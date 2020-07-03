package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
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
    protected TextView fqs;
    protected int iKF;
    private Calendar iKQ;
    protected long iKR;
    protected TbRichTextView iKS;
    protected ChatVoiceView iKT;
    protected GifView iKU;
    protected Invite2GroupView iKV;
    protected ShareFromPBView iKW;
    protected ShareFromFrsView iKX;
    protected ShareFromGameCenter iKY;
    protected ChatImageWithTailView iKZ;
    protected com.baidu.adp.lib.b.a iKw;
    protected com.baidu.adp.lib.b.b iKx;
    protected boolean iLa;
    protected boolean iLb;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.iKw = null;
        this.iKx = null;
        this.mPosition = 0;
        this.iKR = 0L;
        this.mId = null;
        this.iLa = true;
        this.iLb = false;
        this.mLastTime = 0L;
        this.iKQ = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.iKw = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.iKx = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void ey(long j) {
        this.mLastTime = j;
    }

    public void ez(long j) {
        this.iKQ = Calendar.getInstance();
        this.iKQ.setTimeInMillis(1000 * j);
    }

    private boolean eA(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String eB(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.iKQ != null && this.iKQ.get(1) == calendar.get(1) && this.iKQ.get(6) == calendar.get(6)) {
            return ar.getDateStringHm(calendar.getTime());
        }
        return ar.getDateStringMdHm(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.mId = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.fqs = (TextView) findViewById(R.id.tex_msgitem_time);
        this.iKS = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.iKS.setLinkTextColor(-14845754);
        this.iKZ = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.iKV = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.iKW = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.iKX = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.iKY = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.iKT = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.iKT.setClickable(true);
        this.iKT.setOnClickListener(this.iKT);
        this.iKT.setLongClickable(true);
        this.iKT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iKx.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iKZ.getImage().setClickable(true);
        this.iKZ.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iKw.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.iKZ.getImage().setLongClickable(true);
        this.iKZ.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iKx.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iKZ.getTail().setClickable(true);
        this.iKZ.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iKw.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.iKS.setLongClickable(true);
        this.iKS.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iKx.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iKU = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.iKU.setSupportNoImage(false);
        this.iKU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iKw.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.iKU.setLongClickable(true);
        this.iKU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iKx.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iKW.setClickable(true);
        this.iKW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iKw.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.iKW.setLongClickable(true);
        this.iKW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iKx.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iKX.setClickable(true);
        this.iKX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iKw.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.iKX.setLongClickable(true);
        this.iKX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iKx.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iKY.getContentBody().setClickable(true);
        this.iKY.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iKw.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.iKY.getTail().setClickable(true);
        this.iKY.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iKw.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.iKY.getContentBody().setLongClickable(true);
        this.iKY.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iKx.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.iKV != null) {
            this.iKV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.iKx.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xZ(int i) {
        this.iKZ.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean eA = eA(chatMessage.getTime());
        if (z || eA) {
            this.fqs.setVisibility(0);
            this.fqs.setText(eB(chatMessage.getTime()));
        } else {
            this.fqs.setVisibility(8);
        }
        if (!z && eA) {
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
        j.a(this.mContext.getContext(), this.iKS, chatMessage, str, this.iKF);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.iKS.setContentDescription(stringBuffer.toString());
            this.iKS.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.iKZ, chatMessage, this.iKR, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.iKT, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.iKU, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.iKV, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.iKW, this.iKX, this.iKY, chatMessage, str);
    }

    public void oU(boolean z) {
        this.iLa = z;
    }

    public void oV(boolean z) {
        this.iLb = z;
    }

    public void xY(int i) {
        this.iKF = i;
    }
}
