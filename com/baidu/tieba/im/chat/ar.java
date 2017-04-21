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
    protected int atz;
    protected TextView bLE;
    protected com.baidu.adp.lib.c.a cPJ;
    protected com.baidu.adp.lib.c.b cPK;
    protected int cPT;
    private long cQe;
    private Calendar cQf;
    protected long cQg;
    protected Long cQh;
    protected TbRichTextView cQi;
    protected ChatVoiceView cQj;
    protected GifView cQk;
    protected Invite2GroupView cQl;
    protected ShareFromPBView cQm;
    protected ShareFromFrsView cQn;
    protected ShareFromGameCenter cQo;
    protected ChatImageWithTailView cQp;
    protected boolean cQq;
    protected boolean cQr;

    public ar(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.cPJ = null;
        this.cPK = null;
        this.atz = 0;
        this.cQg = 0L;
        this.cQh = null;
        this.cQq = true;
        this.cQr = false;
        this.cQe = 0L;
        this.cQf = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.cPJ = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.cPK = bVar;
    }

    public void setPosition(int i) {
        this.atz = i;
    }

    public void bx(long j) {
        this.cQe = j;
    }

    public void by(long j) {
        this.cQf = Calendar.getInstance();
        this.cQf.setTimeInMillis(1000 * j);
    }

    private boolean bz(long j) {
        if (j < 1000) {
            return false;
        }
        return this.cQe == 0 || j - this.cQe >= 180;
    }

    private String bA(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.cQf != null && this.cQf.get(1) == calendar.get(1) && this.cQf.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.au.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.au.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.cQh = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bLE = (TextView) findViewById(w.h.tex_msgitem_time);
        this.cQi = (TbRichTextView) findViewById(w.h.tex_msgitem_text);
        this.cQi.setLinkTextColor(-14845754);
        this.cQp = (ChatImageWithTailView) findViewById(w.h.img_msgitem_image);
        this.cQl = (Invite2GroupView) findViewById(w.h.lay_msgitem_invite_view);
        this.cQm = (ShareFromPBView) findViewById(w.h.lay_msgitem_share_view);
        this.cQn = (ShareFromFrsView) findViewById(w.h.lay_msgitem_share_frs);
        this.cQo = (ShareFromGameCenter) findViewById(w.h.lay_msgitem_share_game);
        this.cQj = (ChatVoiceView) findViewById(w.h.lay_msgitem_voice);
        this.cQj.setClickable(true);
        this.cQj.setOnClickListener(this.cQj);
        this.cQj.setLongClickable(true);
        this.cQj.setOnLongClickListener(new as(this));
        this.cQp.getImage().setClickable(true);
        this.cQp.getImage().setOnClickListener(new az(this));
        this.cQp.getImage().setLongClickable(true);
        this.cQp.getImage().setOnLongClickListener(new ba(this));
        this.cQp.getTail().setClickable(true);
        this.cQp.getTail().setOnClickListener(new bb(this));
        this.cQi.setLongClickable(true);
        this.cQi.setOnLongClickListener(new bc(this));
        this.cQk = (GifView) findViewById(w.h.emotion_msgitem_image);
        this.cQk.setSupportNoImage(false);
        this.cQk.setOnClickListener(new bd(this));
        this.cQk.setLongClickable(true);
        this.cQk.setOnLongClickListener(new be(this));
        this.cQm.setClickable(true);
        this.cQm.setOnClickListener(new bf(this));
        this.cQm.setLongClickable(true);
        this.cQm.setOnLongClickListener(new bg(this));
        this.cQn.setClickable(true);
        this.cQn.setOnClickListener(new at(this));
        this.cQn.setLongClickable(true);
        this.cQn.setOnLongClickListener(new au(this));
        this.cQo.getContentBody().setClickable(true);
        this.cQo.getContentBody().setOnClickListener(new av(this));
        this.cQo.getTail().setClickable(true);
        this.cQo.getTail().setOnClickListener(new aw(this));
        this.cQo.getContentBody().setLongClickable(true);
        this.cQo.getContentBody().setOnLongClickListener(new ax(this));
        if (this.cQl != null) {
            this.cQl.setOnLongClickListener(new ay(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lk(int i) {
        this.cQp.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bz = bz(chatMessage.getTime());
        if (z || bz) {
            this.bLE.setVisibility(0);
            this.bLE.setText(bA(chatMessage.getTime()));
        } else {
            this.bLE.setVisibility(8);
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
        bq.a(this.mContext.getContext(), this.cQi, chatMessage, str, this.cPT);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.cQi.setContentDescription(stringBuffer.toString());
            this.cQi.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cQp, chatMessage, this.cQg, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.cQj, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bq.a(this.mContext.getContext(), this.cQk, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bq.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.cQl, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cQm, this.cQn, this.cQo, chatMessage, str);
    }

    public void fA(boolean z) {
        this.cQq = z;
    }

    public void fB(boolean z) {
        this.cQr = z;
    }

    public void lj(int i) {
        this.cPT = i;
    }
}
