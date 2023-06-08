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
public class hk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<vn> a;
    public List<ThreadData> b;
    public Object[] c;

    public hk7() {
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

    public List<vn> a() {
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
                        hv6 hv6Var = new hv6();
                        hv6Var.c(threadData);
                        this.a.add(hv6Var);
                    } else {
                        iv6 iv6Var = new iv6();
                        iv6Var.c(threadData);
                        this.a.add(iv6Var);
                    }
                }
            }
        }
    }

    public void c(int i, fk7 fk7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, fk7Var) != null) || fk7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[fk7Var.b + 10];
        }
        if (!ListUtils.isEmpty(fk7Var.c)) {
            ArrayList arrayList = new ArrayList(fk7Var.c.size());
            for (ThreadData threadData : fk7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(fk7Var);
        }
        this.a.clear();
        b();
        g();
        f(fk7Var);
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

    public final void f(fk7 fk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fk7Var) == null) {
            nv6 nv6Var = new nv6();
            nv6Var.d(fk7Var.d);
            this.a.add(0, nv6Var);
        }
    }

    public final void e(fk7 fk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fk7Var) == null) {
            if (!ListUtils.isEmpty(fk7Var.e)) {
                for (FeatureCardHot featureCardHot : fk7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(fk7Var.f)) {
                for (FeatureCardTopic featureCardTopic : fk7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(fk7Var.g)) {
                for (gk7 gk7Var : fk7Var.g) {
                    if (gk7Var != null && gk7Var.a()) {
                        d(gk7Var.c.intValue());
                        this.c[gk7Var.c.intValue()] = gk7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(fk7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : fk7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(fk7Var.i)) {
                for (FeatureCardGod featureCardGod : fk7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(fk7Var.j)) {
                for (FeatureCardGame featureCardGame : fk7Var.j) {
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
                            lv6 lv6Var = new lv6();
                            lv6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, lv6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            ov6 ov6Var = new ov6();
                            ov6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, ov6Var);
                        } else if (obj instanceof gk7) {
                            kv6 kv6Var = new kv6();
                            kv6Var.d((gk7) obj);
                            this.a.add(i2, kv6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            jv6 jv6Var = new jv6();
                            jv6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, jv6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            vd7 vd7Var = new vd7();
                            vd7Var.e((FeatureCardGod) obj);
                            this.a.add(i2, vd7Var);
                        } else if (obj instanceof FeatureCardGame) {
                            mv6 mv6Var = new mv6();
                            mv6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, mv6Var);
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
