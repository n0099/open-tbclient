package com.baidu.tieba.homepage.fragment.data;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.mvc.b.j;
import com.baidu.tieba.homepage.fragment.data.UserModuleData;
import com.baidu.tieba.homepage.listview.card.d.b;
import com.baidu.tieba.homepage.listview.card.discover.h;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import tbclient.HomePage.DataRes;
import tbclient.HomePage.HomePageResIdl;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.b, j {
    private ArrayList<u> byg = null;
    public UserModuleData byh = null;
    private com.baidu.tieba.homepage.listview.card.a.a byi = null;
    private com.baidu.tieba.homepage.listview.card.i.b byj = null;
    private com.baidu.tieba.homepage.listview.card.h.b byk = null;
    private com.baidu.tieba.homepage.listview.card.c.d byl = null;
    private com.baidu.tieba.homepage.listview.card.g.b bym = null;
    private com.baidu.tieba.homepage.listview.card.e.b byn = null;
    private com.baidu.tieba.homepage.listview.card.d.b byo = null;
    private com.baidu.tieba.homepage.listview.card.b.b byp = null;
    private com.baidu.tieba.homepage.listview.card.j.b byq = null;
    public h byr = null;
    private com.baidu.tieba.homepage.listview.card.f.b bys = null;
    private Map<Long, u> byt = null;

    public boolean TN() {
        return this.byt == null || this.byt.isEmpty();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.byt = new HashMap();
            if (dataRes.user_module != null) {
                this.byh = new UserModuleData();
                this.byh.parserProtobuf(dataRes.user_module);
            }
            if (dataRes.banner != null) {
                this.byi = new com.baidu.tieba.homepage.listview.card.a.a();
                this.byi.a(dataRes.banner);
            }
            if (dataRes.hot_video != null) {
                this.byj = new com.baidu.tieba.homepage.listview.card.i.b();
                this.byj.a(dataRes.hot_video);
                if (!this.byj.TN()) {
                    this.byt.put(Long.valueOf(this.byj.mid), this.byj);
                }
            }
            if (dataRes.hot_twzb != null) {
                this.byk = new com.baidu.tieba.homepage.listview.card.h.b();
                this.byk.a(dataRes.hot_twzb);
                if (!this.byk.TN() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.byt.put(Long.valueOf(this.byk.mid), this.byk);
                }
            }
            if (dataRes.hot_activity != null) {
                this.byl = new com.baidu.tieba.homepage.listview.card.c.d();
                this.byl.a(dataRes.hot_activity);
                this.byt.put(Long.valueOf(this.byl.mid), this.byl);
            }
            if (dataRes.hot_topic != null) {
                this.bym = new com.baidu.tieba.homepage.listview.card.g.b();
                this.bym.a(dataRes.hot_topic);
                if (!this.bym.TN()) {
                    this.byt.put(Long.valueOf(this.bym.mid), this.bym);
                }
            }
            if (dataRes.hot_god != null) {
                this.byn = new com.baidu.tieba.homepage.listview.card.e.b();
                this.byn.a(dataRes.hot_god);
                if (!this.byn.TN()) {
                    this.byt.put(Long.valueOf(this.byn.mid), this.byn);
                }
            }
            if (dataRes.hot_forum != null) {
                this.byo = new com.baidu.tieba.homepage.listview.card.d.b();
                this.byo.a(dataRes.hot_forum);
                if (!this.byo.TN()) {
                    this.byt.put(Long.valueOf(this.byo.mid), this.byo);
                }
            }
            if (dataRes.fun_center != null) {
                this.byp = new com.baidu.tieba.homepage.listview.card.b.b();
                this.byp.a(dataRes.fun_center);
                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameCenterActivityConfig.class)) {
                    this.byt.put(Long.valueOf(this.byp.mid), this.byp);
                }
            }
            if (dataRes.vip_center != null) {
                this.byq = new com.baidu.tieba.homepage.listview.card.j.b();
                this.byq.a(dataRes.vip_center);
                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
                    this.byt.put(Long.valueOf(this.byq.mid), this.byq);
                }
            }
            if (dataRes.discover != null) {
                this.byr = new h();
                this.byr.a(dataRes.discover);
                if (!this.byr.TN()) {
                    this.byt.put(Long.valueOf(this.byr.mid), this.byr);
                }
            }
            if (dataRes.hot_thread != null) {
                this.bys = new com.baidu.tieba.homepage.listview.card.f.b();
                this.bys.a(dataRes.hot_thread);
                if (!this.bys.TN()) {
                    this.byt.put(Long.valueOf(this.bys.mid), this.bys);
                }
            }
        }
    }

    public void TO() {
        if (this.byt != null) {
            if (this.byk != null && !this.byk.TN() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                this.byt.put(Long.valueOf(this.byk.mid), this.byk);
            }
            if (this.byq != null && TbadkCoreApplication.m411getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
                this.byt.put(Long.valueOf(this.byq.mid), this.byq);
            }
            if (this.byp != null && TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameCenterActivityConfig.class)) {
                this.byt.put(Long.valueOf(this.byp.mid), this.byp);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void g(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
        if (message instanceof HomePageResIdl) {
            HomePageResIdl homePageResIdl = (HomePageResIdl) message;
            if ((homePageResIdl.error == null || homePageResIdl.error.errorno.intValue() == 0) && homePageResIdl.data != null) {
                a(homePageResIdl.data);
            }
        }
    }

    public ArrayList<u> TP() {
        return this.byg;
    }

    public void a(UserModuleData userModuleData) {
        u uVar;
        if (userModuleData != null && this.byt != null) {
            if (this.byg == null) {
                this.byg = new ArrayList<>();
            } else {
                this.byg.clear();
            }
            if (userModuleData.moduleDataList != null) {
                for (UserModuleData.ModuleItemData moduleItemData : userModuleData.moduleDataList) {
                    if (moduleItemData != null && (uVar = this.byt.get(Long.valueOf(moduleItemData.mid))) != null) {
                        this.byg.add(uVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean R(byte[] bArr) {
        try {
            a((HomePageResIdl) new Wire(new Class[0]).parseFrom(bArr, HomePageResIdl.class));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Dq() {
        return null;
    }

    public com.baidu.tieba.homepage.listview.card.a.a TQ() {
        return this.byi;
    }

    public void e(long j, boolean z) {
        if (this.byo != null && this.byo.bAg != null) {
            for (b.a aVar : this.byo.bAg) {
                if (aVar != null && aVar.forumId == j) {
                    aVar.isLiked = z;
                    return;
                }
            }
        }
    }
}
