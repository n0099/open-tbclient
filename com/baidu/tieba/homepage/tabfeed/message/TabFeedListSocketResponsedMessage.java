package com.baidu.tieba.homepage.tabfeed.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.q0.e1.j.h.a;
import tbclient.ActivityPage.ActivityPageResIdl;
import tbclient.Error;
/* loaded from: classes4.dex */
public class TabFeedListSocketResponsedMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a tabFeedData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabFeedListSocketResponsedMessage() {
        super(309655);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            ActivityPageResIdl activityPageResIdl = (ActivityPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ActivityPageResIdl.class);
            Error error = activityPageResIdl.error;
            if (error != null && (num = error.errorno) != null) {
                setError(num.intValue());
            }
            Error error2 = activityPageResIdl.error;
            if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
                setErrorString(activityPageResIdl.error.usermsg);
            }
            if (getError() == 0 && activityPageResIdl.data != null) {
                a aVar = new a();
                this.tabFeedData = aVar;
                aVar.j(activityPageResIdl.data);
            }
        }
    }
}
