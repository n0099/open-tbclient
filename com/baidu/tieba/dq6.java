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
/* loaded from: classes3.dex */
public class dq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<xn> a;
    public List<ThreadData> b;
    public Object[] c;

    public dq6() {
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

    public List<xn> a() {
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
                ThreadData threadData = this.b.get(i);
                if (threadData != null) {
                    if (i % 4 == 0) {
                        d96 d96Var = new d96();
                        d96Var.c(threadData);
                        this.a.add(d96Var);
                    } else {
                        e96 e96Var = new e96();
                        e96Var.c(threadData);
                        this.a.add(e96Var);
                    }
                }
            }
        }
    }

    public void c(int i, bq6 bq6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bq6Var) != null) || bq6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[bq6Var.b + 10];
        }
        if (!ListUtils.isEmpty(bq6Var.c)) {
            ArrayList arrayList = new ArrayList(bq6Var.c.size());
            for (ThreadData threadData : bq6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(bq6Var);
        }
        this.a.clear();
        b();
        g();
        f(bq6Var);
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

    public final void f(bq6 bq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bq6Var) == null) {
            j96 j96Var = new j96();
            j96Var.f(bq6Var.d);
            this.a.add(0, j96Var);
        }
    }

    public final void e(bq6 bq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bq6Var) == null) {
            if (!ListUtils.isEmpty(bq6Var.e)) {
                for (FeatureCardHot featureCardHot : bq6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(bq6Var.f)) {
                for (FeatureCardTopic featureCardTopic : bq6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(bq6Var.g)) {
                for (cq6 cq6Var : bq6Var.g) {
                    if (cq6Var != null && cq6Var.a()) {
                        d(cq6Var.c.intValue());
                        this.c[cq6Var.c.intValue()] = cq6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(bq6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : bq6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(bq6Var.i)) {
                for (FeatureCardGod featureCardGod : bq6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(bq6Var.j)) {
                for (FeatureCardGame featureCardGame : bq6Var.j) {
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
                            h96 h96Var = new h96();
                            h96Var.f((FeatureCardHot) obj);
                            this.a.add(i2, h96Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            k96 k96Var = new k96();
                            k96Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, k96Var);
                        } else if (obj instanceof cq6) {
                            g96 g96Var = new g96();
                            g96Var.f((cq6) obj);
                            this.a.add(i2, g96Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            f96 f96Var = new f96();
                            f96Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, f96Var);
                        } else if (obj instanceof FeatureCardGod) {
                            uj6 uj6Var = new uj6();
                            uj6Var.g((FeatureCardGod) obj);
                            this.a.add(i2, uj6Var);
                        } else if (obj instanceof FeatureCardGame) {
                            i96 i96Var = new i96();
                            i96Var.b((FeatureCardGame) obj);
                            this.a.add(i2, i96Var);
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
