package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.base.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.ShareFromFrsView;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class g extends b<MsglistActivity<?>> {
    protected TextView dno;
    protected com.baidu.adp.lib.c.a epM;
    protected com.baidu.adp.lib.c.b epN;
    protected int epW;
    private Calendar eqh;
    protected long eqi;
    protected Long eqj;
    protected TbRichTextView eqk;
    protected ChatVoiceView eql;
    protected GifView eqm;
    protected Invite2GroupView eqn;
    protected ShareFromPBView eqo;
    protected ShareFromFrsView eqp;
    protected ShareFromGameCenter eqq;
    protected ChatImageWithTailView eqr;
    protected boolean eqs;
    protected boolean eqt;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.epM = null;
        this.epN = null;
        this.mPosition = 0;
        this.eqi = 0L;
        this.eqj = null;
        this.eqs = true;
        this.eqt = false;
        this.mLastTime = 0L;
        this.eqh = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.epM = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.epN = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bR(long j) {
        this.mLastTime = j;
    }

    public void bS(long j) {
        this.eqh = Calendar.getInstance();
        this.eqh.setTimeInMillis(1000 * j);
    }

    private boolean bT(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String bU(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.eqh != null && this.eqh.get(1) == calendar.get(1) && this.eqh.get(6) == calendar.get(6)) {
            return am.b(calendar.getTime());
        }
        return am.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.eqj = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dno = (TextView) findViewById(d.g.tex_msgitem_time);
        this.eqk = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.eqk.setLinkTextColor(-14845754);
        this.eqr = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.eqn = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.eqo = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.eqp = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.eqq = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.eql = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.eql.setClickable(true);
        this.eql.setOnClickListener(this.eql);
        this.eql.setLongClickable(true);
        this.eql.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.epN.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eqr.getImage().setClickable(true);
        this.eqr.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.epM.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.eqr.getImage().setLongClickable(true);
        this.eqr.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.epN.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eqr.getTail().setClickable(true);
        this.eqr.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.epM.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.eqk.setLongClickable(true);
        this.eqk.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.epN.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eqm = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.eqm.setSupportNoImage(false);
        this.eqm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.epM.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.eqm.setLongClickable(true);
        this.eqm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.epN.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eqo.setClickable(true);
        this.eqo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.epM.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.eqo.setLongClickable(true);
        this.eqo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.epN.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eqp.setClickable(true);
        this.eqp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.epM.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.eqp.setLongClickable(true);
        this.eqp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.epN.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eqq.getContentBody().setClickable(true);
        this.eqq.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.epM.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.eqq.getTail().setClickable(true);
        this.eqq.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.epM.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.eqq.getContentBody().setLongClickable(true);
        this.eqq.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.epN.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.eqn != null) {
            this.eqn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.epN.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pO(int i) {
        this.eqr.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bT = bT(chatMessage.getTime());
        if (z || bT) {
            this.dno.setVisibility(0);
            this.dno.setText(bU(chatMessage.getTime()));
        } else {
            this.dno.setVisibility(8);
        }
        if (!z && bT) {
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
        j.a(this.mContext.getContext(), this.eqk, chatMessage, str, this.epW);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.eqk.setContentDescription(stringBuffer.toString());
            this.eqk.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eqr, chatMessage, this.eqi, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.eql, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.eqm, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.eqn, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eqo, this.eqp, this.eqq, chatMessage, str);
    }

    public void gN(boolean z) {
        this.eqs = z;
    }

    public void gO(boolean z) {
        this.eqt = z;
    }

    public void pN(int i) {
        this.epW = i;
    }
}
