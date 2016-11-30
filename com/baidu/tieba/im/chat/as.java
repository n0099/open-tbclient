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
    protected int ape;
    protected TextView bOB;
    private long bjX;
    private Calendar daJ;
    protected long daK;
    protected Long daL;
    protected TbRichTextView daM;
    protected ChatVoiceView daN;
    protected GifView daO;
    protected Invite2GroupView daP;
    protected ShareFromPBView daQ;
    protected ShareFromFrsView daR;
    protected ShareFromGameCenter daS;
    protected ChatImageWithTailView daT;
    protected boolean daU;
    protected boolean daV;
    protected com.baidu.adp.lib.d.a dam;
    protected com.baidu.adp.lib.d.b dan;
    protected int dax;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.dam = null;
        this.dan = null;
        this.ape = 0;
        this.daK = 0L;
        this.daL = null;
        this.daU = true;
        this.daV = false;
        this.bjX = 0L;
        this.daJ = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.dam = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.dan = bVar;
    }

    public void setPosition(int i) {
        this.ape = i;
    }

    public void bN(long j) {
        this.bjX = j;
    }

    public void bO(long j) {
        this.daJ = Calendar.getInstance();
        this.daJ.setTimeInMillis(1000 * j);
    }

    private boolean bP(long j) {
        if (j < 1000) {
            return false;
        }
        return this.bjX == 0 || j - this.bjX >= 180;
    }

    private String bQ(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.daJ != null && this.daJ.get(1) == calendar.get(1) && this.daJ.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.ax.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.ax.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.daL = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bOB = (TextView) findViewById(r.g.tex_msgitem_time);
        this.daM = (TbRichTextView) findViewById(r.g.tex_msgitem_text);
        this.daM.setLinkTextColor(-14845754);
        this.daT = (ChatImageWithTailView) findViewById(r.g.img_msgitem_image);
        this.daP = (Invite2GroupView) findViewById(r.g.lay_msgitem_invite_view);
        this.daQ = (ShareFromPBView) findViewById(r.g.lay_msgitem_share_view);
        this.daR = (ShareFromFrsView) findViewById(r.g.lay_msgitem_share_frs);
        this.daS = (ShareFromGameCenter) findViewById(r.g.lay_msgitem_share_game);
        this.daN = (ChatVoiceView) findViewById(r.g.lay_msgitem_voice);
        this.daN.setClickable(true);
        this.daN.setOnClickListener(this.daN);
        this.daN.setLongClickable(true);
        this.daN.setOnLongClickListener(new at(this));
        this.daT.getImage().setClickable(true);
        this.daT.getImage().setOnClickListener(new ba(this));
        this.daT.getImage().setLongClickable(true);
        this.daT.getImage().setOnLongClickListener(new bb(this));
        this.daT.getTail().setClickable(true);
        this.daT.getTail().setOnClickListener(new bc(this));
        this.daM.setLongClickable(true);
        this.daM.setOnLongClickListener(new bd(this));
        this.daO = (GifView) findViewById(r.g.emotion_msgitem_image);
        this.daO.setSupportNoImage(false);
        this.daO.setOnClickListener(new be(this));
        this.daO.setLongClickable(true);
        this.daO.setOnLongClickListener(new bf(this));
        this.daQ.setClickable(true);
        this.daQ.setOnClickListener(new bg(this));
        this.daQ.setLongClickable(true);
        this.daQ.setOnLongClickListener(new bh(this));
        this.daR.setClickable(true);
        this.daR.setOnClickListener(new au(this));
        this.daR.setLongClickable(true);
        this.daR.setOnLongClickListener(new av(this));
        this.daS.getContentBody().setClickable(true);
        this.daS.getContentBody().setOnClickListener(new aw(this));
        this.daS.getTail().setClickable(true);
        this.daS.getTail().setOnClickListener(new ax(this));
        this.daS.getContentBody().setLongClickable(true);
        this.daS.getContentBody().setOnLongClickListener(new ay(this));
        if (this.daP != null) {
            this.daP.setOnLongClickListener(new az(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lq(int i) {
        this.daT.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bP = bP(chatMessage.getTime());
        if (z || bP) {
            this.bOB.setVisibility(0);
            this.bOB.setText(bQ(chatMessage.getTime()));
        } else {
            this.bOB.setVisibility(8);
        }
        if (!z && bP) {
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
        br.a(this.mContext.getContext(), this.daM, chatMessage, str, this.dax);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.daM.setContentDescription(stringBuffer.toString());
            this.daM.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), view, this.daT, chatMessage, this.daK, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), this.daN, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        br.a(this.mContext.getContext(), this.daO, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        br.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.daP, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), view, this.daQ, this.daR, this.daS, chatMessage, str);
    }

    public void fM(boolean z) {
        this.daU = z;
    }

    public void fN(boolean z) {
        this.daV = z;
    }

    public void lp(int i) {
        this.dax = i;
    }
}
