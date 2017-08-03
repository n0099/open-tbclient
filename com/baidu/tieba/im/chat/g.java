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
    protected int avi;
    protected TextView ccL;
    protected com.baidu.adp.lib.c.a dfO;
    protected com.baidu.adp.lib.c.b dfP;
    protected int dfY;
    private Calendar dgj;
    protected long dgk;
    protected Long dgl;
    protected TbRichTextView dgm;
    protected ChatVoiceView dgn;
    protected GifView dgo;
    protected Invite2GroupView dgp;
    protected ShareFromPBView dgq;
    protected ShareFromFrsView dgr;
    protected ShareFromGameCenter dgs;
    protected ChatImageWithTailView dgt;
    protected boolean dgu;
    protected boolean dgv;
    private long mLastTime;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.dfO = null;
        this.dfP = null;
        this.avi = 0;
        this.dgk = 0L;
        this.dgl = null;
        this.dgu = true;
        this.dgv = false;
        this.mLastTime = 0L;
        this.dgj = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dfO = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dfP = bVar;
    }

    public void setPosition(int i) {
        this.avi = i;
    }

    public void bB(long j) {
        this.mLastTime = j;
    }

    public void bC(long j) {
        this.dgj = Calendar.getInstance();
        this.dgj.setTimeInMillis(1000 * j);
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
        if (this.dgj != null && this.dgj.get(1) == calendar.get(1) && this.dgj.get(6) == calendar.get(6)) {
            return al.b(calendar.getTime());
        }
        return al.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.dgl = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.ccL = (TextView) findViewById(d.h.tex_msgitem_time);
        this.dgm = (TbRichTextView) findViewById(d.h.tex_msgitem_text);
        this.dgm.setLinkTextColor(-14845754);
        this.dgt = (ChatImageWithTailView) findViewById(d.h.img_msgitem_image);
        this.dgp = (Invite2GroupView) findViewById(d.h.lay_msgitem_invite_view);
        this.dgq = (ShareFromPBView) findViewById(d.h.lay_msgitem_share_view);
        this.dgr = (ShareFromFrsView) findViewById(d.h.lay_msgitem_share_frs);
        this.dgs = (ShareFromGameCenter) findViewById(d.h.lay_msgitem_share_game);
        this.dgn = (ChatVoiceView) findViewById(d.h.lay_msgitem_voice);
        this.dgn.setClickable(true);
        this.dgn.setOnClickListener(this.dgn);
        this.dgn.setLongClickable(true);
        this.dgn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dfP.b(view, 5, g.this.avi, 0L);
                return true;
            }
        });
        this.dgt.getImage().setClickable(true);
        this.dgt.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dfO.a(view, 4, g.this.avi, 0L);
            }
        });
        this.dgt.getImage().setLongClickable(true);
        this.dgt.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dfP.b(view, 4, g.this.avi, 0L);
                return true;
            }
        });
        this.dgt.getTail().setClickable(true);
        this.dgt.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dfO.a(view, 13, g.this.avi, 0L);
            }
        });
        this.dgm.setLongClickable(true);
        this.dgm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dfP.b(view, 3, g.this.avi, 0L);
                return true;
            }
        });
        this.dgo = (GifView) findViewById(d.h.emotion_msgitem_image);
        this.dgo.setSupportNoImage(false);
        this.dgo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dfO.a(view, 7, g.this.avi, 0L);
            }
        });
        this.dgo.setLongClickable(true);
        this.dgo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dfP.b(view, 7, g.this.avi, 0L);
                return true;
            }
        });
        this.dgq.setClickable(true);
        this.dgq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dfO.a(view, 10, g.this.avi, 0L);
            }
        });
        this.dgq.setLongClickable(true);
        this.dgq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dfP.b(view, 10, g.this.avi, 0L);
                return true;
            }
        });
        this.dgr.setClickable(true);
        this.dgr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dfO.a(view, 15, g.this.avi, 0L);
            }
        });
        this.dgr.setLongClickable(true);
        this.dgr.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dfP.b(view, 15, g.this.avi, 0L);
                return true;
            }
        });
        this.dgs.getContentBody().setClickable(true);
        this.dgs.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dfO.a(view, 11, g.this.avi, 0L);
            }
        });
        this.dgs.getTail().setClickable(true);
        this.dgs.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dfO.a(view, 12, g.this.avi, 0L);
            }
        });
        this.dgs.getContentBody().setLongClickable(true);
        this.dgs.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dfP.b(view, 11, g.this.avi, 0L);
                return true;
            }
        });
        if (this.dgp != null) {
            this.dgp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.dfP.b(view, 17, g.this.avi, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lL(int i) {
        this.dgt.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bD = bD(chatMessage.getTime());
        if (z || bD) {
            this.ccL.setVisibility(0);
            this.ccL.setText(bE(chatMessage.getTime()));
        } else {
            this.ccL.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.dgm, chatMessage, str, this.dfY);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.dgm.setContentDescription(stringBuffer.toString());
            this.dgm.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dgt, chatMessage, this.dgk, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.dgn, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.dgo, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.dgp, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dgq, this.dgr, this.dgs, chatMessage, str);
    }

    public void fU(boolean z) {
        this.dgu = z;
    }

    public void fV(boolean z) {
        this.dgv = z;
    }

    public void lK(int i) {
        this.dfY = i;
    }
}
