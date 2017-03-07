package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.ShareFromFrsView;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import com.baidu.tieba.w;
import java.util.Calendar;
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.base.d<MsglistActivity<?>> {
    protected int ath;
    protected TextView bJu;
    protected com.baidu.adp.lib.c.a cOV;
    protected com.baidu.adp.lib.c.b cOW;
    protected ShareFromGameCenter cPA;
    protected ChatImageWithTailView cPB;
    protected boolean cPC;
    protected boolean cPD;
    protected int cPf;
    private long cPq;
    private Calendar cPr;
    protected long cPs;
    protected Long cPt;
    protected TbRichTextView cPu;
    protected ChatVoiceView cPv;
    protected GifView cPw;
    protected Invite2GroupView cPx;
    protected ShareFromPBView cPy;
    protected ShareFromFrsView cPz;

    public ar(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.cOV = null;
        this.cOW = null;
        this.ath = 0;
        this.cPs = 0L;
        this.cPt = null;
        this.cPC = true;
        this.cPD = false;
        this.cPq = 0L;
        this.cPr = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.cOV = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.cOW = bVar;
    }

    public void setPosition(int i) {
        this.ath = i;
    }

    public void bx(long j) {
        this.cPq = j;
    }

    public void by(long j) {
        this.cPr = Calendar.getInstance();
        this.cPr.setTimeInMillis(1000 * j);
    }

    private boolean bz(long j) {
        if (j < 1000) {
            return false;
        }
        return this.cPq == 0 || j - this.cPq >= 180;
    }

    private String bA(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.cPr != null && this.cPr.get(1) == calendar.get(1) && this.cPr.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.au.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.au.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.cPt = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bJu = (TextView) findViewById(w.h.tex_msgitem_time);
        this.cPu = (TbRichTextView) findViewById(w.h.tex_msgitem_text);
        this.cPu.setLinkTextColor(-14845754);
        this.cPB = (ChatImageWithTailView) findViewById(w.h.img_msgitem_image);
        this.cPx = (Invite2GroupView) findViewById(w.h.lay_msgitem_invite_view);
        this.cPy = (ShareFromPBView) findViewById(w.h.lay_msgitem_share_view);
        this.cPz = (ShareFromFrsView) findViewById(w.h.lay_msgitem_share_frs);
        this.cPA = (ShareFromGameCenter) findViewById(w.h.lay_msgitem_share_game);
        this.cPv = (ChatVoiceView) findViewById(w.h.lay_msgitem_voice);
        this.cPv.setClickable(true);
        this.cPv.setOnClickListener(this.cPv);
        this.cPv.setLongClickable(true);
        this.cPv.setOnLongClickListener(new as(this));
        this.cPB.getImage().setClickable(true);
        this.cPB.getImage().setOnClickListener(new az(this));
        this.cPB.getImage().setLongClickable(true);
        this.cPB.getImage().setOnLongClickListener(new ba(this));
        this.cPB.getTail().setClickable(true);
        this.cPB.getTail().setOnClickListener(new bb(this));
        this.cPu.setLongClickable(true);
        this.cPu.setOnLongClickListener(new bc(this));
        this.cPw = (GifView) findViewById(w.h.emotion_msgitem_image);
        this.cPw.setSupportNoImage(false);
        this.cPw.setOnClickListener(new bd(this));
        this.cPw.setLongClickable(true);
        this.cPw.setOnLongClickListener(new be(this));
        this.cPy.setClickable(true);
        this.cPy.setOnClickListener(new bf(this));
        this.cPy.setLongClickable(true);
        this.cPy.setOnLongClickListener(new bg(this));
        this.cPz.setClickable(true);
        this.cPz.setOnClickListener(new at(this));
        this.cPz.setLongClickable(true);
        this.cPz.setOnLongClickListener(new au(this));
        this.cPA.getContentBody().setClickable(true);
        this.cPA.getContentBody().setOnClickListener(new av(this));
        this.cPA.getTail().setClickable(true);
        this.cPA.getTail().setOnClickListener(new aw(this));
        this.cPA.getContentBody().setLongClickable(true);
        this.cPA.getContentBody().setOnLongClickListener(new ax(this));
        if (this.cPx != null) {
            this.cPx.setOnLongClickListener(new ay(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ld(int i) {
        this.cPB.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bz = bz(chatMessage.getTime());
        if (z || bz) {
            this.bJu.setVisibility(0);
            this.bJu.setText(bA(chatMessage.getTime()));
        } else {
            this.bJu.setVisibility(8);
        }
        if (!z && bz) {
            MsgCacheData cacheData = chatMessage.getCacheData();
            if (cacheData == null) {
                MsgCacheData msgCacheData = new MsgCacheData();
                msgCacheData.setIs_show_time(1);
                chatMessage.setCacheData(msgCacheData);
                return;
            }
            cacheData.setIs_show_time(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.cPu, chatMessage, str, this.cPf);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.cPu.setContentDescription(stringBuffer.toString());
            this.cPu.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cPB, chatMessage, this.cPs, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.cPv, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bq.a(this.mContext.getContext(), this.cPw, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bq.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.cPx, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cPy, this.cPz, this.cPA, chatMessage, str);
    }

    public void fq(boolean z) {
        this.cPC = z;
    }

    public void fr(boolean z) {
        this.cPD = z;
    }

    public void lc(int i) {
        this.cPf = i;
    }
}
