package com.baidu.tieba.d.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d.a.f;
import com.baidu.tieba.d.b.d;
import com.baidu.tieba.d.b.g;
import com.baidu.tieba.d.b.h;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public abstract class a {
    protected View a;
    protected TextView b;
    protected TextView c;
    protected TextView d;
    protected HeadImageView e;
    protected View f;
    protected int g = TbadkApplication.m252getInst().getSkinType();
    protected f h;
    protected boolean i;
    private int j;

    protected abstract void c();

    protected abstract void d();

    protected abstract int e();

    public a(View view) {
        this.a = view;
        view.setTag(this);
    }

    public void a() {
        a(this.h, this.j, this.i);
    }

    public void a(f fVar, int i, boolean z) {
        if (!fVar.a) {
            com.baidu.tbadk.distribute.a.a().a(this.a.getContext(), fVar.y(), "show", "pb", fVar.b, fVar.c);
            com.baidu.tbadk.distribute.a.a().a(fVar.y(), fVar.b, fVar.c, "PB", "show");
            fVar.a = true;
        }
        this.h = fVar;
        this.j = i;
        this.i = z;
        this.a.setTag(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.h != null && this.h.s()) {
            boolean b = com.baidu.tieba.frs.b.a().b(this.h.a());
            boolean c = com.baidu.tieba.frs.b.a().c(this.h.a());
            if (b) {
                this.h.a(1);
            } else if (c) {
                this.h.a(2);
            } else {
                this.h.a(0);
            }
            if (this.h.t()) {
                switch (this.h.r()) {
                    case 0:
                        c();
                        this.b.setText(e());
                        this.b.setOnClickListener(d.a());
                        this.a.setOnClickListener(com.baidu.tieba.d.b.a.a());
                        this.b.setEnabled(true);
                        return;
                    case 1:
                        d();
                        this.b.setText(x.downloading2);
                        this.b.setOnClickListener(null);
                        this.a.setOnClickListener(null);
                        this.b.setEnabled(false);
                        return;
                    case 2:
                        c();
                        this.b.setText(x.downloaded_install);
                        this.b.setOnClickListener(d.a());
                        this.a.setOnClickListener(com.baidu.tieba.d.b.a.a());
                        this.b.setEnabled(true);
                        return;
                    default:
                        return;
                }
            } else if (this.h.u()) {
                c();
                this.b.setText(x.view);
                this.b.setOnClickListener(g.a());
                this.a.setOnClickListener(h.a());
            }
        }
    }

    public View f() {
        return this.a;
    }

    public int g() {
        return this.j;
    }

    public f h() {
        return this.h;
    }

    public String a(String str) {
        if (!StringUtils.isNull(str)) {
            String replaceAll = str.replaceAll("，", "， ").replaceAll("。", "。 ").replaceAll("？", "？ ").replaceAll("！", "！ ").replaceAll("、", "、 ").replaceAll("‘", "’ ").replaceAll("“", "” ").replaceAll("【", "【 ").replaceAll("】", "】 ").replaceAll("；", "； ").replaceAll("：", "： ").replaceAll("（", "（ ").replaceAll("）", "） ").replaceAll("·", "· ").replaceAll(" ", "  ");
            if (replaceAll.charAt(replaceAll.length() - 1) == ' ') {
                replaceAll = replaceAll.substring(0, replaceAll.length() - 1);
            }
            return replaceAll;
        }
        return str;
    }
}
