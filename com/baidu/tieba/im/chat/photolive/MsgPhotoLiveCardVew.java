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
/* loaded from: classes3.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout gEC;
    private ClickableHeaderImageView gED;
    private TextView gEE;
    private TextView gEF;
    private TextView gEG;
    private TextView gEH;
    private TextView gEI;
    private LinearLayout gEJ;
    private TextView gEK;
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
        this.paddingLeft = l.g(tbPageContext.getContext(), R.dimen.ds24);
        init();
    }

    private void init() {
        this.gEC = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.gED = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.gEE = (TextView) findViewById(R.id.author_name);
        this.gEF = (TextView) findViewById(R.id.call_time);
        this.gEG = (TextView) findViewById(R.id.call_content);
        this.gEH = (TextView) findViewById(R.id.call_thread_title);
        this.gEJ = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.gEI = (TextView) findViewById(R.id.remind_title);
        this.gEK = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.gEC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MsgPhotoLiveCardVew.this.threadId > 0) {
                    c photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
                    if (MsgPhotoLiveCardVew.this.messageType != 1) {
                        if (MsgPhotoLiveCardVew.this.messageType != 3) {
                            if (MsgPhotoLiveCardVew.this.messageType != 4) {
                                if (MsgPhotoLiveCardVew.this.messageType == 5) {
                                    TiebaStatic.log("c10492");
                                }
                            } else {
                                TiebaStatic.log("c10500");
                            }
                        } else {
                            TiebaStatic.log("c10390");
                        }
                    } else {
                        TiebaStatic.log("c10195");
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.Fw(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.Fw(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.vn(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vn(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
        }
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        int i;
        String str;
        int i2 = -1;
        if (chatMessage != null) {
            a.C0345a yV = a.yV(chatMessage.getContent());
            if (yV == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = yV.threadId;
            this.postId = yV.postId;
            this.messageType = yV.msgType;
            int i3 = yV.gEO;
            ViewGroup.LayoutParams layoutParams = this.gEJ.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = yV.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(yV.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.gEH.setText(str);
                layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.gEJ.setPadding(this.paddingLeft, 0, 0, 0);
                this.gED.setVisibility(0);
                this.gED.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.ci(view2);
                    }
                });
                this.gED.setTag(yV.userId);
                this.gED.setGodIconMargin(i2);
                this.gEI.setVisibility(8);
                this.gEE.setVisibility(0);
                this.gEE.setText(yV.userName);
                this.gEG.setText(yV.gEN);
                this.gEE.setTextSize(0, l.g(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.gEK.setText(i);
            } else if (this.messageType == 3) {
                this.gEH.setText(yV.threadTitle);
                layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.gEJ.setPadding(0, 0, 0, 0);
                this.gED.setVisibility(8);
                this.gEI.setVisibility(0);
                this.gEE.setVisibility(8);
                this.gEI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (yV.gEN != null && yV.gEN.indexOf(String.valueOf(i3)) != -1) {
                    this.gEG.setText(aG(yV.gEN, i3));
                } else {
                    this.gEG.setText(yV.gEN);
                }
            } else {
                layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.gEJ.setPadding(0, 0, 0, 0);
                this.gED.setVisibility(8);
                this.gEI.setVisibility(0);
                this.gEE.setVisibility(8);
                this.gEG.setText(yV.gEN);
                if (this.messageType == 4) {
                    this.gEH.setText(yV.threadTitle);
                    this.gEI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.gEH.setText(yV.threadTitle);
                    this.gEK.setText(R.string.look_normal_thread);
                    this.gEI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(yV.portrait)) {
                this.gED.startLoad(yV.portrait, 12, false);
            } else {
                this.gED.startLoad(null, 12, false);
            }
            this.gEF.setText(aq.aD(yV.gEM));
        }
    }

    private SpannableStringBuilder aG(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int vo = vo(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)), indexOf, vo + indexOf, 33);
        return spannableStringBuilder;
    }

    private int vo(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
