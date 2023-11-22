package com.baidu.tieba;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiePlusStatic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ItemInfo;
/* loaded from: classes6.dex */
public class gf8 {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayMap<String, String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ThirdStatisticHelper.ThirdStatisticCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.ThirdStatisticCallback
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && gf8.a != null) {
                gf8.a.put(str, "3");
            }
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.ThirdStatisticCallback
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && gf8.a != null) {
                gf8.a.put(str, "2");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947792112, "Lcom/baidu/tieba/gf8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947792112, "Lcom/baidu/tieba/gf8;");
                return;
            }
        }
        a = new ArrayMap<>();
    }

    @Deprecated
    public static void b(ThreadData threadData, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, threadData, str, i) == null) {
            c(threadData, str, i, 1);
        }
    }

    public static void e(String str, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65541, null, str, threadData, i) == null) && threadData != null && !StringUtils.isNull(threadData.getConvertBtnType())) {
            q(str, threadData, i);
        }
    }

    public static void l(String str, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65548, null, str, threadData, i) == null) && threadData != null && threadData.isTiebaPlusAdThread) {
            q(str, threadData, i);
        }
    }

    public static void c(ThreadData threadData, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLII(65539, null, threadData, str, i, i2) != null) || threadData == null) {
            return;
        }
        if (!TextUtils.isEmpty(threadData.tiePlusCostUrl)) {
            ThirdStatisticHelper.sendTiePlusReq(threadData.tiePlusCostUrl, threadData.tid, 2, null);
        }
        if (!TextUtils.isEmpty(threadData.tiePlusMonitorClickUrl)) {
            ThirdStatisticHelper.sendReq(threadData.tiePlusMonitorClickUrl);
        }
        if (threadData.isTiebaPlusAdThread) {
            l(CommonStatisticKey.KEY_HEATING_THREAD_CLICK, threadData, i2);
            lq4.a(lq4.e, lq4.a, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, i);
        }
        if (str != null && str.startsWith("manual")) {
            lq4.a(lq4.l, lq4.a, str, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, i);
        }
    }

    public static void d(ThreadData threadData, BdUniqueId bdUniqueId, int i, int i2) {
        String str;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData, bdUniqueId, i, i2) != null) || threadData == null) {
            return;
        }
        if (threadData.isSCard) {
            str = threadData.scardPacketId;
            z = true;
            i3 = 20;
        } else {
            str = null;
            z = false;
            i3 = 0;
        }
        StatisticItem e = upa.e(threadData, "a002", "common_click", i2, i, z, str, null, i3);
        if (e == null) {
            return;
        }
        if (threadData.isGoods()) {
            e.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (threadData.getItem() != null) {
            e.param(TiebaStatic.Params.GUA_TYPE, 2);
            int indexOf = e.getParams().indexOf("obj_locate");
            if (indexOf >= 0) {
                int i4 = indexOf + 1;
                e.getParams().remove(i4);
                e.getParams().add(i4, 16);
            } else {
                e.param("obj_locate", 16);
            }
        } else if (iy5.w(threadData)) {
            e.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            e.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        if (threadData.isSCard) {
            e.delete("thread_type");
            e.param("thread_type", threadData.getThreadType());
        }
        k(threadData, e);
        e.param(TiebaStatic.Params.RECOM_TYPE, threadData.getRecomCardType());
        if (PermissionUtil.isBrowseMode()) {
            e.param(TiebaStatic.Params.PURE_BROWSING, 1);
        }
        j(threadData, e);
        xpa.g().c(bdUniqueId, e);
        i(threadData, i2);
        g(threadData, i2);
    }

    public static void f(String str, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, str, threadData) == null) && threadData != null && !StringUtils.isNull(threadData.getConvertBtnType())) {
            r(str, threadData);
        }
    }

    public static void i(ThreadData threadData, int i) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, threadData, i) == null) {
            if (i != 2) {
                if (i != 9) {
                    n = null;
                } else {
                    n = upa.n("c13693", threadData, 1);
                }
            } else {
                n = upa.n("c13692", threadData, 1);
            }
            TiebaStatic.log(n);
        }
    }

    public static void j(ThreadData threadData, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, threadData, statisticItem) == null) {
            if (threadData.getForumData() != null && !ListUtils.isEmpty(threadData.getForumData().h())) {
                statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM3, 1);
            } else {
                statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM3, 0);
            }
        }
    }

    public static void k(ThreadData threadData, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, threadData, statisticItem) == null) {
            if (threadData.getThreadRecommendTagData() != null && !TextUtils.isEmpty(threadData.getThreadRecommendTagData().getText())) {
                statisticItem.addParam(TiebaStatic.Params.IS_SPECIAL_THREAD, 1);
            } else {
                statisticItem.addParam(TiebaStatic.Params.IS_SPECIAL_THREAD, 0);
            }
        }
    }

    public static void m(String str, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, str, threadData) == null) && threadData != null && threadData.isTiebaPlusAdThread) {
            r(str, threadData);
        }
    }

    public static void g(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65543, null, threadData, i) == null) && threadData != null && threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().i())) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_REC_THREAD_CLICK);
            statisticItem.addParam("tid", threadData.getTid()).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("fid", threadData.getFid()).addParam("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void r(String str, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, str, threadData) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.addParam("obj_locate", 1);
            if (threadData.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (threadData.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", threadData.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, threadData.getFid());
            statisticItem.addParam("order_id", threadData.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void h(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, threadData) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_REC_THREAD_SHOW);
            statisticItem.addParam("tid", threadData.getTid()).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("fid", threadData.getFid());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void n(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, threadData) == null) && threadData != null && !TextUtils.isEmpty(threadData.tiePlusShowUrl)) {
            if (a == null) {
                a = new ArrayMap<>();
            }
            String str = a.get(threadData.tiePlusShowUrl);
            if (!"1".equals(str) && !"2".equals(str)) {
                ThirdStatisticHelper.sendTiePlusReq(threadData.tiePlusShowUrl, threadData.tid, 1, new a());
                a.put(threadData.tiePlusShowUrl, "1");
            }
        }
    }

    public static void o(ThreadData threadData, String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65551, null, threadData, str, i) != null) || threadData == null) {
            return;
        }
        n(threadData);
        if (threadData.isTiebaPlusAdThread) {
            m(CommonStatisticKey.KEY_HEATING_THREAD_EXPOSE, threadData);
            lq4.a(lq4.d, lq4.a, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, i);
        }
        if (str != null && str.startsWith("manual")) {
            lq4.a(lq4.k, lq4.a, str, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, i);
        }
        if (!TextUtils.isEmpty(threadData.tiePlusMonitorShowUrl)) {
            ThirdStatisticHelper.sendReq(threadData.tiePlusMonitorShowUrl);
        }
    }

    public static void q(String str, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65553, null, str, threadData, i) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.addParam("obj_locate", 1);
            if (threadData.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (threadData.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam(TiePlusStatic.Params.CLI_LOCATE, i);
            statisticItem.addParam("tid", threadData.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, threadData.getFid());
            statisticItem.addParam("order_id", threadData.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void p(ThreadData threadData, BdUniqueId bdUniqueId, int i) {
        String str;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65552, null, threadData, bdUniqueId, i) != null) || threadData == null) {
            return;
        }
        if (threadData.isSCard) {
            str = threadData.scardPacketId;
            z = true;
            i2 = 20;
        } else {
            str = null;
            z = false;
            i2 = 0;
        }
        String d = upa.d(threadData.getTid(), str, "", threadData.getBaijiahaoData());
        StatisticItem f = upa.f(threadData, "a002", "common_exp", i, z, str, null, i2);
        if (f == null) {
            return;
        }
        if (threadData.isSCard) {
            f.delete("thread_type");
            f.param("thread_type", threadData.getThreadType());
        }
        if (threadData.isGoods()) {
            f.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (threadData.getItem() != null) {
            f.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else if (iy5.w(threadData)) {
            f.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            f.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        k(threadData, f);
        f.param(TiebaStatic.Params.RECOM_TYPE, threadData.getRecomCardType());
        if (PermissionUtil.isBrowseMode()) {
            f.param(TiebaStatic.Params.PURE_BROWSING, 1);
        }
        j(threadData, f);
        xpa.g().d(bdUniqueId, d, f);
        yc8.c(d);
        s(threadData);
    }

    public static void s(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65555, null, threadData) == null) && threadData != null && threadData.isXiuXiuThread()) {
            int i = 0;
            ItemInfo itemInfo = TbSingleton.getInstance().getFrsItemInfoCache().get(threadData.getForum_name());
            if (itemInfo != null) {
                i = itemInfo.id.intValue();
                str = itemInfo.name;
            } else {
                str = "";
            }
            new StatisticItem(CommonStatisticKey.KEY_XIUXIU_THREAD_SHOW).addParam("obj_locate", 2).addParam("fid", threadData.getFid()).addParam("fname", threadData.getForum_name()).addParam("post_id", threadData.getTid()).addParam("obj_id", i).addParam("obj_name", str).eventStat();
        }
    }
}
