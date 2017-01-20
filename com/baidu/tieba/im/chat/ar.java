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
import com.baidu.tieba.r;
import java.util.Calendar;
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.base.d<MsglistActivity<?>> {
    protected int anM;
    protected TextView bCn;
    protected com.baidu.adp.lib.c.a cMG;
    protected com.baidu.adp.lib.c.b cMH;
    protected int cMQ;
    private long cNb;
    private Calendar cNc;
    protected long cNd;
    protected Long cNe;
    protected TbRichTextView cNf;
    protected ChatVoiceView cNg;
    protected GifView cNh;
    protected Invite2GroupView cNi;
    protected ShareFromPBView cNj;
    protected ShareFromFrsView cNk;
    protected ShareFromGameCenter cNl;
    protected ChatImageWithTailView cNm;
    protected boolean cNn;
    protected boolean cNo;

    public ar(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.cMG = null;
        this.cMH = null;
        this.anM = 0;
        this.cNd = 0L;
        this.cNe = null;
        this.cNn = true;
        this.cNo = false;
        this.cNb = 0L;
        this.cNc = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.cMG = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.cMH = bVar;
    }

    public void setPosition(int i) {
        this.anM = i;
    }

    public void bw(long j) {
        this.cNb = j;
    }

    public void bx(long j) {
        this.cNc = Calendar.getInstance();
        this.cNc.setTimeInMillis(1000 * j);
    }

    private boolean by(long j) {
        if (j < 1000) {
            return false;
        }
        return this.cNb == 0 || j - this.cNb >= 180;
    }

    private String bz(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.cNc != null && this.cNc.get(1) == calendar.get(1) && this.cNc.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.at.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.at.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.cNe = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bCn = (TextView) findViewById(r.h.tex_msgitem_time);
        this.cNf = (TbRichTextView) findViewById(r.h.tex_msgitem_text);
        this.cNf.setLinkTextColor(-14845754);
        this.cNm = (ChatImageWithTailView) findViewById(r.h.img_msgitem_image);
        this.cNi = (Invite2GroupView) findViewById(r.h.lay_msgitem_invite_view);
        this.cNj = (ShareFromPBView) findViewById(r.h.lay_msgitem_share_view);
        this.cNk = (ShareFromFrsView) findViewById(r.h.lay_msgitem_share_frs);
        this.cNl = (ShareFromGameCenter) findViewById(r.h.lay_msgitem_share_game);
        this.cNg = (ChatVoiceView) findViewById(r.h.lay_msgitem_voice);
        this.cNg.setClickable(true);
        this.cNg.setOnClickListener(this.cNg);
        this.cNg.setLongClickable(true);
        this.cNg.setOnLongClickListener(new as(this));
        this.cNm.getImage().setClickable(true);
        this.cNm.getImage().setOnClickListener(new az(this));
        this.cNm.getImage().setLongClickable(true);
        this.cNm.getImage().setOnLongClickListener(new ba(this));
        this.cNm.getTail().setClickable(true);
        this.cNm.getTail().setOnClickListener(new bb(this));
        this.cNf.setLongClickable(true);
        this.cNf.setOnLongClickListener(new bc(this));
        this.cNh = (GifView) findViewById(r.h.emotion_msgitem_image);
        this.cNh.setSupportNoImage(false);
        this.cNh.setOnClickListener(new bd(this));
        this.cNh.setLongClickable(true);
        this.cNh.setOnLongClickListener(new be(this));
        this.cNj.setClickable(true);
        this.cNj.setOnClickListener(new bf(this));
        this.cNj.setLongClickable(true);
        this.cNj.setOnLongClickListener(new bg(this));
        this.cNk.setClickable(true);
        this.cNk.setOnClickListener(new at(this));
        this.cNk.setLongClickable(true);
        this.cNk.setOnLongClickListener(new au(this));
        this.cNl.getContentBody().setClickable(true);
        this.cNl.getContentBody().setOnClickListener(new av(this));
        this.cNl.getTail().setClickable(true);
        this.cNl.getTail().setOnClickListener(new aw(this));
        this.cNl.getContentBody().setLongClickable(true);
        this.cNl.getContentBody().setOnLongClickListener(new ax(this));
        if (this.cNi != null) {
            this.cNi.setOnLongClickListener(new ay(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ln(int i) {
        this.cNm.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean by = by(chatMessage.getTime());
        if (z || by) {
            this.bCn.setVisibility(0);
            this.bCn.setText(bz(chatMessage.getTime()));
        } else {
            this.bCn.setVisibility(8);
        }
        if (!z && by) {
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
        bq.a(this.mContext.getContext(), this.cNf, chatMessage, str, this.cMQ);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.cNf.setContentDescription(stringBuffer.toString());
            this.cNf.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cNm, chatMessage, this.cNd, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.cNg, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bq.a(this.mContext.getContext(), this.cNh, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bq.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.cNi, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cNj, this.cNk, this.cNl, chatMessage, str);
    }

    public void fA(boolean z) {
        this.cNn = z;
    }

    public void fB(boolean z) {
        this.cNo = z;
    }

    public void lm(int i) {
        this.cMQ = i;
    }
}
