package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gw5;
import com.repackage.iw5;
import com.repackage.xv5;
import com.repackage.yv5;
import com.repackage.zv5;
import java.util.List;
/* loaded from: classes3.dex */
public class CardBasicLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public zv5 b;
    public xv5 c;

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

    public void setData(int i, zv5 zv5Var) {
        yv5 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, zv5Var) == null) {
            this.b = zv5Var;
            if (zv5Var == null || zv5Var.a() == null || (a = this.b.a()) == null) {
                return;
            }
            int g = a.g();
            if (g == iw5.b) {
                if (i == VoteCandidateCard.A) {
                    this.a = gw5.d;
                    this.c = this.b.f();
                    return;
                }
                this.a = gw5.a;
                List<xv5> b = this.b.b();
                if (b == null || b.size() <= i) {
                    return;
                }
                this.c = b.get(i);
            } else if (g == iw5.c) {
                if (i == VoteCandidateCard.A) {
                    this.a = gw5.c;
                    List<xv5> b2 = this.b.b();
                    if (b2 == null || b2.size() <= 0) {
                        return;
                    }
                    for (xv5 xv5Var : b2) {
                        if (xv5Var.i() == 1) {
                            this.c = xv5Var;
                            return;
                        }
                    }
                    return;
                }
                this.a = gw5.b;
                List<xv5> b3 = this.b.b();
                if (b3 == null || b3.size() <= i) {
                    return;
                }
                xv5 xv5Var2 = b3.get(i);
                this.c = xv5Var2;
                if (xv5Var2.i() == 1 && i == 0) {
                    this.a = gw5.c;
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
