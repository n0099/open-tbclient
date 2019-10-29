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
    protected TextView dyX;
    protected boolean gAa;
    protected int gzD;
    private Calendar gzO;
    protected long gzP;
    protected Long gzQ;
    protected TbRichTextView gzR;
    protected ChatVoiceView gzS;
    protected GifView gzT;
    protected Invite2GroupView gzU;
    protected ShareFromPBView gzV;
    protected ShareFromFrsView gzW;
    protected ShareFromGameCenter gzX;
    protected ChatImageWithTailView gzY;
    protected boolean gzZ;
    protected com.baidu.adp.lib.c.a gzu;
    protected com.baidu.adp.lib.c.b gzv;
    private long mLastTime;
    protected int mPosition;

    public g(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.gzu = null;
        this.gzv = null;
        this.mPosition = 0;
        this.gzP = 0L;
        this.gzQ = null;
        this.gzZ = true;
        this.gAa = false;
        this.mLastTime = 0L;
        this.gzO = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gzu = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gzv = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void da(long j) {
        this.mLastTime = j;
    }

    public void db(long j) {
        this.gzO = Calendar.getInstance();
        this.gzO.setTimeInMillis(1000 * j);
    }

    private boolean dc(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String dd(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.gzO != null && this.gzO.get(1) == calendar.get(1) && this.gzO.get(6) == calendar.get(6)) {
            return aq.getDateStringHm(calendar.getTime());
        }
        return aq.getDateStringMdHm(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.gzQ = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dyX = (TextView) findViewById(R.id.tex_msgitem_time);
        this.gzR = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.gzR.setLinkTextColor(-14845754);
        this.gzY = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.gzU = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.gzV = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.gzW = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.gzX = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.gzS = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.gzS.setClickable(true);
        this.gzS.setOnClickListener(this.gzS);
        this.gzS.setLongClickable(true);
        this.gzS.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gzv.onItemViewLongClick(view, 5, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzY.getImage().setClickable(true);
        this.gzY.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gzu.onItemViewClick(view, 4, g.this.mPosition, 0L);
            }
        });
        this.gzY.getImage().setLongClickable(true);
        this.gzY.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gzv.onItemViewLongClick(view, 4, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzY.getTail().setClickable(true);
        this.gzY.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gzu.onItemViewClick(view, 13, g.this.mPosition, 0L);
            }
        });
        this.gzR.setLongClickable(true);
        this.gzR.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gzv.onItemViewLongClick(view, 3, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzT = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.gzT.setSupportNoImage(false);
        this.gzT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gzu.onItemViewClick(view, 7, g.this.mPosition, 0L);
            }
        });
        this.gzT.setLongClickable(true);
        this.gzT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gzv.onItemViewLongClick(view, 7, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzV.setClickable(true);
        this.gzV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gzu.onItemViewClick(view, 10, g.this.mPosition, 0L);
            }
        });
        this.gzV.setLongClickable(true);
        this.gzV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gzv.onItemViewLongClick(view, 10, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzW.setClickable(true);
        this.gzW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gzu.onItemViewClick(view, 15, g.this.mPosition, 0L);
            }
        });
        this.gzW.setLongClickable(true);
        this.gzW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gzv.onItemViewLongClick(view, 15, g.this.mPosition, 0L);
                return true;
            }
        });
        this.gzX.getContentBody().setClickable(true);
        this.gzX.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gzu.onItemViewClick(view, 11, g.this.mPosition, 0L);
            }
        });
        this.gzX.getTail().setClickable(true);
        this.gzX.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gzu.onItemViewClick(view, 12, g.this.mPosition, 0L);
            }
        });
        this.gzX.getContentBody().setLongClickable(true);
        this.gzX.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                g.this.gzv.onItemViewLongClick(view, 11, g.this.mPosition, 0L);
                return true;
            }
        });
        if (this.gzU != null) {
            this.gzU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.g.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    g.this.gzv.onItemViewLongClick(view, 17, g.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tP(int i) {
        this.gzY.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean dc = dc(chatMessage.getTime());
        if (z || dc) {
            this.dyX.setVisibility(0);
            this.dyX.setText(dd(chatMessage.getTime()));
        } else {
            this.dyX.setVisibility(8);
        }
        if (!z && dc) {
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
        j.a(this.mContext.getContext(), this.gzR, chatMessage, str, this.gzD);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.gzR.setContentDescription(stringBuffer.toString());
            this.gzR.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gzY, chatMessage, this.gzP, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), this.gzS, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        j.a(this.mContext.getContext(), this.gzT, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        j.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.gzU, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        j.a(this.mContext.getContext(), view, this.gzV, this.gzW, this.gzX, chatMessage, str);
    }

    public void lC(boolean z) {
        this.gzZ = z;
    }

    public void lD(boolean z) {
        this.gAa = z;
    }

    public void tO(int i) {
        this.gzD = i;
    }
}
