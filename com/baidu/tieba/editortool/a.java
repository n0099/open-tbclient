package com.baidu.tieba.editortool;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.BubbleListData;
/* loaded from: classes.dex */
public final class a extends ag {
    com.baidu.tieba.model.f a;
    BubbleListData b;
    com.baidu.tbadk.editortool.ab c;
    Context d;
    int e;
    String f;
    public com.baidu.adp.framework.c.a g;
    private boolean h;
    private com.baidu.tieba.model.i i;
    private com.baidu.tieba.model.j j;
    private View.OnClickListener k;

    public a(al alVar) {
        super(alVar);
        this.e = 0;
        this.h = false;
        this.i = new b(this);
        this.j = new c(this);
        this.g = new d(this, 2010040);
        this.k = new e(this);
    }

    @Override // com.baidu.tieba.editortool.ag
    public final void a(Context context) {
        if (this.h) {
            if (i() != null) {
                i().a();
                return;
            }
            return;
        }
        this.h = true;
        this.d = context;
        ai aiVar = new ai();
        aiVar.a = com.baidu.tieba.a.g.icon_bubble;
        aiVar.b = 0;
        c(TbadkApplication.j().getResources().getDimensionPixelSize(com.baidu.tieba.a.f.ds26));
        d(TbadkApplication.j().getResources().getDimensionPixelSize(com.baidu.tieba.a.f.ds30));
        a(aiVar);
        a(2);
        b(2);
        this.c = new com.baidu.tbadk.editortool.ab(context);
        this.c.a(true);
        a(new f(this, context));
        if (this.a == null) {
            this.a = new com.baidu.tieba.model.f();
        }
        this.a.a(this.i);
        this.a.a(this.j);
        com.baidu.tieba.model.f fVar = this.a;
        com.baidu.adp.framework.c.a().a(this.g);
        this.a.c();
        this.a.d();
        if (i() != null) {
            i().b();
        }
        com.baidu.tieba.model.f fVar2 = this.a;
        com.baidu.tieba.model.f.a(0, 50, com.baidu.adp.lib.util.i.b(this.d), com.baidu.adp.lib.util.i.c(this.d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar) {
        int i = 0;
        if (aVar.b != null && aVar.b.getB_info() != null) {
            BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
            bubbleData.setBcode(0);
            if (aVar.b.getB_info().get(0).getBcode() != 0) {
                aVar.b.getB_info().add(0, bubbleData);
            }
            aVar.e = 0;
            while (true) {
                if (i >= aVar.b.getB_info().size()) {
                    break;
                } else if (aVar.b.getB_info().get(i).isDef()) {
                    aVar.e = i;
                    break;
                } else {
                    i++;
                }
            }
        }
        if (aVar.j() != null) {
            if (aVar.e == 0) {
                aVar.j().a(47, null);
            } else {
                aVar.j().a(46, aVar.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ BubbleListData.BubbleData a(a aVar, int i) {
        if (i < 0 || i >= aVar.a()) {
            return null;
        }
        return aVar.b.getB_info().get(i);
    }

    @Override // com.baidu.tieba.editortool.ag
    public final int a() {
        if (this.b == null || this.b.getB_info() == null) {
            return 0;
        }
        return this.b.getB_info().size();
    }

    @Override // com.baidu.tieba.editortool.ag
    public final void b() {
        if (this.a != null) {
            this.a.e();
            com.baidu.tieba.model.f fVar = this.a;
            com.baidu.adp.framework.c.a().b(this.g);
            this.a = null;
            this.h = false;
        }
    }
}
