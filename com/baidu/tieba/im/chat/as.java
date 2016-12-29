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
    protected int aoG;
    private long bjq;
    protected TextView buG;
    protected int cFI;
    private Calendar cFT;
    protected long cFU;
    protected Long cFV;
    protected TbRichTextView cFW;
    protected ChatVoiceView cFX;
    protected GifView cFY;
    protected Invite2GroupView cFZ;
    protected com.baidu.adp.lib.d.a cFy;
    protected com.baidu.adp.lib.d.b cFz;
    protected ShareFromPBView cGa;
    protected ShareFromFrsView cGb;
    protected ShareFromGameCenter cGc;
    protected ChatImageWithTailView cGd;
    protected boolean cGe;
    protected boolean cGf;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.cFy = null;
        this.cFz = null;
        this.aoG = 0;
        this.cFU = 0L;
        this.cFV = null;
        this.cGe = true;
        this.cGf = false;
        this.bjq = 0L;
        this.cFT = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.cFy = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.cFz = bVar;
    }

    public void setPosition(int i) {
        this.aoG = i;
    }

    public void bB(long j) {
        this.bjq = j;
    }

    public void bC(long j) {
        this.cFT = Calendar.getInstance();
        this.cFT.setTimeInMillis(1000 * j);
    }

    private boolean bD(long j) {
        if (j < 1000) {
            return false;
        }
        return this.bjq == 0 || j - this.bjq >= 180;
    }

    private String bE(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.cFT != null && this.cFT.get(1) == calendar.get(1) && this.cFT.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.av.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.av.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.cFV = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.buG = (TextView) findViewById(r.g.tex_msgitem_time);
        this.cFW = (TbRichTextView) findViewById(r.g.tex_msgitem_text);
        this.cFW.setLinkTextColor(-14845754);
        this.cGd = (ChatImageWithTailView) findViewById(r.g.img_msgitem_image);
        this.cFZ = (Invite2GroupView) findViewById(r.g.lay_msgitem_invite_view);
        this.cGa = (ShareFromPBView) findViewById(r.g.lay_msgitem_share_view);
        this.cGb = (ShareFromFrsView) findViewById(r.g.lay_msgitem_share_frs);
        this.cGc = (ShareFromGameCenter) findViewById(r.g.lay_msgitem_share_game);
        this.cFX = (ChatVoiceView) findViewById(r.g.lay_msgitem_voice);
        this.cFX.setClickable(true);
        this.cFX.setOnClickListener(this.cFX);
        this.cFX.setLongClickable(true);
        this.cFX.setOnLongClickListener(new at(this));
        this.cGd.getImage().setClickable(true);
        this.cGd.getImage().setOnClickListener(new ba(this));
        this.cGd.getImage().setLongClickable(true);
        this.cGd.getImage().setOnLongClickListener(new bb(this));
        this.cGd.getTail().setClickable(true);
        this.cGd.getTail().setOnClickListener(new bc(this));
        this.cFW.setLongClickable(true);
        this.cFW.setOnLongClickListener(new bd(this));
        this.cFY = (GifView) findViewById(r.g.emotion_msgitem_image);
        this.cFY.setSupportNoImage(false);
        this.cFY.setOnClickListener(new be(this));
        this.cFY.setLongClickable(true);
        this.cFY.setOnLongClickListener(new bf(this));
        this.cGa.setClickable(true);
        this.cGa.setOnClickListener(new bg(this));
        this.cGa.setLongClickable(true);
        this.cGa.setOnLongClickListener(new bh(this));
        this.cGb.setClickable(true);
        this.cGb.setOnClickListener(new au(this));
        this.cGb.setLongClickable(true);
        this.cGb.setOnLongClickListener(new av(this));
        this.cGc.getContentBody().setClickable(true);
        this.cGc.getContentBody().setOnClickListener(new aw(this));
        this.cGc.getTail().setClickable(true);
        this.cGc.getTail().setOnClickListener(new ax(this));
        this.cGc.getContentBody().setLongClickable(true);
        this.cGc.getContentBody().setOnLongClickListener(new ay(this));
        if (this.cFZ != null) {
            this.cFZ.setOnLongClickListener(new az(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kA(int i) {
        this.cGd.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bD = bD(chatMessage.getTime());
        if (z || bD) {
            this.buG.setVisibility(0);
            this.buG.setText(bE(chatMessage.getTime()));
        } else {
            this.buG.setVisibility(8);
        }
        if (!z && bD) {
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
        br.a(this.mContext.getContext(), this.cFW, chatMessage, str, this.cFI);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.cFW.setContentDescription(stringBuffer.toString());
            this.cFW.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), view, this.cGd, chatMessage, this.cFU, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), this.cFX, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        br.a(this.mContext.getContext(), this.cFY, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        br.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.cFZ, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), view, this.cGa, this.cGb, this.cGc, chatMessage, str);
    }

    public void fx(boolean z) {
        this.cGe = z;
    }

    public void fy(boolean z) {
        this.cGf = z;
    }

    public void kz(int i) {
        this.cFI = i;
    }
}
