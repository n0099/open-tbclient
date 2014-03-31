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
import java.util.Calendar;
/* loaded from: classes.dex */
public class ch extends com.baidu.adp.a.d<com.baidu.tieba.im.message.a.a> {
    protected com.baidu.adp.lib.b.a c;
    protected com.baidu.adp.lib.b.b d;
    protected com.baidu.tbadk.editortool.aa e;
    protected int f;
    protected long g;
    protected Long h;
    protected TextView i;
    protected TbRichTextView j;
    protected BDImageView2 k;
    protected ChatVoiceView l;
    protected GifView m;
    protected Invite2GroupView n;
    protected boolean o;
    private long p;
    private Calendar q;

    public ch(Context context, int i) {
        super(context, i);
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = 0L;
        this.h = null;
        this.o = true;
        this.p = 0L;
        this.q = null;
        this.b = context;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.c = aVar;
    }

    public void a(com.baidu.adp.lib.b.b bVar) {
        this.d = bVar;
    }

    public final void a(com.baidu.tbadk.editortool.aa aaVar) {
        this.e = aaVar;
    }

    public void b(int i) {
        this.f = i;
    }

    public final void a(long j) {
        this.g = j;
    }

    public final void b(long j) {
        this.p = j;
    }

    public final void c(long j) {
        this.q = Calendar.getInstance();
        this.q.setTimeInMillis(1000 * j);
    }

    public void b(com.baidu.tieba.im.message.a.a aVar) {
    }

    public void a(View view, com.baidu.tieba.im.message.a.a aVar) {
        if (aVar != null) {
            this.h = Long.valueOf(aVar.w());
        } else {
            com.baidu.adp.lib.util.f.b("data is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        this.i = (TextView) a(com.baidu.tieba.im.h.tex_msgitem_time);
        this.j = (TbRichTextView) a(com.baidu.tieba.im.h.tex_msgitem_text);
        this.j.setLinkTextColor(-14845754);
        this.k = (BDImageView2) a(com.baidu.tieba.im.h.img_msgitem_image);
        this.k.setDefaultResource(com.baidu.tieba.im.g.image_h_not);
        this.n = (Invite2GroupView) a(com.baidu.tieba.im.h.lay_msgitem_invite_view);
        this.l = (ChatVoiceView) a(com.baidu.tieba.im.h.lay_msgitem_voice);
        this.l.setClickable(true);
        this.l.setOnClickListener(this.l);
        this.l.setLongClickable(true);
        this.l.setOnLongClickListener(new ci(this));
        this.k.setClickable(true);
        this.k.setOnClickListener(new cj(this));
        this.k.setLongClickable(true);
        this.k.setOnLongClickListener(new ck(this));
        this.j.setLongClickable(true);
        this.j.setOnLongClickListener(new cl(this));
        this.m = (GifView) a(com.baidu.tieba.im.h.emotion_msgitem_image);
        this.m.setOnClickListener(new cm(this));
        this.m.setLongClickable(true);
        this.m.setOnLongClickListener(new cn(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(int i) {
        this.k.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(com.baidu.tieba.im.message.a.a aVar) {
        boolean z;
        String b;
        boolean z2 = aVar.z() != null && aVar.z().getIs_show_time() == 1;
        long A = aVar.A();
        if (A < 1000) {
            z = false;
        } else {
            z = this.p == 0 || A - this.p >= 180;
        }
        if (z2 || z) {
            this.i.setVisibility(0);
            TextView textView = this.i;
            long A2 = aVar.A();
            if (A2 < 1000) {
                b = "";
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(A2 * 1000);
                b = (this.q != null && this.q.get(1) == calendar.get(1) && this.q.get(6) == calendar.get(6)) ? com.baidu.tbadk.core.util.bc.b(calendar.getTime()) : com.baidu.tbadk.core.util.bc.a(calendar.getTime());
            }
            textView.setText(b);
        } else {
            this.i.setVisibility(8);
        }
        if (!z2 && z) {
            MsgCacheData z3 = aVar.z();
            if (z3 == null) {
                MsgCacheData msgCacheData = new MsgCacheData();
                msgCacheData.setIs_show_time(1);
                aVar.a(msgCacheData);
                return;
            }
            z3.setIs_show_time(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(com.baidu.tieba.im.message.a.a aVar, String str) {
        dg.a(this.b, this.j, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(View view, com.baidu.tieba.im.message.a.a aVar, String str) {
        Context context = this.b;
        BDImageView2 bDImageView2 = this.k;
        long j = this.g;
        dg.a(context, view, bDImageView2, aVar, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(com.baidu.tieba.im.message.a.a aVar, String str) {
        Context context = this.b;
        dg.a(this.l, aVar, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(com.baidu.tieba.im.message.a.a aVar, boolean z) {
        dg.a(this.b, this.m, aVar, this.e, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(View view, com.baidu.tieba.im.message.a.a aVar, String str) {
        dg.a(this.b, view, this.n, aVar, str);
    }

    public final void a(boolean z) {
        this.o = z;
    }
}
