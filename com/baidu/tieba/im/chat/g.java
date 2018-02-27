package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
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
public class g extends com.baidu.adp.base.b<MsglistActivity<?>> {
    protected TextView duR;
    protected com.baidu.adp.lib.c.a evD;
    protected com.baidu.adp.lib.c.b evE;
    protected int evN;
    private Calendar evY;
    protected long evZ;
    protected Long ewa;
    protected TbRichTextView ewb;
    protected ChatVoiceView ewc;
    protected GifView ewd;
    protected Invite2GroupView ewe;
    protected ShareFromPBView ewf;
    protected ShareFromFrsView ewg;
    protected ShareFromGameCenter ewh;
    protected ChatImageWithTailView ewi;
    protected boolean ewj;
    protected boolean ewk;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.evD = null;
        this.evE = null;
        this.mPosition = 0;
        this.evZ = 0L;
        this.ewa = null;
        this.ewj = true;
        this.ewk = false;
        this.mLastTime = 0L;
        this.evY = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.evD = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.evE = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bR(long j) {
        this.mLastTime = j;
    }

    public void bS(long j) {
        this.evY = Calendar.getInstance();
        this.evY.setTimeInMillis(1000 * j);
    }

    private boolean bT(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String bU(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.evY != null && this.evY.get(1) == calendar.get(1) && this.evY.get(6) == calendar.get(6)) {
            return am.b(calendar.getTime());
        }
        return am.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.ewa = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.duR = (TextView) findViewById(d.g.tex_msgitem_time);
        this.ewb = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.ewb.setLinkTextColor(-14845754);
        this.ewi = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.ewe = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.ewf = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.ewg = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.ewh = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.ewc = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.ewc.setClickable(true);
        this.ewc.setOnClickListener(this.ewc);
        this.ewc.setLongClickable(true);
        this.ewc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evE.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewi.getImage().setClickable(true);
        this.ewi.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evD.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.ewi.getImage().setLongClickable(true);
        this.ewi.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evE.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewi.getTail().setClickable(true);
        this.ewi.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evD.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.ewb.setLongClickable(true);
        this.ewb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evE.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewd = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.ewd.setSupportNoImage(false);
        this.ewd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evD.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.ewd.setLongClickable(true);
        this.ewd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evE.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewf.setClickable(true);
        this.ewf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evD.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.ewf.setLongClickable(true);
        this.ewf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evE.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewg.setClickable(true);
        this.ewg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evD.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.ewg.setLongClickable(true);
        this.ewg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evE.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ewh.getContentBody().setClickable(true);
        this.ewh.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evD.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.ewh.getTail().setClickable(true);
        this.ewh.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.evD.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.ewh.getContentBody().setLongClickable(true);
        this.ewh.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.evE.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.ewe != null) {
            this.ewe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.evE.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pI(int i) {
        this.ewi.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bT = bT(chatMessage.getTime());
        if (z || bT) {
            this.duR.setVisibility(0);
            this.duR.setText(bU(chatMessage.getTime()));
        } else {
            this.duR.setVisibility(8);
        }
        if (!z && bT) {
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
        j.a(this.mContext.getContext(), this.ewb, chatMessage, str, this.evN);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.ewb.setContentDescription(stringBuffer.toString());
            this.ewb.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.ewi, chatMessage, this.evZ, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.ewc, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.ewd, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.ewe, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.ewf, this.ewg, this.ewh, chatMessage, str);
    }

    public void hd(boolean z) {
        this.ewj = z;
    }

    public void he(boolean z) {
        this.ewk = z;
    }

    public void pH(int i) {
        this.evN = i;
    }
}
