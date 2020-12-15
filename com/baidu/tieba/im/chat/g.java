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
    protected TextView gul;
    protected com.baidu.adp.lib.b.a kjX;
    protected com.baidu.adp.lib.b.b kjY;
    protected ChatImageWithTailView kkA;
    protected boolean kkB;
    protected boolean kkC;
    protected int kkg;
    private Calendar kkr;
    protected long kks;
    protected TbRichTextView kkt;
    protected ChatVoiceView kku;
    protected GifView kkv;
    protected Invite2GroupView kkw;
    protected ShareFromPBView kkx;
    protected ShareFromFrsView kky;
    protected ShareFromGameCenter kkz;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.kjX = null;
        this.kjY = null;
        this.mPosition = 0;
        this.kks = 0L;
        this.mId = null;
        this.kkB = true;
        this.kkC = false;
        this.mLastTime = 0L;
        this.kkr = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.kjX = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kjY = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void gI(long j) {
        this.mLastTime = j;
    }

    public void gJ(long j) {
        this.kkr = Calendar.getInstance();
        this.kkr.setTimeInMillis(1000 * j);
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
        if (this.kkr != null && this.kkr.get(1) == calendar.get(1) && this.kkr.get(6) == calendar.get(6)) {
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
        this.gul = (TextView) findViewById(R.id.tex_msgitem_time);
        this.kkt = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.kkt.setLinkTextColor(-14845754);
        this.kkA = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.kkw = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.kkx = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.kky = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.kkz = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.kku = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.kku.setClickable(true);
        this.kku.setOnClickListener(this.kku);
        this.kku.setLongClickable(true);
        this.kku.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.kjY.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.kkA.getImage().setClickable(true);
        this.kkA.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.kjX.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.kkA.getImage().setLongClickable(true);
        this.kkA.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.kjY.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.kkA.getTail().setClickable(true);
        this.kkA.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.kjX.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.kkt.setLongClickable(true);
        this.kkt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.kjY.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.kkv = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.kkv.setSupportNoImage(false);
        this.kkv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.kjX.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.kkv.setLongClickable(true);
        this.kkv.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.kjY.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.kkx.setClickable(true);
        this.kkx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.kjX.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.kkx.setLongClickable(true);
        this.kkx.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.kjY.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.kky.setClickable(true);
        this.kky.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.kjX.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.kky.setLongClickable(true);
        this.kky.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.kjY.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.kkz.getContentBody().setClickable(true);
        this.kkz.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.kjX.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.kkz.getTail().setClickable(true);
        this.kkz.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.kjX.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.kkz.getContentBody().setLongClickable(true);
        this.kkz.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.kjY.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.kkw != null) {
            this.kkw.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.kjY.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DL(int i) {
        this.kkA.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean gK = gK(chatMessage.getTime());
        if (z || gK) {
            this.gul.setVisibility(0);
            this.gul.setText(gL(chatMessage.getTime()));
        } else {
            this.gul.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.kkt, chatMessage, str, this.kkg);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.kkt.setContentDescription(stringBuffer.toString());
            this.kkt.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.kkA, chatMessage, this.kks, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.kku, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.kkv, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.kkw, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.kkx, this.kky, this.kkz, chatMessage, str);
    }

    public void sb(boolean z) {
        this.kkB = z;
    }

    public void sc(boolean z) {
        this.kkC = z;
    }

    public void DK(int i) {
        this.kkg = i;
    }
}
