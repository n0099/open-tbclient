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
import com.baidu.tieba.t;
import java.util.Calendar;
/* loaded from: classes.dex */
public class as extends com.baidu.adp.base.d<MsglistActivity<?>> {
    protected int anV;
    protected com.baidu.adp.lib.d.a bOI;
    protected com.baidu.adp.lib.d.b bOJ;
    protected int bOR;
    private long bPc;
    private Calendar bPd;
    protected long bPe;
    protected Long bPf;
    protected TbRichTextView bPg;
    protected ChatVoiceView bPh;
    protected GifView bPi;
    protected Invite2GroupView bPj;
    protected ShareFromPBView bPk;
    protected ShareFromFrsView bPl;
    protected ShareFromGameCenter bPm;
    protected ChatImageWithTailView bPn;
    protected boolean bPo;
    protected boolean bPp;
    protected TextView bbx;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.bOI = null;
        this.bOJ = null;
        this.anV = 0;
        this.bPe = 0L;
        this.bPf = null;
        this.bPo = true;
        this.bPp = false;
        this.bPc = 0L;
        this.bPd = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.bOI = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.bOJ = bVar;
    }

    public void setPosition(int i) {
        this.anV = i;
    }

    public void aP(long j) {
        this.bPc = j;
    }

    public void aQ(long j) {
        this.bPd = Calendar.getInstance();
        this.bPd.setTimeInMillis(1000 * j);
    }

    private boolean aR(long j) {
        if (j < 1000) {
            return false;
        }
        return this.bPc == 0 || j - this.bPc >= 180;
    }

    private String aS(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.bPd != null && this.bPd.get(1) == calendar.get(1) && this.bPd.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.aw.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.aw.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.bPf = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bbx = (TextView) findViewById(t.g.tex_msgitem_time);
        this.bPg = (TbRichTextView) findViewById(t.g.tex_msgitem_text);
        this.bPg.setLinkTextColor(-14845754);
        this.bPn = (ChatImageWithTailView) findViewById(t.g.img_msgitem_image);
        this.bPj = (Invite2GroupView) findViewById(t.g.lay_msgitem_invite_view);
        this.bPk = (ShareFromPBView) findViewById(t.g.lay_msgitem_share_view);
        this.bPl = (ShareFromFrsView) findViewById(t.g.lay_msgitem_share_frs);
        this.bPm = (ShareFromGameCenter) findViewById(t.g.lay_msgitem_share_game);
        this.bPh = (ChatVoiceView) findViewById(t.g.lay_msgitem_voice);
        this.bPh.setClickable(true);
        this.bPh.setOnClickListener(this.bPh);
        this.bPh.setLongClickable(true);
        this.bPh.setOnLongClickListener(new at(this));
        this.bPn.getImage().setClickable(true);
        this.bPn.getImage().setOnClickListener(new az(this));
        this.bPn.getImage().setLongClickable(true);
        this.bPn.getImage().setOnLongClickListener(new ba(this));
        this.bPn.getTail().setClickable(true);
        this.bPn.getTail().setOnClickListener(new bb(this));
        this.bPg.setLongClickable(true);
        this.bPg.setOnLongClickListener(new bc(this));
        this.bPi = (GifView) findViewById(t.g.emotion_msgitem_image);
        this.bPi.setSupportNoImage(false);
        this.bPi.setOnClickListener(new bd(this));
        this.bPi.setLongClickable(true);
        this.bPi.setOnLongClickListener(new be(this));
        this.bPk.setClickable(true);
        this.bPk.setOnClickListener(new bf(this));
        this.bPk.setLongClickable(true);
        this.bPk.setOnLongClickListener(new bg(this));
        this.bPl.setClickable(true);
        this.bPl.setOnClickListener(new au(this));
        this.bPl.setLongClickable(true);
        this.bPl.setOnLongClickListener(new av(this));
        this.bPm.getContentBody().setClickable(true);
        this.bPm.getContentBody().setOnClickListener(new aw(this));
        this.bPm.getTail().setClickable(true);
        this.bPm.getTail().setOnClickListener(new ax(this));
        this.bPm.getContentBody().setLongClickable(true);
        this.bPm.getContentBody().setOnLongClickListener(new ay(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iF(int i) {
        this.bPn.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean aR = aR(chatMessage.getTime());
        if (z || aR) {
            this.bbx.setVisibility(0);
            this.bbx.setText(aS(chatMessage.getTime()));
        } else {
            this.bbx.setVisibility(8);
        }
        if (!z && aR) {
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
        bq.a(this.mContext.getContext(), this.bPg, chatMessage, str, this.bOR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.bPn, chatMessage, this.bPe, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.bPh, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bq.a(this.mContext.getContext(), this.bPi, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bq.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.bPj, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.bPk, this.bPl, this.bPm, chatMessage, str);
    }

    public void dj(boolean z) {
        this.bPo = z;
    }

    public void dk(boolean z) {
        this.bPp = z;
    }

    public void iE(int i) {
        this.bOR = i;
    }
}
