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
    protected TextView fWB;
    private Calendar jDD;
    protected long jDE;
    protected TbRichTextView jDF;
    protected ChatVoiceView jDG;
    protected GifView jDH;
    protected Invite2GroupView jDI;
    protected ShareFromPBView jDJ;
    protected ShareFromFrsView jDK;
    protected ShareFromGameCenter jDL;
    protected ChatImageWithTailView jDM;
    protected boolean jDN;
    protected boolean jDO;
    protected com.baidu.adp.lib.b.a jDj;
    protected com.baidu.adp.lib.b.b jDk;
    protected int jDs;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.jDj = null;
        this.jDk = null;
        this.mPosition = 0;
        this.jDE = 0L;
        this.mId = null;
        this.jDN = true;
        this.jDO = false;
        this.mLastTime = 0L;
        this.jDD = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.jDj = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jDk = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void fD(long j) {
        this.mLastTime = j;
    }

    public void fE(long j) {
        this.jDD = Calendar.getInstance();
        this.jDD.setTimeInMillis(1000 * j);
    }

    private boolean fF(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String fG(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.jDD != null && this.jDD.get(1) == calendar.get(1) && this.jDD.get(6) == calendar.get(6)) {
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
        this.fWB = (TextView) findViewById(R.id.tex_msgitem_time);
        this.jDF = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.jDF.setLinkTextColor(-14845754);
        this.jDM = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.jDI = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.jDJ = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.jDK = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.jDL = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.jDG = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.jDG.setClickable(true);
        this.jDG.setOnClickListener(this.jDG);
        this.jDG.setLongClickable(true);
        this.jDG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jDk.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jDM.getImage().setClickable(true);
        this.jDM.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jDj.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.jDM.getImage().setLongClickable(true);
        this.jDM.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jDk.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jDM.getTail().setClickable(true);
        this.jDM.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jDj.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.jDF.setLongClickable(true);
        this.jDF.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jDk.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jDH = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.jDH.setSupportNoImage(false);
        this.jDH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jDj.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.jDH.setLongClickable(true);
        this.jDH.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jDk.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jDJ.setClickable(true);
        this.jDJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jDj.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.jDJ.setLongClickable(true);
        this.jDJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jDk.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jDK.setClickable(true);
        this.jDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jDj.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.jDK.setLongClickable(true);
        this.jDK.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jDk.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jDL.getContentBody().setClickable(true);
        this.jDL.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jDj.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.jDL.getTail().setClickable(true);
        this.jDL.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jDj.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.jDL.getContentBody().setLongClickable(true);
        this.jDL.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jDk.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.jDI != null) {
            this.jDI.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.jDk.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BS(int i) {
        this.jDM.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean fF = fF(chatMessage.getTime());
        if (z || fF) {
            this.fWB.setVisibility(0);
            this.fWB.setText(fG(chatMessage.getTime()));
        } else {
            this.fWB.setVisibility(8);
        }
        if (!z && fF) {
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
        j.a(this.mContext.getContext(), this.jDF, chatMessage, str, this.jDs);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.jDF.setContentDescription(stringBuffer.toString());
            this.jDF.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.jDM, chatMessage, this.jDE, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.jDG, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.jDH, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.jDI, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.jDJ, this.jDK, this.jDL, chatMessage, str);
    }

    public void qV(boolean z) {
        this.jDN = z;
    }

    public void qW(boolean z) {
        this.jDO = z;
    }

    public void BR(int i) {
        this.jDs = i;
    }
}
