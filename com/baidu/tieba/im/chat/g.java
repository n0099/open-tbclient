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
    protected int auI;
    protected TextView cif;
    protected com.baidu.adp.lib.c.a dmE;
    protected com.baidu.adp.lib.c.b dmF;
    protected int dmO;
    private Calendar dmZ;
    protected long dna;
    protected Long dnb;
    protected TbRichTextView dnc;
    protected ChatVoiceView dnd;
    protected GifView dne;
    protected Invite2GroupView dnf;
    protected ShareFromPBView dng;
    protected ShareFromFrsView dnh;
    protected ShareFromGameCenter dni;
    protected ChatImageWithTailView dnj;
    protected boolean dnk;
    protected boolean dnl;
    private long mLastTime;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.dmE = null;
        this.dmF = null;
        this.auI = 0;
        this.dna = 0L;
        this.dnb = null;
        this.dnk = true;
        this.dnl = false;
        this.mLastTime = 0L;
        this.dmZ = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dmE = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dmF = bVar;
    }

    public void setPosition(int i) {
        this.auI = i;
    }

    public void bz(long j) {
        this.mLastTime = j;
    }

    public void bA(long j) {
        this.dmZ = Calendar.getInstance();
        this.dmZ.setTimeInMillis(1000 * j);
    }

    private boolean bB(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String bC(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.dmZ != null && this.dmZ.get(1) == calendar.get(1) && this.dmZ.get(6) == calendar.get(6)) {
            return am.b(calendar.getTime());
        }
        return am.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.dnb = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cif = (TextView) findViewById(d.h.tex_msgitem_time);
        this.dnc = (TbRichTextView) findViewById(d.h.tex_msgitem_text);
        this.dnc.setLinkTextColor(-14845754);
        this.dnj = (ChatImageWithTailView) findViewById(d.h.img_msgitem_image);
        this.dnf = (Invite2GroupView) findViewById(d.h.lay_msgitem_invite_view);
        this.dng = (ShareFromPBView) findViewById(d.h.lay_msgitem_share_view);
        this.dnh = (ShareFromFrsView) findViewById(d.h.lay_msgitem_share_frs);
        this.dni = (ShareFromGameCenter) findViewById(d.h.lay_msgitem_share_game);
        this.dnd = (ChatVoiceView) findViewById(d.h.lay_msgitem_voice);
        this.dnd.setClickable(true);
        this.dnd.setOnClickListener(this.dnd);
        this.dnd.setLongClickable(true);
        this.dnd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dmF.b(view, 5, g.this.auI, 0L);
                return true;
            }
        });
        this.dnj.getImage().setClickable(true);
        this.dnj.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dmE.a(view, 4, g.this.auI, 0L);
            }
        });
        this.dnj.getImage().setLongClickable(true);
        this.dnj.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dmF.b(view, 4, g.this.auI, 0L);
                return true;
            }
        });
        this.dnj.getTail().setClickable(true);
        this.dnj.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dmE.a(view, 13, g.this.auI, 0L);
            }
        });
        this.dnc.setLongClickable(true);
        this.dnc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dmF.b(view, 3, g.this.auI, 0L);
                return true;
            }
        });
        this.dne = (GifView) findViewById(d.h.emotion_msgitem_image);
        this.dne.setSupportNoImage(false);
        this.dne.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dmE.a(view, 7, g.this.auI, 0L);
            }
        });
        this.dne.setLongClickable(true);
        this.dne.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dmF.b(view, 7, g.this.auI, 0L);
                return true;
            }
        });
        this.dng.setClickable(true);
        this.dng.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dmE.a(view, 10, g.this.auI, 0L);
            }
        });
        this.dng.setLongClickable(true);
        this.dng.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dmF.b(view, 10, g.this.auI, 0L);
                return true;
            }
        });
        this.dnh.setClickable(true);
        this.dnh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dmE.a(view, 15, g.this.auI, 0L);
            }
        });
        this.dnh.setLongClickable(true);
        this.dnh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dmF.b(view, 15, g.this.auI, 0L);
                return true;
            }
        });
        this.dni.getContentBody().setClickable(true);
        this.dni.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dmE.a(view, 11, g.this.auI, 0L);
            }
        });
        this.dni.getTail().setClickable(true);
        this.dni.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dmE.a(view, 12, g.this.auI, 0L);
            }
        });
        this.dni.getContentBody().setLongClickable(true);
        this.dni.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dmF.b(view, 11, g.this.auI, 0L);
                return true;
            }
        });
        if (this.dnf != null) {
            this.dnf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.dmF.b(view, 17, g.this.auI, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mk(int i) {
        this.dnj.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bB = bB(chatMessage.getTime());
        if (z || bB) {
            this.cif.setVisibility(0);
            this.cif.setText(bC(chatMessage.getTime()));
        } else {
            this.cif.setVisibility(8);
        }
        if (!z && bB) {
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
        j.a(this.mContext.getContext(), this.dnc, chatMessage, str, this.dmO);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.dnc.setContentDescription(stringBuffer.toString());
            this.dnc.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dnj, chatMessage, this.dna, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.dnd, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.dne, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.dnf, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dng, this.dnh, this.dni, chatMessage, str);
    }

    public void fR(boolean z) {
        this.dnk = z;
    }

    public void fS(boolean z) {
        this.dnl = z;
    }

    public void mj(int i) {
        this.dmO = i;
    }
}
