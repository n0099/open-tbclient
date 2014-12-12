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
public class az extends com.baidu.adp.base.e<MsglistActivity<?>> {
    private long aQW;
    private Calendar aQX;
    protected Long aQY;
    protected TbRichTextView aQZ;
    protected ChatVoiceView aRa;
    protected GifView aRb;
    protected Invite2GroupView aRc;
    protected ShareFromPBView aRd;
    protected ShareFromGameCenter aRe;
    protected ChatImageWithTailView aRf;
    protected boolean aRg;
    protected boolean aRh;
    protected TextView axA;
    protected long mGid;
    protected com.baidu.adp.lib.c.a mItemViewClickListener;
    protected com.baidu.adp.lib.c.b mItemViewLongClickListener;
    protected int mPosition;

    public az(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.mItemViewClickListener = null;
        this.mItemViewLongClickListener = null;
        this.mPosition = 0;
        this.mGid = 0L;
        this.aQY = null;
        this.aRg = true;
        this.aRh = false;
        this.aQW = 0L;
        this.aQX = null;
        this.mContext = tbPageContext;
    }

    public void setOnItemViewClickListener(com.baidu.adp.lib.c.a aVar) {
        this.mItemViewClickListener = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.mItemViewLongClickListener = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setGid(long j) {
        this.mGid = j;
    }

    public void P(long j) {
        this.aQW = j;
    }

    public void Q(long j) {
        this.aQX = Calendar.getInstance();
        this.aQX.setTimeInMillis(1000 * j);
    }

    private boolean R(long j) {
        if (j < 1000) {
            return false;
        }
        return this.aQW == 0 || j - this.aQW >= 180;
    }

    private String S(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.aQX != null && this.aQX.get(1) == calendar.get(1) && this.aQX.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.ba.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.ba.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.aQY = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.axA = (TextView) findViewById(com.baidu.tieba.w.tex_msgitem_time);
        this.aQZ = (TbRichTextView) findViewById(com.baidu.tieba.w.tex_msgitem_text);
        this.aQZ.setLinkTextColor(-14845754);
        this.aRf = (ChatImageWithTailView) findViewById(com.baidu.tieba.w.img_msgitem_image);
        this.aRc = (Invite2GroupView) findViewById(com.baidu.tieba.w.lay_msgitem_invite_view);
        this.aRd = (ShareFromPBView) findViewById(com.baidu.tieba.w.lay_msgitem_share_view);
        this.aRe = (ShareFromGameCenter) findViewById(com.baidu.tieba.w.lay_msgitem_share_game);
        this.aRa = (ChatVoiceView) findViewById(com.baidu.tieba.w.lay_msgitem_voice);
        this.aRa.setClickable(true);
        this.aRa.setOnClickListener(this.aRa);
        this.aRa.setLongClickable(true);
        this.aRa.setOnLongClickListener(new ba(this));
        this.aRf.getImage().setClickable(true);
        this.aRf.getImage().setOnClickListener(new be(this));
        this.aRf.getImage().setLongClickable(true);
        this.aRf.getImage().setOnLongClickListener(new bf(this));
        this.aRf.getTail().setClickable(true);
        this.aRf.getTail().setOnClickListener(new bg(this));
        this.aQZ.setLongClickable(true);
        this.aQZ.setOnLongClickListener(new bh(this));
        this.aRb = (GifView) findViewById(com.baidu.tieba.w.emotion_msgitem_image);
        this.aRb.setOnClickListener(new bi(this));
        this.aRb.setLongClickable(true);
        this.aRb.setOnLongClickListener(new bj(this));
        this.aRd.setClickable(true);
        this.aRd.setOnClickListener(new bk(this));
        this.aRd.setLongClickable(true);
        this.aRd.setOnLongClickListener(new bl(this));
        this.aRe.getContentBody().setClickable(true);
        this.aRe.getContentBody().setOnClickListener(new bb(this));
        this.aRe.getTail().setClickable(true);
        this.aRe.getTail().setOnClickListener(new bc(this));
        this.aRe.getContentBody().setLongClickable(true);
        this.aRe.getContentBody().setOnLongClickListener(new bd(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ft(int i) {
        this.aRf.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean R = R(chatMessage.getTime());
        if (z || R) {
            this.axA.setVisibility(0);
            this.axA.setText(S(chatMessage.getTime()));
        } else {
            this.axA.setVisibility(8);
        }
        if (!z && R) {
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
        cs.a(this.mContext.getContext(), this.aQZ, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        cs.a(this.mContext.getContext(), view, this.aRf, chatMessage, this.mGid, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        cs.a(this.mContext.getContext(), this.aRa, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        cs.a(this.mContext.getContext(), this.aRb, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        cs.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.aRc, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        cs.a(this.mContext.getContext(), view, this.aRd, this.aRe, chatMessage, str);
    }

    public void setNeedShowName(boolean z) {
        this.aRg = z;
    }

    public void setIsPersonal(boolean z) {
        this.aRh = z;
    }
}
