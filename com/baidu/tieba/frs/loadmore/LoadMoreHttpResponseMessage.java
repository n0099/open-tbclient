package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.c;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.recapp.g;
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
                if (x.s(threadListResIdl.data.user_list) > 0) {
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
                if (x.s(threadListResIdl.data.thread_list) > 0) {
                    this.threadList = new ArrayList<>();
                    List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
                    if (list2 != null) {
                        for (int i3 = 0; i3 < list2.size(); i3++) {
                            bk bkVar = new bk();
                            bkVar.setUserMap(this.userMap);
                            bkVar.a(list2.get(i3));
                            bkVar.sw();
                            if (bkVar.getThreadType() == 33) {
                                au auVar = new au();
                                auVar.a(bkVar, 0);
                                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                    this.threadList.add(auVar);
                                }
                            } else if (!TextUtils.isEmpty(bkVar.sJ())) {
                                ah ahVar = new ah();
                                ahVar.cp(bkVar.sJ());
                                this.threadList.add(ahVar);
                            } else {
                                this.threadList.add(bkVar);
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
            int s = x.s(arrayList);
            int s2 = x.s(bannerList.app);
            if (s > 0 && s2 > 0) {
                BannerListData bannerListData = new BannerListData();
                bannerListData.parserProtobuf(bannerList);
                int size = bannerListData.getAllAdvertList().size();
                HashSet hashSet = new HashSet();
                TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
                for (int i = 0; i < size; i++) {
                    c cVar = bannerListData.getAllAdvertList().get(i);
                    if (cVar != null && cVar.pj() && com.baidu.adp.lib.h.b.g(cVar.adPosition, 0) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && g < s) {
                        if (cVar.pk()) {
                            if (!g.isInstalledPackage(m9getInst, cVar.Ps) && !TextUtils.isEmpty(cVar.Ps) && !TextUtils.isEmpty(cVar.Pn)) {
                                boolean fm = com.baidu.tieba.recapp.b.a.beu().fm(cVar.Ps);
                                boolean fo = com.baidu.tieba.recapp.b.a.beu().fo(cVar.Ps);
                                if (fm) {
                                    cVar.Pl = 1;
                                } else if (fo) {
                                    cVar.Pl = 2;
                                } else {
                                    cVar.Pl = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                arrayList.add(g, cVar);
                            }
                        } else if (cVar.pl()) {
                            hashSet.add(Integer.valueOf(g));
                            arrayList.add(g, cVar);
                        }
                    }
                }
            }
        }
    }
}
