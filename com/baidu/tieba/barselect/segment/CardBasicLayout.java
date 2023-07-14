package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.aj6;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.bj6;
import com.baidu.tieba.cj6;
import com.baidu.tieba.jj6;
import com.baidu.tieba.lj6;
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
    public cj6 b;
    public aj6 c;

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

    public void setData(int i, cj6 cj6Var) {
        bj6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, cj6Var) == null) {
            this.b = cj6Var;
            if (cj6Var != null && cj6Var.a() != null && (a = this.b.a()) != null) {
                int h = a.h();
                if (h == lj6.b) {
                    if (i == VoteCandidateCard.A) {
                        this.a = jj6.d;
                        this.c = this.b.f();
                        return;
                    }
                    this.a = jj6.a;
                    List<aj6> b = this.b.b();
                    if (b != null && b.size() > i) {
                        this.c = b.get(i);
                    }
                } else if (h == lj6.c) {
                    if (i == VoteCandidateCard.A) {
                        this.a = jj6.c;
                        List<aj6> b2 = this.b.b();
                        if (b2 != null && b2.size() > 0) {
                            for (aj6 aj6Var : b2) {
                                if (aj6Var.i() == 1) {
                                    this.c = aj6Var;
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.a = jj6.b;
                    List<aj6> b3 = this.b.b();
                    if (b3 != null && b3.size() > i) {
                        aj6 aj6Var2 = b3.get(i);
                        this.c = aj6Var2;
                        if (aj6Var2.i() == 1 && i == 0) {
                            this.a = jj6.c;
                        }
                    }
                }
            }
        }
    }
}
