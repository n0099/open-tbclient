package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class cb extends com.baidu.adp.base.d<ChatMessage> {
    protected com.baidu.adp.lib.b.a b;
    protected com.baidu.adp.lib.b.b c;
    protected int d;
    protected long e;
    protected Long f;
    protected TextView g;
    protected TbRichTextView h;
    protected ChatVoiceView i;
    protected GifView j;
    protected Invite2GroupView k;
    protected ShareFromPBView l;
    protected ShareFromGameCenter m;
    protected ChatImageWithTailView n;
    protected boolean o;
    private long p;
    private Calendar q;

    public cb(Context context, int i) {
        super(context, i);
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = 0L;
        this.f = null;
        this.o = true;
        this.p = 0L;
        this.q = null;
        this.mContext = context;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.b = aVar;
    }

    public void a(com.baidu.adp.lib.b.b bVar) {
        this.c = bVar;
    }

    public void b(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.e = j;
    }

    public void b(long j) {
        this.p = j;
    }

    public void c(long j) {
        this.q = Calendar.getInstance();
        this.q.setTimeInMillis(1000 * j);
    }

    private boolean d(long j) {
        if (j < 1000) {
            return false;
        }
        return this.p == 0 || j - this.p >= 180;
    }

    private String e(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.q != null && this.q.get(1) == calendar.get(1) && this.q.get(6) == calendar.get(6)) {
            return com.baidu.tbadk.core.util.ba.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.ba.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.f = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.g = (TextView) a(com.baidu.tieba.u.tex_msgitem_time);
        this.h = (TbRichTextView) a(com.baidu.tieba.u.tex_msgitem_text);
        this.h.setLinkTextColor(-14845754);
        this.n = (ChatImageWithTailView) a(com.baidu.tieba.u.img_msgitem_image);
        this.k = (Invite2GroupView) a(com.baidu.tieba.u.lay_msgitem_invite_view);
        this.l = (ShareFromPBView) a(com.baidu.tieba.u.lay_msgitem_share_view);
        this.m = (ShareFromGameCenter) a(com.baidu.tieba.u.lay_msgitem_share_game);
        this.i = (ChatVoiceView) a(com.baidu.tieba.u.lay_msgitem_voice);
        this.i.setClickable(true);
        this.i.setOnClickListener(this.i);
        this.i.setLongClickable(true);
        this.i.setOnLongClickListener(new cc(this));
        this.n.getImage().setClickable(true);
        this.n.getImage().setOnClickListener(new cf(this));
        this.n.getImage().setLongClickable(true);
        this.n.getImage().setOnLongClickListener(new cg(this));
        this.n.getTail().setClickable(true);
        this.n.getTail().setOnClickListener(new ch(this));
        this.h.setLongClickable(true);
        this.h.setOnLongClickListener(new ci(this));
        this.j = (GifView) a(com.baidu.tieba.u.emotion_msgitem_image);
        this.j.setOnClickListener(new cj(this));
        this.j.setLongClickable(true);
        this.j.setOnLongClickListener(new ck(this));
        this.l.setClickable(true);
        this.l.setOnClickListener(new cl(this));
        this.l.setLongClickable(true);
        this.l.setOnLongClickListener(new cm(this));
        this.m.getContentBody().setClickable(true);
        this.m.getContentBody().setOnClickListener(new cd(this));
        this.m.getTail().setClickable(true);
        this.m.getTail().setOnClickListener(new ce(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        this.n.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean d = d(chatMessage.getTime());
        if (z || d) {
            this.g.setVisibility(0);
            this.g.setText(e(chatMessage.getTime()));
        } else {
            this.g.setVisibility(8);
        }
        if (!z && d) {
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
        df.a(this.mContext, this.h, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        df.a(this.mContext, view, this.n, chatMessage, this.e, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        df.a(this.mContext, this.i, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        df.a(this.mContext, this.j, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        df.a(this.mContext, view, this.k, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        df.a(this.mContext, view, this.l, this.m, chatMessage, str);
    }

    public void a(boolean z) {
        this.o = z;
    }
}
