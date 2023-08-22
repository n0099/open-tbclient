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
public class co7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<bn> a;
    public List<ThreadData> b;
    public Object[] c;

    public co7() {
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

    public List<bn> a() {
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
                        pw6 pw6Var = new pw6();
                        pw6Var.c(threadData);
                        this.a.add(pw6Var);
                    } else {
                        qw6 qw6Var = new qw6();
                        qw6Var.c(threadData);
                        this.a.add(qw6Var);
                    }
                }
            }
        }
    }

    public void c(int i, ao7 ao7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, ao7Var) != null) || ao7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[ao7Var.b + 10];
        }
        if (!ListUtils.isEmpty(ao7Var.c)) {
            ArrayList arrayList = new ArrayList(ao7Var.c.size());
            for (ThreadData threadData : ao7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(ao7Var);
        }
        this.a.clear();
        b();
        g();
        f(ao7Var);
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

    public final void f(ao7 ao7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ao7Var) == null) {
            vw6 vw6Var = new vw6();
            vw6Var.d(ao7Var.d);
            this.a.add(0, vw6Var);
        }
    }

    public final void e(ao7 ao7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ao7Var) == null) {
            if (!ListUtils.isEmpty(ao7Var.e)) {
                for (FeatureCardHot featureCardHot : ao7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(ao7Var.f)) {
                for (FeatureCardTopic featureCardTopic : ao7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(ao7Var.g)) {
                for (bo7 bo7Var : ao7Var.g) {
                    if (bo7Var != null && bo7Var.a()) {
                        d(bo7Var.c.intValue());
                        this.c[bo7Var.c.intValue()] = bo7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(ao7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : ao7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(ao7Var.i)) {
                for (FeatureCardGod featureCardGod : ao7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(ao7Var.j)) {
                for (FeatureCardGame featureCardGame : ao7Var.j) {
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
                            tw6 tw6Var = new tw6();
                            tw6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, tw6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            ww6 ww6Var = new ww6();
                            ww6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, ww6Var);
                        } else if (obj instanceof bo7) {
                            sw6 sw6Var = new sw6();
                            sw6Var.d((bo7) obj);
                            this.a.add(i2, sw6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            rw6 rw6Var = new rw6();
                            rw6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, rw6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            lh7 lh7Var = new lh7();
                            lh7Var.e((FeatureCardGod) obj);
                            this.a.add(i2, lh7Var);
                        } else if (obj instanceof FeatureCardGame) {
                            uw6 uw6Var = new uw6();
                            uw6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, uw6Var);
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
