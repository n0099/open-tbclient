package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
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
    protected TextView fvC;
    protected com.baidu.adp.lib.b.a iQB;
    protected com.baidu.adp.lib.b.b iQC;
    protected int iQK;
    private Calendar iQV;
    protected long iQW;
    protected TbRichTextView iQX;
    protected ChatVoiceView iQY;
    protected GifView iQZ;
    protected Invite2GroupView iRa;
    protected ShareFromPBView iRb;
    protected ShareFromFrsView iRc;
    protected ShareFromGameCenter iRd;
    protected ChatImageWithTailView iRe;
    protected boolean iRf;
    protected boolean iRg;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.iQB = null;
        this.iQC = null;
        this.mPosition = 0;
        this.iQW = 0L;
        this.mId = null;
        this.iRf = true;
        this.iRg = false;
        this.mLastTime = 0L;
        this.iQV = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.iQB = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.iQC = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void eL(long j) {
        this.mLastTime = j;
    }

    public void eM(long j) {
        this.iQV = Calendar.getInstance();
        this.iQV.setTimeInMillis(1000 * j);
    }

    private boolean eN(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String eO(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.iQV != null && this.iQV.get(1) == calendar.get(1) && this.iQV.get(6) == calendar.get(6)) {
            return as.getDateStringHm(calendar.getTime());
        }
        return as.getDateStringMdHm(calendar.getTime());
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
        this.fvC = (TextView) findViewById(R.id.tex_msgitem_time);
        this.iQX = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.iQX.setLinkTextColor(-14845754);
        this.iRe = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.iRa = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.iRb = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.iRc = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.iRd = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.iQY = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.iQY.setClickable(true);
        this.iQY.setOnClickListener(this.iQY);
        this.iQY.setLongClickable(true);
        this.iQY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iQC.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iRe.getImage().setClickable(true);
        this.iRe.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iQB.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.iRe.getImage().setLongClickable(true);
        this.iRe.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iQC.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iRe.getTail().setClickable(true);
        this.iRe.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iQB.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.iQX.setLongClickable(true);
        this.iQX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iQC.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iQZ = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.iQZ.setSupportNoImage(false);
        this.iQZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iQB.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.iQZ.setLongClickable(true);
        this.iQZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iQC.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iRb.setClickable(true);
        this.iRb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iQB.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.iRb.setLongClickable(true);
        this.iRb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iQC.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iRc.setClickable(true);
        this.iRc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iQB.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.iRc.setLongClickable(true);
        this.iRc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iQC.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iRd.getContentBody().setClickable(true);
        this.iRd.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iQB.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.iRd.getTail().setClickable(true);
        this.iRd.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iQB.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.iRd.getContentBody().setLongClickable(true);
        this.iRd.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iQC.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.iRa != null) {
            this.iRa.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.iQC.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yr(int i) {
        this.iRe.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean eN = eN(chatMessage.getTime());
        if (z || eN) {
            this.fvC.setVisibility(0);
            this.fvC.setText(eO(chatMessage.getTime()));
        } else {
            this.fvC.setVisibility(8);
        }
        if (!z && eN) {
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
        j.a(this.mContext.getContext(), this.iQX, chatMessage, str, this.iQK);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.iQX.setContentDescription(stringBuffer.toString());
            this.iQX.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.iRe, chatMessage, this.iQW, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.iQY, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.iQZ, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.iRa, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.iRb, this.iRc, this.iRd, chatMessage, str);
    }

    public void pz(boolean z) {
        this.iRf = z;
    }

    public void pA(boolean z) {
        this.iRg = z;
    }

    public void yq(int i) {
        this.iQK = i;
    }
}
