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
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.chat.photolive.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class MsgPhotoLiveCardVew extends g {
    private TextView bnD;
    private LinearLayout eyP;
    private ClickableHeaderImageView eyQ;
    private TextView eyR;
    private TextView eyS;
    private TextView eyT;
    private TextView eyU;
    private LinearLayout eyV;
    private TextView eyW;
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
        this.paddingLeft = l.t(tbPageContext.getContext(), d.e.ds24);
        init();
    }

    private void init() {
        this.eyP = (LinearLayout) findViewById(d.g.msg_photolive_card);
        this.eyQ = (ClickableHeaderImageView) findViewById(d.g.author_portrait);
        this.bnD = (TextView) findViewById(d.g.author_name);
        this.eyR = (TextView) findViewById(d.g.call_time);
        this.eyS = (TextView) findViewById(d.g.call_content);
        this.eyT = (TextView) findViewById(d.g.call_thread_title);
        this.eyV = (LinearLayout) findViewById(d.g.auhtor_name_and_call_time);
        this.eyU = (TextView) findViewById(d.g.remind_title);
        this.eyW = (TextView) findViewById(d.g.card_bottom_chakanzhibo);
        this.eyP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.sU(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.sU(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.pL(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pL(int i) {
        PhotoLiveActivityConfig xD;
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
            return;
        }
        if (this.postId > 0) {
            xD = new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), String.valueOf(this.threadId)).cP(String.valueOf(this.postId)).cR(PhotoLiveActivityConfig.KEY_FROM_MESSAGE).xD();
        } else {
            xD = new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), String.valueOf(this.threadId)).xD();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, xD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
        }
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        int i;
        CharSequence charSequence;
        int i2 = -1;
        if (chatMessage != null) {
            a.C0171a mO = a.mO(chatMessage.getContent());
            if (mO == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = mO.threadId;
            this.postId = mO.postId;
            this.messageType = mO.msgType;
            int i3 = mO.eza;
            ViewGroup.LayoutParams layoutParams = this.eyV.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    charSequence = PhotoLiveCardData.getLiveIconTitle(mO.threadTitle);
                    i = d.j.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(mO.threadTitle);
                    i = d.j.look_god_thread;
                    charSequence = decode;
                    i2 = 0;
                }
                this.eyT.setText(charSequence);
                layoutParams.height = l.t(TbadkCoreApplication.getInst(), d.e.ds72);
                this.eyV.setPadding(this.paddingLeft, 0, 0, 0);
                this.eyQ.setVisibility(0);
                this.eyQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.cc(view2);
                    }
                });
                this.eyQ.setTag(mO.userId);
                this.eyQ.setGodIconMargin(i2);
                this.eyU.setVisibility(8);
                this.bnD.setVisibility(0);
                this.bnD.setText(mO.userName);
                this.eyS.setText(mO.eyZ);
                this.bnD.setTextSize(0, l.t(TbadkCoreApplication.getInst(), d.e.fontsize28));
                this.eyW.setText(i);
            } else if (this.messageType == 3) {
                this.eyT.setText(PhotoLiveCardData.getLiveIconTitle(mO.threadTitle));
                layoutParams.height = l.t(TbadkCoreApplication.getInst(), d.e.ds80);
                this.eyV.setPadding(0, 0, 0, 0);
                this.eyQ.setVisibility(8);
                this.eyU.setVisibility(0);
                this.bnD.setVisibility(8);
                this.eyU.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.fans_urge_tips));
                if (mO.eyZ != null && mO.eyZ.indexOf(String.valueOf(i3)) != -1) {
                    this.eyS.setText(ab(mO.eyZ, i3));
                } else {
                    this.eyS.setText(mO.eyZ);
                }
            } else {
                layoutParams.height = l.t(TbadkCoreApplication.getInst(), d.e.ds80);
                this.eyV.setPadding(0, 0, 0, 0);
                this.eyQ.setVisibility(8);
                this.eyU.setVisibility(0);
                this.bnD.setVisibility(8);
                this.eyS.setText(mO.eyZ);
                if (this.messageType == 4) {
                    this.eyT.setText(PhotoLiveCardData.getLiveIconTitle(mO.threadTitle));
                    this.eyU.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.eyT.setText(mO.threadTitle);
                    this.eyW.setText(d.j.look_normal_thread);
                    this.eyU.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(mO.portrait)) {
                this.eyQ.startLoad(mO.portrait, 12, false);
            } else {
                this.eyQ.startLoad(null, 12, false);
            }
            this.eyR.setText(am.z(mO.eyY));
        }
    }

    private SpannableStringBuilder ab(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int pM = pM(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0141d.cp_link_tip_d)), indexOf, pM + indexOf, 33);
        return spannableStringBuilder;
    }

    private int pM(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
