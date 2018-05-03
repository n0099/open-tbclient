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
    protected TextView cNF;
    protected int dQG;
    private Calendar dQR;
    protected long dQS;
    protected Long dQT;
    protected TbRichTextView dQU;
    protected ChatVoiceView dQV;
    protected GifView dQW;
    protected Invite2GroupView dQX;
    protected ShareFromPBView dQY;
    protected ShareFromFrsView dQZ;
    protected com.baidu.adp.lib.c.a dQw;
    protected com.baidu.adp.lib.c.b dQx;
    protected ShareFromGameCenter dRa;
    protected ChatImageWithTailView dRb;
    protected boolean dRc;
    protected boolean dRd;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.dQw = null;
        this.dQx = null;
        this.mPosition = 0;
        this.dQS = 0L;
        this.dQT = null;
        this.dRc = true;
        this.dRd = false;
        this.mLastTime = 0L;
        this.dQR = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dQw = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dQx = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bP(long j) {
        this.mLastTime = j;
    }

    public void bQ(long j) {
        this.dQR = Calendar.getInstance();
        this.dQR.setTimeInMillis(1000 * j);
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
        if (this.dQR != null && this.dQR.get(1) == calendar.get(1) && this.dQR.get(6) == calendar.get(6)) {
            return an.c(calendar.getTime());
        }
        return an.b(calendar.getTime());
    }

    public void a(View view2, ChatMessage chatMessage) {
    }

    public void b(View view2, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.dQT = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cNF = (TextView) findViewById(d.g.tex_msgitem_time);
        this.dQU = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.dQU.setLinkTextColor(-14845754);
        this.dRb = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.dQX = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.dQY = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.dQZ = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.dRa = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.dQV = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.dQV.setClickable(true);
        this.dQV.setOnClickListener(this.dQV);
        this.dQV.setLongClickable(true);
        this.dQV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dQx.b(view2, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dRb.getImage().setClickable(true);
        this.dRb.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dQw.a(view2, 4, g.this.mPosition, 0L);
            }
        });
        this.dRb.getImage().setLongClickable(true);
        this.dRb.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dQx.b(view2, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dRb.getTail().setClickable(true);
        this.dRb.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dQw.a(view2, 13, g.this.mPosition, 0L);
            }
        });
        this.dQU.setLongClickable(true);
        this.dQU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dQx.b(view2, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dQW = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.dQW.setSupportNoImage(false);
        this.dQW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dQw.a(view2, 7, g.this.mPosition, 0L);
            }
        });
        this.dQW.setLongClickable(true);
        this.dQW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dQx.b(view2, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dQY.setClickable(true);
        this.dQY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dQw.a(view2, 10, g.this.mPosition, 0L);
            }
        });
        this.dQY.setLongClickable(true);
        this.dQY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dQx.b(view2, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dQZ.setClickable(true);
        this.dQZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dQw.a(view2, 15, g.this.mPosition, 0L);
            }
        });
        this.dQZ.setLongClickable(true);
        this.dQZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dQx.b(view2, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dRa.getContentBody().setClickable(true);
        this.dRa.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dQw.a(view2, 11, g.this.mPosition, 0L);
            }
        });
        this.dRa.getTail().setClickable(true);
        this.dRa.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dQw.a(view2, 12, g.this.mPosition, 0L);
            }
        });
        this.dRa.getContentBody().setLongClickable(true);
        this.dRa.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dQx.b(view2, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.dQX != null) {
            this.dQX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    g.this.dQx.b(view2, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nh(int i) {
        this.dRb.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bR = bR(chatMessage.getTime());
        if (z || bR) {
            this.cNF.setVisibility(0);
            this.cNF.setText(bS(chatMessage.getTime()));
        } else {
            this.cNF.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.dQU, chatMessage, str, this.dQG);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.dQU.setContentDescription(stringBuffer.toString());
            this.dQU.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view2, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view2, this.dRb, chatMessage, this.dQS, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.dQV, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.dQW, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view2, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view2, this.dQX, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view2, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view2, this.dQY, this.dQZ, this.dRa, chatMessage, str);
    }

    public void gI(boolean z) {
        this.dRc = z;
    }

    public void gJ(boolean z) {
        this.dRd = z;
    }

    public void ng(int i) {
        this.dQG = i;
    }
}
