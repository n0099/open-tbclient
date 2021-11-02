package com.baidu.tieba.hottopicselect;

import GetSugTopic.DataRes;
import GetSugTopic.GetSugTopicResIdl;
import b.a.q0.s.r.a;
import b.a.r0.k1.c;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
/* loaded from: classes9.dex */
public class HotSelectCacheResponseMessage extends CustomResponsedMessage<Object> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TOPIC_SELECT_KEY = "topic_select_user";
    public transient /* synthetic */ FieldHolder $fh;
    public c mBangData;
    public c mUserData;
    public c mVideoHotpicData;
    public int resultStatus;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotSelectCacheResponseMessage() {
        super(2016491);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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

    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bArr) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = "";
            }
            a.f();
            byte[] bArr2 = a.e("topic_select_space", currentAccount).get("topic_select_user");
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
                    c cVar = new c();
                    cVar.d(getSugTopicResIdl.data.user_his_topic);
                    cVar.f(0);
                    this.mUserData = cVar;
                }
                if (getSugTopicResIdl.data.bang_topic != null) {
                    c cVar2 = new c();
                    cVar2.d(getSugTopicResIdl.data.bang_topic);
                    cVar2.f(1);
                    this.mBangData = cVar2;
                }
                if (getSugTopicResIdl.data.video_topic != null) {
                    c cVar3 = new c();
                    cVar3.d(getSugTopicResIdl.data.video_topic);
                    cVar3.f(2);
                    this.mVideoHotpicData = cVar3;
                }
                this.resultStatus = 2;
                return;
            }
            this.resultStatus = 3;
        }
    }

    public int getResultStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.resultStatus : invokeV.intValue;
    }
}
