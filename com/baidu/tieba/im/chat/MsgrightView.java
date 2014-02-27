package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.HeadImageShaderView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MsgrightView extends br {
    private static final String p = MsgrightView.class.getName();
    protected TextView o;
    private ProgressBar q;
    private ImageButton r;
    private HeadImageShaderView s;

    public MsgrightView(Context context) {
        super(context, R.layout.msg_msgright_view);
        d();
        this.o = (TextView) a(R.id.img_msgitem_progressbar);
        this.q = (ProgressBar) a(R.id.progress);
        this.r = (ImageButton) a(R.id.btn_msgitem_resend);
        this.s = (HeadImageShaderView) a(R.id.img_msgitem_photo);
        this.s.setAutoChangeStyle(false);
        this.s.setOnClickListener(new ch(this));
    }

    @Override // com.baidu.tieba.im.chat.br
    public final void b(com.baidu.tieba.im.message.b bVar) {
        if (bVar.n() != null && bVar.n().getStatus() != null && (bVar.n().getStatus().shortValue() == 3 || bVar.n().getStatus().shortValue() == 2)) {
            if (this.o.getVisibility() != 8) {
                this.o.setVisibility(8);
                this.k.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (bVar.e() >= 100 || !bVar.d()) {
            if (this.o.getVisibility() != 8) {
                this.o.setVisibility(8);
                this.k.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.k.setColorFilter(TiebaApplication.g().b().getResources().getColor(R.color.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.o.setText(String.valueOf(bVar.e()) + "%");
            this.o.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.br
    public final void a(View view, com.baidu.tieba.im.message.b bVar) {
        String str = null;
        super.a(view, bVar);
        if (bVar == null) {
            this.i.setVisibility(8);
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.j.setVisibility(0);
            this.j.setText(null);
            c(8);
            this.k.setTag(null);
            this.l.setVisibility(8);
            this.l.setTag(null);
            return;
        }
        try {
            c(bVar);
            if (bVar.g() != null) {
                this.s.setUserId(bVar.g().getUserId());
                if (TiebaApplication.w()) {
                    str = com.baidu.tieba.im.e.c();
                }
            }
            this.e.c(str, new ci(this));
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            if (bVar.n() != null && bVar.n().getStatus() != null) {
                switch (bVar.n().getStatus().shortValue()) {
                    case 1:
                        this.q.setVisibility(0);
                        break;
                    case 2:
                        this.r.setVisibility(0);
                        break;
                    case 3:
                        this.q.setVisibility(8);
                        break;
                }
            }
            if (this.r.getVisibility() == 0) {
                this.r.setOnClickListener(new cj(this));
            }
            this.j.setVisibility(8);
            c(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            switch (bVar.i()) {
                case 1:
                    a(bVar, p);
                    return;
                case 2:
                    a(view, bVar, p);
                    c(0);
                    return;
                case 3:
                    b(bVar, p);
                    this.l.setVisibility(0);
                    return;
                case 4:
                    a(bVar, true);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("MsgrightView", "setData", "error = " + e.getMessage());
        }
    }
}
