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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.chat.photolive.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.tbadkCore.util.c;
import java.net.URLDecoder;
/* loaded from: classes13.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout iNA;
    private ClickableHeaderImageView iNB;
    private TextView iNC;
    private TextView iND;
    private TextView iNE;
    private TextView iNF;
    private TextView iNG;
    private LinearLayout iNH;
    private TextView iNI;
    private int messageType;
    private int paddingLeft;
    private long postId;
    private long threadId;

    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_photolive_card_view);
        this.threadId = 0L;
        this.postId = 0L;
        this.messageType = 0;
        this.paddingLeft = 0;
        this.paddingLeft = l.getDimens(tbPageContext.getContext(), R.dimen.ds24);
        init();
    }

    private void init() {
        this.iNA = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.iNB = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.iNC = (TextView) findViewById(R.id.author_name);
        this.iND = (TextView) findViewById(R.id.call_time);
        this.iNE = (TextView) findViewById(R.id.call_content);
        this.iNF = (TextView) findViewById(R.id.call_thread_title);
        this.iNH = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.iNG = (TextView) findViewById(R.id.remind_title);
        this.iNI = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.iNA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MsgPhotoLiveCardVew.this.threadId > 0) {
                    c photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
                    if (MsgPhotoLiveCardVew.this.messageType != 1) {
                        if (MsgPhotoLiveCardVew.this.messageType != 3) {
                            if (MsgPhotoLiveCardVew.this.messageType != 4) {
                                if (MsgPhotoLiveCardVew.this.messageType == 5) {
                                    TiebaStatic.log(TbadkCoreStatisticKey.CHANDE_OLD_SUCCESS);
                                }
                            } else {
                                TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_SUCCESS);
                            }
                        } else {
                            TiebaStatic.log(TbadkCoreStatisticKey.FANS_REMIND_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.PHOTO_LIVE_GREATCALL_MSG);
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.Np(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.Np(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.yc(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yc(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
        }
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        int i;
        String str;
        int i2 = -1;
        if (chatMessage != null) {
            a.C0649a Gu = a.Gu(chatMessage.getContent());
            if (Gu == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = Gu.threadId;
            this.postId = Gu.postId;
            this.messageType = Gu.msgType;
            int i3 = Gu.iNM;
            ViewGroup.LayoutParams layoutParams = this.iNH.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = Gu.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(Gu.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.iNF.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.iNH.setPadding(this.paddingLeft, 0, 0, 0);
                this.iNB.setVisibility(0);
                this.iNB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.cp(view2);
                    }
                });
                this.iNB.setTag(Gu.userId);
                this.iNB.setGodIconMargin(i2);
                this.iNG.setVisibility(8);
                this.iNC.setVisibility(0);
                this.iNC.setText(Gu.userName);
                this.iNE.setText(Gu.iNL);
                this.iNC.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.iNI.setText(i);
            } else if (this.messageType == 3) {
                this.iNF.setText(Gu.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.iNH.setPadding(0, 0, 0, 0);
                this.iNB.setVisibility(8);
                this.iNG.setVisibility(0);
                this.iNC.setVisibility(8);
                this.iNG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (Gu.iNL != null && Gu.iNL.indexOf(String.valueOf(i3)) != -1) {
                    this.iNE.setText(aT(Gu.iNL, i3));
                } else {
                    this.iNE.setText(Gu.iNL);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.iNH.setPadding(0, 0, 0, 0);
                this.iNB.setVisibility(8);
                this.iNG.setVisibility(0);
                this.iNC.setVisibility(8);
                this.iNE.setText(Gu.iNL);
                if (this.messageType == 4) {
                    this.iNF.setText(Gu.threadTitle);
                    this.iNG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.iNF.setText(Gu.threadTitle);
                    this.iNI.setText(R.string.look_normal_thread);
                    this.iNG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(Gu.portrait)) {
                this.iNB.startLoad(Gu.portrait, 12, false);
            } else {
                this.iNB.startLoad(null, 12, false);
            }
            this.iND.setText(ar.getFormatTime(Gu.iNK));
        }
    }

    private SpannableStringBuilder aT(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int yd = yd(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(an.getColor(R.color.cp_link_tip_d)), indexOf, yd + indexOf, 33);
        return spannableStringBuilder;
    }

    private int yd(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
