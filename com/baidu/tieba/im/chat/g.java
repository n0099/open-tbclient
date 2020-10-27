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
    protected TextView ggF;
    protected com.baidu.adp.lib.b.a jPI;
    protected com.baidu.adp.lib.b.b jPJ;
    protected int jPR;
    private Calendar jQc;
    protected long jQd;
    protected TbRichTextView jQe;
    protected ChatVoiceView jQf;
    protected GifView jQg;
    protected Invite2GroupView jQh;
    protected ShareFromPBView jQi;
    protected ShareFromFrsView jQj;
    protected ShareFromGameCenter jQk;
    protected ChatImageWithTailView jQl;
    protected boolean jQm;
    protected boolean jQn;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.jPI = null;
        this.jPJ = null;
        this.mPosition = 0;
        this.jQd = 0L;
        this.mId = null;
        this.jQm = true;
        this.jQn = false;
        this.mLastTime = 0L;
        this.jQc = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.jPI = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jPJ = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void fE(long j) {
        this.mLastTime = j;
    }

    public void fF(long j) {
        this.jQc = Calendar.getInstance();
        this.jQc.setTimeInMillis(1000 * j);
    }

    private boolean fG(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String fH(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.jQc != null && this.jQc.get(1) == calendar.get(1) && this.jQc.get(6) == calendar.get(6)) {
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
        this.ggF = (TextView) findViewById(R.id.tex_msgitem_time);
        this.jQe = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.jQe.setLinkTextColor(-14845754);
        this.jQl = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.jQh = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.jQi = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.jQj = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.jQk = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.jQf = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.jQf.setClickable(true);
        this.jQf.setOnClickListener(this.jQf);
        this.jQf.setLongClickable(true);
        this.jQf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jPJ.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jQl.getImage().setClickable(true);
        this.jQl.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jPI.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.jQl.getImage().setLongClickable(true);
        this.jQl.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jPJ.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jQl.getTail().setClickable(true);
        this.jQl.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jPI.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.jQe.setLongClickable(true);
        this.jQe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jPJ.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jQg = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.jQg.setSupportNoImage(false);
        this.jQg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jPI.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.jQg.setLongClickable(true);
        this.jQg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jPJ.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jQi.setClickable(true);
        this.jQi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jPI.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.jQi.setLongClickable(true);
        this.jQi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jPJ.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jQj.setClickable(true);
        this.jQj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jPI.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.jQj.setLongClickable(true);
        this.jQj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jPJ.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.jQk.getContentBody().setClickable(true);
        this.jQk.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jPI.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.jQk.getTail().setClickable(true);
        this.jQk.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.jPI.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.jQk.getContentBody().setLongClickable(true);
        this.jQk.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.jPJ.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.jQh != null) {
            this.jQh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.jPJ.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cl(int i) {
        this.jQl.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean fG = fG(chatMessage.getTime());
        if (z || fG) {
            this.ggF.setVisibility(0);
            this.ggF.setText(fH(chatMessage.getTime()));
        } else {
            this.ggF.setVisibility(8);
        }
        if (!z && fG) {
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
        j.a(this.mContext.getContext(), this.jQe, chatMessage, str, this.jPR);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.jQe.setContentDescription(stringBuffer.toString());
            this.jQe.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.jQl, chatMessage, this.jQd, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.jQf, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.jQg, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.jQh, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.jQi, this.jQj, this.jQk, chatMessage, str);
    }

    public void rn(boolean z) {
        this.jQm = z;
    }

    public void ro(boolean z) {
        this.jQn = z;
    }

    public void Ck(int i) {
        this.jPR = i;
    }
}
