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
    protected TextView dsk;
    protected com.baidu.adp.lib.c.a erF;
    protected com.baidu.adp.lib.c.b erG;
    protected int erP;
    private Calendar esa;
    protected long esb;
    protected Long esc;
    protected TbRichTextView esd;
    protected ChatVoiceView ese;
    protected GifView esf;
    protected Invite2GroupView esg;
    protected ShareFromPBView esh;
    protected ShareFromFrsView esi;
    protected ShareFromGameCenter esj;
    protected ChatImageWithTailView esk;
    protected boolean esl;
    protected boolean esm;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.erF = null;
        this.erG = null;
        this.mPosition = 0;
        this.esb = 0L;
        this.esc = null;
        this.esl = true;
        this.esm = false;
        this.mLastTime = 0L;
        this.esa = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.erF = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.erG = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bR(long j) {
        this.mLastTime = j;
    }

    public void bS(long j) {
        this.esa = Calendar.getInstance();
        this.esa.setTimeInMillis(1000 * j);
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
        if (this.esa != null && this.esa.get(1) == calendar.get(1) && this.esa.get(6) == calendar.get(6)) {
            return am.b(calendar.getTime());
        }
        return am.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.esc = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dsk = (TextView) findViewById(d.g.tex_msgitem_time);
        this.esd = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.esd.setLinkTextColor(-14845754);
        this.esk = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.esg = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.esh = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.esi = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.esj = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.ese = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.ese.setClickable(true);
        this.ese.setOnClickListener(this.ese);
        this.ese.setLongClickable(true);
        this.ese.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erG.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.esk.getImage().setClickable(true);
        this.esk.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erF.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.esk.getImage().setLongClickable(true);
        this.esk.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erG.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.esk.getTail().setClickable(true);
        this.esk.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erF.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.esd.setLongClickable(true);
        this.esd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erG.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.esf = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.esf.setSupportNoImage(false);
        this.esf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erF.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.esf.setLongClickable(true);
        this.esf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erG.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.esh.setClickable(true);
        this.esh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erF.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.esh.setLongClickable(true);
        this.esh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erG.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.esi.setClickable(true);
        this.esi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erF.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.esi.setLongClickable(true);
        this.esi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erG.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.esj.getContentBody().setClickable(true);
        this.esj.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erF.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.esj.getTail().setClickable(true);
        this.esj.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erF.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.esj.getContentBody().setLongClickable(true);
        this.esj.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erG.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.esg != null) {
            this.esg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.erG.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pH(int i) {
        this.esk.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bT = bT(chatMessage.getTime());
        if (z || bT) {
            this.dsk.setVisibility(0);
            this.dsk.setText(bU(chatMessage.getTime()));
        } else {
            this.dsk.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.esd, chatMessage, str, this.erP);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.esd.setContentDescription(stringBuffer.toString());
            this.esd.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.esk, chatMessage, this.esb, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.ese, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.esf, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.esg, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.esh, this.esi, this.esj, chatMessage, str);
    }

    public void gT(boolean z) {
        this.esl = z;
    }

    public void gU(boolean z) {
        this.esm = z;
    }

    public void pG(int i) {
        this.erP = i;
    }
}
