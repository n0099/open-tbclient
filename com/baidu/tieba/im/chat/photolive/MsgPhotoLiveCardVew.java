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
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout dTI;
    private ClickableHeaderImageView dTJ;
    private TextView dTK;
    private TextView dTL;
    private TextView dTM;
    private TextView dTN;
    private TextView dTO;
    private LinearLayout dTP;
    private TextView dTQ;
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
        this.dTI = (LinearLayout) findViewById(d.g.msg_photolive_card);
        this.dTJ = (ClickableHeaderImageView) findViewById(d.g.author_portrait);
        this.dTK = (TextView) findViewById(d.g.author_name);
        this.dTL = (TextView) findViewById(d.g.call_time);
        this.dTM = (TextView) findViewById(d.g.call_content);
        this.dTN = (TextView) findViewById(d.g.call_thread_title);
        this.dTP = (LinearLayout) findViewById(d.g.auhtor_name_and_call_time);
        this.dTO = (TextView) findViewById(d.g.remind_title);
        this.dTQ = (TextView) findViewById(d.g.card_bottom_chakanzhibo);
        this.dTI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (MsgPhotoLiveCardVew.this.threadId > 0) {
                    com.baidu.tieba.tbadkCore.util.d photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.tb(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.tb(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.nk(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nk(int i) {
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
            a.C0154a mS = a.mS(chatMessage.getContent());
            if (mS == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = mS.threadId;
            this.postId = mS.postId;
            this.messageType = mS.msgType;
            int i3 = mS.dTU;
            ViewGroup.LayoutParams layoutParams = this.dTP.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = mS.threadTitle;
                    i = d.k.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(mS.threadTitle);
                    i = d.k.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.dTN.setText(str);
                layoutParams.height = l.e(TbadkCoreApplication.getInst(), d.e.ds72);
                this.dTP.setPadding(this.paddingLeft, 0, 0, 0);
                this.dTJ.setVisibility(0);
                this.dTJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        MsgPhotoLiveCardVew.this.aI(view3);
                    }
                });
                this.dTJ.setTag(mS.userId);
                this.dTJ.setGodIconMargin(i2);
                this.dTO.setVisibility(8);
                this.dTK.setVisibility(0);
                this.dTK.setText(mS.userName);
                this.dTM.setText(mS.dTT);
                this.dTK.setTextSize(0, l.e(TbadkCoreApplication.getInst(), d.e.fontsize28));
                this.dTQ.setText(i);
            } else if (this.messageType == 3) {
                this.dTN.setText(mS.threadTitle);
                layoutParams.height = l.e(TbadkCoreApplication.getInst(), d.e.ds80);
                this.dTP.setPadding(0, 0, 0, 0);
                this.dTJ.setVisibility(8);
                this.dTO.setVisibility(0);
                this.dTK.setVisibility(8);
                this.dTO.setText(TbadkCoreApplication.getInst().getResources().getString(d.k.fans_urge_tips));
                if (mS.dTT != null && mS.dTT.indexOf(String.valueOf(i3)) != -1) {
                    this.dTM.setText(ad(mS.dTT, i3));
                } else {
                    this.dTM.setText(mS.dTT);
                }
            } else {
                layoutParams.height = l.e(TbadkCoreApplication.getInst(), d.e.ds80);
                this.dTP.setPadding(0, 0, 0, 0);
                this.dTJ.setVisibility(8);
                this.dTO.setVisibility(0);
                this.dTK.setVisibility(8);
                this.dTM.setText(mS.dTT);
                if (this.messageType == 4) {
                    this.dTN.setText(mS.threadTitle);
                    this.dTO.setText(TbadkCoreApplication.getInst().getResources().getString(d.k.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.dTN.setText(mS.threadTitle);
                    this.dTQ.setText(d.k.look_normal_thread);
                    this.dTO.setText(TbadkCoreApplication.getInst().getResources().getString(d.k.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(mS.portrait)) {
                this.dTJ.startLoad(mS.portrait, 12, false);
            } else {
                this.dTJ.startLoad(null, 12, false);
            }
            this.dTL.setText(an.s(mS.dTS));
        }
    }

    private SpannableStringBuilder ad(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int nl = nl(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_d)), indexOf, nl + indexOf, 33);
        return spannableStringBuilder;
    }

    private int nl(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
