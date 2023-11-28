package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.frs.headercomponent.HeaderComponentMultiView;
import com.baidu.tieba.frs.headercomponent.HeaderComponentSingleView;
import com.baidu.tieba.util.TopicListUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsPage.LiveFuseForumData;
/* loaded from: classes6.dex */
public class h08 implements i08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final j08 a;
    @NonNull
    public final TbPageContext b;
    @NonNull
    public final List<LiveFuseForumData> c;
    public final boolean d;
    public String e;
    public String f;

    public h08(@NonNull TbPageContext tbPageContext, @NonNull List<LiveFuseForumData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, list, Boolean.valueOf(z)};
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
        this.c = list;
        this.d = z;
        if (list.size() == 1) {
            this.a = new HeaderComponentSingleView(this.b.getPageActivity());
        } else {
            this.a = new HeaderComponentMultiView(this.b.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.i08
    public void a(int i, LiveFuseForumData liveFuseForumData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048576, this, i, liveFuseForumData) != null) || liveFuseForumData == null) {
            return;
        }
        if (!TextUtils.isEmpty(liveFuseForumData.schema) && liveFuseForumData.schema.contains(TopicListUtil.TOPIC_LIST_URL)) {
            TopicListUtil.frsStatistic(1, this.e, liveFuseForumData.type.intValue());
        } else if (liveFuseForumData.type.intValue() == 6) {
            k("c15057");
        } else if (liveFuseForumData.type.intValue() == 8) {
            l("c15416", liveFuseForumData.yyext);
        } else {
            StatisticItem param = new StatisticItem("c14701").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", e(i, liveFuseForumData)).param("fid", this.e).param("obj_param1", !this.d ? 1 : 0);
            if (ListUtils.getCount(liveFuseForumData.title) > 0) {
                param.param("obj_name", (String) ListUtils.getItem(liveFuseForumData.title, 0));
            }
            param.eventStat();
            String str = liveFuseForumData.schema;
            if (str != null && str.startsWith("bdtiebalive")) {
                j("c14708", liveFuseForumData.yyext);
            }
        }
    }

    public final void j(String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.addParam("fid", this.e);
            statisticItem.addParam("fname", this.f);
            JSONObject g = g(str2);
            if (g != null) {
                if (g.optBoolean("is_yy_game")) {
                    str3 = "3";
                } else {
                    str3 = "2";
                }
                statisticItem.param("obj_param1", str3).param(TiebaStatic.Params.OBJ_PARAM2, g.optString(TiebaStatic.YYParams.YYLIVEID)).param("liveid", g.optString("liveid")).param("hdid", TbadkCoreApplication.getInst().getHdid()).param(TiebaStatic.YYParams.YYSID, g.optString(TiebaStatic.YYParams.YYSID)).param(TiebaStatic.YYParams.YYSSID, g.optString(TiebaStatic.YYParams.YYSSID)).param("yyuid", g.optString("yyuid")).param("template_id", g.optString("template_id")).param(TiebaStatic.YYParams.YYLIVEID, g.optString(TiebaStatic.YYParams.YYLIVEID)).param("vid", g.optString("vid"));
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.i08
    public void b(int i, LiveFuseForumData liveFuseForumData, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), liveFuseForumData, Integer.valueOf(i2)}) != null) || liveFuseForumData == null) {
            return;
        }
        String str = liveFuseForumData.schema;
        if (liveFuseForumData.type.intValue() != 2 && liveFuseForumData.type.intValue() != 3 && liveFuseForumData.type.intValue() != 4) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            g08.d().c(this.b, liveFuseForumData, str, i, this.d, this.e, this.f);
        } else {
            UrlManager.getInstance().dealOneLink(this.b, new String[]{str});
        }
        if (liveFuseForumData.type.intValue() == 6) {
            k("c15058");
        } else if (liveFuseForumData.type.intValue() == 8) {
            l("c15417", liveFuseForumData.yyext);
        }
        if (!TextUtils.isEmpty(liveFuseForumData.schema) && liveFuseForumData.schema.contains(TopicListUtil.TOPIC_LIST_URL)) {
            TopicListUtil.frsStatistic(2, this.e, liveFuseForumData.type.intValue());
        }
    }

    @Override // com.baidu.tieba.i08
    public void c(int i, LiveFuseForumData liveFuseForumData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, liveFuseForumData) != null) || liveFuseForumData == null) {
            return;
        }
        String urlAddParam = BdUtilHelper.urlAddParam(liveFuseForumData.schema, "from=key_from_frs_card");
        if (liveFuseForumData.type.intValue() != 2 && liveFuseForumData.type.intValue() != 3 && liveFuseForumData.type.intValue() != 4) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            g08.d().c(this.b, liveFuseForumData, urlAddParam, i, this.d, this.e, this.f);
        } else {
            UrlManager.getInstance().dealOneLink(this.b, new String[]{urlAddParam});
        }
        if (liveFuseForumData.type.intValue() == 6) {
            k("c15058");
        } else if (liveFuseForumData.type.intValue() == 8) {
            l("c15417", liveFuseForumData.yyext);
        } else if (!TextUtils.isEmpty(liveFuseForumData.schema) && liveFuseForumData.schema.contains(TopicListUtil.TOPIC_LIST_URL)) {
            TopicListUtil.frsStatistic(2, this.e, liveFuseForumData.type.intValue());
        } else if (!z) {
            StatisticItem param = new StatisticItem("c14702").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", e(i, liveFuseForumData)).param("fid", this.e).param("obj_param1", !this.d ? 1 : 0);
            if (ListUtils.getCount(liveFuseForumData.title) > 0) {
                param.param("obj_name", (String) ListUtils.getItem(liveFuseForumData.title, 0));
            }
            param.eventStat();
            String str = liveFuseForumData.schema;
            if (str != null && str.startsWith("bdtiebalive")) {
                j("c14709", liveFuseForumData.yyext);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.a(this.c, this);
        }
    }

    @NonNull
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.getView();
        }
        return (View) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.f();
        }
    }

    public final int e(int i, LiveFuseForumData liveFuseForumData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, liveFuseForumData)) == null) {
            if (i == 1) {
                if (liveFuseForumData.type.intValue() == 1) {
                    return 1;
                }
                if (liveFuseForumData.type.intValue() == 2) {
                    return 3;
                }
                if (liveFuseForumData.type.intValue() == 7) {
                    return 5;
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

    public final JSONObject g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            TiebaStatic.log(new StatisticItem(str).param("fid", this.e).param("fname", this.f));
        }
    }

    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            this.e = str;
            this.f = str2;
        }
    }

    public final void l(String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            JSONObject g = g(str2);
            if (g != null) {
                str3 = g.optString("group_id");
            } else {
                str3 = "";
            }
            TiebaStatic.log(new StatisticItem(str).param("fid", this.e).param("fname", this.f).param("obj_id", str3));
        }
    }
}
