package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import d.a.c.e.m.b;
import d.a.i0.w.a;
import d.a.i0.w.h;
import d.a.i0.w.i;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MoreDeskView extends CommonTabHost {
    public LinkedList<h> q;
    public SparseIntArray r;

    public MoreDeskView(Context context) {
        super(context);
        this.r = new SparseIntArray();
        setBackgroundColorId(R.color.CAM_X0206);
        setToolId(2);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, d.a.i0.w.n
    public void b() {
        super.b();
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, d.a.i0.w.n
    public void init() {
        setShowDelete(false);
        i iVar = new i();
        iVar.E(this.q);
        k(iVar);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, d.a.i0.w.b
    public void onAction(a aVar) {
        super.onAction(aVar);
        if (aVar == null || aVar.f49949a != 2 || aVar.f49950b == 5) {
            return;
        }
        r(aVar);
        q();
    }

    public void p(LinkedList<h> linkedList) {
        this.q = linkedList;
    }

    public final void q() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.r.size(); i3++) {
            i2 += this.r.valueAt(i3);
        }
        if (i2 > 0) {
            d(new a(2, 2, " "));
        } else {
            d(new a(2, 2, null));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r(a aVar) {
        Integer valueOf = Integer.valueOf(this.r.get(aVar.f49950b));
        int intValue = valueOf != null ? valueOf.intValue() : 0;
        Object obj = aVar.f49951c;
        if (obj != null) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    intValue = TextUtils.isEmpty(str.trim()) ? 1 : b.d(str, 1);
                }
            }
            this.r.put(aVar.f49950b, intValue >= 0 ? intValue : 0);
        }
        intValue = 0;
        this.r.put(aVar.f49950b, intValue >= 0 ? intValue : 0);
    }

    public MoreDeskView(Context context, boolean z) {
        super(context);
        this.r = new SparseIntArray();
        setBackgroundColorId(R.color.CAM_X0206);
        setToolId(2);
    }
}
