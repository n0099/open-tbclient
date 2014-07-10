package com.baidu.tieba.editortool;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.BubbleListData;
/* loaded from: classes.dex */
public class a extends ai {
    com.baidu.tieba.model.d a;
    BubbleListData b;
    com.baidu.tbadk.editortool.aa c;
    Context d;
    int e;
    String f;
    public CustomMessageListener g;
    private boolean h;
    private com.baidu.tieba.model.g i;
    private com.baidu.tieba.model.h j;
    private View.OnClickListener k;
    private com.baidu.tieba.bubble.s l;
    private com.baidu.tieba.bubble.s m;

    public a(an anVar) {
        super(anVar);
        this.e = 0;
        this.h = false;
        this.i = new b(this);
        this.j = new c(this);
        this.g = new d(this, 2010040);
        this.k = new e(this);
        this.l = new f(this);
        this.m = new g(this);
    }

    @Override // com.baidu.tieba.editortool.ai
    public void a(Context context) {
        if (this.h) {
            if (i() != null) {
                i().a(this);
                return;
            }
            return;
        }
        this.h = true;
        this.d = context;
        ak akVar = new ak();
        akVar.a = com.baidu.tieba.u.icon_bubble;
        akVar.b = 0;
        c(TbadkApplication.m252getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds26));
        d(TbadkApplication.m252getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30));
        a(akVar);
        a(2);
        b(2);
        this.c = new com.baidu.tbadk.editortool.aa(context);
        this.c.b(false);
        a(new h(this, context));
        if (this.a == null) {
            this.a = new com.baidu.tieba.model.d();
        }
        this.a.a(this.i);
        this.a.a(this.j);
        this.a.a(this.g);
        this.a.c();
        this.a.d();
        if (i() != null) {
            i().a();
        }
        this.a.a(0, 50, com.baidu.adp.lib.util.j.b(this.d), com.baidu.adp.lib.util.j.c(this.d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        this.a.a(i, com.baidu.adp.lib.util.j.b(this.d), com.baidu.adp.lib.util.j.c(this.d));
        this.a.a(i);
        if (i() != null) {
            i().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        int i = 0;
        if (this.b != null && this.b.getB_info() != null) {
            BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
            bubbleData.setBcode(0);
            if (this.b.getB_info().get(0).getBcode() != 0) {
                this.b.getB_info().add(0, bubbleData);
            }
            this.e = 0;
            while (true) {
                if (i >= this.b.getB_info().size()) {
                    break;
                } else if (!this.b.getB_info().get(i).isDef()) {
                    i++;
                } else {
                    this.e = i;
                    break;
                }
            }
        }
        if (j() != null) {
            if (this.e == 0) {
                j().a(47, null);
            } else {
                j().a(46, this.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BubbleListData.BubbleData f(int i) {
        if (i < 0 || i >= a()) {
            return null;
        }
        return this.b.getB_info().get(i);
    }

    @Override // com.baidu.tieba.editortool.ai
    public int a() {
        if (this.b == null || this.b.getB_info() == null) {
            return 0;
        }
        return this.b.getB_info().size();
    }

    @Override // com.baidu.tieba.editortool.ai
    public void b() {
        if (this.a != null) {
            this.a.e();
            this.a.b(this.g);
            this.a = null;
            this.h = false;
        }
    }
}
