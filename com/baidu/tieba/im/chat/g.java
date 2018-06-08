package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
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
    protected TextView cXR;
    protected com.baidu.adp.lib.c.a ecQ;
    protected com.baidu.adp.lib.c.b ecR;
    protected int eda;
    private Calendar edl;
    protected long edm;
    protected Long edn;
    protected TbRichTextView edo;
    protected ChatVoiceView edp;
    protected GifView edq;
    protected Invite2GroupView edr;
    protected ShareFromPBView eds;
    protected ShareFromFrsView edt;
    protected ShareFromGameCenter edu;
    protected ChatImageWithTailView edv;
    protected boolean edw;
    protected boolean edx;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.ecQ = null;
        this.ecR = null;
        this.mPosition = 0;
        this.edm = 0L;
        this.edn = null;
        this.edw = true;
        this.edx = false;
        this.mLastTime = 0L;
        this.edl = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.ecQ = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ecR = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void bV(long j) {
        this.mLastTime = j;
    }

    public void bW(long j) {
        this.edl = Calendar.getInstance();
        this.edl.setTimeInMillis(1000 * j);
    }

    private boolean bX(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String bY(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.edl != null && this.edl.get(1) == calendar.get(1) && this.edl.get(6) == calendar.get(6)) {
            return ao.c(calendar.getTime());
        }
        return ao.b(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.edn = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cXR = (TextView) findViewById(d.g.tex_msgitem_time);
        this.edo = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.edo.setLinkTextColor(-14845754);
        this.edv = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.edr = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.eds = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.edt = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.edu = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.edp = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.edp.setClickable(true);
        this.edp.setOnClickListener(this.edp);
        this.edp.setLongClickable(true);
        this.edp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ecR.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.edv.getImage().setClickable(true);
        this.edv.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ecQ.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.edv.getImage().setLongClickable(true);
        this.edv.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ecR.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.edv.getTail().setClickable(true);
        this.edv.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ecQ.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.edo.setLongClickable(true);
        this.edo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ecR.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.edq = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.edq.setSupportNoImage(false);
        this.edq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ecQ.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.edq.setLongClickable(true);
        this.edq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ecR.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eds.setClickable(true);
        this.eds.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ecQ.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.eds.setLongClickable(true);
        this.eds.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ecR.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.edt.setClickable(true);
        this.edt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ecQ.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.edt.setLongClickable(true);
        this.edt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ecR.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.edu.getContentBody().setClickable(true);
        this.edu.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ecQ.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.edu.getTail().setClickable(true);
        this.edu.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ecQ.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.edu.getContentBody().setLongClickable(true);
        this.edu.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.ecR.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.edr != null) {
            this.edr.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.ecR.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ns(int i) {
        this.edv.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bX = bX(chatMessage.getTime());
        if (z || bX) {
            this.cXR.setVisibility(0);
            this.cXR.setText(bY(chatMessage.getTime()));
        } else {
            this.cXR.setVisibility(8);
        }
        if (!z && bX) {
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
        j.a(this.mContext.getContext(), this.edo, chatMessage, str, this.eda);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.edo.setContentDescription(stringBuffer.toString());
            this.edo.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.edv, chatMessage, this.edm, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.edp, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.edq, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.edr, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eds, this.edt, this.edu, chatMessage, str);
    }

    public void gP(boolean z) {
        this.edw = z;
    }

    public void gQ(boolean z) {
        this.edx = z;
    }

    public void nr(int i) {
        this.eda = i;
    }
}
