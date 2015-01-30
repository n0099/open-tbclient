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
public class bc extends com.baidu.adp.base.e<MsglistActivity<?>> {
    private long aSf;
    private Calendar aSg;
    protected Long aSh;
    protected TbRichTextView aSi;
    protected ChatVoiceView aSj;
    protected GifView aSk;
    protected Invite2GroupView aSl;
    protected ShareFromPBView aSm;
    protected ShareFromGameCenter aSn;
    protected ChatImageWithTailView aSo;
    protected boolean aSp;
    protected boolean aSq;
    protected TextView ayA;
    protected long mGid;
    protected com.baidu.adp.lib.c.a mItemViewClickListener;
    protected com.baidu.adp.lib.c.b mItemViewLongClickListener;
    protected int mPosition;

    public bc(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.mItemViewClickListener = null;
        this.mItemViewLongClickListener = null;
        this.mPosition = 0;
        this.mGid = 0L;
        this.aSh = null;
        this.aSp = true;
        this.aSq = false;
        this.aSf = 0L;
        this.aSg = null;
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
        this.aSf = j;
    }

    public void Q(long j) {
        this.aSg = Calendar.getInstance();
        this.aSg.setTimeInMillis(1000 * j);
    }

    private boolean R(long j) {
        if (j < 1000) {
            return false;
        }
        return this.aSf == 0 || j - this.aSf >= 180;
    }

    private String S(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.aSg != null && this.aSg.get(1) == calendar.get(1) && this.aSg.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.bf.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.bf.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.aSh = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.ayA = (TextView) findViewById(com.baidu.tieba.w.tex_msgitem_time);
        this.aSi = (TbRichTextView) findViewById(com.baidu.tieba.w.tex_msgitem_text);
        this.aSi.setLinkTextColor(-14845754);
        this.aSo = (ChatImageWithTailView) findViewById(com.baidu.tieba.w.img_msgitem_image);
        this.aSl = (Invite2GroupView) findViewById(com.baidu.tieba.w.lay_msgitem_invite_view);
        this.aSm = (ShareFromPBView) findViewById(com.baidu.tieba.w.lay_msgitem_share_view);
        this.aSn = (ShareFromGameCenter) findViewById(com.baidu.tieba.w.lay_msgitem_share_game);
        this.aSj = (ChatVoiceView) findViewById(com.baidu.tieba.w.lay_msgitem_voice);
        this.aSj.setClickable(true);
        this.aSj.setOnClickListener(this.aSj);
        this.aSj.setLongClickable(true);
        this.aSj.setOnLongClickListener(new bd(this));
        this.aSo.getImage().setClickable(true);
        this.aSo.getImage().setOnClickListener(new bh(this));
        this.aSo.getImage().setLongClickable(true);
        this.aSo.getImage().setOnLongClickListener(new bi(this));
        this.aSo.getTail().setClickable(true);
        this.aSo.getTail().setOnClickListener(new bj(this));
        this.aSi.setLongClickable(true);
        this.aSi.setOnLongClickListener(new bk(this));
        this.aSk = (GifView) findViewById(com.baidu.tieba.w.emotion_msgitem_image);
        this.aSk.setOnClickListener(new bl(this));
        this.aSk.setLongClickable(true);
        this.aSk.setOnLongClickListener(new bm(this));
        this.aSm.setClickable(true);
        this.aSm.setOnClickListener(new bn(this));
        this.aSm.setLongClickable(true);
        this.aSm.setOnLongClickListener(new bo(this));
        this.aSn.getContentBody().setClickable(true);
        this.aSn.getContentBody().setOnClickListener(new be(this));
        this.aSn.getTail().setClickable(true);
        this.aSn.getTail().setOnClickListener(new bf(this));
        this.aSn.getContentBody().setLongClickable(true);
        this.aSn.getContentBody().setOnLongClickListener(new bg(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fy(int i) {
        this.aSo.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean R = R(chatMessage.getTime());
        if (z || R) {
            this.ayA.setVisibility(0);
            this.ayA.setText(S(chatMessage.getTime()));
        } else {
            this.ayA.setVisibility(8);
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
        cv.a(this.mContext.getContext(), this.aSi, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        cv.a(this.mContext.getContext(), view, this.aSo, chatMessage, this.mGid, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        cv.a(this.mContext.getContext(), this.aSj, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        cv.a(this.mContext.getContext(), this.aSk, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        cv.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.aSl, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        cv.a(this.mContext.getContext(), view, this.aSm, this.aSn, chatMessage, str);
    }

    public void setNeedShowName(boolean z) {
        this.aSp = z;
    }

    public void setIsPersonal(boolean z) {
        this.aSq = z;
    }
}
