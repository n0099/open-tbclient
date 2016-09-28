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
import com.baidu.tieba.r;
import java.util.Calendar;
/* loaded from: classes.dex */
public class as extends com.baidu.adp.base.d<MsglistActivity<?>> {
    protected int aok;
    protected TextView bLI;
    private long bgZ;
    protected com.baidu.adp.lib.d.a cUE;
    protected com.baidu.adp.lib.d.b cUF;
    protected int cUN;
    private Calendar cUY;
    protected long cUZ;
    protected Long cVa;
    protected TbRichTextView cVb;
    protected ChatVoiceView cVc;
    protected GifView cVd;
    protected Invite2GroupView cVe;
    protected ShareFromPBView cVf;
    protected ShareFromFrsView cVg;
    protected ShareFromGameCenter cVh;
    protected ChatImageWithTailView cVi;
    protected boolean cVj;
    protected boolean cVk;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.cUE = null;
        this.cUF = null;
        this.aok = 0;
        this.cUZ = 0L;
        this.cVa = null;
        this.cVj = true;
        this.cVk = false;
        this.bgZ = 0L;
        this.cUY = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.cUE = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.cUF = bVar;
    }

    public void setPosition(int i) {
        this.aok = i;
    }

    public void bO(long j) {
        this.bgZ = j;
    }

    public void bP(long j) {
        this.cUY = Calendar.getInstance();
        this.cUY.setTimeInMillis(1000 * j);
    }

    private boolean bQ(long j) {
        if (j < 1000) {
            return false;
        }
        return this.bgZ == 0 || j - this.bgZ >= 180;
    }

    private String bR(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.cUY != null && this.cUY.get(1) == calendar.get(1) && this.cUY.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.az.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.az.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.cVa = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bLI = (TextView) findViewById(r.g.tex_msgitem_time);
        this.cVb = (TbRichTextView) findViewById(r.g.tex_msgitem_text);
        this.cVb.setLinkTextColor(-14845754);
        this.cVi = (ChatImageWithTailView) findViewById(r.g.img_msgitem_image);
        this.cVe = (Invite2GroupView) findViewById(r.g.lay_msgitem_invite_view);
        this.cVf = (ShareFromPBView) findViewById(r.g.lay_msgitem_share_view);
        this.cVg = (ShareFromFrsView) findViewById(r.g.lay_msgitem_share_frs);
        this.cVh = (ShareFromGameCenter) findViewById(r.g.lay_msgitem_share_game);
        this.cVc = (ChatVoiceView) findViewById(r.g.lay_msgitem_voice);
        this.cVc.setClickable(true);
        this.cVc.setOnClickListener(this.cVc);
        this.cVc.setLongClickable(true);
        this.cVc.setOnLongClickListener(new at(this));
        this.cVi.getImage().setClickable(true);
        this.cVi.getImage().setOnClickListener(new ba(this));
        this.cVi.getImage().setLongClickable(true);
        this.cVi.getImage().setOnLongClickListener(new bb(this));
        this.cVi.getTail().setClickable(true);
        this.cVi.getTail().setOnClickListener(new bc(this));
        this.cVb.setLongClickable(true);
        this.cVb.setOnLongClickListener(new bd(this));
        this.cVd = (GifView) findViewById(r.g.emotion_msgitem_image);
        this.cVd.setSupportNoImage(false);
        this.cVd.setOnClickListener(new be(this));
        this.cVd.setLongClickable(true);
        this.cVd.setOnLongClickListener(new bf(this));
        this.cVf.setClickable(true);
        this.cVf.setOnClickListener(new bg(this));
        this.cVf.setLongClickable(true);
        this.cVf.setOnLongClickListener(new bh(this));
        this.cVg.setClickable(true);
        this.cVg.setOnClickListener(new au(this));
        this.cVg.setLongClickable(true);
        this.cVg.setOnLongClickListener(new av(this));
        this.cVh.getContentBody().setClickable(true);
        this.cVh.getContentBody().setOnClickListener(new aw(this));
        this.cVh.getTail().setClickable(true);
        this.cVh.getTail().setOnClickListener(new ax(this));
        this.cVh.getContentBody().setLongClickable(true);
        this.cVh.getContentBody().setOnLongClickListener(new ay(this));
        if (this.cVe != null) {
            this.cVe.setOnLongClickListener(new az(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void li(int i) {
        this.cVi.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bQ = bQ(chatMessage.getTime());
        if (z || bQ) {
            this.bLI.setVisibility(0);
            this.bLI.setText(bR(chatMessage.getTime()));
        } else {
            this.bLI.setVisibility(8);
        }
        if (!z && bQ) {
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
        br.a(this.mContext.getContext(), this.cVb, chatMessage, str, this.cUN);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.cVb.setContentDescription(stringBuffer.toString());
            this.cVb.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), view, this.cVi, chatMessage, this.cUZ, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), this.cVc, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        br.a(this.mContext.getContext(), this.cVd, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        br.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.cVe, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), view, this.cVf, this.cVg, this.cVh, chatMessage, str);
    }

    public void fs(boolean z) {
        this.cVj = z;
    }

    public void ft(boolean z) {
        this.cVk = z;
    }

    public void lh(int i) {
        this.cUN = i;
    }
}
