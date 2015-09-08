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
    protected TextView aQQ;
    protected int apk;
    protected int boC;
    private long boN;
    private Calendar boO;
    protected long boP;
    protected Long boQ;
    protected TbRichTextView boR;
    protected ChatVoiceView boS;
    protected GifView boT;
    protected Invite2GroupView boU;
    protected ShareFromPBView boV;
    protected ShareFromGameCenter boW;
    protected ChatImageWithTailView boX;
    protected boolean boY;
    protected boolean boZ;
    protected com.baidu.adp.lib.c.a bot;
    protected com.baidu.adp.lib.c.b bou;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.bot = null;
        this.bou = null;
        this.apk = 0;
        this.boP = 0L;
        this.boQ = null;
        this.boY = true;
        this.boZ = false;
        this.boN = 0L;
        this.boO = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.bot = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.bou = bVar;
    }

    public void setPosition(int i) {
        this.apk = i;
    }

    public void af(long j) {
        this.boN = j;
    }

    public void ag(long j) {
        this.boO = Calendar.getInstance();
        this.boO.setTimeInMillis(1000 * j);
    }

    private boolean ah(long j) {
        if (j < 1000) {
            return false;
        }
        return this.boN == 0 || j - this.boN >= 180;
    }

    private String ai(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.boO != null && this.boO.get(1) == calendar.get(1) && this.boO.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.aq.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.aq.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.boQ = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aQQ = (TextView) findViewById(i.f.tex_msgitem_time);
        this.boR = (TbRichTextView) findViewById(i.f.tex_msgitem_text);
        this.boR.setLinkTextColor(-14845754);
        this.boX = (ChatImageWithTailView) findViewById(i.f.img_msgitem_image);
        this.boU = (Invite2GroupView) findViewById(i.f.lay_msgitem_invite_view);
        this.boV = (ShareFromPBView) findViewById(i.f.lay_msgitem_share_view);
        this.boW = (ShareFromGameCenter) findViewById(i.f.lay_msgitem_share_game);
        this.boS = (ChatVoiceView) findViewById(i.f.lay_msgitem_voice);
        this.boS.setClickable(true);
        this.boS.setOnClickListener(this.boS);
        this.boS.setLongClickable(true);
        this.boS.setOnLongClickListener(new at(this));
        this.boX.getImage().setClickable(true);
        this.boX.getImage().setOnClickListener(new ax(this));
        this.boX.getImage().setLongClickable(true);
        this.boX.getImage().setOnLongClickListener(new ay(this));
        this.boX.getTail().setClickable(true);
        this.boX.getTail().setOnClickListener(new az(this));
        this.boR.setLongClickable(true);
        this.boR.setOnLongClickListener(new ba(this));
        this.boT = (GifView) findViewById(i.f.emotion_msgitem_image);
        this.boT.setOnClickListener(new bb(this));
        this.boT.setLongClickable(true);
        this.boT.setOnLongClickListener(new bc(this));
        this.boV.setClickable(true);
        this.boV.setOnClickListener(new bd(this));
        this.boV.setLongClickable(true);
        this.boV.setOnLongClickListener(new be(this));
        this.boW.getContentBody().setClickable(true);
        this.boW.getContentBody().setOnClickListener(new au(this));
        this.boW.getTail().setClickable(true);
        this.boW.getTail().setOnClickListener(new av(this));
        this.boW.getContentBody().setLongClickable(true);
        this.boW.getContentBody().setOnLongClickListener(new aw(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gD(int i) {
        this.boX.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean ah = ah(chatMessage.getTime());
        if (z || ah) {
            this.aQQ.setVisibility(0);
            this.aQQ.setText(ai(chatMessage.getTime()));
        } else {
            this.aQQ.setVisibility(8);
        }
        if (!z && ah) {
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
        bo.a(this.mContext.getContext(), this.boR, chatMessage, str, this.boC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bo.a(this.mContext.getContext(), view, this.boX, chatMessage, this.boP, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bo.a(this.mContext.getContext(), this.boS, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bo.a(this.mContext.getContext(), this.boT, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bo.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.boU, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bo.a(this.mContext.getContext(), view, this.boV, this.boW, chatMessage, str);
    }

    public void cK(boolean z) {
        this.boY = z;
    }

    public void cL(boolean z) {
        this.boZ = z;
    }

    public void gC(int i) {
        this.boC = i;
    }
}
