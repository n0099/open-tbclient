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
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.chat.photolive.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.tbadkCore.util.c;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout geA;
    private TextView geB;
    private LinearLayout get;
    private ClickableHeaderImageView geu;
    private TextView gev;
    private TextView gew;
    private TextView gex;
    private TextView gey;
    private TextView gez;
    private int messageType;
    private int paddingLeft;
    private long postId;
    private long threadId;

    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_photolive_card_view);
        this.threadId = 0L;
        this.postId = 0L;
        this.messageType = 0;
        this.paddingLeft = 0;
        this.paddingLeft = l.h(tbPageContext.getContext(), d.e.ds24);
        init();
    }

    private void init() {
        this.get = (LinearLayout) findViewById(d.g.msg_photolive_card);
        this.geu = (ClickableHeaderImageView) findViewById(d.g.author_portrait);
        this.gev = (TextView) findViewById(d.g.author_name);
        this.gew = (TextView) findViewById(d.g.call_time);
        this.gex = (TextView) findViewById(d.g.call_content);
        this.gey = (TextView) findViewById(d.g.call_thread_title);
        this.geA = (LinearLayout) findViewById(d.g.auhtor_name_and_call_time);
        this.gez = (TextView) findViewById(d.g.remind_title);
        this.geB = (TextView) findViewById(d.g.card_bottom_chakanzhibo);
        this.get.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.CK(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.CK(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.tz(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tz(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(View view) {
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
            a.C0312a wu = a.wu(chatMessage.getContent());
            if (wu == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = wu.threadId;
            this.postId = wu.postId;
            this.messageType = wu.msgType;
            int i3 = wu.geF;
            ViewGroup.LayoutParams layoutParams = this.geA.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = wu.threadTitle;
                    i = d.j.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(wu.threadTitle);
                    i = d.j.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.gey.setText(str);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), d.e.ds72);
                this.geA.setPadding(this.paddingLeft, 0, 0, 0);
                this.geu.setVisibility(0);
                this.geu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.bX(view2);
                    }
                });
                this.geu.setTag(wu.userId);
                this.geu.setGodIconMargin(i2);
                this.gez.setVisibility(8);
                this.gev.setVisibility(0);
                this.gev.setText(wu.userName);
                this.gex.setText(wu.geE);
                this.gev.setTextSize(0, l.h(TbadkCoreApplication.getInst(), d.e.fontsize28));
                this.geB.setText(i);
            } else if (this.messageType == 3) {
                this.gey.setText(wu.threadTitle);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), d.e.ds80);
                this.geA.setPadding(0, 0, 0, 0);
                this.geu.setVisibility(8);
                this.gez.setVisibility(0);
                this.gev.setVisibility(8);
                this.gez.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.fans_urge_tips));
                if (wu.geE != null && wu.geE.indexOf(String.valueOf(i3)) != -1) {
                    this.gex.setText(aH(wu.geE, i3));
                } else {
                    this.gex.setText(wu.geE);
                }
            } else {
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), d.e.ds80);
                this.geA.setPadding(0, 0, 0, 0);
                this.geu.setVisibility(8);
                this.gez.setVisibility(0);
                this.gev.setVisibility(8);
                this.gex.setText(wu.geE);
                if (this.messageType == 4) {
                    this.gey.setText(wu.threadTitle);
                    this.gez.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.gey.setText(wu.threadTitle);
                    this.geB.setText(d.j.look_normal_thread);
                    this.gez.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(wu.portrait)) {
                this.geu.startLoad(wu.portrait, 12, false);
            } else {
                this.geu.startLoad(null, 12, false);
            }
            this.gew.setText(ap.ao(wu.geD));
        }
    }

    private SpannableStringBuilder aH(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int tA = tA(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_d)), indexOf, tA + indexOf, 33);
        return spannableStringBuilder;
    }

    private int tA(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
