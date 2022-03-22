package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import c.a.p0.e0.b.d;
import c.a.p0.e0.b.e;
import c.a.p0.e0.b.f;
import c.a.p0.e0.e.a;
import c.a.p0.e0.e.c;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class CardBasicLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public f f31572b;

    /* renamed from: c  reason: collision with root package name */
    public d f31573c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardBasicLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setData(int i, f fVar) {
        e a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, fVar) == null) {
            this.f31572b = fVar;
            if (fVar == null || fVar.a() == null || (a = this.f31572b.a()) == null) {
                return;
            }
            int g2 = a.g();
            if (g2 == c.f13760b) {
                if (i == VoteCandidateCard.A) {
                    this.a = a.f13759d;
                    this.f31573c = this.f31572b.f();
                    return;
                }
                this.a = a.a;
                List<d> b2 = this.f31572b.b();
                if (b2 == null || b2.size() <= i) {
                    return;
                }
                this.f31573c = b2.get(i);
            } else if (g2 == c.f13761c) {
                if (i == VoteCandidateCard.A) {
                    this.a = a.f13758c;
                    List<d> b3 = this.f31572b.b();
                    if (b3 == null || b3.size() <= 0) {
                        return;
                    }
                    for (d dVar : b3) {
                        if (dVar.i() == 1) {
                            this.f31573c = dVar;
                            return;
                        }
                    }
                    return;
                }
                this.a = a.f13757b;
                List<d> b4 = this.f31572b.b();
                if (b4 == null || b4.size() <= i) {
                    return;
                }
                d dVar2 = b4.get(i);
                this.f31573c = dVar2;
                if (dVar2.i() == 1 && i == 0) {
                    this.a = a.f13758c;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
    }
}
