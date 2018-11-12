package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
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
    protected TextView dnM;
    protected GifView eBA;
    protected Invite2GroupView eBB;
    protected ShareFromPBView eBC;
    protected ShareFromFrsView eBD;
    protected ShareFromGameCenter eBE;
    protected ChatImageWithTailView eBF;
    protected boolean eBG;
    protected boolean eBH;
    protected com.baidu.adp.lib.c.a eBa;
    protected com.baidu.adp.lib.c.b eBb;
    protected int eBk;
    private Calendar eBv;
    protected long eBw;
    protected Long eBx;
    protected TbRichTextView eBy;
    protected ChatVoiceView eBz;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.eBa = null;
        this.eBb = null;
        this.mPosition = 0;
        this.eBw = 0L;
        this.eBx = null;
        this.eBG = true;
        this.eBH = false;
        this.mLastTime = 0L;
        this.eBv = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.eBa = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.eBb = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void cc(long j) {
        this.mLastTime = j;
    }

    public void cd(long j) {
        this.eBv = Calendar.getInstance();
        this.eBv.setTimeInMillis(1000 * j);
    }

    private boolean ce(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String cf(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.eBv != null && this.eBv.get(1) == calendar.get(1) && this.eBv.get(6) == calendar.get(6)) {
            return ao.b(calendar.getTime());
        }
        return ao.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.eBx = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dnM = (TextView) findViewById(e.g.tex_msgitem_time);
        this.eBy = (TbRichTextView) findViewById(e.g.tex_msgitem_text);
        this.eBy.setLinkTextColor(-14845754);
        this.eBF = (ChatImageWithTailView) findViewById(e.g.img_msgitem_image);
        this.eBB = (Invite2GroupView) findViewById(e.g.lay_msgitem_invite_view);
        this.eBC = (ShareFromPBView) findViewById(e.g.lay_msgitem_share_view);
        this.eBD = (ShareFromFrsView) findViewById(e.g.lay_msgitem_share_frs);
        this.eBE = (ShareFromGameCenter) findViewById(e.g.lay_msgitem_share_game);
        this.eBz = (ChatVoiceView) findViewById(e.g.lay_msgitem_voice);
        this.eBz.setClickable(true);
        this.eBz.setOnClickListener(this.eBz);
        this.eBz.setLongClickable(true);
        this.eBz.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eBb.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eBF.getImage().setClickable(true);
        this.eBF.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eBa.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.eBF.getImage().setLongClickable(true);
        this.eBF.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eBb.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eBF.getTail().setClickable(true);
        this.eBF.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eBa.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.eBy.setLongClickable(true);
        this.eBy.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eBb.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eBA = (GifView) findViewById(e.g.emotion_msgitem_image);
        this.eBA.setSupportNoImage(false);
        this.eBA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eBa.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.eBA.setLongClickable(true);
        this.eBA.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eBb.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eBC.setClickable(true);
        this.eBC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eBa.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.eBC.setLongClickable(true);
        this.eBC.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eBb.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eBD.setClickable(true);
        this.eBD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eBa.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.eBD.setLongClickable(true);
        this.eBD.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eBb.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.eBE.getContentBody().setClickable(true);
        this.eBE.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eBa.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.eBE.getTail().setClickable(true);
        this.eBE.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.eBa.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.eBE.getContentBody().setLongClickable(true);
        this.eBE.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.eBb.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.eBB != null) {
            this.eBB.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.eBb.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ph(int i) {
        this.eBF.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean ce = ce(chatMessage.getTime());
        if (z || ce) {
            this.dnM.setVisibility(0);
            this.dnM.setText(cf(chatMessage.getTime()));
        } else {
            this.dnM.setVisibility(8);
        }
        if (!z && ce) {
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
        j.a(this.mContext.getContext(), this.eBy, chatMessage, str, this.eBk);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.eBy.setContentDescription(stringBuffer.toString());
            this.eBy.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eBF, chatMessage, this.eBw, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.eBz, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.eBA, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.eBB, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.eBC, this.eBD, this.eBE, chatMessage, str);
    }

    public void ib(boolean z) {
        this.eBG = z;
    }

    public void ic(boolean z) {
        this.eBH = z;
    }

    public void pg(int i) {
        this.eBk = i;
    }
}
