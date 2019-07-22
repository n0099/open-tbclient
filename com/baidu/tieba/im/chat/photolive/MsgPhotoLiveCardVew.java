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
    private LinearLayout gBT;
    private ClickableHeaderImageView gBU;
    private TextView gBV;
    private TextView gBW;
    private TextView gBX;
    private TextView gBY;
    private TextView gBZ;
    private LinearLayout gCa;
    private TextView gCb;
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
        this.gBT = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.gBU = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.gBV = (TextView) findViewById(R.id.author_name);
        this.gBW = (TextView) findViewById(R.id.call_time);
        this.gBX = (TextView) findViewById(R.id.call_content);
        this.gBY = (TextView) findViewById(R.id.call_thread_title);
        this.gCa = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.gBZ = (TextView) findViewById(R.id.remind_title);
        this.gCb = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.gBT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.EV(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.EV(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.vh(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(View view) {
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
            a.C0328a yv = a.yv(chatMessage.getContent());
            if (yv == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = yv.threadId;
            this.postId = yv.postId;
            this.messageType = yv.msgType;
            int i3 = yv.gCf;
            ViewGroup.LayoutParams layoutParams = this.gCa.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = yv.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(yv.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.gBY.setText(str);
                layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.gCa.setPadding(this.paddingLeft, 0, 0, 0);
                this.gBU.setVisibility(0);
                this.gBU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.ch(view2);
                    }
                });
                this.gBU.setTag(yv.userId);
                this.gBU.setGodIconMargin(i2);
                this.gBZ.setVisibility(8);
                this.gBV.setVisibility(0);
                this.gBV.setText(yv.userName);
                this.gBX.setText(yv.gCe);
                this.gBV.setTextSize(0, l.g(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.gCb.setText(i);
            } else if (this.messageType == 3) {
                this.gBY.setText(yv.threadTitle);
                layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.gCa.setPadding(0, 0, 0, 0);
                this.gBU.setVisibility(8);
                this.gBZ.setVisibility(0);
                this.gBV.setVisibility(8);
                this.gBZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (yv.gCe != null && yv.gCe.indexOf(String.valueOf(i3)) != -1) {
                    this.gBX.setText(aE(yv.gCe, i3));
                } else {
                    this.gBX.setText(yv.gCe);
                }
            } else {
                layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.gCa.setPadding(0, 0, 0, 0);
                this.gBU.setVisibility(8);
                this.gBZ.setVisibility(0);
                this.gBV.setVisibility(8);
                this.gBX.setText(yv.gCe);
                if (this.messageType == 4) {
                    this.gBY.setText(yv.threadTitle);
                    this.gBZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.gBY.setText(yv.threadTitle);
                    this.gCb.setText(R.string.look_normal_thread);
                    this.gBZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(yv.portrait)) {
                this.gBU.startLoad(yv.portrait, 12, false);
            } else {
                this.gBU.startLoad(null, 12, false);
            }
            this.gBW.setText(aq.aD(yv.gCd));
        }
    }

    private SpannableStringBuilder aE(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int vi = vi(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)), indexOf, vi + indexOf, 33);
        return spannableStringBuilder;
    }

    private int vi(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
