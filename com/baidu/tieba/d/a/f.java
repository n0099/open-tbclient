package com.baidu.tieba.d.a;

import com.baidu.tieba.data.ak;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class f extends ak implements d {
    public String aAt;
    private a bHo;
    public boolean bHp = false;
    public String bHq;
    public long threadId;
    private int zf;

    @Override // com.baidu.tieba.data.ak
    public void parserJson(JSONObject jSONObject) {
        this.bHo = new a(jSONObject);
    }

    public void b(App app) {
        this.bHo = new a(app);
    }

    public a abq() {
        return this.bHo;
    }

    public String abr() {
        return this.bHo == null ? "" : this.bHo.id;
    }

    public int abs() {
        return this.zf;
    }

    @Override // com.baidu.tieba.d.a.c
    public void hf(int i) {
        this.zf = i;
    }

    public boolean jF() {
        if (this.bHo == null) {
            return false;
        }
        return this.bHo.jF();
    }

    public boolean abt() {
        if (this.bHo == null) {
            return false;
        }
        return this.bHo.jG();
    }

    public boolean abu() {
        if (this.bHo == null) {
            return false;
        }
        return this.bHo.jH();
    }

    @Override // com.baidu.tieba.d.a.c
    public String abk() {
        if (this.bHo == null) {
            return null;
        }
        return this.bHo.apk_name;
    }

    @Override // com.baidu.tieba.d.a.c
    public String getDownloadUrl() {
        if (this.bHo == null) {
            return null;
        }
        return this.bHo.apk_url;
    }

    @Override // com.baidu.tieba.d.a.c
    public String getAppName() {
        return this.bHo == null ? "" : this.bHo.name;
    }

    @Override // com.baidu.tieba.d.a.e
    public String abl() {
        if (this.bHo == null || this.bHo.bHm == null) {
            return null;
        }
        return this.bHo.bHm.user_name;
    }

    @Override // com.baidu.tieba.d.a.e
    public String abm() {
        if (this.bHo == null || this.bHo.bHm == null) {
            return null;
        }
        return this.bHo.bHm.user_portrait;
    }

    @Override // com.baidu.tieba.d.a.e
    public String abn() {
        if (this.bHo == null || this.bHo.bHm == null) {
            return null;
        }
        return this.bHo.bHm.thread_title;
    }

    @Override // com.baidu.tieba.d.a.e
    public String abo() {
        if (this.bHo == null || this.bHo.bHm == null) {
            return null;
        }
        return this.bHo.bHm.thread_pic;
    }

    @Override // com.baidu.tieba.d.a.e
    public long abp() {
        if (this.bHo == null) {
            return 0L;
        }
        return this.bHo.bHk * 1000;
    }

    public int getShowType() {
        if (this.bHo == null || this.bHo.bHm == null) {
            return -1;
        }
        return this.bHo.bHm.bHn;
    }

    public int getPosition() {
        int f = this.bHo != null ? com.baidu.adp.lib.g.c.f(this.bHo.pos_name, 0) : 0;
        if (f < 2 || f > 30) {
            return 7;
        }
        return f;
    }

    public String abv() {
        if (this.bHo == null || this.bHo.bHm == null) {
            return null;
        }
        return this.bHo.bHm.pop_window_text;
    }

    public com.baidu.tbadk.core.data.a abw() {
        com.baidu.tbadk.core.data.a aVar = new com.baidu.tbadk.core.data.a();
        if (this.bHo != null) {
            aVar.zg = this.bHo.id;
            aVar.zh = this.bHo.name;
            aVar.zi = this.bHo.bHi;
            aVar.zj = this.bHo.url;
            aVar.zk = this.bHo.apk_url;
            aVar.zl = this.bHo.apk_name;
            try {
                aVar.zm = Integer.parseInt(this.bHo.pos_name.trim());
            } catch (Exception e) {
                aVar.zm = -1;
            }
            aVar.zn = this.bHo.first_name;
            aVar.zo = this.bHo.second_name;
            aVar.zp = this.bHo.zp;
            aVar.abtest = this.bHo.abtest;
            aVar.zq = this.bHo.bHj;
            aVar.userId = this.bHo.user_id;
            aVar.zr = this.bHo.verify;
            aVar.price = this.bHo.price;
            aVar.zs = this.bHo.ext_info;
            aVar.zt = this.bHo.bHk * 1000;
            if (this.bHo.bHm != null) {
                aVar.zu.zz = this.bHo.bHm.pop_window_text;
                aVar.zu.zw = this.bHo.bHm.id;
                aVar.zu.zy = this.bHo.bHm.thread_pic;
                aVar.zu.zA = this.bHo.bHm.bHn;
                aVar.zu.zx = this.bHo.bHm.thread_title;
                aVar.zu.userName = this.bHo.bHm.user_name;
                aVar.zu.userPortrait = this.bHo.bHm.user_portrait;
            }
        }
        return aVar;
    }
}
