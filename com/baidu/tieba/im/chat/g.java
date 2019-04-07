package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
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
    protected TextView eKM;
    private Calendar gbD;
    protected long gbE;
    protected Long gbF;
    protected TbRichTextView gbG;
    protected ChatVoiceView gbH;
    protected GifView gbI;
    protected Invite2GroupView gbJ;
    protected ShareFromPBView gbK;
    protected ShareFromFrsView gbL;
    protected ShareFromGameCenter gbM;
    protected ChatImageWithTailView gbN;
    protected boolean gbO;
    protected boolean gbP;
    protected com.baidu.adp.lib.c.a gbi;
    protected com.baidu.adp.lib.c.b gbj;
    protected int gbs;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.gbi = null;
        this.gbj = null;
        this.mPosition = 0;
        this.gbE = 0L;
        this.gbF = null;
        this.gbO = true;
        this.gbP = false;
        this.mLastTime = 0L;
        this.gbD = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gbi = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gbj = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void cT(long j) {
        this.mLastTime = j;
    }

    public void cU(long j) {
        this.gbD = Calendar.getInstance();
        this.gbD.setTimeInMillis(1000 * j);
    }

    private boolean cV(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String cW(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.gbD != null && this.gbD.get(1) == calendar.get(1) && this.gbD.get(6) == calendar.get(6)) {
            return ap.b(calendar.getTime());
        }
        return ap.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.gbF = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.eKM = (TextView) findViewById(d.g.tex_msgitem_time);
        this.gbG = (TbRichTextView) findViewById(d.g.tex_msgitem_text);
        this.gbG.setLinkTextColor(-14845754);
        this.gbN = (ChatImageWithTailView) findViewById(d.g.img_msgitem_image);
        this.gbJ = (Invite2GroupView) findViewById(d.g.lay_msgitem_invite_view);
        this.gbK = (ShareFromPBView) findViewById(d.g.lay_msgitem_share_view);
        this.gbL = (ShareFromFrsView) findViewById(d.g.lay_msgitem_share_frs);
        this.gbM = (ShareFromGameCenter) findViewById(d.g.lay_msgitem_share_game);
        this.gbH = (ChatVoiceView) findViewById(d.g.lay_msgitem_voice);
        this.gbH.setClickable(true);
        this.gbH.setOnClickListener(this.gbH);
        this.gbH.setLongClickable(true);
        this.gbH.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbj.b(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbN.getImage().setClickable(true);
        this.gbN.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbi.a(view, 4, g.this.mPosition, 0L);
            }
        });
        this.gbN.getImage().setLongClickable(true);
        this.gbN.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbj.b(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbN.getTail().setClickable(true);
        this.gbN.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbi.a(view, 13, g.this.mPosition, 0L);
            }
        });
        this.gbG.setLongClickable(true);
        this.gbG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbj.b(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbI = (GifView) findViewById(d.g.emotion_msgitem_image);
        this.gbI.setSupportNoImage(false);
        this.gbI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbi.a(view, 7, g.this.mPosition, 0L);
            }
        });
        this.gbI.setLongClickable(true);
        this.gbI.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbj.b(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbK.setClickable(true);
        this.gbK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbi.a(view, 10, g.this.mPosition, 0L);
            }
        });
        this.gbK.setLongClickable(true);
        this.gbK.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbj.b(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbL.setClickable(true);
        this.gbL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbi.a(view, 15, g.this.mPosition, 0L);
            }
        });
        this.gbL.setLongClickable(true);
        this.gbL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbj.b(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gbM.getContentBody().setClickable(true);
        this.gbM.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbi.a(view, 11, g.this.mPosition, 0L);
            }
        });
        this.gbM.getTail().setClickable(true);
        this.gbM.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gbi.a(view, 12, g.this.mPosition, 0L);
            }
        });
        this.gbM.getContentBody().setLongClickable(true);
        this.gbM.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gbj.b(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.gbJ != null) {
            this.gbJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.gbj.b(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tw(int i) {
        this.gbN.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean cV = cV(chatMessage.getTime());
        if (z || cV) {
            this.eKM.setVisibility(0);
            this.eKM.setText(cW(chatMessage.getTime()));
        } else {
            this.eKM.setVisibility(8);
        }
        if (!z && cV) {
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
        j.a(this.mContext.getContext(), this.gbG, chatMessage, str, this.gbs);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.gbG.setContentDescription(stringBuffer.toString());
            this.gbG.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gbN, chatMessage, this.gbE, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.gbH, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.gbI, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.gbJ, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gbK, this.gbL, this.gbM, chatMessage, str);
    }

    public void kH(boolean z) {
        this.gbO = z;
    }

    public void kI(boolean z) {
        this.gbP = z;
    }

    public void tv(int i) {
        this.gbs = i;
    }
}
