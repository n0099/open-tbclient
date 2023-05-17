package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.gd6;
import com.baidu.tieba.hd6;
import com.baidu.tieba.id6;
import com.baidu.tieba.pd6;
import com.baidu.tieba.rd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class CardBasicLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public id6 b;
    public gd6 c;

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

    public void setData(int i, id6 id6Var) {
        hd6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, id6Var) == null) {
            this.b = id6Var;
            if (id6Var != null && id6Var.a() != null && (a = this.b.a()) != null) {
                int h = a.h();
                if (h == rd6.b) {
                    if (i == VoteCandidateCard.A) {
                        this.a = pd6.d;
                        this.c = this.b.f();
                        return;
                    }
                    this.a = pd6.a;
                    List<gd6> b = this.b.b();
                    if (b != null && b.size() > i) {
                        this.c = b.get(i);
                    }
                } else if (h == rd6.c) {
                    if (i == VoteCandidateCard.A) {
                        this.a = pd6.c;
                        List<gd6> b2 = this.b.b();
                        if (b2 != null && b2.size() > 0) {
                            for (gd6 gd6Var : b2) {
                                if (gd6Var.i() == 1) {
                                    this.c = gd6Var;
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.a = pd6.b;
                    List<gd6> b3 = this.b.b();
                    if (b3 != null && b3.size() > i) {
                        gd6 gd6Var2 = b3.get(i);
                        this.c = gd6Var2;
                        if (gd6Var2.i() == 1 && i == 0) {
                            this.a = pd6.c;
                        }
                    }
                }
            }
        }
    }
}
