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
    protected TextView feW;
    protected com.baidu.adp.lib.b.a isD;
    protected com.baidu.adp.lib.b.b isE;
    protected int isM;
    private Calendar isX;
    protected long isY;
    protected TbRichTextView isZ;
    protected ChatVoiceView ita;
    protected GifView itb;
    protected Invite2GroupView itc;
    protected ShareFromPBView itd;
    protected ShareFromFrsView ite;
    protected ShareFromGameCenter itf;
    protected ChatImageWithTailView itg;
    protected boolean ith;
    protected boolean iti;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.isD = null;
        this.isE = null;
        this.mPosition = 0;
        this.isY = 0L;
        this.mId = null;
        this.ith = true;
        this.iti = false;
        this.mLastTime = 0L;
        this.isX = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.isD = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.isE = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void ev(long j) {
        this.mLastTime = j;
    }

    public void ew(long j) {
        this.isX = Calendar.getInstance();
        this.isX.setTimeInMillis(1000 * j);
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
        if (this.isX != null && this.isX.get(1) == calendar.get(1) && this.isX.get(6) == calendar.get(6)) {
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
        this.feW = (TextView) findViewById(R.id.tex_msgitem_time);
        this.isZ = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.isZ.setLinkTextColor(-14845754);
        this.itg = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.itc = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.itd = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.ite = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.itf = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.ita = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.ita.setClickable(true);
        this.ita.setOnClickListener(this.ita);
        this.ita.setLongClickable(true);
        this.ita.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.isE.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.itg.getImage().setClickable(true);
        this.itg.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.isD.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.itg.getImage().setLongClickable(true);
        this.itg.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.isE.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.itg.getTail().setClickable(true);
        this.itg.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.isD.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.isZ.setLongClickable(true);
        this.isZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.isE.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.itb = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.itb.setSupportNoImage(false);
        this.itb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.isD.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.itb.setLongClickable(true);
        this.itb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.isE.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.itd.setClickable(true);
        this.itd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.isD.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.itd.setLongClickable(true);
        this.itd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.isE.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.ite.setClickable(true);
        this.ite.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.isD.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.ite.setLongClickable(true);
        this.ite.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.isE.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.itf.getContentBody().setClickable(true);
        this.itf.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.isD.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.itf.getTail().setClickable(true);
        this.itf.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.isD.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.itf.getContentBody().setLongClickable(true);
        this.itf.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.isE.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.itc != null) {
            this.itc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.isE.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xn(int i) {
        this.itg.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean ex = ex(chatMessage.getTime());
        if (z || ex) {
            this.feW.setVisibility(0);
            this.feW.setText(ey(chatMessage.getTime()));
        } else {
            this.feW.setVisibility(8);
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
        j.a(this.mContext.getContext(), this.isZ, chatMessage, str, this.isM);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.isZ.setContentDescription(stringBuffer.toString());
            this.isZ.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.itg, chatMessage, this.isY, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.ita, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.itb, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.itc, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.itd, this.ite, this.itf, chatMessage, str);
    }

    public void oK(boolean z) {
        this.ith = z;
    }

    public void oL(boolean z) {
        this.iti = z;
    }

    public void xm(int i) {
        this.isM = i;
    }
}
