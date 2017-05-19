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
    protected int atD;
    protected TextView bKI;
    protected com.baidu.adp.lib.c.a cJM;
    protected com.baidu.adp.lib.c.b cJN;
    protected int cJW;
    private Calendar cKh;
    protected long cKi;
    protected Long cKj;
    protected TbRichTextView cKk;
    protected ChatVoiceView cKl;
    protected GifView cKm;
    protected Invite2GroupView cKn;
    protected ShareFromPBView cKo;
    protected ShareFromFrsView cKp;
    protected ShareFromGameCenter cKq;
    protected ChatImageWithTailView cKr;
    protected boolean cKs;
    protected boolean cKt;
    private long mLastTime;

    public ar(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.cJM = null;
        this.cJN = null;
        this.atD = 0;
        this.cKi = 0L;
        this.cKj = null;
        this.cKs = true;
        this.cKt = false;
        this.mLastTime = 0L;
        this.cKh = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.cJM = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.cJN = bVar;
    }

    public void setPosition(int i) {
        this.atD = i;
    }

    public void bi(long j) {
        this.mLastTime = j;
    }

    public void bj(long j) {
        this.cKh = Calendar.getInstance();
        this.cKh.setTimeInMillis(1000 * j);
    }

    private boolean bk(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String bl(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.cKh != null && this.cKh.get(1) == calendar.get(1) && this.cKh.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.au.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.au.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.cKj = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bKI = (TextView) findViewById(w.h.tex_msgitem_time);
        this.cKk = (TbRichTextView) findViewById(w.h.tex_msgitem_text);
        this.cKk.setLinkTextColor(-14845754);
        this.cKr = (ChatImageWithTailView) findViewById(w.h.img_msgitem_image);
        this.cKn = (Invite2GroupView) findViewById(w.h.lay_msgitem_invite_view);
        this.cKo = (ShareFromPBView) findViewById(w.h.lay_msgitem_share_view);
        this.cKp = (ShareFromFrsView) findViewById(w.h.lay_msgitem_share_frs);
        this.cKq = (ShareFromGameCenter) findViewById(w.h.lay_msgitem_share_game);
        this.cKl = (ChatVoiceView) findViewById(w.h.lay_msgitem_voice);
        this.cKl.setClickable(true);
        this.cKl.setOnClickListener(this.cKl);
        this.cKl.setLongClickable(true);
        this.cKl.setOnLongClickListener(new as(this));
        this.cKr.getImage().setClickable(true);
        this.cKr.getImage().setOnClickListener(new az(this));
        this.cKr.getImage().setLongClickable(true);
        this.cKr.getImage().setOnLongClickListener(new ba(this));
        this.cKr.getTail().setClickable(true);
        this.cKr.getTail().setOnClickListener(new bb(this));
        this.cKk.setLongClickable(true);
        this.cKk.setOnLongClickListener(new bc(this));
        this.cKm = (GifView) findViewById(w.h.emotion_msgitem_image);
        this.cKm.setSupportNoImage(false);
        this.cKm.setOnClickListener(new bd(this));
        this.cKm.setLongClickable(true);
        this.cKm.setOnLongClickListener(new be(this));
        this.cKo.setClickable(true);
        this.cKo.setOnClickListener(new bf(this));
        this.cKo.setLongClickable(true);
        this.cKo.setOnLongClickListener(new bg(this));
        this.cKp.setClickable(true);
        this.cKp.setOnClickListener(new at(this));
        this.cKp.setLongClickable(true);
        this.cKp.setOnLongClickListener(new au(this));
        this.cKq.getContentBody().setClickable(true);
        this.cKq.getContentBody().setOnClickListener(new av(this));
        this.cKq.getTail().setClickable(true);
        this.cKq.getTail().setOnClickListener(new aw(this));
        this.cKq.getContentBody().setLongClickable(true);
        this.cKq.getContentBody().setOnLongClickListener(new ax(this));
        if (this.cKn != null) {
            this.cKn.setOnLongClickListener(new ay(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kX(int i) {
        this.cKr.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bk = bk(chatMessage.getTime());
        if (z || bk) {
            this.bKI.setVisibility(0);
            this.bKI.setText(bl(chatMessage.getTime()));
        } else {
            this.bKI.setVisibility(8);
        }
        if (!z && bk) {
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
        bq.a(this.mContext.getContext(), this.cKk, chatMessage, str, this.cJW);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.cKk.setContentDescription(stringBuffer.toString());
            this.cKk.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cKr, chatMessage, this.cKi, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.cKl, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bq.a(this.mContext.getContext(), this.cKm, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bq.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.cKn, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cKo, this.cKp, this.cKq, chatMessage, str);
    }

    public void fb(boolean z) {
        this.cKs = z;
    }

    public void fc(boolean z) {
        this.cKt = z;
    }

    public void kW(int i) {
        this.cJW = i;
    }
}
