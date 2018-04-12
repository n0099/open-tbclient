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
    protected TextView cNI;
    protected com.baidu.adp.lib.c.b dQA;
    protected int dQJ;
    private Calendar dQU;
    protected long dQV;
    protected Long dQW;
    protected TbRichTextView dQX;
    protected ChatVoiceView dQY;
    protected GifView dQZ;
    protected com.baidu.adp.lib.c.a dQz;
    protected Invite2GroupView dRa;
    protected ShareFromPBView dRb;
    protected ShareFromFrsView dRc;
    protected ShareFromGameCenter dRd;
    protected ChatImageWithTailView dRe;
    protected boolean dRf;
    protected boolean dRg;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.dQz = null;
        this.dQA = null;
        this.mPosition = 0;
        this.dQV = 0L;
        this.dQW = null;
        this.dRf = true;
        this.dRg = false;
        this.mLastTime = 0L;
        this.dQU = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dQz = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dQA = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bP(long j) {
        this.mLastTime = j;
    }

    public void bQ(long j) {
        this.dQU = Calendar.getInstance();
        this.dQU.setTimeInMillis(1000 * j);
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
        if (this.dQU != null && this.dQU.get(1) == calendar.get(1) && this.dQU.get(6) == calendar.get(6)) {
            return an.c(calendar.getTime());
        }
        return an.b(calendar.getTime());
    }

    public void a(View view2, ChatMessage chatMessage) {
    }

    public void b(View view2, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.dQW = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cNI = (TextView) findViewById(d.g.tex_msgitem_time);
        this.dQX = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.dQX.setLinkTextColor(-14845754);
        this.dRe = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.dRa = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.dRb = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.dRc = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.dRd = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.dQY = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.dQY.setClickable(true);
        this.dQY.setOnClickListener(this.dQY);
        this.dQY.setLongClickable(true);
        this.dQY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dQA.b(view2, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dRe.getImage().setClickable(true);
        this.dRe.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dQz.a(view2, 4, g.this.mPosition, 0L);
            }
        });
        this.dRe.getImage().setLongClickable(true);
        this.dRe.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dQA.b(view2, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dRe.getTail().setClickable(true);
        this.dRe.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dQz.a(view2, 13, g.this.mPosition, 0L);
            }
        });
        this.dQX.setLongClickable(true);
        this.dQX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dQA.b(view2, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dQZ = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.dQZ.setSupportNoImage(false);
        this.dQZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dQz.a(view2, 7, g.this.mPosition, 0L);
            }
        });
        this.dQZ.setLongClickable(true);
        this.dQZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dQA.b(view2, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dRb.setClickable(true);
        this.dRb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dQz.a(view2, 10, g.this.mPosition, 0L);
            }
        });
        this.dRb.setLongClickable(true);
        this.dRb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dQA.b(view2, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dRc.setClickable(true);
        this.dRc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dQz.a(view2, 15, g.this.mPosition, 0L);
            }
        });
        this.dRc.setLongClickable(true);
        this.dRc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dQA.b(view2, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dRd.getContentBody().setClickable(true);
        this.dRd.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dQz.a(view2, 11, g.this.mPosition, 0L);
            }
        });
        this.dRd.getTail().setClickable(true);
        this.dRd.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dQz.a(view2, 12, g.this.mPosition, 0L);
            }
        });
        this.dRd.getContentBody().setLongClickable(true);
        this.dRd.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                g.this.dQA.b(view2, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.dRa != null) {
            this.dRa.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    g.this.dQA.b(view2, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ni(int i) {
        this.dRe.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bR = bR(chatMessage.getTime());
        if (z || bR) {
            this.cNI.setVisibility(0);
            this.cNI.setText(bS(chatMessage.getTime()));
        } else {
            this.cNI.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.dQX, chatMessage, str, this.dQJ);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.dQX.setContentDescription(stringBuffer.toString());
            this.dQX.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view2, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view2, this.dRe, chatMessage, this.dQV, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.dQY, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.dQZ, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view2, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view2, this.dRa, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view2, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view2, this.dRb, this.dRc, this.dRd, chatMessage, str);
    }

    public void gI(boolean z) {
        this.dRf = z;
    }

    public void gJ(boolean z) {
        this.dRg = z;
    }

    public void nh(int i) {
        this.dQJ = i;
    }
}
