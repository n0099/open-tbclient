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
    protected TextView eoh;
    private Calendar hsH;
    protected long hsI;
    protected TbRichTextView hsJ;
    protected ChatVoiceView hsK;
    protected GifView hsL;
    protected Invite2GroupView hsM;
    protected ShareFromPBView hsN;
    protected ShareFromFrsView hsO;
    protected ShareFromGameCenter hsP;
    protected ChatImageWithTailView hsQ;
    protected boolean hsR;
    protected boolean hsS;
    protected com.baidu.adp.lib.b.a hsn;
    protected com.baidu.adp.lib.b.b hso;
    protected int hsw;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.hsn = null;
        this.hso = null;
        this.mPosition = 0;
        this.hsI = 0L;
        this.mId = null;
        this.hsR = true;
        this.hsS = false;
        this.mLastTime = 0L;
        this.hsH = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.hsn = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.hso = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void dK(long j) {
        this.mLastTime = j;
    }

    public void dL(long j) {
        this.hsH = Calendar.getInstance();
        this.hsH.setTimeInMillis(1000 * j);
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
        if (this.hsH != null && this.hsH.get(1) == calendar.get(1) && this.hsH.get(6) == calendar.get(6)) {
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
        this.eoh = (TextView) findViewById(R.id.tex_msgitem_time);
        this.hsJ = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.hsJ.setLinkTextColor(-14845754);
        this.hsQ = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.hsM = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.hsN = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.hsO = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.hsP = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.hsK = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.hsK.setClickable(true);
        this.hsK.setOnClickListener(this.hsK);
        this.hsK.setLongClickable(true);
        this.hsK.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hso.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hsQ.getImage().setClickable(true);
        this.hsQ.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsn.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.hsQ.getImage().setLongClickable(true);
        this.hsQ.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hso.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hsQ.getTail().setClickable(true);
        this.hsQ.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsn.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.hsJ.setLongClickable(true);
        this.hsJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hso.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hsL = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.hsL.setSupportNoImage(false);
        this.hsL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsn.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.hsL.setLongClickable(true);
        this.hsL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hso.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hsN.setClickable(true);
        this.hsN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsn.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.hsN.setLongClickable(true);
        this.hsN.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hso.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hsO.setClickable(true);
        this.hsO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsn.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.hsO.setLongClickable(true);
        this.hsO.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hso.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hsP.getContentBody().setClickable(true);
        this.hsP.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsn.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.hsP.getTail().setClickable(true);
        this.hsP.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hsn.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.hsP.getContentBody().setLongClickable(true);
        this.hsP.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hso.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.hsM != null) {
            this.hsM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.hso.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wb(int i) {
        this.hsQ.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean dM = dM(chatMessage.getTime());
        if (z || dM) {
            this.eoh.setVisibility(0);
            this.eoh.setText(dN(chatMessage.getTime()));
        } else {
            this.eoh.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.hsJ, chatMessage, str, this.hsw);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.hsJ.setContentDescription(stringBuffer.toString());
            this.hsJ.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.hsQ, chatMessage, this.hsI, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.hsK, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.hsL, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.hsM, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.hsN, this.hsO, this.hsP, chatMessage, str);
    }

    public void ne(boolean z) {
        this.hsR = z;
    }

    public void nf(boolean z) {
        this.hsS = z;
    }

    public void wa(int i) {
        this.hsw = i;
    }
}
