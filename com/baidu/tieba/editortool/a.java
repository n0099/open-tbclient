package com.baidu.tieba.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.BubbleListData;
/* loaded from: classes.dex */
public class a extends ai {
    public CustomMessageListener a;
    private com.baidu.tieba.model.e b;
    private BubbleListData c;
    private Context d;
    private int e;
    private String f;
    private boolean g;
    private com.baidu.tieba.model.h h;
    private com.baidu.tieba.model.i i;
    private View.OnClickListener j;
    private com.baidu.tieba.bubble.s k;
    private com.baidu.tieba.bubble.s l;

    public a(an anVar) {
        super(anVar);
        this.e = 0;
        this.g = false;
        this.h = new b(this);
        this.i = new c(this);
        this.a = new d(this, 2010040);
        this.j = new e(this);
        this.k = new f(this);
        this.l = new g(this);
    }

    @Override // com.baidu.tieba.editortool.ai
    public void a(Context context) {
        if (this.g) {
            if (i() != null) {
                i().a(this);
                return;
            }
            return;
        }
        this.g = true;
        this.d = context;
        ak akVar = new ak();
        akVar.a = com.baidu.tieba.t.icon_bubble;
        akVar.b = 0;
        c(TbadkApplication.m252getInst().getResources().getDimensionPixelSize(com.baidu.tieba.s.ds26));
        d(TbadkApplication.m252getInst().getResources().getDimensionPixelSize(com.baidu.tieba.s.ds30));
        a(akVar);
        a(2);
        b(2);
        a(new h(this, context));
        if (this.b == null) {
            this.b = new com.baidu.tieba.model.e();
        }
        this.b.a(this.h);
        this.b.a(this.i);
        this.b.a(this.a);
        this.b.c();
        this.b.d();
        if (i() != null) {
            i().a();
        }
        this.b.a(0, 50, com.baidu.adp.lib.util.j.b(this.d), com.baidu.adp.lib.util.j.c(this.d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        this.b.a(i, com.baidu.adp.lib.util.j.b(this.d), com.baidu.adp.lib.util.j.c(this.d));
        this.b.a(i);
        if (i() != null) {
            i().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        int i = 0;
        if (this.c != null && this.c.getB_info() != null) {
            BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
            bubbleData.setBcode(0);
            if (this.c.getB_info().get(0).getBcode() != 0) {
                this.c.getB_info().add(0, bubbleData);
            }
            this.e = 0;
            while (true) {
                if (i >= this.c.getB_info().size()) {
                    break;
                } else if (!this.c.getB_info().get(i).isDef()) {
                    i++;
                } else {
                    this.e = i;
                    break;
                }
            }
        }
        if (j() != null) {
            if (this.e == 0 || TextUtils.isEmpty(this.f)) {
                j().a(47, null);
            } else {
                j().a(46, this.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BubbleListData.BubbleData f(int i) {
        if (i < 0 || i >= a() || this.c == null) {
            return null;
        }
        return this.c.getB_info().get(i);
    }

    @Override // com.baidu.tieba.editortool.ai
    public int a() {
        if (this.c == null || this.c.getB_info() == null) {
            return 0;
        }
        return this.c.getB_info().size();
    }

    @Override // com.baidu.tieba.editortool.ai
    public void b() {
        if (this.b != null) {
            this.b.e();
            this.b.b(this.a);
            this.b = null;
            this.g = false;
        }
    }
}
