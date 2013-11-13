package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ImageView.BDImageView2;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.slidingmenu.lib.R;
import java.util.Calendar;
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.a.c<ChatMessage> {
    protected com.baidu.adp.lib.b.a c;
    protected com.baidu.adp.lib.b.b d;
    protected com.baidu.tieba.util.i e;
    protected int f;
    protected long g;
    protected Long h;
    protected TextView i;
    protected TbRichTextView j;
    protected BDImageView2 k;
    protected ChatVoiceView l;
    private long m;
    private Calendar n;

    public ak(Context context, int i) {
        super(context, i);
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = 0L;
        this.h = null;
        this.m = 0L;
        this.n = null;
        this.b = context;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.c = aVar;
    }

    public void a(com.baidu.adp.lib.b.b bVar) {
        this.d = bVar;
    }

    public void a(com.baidu.tieba.util.i iVar) {
        this.e = iVar;
    }

    public void b(int i) {
        this.f = i;
    }

    public void a(long j) {
        this.g = j;
    }

    public void b(long j) {
        this.m = j;
    }

    public void c(long j) {
        this.n = Calendar.getInstance();
        this.n.setTimeInMillis(1000 * j);
    }

    private boolean d(long j) {
        if (j < 1000) {
            return false;
        }
        return this.m == 0 || j - this.m >= 180;
    }

    private String e(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.n != null && this.n.get(1) == calendar.get(1) && this.n.get(6) == calendar.get(6)) {
            return com.baidu.tieba.util.be.b(calendar.getTime());
        }
        return com.baidu.tieba.util.be.a(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
        this.h = Long.valueOf(chatMessage.getMsgId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.i = (TextView) a(R.id.tex_msgitem_time);
        this.j = (TbRichTextView) a(R.id.tex_msgitem_text);
        this.k = (BDImageView2) a(R.id.img_msgitem_image);
        this.k.setDefaultResource(R.drawable.image_h_not);
        this.l = (ChatVoiceView) a(R.id.lay_msgitem_voice);
        this.l.setClickable(true);
        this.l.setOnClickListener(this.l);
        this.l.setLongClickable(true);
        this.l.setOnLongClickListener(new al(this));
        this.k.setClickable(true);
        this.k.setOnClickListener(new am(this));
        this.k.setLongClickable(true);
        this.k.setOnLongClickListener(new an(this));
        this.j.setLongClickable(true);
        this.j.setOnLongClickListener(new ao(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        this.k.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean d = d(chatMessage.getTime());
        if (z || d) {
            this.i.setVisibility(0);
            this.i.setText(e(chatMessage.getTime()));
        } else {
            this.i.setVisibility(8);
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
        by.a(this.b, this.j, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        by.a(this.b, view, this.k, chatMessage, this.g, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        by.a(this.b, this.l, chatMessage, str);
    }
}
