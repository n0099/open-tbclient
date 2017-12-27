package com.baidu.tieba.i;

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
    private String bAK;
    private String bOw;
    private int fqA;
    private com.baidu.tieba.i.a.b fqD;
    private com.baidu.tieba.i.a.d fqE;
    private List<com.baidu.tieba.i.a.c> fqF;
    private long fqJ;
    private long fqK;
    private long fqL;
    private boolean fqM;
    private boolean fqP;
    private String fqQ;
    private List<b> fqR;
    private int fqS;
    private String fqy;
    private int fqz;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fqN = true;
    private boolean fqO = false;
    private String fqx = UUID.randomUUID().toString();
    private Map<String, Long> fqC = new HashMap();
    private List<com.baidu.tieba.l.c> fqB = new ArrayList();
    private long fqG = 0;
    private long fqH = 0;
    private long fqI = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.bAK = str;
        this.bOw = str2;
        this.fqy = str3;
    }

    @Override // com.baidu.tieba.i.i
    public void aUY() {
        this.fqG = System.currentTimeMillis();
        this.fqB.add(new com.baidu.tieba.l.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.i.i
    public void pj(String str) {
        po(str);
        this.fqB.add(new com.baidu.tieba.l.a(1));
        this.mCurrentState = 1;
    }

    private void po(String str) {
        if (!StringUtils.isNull(str)) {
            this.fqA = VideoPlatformStatic.hJ(str);
            if (this.fqA != 0) {
                this.fqM = true;
            }
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aUZ() {
        this.fqB.add(new com.baidu.tieba.l.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void aVa() {
        if (this.mCurrentState != 2) {
            this.fqG = System.currentTimeMillis();
            this.fqB.add(new com.baidu.tieba.l.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fqG = System.currentTimeMillis();
        po(str);
        this.fqB.add(new com.baidu.tieba.l.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void sl(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fqz = i;
            this.fqN = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fqG;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.fqC.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fqG = 0L;
            this.fqH = System.currentTimeMillis();
            this.fqB.add(new com.baidu.tieba.l.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void sm(int i) {
        if (this.mCurrentState == 5) {
            aVh();
        } else if (this.mCurrentState == 3) {
            this.fqz = i;
            this.fqB.add(new com.baidu.tieba.l.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aVb() {
        if (this.fqH != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fqI += currentTimeMillis - this.fqH;
            this.fqH = currentTimeMillis;
        }
        this.fqJ++;
        this.fqL = System.currentTimeMillis();
        this.fqB.add(new com.baidu.tieba.l.a(HttpStatus.SC_CREATED));
    }

    @Override // com.baidu.tieba.i.i
    public void aVc() {
        this.fqH = System.currentTimeMillis();
        if (this.fqL != 0) {
            this.fqK += System.currentTimeMillis() - this.fqL;
        }
        this.fqB.add(new com.baidu.tieba.l.a(HttpStatus.SC_ACCEPTED));
    }

    @Override // com.baidu.tieba.i.i
    public void aVd() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fqH != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fqI += currentTimeMillis - this.fqH;
                this.fqH = currentTimeMillis;
            }
            this.fqB.add(new com.baidu.tieba.l.a(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION));
            this.mCurrentState = 5;
        }
    }

    public void aVh() {
        if (this.mCurrentState == 5) {
            this.fqH = System.currentTimeMillis();
            this.fqB.add(new com.baidu.tieba.l.a(HttpStatus.SC_NO_CONTENT));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pk(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.hK(str);
            aVj();
            this.fqB.add(new com.baidu.tieba.l.a(HttpStatus.SC_RESET_CONTENT));
            this.mCurrentState = 8;
            aVe();
        }
    }

    @Override // com.baidu.tieba.i.i
    public String pl(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fqx;
        }
        this.mSource = VideoPlatformStatic.hK(str);
        aVj();
        this.fqC.put("stallDuration", Long.valueOf(this.fqK));
        this.fqB.add(new com.baidu.tieba.l.a(HttpStatus.SC_PARTIAL_CONTENT));
        this.mCurrentState = 6;
        aVe();
        return this.fqx;
    }

    @Override // com.baidu.tieba.i.i
    public boolean pm(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.hK(str);
        aVj();
        this.fqB.add(new com.baidu.tieba.l.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aVe();
        return true;
    }

    @Override // com.baidu.tieba.i.i
    public void i(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fqE == null && com.baidu.adp.lib.util.f.lk()) {
                this.fqE = new com.baidu.tieba.i.a.d(this.fqx);
                a(this.fqE);
            }
            if (this.fqE != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fqE.a(new com.baidu.tieba.play.c.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.Ih())) {
            if (this.fqD == null && com.baidu.adp.lib.util.f.lk()) {
                this.fqD = new com.baidu.tieba.i.a.b(this.fqx);
                a(this.fqD);
            }
            if (this.fqD != null) {
                if (this.fqD.size() == 0) {
                    this.fqS = i2;
                }
                this.fqD.a(new com.baidu.tieba.play.c.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.i.a.c cVar) {
        if (this.fqF == null) {
            this.fqF = new ArrayList();
        }
        this.fqF.add(cVar);
    }

    @Override // com.baidu.tieba.i.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fqx;
        }
        this.fqz = i;
        this.fqN = false;
        this.fqO = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.hK(str);
        aVj();
        if (!v.G(this.fqF)) {
            int size = this.fqF.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.i.a.c cVar = this.fqF.get(i4);
                if (cVar != null) {
                    cVar.aVs();
                }
            }
        }
        this.fqB.add(new com.baidu.tieba.l.b(i, i2, i3, j, str2, aVi()));
        this.mCurrentState = -1;
        aVe();
        return this.fqx;
    }

    private com.baidu.tieba.i.a.e[] aVi() {
        if (this.fqF == null || this.fqF.size() == 0) {
            return null;
        }
        com.baidu.tieba.i.a.e[] eVarArr = new com.baidu.tieba.i.a.e[this.fqF.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fqF.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fqF.get(i2).aVq();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pn(String str) {
        this.fqQ = str;
    }

    private void aVj() {
        if (this.fqH != 0) {
            this.fqI += System.currentTimeMillis() - this.fqH;
        }
        this.fqC.put("playDuration", Long.valueOf(this.fqI));
        this.fqC.put("stallCount", Long.valueOf(this.fqJ));
        this.fqC.put("stallDuration", Long.valueOf(this.fqK));
        if (!this.fqC.containsKey("loadingTime")) {
            this.fqC.put("loadingTime", 0L);
        }
        this.fqG = 0L;
        this.fqH = 0L;
        this.fqI = 0L;
        this.fqJ = 0L;
        this.fqK = 0L;
        this.fqL = 0L;
    }

    @Override // com.baidu.tieba.i.i
    public void aVe() {
        if (!this.fqP) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.Ic() || !this.fqN) && reportType != 3) {
                this.fqP = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.i.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.TG());
                            jSONObject.put("kpiInfo", j.this.aVk());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fqN)) {
                                JSONObject aVl = j.this.aVl();
                                aVl.put("running", j.this.aVm());
                                jSONObject.put("debugInfo", aVl);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.aVl());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.q.e.bGv().c(jSONObject, j.this.fqN ? false : true);
                        if (j.this.fqR != null) {
                            j.this.fqR.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject TG() {
        JSONObject TG = VideoPlatformStatic.TG();
        if (this.fqR != null) {
            try {
                int size = this.fqR.size();
                for (int i = 0; i < size; i++) {
                    this.fqR.get(i).G(TG);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return TG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aVk() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.fqC.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fqC.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fqC.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fqC.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fqC.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fqM ? 1 : 0);
            jSONObject.put("playSuccess", this.fqN ? 1 : 0);
            jSONObject.put("retryError", this.fqO ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.fqR != null) {
                int size = this.fqR.size();
                for (int i = 0; i < size; i++) {
                    this.fqR.get(i).H(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aVl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.fqx);
            if (!StringUtils.isNull(this.fqy)) {
                jSONObject.put("parentUuid", this.fqy);
            }
            jSONObject.put("tid", this.bAK);
            jSONObject.put("videoUrl", this.bOw);
            jSONObject.put(LegoListActivityConfig.IS_FROM, this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.jt(this.fqz));
            jSONObject.put("urlType", this.fqA);
            jSONObject.put("sub_error", this.fqS);
            if (!StringUtils.isNull(this.fqQ)) {
                jSONObject.put("error_stack", this.fqQ);
            }
            if (this.fqR != null) {
                int size = this.fqR.size();
                for (int i = 0; i < size; i++) {
                    this.fqR.get(i).I(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray aVm() {
        JSONArray jSONArray = new JSONArray();
        if (this.fqB == null) {
            return jSONArray;
        }
        int size = this.fqB.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fqB.get(i).brv());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.i.i
    public void a(b bVar) {
        if (this.fqR == null) {
            this.fqR = new ArrayList();
        }
        this.fqR.add(bVar);
    }

    @Override // com.baidu.tieba.i.i
    public void iT(boolean z) {
        this.fqN = z;
    }

    @Override // com.baidu.tieba.i.i
    public String aVf() {
        return this.fqx;
    }

    @Override // com.baidu.tieba.i.i
    public String aVg() {
        return this.fqS + "";
    }
}
