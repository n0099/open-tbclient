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
    protected TextView dxa;
    protected com.baidu.adp.lib.c.a eKG;
    protected com.baidu.adp.lib.c.b eKH;
    protected int eKQ;
    private Calendar eLb;
    protected long eLc;
    protected Long eLd;
    protected TbRichTextView eLe;
    protected ChatVoiceView eLf;
    protected GifView eLg;
    protected Invite2GroupView eLh;
    protected ShareFromPBView eLi;
    protected ShareFromFrsView eLj;
    protected ShareFromGameCenter eLk;
    protected ChatImageWithTailView eLl;
    protected boolean eLm;
    protected boolean eLn;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.eKG = null;
        this.eKH = null;
        this.mPosition = 0;
        this.eLc = 0L;
        this.eLd = null;
        this.eLm = true;
        this.eLn = false;
        this.mLastTime = 0L;
        this.eLb = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.eKG = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.eKH = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void co(long j) {
        this.mLastTime = j;
    }

    public void cp(long j) {
        this.eLb = Calendar.getInstance();
        this.eLb.setTimeInMillis(1000 * j);
    }

    private boolean cq(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String cr(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.eLb != null && this.eLb.get(1) == calendar.get(1) && this.eLb.get(6) == calendar.get(6)) {
            return ao.b(calendar.getTime());
        }
        return ao.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.eLd = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dxa = (TextView) findViewById(e.g.tex_msgitem_time);
        this.eLe = (TbRichTextView) findViewById(e.g.tex_msgitem_text);
        this.eLe.setLinkTextColor(-14845754);
        this.eLl = (ChatImageWithTailView) findViewById(e.g.img_msgitem_image);
        this.eLh = (Invite2GroupView) findViewById(e.g.lay_msgitem_invite_view);
        this.eLi = (ShareFromPBView) findViewById(e.g.lay_msgitem_share_view);
        this.eLj = (ShareFromFrsView) findViewById(e.g.lay_msgitem_share_frs);
        this.eLk = (ShareFromGameCenter) findViewById(e.g.lay_msgitem_share_game);
        this.eLf = (ChatVoiceView) findViewById(e.g.lay_msgitem_voice);
        this.eLf.setClickable(true);
        this.eLf.setOnClickListener(this.eLf);
        this.eLf.setLongClickable(true);
        this.eLf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eKH.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLl.getImage().setClickable(true);
        this.eLl.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eKG.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.eLl.getImage().setLongClickable(true);
        this.eLl.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eKH.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLl.getTail().setClickable(true);
        this.eLl.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eKG.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.eLe.setLongClickable(true);
        this.eLe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eKH.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLg = (GifView) findViewById(e.g.emotion_msgitem_image);
        this.eLg.setSupportNoImage(false);
        this.eLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eKG.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.eLg.setLongClickable(true);
        this.eLg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eKH.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLi.setClickable(true);
        this.eLi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eKG.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.eLi.setLongClickable(true);
        this.eLi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eKH.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLj.setClickable(true);
        this.eLj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eKG.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.eLj.setLongClickable(true);
        this.eLj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eKH.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLk.getContentBody().setClickable(true);
        this.eLk.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eKG.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.eLk.getTail().setClickable(true);
        this.eLk.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eKG.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.eLk.getContentBody().setLongClickable(true);
        this.eLk.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eKH.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.eLh != null) {
            this.eLh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.eKH.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pP(int i) {
        this.eLl.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean cq = cq(chatMessage.getTime());
        if (z || cq) {
            this.dxa.setVisibility(0);
            this.dxa.setText(cr(chatMessage.getTime()));
        } else {
            this.dxa.setVisibility(8);
        }
        if (!z && cq) {
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
        j.a(this.mContext.getContext(), this.eLe, chatMessage, str, this.eKQ);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.eLe.setContentDescription(stringBuffer.toString());
            this.eLe.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eLl, chatMessage, this.eLc, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.eLf, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.eLg, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.eLh, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eLi, this.eLj, this.eLk, chatMessage, str);
    }

    public void ih(boolean z) {
        this.eLm = z;
    }

    public void ii(boolean z) {
        this.eLn = z;
    }

    public void pO(int i) {
        this.eKQ = i;
    }
}
