package com.baidu.tieba.hottopicselect;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.o55;
import com.baidu.tieba.qb8;
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
    public qb8 mBangTopic;
    public qb8 mSugTopic;
    public qb8 mUserHisTopic;
    public qb8 mVideoTopic;

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

    public qb8 getBangTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mBangTopic;
        }
        return (qb8) invokeV.objValue;
    }

    public qb8 getSugTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mSugTopic;
        }
        return (qb8) invokeV.objValue;
    }

    public qb8 getUserHisTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mUserHisTopic;
        }
        return (qb8) invokeV.objValue;
    }

    public qb8 getVideoTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mVideoTopic;
        }
        return (qb8) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.afterDispatchInBackGround(i, (int) bArr);
            if (bArr != null && bArr.length > 0 && getError() == 0) {
                o55.e();
                o55.d("topic_select_space", TbadkCoreApplication.getCurrentAccount()).a("topic_select_user", bArr);
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
                qb8 qb8Var = new qb8();
                qb8Var.f(0);
                qb8Var.d(getSugTopicResIdl.data.user_his_topic);
                this.mUserHisTopic = qb8Var;
            }
            if (getSugTopicResIdl.data.bang_topic != null) {
                qb8 qb8Var2 = new qb8();
                qb8Var2.f(1);
                qb8Var2.d(getSugTopicResIdl.data.bang_topic);
                this.mBangTopic = qb8Var2;
            }
            if (getSugTopicResIdl.data.sug_topic != null) {
                qb8 qb8Var3 = new qb8();
                qb8Var3.d(getSugTopicResIdl.data.sug_topic);
                this.mSugTopic = qb8Var3;
            }
            if (getSugTopicResIdl.data.video_topic != null) {
                qb8 qb8Var4 = new qb8();
                qb8Var4.d(getSugTopicResIdl.data.video_topic);
                this.mVideoTopic = qb8Var4;
            }
            return getSugTopicResIdl;
        }
        return invokeIL.objValue;
    }

    public void setVideoTopic(qb8 qb8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, qb8Var) == null) {
            this.mVideoTopic = qb8Var;
        }
    }
}
