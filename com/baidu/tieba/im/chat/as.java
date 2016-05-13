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
    protected int aka;
    protected com.baidu.adp.lib.d.a bZF;
    protected com.baidu.adp.lib.d.b bZG;
    protected int bZO;
    private long bZZ;
    protected TextView bbW;
    private Calendar caa;
    protected long cab;
    protected Long cac;
    protected TbRichTextView cad;
    protected ChatVoiceView cae;
    protected GifView caf;
    protected Invite2GroupView cag;
    protected ShareFromPBView cah;
    protected ShareFromFrsView cai;
    protected ShareFromGameCenter caj;
    protected ChatImageWithTailView cak;
    protected boolean cal;
    protected boolean cam;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.bZF = null;
        this.bZG = null;
        this.aka = 0;
        this.cab = 0L;
        this.cac = null;
        this.cal = true;
        this.cam = false;
        this.bZZ = 0L;
        this.caa = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.bZF = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.bZG = bVar;
    }

    public void setPosition(int i) {
        this.aka = i;
    }

    public void setLastTime(long j) {
        this.bZZ = j;
    }

    public void aW(long j) {
        this.caa = Calendar.getInstance();
        this.caa.setTimeInMillis(1000 * j);
    }

    private boolean aX(long j) {
        if (j < 1000) {
            return false;
        }
        return this.bZZ == 0 || j - this.bZZ >= 180;
    }

    private String aY(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.caa != null && this.caa.get(1) == calendar.get(1) && this.caa.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.ay.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.ay.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.cac = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bbW = (TextView) findViewById(t.g.tex_msgitem_time);
        this.cad = (TbRichTextView) findViewById(t.g.tex_msgitem_text);
        this.cad.setLinkTextColor(-14845754);
        this.cak = (ChatImageWithTailView) findViewById(t.g.img_msgitem_image);
        this.cag = (Invite2GroupView) findViewById(t.g.lay_msgitem_invite_view);
        this.cah = (ShareFromPBView) findViewById(t.g.lay_msgitem_share_view);
        this.cai = (ShareFromFrsView) findViewById(t.g.lay_msgitem_share_frs);
        this.caj = (ShareFromGameCenter) findViewById(t.g.lay_msgitem_share_game);
        this.cae = (ChatVoiceView) findViewById(t.g.lay_msgitem_voice);
        this.cae.setClickable(true);
        this.cae.setOnClickListener(this.cae);
        this.cae.setLongClickable(true);
        this.cae.setOnLongClickListener(new at(this));
        this.cak.getImage().setClickable(true);
        this.cak.getImage().setOnClickListener(new az(this));
        this.cak.getImage().setLongClickable(true);
        this.cak.getImage().setOnLongClickListener(new ba(this));
        this.cak.getTail().setClickable(true);
        this.cak.getTail().setOnClickListener(new bb(this));
        this.cad.setLongClickable(true);
        this.cad.setOnLongClickListener(new bc(this));
        this.caf = (GifView) findViewById(t.g.emotion_msgitem_image);
        this.caf.setSupportNoImage(false);
        this.caf.setOnClickListener(new bd(this));
        this.caf.setLongClickable(true);
        this.caf.setOnLongClickListener(new be(this));
        this.cah.setClickable(true);
        this.cah.setOnClickListener(new bf(this));
        this.cah.setLongClickable(true);
        this.cah.setOnLongClickListener(new bg(this));
        this.cai.setClickable(true);
        this.cai.setOnClickListener(new au(this));
        this.cai.setLongClickable(true);
        this.cai.setOnLongClickListener(new av(this));
        this.caj.getContentBody().setClickable(true);
        this.caj.getContentBody().setOnClickListener(new aw(this));
        this.caj.getTail().setClickable(true);
        this.caj.getTail().setOnClickListener(new ax(this));
        this.caj.getContentBody().setLongClickable(true);
        this.caj.getContentBody().setOnLongClickListener(new ay(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iP(int i) {
        this.cak.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean aX = aX(chatMessage.getTime());
        if (z || aX) {
            this.bbW.setVisibility(0);
            this.bbW.setText(aY(chatMessage.getTime()));
        } else {
            this.bbW.setVisibility(8);
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
        bq.a(this.mContext.getContext(), this.cad, chatMessage, str, this.bZO);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.cad.setContentDescription(stringBuffer.toString());
            this.cad.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cak, chatMessage, this.cab, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), this.cae, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        bq.a(this.mContext.getContext(), this.caf, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        bq.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.cag, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        bq.a(this.mContext.getContext(), view, this.cah, this.cai, this.caj, chatMessage, str);
    }

    public void ee(boolean z) {
        this.cal = z;
    }

    public void ef(boolean z) {
        this.cam = z;
    }

    public void iO(int i) {
        this.bZO = i;
    }
}
