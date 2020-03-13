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
    protected TextView eov;
    protected com.baidu.adp.lib.b.a hsB;
    protected com.baidu.adp.lib.b.b hsC;
    protected int hsK;
    private Calendar hsV;
    protected long hsW;
    protected TbRichTextView hsX;
    protected ChatVoiceView hsY;
    protected GifView hsZ;
    protected Invite2GroupView hta;
    protected ShareFromPBView htb;
    protected ShareFromFrsView htc;
    protected ShareFromGameCenter htd;
    protected ChatImageWithTailView hte;
    protected boolean htf;
    protected boolean htg;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.hsB = null;
        this.hsC = null;
        this.mPosition = 0;
        this.hsW = 0L;
        this.mId = null;
        this.htf = true;
        this.htg = false;
        this.mLastTime = 0L;
        this.hsV = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.hsB = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.hsC = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void dK(long j) {
        this.mLastTime = j;
    }

    public void dL(long j) {
        this.hsV = Calendar.getInstance();
        this.hsV.setTimeInMillis(1000 * j);
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
        if (this.hsV != null && this.hsV.get(1) == calendar.get(1) && this.hsV.get(6) == calendar.get(6)) {
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
        this.eov = (TextView) findViewById(R.id.tex_msgitem_time);
        this.hsX = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.hsX.setLinkTextColor(-14845754);
        this.hte = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.hta = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.htb = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.htc = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.htd = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.hsY = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.hsY.setClickable(true);
        this.hsY.setOnClickListener(this.hsY);
        this.hsY.setLongClickable(true);
        this.hsY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hsC.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hte.getImage().setClickable(true);
        this.hte.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsB.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.hte.getImage().setLongClickable(true);
        this.hte.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hsC.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hte.getTail().setClickable(true);
        this.hte.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsB.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.hsX.setLongClickable(true);
        this.hsX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hsC.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hsZ = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.hsZ.setSupportNoImage(false);
        this.hsZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsB.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.hsZ.setLongClickable(true);
        this.hsZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hsC.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.htb.setClickable(true);
        this.htb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsB.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.htb.setLongClickable(true);
        this.htb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hsC.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.htc.setClickable(true);
        this.htc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsB.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.htc.setLongClickable(true);
        this.htc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hsC.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.htd.getContentBody().setClickable(true);
        this.htd.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsB.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.htd.getTail().setClickable(true);
        this.htd.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsB.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.htd.getContentBody().setLongClickable(true);
        this.htd.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hsC.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.hta != null) {
            this.hta.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.hsC.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wb(int i) {
        this.hte.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean dM = dM(chatMessage.getTime());
        if (z || dM) {
            this.eov.setVisibility(0);
            this.eov.setText(dN(chatMessage.getTime()));
        } else {
            this.eov.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.hsX, chatMessage, str, this.hsK);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.hsX.setContentDescription(stringBuffer.toString());
            this.hsX.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.hte, chatMessage, this.hsW, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.hsY, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.hsZ, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.hta, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.htb, this.htc, this.htd, chatMessage, str);
    }

    public void ne(boolean z) {
        this.htf = z;
    }

    public void nf(boolean z) {
        this.htg = z;
    }

    public void wa(int i) {
        this.hsK = i;
    }
}
