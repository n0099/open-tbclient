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
    protected TextView fKk;
    private Calendar joG;
    protected long joH;
    protected TbRichTextView joI;
    protected ChatVoiceView joJ;
    protected GifView joK;
    protected Invite2GroupView joL;
    protected ShareFromPBView joM;
    protected ShareFromFrsView joN;
    protected ShareFromGameCenter joO;
    protected ChatImageWithTailView joP;
    protected boolean joQ;
    protected boolean joR;
    protected com.baidu.adp.lib.b.a jom;
    protected com.baidu.adp.lib.b.b jon;
    protected int jov;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.jom = null;
        this.jon = null;
        this.mPosition = 0;
        this.joH = 0L;
        this.mId = null;
        this.joQ = true;
        this.joR = false;
        this.mLastTime = 0L;
        this.joG = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.jom = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jon = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void fl(long j) {
        this.mLastTime = j;
    }

    public void fm(long j) {
        this.joG = Calendar.getInstance();
        this.joG.setTimeInMillis(1000 * j);
    }

    private boolean fn(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String fo(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.joG != null && this.joG.get(1) == calendar.get(1) && this.joG.get(6) == calendar.get(6)) {
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
        this.fKk = (TextView) findViewById(R.id.tex_msgitem_time);
        this.joI = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.joI.setLinkTextColor(-14845754);
        this.joP = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.joL = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.joM = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.joN = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.joO = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.joJ = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.joJ.setClickable(true);
        this.joJ.setOnClickListener(this.joJ);
        this.joJ.setLongClickable(true);
        this.joJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jon.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.joP.getImage().setClickable(true);
        this.joP.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jom.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.joP.getImage().setLongClickable(true);
        this.joP.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jon.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.joP.getTail().setClickable(true);
        this.joP.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jom.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.joI.setLongClickable(true);
        this.joI.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jon.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.joK = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.joK.setSupportNoImage(false);
        this.joK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jom.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.joK.setLongClickable(true);
        this.joK.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jon.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.joM.setClickable(true);
        this.joM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jom.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.joM.setLongClickable(true);
        this.joM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jon.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.joN.setClickable(true);
        this.joN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jom.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.joN.setLongClickable(true);
        this.joN.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jon.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.joO.getContentBody().setClickable(true);
        this.joO.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jom.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.joO.getTail().setClickable(true);
        this.joO.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jom.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.joO.getContentBody().setLongClickable(true);
        this.joO.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jon.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.joL != null) {
            this.joL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.jon.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bm(int i) {
        this.joP.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean fn = fn(chatMessage.getTime());
        if (z || fn) {
            this.fKk.setVisibility(0);
            this.fKk.setText(fo(chatMessage.getTime()));
        } else {
            this.fKk.setVisibility(8);
        }
        if (!z && fn) {
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
        j.a(this.mContext.getContext(), this.joI, chatMessage, str, this.jov);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.joI.setContentDescription(stringBuffer.toString());
            this.joI.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.joP, chatMessage, this.joH, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.joJ, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.joK, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.joL, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.joM, this.joN, this.joO, chatMessage, str);
    }

    public void qp(boolean z) {
        this.joQ = z;
    }

    public void qq(boolean z) {
        this.joR = z;
    }

    public void Bl(int i) {
        this.jov = i;
    }
}
