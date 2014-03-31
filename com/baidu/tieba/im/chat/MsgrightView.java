package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.view.HeadImageShaderView;
/* loaded from: classes.dex */
public class MsgrightView extends ch {
    private static final String q = MsgrightView.class.getName();
    protected TextView p;
    private ProgressBar r;
    private ImageButton s;
    private HeadImageShaderView t;

    public MsgrightView(Context context) {
        super(context, com.baidu.tieba.im.i.msg_msgright_view);
        d();
        this.p = (TextView) a(com.baidu.tieba.im.h.img_msgitem_progressbar);
        this.r = (ProgressBar) a(com.baidu.tieba.im.h.progress);
        this.s = (ImageButton) a(com.baidu.tieba.im.h.btn_msgitem_resend);
        this.t = (HeadImageShaderView) a(com.baidu.tieba.im.h.img_msgitem_photo);
        this.t.setAutoChangeStyle(false);
        this.t.setOnClickListener(new cu(this));
    }

    @Override // com.baidu.tieba.im.chat.ch
    public final void b(com.baidu.tieba.im.message.a.a aVar) {
        if (aVar.y() != null && aVar.y().getStatus() != null && (aVar.y().getStatus().shortValue() == 3 || aVar.y().getStatus().shortValue() == 2)) {
            if (this.p.getVisibility() != 8) {
                this.p.setVisibility(8);
                this.k.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (aVar.p() >= 100 || !aVar.o()) {
            if (this.p.getVisibility() != 8) {
                this.p.setVisibility(8);
                this.k.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.k.setColorFilter(TbadkApplication.j().b().getResources().getColor(com.baidu.tieba.im.e.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.p.setText(String.valueOf(aVar.p()) + "%");
            this.p.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.ch
    public final void a(View view, com.baidu.tieba.im.message.a.a aVar) {
        String str = null;
        super.a(view, aVar);
        if (aVar == null) {
            this.i.setVisibility(8);
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            this.j.setVisibility(0);
            this.j.setText(null);
            c(8);
            this.k.setTag(null);
            this.l.setVisibility(8);
            this.l.setTag(null);
            return;
        }
        try {
            c(aVar);
            if (aVar.r() != null) {
                this.t.setUserId(aVar.r().getUserId());
                if (TbadkApplication.F()) {
                    str = com.baidu.tieba.im.p.c();
                }
            }
            this.e.c(str, new cv(this));
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            if (aVar.y() != null && aVar.y().getStatus() != null) {
                switch (aVar.y().getStatus().shortValue()) {
                    case 1:
                        this.r.setVisibility(0);
                        break;
                    case 2:
                        this.s.setVisibility(0);
                        break;
                    case 3:
                        this.r.setVisibility(8);
                        break;
                }
            }
            if (this.s.getVisibility() == 0) {
                this.s.setOnClickListener(new cw(this));
            }
            this.j.setVisibility(8);
            c(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            switch (aVar.t()) {
                case 1:
                    a(aVar, q);
                    return;
                case 2:
                    a(view, aVar, q);
                    c(0);
                    return;
                case 3:
                    b(aVar, q);
                    this.l.setVisibility(0);
                    return;
                case 4:
                    a(aVar, true);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("MsgrightView", "setData", "error = " + e.getMessage());
        }
    }
}
