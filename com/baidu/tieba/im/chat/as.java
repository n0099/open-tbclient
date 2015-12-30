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
import com.baidu.tieba.n;
import java.util.Calendar;
/* loaded from: classes.dex */
public class as extends com.baidu.adp.base.d<MsglistActivity<?>> {
    protected TextView aZi;
    protected int anc;
    protected com.baidu.adp.lib.d.a bKU;
    protected com.baidu.adp.lib.d.b bKV;
    protected boolean bLA;
    protected boolean bLB;
    protected int bLd;
    private long bLo;
    private Calendar bLp;
    protected long bLq;
    protected Long bLr;
    protected TbRichTextView bLs;
    protected ChatVoiceView bLt;
    protected GifView bLu;
    protected Invite2GroupView bLv;
    protected ShareFromPBView bLw;
    protected ShareFromFrsView bLx;
    protected ShareFromGameCenter bLy;
    protected ChatImageWithTailView bLz;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.bKU = null;
        this.bKV = null;
        this.anc = 0;
        this.bLq = 0L;
        this.bLr = null;
        this.bLA = true;
        this.bLB = false;
        this.bLo = 0L;
        this.bLp = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.bKU = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.bKV = bVar;
    }

    public void setPosition(int i) {
        this.anc = i;
    }

    public void aO(long j) {
        this.bLo = j;
    }

    public void aP(long j) {
        this.bLp = Calendar.getInstance();
        this.bLp.setTimeInMillis(1000 * j);
    }

    private boolean aQ(long j) {
        if (j < 1000) {
            return false;
        }
        return this.bLo == 0 || j - this.bLo >= 180;
    }

    private String aR(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.bLp != null && this.bLp.get(1) == calendar.get(1) && this.bLp.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.ax.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.ax.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.bLr = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aZi = (TextView) findViewById(n.g.tex_msgitem_time);
        this.bLs = (TbRichTextView) findViewById(n.g.tex_msgitem_text);
        this.bLs.setLinkTextColor(-14845754);
        this.bLz = (ChatImageWithTailView) findViewById(n.g.img_msgitem_image);
        this.bLv = (Invite2GroupView) findViewById(n.g.lay_msgitem_invite_view);
        this.bLw = (ShareFromPBView) findViewById(n.g.lay_msgitem_share_view);
        this.bLx = (ShareFromFrsView) findViewById(n.g.lay_msgitem_share_frs);
        this.bLy = (ShareFromGameCenter) findViewById(n.g.lay_msgitem_share_game);
        this.bLt = (ChatVoiceView) findViewById(n.g.lay_msgitem_voice);
        this.bLt.setClickable(true);
        this.bLt.setOnClickListener(this.bLt);
        this.bLt.setLongClickable(true);
        this.bLt.setOnLongClickListener(new at(this));
        this.bLz.getImage().setClickable(true);
        this.bLz.getImage().setOnClickListener(new az(this));
        this.bLz.getImage().setLongClickable(true);
        this.bLz.getImage().setOnLongClickListener(new ba(this));
        this.bLz.getTail().setClickable(true);
        this.bLz.getTail().setOnClickListener(new bb(this));
        this.bLs.setLongClickable(true);
        this.bLs.setOnLongClickListener(new bc(this));
        this.bLu = (GifView) findViewById(n.g.emotion_msgitem_image);
        this.bLu.setSupportNoImage(false);
        this.bLu.setOnClickListener(new bd(this));
        this.bLu.setLongClickable(true);
        this.bLu.setOnLongClickListener(new be(this));
        this.bLw.setClickable(true);
        this.bLw.setOnClickListener(new bf(this));
        this.bLw.setLongClickable(true);
        this.bLw.setOnLongClickListener(new bg(this));
        this.bLx.setClickable(true);
        this.bLx.setOnClickListener(new au(this));
        this.bLx.setLongClickable(true);
        this.bLx.setOnLongClickListener(new av(this));
        this.bLy.getContentBody().setClickable(true);
        this.bLy.getContentBody().setOnClickListener(new aw(this));
        this.bLy.getTail().setClickable(true);
        this.bLy.getTail().setOnClickListener(new ax(this));
        this.bLy.getContentBody().setLongClickable(true);
        this.bLy.getContentBody().setOnLongClickListener(new ay(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ii(int i) {
        this.bLz.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean aQ = aQ(chatMessage.getTime());
        if (z || aQ) {
            this.aZi.setVisibility(0);
            this.aZi.setText(aR(chatMessage.getTime()));
        } else {
            this.aZi.setVisibility(8);
        }
        if (!z && aQ) {
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
        bq.a(this.mContext.getContext(), this.bLs, chatMessage, str, this.bLd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.bLz, chatMessage, this.bLq, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.bLt, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bq.a(this.mContext.getContext(), this.bLu, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bq.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.bLv, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.bLw, this.bLx, this.bLy, chatMessage, str);
    }

    public void dh(boolean z) {
        this.bLA = z;
    }

    public void di(boolean z) {
        this.bLB = z;
    }

    public void ih(int i) {
        this.bLd = i;
    }
}
