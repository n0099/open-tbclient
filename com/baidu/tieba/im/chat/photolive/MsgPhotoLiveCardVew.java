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
    private LinearLayout gvI;
    private ClickableHeaderImageView gvJ;
    private TextView gvK;
    private TextView gvL;
    private TextView gvM;
    private TextView gvN;
    private TextView gvO;
    private LinearLayout gvP;
    private TextView gvQ;
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
        this.gvI = (LinearLayout) findViewById(R.id.msg_photolive_card);
        this.gvJ = (ClickableHeaderImageView) findViewById(R.id.author_portrait);
        this.gvK = (TextView) findViewById(R.id.author_name);
        this.gvL = (TextView) findViewById(R.id.call_time);
        this.gvM = (TextView) findViewById(R.id.call_content);
        this.gvN = (TextView) findViewById(R.id.call_thread_title);
        this.gvP = (LinearLayout) findViewById(R.id.auhtor_name_and_call_time);
        this.gvO = (TextView) findViewById(R.id.remind_title);
        this.gvQ = (TextView) findViewById(R.id.card_bottom_chakanzhibo);
        this.gvI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.Ei(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.Ei(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
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
            a.C0329a xL = a.xL(chatMessage.getContent());
            if (xL == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = xL.threadId;
            this.postId = xL.postId;
            this.messageType = xL.msgType;
            int i3 = xL.gvU;
            ViewGroup.LayoutParams layoutParams = this.gvP.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = xL.threadTitle;
                    i = R.string.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(xL.threadTitle);
                    i = R.string.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.gvN.setText(str);
                layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds72);
                this.gvP.setPadding(this.paddingLeft, 0, 0, 0);
                this.gvJ.setVisibility(0);
                this.gvJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.ce(view2);
                    }
                });
                this.gvJ.setTag(xL.userId);
                this.gvJ.setGodIconMargin(i2);
                this.gvO.setVisibility(8);
                this.gvK.setVisibility(0);
                this.gvK.setText(xL.userName);
                this.gvM.setText(xL.gvT);
                this.gvK.setTextSize(0, l.g(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
                this.gvQ.setText(i);
            } else if (this.messageType == 3) {
                this.gvN.setText(xL.threadTitle);
                layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.gvP.setPadding(0, 0, 0, 0);
                this.gvJ.setVisibility(8);
                this.gvO.setVisibility(0);
                this.gvK.setVisibility(8);
                this.gvO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
                if (xL.gvT != null && xL.gvT.indexOf(String.valueOf(i3)) != -1) {
                    this.gvM.setText(aD(xL.gvT, i3));
                } else {
                    this.gvM.setText(xL.gvT);
                }
            } else {
                layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
                this.gvP.setPadding(0, 0, 0, 0);
                this.gvJ.setVisibility(8);
                this.gvO.setVisibility(0);
                this.gvK.setVisibility(8);
                this.gvM.setText(xL.gvT);
                if (this.messageType == 4) {
                    this.gvN.setText(xL.threadTitle);
                    this.gvO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.gvN.setText(xL.threadTitle);
                    this.gvQ.setText(R.string.look_normal_thread);
                    this.gvO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(xL.portrait)) {
                this.gvJ.startLoad(xL.portrait, 12, false);
            } else {
                this.gvJ.startLoad(null, 12, false);
            }
            this.gvL.setText(ap.aC(xL.gvS));
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
