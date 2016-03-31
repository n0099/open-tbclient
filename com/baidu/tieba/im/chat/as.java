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
import com.baidu.tieba.t;
import java.util.Calendar;
/* loaded from: classes.dex */
public class as extends com.baidu.adp.base.d<MsglistActivity<?>> {
    protected int aom;
    protected GifView bZA;
    protected Invite2GroupView bZB;
    protected ShareFromPBView bZC;
    protected ShareFromFrsView bZD;
    protected ShareFromGameCenter bZE;
    protected ChatImageWithTailView bZF;
    protected boolean bZG;
    protected boolean bZH;
    protected com.baidu.adp.lib.d.a bZa;
    protected com.baidu.adp.lib.d.b bZb;
    protected int bZj;
    private long bZu;
    private Calendar bZv;
    protected long bZw;
    protected Long bZx;
    protected TbRichTextView bZy;
    protected ChatVoiceView bZz;
    protected TextView bgh;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.bZa = null;
        this.bZb = null;
        this.aom = 0;
        this.bZw = 0L;
        this.bZx = null;
        this.bZG = true;
        this.bZH = false;
        this.bZu = 0L;
        this.bZv = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.bZa = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.bZb = bVar;
    }

    public void setPosition(int i) {
        this.aom = i;
    }

    public void aV(long j) {
        this.bZu = j;
    }

    public void aW(long j) {
        this.bZv = Calendar.getInstance();
        this.bZv.setTimeInMillis(1000 * j);
    }

    private boolean aX(long j) {
        if (j < 1000) {
            return false;
        }
        return this.bZu == 0 || j - this.bZu >= 180;
    }

    private String aY(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.bZv != null && this.bZv.get(1) == calendar.get(1) && this.bZv.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.ay.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.ay.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.bZx = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bgh = (TextView) findViewById(t.g.tex_msgitem_time);
        this.bZy = (TbRichTextView) findViewById(t.g.tex_msgitem_text);
        this.bZy.setLinkTextColor(-14845754);
        this.bZF = (ChatImageWithTailView) findViewById(t.g.img_msgitem_image);
        this.bZB = (Invite2GroupView) findViewById(t.g.lay_msgitem_invite_view);
        this.bZC = (ShareFromPBView) findViewById(t.g.lay_msgitem_share_view);
        this.bZD = (ShareFromFrsView) findViewById(t.g.lay_msgitem_share_frs);
        this.bZE = (ShareFromGameCenter) findViewById(t.g.lay_msgitem_share_game);
        this.bZz = (ChatVoiceView) findViewById(t.g.lay_msgitem_voice);
        this.bZz.setClickable(true);
        this.bZz.setOnClickListener(this.bZz);
        this.bZz.setLongClickable(true);
        this.bZz.setOnLongClickListener(new at(this));
        this.bZF.getImage().setClickable(true);
        this.bZF.getImage().setOnClickListener(new az(this));
        this.bZF.getImage().setLongClickable(true);
        this.bZF.getImage().setOnLongClickListener(new ba(this));
        this.bZF.getTail().setClickable(true);
        this.bZF.getTail().setOnClickListener(new bb(this));
        this.bZy.setLongClickable(true);
        this.bZy.setOnLongClickListener(new bc(this));
        this.bZA = (GifView) findViewById(t.g.emotion_msgitem_image);
        this.bZA.setSupportNoImage(false);
        this.bZA.setOnClickListener(new bd(this));
        this.bZA.setLongClickable(true);
        this.bZA.setOnLongClickListener(new be(this));
        this.bZC.setClickable(true);
        this.bZC.setOnClickListener(new bf(this));
        this.bZC.setLongClickable(true);
        this.bZC.setOnLongClickListener(new bg(this));
        this.bZD.setClickable(true);
        this.bZD.setOnClickListener(new au(this));
        this.bZD.setLongClickable(true);
        this.bZD.setOnLongClickListener(new av(this));
        this.bZE.getContentBody().setClickable(true);
        this.bZE.getContentBody().setOnClickListener(new aw(this));
        this.bZE.getTail().setClickable(true);
        this.bZE.getTail().setOnClickListener(new ax(this));
        this.bZE.getContentBody().setLongClickable(true);
        this.bZE.getContentBody().setOnLongClickListener(new ay(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jm(int i) {
        this.bZF.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean aX = aX(chatMessage.getTime());
        if (z || aX) {
            this.bgh.setVisibility(0);
            this.bgh.setText(aY(chatMessage.getTime()));
        } else {
            this.bgh.setVisibility(8);
        }
        if (!z && aX) {
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
        bq.a(this.mContext.getContext(), this.bZy, chatMessage, str, this.bZj);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.bZy.setContentDescription(stringBuffer.toString());
            this.bZy.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.bZF, chatMessage, this.bZw, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.bZz, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bq.a(this.mContext.getContext(), this.bZA, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bq.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.bZB, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.bZC, this.bZD, this.bZE, chatMessage, str);
    }

    public void dD(boolean z) {
        this.bZG = z;
    }

    public void dE(boolean z) {
        this.bZH = z;
    }

    public void jl(int i) {
        this.bZj = i;
    }
}
