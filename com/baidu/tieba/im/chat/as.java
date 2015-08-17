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
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class as extends com.baidu.adp.base.d<MsglistActivity<?>> {
    protected TextView aQC;
    protected int anz;
    protected com.baidu.adp.lib.c.a bnV;
    protected com.baidu.adp.lib.c.b bnW;
    protected boolean boA;
    protected boolean boB;
    protected int boe;
    private long bop;
    private Calendar boq;
    protected long bor;
    protected Long bos;
    protected TbRichTextView bot;
    protected ChatVoiceView bou;
    protected GifView bov;
    protected Invite2GroupView bow;
    protected ShareFromPBView box;
    protected ShareFromGameCenter boy;
    protected ChatImageWithTailView boz;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.bnV = null;
        this.bnW = null;
        this.anz = 0;
        this.bor = 0L;
        this.bos = null;
        this.boA = true;
        this.boB = false;
        this.bop = 0L;
        this.boq = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.bnV = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.bnW = bVar;
    }

    public void setPosition(int i) {
        this.anz = i;
    }

    public void ae(long j) {
        this.bop = j;
    }

    public void af(long j) {
        this.boq = Calendar.getInstance();
        this.boq.setTimeInMillis(1000 * j);
    }

    private boolean ag(long j) {
        if (j < 1000) {
            return false;
        }
        return this.bop == 0 || j - this.bop >= 180;
    }

    private String ah(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.boq != null && this.boq.get(1) == calendar.get(1) && this.boq.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.aq.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.aq.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.bos = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aQC = (TextView) findViewById(i.f.tex_msgitem_time);
        this.bot = (TbRichTextView) findViewById(i.f.tex_msgitem_text);
        this.bot.setLinkTextColor(-14845754);
        this.boz = (ChatImageWithTailView) findViewById(i.f.img_msgitem_image);
        this.bow = (Invite2GroupView) findViewById(i.f.lay_msgitem_invite_view);
        this.box = (ShareFromPBView) findViewById(i.f.lay_msgitem_share_view);
        this.boy = (ShareFromGameCenter) findViewById(i.f.lay_msgitem_share_game);
        this.bou = (ChatVoiceView) findViewById(i.f.lay_msgitem_voice);
        this.bou.setClickable(true);
        this.bou.setOnClickListener(this.bou);
        this.bou.setLongClickable(true);
        this.bou.setOnLongClickListener(new at(this));
        this.boz.getImage().setClickable(true);
        this.boz.getImage().setOnClickListener(new ax(this));
        this.boz.getImage().setLongClickable(true);
        this.boz.getImage().setOnLongClickListener(new ay(this));
        this.boz.getTail().setClickable(true);
        this.boz.getTail().setOnClickListener(new az(this));
        this.bot.setLongClickable(true);
        this.bot.setOnLongClickListener(new ba(this));
        this.bov = (GifView) findViewById(i.f.emotion_msgitem_image);
        this.bov.setOnClickListener(new bb(this));
        this.bov.setLongClickable(true);
        this.bov.setOnLongClickListener(new bc(this));
        this.box.setClickable(true);
        this.box.setOnClickListener(new bd(this));
        this.box.setLongClickable(true);
        this.box.setOnLongClickListener(new be(this));
        this.boy.getContentBody().setClickable(true);
        this.boy.getContentBody().setOnClickListener(new au(this));
        this.boy.getTail().setClickable(true);
        this.boy.getTail().setOnClickListener(new av(this));
        this.boy.getContentBody().setLongClickable(true);
        this.boy.getContentBody().setOnLongClickListener(new aw(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gt(int i) {
        this.boz.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean ag = ag(chatMessage.getTime());
        if (z || ag) {
            this.aQC.setVisibility(0);
            this.aQC.setText(ah(chatMessage.getTime()));
        } else {
            this.aQC.setVisibility(8);
        }
        if (!z && ag) {
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
        bo.a(this.mContext.getContext(), this.bot, chatMessage, str, this.boe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bo.a(this.mContext.getContext(), view, this.boz, chatMessage, this.bor, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bo.a(this.mContext.getContext(), this.bou, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bo.a(this.mContext.getContext(), this.bov, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bo.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.bow, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bo.a(this.mContext.getContext(), view, this.box, this.boy, chatMessage, str);
    }

    public void cF(boolean z) {
        this.boA = z;
    }

    public void cG(boolean z) {
        this.boB = z;
    }

    public void gs(int i) {
        this.boe = i;
    }
}
