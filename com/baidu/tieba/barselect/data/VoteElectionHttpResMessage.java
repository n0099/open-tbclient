package com.baidu.tieba.barselect.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.my5;
import com.baidu.tieba.ny5;
import com.baidu.tieba.oy5;
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
/* loaded from: classes3.dex */
public class VoteElectionHttpResMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oy5 mVoteData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoteElectionHttpResMessage() {
        super(CmdConfigHttp.CMD_BAR_ELECTION);
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

    public oy5 getVoteData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mVoteData : (oy5) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            ElectionInfoResIdl electionInfoResIdl = (ElectionInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, ElectionInfoResIdl.class);
            if (electionInfoResIdl != null) {
                setError(electionInfoResIdl.error.errorno.intValue());
                setErrorString(electionInfoResIdl.error.usermsg);
                if (getError() == 0 && electionInfoResIdl.data != null) {
                    if (this.mVoteData == null) {
                        this.mVoteData = new oy5();
                    }
                    if (electionInfoResIdl.data.election_list != null) {
                        ArrayList<my5> arrayList = new ArrayList<>();
                        for (ElectionList electionList : electionInfoResIdl.data.election_list) {
                            arrayList.add(my5.o(electionList));
                        }
                        this.mVoteData.h(arrayList);
                    }
                    Basic basic = electionInfoResIdl.data.basic;
                    if (basic != null) {
                        this.mVoteData.m(ny5.j(basic));
                    }
                    Myrecord myrecord = electionInfoResIdl.data.my_record;
                    if (myrecord != null) {
                        this.mVoteData.n(my5.p(myrecord));
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
