package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.b16;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.d16;
import com.baidu.tieba.s06;
import com.baidu.tieba.t06;
import com.baidu.tieba.u06;
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
    public u06 b;
    public s06 c;

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

    public void setData(int i, u06 u06Var) {
        t06 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, u06Var) == null) {
            this.b = u06Var;
            if (u06Var != null && u06Var.a() != null && (a = this.b.a()) != null) {
                int h = a.h();
                if (h == d16.b) {
                    if (i == VoteCandidateCard.A) {
                        this.a = b16.d;
                        this.c = this.b.f();
                        return;
                    }
                    this.a = b16.a;
                    List b = this.b.b();
                    if (b != null && b.size() > i) {
                        this.c = (s06) b.get(i);
                    }
                } else if (h == d16.c) {
                    if (i == VoteCandidateCard.A) {
                        this.a = b16.c;
                        List<s06> b2 = this.b.b();
                        if (b2 != null && b2.size() > 0) {
                            for (s06 s06Var : b2) {
                                if (s06Var.i() == 1) {
                                    this.c = s06Var;
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.a = b16.b;
                    List b3 = this.b.b();
                    if (b3 != null && b3.size() > i) {
                        s06 s06Var2 = (s06) b3.get(i);
                        this.c = s06Var2;
                        if (s06Var2.i() == 1 && i == 0) {
                            this.a = b16.c;
                        }
                    }
                }
            }
        }
    }
}
