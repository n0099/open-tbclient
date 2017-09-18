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
    protected int avK;
    protected TextView ciZ;
    protected com.baidu.adp.lib.c.a dqC;
    protected com.baidu.adp.lib.c.b dqD;
    protected int dqM;
    private Calendar dqX;
    protected long dqY;
    protected Long dqZ;
    protected TbRichTextView dra;
    protected ChatVoiceView drb;
    protected GifView drc;
    protected Invite2GroupView drd;
    protected ShareFromPBView dre;
    protected ShareFromFrsView drf;
    protected ShareFromGameCenter drg;
    protected ChatImageWithTailView drh;
    protected boolean dri;
    protected boolean drj;
    private long mLastTime;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.dqC = null;
        this.dqD = null;
        this.avK = 0;
        this.dqY = 0L;
        this.dqZ = null;
        this.dri = true;
        this.drj = false;
        this.mLastTime = 0L;
        this.dqX = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dqC = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dqD = bVar;
    }

    public void setPosition(int i) {
        this.avK = i;
    }

    public void bB(long j) {
        this.mLastTime = j;
    }

    public void bC(long j) {
        this.dqX = Calendar.getInstance();
        this.dqX.setTimeInMillis(1000 * j);
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
        if (this.dqX != null && this.dqX.get(1) == calendar.get(1) && this.dqX.get(6) == calendar.get(6)) {
            return am.b(calendar.getTime());
        }
        return am.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.dqZ = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.ciZ = (TextView) findViewById(d.h.tex_msgitem_time);
        this.dra = (TbRichTextView) findViewById(d.h.tex_msgitem_text);
        this.dra.setLinkTextColor(-14845754);
        this.drh = (ChatImageWithTailView) findViewById(d.h.img_msgitem_image);
        this.drd = (Invite2GroupView) findViewById(d.h.lay_msgitem_invite_view);
        this.dre = (ShareFromPBView) findViewById(d.h.lay_msgitem_share_view);
        this.drf = (ShareFromFrsView) findViewById(d.h.lay_msgitem_share_frs);
        this.drg = (ShareFromGameCenter) findViewById(d.h.lay_msgitem_share_game);
        this.drb = (ChatVoiceView) findViewById(d.h.lay_msgitem_voice);
        this.drb.setClickable(true);
        this.drb.setOnClickListener(this.drb);
        this.drb.setLongClickable(true);
        this.drb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dqD.b(view, 5, g.this.avK, 0L);
                return true;
            }
        });
        this.drh.getImage().setClickable(true);
        this.drh.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dqC.a(view, 4, g.this.avK, 0L);
            }
        });
        this.drh.getImage().setLongClickable(true);
        this.drh.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dqD.b(view, 4, g.this.avK, 0L);
                return true;
            }
        });
        this.drh.getTail().setClickable(true);
        this.drh.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dqC.a(view, 13, g.this.avK, 0L);
            }
        });
        this.dra.setLongClickable(true);
        this.dra.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dqD.b(view, 3, g.this.avK, 0L);
                return true;
            }
        });
        this.drc = (GifView) findViewById(d.h.emotion_msgitem_image);
        this.drc.setSupportNoImage(false);
        this.drc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dqC.a(view, 7, g.this.avK, 0L);
            }
        });
        this.drc.setLongClickable(true);
        this.drc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dqD.b(view, 7, g.this.avK, 0L);
                return true;
            }
        });
        this.dre.setClickable(true);
        this.dre.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dqC.a(view, 10, g.this.avK, 0L);
            }
        });
        this.dre.setLongClickable(true);
        this.dre.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dqD.b(view, 10, g.this.avK, 0L);
                return true;
            }
        });
        this.drf.setClickable(true);
        this.drf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dqC.a(view, 15, g.this.avK, 0L);
            }
        });
        this.drf.setLongClickable(true);
        this.drf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dqD.b(view, 15, g.this.avK, 0L);
                return true;
            }
        });
        this.drg.getContentBody().setClickable(true);
        this.drg.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dqC.a(view, 11, g.this.avK, 0L);
            }
        });
        this.drg.getTail().setClickable(true);
        this.drg.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dqC.a(view, 12, g.this.avK, 0L);
            }
        });
        this.drg.getContentBody().setLongClickable(true);
        this.drg.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dqD.b(view, 11, g.this.avK, 0L);
                return true;
            }
        });
        if (this.drd != null) {
            this.drd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.dqD.b(view, 17, g.this.avK, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mp(int i) {
        this.drh.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bD = bD(chatMessage.getTime());
        if (z || bD) {
            this.ciZ.setVisibility(0);
            this.ciZ.setText(bE(chatMessage.getTime()));
        } else {
            this.ciZ.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.dra, chatMessage, str, this.dqM);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.dra.setContentDescription(stringBuffer.toString());
            this.dra.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.drh, chatMessage, this.dqY, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.drb, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.drc, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.drd, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dre, this.drf, this.drg, chatMessage, str);
    }

    public void gg(boolean z) {
        this.dri = z;
    }

    public void gh(boolean z) {
        this.drj = z;
    }

    public void mo(int i) {
        this.dqM = i;
    }
}
