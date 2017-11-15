package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.base.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
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
public class g extends b<MsglistActivity<?>> {
    protected TextView cpT;
    protected com.baidu.adp.lib.c.a duO;
    protected com.baidu.adp.lib.c.b duP;
    protected int duY;
    private Calendar dvj;
    protected long dvk;
    protected Long dvl;
    protected TbRichTextView dvm;
    protected ChatVoiceView dvn;
    protected GifView dvo;
    protected Invite2GroupView dvp;
    protected ShareFromPBView dvq;
    protected ShareFromFrsView dvr;
    protected ShareFromGameCenter dvs;
    protected ChatImageWithTailView dvt;
    protected boolean dvu;
    protected boolean dvv;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.duO = null;
        this.duP = null;
        this.mPosition = 0;
        this.dvk = 0L;
        this.dvl = null;
        this.dvu = true;
        this.dvv = false;
        this.mLastTime = 0L;
        this.dvj = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.duO = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.duP = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bA(long j) {
        this.mLastTime = j;
    }

    public void bB(long j) {
        this.dvj = Calendar.getInstance();
        this.dvj.setTimeInMillis(1000 * j);
    }

    private boolean bC(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String bD(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.dvj != null && this.dvj.get(1) == calendar.get(1) && this.dvj.get(6) == calendar.get(6)) {
            return am.b(calendar.getTime());
        }
        return am.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.dvl = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cpT = (TextView) findViewById(d.g.tex_msgitem_time);
        this.dvm = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.dvm.setLinkTextColor(-14845754);
        this.dvt = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.dvp = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.dvq = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.dvr = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.dvs = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.dvn = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.dvn.setClickable(true);
        this.dvn.setOnClickListener(this.dvn);
        this.dvn.setLongClickable(true);
        this.dvn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.duP.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dvt.getImage().setClickable(true);
        this.dvt.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.duO.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.dvt.getImage().setLongClickable(true);
        this.dvt.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.duP.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dvt.getTail().setClickable(true);
        this.dvt.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.duO.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.dvm.setLongClickable(true);
        this.dvm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.duP.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dvo = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.dvo.setSupportNoImage(false);
        this.dvo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.duO.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.dvo.setLongClickable(true);
        this.dvo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.duP.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dvq.setClickable(true);
        this.dvq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.duO.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.dvq.setLongClickable(true);
        this.dvq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.duP.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dvr.setClickable(true);
        this.dvr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.duO.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.dvr.setLongClickable(true);
        this.dvr.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.duP.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.dvs.getContentBody().setClickable(true);
        this.dvs.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.duO.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.dvs.getTail().setClickable(true);
        this.dvs.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.duO.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.dvs.getContentBody().setLongClickable(true);
        this.dvs.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.duP.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.dvp != null) {
            this.dvp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.duP.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mB(int i) {
        this.dvt.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bC = bC(chatMessage.getTime());
        if (z || bC) {
            this.cpT.setVisibility(0);
            this.cpT.setText(bD(chatMessage.getTime()));
        } else {
            this.cpT.setVisibility(8);
        }
        if (!z && bC) {
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
        j.a(this.mContext.getContext(), this.dvm, chatMessage, str, this.duY);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.dvm.setContentDescription(stringBuffer.toString());
            this.dvm.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dvt, chatMessage, this.dvk, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.dvn, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.dvo, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.dvp, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dvq, this.dvr, this.dvs, chatMessage, str);
    }

    public void fT(boolean z) {
        this.dvu = z;
    }

    public void fU(boolean z) {
        this.dvv = z;
    }

    public void mA(int i) {
        this.duY = i;
    }
}
