package com.baidu.tieba.hottopicselect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mr4;
import com.repackage.q37;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetSugTopic.DataRes;
import tbclient.GetSugTopic.GetSugTopicResIdl;
/* loaded from: classes3.dex */
public class HotSelectSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q37 mBangTopic;
    public q37 mSugTopic;
    public q37 mUserHisTopic;
    public q37 mVideoTopic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotSelectSocketResponseMessage() {
        super(309416);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public q37 getBangTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBangTopic : (q37) invokeV.objValue;
    }

    public q37 getSugTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mSugTopic : (q37) invokeV.objValue;
    }

    public q37 getUserHisTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mUserHisTopic : (q37) invokeV.objValue;
    }

    public q37 getVideoTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mVideoTopic : (q37) invokeV.objValue;
    }

    public void setVideoTopic(q37 q37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, q37Var) == null) {
            this.mVideoTopic = q37Var;
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
            mr4.f();
            mr4.e("topic_select_space", TbadkCoreApplication.getCurrentAccount()).a("topic_select_user", bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
            q37 q37Var = new q37();
            q37Var.f(0);
            q37Var.d(getSugTopicResIdl.data.user_his_topic);
            this.mUserHisTopic = q37Var;
        }
        if (getSugTopicResIdl.data.bang_topic != null) {
            q37 q37Var2 = new q37();
            q37Var2.f(1);
            q37Var2.d(getSugTopicResIdl.data.bang_topic);
            this.mBangTopic = q37Var2;
        }
        if (getSugTopicResIdl.data.sug_topic != null) {
            q37 q37Var3 = new q37();
            q37Var3.d(getSugTopicResIdl.data.sug_topic);
            this.mSugTopic = q37Var3;
        }
        if (getSugTopicResIdl.data.video_topic != null) {
            q37 q37Var4 = new q37();
            q37Var4.d(getSugTopicResIdl.data.video_topic);
            this.mVideoTopic = q37Var4;
        }
    }
}
