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
    protected TextView dpV;
    protected com.baidu.adp.lib.c.a gyM;
    protected com.baidu.adp.lib.c.b gyN;
    protected int gyW;
    private Calendar gzh;
    protected long gzi;
    protected Long gzj;
    protected TbRichTextView gzk;
    protected ChatVoiceView gzl;
    protected GifView gzm;
    protected Invite2GroupView gzn;
    protected ShareFromPBView gzo;
    protected ShareFromFrsView gzp;
    protected ShareFromGameCenter gzq;
    protected ChatImageWithTailView gzr;
    protected boolean gzs;
    protected boolean gzt;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.gyM = null;
        this.gyN = null;
        this.mPosition = 0;
        this.gzi = 0L;
        this.gzj = null;
        this.gzs = true;
        this.gzt = false;
        this.mLastTime = 0L;
        this.gzh = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gyM = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gyN = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void dA(long j) {
        this.mLastTime = j;
    }

    public void dB(long j) {
        this.gzh = Calendar.getInstance();
        this.gzh.setTimeInMillis(1000 * j);
    }

    private boolean dC(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String dD(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.gzh != null && this.gzh.get(1) == calendar.get(1) && this.gzh.get(6) == calendar.get(6)) {
            return aq.b(calendar.getTime());
        }
        return aq.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.gzj = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dpV = (TextView) findViewById(R.id.tex_msgitem_time);
        this.gzk = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.gzk.setLinkTextColor(-14845754);
        this.gzr = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.gzn = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.gzo = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.gzp = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.gzq = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.gzl = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.gzl.setClickable(true);
        this.gzl.setOnClickListener(this.gzl);
        this.gzl.setLongClickable(true);
        this.gzl.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gyN.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzr.getImage().setClickable(true);
        this.gzr.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gyM.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.gzr.getImage().setLongClickable(true);
        this.gzr.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gyN.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzr.getTail().setClickable(true);
        this.gzr.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gyM.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.gzk.setLongClickable(true);
        this.gzk.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gyN.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzm = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.gzm.setSupportNoImage(false);
        this.gzm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gyM.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.gzm.setLongClickable(true);
        this.gzm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gyN.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzo.setClickable(true);
        this.gzo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gyM.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.gzo.setLongClickable(true);
        this.gzo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gyN.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzp.setClickable(true);
        this.gzp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gyM.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.gzp.setLongClickable(true);
        this.gzp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gyN.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzq.getContentBody().setClickable(true);
        this.gzq.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gyM.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.gzq.getTail().setClickable(true);
        this.gzq.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gyM.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.gzq.getContentBody().setLongClickable(true);
        this.gzq.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gyN.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.gzn != null) {
            this.gzn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.gyN.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ve(int i) {
        this.gzr.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean dC = dC(chatMessage.getTime());
        if (z || dC) {
            this.dpV.setVisibility(0);
            this.dpV.setText(dD(chatMessage.getTime()));
        } else {
            this.dpV.setVisibility(8);
        }
        if (!z && dC) {
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
        j.a(this.mContext.getContext(), this.gzk, chatMessage, str, this.gyW);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.gzk.setContentDescription(stringBuffer.toString());
            this.gzk.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gzr, chatMessage, this.gzi, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.gzl, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.gzm, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.gzn, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gzo, this.gzp, this.gzq, chatMessage, str);
    }

    public void lL(boolean z) {
        this.gzs = z;
    }

    public void lM(boolean z) {
        this.gzt = z;
    }

    public void vd(int i) {
        this.gyW = i;
    }
}
