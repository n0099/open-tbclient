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
    protected int auU;
    protected TextView cir;
    protected com.baidu.adp.lib.c.a dmR;
    protected com.baidu.adp.lib.c.b dmS;
    protected int dnb;
    private Calendar dnm;
    protected long dnn;
    protected Long dno;
    protected TbRichTextView dnp;
    protected ChatVoiceView dnq;
    protected GifView dnr;
    protected Invite2GroupView dns;
    protected ShareFromPBView dnt;
    protected ShareFromFrsView dnu;
    protected ShareFromGameCenter dnv;
    protected ChatImageWithTailView dnw;
    protected boolean dnx;
    protected boolean dny;
    private long mLastTime;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.dmR = null;
        this.dmS = null;
        this.auU = 0;
        this.dnn = 0L;
        this.dno = null;
        this.dnx = true;
        this.dny = false;
        this.mLastTime = 0L;
        this.dnm = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dmR = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dmS = bVar;
    }

    public void setPosition(int i) {
        this.auU = i;
    }

    public void by(long j) {
        this.mLastTime = j;
    }

    public void bz(long j) {
        this.dnm = Calendar.getInstance();
        this.dnm.setTimeInMillis(1000 * j);
    }

    private boolean bA(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String bB(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.dnm != null && this.dnm.get(1) == calendar.get(1) && this.dnm.get(6) == calendar.get(6)) {
            return am.b(calendar.getTime());
        }
        return am.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.dno = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cir = (TextView) findViewById(d.h.tex_msgitem_time);
        this.dnp = (TbRichTextView) findViewById(d.h.tex_msgitem_text);
        this.dnp.setLinkTextColor(-14845754);
        this.dnw = (ChatImageWithTailView) findViewById(d.h.img_msgitem_image);
        this.dns = (Invite2GroupView) findViewById(d.h.lay_msgitem_invite_view);
        this.dnt = (ShareFromPBView) findViewById(d.h.lay_msgitem_share_view);
        this.dnu = (ShareFromFrsView) findViewById(d.h.lay_msgitem_share_frs);
        this.dnv = (ShareFromGameCenter) findViewById(d.h.lay_msgitem_share_game);
        this.dnq = (ChatVoiceView) findViewById(d.h.lay_msgitem_voice);
        this.dnq.setClickable(true);
        this.dnq.setOnClickListener(this.dnq);
        this.dnq.setLongClickable(true);
        this.dnq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dmS.b(view, 5, g.this.auU, 0L);
                return true;
            }
        });
        this.dnw.getImage().setClickable(true);
        this.dnw.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dmR.a(view, 4, g.this.auU, 0L);
            }
        });
        this.dnw.getImage().setLongClickable(true);
        this.dnw.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dmS.b(view, 4, g.this.auU, 0L);
                return true;
            }
        });
        this.dnw.getTail().setClickable(true);
        this.dnw.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dmR.a(view, 13, g.this.auU, 0L);
            }
        });
        this.dnp.setLongClickable(true);
        this.dnp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dmS.b(view, 3, g.this.auU, 0L);
                return true;
            }
        });
        this.dnr = (GifView) findViewById(d.h.emotion_msgitem_image);
        this.dnr.setSupportNoImage(false);
        this.dnr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dmR.a(view, 7, g.this.auU, 0L);
            }
        });
        this.dnr.setLongClickable(true);
        this.dnr.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dmS.b(view, 7, g.this.auU, 0L);
                return true;
            }
        });
        this.dnt.setClickable(true);
        this.dnt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dmR.a(view, 10, g.this.auU, 0L);
            }
        });
        this.dnt.setLongClickable(true);
        this.dnt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dmS.b(view, 10, g.this.auU, 0L);
                return true;
            }
        });
        this.dnu.setClickable(true);
        this.dnu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dmR.a(view, 15, g.this.auU, 0L);
            }
        });
        this.dnu.setLongClickable(true);
        this.dnu.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dmS.b(view, 15, g.this.auU, 0L);
                return true;
            }
        });
        this.dnv.getContentBody().setClickable(true);
        this.dnv.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dmR.a(view, 11, g.this.auU, 0L);
            }
        });
        this.dnv.getTail().setClickable(true);
        this.dnv.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dmR.a(view, 12, g.this.auU, 0L);
            }
        });
        this.dnv.getContentBody().setLongClickable(true);
        this.dnv.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dmS.b(view, 11, g.this.auU, 0L);
                return true;
            }
        });
        if (this.dns != null) {
            this.dns.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.dmS.b(view, 17, g.this.auU, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ml(int i) {
        this.dnw.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bA = bA(chatMessage.getTime());
        if (z || bA) {
            this.cir.setVisibility(0);
            this.cir.setText(bB(chatMessage.getTime()));
        } else {
            this.cir.setVisibility(8);
        }
        if (!z && bA) {
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
        j.a(this.mContext.getContext(), this.dnp, chatMessage, str, this.dnb);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.dnp.setContentDescription(stringBuffer.toString());
            this.dnp.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dnw, chatMessage, this.dnn, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.dnq, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.dnr, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.dns, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dnt, this.dnu, this.dnv, chatMessage, str);
    }

    public void fS(boolean z) {
        this.dnx = z;
    }

    public void fT(boolean z) {
        this.dny = z;
    }

    public void mk(int i) {
        this.dnb = i;
    }
}
