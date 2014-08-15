package com.baidu.tieba.frs;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.UserData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.AnchorInfo;
import tbclient.FrsPage.AnchorPower;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class g {
    private ForumData a;
    private ArrayList<com.baidu.tbadk.core.data.n> b;
    private AntiData c;
    private com.baidu.tbadk.core.data.l d;
    private com.baidu.tieba.data.t e;
    private boolean f;
    private String g;
    private com.baidu.tieba.data.u h;
    private UserData i;
    private com.baidu.tieba.data.c j;
    private boolean k;
    private String l;
    private ArrayList<LiveCardData> t;
    private HashMap<String, MetaData> u;
    private int m = 0;
    private dl n = null;
    private dk o = null;
    private boolean p = false;
    private k q = null;
    private h r = null;
    private boolean s = false;
    private long v = 0;
    private long w = 0;
    private long x = 0;
    private long y = 0;

    public boolean a() {
        return this.k;
    }

    public String b() {
        return this.l;
    }

    public ArrayList<LiveCardData> c() {
        return this.t;
    }

    public long d() {
        return this.y;
    }

    public long e() {
        return this.w;
    }

    public long f() {
        return this.x;
    }

    public long g() {
        return this.v;
    }

    public boolean h() {
        return this.f;
    }

    public g() {
        u();
    }

    private void u() {
        this.a = new ForumData();
        this.b = new ArrayList<>();
        this.u = new HashMap<>();
        this.d = new com.baidu.tbadk.core.data.l();
        this.e = new com.baidu.tieba.data.t();
        this.i = new UserData();
        this.h = new com.baidu.tieba.data.u();
        a(new AntiData());
        a(new com.baidu.tieba.data.c());
    }

    public void a(com.baidu.tieba.data.ab abVar) {
        if (abVar != null) {
            this.a.setCurScore(abVar.e());
            this.a.setLevelupScore(abVar.f());
            this.a.setLike(abVar.c());
            this.a.setUser_level(abVar.b());
            this.a.setLevelName(abVar.d());
        }
    }

    public void a(SignData signData) {
        this.a.setSignData(signData);
    }

    public ForumData i() {
        return this.a;
    }

    public void a(AnchorPower anchorPower) {
        this.a.setAnchorPower(anchorPower);
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        while (!this.b.isEmpty() && this.b.get(0) != null && this.b.get(0).m() == 2) {
            this.b.remove(0);
        }
        this.b.add(0, nVar);
    }

    public ArrayList<com.baidu.tbadk.core.data.n> j() {
        return this.b;
    }

    public UserData k() {
        return this.i;
    }

    public void a(AntiData antiData) {
        this.c = antiData;
    }

    public AntiData l() {
        return this.c;
    }

    public com.baidu.tbadk.core.data.l m() {
        return this.d;
    }

    public com.baidu.tieba.data.t n() {
        return this.e;
    }

    public void a(boolean z) {
        this.p = z;
    }

    public boolean o() {
        return this.p;
    }

    public FrsPageResIdl a(byte[] bArr) {
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
                u();
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.u.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                a(dataRes.is_new_url.intValue());
                this.f = dataRes.fortune_bag.intValue() == 1;
                this.g = dataRes.fortune_desc;
                this.k = dataRes.forum.has_game.intValue() == 1;
                this.l = dataRes.forum.game_url;
                this.h.a(dataRes.gcon_account);
                this.a.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list2 = dataRes.thread_list;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                        nVar.a(this.u);
                        nVar.a(list2.get(i2));
                        nVar.D();
                        this.b.add(nVar);
                    }
                }
                this.c.parserProtobuf(dataRes.anti);
                this.j.a(dataRes.group);
                this.d.a(dataRes.page);
                this.e.a(dataRes.frs_star);
                this.i.parserProtobuf(dataRes.user);
                List<AnchorInfo> list3 = dataRes.forum_livegroup_list;
                this.t = new ArrayList<>();
                if (list3 != null) {
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list3.get(i3));
                        this.t.add(liveCardData);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(FrsActivity frsActivity, FRSPageRequestMessage fRSPageRequestMessage, int i, boolean z, String str) {
        if (this.q != null) {
            this.q.cancel();
            this.q = null;
        }
        this.s = z;
        this.q = new k(this, frsActivity, fRSPageRequestMessage, i, str);
        this.q.setPriority(3);
        this.q.execute(fRSPageRequestMessage);
    }

    public void a(String str) {
        if (this.r != null) {
            this.r.cancel();
            this.r = null;
        }
        ForumData i = i();
        this.r = new h(this, i.getId(), i.getName(), str);
        this.r.setPriority(2);
        this.r.execute(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/user/fansno");
    }

    public void p() {
        if (this.q != null) {
            this.q.cancel();
            this.q = null;
        }
        if (this.r != null) {
            this.r.cancel();
            this.r = null;
        }
    }

    public void a(i iVar) {
        com.baidu.tieba.data.ab abVar = new com.baidu.tieba.data.ab();
        abVar.b(1);
        abVar.a(iVar.d);
        abVar.c(iVar.e);
        abVar.e(iVar.f);
        abVar.f(iVar.g);
        a(abVar);
    }

    public void a(dl dlVar) {
        this.n = dlVar;
    }

    public void a(dk dkVar) {
        this.o = dkVar;
    }

    public int q() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
    }

    public com.baidu.tieba.data.c r() {
        return this.j;
    }

    public void a(com.baidu.tieba.data.c cVar) {
        this.j = cVar;
    }

    public com.baidu.tieba.data.u s() {
        return this.h;
    }

    public String t() {
        return this.g;
    }
}
