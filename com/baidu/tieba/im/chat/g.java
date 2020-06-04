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
    protected TextView ffh;
    private Calendar itK;
    protected long itL;
    protected TbRichTextView itM;
    protected ChatVoiceView itN;
    protected GifView itO;
    protected Invite2GroupView itP;
    protected ShareFromPBView itQ;
    protected ShareFromFrsView itR;
    protected ShareFromGameCenter itS;
    protected ChatImageWithTailView itT;
    protected boolean itU;
    protected boolean itV;
    protected com.baidu.adp.lib.b.a itq;
    protected com.baidu.adp.lib.b.b itr;
    protected int itz;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.itq = null;
        this.itr = null;
        this.mPosition = 0;
        this.itL = 0L;
        this.mId = null;
        this.itU = true;
        this.itV = false;
        this.mLastTime = 0L;
        this.itK = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.itq = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.itr = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void ev(long j) {
        this.mLastTime = j;
    }

    public void ew(long j) {
        this.itK = Calendar.getInstance();
        this.itK.setTimeInMillis(1000 * j);
    }

    private boolean ex(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String ey(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.itK != null && this.itK.get(1) == calendar.get(1) && this.itK.get(6) == calendar.get(6)) {
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
        this.ffh = (TextView) findViewById(R.id.tex_msgitem_time);
        this.itM = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.itM.setLinkTextColor(-14845754);
        this.itT = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.itP = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.itQ = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.itR = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.itS = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.itN = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.itN.setClickable(true);
        this.itN.setOnClickListener(this.itN);
        this.itN.setLongClickable(true);
        this.itN.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.itr.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.itT.getImage().setClickable(true);
        this.itT.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.itq.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.itT.getImage().setLongClickable(true);
        this.itT.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.itr.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.itT.getTail().setClickable(true);
        this.itT.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.itq.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.itM.setLongClickable(true);
        this.itM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.itr.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.itO = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.itO.setSupportNoImage(false);
        this.itO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.itq.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.itO.setLongClickable(true);
        this.itO.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.itr.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.itQ.setClickable(true);
        this.itQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.itq.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.itQ.setLongClickable(true);
        this.itQ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.itr.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.itR.setClickable(true);
        this.itR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.itq.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.itR.setLongClickable(true);
        this.itR.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.itr.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.itS.getContentBody().setClickable(true);
        this.itS.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.itq.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.itS.getTail().setClickable(true);
        this.itS.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.itq.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.itS.getContentBody().setLongClickable(true);
        this.itS.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.itr.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.itP != null) {
            this.itP.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.itr.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xp(int i) {
        this.itT.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean ex = ex(chatMessage.getTime());
        if (z || ex) {
            this.ffh.setVisibility(0);
            this.ffh.setText(ey(chatMessage.getTime()));
        } else {
            this.ffh.setVisibility(8);
        }
        if (!z && ex) {
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
        j.a(this.mContext.getContext(), this.itM, chatMessage, str, this.itz);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.itM.setContentDescription(stringBuffer.toString());
            this.itM.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.itT, chatMessage, this.itL, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.itN, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.itO, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.itP, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.itQ, this.itR, this.itS, chatMessage, str);
    }

    public void oK(boolean z) {
        this.itU = z;
    }

    public void oL(boolean z) {
        this.itV = z;
    }

    public void xo(int i) {
        this.itz = i;
    }
}
