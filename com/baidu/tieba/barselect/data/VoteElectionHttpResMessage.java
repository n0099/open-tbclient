package com.baidu.tieba.barselect.data;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.ElectionInfo.ElectionInfoResIdl;
import tbclient.ElectionList;
/* loaded from: classes15.dex */
public class VoteElectionHttpResMessage extends TbHttpResponsedMessage {
    private f mVoteData;

    public VoteElectionHttpResMessage() {
        super(CmdConfigHttp.CMD_BAR_ELECTION);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
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
                        arrayList.add(d.a(electionList));
                    }
                    this.mVoteData.ak(arrayList);
                }
                if (electionInfoResIdl.data.basic != null) {
                    this.mVoteData.a(e.a(electionInfoResIdl.data.basic));
                }
                if (electionInfoResIdl.data.my_record != null) {
                    this.mVoteData.a(d.a(electionInfoResIdl.data.my_record));
                }
                if (electionInfoResIdl.data.has_more != null) {
                    this.mVoteData.setHasMore(electionInfoResIdl.data.has_more.intValue() == 1);
                }
                if (electionInfoResIdl.data.vote_limit != null) {
                    this.mVoteData.a(electionInfoResIdl.data.vote_limit);
                }
            }
        }
    }

    public f getVoteData() {
        return this.mVoteData;
    }
}
