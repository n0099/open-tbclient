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
import com.baidu.tbadk.core.util.as;
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
    private LinearLayout iUD;
    private ClickableHeaderImageView iUE;
    private TextView iUF;
    private TextView iUG;
    private TextView iUH;
    private TextView iUI;
    private TextView iUJ;
    private LinearLayout iUK;
    private TextView iUL;
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
        this.iUD = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.iUE = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.iUF = (TextView) findViewById(R.id.author_name);
        this.iUG = (TextView) findViewById(R.id.call_time);
        this.iUH = (TextView) findViewById(R.id.call_content);
        this.iUI = (TextView) findViewById(R.id.call_thread_title);
        this.iUK = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.iUJ = (TextView) findViewById(R.id.remind_title);
        this.iUL = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.iUD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.NX(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.NX(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.yx(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yx(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(View view) {
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
            a.C0659a Hi = a.Hi(chatMessage.getContent());
            if (Hi == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = Hi.threadId;
            this.postId = Hi.postId;
            this.messageType = Hi.msgType;
            int i3 = Hi.iUP;
            ViewGroup.LayoutParams layoutParams = this.iUK.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = Hi.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(Hi.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.iUI.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.iUK.setPadding(this.paddingLeft, 0, 0, 0);
                this.iUE.setVisibility(0);
                this.iUE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.cv(view2);
                    }
                });
                this.iUE.setTag(Hi.userId);
                this.iUE.setGodIconMargin(i2);
                this.iUJ.setVisibility(8);
                this.iUF.setVisibility(0);
                this.iUF.setText(Hi.userName);
                this.iUH.setText(Hi.iUO);
                this.iUF.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.iUL.setText(i);
            } else if (this.messageType == 3) {
                this.iUI.setText(Hi.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.iUK.setPadding(0, 0, 0, 0);
                this.iUE.setVisibility(8);
                this.iUJ.setVisibility(0);
                this.iUF.setVisibility(8);
                this.iUJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (Hi.iUO != null && Hi.iUO.indexOf(String.valueOf(i3)) != -1) {
                    this.iUH.setText(aS(Hi.iUO, i3));
                } else {
                    this.iUH.setText(Hi.iUO);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.iUK.setPadding(0, 0, 0, 0);
                this.iUE.setVisibility(8);
                this.iUJ.setVisibility(0);
                this.iUF.setVisibility(8);
                this.iUH.setText(Hi.iUO);
                if (this.messageType == 4) {
                    this.iUI.setText(Hi.threadTitle);
                    this.iUJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.iUI.setText(Hi.threadTitle);
                    this.iUL.setText(R.string.look_normal_thread);
                    this.iUJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(Hi.portrait)) {
                this.iUE.startLoad(Hi.portrait, 12, false);
            } else {
                this.iUE.startLoad(null, 12, false);
            }
            this.iUG.setText(as.getFormatTime(Hi.iUN));
        }
    }

    private SpannableStringBuilder aS(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int yy = yy(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.cp_link_tip_d)), indexOf, yy + indexOf, 33);
        return spannableStringBuilder;
    }

    private int yy(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
