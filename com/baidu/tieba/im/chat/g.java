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
    protected int avN;
    protected TextView cih;
    protected com.baidu.adp.lib.c.a dpH;
    protected com.baidu.adp.lib.c.b dpI;
    protected int dpR;
    private Calendar dqc;
    protected long dqd;
    protected Long dqe;
    protected TbRichTextView dqf;
    protected ChatVoiceView dqg;
    protected GifView dqh;
    protected Invite2GroupView dqi;
    protected ShareFromPBView dqj;
    protected ShareFromFrsView dqk;
    protected ShareFromGameCenter dql;
    protected ChatImageWithTailView dqm;
    protected boolean dqn;
    protected boolean dqo;
    private long mLastTime;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.dpH = null;
        this.dpI = null;
        this.avN = 0;
        this.dqd = 0L;
        this.dqe = null;
        this.dqn = true;
        this.dqo = false;
        this.mLastTime = 0L;
        this.dqc = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dpH = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dpI = bVar;
    }

    public void setPosition(int i) {
        this.avN = i;
    }

    public void bB(long j) {
        this.mLastTime = j;
    }

    public void bC(long j) {
        this.dqc = Calendar.getInstance();
        this.dqc.setTimeInMillis(1000 * j);
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
        if (this.dqc != null && this.dqc.get(1) == calendar.get(1) && this.dqc.get(6) == calendar.get(6)) {
            return am.b(calendar.getTime());
        }
        return am.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.dqe = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cih = (TextView) findViewById(d.h.tex_msgitem_time);
        this.dqf = (TbRichTextView) findViewById(d.h.tex_msgitem_text);
        this.dqf.setLinkTextColor(-14845754);
        this.dqm = (ChatImageWithTailView) findViewById(d.h.img_msgitem_image);
        this.dqi = (Invite2GroupView) findViewById(d.h.lay_msgitem_invite_view);
        this.dqj = (ShareFromPBView) findViewById(d.h.lay_msgitem_share_view);
        this.dqk = (ShareFromFrsView) findViewById(d.h.lay_msgitem_share_frs);
        this.dql = (ShareFromGameCenter) findViewById(d.h.lay_msgitem_share_game);
        this.dqg = (ChatVoiceView) findViewById(d.h.lay_msgitem_voice);
        this.dqg.setClickable(true);
        this.dqg.setOnClickListener(this.dqg);
        this.dqg.setLongClickable(true);
        this.dqg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dpI.b(view, 5, g.this.avN, 0L);
                return true;
            }
        });
        this.dqm.getImage().setClickable(true);
        this.dqm.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dpH.a(view, 4, g.this.avN, 0L);
            }
        });
        this.dqm.getImage().setLongClickable(true);
        this.dqm.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dpI.b(view, 4, g.this.avN, 0L);
                return true;
            }
        });
        this.dqm.getTail().setClickable(true);
        this.dqm.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dpH.a(view, 13, g.this.avN, 0L);
            }
        });
        this.dqf.setLongClickable(true);
        this.dqf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dpI.b(view, 3, g.this.avN, 0L);
                return true;
            }
        });
        this.dqh = (GifView) findViewById(d.h.emotion_msgitem_image);
        this.dqh.setSupportNoImage(false);
        this.dqh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dpH.a(view, 7, g.this.avN, 0L);
            }
        });
        this.dqh.setLongClickable(true);
        this.dqh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dpI.b(view, 7, g.this.avN, 0L);
                return true;
            }
        });
        this.dqj.setClickable(true);
        this.dqj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dpH.a(view, 10, g.this.avN, 0L);
            }
        });
        this.dqj.setLongClickable(true);
        this.dqj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dpI.b(view, 10, g.this.avN, 0L);
                return true;
            }
        });
        this.dqk.setClickable(true);
        this.dqk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dpH.a(view, 15, g.this.avN, 0L);
            }
        });
        this.dqk.setLongClickable(true);
        this.dqk.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dpI.b(view, 15, g.this.avN, 0L);
                return true;
            }
        });
        this.dql.getContentBody().setClickable(true);
        this.dql.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dpH.a(view, 11, g.this.avN, 0L);
            }
        });
        this.dql.getTail().setClickable(true);
        this.dql.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dpH.a(view, 12, g.this.avN, 0L);
            }
        });
        this.dql.getContentBody().setLongClickable(true);
        this.dql.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dpI.b(view, 11, g.this.avN, 0L);
                return true;
            }
        });
        if (this.dqi != null) {
            this.dqi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.dpI.b(view, 17, g.this.avN, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mn(int i) {
        this.dqm.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bD = bD(chatMessage.getTime());
        if (z || bD) {
            this.cih.setVisibility(0);
            this.cih.setText(bE(chatMessage.getTime()));
        } else {
            this.cih.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.dqf, chatMessage, str, this.dpR);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.dqf.setContentDescription(stringBuffer.toString());
            this.dqf.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dqm, chatMessage, this.dqd, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.dqg, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.dqh, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.dqi, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dqj, this.dqk, this.dql, chatMessage, str);
    }

    public void gf(boolean z) {
        this.dqn = z;
    }

    public void gg(boolean z) {
        this.dqo = z;
    }

    public void mm(int i) {
        this.dpR = i;
    }
}
