package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.bi;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.GetHotThread.GetHotThreadResIdl;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class ResponsedFrsHotSocketMessage extends SocketResponsedMessage {
    private final a mCache;
    private final am mPage;
    private final ArrayList<v> mThreadList;

    public ResponsedFrsHotSocketMessage() {
        super(301003);
        this.mThreadList = new ArrayList<>();
        this.mPage = new am();
        this.mCache = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetHotThreadResIdl getHotThreadResIdl = (GetHotThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, GetHotThreadResIdl.class);
        if (getHotThreadResIdl != null) {
            if (getHotThreadResIdl.error != null) {
                setError(getHotThreadResIdl.error.errorno.intValue());
                setErrorString(getHotThreadResIdl.error.usermsg);
            }
            if (getError() == 0 && getHotThreadResIdl.data != null) {
                HashMap<String, MetaData> hashMap = new HashMap<>();
                List<User> list = getHotThreadResIdl.data.user_list;
                if (list != null) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            hashMap.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                List<ThreadInfo> list2 = getHotThreadResIdl.data.thread_list;
                if (list2 != null) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        bi biVar = new bi();
                        biVar.setUserMap(hashMap);
                        biVar.a(list2.get(i3));
                        biVar.bV(0);
                        biVar.su();
                        if (biVar.getThreadType() == 33) {
                            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                this.mThreadList.add(biVar);
                            }
                        } else {
                            this.mThreadList.add(biVar);
                        }
                    }
                }
                this.mPage.a(getHotThreadResIdl.data.page);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        RequestFrsHotThreadMessage requestFrsHotThreadMessage;
        if (this.mThreadList.size() > 0 && this.mPage.qz() == 1 && getOrginalMessage() != null && getOrginalMessage().getExtra() != null && (requestFrsHotThreadMessage = (RequestFrsHotThreadMessage) getOrginalMessage().getExtra()) != null) {
            this.mCache.j(String.valueOf(requestFrsHotThreadMessage.getForumId()), bArr);
        }
    }

    public ArrayList<v> getThreadList() {
        return this.mThreadList;
    }

    public am getPage() {
        return this.mPage;
    }
}
