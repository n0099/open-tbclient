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
    protected com.baidu.adp.lib.c.a gsB;
    protected com.baidu.adp.lib.c.b gsC;
    protected int gsL;
    private Calendar gsW;
    protected long gsX;
    protected Long gsY;
    protected TbRichTextView gsZ;
    protected ChatVoiceView gta;
    protected GifView gtb;
    protected Invite2GroupView gtc;
    protected ShareFromPBView gtd;
    protected ShareFromFrsView gte;
    protected ShareFromGameCenter gtf;
    protected ChatImageWithTailView gtg;
    protected boolean gth;
    protected boolean gti;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.gsB = null;
        this.gsC = null;
        this.mPosition = 0;
        this.gsX = 0L;
        this.gsY = null;
        this.gth = true;
        this.gti = false;
        this.mLastTime = 0L;
        this.gsW = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gsB = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gsC = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void dq(long j) {
        this.mLastTime = j;
    }

    public void dr(long j) {
        this.gsW = Calendar.getInstance();
        this.gsW.setTimeInMillis(1000 * j);
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
        if (this.gsW != null && this.gsW.get(1) == calendar.get(1) && this.gsW.get(6) == calendar.get(6)) {
            return ap.b(calendar.getTime());
        }
        return ap.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.gsY = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.faX = (TextView) findViewById(R.id.tex_msgitem_time);
        this.gsZ = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.gsZ.setLinkTextColor(-14845754);
        this.gtg = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.gtc = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.gtd = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.gte = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.gtf = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.gta = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.gta.setClickable(true);
        this.gta.setOnClickListener(this.gta);
        this.gta.setLongClickable(true);
        this.gta.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsC.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gtg.getImage().setClickable(true);
        this.gtg.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsB.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.gtg.getImage().setLongClickable(true);
        this.gtg.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsC.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gtg.getTail().setClickable(true);
        this.gtg.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsB.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.gsZ.setLongClickable(true);
        this.gsZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsC.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gtb = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.gtb.setSupportNoImage(false);
        this.gtb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsB.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.gtb.setLongClickable(true);
        this.gtb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsC.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gtd.setClickable(true);
        this.gtd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsB.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.gtd.setLongClickable(true);
        this.gtd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsC.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gte.setClickable(true);
        this.gte.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsB.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.gte.setLongClickable(true);
        this.gte.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsC.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gtf.getContentBody().setClickable(true);
        this.gtf.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsB.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.gtf.getTail().setClickable(true);
        this.gtf.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsB.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.gtf.getContentBody().setLongClickable(true);
        this.gtf.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsC.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.gtc != null) {
            this.gtc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.gsC.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uD(int i) {
        this.gtg.setVisibility(i);
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
        j.a(this.mContext.getContext(), this.gsZ, chatMessage, str, this.gsL);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.gsZ.setContentDescription(stringBuffer.toString());
            this.gsZ.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gtg, chatMessage, this.gsX, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.gta, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.gtb, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.gtc, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gtd, this.gte, this.gtf, chatMessage, str);
    }

    public void lx(boolean z) {
        this.gth = z;
    }

    public void ly(boolean z) {
        this.gti = z;
    }

    public void uC(int i) {
        this.gsL = i;
    }
}
