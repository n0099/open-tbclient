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
    protected TextView eLa;
    protected int gbE;
    private Calendar gbP;
    protected long gbQ;
    protected Long gbR;
    protected TbRichTextView gbS;
    protected ChatVoiceView gbT;
    protected GifView gbU;
    protected Invite2GroupView gbV;
    protected ShareFromPBView gbW;
    protected ShareFromFrsView gbX;
    protected ShareFromGameCenter gbY;
    protected ChatImageWithTailView gbZ;
    protected com.baidu.adp.lib.c.a gbu;
    protected com.baidu.adp.lib.c.b gbv;
    protected boolean gca;
    protected boolean gcb;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.gbu = null;
        this.gbv = null;
        this.mPosition = 0;
        this.gbQ = 0L;
        this.gbR = null;
        this.gca = true;
        this.gcb = false;
        this.mLastTime = 0L;
        this.gbP = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gbu = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gbv = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void cT(long j) {
        this.mLastTime = j;
    }

    public void cU(long j) {
        this.gbP = Calendar.getInstance();
        this.gbP.setTimeInMillis(1000 * j);
    }

    private boolean cV(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String cW(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.gbP != null && this.gbP.get(1) == calendar.get(1) && this.gbP.get(6) == calendar.get(6)) {
            return ap.b(calendar.getTime());
        }
        return ap.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.gbR = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.eLa = (TextView) findViewById(d.g.tex_msgitem_time);
        this.gbS = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.gbS.setLinkTextColor(-14845754);
        this.gbZ = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.gbV = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.gbW = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.gbX = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.gbY = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.gbT = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.gbT.setClickable(true);
        this.gbT.setOnClickListener(this.gbT);
        this.gbT.setLongClickable(true);
        this.gbT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbv.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbZ.getImage().setClickable(true);
        this.gbZ.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbu.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.gbZ.getImage().setLongClickable(true);
        this.gbZ.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbv.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbZ.getTail().setClickable(true);
        this.gbZ.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbu.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.gbS.setLongClickable(true);
        this.gbS.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbv.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbU = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.gbU.setSupportNoImage(false);
        this.gbU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbu.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.gbU.setLongClickable(true);
        this.gbU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbv.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbW.setClickable(true);
        this.gbW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbu.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.gbW.setLongClickable(true);
        this.gbW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbv.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbX.setClickable(true);
        this.gbX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbu.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.gbX.setLongClickable(true);
        this.gbX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbv.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbY.getContentBody().setClickable(true);
        this.gbY.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbu.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.gbY.getTail().setClickable(true);
        this.gbY.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbu.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.gbY.getContentBody().setLongClickable(true);
        this.gbY.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbv.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.gbV != null) {
            this.gbV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.gbv.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tA(int i) {
        this.gbZ.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean cV = cV(chatMessage.getTime());
        if (z || cV) {
            this.eLa.setVisibility(0);
            this.eLa.setText(cW(chatMessage.getTime()));
        } else {
            this.eLa.setVisibility(8);
        }
        if (!z && cV) {
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
        j.a(this.mContext.getContext(), this.gbS, chatMessage, str, this.gbE);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.gbS.setContentDescription(stringBuffer.toString());
            this.gbS.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gbZ, chatMessage, this.gbQ, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.gbT, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.gbU, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.gbV, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gbW, this.gbX, this.gbY, chatMessage, str);
    }

    public void kH(boolean z) {
        this.gca = z;
    }

    public void kI(boolean z) {
        this.gcb = z;
    }

    public void tz(int i) {
        this.gbE = i;
    }
}
