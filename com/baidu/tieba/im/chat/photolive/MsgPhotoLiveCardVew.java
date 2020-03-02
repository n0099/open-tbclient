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
    private TextView hvA;
    private LinearLayout hvB;
    private TextView hvC;
    private LinearLayout hvu;
    private ClickableHeaderImageView hvv;
    private TextView hvw;
    private TextView hvx;
    private TextView hvy;
    private TextView hvz;
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
        this.hvu = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.hvv = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.hvw = (TextView) findViewById(R.id.author_name);
        this.hvx = (TextView) findViewById(R.id.call_time);
        this.hvy = (TextView) findViewById(R.id.call_content);
        this.hvz = (TextView) findViewById(R.id.call_thread_title);
        this.hvB = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.hvA = (TextView) findViewById(R.id.remind_title);
        this.hvC = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.hvu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.Jm(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.Jm(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.we(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void we(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(View view) {
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
            a.C0527a Cx = a.Cx(chatMessage.getContent());
            if (Cx == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = Cx.threadId;
            this.postId = Cx.postId;
            this.messageType = Cx.msgType;
            int i3 = Cx.hvG;
            ViewGroup.LayoutParams layoutParams = this.hvB.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = Cx.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(Cx.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.hvz.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.hvB.setPadding(this.paddingLeft, 0, 0, 0);
                this.hvv.setVisibility(0);
                this.hvv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.cg(view2);
                    }
                });
                this.hvv.setTag(Cx.userId);
                this.hvv.setGodIconMargin(i2);
                this.hvA.setVisibility(8);
                this.hvw.setVisibility(0);
                this.hvw.setText(Cx.userName);
                this.hvy.setText(Cx.hvF);
                this.hvw.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.hvC.setText(i);
            } else if (this.messageType == 3) {
                this.hvz.setText(Cx.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.hvB.setPadding(0, 0, 0, 0);
                this.hvv.setVisibility(8);
                this.hvA.setVisibility(0);
                this.hvw.setVisibility(8);
                this.hvA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (Cx.hvF != null && Cx.hvF.indexOf(String.valueOf(i3)) != -1) {
                    this.hvy.setText(aJ(Cx.hvF, i3));
                } else {
                    this.hvy.setText(Cx.hvF);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.hvB.setPadding(0, 0, 0, 0);
                this.hvv.setVisibility(8);
                this.hvA.setVisibility(0);
                this.hvw.setVisibility(8);
                this.hvy.setText(Cx.hvF);
                if (this.messageType == 4) {
                    this.hvz.setText(Cx.threadTitle);
                    this.hvA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.hvz.setText(Cx.threadTitle);
                    this.hvC.setText(R.string.look_normal_thread);
                    this.hvA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(Cx.portrait)) {
                this.hvv.startLoad(Cx.portrait, 12, false);
            } else {
                this.hvv.startLoad(null, 12, false);
            }
            this.hvx.setText(aq.getFormatTime(Cx.hvE));
        }
    }

    private SpannableStringBuilder aJ(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int wf = wf(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)), indexOf, wf + indexOf, 33);
        return spannableStringBuilder;
    }

    private int wf(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
