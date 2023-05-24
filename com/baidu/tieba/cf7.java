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
public class cf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<rn> a;
    public List<ThreadData> b;
    public Object[] c;

    public cf7() {
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

    public List<rn> a() {
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
                        uq6 uq6Var = new uq6();
                        uq6Var.c(threadData);
                        this.a.add(uq6Var);
                    } else {
                        vq6 vq6Var = new vq6();
                        vq6Var.c(threadData);
                        this.a.add(vq6Var);
                    }
                }
            }
        }
    }

    public void c(int i, af7 af7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, af7Var) != null) || af7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[af7Var.b + 10];
        }
        if (!ListUtils.isEmpty(af7Var.c)) {
            ArrayList arrayList = new ArrayList(af7Var.c.size());
            for (ThreadData threadData : af7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(af7Var);
        }
        this.a.clear();
        b();
        g();
        f(af7Var);
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

    public final void f(af7 af7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, af7Var) == null) {
            ar6 ar6Var = new ar6();
            ar6Var.d(af7Var.d);
            this.a.add(0, ar6Var);
        }
    }

    public final void e(af7 af7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, af7Var) == null) {
            if (!ListUtils.isEmpty(af7Var.e)) {
                for (FeatureCardHot featureCardHot : af7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(af7Var.f)) {
                for (FeatureCardTopic featureCardTopic : af7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(af7Var.g)) {
                for (bf7 bf7Var : af7Var.g) {
                    if (bf7Var != null && bf7Var.a()) {
                        d(bf7Var.c.intValue());
                        this.c[bf7Var.c.intValue()] = bf7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(af7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : af7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(af7Var.i)) {
                for (FeatureCardGod featureCardGod : af7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(af7Var.j)) {
                for (FeatureCardGame featureCardGame : af7Var.j) {
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
                            yq6 yq6Var = new yq6();
                            yq6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, yq6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            br6 br6Var = new br6();
                            br6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, br6Var);
                        } else if (obj instanceof bf7) {
                            xq6 xq6Var = new xq6();
                            xq6Var.d((bf7) obj);
                            this.a.add(i2, xq6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            wq6 wq6Var = new wq6();
                            wq6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, wq6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            q87 q87Var = new q87();
                            q87Var.e((FeatureCardGod) obj);
                            this.a.add(i2, q87Var);
                        } else if (obj instanceof FeatureCardGame) {
                            zq6 zq6Var = new zq6();
                            zq6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, zq6Var);
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
