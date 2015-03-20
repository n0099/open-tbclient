package com.baidu.tieba.frs.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.q;
import com.baidu.tbadk.performanceLog.aa;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.h;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.d.b<t, u> {
    private String Ws;
    private com.baidu.tieba.tbadkCore.e.a aDi;
    private long aDj;
    private long aDk;
    private long aDl;
    private long aDm;
    private String aIK;
    private int aIL;
    private int aIM;
    private w aIV;
    private FrsActivity aNb;
    private c<FrsActivity> aNc;
    private t aNd;
    private long aNe;
    private boolean aNf;
    private String aNg;
    private String aNh;
    private String aNi;
    private boolean aNj;
    private boolean aNk;
    h aNl;
    private long apu;
    private String mPageType;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity);
        this.aIK = null;
        this.mType = 3;
        this.aIM = 1;
        this.Ws = null;
        this.aIL = 0;
        this.aNe = 0L;
        this.aNf = false;
        this.mPageType = "normal_page";
        this.aNg = null;
        this.aNh = null;
        this.aNi = null;
        this.aDi = null;
        this.apu = 0L;
        this.aNj = false;
        this.aNk = false;
        this.aDj = 0L;
        this.aDk = 0L;
        this.aDl = 0L;
        this.aDm = 0L;
        this.aNb = frsActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.aIK = bundle.getString("name");
            this.Ws = bundle.getString("from");
            this.aIL = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.aNf = bundle.getBoolean(FrsActivityConfig.GOOD, false);
        }
        if (TextUtils.isEmpty(this.aIK)) {
            this.aIK = "";
        }
        if (TextUtils.isEmpty(this.Ws)) {
            this.Ws = "";
        }
        this.aNg = this.Ws;
        this.aNd = new t();
        this.aIV = new w();
        this.aNc = new c<>(this.aNb.getPageContext(), this.aNd);
        this.aNc.a((q) this);
        this.aNc.setUniqueId(getUniqueId());
        if (this.aIK != null && this.aIK.length() > 0) {
            if (this.Ws == null || this.Ws.length() <= 0) {
                this.Ws = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aIK);
        bundle.putString("from", this.Ws);
        bundle.putInt(FrsActivityConfig.FLAG, this.aIL);
        bundle.putBoolean(FrsActivityConfig.GOOD, this.aNf);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean ow() {
        return aU(true);
    }

    @Override // com.baidu.tbadk.mvc.d.b
    public boolean AH() {
        if (!this.aNc.isLoading() && this.aNd.getPn() > 1) {
            t tVar = (t) t.objectWithJson(t.jsonWithObject(this.aNd), t.class);
            tVar.setPn(this.aNd.getPn() - 1);
            a(tVar, 2);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.d.d
    public boolean AI() {
        if (this.aNc.isLoading()) {
            return false;
        }
        TiebaStatic.eventStat(this.aNb.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
        t tVar = (t) t.objectWithJson(t.jsonWithObject(this.aNd), t.class);
        tVar.setPn(tVar.getPn() + 1);
        a(tVar, 1);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.e
    public boolean aU(boolean z) {
        if (this.aNc.isLoading()) {
            return false;
        }
        t tVar = (t) t.objectWithJson(t.jsonWithObject(this.aNd), t.class);
        tVar.setPn(1);
        a(tVar, 3);
        return true;
    }

    public boolean KB() {
        if (this.aNc.isLoading()) {
            return false;
        }
        this.aNf = false;
        this.aIM = 1;
        return aU(true);
    }

    public boolean eQ(int i) {
        if (this.aNc.isLoading()) {
            return false;
        }
        this.aNf = true;
        this.aNe = i;
        this.aIM = 1;
        return aU(true);
    }

    public boolean aq(String str, String str2) {
        if (this.aNc.isLoading() || str2 == null) {
            return false;
        }
        this.aNg = "sidebar";
        this.aNh = str;
        this.aNf = false;
        this.aIK = str2;
        return aU(true);
    }

    private void a(t tVar, int i) {
        boolean z = true;
        this.aNb.aJp.eG(i);
        this.aNc.a(tVar);
        this.mType = i;
        tVar.setKw(this.aIK);
        if (n.px().pB()) {
            tVar.setRn(35);
        } else {
            tVar.setRn(50);
        }
        tVar.setWithGroup(1);
        if (this.aNf) {
            tVar.setIsGood(1);
            tVar.setCid((int) this.aNe);
        } else {
            tVar.setIsGood(0);
            tVar.setCid(0);
        }
        int M = com.baidu.adp.lib.util.n.M(this.aNb.getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.n.N(this.aNb.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = be.sY().ta() ? 2 : 1;
        tVar.setScrW(M);
        tVar.setScrH(N);
        tVar.setScrDip(f);
        tVar.setqType(i2);
        tVar.setLastId(this.aNi);
        if (this.aNg != null) {
            tVar.setStType(this.aNg);
            if (this.aNg.equalsIgnoreCase("sidebar")) {
                tVar.setStType(this.aNh);
            }
        }
        if (FrsActivity.aJb != 0) {
            tVar.setCtime((int) FrsActivity.aJb);
        }
        if (FrsActivity.aJc != 0) {
            tVar.setDataSize((int) FrsActivity.aJc);
        }
        if (FrsActivity.aJd != 0) {
            tVar.setNetError(FrsActivity.aJd);
        }
        if (tVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3 || this.aNf)) {
            z = false;
        }
        tVar.setUpdateType(this.mType);
        tVar.setNeedCache(z);
        new b(this, z, this.aIK).execute(new Object[0]);
        if (this.aDi == null) {
            this.aDi = new com.baidu.tieba.tbadkCore.e.a("frsStat");
            this.aDi.start();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(t tVar, u uVar) {
        this.aIV.d(uVar);
        if (this.aIV.akq().akz() == 1) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (this.aNf) {
            this.mPageType = "good_page";
        }
        if (tVar != null) {
            this.aNd = tVar;
            this.aIM = this.aNd.getPn();
            this.aIK = this.aNd.getKw();
            this.aNb.fI(this.aIK);
            this.aNb.setFrom(this.Ws);
            this.aNb.setPn(this.aIM);
            this.aNb.setFlag(this.aIL);
        }
        this.aNb.aJp.a(this.mType, false, this.aNl);
        this.aNg = null;
        return super.a((a) tVar, (t) uVar);
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.model.s
    public void a(MvcSocketResponsedMessage<u, ?> mvcSocketResponsedMessage, MvcSocketMessage<t, u> mvcSocketMessage, MvcNetMessage<t, u> mvcNetMessage) {
        h hVar = new h();
        hVar.ckr = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        hVar.isSuccess = !mvcSocketResponsedMessage.hasError();
        hVar.errorCode = mvcSocketResponsedMessage.getError();
        hVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        hVar.cks = mvcSocketResponsedMessage.getDownSize();
        this.aNl = hVar;
        super.a(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
        KD();
        if (this.aDi != null) {
            this.aDi.a(false, hVar.isSuccess, hVar.errorCode, hVar.errorMsg, hVar.cks);
            this.aDi = null;
        }
        if (!this.aNk) {
            this.aNk = true;
            aa aaVar = new aa();
            aaVar.eb(1000);
            aaVar.apz = false;
            aaVar.isSuccess = hVar.isSuccess;
            aaVar.apn = mvcSocketResponsedMessage.performanceData.qt;
            aaVar.apo = mvcSocketResponsedMessage.performanceData.qu;
            aaVar.apq = mvcSocketResponsedMessage.performanceData.qv;
            aaVar.apr = mvcSocketResponsedMessage.performanceData.qw;
            aaVar.aps = mvcSocketResponsedMessage.performanceData.qx;
            aaVar.apx = hVar.cks;
            aaVar.apy = 0L;
            if (this.aNb.aJp != null) {
                e(aaVar);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.model.r
    public void a(MvcHttpResponsedMessage<u> mvcHttpResponsedMessage, MvcHttpMessage<t, u> mvcHttpMessage, MvcNetMessage<t, u> mvcNetMessage) {
        h hVar = new h();
        hVar.ckr = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        hVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        hVar.errorCode = mvcHttpResponsedMessage.getError();
        hVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        hVar.cks = mvcHttpResponsedMessage.getDownSize();
        this.aNl = hVar;
        super.a(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
        KD();
        if (this.aDi != null) {
            this.aDi.a(true, hVar.isSuccess, hVar.errorCode, hVar.errorMsg, hVar.cks);
            this.aDi = null;
        }
        if (!this.aNk) {
            this.aNk = true;
            aa aaVar = new aa();
            aaVar.eb(1000);
            aaVar.apz = true;
            aaVar.isSuccess = hVar.isSuccess;
            aaVar.apn = mvcHttpResponsedMessage.performanceData.qt;
            aaVar.apo = mvcHttpResponsedMessage.performanceData.qu;
            aaVar.apq = mvcHttpResponsedMessage.performanceData.qv;
            aaVar.apr = mvcHttpResponsedMessage.performanceData.qw;
            aaVar.aps = mvcHttpResponsedMessage.performanceData.qx;
            aaVar.apx = 0L;
            aaVar.apy = hVar.cks;
            if (this.aNb.aJp != null) {
                e(aaVar);
            }
        }
    }

    public void KC() {
        if (this.aIV != null && this.aIV.YO() != null && this.aIV.YO().getBannerListData() != null) {
            String pV = this.aIV.YO().getBannerListData().pV();
            if (!TextUtils.isEmpty(pV)) {
                this.aNi = pV;
            }
        }
    }

    public void KD() {
        if (!this.aNj) {
            this.aNj = true;
            this.apu = System.currentTimeMillis() - this.aNb.aJa;
            aa aaVar = new aa();
            aaVar.eb(1000);
            aaVar.apk = this.aNb.aJi;
            aaVar.apm = this.aNb.createTime;
            aaVar.apu = this.apu;
            aaVar.CE();
        }
    }

    public void e(aa aaVar) {
        if (aaVar != null) {
            aaVar.apm = this.aNb.createTime;
            this.aNb.createTime = 0L;
            aaVar.apk = this.aNb.aJi;
            aaVar.apt = this.aNb.apt;
            aaVar.apu = this.apu == 0 ? System.currentTimeMillis() - this.aNb.aJa : this.apu;
            aaVar.CF();
        }
    }

    public String KE() {
        return this.mPageType;
    }

    public boolean KF() {
        return this.aNf;
    }

    public int getType() {
        return this.mType;
    }

    public w KG() {
        return this.aIV;
    }

    public h KH() {
        return this.aNl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KI() {
        this.aDj = System.currentTimeMillis();
        this.aNc.AT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(u uVar) {
        this.aNb.aJp.b(uVar);
    }

    public long GR() {
        return this.aDm;
    }

    public long GS() {
        return this.aDk;
    }

    public long GT() {
        return this.aDl;
    }

    public long GU() {
        return this.aDj;
    }
}
