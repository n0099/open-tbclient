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
/* loaded from: classes10.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout hpQ;
    private ClickableHeaderImageView hpR;
    private TextView hpS;
    private TextView hpT;
    private TextView hpU;
    private TextView hpV;
    private TextView hpW;
    private LinearLayout hpX;
    private TextView hpY;
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
        this.hpQ = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.hpR = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.hpS = (TextView) findViewById(R.id.author_name);
        this.hpT = (TextView) findViewById(R.id.call_time);
        this.hpU = (TextView) findViewById(R.id.call_content);
        this.hpV = (TextView) findViewById(R.id.call_thread_title);
        this.hpX = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.hpW = (TextView) findViewById(R.id.remind_title);
        this.hpY = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.hpQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.IP(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.IP(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.vT(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vT(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(View view) {
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
            a.C0515a BX = a.BX(chatMessage.getContent());
            if (BX == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = BX.threadId;
            this.postId = BX.postId;
            this.messageType = BX.msgType;
            int i3 = BX.hqc;
            ViewGroup.LayoutParams layoutParams = this.hpX.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = BX.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(BX.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.hpV.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.hpX.setPadding(this.paddingLeft, 0, 0, 0);
                this.hpR.setVisibility(0);
                this.hpR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.cb(view2);
                    }
                });
                this.hpR.setTag(BX.userId);
                this.hpR.setGodIconMargin(i2);
                this.hpW.setVisibility(8);
                this.hpS.setVisibility(0);
                this.hpS.setText(BX.userName);
                this.hpU.setText(BX.hqb);
                this.hpS.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.hpY.setText(i);
            } else if (this.messageType == 3) {
                this.hpV.setText(BX.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.hpX.setPadding(0, 0, 0, 0);
                this.hpR.setVisibility(8);
                this.hpW.setVisibility(0);
                this.hpS.setVisibility(8);
                this.hpW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (BX.hqb != null && BX.hqb.indexOf(String.valueOf(i3)) != -1) {
                    this.hpU.setText(aK(BX.hqb, i3));
                } else {
                    this.hpU.setText(BX.hqb);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.hpX.setPadding(0, 0, 0, 0);
                this.hpR.setVisibility(8);
                this.hpW.setVisibility(0);
                this.hpS.setVisibility(8);
                this.hpU.setText(BX.hqb);
                if (this.messageType == 4) {
                    this.hpV.setText(BX.threadTitle);
                    this.hpW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.hpV.setText(BX.threadTitle);
                    this.hpY.setText(R.string.look_normal_thread);
                    this.hpW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(BX.portrait)) {
                this.hpR.startLoad(BX.portrait, 12, false);
            } else {
                this.hpR.startLoad(null, 12, false);
            }
            this.hpT.setText(aq.getFormatTime(BX.hqa));
        }
    }

    private SpannableStringBuilder aK(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int vU = vU(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)), indexOf, vU + indexOf, 33);
        return spannableStringBuilder;
    }

    private int vU(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
