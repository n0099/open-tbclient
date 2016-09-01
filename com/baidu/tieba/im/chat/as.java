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
    protected int aoC;
    protected TextView bLH;
    private long bgL;
    private Calendar cTE;
    protected long cTF;
    protected Long cTG;
    protected TbRichTextView cTH;
    protected ChatVoiceView cTI;
    protected GifView cTJ;
    protected Invite2GroupView cTK;
    protected ShareFromPBView cTL;
    protected ShareFromFrsView cTM;
    protected ShareFromGameCenter cTN;
    protected ChatImageWithTailView cTO;
    protected boolean cTP;
    protected boolean cTQ;
    protected com.baidu.adp.lib.d.a cTk;
    protected com.baidu.adp.lib.d.b cTl;
    protected int cTt;

    public as(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.cTk = null;
        this.cTl = null;
        this.aoC = 0;
        this.cTF = 0L;
        this.cTG = null;
        this.cTP = true;
        this.cTQ = false;
        this.bgL = 0L;
        this.cTE = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.cTk = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.cTl = bVar;
    }

    public void setPosition(int i) {
        this.aoC = i;
    }

    public void bO(long j) {
        this.bgL = j;
    }

    public void bP(long j) {
        this.cTE = Calendar.getInstance();
        this.cTE.setTimeInMillis(1000 * j);
    }

    private boolean bQ(long j) {
        if (j < 1000) {
            return false;
        }
        return this.bgL == 0 || j - this.bgL >= 180;
    }

    private String bR(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.cTE != null && this.cTE.get(1) == calendar.get(1) && this.cTE.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.ba.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.ba.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.cTG = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bLH = (TextView) findViewById(t.g.tex_msgitem_time);
        this.cTH = (TbRichTextView) findViewById(t.g.tex_msgitem_text);
        this.cTH.setLinkTextColor(-14845754);
        this.cTO = (ChatImageWithTailView) findViewById(t.g.img_msgitem_image);
        this.cTK = (Invite2GroupView) findViewById(t.g.lay_msgitem_invite_view);
        this.cTL = (ShareFromPBView) findViewById(t.g.lay_msgitem_share_view);
        this.cTM = (ShareFromFrsView) findViewById(t.g.lay_msgitem_share_frs);
        this.cTN = (ShareFromGameCenter) findViewById(t.g.lay_msgitem_share_game);
        this.cTI = (ChatVoiceView) findViewById(t.g.lay_msgitem_voice);
        this.cTI.setClickable(true);
        this.cTI.setOnClickListener(this.cTI);
        this.cTI.setLongClickable(true);
        this.cTI.setOnLongClickListener(new at(this));
        this.cTO.getImage().setClickable(true);
        this.cTO.getImage().setOnClickListener(new ba(this));
        this.cTO.getImage().setLongClickable(true);
        this.cTO.getImage().setOnLongClickListener(new bb(this));
        this.cTO.getTail().setClickable(true);
        this.cTO.getTail().setOnClickListener(new bc(this));
        this.cTH.setLongClickable(true);
        this.cTH.setOnLongClickListener(new bd(this));
        this.cTJ = (GifView) findViewById(t.g.emotion_msgitem_image);
        this.cTJ.setSupportNoImage(false);
        this.cTJ.setOnClickListener(new be(this));
        this.cTJ.setLongClickable(true);
        this.cTJ.setOnLongClickListener(new bf(this));
        this.cTL.setClickable(true);
        this.cTL.setOnClickListener(new bg(this));
        this.cTL.setLongClickable(true);
        this.cTL.setOnLongClickListener(new bh(this));
        this.cTM.setClickable(true);
        this.cTM.setOnClickListener(new au(this));
        this.cTM.setLongClickable(true);
        this.cTM.setOnLongClickListener(new av(this));
        this.cTN.getContentBody().setClickable(true);
        this.cTN.getContentBody().setOnClickListener(new aw(this));
        this.cTN.getTail().setClickable(true);
        this.cTN.getTail().setOnClickListener(new ax(this));
        this.cTN.getContentBody().setLongClickable(true);
        this.cTN.getContentBody().setOnLongClickListener(new ay(this));
        if (this.cTK != null) {
            this.cTK.setOnLongClickListener(new az(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void la(int i) {
        this.cTO.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean bQ = bQ(chatMessage.getTime());
        if (z || bQ) {
            this.bLH.setVisibility(0);
            this.bLH.setText(bR(chatMessage.getTime()));
        } else {
            this.bLH.setVisibility(8);
        }
        if (!z && bQ) {
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
        br.a(this.mContext.getContext(), this.cTH, chatMessage, str, this.cTt);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.cTH.setContentDescription(stringBuffer.toString());
            this.cTH.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), view, this.cTO, chatMessage, this.cTF, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), this.cTI, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        br.a(this.mContext.getContext(), this.cTJ, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        br.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.cTK, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        br.a(this.mContext.getContext(), view, this.cTL, this.cTM, this.cTN, chatMessage, str);
    }

    public void fp(boolean z) {
        this.cTP = z;
    }

    public void fq(boolean z) {
        this.cTQ = z;
    }

    public void kZ(int i) {
        this.cTt = i;
    }
}
