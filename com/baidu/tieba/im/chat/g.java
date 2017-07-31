package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.base.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
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
public class g extends b<MsglistActivity<?>> {
    protected int awz;
    protected TextView cdR;
    private Calendar dhB;
    protected long dhC;
    protected Long dhD;
    protected TbRichTextView dhE;
    protected ChatVoiceView dhF;
    protected GifView dhG;
    protected Invite2GroupView dhH;
    protected ShareFromPBView dhI;
    protected ShareFromFrsView dhJ;
    protected ShareFromGameCenter dhK;
    protected ChatImageWithTailView dhL;
    protected boolean dhM;
    protected boolean dhN;
    protected com.baidu.adp.lib.c.a dhg;
    protected com.baidu.adp.lib.c.b dhh;
    protected int dhq;
    private long mLastTime;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.dhg = null;
        this.dhh = null;
        this.awz = 0;
        this.dhC = 0L;
        this.dhD = null;
        this.dhM = true;
        this.dhN = false;
        this.mLastTime = 0L;
        this.dhB = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dhg = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dhh = bVar;
    }

    public void setPosition(int i) {
        this.awz = i;
    }

    public void bB(long j) {
        this.mLastTime = j;
    }

    public void bC(long j) {
        this.dhB = Calendar.getInstance();
        this.dhB.setTimeInMillis(1000 * j);
    }

    private boolean bD(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String bE(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.dhB != null && this.dhB.get(1) == calendar.get(1) && this.dhB.get(6) == calendar.get(6)) {
            return al.b(calendar.getTime());
        }
        return al.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.dhD = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cdR = (TextView) findViewById(d.h.tex_msgitem_time);
        this.dhE = (TbRichTextView) findViewById(d.h.tex_msgitem_text);
        this.dhE.setLinkTextColor(-14845754);
        this.dhL = (ChatImageWithTailView) findViewById(d.h.img_msgitem_image);
        this.dhH = (Invite2GroupView) findViewById(d.h.lay_msgitem_invite_view);
        this.dhI = (ShareFromPBView) findViewById(d.h.lay_msgitem_share_view);
        this.dhJ = (ShareFromFrsView) findViewById(d.h.lay_msgitem_share_frs);
        this.dhK = (ShareFromGameCenter) findViewById(d.h.lay_msgitem_share_game);
        this.dhF = (ChatVoiceView) findViewById(d.h.lay_msgitem_voice);
        this.dhF.setClickable(true);
        this.dhF.setOnClickListener(this.dhF);
        this.dhF.setLongClickable(true);
        this.dhF.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dhh.b(view, 5, g.this.awz, 0L);
                return true;
            }
        });
        this.dhL.getImage().setClickable(true);
        this.dhL.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dhg.a(view, 4, g.this.awz, 0L);
            }
        });
        this.dhL.getImage().setLongClickable(true);
        this.dhL.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dhh.b(view, 4, g.this.awz, 0L);
                return true;
            }
        });
        this.dhL.getTail().setClickable(true);
        this.dhL.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dhg.a(view, 13, g.this.awz, 0L);
            }
        });
        this.dhE.setLongClickable(true);
        this.dhE.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dhh.b(view, 3, g.this.awz, 0L);
                return true;
            }
        });
        this.dhG = (GifView) findViewById(d.h.emotion_msgitem_image);
        this.dhG.setSupportNoImage(false);
        this.dhG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dhg.a(view, 7, g.this.awz, 0L);
            }
        });
        this.dhG.setLongClickable(true);
        this.dhG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dhh.b(view, 7, g.this.awz, 0L);
                return true;
            }
        });
        this.dhI.setClickable(true);
        this.dhI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dhg.a(view, 10, g.this.awz, 0L);
            }
        });
        this.dhI.setLongClickable(true);
        this.dhI.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dhh.b(view, 10, g.this.awz, 0L);
                return true;
            }
        });
        this.dhJ.setClickable(true);
        this.dhJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dhg.a(view, 15, g.this.awz, 0L);
            }
        });
        this.dhJ.setLongClickable(true);
        this.dhJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dhh.b(view, 15, g.this.awz, 0L);
                return true;
            }
        });
        this.dhK.getContentBody().setClickable(true);
        this.dhK.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dhg.a(view, 11, g.this.awz, 0L);
            }
        });
        this.dhK.getTail().setClickable(true);
        this.dhK.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dhg.a(view, 12, g.this.awz, 0L);
            }
        });
        this.dhK.getContentBody().setLongClickable(true);
        this.dhK.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.dhh.b(view, 11, g.this.awz, 0L);
                return true;
            }
        });
        if (this.dhH != null) {
            this.dhH.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.dhh.b(view, 17, g.this.awz, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lL(int i) {
        this.dhL.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bD = bD(chatMessage.getTime());
        if (z || bD) {
            this.cdR.setVisibility(0);
            this.cdR.setText(bE(chatMessage.getTime()));
        } else {
            this.cdR.setVisibility(8);
        }
        if (!z && bD) {
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
        j.a(this.mContext.getContext(), this.dhE, chatMessage, str, this.dhq);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.dhE.setContentDescription(stringBuffer.toString());
            this.dhE.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dhL, chatMessage, this.dhC, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.dhF, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.dhG, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.dhH, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.dhI, this.dhJ, this.dhK, chatMessage, str);
    }

    public void fU(boolean z) {
        this.dhM = z;
    }

    public void fV(boolean z) {
        this.dhN = z;
    }

    public void lK(int i) {
        this.dhq = i;
    }
}
