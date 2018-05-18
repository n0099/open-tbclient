package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
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
    protected TextView cOM;
    protected com.baidu.adp.lib.c.a dRD;
    protected com.baidu.adp.lib.c.b dRE;
    protected int dRN;
    private Calendar dRY;
    protected long dRZ;
    protected Long dSa;
    protected TbRichTextView dSb;
    protected ChatVoiceView dSc;
    protected GifView dSd;
    protected Invite2GroupView dSe;
    protected ShareFromPBView dSf;
    protected ShareFromFrsView dSg;
    protected ShareFromGameCenter dSh;
    protected ChatImageWithTailView dSi;
    protected boolean dSj;
    protected boolean dSk;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.dRD = null;
        this.dRE = null;
        this.mPosition = 0;
        this.dRZ = 0L;
        this.dSa = null;
        this.dSj = true;
        this.dSk = false;
        this.mLastTime = 0L;
        this.dRY = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dRD = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dRE = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bP(long j) {
        this.mLastTime = j;
    }

    public void bQ(long j) {
        this.dRY = Calendar.getInstance();
        this.dRY.setTimeInMillis(1000 * j);
    }

    private boolean bR(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String bS(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.dRY != null && this.dRY.get(1) == calendar.get(1) && this.dRY.get(6) == calendar.get(6)) {
            return an.c(calendar.getTime());
        }
        return an.b(calendar.getTime());
    }

    public void a(View view2, ChatMessage chatMessage) {
    }

    public void b(View view2, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.dSa = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cOM = (TextView) findViewById(d.g.tex_msgitem_time);
        this.dSb = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.dSb.setLinkTextColor(-14845754);
        this.dSi = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.dSe = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.dSf = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.dSg = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.dSh = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.dSc = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.dSc.setClickable(true);
        this.dSc.setOnClickListener(this.dSc);
        this.dSc.setLongClickable(true);
        this.dSc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dRE.b(view2, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dSi.getImage().setClickable(true);
        this.dSi.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dRD.a(view2, 4, g.this.mPosition, 0L);
            }
        });
        this.dSi.getImage().setLongClickable(true);
        this.dSi.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dRE.b(view2, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dSi.getTail().setClickable(true);
        this.dSi.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dRD.a(view2, 13, g.this.mPosition, 0L);
            }
        });
        this.dSb.setLongClickable(true);
        this.dSb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dRE.b(view2, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dSd = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.dSd.setSupportNoImage(false);
        this.dSd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dRD.a(view2, 7, g.this.mPosition, 0L);
            }
        });
        this.dSd.setLongClickable(true);
        this.dSd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dRE.b(view2, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dSf.setClickable(true);
        this.dSf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dRD.a(view2, 10, g.this.mPosition, 0L);
            }
        });
        this.dSf.setLongClickable(true);
        this.dSf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dRE.b(view2, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dSg.setClickable(true);
        this.dSg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dRD.a(view2, 15, g.this.mPosition, 0L);
            }
        });
        this.dSg.setLongClickable(true);
        this.dSg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dRE.b(view2, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dSh.getContentBody().setClickable(true);
        this.dSh.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dRD.a(view2, 11, g.this.mPosition, 0L);
            }
        });
        this.dSh.getTail().setClickable(true);
        this.dSh.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dRD.a(view2, 12, g.this.mPosition, 0L);
            }
        });
        this.dSh.getContentBody().setLongClickable(true);
        this.dSh.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dRE.b(view2, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.dSe != null) {
            this.dSe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    g.this.dRE.b(view2, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ng(int i) {
        this.dSi.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bR = bR(chatMessage.getTime());
        if (z || bR) {
            this.cOM.setVisibility(0);
            this.cOM.setText(bS(chatMessage.getTime()));
        } else {
            this.cOM.setVisibility(8);
        }
        if (!z && bR) {
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
        j.a(this.mContext.getContext(), this.dSb, chatMessage, str, this.dRN);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.dSb.setContentDescription(stringBuffer.toString());
            this.dSb.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view2, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view2, this.dSi, chatMessage, this.dRZ, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.dSc, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.dSd, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view2, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view2, this.dSe, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view2, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view2, this.dSf, this.dSg, this.dSh, chatMessage, str);
    }

    public void gJ(boolean z) {
        this.dSj = z;
    }

    public void gK(boolean z) {
        this.dSk = z;
    }

    public void nf(int i) {
        this.dRN = i;
    }
}
