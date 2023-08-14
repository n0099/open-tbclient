package com.baidu.tieba.hottopicselect;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
public class HotSelectSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l98 mBangTopic;
    public l98 mSugTopic;
    public l98 mUserHisTopic;
    public l98 mVideoTopic;

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

    public l98 getBangTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mBangTopic;
        }
        return (l98) invokeV.objValue;
    }

    public l98 getSugTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mSugTopic;
        }
        return (l98) invokeV.objValue;
    }

    public l98 getUserHisTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mUserHisTopic;
        }
        return (l98) invokeV.objValue;
    }

    public l98 getVideoTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mVideoTopic;
        }
        return (l98) invokeV.objValue;
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            GetSugTopicResIdl getSugTopicResIdl = (GetSugTopicResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSugTopicResIdl.class);
            if (getSugTopicResIdl == null) {
                return null;
            }
            Error error = getSugTopicResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getSugTopicResIdl.error.errmsg);
            }
            DataRes dataRes = getSugTopicResIdl.data;
            if (dataRes == null) {
                return getSugTopicResIdl;
            }
            if (dataRes.user_his_topic != null) {
                l98 l98Var = new l98();
                l98Var.f(0);
                l98Var.d(getSugTopicResIdl.data.user_his_topic);
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
            return getSugTopicResIdl;
        }
        return invokeIL.objValue;
    }

    public void setVideoTopic(l98 l98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, l98Var) == null) {
            this.mVideoTopic = l98Var;
        }
    }
}
