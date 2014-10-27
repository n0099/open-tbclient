package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
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
public class cc extends com.baidu.adp.base.d<ChatMessage> {
    protected int Uy;
    protected com.baidu.adp.lib.c.a aOK;
    protected com.baidu.adp.lib.c.b aOL;
    private long aOX;
    private Calendar aOY;
    protected long aOZ;
    protected Long aPa;
    protected TbRichTextView aPb;
    protected ChatVoiceView aPc;
    protected GifView aPd;
    protected Invite2GroupView aPe;
    protected ShareFromPBView aPf;
    protected ShareFromGameCenter aPg;
    protected ChatImageWithTailView aPh;
    protected boolean aPi;
    protected boolean aPj;
    protected TextView auh;

    public cc(Context context, int i) {
        super(context, i);
        this.aOK = null;
        this.aOL = null;
        this.Uy = 0;
        this.aOZ = 0L;
        this.aPa = null;
        this.aPi = true;
        this.aPj = false;
        this.aOX = 0L;
        this.aOY = null;
        this.mContext = context;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.aOK = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aOL = bVar;
    }

    public void setPosition(int i) {
        this.Uy = i;
    }

    public void setGid(long j) {
        this.aOZ = j;
    }

    public void H(long j) {
        this.aOX = j;
    }

    public void I(long j) {
        this.aOY = Calendar.getInstance();
        this.aOY.setTimeInMillis(1000 * j);
    }

    private boolean J(long j) {
        if (j < 1000) {
            return false;
        }
        return this.aOX == 0 || j - this.aOX >= 180;
    }

    private String K(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.aOY != null && this.aOY.get(1) == calendar.get(1) && this.aOY.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.ay.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.ay.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.aPa = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nu() {
        this.auh = (TextView) findViewById(com.baidu.tieba.v.tex_msgitem_time);
        this.aPb = (TbRichTextView) findViewById(com.baidu.tieba.v.tex_msgitem_text);
        this.aPb.setLinkTextColor(-14845754);
        this.aPh = (ChatImageWithTailView) findViewById(com.baidu.tieba.v.img_msgitem_image);
        this.aPe = (Invite2GroupView) findViewById(com.baidu.tieba.v.lay_msgitem_invite_view);
        this.aPf = (ShareFromPBView) findViewById(com.baidu.tieba.v.lay_msgitem_share_view);
        this.aPg = (ShareFromGameCenter) findViewById(com.baidu.tieba.v.lay_msgitem_share_game);
        this.aPc = (ChatVoiceView) findViewById(com.baidu.tieba.v.lay_msgitem_voice);
        this.aPc.setClickable(true);
        this.aPc.setOnClickListener(this.aPc);
        this.aPc.setLongClickable(true);
        this.aPc.setOnLongClickListener(new cd(this));
        this.aPh.getImage().setClickable(true);
        this.aPh.getImage().setOnClickListener(new ch(this));
        this.aPh.getImage().setLongClickable(true);
        this.aPh.getImage().setOnLongClickListener(new ci(this));
        this.aPh.getTail().setClickable(true);
        this.aPh.getTail().setOnClickListener(new cj(this));
        this.aPb.setLongClickable(true);
        this.aPb.setOnLongClickListener(new ck(this));
        this.aPd = (GifView) findViewById(com.baidu.tieba.v.emotion_msgitem_image);
        this.aPd.setOnClickListener(new cl(this));
        this.aPd.setLongClickable(true);
        this.aPd.setOnLongClickListener(new cm(this));
        this.aPf.setClickable(true);
        this.aPf.setOnClickListener(new cn(this));
        this.aPf.setLongClickable(true);
        this.aPf.setOnLongClickListener(new co(this));
        this.aPg.getContentBody().setClickable(true);
        this.aPg.getContentBody().setOnClickListener(new ce(this));
        this.aPg.getTail().setClickable(true);
        this.aPg.getTail().setOnClickListener(new cf(this));
        this.aPg.getContentBody().setLongClickable(true);
        this.aPg.getContentBody().setOnLongClickListener(new cg(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fq(int i) {
        this.aPh.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean J = J(chatMessage.getTime());
        if (z || J) {
            this.auh.setVisibility(0);
            this.auh.setText(K(chatMessage.getTime()));
        } else {
            this.auh.setVisibility(8);
        }
        if (!z && J) {
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
    public void b(ChatMessage chatMessage, String str) {
        dm.a(this.mContext, this.aPb, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        dm.a(this.mContext, view, this.aPh, chatMessage, this.aOZ, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(ChatMessage chatMessage, String str) {
        dm.a(this.mContext, this.aPc, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        dm.a(this.mContext, this.aPd, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        dm.a(this.mContext, view, this.aPe, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        dm.a(this.mContext, view, this.aPf, this.aPg, chatMessage, str);
    }

    public void cA(boolean z) {
        this.aPi = z;
    }

    public void cB(boolean z) {
        this.aPj = z;
    }
}
