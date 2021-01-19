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
/* loaded from: classes7.dex */
public class MsgPhotoLiveCardVew extends e {
    private LinearLayout kvX;
    private ClickableHeaderImageView kvY;
    private TextView kvZ;
    private TextView kwa;
    private TextView kwb;
    private TextView kwc;
    private TextView kwd;
    private LinearLayout kwe;
    private TextView kwf;
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
        this.kvX = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.kvY = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.kvZ = (TextView) findViewById(R.id.author_name);
        this.kwa = (TextView) findViewById(R.id.call_time);
        this.kwb = (TextView) findViewById(R.id.call_content);
        this.kwc = (TextView) findViewById(R.id.call_thread_title);
        this.kwe = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.kwd = (TextView) findViewById(R.id.remind_title);
        this.kwf = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.kvX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.SB(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.SB(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.Cw(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cw(int i) {
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
            a.C0753a LI = a.LI(chatMessage.getContent());
            if (LI == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = LI.threadId;
            this.postId = LI.postId;
            this.messageType = LI.msgType;
            int i3 = LI.kwj;
            ViewGroup.LayoutParams layoutParams = this.kwe.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    decode = LI.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    decode = URLDecoder.decode(LI.threadTitle);
                    i = R.string.look_god_thread;
                    i2 = 0;
                }
                this.kwc.setText(decode);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.kwe.setPadding(this.paddingLeft, 0, 0, 0);
                this.kvY.setVisibility(0);
                this.kvY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.dq(view2);
                    }
                });
                this.kvY.setTag(LI.userId);
                this.kvY.setGodIconMargin(i2);
                this.kwd.setVisibility(8);
                this.kvZ.setVisibility(0);
                this.kvZ.setText(LI.userName);
                this.kwb.setText(LI.kwi);
                this.kvZ.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.kwf.setText(i);
            } else if (this.messageType == 3) {
                this.kwc.setText(LI.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.kwe.setPadding(0, 0, 0, 0);
                this.kvY.setVisibility(8);
                this.kwd.setVisibility(0);
                this.kvZ.setVisibility(8);
                this.kwd.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (LI.kwi != null && LI.kwi.indexOf(String.valueOf(i3)) != -1) {
                    this.kwb.setText(bh(LI.kwi, i3));
                } else {
                    this.kwb.setText(LI.kwi);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.kwe.setPadding(0, 0, 0, 0);
                this.kvY.setVisibility(8);
                this.kwd.setVisibility(0);
                this.kvZ.setVisibility(8);
                this.kwb.setText(LI.kwi);
                if (this.messageType == 4) {
                    this.kwc.setText(LI.threadTitle);
                    this.kwd.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.kwc.setText(LI.threadTitle);
                    this.kwf.setText(R.string.look_normal_thread);
                    this.kwd.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(LI.portrait)) {
                this.kvY.startLoad(LI.portrait, 12, false);
            } else {
                this.kvY.startLoad(null, 12, false);
            }
            this.kwa.setText(at.getFormatTime(LI.kwh));
        }
    }

    private SpannableStringBuilder bh(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int Cx = Cx(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0305)), indexOf, Cx + indexOf, 33);
        return spannableStringBuilder;
    }

    private int Cx(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
