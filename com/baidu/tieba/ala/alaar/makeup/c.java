package com.baidu.tieba.ala.alaar.makeup;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tieba.ala.alaar.sticker.a.h;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements com.baidu.tieba.ala.alaar.makeup.b.b {
    private int fVA;
    private int fVB;
    private int fVC;
    com.baidu.tieba.ala.alaar.sticker.model.c fVD;
    private WeakReference<h.a> fVE;
    public int fVq;
    public int fVr;
    public a fVs;
    private BeautyType fVt;
    private String fVu;
    public boolean fVv;
    private String fVw;
    private String fVx;
    private String fVy;
    private int fVz;
    private String icon;
    public String id;
    private File mFolder;
    public String name;
    public int value;
    private final List<h.a> mOnFileLoadedCallbacks = new ArrayList();
    com.baidu.tieba.ala.alaar.sticker.download.a.a mAbilityCb = new com.baidu.tieba.ala.alaar.sticker.download.a.a() { // from class: com.baidu.tieba.ala.alaar.makeup.c.1
        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onStarted() {
            super.onStarted();
            c.this.d("DownloadCallback onStarted");
            if (com.baidu.tieba.ala.alaar.sticker.download.b.bKT().isRunning(c.this.bKm())) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= c.this.mOnFileLoadedCallbacks.size()) {
                        break;
                    }
                    h.a aVar = (h.a) c.this.mOnFileLoadedCallbacks.get(i2);
                    if (aVar != null) {
                        aVar.aD(c.this);
                    }
                    i = i2 + 1;
                }
            }
            h.a bKp = c.this.bKp();
            if (bKp != null) {
                bKp.aD(c.this);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onCompleted(String str) {
            super.onCompleted(str);
            c.this.d("DownloadCallback onCompleted:" + str);
            if (c.this.fVD == null || c.this.fVD.isLoaded()) {
                onCompleted();
            }
        }

        public void onCompleted() {
            c.this.d("DownloadCallback onCompleted,mFinished:" + c.this.fVD.isLoaded());
            synchronized (c.this) {
                c.this.mAbilityCb = null;
            }
            h.a bKp = c.this.bKp();
            if (bKp != null) {
                bKp.aE(c.this);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < c.this.mOnFileLoadedCallbacks.size()) {
                    h.a aVar = (h.a) c.this.mOnFileLoadedCallbacks.get(i2);
                    if (aVar != null) {
                        aVar.aE(c.this);
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
            c.this.d("DownloadCallback onFailed:" + (downloadException == null ? Constants.ACCEPT_TIME_SEPARATOR_SP : downloadException.getErrorMessage()));
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
                h.a bKp = c.this.bKp();
                if (bKp != null) {
                    bKp.a(c.this, i, 0, str);
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

    public void setName(String str) {
        this.name = str;
    }

    protected void ts(int i) {
        this.fVr = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = g(this.mFolder, str);
        if (str.startsWith("resIdName://")) {
            int aL = aL(TbadkCoreApplication.getInst().getApp(), FG(str));
            if (aL > 0) {
                ts(aL);
            }
        }
    }

    public void a(a aVar) {
        this.fVs = aVar;
    }

    public a bKf() {
        return this.fVs;
    }

    public int getValue() {
        return this.value;
    }

    public int bKg() {
        return this.fVA;
    }

    public int bKh() {
        return this.fVz;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public void tt(int i) {
        this.fVq = i;
    }

    public int bKi() {
        return this.fVq;
    }

    public float bKj() {
        return ((((this.value - this.fVz) / (this.fVA - this.fVz)) * (this.fVC - this.fVB)) + this.fVB) / 100.0f;
    }

    public void setHide(boolean z) {
        this.fVv = z;
    }

    public boolean bKk() {
        return this.fVv;
    }

    public BeautyType getType() {
        return this.fVt;
    }

    public String getTypeName() {
        return this.fVu;
    }

    public void setTypeName(String str) {
        this.fVu = str;
    }

    public void a(BeautyType beautyType) {
        this.fVt = beautyType;
    }

    public String bKl() {
        return this.fVw;
    }

    public void FE(String str) {
        this.fVw = g(this.mFolder, str);
    }

    public String bKm() {
        return this.fVx;
    }

    public void FF(String str) {
        this.fVx = g(this.mFolder, str);
    }

    public String bKn() {
        return this.fVy;
    }

    public static String g(File file, String str) {
        if (file != null && str != null && str.startsWith("relativePath://")) {
            return str.replace("relativePath://", file.getAbsolutePath() + File.separator);
        }
        return str;
    }

    public String FG(String str) {
        if (str.startsWith("resIdName://")) {
            return str.replace("resIdName://", "");
        }
        return str;
    }

    public void X(File file) {
        this.mFolder = file;
    }

    public File bKo() {
        return this.mFolder;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getName());
            jSONObject.put("makeup_id", getId());
            String str = null;
            if (this.fVt != null) {
                str = this.fVt.name();
            }
            jSONObject.put("type", str);
            jSONObject.put("value", getValue());
            jSONObject.put("live_default", bKi());
            jSONObject.put("hide", bKk() ? 1 : 0);
            jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, getIcon());
            jSONObject.put("path", bKl());
            jSONObject.put("file", bKm());
            a bKf = bKf();
            if (bKf != null) {
                jSONObject.put("state_icon", bKf.toJson());
            }
            jSONObject.put(SmsLoginView.f.j, this.fVy);
            jSONObject.put("live_min", this.fVz);
            jSONObject.put("live_max", this.fVA);
            jSONObject.put("actual_min", this.fVB);
            jSONObject.put("actual_max", this.fVC);
        } catch (JSONException e) {
            e.printStackTrace();
            if (h.isDebug()) {
                h.e("DuBeautyEntity", e.getMessage());
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean dt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        setName(jSONObject.optString("name"));
        setId(jSONObject.optString("makeup_id"));
        tt(jSONObject.optInt("live_default", 0));
        setValue(jSONObject.optInt("value", bKi()));
        setIcon(jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON));
        JSONObject optJSONObject = jSONObject.optJSONObject("state_icon");
        if (optJSONObject != null) {
            a aVar = new a();
            aVar.X(this.mFolder);
            if (aVar.dt(optJSONObject)) {
                a(aVar);
            }
        }
        this.fVu = jSONObject.optString("type", this.fVu);
        FE(jSONObject.optString("path"));
        FF(jSONObject.optString("file"));
        if (TextUtils.isEmpty(this.fVu)) {
            return false;
        }
        a(BeautyType.valueOf(this.fVu));
        setHide(jSONObject.optInt("hide", 0) == 1);
        this.fVy = jSONObject.optString(SmsLoginView.f.j);
        this.fVz = jSONObject.optInt("live_min", 0);
        this.fVA = jSONObject.optInt("live_max", 0);
        this.fVB = jSONObject.optInt("actual_min", 0);
        this.fVC = jSONObject.optInt("actual_max", 100);
        if (!TextUtils.isEmpty(bKm())) {
            this.fVD = com.baidu.tieba.ala.alaar.sticker.a.f.bLg().FS(bKn());
            if (this.fVD == null) {
                this.fVD = new com.baidu.tieba.ala.alaar.sticker.model.c(this);
                com.baidu.tieba.ala.alaar.sticker.a.f.bLg().a(bKn(), this.fVD);
            }
            if (this.fVD.getLocalFile() != null) {
                FE(this.fVD.getLocalFile().getAbsolutePath());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        h.d("DuBeautyEntity", str);
    }

    public void download(h.a aVar) {
        if (this.fVD == null) {
            d("download-return with model null");
            return;
        }
        if (aVar != null && !this.mOnFileLoadedCallbacks.contains(aVar)) {
            this.mOnFileLoadedCallbacks.add(aVar);
        }
        d("download-from: " + bKm() + "\nto: " + this.fVD.getLocalFile() + "\nis exists: " + this.fVD.getLocalFile().exists());
        this.fVD.b(this.mAbilityCb);
    }

    public boolean isLoaded() {
        return this.fVD == null || this.fVD.isLoaded();
    }

    public boolean isLoading() {
        return this.fVD != null && this.fVD.isLoading();
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

    public h.a bKp() {
        if (this.fVE != null) {
            return this.fVE.get();
        }
        return null;
    }

    /* loaded from: classes4.dex */
    public static class a implements com.baidu.tieba.ala.alaar.makeup.b.b {
        private String fVG;
        private String fVH;
        private File mFolder;

        public void X(File file) {
            this.mFolder = file;
        }

        public String bKq() {
            return this.fVG;
        }

        public void FH(String str) {
            this.fVG = c.g(this.mFolder, str);
        }

        public void FI(String str) {
            this.fVH = c.g(this.mFolder, str);
        }

        public JSONObject toJson() {
            if (TextUtils.isEmpty(this.fVG) && TextUtils.isEmpty(this.fVH)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.fVG)) {
                    jSONObject.put("normal", this.fVG);
                }
                if (!TextUtils.isEmpty(this.fVH)) {
                    jSONObject.put("disable", this.fVH);
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
        public boolean dt(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    String optString = jSONObject.optString("normal");
                    String optString2 = jSONObject.optString("disable");
                    FH(optString);
                    FI(optString2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return jSONObject != null && jSONObject.length() > 0;
        }
    }

    public static int aL(Context context, String str) {
        return context.getResources().getIdentifier(str, "drawable", context.getApplicationInfo().packageName);
    }
}
