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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
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
    private LinearLayout gvF;
    private ClickableHeaderImageView gvG;
    private TextView gvH;
    private TextView gvI;
    private TextView gvJ;
    private TextView gvK;
    private TextView gvL;
    private LinearLayout gvM;
    private TextView gvN;
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
        this.gvF = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.gvG = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.gvH = (TextView) findViewById(R.id.author_name);
        this.gvI = (TextView) findViewById(R.id.call_time);
        this.gvJ = (TextView) findViewById(R.id.call_content);
        this.gvK = (TextView) findViewById(R.id.call_thread_title);
        this.gvM = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.gvL = (TextView) findViewById(R.id.remind_title);
        this.gvN = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.gvF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.Eg(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.Eg(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.uG(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uG(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(View view) {
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
            a.C0329a xJ = a.xJ(chatMessage.getContent());
            if (xJ == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = xJ.threadId;
            this.postId = xJ.postId;
            this.messageType = xJ.msgType;
            int i3 = xJ.gvR;
            ViewGroup.LayoutParams layoutParams = this.gvM.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = xJ.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(xJ.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.gvK.setText(str);
                layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.gvM.setPadding(this.paddingLeft, 0, 0, 0);
                this.gvG.setVisibility(0);
                this.gvG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.ce(view2);
                    }
                });
                this.gvG.setTag(xJ.userId);
                this.gvG.setGodIconMargin(i2);
                this.gvL.setVisibility(8);
                this.gvH.setVisibility(0);
                this.gvH.setText(xJ.userName);
                this.gvJ.setText(xJ.gvQ);
                this.gvH.setTextSize(0, l.g(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.gvN.setText(i);
            } else if (this.messageType == 3) {
                this.gvK.setText(xJ.threadTitle);
                layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.gvM.setPadding(0, 0, 0, 0);
                this.gvG.setVisibility(8);
                this.gvL.setVisibility(0);
                this.gvH.setVisibility(8);
                this.gvL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (xJ.gvQ != null && xJ.gvQ.indexOf(String.valueOf(i3)) != -1) {
                    this.gvJ.setText(aD(xJ.gvQ, i3));
                } else {
                    this.gvJ.setText(xJ.gvQ);
                }
            } else {
                layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.gvM.setPadding(0, 0, 0, 0);
                this.gvG.setVisibility(8);
                this.gvL.setVisibility(0);
                this.gvH.setVisibility(8);
                this.gvJ.setText(xJ.gvQ);
                if (this.messageType == 4) {
                    this.gvK.setText(xJ.threadTitle);
                    this.gvL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.gvK.setText(xJ.threadTitle);
                    this.gvN.setText(R.string.look_normal_thread);
                    this.gvL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(xJ.portrait)) {
                this.gvG.startLoad(xJ.portrait, 12, false);
            } else {
                this.gvG.startLoad(null, 12, false);
            }
            this.gvI.setText(ap.aC(xJ.gvP));
        }
    }

    private SpannableStringBuilder aD(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int uH = uH(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_d)), indexOf, uH + indexOf, 33);
        return spannableStringBuilder;
    }

    private int uH(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
