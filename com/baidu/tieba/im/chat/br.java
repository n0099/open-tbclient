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
public class br extends com.baidu.adp.a.c<com.baidu.tieba.im.message.b> {
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

    public br(Context context, int i) {
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

    public final void a(com.baidu.tieba.util.i iVar) {
        this.e = iVar;
    }

    public void b(int i) {
        this.f = i;
    }

    public final void a(long j) {
        this.g = j;
    }

    public final void b(long j) {
        this.o = j;
    }

    public final void c(long j) {
        this.p = Calendar.getInstance();
        this.p.setTimeInMillis(1000 * j);
    }

    public void b(com.baidu.tieba.im.message.b bVar) {
    }

    public void a(View view, com.baidu.tieba.im.message.b bVar) {
        com.baidu.adp.lib.util.e.e("simon", "setData", bVar.toString());
        if (bVar != null) {
            this.h = Long.valueOf(bVar.l());
        } else {
            com.baidu.adp.lib.util.e.b("data is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
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
        this.l.setOnLongClickListener(new bs(this));
        this.k.setClickable(true);
        this.k.setOnClickListener(new bt(this));
        this.k.setLongClickable(true);
        this.k.setOnLongClickListener(new bu(this));
        this.j.setLongClickable(true);
        this.j.setOnLongClickListener(new bv(this));
        this.m = (GifView) a(R.id.emotion_msgitem_image);
        this.m.setOnClickListener(new bw(this));
        this.m.setLongClickable(true);
        this.m.setOnLongClickListener(new bx(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(int i) {
        this.k.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(com.baidu.tieba.im.message.b bVar) {
        boolean z;
        String b;
        boolean z2 = bVar.o() != null && bVar.o().getIs_show_time() == 1;
        long p = bVar.p();
        if (p < 1000) {
            z = false;
        } else {
            z = this.o == 0 || p - this.o >= 180;
        }
        if (z2 || z) {
            this.i.setVisibility(0);
            TextView textView = this.i;
            long p2 = bVar.p();
            if (p2 < 1000) {
                b = "";
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(p2 * 1000);
                b = (this.p != null && this.p.get(1) == calendar.get(1) && this.p.get(6) == calendar.get(6)) ? com.baidu.tieba.util.bs.b(calendar.getTime()) : com.baidu.tieba.util.bs.a(calendar.getTime());
            }
            textView.setText(b);
        } else {
            this.i.setVisibility(8);
        }
        if (!z2 && z) {
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
    public final void a(com.baidu.tieba.im.message.b bVar, String str) {
        cr.a(this.b, this.j, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(View view, com.baidu.tieba.im.message.b bVar, String str) {
        Context context = this.b;
        BDImageView2 bDImageView2 = this.k;
        long j = this.g;
        cr.a(context, view, bDImageView2, bVar, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(com.baidu.tieba.im.message.b bVar, String str) {
        Context context = this.b;
        cr.a(this.l, bVar, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(com.baidu.tieba.im.message.b bVar, boolean z) {
        cr.a(this.b, this.m, bVar, this.e, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(View view, com.baidu.tieba.im.message.b bVar, String str) {
        cr.a(this.b, view, this.n, bVar, str);
    }
}
