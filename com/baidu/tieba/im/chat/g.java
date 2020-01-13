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
    protected TextView ejW;
    private Calendar hqI;
    protected long hqJ;
    protected TbRichTextView hqK;
    protected ChatVoiceView hqL;
    protected GifView hqM;
    protected Invite2GroupView hqN;
    protected ShareFromPBView hqO;
    protected ShareFromFrsView hqP;
    protected ShareFromGameCenter hqQ;
    protected ChatImageWithTailView hqR;
    protected boolean hqS;
    protected boolean hqT;
    protected com.baidu.adp.lib.b.a hqo;
    protected com.baidu.adp.lib.b.b hqp;
    protected int hqx;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.hqo = null;
        this.hqp = null;
        this.mPosition = 0;
        this.hqJ = 0L;
        this.mId = null;
        this.hqS = true;
        this.hqT = false;
        this.mLastTime = 0L;
        this.hqI = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.hqo = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.hqp = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void dK(long j) {
        this.mLastTime = j;
    }

    public void dL(long j) {
        this.hqI = Calendar.getInstance();
        this.hqI.setTimeInMillis(1000 * j);
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
        if (this.hqI != null && this.hqI.get(1) == calendar.get(1) && this.hqI.get(6) == calendar.get(6)) {
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
        this.ejW = (TextView) findViewById(R.id.tex_msgitem_time);
        this.hqK = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.hqK.setLinkTextColor(-14845754);
        this.hqR = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.hqN = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.hqO = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.hqP = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.hqQ = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.hqL = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.hqL.setClickable(true);
        this.hqL.setOnClickListener(this.hqL);
        this.hqL.setLongClickable(true);
        this.hqL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hqp.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hqR.getImage().setClickable(true);
        this.hqR.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hqo.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.hqR.getImage().setLongClickable(true);
        this.hqR.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hqp.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hqR.getTail().setClickable(true);
        this.hqR.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hqo.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.hqK.setLongClickable(true);
        this.hqK.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hqp.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hqM = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.hqM.setSupportNoImage(false);
        this.hqM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hqo.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.hqM.setLongClickable(true);
        this.hqM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hqp.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hqO.setClickable(true);
        this.hqO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hqo.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.hqO.setLongClickable(true);
        this.hqO.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hqp.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hqP.setClickable(true);
        this.hqP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hqo.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.hqP.setLongClickable(true);
        this.hqP.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hqp.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hqQ.getContentBody().setClickable(true);
        this.hqQ.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hqo.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.hqQ.getTail().setClickable(true);
        this.hqQ.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hqo.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.hqQ.getContentBody().setLongClickable(true);
        this.hqQ.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hqp.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.hqN != null) {
            this.hqN.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.hqp.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vV(int i) {
        this.hqR.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean dM = dM(chatMessage.getTime());
        if (z || dM) {
            this.ejW.setVisibility(0);
            this.ejW.setText(dN(chatMessage.getTime()));
        } else {
            this.ejW.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.hqK, chatMessage, str, this.hqx);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.hqK.setContentDescription(stringBuffer.toString());
            this.hqK.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.hqR, chatMessage, this.hqJ, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.hqL, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.hqM, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.hqN, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.hqO, this.hqP, this.hqQ, chatMessage, str);
    }

    public void nc(boolean z) {
        this.hqS = z;
    }

    public void nd(boolean z) {
        this.hqT = z;
    }

    public void vU(int i) {
        this.hqx = i;
    }
}
