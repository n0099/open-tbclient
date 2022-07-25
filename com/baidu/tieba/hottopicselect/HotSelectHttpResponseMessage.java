package com.baidu.tieba.hottopicselect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import com.repackage.s37;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetSugTopic.DataRes;
import tbclient.GetSugTopic.GetSugTopicResIdl;
/* loaded from: classes3.dex */
public class HotSelectHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s37 mBangTopic;
    public s37 mSugTopic;
    public s37 mUserHisTopic;
    public s37 mVideoTopic;

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

    public s37 getBangTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBangTopic : (s37) invokeV.objValue;
    }

    public s37 getSugTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mSugTopic : (s37) invokeV.objValue;
    }

    public s37 getUserHisTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mUserHisTopic : (s37) invokeV.objValue;
    }

    public s37 getVideoTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mVideoTopic : (s37) invokeV.objValue;
    }

    public void setVideoTopic(s37 s37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s37Var) == null) {
            this.mVideoTopic = s37Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.afterDispatchInBackGround(i, (int) bArr);
            if (bArr == null || bArr.length <= 0 || getError() != 0) {
                return;
            }
            cr4.f();
            cr4.e("topic_select_space", TbadkCoreApplication.getCurrentAccount()).a("topic_select_user", bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetSugTopicResIdl getSugTopicResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) || (getSugTopicResIdl = (GetSugTopicResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSugTopicResIdl.class)) == null) {
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
            s37 s37Var = new s37();
            s37Var.d(getSugTopicResIdl.data.user_his_topic);
            s37Var.f(0);
            this.mUserHisTopic = s37Var;
        }
        if (getSugTopicResIdl.data.bang_topic != null) {
            s37 s37Var2 = new s37();
            s37Var2.f(1);
            s37Var2.d(getSugTopicResIdl.data.bang_topic);
            this.mBangTopic = s37Var2;
        }
        if (getSugTopicResIdl.data.sug_topic != null) {
            s37 s37Var3 = new s37();
            s37Var3.d(getSugTopicResIdl.data.sug_topic);
            this.mSugTopic = s37Var3;
        }
        if (getSugTopicResIdl.data.video_topic != null) {
            s37 s37Var4 = new s37();
            s37Var4.d(getSugTopicResIdl.data.video_topic);
            this.mVideoTopic = s37Var4;
        }
    }
}
