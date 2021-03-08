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
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.chat.photolive.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.tbadkCore.util.c;
import java.net.URLDecoder;
/* loaded from: classes7.dex */
public class MsgPhotoLiveCardVew extends e {
    private LinearLayout kGA;
    private TextView kGB;
    private LinearLayout kGt;
    private ClickableHeaderImageView kGu;
    private TextView kGv;
    private TextView kGw;
    private TextView kGx;
    private TextView kGy;
    private TextView kGz;
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
        this.kGt = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.kGu = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.kGv = (TextView) findViewById(R.id.author_name);
        this.kGw = (TextView) findViewById(R.id.call_time);
        this.kGx = (TextView) findViewById(R.id.call_content);
        this.kGy = (TextView) findViewById(R.id.call_thread_title);
        this.kGA = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.kGz = (TextView) findViewById(R.id.remind_title);
        this.kGB = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.kGt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.TR(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.TR(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.CR(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CR(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m35do(View view) {
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
            a.C0762a MD = a.MD(chatMessage.getContent());
            if (MD == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = MD.threadId;
            this.postId = MD.postId;
            this.messageType = MD.msgType;
            int i3 = MD.kGF;
            ViewGroup.LayoutParams layoutParams = this.kGA.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    decode = MD.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    decode = URLDecoder.decode(MD.threadTitle);
                    i = R.string.look_god_thread;
                    i2 = 0;
                }
                this.kGy.setText(decode);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.kGA.setPadding(this.paddingLeft, 0, 0, 0);
                this.kGu.setVisibility(0);
                this.kGu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.m35do(view2);
                    }
                });
                this.kGu.setTag(MD.userId);
                this.kGu.setGodIconMargin(i2);
                this.kGz.setVisibility(8);
                this.kGv.setVisibility(0);
                this.kGv.setText(MD.userName);
                this.kGx.setText(MD.kGE);
                this.kGv.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.kGB.setText(i);
            } else if (this.messageType == 3) {
                this.kGy.setText(MD.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.kGA.setPadding(0, 0, 0, 0);
                this.kGu.setVisibility(8);
                this.kGz.setVisibility(0);
                this.kGv.setVisibility(8);
                this.kGz.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (MD.kGE != null && MD.kGE.indexOf(String.valueOf(i3)) != -1) {
                    this.kGx.setText(bh(MD.kGE, i3));
                } else {
                    this.kGx.setText(MD.kGE);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.kGA.setPadding(0, 0, 0, 0);
                this.kGu.setVisibility(8);
                this.kGz.setVisibility(0);
                this.kGv.setVisibility(8);
                this.kGx.setText(MD.kGE);
                if (this.messageType == 4) {
                    this.kGy.setText(MD.threadTitle);
                    this.kGz.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.kGy.setText(MD.threadTitle);
                    this.kGB.setText(R.string.look_normal_thread);
                    this.kGz.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(MD.portrait)) {
                this.kGu.startLoad(MD.portrait, 12, false);
            } else {
                this.kGu.startLoad(null, 12, false);
            }
            this.kGw.setText(au.getFormatTime(MD.kGD));
        }
    }

    private SpannableStringBuilder bh(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int CS = CS(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305)), indexOf, CS + indexOf, 33);
        return spannableStringBuilder;
    }

    private int CS(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
