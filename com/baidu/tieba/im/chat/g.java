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
    protected TextView cyM;
    protected com.baidu.adp.lib.c.a dDF;
    protected com.baidu.adp.lib.c.b dDG;
    protected int dDP;
    private Calendar dEa;
    protected long dEb;
    protected Long dEc;
    protected TbRichTextView dEd;
    protected ChatVoiceView dEe;
    protected GifView dEf;
    protected Invite2GroupView dEg;
    protected ShareFromPBView dEh;
    protected ShareFromFrsView dEi;
    protected ShareFromGameCenter dEj;
    protected ChatImageWithTailView dEk;
    protected boolean dEl;
    protected boolean dEm;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.dDF = null;
        this.dDG = null;
        this.mPosition = 0;
        this.dEb = 0L;
        this.dEc = null;
        this.dEl = true;
        this.dEm = false;
        this.mLastTime = 0L;
        this.dEa = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dDF = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dDG = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bI(long j) {
        this.mLastTime = j;
    }

    public void bJ(long j) {
        this.dEa = Calendar.getInstance();
        this.dEa.setTimeInMillis(1000 * j);
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
        if (this.dEa != null && this.dEa.get(1) == calendar.get(1) && this.dEa.get(6) == calendar.get(6)) {
            return am.b(calendar.getTime());
        }
        return am.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.dEc = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cyM = (TextView) findViewById(d.g.tex_msgitem_time);
        this.dEd = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.dEd.setLinkTextColor(-14845754);
        this.dEk = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.dEg = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.dEh = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.dEi = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.dEj = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.dEe = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.dEe.setClickable(true);
        this.dEe.setOnClickListener(this.dEe);
        this.dEe.setLongClickable(true);
        this.dEe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dDG.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dEk.getImage().setClickable(true);
        this.dEk.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dDF.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.dEk.getImage().setLongClickable(true);
        this.dEk.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dDG.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dEk.getTail().setClickable(true);
        this.dEk.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dDF.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.dEd.setLongClickable(true);
        this.dEd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dDG.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dEf = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.dEf.setSupportNoImage(false);
        this.dEf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dDF.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.dEf.setLongClickable(true);
        this.dEf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dDG.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dEh.setClickable(true);
        this.dEh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dDF.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.dEh.setLongClickable(true);
        this.dEh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dDG.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dEi.setClickable(true);
        this.dEi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dDF.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.dEi.setLongClickable(true);
        this.dEi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dDG.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dEj.getContentBody().setClickable(true);
        this.dEj.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dDF.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.dEj.getTail().setClickable(true);
        this.dEj.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dDF.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.dEj.getContentBody().setLongClickable(true);
        this.dEj.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dDG.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.dEg != null) {
            this.dEg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.dDG.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mW(int i) {
        this.dEk.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bK = bK(chatMessage.getTime());
        if (z || bK) {
            this.cyM.setVisibility(0);
            this.cyM.setText(bL(chatMessage.getTime()));
        } else {
            this.cyM.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.dEd, chatMessage, str, this.dDP);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.dEd.setContentDescription(stringBuffer.toString());
            this.dEd.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dEk, chatMessage, this.dEb, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.dEe, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.dEf, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.dEg, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dEh, this.dEi, this.dEj, chatMessage, str);
    }

    public void go(boolean z) {
        this.dEl = z;
    }

    public void gp(boolean z) {
        this.dEm = z;
    }

    public void mV(int i) {
        this.dDP = i;
    }
}
