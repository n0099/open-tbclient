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
    protected TextView faW;
    protected int gsI;
    private Calendar gsT;
    protected long gsU;
    protected Long gsV;
    protected TbRichTextView gsW;
    protected ChatVoiceView gsX;
    protected GifView gsY;
    protected Invite2GroupView gsZ;
    protected com.baidu.adp.lib.c.a gsy;
    protected com.baidu.adp.lib.c.b gsz;
    protected ShareFromPBView gta;
    protected ShareFromFrsView gtb;
    protected ShareFromGameCenter gtc;
    protected ChatImageWithTailView gtd;
    protected boolean gte;
    protected boolean gtf;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.gsy = null;
        this.gsz = null;
        this.mPosition = 0;
        this.gsU = 0L;
        this.gsV = null;
        this.gte = true;
        this.gtf = false;
        this.mLastTime = 0L;
        this.gsT = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gsy = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gsz = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void dq(long j) {
        this.mLastTime = j;
    }

    public void dr(long j) {
        this.gsT = Calendar.getInstance();
        this.gsT.setTimeInMillis(1000 * j);
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
        if (this.gsT != null && this.gsT.get(1) == calendar.get(1) && this.gsT.get(6) == calendar.get(6)) {
            return ap.b(calendar.getTime());
        }
        return ap.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.gsV = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.faW = (TextView) findViewById(R.id.tex_msgitem_time);
        this.gsW = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.gsW.setLinkTextColor(-14845754);
        this.gtd = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.gsZ = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.gta = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.gtb = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.gtc = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.gsX = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.gsX.setClickable(true);
        this.gsX.setOnClickListener(this.gsX);
        this.gsX.setLongClickable(true);
        this.gsX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsz.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gtd.getImage().setClickable(true);
        this.gtd.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsy.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.gtd.getImage().setLongClickable(true);
        this.gtd.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsz.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gtd.getTail().setClickable(true);
        this.gtd.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsy.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.gsW.setLongClickable(true);
        this.gsW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsz.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gsY = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.gsY.setSupportNoImage(false);
        this.gsY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsy.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.gsY.setLongClickable(true);
        this.gsY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsz.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gta.setClickable(true);
        this.gta.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsy.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.gta.setLongClickable(true);
        this.gta.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsz.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gtb.setClickable(true);
        this.gtb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsy.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.gtb.setLongClickable(true);
        this.gtb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsz.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gtc.getContentBody().setClickable(true);
        this.gtc.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsy.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.gtc.getTail().setClickable(true);
        this.gtc.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gsy.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.gtc.getContentBody().setLongClickable(true);
        this.gtc.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gsz.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.gsZ != null) {
            this.gsZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.gsz.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uD(int i) {
        this.gtd.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean ds = ds(chatMessage.getTime());
        if (z || ds) {
            this.faW.setVisibility(0);
            this.faW.setText(dt(chatMessage.getTime()));
        } else {
            this.faW.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.gsW, chatMessage, str, this.gsI);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.gsW.setContentDescription(stringBuffer.toString());
            this.gsW.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gtd, chatMessage, this.gsU, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.gsX, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.gsY, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.gsZ, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gta, this.gtb, this.gtc, chatMessage, str);
    }

    public void lw(boolean z) {
        this.gte = z;
    }

    public void lx(boolean z) {
        this.gtf = z;
    }

    public void uC(int i) {
        this.gsI = i;
    }
}
