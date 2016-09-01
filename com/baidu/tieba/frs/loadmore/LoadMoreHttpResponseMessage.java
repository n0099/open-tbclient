package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.recapp.f;
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
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Message<?> orginalMessage;
        ThreadListResIdl threadListResIdl = (ThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, ThreadListResIdl.class);
        if (threadListResIdl != null && threadListResIdl.error != null) {
            setError(threadListResIdl.error.errorno.intValue());
            setErrorString(threadListResIdl.error.usermsg);
            if (getError() == 0 && threadListResIdl.data != null) {
                if (y.s(threadListResIdl.data.user_list) > 0) {
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
                if (y.s(threadListResIdl.data.thread_list) > 0) {
                    this.threadList = new ArrayList<>();
                    List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
                    if (list2 != null) {
                        for (int i3 = 0; i3 < list2.size(); i3++) {
                            bg bgVar = new bg();
                            bgVar.setUserMap(this.userMap);
                            bgVar.a(list2.get(i3));
                            bgVar.si();
                            if (bgVar.getThreadType() == 33) {
                                aq aqVar = new aq();
                                aqVar.a(bgVar, 0);
                                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                    this.threadList.add(aqVar);
                                }
                            } else if (!TextUtils.isEmpty(bgVar.sv())) {
                                ad adVar = new ad();
                                adVar.cn(bgVar.sv());
                                this.threadList.add(adVar);
                            } else {
                                this.threadList.add(bgVar);
                            }
                        }
                    }
                }
                if (threadListResIdl.data.banner_list != null && (orginalMessage = getOrginalMessage()) != null && orginalMessage.getExtra() != null && (orginalMessage.getExtra() instanceof LoadMoreRequestMessage) && ((LoadMoreRequestMessage) orginalMessage.getExtra()).getPageType() == 1) {
                    addRecAppList(this.threadList, threadListResIdl.data.banner_list);
                }
            }
        }
    }

    private void addRecAppList(ArrayList<v> arrayList, BannerList bannerList) {
        int g;
        if (TbadkCoreApplication.m9getInst().isRecAppExist() && bannerList != null) {
            int s = y.s(arrayList);
            int s2 = y.s(bannerList.app);
            if (s > 0 && s2 > 0) {
                BannerListData bannerListData = new BannerListData();
                bannerListData.parserProtobuf(bannerList);
                int size = bannerListData.getAllAdvertList().size();
                HashSet hashSet = new HashSet();
                TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
                for (int i = 0; i < size; i++) {
                    com.baidu.tbadk.core.data.b bVar = bannerListData.getAllAdvertList().get(i);
                    if (bVar != null && bVar.pg() && com.baidu.adp.lib.h.b.g(bVar.Pf, 0) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && g < s) {
                        if (bVar.ph()) {
                            if (!f.isInstalledPackage(m9getInst, bVar.Pe) && !TextUtils.isEmpty(bVar.Pe) && !TextUtils.isEmpty(bVar.OZ)) {
                                boolean fh = com.baidu.tieba.recapp.b.a.bbr().fh(bVar.Pe);
                                boolean fj = com.baidu.tieba.recapp.b.a.bbr().fj(bVar.Pe);
                                if (fh) {
                                    bVar.OX = 1;
                                } else if (fj) {
                                    bVar.OX = 2;
                                } else {
                                    bVar.OX = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                arrayList.add(g, bVar);
                            }
                        } else if (bVar.pi()) {
                            hashSet.add(Integer.valueOf(g));
                            arrayList.add(g, bVar);
                        }
                    }
                }
            }
        }
    }
}
