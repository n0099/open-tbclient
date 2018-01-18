package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.base.b;
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
public class g extends b<MsglistActivity<?>> {
    protected TextView drP;
    private Calendar erF;
    protected long erG;
    protected Long erH;
    protected TbRichTextView erI;
    protected ChatVoiceView erJ;
    protected GifView erK;
    protected Invite2GroupView erL;
    protected ShareFromPBView erM;
    protected ShareFromFrsView erN;
    protected ShareFromGameCenter erO;
    protected ChatImageWithTailView erP;
    protected boolean erQ;
    protected boolean erR;
    protected com.baidu.adp.lib.c.a erj;
    protected com.baidu.adp.lib.c.b erk;
    protected int eru;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.erj = null;
        this.erk = null;
        this.mPosition = 0;
        this.erG = 0L;
        this.erH = null;
        this.erQ = true;
        this.erR = false;
        this.mLastTime = 0L;
        this.erF = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.erj = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.erk = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bP(long j) {
        this.mLastTime = j;
    }

    public void bQ(long j) {
        this.erF = Calendar.getInstance();
        this.erF.setTimeInMillis(1000 * j);
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
        if (this.erF != null && this.erF.get(1) == calendar.get(1) && this.erF.get(6) == calendar.get(6)) {
            return am.b(calendar.getTime());
        }
        return am.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.erH = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.drP = (TextView) findViewById(d.g.tex_msgitem_time);
        this.erI = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.erI.setLinkTextColor(-14845754);
        this.erP = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.erL = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.erM = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.erN = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.erO = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.erJ = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.erJ.setClickable(true);
        this.erJ.setOnClickListener(this.erJ);
        this.erJ.setLongClickable(true);
        this.erJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erk.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.erP.getImage().setClickable(true);
        this.erP.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erj.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.erP.getImage().setLongClickable(true);
        this.erP.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erk.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.erP.getTail().setClickable(true);
        this.erP.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erj.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.erI.setLongClickable(true);
        this.erI.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erk.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.erK = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.erK.setSupportNoImage(false);
        this.erK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erj.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.erK.setLongClickable(true);
        this.erK.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erk.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.erM.setClickable(true);
        this.erM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erj.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.erM.setLongClickable(true);
        this.erM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erk.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.erN.setClickable(true);
        this.erN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erj.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.erN.setLongClickable(true);
        this.erN.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erk.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.erO.getContentBody().setClickable(true);
        this.erO.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erj.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.erO.getTail().setClickable(true);
        this.erO.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.erj.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.erO.getContentBody().setLongClickable(true);
        this.erO.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.erk.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.erL != null) {
            this.erL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.erk.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pH(int i) {
        this.erP.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bR = bR(chatMessage.getTime());
        if (z || bR) {
            this.drP.setVisibility(0);
            this.drP.setText(bS(chatMessage.getTime()));
        } else {
            this.drP.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.erI, chatMessage, str, this.eru);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.erI.setContentDescription(stringBuffer.toString());
            this.erI.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.erP, chatMessage, this.erG, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.erJ, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.erK, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.erL, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.erM, this.erN, this.erO, chatMessage, str);
    }

    public void gQ(boolean z) {
        this.erQ = z;
    }

    public void gR(boolean z) {
        this.erR = z;
    }

    public void pG(int i) {
        this.eru = i;
    }
}
