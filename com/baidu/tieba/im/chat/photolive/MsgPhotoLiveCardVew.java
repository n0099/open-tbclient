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
    private LinearLayout jZG;
    private ClickableHeaderImageView jZH;
    private TextView jZI;
    private TextView jZJ;
    private TextView jZK;
    private TextView jZL;
    private TextView jZM;
    private LinearLayout jZN;
    private TextView jZO;
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
        this.jZG = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.jZH = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.jZI = (TextView) findViewById(R.id.author_name);
        this.jZJ = (TextView) findViewById(R.id.call_time);
        this.jZK = (TextView) findViewById(R.id.call_content);
        this.jZL = (TextView) findViewById(R.id.call_thread_title);
        this.jZN = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.jZM = (TextView) findViewById(R.id.remind_title);
        this.jZO = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.jZG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.SZ(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.SZ(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.CE(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CE(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(View view) {
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
            a.C0756a Mh = a.Mh(chatMessage.getContent());
            if (Mh == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = Mh.threadId;
            this.postId = Mh.postId;
            this.messageType = Mh.msgType;
            int i3 = Mh.jZS;
            ViewGroup.LayoutParams layoutParams = this.jZN.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = Mh.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(Mh.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.jZL.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.jZN.setPadding(this.paddingLeft, 0, 0, 0);
                this.jZH.setVisibility(0);
                this.jZH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.cU(view2);
                    }
                });
                this.jZH.setTag(Mh.userId);
                this.jZH.setGodIconMargin(i2);
                this.jZM.setVisibility(8);
                this.jZI.setVisibility(0);
                this.jZI.setText(Mh.userName);
                this.jZK.setText(Mh.jZR);
                this.jZI.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.jZO.setText(i);
            } else if (this.messageType == 3) {
                this.jZL.setText(Mh.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.jZN.setPadding(0, 0, 0, 0);
                this.jZH.setVisibility(8);
                this.jZM.setVisibility(0);
                this.jZI.setVisibility(8);
                this.jZM.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (Mh.jZR != null && Mh.jZR.indexOf(String.valueOf(i3)) != -1) {
                    this.jZK.setText(aZ(Mh.jZR, i3));
                } else {
                    this.jZK.setText(Mh.jZR);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.jZN.setPadding(0, 0, 0, 0);
                this.jZH.setVisibility(8);
                this.jZM.setVisibility(0);
                this.jZI.setVisibility(8);
                this.jZK.setText(Mh.jZR);
                if (this.messageType == 4) {
                    this.jZL.setText(Mh.threadTitle);
                    this.jZM.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.jZL.setText(Mh.threadTitle);
                    this.jZO.setText(R.string.look_normal_thread);
                    this.jZM.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(Mh.portrait)) {
                this.jZH.startLoad(Mh.portrait, 12, false);
            } else {
                this.jZH.startLoad(null, 12, false);
            }
            this.jZJ.setText(at.getFormatTime(Mh.jZQ));
        }
    }

    private SpannableStringBuilder aZ(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int CF = CF(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)), indexOf, CF + indexOf, 33);
        return spannableStringBuilder;
    }

    private int CF(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
