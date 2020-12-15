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
import com.baidu.tbadk.core.util.au;
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
    private LinearLayout knX;
    private ClickableHeaderImageView knY;
    private TextView knZ;
    private TextView koa;
    private TextView kob;
    private TextView koc;
    private TextView kod;
    private LinearLayout koe;
    private TextView kof;
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
        this.knX = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.knY = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.knZ = (TextView) findViewById(R.id.author_name);
        this.koa = (TextView) findViewById(R.id.call_time);
        this.kob = (TextView) findViewById(R.id.call_content);
        this.koc = (TextView) findViewById(R.id.call_thread_title);
        this.koe = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.kod = (TextView) findViewById(R.id.remind_title);
        this.kof = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.knX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.TZ(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.TZ(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.DR(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DR(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dg(View view) {
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
            a.C0774a MQ = a.MQ(chatMessage.getContent());
            if (MQ == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = MQ.threadId;
            this.postId = MQ.postId;
            this.messageType = MQ.msgType;
            int i3 = MQ.koj;
            ViewGroup.LayoutParams layoutParams = this.koe.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = MQ.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(MQ.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.koc.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.koe.setPadding(this.paddingLeft, 0, 0, 0);
                this.knY.setVisibility(0);
                this.knY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.dg(view2);
                    }
                });
                this.knY.setTag(MQ.userId);
                this.knY.setGodIconMargin(i2);
                this.kod.setVisibility(8);
                this.knZ.setVisibility(0);
                this.knZ.setText(MQ.userName);
                this.kob.setText(MQ.koi);
                this.knZ.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.kof.setText(i);
            } else if (this.messageType == 3) {
                this.koc.setText(MQ.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.koe.setPadding(0, 0, 0, 0);
                this.knY.setVisibility(8);
                this.kod.setVisibility(0);
                this.knZ.setVisibility(8);
                this.kod.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (MQ.koi != null && MQ.koi.indexOf(String.valueOf(i3)) != -1) {
                    this.kob.setText(aZ(MQ.koi, i3));
                } else {
                    this.kob.setText(MQ.koi);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.koe.setPadding(0, 0, 0, 0);
                this.knY.setVisibility(8);
                this.kod.setVisibility(0);
                this.knZ.setVisibility(8);
                this.kob.setText(MQ.koi);
                if (this.messageType == 4) {
                    this.koc.setText(MQ.threadTitle);
                    this.kod.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.koc.setText(MQ.threadTitle);
                    this.kof.setText(R.string.look_normal_thread);
                    this.kod.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(MQ.portrait)) {
                this.knY.startLoad(MQ.portrait, 12, false);
            } else {
                this.knY.startLoad(null, 12, false);
            }
            this.koa.setText(au.getFormatTime(MQ.koh));
        }
    }

    private SpannableStringBuilder aZ(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int DS = DS(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305)), indexOf, DS + indexOf, 33);
        return spannableStringBuilder;
    }

    private int DS(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
