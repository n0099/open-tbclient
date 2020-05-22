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
    private LinearLayout ivI;
    private ClickableHeaderImageView ivJ;
    private TextView ivK;
    private TextView ivL;
    private TextView ivM;
    private TextView ivN;
    private TextView ivO;
    private LinearLayout ivP;
    private TextView ivQ;
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
        this.ivI = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.ivJ = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.ivK = (TextView) findViewById(R.id.author_name);
        this.ivL = (TextView) findViewById(R.id.call_time);
        this.ivM = (TextView) findViewById(R.id.call_content);
        this.ivN = (TextView) findViewById(R.id.call_thread_title);
        this.ivP = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.ivO = (TextView) findViewById(R.id.remind_title);
        this.ivQ = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.ivI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.MM(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.MM(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.xq(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xq(int i) {
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
            a.C0636a FS = a.FS(chatMessage.getContent());
            if (FS == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = FS.threadId;
            this.postId = FS.postId;
            this.messageType = FS.msgType;
            int i3 = FS.ivU;
            ViewGroup.LayoutParams layoutParams = this.ivP.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = FS.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(FS.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.ivN.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.ivP.setPadding(this.paddingLeft, 0, 0, 0);
                this.ivJ.setVisibility(0);
                this.ivJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.co(view2);
                    }
                });
                this.ivJ.setTag(FS.userId);
                this.ivJ.setGodIconMargin(i2);
                this.ivO.setVisibility(8);
                this.ivK.setVisibility(0);
                this.ivK.setText(FS.userName);
                this.ivM.setText(FS.ivT);
                this.ivK.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.ivQ.setText(i);
            } else if (this.messageType == 3) {
                this.ivN.setText(FS.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.ivP.setPadding(0, 0, 0, 0);
                this.ivJ.setVisibility(8);
                this.ivO.setVisibility(0);
                this.ivK.setVisibility(8);
                this.ivO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (FS.ivT != null && FS.ivT.indexOf(String.valueOf(i3)) != -1) {
                    this.ivM.setText(aU(FS.ivT, i3));
                } else {
                    this.ivM.setText(FS.ivT);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.ivP.setPadding(0, 0, 0, 0);
                this.ivJ.setVisibility(8);
                this.ivO.setVisibility(0);
                this.ivK.setVisibility(8);
                this.ivM.setText(FS.ivT);
                if (this.messageType == 4) {
                    this.ivN.setText(FS.threadTitle);
                    this.ivO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.ivN.setText(FS.threadTitle);
                    this.ivQ.setText(R.string.look_normal_thread);
                    this.ivO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(FS.portrait)) {
                this.ivJ.startLoad(FS.portrait, 12, false);
            } else {
                this.ivJ.startLoad(null, 12, false);
            }
            this.ivL.setText(aq.getFormatTime(FS.ivS));
        }
    }

    private SpannableStringBuilder aU(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int xr = xr(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)), indexOf, xr + indexOf, 33);
        return spannableStringBuilder;
    }

    private int xr(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
