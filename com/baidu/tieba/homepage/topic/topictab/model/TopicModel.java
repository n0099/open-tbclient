package com.baidu.tieba.homepage.topic.topictab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.mi;
import com.repackage.q27;
import com.repackage.wa;
/* loaded from: classes3.dex */
public class TopicModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q27 a;
    public wa b;
    public wa c;
    public boolean d;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.b);
            MessageManager.getInstance().unRegisterListener(this.c);
            this.d = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.b.setTag(bdUniqueId);
            registerListener(this.b);
            this.c.setTag(bdUniqueId);
            registerListener(this.c);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!mi.A()) {
                q27 q27Var = this.a;
                if (q27Var != null) {
                    q27Var.netCallback(-1, null);
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

    public void z(q27 q27Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, q27Var) == null) {
            this.a = q27Var;
        }
    }
}
