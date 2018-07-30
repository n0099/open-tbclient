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
    private LinearLayout enK;
    private ClickableHeaderImageView enL;
    private TextView enM;
    private TextView enN;
    private TextView enO;
    private TextView enP;
    private TextView enQ;
    private LinearLayout enR;
    private TextView enS;
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
        this.paddingLeft = l.f(tbPageContext.getContext(), d.e.ds24);
        init();
    }

    private void init() {
        this.enK = (LinearLayout) findViewById(d.g.msg_photolive_card);
        this.enL = (ClickableHeaderImageView) findViewById(d.g.author_portrait);
        this.enM = (TextView) findViewById(d.g.author_name);
        this.enN = (TextView) findViewById(d.g.call_time);
        this.enO = (TextView) findViewById(d.g.call_content);
        this.enP = (TextView) findViewById(d.g.call_thread_title);
        this.enR = (LinearLayout) findViewById(d.g.auhtor_name_and_call_time);
        this.enQ = (TextView) findViewById(d.g.remind_title);
        this.enS = (TextView) findViewById(d.g.card_bottom_chakanzhibo);
        this.enK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.tW(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.tW(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.nQ(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nQ(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(View view) {
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
            a.C0171a nK = a.nK(chatMessage.getContent());
            if (nK == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = nK.threadId;
            this.postId = nK.postId;
            this.messageType = nK.msgType;
            int i3 = nK.enW;
            ViewGroup.LayoutParams layoutParams = this.enR.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = nK.threadTitle;
                    i = d.j.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(nK.threadTitle);
                    i = d.j.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.enP.setText(str);
                layoutParams.height = l.f(TbadkCoreApplication.getInst(), d.e.ds72);
                this.enR.setPadding(this.paddingLeft, 0, 0, 0);
                this.enL.setVisibility(0);
                this.enL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.aP(view2);
                    }
                });
                this.enL.setTag(nK.userId);
                this.enL.setGodIconMargin(i2);
                this.enQ.setVisibility(8);
                this.enM.setVisibility(0);
                this.enM.setText(nK.userName);
                this.enO.setText(nK.enV);
                this.enM.setTextSize(0, l.f(TbadkCoreApplication.getInst(), d.e.fontsize28));
                this.enS.setText(i);
            } else if (this.messageType == 3) {
                this.enP.setText(nK.threadTitle);
                layoutParams.height = l.f(TbadkCoreApplication.getInst(), d.e.ds80);
                this.enR.setPadding(0, 0, 0, 0);
                this.enL.setVisibility(8);
                this.enQ.setVisibility(0);
                this.enM.setVisibility(8);
                this.enQ.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.fans_urge_tips));
                if (nK.enV != null && nK.enV.indexOf(String.valueOf(i3)) != -1) {
                    this.enO.setText(ab(nK.enV, i3));
                } else {
                    this.enO.setText(nK.enV);
                }
            } else {
                layoutParams.height = l.f(TbadkCoreApplication.getInst(), d.e.ds80);
                this.enR.setPadding(0, 0, 0, 0);
                this.enL.setVisibility(8);
                this.enQ.setVisibility(0);
                this.enM.setVisibility(8);
                this.enO.setText(nK.enV);
                if (this.messageType == 4) {
                    this.enP.setText(nK.threadTitle);
                    this.enQ.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.enP.setText(nK.threadTitle);
                    this.enS.setText(d.j.look_normal_thread);
                    this.enQ.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(nK.portrait)) {
                this.enL.startLoad(nK.portrait, 12, false);
            } else {
                this.enL.startLoad(null, 12, false);
            }
            this.enN.setText(ap.w(nK.enU));
        }
    }

    private SpannableStringBuilder ab(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int nR = nR(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0140d.cp_link_tip_d)), indexOf, nR + indexOf, 33);
        return spannableStringBuilder;
    }

    private int nR(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
