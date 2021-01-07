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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.chat.photolive.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.tbadkCore.util.c;
import java.net.URLDecoder;
/* loaded from: classes8.dex */
public class MsgPhotoLiveCardVew extends e {
    private LinearLayout kAC;
    private ClickableHeaderImageView kAD;
    private TextView kAE;
    private TextView kAF;
    private TextView kAG;
    private TextView kAH;
    private TextView kAI;
    private LinearLayout kAJ;
    private TextView kAK;
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
        this.kAC = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.kAD = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.kAE = (TextView) findViewById(R.id.author_name);
        this.kAF = (TextView) findViewById(R.id.call_time);
        this.kAG = (TextView) findViewById(R.id.call_content);
        this.kAH = (TextView) findViewById(R.id.call_thread_title);
        this.kAJ = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.kAI = (TextView) findViewById(R.id.remind_title);
        this.kAK = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.kAC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.TI(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.TI(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.Ed(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ed(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
        }
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        String decode;
        int i;
        int i2 = -1;
        if (chatMessage != null) {
            a.C0770a MP = a.MP(chatMessage.getContent());
            if (MP == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = MP.threadId;
            this.postId = MP.postId;
            this.messageType = MP.msgType;
            int i3 = MP.kAO;
            ViewGroup.LayoutParams layoutParams = this.kAJ.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    decode = MP.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    decode = URLDecoder.decode(MP.threadTitle);
                    i = R.string.look_god_thread;
                    i2 = 0;
                }
                this.kAH.setText(decode);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.kAJ.setPadding(this.paddingLeft, 0, 0, 0);
                this.kAD.setVisibility(0);
                this.kAD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.dq(view2);
                    }
                });
                this.kAD.setTag(MP.userId);
                this.kAD.setGodIconMargin(i2);
                this.kAI.setVisibility(8);
                this.kAE.setVisibility(0);
                this.kAE.setText(MP.userName);
                this.kAG.setText(MP.kAN);
                this.kAE.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.kAK.setText(i);
            } else if (this.messageType == 3) {
                this.kAH.setText(MP.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.kAJ.setPadding(0, 0, 0, 0);
                this.kAD.setVisibility(8);
                this.kAI.setVisibility(0);
                this.kAE.setVisibility(8);
                this.kAI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (MP.kAN != null && MP.kAN.indexOf(String.valueOf(i3)) != -1) {
                    this.kAG.setText(bg(MP.kAN, i3));
                } else {
                    this.kAG.setText(MP.kAN);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.kAJ.setPadding(0, 0, 0, 0);
                this.kAD.setVisibility(8);
                this.kAI.setVisibility(0);
                this.kAE.setVisibility(8);
                this.kAG.setText(MP.kAN);
                if (this.messageType == 4) {
                    this.kAH.setText(MP.threadTitle);
                    this.kAI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.kAH.setText(MP.threadTitle);
                    this.kAK.setText(R.string.look_normal_thread);
                    this.kAI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(MP.portrait)) {
                this.kAD.startLoad(MP.portrait, 12, false);
            } else {
                this.kAD.startLoad(null, 12, false);
            }
            this.kAF.setText(at.getFormatTime(MP.kAM));
        }
    }

    private SpannableStringBuilder bg(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int Ee = Ee(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0305)), indexOf, Ee + indexOf, 33);
        return spannableStringBuilder;
    }

    private int Ee(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
