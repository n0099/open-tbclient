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
public class hm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ym> a;
    public List<ThreadData> b;
    public Object[] c;

    public hm7() {
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
                        ev6 ev6Var = new ev6();
                        ev6Var.c(threadData);
                        this.a.add(ev6Var);
                    } else {
                        fv6 fv6Var = new fv6();
                        fv6Var.c(threadData);
                        this.a.add(fv6Var);
                    }
                }
            }
        }
    }

    public void c(int i, fm7 fm7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, fm7Var) != null) || fm7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[fm7Var.b + 10];
        }
        if (!ListUtils.isEmpty(fm7Var.c)) {
            ArrayList arrayList = new ArrayList(fm7Var.c.size());
            for (ThreadData threadData : fm7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(fm7Var);
        }
        this.a.clear();
        b();
        g();
        f(fm7Var);
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

    public final void f(fm7 fm7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fm7Var) == null) {
            kv6 kv6Var = new kv6();
            kv6Var.d(fm7Var.d);
            this.a.add(0, kv6Var);
        }
    }

    public final void e(fm7 fm7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fm7Var) == null) {
            if (!ListUtils.isEmpty(fm7Var.e)) {
                for (FeatureCardHot featureCardHot : fm7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(fm7Var.f)) {
                for (FeatureCardTopic featureCardTopic : fm7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(fm7Var.g)) {
                for (gm7 gm7Var : fm7Var.g) {
                    if (gm7Var != null && gm7Var.a()) {
                        d(gm7Var.c.intValue());
                        this.c[gm7Var.c.intValue()] = gm7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(fm7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : fm7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(fm7Var.i)) {
                for (FeatureCardGod featureCardGod : fm7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(fm7Var.j)) {
                for (FeatureCardGame featureCardGame : fm7Var.j) {
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
                            iv6 iv6Var = new iv6();
                            iv6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, iv6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            lv6 lv6Var = new lv6();
                            lv6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, lv6Var);
                        } else if (obj instanceof gm7) {
                            hv6 hv6Var = new hv6();
                            hv6Var.d((gm7) obj);
                            this.a.add(i2, hv6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            gv6 gv6Var = new gv6();
                            gv6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, gv6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            uf7 uf7Var = new uf7();
                            uf7Var.e((FeatureCardGod) obj);
                            this.a.add(i2, uf7Var);
                        } else if (obj instanceof FeatureCardGame) {
                            jv6 jv6Var = new jv6();
                            jv6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, jv6Var);
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
