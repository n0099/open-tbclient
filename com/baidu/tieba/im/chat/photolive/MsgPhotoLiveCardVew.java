package com.baidu.tieba.im.chat.photolive;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.chat.photolive.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.tbadkCore.util.c;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout eOB;
    private ClickableHeaderImageView eOC;
    private TextView eOD;
    private TextView eOE;
    private TextView eOF;
    private TextView eOG;
    private TextView eOH;
    private LinearLayout eOI;
    private TextView eOJ;
    private int messageType;
    private int paddingLeft;
    private long postId;
    private long threadId;

    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_photolive_card_view);
        this.threadId = 0L;
        this.postId = 0L;
        this.messageType = 0;
        this.paddingLeft = 0;
        this.paddingLeft = l.h(tbPageContext.getContext(), e.C0210e.ds24);
        init();
    }

    private void init() {
        this.eOB = (LinearLayout) findViewById(e.g.msg_photolive_card);
        this.eOC = (ClickableHeaderImageView) findViewById(e.g.author_portrait);
        this.eOD = (TextView) findViewById(e.g.author_name);
        this.eOE = (TextView) findViewById(e.g.call_time);
        this.eOF = (TextView) findViewById(e.g.call_content);
        this.eOG = (TextView) findViewById(e.g.call_thread_title);
        this.eOI = (LinearLayout) findViewById(e.g.auhtor_name_and_call_time);
        this.eOH = (TextView) findViewById(e.g.remind_title);
        this.eOJ = (TextView) findViewById(e.g.card_bottom_chakanzhibo);
        this.eOB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MsgPhotoLiveCardVew.this.threadId > 0) {
                    c photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
                    if (MsgPhotoLiveCardVew.this.messageType != 1) {
                        if (MsgPhotoLiveCardVew.this.messageType != 3) {
                            if (MsgPhotoLiveCardVew.this.messageType != 4) {
                                if (MsgPhotoLiveCardVew.this.messageType == 5) {
                                    TiebaStatic.log("c10492");
                                }
                            } else {
                                TiebaStatic.log("c10500");
                            }
                        } else {
                            TiebaStatic.log("c10390");
                        }
                    } else {
                        TiebaStatic.log("c10195");
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.wi(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.wi(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.pT(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pT(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
        }
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        int i;
        String str;
        int i2 = -1;
        if (chatMessage != null) {
            a.C0244a pR = a.pR(chatMessage.getContent());
            if (pR == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = pR.threadId;
            this.postId = pR.postId;
            this.messageType = pR.msgType;
            int i3 = pR.eON;
            ViewGroup.LayoutParams layoutParams = this.eOI.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = pR.threadTitle;
                    i = e.j.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(pR.threadTitle);
                    i = e.j.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.eOG.setText(str);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds72);
                this.eOI.setPadding(this.paddingLeft, 0, 0, 0);
                this.eOC.setVisibility(0);
                this.eOC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.bi(view2);
                    }
                });
                this.eOC.setTag(pR.userId);
                this.eOC.setGodIconMargin(i2);
                this.eOH.setVisibility(8);
                this.eOD.setVisibility(0);
                this.eOD.setText(pR.userName);
                this.eOF.setText(pR.eOM);
                this.eOD.setTextSize(0, l.h(TbadkCoreApplication.getInst(), e.C0210e.fontsize28));
                this.eOJ.setText(i);
            } else if (this.messageType == 3) {
                this.eOG.setText(pR.threadTitle);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds80);
                this.eOI.setPadding(0, 0, 0, 0);
                this.eOC.setVisibility(8);
                this.eOH.setVisibility(0);
                this.eOD.setVisibility(8);
                this.eOH.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.fans_urge_tips));
                if (pR.eOM != null && pR.eOM.indexOf(String.valueOf(i3)) != -1) {
                    this.eOF.setText(am(pR.eOM, i3));
                } else {
                    this.eOF.setText(pR.eOM);
                }
            } else {
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds80);
                this.eOI.setPadding(0, 0, 0, 0);
                this.eOC.setVisibility(8);
                this.eOH.setVisibility(0);
                this.eOD.setVisibility(8);
                this.eOF.setText(pR.eOM);
                if (this.messageType == 4) {
                    this.eOG.setText(pR.threadTitle);
                    this.eOH.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.eOG.setText(pR.threadTitle);
                    this.eOJ.setText(e.j.look_normal_thread);
                    this.eOH.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(pR.portrait)) {
                this.eOC.startLoad(pR.portrait, 12, false);
            } else {
                this.eOC.startLoad(null, 12, false);
            }
            this.eOE.setText(ao.M(pR.eOL));
        }
    }

    private SpannableStringBuilder am(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int pU = pU(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)), indexOf, pU + indexOf, 33);
        return spannableStringBuilder;
    }

    private int pU(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
