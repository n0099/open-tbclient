package com.baidu.tieba.i;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiSafeFacade;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j implements i {
    private String aMR;
    private String baH;
    private long eDC;
    private long eDD;
    private long eDE;
    private boolean eDF;
    private boolean eDI;
    private String eDJ;
    private List<b> eDK;
    private int eDL;
    private String eDr;
    private int eDs;
    private int eDt;
    private com.baidu.tieba.i.a.b eDw;
    private com.baidu.tieba.i.a.d eDx;
    private List<com.baidu.tieba.i.a.c> eDy;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean eDG = true;
    private boolean eDH = false;
    private String eDq = UUID.randomUUID().toString();
    private Map<String, Long> eDv = new HashMap();
    private List<com.baidu.tieba.l.c> eDu = new ArrayList();
    private long eDz = 0;
    private long eDA = 0;
    private long eDB = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.aMR = str;
        this.baH = str2;
        this.eDr = str3;
    }

    @Override // com.baidu.tieba.i.i
    public void aNN() {
        this.eDz = System.currentTimeMillis();
        this.eDu.add(new com.baidu.tieba.l.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.i.i
    public void oZ(String str) {
        pe(str);
        this.eDu.add(new com.baidu.tieba.l.a(1));
        this.mCurrentState = 1;
    }

    private void pe(String str) {
        if (!StringUtils.isNull(str)) {
            this.eDt = VideoPlatformStatic.hJ(str);
            if (this.eDt != 0) {
                this.eDF = true;
            }
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aNO() {
        this.eDu.add(new com.baidu.tieba.l.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void aNP() {
        if (this.mCurrentState != 2) {
            this.eDz = System.currentTimeMillis();
            this.eDu.add(new com.baidu.tieba.l.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.eDz = System.currentTimeMillis();
        pe(str);
        this.eDu.add(new com.baidu.tieba.l.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void aNQ() {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            long currentTimeMillis = System.currentTimeMillis() - this.eDz;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.eDv.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.eDz = 0L;
            this.eDA = System.currentTimeMillis();
            this.eDu.add(new com.baidu.tieba.l.a(SapiSafeFacade.SAPIWEBVIEW_BACK));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pm(int i) {
        if (this.mCurrentState == 5) {
            aNV();
        } else if (this.mCurrentState == 3) {
            this.eDs = i;
            this.eDu.add(new com.baidu.tieba.l.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aNR() {
        if (this.eDA != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eDB += currentTimeMillis - this.eDA;
            this.eDA = currentTimeMillis;
        }
        this.eDC++;
        this.eDE = System.currentTimeMillis();
        this.eDu.add(new com.baidu.tieba.l.a(201));
    }

    @Override // com.baidu.tieba.i.i
    public void aNS() {
        this.eDA = System.currentTimeMillis();
        if (this.eDE != 0) {
            this.eDD += System.currentTimeMillis() - this.eDE;
        }
        this.eDu.add(new com.baidu.tieba.l.a(202));
    }

    @Override // com.baidu.tieba.i.i
    public void aNT() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.eDA != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.eDB += currentTimeMillis - this.eDA;
                this.eDA = currentTimeMillis;
            }
            this.eDu.add(new com.baidu.tieba.l.a(203));
            this.mCurrentState = 5;
        }
    }

    public void aNV() {
        if (this.mCurrentState == 5) {
            this.eDA = System.currentTimeMillis();
            this.eDu.add(new com.baidu.tieba.l.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pa(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.eDG = true;
            this.mSource = VideoPlatformStatic.hK(str);
            aNX();
            this.eDu.add(new com.baidu.tieba.l.a(205));
            this.mCurrentState = 8;
            aNU();
        }
    }

    @Override // com.baidu.tieba.i.i
    public String pb(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.eDq;
        }
        this.eDG = true;
        this.mSource = VideoPlatformStatic.hK(str);
        aNX();
        this.eDv.put("stallDuration", Long.valueOf(this.eDD));
        this.eDu.add(new com.baidu.tieba.l.a(206));
        this.mCurrentState = 6;
        aNU();
        return this.eDq;
    }

    @Override // com.baidu.tieba.i.i
    public boolean pc(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.eDG = true;
        this.mSource = VideoPlatformStatic.hK(str);
        aNX();
        this.eDu.add(new com.baidu.tieba.l.a(207));
        this.mCurrentState = 7;
        aNU();
        return true;
    }

    @Override // com.baidu.tieba.i.i
    public void g(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.eDx == null && com.baidu.adp.lib.util.f.dG()) {
                this.eDx = new com.baidu.tieba.i.a.d(this.eDq);
                a(this.eDx);
            }
            if (this.eDx != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.eDx.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.AH())) {
            if (this.eDw == null && com.baidu.adp.lib.util.f.dG()) {
                this.eDw = new com.baidu.tieba.i.a.b(this.eDq);
                a(this.eDw);
            }
            if (this.eDw != null) {
                if (this.eDw.size() == 0) {
                    this.eDL = i2;
                }
                this.eDw.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.i.a.c cVar) {
        if (this.eDy == null) {
            this.eDy = new ArrayList();
        }
        this.eDy.add(cVar);
    }

    @Override // com.baidu.tieba.i.i
    public String a(int i, int i2, int i3, String str, boolean z, long j) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.eDq;
        }
        this.eDs = i;
        this.eDG = false;
        this.eDH = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.hK(str);
        aNX();
        if (!v.w(this.eDy)) {
            int size = this.eDy.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.i.a.c cVar = this.eDy.get(i4);
                if (cVar != null) {
                    cVar.aOg();
                }
            }
        }
        this.eDu.add(new com.baidu.tieba.l.b(i, i2, i3, j, aNW()));
        this.mCurrentState = -1;
        aNU();
        return this.eDq;
    }

    private com.baidu.tieba.i.a.e[] aNW() {
        if (this.eDy == null || this.eDy.size() == 0) {
            return null;
        }
        com.baidu.tieba.i.a.e[] eVarArr = new com.baidu.tieba.i.a.e[this.eDy.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eDy.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.eDy.get(i2).aOe();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pd(String str) {
        this.eDJ = str;
    }

    private void aNX() {
        if (this.eDA != 0) {
            this.eDB += System.currentTimeMillis() - this.eDA;
        }
        this.eDv.put("playDuration", Long.valueOf(this.eDB));
        this.eDv.put("stallCount", Long.valueOf(this.eDC));
        this.eDv.put("stallDuration", Long.valueOf(this.eDD));
        if (!this.eDv.containsKey("loadingTime")) {
            this.eDv.put("loadingTime", 0L);
        }
        this.eDz = 0L;
        this.eDA = 0L;
        this.eDB = 0L;
        this.eDC = 0L;
        this.eDD = 0L;
        this.eDE = 0L;
    }

    @Override // com.baidu.tieba.i.i
    public void aNU() {
        if (!this.eDI) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.AC() || !this.eDG) && reportType != 3) {
                this.eDI = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.i.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.Mh());
                            jSONObject.put("kpiInfo", j.this.aNY());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.eDG)) {
                                JSONObject aNZ = j.this.aNZ();
                                aNZ.put("running", j.this.aOa());
                                jSONObject.put("debugInfo", aNZ);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.aNZ());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.p.e.bAt().c(jSONObject, j.this.eDG ? false : true);
                        if (j.this.eDK != null) {
                            j.this.eDK.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Mh() {
        JSONObject Mh = VideoPlatformStatic.Mh();
        if (this.eDK != null) {
            try {
                int size = this.eDK.size();
                for (int i = 0; i < size; i++) {
                    this.eDK.get(i).G(Mh);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return Mh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aNY() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.eDv.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.eDv.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.eDv.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.eDv.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.eDv.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.eDF ? 1 : 0);
            jSONObject.put("playSuccess", this.eDG ? 1 : 0);
            jSONObject.put("retryError", this.eDH ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.eDK != null) {
                int size = this.eDK.size();
                for (int i = 0; i < size; i++) {
                    this.eDK.get(i).H(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aNZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.eDq);
            if (!StringUtils.isNull(this.eDr)) {
                jSONObject.put("parentUuid", this.eDr);
            }
            jSONObject.put("tid", this.aMR);
            jSONObject.put("videoUrl", this.baH);
            jSONObject.put(LegoListActivityConfig.IS_FROM, this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.gu(this.eDs));
            jSONObject.put("urlType", this.eDt);
            jSONObject.put("sub_error", this.eDL);
            if (!StringUtils.isNull(this.eDJ)) {
                jSONObject.put("error_stack", this.eDJ);
            }
            if (this.eDK != null) {
                int size = this.eDK.size();
                for (int i = 0; i < size; i++) {
                    this.eDK.get(i).I(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray aOa() {
        JSONArray jSONArray = new JSONArray();
        if (this.eDu == null) {
            return jSONArray;
        }
        int size = this.eDu.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.eDu.get(i).bjI());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.i.i
    public void a(b bVar) {
        if (this.eDK == null) {
            this.eDK = new ArrayList();
        }
        this.eDK.add(bVar);
    }
}
