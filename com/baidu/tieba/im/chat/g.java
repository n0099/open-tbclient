package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
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
    protected TextView drN;
    protected int gBF;
    private Calendar gBQ;
    protected long gBR;
    protected Long gBS;
    protected TbRichTextView gBT;
    protected ChatVoiceView gBU;
    protected GifView gBV;
    protected Invite2GroupView gBW;
    protected ShareFromPBView gBX;
    protected ShareFromFrsView gBY;
    protected ShareFromGameCenter gBZ;
    protected com.baidu.adp.lib.c.a gBv;
    protected com.baidu.adp.lib.c.b gBw;
    protected ChatImageWithTailView gCa;
    protected boolean gCb;
    protected boolean gCc;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.gBv = null;
        this.gBw = null;
        this.mPosition = 0;
        this.gBR = 0L;
        this.gBS = null;
        this.gCb = true;
        this.gCc = false;
        this.mLastTime = 0L;
        this.gBQ = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gBv = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gBw = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void dD(long j) {
        this.mLastTime = j;
    }

    public void dE(long j) {
        this.gBQ = Calendar.getInstance();
        this.gBQ.setTimeInMillis(1000 * j);
    }

    private boolean dF(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String dG(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.gBQ != null && this.gBQ.get(1) == calendar.get(1) && this.gBQ.get(6) == calendar.get(6)) {
            return aq.b(calendar.getTime());
        }
        return aq.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.gBS = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.drN = (TextView) findViewById(R.id.tex_msgitem_time);
        this.gBT = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.gBT.setLinkTextColor(-14845754);
        this.gCa = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.gBW = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.gBX = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.gBY = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.gBZ = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.gBU = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.gBU.setClickable(true);
        this.gBU.setOnClickListener(this.gBU);
        this.gBU.setLongClickable(true);
        this.gBU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gBw.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gCa.getImage().setClickable(true);
        this.gCa.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gBv.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.gCa.getImage().setLongClickable(true);
        this.gCa.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gBw.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gCa.getTail().setClickable(true);
        this.gCa.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gBv.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.gBT.setLongClickable(true);
        this.gBT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gBw.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gBV = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.gBV.setSupportNoImage(false);
        this.gBV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gBv.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.gBV.setLongClickable(true);
        this.gBV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gBw.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gBX.setClickable(true);
        this.gBX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gBv.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.gBX.setLongClickable(true);
        this.gBX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gBw.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gBY.setClickable(true);
        this.gBY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gBv.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.gBY.setLongClickable(true);
        this.gBY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gBw.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gBZ.getContentBody().setClickable(true);
        this.gBZ.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gBv.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.gBZ.getTail().setClickable(true);
        this.gBZ.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gBv.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.gBZ.getContentBody().setLongClickable(true);
        this.gBZ.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gBw.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.gBW != null) {
            this.gBW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.gBw.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vk(int i) {
        this.gCa.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean dF = dF(chatMessage.getTime());
        if (z || dF) {
            this.drN.setVisibility(0);
            this.drN.setText(dG(chatMessage.getTime()));
        } else {
            this.drN.setVisibility(8);
        }
        if (!z && dF) {
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
        j.a(this.mContext.getContext(), this.gBT, chatMessage, str, this.gBF);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.gBT.setContentDescription(stringBuffer.toString());
            this.gBT.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gCa, chatMessage, this.gBR, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.gBU, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.gBV, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.gBW, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gBX, this.gBY, this.gBZ, chatMessage, str);
    }

    public void lO(boolean z) {
        this.gCb = z;
    }

    public void lP(boolean z) {
        this.gCc = z;
    }

    public void vj(int i) {
        this.gBF = i;
    }
}
