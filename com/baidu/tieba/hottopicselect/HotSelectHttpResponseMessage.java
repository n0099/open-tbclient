package com.baidu.tieba.hottopicselect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.l45;
import com.baidu.tieba.l98;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetSugTopic.DataRes;
import tbclient.GetSugTopic.GetSugTopicResIdl;
/* loaded from: classes6.dex */
public class HotSelectHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l98 mBangTopic;
    public l98 mSugTopic;
    public l98 mUserHisTopic;
    public l98 mVideoTopic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotSelectHttpResponseMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.afterDispatchInBackGround(i, (int) bArr);
            if (bArr != null && bArr.length > 0 && getError() == 0) {
                l45.e();
                l45.d("topic_select_space", TbadkCoreApplication.getCurrentAccount()).a("topic_select_user", bArr);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetSugTopicResIdl getSugTopicResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048579, this, i, bArr) != null) || (getSugTopicResIdl = (GetSugTopicResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSugTopicResIdl.class)) == null) {
            return;
        }
        Error error = getSugTopicResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getSugTopicResIdl.error.errmsg);
        }
        DataRes dataRes = getSugTopicResIdl.data;
        if (dataRes == null) {
            return;
        }
        if (dataRes.user_his_topic != null) {
            l98 l98Var = new l98();
            l98Var.d(getSugTopicResIdl.data.user_his_topic);
            l98Var.f(0);
            this.mUserHisTopic = l98Var;
        }
        if (getSugTopicResIdl.data.bang_topic != null) {
            l98 l98Var2 = new l98();
            l98Var2.f(1);
            l98Var2.d(getSugTopicResIdl.data.bang_topic);
            this.mBangTopic = l98Var2;
        }
        if (getSugTopicResIdl.data.sug_topic != null) {
            l98 l98Var3 = new l98();
            l98Var3.d(getSugTopicResIdl.data.sug_topic);
            this.mSugTopic = l98Var3;
        }
        if (getSugTopicResIdl.data.video_topic != null) {
            l98 l98Var4 = new l98();
            l98Var4.d(getSugTopicResIdl.data.video_topic);
            this.mVideoTopic = l98Var4;
        }
    }

    public l98 getBangTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mBangTopic;
        }
        return (l98) invokeV.objValue;
    }

    public l98 getSugTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mSugTopic;
        }
        return (l98) invokeV.objValue;
    }

    public l98 getUserHisTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mUserHisTopic;
        }
        return (l98) invokeV.objValue;
    }

    public l98 getVideoTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mVideoTopic;
        }
        return (l98) invokeV.objValue;
    }

    public void setVideoTopic(l98 l98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, l98Var) == null) {
            this.mVideoTopic = l98Var;
        }
    }
}
