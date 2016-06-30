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
import com.baidu.tieba.u;
import java.util.Calendar;
/* loaded from: classes.dex */
public class as extends com.baidu.adp.base.d<MsglistActivity<?>> {
    protected int akG;
    protected TextView bxR;
    protected com.baidu.adp.lib.d.a cEP;
    protected com.baidu.adp.lib.d.b cEQ;
    protected int cEY;
    private long cFj;
    private Calendar cFk;
    protected long cFl;
    protected Long cFm;
    protected TbRichTextView cFn;
    protected ChatVoiceView cFo;
    protected GifView cFp;
    protected Invite2GroupView cFq;
    protected ShareFromPBView cFr;
    protected ShareFromFrsView cFs;
    protected ShareFromGameCenter cFt;
    protected ChatImageWithTailView cFu;
    protected boolean cFv;
    protected boolean cFw;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.cEP = null;
        this.cEQ = null;
        this.akG = 0;
        this.cFl = 0L;
        this.cFm = null;
        this.cFv = true;
        this.cFw = false;
        this.cFj = 0L;
        this.cFk = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.cEP = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.cEQ = bVar;
    }

    public void setPosition(int i) {
        this.akG = i;
    }

    public void bx(long j) {
        this.cFj = j;
    }

    public void by(long j) {
        this.cFk = Calendar.getInstance();
        this.cFk.setTimeInMillis(1000 * j);
    }

    private boolean bz(long j) {
        if (j < 1000) {
            return false;
        }
        return this.cFj == 0 || j - this.cFj >= 180;
    }

    private String bA(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.cFk != null && this.cFk.get(1) == calendar.get(1) && this.cFk.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.ba.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.ba.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.cFm = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bxR = (TextView) findViewById(u.g.tex_msgitem_time);
        this.cFn = (TbRichTextView) findViewById(u.g.tex_msgitem_text);
        this.cFn.setLinkTextColor(-14845754);
        this.cFu = (ChatImageWithTailView) findViewById(u.g.img_msgitem_image);
        this.cFq = (Invite2GroupView) findViewById(u.g.lay_msgitem_invite_view);
        this.cFr = (ShareFromPBView) findViewById(u.g.lay_msgitem_share_view);
        this.cFs = (ShareFromFrsView) findViewById(u.g.lay_msgitem_share_frs);
        this.cFt = (ShareFromGameCenter) findViewById(u.g.lay_msgitem_share_game);
        this.cFo = (ChatVoiceView) findViewById(u.g.lay_msgitem_voice);
        this.cFo.setClickable(true);
        this.cFo.setOnClickListener(this.cFo);
        this.cFo.setLongClickable(true);
        this.cFo.setOnLongClickListener(new at(this));
        this.cFu.getImage().setClickable(true);
        this.cFu.getImage().setOnClickListener(new ba(this));
        this.cFu.getImage().setLongClickable(true);
        this.cFu.getImage().setOnLongClickListener(new bb(this));
        this.cFu.getTail().setClickable(true);
        this.cFu.getTail().setOnClickListener(new bc(this));
        this.cFn.setLongClickable(true);
        this.cFn.setOnLongClickListener(new bd(this));
        this.cFp = (GifView) findViewById(u.g.emotion_msgitem_image);
        this.cFp.setSupportNoImage(false);
        this.cFp.setOnClickListener(new be(this));
        this.cFp.setLongClickable(true);
        this.cFp.setOnLongClickListener(new bf(this));
        this.cFr.setClickable(true);
        this.cFr.setOnClickListener(new bg(this));
        this.cFr.setLongClickable(true);
        this.cFr.setOnLongClickListener(new bh(this));
        this.cFs.setClickable(true);
        this.cFs.setOnClickListener(new au(this));
        this.cFs.setLongClickable(true);
        this.cFs.setOnLongClickListener(new av(this));
        this.cFt.getContentBody().setClickable(true);
        this.cFt.getContentBody().setOnClickListener(new aw(this));
        this.cFt.getTail().setClickable(true);
        this.cFt.getTail().setOnClickListener(new ax(this));
        this.cFt.getContentBody().setLongClickable(true);
        this.cFt.getContentBody().setOnLongClickListener(new ay(this));
        if (this.cFq != null) {
            this.cFq.setOnLongClickListener(new az(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kr(int i) {
        this.cFu.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bz = bz(chatMessage.getTime());
        if (z || bz) {
            this.bxR.setVisibility(0);
            this.bxR.setText(bA(chatMessage.getTime()));
        } else {
            this.bxR.setVisibility(8);
        }
        if (!z && bz) {
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
        br.a(this.mContext.getContext(), this.cFn, chatMessage, str, this.cEY);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.cFn.setContentDescription(stringBuffer.toString());
            this.cFn.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), view, this.cFu, chatMessage, this.cFl, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), this.cFo, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        br.a(this.mContext.getContext(), this.cFp, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        br.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.cFq, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), view, this.cFr, this.cFs, this.cFt, chatMessage, str);
    }

    public void eS(boolean z) {
        this.cFv = z;
    }

    public void eT(boolean z) {
        this.cFw = z;
    }

    public void kq(int i) {
        this.cEY = i;
    }
}
