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
    protected TextView dyg;
    protected com.baidu.adp.lib.c.a gyD;
    protected com.baidu.adp.lib.c.b gyE;
    protected int gyM;
    private Calendar gyX;
    protected long gyY;
    protected Long gyZ;
    protected TbRichTextView gza;
    protected ChatVoiceView gzb;
    protected GifView gzc;
    protected Invite2GroupView gzd;
    protected ShareFromPBView gze;
    protected ShareFromFrsView gzf;
    protected ShareFromGameCenter gzg;
    protected ChatImageWithTailView gzh;
    protected boolean gzi;
    protected boolean gzj;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.gyD = null;
        this.gyE = null;
        this.mPosition = 0;
        this.gyY = 0L;
        this.gyZ = null;
        this.gzi = true;
        this.gzj = false;
        this.mLastTime = 0L;
        this.gyX = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gyD = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gyE = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void cZ(long j) {
        this.mLastTime = j;
    }

    public void da(long j) {
        this.gyX = Calendar.getInstance();
        this.gyX.setTimeInMillis(1000 * j);
    }

    private boolean db(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String dc(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.gyX != null && this.gyX.get(1) == calendar.get(1) && this.gyX.get(6) == calendar.get(6)) {
            return aq.getDateStringHm(calendar.getTime());
        }
        return aq.getDateStringMdHm(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.gyZ = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dyg = (TextView) findViewById(R.id.tex_msgitem_time);
        this.gza = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.gza.setLinkTextColor(-14845754);
        this.gzh = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.gzd = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.gze = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.gzf = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.gzg = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.gzb = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.gzb.setClickable(true);
        this.gzb.setOnClickListener(this.gzb);
        this.gzb.setLongClickable(true);
        this.gzb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gyE.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzh.getImage().setClickable(true);
        this.gzh.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gyD.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.gzh.getImage().setLongClickable(true);
        this.gzh.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gyE.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzh.getTail().setClickable(true);
        this.gzh.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gyD.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.gza.setLongClickable(true);
        this.gza.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gyE.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzc = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.gzc.setSupportNoImage(false);
        this.gzc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gyD.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.gzc.setLongClickable(true);
        this.gzc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gyE.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gze.setClickable(true);
        this.gze.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gyD.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.gze.setLongClickable(true);
        this.gze.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gyE.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzf.setClickable(true);
        this.gzf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gyD.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.gzf.setLongClickable(true);
        this.gzf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gyE.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzg.getContentBody().setClickable(true);
        this.gzg.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gyD.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.gzg.getTail().setClickable(true);
        this.gzg.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gyD.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.gzg.getContentBody().setLongClickable(true);
        this.gzg.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gyE.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.gzd != null) {
            this.gzd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.gyE.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tO(int i) {
        this.gzh.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean db = db(chatMessage.getTime());
        if (z || db) {
            this.dyg.setVisibility(0);
            this.dyg.setText(dc(chatMessage.getTime()));
        } else {
            this.dyg.setVisibility(8);
        }
        if (!z && db) {
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
        j.a(this.mContext.getContext(), this.gza, chatMessage, str, this.gyM);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.gza.setContentDescription(stringBuffer.toString());
            this.gza.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gzh, chatMessage, this.gyY, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.gzb, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.gzc, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.gzd, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gze, this.gzf, this.gzg, chatMessage, str);
    }

    public void lC(boolean z) {
        this.gzi = z;
    }

    public void lD(boolean z) {
        this.gzj = z;
    }

    public void tN(int i) {
        this.gyM = i;
    }
}
