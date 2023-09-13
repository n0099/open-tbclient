package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.hi6;
import com.baidu.tieba.ii6;
import com.baidu.tieba.ji6;
import com.baidu.tieba.qi6;
import com.baidu.tieba.si6;
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
    public ji6 b;
    public hi6 c;

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

    public void setData(int i, ji6 ji6Var) {
        ii6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, ji6Var) == null) {
            this.b = ji6Var;
            if (ji6Var != null && ji6Var.a() != null && (a = this.b.a()) != null) {
                int h = a.h();
                if (h == si6.b) {
                    if (i == VoteCandidateCard.A) {
                        this.a = qi6.d;
                        this.c = this.b.f();
                        return;
                    }
                    this.a = qi6.a;
                    List<hi6> b = this.b.b();
                    if (b != null && b.size() > i) {
                        this.c = b.get(i);
                    }
                } else if (h == si6.c) {
                    if (i == VoteCandidateCard.A) {
                        this.a = qi6.c;
                        List<hi6> b2 = this.b.b();
                        if (b2 != null && b2.size() > 0) {
                            for (hi6 hi6Var : b2) {
                                if (hi6Var.i() == 1) {
                                    this.c = hi6Var;
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.a = qi6.b;
                    List<hi6> b3 = this.b.b();
                    if (b3 != null && b3.size() > i) {
                        hi6 hi6Var2 = b3.get(i);
                        this.c = hi6Var2;
                        if (hi6Var2.i() == 1 && i == 0) {
                            this.a = qi6.c;
                        }
                    }
                }
            }
        }
    }
}
