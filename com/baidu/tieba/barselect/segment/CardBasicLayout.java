package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.dc6;
import com.baidu.tieba.fc6;
import com.baidu.tieba.ub6;
import com.baidu.tieba.vb6;
import com.baidu.tieba.wb6;
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
    public wb6 b;
    public ub6 c;

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

    public void setData(int i, wb6 wb6Var) {
        vb6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, wb6Var) == null) {
            this.b = wb6Var;
            if (wb6Var != null && wb6Var.a() != null && (a = this.b.a()) != null) {
                int h = a.h();
                if (h == fc6.b) {
                    if (i == VoteCandidateCard.A) {
                        this.a = dc6.d;
                        this.c = this.b.f();
                        return;
                    }
                    this.a = dc6.a;
                    List<ub6> b = this.b.b();
                    if (b != null && b.size() > i) {
                        this.c = b.get(i);
                    }
                } else if (h == fc6.c) {
                    if (i == VoteCandidateCard.A) {
                        this.a = dc6.c;
                        List<ub6> b2 = this.b.b();
                        if (b2 != null && b2.size() > 0) {
                            for (ub6 ub6Var : b2) {
                                if (ub6Var.i() == 1) {
                                    this.c = ub6Var;
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.a = dc6.b;
                    List<ub6> b3 = this.b.b();
                    if (b3 != null && b3.size() > i) {
                        ub6 ub6Var2 = b3.get(i);
                        this.c = ub6Var2;
                        if (ub6Var2.i() == 1 && i == 0) {
                            this.a = dc6.c;
                        }
                    }
                }
            }
        }
    }
}
