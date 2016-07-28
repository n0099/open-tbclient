package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.tbadkCore.al;
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
            this.threadList = new ArrayList<>();
            List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
            if (list2 != null) {
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    be beVar = new be();
                    beVar.setUserMap(this.userMap);
                    beVar.a(list2.get(i3));
                    beVar.rd();
                    if (beVar.getThreadType() == 33) {
                        ao aoVar = new ao();
                        aoVar.a(beVar, 0);
                        if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.threadList.add(aoVar);
                        }
                    } else if (!TextUtils.isEmpty(beVar.rq())) {
                        ac acVar = new ac();
                        acVar.cm(beVar.rq());
                        this.threadList.add(acVar);
                    } else {
                        this.threadList.add(beVar);
                    }
                }
            }
            if (threadListResIdl.data.banner_list != null) {
                addRecAppList(this.threadList, threadListResIdl.data.banner_list);
            }
        }
    }

    private void addRecAppList(ArrayList<v> arrayList, BannerList bannerList) {
        int g;
        if (bannerList != null) {
            int s = y.s(arrayList);
            int s2 = y.s(bannerList.app);
            if (s > 0 && s2 > 0) {
                BannerListData bannerListData = new BannerListData();
                bannerListData.parserProtobuf(bannerList);
                int size = bannerListData.getAllAdvertList().size();
                HashSet hashSet = new HashSet();
                TbadkCoreApplication m10getInst = TbadkCoreApplication.m10getInst();
                for (int i = 0; i < size; i++) {
                    com.baidu.tbadk.core.data.b bVar = bannerListData.getAllAdvertList().get(i);
                    if (bVar != null && bVar.ok() && com.baidu.adp.lib.h.b.g(bVar.MM, 0) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && g < s) {
                        if (bVar.ol()) {
                            if (!al.isInstalledPackage(m10getInst, bVar.MK) && !TextUtils.isEmpty(bVar.MK) && !TextUtils.isEmpty(bVar.MF)) {
                                boolean fe = com.baidu.tbadk.download.b.Ba().fe(bVar.MK);
                                boolean fh = com.baidu.tbadk.download.b.Ba().fh(bVar.MK);
                                if (fe) {
                                    bVar.MD = 1;
                                } else if (fh) {
                                    bVar.MD = 2;
                                } else {
                                    bVar.MD = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                arrayList.add(g, bVar);
                            }
                        } else if (bVar.om()) {
                            hashSet.add(Integer.valueOf(g));
                            arrayList.add(g, bVar);
                        }
                    }
                }
            }
        }
    }
}
