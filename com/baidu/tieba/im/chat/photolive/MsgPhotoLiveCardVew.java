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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.chat.photolive.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.tbadkCore.util.c;
import java.net.URLDecoder;
/* loaded from: classes26.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout jHl;
    private ClickableHeaderImageView jHm;
    private TextView jHn;
    private TextView jHo;
    private TextView jHp;
    private TextView jHq;
    private TextView jHr;
    private LinearLayout jHs;
    private TextView jHt;
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
        this.jHl = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.jHm = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.jHn = (TextView) findViewById(R.id.author_name);
        this.jHo = (TextView) findViewById(R.id.call_time);
        this.jHp = (TextView) findViewById(R.id.call_content);
        this.jHq = (TextView) findViewById(R.id.call_thread_title);
        this.jHs = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.jHr = (TextView) findViewById(R.id.remind_title);
        this.jHt = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.jHl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.Sj(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.Sj(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.BY(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BY(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(View view) {
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
            a.C0726a Ls = a.Ls(chatMessage.getContent());
            if (Ls == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = Ls.threadId;
            this.postId = Ls.postId;
            this.messageType = Ls.msgType;
            int i3 = Ls.jHx;
            ViewGroup.LayoutParams layoutParams = this.jHs.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = Ls.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(Ls.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.jHq.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.jHs.setPadding(this.paddingLeft, 0, 0, 0);
                this.jHm.setVisibility(0);
                this.jHm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.cL(view2);
                    }
                });
                this.jHm.setTag(Ls.userId);
                this.jHm.setGodIconMargin(i2);
                this.jHr.setVisibility(8);
                this.jHn.setVisibility(0);
                this.jHn.setText(Ls.userName);
                this.jHp.setText(Ls.jHw);
                this.jHn.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.jHt.setText(i);
            } else if (this.messageType == 3) {
                this.jHq.setText(Ls.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.jHs.setPadding(0, 0, 0, 0);
                this.jHm.setVisibility(8);
                this.jHr.setVisibility(0);
                this.jHn.setVisibility(8);
                this.jHr.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (Ls.jHw != null && Ls.jHw.indexOf(String.valueOf(i3)) != -1) {
                    this.jHp.setText(aW(Ls.jHw, i3));
                } else {
                    this.jHp.setText(Ls.jHw);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.jHs.setPadding(0, 0, 0, 0);
                this.jHm.setVisibility(8);
                this.jHr.setVisibility(0);
                this.jHn.setVisibility(8);
                this.jHp.setText(Ls.jHw);
                if (this.messageType == 4) {
                    this.jHq.setText(Ls.threadTitle);
                    this.jHr.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.jHq.setText(Ls.threadTitle);
                    this.jHt.setText(R.string.look_normal_thread);
                    this.jHr.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(Ls.portrait)) {
                this.jHm.startLoad(Ls.portrait, 12, false);
            } else {
                this.jHm.startLoad(null, 12, false);
            }
            this.jHo.setText(at.getFormatTime(Ls.jHv));
        }
    }

    private SpannableStringBuilder aW(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int BZ = BZ(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)), indexOf, BZ + indexOf, 33);
        return spannableStringBuilder;
    }

    private int BZ(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
