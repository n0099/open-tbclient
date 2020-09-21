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
/* loaded from: classes25.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout jso;
    private ClickableHeaderImageView jsp;
    private TextView jsq;
    private TextView jsr;
    private TextView jss;
    private TextView jst;
    private TextView jsu;
    private LinearLayout jsv;
    private TextView jsw;
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
        this.jso = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.jsp = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.jsq = (TextView) findViewById(R.id.author_name);
        this.jsr = (TextView) findViewById(R.id.call_time);
        this.jss = (TextView) findViewById(R.id.call_content);
        this.jst = (TextView) findViewById(R.id.call_thread_title);
        this.jsv = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.jsu = (TextView) findViewById(R.id.remind_title);
        this.jsw = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.jso.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.Rv(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.Rv(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.Bs(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bs(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(View view) {
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
            a.C0708a KD = a.KD(chatMessage.getContent());
            if (KD == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = KD.threadId;
            this.postId = KD.postId;
            this.messageType = KD.msgType;
            int i3 = KD.jsA;
            ViewGroup.LayoutParams layoutParams = this.jsv.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = KD.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(KD.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.jst.setText(str);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.jsv.setPadding(this.paddingLeft, 0, 0, 0);
                this.jsp.setVisibility(0);
                this.jsp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.cH(view2);
                    }
                });
                this.jsp.setTag(KD.userId);
                this.jsp.setGodIconMargin(i2);
                this.jsu.setVisibility(8);
                this.jsq.setVisibility(0);
                this.jsq.setText(KD.userName);
                this.jss.setText(KD.jsz);
                this.jsq.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.jsw.setText(i);
            } else if (this.messageType == 3) {
                this.jst.setText(KD.threadTitle);
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.jsv.setPadding(0, 0, 0, 0);
                this.jsp.setVisibility(8);
                this.jsu.setVisibility(0);
                this.jsq.setVisibility(8);
                this.jsu.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (KD.jsz != null && KD.jsz.indexOf(String.valueOf(i3)) != -1) {
                    this.jss.setText(aV(KD.jsz, i3));
                } else {
                    this.jss.setText(KD.jsz);
                }
            } else {
                layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.jsv.setPadding(0, 0, 0, 0);
                this.jsp.setVisibility(8);
                this.jsu.setVisibility(0);
                this.jsq.setVisibility(8);
                this.jss.setText(KD.jsz);
                if (this.messageType == 4) {
                    this.jst.setText(KD.threadTitle);
                    this.jsu.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.jst.setText(KD.threadTitle);
                    this.jsw.setText(R.string.look_normal_thread);
                    this.jsu.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(KD.portrait)) {
                this.jsp.startLoad(KD.portrait, 12, false);
            } else {
                this.jsp.startLoad(null, 12, false);
            }
            this.jsr.setText(at.getFormatTime(KD.jsy));
        }
    }

    private SpannableStringBuilder aV(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int Bt = Bt(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)), indexOf, Bt + indexOf, 33);
        return spannableStringBuilder;
    }

    private int Bt(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
