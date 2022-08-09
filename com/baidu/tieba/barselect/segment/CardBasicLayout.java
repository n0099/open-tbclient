package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ey5;
import com.repackage.fy5;
import com.repackage.gy5;
import com.repackage.ny5;
import com.repackage.py5;
import java.util.List;
/* loaded from: classes3.dex */
public class CardBasicLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public gy5 b;
    public ey5 c;

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

    public void setData(int i, gy5 gy5Var) {
        fy5 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, gy5Var) == null) {
            this.b = gy5Var;
            if (gy5Var == null || gy5Var.a() == null || (a = this.b.a()) == null) {
                return;
            }
            int h = a.h();
            if (h == py5.b) {
                if (i == VoteCandidateCard.A) {
                    this.a = ny5.d;
                    this.c = this.b.f();
                    return;
                }
                this.a = ny5.a;
                List<ey5> b = this.b.b();
                if (b == null || b.size() <= i) {
                    return;
                }
                this.c = b.get(i);
            } else if (h == py5.c) {
                if (i == VoteCandidateCard.A) {
                    this.a = ny5.c;
                    List<ey5> b2 = this.b.b();
                    if (b2 == null || b2.size() <= 0) {
                        return;
                    }
                    for (ey5 ey5Var : b2) {
                        if (ey5Var.i() == 1) {
                            this.c = ey5Var;
                            return;
                        }
                    }
                    return;
                }
                this.a = ny5.b;
                List<ey5> b3 = this.b.b();
                if (b3 == null || b3.size() <= i) {
                    return;
                }
                ey5 ey5Var2 = b3.get(i);
                this.c = ey5Var2;
                if (ey5Var2.i() == 1 && i == 0) {
                    this.a = ny5.c;
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
