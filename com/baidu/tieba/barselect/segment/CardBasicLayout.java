package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.cb6;
import com.baidu.tieba.eb6;
import com.baidu.tieba.ta6;
import com.baidu.tieba.ua6;
import com.baidu.tieba.va6;
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
    public va6 b;
    public ta6 c;

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

    public void setData(int i, va6 va6Var) {
        ua6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, va6Var) == null) {
            this.b = va6Var;
            if (va6Var != null && va6Var.a() != null && (a = this.b.a()) != null) {
                int h = a.h();
                if (h == eb6.b) {
                    if (i == VoteCandidateCard.A) {
                        this.a = cb6.d;
                        this.c = this.b.f();
                        return;
                    }
                    this.a = cb6.a;
                    List<ta6> b = this.b.b();
                    if (b != null && b.size() > i) {
                        this.c = b.get(i);
                    }
                } else if (h == eb6.c) {
                    if (i == VoteCandidateCard.A) {
                        this.a = cb6.c;
                        List<ta6> b2 = this.b.b();
                        if (b2 != null && b2.size() > 0) {
                            for (ta6 ta6Var : b2) {
                                if (ta6Var.i() == 1) {
                                    this.c = ta6Var;
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.a = cb6.b;
                    List<ta6> b3 = this.b.b();
                    if (b3 != null && b3.size() > i) {
                        ta6 ta6Var2 = b3.get(i);
                        this.c = ta6Var2;
                        if (ta6Var2.i() == 1 && i == 0) {
                            this.a = cb6.c;
                        }
                    }
                }
            }
        }
    }
}
