package com.baidu.tieba.hottopicselect;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ac8;
import com.baidu.tieba.x45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.GetSugTopic.DataRes;
import tbclient.GetSugTopic.GetSugTopicResIdl;
/* loaded from: classes6.dex */
public class HotSelectCacheResponseMessage extends CustomResponsedMessage<Object> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TOPIC_SELECT_KEY = "topic_select_user";
    public transient /* synthetic */ FieldHolder $fh;
    public ac8 mBangData;
    public ac8 mUserData;
    public ac8 mVideoHotpicData;
    public int resultStatus;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotSelectCacheResponseMessage() {
        super(2016491);
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

    public int getResultStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.resultStatus;
        }
        return invokeV.intValue;
    }

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, bArr) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = "";
            }
            x45.k();
            byte[] bArr2 = x45.j("topic_select_space", currentAccount).get("topic_select_user");
            GetSugTopicResIdl getSugTopicResIdl = null;
            if (bArr2 == null) {
                this.resultStatus = 1;
            }
            try {
                getSugTopicResIdl = (GetSugTopicResIdl) new Wire(new Class[0]).parseFrom(bArr2, GetSugTopicResIdl.class);
            } catch (IOException unused) {
                this.resultStatus = 3;
            }
            if (getSugTopicResIdl != null && (dataRes = getSugTopicResIdl.data) != null) {
                if (dataRes.user_his_topic != null) {
                    ac8 ac8Var = new ac8();
                    ac8Var.d(getSugTopicResIdl.data.user_his_topic);
                    ac8Var.f(0);
                    this.mUserData = ac8Var;
                }
                if (getSugTopicResIdl.data.bang_topic != null) {
                    ac8 ac8Var2 = new ac8();
                    ac8Var2.d(getSugTopicResIdl.data.bang_topic);
                    ac8Var2.f(1);
                    this.mBangData = ac8Var2;
                }
                if (getSugTopicResIdl.data.video_topic != null) {
                    ac8 ac8Var3 = new ac8();
                    ac8Var3.d(getSugTopicResIdl.data.video_topic);
                    ac8Var3.f(2);
                    this.mVideoHotpicData = ac8Var3;
                }
                this.resultStatus = 2;
                return;
            }
            this.resultStatus = 3;
        }
    }
}
