package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.relatelist.RelateRecThreadListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.RelateRecThread.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class ho8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<gn> a;
    public final RelateRecThreadListModel b;
    public om8 c;
    public PbModel d;
    public boolean e;
    public List<gn> f;
    public final ru4 g;

    /* loaded from: classes4.dex */
    public class a implements ru4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ho8 a;

        public a(ho8 ho8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ho8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ho8Var;
        }

        @Override // com.baidu.tieba.ru4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.c != null && this.a.c.f1() != null) {
                this.a.c.f1().P();
            }
        }

        @Override // com.baidu.tieba.ru4
        public void onSuccess(Object obj) {
            String str;
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.a.d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    ki8 w1 = this.a.d.w1();
                    if (w1.l() != null) {
                        str = w1.l().getFirst_class();
                    } else {
                        str = "";
                    }
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.a.c != null && this.a.c.f1() != null) {
                            this.a.c.f1().x(w1.t());
                            this.a.c.f1().P();
                            if (w1.t()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem.param("fid", w1.m());
                                statisticItem.param("fname", w1.n());
                                statisticItem.param("tid", w1.S());
                                TiebaStatic.log(statisticItem);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    List<gn> b = io8.b(list, str, this.a.d.v1());
                    this.a.a.addAll(b);
                    w1.S0(this.a.a);
                    this.a.f.addAll(b);
                    Integer num = dataRes.rec_type;
                    if (num == null) {
                        intValue = 0;
                    } else {
                        intValue = num.intValue();
                    }
                    w1.P0(intValue);
                }
                if (this.a.c != null && !ListUtils.isEmpty(this.a.a)) {
                    this.a.c.X3();
                }
                if (this.a.c.f1() != null && this.a.c.f1().p() && !ListUtils.isEmpty(this.a.a)) {
                    this.a.c.f1().m();
                }
            }
        }
    }

    public ho8(wp8 wp8Var, BdUniqueId bdUniqueId, om8 om8Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wp8Var, bdUniqueId, om8Var, pbModel};
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
        this.f = new ArrayList();
        this.g = new a(this);
        this.c = om8Var;
        this.d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(wp8Var.getPageContext(), bdUniqueId);
        this.b = relateRecThreadListModel;
        relateRecThreadListModel.Y(this.g);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.Q1()) || this.d.w1() == null) {
                return false;
            }
            if (this.e) {
                return true;
            }
            if (this.d.w1().e0()) {
                return false;
            }
            String forumId = this.d.getForumId();
            if (TextUtils.isEmpty(forumId) && this.d.w1().l() != null) {
                forumId = this.d.w1().l().getId();
            }
            long g = gg.g(forumId, 0L);
            long g2 = gg.g(this.d.Q1(), 0L);
            int L1 = this.d.L1();
            String K1 = this.d.K1();
            if (!this.e) {
                this.e = true;
            }
            return this.b.X(g, g2, 1, L1, K1);
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.clear();
            this.b.onDestroy();
        }
    }

    public void f(om8 om8Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, om8Var, pbModel) == null) {
            this.c = om8Var;
            this.d = pbModel;
        }
    }
}
