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
    protected TextView dxJ;
    protected int eLC;
    private Calendar eLN;
    protected long eLO;
    protected Long eLP;
    protected TbRichTextView eLQ;
    protected ChatVoiceView eLR;
    protected GifView eLS;
    protected Invite2GroupView eLT;
    protected ShareFromPBView eLU;
    protected ShareFromFrsView eLV;
    protected ShareFromGameCenter eLW;
    protected ChatImageWithTailView eLX;
    protected boolean eLY;
    protected boolean eLZ;
    protected com.baidu.adp.lib.c.a eLs;
    protected com.baidu.adp.lib.c.b eLt;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.eLs = null;
        this.eLt = null;
        this.mPosition = 0;
        this.eLO = 0L;
        this.eLP = null;
        this.eLY = true;
        this.eLZ = false;
        this.mLastTime = 0L;
        this.eLN = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.eLs = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.eLt = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void co(long j) {
        this.mLastTime = j;
    }

    public void cp(long j) {
        this.eLN = Calendar.getInstance();
        this.eLN.setTimeInMillis(1000 * j);
    }

    private boolean cq(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String cr(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.eLN != null && this.eLN.get(1) == calendar.get(1) && this.eLN.get(6) == calendar.get(6)) {
            return ao.b(calendar.getTime());
        }
        return ao.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.eLP = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dxJ = (TextView) findViewById(e.g.tex_msgitem_time);
        this.eLQ = (TbRichTextView) findViewById(e.g.tex_msgitem_text);
        this.eLQ.setLinkTextColor(-14845754);
        this.eLX = (ChatImageWithTailView) findViewById(e.g.img_msgitem_image);
        this.eLT = (Invite2GroupView) findViewById(e.g.lay_msgitem_invite_view);
        this.eLU = (ShareFromPBView) findViewById(e.g.lay_msgitem_share_view);
        this.eLV = (ShareFromFrsView) findViewById(e.g.lay_msgitem_share_frs);
        this.eLW = (ShareFromGameCenter) findViewById(e.g.lay_msgitem_share_game);
        this.eLR = (ChatVoiceView) findViewById(e.g.lay_msgitem_voice);
        this.eLR.setClickable(true);
        this.eLR.setOnClickListener(this.eLR);
        this.eLR.setLongClickable(true);
        this.eLR.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eLt.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLX.getImage().setClickable(true);
        this.eLX.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eLs.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.eLX.getImage().setLongClickable(true);
        this.eLX.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eLt.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLX.getTail().setClickable(true);
        this.eLX.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eLs.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.eLQ.setLongClickable(true);
        this.eLQ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eLt.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLS = (GifView) findViewById(e.g.emotion_msgitem_image);
        this.eLS.setSupportNoImage(false);
        this.eLS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eLs.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.eLS.setLongClickable(true);
        this.eLS.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eLt.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLU.setClickable(true);
        this.eLU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eLs.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.eLU.setLongClickable(true);
        this.eLU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eLt.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLV.setClickable(true);
        this.eLV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eLs.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.eLV.setLongClickable(true);
        this.eLV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eLt.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLW.getContentBody().setClickable(true);
        this.eLW.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eLs.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.eLW.getTail().setClickable(true);
        this.eLW.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eLs.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.eLW.getContentBody().setLongClickable(true);
        this.eLW.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eLt.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.eLT != null) {
            this.eLT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.eLt.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pQ(int i) {
        this.eLX.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean cq = cq(chatMessage.getTime());
        if (z || cq) {
            this.dxJ.setVisibility(0);
            this.dxJ.setText(cr(chatMessage.getTime()));
        } else {
            this.dxJ.setVisibility(8);
        }
        if (!z && cq) {
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
        j.a(this.mContext.getContext(), this.eLQ, chatMessage, str, this.eLC);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.eLQ.setContentDescription(stringBuffer.toString());
            this.eLQ.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eLX, chatMessage, this.eLO, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.eLR, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.eLS, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.eLT, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eLU, this.eLV, this.eLW, chatMessage, str);
    }

    public void ih(boolean z) {
        this.eLY = z;
    }

    public void ii(boolean z) {
        this.eLZ = z;
    }

    public void pP(int i) {
        this.eLC = i;
    }
}
