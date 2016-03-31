package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.c;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.tbadkCore.ag;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import tbclient.BannerList;
import tbclient.ThreadInfo;
import tbclient.ThreadList.ThreadListResIdl;
import tbclient.User;
/* loaded from: classes.dex */
public class LoadMoreResponseSocketMessage extends SocketResponsedMessage {
    private ArrayList<u> threadList;
    private HashMap<String, MetaData> userMap;

    public LoadMoreResponseSocketMessage() {
        super(301002);
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
                    if (i2 >= list2.size()) {
                        break;
                    }
                    as asVar = new as();
                    asVar.setUserMap(this.userMap);
                    asVar.a(list2.get(i2));
                    asVar.parser_title();
                    if (asVar.getThreadType() == 33) {
                        am amVar = new am();
                        amVar.a(asVar, i5);
                        if (amVar.sT() != null) {
                            i5 = amVar.sT().getShowStyle();
                        }
                        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.threadList.add(amVar);
                        }
                    } else {
                        this.threadList.add(asVar);
                    }
                    i4 = i5;
                    i2++;
                }
            }
            if (threadListResIdl.data.banner_list != null) {
                addRecAppList(this.threadList, threadListResIdl.data.banner_list);
            }
        }
    }

    private void addRecAppList(ArrayList<u> arrayList, BannerList bannerList) {
        int g;
        if (bannerList != null) {
            int p = y.p(arrayList);
            int p2 = y.p(bannerList.app);
            if (p > 0 && p2 > 0) {
                BannerListData bannerListData = new BannerListData();
                bannerListData.parserProtobuf(bannerList);
                int size = bannerListData.getAllAdvertList().size();
                HashSet hashSet = new HashSet();
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                for (int i = 0; i < size; i++) {
                    c cVar = bannerListData.getAllAdvertList().get(i);
                    if (cVar != null && cVar.rk() && com.baidu.adp.lib.h.b.g(cVar.Sf, 0) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && g < p) {
                        if (cVar.rl()) {
                            if (!ag.isInstalledPackage(m411getInst, cVar.Se) && !TextUtils.isEmpty(cVar.Se) && !TextUtils.isEmpty(cVar.Sa)) {
                                boolean fd = com.baidu.tbadk.download.b.CX().fd(cVar.Se);
                                boolean fg = com.baidu.tbadk.download.b.CX().fg(cVar.Se);
                                if (fd) {
                                    cVar.RY = 1;
                                } else if (fg) {
                                    cVar.RY = 2;
                                } else {
                                    cVar.RY = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                arrayList.add(g, cVar);
                            }
                        } else if (cVar.rm()) {
                            hashSet.add(Integer.valueOf(g));
                            arrayList.add(g, cVar);
                        }
                    }
                }
            }
        }
    }
}
