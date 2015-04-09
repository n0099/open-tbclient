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
    protected TextView aGS;
    protected int aXB;
    private long aXM;
    private Calendar aXN;
    protected long aXO;
    protected Long aXP;
    protected TbRichTextView aXQ;
    protected ChatVoiceView aXR;
    protected GifView aXS;
    protected Invite2GroupView aXT;
    protected ShareFromPBView aXU;
    protected ShareFromGameCenter aXV;
    protected ChatImageWithTailView aXW;
    protected boolean aXX;
    protected boolean aXY;
    protected com.baidu.adp.lib.c.a aXs;
    protected com.baidu.adp.lib.c.b aXt;
    protected int mPosition;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.aXs = null;
        this.aXt = null;
        this.mPosition = 0;
        this.aXO = 0L;
        this.aXP = null;
        this.aXX = true;
        this.aXY = false;
        this.aXM = 0L;
        this.aXN = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.aXs = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aXt = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void T(long j) {
        this.aXM = j;
    }

    public void U(long j) {
        this.aXN = Calendar.getInstance();
        this.aXN.setTimeInMillis(1000 * j);
    }

    private boolean V(long j) {
        if (j < 1000) {
            return false;
        }
        return this.aXM == 0 || j - this.aXM >= 180;
    }

    private String W(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.aXN != null && this.aXN.get(1) == calendar.get(1) && this.aXN.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.bd.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.bd.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.aXP = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aGS = (TextView) findViewById(com.baidu.tieba.v.tex_msgitem_time);
        this.aXQ = (TbRichTextView) findViewById(com.baidu.tieba.v.tex_msgitem_text);
        this.aXQ.setLinkTextColor(-14845754);
        this.aXW = (ChatImageWithTailView) findViewById(com.baidu.tieba.v.img_msgitem_image);
        this.aXT = (Invite2GroupView) findViewById(com.baidu.tieba.v.lay_msgitem_invite_view);
        this.aXU = (ShareFromPBView) findViewById(com.baidu.tieba.v.lay_msgitem_share_view);
        this.aXV = (ShareFromGameCenter) findViewById(com.baidu.tieba.v.lay_msgitem_share_game);
        this.aXR = (ChatVoiceView) findViewById(com.baidu.tieba.v.lay_msgitem_voice);
        this.aXR.setClickable(true);
        this.aXR.setOnClickListener(this.aXR);
        this.aXR.setLongClickable(true);
        this.aXR.setOnLongClickListener(new bl(this));
        this.aXW.getImage().setClickable(true);
        this.aXW.getImage().setOnClickListener(new bp(this));
        this.aXW.getImage().setLongClickable(true);
        this.aXW.getImage().setOnLongClickListener(new bq(this));
        this.aXW.getTail().setClickable(true);
        this.aXW.getTail().setOnClickListener(new br(this));
        this.aXQ.setLongClickable(true);
        this.aXQ.setOnLongClickListener(new bs(this));
        this.aXS = (GifView) findViewById(com.baidu.tieba.v.emotion_msgitem_image);
        this.aXS.setOnClickListener(new bt(this));
        this.aXS.setLongClickable(true);
        this.aXS.setOnLongClickListener(new bu(this));
        this.aXU.setClickable(true);
        this.aXU.setOnClickListener(new bv(this));
        this.aXU.setLongClickable(true);
        this.aXU.setOnLongClickListener(new bw(this));
        this.aXV.getContentBody().setClickable(true);
        this.aXV.getContentBody().setOnClickListener(new bm(this));
        this.aXV.getTail().setClickable(true);
        this.aXV.getTail().setOnClickListener(new bn(this));
        this.aXV.getContentBody().setLongClickable(true);
        this.aXV.getContentBody().setOnLongClickListener(new bo(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fB(int i) {
        this.aXW.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean V = V(chatMessage.getTime());
        if (z || V) {
            this.aGS.setVisibility(0);
            this.aGS.setText(W(chatMessage.getTime()));
        } else {
            this.aGS.setVisibility(8);
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
        cg.a(this.mContext.getContext(), this.aXQ, chatMessage, str, this.aXB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        cg.a(this.mContext.getContext(), view, this.aXW, chatMessage, this.aXO, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        cg.a(this.mContext.getContext(), this.aXR, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        cg.a(this.mContext.getContext(), this.aXS, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        cg.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.aXT, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        cg.a(this.mContext.getContext(), view, this.aXU, this.aXV, chatMessage, str);
    }

    public void cp(boolean z) {
        this.aXX = z;
    }

    public void cq(boolean z) {
        this.aXY = z;
    }

    public void fA(int i) {
        this.aXB = i;
    }
}
