package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.tieba.pb.chosen.net.ChosenPbHttpResponse;
import com.baidu.tieba.pb.chosen.net.ChosenPbNetMessage;
import com.baidu.tieba.pb.chosen.net.ChosenPbSocketResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fv8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b();
        a();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            zn5 zn5Var = new zn5(309093);
            zn5Var.setResponsedClass(ChosenPbSocketResponse.class);
            zn5Var.g(true);
            zn5Var.h(false);
            MessageManager.getInstance().registerTask(zn5Var);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FINE_PB, xo9.a(TbConfig.FINE_PB_PAGE, 309093));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(ChosenPbHttpResponse.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void c(PbChosenActivity pbChosenActivity, long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pbChosenActivity, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            ChosenPbNetMessage chosenPbNetMessage = new ChosenPbNetMessage();
            int l = ii.l(pbChosenActivity.getPageContext().getPageActivity());
            int j4 = ii.j(pbChosenActivity.getPageContext().getPageActivity());
            float i = ii.i(pbChosenActivity.getPageContext().getPageActivity());
            chosenPbNetMessage.setQ_type(45L);
            chosenPbNetMessage.setScrH(j4);
            chosenPbNetMessage.setScrW(l);
            chosenPbNetMessage.setScr_dip(i);
            chosenPbNetMessage.setExcId(j);
            chosenPbNetMessage.setTagCode(j2);
            chosenPbNetMessage.setThreadId(j3);
            pbChosenActivity.sendMessage(chosenPbNetMessage);
        }
    }
}
