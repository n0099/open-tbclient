package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import d.a.j0.v.b.d;
import d.a.j0.v.b.e;
import d.a.j0.v.b.f;
import d.a.j0.v.e.a;
import java.util.List;
/* loaded from: classes4.dex */
public class CardBasicLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f14959e;

    /* renamed from: f  reason: collision with root package name */
    public f f14960f;

    /* renamed from: g  reason: collision with root package name */
    public d f14961g;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public void setData(int i2, f fVar) {
        e a2;
        this.f14960f = fVar;
        if (fVar == null || fVar.a() == null || (a2 = this.f14960f.a()) == null) {
            return;
        }
        int g2 = a2.g();
        if (g2 == d.a.j0.v.e.d.f61620b) {
            if (i2 == VoteCandidateCard.E) {
                this.f14959e = a.f61618d;
                this.f14961g = this.f14960f.f();
                return;
            }
            this.f14959e = a.f61615a;
            List<d> b2 = this.f14960f.b();
            if (b2 == null || b2.size() <= i2) {
                return;
            }
            this.f14961g = b2.get(i2);
        } else if (g2 == d.a.j0.v.e.d.f61621c) {
            if (i2 == VoteCandidateCard.E) {
                this.f14959e = a.f61617c;
                List<d> b3 = this.f14960f.b();
                if (b3 == null || b3.size() <= 0) {
                    return;
                }
                for (d dVar : b3) {
                    if (dVar.i() == 1) {
                        this.f14961g = dVar;
                        return;
                    }
                }
                return;
            }
            this.f14959e = a.f61616b;
            List<d> b4 = this.f14960f.b();
            if (b4 == null || b4.size() <= i2) {
                return;
            }
            d dVar2 = b4.get(i2);
            this.f14961g = dVar2;
            if (dVar2.i() == 1 && i2 == 0) {
                this.f14959e = a.f61617c;
            }
        }
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14959e = -1;
    }
}
