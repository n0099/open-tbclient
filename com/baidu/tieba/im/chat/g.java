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
    protected com.baidu.adp.lib.b.a iQD;
    protected com.baidu.adp.lib.b.b iQE;
    protected int iQM;
    private Calendar iQX;
    protected long iQY;
    protected TbRichTextView iQZ;
    protected ChatVoiceView iRa;
    protected GifView iRb;
    protected Invite2GroupView iRc;
    protected ShareFromPBView iRd;
    protected ShareFromFrsView iRe;
    protected ShareFromGameCenter iRf;
    protected ChatImageWithTailView iRg;
    protected boolean iRh;
    protected boolean iRi;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.iQD = null;
        this.iQE = null;
        this.mPosition = 0;
        this.iQY = 0L;
        this.mId = null;
        this.iRh = true;
        this.iRi = false;
        this.mLastTime = 0L;
        this.iQX = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.iQD = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.iQE = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void eL(long j) {
        this.mLastTime = j;
    }

    public void eM(long j) {
        this.iQX = Calendar.getInstance();
        this.iQX.setTimeInMillis(1000 * j);
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
        if (this.iQX != null && this.iQX.get(1) == calendar.get(1) && this.iQX.get(6) == calendar.get(6)) {
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
        this.iQZ = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.iQZ.setLinkTextColor(-14845754);
        this.iRg = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.iRc = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.iRd = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.iRe = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.iRf = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.iRa = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.iRa.setClickable(true);
        this.iRa.setOnClickListener(this.iRa);
        this.iRa.setLongClickable(true);
        this.iRa.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iQE.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iRg.getImage().setClickable(true);
        this.iRg.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iQD.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.iRg.getImage().setLongClickable(true);
        this.iRg.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iQE.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iRg.getTail().setClickable(true);
        this.iRg.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iQD.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.iQZ.setLongClickable(true);
        this.iQZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iQE.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iRb = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.iRb.setSupportNoImage(false);
        this.iRb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iQD.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.iRb.setLongClickable(true);
        this.iRb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iQE.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iRd.setClickable(true);
        this.iRd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iQD.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.iRd.setLongClickable(true);
        this.iRd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iQE.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iRe.setClickable(true);
        this.iRe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iQD.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.iRe.setLongClickable(true);
        this.iRe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iQE.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iRf.getContentBody().setClickable(true);
        this.iRf.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iQD.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.iRf.getTail().setClickable(true);
        this.iRf.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.iQD.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.iRf.getContentBody().setLongClickable(true);
        this.iRf.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.iQE.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.iRc != null) {
            this.iRc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.iQE.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yr(int i) {
        this.iRg.setVisibility(i);
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
        j.a(this.mContext.getContext(), this.iQZ, chatMessage, str, this.iQM);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.iQZ.setContentDescription(stringBuffer.toString());
            this.iQZ.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.iRg, chatMessage, this.iQY, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.iRa, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.iRb, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.iRc, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.iRd, this.iRe, this.iRf, chatMessage, str);
    }

    public void pz(boolean z) {
        this.iRh = z;
    }

    public void pA(boolean z) {
        this.iRi = z;
    }

    public void yq(int i) {
        this.iQM = i;
    }
}
