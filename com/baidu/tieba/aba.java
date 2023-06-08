package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.video.LiveConfig;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class aba {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemData a;
    public LiveConfig b;

    public aba(VideoItemData videoItemData, LiveConfig liveConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoItemData, liveConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = videoItemData;
        this.b = liveConfig;
    }

    public void a(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.VIDEO_LIVE_PAGE_AUTO_JUMP);
            statisticItem.addParam("tid", this.a.thread_id);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_locate", i);
            statisticItem.addParam("obj_source", this.a.mRecomSource);
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam(TiebaStatic.Params.OBJ_TO, this.b.getCurrentRealHitStrategy());
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM3, this.b.getWaitSecond());
            statisticItem.addParam("obj_param1", YYLiveUtil.calculateLiveType(this.a.getLivePageData()));
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, this.b.getWaitSecond());
            statisticItem.addParam(TiebaStatic.YYParams.YYSID, this.a.getLivePageData().mYyExtData.mSid);
            statisticItem.addParam(TiebaStatic.YYParams.YYSSID, this.a.getLivePageData().mYyExtData.mSsid);
            statisticItem.addParam("yyuid", this.a.getLivePageData().mYyExtData.mYyUid);
            statisticItem.addParam(TiebaStatic.YYParams.YYLIVEID, 1);
            statisticItem.addParam("template_id", 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public void c(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.VIDEO_LIVE_PAGE_SHOW);
            statisticItem.addParam("tid", this.a.thread_id);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_locate", i);
            statisticItem.addParam("obj_source", this.a.mRecomSource);
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam(TiebaStatic.Params.OBJ_TO, this.b.getCurrentRealHitStrategy());
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM3, this.b.getWaitSecond());
            statisticItem.addParam("obj_param1", YYLiveUtil.calculateLiveType(this.a.getLivePageData()));
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, this.b.getWaitSecond());
            statisticItem.addParam(TiebaStatic.YYParams.YYSID, this.a.getLivePageData().mYyExtData.mSid);
            statisticItem.addParam(TiebaStatic.YYParams.YYSSID, this.a.getLivePageData().mYyExtData.mSsid);
            statisticItem.addParam("yyuid", this.a.getLivePageData().mYyExtData.mYyUid);
            statisticItem.addParam(TiebaStatic.YYParams.YYLIVEID, 1);
            statisticItem.addParam("template_id", 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public void b(int i, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.VIDEO_LIVE_PAGE_CLICK);
            statisticItem.addParam("tid", this.a.thread_id);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_locate", i);
            statisticItem.addParam("obj_source", this.a.mRecomSource);
            statisticItem.addParam("obj_name", i2);
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam(TiebaStatic.Params.OBJ_TO, this.b.getCurrentRealHitStrategy());
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM3, this.b.getWaitSecond());
            statisticItem.addParam("obj_param1", YYLiveUtil.calculateLiveType(this.a.getLivePageData()));
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, this.b.getWaitSecond());
            statisticItem.addParam(TiebaStatic.YYParams.YYSID, this.a.getLivePageData().mYyExtData.mSid);
            statisticItem.addParam(TiebaStatic.YYParams.YYSSID, this.a.getLivePageData().mYyExtData.mSsid);
            statisticItem.addParam("yyuid", this.a.getLivePageData().mYyExtData.mYyUid);
            statisticItem.addParam(TiebaStatic.YYParams.YYLIVEID, 1);
            statisticItem.addParam("template_id", 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public dj9 d(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, str)) == null) {
            dj9 dj9Var = new dj9();
            dj9Var.e = TbadkCoreApplication.getCurrentAccount();
            dj9Var.c = this.a.thread_id;
            dj9Var.a = String.valueOf(i);
            dj9Var.f = this.a.mRecomSource;
            dj9Var.A = str;
            dj9Var.B = String.valueOf(this.b.getCurrentRealHitStrategy());
            dj9Var.g = String.valueOf(this.b.getWaitSecond());
            dj9Var.h = TiebaStatic.YYValues.YY_LIVE;
            dj9Var.i = String.valueOf(YYLiveUtil.calculateLiveType(this.a.getLivePageData()));
            dj9Var.C = this.a.getLivePageData().mYyExtData.mSid;
            dj9Var.D = this.a.getLivePageData().mYyExtData.mSsid;
            dj9Var.E = this.a.getLivePageData().mYyExtData.mYyUid;
            dj9Var.F = "1";
            dj9Var.G = "1";
            return dj9Var;
        }
        return (dj9) invokeIL.objValue;
    }
}
