package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.o26;
import com.baidu.tieba.p26;
import com.baidu.tieba.q26;
import com.baidu.tieba.x26;
import com.baidu.tieba.z26;
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
    public q26 b;
    public o26 c;

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

    public void setData(int i, q26 q26Var) {
        p26 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, q26Var) == null) {
            this.b = q26Var;
            if (q26Var != null && q26Var.a() != null && (a = this.b.a()) != null) {
                int h = a.h();
                if (h == z26.b) {
                    if (i == VoteCandidateCard.A) {
                        this.a = x26.d;
                        this.c = this.b.f();
                        return;
                    }
                    this.a = x26.a;
                    List<o26> b = this.b.b();
                    if (b != null && b.size() > i) {
                        this.c = b.get(i);
                    }
                } else if (h == z26.c) {
                    if (i == VoteCandidateCard.A) {
                        this.a = x26.c;
                        List<o26> b2 = this.b.b();
                        if (b2 != null && b2.size() > 0) {
                            for (o26 o26Var : b2) {
                                if (o26Var.i() == 1) {
                                    this.c = o26Var;
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.a = x26.b;
                    List<o26> b3 = this.b.b();
                    if (b3 != null && b3.size() > i) {
                        o26 o26Var2 = b3.get(i);
                        this.c = o26Var2;
                        if (o26Var2.i() == 1 && i == 0) {
                            this.a = x26.c;
                        }
                    }
                }
            }
        }
    }
}
