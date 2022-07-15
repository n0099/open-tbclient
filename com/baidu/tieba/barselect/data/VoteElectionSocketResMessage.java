package com.baidu.tieba.barselect.data;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mw5;
import com.repackage.nw5;
import com.repackage.ow5;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.ElectionInfoResIdl;
import tbclient.ElectionList;
import tbclient.ManagerElection;
import tbclient.Myrecord;
/* loaded from: classes3.dex */
public class VoteElectionSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ow5 mVoteData;

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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            ElectionInfoResIdl electionInfoResIdl = (ElectionInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, ElectionInfoResIdl.class);
            if (electionInfoResIdl != null) {
                setError(electionInfoResIdl.error.errorno.intValue());
                setErrorString(electionInfoResIdl.error.usermsg);
                if (getError() != 0 || electionInfoResIdl.data == null) {
                    return electionInfoResIdl;
                }
                if (this.mVoteData == null) {
                    this.mVoteData = new ow5();
                }
                if (electionInfoResIdl.data.election_list != null) {
                    ArrayList<mw5> arrayList = new ArrayList<>();
                    for (ElectionList electionList : electionInfoResIdl.data.election_list) {
                        arrayList.add(mw5.o(electionList));
                    }
                    this.mVoteData.h(arrayList);
                }
                Basic basic = electionInfoResIdl.data.basic;
                if (basic != null) {
                    this.mVoteData.m(nw5.i(basic));
                }
                Myrecord myrecord = electionInfoResIdl.data.my_record;
                if (myrecord != null) {
                    this.mVoteData.n(mw5.p(myrecord));
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
            return electionInfoResIdl;
        }
        return invokeIL.objValue;
    }

    public ow5 getVoteData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mVoteData : (ow5) invokeV.objValue;
    }
}
