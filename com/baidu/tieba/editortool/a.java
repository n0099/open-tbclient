package com.baidu.tieba.editortool;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tieba.data.BubbleListData;
/* loaded from: classes.dex */
public class a extends ag {
    com.baidu.tieba.model.f a;
    BubbleListData b;
    com.baidu.tbadk.editortool.ab c;
    Context d;
    int e;
    String f;
    public CustomMessageListener g;
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
        this.g = new d(this, CmdConfig.BUBBLE_LIST_REFRESH);
        this.k = new e(this);
    }

    @Override // com.baidu.tieba.editortool.ag
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
        ai aiVar = new ai();
        aiVar.a = com.baidu.tieba.u.icon_bubble;
        aiVar.b = 0;
        c(TbadkApplication.m252getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds26));
        d(TbadkApplication.m252getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30));
        a(aiVar);
        a(2);
        b(2);
        this.c = new com.baidu.tbadk.editortool.ab(context);
        this.c.d(false);
        a(new f(this, context));
        if (this.a == null) {
            this.a = new com.baidu.tieba.model.f();
        }
        this.a.a(this.i);
        this.a.a(this.j);
        this.a.a(this.g);
        this.a.c();
        this.a.d();
        if (i() != null) {
            i().a();
        }
        this.a.a(0, 50, com.baidu.adp.lib.util.k.b(this.d), com.baidu.adp.lib.util.k.c(this.d));
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
    public BubbleListData.BubbleData e(int i) {
        if (i < 0 || i >= a()) {
            return null;
        }
        return this.b.getB_info().get(i);
    }

    @Override // com.baidu.tieba.editortool.ag
    public int a() {
        if (this.b == null || this.b.getB_info() == null) {
            return 0;
        }
        return this.b.getB_info().size();
    }

    @Override // com.baidu.tieba.editortool.ag
    public void b() {
        if (this.a != null) {
            this.a.e();
            this.a.b(this.g);
            this.a = null;
            this.h = false;
        }
    }
}
