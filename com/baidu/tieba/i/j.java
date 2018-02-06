package com.baidu.tieba.i;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.shell.SapiErrorCode;
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
    private String bDf;
    private String bQV;
    private String fvV;
    private int fvW;
    private int fvX;
    private com.baidu.tieba.i.a.b fwa;
    private com.baidu.tieba.i.a.d fwb;
    private List<com.baidu.tieba.i.a.c> fwc;
    private long fwg;
    private long fwh;
    private long fwi;
    private boolean fwj;
    private boolean fwm;
    private String fwn;
    private List<b> fwo;
    private int fwp;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fwk = true;
    private boolean fwl = false;
    private String fvU = UUID.randomUUID().toString();
    private Map<String, Long> fvZ = new HashMap();
    private List<com.baidu.tieba.l.c> fvY = new ArrayList();
    private long fwd = 0;
    private long fwe = 0;
    private long fwf = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.bDf = str;
        this.bQV = str2;
        this.fvV = str3;
    }

    @Override // com.baidu.tieba.i.i
    public void aWR() {
        this.fwd = System.currentTimeMillis();
        this.fvY.add(new com.baidu.tieba.l.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.i.i
    public void pC(String str) {
        pH(str);
        this.fvY.add(new com.baidu.tieba.l.a(1));
        this.mCurrentState = 1;
    }

    private void pH(String str) {
        if (!StringUtils.isNull(str)) {
            this.fvX = VideoPlatformStatic.ib(str);
            if (this.fvX != 0) {
                this.fwj = true;
            }
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aWS() {
        this.fvY.add(new com.baidu.tieba.l.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void aWT() {
        if (this.mCurrentState != 2) {
            this.fwd = System.currentTimeMillis();
            this.fvY.add(new com.baidu.tieba.l.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fwd = System.currentTimeMillis();
        pH(str);
        this.fvY.add(new com.baidu.tieba.l.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void sh(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fvW = i;
            this.fwk = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fwd;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.fvZ.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fwd = 0L;
            this.fwe = System.currentTimeMillis();
            this.fvY.add(new com.baidu.tieba.l.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void si(int i) {
        if (this.mCurrentState == 5) {
            aXa();
        } else if (this.mCurrentState == 3) {
            this.fvW = i;
            this.fvY.add(new com.baidu.tieba.l.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aWU() {
        if (this.fwe != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fwf += currentTimeMillis - this.fwe;
            this.fwe = currentTimeMillis;
        }
        this.fwg++;
        this.fwi = System.currentTimeMillis();
        this.fvY.add(new com.baidu.tieba.l.a(201));
    }

    @Override // com.baidu.tieba.i.i
    public void aWV() {
        this.fwe = System.currentTimeMillis();
        if (this.fwi != 0) {
            this.fwh += System.currentTimeMillis() - this.fwi;
        }
        this.fvY.add(new com.baidu.tieba.l.a(202));
    }

    @Override // com.baidu.tieba.i.i
    public void aWW() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fwe != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fwf += currentTimeMillis - this.fwe;
                this.fwe = currentTimeMillis;
            }
            this.fvY.add(new com.baidu.tieba.l.a(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION));
            this.mCurrentState = 5;
        }
    }

    public void aXa() {
        if (this.mCurrentState == 5) {
            this.fwe = System.currentTimeMillis();
            this.fvY.add(new com.baidu.tieba.l.a(HttpStatus.SC_NO_CONTENT));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pD(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.ic(str);
            aXc();
            this.fvY.add(new com.baidu.tieba.l.a(HttpStatus.SC_RESET_CONTENT));
            this.mCurrentState = 8;
            aWX();
        }
    }

    @Override // com.baidu.tieba.i.i
    public String pE(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fvU;
        }
        this.mSource = VideoPlatformStatic.ic(str);
        aXc();
        this.fvZ.put("stallDuration", Long.valueOf(this.fwh));
        this.fvY.add(new com.baidu.tieba.l.a(HttpStatus.SC_PARTIAL_CONTENT));
        this.mCurrentState = 6;
        aWX();
        return this.fvU;
    }

    @Override // com.baidu.tieba.i.i
    public boolean pF(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.ic(str);
        aXc();
        this.fvY.add(new com.baidu.tieba.l.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aWX();
        return true;
    }

    @Override // com.baidu.tieba.i.i
    public void i(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fwb == null && com.baidu.adp.lib.util.f.lk()) {
                this.fwb = new com.baidu.tieba.i.a.d(this.fvU);
                a(this.fwb);
            }
            if (this.fwb != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fwb.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.II())) {
            if (this.fwa == null && com.baidu.adp.lib.util.f.lk()) {
                this.fwa = new com.baidu.tieba.i.a.b(this.fvU);
                a(this.fwa);
            }
            if (this.fwa != null) {
                if (this.fwa.size() == 0) {
                    this.fwp = i2;
                }
                this.fwa.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.i.a.c cVar) {
        if (this.fwc == null) {
            this.fwc = new ArrayList();
        }
        this.fwc.add(cVar);
    }

    @Override // com.baidu.tieba.i.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fvU;
        }
        this.fvW = i;
        this.fwk = false;
        this.fwl = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.ic(str);
        aXc();
        if (!v.E(this.fwc)) {
            int size = this.fwc.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.i.a.c cVar = this.fwc.get(i4);
                if (cVar != null) {
                    cVar.aXl();
                }
            }
        }
        this.fvY.add(new com.baidu.tieba.l.b(i, i2, i3, j, str2, aXb()));
        this.mCurrentState = -1;
        aWX();
        return this.fvU;
    }

    private com.baidu.tieba.i.a.e[] aXb() {
        if (this.fwc == null || this.fwc.size() == 0) {
            return null;
        }
        com.baidu.tieba.i.a.e[] eVarArr = new com.baidu.tieba.i.a.e[this.fwc.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fwc.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fwc.get(i2).aXj();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pG(String str) {
        this.fwn = str;
    }

    private void aXc() {
        if (this.fwe != 0) {
            this.fwf += System.currentTimeMillis() - this.fwe;
        }
        this.fvZ.put("playDuration", Long.valueOf(this.fwf));
        this.fvZ.put("stallCount", Long.valueOf(this.fwg));
        this.fvZ.put("stallDuration", Long.valueOf(this.fwh));
        if (!this.fvZ.containsKey("loadingTime")) {
            this.fvZ.put("loadingTime", 0L);
        }
        this.fwd = 0L;
        this.fwe = 0L;
        this.fwf = 0L;
        this.fwg = 0L;
        this.fwh = 0L;
        this.fwi = 0L;
    }

    @Override // com.baidu.tieba.i.i
    public void aWX() {
        if (!this.fwm) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.ID() || !this.fwk) && reportType != 3) {
                this.fwm = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.i.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.Uf());
                            jSONObject.put("kpiInfo", j.this.aXd());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fwk)) {
                                JSONObject aXe = j.this.aXe();
                                aXe.put("running", j.this.aXf());
                                jSONObject.put("debugInfo", aXe);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.aXe());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.q.e.bAE().c(jSONObject, j.this.fwk ? false : true);
                        if (j.this.fwo != null) {
                            j.this.fwo.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Uf() {
        JSONObject Uf = VideoPlatformStatic.Uf();
        if (this.fwo != null) {
            try {
                int size = this.fwo.size();
                for (int i = 0; i < size; i++) {
                    this.fwo.get(i).M(Uf);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return Uf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aXd() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.fvZ.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fvZ.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fvZ.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fvZ.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fvZ.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fwj ? 1 : 0);
            jSONObject.put("playSuccess", this.fwk ? 1 : 0);
            jSONObject.put("retryError", this.fwl ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.fwo != null) {
                int size = this.fwo.size();
                for (int i = 0; i < size; i++) {
                    this.fwo.get(i).N(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aXe() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.fvU);
            if (!StringUtils.isNull(this.fvV)) {
                jSONObject.put("parentUuid", this.fvV);
            }
            jSONObject.put("tid", this.bDf);
            jSONObject.put("videoUrl", this.bQV);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.jl(this.fvW));
            jSONObject.put("urlType", this.fvX);
            jSONObject.put("sub_error", this.fwp);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fwn)) {
                jSONObject.put("error_stack", this.fwn);
            }
            if (this.fwo != null) {
                int size = this.fwo.size();
                for (int i = 0; i < size; i++) {
                    this.fwo.get(i).O(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray aXf() {
        JSONArray jSONArray = new JSONArray();
        if (this.fvY == null) {
            return jSONArray;
        }
        int size = this.fvY.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fvY.get(i).bmc());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.i.i
    public void a(b bVar) {
        if (this.fwo == null) {
            this.fwo = new ArrayList();
        }
        this.fwo.add(bVar);
    }

    @Override // com.baidu.tieba.i.i
    public void ji(boolean z) {
        this.fwk = z;
    }

    @Override // com.baidu.tieba.i.i
    public String aWY() {
        return this.fvU;
    }

    @Override // com.baidu.tieba.i.i
    public String aWZ() {
        return this.fwp + "";
    }
}
