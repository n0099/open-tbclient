package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.base.b;
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
public class g extends b<MsglistActivity<?>> {
    protected TextView eLe;
    protected int gbF;
    private Calendar gbQ;
    protected long gbR;
    protected Long gbS;
    protected TbRichTextView gbT;
    protected ChatVoiceView gbU;
    protected GifView gbV;
    protected Invite2GroupView gbW;
    protected ShareFromPBView gbX;
    protected ShareFromFrsView gbY;
    protected ShareFromGameCenter gbZ;
    protected com.baidu.adp.lib.c.a gbv;
    protected com.baidu.adp.lib.c.b gbw;
    protected ChatImageWithTailView gca;
    protected boolean gcb;
    protected boolean gcc;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.gbv = null;
        this.gbw = null;
        this.mPosition = 0;
        this.gbR = 0L;
        this.gbS = null;
        this.gcb = true;
        this.gcc = false;
        this.mLastTime = 0L;
        this.gbQ = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gbv = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gbw = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void cT(long j) {
        this.mLastTime = j;
    }

    public void cU(long j) {
        this.gbQ = Calendar.getInstance();
        this.gbQ.setTimeInMillis(1000 * j);
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
        if (this.gbQ != null && this.gbQ.get(1) == calendar.get(1) && this.gbQ.get(6) == calendar.get(6)) {
            return ap.b(calendar.getTime());
        }
        return ap.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.gbS = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.eLe = (TextView) findViewById(d.g.tex_msgitem_time);
        this.gbT = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.gbT.setLinkTextColor(-14845754);
        this.gca = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.gbW = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.gbX = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.gbY = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.gbZ = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.gbU = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.gbU.setClickable(true);
        this.gbU.setOnClickListener(this.gbU);
        this.gbU.setLongClickable(true);
        this.gbU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbw.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gca.getImage().setClickable(true);
        this.gca.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbv.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.gca.getImage().setLongClickable(true);
        this.gca.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbw.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gca.getTail().setClickable(true);
        this.gca.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbv.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.gbT.setLongClickable(true);
        this.gbT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbw.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbV = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.gbV.setSupportNoImage(false);
        this.gbV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbv.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.gbV.setLongClickable(true);
        this.gbV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbw.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbX.setClickable(true);
        this.gbX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbv.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.gbX.setLongClickable(true);
        this.gbX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbw.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbY.setClickable(true);
        this.gbY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbv.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.gbY.setLongClickable(true);
        this.gbY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbw.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbZ.getContentBody().setClickable(true);
        this.gbZ.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbv.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.gbZ.getTail().setClickable(true);
        this.gbZ.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbv.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.gbZ.getContentBody().setLongClickable(true);
        this.gbZ.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbw.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.gbW != null) {
            this.gbW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.gbw.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tA(int i) {
        this.gca.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean cV = cV(chatMessage.getTime());
        if (z || cV) {
            this.eLe.setVisibility(0);
            this.eLe.setText(cW(chatMessage.getTime()));
        } else {
            this.eLe.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.gbT, chatMessage, str, this.gbF);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.gbT.setContentDescription(stringBuffer.toString());
            this.gbT.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gca, chatMessage, this.gbR, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.gbU, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.gbV, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.gbW, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gbX, this.gbY, this.gbZ, chatMessage, str);
    }

    public void kH(boolean z) {
        this.gcb = z;
    }

    public void kI(boolean z) {
        this.gcc = z;
    }

    public void tz(int i) {
        this.gbF = i;
    }
}
