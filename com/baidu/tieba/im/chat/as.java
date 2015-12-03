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
import com.baidu.tieba.n;
import java.util.Calendar;
/* loaded from: classes.dex */
public class as extends com.baidu.adp.base.d<MsglistActivity<?>> {
    protected TextView aVi;
    protected int apI;
    private long bHH;
    private Calendar bHI;
    protected long bHJ;
    protected Long bHK;
    protected TbRichTextView bHL;
    protected ChatVoiceView bHM;
    protected GifView bHN;
    protected Invite2GroupView bHO;
    protected ShareFromPBView bHP;
    protected ShareFromFrsView bHQ;
    protected ShareFromGameCenter bHR;
    protected ChatImageWithTailView bHS;
    protected boolean bHT;
    protected boolean bHU;
    protected com.baidu.adp.lib.d.a bHn;
    protected com.baidu.adp.lib.d.b bHo;
    protected int bHw;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.bHn = null;
        this.bHo = null;
        this.apI = 0;
        this.bHJ = 0L;
        this.bHK = null;
        this.bHT = true;
        this.bHU = false;
        this.bHH = 0L;
        this.bHI = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.bHn = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.bHo = bVar;
    }

    public void setPosition(int i) {
        this.apI = i;
    }

    public void aN(long j) {
        this.bHH = j;
    }

    public void aO(long j) {
        this.bHI = Calendar.getInstance();
        this.bHI.setTimeInMillis(1000 * j);
    }

    private boolean aP(long j) {
        if (j < 1000) {
            return false;
        }
        return this.bHH == 0 || j - this.bHH >= 180;
    }

    private String aQ(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.bHI != null && this.bHI.get(1) == calendar.get(1) && this.bHI.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.ax.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.ax.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.bHK = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aVi = (TextView) findViewById(n.f.tex_msgitem_time);
        this.bHL = (TbRichTextView) findViewById(n.f.tex_msgitem_text);
        this.bHL.setLinkTextColor(-14845754);
        this.bHS = (ChatImageWithTailView) findViewById(n.f.img_msgitem_image);
        this.bHO = (Invite2GroupView) findViewById(n.f.lay_msgitem_invite_view);
        this.bHP = (ShareFromPBView) findViewById(n.f.lay_msgitem_share_view);
        this.bHQ = (ShareFromFrsView) findViewById(n.f.lay_msgitem_share_frs);
        this.bHR = (ShareFromGameCenter) findViewById(n.f.lay_msgitem_share_game);
        this.bHM = (ChatVoiceView) findViewById(n.f.lay_msgitem_voice);
        this.bHM.setClickable(true);
        this.bHM.setOnClickListener(this.bHM);
        this.bHM.setLongClickable(true);
        this.bHM.setOnLongClickListener(new at(this));
        this.bHS.getImage().setClickable(true);
        this.bHS.getImage().setOnClickListener(new az(this));
        this.bHS.getImage().setLongClickable(true);
        this.bHS.getImage().setOnLongClickListener(new ba(this));
        this.bHS.getTail().setClickable(true);
        this.bHS.getTail().setOnClickListener(new bb(this));
        this.bHL.setLongClickable(true);
        this.bHL.setOnLongClickListener(new bc(this));
        this.bHN = (GifView) findViewById(n.f.emotion_msgitem_image);
        this.bHN.setSupportNoImage(false);
        this.bHN.setOnClickListener(new bd(this));
        this.bHN.setLongClickable(true);
        this.bHN.setOnLongClickListener(new be(this));
        this.bHP.setClickable(true);
        this.bHP.setOnClickListener(new bf(this));
        this.bHP.setLongClickable(true);
        this.bHP.setOnLongClickListener(new bg(this));
        this.bHQ.setClickable(true);
        this.bHQ.setOnClickListener(new au(this));
        this.bHQ.setLongClickable(true);
        this.bHQ.setOnLongClickListener(new av(this));
        this.bHR.getContentBody().setClickable(true);
        this.bHR.getContentBody().setOnClickListener(new aw(this));
        this.bHR.getTail().setClickable(true);
        this.bHR.getTail().setOnClickListener(new ax(this));
        this.bHR.getContentBody().setLongClickable(true);
        this.bHR.getContentBody().setOnLongClickListener(new ay(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hI(int i) {
        this.bHS.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean aP = aP(chatMessage.getTime());
        if (z || aP) {
            this.aVi.setVisibility(0);
            this.aVi.setText(aQ(chatMessage.getTime()));
        } else {
            this.aVi.setVisibility(8);
        }
        if (!z && aP) {
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
        bq.a(this.mContext.getContext(), this.bHL, chatMessage, str, this.bHw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.bHS, chatMessage, this.bHJ, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.bHM, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bq.a(this.mContext.getContext(), this.bHN, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bq.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.bHO, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.bHP, this.bHQ, this.bHR, chatMessage, str);
    }

    public void dh(boolean z) {
        this.bHT = z;
    }

    public void di(boolean z) {
        this.bHU = z;
    }

    public void hH(int i) {
        this.bHw = i;
    }
}
