package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.x.b.d;
import d.a.p0.x.b.e;
import d.a.p0.x.b.f;
import d.a.p0.x.e.a;
import d.a.p0.x.e.c;
import java.util.List;
/* loaded from: classes4.dex */
public class CardBasicLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f14442e;

    /* renamed from: f  reason: collision with root package name */
    public f f14443f;

    /* renamed from: g  reason: collision with root package name */
    public d f14444g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardBasicLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setData(int i2, f fVar) {
        e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, fVar) == null) {
            this.f14443f = fVar;
            if (fVar == null || fVar.a() == null || (a2 = this.f14443f.a()) == null) {
                return;
            }
            int g2 = a2.g();
            if (g2 == c.f66175b) {
                if (i2 == VoteCandidateCard.E) {
                    this.f14442e = a.f66173d;
                    this.f14444g = this.f14443f.f();
                    return;
                }
                this.f14442e = a.f66170a;
                List<d> b2 = this.f14443f.b();
                if (b2 == null || b2.size() <= i2) {
                    return;
                }
                this.f14444g = b2.get(i2);
            } else if (g2 == c.f66176c) {
                if (i2 == VoteCandidateCard.E) {
                    this.f14442e = a.f66172c;
                    List<d> b3 = this.f14443f.b();
                    if (b3 == null || b3.size() <= 0) {
                        return;
                    }
                    for (d dVar : b3) {
                        if (dVar.i() == 1) {
                            this.f14444g = dVar;
                            return;
                        }
                    }
                    return;
                }
                this.f14442e = a.f66171b;
                List<d> b4 = this.f14443f.b();
                if (b4 == null || b4.size() <= i2) {
                    return;
                }
                d dVar2 = b4.get(i2);
                this.f14444g = dVar2;
                if (dVar2.i() == 1 && i2 == 0) {
                    this.f14442e = a.f66172c;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14442e = -1;
    }
}
