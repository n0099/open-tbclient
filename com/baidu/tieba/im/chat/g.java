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
    protected TextView dun;
    protected com.baidu.adp.lib.c.a eHP;
    protected com.baidu.adp.lib.c.b eHQ;
    protected int eHZ;
    private Calendar eIk;
    protected long eIl;
    protected Long eIm;
    protected TbRichTextView eIn;
    protected ChatVoiceView eIo;
    protected GifView eIp;
    protected Invite2GroupView eIq;
    protected ShareFromPBView eIr;
    protected ShareFromFrsView eIs;
    protected ShareFromGameCenter eIt;
    protected ChatImageWithTailView eIu;
    protected boolean eIv;
    protected boolean eIw;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.eHP = null;
        this.eHQ = null;
        this.mPosition = 0;
        this.eIl = 0L;
        this.eIm = null;
        this.eIv = true;
        this.eIw = false;
        this.mLastTime = 0L;
        this.eIk = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.eHP = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.eHQ = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void cj(long j) {
        this.mLastTime = j;
    }

    public void ck(long j) {
        this.eIk = Calendar.getInstance();
        this.eIk.setTimeInMillis(1000 * j);
    }

    private boolean cl(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String cm(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.eIk != null && this.eIk.get(1) == calendar.get(1) && this.eIk.get(6) == calendar.get(6)) {
            return ao.b(calendar.getTime());
        }
        return ao.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.eIm = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dun = (TextView) findViewById(e.g.tex_msgitem_time);
        this.eIn = (TbRichTextView) findViewById(e.g.tex_msgitem_text);
        this.eIn.setLinkTextColor(-14845754);
        this.eIu = (ChatImageWithTailView) findViewById(e.g.img_msgitem_image);
        this.eIq = (Invite2GroupView) findViewById(e.g.lay_msgitem_invite_view);
        this.eIr = (ShareFromPBView) findViewById(e.g.lay_msgitem_share_view);
        this.eIs = (ShareFromFrsView) findViewById(e.g.lay_msgitem_share_frs);
        this.eIt = (ShareFromGameCenter) findViewById(e.g.lay_msgitem_share_game);
        this.eIo = (ChatVoiceView) findViewById(e.g.lay_msgitem_voice);
        this.eIo.setClickable(true);
        this.eIo.setOnClickListener(this.eIo);
        this.eIo.setLongClickable(true);
        this.eIo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eHQ.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eIu.getImage().setClickable(true);
        this.eIu.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eHP.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.eIu.getImage().setLongClickable(true);
        this.eIu.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eHQ.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eIu.getTail().setClickable(true);
        this.eIu.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eHP.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.eIn.setLongClickable(true);
        this.eIn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eHQ.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eIp = (GifView) findViewById(e.g.emotion_msgitem_image);
        this.eIp.setSupportNoImage(false);
        this.eIp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eHP.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.eIp.setLongClickable(true);
        this.eIp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eHQ.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eIr.setClickable(true);
        this.eIr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eHP.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.eIr.setLongClickable(true);
        this.eIr.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eHQ.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eIs.setClickable(true);
        this.eIs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eHP.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.eIs.setLongClickable(true);
        this.eIs.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eHQ.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eIt.getContentBody().setClickable(true);
        this.eIt.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eHP.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.eIt.getTail().setClickable(true);
        this.eIt.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eHP.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.eIt.getContentBody().setLongClickable(true);
        this.eIt.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eHQ.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.eIq != null) {
            this.eIq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.eHQ.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pC(int i) {
        this.eIu.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean cl = cl(chatMessage.getTime());
        if (z || cl) {
            this.dun.setVisibility(0);
            this.dun.setText(cm(chatMessage.getTime()));
        } else {
            this.dun.setVisibility(8);
        }
        if (!z && cl) {
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
        j.a(this.mContext.getContext(), this.eIn, chatMessage, str, this.eHZ);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.eIn.setContentDescription(stringBuffer.toString());
            this.eIn.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eIu, chatMessage, this.eIl, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.eIo, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.eIp, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.eIq, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eIr, this.eIs, this.eIt, chatMessage, str);
    }

    public void ie(boolean z) {
        this.eIv = z;
    }

    /* renamed from: if  reason: not valid java name */
    public void m20if(boolean z) {
        this.eIw = z;
    }

    public void pB(int i) {
        this.eHZ = i;
    }
}
