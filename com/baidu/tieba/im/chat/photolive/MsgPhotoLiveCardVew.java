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
    private TextView iwA;
    private TextView iwB;
    private LinearLayout iwC;
    private TextView iwD;
    private LinearLayout iwv;
    private ClickableHeaderImageView iww;
    private TextView iwx;
    private TextView iwy;
    private TextView iwz;
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
        this.iwv = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.iww = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.iwx = (TextView) findViewById(R.id.author_name);
        this.iwy = (TextView) findViewById(R.id.call_time);
        this.iwz = (TextView) findViewById(R.id.call_content);
        this.iwA = (TextView) findViewById(R.id.call_thread_title);
        this.iwC = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.iwB = (TextView) findViewById(R.id.remind_title);
        this.iwD = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.iwv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.MN(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.MN(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.xs(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xs(int i) {
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
            int i3 = FS.iwH;
            ViewGroup.LayoutParams layoutParams = this.iwC.getLayoutParams();
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
                this.iwA.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.iwC.setPadding(this.paddingLeft, 0, 0, 0);
                this.iww.setVisibility(0);
                this.iww.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.co(view2);
                    }
                });
                this.iww.setTag(FS.userId);
                this.iww.setGodIconMargin(i2);
                this.iwB.setVisibility(8);
                this.iwx.setVisibility(0);
                this.iwx.setText(FS.userName);
                this.iwz.setText(FS.iwG);
                this.iwx.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.iwD.setText(i);
            } else if (this.messageType == 3) {
                this.iwA.setText(FS.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.iwC.setPadding(0, 0, 0, 0);
                this.iww.setVisibility(8);
                this.iwB.setVisibility(0);
                this.iwx.setVisibility(8);
                this.iwB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (FS.iwG != null && FS.iwG.indexOf(String.valueOf(i3)) != -1) {
                    this.iwz.setText(aU(FS.iwG, i3));
                } else {
                    this.iwz.setText(FS.iwG);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.iwC.setPadding(0, 0, 0, 0);
                this.iww.setVisibility(8);
                this.iwB.setVisibility(0);
                this.iwx.setVisibility(8);
                this.iwz.setText(FS.iwG);
                if (this.messageType == 4) {
                    this.iwA.setText(FS.threadTitle);
                    this.iwB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.iwA.setText(FS.threadTitle);
                    this.iwD.setText(R.string.look_normal_thread);
                    this.iwB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(FS.portrait)) {
                this.iww.startLoad(FS.portrait, 12, false);
            } else {
                this.iww.startLoad(null, 12, false);
            }
            this.iwy.setText(aq.getFormatTime(FS.iwF));
        }
    }

    private SpannableStringBuilder aU(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int xt = xt(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)), indexOf, xt + indexOf, 33);
        return spannableStringBuilder;
    }

    private int xt(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
