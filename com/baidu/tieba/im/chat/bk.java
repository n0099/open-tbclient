package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class bk extends com.baidu.adp.base.e<MsglistActivity<?>> {
    protected TextView aGK;
    protected TbRichTextView aXA;
    protected ChatVoiceView aXB;
    protected GifView aXC;
    protected Invite2GroupView aXD;
    protected ShareFromPBView aXE;
    protected ShareFromGameCenter aXF;
    protected ChatImageWithTailView aXG;
    protected boolean aXH;
    protected boolean aXI;
    protected com.baidu.adp.lib.c.a aXc;
    protected com.baidu.adp.lib.c.b aXd;
    protected int aXl;
    private long aXw;
    private Calendar aXx;
    protected long aXy;
    protected Long aXz;
    protected int mPosition;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.aXc = null;
        this.aXd = null;
        this.mPosition = 0;
        this.aXy = 0L;
        this.aXz = null;
        this.aXH = true;
        this.aXI = false;
        this.aXw = 0L;
        this.aXx = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.aXc = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aXd = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void T(long j) {
        this.aXw = j;
    }

    public void U(long j) {
        this.aXx = Calendar.getInstance();
        this.aXx.setTimeInMillis(1000 * j);
    }

    private boolean V(long j) {
        if (j < 1000) {
            return false;
        }
        return this.aXw == 0 || j - this.aXw >= 180;
    }

    private String W(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.aXx != null && this.aXx.get(1) == calendar.get(1) && this.aXx.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.bd.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.bd.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.aXz = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aGK = (TextView) findViewById(com.baidu.tieba.v.tex_msgitem_time);
        this.aXA = (TbRichTextView) findViewById(com.baidu.tieba.v.tex_msgitem_text);
        this.aXA.setLinkTextColor(-14845754);
        this.aXG = (ChatImageWithTailView) findViewById(com.baidu.tieba.v.img_msgitem_image);
        this.aXD = (Invite2GroupView) findViewById(com.baidu.tieba.v.lay_msgitem_invite_view);
        this.aXE = (ShareFromPBView) findViewById(com.baidu.tieba.v.lay_msgitem_share_view);
        this.aXF = (ShareFromGameCenter) findViewById(com.baidu.tieba.v.lay_msgitem_share_game);
        this.aXB = (ChatVoiceView) findViewById(com.baidu.tieba.v.lay_msgitem_voice);
        this.aXB.setClickable(true);
        this.aXB.setOnClickListener(this.aXB);
        this.aXB.setLongClickable(true);
        this.aXB.setOnLongClickListener(new bl(this));
        this.aXG.getImage().setClickable(true);
        this.aXG.getImage().setOnClickListener(new bp(this));
        this.aXG.getImage().setLongClickable(true);
        this.aXG.getImage().setOnLongClickListener(new bq(this));
        this.aXG.getTail().setClickable(true);
        this.aXG.getTail().setOnClickListener(new br(this));
        this.aXA.setLongClickable(true);
        this.aXA.setOnLongClickListener(new bs(this));
        this.aXC = (GifView) findViewById(com.baidu.tieba.v.emotion_msgitem_image);
        this.aXC.setOnClickListener(new bt(this));
        this.aXC.setLongClickable(true);
        this.aXC.setOnLongClickListener(new bu(this));
        this.aXE.setClickable(true);
        this.aXE.setOnClickListener(new bv(this));
        this.aXE.setLongClickable(true);
        this.aXE.setOnLongClickListener(new bw(this));
        this.aXF.getContentBody().setClickable(true);
        this.aXF.getContentBody().setOnClickListener(new bm(this));
        this.aXF.getTail().setClickable(true);
        this.aXF.getTail().setOnClickListener(new bn(this));
        this.aXF.getContentBody().setLongClickable(true);
        this.aXF.getContentBody().setOnLongClickListener(new bo(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fz(int i) {
        this.aXG.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean V = V(chatMessage.getTime());
        if (z || V) {
            this.aGK.setVisibility(0);
            this.aGK.setText(W(chatMessage.getTime()));
        } else {
            this.aGK.setVisibility(8);
        }
        if (!z && V) {
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
        cg.a(this.mContext.getContext(), this.aXA, chatMessage, str, this.aXl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        cg.a(this.mContext.getContext(), view, this.aXG, chatMessage, this.aXy, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        cg.a(this.mContext.getContext(), this.aXB, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        cg.a(this.mContext.getContext(), this.aXC, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        cg.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.aXD, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        cg.a(this.mContext.getContext(), view, this.aXE, this.aXF, chatMessage, str);
    }

    public void cr(boolean z) {
        this.aXH = z;
    }

    public void cs(boolean z) {
        this.aXI = z;
    }

    public void fy(int i) {
        this.aXl = i;
    }
}
