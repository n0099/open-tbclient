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
    protected TextView cyQ;
    protected com.baidu.adp.lib.c.a dDJ;
    protected com.baidu.adp.lib.c.b dDK;
    protected int dDT;
    private Calendar dEe;
    protected long dEf;
    protected Long dEg;
    protected TbRichTextView dEh;
    protected ChatVoiceView dEi;
    protected GifView dEj;
    protected Invite2GroupView dEk;
    protected ShareFromPBView dEl;
    protected ShareFromFrsView dEm;
    protected ShareFromGameCenter dEn;
    protected ChatImageWithTailView dEo;
    protected boolean dEp;
    protected boolean dEq;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.dDJ = null;
        this.dDK = null;
        this.mPosition = 0;
        this.dEf = 0L;
        this.dEg = null;
        this.dEp = true;
        this.dEq = false;
        this.mLastTime = 0L;
        this.dEe = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dDJ = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dDK = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bI(long j) {
        this.mLastTime = j;
    }

    public void bJ(long j) {
        this.dEe = Calendar.getInstance();
        this.dEe.setTimeInMillis(1000 * j);
    }

    private boolean bK(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String bL(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.dEe != null && this.dEe.get(1) == calendar.get(1) && this.dEe.get(6) == calendar.get(6)) {
            return am.b(calendar.getTime());
        }
        return am.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.dEg = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cyQ = (TextView) findViewById(d.g.tex_msgitem_time);
        this.dEh = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.dEh.setLinkTextColor(-14845754);
        this.dEo = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.dEk = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.dEl = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.dEm = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.dEn = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.dEi = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.dEi.setClickable(true);
        this.dEi.setOnClickListener(this.dEi);
        this.dEi.setLongClickable(true);
        this.dEi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dDK.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dEo.getImage().setClickable(true);
        this.dEo.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dDJ.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.dEo.getImage().setLongClickable(true);
        this.dEo.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dDK.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dEo.getTail().setClickable(true);
        this.dEo.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dDJ.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.dEh.setLongClickable(true);
        this.dEh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dDK.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dEj = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.dEj.setSupportNoImage(false);
        this.dEj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dDJ.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.dEj.setLongClickable(true);
        this.dEj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dDK.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dEl.setClickable(true);
        this.dEl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dDJ.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.dEl.setLongClickable(true);
        this.dEl.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dDK.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dEm.setClickable(true);
        this.dEm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dDJ.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.dEm.setLongClickable(true);
        this.dEm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dDK.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dEn.getContentBody().setClickable(true);
        this.dEn.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dDJ.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.dEn.getTail().setClickable(true);
        this.dEn.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dDJ.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.dEn.getContentBody().setLongClickable(true);
        this.dEn.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dDK.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.dEk != null) {
            this.dEk.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.dDK.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mW(int i) {
        this.dEo.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bK = bK(chatMessage.getTime());
        if (z || bK) {
            this.cyQ.setVisibility(0);
            this.cyQ.setText(bL(chatMessage.getTime()));
        } else {
            this.cyQ.setVisibility(8);
        }
        if (!z && bK) {
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
        j.a(this.mContext.getContext(), this.dEh, chatMessage, str, this.dDT);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.dEh.setContentDescription(stringBuffer.toString());
            this.dEh.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dEo, chatMessage, this.dEf, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.dEi, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.dEj, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.dEk, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dEl, this.dEm, this.dEn, chatMessage, str);
    }

    public void go(boolean z) {
        this.dEp = z;
    }

    public void gp(boolean z) {
        this.dEq = z;
    }

    public void mV(int i) {
        this.dDT = i;
    }
}
