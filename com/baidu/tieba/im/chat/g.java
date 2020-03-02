package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
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
    protected TextView eoi;
    private Calendar hsJ;
    protected long hsK;
    protected TbRichTextView hsL;
    protected ChatVoiceView hsM;
    protected GifView hsN;
    protected Invite2GroupView hsO;
    protected ShareFromPBView hsP;
    protected ShareFromFrsView hsQ;
    protected ShareFromGameCenter hsR;
    protected ChatImageWithTailView hsS;
    protected boolean hsT;
    protected boolean hsU;
    protected com.baidu.adp.lib.b.a hsp;
    protected com.baidu.adp.lib.b.b hsq;
    protected int hsy;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.hsp = null;
        this.hsq = null;
        this.mPosition = 0;
        this.hsK = 0L;
        this.mId = null;
        this.hsT = true;
        this.hsU = false;
        this.mLastTime = 0L;
        this.hsJ = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.hsp = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.hsq = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void dK(long j) {
        this.mLastTime = j;
    }

    public void dL(long j) {
        this.hsJ = Calendar.getInstance();
        this.hsJ.setTimeInMillis(1000 * j);
    }

    private boolean dM(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String dN(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.hsJ != null && this.hsJ.get(1) == calendar.get(1) && this.hsJ.get(6) == calendar.get(6)) {
            return aq.getDateStringHm(calendar.getTime());
        }
        return aq.getDateStringMdHm(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.mId = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.eoi = (TextView) findViewById(R.id.tex_msgitem_time);
        this.hsL = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.hsL.setLinkTextColor(-14845754);
        this.hsS = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.hsO = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.hsP = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.hsQ = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.hsR = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.hsM = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.hsM.setClickable(true);
        this.hsM.setOnClickListener(this.hsM);
        this.hsM.setLongClickable(true);
        this.hsM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hsq.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hsS.getImage().setClickable(true);
        this.hsS.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsp.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.hsS.getImage().setLongClickable(true);
        this.hsS.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hsq.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hsS.getTail().setClickable(true);
        this.hsS.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsp.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.hsL.setLongClickable(true);
        this.hsL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hsq.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hsN = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.hsN.setSupportNoImage(false);
        this.hsN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsp.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.hsN.setLongClickable(true);
        this.hsN.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hsq.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hsP.setClickable(true);
        this.hsP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsp.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.hsP.setLongClickable(true);
        this.hsP.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hsq.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hsQ.setClickable(true);
        this.hsQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsp.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.hsQ.setLongClickable(true);
        this.hsQ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hsq.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hsR.getContentBody().setClickable(true);
        this.hsR.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsp.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.hsR.getTail().setClickable(true);
        this.hsR.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsp.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.hsR.getContentBody().setLongClickable(true);
        this.hsR.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hsq.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.hsO != null) {
            this.hsO.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.hsq.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wb(int i) {
        this.hsS.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean dM = dM(chatMessage.getTime());
        if (z || dM) {
            this.eoi.setVisibility(0);
            this.eoi.setText(dN(chatMessage.getTime()));
        } else {
            this.eoi.setVisibility(8);
        }
        if (!z && dM) {
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
        j.a(this.mContext.getContext(), this.hsL, chatMessage, str, this.hsy);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.hsL.setContentDescription(stringBuffer.toString());
            this.hsL.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.hsS, chatMessage, this.hsK, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.hsM, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.hsN, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.hsO, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.hsP, this.hsQ, this.hsR, chatMessage, str);
    }

    public void ne(boolean z) {
        this.hsT = z;
    }

    public void nf(boolean z) {
        this.hsU = z;
    }

    public void wa(int i) {
        this.hsy = i;
    }
}
