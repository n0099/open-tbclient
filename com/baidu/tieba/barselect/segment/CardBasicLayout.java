package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.a36;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.p26;
import com.baidu.tieba.q26;
import com.baidu.tieba.r26;
import com.baidu.tieba.y26;
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
    public r26 b;
    public p26 c;

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

    public void setData(int i, r26 r26Var) {
        q26 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, r26Var) == null) {
            this.b = r26Var;
            if (r26Var != null && r26Var.a() != null && (a = this.b.a()) != null) {
                int h = a.h();
                if (h == a36.b) {
                    if (i == VoteCandidateCard.A) {
                        this.a = y26.d;
                        this.c = this.b.f();
                        return;
                    }
                    this.a = y26.a;
                    List<p26> b = this.b.b();
                    if (b != null && b.size() > i) {
                        this.c = b.get(i);
                    }
                } else if (h == a36.c) {
                    if (i == VoteCandidateCard.A) {
                        this.a = y26.c;
                        List<p26> b2 = this.b.b();
                        if (b2 != null && b2.size() > 0) {
                            for (p26 p26Var : b2) {
                                if (p26Var.i() == 1) {
                                    this.c = p26Var;
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.a = y26.b;
                    List<p26> b3 = this.b.b();
                    if (b3 != null && b3.size() > i) {
                        p26 p26Var2 = b3.get(i);
                        this.c = p26Var2;
                        if (p26Var2.i() == 1 && i == 0) {
                            this.a = y26.c;
                        }
                    }
                }
            }
        }
    }
}
