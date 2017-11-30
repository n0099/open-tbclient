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
    protected TextView cyE;
    protected com.baidu.adp.lib.c.a dCB;
    protected com.baidu.adp.lib.c.b dCC;
    protected int dCL;
    private Calendar dCW;
    protected long dCX;
    protected Long dCY;
    protected TbRichTextView dCZ;
    protected ChatVoiceView dDa;
    protected GifView dDb;
    protected Invite2GroupView dDc;
    protected ShareFromPBView dDd;
    protected ShareFromFrsView dDe;
    protected ShareFromGameCenter dDf;
    protected ChatImageWithTailView dDg;
    protected boolean dDh;
    protected boolean dDi;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.dCB = null;
        this.dCC = null;
        this.mPosition = 0;
        this.dCX = 0L;
        this.dCY = null;
        this.dDh = true;
        this.dDi = false;
        this.mLastTime = 0L;
        this.dCW = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dCB = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dCC = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bI(long j) {
        this.mLastTime = j;
    }

    public void bJ(long j) {
        this.dCW = Calendar.getInstance();
        this.dCW.setTimeInMillis(1000 * j);
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
        if (this.dCW != null && this.dCW.get(1) == calendar.get(1) && this.dCW.get(6) == calendar.get(6)) {
            return am.b(calendar.getTime());
        }
        return am.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.dCY = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cyE = (TextView) findViewById(d.g.tex_msgitem_time);
        this.dCZ = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.dCZ.setLinkTextColor(-14845754);
        this.dDg = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.dDc = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.dDd = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.dDe = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.dDf = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.dDa = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.dDa.setClickable(true);
        this.dDa.setOnClickListener(this.dDa);
        this.dDa.setLongClickable(true);
        this.dDa.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dCC.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dDg.getImage().setClickable(true);
        this.dDg.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dCB.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.dDg.getImage().setLongClickable(true);
        this.dDg.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dCC.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dDg.getTail().setClickable(true);
        this.dDg.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dCB.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.dCZ.setLongClickable(true);
        this.dCZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dCC.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dDb = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.dDb.setSupportNoImage(false);
        this.dDb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dCB.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.dDb.setLongClickable(true);
        this.dDb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dCC.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dDd.setClickable(true);
        this.dDd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dCB.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.dDd.setLongClickable(true);
        this.dDd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dCC.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dDe.setClickable(true);
        this.dDe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dCB.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.dDe.setLongClickable(true);
        this.dDe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dCC.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dDf.getContentBody().setClickable(true);
        this.dDf.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dCB.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.dDf.getTail().setClickable(true);
        this.dDf.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dCB.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.dDf.getContentBody().setLongClickable(true);
        this.dDf.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dCC.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.dDc != null) {
            this.dDc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.dCC.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mP(int i) {
        this.dDg.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bK = bK(chatMessage.getTime());
        if (z || bK) {
            this.cyE.setVisibility(0);
            this.cyE.setText(bL(chatMessage.getTime()));
        } else {
            this.cyE.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.dCZ, chatMessage, str, this.dCL);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.dCZ.setContentDescription(stringBuffer.toString());
            this.dCZ.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dDg, chatMessage, this.dCX, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.dDa, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.dDb, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.dDc, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dDd, this.dDe, this.dDf, chatMessage, str);
    }

    public void gn(boolean z) {
        this.dDh = z;
    }

    public void go(boolean z) {
        this.dDi = z;
    }

    public void mO(int i) {
        this.dCL = i;
    }
}
