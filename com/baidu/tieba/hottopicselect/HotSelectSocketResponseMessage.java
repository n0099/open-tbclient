package com.baidu.tieba.hottopicselect;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.gz4;
import com.baidu.tieba.p68;
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
    public p68 mBangTopic;
    public p68 mSugTopic;
    public p68 mUserHisTopic;
    public p68 mVideoTopic;

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

    public p68 getBangTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mBangTopic;
        }
        return (p68) invokeV.objValue;
    }

    public p68 getSugTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mSugTopic;
        }
        return (p68) invokeV.objValue;
    }

    public p68 getUserHisTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mUserHisTopic;
        }
        return (p68) invokeV.objValue;
    }

    public p68 getVideoTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mVideoTopic;
        }
        return (p68) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.afterDispatchInBackGround(i, (int) bArr);
            if (bArr != null && bArr.length > 0 && getError() == 0) {
                gz4.k();
                gz4.j("topic_select_space", TbadkCoreApplication.getCurrentAccount()).a("topic_select_user", bArr);
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
                p68 p68Var = new p68();
                p68Var.g(0);
                p68Var.e(getSugTopicResIdl.data.user_his_topic);
                this.mUserHisTopic = p68Var;
            }
            if (getSugTopicResIdl.data.bang_topic != null) {
                p68 p68Var2 = new p68();
                p68Var2.g(1);
                p68Var2.e(getSugTopicResIdl.data.bang_topic);
                this.mBangTopic = p68Var2;
            }
            if (getSugTopicResIdl.data.sug_topic != null) {
                p68 p68Var3 = new p68();
                p68Var3.e(getSugTopicResIdl.data.sug_topic);
                this.mSugTopic = p68Var3;
            }
            if (getSugTopicResIdl.data.video_topic != null) {
                p68 p68Var4 = new p68();
                p68Var4.e(getSugTopicResIdl.data.video_topic);
                this.mVideoTopic = p68Var4;
            }
            return getSugTopicResIdl;
        }
        return invokeIL.objValue;
    }

    public void setVideoTopic(p68 p68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, p68Var) == null) {
            this.mVideoTopic = p68Var;
        }
    }
}
