package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bm;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.ThreadInfo;
import tbclient.ThreadList.ThreadListResIdl;
import tbclient.User;
/* loaded from: classes.dex */
public class LoadMoreResponseSocketMessage extends SocketResponsedMessage {
    private BannerListData bannerListData;
    private ArrayList<v> threadList;
    private HashMap<String, MetaData> userMap;

    public LoadMoreResponseSocketMessage() {
        super(301002);
    }

    public ArrayList<v> getThreadList() {
        return this.threadList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Message<?> orginalMessage;
        ThreadListResIdl threadListResIdl = (ThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, ThreadListResIdl.class);
        setError(threadListResIdl.error.errorno.intValue());
        setErrorString(threadListResIdl.error.usermsg);
        if (getError() == 0) {
            this.userMap = new HashMap<>();
            List<User> list = threadListResIdl.data.user_list;
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(list.get(i2));
                    String userId = metaData.getUserId();
                    if (userId != null && !userId.equals("0")) {
                        this.userMap.put(metaData.getUserId(), metaData);
                    }
                }
            }
            com.baidu.tieba.recapp.d.a.bex().qD(threadListResIdl.data.asp_shown_info);
            this.threadList = new ArrayList<>();
            List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
            if (list2 != null) {
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    bm bmVar = new bm();
                    bmVar.setUserMap(this.userMap);
                    bmVar.a(list2.get(i3));
                    bmVar.bW(3);
                    bmVar.rZ();
                    if (bmVar.getThreadType() == 33) {
                        ay ayVar = new ay();
                        ayVar.a(bmVar, 0);
                        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.threadList.add(ayVar);
                        }
                    } else if (!TextUtils.isEmpty(bmVar.sm())) {
                        ai aiVar = new ai();
                        aiVar.ct(bmVar.sm());
                        this.threadList.add(aiVar);
                    } else {
                        this.threadList.add(bmVar);
                    }
                }
            }
            this.bannerListData = null;
            if (threadListResIdl.data.banner_list != null && (orginalMessage = getOrginalMessage()) != null && orginalMessage.getExtra() != null && (orginalMessage.getExtra() instanceof LoadMoreRequestMessage) && ((LoadMoreRequestMessage) orginalMessage.getExtra()).getPageType() == 1) {
                this.bannerListData = new BannerListData();
                this.bannerListData.parserProtobuf(threadListResIdl.data.banner_list);
            }
        }
    }

    public BannerListData getBannerListData() {
        return this.bannerListData;
    }
}
