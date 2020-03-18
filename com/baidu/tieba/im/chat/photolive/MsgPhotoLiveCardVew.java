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
    private LinearLayout hxg;
    private ClickableHeaderImageView hxh;
    private TextView hxi;
    private TextView hxj;
    private TextView hxk;
    private TextView hxl;
    private TextView hxm;
    private LinearLayout hxn;
    private TextView hxo;
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
        this.hxg = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.hxh = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.hxi = (TextView) findViewById(R.id.author_name);
        this.hxj = (TextView) findViewById(R.id.call_time);
        this.hxk = (TextView) findViewById(R.id.call_content);
        this.hxl = (TextView) findViewById(R.id.call_thread_title);
        this.hxn = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.hxm = (TextView) findViewById(R.id.remind_title);
        this.hxo = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.hxg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                    MsgPhotoLiveCardVew.this.wm(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wm(int i) {
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
            a.C0528a Cx = a.Cx(chatMessage.getContent());
            if (Cx == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = Cx.threadId;
            this.postId = Cx.postId;
            this.messageType = Cx.msgType;
            int i3 = Cx.hxs;
            ViewGroup.LayoutParams layoutParams = this.hxn.getLayoutParams();
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
                this.hxl.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.hxn.setPadding(this.paddingLeft, 0, 0, 0);
                this.hxh.setVisibility(0);
                this.hxh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.cg(view2);
                    }
                });
                this.hxh.setTag(Cx.userId);
                this.hxh.setGodIconMargin(i2);
                this.hxm.setVisibility(8);
                this.hxi.setVisibility(0);
                this.hxi.setText(Cx.userName);
                this.hxk.setText(Cx.hxr);
                this.hxi.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.hxo.setText(i);
            } else if (this.messageType == 3) {
                this.hxl.setText(Cx.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.hxn.setPadding(0, 0, 0, 0);
                this.hxh.setVisibility(8);
                this.hxm.setVisibility(0);
                this.hxi.setVisibility(8);
                this.hxm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (Cx.hxr != null && Cx.hxr.indexOf(String.valueOf(i3)) != -1) {
                    this.hxk.setText(aJ(Cx.hxr, i3));
                } else {
                    this.hxk.setText(Cx.hxr);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.hxn.setPadding(0, 0, 0, 0);
                this.hxh.setVisibility(8);
                this.hxm.setVisibility(0);
                this.hxi.setVisibility(8);
                this.hxk.setText(Cx.hxr);
                if (this.messageType == 4) {
                    this.hxl.setText(Cx.threadTitle);
                    this.hxm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.hxl.setText(Cx.threadTitle);
                    this.hxo.setText(R.string.look_normal_thread);
                    this.hxm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(Cx.portrait)) {
                this.hxh.startLoad(Cx.portrait, 12, false);
            } else {
                this.hxh.startLoad(null, 12, false);
            }
            this.hxj.setText(aq.getFormatTime(Cx.hxq));
        }
    }

    private SpannableStringBuilder aJ(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int wn = wn(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)), indexOf, wn + indexOf, 33);
        return spannableStringBuilder;
    }

    private int wn(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
