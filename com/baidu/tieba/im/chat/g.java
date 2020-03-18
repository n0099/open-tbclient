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
    protected TextView eoM;
    protected Invite2GroupView huA;
    protected ShareFromPBView huB;
    protected ShareFromFrsView huC;
    protected ShareFromGameCenter huD;
    protected ChatImageWithTailView huE;
    protected boolean huF;
    protected boolean huG;
    protected com.baidu.adp.lib.b.a hub;
    protected com.baidu.adp.lib.b.b huc;
    protected int huk;
    private Calendar huv;
    protected long huw;
    protected TbRichTextView hux;
    protected ChatVoiceView huy;
    protected GifView huz;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.hub = null;
        this.huc = null;
        this.mPosition = 0;
        this.huw = 0L;
        this.mId = null;
        this.huF = true;
        this.huG = false;
        this.mLastTime = 0L;
        this.huv = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.hub = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.huc = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void dL(long j) {
        this.mLastTime = j;
    }

    public void dM(long j) {
        this.huv = Calendar.getInstance();
        this.huv.setTimeInMillis(1000 * j);
    }

    private boolean dN(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String dO(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.huv != null && this.huv.get(1) == calendar.get(1) && this.huv.get(6) == calendar.get(6)) {
            return aq.getDateStringHm(calendar.getTime());
        }
        return aq.getDateStringMdHm(calendar.getTime());
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
        this.eoM = (TextView) findViewById(R.id.tex_msgitem_time);
        this.hux = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.hux.setLinkTextColor(-14845754);
        this.huE = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.huA = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.huB = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.huC = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.huD = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.huy = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.huy.setClickable(true);
        this.huy.setOnClickListener(this.huy);
        this.huy.setLongClickable(true);
        this.huy.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.huc.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.huE.getImage().setClickable(true);
        this.huE.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hub.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.huE.getImage().setLongClickable(true);
        this.huE.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.huc.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.huE.getTail().setClickable(true);
        this.huE.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hub.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.hux.setLongClickable(true);
        this.hux.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.huc.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.huz = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.huz.setSupportNoImage(false);
        this.huz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hub.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.huz.setLongClickable(true);
        this.huz.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.huc.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.huB.setClickable(true);
        this.huB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hub.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.huB.setLongClickable(true);
        this.huB.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.huc.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.huC.setClickable(true);
        this.huC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hub.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.huC.setLongClickable(true);
        this.huC.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.huc.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.huD.getContentBody().setClickable(true);
        this.huD.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hub.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.huD.getTail().setClickable(true);
        this.huD.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hub.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.huD.getContentBody().setLongClickable(true);
        this.huD.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.huc.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.huA != null) {
            this.huA.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.huc.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wj(int i) {
        this.huE.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean dN = dN(chatMessage.getTime());
        if (z || dN) {
            this.eoM.setVisibility(0);
            this.eoM.setText(dO(chatMessage.getTime()));
        } else {
            this.eoM.setVisibility(8);
        }
        if (!z && dN) {
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
        j.a(this.mContext.getContext(), this.hux, chatMessage, str, this.huk);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.hux.setContentDescription(stringBuffer.toString());
            this.hux.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.huE, chatMessage, this.huw, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.huy, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.huz, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.huA, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.huB, this.huC, this.huD, chatMessage, str);
    }

    public void nk(boolean z) {
        this.huF = z;
    }

    public void nl(boolean z) {
        this.huG = z;
    }

    public void wi(int i) {
        this.huk = i;
    }
}
