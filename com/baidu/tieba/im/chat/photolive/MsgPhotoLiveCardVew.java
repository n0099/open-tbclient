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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
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
    private LinearLayout dUM;
    private ClickableHeaderImageView dUN;
    private TextView dUO;
    private TextView dUP;
    private TextView dUQ;
    private TextView dUR;
    private TextView dUS;
    private LinearLayout dUT;
    private TextView dUU;
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
        this.dUM = (LinearLayout) findViewById(d.g.msg_photolive_card);
        this.dUN = (ClickableHeaderImageView) findViewById(d.g.author_portrait);
        this.dUO = (TextView) findViewById(d.g.author_name);
        this.dUP = (TextView) findViewById(d.g.call_time);
        this.dUQ = (TextView) findViewById(d.g.call_content);
        this.dUR = (TextView) findViewById(d.g.call_thread_title);
        this.dUT = (LinearLayout) findViewById(d.g.auhtor_name_and_call_time);
        this.dUS = (TextView) findViewById(d.g.remind_title);
        this.dUU = (TextView) findViewById(d.g.card_bottom_chakanzhibo);
        this.dUM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.te(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.te(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.nj(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(View view2) {
        Object tag = view2.getTag();
        if (tag instanceof String) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
        }
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view2) {
        int i;
        String str;
        int i2 = -1;
        if (chatMessage != null) {
            a.C0154a mV = a.mV(chatMessage.getContent());
            if (mV == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = mV.threadId;
            this.postId = mV.postId;
            this.messageType = mV.msgType;
            int i3 = mV.dUY;
            ViewGroup.LayoutParams layoutParams = this.dUT.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = mV.threadTitle;
                    i = d.k.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(mV.threadTitle);
                    i = d.k.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.dUR.setText(str);
                layoutParams.height = l.e(TbadkCoreApplication.getInst(), d.e.ds72);
                this.dUT.setPadding(this.paddingLeft, 0, 0, 0);
                this.dUN.setVisibility(0);
                this.dUN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        MsgPhotoLiveCardVew.this.aI(view3);
                    }
                });
                this.dUN.setTag(mV.userId);
                this.dUN.setGodIconMargin(i2);
                this.dUS.setVisibility(8);
                this.dUO.setVisibility(0);
                this.dUO.setText(mV.userName);
                this.dUQ.setText(mV.dUX);
                this.dUO.setTextSize(0, l.e(TbadkCoreApplication.getInst(), d.e.fontsize28));
                this.dUU.setText(i);
            } else if (this.messageType == 3) {
                this.dUR.setText(mV.threadTitle);
                layoutParams.height = l.e(TbadkCoreApplication.getInst(), d.e.ds80);
                this.dUT.setPadding(0, 0, 0, 0);
                this.dUN.setVisibility(8);
                this.dUS.setVisibility(0);
                this.dUO.setVisibility(8);
                this.dUS.setText(TbadkCoreApplication.getInst().getResources().getString(d.k.fans_urge_tips));
                if (mV.dUX != null && mV.dUX.indexOf(String.valueOf(i3)) != -1) {
                    this.dUQ.setText(ad(mV.dUX, i3));
                } else {
                    this.dUQ.setText(mV.dUX);
                }
            } else {
                layoutParams.height = l.e(TbadkCoreApplication.getInst(), d.e.ds80);
                this.dUT.setPadding(0, 0, 0, 0);
                this.dUN.setVisibility(8);
                this.dUS.setVisibility(0);
                this.dUO.setVisibility(8);
                this.dUQ.setText(mV.dUX);
                if (this.messageType == 4) {
                    this.dUR.setText(mV.threadTitle);
                    this.dUS.setText(TbadkCoreApplication.getInst().getResources().getString(d.k.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.dUR.setText(mV.threadTitle);
                    this.dUU.setText(d.k.look_normal_thread);
                    this.dUS.setText(TbadkCoreApplication.getInst().getResources().getString(d.k.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(mV.portrait)) {
                this.dUN.startLoad(mV.portrait, 12, false);
            } else {
                this.dUN.startLoad(null, 12, false);
            }
            this.dUP.setText(an.s(mV.dUW));
        }
    }

    private SpannableStringBuilder ad(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int nk = nk(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_d)), indexOf, nk + indexOf, 33);
        return spannableStringBuilder;
    }

    private int nk(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
