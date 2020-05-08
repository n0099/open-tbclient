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
    protected TextView eSo;
    protected com.baidu.adp.lib.b.a idU;
    protected com.baidu.adp.lib.b.b idV;
    protected int ied;
    private Calendar ieo;
    protected long iep;
    protected TbRichTextView ieq;
    protected ChatVoiceView ier;
    protected GifView ies;
    protected Invite2GroupView iet;
    protected ShareFromPBView ieu;
    protected ShareFromFrsView iev;
    protected ShareFromGameCenter iew;
    protected ChatImageWithTailView iex;
    protected boolean iey;
    protected boolean iez;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.idU = null;
        this.idV = null;
        this.mPosition = 0;
        this.iep = 0L;
        this.mId = null;
        this.iey = true;
        this.iez = false;
        this.mLastTime = 0L;
        this.ieo = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.idU = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.idV = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void eu(long j) {
        this.mLastTime = j;
    }

    public void ev(long j) {
        this.ieo = Calendar.getInstance();
        this.ieo.setTimeInMillis(1000 * j);
    }

    private boolean ew(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String ex(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.ieo != null && this.ieo.get(1) == calendar.get(1) && this.ieo.get(6) == calendar.get(6)) {
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
        this.eSo = (TextView) findViewById(R.id.tex_msgitem_time);
        this.ieq = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.ieq.setLinkTextColor(-14845754);
        this.iex = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.iet = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.ieu = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.iev = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.iew = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.ier = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.ier.setClickable(true);
        this.ier.setOnClickListener(this.ier);
        this.ier.setLongClickable(true);
        this.ier.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.idV.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iex.getImage().setClickable(true);
        this.iex.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.idU.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.iex.getImage().setLongClickable(true);
        this.iex.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.idV.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iex.getTail().setClickable(true);
        this.iex.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.idU.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.ieq.setLongClickable(true);
        this.ieq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.idV.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ies = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.ies.setSupportNoImage(false);
        this.ies.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.idU.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.ies.setLongClickable(true);
        this.ies.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.idV.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ieu.setClickable(true);
        this.ieu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.idU.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.ieu.setLongClickable(true);
        this.ieu.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.idV.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iev.setClickable(true);
        this.iev.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.idU.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.iev.setLongClickable(true);
        this.iev.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.idV.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iew.getContentBody().setClickable(true);
        this.iew.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.idU.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.iew.getTail().setClickable(true);
        this.iew.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.idU.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.iew.getContentBody().setLongClickable(true);
        this.iew.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.idV.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.iet != null) {
            this.iet.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.idV.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wH(int i) {
        this.iex.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean ew = ew(chatMessage.getTime());
        if (z || ew) {
            this.eSo.setVisibility(0);
            this.eSo.setText(ex(chatMessage.getTime()));
        } else {
            this.eSo.setVisibility(8);
        }
        if (!z && ew) {
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
        j.a(this.mContext.getContext(), this.ieq, chatMessage, str, this.ied);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.ieq.setContentDescription(stringBuffer.toString());
            this.ieq.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.iex, chatMessage, this.iep, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.ier, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.ies, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.iet, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.ieu, this.iev, this.iew, chatMessage, str);
    }

    public void oo(boolean z) {
        this.iey = z;
    }

    public void op(boolean z) {
        this.iez = z;
    }

    public void wG(int i) {
        this.ied = i;
    }
}
