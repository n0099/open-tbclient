package com.baidu.tieba;

import android.content.Context;
import android.location.Location;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.controller.TransmitShareController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes6.dex */
public class gba {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public gba(Context context) {
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
            String str = "【" + shareItem.title + "】 " + shareItem.content;
            shareItem.content = str;
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final Location b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TransmitShareController.getForeverNullLocation();
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
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
            return;
        }
        if (z && (b = b()) != null) {
            shareItem.location = b;
        }
        ag5 ag5Var = new ag5(this.a, null);
        if (i == 3) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
            if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                BdToast.makeText(this.a, TbadkCoreApplication.getInst().getText(R.string.obfuscated_res_0x7f0f13ee)).show();
                return;
            }
            e(shareItem, 4);
            ag5Var.r(shareItem);
        } else if (i == 2) {
            IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
            if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                BdToast.makeText(this.a, TbadkCoreApplication.getInst().getText(R.string.obfuscated_res_0x7f0f13ee)).show();
                return;
            }
            e(shareItem, 3);
            if (shareItem.isFromShareFrs) {
                shareItem.content = a(shareItem);
            }
            ag5Var.s(shareItem);
        } else if (i == 4) {
            if (dja.b(this.a, "com.tencent.mobileqq")) {
                e(shareItem, 5);
                ag5Var.n(shareItem);
                return;
            }
            Context context = this.a;
            BdToast.makeText(context, context.getText(R.string.share_qq_not_install)).show();
        } else if (i == 5) {
            if (!shareItem.isFromChosenPb) {
                shareItem.content = a(shareItem);
            }
            ag5Var.q(shareItem);
        } else if (i == 6) {
            e(shareItem, 7);
            if (!shareItem.isFromChosenPb) {
                shareItem.content = a(shareItem);
            }
            ag5Var.p(shareItem);
        } else if (i == 7) {
            if (!shareItem.isFromChosenPb) {
                shareItem.content = a(shareItem);
            }
            ag5Var.o(shareItem);
        } else if (i == 8) {
            if (dja.b(this.a, "com.tencent.mobileqq")) {
                e(shareItem, 9);
                ag5Var.m(shareItem);
                return;
            }
            Context context2 = this.a;
            BdToast.makeText(context2, context2.getText(R.string.share_qq_not_install)).show();
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
        if ((interceptable == null || interceptable.invokeLI(1048580, this, shareItem, i) == null) && shareItem != null && shareItem.extData != null) {
            if (shareItem.isFromShareFrs) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.extData).param("obj_type", i));
            } else if (!shareItem.isFromSharePb && !shareItem.isFromFeed) {
                if (shareItem.isFromPhotoLive) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.extData).param("obj_type", i));
                } else if (shareItem.isFromChosenPb) {
                    d(i, shareItem.ftid);
                } else if (shareItem.isFromAcrossForum) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i).param("fid", shareItem.extData));
                } else if (shareItem.isFromWebActivity) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i);
                    param.param("obj_source", shareItem.objSource);
                    if (!di.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                        param.param("obj_param1", 9);
                    }
                    TiebaStatic.log(param);
                } else if (shareItem.isFromFeedVideoFinish) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.extData).param("fid", shareItem.fid).param("obj_type", i).param("obj_source", shareItem.objSource).param("obj_param1", shareItem.objParam1).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.objParam2).param(TiebaStatic.Params.OBJ_PARAM3, shareItem.objParam3).param("obj_locate", shareItem.objLocate));
                }
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.extData).param("obj_type", i).param("obj_source", shareItem.objSource).param("obj_param1", shareItem.objParam1).param("fid", shareItem.fid).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.objParam2));
            }
        }
    }
}
