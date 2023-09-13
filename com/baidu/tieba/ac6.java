package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class ac6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bc6 a;
    public cc6 b;
    public gc6 c;
    public fc6 d;
    public dc6 e;
    public ec6 f;
    public List<pm> g;

    /* loaded from: classes5.dex */
    public class a implements uc6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ String b;

        public a(ac6 ac6Var, TbPageContext tbPageContext, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac6Var, tbPageContext, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = str;
        }

        @Override // com.baidu.tieba.uc6
        public void a(ib6 ib6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ib6Var) == null) && ib6Var != null && ib6Var.getThreadData() != null) {
                if (ib6Var.getThreadData().getThreadAlaInfo() != null && ib6Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    AlaInfoData threadAlaInfo = ib6Var.getThreadData().getThreadAlaInfo();
                    TbPageContext tbPageContext = this.a;
                    YyExtData yyExtData = threadAlaInfo.mYyExtData;
                    String str = yyExtData.mSid;
                    String str2 = yyExtData.mSsid;
                    String str3 = yyExtData.mTemplateId;
                    YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + threadAlaInfo.roomId, threadAlaInfo.mYyExtData.streamInfo, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                    AlaUserInfoData alaUserInfoData = threadAlaInfo.user_info;
                    if (alaUserInfoData != null) {
                        StatisticItem.make("c14719").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", alaUserInfoData.ala_id).param("obj_locate", pp6.f(this.b)).eventStat();
                        return;
                    }
                    return;
                }
                mb6.h(this.a.getPageActivity(), ib6Var.getThreadData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements uc6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public b(ac6 ac6Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac6Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.uc6
        public void a(ib6 ib6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ib6Var) == null) && ib6Var != null && ib6Var.getThreadData() != null && ib6Var.getThreadData().getThreadAlaInfo() != null && ib6Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                AlaInfoData threadAlaInfo = ib6Var.getThreadData().getThreadAlaInfo();
                TbPageContext tbPageContext = this.a;
                YyExtData yyExtData = threadAlaInfo.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + threadAlaInfo.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD);
            }
        }
    }

    public ac6(TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new LinkedList();
        this.a = new bc6(tbPageContext);
        this.b = new cc6(tbPageContext, str);
        this.c = new gc6(tbPageContext);
        this.d = new fc6(tbPageContext);
        this.e = new dc6(tbPageContext);
        this.f = new ec6(tbPageContext);
        this.b.u(new a(this, tbPageContext, str));
        this.d.u(new b(this, tbPageContext));
        this.g.add(this.a);
        this.g.add(this.b);
        this.g.add(this.c);
        this.g.add(this.d);
        this.g.add(this.e);
        this.g.add(this.f);
    }

    public List<pm> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (List) invokeV.objValue;
    }
}
