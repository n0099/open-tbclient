package com.baidu.tieba.frs.loadmore;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.data.w;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.ThreadInfo;
import tbclient.ThreadList.ThreadListResIdl;
import tbclient.User;
/* loaded from: classes.dex */
public class LoadMoreHttpResponseMessage extends HttpResponsedMessage {
    private ArrayList<u> threadList;
    private HashMap<String, MetaData> userMap;

    public LoadMoreHttpResponseMessage(int i) {
        super(i);
    }

    public ArrayList<u> getThreadList() {
        return this.threadList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        int i2 = 0;
        ThreadListResIdl threadListResIdl = (ThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, ThreadListResIdl.class);
        setError(threadListResIdl.error.errorno.intValue());
        setErrorString(threadListResIdl.error.usermsg);
        if (getError() == 0) {
            this.userMap = new HashMap<>();
            List<User> list = threadListResIdl.data.user_list;
            if (list != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(list.get(i3));
                    String userId = metaData.getUserId();
                    if (userId != null && !userId.equals("0")) {
                        this.userMap.put(metaData.getUserId(), metaData);
                    }
                }
            }
            this.threadList = new ArrayList<>();
            List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
            if (list2 != null) {
                int i4 = -1;
                while (true) {
                    int i5 = i4;
                    if (i2 < list2.size()) {
                        w wVar = new w();
                        wVar.setUserMap(this.userMap);
                        wVar.a(list2.get(i2));
                        wVar.parser_title();
                        if (wVar.sn() == 33) {
                            t tVar = new t();
                            tVar.a(wVar, i5);
                            if (tVar.rZ() != null) {
                                i5 = tVar.rZ().getShowStyle();
                            }
                            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                this.threadList.add(tVar);
                            }
                        } else {
                            this.threadList.add(wVar);
                        }
                        i4 = i5;
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
