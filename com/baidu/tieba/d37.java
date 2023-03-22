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
public class d37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<gn> a;
    public List<ThreadData> b;
    public Object[] c;

    public d37() {
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

    public List<gn> a() {
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
                        lk6 lk6Var = new lk6();
                        lk6Var.c(threadData);
                        this.a.add(lk6Var);
                    } else {
                        mk6 mk6Var = new mk6();
                        mk6Var.c(threadData);
                        this.a.add(mk6Var);
                    }
                }
            }
        }
    }

    public void c(int i, b37 b37Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, b37Var) != null) || b37Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[b37Var.b + 10];
        }
        if (!ListUtils.isEmpty(b37Var.c)) {
            ArrayList arrayList = new ArrayList(b37Var.c.size());
            for (ThreadData threadData : b37Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(b37Var);
        }
        this.a.clear();
        b();
        g();
        f(b37Var);
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

    public final void f(b37 b37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, b37Var) == null) {
            rk6 rk6Var = new rk6();
            rk6Var.f(b37Var.d);
            this.a.add(0, rk6Var);
        }
    }

    public final void e(b37 b37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b37Var) == null) {
            if (!ListUtils.isEmpty(b37Var.e)) {
                for (FeatureCardHot featureCardHot : b37Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(b37Var.f)) {
                for (FeatureCardTopic featureCardTopic : b37Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(b37Var.g)) {
                for (c37 c37Var : b37Var.g) {
                    if (c37Var != null && c37Var.a()) {
                        d(c37Var.c.intValue());
                        this.c[c37Var.c.intValue()] = c37Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(b37Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : b37Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(b37Var.i)) {
                for (FeatureCardGod featureCardGod : b37Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(b37Var.j)) {
                for (FeatureCardGame featureCardGame : b37Var.j) {
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
                            pk6 pk6Var = new pk6();
                            pk6Var.f((FeatureCardHot) obj);
                            this.a.add(i2, pk6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            sk6 sk6Var = new sk6();
                            sk6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, sk6Var);
                        } else if (obj instanceof c37) {
                            ok6 ok6Var = new ok6();
                            ok6Var.f((c37) obj);
                            this.a.add(i2, ok6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            nk6 nk6Var = new nk6();
                            nk6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, nk6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            rw6 rw6Var = new rw6();
                            rw6Var.g((FeatureCardGod) obj);
                            this.a.add(i2, rw6Var);
                        } else if (obj instanceof FeatureCardGame) {
                            qk6 qk6Var = new qk6();
                            qk6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, qk6Var);
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
