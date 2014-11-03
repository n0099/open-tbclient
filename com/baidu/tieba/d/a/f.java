package com.baidu.tieba.d.a;

import com.baidu.tieba.data.ak;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class f extends ak implements d {
    public String aAD;
    private a bHC;
    public boolean bHD = false;
    public String bHE;
    public long threadId;
    private int zf;

    @Override // com.baidu.tieba.data.ak
    public void parserJson(JSONObject jSONObject) {
        this.bHC = new a(jSONObject);
    }

    public void b(App app) {
        this.bHC = new a(app);
    }

    public a abt() {
        return this.bHC;
    }

    public String abu() {
        return this.bHC == null ? "" : this.bHC.id;
    }

    public int abv() {
        return this.zf;
    }

    @Override // com.baidu.tieba.d.a.c
    public void hf(int i) {
        this.zf = i;
    }

    public boolean jF() {
        if (this.bHC == null) {
            return false;
        }
        return this.bHC.jF();
    }

    public boolean abw() {
        if (this.bHC == null) {
            return false;
        }
        return this.bHC.jG();
    }

    public boolean abx() {
        if (this.bHC == null) {
            return false;
        }
        return this.bHC.jH();
    }

    @Override // com.baidu.tieba.d.a.c
    public String abn() {
        if (this.bHC == null) {
            return null;
        }
        return this.bHC.apk_name;
    }

    @Override // com.baidu.tieba.d.a.c
    public String getDownloadUrl() {
        if (this.bHC == null) {
            return null;
        }
        return this.bHC.apk_url;
    }

    @Override // com.baidu.tieba.d.a.c
    public String getAppName() {
        return this.bHC == null ? "" : this.bHC.name;
    }

    @Override // com.baidu.tieba.d.a.e
    public String abo() {
        if (this.bHC == null || this.bHC.bHA == null) {
            return null;
        }
        return this.bHC.bHA.user_name;
    }

    @Override // com.baidu.tieba.d.a.e
    public String abp() {
        if (this.bHC == null || this.bHC.bHA == null) {
            return null;
        }
        return this.bHC.bHA.user_portrait;
    }

    @Override // com.baidu.tieba.d.a.e
    public String abq() {
        if (this.bHC == null || this.bHC.bHA == null) {
            return null;
        }
        return this.bHC.bHA.thread_title;
    }

    @Override // com.baidu.tieba.d.a.e
    public String abr() {
        if (this.bHC == null || this.bHC.bHA == null) {
            return null;
        }
        return this.bHC.bHA.thread_pic;
    }

    @Override // com.baidu.tieba.d.a.e
    public long abs() {
        if (this.bHC == null) {
            return 0L;
        }
        return this.bHC.bHy * 1000;
    }

    public int getShowType() {
        if (this.bHC == null || this.bHC.bHA == null) {
            return -1;
        }
        return this.bHC.bHA.bHB;
    }

    public int getPosition() {
        int f = this.bHC != null ? com.baidu.adp.lib.g.c.f(this.bHC.pos_name, 0) : 0;
        if (f < 2 || f > 30) {
            return 7;
        }
        return f;
    }

    public String aby() {
        if (this.bHC == null || this.bHC.bHA == null) {
            return null;
        }
        return this.bHC.bHA.pop_window_text;
    }

    public com.baidu.tbadk.core.data.a abz() {
        com.baidu.tbadk.core.data.a aVar = new com.baidu.tbadk.core.data.a();
        if (this.bHC != null) {
            aVar.zg = this.bHC.id;
            aVar.zh = this.bHC.name;
            aVar.zi = this.bHC.bHw;
            aVar.zj = this.bHC.url;
            aVar.zk = this.bHC.apk_url;
            aVar.zl = this.bHC.apk_name;
            try {
                aVar.zm = Integer.parseInt(this.bHC.pos_name.trim());
            } catch (Exception e) {
                aVar.zm = -1;
            }
            aVar.zn = this.bHC.first_name;
            aVar.zo = this.bHC.second_name;
            aVar.zp = this.bHC.zp;
            aVar.abtest = this.bHC.abtest;
            aVar.zq = this.bHC.bHx;
            aVar.userId = this.bHC.user_id;
            aVar.zr = this.bHC.verify;
            aVar.price = this.bHC.price;
            aVar.zs = this.bHC.ext_info;
            aVar.zt = this.bHC.bHy * 1000;
            if (this.bHC.bHA != null) {
                aVar.zu.zz = this.bHC.bHA.pop_window_text;
                aVar.zu.zw = this.bHC.bHA.id;
                aVar.zu.zy = this.bHC.bHA.thread_pic;
                aVar.zu.zA = this.bHC.bHA.bHB;
                aVar.zu.zx = this.bHC.bHA.thread_title;
                aVar.zu.userName = this.bHC.bHA.user_name;
                aVar.zu.userPortrait = this.bHC.bHA.user_portrait;
            }
        }
        return aVar;
    }
}
