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
    private Calendar eAb;
    protected long eAc;
    protected Long eAd;
    protected TbRichTextView eAe;
    protected ChatVoiceView eAf;
    protected GifView eAg;
    protected Invite2GroupView eAh;
    protected ShareFromPBView eAi;
    protected ShareFromFrsView eAj;
    protected ShareFromGameCenter eAk;
    protected ChatImageWithTailView eAl;
    protected boolean eAm;
    protected boolean eAn;
    protected com.baidu.adp.lib.c.a ezG;
    protected com.baidu.adp.lib.c.b ezH;
    protected int ezQ;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.ezG = null;
        this.ezH = null;
        this.mPosition = 0;
        this.eAc = 0L;
        this.eAd = null;
        this.eAm = true;
        this.eAn = false;
        this.mLastTime = 0L;
        this.eAb = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.ezG = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ezH = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void ch(long j) {
        this.mLastTime = j;
    }

    public void ci(long j) {
        this.eAb = Calendar.getInstance();
        this.eAb.setTimeInMillis(1000 * j);
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
        if (this.eAb != null && this.eAb.get(1) == calendar.get(1) && this.eAb.get(6) == calendar.get(6)) {
            return ao.b(calendar.getTime());
        }
        return ao.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.eAd = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dmH = (TextView) findViewById(e.g.tex_msgitem_time);
        this.eAe = (TbRichTextView) findViewById(e.g.tex_msgitem_text);
        this.eAe.setLinkTextColor(-14845754);
        this.eAl = (ChatImageWithTailView) findViewById(e.g.img_msgitem_image);
        this.eAh = (Invite2GroupView) findViewById(e.g.lay_msgitem_invite_view);
        this.eAi = (ShareFromPBView) findViewById(e.g.lay_msgitem_share_view);
        this.eAj = (ShareFromFrsView) findViewById(e.g.lay_msgitem_share_frs);
        this.eAk = (ShareFromGameCenter) findViewById(e.g.lay_msgitem_share_game);
        this.eAf = (ChatVoiceView) findViewById(e.g.lay_msgitem_voice);
        this.eAf.setClickable(true);
        this.eAf.setOnClickListener(this.eAf);
        this.eAf.setLongClickable(true);
        this.eAf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ezH.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eAl.getImage().setClickable(true);
        this.eAl.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ezG.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.eAl.getImage().setLongClickable(true);
        this.eAl.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ezH.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eAl.getTail().setClickable(true);
        this.eAl.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ezG.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.eAe.setLongClickable(true);
        this.eAe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ezH.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eAg = (GifView) findViewById(e.g.emotion_msgitem_image);
        this.eAg.setSupportNoImage(false);
        this.eAg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ezG.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.eAg.setLongClickable(true);
        this.eAg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ezH.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eAi.setClickable(true);
        this.eAi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ezG.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.eAi.setLongClickable(true);
        this.eAi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ezH.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eAj.setClickable(true);
        this.eAj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ezG.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.eAj.setLongClickable(true);
        this.eAj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ezH.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eAk.getContentBody().setClickable(true);
        this.eAk.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ezG.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.eAk.getTail().setClickable(true);
        this.eAk.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ezG.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.eAk.getContentBody().setLongClickable(true);
        this.eAk.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ezH.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.eAh != null) {
            this.eAh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.ezH.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oP(int i) {
        this.eAl.setVisibility(i);
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
        j.a(this.mContext.getContext(), this.eAe, chatMessage, str, this.ezQ);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.eAe.setContentDescription(stringBuffer.toString());
            this.eAe.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eAl, chatMessage, this.eAc, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.eAf, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.eAg, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.eAh, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eAi, this.eAj, this.eAk, chatMessage, str);
    }

    public void hS(boolean z) {
        this.eAm = z;
    }

    public void hT(boolean z) {
        this.eAn = z;
    }

    public void oO(int i) {
        this.ezQ = i;
    }
}
