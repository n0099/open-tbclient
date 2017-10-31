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
    protected TextView cpA;
    protected int duE;
    private Calendar duP;
    protected long duQ;
    protected Long duR;
    protected TbRichTextView duS;
    protected ChatVoiceView duT;
    protected GifView duU;
    protected Invite2GroupView duV;
    protected ShareFromPBView duW;
    protected ShareFromFrsView duX;
    protected ShareFromGameCenter duY;
    protected ChatImageWithTailView duZ;
    protected com.baidu.adp.lib.c.a duu;
    protected com.baidu.adp.lib.c.b duv;
    protected boolean dva;
    protected boolean dvb;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.duu = null;
        this.duv = null;
        this.mPosition = 0;
        this.duQ = 0L;
        this.duR = null;
        this.dva = true;
        this.dvb = false;
        this.mLastTime = 0L;
        this.duP = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.duu = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.duv = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bA(long j) {
        this.mLastTime = j;
    }

    public void bB(long j) {
        this.duP = Calendar.getInstance();
        this.duP.setTimeInMillis(1000 * j);
    }

    private boolean bC(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String bD(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.duP != null && this.duP.get(1) == calendar.get(1) && this.duP.get(6) == calendar.get(6)) {
            return am.b(calendar.getTime());
        }
        return am.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.duR = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cpA = (TextView) findViewById(d.g.tex_msgitem_time);
        this.duS = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.duS.setLinkTextColor(-14845754);
        this.duZ = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.duV = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.duW = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.duX = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.duY = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.duT = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.duT.setClickable(true);
        this.duT.setOnClickListener(this.duT);
        this.duT.setLongClickable(true);
        this.duT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.duv.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.duZ.getImage().setClickable(true);
        this.duZ.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.duu.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.duZ.getImage().setLongClickable(true);
        this.duZ.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.duv.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.duZ.getTail().setClickable(true);
        this.duZ.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.duu.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.duS.setLongClickable(true);
        this.duS.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.duv.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.duU = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.duU.setSupportNoImage(false);
        this.duU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.duu.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.duU.setLongClickable(true);
        this.duU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.duv.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.duW.setClickable(true);
        this.duW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.duu.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.duW.setLongClickable(true);
        this.duW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.duv.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.duX.setClickable(true);
        this.duX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.duu.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.duX.setLongClickable(true);
        this.duX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.duv.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.duY.getContentBody().setClickable(true);
        this.duY.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.duu.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.duY.getTail().setClickable(true);
        this.duY.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.duu.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.duY.getContentBody().setLongClickable(true);
        this.duY.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.duv.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.duV != null) {
            this.duV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.duv.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mB(int i) {
        this.duZ.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bC = bC(chatMessage.getTime());
        if (z || bC) {
            this.cpA.setVisibility(0);
            this.cpA.setText(bD(chatMessage.getTime()));
        } else {
            this.cpA.setVisibility(8);
        }
        if (!z && bC) {
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
        j.a(this.mContext.getContext(), this.duS, chatMessage, str, this.duE);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.duS.setContentDescription(stringBuffer.toString());
            this.duS.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.duZ, chatMessage, this.duQ, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.duT, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.duU, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.duV, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.duW, this.duX, this.duY, chatMessage, str);
    }

    public void fN(boolean z) {
        this.dva = z;
    }

    public void fO(boolean z) {
        this.dvb = z;
    }

    public void mA(int i) {
        this.duE = i;
    }
}
