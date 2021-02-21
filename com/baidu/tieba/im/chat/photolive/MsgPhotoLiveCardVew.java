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
/* loaded from: classes8.dex */
public class MsgPhotoLiveCardVew extends e {
    private LinearLayout kEr;
    private ClickableHeaderImageView kEs;
    private TextView kEt;
    private TextView kEu;
    private TextView kEv;
    private TextView kEw;
    private TextView kEx;
    private LinearLayout kEy;
    private TextView kEz;
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
        this.kEr = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.kEs = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.kEt = (TextView) findViewById(R.id.author_name);
        this.kEu = (TextView) findViewById(R.id.call_time);
        this.kEv = (TextView) findViewById(R.id.call_content);
        this.kEw = (TextView) findViewById(R.id.call_thread_title);
        this.kEy = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.kEx = (TextView) findViewById(R.id.remind_title);
        this.kEz = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.kEr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.TK(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.TK(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.CO(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CO(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m34do(View view) {
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
            a.C0756a Mx = a.Mx(chatMessage.getContent());
            if (Mx == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = Mx.threadId;
            this.postId = Mx.postId;
            this.messageType = Mx.msgType;
            int i3 = Mx.kED;
            ViewGroup.LayoutParams layoutParams = this.kEy.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    decode = Mx.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    decode = URLDecoder.decode(Mx.threadTitle);
                    i = R.string.look_god_thread;
                    i2 = 0;
                }
                this.kEw.setText(decode);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.kEy.setPadding(this.paddingLeft, 0, 0, 0);
                this.kEs.setVisibility(0);
                this.kEs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.m34do(view2);
                    }
                });
                this.kEs.setTag(Mx.userId);
                this.kEs.setGodIconMargin(i2);
                this.kEx.setVisibility(8);
                this.kEt.setVisibility(0);
                this.kEt.setText(Mx.userName);
                this.kEv.setText(Mx.kEC);
                this.kEt.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.kEz.setText(i);
            } else if (this.messageType == 3) {
                this.kEw.setText(Mx.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.kEy.setPadding(0, 0, 0, 0);
                this.kEs.setVisibility(8);
                this.kEx.setVisibility(0);
                this.kEt.setVisibility(8);
                this.kEx.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (Mx.kEC != null && Mx.kEC.indexOf(String.valueOf(i3)) != -1) {
                    this.kEv.setText(bh(Mx.kEC, i3));
                } else {
                    this.kEv.setText(Mx.kEC);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.kEy.setPadding(0, 0, 0, 0);
                this.kEs.setVisibility(8);
                this.kEx.setVisibility(0);
                this.kEt.setVisibility(8);
                this.kEv.setText(Mx.kEC);
                if (this.messageType == 4) {
                    this.kEw.setText(Mx.threadTitle);
                    this.kEx.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.kEw.setText(Mx.threadTitle);
                    this.kEz.setText(R.string.look_normal_thread);
                    this.kEx.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(Mx.portrait)) {
                this.kEs.startLoad(Mx.portrait, 12, false);
            } else {
                this.kEs.startLoad(null, 12, false);
            }
            this.kEu.setText(au.getFormatTime(Mx.kEB));
        }
    }

    private SpannableStringBuilder bh(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int CP = CP(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305)), indexOf, CP + indexOf, 33);
        return spannableStringBuilder;
    }

    private int CP(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
