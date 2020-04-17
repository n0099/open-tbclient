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
/* loaded from: classes13.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout igT;
    private ClickableHeaderImageView igU;
    private TextView igV;
    private TextView igW;
    private TextView igX;
    private TextView igY;
    private TextView igZ;
    private LinearLayout iha;
    private TextView ihb;
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
        this.igT = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.igU = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.igV = (TextView) findViewById(R.id.author_name);
        this.igW = (TextView) findViewById(R.id.call_time);
        this.igX = (TextView) findViewById(R.id.call_content);
        this.igY = (TextView) findViewById(R.id.call_thread_title);
        this.iha = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.igZ = (TextView) findViewById(R.id.remind_title);
        this.ihb = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.igT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.KW(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.KW(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.wK(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wK(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(View view) {
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
            a.C0565a Eg = a.Eg(chatMessage.getContent());
            if (Eg == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = Eg.threadId;
            this.postId = Eg.postId;
            this.messageType = Eg.msgType;
            int i3 = Eg.ihf;
            ViewGroup.LayoutParams layoutParams = this.iha.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = Eg.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(Eg.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.igY.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.iha.setPadding(this.paddingLeft, 0, 0, 0);
                this.igU.setVisibility(0);
                this.igU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.co(view2);
                    }
                });
                this.igU.setTag(Eg.userId);
                this.igU.setGodIconMargin(i2);
                this.igZ.setVisibility(8);
                this.igV.setVisibility(0);
                this.igV.setText(Eg.userName);
                this.igX.setText(Eg.ihe);
                this.igV.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.ihb.setText(i);
            } else if (this.messageType == 3) {
                this.igY.setText(Eg.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.iha.setPadding(0, 0, 0, 0);
                this.igU.setVisibility(8);
                this.igZ.setVisibility(0);
                this.igV.setVisibility(8);
                this.igZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (Eg.ihe != null && Eg.ihe.indexOf(String.valueOf(i3)) != -1) {
                    this.igX.setText(aT(Eg.ihe, i3));
                } else {
                    this.igX.setText(Eg.ihe);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.iha.setPadding(0, 0, 0, 0);
                this.igU.setVisibility(8);
                this.igZ.setVisibility(0);
                this.igV.setVisibility(8);
                this.igX.setText(Eg.ihe);
                if (this.messageType == 4) {
                    this.igY.setText(Eg.threadTitle);
                    this.igZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.igY.setText(Eg.threadTitle);
                    this.ihb.setText(R.string.look_normal_thread);
                    this.igZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(Eg.portrait)) {
                this.igU.startLoad(Eg.portrait, 12, false);
            } else {
                this.igU.startLoad(null, 12, false);
            }
            this.igW.setText(aq.getFormatTime(Eg.ihd));
        }
    }

    private SpannableStringBuilder aT(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int wL = wL(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)), indexOf, wL + indexOf, 33);
        return spannableStringBuilder;
    }

    private int wL(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
