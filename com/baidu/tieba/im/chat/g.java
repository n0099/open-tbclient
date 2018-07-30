package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
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
    protected TextView cYJ;
    protected com.baidu.adp.lib.c.a ekA;
    protected com.baidu.adp.lib.c.b ekB;
    protected int ekK;
    private Calendar ekV;
    protected long ekW;
    protected Long ekX;
    protected TbRichTextView ekY;
    protected ChatVoiceView ekZ;
    protected GifView ela;
    protected Invite2GroupView elb;
    protected ShareFromPBView elc;
    protected ShareFromFrsView eld;
    protected ShareFromGameCenter ele;
    protected ChatImageWithTailView elf;
    protected boolean elg;
    protected boolean elh;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.ekA = null;
        this.ekB = null;
        this.mPosition = 0;
        this.ekW = 0L;
        this.ekX = null;
        this.elg = true;
        this.elh = false;
        this.mLastTime = 0L;
        this.ekV = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.ekA = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ekB = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bW(long j) {
        this.mLastTime = j;
    }

    public void bX(long j) {
        this.ekV = Calendar.getInstance();
        this.ekV.setTimeInMillis(1000 * j);
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
        if (this.ekV != null && this.ekV.get(1) == calendar.get(1) && this.ekV.get(6) == calendar.get(6)) {
            return ap.b(calendar.getTime());
        }
        return ap.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.ekX = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cYJ = (TextView) findViewById(d.g.tex_msgitem_time);
        this.ekY = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.ekY.setLinkTextColor(-14845754);
        this.elf = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.elb = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.elc = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.eld = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.ele = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.ekZ = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.ekZ.setClickable(true);
        this.ekZ.setOnClickListener(this.ekZ);
        this.ekZ.setLongClickable(true);
        this.ekZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ekB.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.elf.getImage().setClickable(true);
        this.elf.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ekA.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.elf.getImage().setLongClickable(true);
        this.elf.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ekB.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.elf.getTail().setClickable(true);
        this.elf.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ekA.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.ekY.setLongClickable(true);
        this.ekY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ekB.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ela = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.ela.setSupportNoImage(false);
        this.ela.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ekA.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.ela.setLongClickable(true);
        this.ela.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ekB.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.elc.setClickable(true);
        this.elc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ekA.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.elc.setLongClickable(true);
        this.elc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ekB.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eld.setClickable(true);
        this.eld.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ekA.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.eld.setLongClickable(true);
        this.eld.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ekB.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ele.getContentBody().setClickable(true);
        this.ele.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ekA.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.ele.getTail().setClickable(true);
        this.ele.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ekA.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.ele.getContentBody().setLongClickable(true);
        this.ele.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ekB.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.elb != null) {
            this.elb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.ekB.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nN(int i) {
        this.elf.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bY = bY(chatMessage.getTime());
        if (z || bY) {
            this.cYJ.setVisibility(0);
            this.cYJ.setText(bZ(chatMessage.getTime()));
        } else {
            this.cYJ.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.ekY, chatMessage, str, this.ekK);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.ekY.setContentDescription(stringBuffer.toString());
            this.ekY.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.elf, chatMessage, this.ekW, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.ekZ, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.ela, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.elb, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.elc, this.eld, this.ele, chatMessage, str);
    }

    public void hc(boolean z) {
        this.elg = z;
    }

    public void hd(boolean z) {
        this.elh = z;
    }

    public void nM(int i) {
        this.ekK = i;
    }
}
