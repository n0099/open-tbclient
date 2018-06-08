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
import com.baidu.tbadk.core.util.ao;
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
    private LinearLayout efZ;
    private ClickableHeaderImageView ega;
    private TextView egb;
    private TextView egc;
    private TextView egd;
    private TextView ege;
    private TextView egf;
    private LinearLayout egg;
    private TextView egh;
    private int messageType;
    private int paddingLeft;
    private long postId;
    private long threadId;

    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_photolive_card_view);
        this.threadId = 0L;
        this.postId = 0L;
        this.messageType = 0;
        this.paddingLeft = 0;
        this.paddingLeft = l.e(tbPageContext.getContext(), d.e.ds24);
        init();
    }

    private void init() {
        this.efZ = (LinearLayout) findViewById(d.g.msg_photolive_card);
        this.ega = (ClickableHeaderImageView) findViewById(d.g.author_portrait);
        this.egb = (TextView) findViewById(d.g.author_name);
        this.egc = (TextView) findViewById(d.g.call_time);
        this.egd = (TextView) findViewById(d.g.call_content);
        this.ege = (TextView) findViewById(d.g.call_thread_title);
        this.egg = (LinearLayout) findViewById(d.g.auhtor_name_and_call_time);
        this.egf = (TextView) findViewById(d.g.remind_title);
        this.egh = (TextView) findViewById(d.g.card_bottom_chakanzhibo);
        this.efZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.tY(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.tY(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.nv(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(View view) {
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
            a.C0170a nH = a.nH(chatMessage.getContent());
            if (nH == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = nH.threadId;
            this.postId = nH.postId;
            this.messageType = nH.msgType;
            int i3 = nH.egl;
            ViewGroup.LayoutParams layoutParams = this.egg.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = nH.threadTitle;
                    i = d.k.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(nH.threadTitle);
                    i = d.k.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.ege.setText(str);
                layoutParams.height = l.e(TbadkCoreApplication.getInst(), d.e.ds72);
                this.egg.setPadding(this.paddingLeft, 0, 0, 0);
                this.ega.setVisibility(0);
                this.ega.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.aL(view2);
                    }
                });
                this.ega.setTag(nH.userId);
                this.ega.setGodIconMargin(i2);
                this.egf.setVisibility(8);
                this.egb.setVisibility(0);
                this.egb.setText(nH.userName);
                this.egd.setText(nH.egk);
                this.egb.setTextSize(0, l.e(TbadkCoreApplication.getInst(), d.e.fontsize28));
                this.egh.setText(i);
            } else if (this.messageType == 3) {
                this.ege.setText(nH.threadTitle);
                layoutParams.height = l.e(TbadkCoreApplication.getInst(), d.e.ds80);
                this.egg.setPadding(0, 0, 0, 0);
                this.ega.setVisibility(8);
                this.egf.setVisibility(0);
                this.egb.setVisibility(8);
                this.egf.setText(TbadkCoreApplication.getInst().getResources().getString(d.k.fans_urge_tips));
                if (nH.egk != null && nH.egk.indexOf(String.valueOf(i3)) != -1) {
                    this.egd.setText(ag(nH.egk, i3));
                } else {
                    this.egd.setText(nH.egk);
                }
            } else {
                layoutParams.height = l.e(TbadkCoreApplication.getInst(), d.e.ds80);
                this.egg.setPadding(0, 0, 0, 0);
                this.ega.setVisibility(8);
                this.egf.setVisibility(0);
                this.egb.setVisibility(8);
                this.egd.setText(nH.egk);
                if (this.messageType == 4) {
                    this.ege.setText(nH.threadTitle);
                    this.egf.setText(TbadkCoreApplication.getInst().getResources().getString(d.k.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.ege.setText(nH.threadTitle);
                    this.egh.setText(d.k.look_normal_thread);
                    this.egf.setText(TbadkCoreApplication.getInst().getResources().getString(d.k.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(nH.portrait)) {
                this.ega.startLoad(nH.portrait, 12, false);
            } else {
                this.ega.startLoad(null, 12, false);
            }
            this.egc.setText(ao.v(nH.egj));
        }
    }

    private SpannableStringBuilder ag(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int nw = nw(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0141d.cp_link_tip_d)), indexOf, nw + indexOf, 33);
        return spannableStringBuilder;
    }

    private int nw(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
