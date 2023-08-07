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
/* loaded from: classes6.dex */
public class gm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ym> a;
    public List<ThreadData> b;
    public Object[] c;

    public gm7() {
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

    public List<ym> a() {
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
                        dv6 dv6Var = new dv6();
                        dv6Var.c(threadData);
                        this.a.add(dv6Var);
                    } else {
                        ev6 ev6Var = new ev6();
                        ev6Var.c(threadData);
                        this.a.add(ev6Var);
                    }
                }
            }
        }
    }

    public void c(int i, em7 em7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, em7Var) != null) || em7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[em7Var.b + 10];
        }
        if (!ListUtils.isEmpty(em7Var.c)) {
            ArrayList arrayList = new ArrayList(em7Var.c.size());
            for (ThreadData threadData : em7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(em7Var);
        }
        this.a.clear();
        b();
        g();
        f(em7Var);
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

    public final void f(em7 em7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, em7Var) == null) {
            jv6 jv6Var = new jv6();
            jv6Var.d(em7Var.d);
            this.a.add(0, jv6Var);
        }
    }

    public final void e(em7 em7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, em7Var) == null) {
            if (!ListUtils.isEmpty(em7Var.e)) {
                for (FeatureCardHot featureCardHot : em7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(em7Var.f)) {
                for (FeatureCardTopic featureCardTopic : em7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(em7Var.g)) {
                for (fm7 fm7Var : em7Var.g) {
                    if (fm7Var != null && fm7Var.a()) {
                        d(fm7Var.c.intValue());
                        this.c[fm7Var.c.intValue()] = fm7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(em7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : em7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(em7Var.i)) {
                for (FeatureCardGod featureCardGod : em7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(em7Var.j)) {
                for (FeatureCardGame featureCardGame : em7Var.j) {
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
                            hv6 hv6Var = new hv6();
                            hv6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, hv6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            kv6 kv6Var = new kv6();
                            kv6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, kv6Var);
                        } else if (obj instanceof fm7) {
                            gv6 gv6Var = new gv6();
                            gv6Var.d((fm7) obj);
                            this.a.add(i2, gv6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            fv6 fv6Var = new fv6();
                            fv6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, fv6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            tf7 tf7Var = new tf7();
                            tf7Var.e((FeatureCardGod) obj);
                            this.a.add(i2, tf7Var);
                        } else if (obj instanceof FeatureCardGame) {
                            iv6 iv6Var = new iv6();
                            iv6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, iv6Var);
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
