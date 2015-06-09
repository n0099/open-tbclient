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
    protected TextView aJb;
    protected com.baidu.adp.lib.c.a aZZ;
    protected GifView baA;
    protected Invite2GroupView baB;
    protected ShareFromPBView baC;
    protected ShareFromGameCenter baD;
    protected ChatImageWithTailView baE;
    protected boolean baF;
    protected boolean baG;
    protected com.baidu.adp.lib.c.b baa;
    protected int bai;
    private long bau;
    private Calendar bav;
    protected long baw;
    protected Long bax;
    protected TbRichTextView bay;
    protected ChatVoiceView baz;
    protected int mPosition;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.aZZ = null;
        this.baa = null;
        this.mPosition = 0;
        this.baw = 0L;
        this.bax = null;
        this.baF = true;
        this.baG = false;
        this.bau = 0L;
        this.bav = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.aZZ = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.baa = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void U(long j) {
        this.bau = j;
    }

    public void V(long j) {
        this.bav = Calendar.getInstance();
        this.bav.setTimeInMillis(1000 * j);
    }

    private boolean W(long j) {
        if (j < 1000) {
            return false;
        }
        return this.bau == 0 || j - this.bau >= 180;
    }

    private String X(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.bav != null && this.bav.get(1) == calendar.get(1) && this.bav.get(6) == calendar.get(6)) {
            return bb.b(calendar.getTime());
        }
        return bb.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.bax = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aJb = (TextView) findViewById(com.baidu.tieba.q.tex_msgitem_time);
        this.bay = (TbRichTextView) findViewById(com.baidu.tieba.q.tex_msgitem_text);
        this.bay.setLinkTextColor(-14845754);
        this.baE = (ChatImageWithTailView) findViewById(com.baidu.tieba.q.img_msgitem_image);
        this.baB = (Invite2GroupView) findViewById(com.baidu.tieba.q.lay_msgitem_invite_view);
        this.baC = (ShareFromPBView) findViewById(com.baidu.tieba.q.lay_msgitem_share_view);
        this.baD = (ShareFromGameCenter) findViewById(com.baidu.tieba.q.lay_msgitem_share_game);
        this.baz = (ChatVoiceView) findViewById(com.baidu.tieba.q.lay_msgitem_voice);
        this.baz.setClickable(true);
        this.baz.setOnClickListener(this.baz);
        this.baz.setLongClickable(true);
        this.baz.setOnLongClickListener(new bl(this));
        this.baE.getImage().setClickable(true);
        this.baE.getImage().setOnClickListener(new bp(this));
        this.baE.getImage().setLongClickable(true);
        this.baE.getImage().setOnLongClickListener(new bq(this));
        this.baE.getTail().setClickable(true);
        this.baE.getTail().setOnClickListener(new br(this));
        this.bay.setLongClickable(true);
        this.bay.setOnLongClickListener(new bs(this));
        this.baA = (GifView) findViewById(com.baidu.tieba.q.emotion_msgitem_image);
        this.baA.setOnClickListener(new bt(this));
        this.baA.setLongClickable(true);
        this.baA.setOnLongClickListener(new bu(this));
        this.baC.setClickable(true);
        this.baC.setOnClickListener(new bv(this));
        this.baC.setLongClickable(true);
        this.baC.setOnLongClickListener(new bw(this));
        this.baD.getContentBody().setClickable(true);
        this.baD.getContentBody().setOnClickListener(new bm(this));
        this.baD.getTail().setClickable(true);
        this.baD.getTail().setOnClickListener(new bn(this));
        this.baD.getContentBody().setLongClickable(true);
        this.baD.getContentBody().setOnLongClickListener(new bo(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fS(int i) {
        this.baE.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean W = W(chatMessage.getTime());
        if (z || W) {
            this.aJb.setVisibility(0);
            this.aJb.setText(X(chatMessage.getTime()));
        } else {
            this.aJb.setVisibility(8);
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
        cg.a(this.mContext.getContext(), this.bay, chatMessage, str, this.bai);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        cg.a(this.mContext.getContext(), view, this.baE, chatMessage, this.baw, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        cg.a(this.mContext.getContext(), this.baz, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        cg.a(this.mContext.getContext(), this.baA, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        cg.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.baB, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        cg.a(this.mContext.getContext(), view, this.baC, this.baD, chatMessage, str);
    }

    public void cA(boolean z) {
        this.baF = z;
    }

    public void cB(boolean z) {
        this.baG = z;
    }

    public void fR(int i) {
        this.bai = i;
    }
}
