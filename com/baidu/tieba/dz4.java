package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.UsbAbTestConst;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dz4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dz4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public dz4() {
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

    public static dz4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (dz4.class) {
                    if (a == null) {
                        a = new dz4();
                    }
                }
            }
            return a;
        }
        return (dz4) invokeV.objValue;
    }

    public void a(String str, String str2, String str3, String str4, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_source", str2).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", str3);
            if (i > 0) {
                statisticItem.param("obj_param1", i);
            }
            if (StringUtils.isNotNull(str4)) {
                statisticItem.param(TiebaStatic.Params.OBJ_URL, str4);
            }
            if (UbsABTestHelper.isNonEcomAdDownloaderTestA()) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, UsbAbTestConst.KEY_NON_ECOM_AD_DOWNLOADER_A);
            } else if (UbsABTestHelper.isNonEcomAdDownloaderTestB()) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, UsbAbTestConst.KEY_NON_ECOM_AD_DOWNLOADER_B);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void c(boolean z, DownloadData downloadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), downloadData, Integer.valueOf(i)}) == null) {
            if (z) {
                a(TbadkCoreStatisticKey.FILE_DOWNLOAD_RESUME, String.valueOf(downloadData.getSource()), downloadData.getName(), downloadData.getUrl(), i);
            } else {
                a(TbadkCoreStatisticKey.FILE_DOWNLOAD_START, String.valueOf(downloadData.getSource()), downloadData.getName(), downloadData.getUrl(), i);
            }
        }
    }
}
