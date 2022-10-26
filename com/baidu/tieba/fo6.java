package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class fo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List a;
    public List b;
    public Object[] c;

    public fo6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public List a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < this.b.size(); i++) {
                ThreadData threadData = (ThreadData) this.b.get(i);
                if (threadData != null) {
                    if (i % 4 == 0) {
                        g76 g76Var = new g76();
                        g76Var.c(threadData);
                        this.a.add(g76Var);
                    } else {
                        h76 h76Var = new h76();
                        h76Var.c(threadData);
                        this.a.add(h76Var);
                    }
                }
            }
        }
    }

    public void c(int i, do6 do6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, do6Var) != null) || do6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[do6Var.b + 10];
        }
        if (!ListUtils.isEmpty(do6Var.c)) {
            ArrayList arrayList = new ArrayList(do6Var.c.size());
            for (ThreadData threadData : do6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(do6Var);
        }
        this.a.clear();
        b();
        g();
        f(do6Var);
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            Object[] objArr = this.c;
            if (i >= objArr.length) {
                this.c = Arrays.copyOf(objArr, i + 1);
            }
        }
    }

    public final void f(do6 do6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, do6Var) == null) {
            m76 m76Var = new m76();
            m76Var.f(do6Var.d);
            this.a.add(0, m76Var);
        }
    }

    public final void e(do6 do6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, do6Var) == null) {
            if (!ListUtils.isEmpty(do6Var.e)) {
                for (FeatureCardHot featureCardHot : do6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(do6Var.f)) {
                for (FeatureCardTopic featureCardTopic : do6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(do6Var.g)) {
                for (eo6 eo6Var : do6Var.g) {
                    if (eo6Var != null && eo6Var.a()) {
                        d(eo6Var.c.intValue());
                        this.c[eo6Var.c.intValue()] = eo6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(do6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : do6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(do6Var.i)) {
                for (FeatureCardGod featureCardGod : do6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(do6Var.j)) {
                for (FeatureCardGame featureCardGame : do6Var.j) {
                    if (featureCardGame != null && featureCardGame.isValid()) {
                        d(featureCardGame.floor.intValue());
                        this.c[featureCardGame.floor.intValue()] = featureCardGame;
                    }
                }
            }
        }
    }

    public final void g() {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (objArr = this.c) != null && objArr.length > 0) {
            int i = 0;
            while (true) {
                Object[] objArr2 = this.c;
                if (i < objArr2.length) {
                    Object obj = objArr2[i];
                    if (obj != null) {
                        int i2 = i - 1;
                        if (i2 < 0) {
                            i2 = 0;
                        } else if (i2 >= this.a.size()) {
                            i2 = this.a.size();
                        }
                        if (obj instanceof FeatureCardHot) {
                            k76 k76Var = new k76();
                            k76Var.f((FeatureCardHot) obj);
                            this.a.add(i2, k76Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            n76 n76Var = new n76();
                            n76Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, n76Var);
                        } else if (obj instanceof eo6) {
                            j76 j76Var = new j76();
                            j76Var.f((eo6) obj);
                            this.a.add(i2, j76Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            i76 i76Var = new i76();
                            i76Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, i76Var);
                        } else if (obj instanceof FeatureCardGod) {
                            xh6 xh6Var = new xh6();
                            xh6Var.g((FeatureCardGod) obj);
                            this.a.add(i2, xh6Var);
                        } else if (obj instanceof FeatureCardGame) {
                            l76 l76Var = new l76();
                            l76Var.b((FeatureCardGame) obj);
                            this.a.add(i2, l76Var);
                        }
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
