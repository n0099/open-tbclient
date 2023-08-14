package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestDataManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class eg9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    public eg9(TbPageContext tbPageContext) {
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
        this.a = tbPageContext;
    }

    public final void a(PbModel pbModel, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048576, this, pbModel, i) != null) || pbModel == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13719");
        statisticItem.param("fid", pbModel.G.l());
        statisticItem.param("tid", pbModel.G.Q());
        statisticItem.param("obj_type", i);
        if (pbModel.r1() == 5) {
            statisticItem.param("obj_source", 1);
        } else if (pbModel.r1() == 7) {
            statisticItem.param("obj_source", 2);
        } else {
            statisticItem.param("obj_source", 3);
        }
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
    }

    public boolean b(PbModel pbModel) {
        InterceptResult invokeL;
        td9 td9Var;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbModel)) == null) {
            int i = 0;
            if (this.a.getPageActivity() != null && pbModel != null && (td9Var = pbModel.G) != null) {
                if ("3".equals(td9Var.e0)) {
                    MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.a.getPageActivity()).createNormalCfg(2);
                    createNormalCfg.setSubTabName(this.a.getString(R.string.tab_name_topic_rank));
                    this.a.sendMessage(new CustomMessage(2015002, createNormalCfg));
                    return true;
                }
                String string = SharedPrefHelper.getInstance().getString("key_pb_back_sid1", "");
                String string2 = SharedPrefHelper.getInstance().getString("key_pb_back_sid2", "");
                if (!TextUtils.isEmpty(string) && UbsABTestDataManager.getInstance().getABTestSwitchData(string) != null) {
                    str = "1";
                } else if (!TextUtils.isEmpty(string2) && UbsABTestDataManager.getInstance().getABTestSwitchData(string2) != null) {
                    str = "2";
                } else {
                    str = null;
                }
                if (str == null && (str2 = pbModel.G.d0) != null) {
                    str = str2;
                }
                if (str == null) {
                    return false;
                }
                if (str.equals("1")) {
                    MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.a.getPageActivity()).createNormalCfg(2);
                    createNormalCfg2.setSubTab(1, null);
                    this.a.sendMessage(new CustomMessage(2015002, createNormalCfg2));
                    a(pbModel, 1);
                    return true;
                } else if (str.equals("2")) {
                    MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.a.getPageActivity()).createNormalCfg(1);
                    createNormalCfg3.setSubTab(0, pbModel.G.e0);
                    this.a.sendMessage(new CustomMessage(2015002, createNormalCfg3));
                    if ("游戏".equals(pbModel.G.e0)) {
                        i = 2;
                    } else if ("数码".equals(pbModel.G.e0)) {
                        i = 3;
                    }
                    a(pbModel, i);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
