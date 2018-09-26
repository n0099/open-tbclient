package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
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
public class g extends com.baidu.adp.base.b<MsglistActivity<?>> {
    protected TextView deC;
    protected com.baidu.adp.lib.c.a erQ;
    protected com.baidu.adp.lib.c.b erR;
    protected int esa;
    private Calendar esl;
    protected long esm;
    protected Long esn;
    protected TbRichTextView eso;
    protected ChatVoiceView esp;
    protected GifView esq;
    protected Invite2GroupView esr;
    protected ShareFromPBView ess;
    protected ShareFromFrsView est;
    protected ShareFromGameCenter esu;
    protected ChatImageWithTailView esv;
    protected boolean esw;
    protected boolean esx;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.erQ = null;
        this.erR = null;
        this.mPosition = 0;
        this.esm = 0L;
        this.esn = null;
        this.esw = true;
        this.esx = false;
        this.mLastTime = 0L;
        this.esl = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.erQ = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.erR = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void ca(long j) {
        this.mLastTime = j;
    }

    public void cb(long j) {
        this.esl = Calendar.getInstance();
        this.esl.setTimeInMillis(1000 * j);
    }

    private boolean cc(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String cd(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.esl != null && this.esl.get(1) == calendar.get(1) && this.esl.get(6) == calendar.get(6)) {
            return ao.b(calendar.getTime());
        }
        return ao.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.esn = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.deC = (TextView) findViewById(e.g.tex_msgitem_time);
        this.eso = (TbRichTextView) findViewById(e.g.tex_msgitem_text);
        this.eso.setLinkTextColor(-14845754);
        this.esv = (ChatImageWithTailView) findViewById(e.g.img_msgitem_image);
        this.esr = (Invite2GroupView) findViewById(e.g.lay_msgitem_invite_view);
        this.ess = (ShareFromPBView) findViewById(e.g.lay_msgitem_share_view);
        this.est = (ShareFromFrsView) findViewById(e.g.lay_msgitem_share_frs);
        this.esu = (ShareFromGameCenter) findViewById(e.g.lay_msgitem_share_game);
        this.esp = (ChatVoiceView) findViewById(e.g.lay_msgitem_voice);
        this.esp.setClickable(true);
        this.esp.setOnClickListener(this.esp);
        this.esp.setLongClickable(true);
        this.esp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erR.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.esv.getImage().setClickable(true);
        this.esv.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erQ.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.esv.getImage().setLongClickable(true);
        this.esv.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erR.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.esv.getTail().setClickable(true);
        this.esv.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erQ.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.eso.setLongClickable(true);
        this.eso.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erR.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.esq = (GifView) findViewById(e.g.emotion_msgitem_image);
        this.esq.setSupportNoImage(false);
        this.esq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erQ.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.esq.setLongClickable(true);
        this.esq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erR.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ess.setClickable(true);
        this.ess.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erQ.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.ess.setLongClickable(true);
        this.ess.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erR.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.est.setClickable(true);
        this.est.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erQ.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.est.setLongClickable(true);
        this.est.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erR.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.esu.getContentBody().setClickable(true);
        this.esu.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erQ.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.esu.getTail().setClickable(true);
        this.esu.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erQ.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.esu.getContentBody().setLongClickable(true);
        this.esu.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erR.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.esr != null) {
            this.esr.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.erR.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void or(int i) {
        this.esv.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean cc = cc(chatMessage.getTime());
        if (z || cc) {
            this.deC.setVisibility(0);
            this.deC.setText(cd(chatMessage.getTime()));
        } else {
            this.deC.setVisibility(8);
        }
        if (!z && cc) {
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
        j.a(this.mContext.getContext(), this.eso, chatMessage, str, this.esa);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.eso.setContentDescription(stringBuffer.toString());
            this.eso.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.esv, chatMessage, this.esm, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.esp, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.esq, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.esr, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.ess, this.est, this.esu, chatMessage, str);
    }

    public void hA(boolean z) {
        this.esw = z;
    }

    public void hB(boolean z) {
        this.esx = z;
    }

    public void oq(int i) {
        this.esa = i;
    }
}
