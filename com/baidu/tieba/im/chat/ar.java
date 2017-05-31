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
import com.baidu.tieba.w;
import java.util.Calendar;
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.base.d<MsglistActivity<?>> {
    protected int atn;
    protected TextView bQv;
    private Calendar cPF;
    protected long cPG;
    protected Long cPH;
    protected TbRichTextView cPI;
    protected ChatVoiceView cPJ;
    protected GifView cPK;
    protected Invite2GroupView cPL;
    protected ShareFromPBView cPM;
    protected ShareFromFrsView cPN;
    protected ShareFromGameCenter cPO;
    protected ChatImageWithTailView cPP;
    protected boolean cPQ;
    protected boolean cPR;
    protected com.baidu.adp.lib.c.a cPk;
    protected com.baidu.adp.lib.c.b cPl;
    protected int cPu;
    private long mLastTime;

    public ar(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.cPk = null;
        this.cPl = null;
        this.atn = 0;
        this.cPG = 0L;
        this.cPH = null;
        this.cPQ = true;
        this.cPR = false;
        this.mLastTime = 0L;
        this.cPF = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.cPk = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.cPl = bVar;
    }

    public void setPosition(int i) {
        this.atn = i;
    }

    public void bl(long j) {
        this.mLastTime = j;
    }

    public void bm(long j) {
        this.cPF = Calendar.getInstance();
        this.cPF.setTimeInMillis(1000 * j);
    }

    private boolean bn(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String bo(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.cPF != null && this.cPF.get(1) == calendar.get(1) && this.cPF.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.au.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.au.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.cPH = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bQv = (TextView) findViewById(w.h.tex_msgitem_time);
        this.cPI = (TbRichTextView) findViewById(w.h.tex_msgitem_text);
        this.cPI.setLinkTextColor(-14845754);
        this.cPP = (ChatImageWithTailView) findViewById(w.h.img_msgitem_image);
        this.cPL = (Invite2GroupView) findViewById(w.h.lay_msgitem_invite_view);
        this.cPM = (ShareFromPBView) findViewById(w.h.lay_msgitem_share_view);
        this.cPN = (ShareFromFrsView) findViewById(w.h.lay_msgitem_share_frs);
        this.cPO = (ShareFromGameCenter) findViewById(w.h.lay_msgitem_share_game);
        this.cPJ = (ChatVoiceView) findViewById(w.h.lay_msgitem_voice);
        this.cPJ.setClickable(true);
        this.cPJ.setOnClickListener(this.cPJ);
        this.cPJ.setLongClickable(true);
        this.cPJ.setOnLongClickListener(new as(this));
        this.cPP.getImage().setClickable(true);
        this.cPP.getImage().setOnClickListener(new az(this));
        this.cPP.getImage().setLongClickable(true);
        this.cPP.getImage().setOnLongClickListener(new ba(this));
        this.cPP.getTail().setClickable(true);
        this.cPP.getTail().setOnClickListener(new bb(this));
        this.cPI.setLongClickable(true);
        this.cPI.setOnLongClickListener(new bc(this));
        this.cPK = (GifView) findViewById(w.h.emotion_msgitem_image);
        this.cPK.setSupportNoImage(false);
        this.cPK.setOnClickListener(new bd(this));
        this.cPK.setLongClickable(true);
        this.cPK.setOnLongClickListener(new be(this));
        this.cPM.setClickable(true);
        this.cPM.setOnClickListener(new bf(this));
        this.cPM.setLongClickable(true);
        this.cPM.setOnLongClickListener(new bg(this));
        this.cPN.setClickable(true);
        this.cPN.setOnClickListener(new at(this));
        this.cPN.setLongClickable(true);
        this.cPN.setOnLongClickListener(new au(this));
        this.cPO.getContentBody().setClickable(true);
        this.cPO.getContentBody().setOnClickListener(new av(this));
        this.cPO.getTail().setClickable(true);
        this.cPO.getTail().setOnClickListener(new aw(this));
        this.cPO.getContentBody().setLongClickable(true);
        this.cPO.getContentBody().setOnLongClickListener(new ax(this));
        if (this.cPL != null) {
            this.cPL.setOnLongClickListener(new ay(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lr(int i) {
        this.cPP.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bn = bn(chatMessage.getTime());
        if (z || bn) {
            this.bQv.setVisibility(0);
            this.bQv.setText(bo(chatMessage.getTime()));
        } else {
            this.bQv.setVisibility(8);
        }
        if (!z && bn) {
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
        bq.a(this.mContext.getContext(), this.cPI, chatMessage, str, this.cPu);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.cPI.setContentDescription(stringBuffer.toString());
            this.cPI.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cPP, chatMessage, this.cPG, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.cPJ, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bq.a(this.mContext.getContext(), this.cPK, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bq.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.cPL, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cPM, this.cPN, this.cPO, chatMessage, str);
    }

    public void fp(boolean z) {
        this.cPQ = z;
    }

    public void fq(boolean z) {
        this.cPR = z;
    }

    public void lq(int i) {
        this.cPu = i;
    }
}
