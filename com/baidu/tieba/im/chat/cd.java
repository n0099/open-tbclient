package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class cd extends com.baidu.adp.base.d<ChatMessage> {
    protected com.baidu.adp.lib.b.a b;
    protected com.baidu.adp.lib.b.b c;
    protected com.baidu.tbadk.editortool.aa d;
    protected int e;
    protected long f;
    protected Long g;
    protected TextView h;
    protected TbRichTextView i;
    protected TbImageView j;
    protected ChatVoiceView k;
    protected GifView l;
    protected Invite2GroupView m;
    protected ShareFromPBView n;
    protected boolean o;
    private long p;
    private Calendar q;

    public cd(Context context, int i) {
        super(context, i);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0L;
        this.g = null;
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

    public void a(com.baidu.tbadk.editortool.aa aaVar) {
        this.d = aaVar;
    }

    public void b(int i) {
        this.e = i;
    }

    public void a(long j) {
        this.f = j;
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
            return com.baidu.tbadk.core.util.bm.b(calendar.getTime());
        }
        return com.baidu.tbadk.core.util.bm.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.g = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.h = (TextView) a(com.baidu.tieba.v.tex_msgitem_time);
        this.i = (TbRichTextView) a(com.baidu.tieba.v.tex_msgitem_text);
        this.i.setLinkTextColor(-14845754);
        this.j = (TbImageView) a(com.baidu.tieba.v.img_msgitem_image);
        this.j.setDefaultResource(com.baidu.tieba.u.image_h_not);
        this.m = (Invite2GroupView) a(com.baidu.tieba.v.lay_msgitem_invite_view);
        this.n = (ShareFromPBView) a(com.baidu.tieba.v.lay_msgitem_share_view);
        this.k = (ChatVoiceView) a(com.baidu.tieba.v.lay_msgitem_voice);
        this.k.setClickable(true);
        this.k.setOnClickListener(this.k);
        this.k.setLongClickable(true);
        this.k.setOnLongClickListener(new ce(this));
        this.j.setClickable(true);
        this.j.setOnClickListener(new cf(this));
        this.j.setLongClickable(true);
        this.j.setOnLongClickListener(new cg(this));
        this.i.setLongClickable(true);
        this.i.setOnLongClickListener(new ch(this));
        this.l = (GifView) a(com.baidu.tieba.v.emotion_msgitem_image);
        this.l.setOnClickListener(new ci(this));
        this.l.setLongClickable(true);
        this.l.setOnLongClickListener(new cj(this));
        this.n.setClickable(true);
        this.n.setOnClickListener(new ck(this));
        this.n.setLongClickable(true);
        this.n.setOnLongClickListener(new cl(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        this.j.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean d = d(chatMessage.getTime());
        if (z || d) {
            this.h.setVisibility(0);
            this.h.setText(e(chatMessage.getTime()));
        } else {
            this.h.setVisibility(8);
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
        de.a(this.mContext, this.i, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        de.a(this.mContext, view, this.j, chatMessage, this.f, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        de.a(this.mContext, this.k, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        de.a(this.mContext, this.l, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        de.a(this.mContext, view, this.m, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        de.a(this.mContext, view, this.n, chatMessage, str);
    }

    public void a(boolean z) {
        this.o = z;
    }
}
