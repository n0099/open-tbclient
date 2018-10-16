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
    private LinearLayout eCO;
    private ClickableHeaderImageView eCP;
    private TextView eCQ;
    private TextView eCR;
    private TextView eCS;
    private TextView eCT;
    private TextView eCU;
    private LinearLayout eCV;
    private TextView eCW;
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
        this.paddingLeft = l.h(tbPageContext.getContext(), e.C0175e.ds24);
        init();
    }

    private void init() {
        this.eCO = (LinearLayout) findViewById(e.g.msg_photolive_card);
        this.eCP = (ClickableHeaderImageView) findViewById(e.g.author_portrait);
        this.eCQ = (TextView) findViewById(e.g.author_name);
        this.eCR = (TextView) findViewById(e.g.call_time);
        this.eCS = (TextView) findViewById(e.g.call_content);
        this.eCT = (TextView) findViewById(e.g.call_thread_title);
        this.eCV = (LinearLayout) findViewById(e.g.auhtor_name_and_call_time);
        this.eCU = (TextView) findViewById(e.g.remind_title);
        this.eCW = (TextView) findViewById(e.g.card_bottom_chakanzhibo);
        this.eCO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.vj(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.vj(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.oS(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oS(int i) {
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
            a.C0207a oV = a.oV(chatMessage.getContent());
            if (oV == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = oV.threadId;
            this.postId = oV.postId;
            this.messageType = oV.msgType;
            int i3 = oV.eDa;
            ViewGroup.LayoutParams layoutParams = this.eCV.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = oV.threadTitle;
                    i = e.j.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(oV.threadTitle);
                    i = e.j.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.eCT.setText(str);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds72);
                this.eCV.setPadding(this.paddingLeft, 0, 0, 0);
                this.eCP.setVisibility(0);
                this.eCP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.bd(view2);
                    }
                });
                this.eCP.setTag(oV.userId);
                this.eCP.setGodIconMargin(i2);
                this.eCU.setVisibility(8);
                this.eCQ.setVisibility(0);
                this.eCQ.setText(oV.userName);
                this.eCS.setText(oV.eCZ);
                this.eCQ.setTextSize(0, l.h(TbadkCoreApplication.getInst(), e.C0175e.fontsize28));
                this.eCW.setText(i);
            } else if (this.messageType == 3) {
                this.eCT.setText(oV.threadTitle);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds80);
                this.eCV.setPadding(0, 0, 0, 0);
                this.eCP.setVisibility(8);
                this.eCU.setVisibility(0);
                this.eCQ.setVisibility(8);
                this.eCU.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.fans_urge_tips));
                if (oV.eCZ != null && oV.eCZ.indexOf(String.valueOf(i3)) != -1) {
                    this.eCS.setText(ak(oV.eCZ, i3));
                } else {
                    this.eCS.setText(oV.eCZ);
                }
            } else {
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds80);
                this.eCV.setPadding(0, 0, 0, 0);
                this.eCP.setVisibility(8);
                this.eCU.setVisibility(0);
                this.eCQ.setVisibility(8);
                this.eCS.setText(oV.eCZ);
                if (this.messageType == 4) {
                    this.eCT.setText(oV.threadTitle);
                    this.eCU.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.eCT.setText(oV.threadTitle);
                    this.eCW.setText(e.j.look_normal_thread);
                    this.eCU.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(oV.portrait)) {
                this.eCP.startLoad(oV.portrait, 12, false);
            } else {
                this.eCP.startLoad(null, 12, false);
            }
            this.eCR.setText(ao.C(oV.eCY));
        }
    }

    private SpannableStringBuilder ak(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int oT = oT(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)), indexOf, oT + indexOf, 33);
        return spannableStringBuilder;
    }

    private int oT(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
