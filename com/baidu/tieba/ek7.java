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
/* loaded from: classes5.dex */
public class ek7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<yh> a;
    public List<ThreadData> b;
    public Object[] c;

    public ek7() {
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

    public List<yh> a() {
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
                        is6 is6Var = new is6();
                        is6Var.c(threadData);
                        this.a.add(is6Var);
                    } else {
                        js6 js6Var = new js6();
                        js6Var.c(threadData);
                        this.a.add(js6Var);
                    }
                }
            }
        }
    }

    public void c(int i, ck7 ck7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, ck7Var) != null) || ck7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[ck7Var.b + 10];
        }
        if (!ListUtils.isEmpty(ck7Var.c)) {
            ArrayList arrayList = new ArrayList(ck7Var.c.size());
            for (ThreadData threadData : ck7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(ck7Var);
        }
        this.a.clear();
        b();
        g();
        f(ck7Var);
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

    public final void f(ck7 ck7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ck7Var) == null) {
            os6 os6Var = new os6();
            os6Var.d(ck7Var.d);
            this.a.add(0, os6Var);
        }
    }

    public final void e(ck7 ck7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ck7Var) == null) {
            if (!ListUtils.isEmpty(ck7Var.e)) {
                for (FeatureCardHot featureCardHot : ck7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(ck7Var.f)) {
                for (FeatureCardTopic featureCardTopic : ck7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(ck7Var.g)) {
                for (dk7 dk7Var : ck7Var.g) {
                    if (dk7Var != null && dk7Var.a()) {
                        d(dk7Var.c.intValue());
                        this.c[dk7Var.c.intValue()] = dk7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(ck7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : ck7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(ck7Var.i)) {
                for (FeatureCardGod featureCardGod : ck7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(ck7Var.j)) {
                for (FeatureCardGame featureCardGame : ck7Var.j) {
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
                            ms6 ms6Var = new ms6();
                            ms6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, ms6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            ps6 ps6Var = new ps6();
                            ps6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, ps6Var);
                        } else if (obj instanceof dk7) {
                            ls6 ls6Var = new ls6();
                            ls6Var.d((dk7) obj);
                            this.a.add(i2, ls6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            ks6 ks6Var = new ks6();
                            ks6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, ks6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            ld7 ld7Var = new ld7();
                            ld7Var.e((FeatureCardGod) obj);
                            this.a.add(i2, ld7Var);
                        } else if (obj instanceof FeatureCardGame) {
                            ns6 ns6Var = new ns6();
                            ns6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, ns6Var);
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
