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
/* loaded from: classes20.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout jjE;
    private ClickableHeaderImageView jjF;
    private TextView jjG;
    private TextView jjH;
    private TextView jjI;
    private TextView jjJ;
    private TextView jjK;
    private LinearLayout jjL;
    private TextView jjM;
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
        this.jjE = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.jjF = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.jjG = (TextView) findViewById(R.id.author_name);
        this.jjH = (TextView) findViewById(R.id.call_time);
        this.jjI = (TextView) findViewById(R.id.call_content);
        this.jjJ = (TextView) findViewById(R.id.call_thread_title);
        this.jjL = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.jjK = (TextView) findViewById(R.id.remind_title);
        this.jjM = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.jjE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.QV(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.QV(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.AR(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AR(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(View view) {
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
            a.C0711a Ka = a.Ka(chatMessage.getContent());
            if (Ka == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = Ka.threadId;
            this.postId = Ka.postId;
            this.messageType = Ka.msgType;
            int i3 = Ka.jjQ;
            ViewGroup.LayoutParams layoutParams = this.jjL.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = Ka.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(Ka.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.jjJ.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.jjL.setPadding(this.paddingLeft, 0, 0, 0);
                this.jjF.setVisibility(0);
                this.jjF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.cy(view2);
                    }
                });
                this.jjF.setTag(Ka.userId);
                this.jjF.setGodIconMargin(i2);
                this.jjK.setVisibility(8);
                this.jjG.setVisibility(0);
                this.jjG.setText(Ka.userName);
                this.jjI.setText(Ka.jjP);
                this.jjG.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.jjM.setText(i);
            } else if (this.messageType == 3) {
                this.jjJ.setText(Ka.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.jjL.setPadding(0, 0, 0, 0);
                this.jjF.setVisibility(8);
                this.jjK.setVisibility(0);
                this.jjG.setVisibility(8);
                this.jjK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (Ka.jjP != null && Ka.jjP.indexOf(String.valueOf(i3)) != -1) {
                    this.jjI.setText(aV(Ka.jjP, i3));
                } else {
                    this.jjI.setText(Ka.jjP);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.jjL.setPadding(0, 0, 0, 0);
                this.jjF.setVisibility(8);
                this.jjK.setVisibility(0);
                this.jjG.setVisibility(8);
                this.jjI.setText(Ka.jjP);
                if (this.messageType == 4) {
                    this.jjJ.setText(Ka.threadTitle);
                    this.jjK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.jjJ.setText(Ka.threadTitle);
                    this.jjM.setText(R.string.look_normal_thread);
                    this.jjK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(Ka.portrait)) {
                this.jjF.startLoad(Ka.portrait, 12, false);
            } else {
                this.jjF.startLoad(null, 12, false);
            }
            this.jjH.setText(at.getFormatTime(Ka.jjO));
        }
    }

    private SpannableStringBuilder aV(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int AS = AS(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)), indexOf, AS + indexOf, 33);
        return spannableStringBuilder;
    }

    private int AS(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
