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
    protected int atx;
    protected TextView bJn;
    protected int cNC;
    private long cNN;
    private Calendar cNO;
    protected long cNP;
    protected Long cNQ;
    protected TbRichTextView cNR;
    protected ChatVoiceView cNS;
    protected GifView cNT;
    protected Invite2GroupView cNU;
    protected ShareFromPBView cNV;
    protected ShareFromFrsView cNW;
    protected ShareFromGameCenter cNX;
    protected ChatImageWithTailView cNY;
    protected boolean cNZ;
    protected com.baidu.adp.lib.c.a cNs;
    protected com.baidu.adp.lib.c.b cNt;
    protected boolean cOa;

    public ar(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.cNs = null;
        this.cNt = null;
        this.atx = 0;
        this.cNP = 0L;
        this.cNQ = null;
        this.cNZ = true;
        this.cOa = false;
        this.cNN = 0L;
        this.cNO = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.cNs = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.cNt = bVar;
    }

    public void setPosition(int i) {
        this.atx = i;
    }

    public void bx(long j) {
        this.cNN = j;
    }

    public void by(long j) {
        this.cNO = Calendar.getInstance();
        this.cNO.setTimeInMillis(1000 * j);
    }

    private boolean bz(long j) {
        if (j < 1000) {
            return false;
        }
        return this.cNN == 0 || j - this.cNN >= 180;
    }

    private String bA(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.cNO != null && this.cNO.get(1) == calendar.get(1) && this.cNO.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.au.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.au.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.cNQ = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bJn = (TextView) findViewById(w.h.tex_msgitem_time);
        this.cNR = (TbRichTextView) findViewById(w.h.tex_msgitem_text);
        this.cNR.setLinkTextColor(-14845754);
        this.cNY = (ChatImageWithTailView) findViewById(w.h.img_msgitem_image);
        this.cNU = (Invite2GroupView) findViewById(w.h.lay_msgitem_invite_view);
        this.cNV = (ShareFromPBView) findViewById(w.h.lay_msgitem_share_view);
        this.cNW = (ShareFromFrsView) findViewById(w.h.lay_msgitem_share_frs);
        this.cNX = (ShareFromGameCenter) findViewById(w.h.lay_msgitem_share_game);
        this.cNS = (ChatVoiceView) findViewById(w.h.lay_msgitem_voice);
        this.cNS.setClickable(true);
        this.cNS.setOnClickListener(this.cNS);
        this.cNS.setLongClickable(true);
        this.cNS.setOnLongClickListener(new as(this));
        this.cNY.getImage().setClickable(true);
        this.cNY.getImage().setOnClickListener(new az(this));
        this.cNY.getImage().setLongClickable(true);
        this.cNY.getImage().setOnLongClickListener(new ba(this));
        this.cNY.getTail().setClickable(true);
        this.cNY.getTail().setOnClickListener(new bb(this));
        this.cNR.setLongClickable(true);
        this.cNR.setOnLongClickListener(new bc(this));
        this.cNT = (GifView) findViewById(w.h.emotion_msgitem_image);
        this.cNT.setSupportNoImage(false);
        this.cNT.setOnClickListener(new bd(this));
        this.cNT.setLongClickable(true);
        this.cNT.setOnLongClickListener(new be(this));
        this.cNV.setClickable(true);
        this.cNV.setOnClickListener(new bf(this));
        this.cNV.setLongClickable(true);
        this.cNV.setOnLongClickListener(new bg(this));
        this.cNW.setClickable(true);
        this.cNW.setOnClickListener(new at(this));
        this.cNW.setLongClickable(true);
        this.cNW.setOnLongClickListener(new au(this));
        this.cNX.getContentBody().setClickable(true);
        this.cNX.getContentBody().setOnClickListener(new av(this));
        this.cNX.getTail().setClickable(true);
        this.cNX.getTail().setOnClickListener(new aw(this));
        this.cNX.getContentBody().setLongClickable(true);
        this.cNX.getContentBody().setOnLongClickListener(new ax(this));
        if (this.cNU != null) {
            this.cNU.setOnLongClickListener(new ay(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void le(int i) {
        this.cNY.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bz = bz(chatMessage.getTime());
        if (z || bz) {
            this.bJn.setVisibility(0);
            this.bJn.setText(bA(chatMessage.getTime()));
        } else {
            this.bJn.setVisibility(8);
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
        bq.a(this.mContext.getContext(), this.cNR, chatMessage, str, this.cNC);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.cNR.setContentDescription(stringBuffer.toString());
            this.cNR.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cNY, chatMessage, this.cNP, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.cNS, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bq.a(this.mContext.getContext(), this.cNT, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bq.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.cNU, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cNV, this.cNW, this.cNX, chatMessage, str);
    }

    public void fq(boolean z) {
        this.cNZ = z;
    }

    public void fr(boolean z) {
        this.cOa = z;
    }

    public void ld(int i) {
        this.cNC = i;
    }
}
