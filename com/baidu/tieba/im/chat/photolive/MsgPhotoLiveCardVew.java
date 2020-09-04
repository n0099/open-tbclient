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
/* loaded from: classes20.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout jjK;
    private ClickableHeaderImageView jjL;
    private TextView jjM;
    private TextView jjN;
    private TextView jjO;
    private TextView jjP;
    private TextView jjQ;
    private LinearLayout jjR;
    private TextView jjS;
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
        this.jjK = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.jjL = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.jjM = (TextView) findViewById(R.id.author_name);
        this.jjN = (TextView) findViewById(R.id.call_time);
        this.jjO = (TextView) findViewById(R.id.call_content);
        this.jjP = (TextView) findViewById(R.id.call_thread_title);
        this.jjR = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.jjQ = (TextView) findViewById(R.id.remind_title);
        this.jjS = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.jjK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.QV(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.QV(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.AR(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AR(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(View view) {
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
            a.C0711a Kb = a.Kb(chatMessage.getContent());
            if (Kb == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = Kb.threadId;
            this.postId = Kb.postId;
            this.messageType = Kb.msgType;
            int i3 = Kb.jjW;
            ViewGroup.LayoutParams layoutParams = this.jjR.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = Kb.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(Kb.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.jjP.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.jjR.setPadding(this.paddingLeft, 0, 0, 0);
                this.jjL.setVisibility(0);
                this.jjL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.cy(view2);
                    }
                });
                this.jjL.setTag(Kb.userId);
                this.jjL.setGodIconMargin(i2);
                this.jjQ.setVisibility(8);
                this.jjM.setVisibility(0);
                this.jjM.setText(Kb.userName);
                this.jjO.setText(Kb.jjV);
                this.jjM.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.jjS.setText(i);
            } else if (this.messageType == 3) {
                this.jjP.setText(Kb.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.jjR.setPadding(0, 0, 0, 0);
                this.jjL.setVisibility(8);
                this.jjQ.setVisibility(0);
                this.jjM.setVisibility(8);
                this.jjQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (Kb.jjV != null && Kb.jjV.indexOf(String.valueOf(i3)) != -1) {
                    this.jjO.setText(aV(Kb.jjV, i3));
                } else {
                    this.jjO.setText(Kb.jjV);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.jjR.setPadding(0, 0, 0, 0);
                this.jjL.setVisibility(8);
                this.jjQ.setVisibility(0);
                this.jjM.setVisibility(8);
                this.jjO.setText(Kb.jjV);
                if (this.messageType == 4) {
                    this.jjP.setText(Kb.threadTitle);
                    this.jjQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.jjP.setText(Kb.threadTitle);
                    this.jjS.setText(R.string.look_normal_thread);
                    this.jjQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(Kb.portrait)) {
                this.jjL.startLoad(Kb.portrait, 12, false);
            } else {
                this.jjL.startLoad(null, 12, false);
            }
            this.jjN.setText(at.getFormatTime(Kb.jjU));
        }
    }

    private SpannableStringBuilder aV(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int AS = AS(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)), indexOf, AS + indexOf, 33);
        return spannableStringBuilder;
    }

    private int AS(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
