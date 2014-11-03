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
    private boolean alJ;
    private com.baidu.tieba.data.u alK;
    private ForumData alQ;
    private com.baidu.tbadk.core.data.m alT;
    private UserData alX;
    private ArrayList<com.baidu.adp.widget.ListView.al> azP;
    private com.baidu.tieba.data.t azQ;
    private com.baidu.tieba.data.c azR;
    private boolean azS;
    private ArrayList<LiveCardData> azZ;
    private String fortune_desc;
    private String game_url;
    private HashMap<String, MetaData> userMap;
    private AntiData zQ;
    private int aky = 0;
    private dd azT = null;
    private dc azU = null;
    private boolean azV = false;
    private f azW = null;
    private c azX = null;
    private boolean azY = false;
    private long aAa = 0;
    private long aAb = 0;
    private long aAc = 0;
    private long aAd = 0;

    public boolean EY() {
        return this.azS;
    }

    public String EZ() {
        return this.game_url;
    }

    public ArrayList<LiveCardData> Fa() {
        return this.azZ;
    }

    public long Fb() {
        return this.aAd;
    }

    public long Fc() {
        return this.aAb;
    }

    public long Fd() {
        return this.aAc;
    }

    public long Fe() {
        return this.aAa;
    }

    public boolean Ff() {
        return this.alJ;
    }

    public b() {
        initData();
    }

    private void initData() {
        this.alQ = new ForumData();
        this.azP = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.alT = new com.baidu.tbadk.core.data.m();
        this.azQ = new com.baidu.tieba.data.t();
        this.alX = new UserData();
        this.alK = new com.baidu.tieba.data.u();
        b(new AntiData());
        a(new com.baidu.tieba.data.c());
    }

    public void a(com.baidu.tieba.data.aa aaVar) {
        if (aaVar != null) {
            this.alQ.setCurScore(aaVar.getCurScore());
            this.alQ.setLevelupScore(aaVar.getLevelupScore());
            this.alQ.setLike(aaVar.isLike());
            this.alQ.setUser_level(aaVar.zB());
            this.alQ.setLevelName(aaVar.getLevelName());
        }
    }

    public void a(SignData signData) {
        this.alQ.setSignData(signData);
    }

    public ForumData zL() {
        return this.alQ;
    }

    public void a(AnchorPower anchorPower) {
        this.alQ.setAnchorPower(anchorPower);
    }

    public void b(com.baidu.tbadk.core.data.q qVar) {
        while (!this.azP.isEmpty() && this.azP.get(0) != null && (this.azP.get(0) instanceof com.baidu.tbadk.core.data.q) && ((com.baidu.tbadk.core.data.q) this.azP.get(0)).getIs_top() == 2) {
            this.azP.remove(0);
        }
        this.azP.add(0, qVar);
    }

    public ArrayList<com.baidu.adp.widget.ListView.al> Fg() {
        return this.azP;
    }

    public UserData getUserData() {
        return this.alX;
    }

    public void b(AntiData antiData) {
        this.zQ = antiData;
    }

    public AntiData jZ() {
        return this.zQ;
    }

    public com.baidu.tbadk.core.data.m zO() {
        return this.alT;
    }

    public com.baidu.tieba.data.t Fh() {
        return this.azQ;
    }

    public void bR(boolean z) {
        this.azV = z;
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
                this.alJ = dataRes.fortune_bag.intValue() == 1;
                this.fortune_desc = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.azS = dataRes.forum.has_game.intValue() == 1;
                    this.game_url = dataRes.forum.game_url;
                }
                this.alK.a(dataRes.gcon_account);
                this.alQ.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list2 = dataRes.thread_list;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
                        qVar.setUserMap(this.userMap);
                        qVar.a(list2.get(i2));
                        qVar.parser_title();
                        this.azP.add(qVar);
                    }
                }
                this.zQ.parserProtobuf(dataRes.anti);
                this.azR.a(dataRes.group);
                this.alT.a(dataRes.page);
                this.azQ.a(dataRes.frs_star);
                this.alX.parserProtobuf(dataRes.user);
                List<AnchorInfo> list3 = dataRes.forum_livegroup_list;
                this.azZ = new ArrayList<>();
                if (list3 != null) {
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list3.get(i3));
                        this.azZ.add(liveCardData);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(FrsActivity frsActivity, FRSPageRequestMessage fRSPageRequestMessage, int i, boolean z, String str) {
        if (this.azW != null) {
            this.azW.cancel();
            this.azW = null;
        }
        this.azY = z;
        this.azW = new f(this, frsActivity, fRSPageRequestMessage, i, str);
        this.azW.setPriority(3);
        this.azW.execute(fRSPageRequestMessage);
    }

    public void clear() {
        if (this.azW != null) {
            this.azW.cancel();
            this.azW = null;
        }
        if (this.azX != null) {
            this.azX.cancel();
            this.azX = null;
        }
    }

    public void a(d dVar) {
        com.baidu.tieba.data.aa aaVar = new com.baidu.tieba.data.aa();
        aaVar.setLike(1);
        aaVar.ed(dVar.level);
        aaVar.setLevelName(dVar.aAk);
        aaVar.setCurScore(dVar.cur_score);
        aaVar.setLevelupScore(dVar.levelup_score);
        a(aaVar);
    }

    public void a(dd ddVar) {
        this.azT = ddVar;
    }

    public int yW() {
        return this.aky;
    }

    public void ee(int i) {
        this.aky = i;
    }

    public com.baidu.tieba.data.c Fi() {
        return this.azR;
    }

    public void a(com.baidu.tieba.data.c cVar) {
        this.azR = cVar;
    }

    public int Fj() {
        if (this.azP == null || this.azP.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.al> it = this.azP.iterator();
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
        if (this.alQ != null && (bannerListData = this.alQ.getBannerListData()) != null && bannerListData.jL() != null && this.azP != null && this.azP.size() > 0) {
            int size = this.azP.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    if (!(this.azP.get(i) instanceof com.baidu.tbadk.core.data.a)) {
                        i++;
                    } else {
                        this.azP.remove(i);
                        break;
                    }
                } else {
                    break;
                }
            }
            int size2 = this.azP.size();
            Iterator<com.baidu.adp.widget.ListView.al> it = this.azP.iterator();
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
                                boolean cV = com.baidu.tbadk.download.b.rj().cV(aVar.zl);
                                boolean cW = com.baidu.tbadk.download.b.rj().cW(aVar.zl);
                                if (cV) {
                                    aVar.zf = 1;
                                } else if (cW) {
                                    aVar.zf = 2;
                                } else {
                                    aVar.zf = 0;
                                }
                                hashSet.add(Integer.valueOf(i4));
                                this.azP.add(i4, aVar);
                            }
                        } else if (aVar.jH()) {
                            hashSet.add(Integer.valueOf(i4));
                            this.azP.add(i4, aVar);
                        }
                    }
                }
            }
        }
    }

    public void Fk() {
        boolean z = true;
        int i = 0;
        if (this.alQ != null && this.alT != null && this.alT.kf() == 1) {
            if (this.alK == null || !this.alK.zq()) {
                z = false;
            }
            if (this.alJ || z) {
                com.baidu.tieba.data.af afVar = new com.baidu.tieba.data.af();
                afVar.bq(this.alJ);
                afVar.ev(this.fortune_desc);
                afVar.a(this.alK);
                afVar.aT(1003);
                if (this.azP != null && this.azP.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.al> it = this.azP.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.al next = it.next();
                        if ((next instanceof com.baidu.tbadk.core.data.q) && ((com.baidu.tbadk.core.data.q) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.azP.add(i, afVar);
                }
            }
        }
    }

    public void Fl() {
        com.baidu.tbadk.core.data.o recommendLikeUser;
        int f;
        int i;
        if (this.alQ != null && (recommendLikeUser = this.alQ.getRecommendLikeUser()) != null && recommendLikeUser.km() != null && !TextUtils.isEmpty(recommendLikeUser.km().getName()) && this.azP != null && this.azP.size() > 0) {
            int size = this.azP.size();
            Iterator<com.baidu.adp.widget.ListView.al> it = this.azP.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.al next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.q) && ((com.baidu.tbadk.core.data.q) next).getIs_top() != 0) {
                    i2++;
                }
            }
            String kl = recommendLikeUser.kl();
            if (!TextUtils.isEmpty(kl) && !TextUtils.isEmpty(kl.trim()) && (f = com.baidu.adp.lib.g.c.f(kl, -1)) != -1 && (f + i2) - 1 < size) {
                this.azP.add(i, recommendLikeUser);
            }
        }
    }

    public com.baidu.tbadk.core.data.q fe(String str) {
        if (this.azP == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.al> it = this.azP.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.al next = it.next();
            if (next != null && (next instanceof com.baidu.tbadk.core.data.q) && TextUtils.equals(str, ((com.baidu.tbadk.core.data.q) next).getId())) {
                return (com.baidu.tbadk.core.data.q) next;
            }
        }
        return null;
    }

    public void c(com.baidu.tbadk.core.data.q qVar) {
        this.azP.remove(qVar);
    }
}
