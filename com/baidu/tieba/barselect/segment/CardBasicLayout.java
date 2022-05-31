package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bv5;
import com.repackage.qu5;
import com.repackage.ru5;
import com.repackage.su5;
import com.repackage.zu5;
import java.util.List;
/* loaded from: classes3.dex */
public class CardBasicLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public su5 b;
    public qu5 c;

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

    public void setData(int i, su5 su5Var) {
        ru5 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, su5Var) == null) {
            this.b = su5Var;
            if (su5Var == null || su5Var.a() == null || (a = this.b.a()) == null) {
                return;
            }
            int g = a.g();
            if (g == bv5.b) {
                if (i == VoteCandidateCard.A) {
                    this.a = zu5.d;
                    this.c = this.b.f();
                    return;
                }
                this.a = zu5.a;
                List<qu5> b = this.b.b();
                if (b == null || b.size() <= i) {
                    return;
                }
                this.c = b.get(i);
            } else if (g == bv5.c) {
                if (i == VoteCandidateCard.A) {
                    this.a = zu5.c;
                    List<qu5> b2 = this.b.b();
                    if (b2 == null || b2.size() <= 0) {
                        return;
                    }
                    for (qu5 qu5Var : b2) {
                        if (qu5Var.i() == 1) {
                            this.c = qu5Var;
                            return;
                        }
                    }
                    return;
                }
                this.a = zu5.b;
                List<qu5> b3 = this.b.b();
                if (b3 == null || b3.size() <= i) {
                    return;
                }
                qu5 qu5Var2 = b3.get(i);
                this.c = qu5Var2;
                if (qu5Var2.i() == 1 && i == 0) {
                    this.a = zu5.c;
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
