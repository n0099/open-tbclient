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
    private LinearLayout eNO;
    private ClickableHeaderImageView eNP;
    private TextView eNQ;
    private TextView eNR;
    private TextView eNS;
    private TextView eNT;
    private TextView eNU;
    private LinearLayout eNV;
    private TextView eNW;
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
        this.eNO = (LinearLayout) findViewById(e.g.msg_photolive_card);
        this.eNP = (ClickableHeaderImageView) findViewById(e.g.author_portrait);
        this.eNQ = (TextView) findViewById(e.g.author_name);
        this.eNR = (TextView) findViewById(e.g.call_time);
        this.eNS = (TextView) findViewById(e.g.call_content);
        this.eNT = (TextView) findViewById(e.g.call_thread_title);
        this.eNV = (LinearLayout) findViewById(e.g.auhtor_name_and_call_time);
        this.eNU = (TextView) findViewById(e.g.remind_title);
        this.eNW = (TextView) findViewById(e.g.card_bottom_chakanzhibo);
        this.eNO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.vS(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.vS(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.pS(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS(int i) {
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
            a.C0244a pB = a.pB(chatMessage.getContent());
            if (pB == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = pB.threadId;
            this.postId = pB.postId;
            this.messageType = pB.msgType;
            int i3 = pB.eOa;
            ViewGroup.LayoutParams layoutParams = this.eNV.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = pB.threadTitle;
                    i = e.j.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(pB.threadTitle);
                    i = e.j.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.eNT.setText(str);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds72);
                this.eNV.setPadding(this.paddingLeft, 0, 0, 0);
                this.eNP.setVisibility(0);
                this.eNP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.bi(view2);
                    }
                });
                this.eNP.setTag(pB.userId);
                this.eNP.setGodIconMargin(i2);
                this.eNU.setVisibility(8);
                this.eNQ.setVisibility(0);
                this.eNQ.setText(pB.userName);
                this.eNS.setText(pB.eNZ);
                this.eNQ.setTextSize(0, l.h(TbadkCoreApplication.getInst(), e.C0210e.fontsize28));
                this.eNW.setText(i);
            } else if (this.messageType == 3) {
                this.eNT.setText(pB.threadTitle);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds80);
                this.eNV.setPadding(0, 0, 0, 0);
                this.eNP.setVisibility(8);
                this.eNU.setVisibility(0);
                this.eNQ.setVisibility(8);
                this.eNU.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.fans_urge_tips));
                if (pB.eNZ != null && pB.eNZ.indexOf(String.valueOf(i3)) != -1) {
                    this.eNS.setText(am(pB.eNZ, i3));
                } else {
                    this.eNS.setText(pB.eNZ);
                }
            } else {
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds80);
                this.eNV.setPadding(0, 0, 0, 0);
                this.eNP.setVisibility(8);
                this.eNU.setVisibility(0);
                this.eNQ.setVisibility(8);
                this.eNS.setText(pB.eNZ);
                if (this.messageType == 4) {
                    this.eNT.setText(pB.threadTitle);
                    this.eNU.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.eNT.setText(pB.threadTitle);
                    this.eNW.setText(e.j.look_normal_thread);
                    this.eNU.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(pB.portrait)) {
                this.eNP.startLoad(pB.portrait, 12, false);
            } else {
                this.eNP.startLoad(null, 12, false);
            }
            this.eNR.setText(ao.M(pB.eNY));
        }
    }

    private SpannableStringBuilder am(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int pT = pT(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)), indexOf, pT + indexOf, 33);
        return spannableStringBuilder;
    }

    private int pT(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
