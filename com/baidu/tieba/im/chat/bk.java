package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bb;
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
    protected TextView aJa;
    protected com.baidu.adp.lib.c.a aZY;
    protected com.baidu.adp.lib.c.b aZZ;
    protected Invite2GroupView baA;
    protected ShareFromPBView baB;
    protected ShareFromGameCenter baC;
    protected ChatImageWithTailView baD;
    protected boolean baE;
    protected boolean baF;
    protected int bah;
    private long bat;
    private Calendar bau;
    protected long bav;
    protected Long baw;
    protected TbRichTextView bax;
    protected ChatVoiceView bay;
    protected GifView baz;
    protected int mPosition;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.aZY = null;
        this.aZZ = null;
        this.mPosition = 0;
        this.bav = 0L;
        this.baw = null;
        this.baE = true;
        this.baF = false;
        this.bat = 0L;
        this.bau = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.aZY = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aZZ = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void U(long j) {
        this.bat = j;
    }

    public void V(long j) {
        this.bau = Calendar.getInstance();
        this.bau.setTimeInMillis(1000 * j);
    }

    private boolean W(long j) {
        if (j < 1000) {
            return false;
        }
        return this.bat == 0 || j - this.bat >= 180;
    }

    private String X(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.bau != null && this.bau.get(1) == calendar.get(1) && this.bau.get(6) == calendar.get(6)) {
            return bb.b(calendar.getTime());
        }
        return bb.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.baw = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aJa = (TextView) findViewById(com.baidu.tieba.q.tex_msgitem_time);
        this.bax = (TbRichTextView) findViewById(com.baidu.tieba.q.tex_msgitem_text);
        this.bax.setLinkTextColor(-14845754);
        this.baD = (ChatImageWithTailView) findViewById(com.baidu.tieba.q.img_msgitem_image);
        this.baA = (Invite2GroupView) findViewById(com.baidu.tieba.q.lay_msgitem_invite_view);
        this.baB = (ShareFromPBView) findViewById(com.baidu.tieba.q.lay_msgitem_share_view);
        this.baC = (ShareFromGameCenter) findViewById(com.baidu.tieba.q.lay_msgitem_share_game);
        this.bay = (ChatVoiceView) findViewById(com.baidu.tieba.q.lay_msgitem_voice);
        this.bay.setClickable(true);
        this.bay.setOnClickListener(this.bay);
        this.bay.setLongClickable(true);
        this.bay.setOnLongClickListener(new bl(this));
        this.baD.getImage().setClickable(true);
        this.baD.getImage().setOnClickListener(new bp(this));
        this.baD.getImage().setLongClickable(true);
        this.baD.getImage().setOnLongClickListener(new bq(this));
        this.baD.getTail().setClickable(true);
        this.baD.getTail().setOnClickListener(new br(this));
        this.bax.setLongClickable(true);
        this.bax.setOnLongClickListener(new bs(this));
        this.baz = (GifView) findViewById(com.baidu.tieba.q.emotion_msgitem_image);
        this.baz.setOnClickListener(new bt(this));
        this.baz.setLongClickable(true);
        this.baz.setOnLongClickListener(new bu(this));
        this.baB.setClickable(true);
        this.baB.setOnClickListener(new bv(this));
        this.baB.setLongClickable(true);
        this.baB.setOnLongClickListener(new bw(this));
        this.baC.getContentBody().setClickable(true);
        this.baC.getContentBody().setOnClickListener(new bm(this));
        this.baC.getTail().setClickable(true);
        this.baC.getTail().setOnClickListener(new bn(this));
        this.baC.getContentBody().setLongClickable(true);
        this.baC.getContentBody().setOnLongClickListener(new bo(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fS(int i) {
        this.baD.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean W = W(chatMessage.getTime());
        if (z || W) {
            this.aJa.setVisibility(0);
            this.aJa.setText(X(chatMessage.getTime()));
        } else {
            this.aJa.setVisibility(8);
        }
        if (!z && W) {
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
        cg.a(this.mContext.getContext(), this.bax, chatMessage, str, this.bah);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        cg.a(this.mContext.getContext(), view, this.baD, chatMessage, this.bav, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        cg.a(this.mContext.getContext(), this.bay, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        cg.a(this.mContext.getContext(), this.baz, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        cg.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.baA, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        cg.a(this.mContext.getContext(), view, this.baB, this.baC, chatMessage, str);
    }

    public void cA(boolean z) {
        this.baE = z;
    }

    public void cB(boolean z) {
        this.baF = z;
    }

    public void fR(int i) {
        this.bah = i;
    }
}
