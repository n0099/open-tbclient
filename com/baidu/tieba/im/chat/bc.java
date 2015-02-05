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
    private long aSe;
    private Calendar aSf;
    protected Long aSg;
    protected TbRichTextView aSh;
    protected ChatVoiceView aSi;
    protected GifView aSj;
    protected Invite2GroupView aSk;
    protected ShareFromPBView aSl;
    protected ShareFromGameCenter aSm;
    protected ChatImageWithTailView aSn;
    protected boolean aSo;
    protected boolean aSp;
    protected TextView ayx;
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
        this.aSg = null;
        this.aSo = true;
        this.aSp = false;
        this.aSe = 0L;
        this.aSf = null;
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
        this.aSe = j;
    }

    public void Q(long j) {
        this.aSf = Calendar.getInstance();
        this.aSf.setTimeInMillis(1000 * j);
    }

    private boolean R(long j) {
        if (j < 1000) {
            return false;
        }
        return this.aSe == 0 || j - this.aSe >= 180;
    }

    private String S(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.aSf != null && this.aSf.get(1) == calendar.get(1) && this.aSf.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.bf.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.bf.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.aSg = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.ayx = (TextView) findViewById(com.baidu.tieba.w.tex_msgitem_time);
        this.aSh = (TbRichTextView) findViewById(com.baidu.tieba.w.tex_msgitem_text);
        this.aSh.setLinkTextColor(-14845754);
        this.aSn = (ChatImageWithTailView) findViewById(com.baidu.tieba.w.img_msgitem_image);
        this.aSk = (Invite2GroupView) findViewById(com.baidu.tieba.w.lay_msgitem_invite_view);
        this.aSl = (ShareFromPBView) findViewById(com.baidu.tieba.w.lay_msgitem_share_view);
        this.aSm = (ShareFromGameCenter) findViewById(com.baidu.tieba.w.lay_msgitem_share_game);
        this.aSi = (ChatVoiceView) findViewById(com.baidu.tieba.w.lay_msgitem_voice);
        this.aSi.setClickable(true);
        this.aSi.setOnClickListener(this.aSi);
        this.aSi.setLongClickable(true);
        this.aSi.setOnLongClickListener(new bd(this));
        this.aSn.getImage().setClickable(true);
        this.aSn.getImage().setOnClickListener(new bh(this));
        this.aSn.getImage().setLongClickable(true);
        this.aSn.getImage().setOnLongClickListener(new bi(this));
        this.aSn.getTail().setClickable(true);
        this.aSn.getTail().setOnClickListener(new bj(this));
        this.aSh.setLongClickable(true);
        this.aSh.setOnLongClickListener(new bk(this));
        this.aSj = (GifView) findViewById(com.baidu.tieba.w.emotion_msgitem_image);
        this.aSj.setOnClickListener(new bl(this));
        this.aSj.setLongClickable(true);
        this.aSj.setOnLongClickListener(new bm(this));
        this.aSl.setClickable(true);
        this.aSl.setOnClickListener(new bn(this));
        this.aSl.setLongClickable(true);
        this.aSl.setOnLongClickListener(new bo(this));
        this.aSm.getContentBody().setClickable(true);
        this.aSm.getContentBody().setOnClickListener(new be(this));
        this.aSm.getTail().setClickable(true);
        this.aSm.getTail().setOnClickListener(new bf(this));
        this.aSm.getContentBody().setLongClickable(true);
        this.aSm.getContentBody().setOnLongClickListener(new bg(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fy(int i) {
        this.aSn.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean R = R(chatMessage.getTime());
        if (z || R) {
            this.ayx.setVisibility(0);
            this.ayx.setText(S(chatMessage.getTime()));
        } else {
            this.ayx.setVisibility(8);
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
        cv.a(this.mContext.getContext(), this.aSh, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        cv.a(this.mContext.getContext(), view, this.aSn, chatMessage, this.mGid, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        cv.a(this.mContext.getContext(), this.aSi, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        cv.a(this.mContext.getContext(), this.aSj, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        cv.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.aSk, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        cv.a(this.mContext.getContext(), view, this.aSl, this.aSm, chatMessage, str);
    }

    public void setNeedShowName(boolean z) {
        this.aSo = z;
    }

    public void setIsPersonal(boolean z) {
        this.aSp = z;
    }
}
