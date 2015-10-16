package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.ShareFromFrsView;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class as extends com.baidu.adp.base.d<MsglistActivity<?>> {
    protected TextView aPX;
    protected int anL;
    protected com.baidu.adp.lib.c.a brD;
    protected com.baidu.adp.lib.c.b brE;
    protected int brM;
    private long brX;
    private Calendar brY;
    protected long brZ;
    protected Long bsa;
    protected TbRichTextView bsb;
    protected ChatVoiceView bsc;
    protected GifView bsd;
    protected Invite2GroupView bse;
    protected ShareFromPBView bsf;
    protected ShareFromFrsView bsg;
    protected ShareFromGameCenter bsh;
    protected ChatImageWithTailView bsi;
    protected boolean bsj;
    protected boolean bsk;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.brD = null;
        this.brE = null;
        this.anL = 0;
        this.brZ = 0L;
        this.bsa = null;
        this.bsj = true;
        this.bsk = false;
        this.brX = 0L;
        this.brY = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.brD = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.brE = bVar;
    }

    public void setPosition(int i) {
        this.anL = i;
    }

    public void aB(long j) {
        this.brX = j;
    }

    public void aC(long j) {
        this.brY = Calendar.getInstance();
        this.brY.setTimeInMillis(1000 * j);
    }

    private boolean aD(long j) {
        if (j < 1000) {
            return false;
        }
        return this.brX == 0 || j - this.brX >= 180;
    }

    private String aE(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.brY != null && this.brY.get(1) == calendar.get(1) && this.brY.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.as.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.as.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.bsa = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aPX = (TextView) findViewById(i.f.tex_msgitem_time);
        this.bsb = (TbRichTextView) findViewById(i.f.tex_msgitem_text);
        this.bsb.setLinkTextColor(-14845754);
        this.bsi = (ChatImageWithTailView) findViewById(i.f.img_msgitem_image);
        this.bse = (Invite2GroupView) findViewById(i.f.lay_msgitem_invite_view);
        this.bsf = (ShareFromPBView) findViewById(i.f.lay_msgitem_share_view);
        this.bsg = (ShareFromFrsView) findViewById(i.f.lay_msgitem_share_frs);
        this.bsh = (ShareFromGameCenter) findViewById(i.f.lay_msgitem_share_game);
        this.bsc = (ChatVoiceView) findViewById(i.f.lay_msgitem_voice);
        this.bsc.setClickable(true);
        this.bsc.setOnClickListener(this.bsc);
        this.bsc.setLongClickable(true);
        this.bsc.setOnLongClickListener(new at(this));
        this.bsi.getImage().setClickable(true);
        this.bsi.getImage().setOnClickListener(new az(this));
        this.bsi.getImage().setLongClickable(true);
        this.bsi.getImage().setOnLongClickListener(new ba(this));
        this.bsi.getTail().setClickable(true);
        this.bsi.getTail().setOnClickListener(new bb(this));
        this.bsb.setLongClickable(true);
        this.bsb.setOnLongClickListener(new bc(this));
        this.bsd = (GifView) findViewById(i.f.emotion_msgitem_image);
        this.bsd.setOnClickListener(new bd(this));
        this.bsd.setLongClickable(true);
        this.bsd.setOnLongClickListener(new be(this));
        this.bsf.setClickable(true);
        this.bsf.setOnClickListener(new bf(this));
        this.bsf.setLongClickable(true);
        this.bsf.setOnLongClickListener(new bg(this));
        this.bsg.setClickable(true);
        this.bsg.setOnClickListener(new au(this));
        this.bsg.setLongClickable(true);
        this.bsg.setOnLongClickListener(new av(this));
        this.bsh.getContentBody().setClickable(true);
        this.bsh.getContentBody().setOnClickListener(new aw(this));
        this.bsh.getTail().setClickable(true);
        this.bsh.getTail().setOnClickListener(new ax(this));
        this.bsh.getContentBody().setLongClickable(true);
        this.bsh.getContentBody().setOnLongClickListener(new ay(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gJ(int i) {
        this.bsi.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean aD = aD(chatMessage.getTime());
        if (z || aD) {
            this.aPX.setVisibility(0);
            this.aPX.setText(aE(chatMessage.getTime()));
        } else {
            this.aPX.setVisibility(8);
        }
        if (!z && aD) {
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
        bq.a(this.mContext.getContext(), this.bsb, chatMessage, str, this.brM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.bsi, chatMessage, this.brZ, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.bsc, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bq.a(this.mContext.getContext(), this.bsd, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bq.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.bse, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.bsf, this.bsg, this.bsh, chatMessage, str);
    }

    public void cK(boolean z) {
        this.bsj = z;
    }

    public void cL(boolean z) {
        this.bsk = z;
    }

    public void gI(int i) {
        this.brM = i;
    }
}
