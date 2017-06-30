package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.ShareFromFrsView;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import com.baidu.tieba.w;
import java.util.Calendar;
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.base.d<MsglistActivity<?>> {
    protected int auq;
    protected TextView bXs;
    private Calendar cXB;
    protected long cXC;
    protected Long cXD;
    protected TbRichTextView cXE;
    protected ChatVoiceView cXF;
    protected GifView cXG;
    protected Invite2GroupView cXH;
    protected ShareFromPBView cXI;
    protected ShareFromFrsView cXJ;
    protected ShareFromGameCenter cXK;
    protected ChatImageWithTailView cXL;
    protected boolean cXM;
    protected boolean cXN;
    protected com.baidu.adp.lib.c.a cXg;
    protected com.baidu.adp.lib.c.b cXh;
    protected int cXq;
    private long mLastTime;

    public ar(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.cXg = null;
        this.cXh = null;
        this.auq = 0;
        this.cXC = 0L;
        this.cXD = null;
        this.cXM = true;
        this.cXN = false;
        this.mLastTime = 0L;
        this.cXB = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.cXg = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.cXh = bVar;
    }

    public void setPosition(int i) {
        this.auq = i;
    }

    public void bz(long j) {
        this.mLastTime = j;
    }

    public void bA(long j) {
        this.cXB = Calendar.getInstance();
        this.cXB.setTimeInMillis(1000 * j);
    }

    private boolean bB(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String bC(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.cXB != null && this.cXB.get(1) == calendar.get(1) && this.cXB.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.aw.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.aw.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.cXD = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bXs = (TextView) findViewById(w.h.tex_msgitem_time);
        this.cXE = (TbRichTextView) findViewById(w.h.tex_msgitem_text);
        this.cXE.setLinkTextColor(-14845754);
        this.cXL = (ChatImageWithTailView) findViewById(w.h.img_msgitem_image);
        this.cXH = (Invite2GroupView) findViewById(w.h.lay_msgitem_invite_view);
        this.cXI = (ShareFromPBView) findViewById(w.h.lay_msgitem_share_view);
        this.cXJ = (ShareFromFrsView) findViewById(w.h.lay_msgitem_share_frs);
        this.cXK = (ShareFromGameCenter) findViewById(w.h.lay_msgitem_share_game);
        this.cXF = (ChatVoiceView) findViewById(w.h.lay_msgitem_voice);
        this.cXF.setClickable(true);
        this.cXF.setOnClickListener(this.cXF);
        this.cXF.setLongClickable(true);
        this.cXF.setOnLongClickListener(new as(this));
        this.cXL.getImage().setClickable(true);
        this.cXL.getImage().setOnClickListener(new az(this));
        this.cXL.getImage().setLongClickable(true);
        this.cXL.getImage().setOnLongClickListener(new ba(this));
        this.cXL.getTail().setClickable(true);
        this.cXL.getTail().setOnClickListener(new bb(this));
        this.cXE.setLongClickable(true);
        this.cXE.setOnLongClickListener(new bc(this));
        this.cXG = (GifView) findViewById(w.h.emotion_msgitem_image);
        this.cXG.setSupportNoImage(false);
        this.cXG.setOnClickListener(new bd(this));
        this.cXG.setLongClickable(true);
        this.cXG.setOnLongClickListener(new be(this));
        this.cXI.setClickable(true);
        this.cXI.setOnClickListener(new bf(this));
        this.cXI.setLongClickable(true);
        this.cXI.setOnLongClickListener(new bg(this));
        this.cXJ.setClickable(true);
        this.cXJ.setOnClickListener(new at(this));
        this.cXJ.setLongClickable(true);
        this.cXJ.setOnLongClickListener(new au(this));
        this.cXK.getContentBody().setClickable(true);
        this.cXK.getContentBody().setOnClickListener(new av(this));
        this.cXK.getTail().setClickable(true);
        this.cXK.getTail().setOnClickListener(new aw(this));
        this.cXK.getContentBody().setLongClickable(true);
        this.cXK.getContentBody().setOnLongClickListener(new ax(this));
        if (this.cXH != null) {
            this.cXH.setOnLongClickListener(new ay(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lC(int i) {
        this.cXL.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bB = bB(chatMessage.getTime());
        if (z || bB) {
            this.bXs.setVisibility(0);
            this.bXs.setText(bC(chatMessage.getTime()));
        } else {
            this.bXs.setVisibility(8);
        }
        if (!z && bB) {
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
        bq.a(this.mContext.getContext(), this.cXE, chatMessage, str, this.cXq);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.cXE.setContentDescription(stringBuffer.toString());
            this.cXE.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cXL, chatMessage, this.cXC, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.cXF, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bq.a(this.mContext.getContext(), this.cXG, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bq.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.cXH, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cXI, this.cXJ, this.cXK, chatMessage, str);
    }

    public void fG(boolean z) {
        this.cXM = z;
    }

    public void fH(boolean z) {
        this.cXN = z;
    }

    public void lB(int i) {
        this.cXq = i;
    }
}
