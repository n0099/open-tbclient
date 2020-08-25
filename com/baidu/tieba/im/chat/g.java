package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.base.b<MsglistActivity<?>> {
    protected TextView fGU;
    protected com.baidu.adp.lib.b.a jfA;
    protected com.baidu.adp.lib.b.b jfB;
    protected int jfJ;
    private Calendar jfU;
    protected long jfV;
    protected TbRichTextView jfW;
    protected ChatVoiceView jfX;
    protected GifView jfY;
    protected Invite2GroupView jfZ;
    protected ShareFromPBView jga;
    protected ShareFromFrsView jgb;
    protected ShareFromGameCenter jgc;
    protected ChatImageWithTailView jgd;
    protected boolean jge;
    protected boolean jgf;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.jfA = null;
        this.jfB = null;
        this.mPosition = 0;
        this.jfV = 0L;
        this.mId = null;
        this.jge = true;
        this.jgf = false;
        this.mLastTime = 0L;
        this.jfU = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.jfA = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jfB = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void eX(long j) {
        this.mLastTime = j;
    }

    public void eY(long j) {
        this.jfU = Calendar.getInstance();
        this.jfU.setTimeInMillis(1000 * j);
    }

    private boolean eZ(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String fa(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.jfU != null && this.jfU.get(1) == calendar.get(1) && this.jfU.get(6) == calendar.get(6)) {
            return at.getDateStringHm(calendar.getTime());
        }
        return at.getDateStringMdHm(calendar.getTime());
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
        this.fGU = (TextView) findViewById(R.id.tex_msgitem_time);
        this.jfW = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.jfW.setLinkTextColor(-14845754);
        this.jgd = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.jfZ = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.jga = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.jgb = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.jgc = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.jfX = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.jfX.setClickable(true);
        this.jfX.setOnClickListener(this.jfX);
        this.jfX.setLongClickable(true);
        this.jfX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jfB.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jgd.getImage().setClickable(true);
        this.jgd.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jfA.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.jgd.getImage().setLongClickable(true);
        this.jgd.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jfB.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jgd.getTail().setClickable(true);
        this.jgd.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jfA.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.jfW.setLongClickable(true);
        this.jfW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jfB.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jfY = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.jfY.setSupportNoImage(false);
        this.jfY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jfA.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.jfY.setLongClickable(true);
        this.jfY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jfB.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jga.setClickable(true);
        this.jga.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jfA.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.jga.setLongClickable(true);
        this.jga.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jfB.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jgb.setClickable(true);
        this.jgb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jfA.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.jgb.setLongClickable(true);
        this.jgb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jfB.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jgc.getContentBody().setClickable(true);
        this.jgc.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jfA.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.jgc.getTail().setClickable(true);
        this.jgc.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jfA.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.jgc.getContentBody().setLongClickable(true);
        this.jgc.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jfB.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.jfZ != null) {
            this.jfZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.jfB.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AL(int i) {
        this.jgd.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean eZ = eZ(chatMessage.getTime());
        if (z || eZ) {
            this.fGU.setVisibility(0);
            this.fGU.setText(fa(chatMessage.getTime()));
        } else {
            this.fGU.setVisibility(8);
        }
        if (!z && eZ) {
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
        j.a(this.mContext.getContext(), this.jfW, chatMessage, str, this.jfJ);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.jfW.setContentDescription(stringBuffer.toString());
            this.jfW.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.jgd, chatMessage, this.jfV, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.jfX, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.jfY, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.jfZ, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.jga, this.jgb, this.jgc, chatMessage, str);
    }

    public void qf(boolean z) {
        this.jge = z;
    }

    public void qg(boolean z) {
        this.jgf = z;
    }

    public void AK(int i) {
        this.jfJ = i;
    }
}
