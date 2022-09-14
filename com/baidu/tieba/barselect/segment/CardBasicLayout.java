package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.a06;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.h06;
import com.baidu.tieba.j06;
import com.baidu.tieba.yz5;
import com.baidu.tieba.zz5;
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
    public a06 b;
    public yz5 c;

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

    public void setData(int i, a06 a06Var) {
        zz5 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, a06Var) == null) {
            this.b = a06Var;
            if (a06Var == null || a06Var.a() == null || (a = this.b.a()) == null) {
                return;
            }
            int h = a.h();
            if (h == j06.b) {
                if (i == VoteCandidateCard.A) {
                    this.a = h06.d;
                    this.c = this.b.f();
                    return;
                }
                this.a = h06.a;
                List<yz5> b = this.b.b();
                if (b == null || b.size() <= i) {
                    return;
                }
                this.c = b.get(i);
            } else if (h == j06.c) {
                if (i == VoteCandidateCard.A) {
                    this.a = h06.c;
                    List<yz5> b2 = this.b.b();
                    if (b2 == null || b2.size() <= 0) {
                        return;
                    }
                    for (yz5 yz5Var : b2) {
                        if (yz5Var.i() == 1) {
                            this.c = yz5Var;
                            return;
                        }
                    }
                    return;
                }
                this.a = h06.b;
                List<yz5> b3 = this.b.b();
                if (b3 == null || b3.size() <= i) {
                    return;
                }
                yz5 yz5Var2 = b3.get(i);
                this.c = yz5Var2;
                if (yz5Var2.i() == 1 && i == 0) {
                    this.a = h06.c;
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
