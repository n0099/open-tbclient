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
import com.baidu.tieba.u;
import java.util.Calendar;
/* loaded from: classes.dex */
public class as extends com.baidu.adp.base.d<MsglistActivity<?>> {
    protected int alw;
    protected TextView bAf;
    protected com.baidu.adp.lib.d.a cHE;
    protected com.baidu.adp.lib.d.b cHF;
    protected int cHN;
    private long cHY;
    private Calendar cHZ;
    protected long cIa;
    protected Long cIb;
    protected TbRichTextView cIc;
    protected ChatVoiceView cId;
    protected GifView cIe;
    protected Invite2GroupView cIf;
    protected ShareFromPBView cIg;
    protected ShareFromFrsView cIh;
    protected ShareFromGameCenter cIi;
    protected ChatImageWithTailView cIj;
    protected boolean cIk;
    protected boolean cIl;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.cHE = null;
        this.cHF = null;
        this.alw = 0;
        this.cIa = 0L;
        this.cIb = null;
        this.cIk = true;
        this.cIl = false;
        this.cHY = 0L;
        this.cHZ = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.cHE = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.cHF = bVar;
    }

    public void setPosition(int i) {
        this.alw = i;
    }

    public void bs(long j) {
        this.cHY = j;
    }

    public void bt(long j) {
        this.cHZ = Calendar.getInstance();
        this.cHZ.setTimeInMillis(1000 * j);
    }

    private boolean bu(long j) {
        if (j < 1000) {
            return false;
        }
        return this.cHY == 0 || j - this.cHY >= 180;
    }

    private String bv(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.cHZ != null && this.cHZ.get(1) == calendar.get(1) && this.cHZ.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.ba.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.ba.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.cIb = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bAf = (TextView) findViewById(u.g.tex_msgitem_time);
        this.cIc = (TbRichTextView) findViewById(u.g.tex_msgitem_text);
        this.cIc.setLinkTextColor(-14845754);
        this.cIj = (ChatImageWithTailView) findViewById(u.g.img_msgitem_image);
        this.cIf = (Invite2GroupView) findViewById(u.g.lay_msgitem_invite_view);
        this.cIg = (ShareFromPBView) findViewById(u.g.lay_msgitem_share_view);
        this.cIh = (ShareFromFrsView) findViewById(u.g.lay_msgitem_share_frs);
        this.cIi = (ShareFromGameCenter) findViewById(u.g.lay_msgitem_share_game);
        this.cId = (ChatVoiceView) findViewById(u.g.lay_msgitem_voice);
        this.cId.setClickable(true);
        this.cId.setOnClickListener(this.cId);
        this.cId.setLongClickable(true);
        this.cId.setOnLongClickListener(new at(this));
        this.cIj.getImage().setClickable(true);
        this.cIj.getImage().setOnClickListener(new ba(this));
        this.cIj.getImage().setLongClickable(true);
        this.cIj.getImage().setOnLongClickListener(new bb(this));
        this.cIj.getTail().setClickable(true);
        this.cIj.getTail().setOnClickListener(new bc(this));
        this.cIc.setLongClickable(true);
        this.cIc.setOnLongClickListener(new bd(this));
        this.cIe = (GifView) findViewById(u.g.emotion_msgitem_image);
        this.cIe.setSupportNoImage(false);
        this.cIe.setOnClickListener(new be(this));
        this.cIe.setLongClickable(true);
        this.cIe.setOnLongClickListener(new bf(this));
        this.cIg.setClickable(true);
        this.cIg.setOnClickListener(new bg(this));
        this.cIg.setLongClickable(true);
        this.cIg.setOnLongClickListener(new bh(this));
        this.cIh.setClickable(true);
        this.cIh.setOnClickListener(new au(this));
        this.cIh.setLongClickable(true);
        this.cIh.setOnLongClickListener(new av(this));
        this.cIi.getContentBody().setClickable(true);
        this.cIi.getContentBody().setOnClickListener(new aw(this));
        this.cIi.getTail().setClickable(true);
        this.cIi.getTail().setOnClickListener(new ax(this));
        this.cIi.getContentBody().setLongClickable(true);
        this.cIi.getContentBody().setOnLongClickListener(new ay(this));
        if (this.cIf != null) {
            this.cIf.setOnLongClickListener(new az(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kx(int i) {
        this.cIj.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bu = bu(chatMessage.getTime());
        if (z || bu) {
            this.bAf.setVisibility(0);
            this.bAf.setText(bv(chatMessage.getTime()));
        } else {
            this.bAf.setVisibility(8);
        }
        if (!z && bu) {
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
        br.a(this.mContext.getContext(), this.cIc, chatMessage, str, this.cHN);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.cIc.setContentDescription(stringBuffer.toString());
            this.cIc.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), view, this.cIj, chatMessage, this.cIa, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), this.cId, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        br.a(this.mContext.getContext(), this.cIe, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        br.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.cIf, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), view, this.cIg, this.cIh, this.cIi, chatMessage, str);
    }

    public void eT(boolean z) {
        this.cIk = z;
    }

    public void eU(boolean z) {
        this.cIl = z;
    }

    public void kw(int i) {
        this.cHN = i;
    }
}
