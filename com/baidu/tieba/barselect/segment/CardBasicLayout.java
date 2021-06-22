package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import d.a.o0.x.b.d;
import d.a.o0.x.b.e;
import d.a.o0.x.b.f;
import d.a.o0.x.e.a;
import d.a.o0.x.e.c;
import java.util.List;
/* loaded from: classes4.dex */
public class CardBasicLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f14316e;

    /* renamed from: f  reason: collision with root package name */
    public f f14317f;

    /* renamed from: g  reason: collision with root package name */
    public d f14318g;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public void setData(int i2, f fVar) {
        e a2;
        this.f14317f = fVar;
        if (fVar == null || fVar.a() == null || (a2 = this.f14317f.a()) == null) {
            return;
        }
        int g2 = a2.g();
        if (g2 == c.f67046b) {
            if (i2 == VoteCandidateCard.E) {
                this.f14316e = a.f67044d;
                this.f14318g = this.f14317f.f();
                return;
            }
            this.f14316e = a.f67041a;
            List<d> b2 = this.f14317f.b();
            if (b2 == null || b2.size() <= i2) {
                return;
            }
            this.f14318g = b2.get(i2);
        } else if (g2 == c.f67047c) {
            if (i2 == VoteCandidateCard.E) {
                this.f14316e = a.f67043c;
                List<d> b3 = this.f14317f.b();
                if (b3 == null || b3.size() <= 0) {
                    return;
                }
                for (d dVar : b3) {
                    if (dVar.i() == 1) {
                        this.f14318g = dVar;
                        return;
                    }
                }
                return;
            }
            this.f14316e = a.f67042b;
            List<d> b4 = this.f14317f.b();
            if (b4 == null || b4.size() <= i2) {
                return;
            }
            d dVar2 = b4.get(i2);
            this.f14318g = dVar2;
            if (dVar2.i() == 1 && i2 == 0) {
                this.f14316e = a.f67043c;
            }
        }
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14316e = -1;
    }
}
