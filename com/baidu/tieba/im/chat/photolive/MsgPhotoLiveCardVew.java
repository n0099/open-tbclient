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
import com.baidu.tieba.f;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.chat.photolive.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.tbadkCore.util.c;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout enG;
    private ClickableHeaderImageView enH;
    private TextView enI;
    private TextView enJ;
    private TextView enK;
    private TextView enL;
    private TextView enM;
    private LinearLayout enN;
    private TextView enO;
    private int messageType;
    private int paddingLeft;
    private long postId;
    private long threadId;

    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, f.h.msg_photolive_card_view);
        this.threadId = 0L;
        this.postId = 0L;
        this.messageType = 0;
        this.paddingLeft = 0;
        this.paddingLeft = l.f(tbPageContext.getContext(), f.e.ds24);
        init();
    }

    private void init() {
        this.enG = (LinearLayout) findViewById(f.g.msg_photolive_card);
        this.enH = (ClickableHeaderImageView) findViewById(f.g.author_portrait);
        this.enI = (TextView) findViewById(f.g.author_name);
        this.enJ = (TextView) findViewById(f.g.call_time);
        this.enK = (TextView) findViewById(f.g.call_content);
        this.enL = (TextView) findViewById(f.g.call_thread_title);
        this.enN = (LinearLayout) findViewById(f.g.auhtor_name_and_call_time);
        this.enM = (TextView) findViewById(f.g.remind_title);
        this.enO = (TextView) findViewById(f.g.card_bottom_chakanzhibo);
        this.enG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.ua(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.ua(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
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
            a.C0171a nM = a.nM(chatMessage.getContent());
            if (nM == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = nM.threadId;
            this.postId = nM.postId;
            this.messageType = nM.msgType;
            int i3 = nM.enS;
            ViewGroup.LayoutParams layoutParams = this.enN.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = nM.threadTitle;
                    i = f.j.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(nM.threadTitle);
                    i = f.j.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.enL.setText(str);
                layoutParams.height = l.f(TbadkCoreApplication.getInst(), f.e.ds72);
                this.enN.setPadding(this.paddingLeft, 0, 0, 0);
                this.enH.setVisibility(0);
                this.enH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.aP(view2);
                    }
                });
                this.enH.setTag(nM.userId);
                this.enH.setGodIconMargin(i2);
                this.enM.setVisibility(8);
                this.enI.setVisibility(0);
                this.enI.setText(nM.userName);
                this.enK.setText(nM.enR);
                this.enI.setTextSize(0, l.f(TbadkCoreApplication.getInst(), f.e.fontsize28));
                this.enO.setText(i);
            } else if (this.messageType == 3) {
                this.enL.setText(nM.threadTitle);
                layoutParams.height = l.f(TbadkCoreApplication.getInst(), f.e.ds80);
                this.enN.setPadding(0, 0, 0, 0);
                this.enH.setVisibility(8);
                this.enM.setVisibility(0);
                this.enI.setVisibility(8);
                this.enM.setText(TbadkCoreApplication.getInst().getResources().getString(f.j.fans_urge_tips));
                if (nM.enR != null && nM.enR.indexOf(String.valueOf(i3)) != -1) {
                    this.enK.setText(ab(nM.enR, i3));
                } else {
                    this.enK.setText(nM.enR);
                }
            } else {
                layoutParams.height = l.f(TbadkCoreApplication.getInst(), f.e.ds80);
                this.enN.setPadding(0, 0, 0, 0);
                this.enH.setVisibility(8);
                this.enM.setVisibility(0);
                this.enI.setVisibility(8);
                this.enK.setText(nM.enR);
                if (this.messageType == 4) {
                    this.enL.setText(nM.threadTitle);
                    this.enM.setText(TbadkCoreApplication.getInst().getResources().getString(f.j.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.enL.setText(nM.threadTitle);
                    this.enO.setText(f.j.look_normal_thread);
                    this.enM.setText(TbadkCoreApplication.getInst().getResources().getString(f.j.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(nM.portrait)) {
                this.enH.startLoad(nM.portrait, 12, false);
            } else {
                this.enH.startLoad(null, 12, false);
            }
            this.enJ.setText(ap.w(nM.enQ));
        }
    }

    private SpannableStringBuilder ab(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int nR = nR(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(f.d.cp_link_tip_d)), indexOf, nR + indexOf, 33);
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
