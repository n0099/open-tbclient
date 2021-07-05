package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.x.b.d;
import d.a.s0.x.b.e;
import d.a.s0.x.b.f;
import d.a.s0.x.e.a;
import d.a.s0.x.e.c;
import java.util.List;
/* loaded from: classes5.dex */
public class CardBasicLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f14403e;

    /* renamed from: f  reason: collision with root package name */
    public f f14404f;

    /* renamed from: g  reason: collision with root package name */
    public d f14405g;

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
            this.f14404f = fVar;
            if (fVar == null || fVar.a() == null || (a2 = this.f14404f.a()) == null) {
                return;
            }
            int g2 = a2.g();
            if (g2 == c.f69387b) {
                if (i2 == VoteCandidateCard.E) {
                    this.f14403e = a.f69385d;
                    this.f14405g = this.f14404f.f();
                    return;
                }
                this.f14403e = a.f69382a;
                List<d> b2 = this.f14404f.b();
                if (b2 == null || b2.size() <= i2) {
                    return;
                }
                this.f14405g = b2.get(i2);
            } else if (g2 == c.f69388c) {
                if (i2 == VoteCandidateCard.E) {
                    this.f14403e = a.f69384c;
                    List<d> b3 = this.f14404f.b();
                    if (b3 == null || b3.size() <= 0) {
                        return;
                    }
                    for (d dVar : b3) {
                        if (dVar.i() == 1) {
                            this.f14405g = dVar;
                            return;
                        }
                    }
                    return;
                }
                this.f14403e = a.f69383b;
                List<d> b4 = this.f14404f.b();
                if (b4 == null || b4.size() <= i2) {
                    return;
                }
                d dVar2 = b4.get(i2);
                this.f14405g = dVar2;
                if (dVar2.i() == 1 && i2 == 0) {
                    this.f14403e = a.f69384c;
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
        this.f14403e = -1;
    }
}
