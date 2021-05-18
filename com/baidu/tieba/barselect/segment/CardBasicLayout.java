package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import d.a.k0.v.b.d;
import d.a.k0.v.b.e;
import d.a.k0.v.b.f;
import d.a.k0.v.e.a;
import d.a.k0.v.e.c;
import java.util.List;
/* loaded from: classes4.dex */
public class CardBasicLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f14274e;

    /* renamed from: f  reason: collision with root package name */
    public f f14275f;

    /* renamed from: g  reason: collision with root package name */
    public d f14276g;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public void setData(int i2, f fVar) {
        e a2;
        this.f14275f = fVar;
        if (fVar == null || fVar.a() == null || (a2 = this.f14275f.a()) == null) {
            return;
        }
        int g2 = a2.g();
        if (g2 == c.f62344b) {
            if (i2 == VoteCandidateCard.E) {
                this.f14274e = a.f62342d;
                this.f14276g = this.f14275f.f();
                return;
            }
            this.f14274e = a.f62339a;
            List<d> b2 = this.f14275f.b();
            if (b2 == null || b2.size() <= i2) {
                return;
            }
            this.f14276g = b2.get(i2);
        } else if (g2 == c.f62345c) {
            if (i2 == VoteCandidateCard.E) {
                this.f14274e = a.f62341c;
                List<d> b3 = this.f14275f.b();
                if (b3 == null || b3.size() <= 0) {
                    return;
                }
                for (d dVar : b3) {
                    if (dVar.i() == 1) {
                        this.f14276g = dVar;
                        return;
                    }
                }
                return;
            }
            this.f14274e = a.f62340b;
            List<d> b4 = this.f14275f.b();
            if (b4 == null || b4.size() <= i2) {
                return;
            }
            d dVar2 = b4.get(i2);
            this.f14276g = dVar2;
            if (dVar2.i() == 1 && i2 == 0) {
                this.f14274e = a.f62341c;
            }
        }
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14274e = -1;
    }
}
