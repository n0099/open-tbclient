package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
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
    protected TextView cVU;
    protected com.baidu.adp.lib.c.a egK;
    protected com.baidu.adp.lib.c.b egL;
    protected int egU;
    private Calendar ehf;
    protected long ehg;
    protected Long ehh;
    protected TbRichTextView ehi;
    protected ChatVoiceView ehj;
    protected GifView ehk;
    protected Invite2GroupView ehl;
    protected ShareFromPBView ehm;
    protected ShareFromFrsView ehn;
    protected ShareFromGameCenter eho;
    protected ChatImageWithTailView ehp;
    protected boolean ehq;
    protected boolean ehr;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.egK = null;
        this.egL = null;
        this.mPosition = 0;
        this.ehg = 0L;
        this.ehh = null;
        this.ehq = true;
        this.ehr = false;
        this.mLastTime = 0L;
        this.ehf = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.egK = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.egL = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bR(long j) {
        this.mLastTime = j;
    }

    public void bS(long j) {
        this.ehf = Calendar.getInstance();
        this.ehf.setTimeInMillis(1000 * j);
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
        if (this.ehf != null && this.ehf.get(1) == calendar.get(1) && this.ehf.get(6) == calendar.get(6)) {
            return ap.c(calendar.getTime());
        }
        return ap.b(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.ehh = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cVU = (TextView) findViewById(d.g.tex_msgitem_time);
        this.ehi = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.ehi.setLinkTextColor(-14845754);
        this.ehp = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.ehl = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.ehm = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.ehn = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.eho = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.ehj = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.ehj.setClickable(true);
        this.ehj.setOnClickListener(this.ehj);
        this.ehj.setLongClickable(true);
        this.ehj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.egL.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ehp.getImage().setClickable(true);
        this.ehp.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.egK.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.ehp.getImage().setLongClickable(true);
        this.ehp.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.egL.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ehp.getTail().setClickable(true);
        this.ehp.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.egK.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.ehi.setLongClickable(true);
        this.ehi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.egL.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ehk = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.ehk.setSupportNoImage(false);
        this.ehk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.egK.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.ehk.setLongClickable(true);
        this.ehk.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.egL.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ehm.setClickable(true);
        this.ehm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.egK.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.ehm.setLongClickable(true);
        this.ehm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.egL.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ehn.setClickable(true);
        this.ehn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.egK.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.ehn.setLongClickable(true);
        this.ehn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.egL.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eho.getContentBody().setClickable(true);
        this.eho.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.egK.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.eho.getTail().setClickable(true);
        this.eho.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.egK.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.eho.getContentBody().setLongClickable(true);
        this.eho.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.egL.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.ehl != null) {
            this.ehl.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.egL.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nz(int i) {
        this.ehp.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bT = bT(chatMessage.getTime());
        if (z || bT) {
            this.cVU.setVisibility(0);
            this.cVU.setText(bU(chatMessage.getTime()));
        } else {
            this.cVU.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.ehi, chatMessage, str, this.egU);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.ehi.setContentDescription(stringBuffer.toString());
            this.ehi.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.ehp, chatMessage, this.ehg, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.ehj, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.ehk, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.ehl, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.ehm, this.ehn, this.eho, chatMessage, str);
    }

    public void gZ(boolean z) {
        this.ehq = z;
    }

    public void ha(boolean z) {
        this.ehr = z;
    }

    public void ny(int i) {
        this.egU = i;
    }
}
