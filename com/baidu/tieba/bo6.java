package com.baidu.tieba;

import android.net.Uri;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.frs.headercomponent.HeaderComponentMultiView;
import com.baidu.tieba.frs.headercomponent.HeaderComponentSingleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsPage.LiveFuseForumData;
/* loaded from: classes3.dex */
public class bo6 implements co6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TbPageContext b;
    public List<LiveFuseForumData> c;
    public String d;
    public String e;

    /* loaded from: classes3.dex */
    public class a extends qh5<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(bo6 bo6Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bo6Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qh5
        /* renamed from: a */
        public Long doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                NetWork netWork = new NetWork("https://peiwan.baidu.com/peiwan/api/index/audio");
                netWork.setNeedBdussForGet(true);
                String netString = netWork.getNetString();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    try {
                        JSONObject optJSONObject = new JSONObject(netString).optJSONObject("data");
                        if (optJSONObject != null) {
                            return Long.valueOf(optJSONObject.optLong("room_id"));
                        }
                        return Long.valueOf(dh.g(this.a, 0L));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return Long.valueOf(dh.g(this.a, 0L));
            }
            return (Long) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements vg5<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bo6 a;

        public b(bo6 bo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bo6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg5
        /* renamed from: a */
        public void onReturnDataInUI(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l) == null) {
                long longValue = l.longValue();
                if (this.a.b == null) {
                    return;
                }
                if (longValue == 0) {
                    ej.N(this.a.b.getPageActivity(), "当前没有可用房间");
                } else {
                    ((j95) ServiceManager.getService(j95.a.a())).a(this.a.b, longValue);
                }
            }
        }
    }

    public bo6(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.co6
    public void a(int i, LiveFuseForumData liveFuseForumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, liveFuseForumData) == null) {
            TiebaStatic.log(new StatisticItem("c14701").param("obj_type", g(i, liveFuseForumData)).param("fid", this.d));
            String str = liveFuseForumData.schema;
            if (str == null || !str.startsWith("bdtiebalive")) {
                return;
            }
            m("c14708", liveFuseForumData.yyext);
        }
    }

    @Override // com.baidu.tieba.co6
    public void b(int i, LiveFuseForumData liveFuseForumData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), liveFuseForumData, Integer.valueOf(i2)}) == null) {
            String str = liveFuseForumData.schema;
            if (liveFuseForumData.type.intValue() == 2 && str.contains("room_id")) {
                k(Uri.parse(str).getQueryParameter("room_id"));
            } else {
                UrlManager.getInstance().dealOneLink(this.b, new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.co6
    public void c(int i, LiveFuseForumData liveFuseForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, liveFuseForumData) == null) || liveFuseForumData == null) {
            return;
        }
        String P = ej.P(liveFuseForumData.schema, "from=key_from_frs_card");
        if (liveFuseForumData.type.intValue() == 2 && P.contains("room_id")) {
            k(Uri.parse(P).getQueryParameter("room_id"));
        } else {
            UrlManager.getInstance().dealOneLink(this.b, new String[]{P});
        }
        TiebaStatic.log(new StatisticItem("c14702").param("obj_type", g(i, liveFuseForumData)).param("fid", this.d));
        String str = liveFuseForumData.schema;
        if (str == null || !str.startsWith("bdtiebalive")) {
            return;
        }
        m("c14709", liveFuseForumData.yyext);
    }

    public void e() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (view2 = this.a) == null) {
            return;
        }
        ((do6) view2).b(this.c, this);
    }

    public void f(List<LiveFuseForumData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.c = list;
        if (list.size() == 1) {
            this.a = new HeaderComponentSingleView(this.b.getPageActivity());
        } else {
            this.a = new HeaderComponentMultiView(this.b.getPageActivity());
        }
    }

    public final int g(int i, LiveFuseForumData liveFuseForumData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, liveFuseForumData)) == null) {
            if (i == 1) {
                if (liveFuseForumData.type.intValue() == 1) {
                    return 1;
                }
                if (liveFuseForumData.type.intValue() == 2) {
                    return 3;
                }
            } else if (i == 2) {
                if (liveFuseForumData.type.intValue() == 1) {
                    return 2;
                }
                if (liveFuseForumData.type.intValue() == 2) {
                    return 4;
                }
            }
            return 0;
        }
        return invokeIL.intValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public final JSONObject i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public void j() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (view2 = this.a) == null) {
            return;
        }
        ((do6) view2).a();
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            uh5.b(new a(this, str), new b(this));
        }
    }

    public void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            this.d = str;
            this.e = str2;
        }
    }

    public final void m(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.addParam("fid", this.d);
            statisticItem.addParam("fname", this.e);
            JSONObject i = i(str2);
            if (i != null) {
                statisticItem.param("obj_param1", i.optBoolean("is_yy_game") ? "3" : "2").param(TiebaStatic.Params.OBJ_PARAM2, i.optString(TiebaStatic.YYParams.YYLIVEID)).param("liveid", i.optString("liveid")).param("hdid", TbadkCoreApplication.getInst().getHdid()).param(TiebaStatic.YYParams.YYSID, i.optString(TiebaStatic.YYParams.YYSID)).param(TiebaStatic.YYParams.YYSSID, i.optString(TiebaStatic.YYParams.YYSSID)).param(TiebaStatic.YYParams.YYUID, i.optString(TiebaStatic.YYParams.YYUID)).param("template_id", i.optString("template_id")).param(TiebaStatic.YYParams.YYLIVEID, i.optString(TiebaStatic.YYParams.YYLIVEID)).param(TiebaStatic.Params.VID, i.optString(TiebaStatic.Params.VID));
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
