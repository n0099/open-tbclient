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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.chat.photolive.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.tbadkCore.util.c;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout geF;
    private ClickableHeaderImageView geG;
    private TextView geH;
    private TextView geI;
    private TextView geJ;
    private TextView geK;
    private TextView geL;
    private LinearLayout geM;
    private TextView geN;
    private int messageType;
    private int paddingLeft;
    private long postId;
    private long threadId;

    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_photolive_card_view);
        this.threadId = 0L;
        this.postId = 0L;
        this.messageType = 0;
        this.paddingLeft = 0;
        this.paddingLeft = l.h(tbPageContext.getContext(), d.e.ds24);
        init();
    }

    private void init() {
        this.geF = (LinearLayout) findViewById(d.g.msg_photolive_card);
        this.geG = (ClickableHeaderImageView) findViewById(d.g.author_portrait);
        this.geH = (TextView) findViewById(d.g.author_name);
        this.geI = (TextView) findViewById(d.g.call_time);
        this.geJ = (TextView) findViewById(d.g.call_content);
        this.geK = (TextView) findViewById(d.g.call_thread_title);
        this.geM = (LinearLayout) findViewById(d.g.auhtor_name_and_call_time);
        this.geL = (TextView) findViewById(d.g.remind_title);
        this.geN = (TextView) findViewById(d.g.card_bottom_chakanzhibo);
        this.geF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.CL(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.CL(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.tD(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tD(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(View view) {
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
            a.C0312a wv = a.wv(chatMessage.getContent());
            if (wv == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = wv.threadId;
            this.postId = wv.postId;
            this.messageType = wv.msgType;
            int i3 = wv.geR;
            ViewGroup.LayoutParams layoutParams = this.geM.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = wv.threadTitle;
                    i = d.j.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(wv.threadTitle);
                    i = d.j.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.geK.setText(str);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), d.e.ds72);
                this.geM.setPadding(this.paddingLeft, 0, 0, 0);
                this.geG.setVisibility(0);
                this.geG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.bX(view2);
                    }
                });
                this.geG.setTag(wv.userId);
                this.geG.setGodIconMargin(i2);
                this.geL.setVisibility(8);
                this.geH.setVisibility(0);
                this.geH.setText(wv.userName);
                this.geJ.setText(wv.geQ);
                this.geH.setTextSize(0, l.h(TbadkCoreApplication.getInst(), d.e.fontsize28));
                this.geN.setText(i);
            } else if (this.messageType == 3) {
                this.geK.setText(wv.threadTitle);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), d.e.ds80);
                this.geM.setPadding(0, 0, 0, 0);
                this.geG.setVisibility(8);
                this.geL.setVisibility(0);
                this.geH.setVisibility(8);
                this.geL.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.fans_urge_tips));
                if (wv.geQ != null && wv.geQ.indexOf(String.valueOf(i3)) != -1) {
                    this.geJ.setText(aH(wv.geQ, i3));
                } else {
                    this.geJ.setText(wv.geQ);
                }
            } else {
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), d.e.ds80);
                this.geM.setPadding(0, 0, 0, 0);
                this.geG.setVisibility(8);
                this.geL.setVisibility(0);
                this.geH.setVisibility(8);
                this.geJ.setText(wv.geQ);
                if (this.messageType == 4) {
                    this.geK.setText(wv.threadTitle);
                    this.geL.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.geK.setText(wv.threadTitle);
                    this.geN.setText(d.j.look_normal_thread);
                    this.geL.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(wv.portrait)) {
                this.geG.startLoad(wv.portrait, 12, false);
            } else {
                this.geG.startLoad(null, 12, false);
            }
            this.geI.setText(ap.ao(wv.geP));
        }
    }

    private SpannableStringBuilder aH(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int tE = tE(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_d)), indexOf, tE + indexOf, 33);
        return spannableStringBuilder;
    }

    private int tE(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
