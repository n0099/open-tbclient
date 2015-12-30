package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.data.z;
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
        if (threadListResIdl != null && threadListResIdl.error != null) {
            setError(threadListResIdl.error.errorno.intValue());
            setErrorString(threadListResIdl.error.usermsg);
            if (getError() == 0 && threadListResIdl.data != null) {
                if (y.l(threadListResIdl.data.user_list) > 0) {
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
                }
                if (y.l(threadListResIdl.data.thread_list) > 0) {
                    this.threadList = new ArrayList<>();
                    List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
                    if (list2 != null) {
                        int i4 = -1;
                        while (true) {
                            int i5 = i4;
                            if (i2 >= list2.size()) {
                                break;
                            }
                            z zVar = new z();
                            zVar.setUserMap(this.userMap);
                            zVar.a(list2.get(i2));
                            zVar.parser_title();
                            if (zVar.getThreadType() == 33) {
                                w wVar = new w();
                                wVar.a(zVar, i5);
                                if (wVar.sh() != null) {
                                    i5 = wVar.sh().getShowStyle();
                                }
                                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                    this.threadList.add(wVar);
                                }
                            } else {
                                this.threadList.add(zVar);
                            }
                            i4 = i5;
                            i2++;
                        }
                    }
                }
                if (threadListResIdl.data.banner_list != null) {
                    addRecAppList(this.threadList, threadListResIdl.data.banner_list);
                }
            }
        }
    }

    private void addRecAppList(ArrayList<u> arrayList, BannerList bannerList) {
        int g;
        if (bannerList != null) {
            int l = y.l(arrayList);
            int l2 = y.l(bannerList.app);
            if (l > 0 && l2 > 0) {
                BannerListData bannerListData = new BannerListData();
                bannerListData.parserProtobuf(bannerList);
                int size = bannerListData.getAllAdvertList().size();
                HashSet hashSet = new HashSet();
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                for (int i = 0; i < size; i++) {
                    com.baidu.tbadk.core.data.b bVar = bannerListData.getAllAdvertList().get(i);
                    if (bVar != null && bVar.rk() && com.baidu.adp.lib.h.b.g(bVar.UT, 0) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && g < l) {
                        if (bVar.rl()) {
                            if (!ah.isInstalledPackage(m411getInst, bVar.US) && !TextUtils.isEmpty(bVar.US) && !TextUtils.isEmpty(bVar.UN)) {
                                boolean eX = com.baidu.tbadk.download.b.Bb().eX(bVar.US);
                                boolean fa = com.baidu.tbadk.download.b.Bb().fa(bVar.US);
                                if (eX) {
                                    bVar.UL = 1;
                                } else if (fa) {
                                    bVar.UL = 2;
                                } else {
                                    bVar.UL = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                arrayList.add(g, bVar);
                            }
                        } else if (bVar.rm()) {
                            hashSet.add(Integer.valueOf(g));
                            arrayList.add(g, bVar);
                        }
                    }
                }
            }
        }
    }
}
