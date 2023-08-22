package com.baidu.tieba.barselect.data;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jh6;
import com.baidu.tieba.kh6;
import com.baidu.tieba.lh6;
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
/* loaded from: classes5.dex */
public class VoteElectionSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lh6 mVoteData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoteElectionSocketResMessage() {
        super(309642);
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

    public lh6 getVoteData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mVoteData;
        }
        return (lh6) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            boolean z = false;
            ElectionInfoResIdl electionInfoResIdl = (ElectionInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, ElectionInfoResIdl.class);
            if (electionInfoResIdl != null) {
                setError(electionInfoResIdl.error.errorno.intValue());
                setErrorString(electionInfoResIdl.error.usermsg);
                if (getError() != 0) {
                    return electionInfoResIdl;
                }
                if (electionInfoResIdl.data == null) {
                    return electionInfoResIdl;
                }
                if (this.mVoteData == null) {
                    this.mVoteData = new lh6();
                }
                if (electionInfoResIdl.data.election_list != null) {
                    ArrayList<jh6> arrayList = new ArrayList<>();
                    for (ElectionList electionList : electionInfoResIdl.data.election_list) {
                        arrayList.add(jh6.o(electionList));
                    }
                    this.mVoteData.h(arrayList);
                }
                Basic basic = electionInfoResIdl.data.basic;
                if (basic != null) {
                    this.mVoteData.m(kh6.j(basic));
                }
                Myrecord myrecord = electionInfoResIdl.data.my_record;
                if (myrecord != null) {
                    this.mVoteData.n(jh6.p(myrecord));
                }
                Integer num = electionInfoResIdl.data.has_more;
                if (num != null) {
                    lh6 lh6Var = this.mVoteData;
                    if (num.intValue() == 1) {
                        z = true;
                    }
                    lh6Var.j(z);
                }
                ManagerElection managerElection = electionInfoResIdl.data.vote_limit;
                if (managerElection != null) {
                    this.mVoteData.k(managerElection);
                }
            }
            return electionInfoResIdl;
        }
        return invokeIL.objValue;
    }
}
