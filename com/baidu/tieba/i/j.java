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
    private String bCV;
    private String bQL;
    private String fvZ;
    private int fwa;
    private int fwb;
    private com.baidu.tieba.i.a.b fwe;
    private com.baidu.tieba.i.a.d fwf;
    private List<com.baidu.tieba.i.a.c> fwg;
    private long fwk;
    private long fwl;
    private long fwm;
    private boolean fwn;
    private boolean fwq;
    private String fwr;
    private List<b> fws;
    private int fwt;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fwo = true;
    private boolean fwp = false;
    private String fvY = UUID.randomUUID().toString();
    private Map<String, Long> fwd = new HashMap();
    private List<com.baidu.tieba.l.c> fwc = new ArrayList();
    private long fwh = 0;
    private long fwi = 0;
    private long fwj = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.bCV = str;
        this.bQL = str2;
        this.fvZ = str3;
    }

    @Override // com.baidu.tieba.i.i
    public void aWR() {
        this.fwh = System.currentTimeMillis();
        this.fwc.add(new com.baidu.tieba.l.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.i.i
    public void pC(String str) {
        pH(str);
        this.fwc.add(new com.baidu.tieba.l.a(1));
        this.mCurrentState = 1;
    }

    private void pH(String str) {
        if (!StringUtils.isNull(str)) {
            this.fwb = VideoPlatformStatic.ib(str);
            if (this.fwb != 0) {
                this.fwn = true;
            }
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aWS() {
        this.fwc.add(new com.baidu.tieba.l.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void aWT() {
        if (this.mCurrentState != 2) {
            this.fwh = System.currentTimeMillis();
            this.fwc.add(new com.baidu.tieba.l.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fwh = System.currentTimeMillis();
        pH(str);
        this.fwc.add(new com.baidu.tieba.l.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void si(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fwa = i;
            this.fwo = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fwh;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.fwd.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fwh = 0L;
            this.fwi = System.currentTimeMillis();
            this.fwc.add(new com.baidu.tieba.l.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void sj(int i) {
        if (this.mCurrentState == 5) {
            aXa();
        } else if (this.mCurrentState == 3) {
            this.fwa = i;
            this.fwc.add(new com.baidu.tieba.l.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aWU() {
        if (this.fwi != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fwj += currentTimeMillis - this.fwi;
            this.fwi = currentTimeMillis;
        }
        this.fwk++;
        this.fwm = System.currentTimeMillis();
        this.fwc.add(new com.baidu.tieba.l.a(201));
    }

    @Override // com.baidu.tieba.i.i
    public void aWV() {
        this.fwi = System.currentTimeMillis();
        if (this.fwm != 0) {
            this.fwl += System.currentTimeMillis() - this.fwm;
        }
        this.fwc.add(new com.baidu.tieba.l.a(202));
    }

    @Override // com.baidu.tieba.i.i
    public void aWW() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fwi != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fwj += currentTimeMillis - this.fwi;
                this.fwi = currentTimeMillis;
            }
            this.fwc.add(new com.baidu.tieba.l.a(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION));
            this.mCurrentState = 5;
        }
    }

    public void aXa() {
        if (this.mCurrentState == 5) {
            this.fwi = System.currentTimeMillis();
            this.fwc.add(new com.baidu.tieba.l.a(HttpStatus.SC_NO_CONTENT));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pD(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.ic(str);
            aXc();
            this.fwc.add(new com.baidu.tieba.l.a(HttpStatus.SC_RESET_CONTENT));
            this.mCurrentState = 8;
            aWX();
        }
    }

    @Override // com.baidu.tieba.i.i
    public String pE(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fvY;
        }
        this.mSource = VideoPlatformStatic.ic(str);
        aXc();
        this.fwd.put("stallDuration", Long.valueOf(this.fwl));
        this.fwc.add(new com.baidu.tieba.l.a(HttpStatus.SC_PARTIAL_CONTENT));
        this.mCurrentState = 6;
        aWX();
        return this.fvY;
    }

    @Override // com.baidu.tieba.i.i
    public boolean pF(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.ic(str);
        aXc();
        this.fwc.add(new com.baidu.tieba.l.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aWX();
        return true;
    }

    @Override // com.baidu.tieba.i.i
    public void i(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fwf == null && com.baidu.adp.lib.util.f.lk()) {
                this.fwf = new com.baidu.tieba.i.a.d(this.fvY);
                a(this.fwf);
            }
            if (this.fwf != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fwf.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.II())) {
            if (this.fwe == null && com.baidu.adp.lib.util.f.lk()) {
                this.fwe = new com.baidu.tieba.i.a.b(this.fvY);
                a(this.fwe);
            }
            if (this.fwe != null) {
                if (this.fwe.size() == 0) {
                    this.fwt = i2;
                }
                this.fwe.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.i.a.c cVar) {
        if (this.fwg == null) {
            this.fwg = new ArrayList();
        }
        this.fwg.add(cVar);
    }

    @Override // com.baidu.tieba.i.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fvY;
        }
        this.fwa = i;
        this.fwo = false;
        this.fwp = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.ic(str);
        aXc();
        if (!v.E(this.fwg)) {
            int size = this.fwg.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.i.a.c cVar = this.fwg.get(i4);
                if (cVar != null) {
                    cVar.aXl();
                }
            }
        }
        this.fwc.add(new com.baidu.tieba.l.b(i, i2, i3, j, str2, aXb()));
        this.mCurrentState = -1;
        aWX();
        return this.fvY;
    }

    private com.baidu.tieba.i.a.e[] aXb() {
        if (this.fwg == null || this.fwg.size() == 0) {
            return null;
        }
        com.baidu.tieba.i.a.e[] eVarArr = new com.baidu.tieba.i.a.e[this.fwg.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fwg.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fwg.get(i2).aXj();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pG(String str) {
        this.fwr = str;
    }

    private void aXc() {
        if (this.fwi != 0) {
            this.fwj += System.currentTimeMillis() - this.fwi;
        }
        this.fwd.put("playDuration", Long.valueOf(this.fwj));
        this.fwd.put("stallCount", Long.valueOf(this.fwk));
        this.fwd.put("stallDuration", Long.valueOf(this.fwl));
        if (!this.fwd.containsKey("loadingTime")) {
            this.fwd.put("loadingTime", 0L);
        }
        this.fwh = 0L;
        this.fwi = 0L;
        this.fwj = 0L;
        this.fwk = 0L;
        this.fwl = 0L;
        this.fwm = 0L;
    }

    @Override // com.baidu.tieba.i.i
    public void aWX() {
        if (!this.fwq) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.ID() || !this.fwo) && reportType != 3) {
                this.fwq = true;
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
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fwo)) {
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
                        com.baidu.tieba.q.e.bAI().c(jSONObject, j.this.fwo ? false : true);
                        if (j.this.fws != null) {
                            j.this.fws.clear();
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
        if (this.fws != null) {
            try {
                int size = this.fws.size();
                for (int i = 0; i < size; i++) {
                    this.fws.get(i).M(Uf);
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
            for (Map.Entry<String, Long> entry : this.fwd.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fwd.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fwd.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fwd.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fwd.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fwn ? 1 : 0);
            jSONObject.put("playSuccess", this.fwo ? 1 : 0);
            jSONObject.put("retryError", this.fwp ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.fws != null) {
                int size = this.fws.size();
                for (int i = 0; i < size; i++) {
                    this.fws.get(i).N(jSONObject);
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
            jSONObject.put(UserBox.TYPE, this.fvY);
            if (!StringUtils.isNull(this.fvZ)) {
                jSONObject.put("parentUuid", this.fvZ);
            }
            jSONObject.put("tid", this.bCV);
            jSONObject.put("videoUrl", this.bQL);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.jl(this.fwa));
            jSONObject.put("urlType", this.fwb);
            jSONObject.put("sub_error", this.fwt);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fwr)) {
                jSONObject.put("error_stack", this.fwr);
            }
            if (this.fws != null) {
                int size = this.fws.size();
                for (int i = 0; i < size; i++) {
                    this.fws.get(i).O(jSONObject);
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
        if (this.fwc == null) {
            return jSONArray;
        }
        int size = this.fwc.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fwc.get(i).bmc());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.i.i
    public void a(b bVar) {
        if (this.fws == null) {
            this.fws = new ArrayList();
        }
        this.fws.add(bVar);
    }

    @Override // com.baidu.tieba.i.i
    public void jn(boolean z) {
        this.fwo = z;
    }

    @Override // com.baidu.tieba.i.i
    public String aWY() {
        return this.fvY;
    }

    @Override // com.baidu.tieba.i.i
    public String aWZ() {
        return this.fwt + "";
    }
}
