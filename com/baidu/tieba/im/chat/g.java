package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.au;
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
    protected TextView gma;
    private Calendar jWJ;
    protected long jWK;
    protected TbRichTextView jWL;
    protected ChatVoiceView jWM;
    protected GifView jWN;
    protected Invite2GroupView jWO;
    protected ShareFromPBView jWP;
    protected ShareFromFrsView jWQ;
    protected ShareFromGameCenter jWR;
    protected ChatImageWithTailView jWS;
    protected boolean jWT;
    protected boolean jWU;
    protected com.baidu.adp.lib.b.a jWp;
    protected com.baidu.adp.lib.b.b jWq;
    protected int jWy;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.jWp = null;
        this.jWq = null;
        this.mPosition = 0;
        this.jWK = 0L;
        this.mId = null;
        this.jWT = true;
        this.jWU = false;
        this.mLastTime = 0L;
        this.jWJ = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.jWp = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jWq = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void gd(long j) {
        this.mLastTime = j;
    }

    public void ge(long j) {
        this.jWJ = Calendar.getInstance();
        this.jWJ.setTimeInMillis(1000 * j);
    }

    private boolean gf(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String gg(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.jWJ != null && this.jWJ.get(1) == calendar.get(1) && this.jWJ.get(6) == calendar.get(6)) {
            return au.getDateStringHm(calendar.getTime());
        }
        return au.getDateStringMdHm(calendar.getTime());
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
        this.gma = (TextView) findViewById(R.id.tex_msgitem_time);
        this.jWL = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.jWL.setLinkTextColor(-14845754);
        this.jWS = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.jWO = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.jWP = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.jWQ = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.jWR = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.jWM = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.jWM.setClickable(true);
        this.jWM.setOnClickListener(this.jWM);
        this.jWM.setLongClickable(true);
        this.jWM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jWq.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jWS.getImage().setClickable(true);
        this.jWS.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jWp.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.jWS.getImage().setLongClickable(true);
        this.jWS.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jWq.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jWS.getTail().setClickable(true);
        this.jWS.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jWp.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.jWL.setLongClickable(true);
        this.jWL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jWq.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jWN = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.jWN.setSupportNoImage(false);
        this.jWN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jWp.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.jWN.setLongClickable(true);
        this.jWN.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jWq.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jWP.setClickable(true);
        this.jWP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jWp.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.jWP.setLongClickable(true);
        this.jWP.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jWq.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jWQ.setClickable(true);
        this.jWQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jWp.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.jWQ.setLongClickable(true);
        this.jWQ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jWq.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jWR.getContentBody().setClickable(true);
        this.jWR.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jWp.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.jWR.getTail().setClickable(true);
        this.jWR.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jWp.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.jWR.getContentBody().setLongClickable(true);
        this.jWR.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jWq.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.jWO != null) {
            this.jWO.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.jWq.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CW(int i) {
        this.jWS.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean gf = gf(chatMessage.getTime());
        if (z || gf) {
            this.gma.setVisibility(0);
            this.gma.setText(gg(chatMessage.getTime()));
        } else {
            this.gma.setVisibility(8);
        }
        if (!z && gf) {
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
        j.a(this.mContext.getContext(), this.jWL, chatMessage, str, this.jWy);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.jWL.setContentDescription(stringBuffer.toString());
            this.jWL.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.jWS, chatMessage, this.jWK, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.jWM, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.jWN, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.jWO, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.jWP, this.jWQ, this.jWR, chatMessage, str);
    }

    public void rz(boolean z) {
        this.jWT = z;
    }

    public void rA(boolean z) {
        this.jWU = z;
    }

    public void CV(int i) {
        this.jWy = i;
    }
}
