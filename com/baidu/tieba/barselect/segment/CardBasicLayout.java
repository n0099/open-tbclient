package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.hg6;
import com.baidu.tieba.ig6;
import com.baidu.tieba.jg6;
import com.baidu.tieba.qg6;
import com.baidu.tieba.sg6;
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
    public jg6 b;
    public hg6 c;

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

    public void setData(int i, jg6 jg6Var) {
        ig6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jg6Var) == null) {
            this.b = jg6Var;
            if (jg6Var != null && jg6Var.a() != null && (a = this.b.a()) != null) {
                int h = a.h();
                if (h == sg6.b) {
                    if (i == VoteCandidateCard.A) {
                        this.a = qg6.d;
                        this.c = this.b.f();
                        return;
                    }
                    this.a = qg6.a;
                    List<hg6> b = this.b.b();
                    if (b != null && b.size() > i) {
                        this.c = b.get(i);
                    }
                } else if (h == sg6.c) {
                    if (i == VoteCandidateCard.A) {
                        this.a = qg6.c;
                        List<hg6> b2 = this.b.b();
                        if (b2 != null && b2.size() > 0) {
                            for (hg6 hg6Var : b2) {
                                if (hg6Var.i() == 1) {
                                    this.c = hg6Var;
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.a = qg6.b;
                    List<hg6> b3 = this.b.b();
                    if (b3 != null && b3.size() > i) {
                        hg6 hg6Var2 = b3.get(i);
                        this.c = hg6Var2;
                        if (hg6Var2.i() == 1 && i == 0) {
                            this.a = qg6.c;
                        }
                    }
                }
            }
        }
    }
}
