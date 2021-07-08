package com.baidu.tieba.barselect.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.p0.x.b.a;
import tbclient.Error;
import tbclient.Search.SearchResIdl;
/* loaded from: classes4.dex */
public class CandidateSearchSocketResMsg extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a candidateData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CandidateSearchSocketResMsg() {
        super(309641);
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
        SearchResIdl searchResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (searchResIdl = (SearchResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchResIdl.class)) == null || searchResIdl.data == null) {
            return;
        }
        Error error = searchResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(searchResIdl.error.errmsg);
        }
        if (searchResIdl.data.uid.longValue() != 0) {
            a aVar = new a();
            this.candidateData = aVar;
            aVar.a(searchResIdl.data);
            if (getOrginalMessage() == null || !(getOrginalMessage().getExtra() instanceof CandidateSearchReqMsg)) {
                return;
            }
            this.candidateData.f66108a = ((CandidateSearchReqMsg) getOrginalMessage().getExtra()).fid;
        }
    }
}
