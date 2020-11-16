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
/* loaded from: classes25.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout kaq;
    private ClickableHeaderImageView kar;
    private TextView kas;
    private TextView kat;
    private TextView kau;
    private TextView kaw;
    private TextView kax;
    private LinearLayout kay;
    private TextView kaz;
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
        this.kaq = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.kar = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.kas = (TextView) findViewById(R.id.author_name);
        this.kat = (TextView) findViewById(R.id.call_time);
        this.kau = (TextView) findViewById(R.id.call_content);
        this.kaw = (TextView) findViewById(R.id.call_thread_title);
        this.kay = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.kax = (TextView) findViewById(R.id.remind_title);
        this.kaz = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.kaq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.SK(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.SK(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.Dc(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dc(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZ(View view) {
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
            a.C0758a LI = a.LI(chatMessage.getContent());
            if (LI == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = LI.threadId;
            this.postId = LI.postId;
            this.messageType = LI.msgType;
            int i3 = LI.kaD;
            ViewGroup.LayoutParams layoutParams = this.kay.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = LI.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(LI.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.kaw.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.kay.setPadding(this.paddingLeft, 0, 0, 0);
                this.kar.setVisibility(0);
                this.kar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.cZ(view2);
                    }
                });
                this.kar.setTag(LI.userId);
                this.kar.setGodIconMargin(i2);
                this.kax.setVisibility(8);
                this.kas.setVisibility(0);
                this.kas.setText(LI.userName);
                this.kau.setText(LI.kaC);
                this.kas.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.kaz.setText(i);
            } else if (this.messageType == 3) {
                this.kaw.setText(LI.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.kay.setPadding(0, 0, 0, 0);
                this.kar.setVisibility(8);
                this.kax.setVisibility(0);
                this.kas.setVisibility(8);
                this.kax.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (LI.kaC != null && LI.kaC.indexOf(String.valueOf(i3)) != -1) {
                    this.kau.setText(aY(LI.kaC, i3));
                } else {
                    this.kau.setText(LI.kaC);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.kay.setPadding(0, 0, 0, 0);
                this.kar.setVisibility(8);
                this.kax.setVisibility(0);
                this.kas.setVisibility(8);
                this.kau.setText(LI.kaC);
                if (this.messageType == 4) {
                    this.kaw.setText(LI.threadTitle);
                    this.kax.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.kaw.setText(LI.threadTitle);
                    this.kaz.setText(R.string.look_normal_thread);
                    this.kax.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(LI.portrait)) {
                this.kar.startLoad(LI.portrait, 12, false);
            } else {
                this.kar.startLoad(null, 12, false);
            }
            this.kat.setText(au.getFormatTime(LI.kaB));
        }
    }

    private SpannableStringBuilder aY(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int Dd = Dd(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305)), indexOf, Dd + indexOf, 33);
        return spannableStringBuilder;
    }

    private int Dd(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
