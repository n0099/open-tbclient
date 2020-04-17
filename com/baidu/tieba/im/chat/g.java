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
    protected TextView eSj;
    protected com.baidu.adp.lib.b.a idO;
    protected com.baidu.adp.lib.b.b idP;
    protected int idX;
    private Calendar iei;
    protected long iej;
    protected TbRichTextView iek;
    protected ChatVoiceView iel;
    protected GifView iem;
    protected Invite2GroupView ien;
    protected ShareFromPBView ieo;
    protected ShareFromFrsView iep;
    protected ShareFromGameCenter ieq;
    protected ChatImageWithTailView ier;
    protected boolean ies;
    protected boolean iet;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.idO = null;
        this.idP = null;
        this.mPosition = 0;
        this.iej = 0L;
        this.mId = null;
        this.ies = true;
        this.iet = false;
        this.mLastTime = 0L;
        this.iei = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.idO = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.idP = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void eu(long j) {
        this.mLastTime = j;
    }

    public void ev(long j) {
        this.iei = Calendar.getInstance();
        this.iei.setTimeInMillis(1000 * j);
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
        if (this.iei != null && this.iei.get(1) == calendar.get(1) && this.iei.get(6) == calendar.get(6)) {
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
        this.eSj = (TextView) findViewById(R.id.tex_msgitem_time);
        this.iek = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.iek.setLinkTextColor(-14845754);
        this.ier = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.ien = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.ieo = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.iep = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.ieq = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.iel = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.iel.setClickable(true);
        this.iel.setOnClickListener(this.iel);
        this.iel.setLongClickable(true);
        this.iel.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.idP.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ier.getImage().setClickable(true);
        this.ier.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.idO.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.ier.getImage().setLongClickable(true);
        this.ier.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.idP.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ier.getTail().setClickable(true);
        this.ier.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.idO.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.iek.setLongClickable(true);
        this.iek.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.idP.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iem = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.iem.setSupportNoImage(false);
        this.iem.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.idO.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.iem.setLongClickable(true);
        this.iem.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.idP.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ieo.setClickable(true);
        this.ieo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.idO.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.ieo.setLongClickable(true);
        this.ieo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.idP.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.iep.setClickable(true);
        this.iep.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.idO.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.iep.setLongClickable(true);
        this.iep.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.idP.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ieq.getContentBody().setClickable(true);
        this.ieq.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.idO.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.ieq.getTail().setClickable(true);
        this.ieq.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.idO.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.ieq.getContentBody().setLongClickable(true);
        this.ieq.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.idP.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.ien != null) {
            this.ien.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.idP.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wH(int i) {
        this.ier.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean ew = ew(chatMessage.getTime());
        if (z || ew) {
            this.eSj.setVisibility(0);
            this.eSj.setText(ex(chatMessage.getTime()));
        } else {
            this.eSj.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.iek, chatMessage, str, this.idX);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.iek.setContentDescription(stringBuffer.toString());
            this.iek.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.ier, chatMessage, this.iej, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.iel, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.iem, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.ien, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.ieo, this.iep, this.ieq, chatMessage, str);
    }

    public void oo(boolean z) {
        this.ies = z;
    }

    public void op(boolean z) {
        this.iet = z;
    }

    public void wG(int i) {
        this.idX = i;
    }
}
