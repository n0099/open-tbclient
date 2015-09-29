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
    protected TextView aPM;
    protected int anK;
    protected int brB;
    private long brM;
    private Calendar brN;
    protected long brO;
    protected Long brP;
    protected TbRichTextView brQ;
    protected ChatVoiceView brR;
    protected GifView brS;
    protected Invite2GroupView brT;
    protected ShareFromPBView brU;
    protected ShareFromFrsView brV;
    protected ShareFromGameCenter brW;
    protected ChatImageWithTailView brX;
    protected boolean brY;
    protected boolean brZ;
    protected com.baidu.adp.lib.c.a brs;
    protected com.baidu.adp.lib.c.b brt;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.brs = null;
        this.brt = null;
        this.anK = 0;
        this.brO = 0L;
        this.brP = null;
        this.brY = true;
        this.brZ = false;
        this.brM = 0L;
        this.brN = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.brs = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.brt = bVar;
    }

    public void setPosition(int i) {
        this.anK = i;
    }

    public void ar(long j) {
        this.brM = j;
    }

    public void as(long j) {
        this.brN = Calendar.getInstance();
        this.brN.setTimeInMillis(1000 * j);
    }

    private boolean at(long j) {
        if (j < 1000) {
            return false;
        }
        return this.brM == 0 || j - this.brM >= 180;
    }

    private String au(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.brN != null && this.brN.get(1) == calendar.get(1) && this.brN.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.ar.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.ar.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.brP = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aPM = (TextView) findViewById(i.f.tex_msgitem_time);
        this.brQ = (TbRichTextView) findViewById(i.f.tex_msgitem_text);
        this.brQ.setLinkTextColor(-14845754);
        this.brX = (ChatImageWithTailView) findViewById(i.f.img_msgitem_image);
        this.brT = (Invite2GroupView) findViewById(i.f.lay_msgitem_invite_view);
        this.brU = (ShareFromPBView) findViewById(i.f.lay_msgitem_share_view);
        this.brV = (ShareFromFrsView) findViewById(i.f.lay_msgitem_share_frs);
        this.brW = (ShareFromGameCenter) findViewById(i.f.lay_msgitem_share_game);
        this.brR = (ChatVoiceView) findViewById(i.f.lay_msgitem_voice);
        this.brR.setClickable(true);
        this.brR.setOnClickListener(this.brR);
        this.brR.setLongClickable(true);
        this.brR.setOnLongClickListener(new at(this));
        this.brX.getImage().setClickable(true);
        this.brX.getImage().setOnClickListener(new az(this));
        this.brX.getImage().setLongClickable(true);
        this.brX.getImage().setOnLongClickListener(new ba(this));
        this.brX.getTail().setClickable(true);
        this.brX.getTail().setOnClickListener(new bb(this));
        this.brQ.setLongClickable(true);
        this.brQ.setOnLongClickListener(new bc(this));
        this.brS = (GifView) findViewById(i.f.emotion_msgitem_image);
        this.brS.setOnClickListener(new bd(this));
        this.brS.setLongClickable(true);
        this.brS.setOnLongClickListener(new be(this));
        this.brU.setClickable(true);
        this.brU.setOnClickListener(new bf(this));
        this.brU.setLongClickable(true);
        this.brU.setOnLongClickListener(new bg(this));
        this.brV.setClickable(true);
        this.brV.setOnClickListener(new au(this));
        this.brV.setLongClickable(true);
        this.brV.setOnLongClickListener(new av(this));
        this.brW.getContentBody().setClickable(true);
        this.brW.getContentBody().setOnClickListener(new aw(this));
        this.brW.getTail().setClickable(true);
        this.brW.getTail().setOnClickListener(new ax(this));
        this.brW.getContentBody().setLongClickable(true);
        this.brW.getContentBody().setOnLongClickListener(new ay(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gJ(int i) {
        this.brX.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean at = at(chatMessage.getTime());
        if (z || at) {
            this.aPM.setVisibility(0);
            this.aPM.setText(au(chatMessage.getTime()));
        } else {
            this.aPM.setVisibility(8);
        }
        if (!z && at) {
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
        bq.a(this.mContext.getContext(), this.brQ, chatMessage, str, this.brB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.brX, chatMessage, this.brO, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.brR, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bq.a(this.mContext.getContext(), this.brS, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bq.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.brT, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.brU, this.brV, this.brW, chatMessage, str);
    }

    public void cK(boolean z) {
        this.brY = z;
    }

    public void cL(boolean z) {
        this.brZ = z;
    }

    public void gI(int i) {
        this.brB = i;
    }
}
