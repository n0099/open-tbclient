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
    private String bAT;
    private String bOE;
    private String frZ;
    private int fsa;
    private int fsb;
    private com.baidu.tieba.i.a.b fse;
    private com.baidu.tieba.i.a.d fsf;
    private List<com.baidu.tieba.i.a.c> fsg;
    private long fsk;
    private long fsl;
    private long fsm;
    private boolean fsn;
    private boolean fsq;
    private String fsr;
    private List<b> fss;
    private int fst;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fso = true;
    private boolean fsp = false;
    private String frY = UUID.randomUUID().toString();
    private Map<String, Long> fsd = new HashMap();
    private List<com.baidu.tieba.l.c> fsc = new ArrayList();
    private long fsh = 0;
    private long fsi = 0;
    private long fsj = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.bAT = str;
        this.bOE = str2;
        this.frZ = str3;
    }

    @Override // com.baidu.tieba.i.i
    public void aVd() {
        this.fsh = System.currentTimeMillis();
        this.fsc.add(new com.baidu.tieba.l.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.i.i
    public void pm(String str) {
        pr(str);
        this.fsc.add(new com.baidu.tieba.l.a(1));
        this.mCurrentState = 1;
    }

    private void pr(String str) {
        if (!StringUtils.isNull(str)) {
            this.fsb = VideoPlatformStatic.hK(str);
            if (this.fsb != 0) {
                this.fsn = true;
            }
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aVe() {
        this.fsc.add(new com.baidu.tieba.l.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void aVf() {
        if (this.mCurrentState != 2) {
            this.fsh = System.currentTimeMillis();
            this.fsc.add(new com.baidu.tieba.l.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fsh = System.currentTimeMillis();
        pr(str);
        this.fsc.add(new com.baidu.tieba.l.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.i.i
    public void se(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fsa = i;
            this.fso = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fsh;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.fsd.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fsh = 0L;
            this.fsi = System.currentTimeMillis();
            this.fsc.add(new com.baidu.tieba.l.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void sf(int i) {
        if (this.mCurrentState == 5) {
            aVm();
        } else if (this.mCurrentState == 3) {
            this.fsa = i;
            this.fsc.add(new com.baidu.tieba.l.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void aVg() {
        if (this.fsi != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fsj += currentTimeMillis - this.fsi;
            this.fsi = currentTimeMillis;
        }
        this.fsk++;
        this.fsm = System.currentTimeMillis();
        this.fsc.add(new com.baidu.tieba.l.a(HttpStatus.SC_CREATED));
    }

    @Override // com.baidu.tieba.i.i
    public void aVh() {
        this.fsi = System.currentTimeMillis();
        if (this.fsm != 0) {
            this.fsl += System.currentTimeMillis() - this.fsm;
        }
        this.fsc.add(new com.baidu.tieba.l.a(HttpStatus.SC_ACCEPTED));
    }

    @Override // com.baidu.tieba.i.i
    public void aVi() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fsi != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fsj += currentTimeMillis - this.fsi;
                this.fsi = currentTimeMillis;
            }
            this.fsc.add(new com.baidu.tieba.l.a(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION));
            this.mCurrentState = 5;
        }
    }

    public void aVm() {
        if (this.mCurrentState == 5) {
            this.fsi = System.currentTimeMillis();
            this.fsc.add(new com.baidu.tieba.l.a(HttpStatus.SC_NO_CONTENT));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pn(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.hL(str);
            aVo();
            this.fsc.add(new com.baidu.tieba.l.a(HttpStatus.SC_RESET_CONTENT));
            this.mCurrentState = 8;
            aVj();
        }
    }

    @Override // com.baidu.tieba.i.i
    public String po(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.frY;
        }
        this.mSource = VideoPlatformStatic.hL(str);
        aVo();
        this.fsd.put("stallDuration", Long.valueOf(this.fsl));
        this.fsc.add(new com.baidu.tieba.l.a(HttpStatus.SC_PARTIAL_CONTENT));
        this.mCurrentState = 6;
        aVj();
        return this.frY;
    }

    @Override // com.baidu.tieba.i.i
    public boolean pp(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.hL(str);
        aVo();
        this.fsc.add(new com.baidu.tieba.l.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aVj();
        return true;
    }

    @Override // com.baidu.tieba.i.i
    public void i(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fsf == null && com.baidu.adp.lib.util.f.lk()) {
                this.fsf = new com.baidu.tieba.i.a.d(this.frY);
                a(this.fsf);
            }
            if (this.fsf != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fsf.a(new com.baidu.tieba.play.c.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.Ia())) {
            if (this.fse == null && com.baidu.adp.lib.util.f.lk()) {
                this.fse = new com.baidu.tieba.i.a.b(this.frY);
                a(this.fse);
            }
            if (this.fse != null) {
                if (this.fse.size() == 0) {
                    this.fst = i2;
                }
                this.fse.a(new com.baidu.tieba.play.c.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.i.a.c cVar) {
        if (this.fsg == null) {
            this.fsg = new ArrayList();
        }
        this.fsg.add(cVar);
    }

    @Override // com.baidu.tieba.i.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.frY;
        }
        this.fsa = i;
        this.fso = false;
        this.fsp = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.hL(str);
        aVo();
        if (!v.E(this.fsg)) {
            int size = this.fsg.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.i.a.c cVar = this.fsg.get(i4);
                if (cVar != null) {
                    cVar.aVx();
                }
            }
        }
        this.fsc.add(new com.baidu.tieba.l.b(i, i2, i3, j, str2, aVn()));
        this.mCurrentState = -1;
        aVj();
        return this.frY;
    }

    private com.baidu.tieba.i.a.e[] aVn() {
        if (this.fsg == null || this.fsg.size() == 0) {
            return null;
        }
        com.baidu.tieba.i.a.e[] eVarArr = new com.baidu.tieba.i.a.e[this.fsg.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fsg.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fsg.get(i2).aVv();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.i.i
    public void pq(String str) {
        this.fsr = str;
    }

    private void aVo() {
        if (this.fsi != 0) {
            this.fsj += System.currentTimeMillis() - this.fsi;
        }
        this.fsd.put("playDuration", Long.valueOf(this.fsj));
        this.fsd.put("stallCount", Long.valueOf(this.fsk));
        this.fsd.put("stallDuration", Long.valueOf(this.fsl));
        if (!this.fsd.containsKey("loadingTime")) {
            this.fsd.put("loadingTime", 0L);
        }
        this.fsh = 0L;
        this.fsi = 0L;
        this.fsj = 0L;
        this.fsk = 0L;
        this.fsl = 0L;
        this.fsm = 0L;
    }

    @Override // com.baidu.tieba.i.i
    public void aVj() {
        if (!this.fsq) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.HV() || !this.fso) && reportType != 3) {
                this.fsq = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.i.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.Tu());
                            jSONObject.put("kpiInfo", j.this.aVp());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fso)) {
                                JSONObject aVq = j.this.aVq();
                                aVq.put("running", j.this.aVr());
                                jSONObject.put("debugInfo", aVq);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.aVq());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.q.e.bzS().c(jSONObject, j.this.fso ? false : true);
                        if (j.this.fss != null) {
                            j.this.fss.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Tu() {
        JSONObject Tu = VideoPlatformStatic.Tu();
        if (this.fss != null) {
            try {
                int size = this.fss.size();
                for (int i = 0; i < size; i++) {
                    this.fss.get(i).H(Tu);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return Tu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aVp() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.fsd.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fsd.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fsd.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fsd.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fsd.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fsn ? 1 : 0);
            jSONObject.put("playSuccess", this.fso ? 1 : 0);
            jSONObject.put("retryError", this.fsp ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.fss != null) {
                int size = this.fss.size();
                for (int i = 0; i < size; i++) {
                    this.fss.get(i).I(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aVq() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.frY);
            if (!StringUtils.isNull(this.frZ)) {
                jSONObject.put("parentUuid", this.frZ);
            }
            jSONObject.put("tid", this.bAT);
            jSONObject.put("videoUrl", this.bOE);
            jSONObject.put(LegoListActivityConfig.IS_FROM, this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.jp(this.fsa));
            jSONObject.put("urlType", this.fsb);
            jSONObject.put("sub_error", this.fst);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fsr)) {
                jSONObject.put("error_stack", this.fsr);
            }
            if (this.fss != null) {
                int size = this.fss.size();
                for (int i = 0; i < size; i++) {
                    this.fss.get(i).J(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray aVr() {
        JSONArray jSONArray = new JSONArray();
        if (this.fsc == null) {
            return jSONArray;
        }
        int size = this.fsc.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fsc.get(i).bkO());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.i.i
    public void a(b bVar) {
        if (this.fss == null) {
            this.fss = new ArrayList();
        }
        this.fss.add(bVar);
    }

    @Override // com.baidu.tieba.i.i
    public void iW(boolean z) {
        this.fso = z;
    }

    @Override // com.baidu.tieba.i.i
    public String aVk() {
        return this.frY;
    }

    @Override // com.baidu.tieba.i.i
    public String aVl() {
        return this.fst + "";
    }
}
