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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.chat.photolive.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.tbadkCore.util.c;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout gBL;
    private ClickableHeaderImageView gBM;
    private TextView gBN;
    private TextView gBO;
    private TextView gBP;
    private TextView gBQ;
    private TextView gBR;
    private LinearLayout gBS;
    private TextView gBT;
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
        this.gBL = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.gBM = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.gBN = (TextView) findViewById(R.id.author_name);
        this.gBO = (TextView) findViewById(R.id.call_time);
        this.gBP = (TextView) findViewById(R.id.call_content);
        this.gBQ = (TextView) findViewById(R.id.call_thread_title);
        this.gBS = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.gBR = (TextView) findViewById(R.id.remind_title);
        this.gBT = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.gBL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.Ea(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.Ea(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.tR(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tR(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cf(View view) {
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
            a.C0434a xo = a.xo(chatMessage.getContent());
            if (xo == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = xo.threadId;
            this.postId = xo.postId;
            this.messageType = xo.msgType;
            int i3 = xo.gBX;
            ViewGroup.LayoutParams layoutParams = this.gBS.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = xo.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(xo.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.gBQ.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.gBS.setPadding(this.paddingLeft, 0, 0, 0);
                this.gBM.setVisibility(0);
                this.gBM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.cf(view2);
                    }
                });
                this.gBM.setTag(xo.userId);
                this.gBM.setGodIconMargin(i2);
                this.gBR.setVisibility(8);
                this.gBN.setVisibility(0);
                this.gBN.setText(xo.userName);
                this.gBP.setText(xo.gBW);
                this.gBN.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.gBT.setText(i);
            } else if (this.messageType == 3) {
                this.gBQ.setText(xo.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.gBS.setPadding(0, 0, 0, 0);
                this.gBM.setVisibility(8);
                this.gBR.setVisibility(0);
                this.gBN.setVisibility(8);
                this.gBR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (xo.gBW != null && xo.gBW.indexOf(String.valueOf(i3)) != -1) {
                    this.gBP.setText(aB(xo.gBW, i3));
                } else {
                    this.gBP.setText(xo.gBW);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.gBS.setPadding(0, 0, 0, 0);
                this.gBM.setVisibility(8);
                this.gBR.setVisibility(0);
                this.gBN.setVisibility(8);
                this.gBP.setText(xo.gBW);
                if (this.messageType == 4) {
                    this.gBQ.setText(xo.threadTitle);
                    this.gBR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.gBQ.setText(xo.threadTitle);
                    this.gBT.setText(R.string.look_normal_thread);
                    this.gBR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(xo.portrait)) {
                this.gBM.startLoad(xo.portrait, 12, false);
            } else {
                this.gBM.startLoad(null, 12, false);
            }
            this.gBO.setText(aq.getFormatTime(xo.gBV));
        }
    }

    private SpannableStringBuilder aB(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int tS = tS(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)), indexOf, tS + indexOf, 33);
        return spannableStringBuilder;
    }

    private int tS(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
