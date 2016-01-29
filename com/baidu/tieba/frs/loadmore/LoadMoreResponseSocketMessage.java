package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.c;
import com.baidu.tbadk.core.util.x;
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
                    ah ahVar = new ah();
                    ahVar.setUserMap(this.userMap);
                    ahVar.a(list2.get(i2));
                    ahVar.parser_title();
                    if (ahVar.getThreadType() == 33) {
                        ab abVar = new ab();
                        abVar.a(ahVar, i5);
                        if (abVar.sS() != null) {
                            i5 = abVar.sS().getShowStyle();
                        }
                        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.threadList.add(abVar);
                        }
                    } else {
                        this.threadList.add(ahVar);
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
            int o = x.o(arrayList);
            int o2 = x.o(bannerList.app);
            if (o > 0 && o2 > 0) {
                BannerListData bannerListData = new BannerListData();
                bannerListData.parserProtobuf(bannerList);
                int size = bannerListData.getAllAdvertList().size();
                HashSet hashSet = new HashSet();
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                for (int i = 0; i < size; i++) {
                    c cVar = bannerListData.getAllAdvertList().get(i);
                    if (cVar != null && cVar.rM() && com.baidu.adp.lib.h.b.g(cVar.Uz, 0) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && g < o) {
                        if (cVar.rN()) {
                            if (!ag.isInstalledPackage(m411getInst, cVar.Uy) && !TextUtils.isEmpty(cVar.Uy) && !TextUtils.isEmpty(cVar.Uu)) {
                                boolean eW = com.baidu.tbadk.download.b.Cr().eW(cVar.Uy);
                                boolean eZ = com.baidu.tbadk.download.b.Cr().eZ(cVar.Uy);
                                if (eW) {
                                    cVar.Us = 1;
                                } else if (eZ) {
                                    cVar.Us = 2;
                                } else {
                                    cVar.Us = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                arrayList.add(g, cVar);
                            }
                        } else if (cVar.rO()) {
                            hashSet.add(Integer.valueOf(g));
                            arrayList.add(g, cVar);
                        }
                    }
                }
            }
        }
    }
}
