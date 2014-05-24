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
    private com.baidu.tieba.data.s e;
    private boolean f;
    private UserData g;
    private com.baidu.tieba.data.b h;
    private ArrayList<LiveCardData> p;
    private HashMap<String, MetaData> q;
    private int i = 0;
    private dh j = null;
    private dg k = null;
    private boolean l = false;
    private k m = null;
    private h n = null;
    private boolean o = false;
    private long r = 0;
    private long s = 0;
    private long t = 0;
    private long u = 0;

    public ArrayList<LiveCardData> a() {
        return this.p;
    }

    public long b() {
        return this.u;
    }

    public long c() {
        return this.s;
    }

    public long d() {
        return this.t;
    }

    public long e() {
        return this.r;
    }

    public boolean f() {
        return this.f;
    }

    public g() {
        q();
    }

    private void q() {
        this.a = new ForumData();
        this.b = new ArrayList<>();
        this.q = new HashMap<>();
        this.d = new com.baidu.tbadk.core.data.l();
        this.e = new com.baidu.tieba.data.s();
        this.g = new UserData();
        a(new AntiData());
        a(new com.baidu.tieba.data.b());
    }

    public void a(com.baidu.tieba.data.z zVar) {
        this.a.setCurScore(zVar.e());
        this.a.setLevelupScore(zVar.f());
        this.a.setLike(zVar.c());
        this.a.setUser_level(zVar.b());
        this.a.setLevelName(zVar.d());
    }

    public void a(SignData signData) {
        this.a.setSignData(signData);
    }

    public ForumData g() {
        return this.a;
    }

    public void a(AnchorPower anchorPower) {
        this.a.setAnchorPower(anchorPower);
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        while (!this.b.isEmpty() && this.b.get(0).u() == 2) {
            this.b.remove(0);
        }
        this.b.add(0, nVar);
    }

    public ArrayList<com.baidu.tbadk.core.data.n> h() {
        return this.b;
    }

    public UserData i() {
        return this.g;
    }

    public void a(AntiData antiData) {
        this.c = antiData;
    }

    public AntiData j() {
        return this.c;
    }

    public com.baidu.tbadk.core.data.l k() {
        return this.d;
    }

    public com.baidu.tieba.data.s l() {
        return this.e;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public boolean m() {
        return this.l;
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
                q();
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.q.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                a(dataRes.is_new_url.intValue());
                this.f = dataRes.fortune_bag.intValue() == 1;
                this.a.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list2 = dataRes.thread_list;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                        nVar.a(this.q);
                        nVar.a(list2.get(i2));
                        nVar.L();
                        this.b.add(nVar);
                    }
                }
                this.c.parserProtobuf(dataRes.anti);
                this.h.a(dataRes.group);
                this.d.a(dataRes.page);
                this.e.a(dataRes.frs_star);
                this.g.parserProtobuf(dataRes.user);
                List<AnchorInfo> list3 = dataRes.forum_livegroup_list;
                this.p = new ArrayList<>();
                if (list3 != null) {
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list3.get(i3));
                        this.p.add(liveCardData);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(FrsActivity frsActivity, FRSPageRequestMessage fRSPageRequestMessage, int i, boolean z, String str) {
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
        this.o = z;
        this.m = new k(this, frsActivity, fRSPageRequestMessage, i, str);
        this.m.setPriority(3);
        this.m.execute(fRSPageRequestMessage);
    }

    public void a(String str) {
        if (this.n != null) {
            this.n.cancel();
            this.n = null;
        }
        ForumData g = g();
        this.n = new h(this, g.getId(), g.getName(), str);
        this.n.setPriority(2);
        this.n.execute(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/user/fansno");
    }

    public void n() {
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
        if (this.n != null) {
            this.n.cancel();
            this.n = null;
        }
    }

    public void a(i iVar) {
        com.baidu.tieba.data.z zVar = new com.baidu.tieba.data.z();
        zVar.b(1);
        zVar.a(iVar.d);
        zVar.c(iVar.e);
        zVar.e(iVar.f);
        zVar.f(iVar.g);
        a(zVar);
    }

    public void a(dh dhVar) {
        this.j = dhVar;
    }

    public void a(dg dgVar) {
        this.k = dgVar;
    }

    public int o() {
        return this.i;
    }

    public void a(int i) {
        this.i = i;
    }

    public com.baidu.tieba.data.b p() {
        return this.h;
    }

    public void a(com.baidu.tieba.data.b bVar) {
        this.h = bVar;
    }
}
