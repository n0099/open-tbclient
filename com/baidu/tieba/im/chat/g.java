package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
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
public class g extends com.baidu.adp.base.b<MsglistActivity<?>> {
    protected TextView dvd;
    protected com.baidu.adp.lib.c.a evP;
    protected com.baidu.adp.lib.c.b evQ;
    protected int evZ;
    private Calendar ewk;
    protected long ewl;
    protected Long ewm;
    protected TbRichTextView ewn;
    protected ChatVoiceView ewo;
    protected GifView ewp;
    protected Invite2GroupView ewq;
    protected ShareFromPBView ewr;
    protected ShareFromFrsView ews;
    protected ShareFromGameCenter ewt;
    protected ChatImageWithTailView ewu;
    protected boolean ewv;
    protected boolean eww;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.evP = null;
        this.evQ = null;
        this.mPosition = 0;
        this.ewl = 0L;
        this.ewm = null;
        this.ewv = true;
        this.eww = false;
        this.mLastTime = 0L;
        this.ewk = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.evP = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.evQ = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bR(long j) {
        this.mLastTime = j;
    }

    public void bS(long j) {
        this.ewk = Calendar.getInstance();
        this.ewk.setTimeInMillis(1000 * j);
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
        if (this.ewk != null && this.ewk.get(1) == calendar.get(1) && this.ewk.get(6) == calendar.get(6)) {
            return am.b(calendar.getTime());
        }
        return am.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.ewm = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dvd = (TextView) findViewById(d.g.tex_msgitem_time);
        this.ewn = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.ewn.setLinkTextColor(-14845754);
        this.ewu = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.ewq = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.ewr = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.ews = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.ewt = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.ewo = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.ewo.setClickable(true);
        this.ewo.setOnClickListener(this.ewo);
        this.ewo.setLongClickable(true);
        this.ewo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evQ.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewu.getImage().setClickable(true);
        this.ewu.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evP.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.ewu.getImage().setLongClickable(true);
        this.ewu.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evQ.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewu.getTail().setClickable(true);
        this.ewu.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evP.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.ewn.setLongClickable(true);
        this.ewn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evQ.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewp = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.ewp.setSupportNoImage(false);
        this.ewp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evP.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.ewp.setLongClickable(true);
        this.ewp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evQ.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewr.setClickable(true);
        this.ewr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evP.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.ewr.setLongClickable(true);
        this.ewr.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evQ.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ews.setClickable(true);
        this.ews.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evP.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.ews.setLongClickable(true);
        this.ews.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evQ.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewt.getContentBody().setClickable(true);
        this.ewt.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evP.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.ewt.getTail().setClickable(true);
        this.ewt.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evP.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.ewt.getContentBody().setLongClickable(true);
        this.ewt.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evQ.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.ewq != null) {
            this.ewq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.evQ.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pI(int i) {
        this.ewu.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bT = bT(chatMessage.getTime());
        if (z || bT) {
            this.dvd.setVisibility(0);
            this.dvd.setText(bU(chatMessage.getTime()));
        } else {
            this.dvd.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.ewn, chatMessage, str, this.evZ);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.ewn.setContentDescription(stringBuffer.toString());
            this.ewn.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.ewu, chatMessage, this.ewl, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.ewo, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.ewp, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.ewq, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.ewr, this.ews, this.ewt, chatMessage, str);
    }

    public void hd(boolean z) {
        this.ewv = z;
    }

    public void he(boolean z) {
        this.eww = z;
    }

    public void pH(int i) {
        this.evZ = i;
    }
}
