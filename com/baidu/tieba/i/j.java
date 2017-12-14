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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j implements i {
    private String aMU;
    private String baI;
    private com.baidu.tieba.i.a.b eEA;
    private com.baidu.tieba.i.a.d eEB;
    private List<com.baidu.tieba.i.a.c> eEC;
    private long eEG;
    private long eEH;
    private long eEI;
    private boolean eEJ;
    private boolean eEM;
    private String eEN;
    private List<b> eEO;
    private int eEP;
    private String eEv;
    private int eEw;
    private int eEx;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean eEK = true;
    private boolean eEL = false;
    private String eEu = UUID.randomUUID().toString();
    private Map<String, Long> eEz = new HashMap();
    private List<com.baidu.tieba.l.c> eEy = new ArrayList();
    private long eED = 0;
    private long eEE = 0;
    private long eEF = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.aMU = str;
        this.baI = str2;
        this.eEv = str3;
    }

    @Override // com.baidu.tieba.i.i
    public void aNW() {
        this.eED = System.currentTimeMillis();
        this.eEy.add(new com.baidu.tieba.l.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.i.i
    public void oZ(String str) {
        pe(str);
        this.eEy.add(new com.baidu.tieba.l.a(1));
        this.mCurrentState = 1;
    }

    private void pe(String str) {
        if (!StringUtils.isNull(str)) {
            this.eEx = VideoPlatformStatic.hH(str);
            if (this.eEx != 0) {
                this.eEJ = true;
            }
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aNX() {
        this.eEy.add(new com.baidu.tieba.l.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void aNY() {
        if (this.mCurrentState != 2) {
            this.eED = System.currentTimeMillis();
            this.eEy.add(new com.baidu.tieba.l.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.eED = System.currentTimeMillis();
        pe(str);
        this.eEy.add(new com.baidu.tieba.l.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void aNZ() {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            long currentTimeMillis = System.currentTimeMillis() - this.eED;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.eEz.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.eED = 0L;
            this.eEE = System.currentTimeMillis();
            this.eEy.add(new com.baidu.tieba.l.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pt(int i) {
        if (this.mCurrentState == 5) {
            aOe();
        } else if (this.mCurrentState == 3) {
            this.eEw = i;
            this.eEy.add(new com.baidu.tieba.l.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aOa() {
        if (this.eEE != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eEF += currentTimeMillis - this.eEE;
            this.eEE = currentTimeMillis;
        }
        this.eEG++;
        this.eEI = System.currentTimeMillis();
        this.eEy.add(new com.baidu.tieba.l.a(201));
    }

    @Override // com.baidu.tieba.i.i
    public void aOb() {
        this.eEE = System.currentTimeMillis();
        if (this.eEI != 0) {
            this.eEH += System.currentTimeMillis() - this.eEI;
        }
        this.eEy.add(new com.baidu.tieba.l.a(202));
    }

    @Override // com.baidu.tieba.i.i
    public void aOc() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.eEE != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.eEF += currentTimeMillis - this.eEE;
                this.eEE = currentTimeMillis;
            }
            this.eEy.add(new com.baidu.tieba.l.a(203));
            this.mCurrentState = 5;
        }
    }

    public void aOe() {
        if (this.mCurrentState == 5) {
            this.eEE = System.currentTimeMillis();
            this.eEy.add(new com.baidu.tieba.l.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pa(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.eEK = true;
            this.mSource = VideoPlatformStatic.hI(str);
            aOg();
            this.eEy.add(new com.baidu.tieba.l.a(205));
            this.mCurrentState = 8;
            aOd();
        }
    }

    @Override // com.baidu.tieba.i.i
    public String pb(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.eEu;
        }
        this.eEK = true;
        this.mSource = VideoPlatformStatic.hI(str);
        aOg();
        this.eEz.put("stallDuration", Long.valueOf(this.eEH));
        this.eEy.add(new com.baidu.tieba.l.a(206));
        this.mCurrentState = 6;
        aOd();
        return this.eEu;
    }

    @Override // com.baidu.tieba.i.i
    public boolean pc(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.eEK = true;
        this.mSource = VideoPlatformStatic.hI(str);
        aOg();
        this.eEy.add(new com.baidu.tieba.l.a(207));
        this.mCurrentState = 7;
        aOd();
        return true;
    }

    @Override // com.baidu.tieba.i.i
    public void g(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.eEB == null && com.baidu.adp.lib.util.f.dG()) {
                this.eEB = new com.baidu.tieba.i.a.d(this.eEu);
                a(this.eEB);
            }
            if (this.eEB != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.eEB.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.AI())) {
            if (this.eEA == null && com.baidu.adp.lib.util.f.dG()) {
                this.eEA = new com.baidu.tieba.i.a.b(this.eEu);
                a(this.eEA);
            }
            if (this.eEA != null) {
                if (this.eEA.size() == 0) {
                    this.eEP = i2;
                }
                this.eEA.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.i.a.c cVar) {
        if (this.eEC == null) {
            this.eEC = new ArrayList();
        }
        this.eEC.add(cVar);
    }

    @Override // com.baidu.tieba.i.i
    public String a(int i, int i2, int i3, String str, boolean z, long j) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.eEu;
        }
        this.eEw = i;
        this.eEK = false;
        this.eEL = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.hI(str);
        aOg();
        if (!v.w(this.eEC)) {
            int size = this.eEC.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.i.a.c cVar = this.eEC.get(i4);
                if (cVar != null) {
                    cVar.aOp();
                }
            }
        }
        this.eEy.add(new com.baidu.tieba.l.b(i, i2, i3, j, aOf()));
        this.mCurrentState = -1;
        aOd();
        return this.eEu;
    }

    private com.baidu.tieba.i.a.e[] aOf() {
        if (this.eEC == null || this.eEC.size() == 0) {
            return null;
        }
        com.baidu.tieba.i.a.e[] eVarArr = new com.baidu.tieba.i.a.e[this.eEC.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eEC.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.eEC.get(i2).aOn();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pd(String str) {
        this.eEN = str;
    }

    private void aOg() {
        if (this.eEE != 0) {
            this.eEF += System.currentTimeMillis() - this.eEE;
        }
        this.eEz.put("playDuration", Long.valueOf(this.eEF));
        this.eEz.put("stallCount", Long.valueOf(this.eEG));
        this.eEz.put("stallDuration", Long.valueOf(this.eEH));
        if (!this.eEz.containsKey("loadingTime")) {
            this.eEz.put("loadingTime", 0L);
        }
        this.eED = 0L;
        this.eEE = 0L;
        this.eEF = 0L;
        this.eEG = 0L;
        this.eEH = 0L;
        this.eEI = 0L;
    }

    @Override // com.baidu.tieba.i.i
    public void aOd() {
        if (!this.eEM) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.AD() || !this.eEK) && reportType != 3) {
                this.eEM = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.i.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.Mh());
                            jSONObject.put("kpiInfo", j.this.aOh());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.eEK)) {
                                JSONObject aOi = j.this.aOi();
                                aOi.put("running", j.this.aOj());
                                jSONObject.put("debugInfo", aOi);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.aOi());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.p.e.bBa().c(jSONObject, j.this.eEK ? false : true);
                        if (j.this.eEO != null) {
                            j.this.eEO.clear();
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
        if (this.eEO != null) {
            try {
                int size = this.eEO.size();
                for (int i = 0; i < size; i++) {
                    this.eEO.get(i).F(Mh);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return Mh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aOh() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.eEz.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.eEz.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.eEz.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.eEz.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.eEz.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.eEJ ? 1 : 0);
            jSONObject.put("playSuccess", this.eEK ? 1 : 0);
            jSONObject.put("retryError", this.eEL ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.eEO != null) {
                int size = this.eEO.size();
                for (int i = 0; i < size; i++) {
                    this.eEO.get(i).G(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aOi() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.eEu);
            if (!StringUtils.isNull(this.eEv)) {
                jSONObject.put("parentUuid", this.eEv);
            }
            jSONObject.put("tid", this.aMU);
            jSONObject.put("videoUrl", this.baI);
            jSONObject.put(LegoListActivityConfig.IS_FROM, this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.gu(this.eEw));
            jSONObject.put("urlType", this.eEx);
            jSONObject.put("sub_error", this.eEP);
            if (!StringUtils.isNull(this.eEN)) {
                jSONObject.put("error_stack", this.eEN);
            }
            if (this.eEO != null) {
                int size = this.eEO.size();
                for (int i = 0; i < size; i++) {
                    this.eEO.get(i).H(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray aOj() {
        JSONArray jSONArray = new JSONArray();
        if (this.eEy == null) {
            return jSONArray;
        }
        int size = this.eEy.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.eEy.get(i).bjQ());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.i.i
    public void a(b bVar) {
        if (this.eEO == null) {
            this.eEO = new ArrayList();
        }
        this.eEO.add(bVar);
    }
}
