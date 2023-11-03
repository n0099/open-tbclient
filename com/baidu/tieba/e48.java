package com.baidu.tieba;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.lbs.BdLocationMananger;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    public static void a(TbPageContext tbPageContext, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, tbPageContext, frsViewData) != null) || tbPageContext == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
        BdLocationMananger.getInstance().getAddress(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), frsViewData.getForum().getName(), frsViewData.getForum().getId(), frsViewData.getUserData().getUserId(), frsViewData.getForum().getSpecialForumType())));
    }

    public static void b(FrsViewData frsViewData, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, frsViewData, tbPageContext) == null) {
            TiebaStatic.log(new StatisticItem("c11839").param("uid", TbadkCoreApplication.getCurrentAccount()));
            if (tbPageContext != null && frsViewData != null && frsViewData.getForum() != null) {
                if (Build.VERSION.SDK_INT < 24) {
                    zz4 zz4Var = new zz4(tbPageContext.getPageActivity());
                    zz4Var.setAutoNight(false);
                    zz4Var.setTitle(R.string.obfuscated_res_0x7f0f11a8);
                    zz4Var.setMessage(tbPageContext.getResources().getString(R.string.disallow_open_live_by_android_v7_0));
                    zz4Var.setTitleShowCenter(true);
                    zz4Var.setMessageShowCenter(true);
                    zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0b79, new a());
                    zz4Var.create(tbPageContext).show();
                } else if (!TbadkCoreApplication.isLogin()) {
                    if (frsViewData != null && frsViewData.getAnti() != null) {
                        frsViewData.getAnti().setIfpost(1);
                    }
                    ViewHelper.skipToLoginActivity(tbPageContext.getPageActivity());
                } else {
                    AntiData anti = frsViewData.getAnti();
                    if (anti != null && (AntiHelper.n(anti) || AntiHelper.g(anti) || AntiHelper.h(anti))) {
                        anti.setBlock_forum_name(frsViewData.getForum().getName());
                        anti.setBlock_forum_id(frsViewData.getForum().getId());
                        anti.setUser_name(frsViewData.getUserData().getUserName());
                        anti.setUser_id(frsViewData.getUserData().getUserId());
                        if (AntiHelper.x(tbPageContext.getPageActivity(), anti, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                            return;
                        }
                    }
                    if (frsViewData.getUserData() != null) {
                        a(tbPageContext, frsViewData);
                    }
                }
            }
        }
    }
}
