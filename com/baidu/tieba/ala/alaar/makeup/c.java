package com.baidu.tieba.ala.alaar.makeup;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tieba.ala.alaar.sticker.a.h;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c implements com.baidu.tieba.ala.alaar.makeup.b.b {
    public int grC;
    protected String grD;
    public int grE;
    public a grF;
    private BeautyType grG;
    public boolean grH;
    private String grI;
    private String grJ;
    private String grK;
    private int grL;
    private int grM;
    private int grN;
    private int grO;
    com.baidu.tieba.ala.alaar.sticker.model.c grP;
    private WeakReference<h.a> grQ;
    private String icon;
    public String id;
    private File mFolder;
    private String mTypeName;
    protected String name;
    public int value;
    private final List<h.a> mOnFileLoadedCallbacks = new ArrayList();
    com.baidu.tieba.ala.alaar.sticker.download.a.a mAbilityCb = new com.baidu.tieba.ala.alaar.sticker.download.a.a() { // from class: com.baidu.tieba.ala.alaar.makeup.c.1
        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onStarted() {
            super.onStarted();
            c.this.d("DownloadCallback onStarted");
            if (com.baidu.tieba.ala.alaar.sticker.download.b.bPJ().isRunning(c.this.bPd())) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= c.this.mOnFileLoadedCallbacks.size()) {
                        break;
                    }
                    h.a aVar = (h.a) c.this.mOnFileLoadedCallbacks.get(i2);
                    if (aVar != null) {
                        aVar.J(c.this);
                    }
                    i = i2 + 1;
                }
            }
            h.a bPg = c.this.bPg();
            if (bPg != null) {
                bPg.J(c.this);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onCompleted(String str) {
            super.onCompleted(str);
            c.this.d("DownloadCallback onCompleted:" + str);
            if (c.this.grP == null || c.this.grP.isLoaded()) {
                onCompleted();
            }
        }

        public void onCompleted() {
            c.this.d("DownloadCallback onCompleted,mFinished:" + c.this.grP.isLoaded());
            synchronized (c.this) {
                c.this.mAbilityCb = null;
            }
            h.a bPg = c.this.bPg();
            if (bPg != null) {
                bPg.aF(c.this);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < c.this.mOnFileLoadedCallbacks.size()) {
                    h.a aVar = (h.a) c.this.mOnFileLoadedCallbacks.get(i2);
                    if (aVar != null) {
                        aVar.aF(c.this);
                    }
                    i = i2 + 1;
                } else {
                    c.this.mOnFileLoadedCallbacks.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            int i;
            String str = null;
            super.a(downloadException);
            c.this.d("DownloadCallback onFailed:" + (downloadException == null ? "," : downloadException.getErrorMessage()));
            if (c.this.isLoading()) {
                synchronized (c.this) {
                    c.this.mAbilityCb = null;
                }
                if (downloadException != null) {
                    i = downloadException.getErrorCode();
                    str = downloadException.getErrorMessage();
                } else {
                    i = 0;
                }
                h.a bPg = c.this.bPg();
                if (bPg != null) {
                    bPg.a(c.this, i, 0, str);
                }
                for (int i2 = 0; i2 < c.this.mOnFileLoadedCallbacks.size(); i2++) {
                    h.a aVar = (h.a) c.this.mOnFileLoadedCallbacks.get(i2);
                    if (aVar != null) {
                        aVar.a(c.this, i, 0, str);
                    }
                }
                c.this.mOnFileLoadedCallbacks.clear();
            }
        }
    };

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public String bOU() {
        return !TextUtils.isEmpty(this.grD) ? this.grD : this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void Fs(String str) {
        this.grD = str;
    }

    public String bOV() {
        return this.grD;
    }

    protected void tq(int i) {
        this.grE = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = g(this.mFolder, str);
        if (str.startsWith("resIdName://")) {
            int drawableId = getDrawableId(TbadkCoreApplication.getInst().getApp(), Fv(str));
            if (drawableId > 0) {
                tq(drawableId);
            }
        }
    }

    public void a(a aVar) {
        this.grF = aVar;
    }

    public a bOW() {
        return this.grF;
    }

    public int getValue() {
        return this.value;
    }

    public int bOX() {
        return this.grM;
    }

    public int bOY() {
        return this.grL;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public void tr(int i) {
        this.grC = i;
    }

    public int bOZ() {
        return this.grC;
    }

    public float bPa() {
        return ((((this.value - this.grL) / (this.grM - this.grL)) * (this.grO - this.grN)) + this.grN) / 100.0f;
    }

    public void setHide(boolean z) {
        this.grH = z;
    }

    public boolean bPb() {
        return this.grH;
    }

    public BeautyType getType() {
        return this.grG;
    }

    public String getTypeName() {
        return this.mTypeName;
    }

    public void setTypeName(String str) {
        this.mTypeName = str;
    }

    public void a(BeautyType beautyType) {
        this.grG = beautyType;
    }

    public String bPc() {
        return this.grI;
    }

    public void Ft(String str) {
        this.grI = g(this.mFolder, str);
    }

    public String bPd() {
        return this.grJ;
    }

    public void Fu(String str) {
        this.grJ = g(this.mFolder, str);
    }

    public String bPe() {
        return this.grK;
    }

    public static String g(File file, String str) {
        if (file != null && str != null && str.startsWith("relativePath://")) {
            return str.replace("relativePath://", file.getAbsolutePath() + File.separator);
        }
        return str;
    }

    public String Fv(String str) {
        if (str.startsWith("resIdName://")) {
            return str.replace("resIdName://", "");
        }
        return str;
    }

    public void V(File file) {
        this.mFolder = file;
    }

    public File bPf() {
        return this.mFolder;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getName());
            jSONObject.put("live_name", bOV());
            jSONObject.put("makeup_id", getId());
            String str = null;
            if (this.grG != null) {
                str = this.grG.name();
            }
            jSONObject.put("type", str);
            jSONObject.put("value", getValue());
            jSONObject.put("live_default", bOZ());
            jSONObject.put("hide", bPb() ? 1 : 0);
            jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, getIcon());
            jSONObject.put("path", bPc());
            jSONObject.put("file", bPd());
            a bOW = bOW();
            if (bOW != null) {
                jSONObject.put("state_icon", bOW.toJson());
            }
            jSONObject.put(SmsLoginView.f.j, this.grK);
            jSONObject.put("live_min", this.grL);
            jSONObject.put("live_max", this.grM);
            jSONObject.put("actual_min", this.grN);
            jSONObject.put("actual_max", this.grO);
        } catch (JSONException e) {
            e.printStackTrace();
            if (h.isDebug()) {
                h.e("DuBeautyEntity", e.getMessage());
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean dE(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        setName(jSONObject.optString("name"));
        Fs(jSONObject.optString("live_name", null));
        setId(jSONObject.optString("makeup_id"));
        tr(jSONObject.optInt("live_default", 0));
        setValue(jSONObject.optInt("value", bOZ()));
        setIcon(jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON));
        JSONObject optJSONObject = jSONObject.optJSONObject("state_icon");
        if (optJSONObject != null) {
            a aVar = new a();
            aVar.V(this.mFolder);
            if (aVar.dE(optJSONObject)) {
                a(aVar);
            }
        }
        this.mTypeName = jSONObject.optString("type", this.mTypeName);
        Ft(jSONObject.optString("path"));
        Fu(jSONObject.optString("file"));
        if (TextUtils.isEmpty(this.mTypeName)) {
            return false;
        }
        a(BeautyType.valueOf(this.mTypeName));
        setHide(jSONObject.optInt("hide", 0) == 1);
        this.grK = jSONObject.optString(SmsLoginView.f.j);
        this.grL = jSONObject.optInt("live_min", 0);
        this.grM = jSONObject.optInt("live_max", 0);
        this.grN = jSONObject.optInt("actual_min", 0);
        this.grO = jSONObject.optInt("actual_max", 100);
        if (!TextUtils.isEmpty(bPd())) {
            this.grP = com.baidu.tieba.ala.alaar.sticker.a.f.bPW().FH(bPe());
            if (this.grP == null) {
                this.grP = new com.baidu.tieba.ala.alaar.sticker.model.c(this);
                com.baidu.tieba.ala.alaar.sticker.a.f.bPW().a(bPe(), this.grP);
            }
            if (this.grP.getLocalFile() != null) {
                Ft(this.grP.getLocalFile().getAbsolutePath());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        h.d("DuBeautyEntity", str);
    }

    public void download(h.a aVar) {
        if (this.grP == null) {
            d("download-return with model null");
            return;
        }
        if (aVar != null && !this.mOnFileLoadedCallbacks.contains(aVar)) {
            this.mOnFileLoadedCallbacks.add(aVar);
        }
        d("download-from: " + bPd() + "\nto: " + this.grP.getLocalFile() + "\nis exists: " + this.grP.getLocalFile().exists());
        this.grP.b(this.mAbilityCb);
    }

    public boolean isLoaded() {
        return this.grP == null || this.grP.isLoaded();
    }

    public boolean isLoading() {
        return this.grP != null && this.grP.isLoading();
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.id == cVar.id || (getType() != null && getType().equals(cVar.getType()));
        }
        return false;
    }

    public h.a bPg() {
        if (this.grQ != null) {
            return this.grQ.get();
        }
        return null;
    }

    /* loaded from: classes11.dex */
    public static class a implements com.baidu.tieba.ala.alaar.makeup.b.b {
        private String grS;
        private String grT;
        private File mFolder;

        public void V(File file) {
            this.mFolder = file;
        }

        public String bPh() {
            return this.grS;
        }

        public void Fw(String str) {
            this.grS = c.g(this.mFolder, str);
        }

        public void Fx(String str) {
            this.grT = c.g(this.mFolder, str);
        }

        public JSONObject toJson() {
            if (TextUtils.isEmpty(this.grS) && TextUtils.isEmpty(this.grT)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.grS)) {
                    jSONObject.put("normal", this.grS);
                }
                if (!TextUtils.isEmpty(this.grT)) {
                    jSONObject.put("disable", this.grT);
                }
                if (jSONObject.length() <= 0) {
                    jSONObject = null;
                }
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // com.baidu.tieba.ala.alaar.makeup.b.b
        public boolean dE(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    String optString = jSONObject.optString("normal");
                    String optString2 = jSONObject.optString("disable");
                    Fw(optString);
                    Fx(optString2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return jSONObject != null && jSONObject.length() > 0;
        }
    }

    public static int getDrawableId(Context context, String str) {
        return context.getResources().getIdentifier(str, "drawable", context.getApplicationInfo().packageName);
    }
}
