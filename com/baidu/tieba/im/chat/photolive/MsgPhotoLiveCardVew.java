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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.chat.photolive.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.tbadkCore.util.c;
import java.net.URLDecoder;
/* loaded from: classes26.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout jTK;
    private ClickableHeaderImageView jTL;
    private TextView jTM;
    private TextView jTN;
    private TextView jTO;
    private TextView jTP;
    private TextView jTQ;
    private LinearLayout jTR;
    private TextView jTS;
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
        this.jTK = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.jTL = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.jTM = (TextView) findViewById(R.id.author_name);
        this.jTN = (TextView) findViewById(R.id.call_time);
        this.jTO = (TextView) findViewById(R.id.call_content);
        this.jTP = (TextView) findViewById(R.id.call_thread_title);
        this.jTR = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.jTQ = (TextView) findViewById(R.id.remind_title);
        this.jTS = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.jTK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.SI(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.SI(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.Cr(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cr(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cP(View view) {
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
            a.C0742a LQ = a.LQ(chatMessage.getContent());
            if (LQ == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = LQ.threadId;
            this.postId = LQ.postId;
            this.messageType = LQ.msgType;
            int i3 = LQ.jTW;
            ViewGroup.LayoutParams layoutParams = this.jTR.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = LQ.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(LQ.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.jTP.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.jTR.setPadding(this.paddingLeft, 0, 0, 0);
                this.jTL.setVisibility(0);
                this.jTL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.cP(view2);
                    }
                });
                this.jTL.setTag(LQ.userId);
                this.jTL.setGodIconMargin(i2);
                this.jTQ.setVisibility(8);
                this.jTM.setVisibility(0);
                this.jTM.setText(LQ.userName);
                this.jTO.setText(LQ.jTV);
                this.jTM.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.jTS.setText(i);
            } else if (this.messageType == 3) {
                this.jTP.setText(LQ.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.jTR.setPadding(0, 0, 0, 0);
                this.jTL.setVisibility(8);
                this.jTQ.setVisibility(0);
                this.jTM.setVisibility(8);
                this.jTQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (LQ.jTV != null && LQ.jTV.indexOf(String.valueOf(i3)) != -1) {
                    this.jTO.setText(aX(LQ.jTV, i3));
                } else {
                    this.jTO.setText(LQ.jTV);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.jTR.setPadding(0, 0, 0, 0);
                this.jTL.setVisibility(8);
                this.jTQ.setVisibility(0);
                this.jTM.setVisibility(8);
                this.jTO.setText(LQ.jTV);
                if (this.messageType == 4) {
                    this.jTP.setText(LQ.threadTitle);
                    this.jTQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.jTP.setText(LQ.threadTitle);
                    this.jTS.setText(R.string.look_normal_thread);
                    this.jTQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(LQ.portrait)) {
                this.jTL.startLoad(LQ.portrait, 12, false);
            } else {
                this.jTL.startLoad(null, 12, false);
            }
            this.jTN.setText(at.getFormatTime(LQ.jTU));
        }
    }

    private SpannableStringBuilder aX(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int Cs = Cs(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)), indexOf, Cs + indexOf, 33);
        return spannableStringBuilder;
    }

    private int Cs(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
