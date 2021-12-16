package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import c.a.s0.c0.b.d;
import c.a.s0.c0.b.e;
import c.a.s0.c0.b.f;
import c.a.s0.c0.e.a;
import c.a.s0.c0.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.List;
/* loaded from: classes11.dex */
public class CardBasicLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f mData;
    public d mElectionData;
    public int status;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardBasicLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public String numDeal(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 >= 100000) {
                String format = new DecimalFormat(".0").format(Float.valueOf(i2 / 10000.0f));
                return format + "W";
            }
            return i2 + "";
        }
        return (String) invokeI.objValue;
    }

    public void setData(int i2, f fVar) {
        e a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, fVar) == null) {
            this.mData = fVar;
            if (fVar == null || fVar.a() == null || (a = this.mData.a()) == null) {
                return;
            }
            int g2 = a.g();
            if (g2 == c.f15382b) {
                if (i2 == VoteCandidateCard.MINE_VOTE) {
                    this.status = a.f15381d;
                    this.mElectionData = this.mData.f();
                    return;
                }
                this.status = a.a;
                List<d> b2 = this.mData.b();
                if (b2 == null || b2.size() <= i2) {
                    return;
                }
                this.mElectionData = b2.get(i2);
            } else if (g2 == c.f15383c) {
                if (i2 == VoteCandidateCard.MINE_VOTE) {
                    this.status = a.f15380c;
                    List<d> b3 = this.mData.b();
                    if (b3 == null || b3.size() <= 0) {
                        return;
                    }
                    for (d dVar : b3) {
                        if (dVar.i() == 1) {
                            this.mElectionData = dVar;
                            return;
                        }
                    }
                    return;
                }
                this.status = a.f15379b;
                List<d> b4 = this.mData.b();
                if (b4 == null || b4.size() <= i2) {
                    return;
                }
                d dVar2 = b4.get(i2);
                this.mElectionData = dVar2;
                if (dVar2.i() == 1 && i2 == 0) {
                    this.status = a.f15380c;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.status = -1;
    }
}
