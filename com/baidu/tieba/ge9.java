package com.baidu.tieba;

import android.content.Context;
import android.location.Location;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class ge9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public ge9(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public final String a(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, shareItem)) == null) {
            String str = "【" + shareItem.v + "】 " + shareItem.w;
            shareItem.w = str;
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final Location b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return bk6.b();
        }
        return (Location) invokeV.objValue;
    }

    public void c(int i, ShareItem shareItem, boolean z) {
        Location b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), shareItem, Boolean.valueOf(z)}) != null) || shareItem == null) {
            return;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            ii.P(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            return;
        }
        if (z && (b = b()) != null) {
            shareItem.F = b;
        }
        ia5 ia5Var = new ia5(this.a, null);
        if (i == 3) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
            if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                BdToast.b(this.a, TbadkCoreApplication.getInst().getText(R.string.obfuscated_res_0x7f0f1252)).o();
                return;
            }
            e(shareItem, 4);
            ia5Var.r(shareItem);
        } else if (i == 2) {
            IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
            if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                BdToast.b(this.a, TbadkCoreApplication.getInst().getText(R.string.obfuscated_res_0x7f0f1252)).o();
                return;
            }
            e(shareItem, 3);
            if (shareItem.b) {
                shareItem.w = a(shareItem);
            }
            ia5Var.s(shareItem);
        } else if (i == 4) {
            if (wk9.b(this.a, "com.tencent.mobileqq")) {
                e(shareItem, 5);
                ia5Var.n(shareItem);
                return;
            }
            Context context = this.a;
            BdToast.b(context, context.getText(R.string.share_qq_not_install)).o();
        } else if (i == 5) {
            if (!shareItem.a) {
                shareItem.w = a(shareItem);
            }
            ia5Var.q(shareItem);
        } else if (i == 6) {
            e(shareItem, 7);
            if (!shareItem.a) {
                shareItem.w = a(shareItem);
            }
            ia5Var.p(shareItem);
        } else if (i == 7) {
            if (!shareItem.a) {
                shareItem.w = a(shareItem);
            }
            ia5Var.o(shareItem);
        } else if (i == 8) {
            if (wk9.b(this.a, "com.tencent.mobileqq")) {
                e(shareItem, 9);
                ia5Var.m(shareItem);
                return;
            }
            Context context2 = this.a;
            BdToast.b(context2, context2.getText(R.string.share_qq_not_install)).o();
        }
    }

    public final void d(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            TiebaStatic.eventStat(this.a, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public final void e(ShareItem shareItem, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, shareItem, i) == null) && shareItem != null && shareItem.u != null) {
            if (shareItem.b) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.u).param("obj_type", i));
            } else if (!shareItem.c && !shareItem.f) {
                if (shareItem.d) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.u).param("obj_type", i));
                } else if (shareItem.a) {
                    d(i, shareItem.G);
                } else if (shareItem.e) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i).param("fid", shareItem.u));
                } else if (shareItem.g) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i);
                    param.param("obj_source", shareItem.I);
                    if (!hi.isEmpty(shareItem.x) && shareItem.x.contains("worldcup")) {
                        param.param("obj_param1", 9);
                    }
                    TiebaStatic.log(param);
                } else if (shareItem.h) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.u).param("fid", shareItem.N).param("obj_type", i).param("obj_source", shareItem.I).param("obj_param1", shareItem.J).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.K).param(TiebaStatic.Params.OBJ_PARAM3, shareItem.L).param("obj_locate", shareItem.M));
                }
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.u).param("obj_type", i).param("obj_source", shareItem.I).param("obj_param1", shareItem.J).param("fid", shareItem.N).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.K));
            }
        }
    }
}
