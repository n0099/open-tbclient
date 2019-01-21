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
    protected TextView dxK;
    protected int eLD;
    private Calendar eLO;
    protected long eLP;
    protected Long eLQ;
    protected TbRichTextView eLR;
    protected ChatVoiceView eLS;
    protected GifView eLT;
    protected Invite2GroupView eLU;
    protected ShareFromPBView eLV;
    protected ShareFromFrsView eLW;
    protected ShareFromGameCenter eLX;
    protected ChatImageWithTailView eLY;
    protected boolean eLZ;
    protected com.baidu.adp.lib.c.a eLt;
    protected com.baidu.adp.lib.c.b eLu;
    protected boolean eMa;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.eLt = null;
        this.eLu = null;
        this.mPosition = 0;
        this.eLP = 0L;
        this.eLQ = null;
        this.eLZ = true;
        this.eMa = false;
        this.mLastTime = 0L;
        this.eLO = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.eLt = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.eLu = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void co(long j) {
        this.mLastTime = j;
    }

    public void cp(long j) {
        this.eLO = Calendar.getInstance();
        this.eLO.setTimeInMillis(1000 * j);
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
        if (this.eLO != null && this.eLO.get(1) == calendar.get(1) && this.eLO.get(6) == calendar.get(6)) {
            return ao.b(calendar.getTime());
        }
        return ao.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.eLQ = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dxK = (TextView) findViewById(e.g.tex_msgitem_time);
        this.eLR = (TbRichTextView) findViewById(e.g.tex_msgitem_text);
        this.eLR.setLinkTextColor(-14845754);
        this.eLY = (ChatImageWithTailView) findViewById(e.g.img_msgitem_image);
        this.eLU = (Invite2GroupView) findViewById(e.g.lay_msgitem_invite_view);
        this.eLV = (ShareFromPBView) findViewById(e.g.lay_msgitem_share_view);
        this.eLW = (ShareFromFrsView) findViewById(e.g.lay_msgitem_share_frs);
        this.eLX = (ShareFromGameCenter) findViewById(e.g.lay_msgitem_share_game);
        this.eLS = (ChatVoiceView) findViewById(e.g.lay_msgitem_voice);
        this.eLS.setClickable(true);
        this.eLS.setOnClickListener(this.eLS);
        this.eLS.setLongClickable(true);
        this.eLS.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eLu.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLY.getImage().setClickable(true);
        this.eLY.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eLt.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.eLY.getImage().setLongClickable(true);
        this.eLY.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eLu.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLY.getTail().setClickable(true);
        this.eLY.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eLt.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.eLR.setLongClickable(true);
        this.eLR.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eLu.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLT = (GifView) findViewById(e.g.emotion_msgitem_image);
        this.eLT.setSupportNoImage(false);
        this.eLT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eLt.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.eLT.setLongClickable(true);
        this.eLT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eLu.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLV.setClickable(true);
        this.eLV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eLt.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.eLV.setLongClickable(true);
        this.eLV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eLu.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLW.setClickable(true);
        this.eLW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eLt.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.eLW.setLongClickable(true);
        this.eLW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eLu.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eLX.getContentBody().setClickable(true);
        this.eLX.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eLt.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.eLX.getTail().setClickable(true);
        this.eLX.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eLt.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.eLX.getContentBody().setLongClickable(true);
        this.eLX.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eLu.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.eLU != null) {
            this.eLU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.eLu.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pQ(int i) {
        this.eLY.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean cq = cq(chatMessage.getTime());
        if (z || cq) {
            this.dxK.setVisibility(0);
            this.dxK.setText(cr(chatMessage.getTime()));
        } else {
            this.dxK.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.eLR, chatMessage, str, this.eLD);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.eLR.setContentDescription(stringBuffer.toString());
            this.eLR.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eLY, chatMessage, this.eLP, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.eLS, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.eLT, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.eLU, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eLV, this.eLW, this.eLX, chatMessage, str);
    }

    public void ih(boolean z) {
        this.eLZ = z;
    }

    public void ii(boolean z) {
        this.eMa = z;
    }

    public void pP(int i) {
        this.eLD = i;
    }
}
