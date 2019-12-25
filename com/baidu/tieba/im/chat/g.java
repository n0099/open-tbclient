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
    protected TextView eji;
    protected com.baidu.adp.lib.b.a hmL;
    protected com.baidu.adp.lib.b.b hmM;
    protected int hmU;
    private Calendar hnf;
    protected long hng;
    protected TbRichTextView hnh;
    protected ChatVoiceView hni;
    protected GifView hnj;
    protected Invite2GroupView hnk;
    protected ShareFromPBView hnl;
    protected ShareFromFrsView hnm;
    protected ShareFromGameCenter hnn;
    protected ChatImageWithTailView hno;
    protected boolean hnp;
    protected boolean hnq;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.hmL = null;
        this.hmM = null;
        this.mPosition = 0;
        this.hng = 0L;
        this.mId = null;
        this.hnp = true;
        this.hnq = false;
        this.mLastTime = 0L;
        this.hnf = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.hmL = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.hmM = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void dF(long j) {
        this.mLastTime = j;
    }

    public void dG(long j) {
        this.hnf = Calendar.getInstance();
        this.hnf.setTimeInMillis(1000 * j);
    }

    private boolean dH(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String dI(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.hnf != null && this.hnf.get(1) == calendar.get(1) && this.hnf.get(6) == calendar.get(6)) {
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
        this.eji = (TextView) findViewById(R.id.tex_msgitem_time);
        this.hnh = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.hnh.setLinkTextColor(-14845754);
        this.hno = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.hnk = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.hnl = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.hnm = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.hnn = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.hni = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.hni.setClickable(true);
        this.hni.setOnClickListener(this.hni);
        this.hni.setLongClickable(true);
        this.hni.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hmM.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hno.getImage().setClickable(true);
        this.hno.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hmL.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.hno.getImage().setLongClickable(true);
        this.hno.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hmM.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hno.getTail().setClickable(true);
        this.hno.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hmL.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.hnh.setLongClickable(true);
        this.hnh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hmM.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hnj = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.hnj.setSupportNoImage(false);
        this.hnj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hmL.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.hnj.setLongClickable(true);
        this.hnj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hmM.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hnl.setClickable(true);
        this.hnl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hmL.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.hnl.setLongClickable(true);
        this.hnl.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hmM.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hnm.setClickable(true);
        this.hnm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hmL.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.hnm.setLongClickable(true);
        this.hnm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hmM.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.hnn.getContentBody().setClickable(true);
        this.hnn.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hmL.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.hnn.getTail().setClickable(true);
        this.hnn.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.hmL.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.hnn.getContentBody().setLongClickable(true);
        this.hnn.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.hmM.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.hnk != null) {
            this.hnk.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.hmM.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vQ(int i) {
        this.hno.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean dH = dH(chatMessage.getTime());
        if (z || dH) {
            this.eji.setVisibility(0);
            this.eji.setText(dI(chatMessage.getTime()));
        } else {
            this.eji.setVisibility(8);
        }
        if (!z && dH) {
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
        j.a(this.mContext.getContext(), this.hnh, chatMessage, str, this.hmU);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.hnh.setContentDescription(stringBuffer.toString());
            this.hnh.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.hno, chatMessage, this.hng, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.hni, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.hnj, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.hnk, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.hnl, this.hnm, this.hnn, chatMessage, str);
    }

    public void mQ(boolean z) {
        this.hnp = z;
    }

    public void mR(boolean z) {
        this.hnq = z;
    }

    public void vP(int i) {
        this.hmU = i;
    }
}
