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
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.b<MsglistActivity<?>> {
    protected TextView fGY;
    protected com.baidu.adp.lib.b.a jfG;
    protected com.baidu.adp.lib.b.b jfH;
    protected int jfP;
    private Calendar jga;
    protected long jgb;
    protected TbRichTextView jgc;
    protected ChatVoiceView jgd;
    protected GifView jge;
    protected Invite2GroupView jgf;
    protected ShareFromPBView jgg;
    protected ShareFromFrsView jgh;
    protected ShareFromGameCenter jgi;
    protected ChatImageWithTailView jgj;
    protected boolean jgk;
    protected boolean jgl;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.jfG = null;
        this.jfH = null;
        this.mPosition = 0;
        this.jgb = 0L;
        this.mId = null;
        this.jgk = true;
        this.jgl = false;
        this.mLastTime = 0L;
        this.jga = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.jfG = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jfH = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void eX(long j) {
        this.mLastTime = j;
    }

    public void eY(long j) {
        this.jga = Calendar.getInstance();
        this.jga.setTimeInMillis(1000 * j);
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
        if (this.jga != null && this.jga.get(1) == calendar.get(1) && this.jga.get(6) == calendar.get(6)) {
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
        this.fGY = (TextView) findViewById(R.id.tex_msgitem_time);
        this.jgc = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.jgc.setLinkTextColor(-14845754);
        this.jgj = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.jgf = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.jgg = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.jgh = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.jgi = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.jgd = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.jgd.setClickable(true);
        this.jgd.setOnClickListener(this.jgd);
        this.jgd.setLongClickable(true);
        this.jgd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jfH.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jgj.getImage().setClickable(true);
        this.jgj.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jfG.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.jgj.getImage().setLongClickable(true);
        this.jgj.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jfH.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jgj.getTail().setClickable(true);
        this.jgj.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jfG.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.jgc.setLongClickable(true);
        this.jgc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jfH.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jge = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.jge.setSupportNoImage(false);
        this.jge.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jfG.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.jge.setLongClickable(true);
        this.jge.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jfH.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jgg.setClickable(true);
        this.jgg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jfG.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.jgg.setLongClickable(true);
        this.jgg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jfH.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jgh.setClickable(true);
        this.jgh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jfG.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.jgh.setLongClickable(true);
        this.jgh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jfH.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jgi.getContentBody().setClickable(true);
        this.jgi.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jfG.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.jgi.getTail().setClickable(true);
        this.jgi.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jfG.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.jgi.getContentBody().setLongClickable(true);
        this.jgi.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jfH.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.jgf != null) {
            this.jgf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.jfH.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AL(int i) {
        this.jgj.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean eZ = eZ(chatMessage.getTime());
        if (z || eZ) {
            this.fGY.setVisibility(0);
            this.fGY.setText(fa(chatMessage.getTime()));
        } else {
            this.fGY.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.jgc, chatMessage, str, this.jfP);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.jgc.setContentDescription(stringBuffer.toString());
            this.jgc.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.jgj, chatMessage, this.jgb, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.jgd, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.jge, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.jgf, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.jgg, this.jgh, this.jgi, chatMessage, str);
    }

    public void qh(boolean z) {
        this.jgk = z;
    }

    public void qi(boolean z) {
        this.jgl = z;
    }

    public void AK(int i) {
        this.jfP = i;
    }
}
