package com.baidu.tieba.barselect.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.v.b.d;
import d.b.i0.v.b.e;
import d.b.i0.v.b.f;
import java.util.ArrayList;
import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.ElectionInfoResIdl;
import tbclient.ElectionList;
import tbclient.ManagerElection;
import tbclient.Myrecord;
/* loaded from: classes4.dex */
public class VoteElectionSocketResMessage extends SocketResponsedMessage {
    public f mVoteData;

    public VoteElectionSocketResMessage() {
        super(309642);
    }

    public f getVoteData() {
        return this.mVoteData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
