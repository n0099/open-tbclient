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
    protected int UC;
    protected com.baidu.adp.lib.c.a aOY;
    protected com.baidu.adp.lib.c.b aOZ;
    private long aPl;
    private Calendar aPm;
    protected long aPn;
    protected Long aPo;
    protected TbRichTextView aPp;
    protected ChatVoiceView aPq;
    protected GifView aPr;
    protected Invite2GroupView aPs;
    protected ShareFromPBView aPt;
    protected ShareFromGameCenter aPu;
    protected ChatImageWithTailView aPv;
    protected boolean aPw;
    protected boolean aPx;
    protected TextView auq;

    public cc(Context context, int i) {
        super(context, i);
        this.aOY = null;
        this.aOZ = null;
        this.UC = 0;
        this.aPn = 0L;
        this.aPo = null;
        this.aPw = true;
        this.aPx = false;
        this.aPl = 0L;
        this.aPm = null;
        this.mContext = context;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.aOY = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aOZ = bVar;
    }

    public void setPosition(int i) {
        this.UC = i;
    }

    public void setGid(long j) {
        this.aPn = j;
    }

    public void H(long j) {
        this.aPl = j;
    }

    public void I(long j) {
        this.aPm = Calendar.getInstance();
        this.aPm.setTimeInMillis(1000 * j);
    }

    private boolean J(long j) {
        if (j < 1000) {
            return false;
        }
        return this.aPl == 0 || j - this.aPl >= 180;
    }

    private String K(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.aPm != null && this.aPm.get(1) == calendar.get(1) && this.aPm.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.az.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.az.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.aPo = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nu() {
        this.auq = (TextView) findViewById(com.baidu.tieba.v.tex_msgitem_time);
        this.aPp = (TbRichTextView) findViewById(com.baidu.tieba.v.tex_msgitem_text);
        this.aPp.setLinkTextColor(-14845754);
        this.aPv = (ChatImageWithTailView) findViewById(com.baidu.tieba.v.img_msgitem_image);
        this.aPs = (Invite2GroupView) findViewById(com.baidu.tieba.v.lay_msgitem_invite_view);
        this.aPt = (ShareFromPBView) findViewById(com.baidu.tieba.v.lay_msgitem_share_view);
        this.aPu = (ShareFromGameCenter) findViewById(com.baidu.tieba.v.lay_msgitem_share_game);
        this.aPq = (ChatVoiceView) findViewById(com.baidu.tieba.v.lay_msgitem_voice);
        this.aPq.setClickable(true);
        this.aPq.setOnClickListener(this.aPq);
        this.aPq.setLongClickable(true);
        this.aPq.setOnLongClickListener(new cd(this));
        this.aPv.getImage().setClickable(true);
        this.aPv.getImage().setOnClickListener(new ch(this));
        this.aPv.getImage().setLongClickable(true);
        this.aPv.getImage().setOnLongClickListener(new ci(this));
        this.aPv.getTail().setClickable(true);
        this.aPv.getTail().setOnClickListener(new cj(this));
        this.aPp.setLongClickable(true);
        this.aPp.setOnLongClickListener(new ck(this));
        this.aPr = (GifView) findViewById(com.baidu.tieba.v.emotion_msgitem_image);
        this.aPr.setOnClickListener(new cl(this));
        this.aPr.setLongClickable(true);
        this.aPr.setOnLongClickListener(new cm(this));
        this.aPt.setClickable(true);
        this.aPt.setOnClickListener(new cn(this));
        this.aPt.setLongClickable(true);
        this.aPt.setOnLongClickListener(new co(this));
        this.aPu.getContentBody().setClickable(true);
        this.aPu.getContentBody().setOnClickListener(new ce(this));
        this.aPu.getTail().setClickable(true);
        this.aPu.getTail().setOnClickListener(new cf(this));
        this.aPu.getContentBody().setLongClickable(true);
        this.aPu.getContentBody().setOnLongClickListener(new cg(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fq(int i) {
        this.aPv.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean J = J(chatMessage.getTime());
        if (z || J) {
            this.auq.setVisibility(0);
            this.auq.setText(K(chatMessage.getTime()));
        } else {
            this.auq.setVisibility(8);
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
        dm.a(this.mContext, this.aPp, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        dm.a(this.mContext, view, this.aPv, chatMessage, this.aPn, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(ChatMessage chatMessage, String str) {
        dm.a(this.mContext, this.aPq, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        dm.a(this.mContext, this.aPr, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        dm.a(this.mContext, view, this.aPs, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        dm.a(this.mContext, view, this.aPt, this.aPu, chatMessage, str);
    }

    public void cA(boolean z) {
        this.aPw = z;
    }

    public void cB(boolean z) {
        this.aPx = z;
    }
}
