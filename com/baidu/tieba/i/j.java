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
    private String bCS;
    private String bQI;
    private String fvJ;
    private int fvK;
    private int fvL;
    private com.baidu.tieba.i.a.b fvO;
    private com.baidu.tieba.i.a.d fvP;
    private List<com.baidu.tieba.i.a.c> fvQ;
    private long fvU;
    private long fvV;
    private long fvW;
    private boolean fvX;
    private boolean fwa;
    private String fwb;
    private List<b> fwc;
    private int fwd;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fvY = true;
    private boolean fvZ = false;
    private String fvI = UUID.randomUUID().toString();
    private Map<String, Long> fvN = new HashMap();
    private List<com.baidu.tieba.l.c> fvM = new ArrayList();
    private long fvR = 0;
    private long fvS = 0;
    private long fvT = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.bCS = str;
        this.bQI = str2;
        this.fvJ = str3;
    }

    @Override // com.baidu.tieba.i.i
    public void aWQ() {
        this.fvR = System.currentTimeMillis();
        this.fvM.add(new com.baidu.tieba.l.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.i.i
    public void pC(String str) {
        pH(str);
        this.fvM.add(new com.baidu.tieba.l.a(1));
        this.mCurrentState = 1;
    }

    private void pH(String str) {
        if (!StringUtils.isNull(str)) {
            this.fvL = VideoPlatformStatic.ib(str);
            if (this.fvL != 0) {
                this.fvX = true;
            }
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aWR() {
        this.fvM.add(new com.baidu.tieba.l.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void aWS() {
        if (this.mCurrentState != 2) {
            this.fvR = System.currentTimeMillis();
            this.fvM.add(new com.baidu.tieba.l.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fvR = System.currentTimeMillis();
        pH(str);
        this.fvM.add(new com.baidu.tieba.l.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void si(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fvK = i;
            this.fvY = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fvR;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.fvN.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fvR = 0L;
            this.fvS = System.currentTimeMillis();
            this.fvM.add(new com.baidu.tieba.l.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void sj(int i) {
        if (this.mCurrentState == 5) {
            aWZ();
        } else if (this.mCurrentState == 3) {
            this.fvK = i;
            this.fvM.add(new com.baidu.tieba.l.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aWT() {
        if (this.fvS != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fvT += currentTimeMillis - this.fvS;
            this.fvS = currentTimeMillis;
        }
        this.fvU++;
        this.fvW = System.currentTimeMillis();
        this.fvM.add(new com.baidu.tieba.l.a(201));
    }

    @Override // com.baidu.tieba.i.i
    public void aWU() {
        this.fvS = System.currentTimeMillis();
        if (this.fvW != 0) {
            this.fvV += System.currentTimeMillis() - this.fvW;
        }
        this.fvM.add(new com.baidu.tieba.l.a(202));
    }

    @Override // com.baidu.tieba.i.i
    public void aWV() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fvS != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fvT += currentTimeMillis - this.fvS;
                this.fvS = currentTimeMillis;
            }
            this.fvM.add(new com.baidu.tieba.l.a(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION));
            this.mCurrentState = 5;
        }
    }

    public void aWZ() {
        if (this.mCurrentState == 5) {
            this.fvS = System.currentTimeMillis();
            this.fvM.add(new com.baidu.tieba.l.a(HttpStatus.SC_NO_CONTENT));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pD(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.ic(str);
            aXb();
            this.fvM.add(new com.baidu.tieba.l.a(HttpStatus.SC_RESET_CONTENT));
            this.mCurrentState = 8;
            aWW();
        }
    }

    @Override // com.baidu.tieba.i.i
    public String pE(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fvI;
        }
        this.mSource = VideoPlatformStatic.ic(str);
        aXb();
        this.fvN.put("stallDuration", Long.valueOf(this.fvV));
        this.fvM.add(new com.baidu.tieba.l.a(HttpStatus.SC_PARTIAL_CONTENT));
        this.mCurrentState = 6;
        aWW();
        return this.fvI;
    }

    @Override // com.baidu.tieba.i.i
    public boolean pF(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.ic(str);
        aXb();
        this.fvM.add(new com.baidu.tieba.l.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aWW();
        return true;
    }

    @Override // com.baidu.tieba.i.i
    public void i(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fvP == null && com.baidu.adp.lib.util.f.lk()) {
                this.fvP = new com.baidu.tieba.i.a.d(this.fvI);
                a(this.fvP);
            }
            if (this.fvP != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fvP.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.IH())) {
            if (this.fvO == null && com.baidu.adp.lib.util.f.lk()) {
                this.fvO = new com.baidu.tieba.i.a.b(this.fvI);
                a(this.fvO);
            }
            if (this.fvO != null) {
                if (this.fvO.size() == 0) {
                    this.fwd = i2;
                }
                this.fvO.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.i.a.c cVar) {
        if (this.fvQ == null) {
            this.fvQ = new ArrayList();
        }
        this.fvQ.add(cVar);
    }

    @Override // com.baidu.tieba.i.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fvI;
        }
        this.fvK = i;
        this.fvY = false;
        this.fvZ = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.ic(str);
        aXb();
        if (!v.E(this.fvQ)) {
            int size = this.fvQ.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.i.a.c cVar = this.fvQ.get(i4);
                if (cVar != null) {
                    cVar.aXk();
                }
            }
        }
        this.fvM.add(new com.baidu.tieba.l.b(i, i2, i3, j, str2, aXa()));
        this.mCurrentState = -1;
        aWW();
        return this.fvI;
    }

    private com.baidu.tieba.i.a.e[] aXa() {
        if (this.fvQ == null || this.fvQ.size() == 0) {
            return null;
        }
        com.baidu.tieba.i.a.e[] eVarArr = new com.baidu.tieba.i.a.e[this.fvQ.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fvQ.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fvQ.get(i2).aXi();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pG(String str) {
        this.fwb = str;
    }

    private void aXb() {
        if (this.fvS != 0) {
            this.fvT += System.currentTimeMillis() - this.fvS;
        }
        this.fvN.put("playDuration", Long.valueOf(this.fvT));
        this.fvN.put("stallCount", Long.valueOf(this.fvU));
        this.fvN.put("stallDuration", Long.valueOf(this.fvV));
        if (!this.fvN.containsKey("loadingTime")) {
            this.fvN.put("loadingTime", 0L);
        }
        this.fvR = 0L;
        this.fvS = 0L;
        this.fvT = 0L;
        this.fvU = 0L;
        this.fvV = 0L;
        this.fvW = 0L;
    }

    @Override // com.baidu.tieba.i.i
    public void aWW() {
        if (!this.fwa) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.IC() || !this.fvY) && reportType != 3) {
                this.fwa = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.i.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.Ue());
                            jSONObject.put("kpiInfo", j.this.aXc());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fvY)) {
                                JSONObject aXd = j.this.aXd();
                                aXd.put("running", j.this.aXe());
                                jSONObject.put("debugInfo", aXd);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.aXd());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.q.e.bAD().c(jSONObject, j.this.fvY ? false : true);
                        if (j.this.fwc != null) {
                            j.this.fwc.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Ue() {
        JSONObject Ue = VideoPlatformStatic.Ue();
        if (this.fwc != null) {
            try {
                int size = this.fwc.size();
                for (int i = 0; i < size; i++) {
                    this.fwc.get(i).M(Ue);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return Ue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aXc() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.fvN.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fvN.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fvN.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fvN.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fvN.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fvX ? 1 : 0);
            jSONObject.put("playSuccess", this.fvY ? 1 : 0);
            jSONObject.put("retryError", this.fvZ ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.fwc != null) {
                int size = this.fwc.size();
                for (int i = 0; i < size; i++) {
                    this.fwc.get(i).N(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aXd() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.fvI);
            if (!StringUtils.isNull(this.fvJ)) {
                jSONObject.put("parentUuid", this.fvJ);
            }
            jSONObject.put("tid", this.bCS);
            jSONObject.put("videoUrl", this.bQI);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.jl(this.fvK));
            jSONObject.put("urlType", this.fvL);
            jSONObject.put("sub_error", this.fwd);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fwb)) {
                jSONObject.put("error_stack", this.fwb);
            }
            if (this.fwc != null) {
                int size = this.fwc.size();
                for (int i = 0; i < size; i++) {
                    this.fwc.get(i).O(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray aXe() {
        JSONArray jSONArray = new JSONArray();
        if (this.fvM == null) {
            return jSONArray;
        }
        int size = this.fvM.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fvM.get(i).bmb());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.i.i
    public void a(b bVar) {
        if (this.fwc == null) {
            this.fwc = new ArrayList();
        }
        this.fwc.add(bVar);
    }

    @Override // com.baidu.tieba.i.i
    public void ji(boolean z) {
        this.fvY = z;
    }

    @Override // com.baidu.tieba.i.i
    public String aWX() {
        return this.fvI;
    }

    @Override // com.baidu.tieba.i.i
    public String aWY() {
        return this.fwd + "";
    }
}
