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
    protected TextView dmH;
    private Calendar eAc;
    protected long eAd;
    protected Long eAe;
    protected TbRichTextView eAf;
    protected ChatVoiceView eAg;
    protected GifView eAh;
    protected Invite2GroupView eAi;
    protected ShareFromPBView eAj;
    protected ShareFromFrsView eAk;
    protected ShareFromGameCenter eAl;
    protected ChatImageWithTailView eAm;
    protected boolean eAn;
    protected boolean eAo;
    protected com.baidu.adp.lib.c.a ezH;
    protected com.baidu.adp.lib.c.b ezI;
    protected int ezR;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.ezH = null;
        this.ezI = null;
        this.mPosition = 0;
        this.eAd = 0L;
        this.eAe = null;
        this.eAn = true;
        this.eAo = false;
        this.mLastTime = 0L;
        this.eAc = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.ezH = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ezI = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void ch(long j) {
        this.mLastTime = j;
    }

    public void ci(long j) {
        this.eAc = Calendar.getInstance();
        this.eAc.setTimeInMillis(1000 * j);
    }

    private boolean cj(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String ck(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.eAc != null && this.eAc.get(1) == calendar.get(1) && this.eAc.get(6) == calendar.get(6)) {
            return ao.b(calendar.getTime());
        }
        return ao.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.eAe = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dmH = (TextView) findViewById(e.g.tex_msgitem_time);
        this.eAf = (TbRichTextView) findViewById(e.g.tex_msgitem_text);
        this.eAf.setLinkTextColor(-14845754);
        this.eAm = (ChatImageWithTailView) findViewById(e.g.img_msgitem_image);
        this.eAi = (Invite2GroupView) findViewById(e.g.lay_msgitem_invite_view);
        this.eAj = (ShareFromPBView) findViewById(e.g.lay_msgitem_share_view);
        this.eAk = (ShareFromFrsView) findViewById(e.g.lay_msgitem_share_frs);
        this.eAl = (ShareFromGameCenter) findViewById(e.g.lay_msgitem_share_game);
        this.eAg = (ChatVoiceView) findViewById(e.g.lay_msgitem_voice);
        this.eAg.setClickable(true);
        this.eAg.setOnClickListener(this.eAg);
        this.eAg.setLongClickable(true);
        this.eAg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ezI.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eAm.getImage().setClickable(true);
        this.eAm.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ezH.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.eAm.getImage().setLongClickable(true);
        this.eAm.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ezI.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eAm.getTail().setClickable(true);
        this.eAm.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ezH.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.eAf.setLongClickable(true);
        this.eAf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ezI.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eAh = (GifView) findViewById(e.g.emotion_msgitem_image);
        this.eAh.setSupportNoImage(false);
        this.eAh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ezH.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.eAh.setLongClickable(true);
        this.eAh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ezI.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eAj.setClickable(true);
        this.eAj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ezH.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.eAj.setLongClickable(true);
        this.eAj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ezI.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eAk.setClickable(true);
        this.eAk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ezH.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.eAk.setLongClickable(true);
        this.eAk.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ezI.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eAl.getContentBody().setClickable(true);
        this.eAl.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ezH.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.eAl.getTail().setClickable(true);
        this.eAl.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ezH.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.eAl.getContentBody().setLongClickable(true);
        this.eAl.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ezI.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.eAi != null) {
            this.eAi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.ezI.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oP(int i) {
        this.eAm.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean cj = cj(chatMessage.getTime());
        if (z || cj) {
            this.dmH.setVisibility(0);
            this.dmH.setText(ck(chatMessage.getTime()));
        } else {
            this.dmH.setVisibility(8);
        }
        if (!z && cj) {
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
        j.a(this.mContext.getContext(), this.eAf, chatMessage, str, this.ezR);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.eAf.setContentDescription(stringBuffer.toString());
            this.eAf.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eAm, chatMessage, this.eAd, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.eAg, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.eAh, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.eAi, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eAj, this.eAk, this.eAl, chatMessage, str);
    }

    public void hS(boolean z) {
        this.eAn = z;
    }

    public void hT(boolean z) {
        this.eAo = z;
    }

    public void oO(int i) {
        this.ezR = i;
    }
}
