package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
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
    protected TextView dqc;
    protected long gAa;
    protected Long gAb;
    protected TbRichTextView gAc;
    protected ChatVoiceView gAd;
    protected GifView gAe;
    protected Invite2GroupView gAf;
    protected ShareFromPBView gAg;
    protected ShareFromFrsView gAh;
    protected ShareFromGameCenter gAi;
    protected ChatImageWithTailView gAj;
    protected boolean gAk;
    protected boolean gAl;
    protected com.baidu.adp.lib.c.a gzE;
    protected com.baidu.adp.lib.c.b gzF;
    protected int gzO;
    private Calendar gzZ;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.gzE = null;
        this.gzF = null;
        this.mPosition = 0;
        this.gAa = 0L;
        this.gAb = null;
        this.gAk = true;
        this.gAl = false;
        this.mLastTime = 0L;
        this.gzZ = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gzE = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gzF = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void dA(long j) {
        this.mLastTime = j;
    }

    public void dB(long j) {
        this.gzZ = Calendar.getInstance();
        this.gzZ.setTimeInMillis(1000 * j);
    }

    private boolean dC(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String dD(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.gzZ != null && this.gzZ.get(1) == calendar.get(1) && this.gzZ.get(6) == calendar.get(6)) {
            return aq.b(calendar.getTime());
        }
        return aq.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.gAb = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dqc = (TextView) findViewById(R.id.tex_msgitem_time);
        this.gAc = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.gAc.setLinkTextColor(-14845754);
        this.gAj = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.gAf = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.gAg = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.gAh = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.gAi = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.gAd = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.gAd.setClickable(true);
        this.gAd.setOnClickListener(this.gAd);
        this.gAd.setLongClickable(true);
        this.gAd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gzF.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gAj.getImage().setClickable(true);
        this.gAj.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gzE.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.gAj.getImage().setLongClickable(true);
        this.gAj.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gzF.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gAj.getTail().setClickable(true);
        this.gAj.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gzE.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.gAc.setLongClickable(true);
        this.gAc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gzF.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gAe = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.gAe.setSupportNoImage(false);
        this.gAe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gzE.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.gAe.setLongClickable(true);
        this.gAe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gzF.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gAg.setClickable(true);
        this.gAg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gzE.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.gAg.setLongClickable(true);
        this.gAg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gzF.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gAh.setClickable(true);
        this.gAh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gzE.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.gAh.setLongClickable(true);
        this.gAh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gzF.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gAi.getContentBody().setClickable(true);
        this.gAi.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gzE.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.gAi.getTail().setClickable(true);
        this.gAi.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gzE.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.gAi.getContentBody().setLongClickable(true);
        this.gAi.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gzF.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.gAf != null) {
            this.gAf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.gzF.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vg(int i) {
        this.gAj.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean dC = dC(chatMessage.getTime());
        if (z || dC) {
            this.dqc.setVisibility(0);
            this.dqc.setText(dD(chatMessage.getTime()));
        } else {
            this.dqc.setVisibility(8);
        }
        if (!z && dC) {
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
        j.a(this.mContext.getContext(), this.gAc, chatMessage, str, this.gzO);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.gAc.setContentDescription(stringBuffer.toString());
            this.gAc.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gAj, chatMessage, this.gAa, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.gAd, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.gAe, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.gAf, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gAg, this.gAh, this.gAi, chatMessage, str);
    }

    public void lL(boolean z) {
        this.gAk = z;
    }

    public void lM(boolean z) {
        this.gAl = z;
    }

    public void vf(int i) {
        this.gzO = i;
    }
}
