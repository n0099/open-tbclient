package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.GetHotThread.GetHotThreadResIdl;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class FrsHotThreadResponseCacheMessage extends CustomResponsedMessage<Object> {
    private final q mPage;
    private final ArrayList<u> mThreadList;

    public FrsHotThreadResponseCacheMessage() {
        super(CmdConfigCustom.CMD_FRS_HOT_CACHE);
        this.mThreadList = new ArrayList<>();
        this.mPage = new q();
    }

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
                        z zVar = new z();
                        zVar.setUserMap(hashMap);
                        zVar.a(list2.get(i3));
                        zVar.bC(0);
                        zVar.parser_title();
                        this.mThreadList.add(zVar);
                    }
                }
                this.mPage.a(getHotThreadResIdl.data.page);
            }
        }
    }

    public ArrayList<u> getThreadList() {
        return this.mThreadList;
    }

    public q getPage() {
        return this.mPage;
    }
}
