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
    private ArrayList<com.baidu.tbadk.core.data.m> b;
    private AntiData c;
    private com.baidu.tbadk.core.data.k d;
    private com.baidu.tieba.data.t e;
    private boolean f;
    private String g;
    private com.baidu.tieba.data.u h;
    private UserData i;
    private com.baidu.tieba.data.c j;
    private ArrayList<LiveCardData> r;
    private HashMap<String, MetaData> s;
    private int k = 0;
    private di l = null;
    private dh m = null;
    private boolean n = false;
    private k o = null;
    private h p = null;
    private boolean q = false;
    private long t = 0;
    private long u = 0;
    private long v = 0;
    private long w = 0;

    public ArrayList<LiveCardData> a() {
        return this.r;
    }

    public long b() {
        return this.w;
    }

    public long c() {
        return this.u;
    }

    public long d() {
        return this.v;
    }

    public long e() {
        return this.t;
    }

    public boolean f() {
        return this.f;
    }

    public g() {
        s();
    }

    private void s() {
        this.a = new ForumData();
        this.b = new ArrayList<>();
        this.s = new HashMap<>();
        this.d = new com.baidu.tbadk.core.data.k();
        this.e = new com.baidu.tieba.data.t();
        this.i = new UserData();
        this.h = new com.baidu.tieba.data.u();
        a(new AntiData());
        a(new com.baidu.tieba.data.c());
    }

    public void a(com.baidu.tieba.data.ab abVar) {
        this.a.setCurScore(abVar.e());
        this.a.setLevelupScore(abVar.f());
        this.a.setLike(abVar.c());
        this.a.setUser_level(abVar.b());
        this.a.setLevelName(abVar.d());
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

    public void a(com.baidu.tbadk.core.data.m mVar) {
        while (!this.b.isEmpty() && this.b.get(0).u() == 2) {
            this.b.remove(0);
        }
        this.b.add(0, mVar);
    }

    public ArrayList<com.baidu.tbadk.core.data.m> h() {
        return this.b;
    }

    public UserData i() {
        return this.i;
    }

    public void a(AntiData antiData) {
        this.c = antiData;
    }

    public AntiData j() {
        return this.c;
    }

    public com.baidu.tbadk.core.data.k k() {
        return this.d;
    }

    public com.baidu.tieba.data.t l() {
        return this.e;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public boolean m() {
        return this.n;
    }

    public FrsPageResIdl a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            new String(bArr, "UTF-8");
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
                s();
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.s.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                a(dataRes.is_new_url.intValue());
                this.f = dataRes.fortune_bag.intValue() == 1;
                this.g = dataRes.fortune_desc;
                this.h.a(dataRes.gcon_account);
                this.a.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list2 = dataRes.thread_list;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
                        mVar.a(this.s);
                        mVar.a(list2.get(i2));
                        mVar.L();
                        this.b.add(mVar);
                    }
                }
                this.c.parserProtobuf(dataRes.anti);
                this.j.a(dataRes.group);
                this.d.a(dataRes.page);
                this.e.a(dataRes.frs_star);
                this.i.parserProtobuf(dataRes.user);
                List<AnchorInfo> list3 = dataRes.forum_livegroup_list;
                this.r = new ArrayList<>();
                if (list3 != null) {
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list3.get(i3));
                        this.r.add(liveCardData);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(FrsActivity frsActivity, FRSPageRequestMessage fRSPageRequestMessage, int i, boolean z, String str) {
        if (this.o != null) {
            this.o.cancel();
            this.o = null;
        }
        this.q = z;
        this.o = new k(this, frsActivity, fRSPageRequestMessage, i, str);
        this.o.setPriority(3);
        this.o.execute(fRSPageRequestMessage);
    }

    public void a(String str) {
        if (this.p != null) {
            this.p.cancel();
            this.p = null;
        }
        ForumData g = g();
        this.p = new h(this, g.getId(), g.getName(), str);
        this.p.setPriority(2);
        this.p.execute(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/user/fansno");
    }

    public void n() {
        if (this.o != null) {
            this.o.cancel();
            this.o = null;
        }
        if (this.p != null) {
            this.p.cancel();
            this.p = null;
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

    public void a(di diVar) {
        this.l = diVar;
    }

    public void a(dh dhVar) {
        this.m = dhVar;
    }

    public int o() {
        return this.k;
    }

    public void a(int i) {
        this.k = i;
    }

    public com.baidu.tieba.data.c p() {
        return this.j;
    }

    public void a(com.baidu.tieba.data.c cVar) {
        this.j = cVar;
    }

    public com.baidu.tieba.data.u q() {
        return this.h;
    }

    public String r() {
        return this.g;
    }
}
