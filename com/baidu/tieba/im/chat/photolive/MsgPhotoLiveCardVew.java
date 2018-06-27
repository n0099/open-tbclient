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
import com.baidu.tbadk.core.util.am;
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
    private LinearLayout ejS;
    private ClickableHeaderImageView ejT;
    private TextView ejU;
    private TextView ejV;
    private TextView ejW;
    private TextView ejX;
    private TextView ejY;
    private LinearLayout ejZ;
    private TextView eka;
    private int messageType;
    private int paddingLeft;
    private long postId;
    private long threadId;

    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_photolive_card_view);
        this.threadId = 0L;
        this.postId = 0L;
        this.messageType = 0;
        this.paddingLeft = 0;
        this.paddingLeft = l.e(tbPageContext.getContext(), d.e.ds24);
        init();
    }

    private void init() {
        this.ejS = (LinearLayout) findViewById(d.g.msg_photolive_card);
        this.ejT = (ClickableHeaderImageView) findViewById(d.g.author_portrait);
        this.ejU = (TextView) findViewById(d.g.author_name);
        this.ejV = (TextView) findViewById(d.g.call_time);
        this.ejW = (TextView) findViewById(d.g.call_content);
        this.ejX = (TextView) findViewById(d.g.call_thread_title);
        this.ejZ = (LinearLayout) findViewById(d.g.auhtor_name_and_call_time);
        this.ejY = (TextView) findViewById(d.g.remind_title);
        this.eka = (TextView) findViewById(d.g.card_bottom_chakanzhibo);
        this.ejS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.tY(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.tY(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.nC(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nC(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(View view) {
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
            a.C0172a nI = a.nI(chatMessage.getContent());
            if (nI == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = nI.threadId;
            this.postId = nI.postId;
            this.messageType = nI.msgType;
            int i3 = nI.eke;
            ViewGroup.LayoutParams layoutParams = this.ejZ.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = nI.threadTitle;
                    i = d.k.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(nI.threadTitle);
                    i = d.k.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.ejX.setText(str);
                layoutParams.height = l.e(TbadkCoreApplication.getInst(), d.e.ds72);
                this.ejZ.setPadding(this.paddingLeft, 0, 0, 0);
                this.ejT.setVisibility(0);
                this.ejT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.aM(view2);
                    }
                });
                this.ejT.setTag(nI.userId);
                this.ejT.setGodIconMargin(i2);
                this.ejY.setVisibility(8);
                this.ejU.setVisibility(0);
                this.ejU.setText(nI.userName);
                this.ejW.setText(nI.ekd);
                this.ejU.setTextSize(0, l.e(TbadkCoreApplication.getInst(), d.e.fontsize28));
                this.eka.setText(i);
            } else if (this.messageType == 3) {
                this.ejX.setText(nI.threadTitle);
                layoutParams.height = l.e(TbadkCoreApplication.getInst(), d.e.ds80);
                this.ejZ.setPadding(0, 0, 0, 0);
                this.ejT.setVisibility(8);
                this.ejY.setVisibility(0);
                this.ejU.setVisibility(8);
                this.ejY.setText(TbadkCoreApplication.getInst().getResources().getString(d.k.fans_urge_tips));
                if (nI.ekd != null && nI.ekd.indexOf(String.valueOf(i3)) != -1) {
                    this.ejW.setText(af(nI.ekd, i3));
                } else {
                    this.ejW.setText(nI.ekd);
                }
            } else {
                layoutParams.height = l.e(TbadkCoreApplication.getInst(), d.e.ds80);
                this.ejZ.setPadding(0, 0, 0, 0);
                this.ejT.setVisibility(8);
                this.ejY.setVisibility(0);
                this.ejU.setVisibility(8);
                this.ejW.setText(nI.ekd);
                if (this.messageType == 4) {
                    this.ejX.setText(nI.threadTitle);
                    this.ejY.setText(TbadkCoreApplication.getInst().getResources().getString(d.k.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.ejX.setText(nI.threadTitle);
                    this.eka.setText(d.k.look_normal_thread);
                    this.ejY.setText(TbadkCoreApplication.getInst().getResources().getString(d.k.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(nI.portrait)) {
                this.ejT.startLoad(nI.portrait, 12, false);
            } else {
                this.ejT.startLoad(null, 12, false);
            }
            this.ejV.setText(ap.w(nI.ekc));
        }
    }

    private SpannableStringBuilder af(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int nD = nD(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0142d.cp_link_tip_d)), indexOf, nD + indexOf, 33);
        return spannableStringBuilder;
    }

    private int nD(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
