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
    protected TextView gmt;
    protected com.baidu.adp.lib.b.a jVF;
    protected com.baidu.adp.lib.b.b jVG;
    protected int jVO;
    private Calendar jVZ;
    protected long jWa;
    protected TbRichTextView jWb;
    protected ChatVoiceView jWc;
    protected GifView jWd;
    protected Invite2GroupView jWe;
    protected ShareFromPBView jWf;
    protected ShareFromFrsView jWg;
    protected ShareFromGameCenter jWh;
    protected ChatImageWithTailView jWi;
    protected boolean jWj;
    protected boolean jWk;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.jVF = null;
        this.jVG = null;
        this.mPosition = 0;
        this.jWa = 0L;
        this.mId = null;
        this.jWj = true;
        this.jWk = false;
        this.mLastTime = 0L;
        this.jVZ = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.jVF = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jVG = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void ga(long j) {
        this.mLastTime = j;
    }

    public void gb(long j) {
        this.jVZ = Calendar.getInstance();
        this.jVZ.setTimeInMillis(1000 * j);
    }

    private boolean gc(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String gd(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.jVZ != null && this.jVZ.get(1) == calendar.get(1) && this.jVZ.get(6) == calendar.get(6)) {
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
        this.gmt = (TextView) findViewById(R.id.tex_msgitem_time);
        this.jWb = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.jWb.setLinkTextColor(-14845754);
        this.jWi = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.jWe = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.jWf = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.jWg = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.jWh = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.jWc = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.jWc.setClickable(true);
        this.jWc.setOnClickListener(this.jWc);
        this.jWc.setLongClickable(true);
        this.jWc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jVG.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jWi.getImage().setClickable(true);
        this.jWi.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jVF.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.jWi.getImage().setLongClickable(true);
        this.jWi.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jVG.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jWi.getTail().setClickable(true);
        this.jWi.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jVF.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.jWb.setLongClickable(true);
        this.jWb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jVG.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jWd = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.jWd.setSupportNoImage(false);
        this.jWd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jVF.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.jWd.setLongClickable(true);
        this.jWd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jVG.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jWf.setClickable(true);
        this.jWf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jVF.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.jWf.setLongClickable(true);
        this.jWf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jVG.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jWg.setClickable(true);
        this.jWg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jVF.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.jWg.setLongClickable(true);
        this.jWg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jVG.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jWh.getContentBody().setClickable(true);
        this.jWh.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jVF.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.jWh.getTail().setClickable(true);
        this.jWh.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jVF.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.jWh.getContentBody().setLongClickable(true);
        this.jWh.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jVG.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.jWe != null) {
            this.jWe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.jVG.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cy(int i) {
        this.jWi.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean gc = gc(chatMessage.getTime());
        if (z || gc) {
            this.gmt.setVisibility(0);
            this.gmt.setText(gd(chatMessage.getTime()));
        } else {
            this.gmt.setVisibility(8);
        }
        if (!z && gc) {
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
        j.a(this.mContext.getContext(), this.jWb, chatMessage, str, this.jVO);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.jWb.setContentDescription(stringBuffer.toString());
            this.jWb.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.jWi, chatMessage, this.jWa, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.jWc, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.jWd, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.jWe, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.jWf, this.jWg, this.jWh, chatMessage, str);
    }

    public void rw(boolean z) {
        this.jWj = z;
    }

    public void rx(boolean z) {
        this.jWk = z;
    }

    public void Cx(int i) {
        this.jVO = i;
    }
}
