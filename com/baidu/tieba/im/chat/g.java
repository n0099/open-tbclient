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
    protected TextView duU;
    protected com.baidu.adp.lib.c.a evT;
    protected com.baidu.adp.lib.c.b evU;
    protected boolean ewA;
    protected int ewd;
    private Calendar ewo;
    protected long ewp;
    protected Long ewq;
    protected TbRichTextView ewr;
    protected ChatVoiceView ews;
    protected GifView ewt;
    protected Invite2GroupView ewu;
    protected ShareFromPBView ewv;
    protected ShareFromFrsView eww;
    protected ShareFromGameCenter ewx;
    protected ChatImageWithTailView ewy;
    protected boolean ewz;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.evT = null;
        this.evU = null;
        this.mPosition = 0;
        this.ewp = 0L;
        this.ewq = null;
        this.ewz = true;
        this.ewA = false;
        this.mLastTime = 0L;
        this.ewo = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.evT = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.evU = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bR(long j) {
        this.mLastTime = j;
    }

    public void bS(long j) {
        this.ewo = Calendar.getInstance();
        this.ewo.setTimeInMillis(1000 * j);
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
        if (this.ewo != null && this.ewo.get(1) == calendar.get(1) && this.ewo.get(6) == calendar.get(6)) {
            return am.b(calendar.getTime());
        }
        return am.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.ewq = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.duU = (TextView) findViewById(d.g.tex_msgitem_time);
        this.ewr = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.ewr.setLinkTextColor(-14845754);
        this.ewy = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.ewu = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.ewv = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.eww = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.ewx = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.ews = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.ews.setClickable(true);
        this.ews.setOnClickListener(this.ews);
        this.ews.setLongClickable(true);
        this.ews.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evU.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewy.getImage().setClickable(true);
        this.ewy.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evT.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.ewy.getImage().setLongClickable(true);
        this.ewy.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evU.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewy.getTail().setClickable(true);
        this.ewy.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evT.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.ewr.setLongClickable(true);
        this.ewr.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evU.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewt = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.ewt.setSupportNoImage(false);
        this.ewt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evT.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.ewt.setLongClickable(true);
        this.ewt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evU.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewv.setClickable(true);
        this.ewv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evT.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.ewv.setLongClickable(true);
        this.ewv.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evU.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eww.setClickable(true);
        this.eww.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evT.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.eww.setLongClickable(true);
        this.eww.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evU.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewx.getContentBody().setClickable(true);
        this.ewx.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evT.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.ewx.getTail().setClickable(true);
        this.ewx.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evT.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.ewx.getContentBody().setLongClickable(true);
        this.ewx.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evU.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.ewu != null) {
            this.ewu.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.evU.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pJ(int i) {
        this.ewy.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bT = bT(chatMessage.getTime());
        if (z || bT) {
            this.duU.setVisibility(0);
            this.duU.setText(bU(chatMessage.getTime()));
        } else {
            this.duU.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.ewr, chatMessage, str, this.ewd);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.ewr.setContentDescription(stringBuffer.toString());
            this.ewr.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.ewy, chatMessage, this.ewp, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.ews, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.ewt, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.ewu, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.ewv, this.eww, this.ewx, chatMessage, str);
    }

    public void hi(boolean z) {
        this.ewz = z;
    }

    public void hj(boolean z) {
        this.ewA = z;
    }

    public void pI(int i) {
        this.ewd = i;
    }
}
