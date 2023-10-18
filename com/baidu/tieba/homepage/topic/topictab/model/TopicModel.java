package com.baidu.tieba.homepage.topic.topictab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
import com.baidu.tieba.p48;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class TopicModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p48 a;
    public NetMessageListener b;
    public NetMessageListener c;
    public boolean d;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                p48 p48Var = this.a;
                if (p48Var != null) {
                    p48Var.z0(-1, null);
                }
            } else if (this.d) {
            } else {
                cancelLoadData();
                RequestGetTopicListMessage requestGetTopicListMessage = new RequestGetTopicListMessage();
                requestGetTopicListMessage.setCallFrom("topic_tab");
                requestGetTopicListMessage.setTag(this.unique_id);
                if (MessageManager.getInstance().sendMessage(requestGetTopicListMessage)) {
                    this.d = true;
                }
            }
        }
    }

    public void O(p48 p48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p48Var) == null) {
            this.a = p48Var;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.b.setTag(bdUniqueId);
            registerListener(this.b);
            this.c.setTag(bdUniqueId);
            registerListener(this.c);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.b);
            MessageManager.getInstance().unRegisterListener(this.c);
            this.d = false;
        }
    }
}
