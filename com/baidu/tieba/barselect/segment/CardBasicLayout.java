package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.li6;
import com.baidu.tieba.mi6;
import com.baidu.tieba.ni6;
import com.baidu.tieba.ui6;
import com.baidu.tieba.wi6;
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
    public ni6 b;
    public li6 c;

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

    public void setData(int i, ni6 ni6Var) {
        mi6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, ni6Var) == null) {
            this.b = ni6Var;
            if (ni6Var != null && ni6Var.a() != null && (a = this.b.a()) != null) {
                int h = a.h();
                if (h == wi6.b) {
                    if (i == VoteCandidateCard.A) {
                        this.a = ui6.d;
                        this.c = this.b.f();
                        return;
                    }
                    this.a = ui6.a;
                    List<li6> b = this.b.b();
                    if (b != null && b.size() > i) {
                        this.c = b.get(i);
                    }
                } else if (h == wi6.c) {
                    if (i == VoteCandidateCard.A) {
                        this.a = ui6.c;
                        List<li6> b2 = this.b.b();
                        if (b2 != null && b2.size() > 0) {
                            for (li6 li6Var : b2) {
                                if (li6Var.i() == 1) {
                                    this.c = li6Var;
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.a = ui6.b;
                    List<li6> b3 = this.b.b();
                    if (b3 != null && b3.size() > i) {
                        li6 li6Var2 = b3.get(i);
                        this.c = li6Var2;
                        if (li6Var2.i() == 1 && i == 0) {
                            this.a = ui6.c;
                        }
                    }
                }
            }
        }
    }
}
