package com.baidu.tieba.frs.hot;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.GetHotThread.GetHotThreadResIdl;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class ResponsedFrsHotHttpMessage extends TbHttpResponsedMessage {
    private final a mCache;
    private final n mPage;
    private final ArrayList<u> mThreadList;

    public ResponsedFrsHotHttpMessage() {
        super(CmdConfigHttp.FRS_HOT_TAB_CMD);
        this.mThreadList = new ArrayList<>();
        this.mPage = new n();
        this.mCache = new a();
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
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
                        v vVar = new v();
                        vVar.setUserMap(hashMap);
                        vVar.a(list2.get(i3));
                        vVar.bA(0);
                        vVar.parser_title();
                        if (vVar.sq() == 33) {
                            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                this.mThreadList.add(vVar);
                            }
                        } else {
                            this.mThreadList.add(vVar);
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
        if (this.mThreadList.size() > 0 && this.mPage.rJ() == 1 && getOrginalMessage() != null && getOrginalMessage().getExtra() != null && (requestFrsHotThreadMessage = (RequestFrsHotThreadMessage) getOrginalMessage().getExtra()) != null) {
            this.mCache.k(String.valueOf(requestFrsHotThreadMessage.getForumId()), bArr);
        }
    }

    public ArrayList<u> getThreadList() {
        return this.mThreadList;
    }

    public n getPage() {
        return this.mPage;
    }
}
