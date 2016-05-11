package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.c;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.tbadkCore.ah;
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
public class LoadMoreHttpResponseMessage extends HttpResponsedMessage {
    private ArrayList<v> threadList;
    private HashMap<String, MetaData> userMap;

    public LoadMoreHttpResponseMessage(int i) {
        super(i);
    }

    public ArrayList<v> getThreadList() {
        return this.threadList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        ThreadListResIdl threadListResIdl = (ThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, ThreadListResIdl.class);
        if (threadListResIdl != null && threadListResIdl.error != null) {
            setError(threadListResIdl.error.errorno.intValue());
            setErrorString(threadListResIdl.error.usermsg);
            if (getError() == 0 && threadListResIdl.data != null) {
                if (y.r(threadListResIdl.data.user_list) > 0) {
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
                }
                if (y.r(threadListResIdl.data.thread_list) > 0) {
                    this.threadList = new ArrayList<>();
                    List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
                    if (list2 != null) {
                        for (int i3 = 0; i3 < list2.size(); i3++) {
                            ax axVar = new ax();
                            axVar.setUserMap(this.userMap);
                            axVar.a(list2.get(i3));
                            axVar.parser_title();
                            if (axVar.getThreadType() == 33) {
                                ag agVar = new ag();
                                agVar.a(axVar, 0);
                                if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                    this.threadList.add(agVar);
                                }
                            } else {
                                this.threadList.add(axVar);
                            }
                        }
                    }
                }
                if (threadListResIdl.data.banner_list != null) {
                    addRecAppList(this.threadList, threadListResIdl.data.banner_list);
                }
            }
        }
    }

    private void addRecAppList(ArrayList<v> arrayList, BannerList bannerList) {
        int g;
        if (bannerList != null) {
            int r = y.r(arrayList);
            int r2 = y.r(bannerList.app);
            if (r > 0 && r2 > 0) {
                BannerListData bannerListData = new BannerListData();
                bannerListData.parserProtobuf(bannerList);
                int size = bannerListData.getAllAdvertList().size();
                HashSet hashSet = new HashSet();
                TbadkCoreApplication m11getInst = TbadkCoreApplication.m11getInst();
                for (int i = 0; i < size; i++) {
                    c cVar = bannerListData.getAllAdvertList().get(i);
                    if (cVar != null && cVar.oF() && com.baidu.adp.lib.h.b.g(cVar.MT, 0) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && g < r) {
                        if (cVar.oG()) {
                            if (!ah.isInstalledPackage(m11getInst, cVar.MS) && !TextUtils.isEmpty(cVar.MS) && !TextUtils.isEmpty(cVar.MO)) {
                                boolean fa = com.baidu.tbadk.download.b.AQ().fa(cVar.MS);
                                boolean fd = com.baidu.tbadk.download.b.AQ().fd(cVar.MS);
                                if (fa) {
                                    cVar.MM = 1;
                                } else if (fd) {
                                    cVar.MM = 2;
                                } else {
                                    cVar.MM = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                arrayList.add(g, cVar);
                            }
                        } else if (cVar.oH()) {
                            hashSet.add(Integer.valueOf(g));
                            arrayList.add(g, cVar);
                        }
                    }
                }
            }
        }
    }
}
