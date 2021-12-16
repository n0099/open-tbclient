package com.baidu.tieba.barselect.data;

import c.a.s0.c0.b.d;
import c.a.s0.c0.b.e;
import c.a.s0.c0.b.f;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.ElectionInfoResIdl;
import tbclient.ElectionList;
import tbclient.ManagerElection;
import tbclient.Myrecord;
/* loaded from: classes11.dex */
public class VoteElectionSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f mVoteData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoteElectionSocketResMessage() {
        super(309642);
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

    public f getVoteData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mVoteData : (f) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            ElectionInfoResIdl electionInfoResIdl = (ElectionInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, ElectionInfoResIdl.class);
            if (electionInfoResIdl != null) {
                setError(electionInfoResIdl.error.errorno.intValue());
                setErrorString(electionInfoResIdl.error.usermsg);
                if (getError() == 0 && electionInfoResIdl.data != null) {
                    if (this.mVoteData == null) {
                        this.mVoteData = new f();
                    }
                    if (electionInfoResIdl.data.election_list != null) {
                        ArrayList<d> arrayList = new ArrayList<>();
                        for (ElectionList electionList : electionInfoResIdl.data.election_list) {
                            arrayList.add(d.o(electionList));
                        }
                        this.mVoteData.h(arrayList);
                    }
                    Basic basic = electionInfoResIdl.data.basic;
                    if (basic != null) {
                        this.mVoteData.m(e.i(basic));
                    }
                    Myrecord myrecord = electionInfoResIdl.data.my_record;
                    if (myrecord != null) {
                        this.mVoteData.n(d.p(myrecord));
                    }
                    Integer num = electionInfoResIdl.data.has_more;
                    if (num != null) {
                        this.mVoteData.j(num.intValue() == 1);
                    }
                    ManagerElection managerElection = electionInfoResIdl.data.vote_limit;
                    if (managerElection != null) {
                        this.mVoteData.k(managerElection);
                    }
                }
            }
        }
    }
}
