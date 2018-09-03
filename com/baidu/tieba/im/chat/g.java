package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.f;
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
    protected TextView cYF;
    protected int ekG;
    private Calendar ekR;
    protected long ekS;
    protected Long ekT;
    protected TbRichTextView ekU;
    protected ChatVoiceView ekV;
    protected GifView ekW;
    protected Invite2GroupView ekX;
    protected ShareFromPBView ekY;
    protected ShareFromFrsView ekZ;
    protected com.baidu.adp.lib.c.a ekw;
    protected com.baidu.adp.lib.c.b ekx;
    protected ShareFromGameCenter ela;
    protected ChatImageWithTailView elb;
    protected boolean elc;
    protected boolean eld;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.ekw = null;
        this.ekx = null;
        this.mPosition = 0;
        this.ekS = 0L;
        this.ekT = null;
        this.elc = true;
        this.eld = false;
        this.mLastTime = 0L;
        this.ekR = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.ekw = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ekx = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bW(long j) {
        this.mLastTime = j;
    }

    public void bX(long j) {
        this.ekR = Calendar.getInstance();
        this.ekR.setTimeInMillis(1000 * j);
    }

    private boolean bY(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String bZ(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.ekR != null && this.ekR.get(1) == calendar.get(1) && this.ekR.get(6) == calendar.get(6)) {
            return ap.b(calendar.getTime());
        }
        return ap.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.ekT = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cYF = (TextView) findViewById(f.g.tex_msgitem_time);
        this.ekU = (TbRichTextView) findViewById(f.g.tex_msgitem_text);
        this.ekU.setLinkTextColor(-14845754);
        this.elb = (ChatImageWithTailView) findViewById(f.g.img_msgitem_image);
        this.ekX = (Invite2GroupView) findViewById(f.g.lay_msgitem_invite_view);
        this.ekY = (ShareFromPBView) findViewById(f.g.lay_msgitem_share_view);
        this.ekZ = (ShareFromFrsView) findViewById(f.g.lay_msgitem_share_frs);
        this.ela = (ShareFromGameCenter) findViewById(f.g.lay_msgitem_share_game);
        this.ekV = (ChatVoiceView) findViewById(f.g.lay_msgitem_voice);
        this.ekV.setClickable(true);
        this.ekV.setOnClickListener(this.ekV);
        this.ekV.setLongClickable(true);
        this.ekV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ekx.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.elb.getImage().setClickable(true);
        this.elb.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ekw.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.elb.getImage().setLongClickable(true);
        this.elb.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ekx.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.elb.getTail().setClickable(true);
        this.elb.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ekw.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.ekU.setLongClickable(true);
        this.ekU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ekx.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ekW = (GifView) findViewById(f.g.emotion_msgitem_image);
        this.ekW.setSupportNoImage(false);
        this.ekW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ekw.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.ekW.setLongClickable(true);
        this.ekW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ekx.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ekY.setClickable(true);
        this.ekY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ekw.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.ekY.setLongClickable(true);
        this.ekY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ekx.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ekZ.setClickable(true);
        this.ekZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ekw.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.ekZ.setLongClickable(true);
        this.ekZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ekx.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ela.getContentBody().setClickable(true);
        this.ela.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ekw.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.ela.getTail().setClickable(true);
        this.ela.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ekw.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.ela.getContentBody().setLongClickable(true);
        this.ela.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ekx.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.ekX != null) {
            this.ekX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.ekx.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nN(int i) {
        this.elb.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bY = bY(chatMessage.getTime());
        if (z || bY) {
            this.cYF.setVisibility(0);
            this.cYF.setText(bZ(chatMessage.getTime()));
        } else {
            this.cYF.setVisibility(8);
        }
        if (!z && bY) {
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
        j.a(this.mContext.getContext(), this.ekU, chatMessage, str, this.ekG);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.ekU.setContentDescription(stringBuffer.toString());
            this.ekU.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.elb, chatMessage, this.ekS, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.ekV, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.ekW, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.ekX, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.ekY, this.ekZ, this.ela, chatMessage, str);
    }

    public void hc(boolean z) {
        this.elc = z;
    }

    public void hd(boolean z) {
        this.eld = z;
    }

    public void nM(int i) {
        this.ekG = i;
    }
}
