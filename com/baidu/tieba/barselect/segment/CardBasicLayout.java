package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.b96;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.q86;
import com.baidu.tieba.r86;
import com.baidu.tieba.s86;
import com.baidu.tieba.z86;
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
    public s86 b;
    public q86 c;

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

    public void setData(int i, s86 s86Var) {
        r86 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, s86Var) == null) {
            this.b = s86Var;
            if (s86Var != null && s86Var.a() != null && (a = this.b.a()) != null) {
                int h = a.h();
                if (h == b96.b) {
                    if (i == VoteCandidateCard.A) {
                        this.a = z86.d;
                        this.c = this.b.f();
                        return;
                    }
                    this.a = z86.a;
                    List<q86> b = this.b.b();
                    if (b != null && b.size() > i) {
                        this.c = b.get(i);
                    }
                } else if (h == b96.c) {
                    if (i == VoteCandidateCard.A) {
                        this.a = z86.c;
                        List<q86> b2 = this.b.b();
                        if (b2 != null && b2.size() > 0) {
                            for (q86 q86Var : b2) {
                                if (q86Var.i() == 1) {
                                    this.c = q86Var;
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.a = z86.b;
                    List<q86> b3 = this.b.b();
                    if (b3 != null && b3.size() > i) {
                        q86 q86Var2 = b3.get(i);
                        this.c = q86Var2;
                        if (q86Var2.i() == 1 && i == 0) {
                            this.a = z86.c;
                        }
                    }
                }
            }
        }
    }
}
