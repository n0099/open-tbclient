package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
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
    protected TextView faX;
    protected com.baidu.adp.lib.c.b gsA;
    protected int gsJ;
    private Calendar gsU;
    protected long gsV;
    protected Long gsW;
    protected TbRichTextView gsX;
    protected ChatVoiceView gsY;
    protected GifView gsZ;
    protected com.baidu.adp.lib.c.a gsz;
    protected Invite2GroupView gta;
    protected ShareFromPBView gtb;
    protected ShareFromFrsView gtc;
    protected ShareFromGameCenter gtd;
    protected ChatImageWithTailView gte;
    protected boolean gtf;
    protected boolean gtg;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.gsz = null;
        this.gsA = null;
        this.mPosition = 0;
        this.gsV = 0L;
        this.gsW = null;
        this.gtf = true;
        this.gtg = false;
        this.mLastTime = 0L;
        this.gsU = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gsz = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gsA = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void dq(long j) {
        this.mLastTime = j;
    }

    public void dr(long j) {
        this.gsU = Calendar.getInstance();
        this.gsU.setTimeInMillis(1000 * j);
    }

    private boolean ds(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String dt(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.gsU != null && this.gsU.get(1) == calendar.get(1) && this.gsU.get(6) == calendar.get(6)) {
            return ap.b(calendar.getTime());
        }
        return ap.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.gsW = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.faX = (TextView) findViewById(R.id.tex_msgitem_time);
        this.gsX = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.gsX.setLinkTextColor(-14845754);
        this.gte = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.gta = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.gtb = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.gtc = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.gtd = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.gsY = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.gsY.setClickable(true);
        this.gsY.setOnClickListener(this.gsY);
        this.gsY.setLongClickable(true);
        this.gsY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsA.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gte.getImage().setClickable(true);
        this.gte.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsz.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.gte.getImage().setLongClickable(true);
        this.gte.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsA.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gte.getTail().setClickable(true);
        this.gte.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsz.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.gsX.setLongClickable(true);
        this.gsX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsA.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gsZ = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.gsZ.setSupportNoImage(false);
        this.gsZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsz.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.gsZ.setLongClickable(true);
        this.gsZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsA.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gtb.setClickable(true);
        this.gtb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsz.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.gtb.setLongClickable(true);
        this.gtb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsA.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gtc.setClickable(true);
        this.gtc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsz.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.gtc.setLongClickable(true);
        this.gtc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsA.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gtd.getContentBody().setClickable(true);
        this.gtd.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsz.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.gtd.getTail().setClickable(true);
        this.gtd.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsz.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.gtd.getContentBody().setLongClickable(true);
        this.gtd.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsA.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.gta != null) {
            this.gta.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.gsA.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uD(int i) {
        this.gte.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean ds = ds(chatMessage.getTime());
        if (z || ds) {
            this.faX.setVisibility(0);
            this.faX.setText(dt(chatMessage.getTime()));
        } else {
            this.faX.setVisibility(8);
        }
        if (!z && ds) {
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
        j.a(this.mContext.getContext(), this.gsX, chatMessage, str, this.gsJ);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.gsX.setContentDescription(stringBuffer.toString());
            this.gsX.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gte, chatMessage, this.gsV, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.gsY, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.gsZ, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.gta, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gtb, this.gtc, this.gtd, chatMessage, str);
    }

    public void lw(boolean z) {
        this.gtf = z;
    }

    public void lx(boolean z) {
        this.gtg = z;
    }

    public void uC(int i) {
        this.gsJ = i;
    }
}
