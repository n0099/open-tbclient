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
    protected TextView aQf;
    protected int anQ;
    private long bsB;
    private Calendar bsC;
    protected long bsD;
    protected Long bsE;
    protected TbRichTextView bsF;
    protected ChatVoiceView bsG;
    protected GifView bsH;
    protected Invite2GroupView bsI;
    protected ShareFromPBView bsJ;
    protected ShareFromFrsView bsK;
    protected ShareFromGameCenter bsL;
    protected ChatImageWithTailView bsM;
    protected boolean bsN;
    protected boolean bsO;
    protected com.baidu.adp.lib.c.a bsh;
    protected com.baidu.adp.lib.c.b bsi;
    protected int bsq;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.bsh = null;
        this.bsi = null;
        this.anQ = 0;
        this.bsD = 0L;
        this.bsE = null;
        this.bsN = true;
        this.bsO = false;
        this.bsB = 0L;
        this.bsC = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.bsh = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.bsi = bVar;
    }

    public void setPosition(int i) {
        this.anQ = i;
    }

    public void az(long j) {
        this.bsB = j;
    }

    public void aA(long j) {
        this.bsC = Calendar.getInstance();
        this.bsC.setTimeInMillis(1000 * j);
    }

    private boolean aB(long j) {
        if (j < 1000) {
            return false;
        }
        return this.bsB == 0 || j - this.bsB >= 180;
    }

    private String aC(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.bsC != null && this.bsC.get(1) == calendar.get(1) && this.bsC.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.as.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.as.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.bsE = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aQf = (TextView) findViewById(i.f.tex_msgitem_time);
        this.bsF = (TbRichTextView) findViewById(i.f.tex_msgitem_text);
        this.bsF.setLinkTextColor(-14845754);
        this.bsM = (ChatImageWithTailView) findViewById(i.f.img_msgitem_image);
        this.bsI = (Invite2GroupView) findViewById(i.f.lay_msgitem_invite_view);
        this.bsJ = (ShareFromPBView) findViewById(i.f.lay_msgitem_share_view);
        this.bsK = (ShareFromFrsView) findViewById(i.f.lay_msgitem_share_frs);
        this.bsL = (ShareFromGameCenter) findViewById(i.f.lay_msgitem_share_game);
        this.bsG = (ChatVoiceView) findViewById(i.f.lay_msgitem_voice);
        this.bsG.setClickable(true);
        this.bsG.setOnClickListener(this.bsG);
        this.bsG.setLongClickable(true);
        this.bsG.setOnLongClickListener(new at(this));
        this.bsM.getImage().setClickable(true);
        this.bsM.getImage().setOnClickListener(new az(this));
        this.bsM.getImage().setLongClickable(true);
        this.bsM.getImage().setOnLongClickListener(new ba(this));
        this.bsM.getTail().setClickable(true);
        this.bsM.getTail().setOnClickListener(new bb(this));
        this.bsF.setLongClickable(true);
        this.bsF.setOnLongClickListener(new bc(this));
        this.bsH = (GifView) findViewById(i.f.emotion_msgitem_image);
        this.bsH.setOnClickListener(new bd(this));
        this.bsH.setLongClickable(true);
        this.bsH.setOnLongClickListener(new be(this));
        this.bsJ.setClickable(true);
        this.bsJ.setOnClickListener(new bf(this));
        this.bsJ.setLongClickable(true);
        this.bsJ.setOnLongClickListener(new bg(this));
        this.bsK.setClickable(true);
        this.bsK.setOnClickListener(new au(this));
        this.bsK.setLongClickable(true);
        this.bsK.setOnLongClickListener(new av(this));
        this.bsL.getContentBody().setClickable(true);
        this.bsL.getContentBody().setOnClickListener(new aw(this));
        this.bsL.getTail().setClickable(true);
        this.bsL.getTail().setOnClickListener(new ax(this));
        this.bsL.getContentBody().setLongClickable(true);
        this.bsL.getContentBody().setOnLongClickListener(new ay(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gW(int i) {
        this.bsM.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean aB = aB(chatMessage.getTime());
        if (z || aB) {
            this.aQf.setVisibility(0);
            this.aQf.setText(aC(chatMessage.getTime()));
        } else {
            this.aQf.setVisibility(8);
        }
        if (!z && aB) {
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
        bq.a(this.mContext.getContext(), this.bsF, chatMessage, str, this.bsq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.bsM, chatMessage, this.bsD, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.bsG, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bq.a(this.mContext.getContext(), this.bsH, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bq.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.bsI, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.bsJ, this.bsK, this.bsL, chatMessage, str);
    }

    public void cM(boolean z) {
        this.bsN = z;
    }

    public void cN(boolean z) {
        this.bsO = z;
    }

    public void gV(int i) {
        this.bsq = i;
    }
}
