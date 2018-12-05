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
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.chat.photolive.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.tbadkCore.util.c;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class MsgPhotoLiveCardVew extends g {
    private LinearLayout eKX;
    private ClickableHeaderImageView eKY;
    private TextView eKZ;
    private TextView eLa;
    private TextView eLb;
    private TextView eLc;
    private TextView eLd;
    private LinearLayout eLe;
    private TextView eLf;
    private int messageType;
    private int paddingLeft;
    private long postId;
    private long threadId;

    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_photolive_card_view);
        this.threadId = 0L;
        this.postId = 0L;
        this.messageType = 0;
        this.paddingLeft = 0;
        this.paddingLeft = l.h(tbPageContext.getContext(), e.C0210e.ds24);
        init();
    }

    private void init() {
        this.eKX = (LinearLayout) findViewById(e.g.msg_photolive_card);
        this.eKY = (ClickableHeaderImageView) findViewById(e.g.author_portrait);
        this.eKZ = (TextView) findViewById(e.g.author_name);
        this.eLa = (TextView) findViewById(e.g.call_time);
        this.eLb = (TextView) findViewById(e.g.call_content);
        this.eLc = (TextView) findViewById(e.g.call_thread_title);
        this.eLe = (LinearLayout) findViewById(e.g.auhtor_name_and_call_time);
        this.eLd = (TextView) findViewById(e.g.remind_title);
        this.eLf = (TextView) findViewById(e.g.card_bottom_chakanzhibo);
        this.eKX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.1
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
                        if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.vP(String.valueOf(MsgPhotoLiveCardVew.this.threadId)) > 0) {
                            MsgPhotoLiveCardVew.this.postId = photoLiveReadThreadHistory.vP(String.valueOf(MsgPhotoLiveCardVew.this.threadId));
                        }
                    }
                    MsgPhotoLiveCardVew.this.pF(MsgPhotoLiveCardVew.this.messageType);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pF(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.threadId), null, "message_tab")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(View view) {
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
            a.C0244a py = a.py(chatMessage.getContent());
            if (py == null) {
                this.threadId = 0L;
                return;
            }
            this.threadId = py.threadId;
            this.postId = py.postId;
            this.messageType = py.msgType;
            int i3 = py.eLj;
            ViewGroup.LayoutParams layoutParams = this.eLe.getLayoutParams();
            if (this.messageType == 1 || this.messageType == 6) {
                if (this.messageType == 1) {
                    str = py.threadTitle;
                    i = e.j.look_live_thread;
                } else {
                    String decode = URLDecoder.decode(py.threadTitle);
                    i = e.j.look_god_thread;
                    str = decode;
                    i2 = 0;
                }
                this.eLc.setText(str);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds72);
                this.eLe.setPadding(this.paddingLeft, 0, 0, 0);
                this.eKY.setVisibility(0);
                this.eKY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.photolive.MsgPhotoLiveCardVew.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgPhotoLiveCardVew.this.bf(view2);
                    }
                });
                this.eKY.setTag(py.userId);
                this.eKY.setGodIconMargin(i2);
                this.eLd.setVisibility(8);
                this.eKZ.setVisibility(0);
                this.eKZ.setText(py.userName);
                this.eLb.setText(py.eLi);
                this.eKZ.setTextSize(0, l.h(TbadkCoreApplication.getInst(), e.C0210e.fontsize28));
                this.eLf.setText(i);
            } else if (this.messageType == 3) {
                this.eLc.setText(py.threadTitle);
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds80);
                this.eLe.setPadding(0, 0, 0, 0);
                this.eKY.setVisibility(8);
                this.eLd.setVisibility(0);
                this.eKZ.setVisibility(8);
                this.eLd.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.fans_urge_tips));
                if (py.eLi != null && py.eLi.indexOf(String.valueOf(i3)) != -1) {
                    this.eLb.setText(al(py.eLi, i3));
                } else {
                    this.eLb.setText(py.eLi);
                }
            } else {
                layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds80);
                this.eLe.setPadding(0, 0, 0, 0);
                this.eKY.setVisibility(8);
                this.eLd.setVisibility(0);
                this.eKZ.setVisibility(8);
                this.eLb.setText(py.eLi);
                if (this.messageType == 4) {
                    this.eLc.setText(py.threadTitle);
                    this.eLd.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.upgrade_to_photo_live_tips));
                } else if (this.messageType == 5) {
                    this.eLc.setText(py.threadTitle);
                    this.eLf.setText(e.j.look_normal_thread);
                    this.eLd.setText(TbadkCoreApplication.getInst().getResources().getString(e.j.change_to_old_thread_msg_tips));
                }
            }
            if (!TextUtils.isEmpty(py.portrait)) {
                this.eKY.startLoad(py.portrait, 12, false);
            } else {
                this.eKY.startLoad(null, 12, false);
            }
            this.eLa.setText(ao.L(py.eLh));
        }
    }

    private SpannableStringBuilder al(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int pG = pG(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)), indexOf, pG + indexOf, 33);
        return spannableStringBuilder;
    }

    private int pG(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }
}
