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
public class cq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<xn> a;
    public List<ThreadData> b;
    public Object[] c;

    public cq6() {
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
                        c96 c96Var = new c96();
                        c96Var.c(threadData);
                        this.a.add(c96Var);
                    } else {
                        d96 d96Var = new d96();
                        d96Var.c(threadData);
                        this.a.add(d96Var);
                    }
                }
            }
        }
    }

    public void c(int i, aq6 aq6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, aq6Var) != null) || aq6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[aq6Var.b + 10];
        }
        if (!ListUtils.isEmpty(aq6Var.c)) {
            ArrayList arrayList = new ArrayList(aq6Var.c.size());
            for (ThreadData threadData : aq6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(aq6Var);
        }
        this.a.clear();
        b();
        g();
        f(aq6Var);
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

    public final void f(aq6 aq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aq6Var) == null) {
            i96 i96Var = new i96();
            i96Var.f(aq6Var.d);
            this.a.add(0, i96Var);
        }
    }

    public final void e(aq6 aq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aq6Var) == null) {
            if (!ListUtils.isEmpty(aq6Var.e)) {
                for (FeatureCardHot featureCardHot : aq6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(aq6Var.f)) {
                for (FeatureCardTopic featureCardTopic : aq6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(aq6Var.g)) {
                for (bq6 bq6Var : aq6Var.g) {
                    if (bq6Var != null && bq6Var.a()) {
                        d(bq6Var.c.intValue());
                        this.c[bq6Var.c.intValue()] = bq6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(aq6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : aq6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(aq6Var.i)) {
                for (FeatureCardGod featureCardGod : aq6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(aq6Var.j)) {
                for (FeatureCardGame featureCardGame : aq6Var.j) {
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
                            g96 g96Var = new g96();
                            g96Var.f((FeatureCardHot) obj);
                            this.a.add(i2, g96Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            j96 j96Var = new j96();
                            j96Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, j96Var);
                        } else if (obj instanceof bq6) {
                            f96 f96Var = new f96();
                            f96Var.f((bq6) obj);
                            this.a.add(i2, f96Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            e96 e96Var = new e96();
                            e96Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, e96Var);
                        } else if (obj instanceof FeatureCardGod) {
                            tj6 tj6Var = new tj6();
                            tj6Var.g((FeatureCardGod) obj);
                            this.a.add(i2, tj6Var);
                        } else if (obj instanceof FeatureCardGame) {
                            h96 h96Var = new h96();
                            h96Var.b((FeatureCardGame) obj);
                            this.a.add(i2, h96Var);
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
