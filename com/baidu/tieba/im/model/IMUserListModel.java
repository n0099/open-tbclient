package com.baidu.tieba.im.model;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d9;
import com.repackage.ng;
import com.repackage.xt4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class IMUserListModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_MAX_SIZE = 200;
    public static final long REQUEST_SPACE = 7200000;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMUserListModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setUniqueId(bdUniqueId);
        registerTask();
    }

    private boolean canRequestIfControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            xt4 k = xt4.k();
            long m = k.m("im_user_list_request_lasttime_" + TbadkCoreApplication.getCurrentAccount(), 0L);
            return m == 0 || System.currentTimeMillis() - m > REQUEST_SPACE;
        }
        return invokeV.booleanValue;
    }

    private void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_USER_LIST, TbConfig.SERVER_ADDRESS + TbConfig.URL_GET_USER_LIST);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(IMUserListHttpResponseMsg.class);
            tbHttpMessageTask.setPriority(3);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void request(boolean z, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (ng.g(str, 0L) <= 0) {
                arrayList.add(str);
            }
        }
        list.removeAll(arrayList);
        if (list.size() > 200) {
            list = list.subList(0, 200);
        }
        if (!z) {
            sendMessage(new IMUserListHttpReqMessage(list));
        } else if (canRequestIfControl()) {
            sendMessage(new IMUserListHttpReqMessage(list));
            xt4 k = xt4.k();
            k.x("im_user_list_request_lasttime_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
        }
    }

    public void requestFroChatActivity(@NonNull UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, userData) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(userData.getUserId());
            IMUserListHttpReqMessage iMUserListHttpReqMessage = new IMUserListHttpReqMessage(arrayList);
            iMUserListHttpReqMessage.needCheckBlock();
            iMUserListHttpReqMessage.needCheckCanChat();
            sendMessage(iMUserListHttpReqMessage);
        }
    }
}
