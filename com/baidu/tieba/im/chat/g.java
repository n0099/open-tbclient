package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.base.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
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
    protected int awB;
    protected TextView ceE;
    protected Long djA;
    protected TbRichTextView djB;
    protected ChatVoiceView djC;
    protected GifView djD;
    protected Invite2GroupView djE;
    protected ShareFromPBView djF;
    protected ShareFromFrsView djG;
    protected ShareFromGameCenter djH;
    protected ChatImageWithTailView djI;
    protected boolean djJ;
    protected boolean djK;
    protected com.baidu.adp.lib.c.a djd;
    protected com.baidu.adp.lib.c.b dje;
    protected int djn;
    private Calendar djy;
    protected long djz;
    private long mLastTime;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.djd = null;
        this.dje = null;
        this.awB = 0;
        this.djz = 0L;
        this.djA = null;
        this.djJ = true;
        this.djK = false;
        this.mLastTime = 0L;
        this.djy = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.djd = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dje = bVar;
    }

    public void setPosition(int i) {
        this.awB = i;
    }

    public void bB(long j) {
        this.mLastTime = j;
    }

    public void bC(long j) {
        this.djy = Calendar.getInstance();
        this.djy.setTimeInMillis(1000 * j);
    }

    private boolean bD(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String bE(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.djy != null && this.djy.get(1) == calendar.get(1) && this.djy.get(6) == calendar.get(6)) {
            return al.b(calendar.getTime());
        }
        return al.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.djA = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.ceE = (TextView) findViewById(d.h.tex_msgitem_time);
        this.djB = (TbRichTextView) findViewById(d.h.tex_msgitem_text);
        this.djB.setLinkTextColor(-14845754);
        this.djI = (ChatImageWithTailView) findViewById(d.h.img_msgitem_image);
        this.djE = (Invite2GroupView) findViewById(d.h.lay_msgitem_invite_view);
        this.djF = (ShareFromPBView) findViewById(d.h.lay_msgitem_share_view);
        this.djG = (ShareFromFrsView) findViewById(d.h.lay_msgitem_share_frs);
        this.djH = (ShareFromGameCenter) findViewById(d.h.lay_msgitem_share_game);
        this.djC = (ChatVoiceView) findViewById(d.h.lay_msgitem_voice);
        this.djC.setClickable(true);
        this.djC.setOnClickListener(this.djC);
        this.djC.setLongClickable(true);
        this.djC.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dje.b(view, 5, g.this.awB, 0L);
                return true;
            }
        });
        this.djI.getImage().setClickable(true);
        this.djI.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.djd.a(view, 4, g.this.awB, 0L);
            }
        });
        this.djI.getImage().setLongClickable(true);
        this.djI.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dje.b(view, 4, g.this.awB, 0L);
                return true;
            }
        });
        this.djI.getTail().setClickable(true);
        this.djI.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.djd.a(view, 13, g.this.awB, 0L);
            }
        });
        this.djB.setLongClickable(true);
        this.djB.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dje.b(view, 3, g.this.awB, 0L);
                return true;
            }
        });
        this.djD = (GifView) findViewById(d.h.emotion_msgitem_image);
        this.djD.setSupportNoImage(false);
        this.djD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.djd.a(view, 7, g.this.awB, 0L);
            }
        });
        this.djD.setLongClickable(true);
        this.djD.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dje.b(view, 7, g.this.awB, 0L);
                return true;
            }
        });
        this.djF.setClickable(true);
        this.djF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.djd.a(view, 10, g.this.awB, 0L);
            }
        });
        this.djF.setLongClickable(true);
        this.djF.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dje.b(view, 10, g.this.awB, 0L);
                return true;
            }
        });
        this.djG.setClickable(true);
        this.djG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.djd.a(view, 15, g.this.awB, 0L);
            }
        });
        this.djG.setLongClickable(true);
        this.djG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dje.b(view, 15, g.this.awB, 0L);
                return true;
            }
        });
        this.djH.getContentBody().setClickable(true);
        this.djH.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.djd.a(view, 11, g.this.awB, 0L);
            }
        });
        this.djH.getTail().setClickable(true);
        this.djH.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.djd.a(view, 12, g.this.awB, 0L);
            }
        });
        this.djH.getContentBody().setLongClickable(true);
        this.djH.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dje.b(view, 11, g.this.awB, 0L);
                return true;
            }
        });
        if (this.djE != null) {
            this.djE.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.dje.b(view, 17, g.this.awB, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lV(int i) {
        this.djI.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bD = bD(chatMessage.getTime());
        if (z || bD) {
            this.ceE.setVisibility(0);
            this.ceE.setText(bE(chatMessage.getTime()));
        } else {
            this.ceE.setVisibility(8);
        }
        if (!z && bD) {
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
        j.a(this.mContext.getContext(), this.djB, chatMessage, str, this.djn);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.djB.setContentDescription(stringBuffer.toString());
            this.djB.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.djI, chatMessage, this.djz, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.djC, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.djD, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.djE, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.djF, this.djG, this.djH, chatMessage, str);
    }

    public void fX(boolean z) {
        this.djJ = z;
    }

    public void fY(boolean z) {
        this.djK = z;
    }

    public void lU(int i) {
        this.djn = i;
    }
}
