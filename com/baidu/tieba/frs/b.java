package com.baidu.tieba.frs;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.UserData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tbclient.AnchorInfo;
import tbclient.FrsPage.AnchorPower;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class b {
    private boolean alA;
    private com.baidu.tieba.data.u alB;
    private ForumData alH;
    private com.baidu.tbadk.core.data.m alK;
    private UserData alO;
    private ArrayList<com.baidu.adp.widget.ListView.al> azG;
    private com.baidu.tieba.data.t azH;
    private com.baidu.tieba.data.c azI;
    private boolean azJ;
    private ArrayList<LiveCardData> azQ;
    private String fortune_desc;
    private String game_url;
    private HashMap<String, MetaData> userMap;
    private AntiData zQ;
    private int akp = 0;
    private dd azK = null;
    private dc azL = null;
    private boolean azM = false;
    private f azN = null;
    private c azO = null;
    private boolean azP = false;
    private long azR = 0;
    private long azS = 0;
    private long azT = 0;
    private long azU = 0;

    public boolean EW() {
        return this.azJ;
    }

    public String EX() {
        return this.game_url;
    }

    public ArrayList<LiveCardData> EY() {
        return this.azQ;
    }

    public long EZ() {
        return this.azU;
    }

    public long Fa() {
        return this.azS;
    }

    public long Fb() {
        return this.azT;
    }

    public long Fc() {
        return this.azR;
    }

    public boolean Fd() {
        return this.alA;
    }

    public b() {
        initData();
    }

    private void initData() {
        this.alH = new ForumData();
        this.azG = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.alK = new com.baidu.tbadk.core.data.m();
        this.azH = new com.baidu.tieba.data.t();
        this.alO = new UserData();
        this.alB = new com.baidu.tieba.data.u();
        b(new AntiData());
        a(new com.baidu.tieba.data.c());
    }

    public void a(com.baidu.tieba.data.aa aaVar) {
        if (aaVar != null) {
            this.alH.setCurScore(aaVar.getCurScore());
            this.alH.setLevelupScore(aaVar.getLevelupScore());
            this.alH.setLike(aaVar.isLike());
            this.alH.setUser_level(aaVar.zz());
            this.alH.setLevelName(aaVar.getLevelName());
        }
    }

    public void a(SignData signData) {
        this.alH.setSignData(signData);
    }

    public ForumData zJ() {
        return this.alH;
    }

    public void a(AnchorPower anchorPower) {
        this.alH.setAnchorPower(anchorPower);
    }

    public void b(com.baidu.tbadk.core.data.q qVar) {
        while (!this.azG.isEmpty() && this.azG.get(0) != null && (this.azG.get(0) instanceof com.baidu.tbadk.core.data.q) && ((com.baidu.tbadk.core.data.q) this.azG.get(0)).getIs_top() == 2) {
            this.azG.remove(0);
        }
        this.azG.add(0, qVar);
    }

    public ArrayList<com.baidu.adp.widget.ListView.al> Fe() {
        return this.azG;
    }

    public UserData getUserData() {
        return this.alO;
    }

    public void b(AntiData antiData) {
        this.zQ = antiData;
    }

    public AntiData jZ() {
        return this.zQ;
    }

    public com.baidu.tbadk.core.data.m zM() {
        return this.alK;
    }

    public com.baidu.tieba.data.t Ff() {
        return this.azH;
    }

    public void bR(boolean z) {
        this.azM = z;
    }

    public FrsPageResIdl A(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) new Wire(new Class[0]).parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl != null && frsPageResIdl.data != null) {
                a(frsPageResIdl.data);
                return frsPageResIdl;
            }
            return frsPageResIdl;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                initData();
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.userMap.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                ee(dataRes.is_new_url.intValue());
                this.alA = dataRes.fortune_bag.intValue() == 1;
                this.fortune_desc = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.azJ = dataRes.forum.has_game.intValue() == 1;
                    this.game_url = dataRes.forum.game_url;
                }
                this.alB.a(dataRes.gcon_account);
                this.alH.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list2 = dataRes.thread_list;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
                        qVar.setUserMap(this.userMap);
                        qVar.a(list2.get(i2));
                        qVar.parser_title();
                        this.azG.add(qVar);
                    }
                }
                this.zQ.parserProtobuf(dataRes.anti);
                this.azI.a(dataRes.group);
                this.alK.a(dataRes.page);
                this.azH.a(dataRes.frs_star);
                this.alO.parserProtobuf(dataRes.user);
                List<AnchorInfo> list3 = dataRes.forum_livegroup_list;
                this.azQ = new ArrayList<>();
                if (list3 != null) {
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list3.get(i3));
                        this.azQ.add(liveCardData);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(FrsActivity frsActivity, FRSPageRequestMessage fRSPageRequestMessage, int i, boolean z, String str) {
        if (this.azN != null) {
            this.azN.cancel();
            this.azN = null;
        }
        this.azP = z;
        this.azN = new f(this, frsActivity, fRSPageRequestMessage, i, str);
        this.azN.setPriority(3);
        this.azN.execute(fRSPageRequestMessage);
    }

    public void clear() {
        if (this.azN != null) {
            this.azN.cancel();
            this.azN = null;
        }
        if (this.azO != null) {
            this.azO.cancel();
            this.azO = null;
        }
    }

    public void a(d dVar) {
        com.baidu.tieba.data.aa aaVar = new com.baidu.tieba.data.aa();
        aaVar.setLike(1);
        aaVar.ed(dVar.level);
        aaVar.setLevelName(dVar.aAb);
        aaVar.setCurScore(dVar.cur_score);
        aaVar.setLevelupScore(dVar.levelup_score);
        a(aaVar);
    }

    public void a(dd ddVar) {
        this.azK = ddVar;
    }

    public int yU() {
        return this.akp;
    }

    public void ee(int i) {
        this.akp = i;
    }

    public com.baidu.tieba.data.c Fg() {
        return this.azI;
    }

    public void a(com.baidu.tieba.data.c cVar) {
        this.azI = cVar;
    }

    public int Fh() {
        if (this.azG == null || this.azG.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.al> it = this.azG.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.al next = it.next();
            if (next instanceof com.baidu.tbadk.core.data.q) {
                if (((com.baidu.tbadk.core.data.q) next).getIs_top() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    public void U(Context context) {
        com.baidu.tbadk.core.data.d bannerListData;
        if (this.alH != null && (bannerListData = this.alH.getBannerListData()) != null && bannerListData.jL() != null && this.azG != null && this.azG.size() > 0) {
            int size = this.azG.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    if (!(this.azG.get(i) instanceof com.baidu.tbadk.core.data.a)) {
                        i++;
                    } else {
                        this.azG.remove(i);
                        break;
                    }
                } else {
                    break;
                }
            }
            int size2 = this.azG.size();
            Iterator<com.baidu.adp.widget.ListView.al> it = this.azG.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.al next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.q) && ((com.baidu.tbadk.core.data.q) next).getIs_top() != 0) {
                    i2++;
                }
            }
            int size3 = bannerListData.jL().size();
            if (size3 >= 1) {
                HashSet hashSet = new HashSet();
                for (int i3 = 0; i3 < size3; i3++) {
                    com.baidu.tbadk.core.data.a aVar = bannerListData.jL().get(i3);
                    int i4 = (aVar.zm + i2) - 1;
                    if (!hashSet.contains(Integer.valueOf(i4)) && aVar != null && aVar.jF() && i4 < size2) {
                        if (aVar.jG()) {
                            if (!com.baidu.tieba.d.b.E(context, aVar.zl) && !TextUtils.isEmpty(aVar.zl) && !TextUtils.isEmpty(aVar.zh)) {
                                boolean cV = com.baidu.tbadk.download.b.rh().cV(aVar.zl);
                                boolean cW = com.baidu.tbadk.download.b.rh().cW(aVar.zl);
                                if (cV) {
                                    aVar.zf = 1;
                                } else if (cW) {
                                    aVar.zf = 2;
                                } else {
                                    aVar.zf = 0;
                                }
                                hashSet.add(Integer.valueOf(i4));
                                this.azG.add(i4, aVar);
                            }
                        } else if (aVar.jH()) {
                            hashSet.add(Integer.valueOf(i4));
                            this.azG.add(i4, aVar);
                        }
                    }
                }
            }
        }
    }

    public void Fi() {
        boolean z = true;
        int i = 0;
        if (this.alH != null && this.alK != null && this.alK.kf() == 1) {
            if (this.alB == null || !this.alB.zo()) {
                z = false;
            }
            if (this.alA || z) {
                com.baidu.tieba.data.af afVar = new com.baidu.tieba.data.af();
                afVar.bq(this.alA);
                afVar.ev(this.fortune_desc);
                afVar.a(this.alB);
                afVar.aT(1003);
                if (this.azG != null && this.azG.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.al> it = this.azG.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.al next = it.next();
                        if ((next instanceof com.baidu.tbadk.core.data.q) && ((com.baidu.tbadk.core.data.q) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.azG.add(i, afVar);
                }
            }
        }
    }

    public void Fj() {
        com.baidu.tbadk.core.data.o recommendLikeUser;
        int f;
        int i;
        if (this.alH != null && (recommendLikeUser = this.alH.getRecommendLikeUser()) != null && recommendLikeUser.km() != null && !TextUtils.isEmpty(recommendLikeUser.km().getName()) && this.azG != null && this.azG.size() > 0) {
            int size = this.azG.size();
            Iterator<com.baidu.adp.widget.ListView.al> it = this.azG.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.al next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.q) && ((com.baidu.tbadk.core.data.q) next).getIs_top() != 0) {
                    i2++;
                }
            }
            String kl = recommendLikeUser.kl();
            if (!TextUtils.isEmpty(kl) && !TextUtils.isEmpty(kl.trim()) && (f = com.baidu.adp.lib.g.c.f(kl, -1)) != -1 && (f + i2) - 1 < size) {
                this.azG.add(i, recommendLikeUser);
            }
        }
    }

    public com.baidu.tbadk.core.data.q fe(String str) {
        if (this.azG == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.al> it = this.azG.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.al next = it.next();
            if (next != null && (next instanceof com.baidu.tbadk.core.data.q) && TextUtils.equals(str, ((com.baidu.tbadk.core.data.q) next).getId())) {
                return (com.baidu.tbadk.core.data.q) next;
            }
        }
        return null;
    }

    public void c(com.baidu.tbadk.core.data.q qVar) {
        this.azG.remove(qVar);
    }
}
