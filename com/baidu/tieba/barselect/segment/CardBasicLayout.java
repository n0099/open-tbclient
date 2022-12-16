package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.k36;
import com.baidu.tieba.l36;
import com.baidu.tieba.m36;
import com.baidu.tieba.t36;
import com.baidu.tieba.v36;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class CardBasicLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public m36 b;
    public k36 c;

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

    public void setData(int i, m36 m36Var) {
        l36 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, m36Var) == null) {
            this.b = m36Var;
            if (m36Var != null && m36Var.a() != null && (a = this.b.a()) != null) {
                int h = a.h();
                if (h == v36.b) {
                    if (i == VoteCandidateCard.A) {
                        this.a = t36.d;
                        this.c = this.b.f();
                        return;
                    }
                    this.a = t36.a;
                    List<k36> b = this.b.b();
                    if (b != null && b.size() > i) {
                        this.c = b.get(i);
                    }
                } else if (h == v36.c) {
                    if (i == VoteCandidateCard.A) {
                        this.a = t36.c;
                        List<k36> b2 = this.b.b();
                        if (b2 != null && b2.size() > 0) {
                            for (k36 k36Var : b2) {
                                if (k36Var.i() == 1) {
                                    this.c = k36Var;
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.a = t36.b;
                    List<k36> b3 = this.b.b();
                    if (b3 != null && b3.size() > i) {
                        k36 k36Var2 = b3.get(i);
                        this.c = k36Var2;
                        if (k36Var2.i() == 1 && i == 0) {
                            this.a = t36.c;
                        }
                    }
                }
            }
        }
    }
}
