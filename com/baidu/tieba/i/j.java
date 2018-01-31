package com.baidu.tieba.i;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.VideoPlatformStatic;
import com.coremedia.iso.boxes.UserBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j implements i {
    private String bBb;
    private String bON;
    private com.baidu.tieba.i.a.d fsA;
    private List<com.baidu.tieba.i.a.c> fsB;
    private long fsF;
    private long fsG;
    private long fsH;
    private boolean fsI;
    private boolean fsL;
    private String fsM;
    private List<b> fsN;
    private int fsO;
    private String fsu;
    private int fsv;
    private int fsw;
    private com.baidu.tieba.i.a.b fsz;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fsJ = true;
    private boolean fsK = false;
    private String fst = UUID.randomUUID().toString();
    private Map<String, Long> fsy = new HashMap();
    private List<com.baidu.tieba.l.c> fsx = new ArrayList();
    private long fsC = 0;
    private long fsD = 0;
    private long fsE = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.bBb = str;
        this.bON = str2;
        this.fsu = str3;
    }

    @Override // com.baidu.tieba.i.i
    public void aVi() {
        this.fsC = System.currentTimeMillis();
        this.fsx.add(new com.baidu.tieba.l.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.i.i
    public void pt(String str) {
        py(str);
        this.fsx.add(new com.baidu.tieba.l.a(1));
        this.mCurrentState = 1;
    }

    private void py(String str) {
        if (!StringUtils.isNull(str)) {
            this.fsw = VideoPlatformStatic.hR(str);
            if (this.fsw != 0) {
                this.fsI = true;
            }
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aVj() {
        this.fsx.add(new com.baidu.tieba.l.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void aVk() {
        if (this.mCurrentState != 2) {
            this.fsC = System.currentTimeMillis();
            this.fsx.add(new com.baidu.tieba.l.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fsC = System.currentTimeMillis();
        py(str);
        this.fsx.add(new com.baidu.tieba.l.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void se(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fsv = i;
            this.fsJ = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fsC;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.fsy.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fsC = 0L;
            this.fsD = System.currentTimeMillis();
            this.fsx.add(new com.baidu.tieba.l.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void sf(int i) {
        if (this.mCurrentState == 5) {
            aVr();
        } else if (this.mCurrentState == 3) {
            this.fsv = i;
            this.fsx.add(new com.baidu.tieba.l.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aVl() {
        if (this.fsD != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fsE += currentTimeMillis - this.fsD;
            this.fsD = currentTimeMillis;
        }
        this.fsF++;
        this.fsH = System.currentTimeMillis();
        this.fsx.add(new com.baidu.tieba.l.a(HttpStatus.SC_CREATED));
    }

    @Override // com.baidu.tieba.i.i
    public void aVm() {
        this.fsD = System.currentTimeMillis();
        if (this.fsH != 0) {
            this.fsG += System.currentTimeMillis() - this.fsH;
        }
        this.fsx.add(new com.baidu.tieba.l.a(HttpStatus.SC_ACCEPTED));
    }

    @Override // com.baidu.tieba.i.i
    public void aVn() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fsD != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fsE += currentTimeMillis - this.fsD;
                this.fsD = currentTimeMillis;
            }
            this.fsx.add(new com.baidu.tieba.l.a(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION));
            this.mCurrentState = 5;
        }
    }

    public void aVr() {
        if (this.mCurrentState == 5) {
            this.fsD = System.currentTimeMillis();
            this.fsx.add(new com.baidu.tieba.l.a(HttpStatus.SC_NO_CONTENT));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pu(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.hS(str);
            aVt();
            this.fsx.add(new com.baidu.tieba.l.a(HttpStatus.SC_RESET_CONTENT));
            this.mCurrentState = 8;
            aVo();
        }
    }

    @Override // com.baidu.tieba.i.i
    public String pv(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fst;
        }
        this.mSource = VideoPlatformStatic.hS(str);
        aVt();
        this.fsy.put("stallDuration", Long.valueOf(this.fsG));
        this.fsx.add(new com.baidu.tieba.l.a(HttpStatus.SC_PARTIAL_CONTENT));
        this.mCurrentState = 6;
        aVo();
        return this.fst;
    }

    @Override // com.baidu.tieba.i.i
    public boolean pw(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.hS(str);
        aVt();
        this.fsx.add(new com.baidu.tieba.l.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aVo();
        return true;
    }

    @Override // com.baidu.tieba.i.i
    public void i(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fsA == null && com.baidu.adp.lib.util.f.lk()) {
                this.fsA = new com.baidu.tieba.i.a.d(this.fst);
                a(this.fsA);
            }
            if (this.fsA != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fsA.a(new com.baidu.tieba.play.c.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.Ic())) {
            if (this.fsz == null && com.baidu.adp.lib.util.f.lk()) {
                this.fsz = new com.baidu.tieba.i.a.b(this.fst);
                a(this.fsz);
            }
            if (this.fsz != null) {
                if (this.fsz.size() == 0) {
                    this.fsO = i2;
                }
                this.fsz.a(new com.baidu.tieba.play.c.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.i.a.c cVar) {
        if (this.fsB == null) {
            this.fsB = new ArrayList();
        }
        this.fsB.add(cVar);
    }

    @Override // com.baidu.tieba.i.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fst;
        }
        this.fsv = i;
        this.fsJ = false;
        this.fsK = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.hS(str);
        aVt();
        if (!v.E(this.fsB)) {
            int size = this.fsB.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.i.a.c cVar = this.fsB.get(i4);
                if (cVar != null) {
                    cVar.aVC();
                }
            }
        }
        this.fsx.add(new com.baidu.tieba.l.b(i, i2, i3, j, str2, aVs()));
        this.mCurrentState = -1;
        aVo();
        return this.fst;
    }

    private com.baidu.tieba.i.a.e[] aVs() {
        if (this.fsB == null || this.fsB.size() == 0) {
            return null;
        }
        com.baidu.tieba.i.a.e[] eVarArr = new com.baidu.tieba.i.a.e[this.fsB.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fsB.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fsB.get(i2).aVA();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void px(String str) {
        this.fsM = str;
    }

    private void aVt() {
        if (this.fsD != 0) {
            this.fsE += System.currentTimeMillis() - this.fsD;
        }
        this.fsy.put("playDuration", Long.valueOf(this.fsE));
        this.fsy.put("stallCount", Long.valueOf(this.fsF));
        this.fsy.put("stallDuration", Long.valueOf(this.fsG));
        if (!this.fsy.containsKey("loadingTime")) {
            this.fsy.put("loadingTime", 0L);
        }
        this.fsC = 0L;
        this.fsD = 0L;
        this.fsE = 0L;
        this.fsF = 0L;
        this.fsG = 0L;
        this.fsH = 0L;
    }

    @Override // com.baidu.tieba.i.i
    public void aVo() {
        if (!this.fsL) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.HX() || !this.fsJ) && reportType != 3) {
                this.fsL = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.i.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.Tw());
                            jSONObject.put("kpiInfo", j.this.aVu());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fsJ)) {
                                JSONObject aVv = j.this.aVv();
                                aVv.put("running", j.this.aVw());
                                jSONObject.put("debugInfo", aVv);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.aVv());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.q.e.bzU().c(jSONObject, j.this.fsJ ? false : true);
                        if (j.this.fsN != null) {
                            j.this.fsN.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Tw() {
        JSONObject Tw = VideoPlatformStatic.Tw();
        if (this.fsN != null) {
            try {
                int size = this.fsN.size();
                for (int i = 0; i < size; i++) {
                    this.fsN.get(i).H(Tw);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return Tw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aVu() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.fsy.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fsy.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fsy.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fsy.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fsy.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fsI ? 1 : 0);
            jSONObject.put("playSuccess", this.fsJ ? 1 : 0);
            jSONObject.put("retryError", this.fsK ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.fsN != null) {
                int size = this.fsN.size();
                for (int i = 0; i < size; i++) {
                    this.fsN.get(i).I(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aVv() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.fst);
            if (!StringUtils.isNull(this.fsu)) {
                jSONObject.put("parentUuid", this.fsu);
            }
            jSONObject.put("tid", this.bBb);
            jSONObject.put("videoUrl", this.bON);
            jSONObject.put(LegoListActivityConfig.IS_FROM, this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.jp(this.fsv));
            jSONObject.put("urlType", this.fsw);
            jSONObject.put("sub_error", this.fsO);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fsM)) {
                jSONObject.put("error_stack", this.fsM);
            }
            if (this.fsN != null) {
                int size = this.fsN.size();
                for (int i = 0; i < size; i++) {
                    this.fsN.get(i).J(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray aVw() {
        JSONArray jSONArray = new JSONArray();
        if (this.fsx == null) {
            return jSONArray;
        }
        int size = this.fsx.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fsx.get(i).bkP());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.i.i
    public void a(b bVar) {
        if (this.fsN == null) {
            this.fsN = new ArrayList();
        }
        this.fsN.add(bVar);
    }

    @Override // com.baidu.tieba.i.i
    public void iY(boolean z) {
        this.fsJ = z;
    }

    @Override // com.baidu.tieba.i.i
    public String aVp() {
        return this.fst;
    }

    @Override // com.baidu.tieba.i.i
    public String aVq() {
        return this.fsO + "";
    }
}
