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
    private String aMX;
    private String baM;
    private int eEA;
    private int eEB;
    private com.baidu.tieba.i.a.b eEE;
    private com.baidu.tieba.i.a.d eEF;
    private List<com.baidu.tieba.i.a.c> eEG;
    private long eEK;
    private long eEL;
    private long eEM;
    private boolean eEN;
    private boolean eEQ;
    private String eER;
    private List<b> eES;
    private int eET;
    private String eEz;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean eEO = true;
    private boolean eEP = false;
    private String eEy = UUID.randomUUID().toString();
    private Map<String, Long> eED = new HashMap();
    private List<com.baidu.tieba.l.c> eEC = new ArrayList();
    private long eEH = 0;
    private long eEI = 0;
    private long eEJ = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.aMX = str;
        this.baM = str2;
        this.eEz = str3;
    }

    @Override // com.baidu.tieba.i.i
    public void aNW() {
        this.eEH = System.currentTimeMillis();
        this.eEC.add(new com.baidu.tieba.l.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.i.i
    public void oZ(String str) {
        pe(str);
        this.eEC.add(new com.baidu.tieba.l.a(1));
        this.mCurrentState = 1;
    }

    private void pe(String str) {
        if (!StringUtils.isNull(str)) {
            this.eEB = VideoPlatformStatic.hH(str);
            if (this.eEB != 0) {
                this.eEN = true;
            }
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aNX() {
        this.eEC.add(new com.baidu.tieba.l.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void aNY() {
        if (this.mCurrentState != 2) {
            this.eEH = System.currentTimeMillis();
            this.eEC.add(new com.baidu.tieba.l.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.eEH = System.currentTimeMillis();
        pe(str);
        this.eEC.add(new com.baidu.tieba.l.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void aNZ() {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            long currentTimeMillis = System.currentTimeMillis() - this.eEH;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.eED.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.eEH = 0L;
            this.eEI = System.currentTimeMillis();
            this.eEC.add(new com.baidu.tieba.l.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pt(int i) {
        if (this.mCurrentState == 5) {
            aOe();
        } else if (this.mCurrentState == 3) {
            this.eEA = i;
            this.eEC.add(new com.baidu.tieba.l.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aOa() {
        if (this.eEI != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eEJ += currentTimeMillis - this.eEI;
            this.eEI = currentTimeMillis;
        }
        this.eEK++;
        this.eEM = System.currentTimeMillis();
        this.eEC.add(new com.baidu.tieba.l.a(201));
    }

    @Override // com.baidu.tieba.i.i
    public void aOb() {
        this.eEI = System.currentTimeMillis();
        if (this.eEM != 0) {
            this.eEL += System.currentTimeMillis() - this.eEM;
        }
        this.eEC.add(new com.baidu.tieba.l.a(202));
    }

    @Override // com.baidu.tieba.i.i
    public void aOc() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.eEI != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.eEJ += currentTimeMillis - this.eEI;
                this.eEI = currentTimeMillis;
            }
            this.eEC.add(new com.baidu.tieba.l.a(203));
            this.mCurrentState = 5;
        }
    }

    public void aOe() {
        if (this.mCurrentState == 5) {
            this.eEI = System.currentTimeMillis();
            this.eEC.add(new com.baidu.tieba.l.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pa(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.eEO = true;
            this.mSource = VideoPlatformStatic.hI(str);
            aOg();
            this.eEC.add(new com.baidu.tieba.l.a(205));
            this.mCurrentState = 8;
            aOd();
        }
    }

    @Override // com.baidu.tieba.i.i
    public String pb(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.eEy;
        }
        this.eEO = true;
        this.mSource = VideoPlatformStatic.hI(str);
        aOg();
        this.eED.put("stallDuration", Long.valueOf(this.eEL));
        this.eEC.add(new com.baidu.tieba.l.a(206));
        this.mCurrentState = 6;
        aOd();
        return this.eEy;
    }

    @Override // com.baidu.tieba.i.i
    public boolean pc(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.eEO = true;
        this.mSource = VideoPlatformStatic.hI(str);
        aOg();
        this.eEC.add(new com.baidu.tieba.l.a(207));
        this.mCurrentState = 7;
        aOd();
        return true;
    }

    @Override // com.baidu.tieba.i.i
    public void g(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.eEF == null && com.baidu.adp.lib.util.f.dG()) {
                this.eEF = new com.baidu.tieba.i.a.d(this.eEy);
                a(this.eEF);
            }
            if (this.eEF != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.eEF.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.AI())) {
            if (this.eEE == null && com.baidu.adp.lib.util.f.dG()) {
                this.eEE = new com.baidu.tieba.i.a.b(this.eEy);
                a(this.eEE);
            }
            if (this.eEE != null) {
                if (this.eEE.size() == 0) {
                    this.eET = i2;
                }
                this.eEE.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.i.a.c cVar) {
        if (this.eEG == null) {
            this.eEG = new ArrayList();
        }
        this.eEG.add(cVar);
    }

    @Override // com.baidu.tieba.i.i
    public String a(int i, int i2, int i3, String str, boolean z, long j) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.eEy;
        }
        this.eEA = i;
        this.eEO = false;
        this.eEP = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.hI(str);
        aOg();
        if (!v.w(this.eEG)) {
            int size = this.eEG.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.i.a.c cVar = this.eEG.get(i4);
                if (cVar != null) {
                    cVar.aOp();
                }
            }
        }
        this.eEC.add(new com.baidu.tieba.l.b(i, i2, i3, j, aOf()));
        this.mCurrentState = -1;
        aOd();
        return this.eEy;
    }

    private com.baidu.tieba.i.a.e[] aOf() {
        if (this.eEG == null || this.eEG.size() == 0) {
            return null;
        }
        com.baidu.tieba.i.a.e[] eVarArr = new com.baidu.tieba.i.a.e[this.eEG.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eEG.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.eEG.get(i2).aOn();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pd(String str) {
        this.eER = str;
    }

    private void aOg() {
        if (this.eEI != 0) {
            this.eEJ += System.currentTimeMillis() - this.eEI;
        }
        this.eED.put("playDuration", Long.valueOf(this.eEJ));
        this.eED.put("stallCount", Long.valueOf(this.eEK));
        this.eED.put("stallDuration", Long.valueOf(this.eEL));
        if (!this.eED.containsKey("loadingTime")) {
            this.eED.put("loadingTime", 0L);
        }
        this.eEH = 0L;
        this.eEI = 0L;
        this.eEJ = 0L;
        this.eEK = 0L;
        this.eEL = 0L;
        this.eEM = 0L;
    }

    @Override // com.baidu.tieba.i.i
    public void aOd() {
        if (!this.eEQ) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.AD() || !this.eEO) && reportType != 3) {
                this.eEQ = true;
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
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.eEO)) {
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
                        com.baidu.tieba.p.e.bBa().c(jSONObject, j.this.eEO ? false : true);
                        if (j.this.eES != null) {
                            j.this.eES.clear();
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
        if (this.eES != null) {
            try {
                int size = this.eES.size();
                for (int i = 0; i < size; i++) {
                    this.eES.get(i).F(Mh);
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
            for (Map.Entry<String, Long> entry : this.eED.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.eED.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.eED.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.eED.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.eED.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.eEN ? 1 : 0);
            jSONObject.put("playSuccess", this.eEO ? 1 : 0);
            jSONObject.put("retryError", this.eEP ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.eES != null) {
                int size = this.eES.size();
                for (int i = 0; i < size; i++) {
                    this.eES.get(i).G(jSONObject);
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
            jSONObject.put(UserBox.TYPE, this.eEy);
            if (!StringUtils.isNull(this.eEz)) {
                jSONObject.put("parentUuid", this.eEz);
            }
            jSONObject.put("tid", this.aMX);
            jSONObject.put("videoUrl", this.baM);
            jSONObject.put(LegoListActivityConfig.IS_FROM, this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.gu(this.eEA));
            jSONObject.put("urlType", this.eEB);
            jSONObject.put("sub_error", this.eET);
            if (!StringUtils.isNull(this.eER)) {
                jSONObject.put("error_stack", this.eER);
            }
            if (this.eES != null) {
                int size = this.eES.size();
                for (int i = 0; i < size; i++) {
                    this.eES.get(i).H(jSONObject);
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
        if (this.eEC == null) {
            return jSONArray;
        }
        int size = this.eEC.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.eEC.get(i).bjQ());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.i.i
    public void a(b bVar) {
        if (this.eES == null) {
            this.eES = new ArrayList();
        }
        this.eES.add(bVar);
    }
}
