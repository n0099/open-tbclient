package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MsgrightView extends at {
    private static final String o = MsgrightView.class.getName();
    protected TextView n;
    private ProgressBar p;
    private ImageButton q;
    private HeadImageView r;

    public MsgrightView(Context context) {
        super(context, R.layout.msg_msgright_view);
        e();
        this.n = (TextView) a(R.id.img_msgitem_progressbar);
        this.p = (ProgressBar) a(R.id.progress);
        this.q = (ImageButton) a(R.id.btn_msgitem_resend);
        this.r = (HeadImageView) a(R.id.img_msgitem_photo);
        this.r.setAutoChangeStyle(false);
        this.r.setOnClickListener(new ck(this));
    }

    @Override // com.baidu.tieba.im.chat.at
    public void a(View view, com.baidu.tieba.im.message.b bVar) {
        if (bVar.m() != null && bVar.m().getStatus() != null && (bVar.m().getStatus().shortValue() == 3 || bVar.m().getStatus().shortValue() == 2)) {
            if (this.n.getVisibility() != 8) {
                this.n.setVisibility(8);
                this.k.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (bVar.d() >= 100 || !bVar.c()) {
            if (this.n.getVisibility() != 8) {
                this.n.setVisibility(8);
                this.k.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.k.setColorFilter(TiebaApplication.h().getResources().getColor(R.color.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.n.setText(bVar.d() + "%");
            this.n.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.at
    public void b(View view, com.baidu.tieba.im.message.b bVar) {
        String str = null;
        super.b(view, bVar);
        if (bVar == null) {
            this.i.setVisibility(8);
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            this.j.setVisibility(0);
            this.j.setText(null);
            c(8);
            this.k.setTag(null);
            this.l.setVisibility(8);
            this.l.setTag(null);
            return;
        }
        try {
            a(bVar);
            if (bVar.f() != null) {
                this.r.setUserId(bVar.f().getId());
                if (TiebaApplication.C()) {
                    str = com.baidu.tieba.im.i.b();
                }
            }
            com.baidu.adp.widget.ImageView.e c = this.e.c(str);
            if (c != null) {
                c.a(this.r);
            } else {
                this.e.b(str, new cl(this));
            }
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            if (bVar.m() != null && bVar.m().getStatus() != null) {
                switch (bVar.m().getStatus().shortValue()) {
                    case 1:
                        this.p.setVisibility(0);
                        break;
                    case 2:
                        this.q.setVisibility(0);
                        break;
                    case 3:
                        this.p.setVisibility(8);
                        break;
                }
            }
            if (this.q.getVisibility() == 0) {
                this.q.setOnClickListener(new cm(this));
            }
            this.j.setVisibility(8);
            c(8);
            this.l.setVisibility(8);
            switch (bVar.h()) {
                case 1:
                    a(bVar, o);
                    return;
                case 2:
                    a(view, bVar, o);
                    c(0);
                    return;
                case 3:
                    b(bVar, o);
                    this.l.setVisibility(0);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b("MsgrightView", "setData", "error = " + e.getMessage());
        }
    }
}
