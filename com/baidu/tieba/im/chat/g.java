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
    protected TextView guj;
    protected com.baidu.adp.lib.b.a kjV;
    protected com.baidu.adp.lib.b.b kjW;
    protected boolean kkA;
    protected int kke;
    private Calendar kkp;
    protected long kkq;
    protected TbRichTextView kkr;
    protected ChatVoiceView kks;
    protected GifView kkt;
    protected Invite2GroupView kku;
    protected ShareFromPBView kkv;
    protected ShareFromFrsView kkw;
    protected ShareFromGameCenter kkx;
    protected ChatImageWithTailView kky;
    protected boolean kkz;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.kjV = null;
        this.kjW = null;
        this.mPosition = 0;
        this.kkq = 0L;
        this.mId = null;
        this.kkz = true;
        this.kkA = false;
        this.mLastTime = 0L;
        this.kkp = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.kjV = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kjW = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void gI(long j) {
        this.mLastTime = j;
    }

    public void gJ(long j) {
        this.kkp = Calendar.getInstance();
        this.kkp.setTimeInMillis(1000 * j);
    }

    private boolean gK(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String gL(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.kkp != null && this.kkp.get(1) == calendar.get(1) && this.kkp.get(6) == calendar.get(6)) {
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
        this.guj = (TextView) findViewById(R.id.tex_msgitem_time);
        this.kkr = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.kkr.setLinkTextColor(-14845754);
        this.kky = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.kku = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.kkv = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.kkw = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.kkx = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.kks = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.kks.setClickable(true);
        this.kks.setOnClickListener(this.kks);
        this.kks.setLongClickable(true);
        this.kks.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.kjW.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.kky.getImage().setClickable(true);
        this.kky.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.kjV.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.kky.getImage().setLongClickable(true);
        this.kky.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.kjW.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.kky.getTail().setClickable(true);
        this.kky.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.kjV.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.kkr.setLongClickable(true);
        this.kkr.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.kjW.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.kkt = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.kkt.setSupportNoImage(false);
        this.kkt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.kjV.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.kkt.setLongClickable(true);
        this.kkt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.kjW.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.kkv.setClickable(true);
        this.kkv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.kjV.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.kkv.setLongClickable(true);
        this.kkv.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.kjW.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.kkw.setClickable(true);
        this.kkw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.kjV.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.kkw.setLongClickable(true);
        this.kkw.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.kjW.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.kkx.getContentBody().setClickable(true);
        this.kkx.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.kjV.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.kkx.getTail().setClickable(true);
        this.kkx.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.kjV.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.kkx.getContentBody().setLongClickable(true);
        this.kkx.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.kjW.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.kku != null) {
            this.kku.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.kjW.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DL(int i) {
        this.kky.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean gK = gK(chatMessage.getTime());
        if (z || gK) {
            this.guj.setVisibility(0);
            this.guj.setText(gL(chatMessage.getTime()));
        } else {
            this.guj.setVisibility(8);
        }
        if (!z && gK) {
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
        j.a(this.mContext.getContext(), this.kkr, chatMessage, str, this.kke);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.kkr.setContentDescription(stringBuffer.toString());
            this.kkr.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.kky, chatMessage, this.kkq, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.kks, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.kkt, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.kku, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.kkv, this.kkw, this.kkx, chatMessage, str);
    }

    public void sb(boolean z) {
        this.kkz = z;
    }

    public void sc(boolean z) {
        this.kkA = z;
    }

    public void DK(int i) {
        this.kke = i;
    }
}
