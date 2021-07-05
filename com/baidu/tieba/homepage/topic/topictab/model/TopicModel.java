package com.baidu.tieba.homepage.topic.topictab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.c.e.p.j;
import d.a.s0.e1.k.b.a;
/* loaded from: classes5.dex */
public class TopicModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f16916e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f16917f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f16918g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16919h;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f16917f);
            MessageManager.getInstance().unRegisterListener(this.f16918g);
            this.f16919h = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.f16917f.setTag(bdUniqueId);
            registerListener(this.f16917f);
            this.f16918g.setTag(bdUniqueId);
            registerListener(this.f16918g);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!j.A()) {
                a aVar = this.f16916e;
                if (aVar != null) {
                    aVar.netCallback(-1, null);
                }
            } else if (this.f16919h) {
            } else {
                cancelLoadData();
                RequestGetTopicListMessage requestGetTopicListMessage = new RequestGetTopicListMessage();
                requestGetTopicListMessage.setCallFrom("topic_tab");
                requestGetTopicListMessage.setTag(this.unique_id);
                if (MessageManager.getInstance().sendMessage(requestGetTopicListMessage)) {
                    this.f16919h = true;
                }
            }
        }
    }

    public void x(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f16916e = aVar;
        }
    }
}
