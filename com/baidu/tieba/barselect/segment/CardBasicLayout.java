package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import d.b.i0.v.b.d;
import d.b.i0.v.b.e;
import d.b.i0.v.b.f;
import d.b.i0.v.e.a;
import java.util.List;
/* loaded from: classes4.dex */
public class CardBasicLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f14856e;

    /* renamed from: f  reason: collision with root package name */
    public f f14857f;

    /* renamed from: g  reason: collision with root package name */
    public d f14858g;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public void setData(int i, f fVar) {
        e a2;
        this.f14857f = fVar;
        if (fVar == null || fVar.a() == null || (a2 = this.f14857f.a()) == null) {
            return;
        }
        int g2 = a2.g();
        if (g2 == d.b.i0.v.e.d.f62969b) {
            if (i == VoteCandidateCard.E) {
                this.f14856e = a.f62967d;
                this.f14858g = this.f14857f.f();
                return;
            }
            this.f14856e = a.f62964a;
            List<d> b2 = this.f14857f.b();
            if (b2 == null || b2.size() <= i) {
                return;
            }
            this.f14858g = b2.get(i);
        } else if (g2 == d.b.i0.v.e.d.f62970c) {
            if (i == VoteCandidateCard.E) {
                this.f14856e = a.f62966c;
                List<d> b3 = this.f14857f.b();
                if (b3 == null || b3.size() <= 0) {
                    return;
                }
                for (d dVar : b3) {
                    if (dVar.i() == 1) {
                        this.f14858g = dVar;
                        return;
                    }
                }
                return;
            }
            this.f14856e = a.f62965b;
            List<d> b4 = this.f14857f.b();
            if (b4 == null || b4.size() <= i) {
                return;
            }
            d dVar2 = b4.get(i);
            this.f14858g = dVar2;
            if (dVar2.i() == 1 && i == 0) {
                this.f14856e = a.f62966c;
            }
        }
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14856e = -1;
    }
}
