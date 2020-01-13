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
/* loaded from: classes11.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout htA;
    private TextView htB;
    private LinearLayout htt;
    private ClickableHeaderImageView htu;
    private TextView htv;
    private TextView htw;
    private TextView htx;
    private TextView hty;
    private TextView htz;
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
        this.htt = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.htu = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.htv = (TextView) findViewById(R.id.author_name);
        this.htw = (TextView) findViewById(R.id.call_time);
        this.htx = (TextView) findViewById(R.id.call_content);
        this.hty = (TextView) findViewById(R.id.call_thread_title);
        this.htA = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.htz = (TextView) findViewById(R.id.remind_title);
        this.htB = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.htt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.IZ(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.IZ(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.vY(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vY(int i) {
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
            a.C0520a Ch = a.Ch(chatMessage.getContent());
            if (Ch == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = Ch.threadId;
            this.postId = Ch.postId;
            this.messageType = Ch.msgType;
            int i3 = Ch.htF;
            ViewGroup.LayoutParams layoutParams = this.htA.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = Ch.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(Ch.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.hty.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.htA.setPadding(this.paddingLeft, 0, 0, 0);
                this.htu.setVisibility(0);
                this.htu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.cg(view2);
                    }
                });
                this.htu.setTag(Ch.userId);
                this.htu.setGodIconMargin(i2);
                this.htz.setVisibility(8);
                this.htv.setVisibility(0);
                this.htv.setText(Ch.userName);
                this.htx.setText(Ch.htE);
                this.htv.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.htB.setText(i);
            } else if (this.messageType == 3) {
                this.hty.setText(Ch.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.htA.setPadding(0, 0, 0, 0);
                this.htu.setVisibility(8);
                this.htz.setVisibility(0);
                this.htv.setVisibility(8);
                this.htz.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (Ch.htE != null && Ch.htE.indexOf(String.valueOf(i3)) != -1) {
                    this.htx.setText(aL(Ch.htE, i3));
                } else {
                    this.htx.setText(Ch.htE);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.htA.setPadding(0, 0, 0, 0);
                this.htu.setVisibility(8);
                this.htz.setVisibility(0);
                this.htv.setVisibility(8);
                this.htx.setText(Ch.htE);
                if (this.messageType == 4) {
                    this.hty.setText(Ch.threadTitle);
                    this.htz.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.hty.setText(Ch.threadTitle);
                    this.htB.setText(R.string.look_normal_thread);
                    this.htz.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(Ch.portrait)) {
                this.htu.startLoad(Ch.portrait, 12, false);
            } else {
                this.htu.startLoad(null, 12, false);
            }
            this.htw.setText(aq.getFormatTime(Ch.htD));
        }
    }

    private SpannableStringBuilder aL(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int vZ = vZ(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)), indexOf, vZ + indexOf, 33);
        return spannableStringBuilder;
    }

    private int vZ(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
