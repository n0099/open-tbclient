package com.baidu.tieba.hottopicselect;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.a68;
import com.baidu.tieba.b55;
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
    public a68 mBangData;
    public a68 mUserData;
    public a68 mVideoHotpicData;
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
            b55.d();
            byte[] bArr2 = b55.c("topic_select_space", currentAccount).get("topic_select_user");
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
                    a68 a68Var = new a68();
                    a68Var.d(getSugTopicResIdl.data.user_his_topic);
                    a68Var.f(0);
                    this.mUserData = a68Var;
                }
                if (getSugTopicResIdl.data.bang_topic != null) {
                    a68 a68Var2 = new a68();
                    a68Var2.d(getSugTopicResIdl.data.bang_topic);
                    a68Var2.f(1);
                    this.mBangData = a68Var2;
                }
                if (getSugTopicResIdl.data.video_topic != null) {
                    a68 a68Var3 = new a68();
                    a68Var3.d(getSugTopicResIdl.data.video_topic);
                    a68Var3.f(2);
                    this.mVideoHotpicData = a68Var3;
                }
                this.resultStatus = 2;
                return;
            }
            this.resultStatus = 3;
        }
    }
}
