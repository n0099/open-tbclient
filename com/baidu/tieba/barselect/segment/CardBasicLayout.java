package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.dd6;
import com.baidu.tieba.fd6;
import com.baidu.tieba.uc6;
import com.baidu.tieba.vc6;
import com.baidu.tieba.wc6;
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
    public wc6 b;
    public uc6 c;

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

    public void setData(int i, wc6 wc6Var) {
        vc6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, wc6Var) == null) {
            this.b = wc6Var;
            if (wc6Var != null && wc6Var.a() != null && (a = this.b.a()) != null) {
                int h = a.h();
                if (h == fd6.b) {
                    if (i == VoteCandidateCard.A) {
                        this.a = dd6.d;
                        this.c = this.b.f();
                        return;
                    }
                    this.a = dd6.a;
                    List<uc6> b = this.b.b();
                    if (b != null && b.size() > i) {
                        this.c = b.get(i);
                    }
                } else if (h == fd6.c) {
                    if (i == VoteCandidateCard.A) {
                        this.a = dd6.c;
                        List<uc6> b2 = this.b.b();
                        if (b2 != null && b2.size() > 0) {
                            for (uc6 uc6Var : b2) {
                                if (uc6Var.i() == 1) {
                                    this.c = uc6Var;
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.a = dd6.b;
                    List<uc6> b3 = this.b.b();
                    if (b3 != null && b3.size() > i) {
                        uc6 uc6Var2 = b3.get(i);
                        this.c = uc6Var2;
                        if (uc6Var2.i() == 1 && i == 0) {
                            this.a = dd6.c;
                        }
                    }
                }
            }
        }
    }
}
