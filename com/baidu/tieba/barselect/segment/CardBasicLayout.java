package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.e46;
import com.baidu.tieba.f46;
import com.baidu.tieba.g46;
import com.baidu.tieba.n46;
import com.baidu.tieba.p46;
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
    public g46 b;
    public e46 c;

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

    public void setData(int i, g46 g46Var) {
        f46 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, g46Var) == null) {
            this.b = g46Var;
            if (g46Var != null && g46Var.a() != null && (a = this.b.a()) != null) {
                int h = a.h();
                if (h == p46.b) {
                    if (i == VoteCandidateCard.A) {
                        this.a = n46.d;
                        this.c = this.b.f();
                        return;
                    }
                    this.a = n46.a;
                    List<e46> b = this.b.b();
                    if (b != null && b.size() > i) {
                        this.c = b.get(i);
                    }
                } else if (h == p46.c) {
                    if (i == VoteCandidateCard.A) {
                        this.a = n46.c;
                        List<e46> b2 = this.b.b();
                        if (b2 != null && b2.size() > 0) {
                            for (e46 e46Var : b2) {
                                if (e46Var.i() == 1) {
                                    this.c = e46Var;
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.a = n46.b;
                    List<e46> b3 = this.b.b();
                    if (b3 != null && b3.size() > i) {
                        e46 e46Var2 = b3.get(i);
                        this.c = e46Var2;
                        if (e46Var2.i() == 1 && i == 0) {
                            this.a = n46.c;
                        }
                    }
                }
            }
        }
    }
}
