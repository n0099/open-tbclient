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
public class fk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<vn> a;
    public List<ThreadData> b;
    public Object[] c;

    public fk7() {
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
                        fv6 fv6Var = new fv6();
                        fv6Var.c(threadData);
                        this.a.add(fv6Var);
                    } else {
                        gv6 gv6Var = new gv6();
                        gv6Var.c(threadData);
                        this.a.add(gv6Var);
                    }
                }
            }
        }
    }

    public void c(int i, dk7 dk7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, dk7Var) != null) || dk7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[dk7Var.b + 10];
        }
        if (!ListUtils.isEmpty(dk7Var.c)) {
            ArrayList arrayList = new ArrayList(dk7Var.c.size());
            for (ThreadData threadData : dk7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(dk7Var);
        }
        this.a.clear();
        b();
        g();
        f(dk7Var);
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

    public final void f(dk7 dk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dk7Var) == null) {
            lv6 lv6Var = new lv6();
            lv6Var.d(dk7Var.d);
            this.a.add(0, lv6Var);
        }
    }

    public final void e(dk7 dk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dk7Var) == null) {
            if (!ListUtils.isEmpty(dk7Var.e)) {
                for (FeatureCardHot featureCardHot : dk7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(dk7Var.f)) {
                for (FeatureCardTopic featureCardTopic : dk7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(dk7Var.g)) {
                for (ek7 ek7Var : dk7Var.g) {
                    if (ek7Var != null && ek7Var.a()) {
                        d(ek7Var.c.intValue());
                        this.c[ek7Var.c.intValue()] = ek7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(dk7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : dk7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(dk7Var.i)) {
                for (FeatureCardGod featureCardGod : dk7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(dk7Var.j)) {
                for (FeatureCardGame featureCardGame : dk7Var.j) {
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
                            jv6 jv6Var = new jv6();
                            jv6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, jv6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            mv6 mv6Var = new mv6();
                            mv6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, mv6Var);
                        } else if (obj instanceof ek7) {
                            iv6 iv6Var = new iv6();
                            iv6Var.d((ek7) obj);
                            this.a.add(i2, iv6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            hv6 hv6Var = new hv6();
                            hv6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, hv6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            td7 td7Var = new td7();
                            td7Var.e((FeatureCardGod) obj);
                            this.a.add(i2, td7Var);
                        } else if (obj instanceof FeatureCardGame) {
                            kv6 kv6Var = new kv6();
                            kv6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, kv6Var);
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
