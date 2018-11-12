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
    private LinearLayout eEi;
    private ClickableHeaderImageView eEj;
    private TextView eEk;
    private TextView eEl;
    private TextView eEm;
    private TextView eEn;
    private TextView eEo;
    private LinearLayout eEp;
    private TextView eEq;
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
        this.paddingLeft = l.h(tbPageContext.getContext(), e.C0200e.ds24);
        init();
    }

    private void init() {
        this.eEi = (LinearLayout) findViewById(e.g.msg_photolive_card);
        this.eEj = (ClickableHeaderImageView) findViewById(e.g.author_portrait);
        this.eEk = (TextView) findViewById(e.g.author_name);
        this.eEl = (TextView) findViewById(e.g.call_time);
        this.eEm = (TextView) findViewById(e.g.call_content);
        this.eEn = (TextView) findViewById(e.g.call_thread_title);
        this.eEp = (LinearLayout) findViewById(e.g.auhtor_name_and_call_time);
        this.eEo = (TextView) findViewById(e.g.remind_title);
        this.eEq = (TextView) findViewById(e.g.card_bottom_chakanzhibo);
        this.eEi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.vo(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.vo(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.pk(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pk(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(View view) {
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
            a.C0233a oW = a.oW(chatMessage.getContent());
            if (oW == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = oW.threadId;
            this.postId = oW.postId;
            this.messageType = oW.msgType;
            int i3 = oW.eEu;
            ViewGroup.LayoutParams layoutParams = this.eEp.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = oW.threadTitle;
                    i = e.j.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(oW.threadTitle);
                    i = e.j.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.eEn.setText(str);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0200e.ds72);
                this.eEp.setPadding(this.paddingLeft, 0, 0, 0);
                this.eEj.setVisibility(0);
                this.eEj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.bf(view2);
                    }
                });
                this.eEj.setTag(oW.userId);
                this.eEj.setGodIconMargin(i2);
                this.eEo.setVisibility(8);
                this.eEk.setVisibility(0);
                this.eEk.setText(oW.userName);
                this.eEm.setText(oW.eEt);
                this.eEk.setTextSize(0, l.h(TbadkCoreApplication.getInst(), e.C0200e.fontsize28));
                this.eEq.setText(i);
            } else if (this.messageType == 3) {
                this.eEn.setText(oW.threadTitle);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0200e.ds80);
                this.eEp.setPadding(0, 0, 0, 0);
                this.eEj.setVisibility(8);
                this.eEo.setVisibility(0);
                this.eEk.setVisibility(8);
                this.eEo.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.fans_urge_tips));
                if (oW.eEt != null && oW.eEt.indexOf(String.valueOf(i3)) != -1) {
                    this.eEm.setText(ak(oW.eEt, i3));
                } else {
                    this.eEm.setText(oW.eEt);
                }
            } else {
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0200e.ds80);
                this.eEp.setPadding(0, 0, 0, 0);
                this.eEj.setVisibility(8);
                this.eEo.setVisibility(0);
                this.eEk.setVisibility(8);
                this.eEm.setText(oW.eEt);
                if (this.messageType == 4) {
                    this.eEn.setText(oW.threadTitle);
                    this.eEo.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.eEn.setText(oW.threadTitle);
                    this.eEq.setText(e.j.look_normal_thread);
                    this.eEo.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(oW.portrait)) {
                this.eEj.startLoad(oW.portrait, 12, false);
            } else {
                this.eEj.startLoad(null, 12, false);
            }
            this.eEl.setText(ao.E(oW.eEs));
        }
    }

    private SpannableStringBuilder ak(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int pl = pl(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)), indexOf, pl + indexOf, 33);
        return spannableStringBuilder;
    }

    private int pl(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
