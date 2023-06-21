package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.ai6;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.ci6;
import com.baidu.tieba.rh6;
import com.baidu.tieba.sh6;
import com.baidu.tieba.th6;
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
    public th6 b;
    public rh6 c;

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

    public void setData(int i, th6 th6Var) {
        sh6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, th6Var) == null) {
            this.b = th6Var;
            if (th6Var != null && th6Var.a() != null && (a = this.b.a()) != null) {
                int h = a.h();
                if (h == ci6.b) {
                    if (i == VoteCandidateCard.A) {
                        this.a = ai6.d;
                        this.c = this.b.f();
                        return;
                    }
                    this.a = ai6.a;
                    List<rh6> b = this.b.b();
                    if (b != null && b.size() > i) {
                        this.c = b.get(i);
                    }
                } else if (h == ci6.c) {
                    if (i == VoteCandidateCard.A) {
                        this.a = ai6.c;
                        List<rh6> b2 = this.b.b();
                        if (b2 != null && b2.size() > 0) {
                            for (rh6 rh6Var : b2) {
                                if (rh6Var.i() == 1) {
                                    this.c = rh6Var;
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.a = ai6.b;
                    List<rh6> b3 = this.b.b();
                    if (b3 != null && b3.size() > i) {
                        rh6 rh6Var2 = b3.get(i);
                        this.c = rh6Var2;
                        if (rh6Var2.i() == 1 && i == 0) {
                            this.a = ai6.c;
                        }
                    }
                }
            }
        }
    }
}
