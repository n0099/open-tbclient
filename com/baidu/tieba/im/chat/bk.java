package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ImageView.BDImageView2;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import com.slidingmenu.lib.R;
import java.util.Calendar;
/* loaded from: classes.dex */
public class bk extends com.baidu.adp.a.c<com.baidu.tieba.im.message.b> {
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
    protected GifView m;
    protected Invite2GroupView n;
    private long o;
    private Calendar p;

    public bk(Context context, int i) {
        super(context, i);
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = 0L;
        this.h = null;
        this.o = 0L;
        this.p = null;
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
        this.o = j;
    }

    public void c(long j) {
        this.p = Calendar.getInstance();
        this.p.setTimeInMillis(1000 * j);
    }

    private boolean d(long j) {
        if (j < 1000) {
            return false;
        }
        return this.o == 0 || j - this.o >= 180;
    }

    private String e(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.p != null && this.p.get(1) == calendar.get(1) && this.p.get(6) == calendar.get(6)) {
            return com.baidu.tieba.util.bu.b(calendar.getTime());
        }
        return com.baidu.tieba.util.bu.a(calendar.getTime());
    }

    public void a(View view, com.baidu.tieba.im.message.b bVar) {
    }

    public void b(View view, com.baidu.tieba.im.message.b bVar) {
        com.baidu.adp.lib.g.e.e("simon", "setData", bVar.toString());
        if (bVar != null) {
            this.h = Long.valueOf(bVar.l());
        } else {
            com.baidu.adp.lib.g.e.a("data is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.i = (TextView) a(R.id.tex_msgitem_time);
        this.j = (TbRichTextView) a(R.id.tex_msgitem_text);
        this.j.setLinkTextColor(-14845754);
        this.k = (BDImageView2) a(R.id.img_msgitem_image);
        this.k.setDefaultResource(R.drawable.image_h_not);
        this.n = (Invite2GroupView) a(R.id.lay_msgitem_invite_view);
        this.l = (ChatVoiceView) a(R.id.lay_msgitem_voice);
        this.l.setClickable(true);
        this.l.setOnClickListener(this.l);
        this.l.setLongClickable(true);
        this.l.setOnLongClickListener(new bl(this));
        this.k.setClickable(true);
        this.k.setOnClickListener(new bm(this));
        this.k.setLongClickable(true);
        this.k.setOnLongClickListener(new bn(this));
        this.j.setLongClickable(true);
        this.j.setOnLongClickListener(new bo(this));
        this.m = (GifView) a(R.id.emotion_msgitem_image);
        this.m.setOnClickListener(new bp(this));
        this.m.setLongClickable(true);
        this.m.setOnLongClickListener(new bq(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        this.k.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.im.message.b bVar) {
        boolean z = bVar.o() != null && bVar.o().getIs_show_time() == 1;
        boolean d = d(bVar.p());
        if (z || d) {
            this.i.setVisibility(0);
            this.i.setText(e(bVar.p()));
        } else {
            this.i.setVisibility(8);
        }
        if (!z && d) {
            MsgCacheData o = bVar.o();
            if (o == null) {
                MsgCacheData msgCacheData = new MsgCacheData();
                msgCacheData.setIs_show_time(1);
                bVar.a(msgCacheData);
                return;
            }
            o.setIs_show_time(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.im.message.b bVar, String str) {
        ci.a(this.b, this.j, bVar, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, com.baidu.tieba.im.message.b bVar, String str) {
        ci.a(this.b, view, this.k, bVar, this.g, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tieba.im.message.b bVar, String str) {
        ci.a(this.b, this.l, bVar, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.im.message.b bVar, boolean z) {
        ci.a(this.b, this.m, bVar, this.e, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, com.baidu.tieba.im.message.b bVar, String str) {
        ci.a(this.b, view, this.n, bVar, str);
    }
}
