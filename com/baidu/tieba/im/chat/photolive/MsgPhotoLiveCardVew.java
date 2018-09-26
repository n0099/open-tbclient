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
    private LinearLayout eva;
    private ClickableHeaderImageView evb;
    private TextView evc;
    private TextView evd;
    private TextView eve;
    private TextView evf;
    private TextView evg;
    private LinearLayout evh;
    private TextView evi;
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
        this.paddingLeft = l.h(tbPageContext.getContext(), e.C0141e.ds24);
        init();
    }

    private void init() {
        this.eva = (LinearLayout) findViewById(e.g.msg_photolive_card);
        this.evb = (ClickableHeaderImageView) findViewById(e.g.author_portrait);
        this.evc = (TextView) findViewById(e.g.author_name);
        this.evd = (TextView) findViewById(e.g.call_time);
        this.eve = (TextView) findViewById(e.g.call_content);
        this.evf = (TextView) findViewById(e.g.call_thread_title);
        this.evh = (LinearLayout) findViewById(e.g.auhtor_name_and_call_time);
        this.evg = (TextView) findViewById(e.g.remind_title);
        this.evi = (TextView) findViewById(e.g.card_bottom_chakanzhibo);
        this.eva.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.uH(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.uH(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.ou(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ou(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(View view) {
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
            a.C0173a ot = a.ot(chatMessage.getContent());
            if (ot == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = ot.threadId;
            this.postId = ot.postId;
            this.messageType = ot.msgType;
            int i3 = ot.evm;
            ViewGroup.LayoutParams layoutParams = this.evh.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = ot.threadTitle;
                    i = e.j.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(ot.threadTitle);
                    i = e.j.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.evf.setText(str);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds72);
                this.evh.setPadding(this.paddingLeft, 0, 0, 0);
                this.evb.setVisibility(0);
                this.evb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.bd(view2);
                    }
                });
                this.evb.setTag(ot.userId);
                this.evb.setGodIconMargin(i2);
                this.evg.setVisibility(8);
                this.evc.setVisibility(0);
                this.evc.setText(ot.userName);
                this.eve.setText(ot.evl);
                this.evc.setTextSize(0, l.h(TbadkCoreApplication.getInst(), e.C0141e.fontsize28));
                this.evi.setText(i);
            } else if (this.messageType == 3) {
                this.evf.setText(ot.threadTitle);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds80);
                this.evh.setPadding(0, 0, 0, 0);
                this.evb.setVisibility(8);
                this.evg.setVisibility(0);
                this.evc.setVisibility(8);
                this.evg.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.fans_urge_tips));
                if (ot.evl != null && ot.evl.indexOf(String.valueOf(i3)) != -1) {
                    this.eve.setText(ag(ot.evl, i3));
                } else {
                    this.eve.setText(ot.evl);
                }
            } else {
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds80);
                this.evh.setPadding(0, 0, 0, 0);
                this.evb.setVisibility(8);
                this.evg.setVisibility(0);
                this.evc.setVisibility(8);
                this.eve.setText(ot.evl);
                if (this.messageType == 4) {
                    this.evf.setText(ot.threadTitle);
                    this.evg.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.evf.setText(ot.threadTitle);
                    this.evi.setText(e.j.look_normal_thread);
                    this.evg.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(ot.portrait)) {
                this.evb.startLoad(ot.portrait, 12, false);
            } else {
                this.evb.startLoad(null, 12, false);
            }
            this.evd.setText(ao.A(ot.evk));
        }
    }

    private SpannableStringBuilder ag(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int ov = ov(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)), indexOf, ov + indexOf, 33);
        return spannableStringBuilder;
    }

    private int ov(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
