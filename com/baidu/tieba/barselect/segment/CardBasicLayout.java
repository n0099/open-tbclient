package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import d.b.j0.v.b.d;
import d.b.j0.v.b.e;
import d.b.j0.v.b.f;
import d.b.j0.v.e.a;
import java.util.List;
/* loaded from: classes4.dex */
public class CardBasicLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f14864e;

    /* renamed from: f  reason: collision with root package name */
    public f f14865f;

    /* renamed from: g  reason: collision with root package name */
    public d f14866g;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public void setData(int i, f fVar) {
        e a2;
        this.f14865f = fVar;
        if (fVar == null || fVar.a() == null || (a2 = this.f14865f.a()) == null) {
            return;
        }
        int g2 = a2.g();
        if (g2 == d.b.j0.v.e.d.f63390b) {
            if (i == VoteCandidateCard.E) {
                this.f14864e = a.f63388d;
                this.f14866g = this.f14865f.f();
                return;
            }
            this.f14864e = a.f63385a;
            List<d> b2 = this.f14865f.b();
            if (b2 == null || b2.size() <= i) {
                return;
            }
            this.f14866g = b2.get(i);
        } else if (g2 == d.b.j0.v.e.d.f63391c) {
            if (i == VoteCandidateCard.E) {
                this.f14864e = a.f63387c;
                List<d> b3 = this.f14865f.b();
                if (b3 == null || b3.size() <= 0) {
                    return;
                }
                for (d dVar : b3) {
                    if (dVar.i() == 1) {
                        this.f14866g = dVar;
                        return;
                    }
                }
                return;
            }
            this.f14864e = a.f63386b;
            List<d> b4 = this.f14865f.b();
            if (b4 == null || b4.size() <= i) {
                return;
            }
            d dVar2 = b4.get(i);
            this.f14866g = dVar2;
            if (dVar2.i() == 1 && i == 0) {
                this.f14864e = a.f63387c;
            }
        }
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14864e = -1;
    }
}
