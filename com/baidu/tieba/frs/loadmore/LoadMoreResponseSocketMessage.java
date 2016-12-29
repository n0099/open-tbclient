package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.c;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.recapp.l;
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
            com.baidu.tieba.recapp.c.a.aYn().pA(threadListResIdl.data.asp_shown_info);
            this.threadList = new ArrayList<>();
            List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
            if (list2 != null) {
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    bg bgVar = new bg();
                    bgVar.setUserMap(this.userMap);
                    bgVar.a(list2.get(i3));
                    bgVar.sl();
                    if (bgVar.getThreadType() == 33) {
                        at atVar = new at();
                        atVar.a(bgVar, 0);
                        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.threadList.add(atVar);
                        }
                    } else if (!TextUtils.isEmpty(bgVar.sy())) {
                        ag agVar = new ag();
                        agVar.cq(bgVar.sy());
                        this.threadList.add(agVar);
                    } else {
                        this.threadList.add(bgVar);
                    }
                }
            }
            if (threadListResIdl.data.banner_list != null && (orginalMessage = getOrginalMessage()) != null && orginalMessage.getExtra() != null && (orginalMessage.getExtra() instanceof LoadMoreRequestMessage) && ((LoadMoreRequestMessage) orginalMessage.getExtra()).getPageType() == 1) {
                addRecAppList(this.threadList, threadListResIdl.data.banner_list);
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
                            if (!l.isInstalledPackage(m9getInst, cVar.Pp) && !TextUtils.isEmpty(cVar.Pp) && !TextUtils.isEmpty(cVar.Pk)) {
                                boolean fi = com.baidu.tieba.recapp.b.a.aYh().fi(cVar.Pp);
                                boolean fk = com.baidu.tieba.recapp.b.a.aYh().fk(cVar.Pp);
                                if (fi) {
                                    cVar.Pi = 1;
                                } else if (fk) {
                                    cVar.Pi = 2;
                                } else {
                                    cVar.Pi = 0;
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
