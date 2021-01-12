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
/* loaded from: classes10.dex */
public class c implements com.baidu.tieba.ala.alaar.makeup.b.b {
    public int goT;
    protected String goU;
    public int goV;
    public a goW;
    private BeautyType goX;
    public boolean goY;
    private String goZ;
    private String gpa;
    private String gpb;
    private int gpc;
    private int gpd;
    private int gpe;
    private int gpf;
    com.baidu.tieba.ala.alaar.sticker.model.c gpg;
    private WeakReference<h.a> gph;
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
            if (com.baidu.tieba.ala.alaar.sticker.download.b.bPf().isRunning(c.this.bOz())) {
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
            h.a bOC = c.this.bOC();
            if (bOC != null) {
                bOC.J(c.this);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onCompleted(String str) {
            super.onCompleted(str);
            c.this.d("DownloadCallback onCompleted:" + str);
            if (c.this.gpg == null || c.this.gpg.isLoaded()) {
                onCompleted();
            }
        }

        public void onCompleted() {
            c.this.d("DownloadCallback onCompleted,mFinished:" + c.this.gpg.isLoaded());
            synchronized (c.this) {
                c.this.mAbilityCb = null;
            }
            h.a bOC = c.this.bOC();
            if (bOC != null) {
                bOC.aF(c.this);
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
                h.a bOC = c.this.bOC();
                if (bOC != null) {
                    bOC.a(c.this, i, 0, str);
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

    public String bOq() {
        return !TextUtils.isEmpty(this.goU) ? this.goU : this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void EU(String str) {
        this.goU = str;
    }

    public String bOr() {
        return this.goU;
    }

    protected void tk(int i) {
        this.goV = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = h(this.mFolder, str);
        if (str.startsWith("resIdName://")) {
            int drawableId = getDrawableId(TbadkCoreApplication.getInst().getApp(), EX(str));
            if (drawableId > 0) {
                tk(drawableId);
            }
        }
    }

    public void a(a aVar) {
        this.goW = aVar;
    }

    public a bOs() {
        return this.goW;
    }

    public int getValue() {
        return this.value;
    }

    public int bOt() {
        return this.gpd;
    }

    public int bOu() {
        return this.gpc;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public void tl(int i) {
        this.goT = i;
    }

    public int bOv() {
        return this.goT;
    }

    public float bOw() {
        return ((((this.value - this.gpc) / (this.gpd - this.gpc)) * (this.gpf - this.gpe)) + this.gpe) / 100.0f;
    }

    public void setHide(boolean z) {
        this.goY = z;
    }

    public boolean bOx() {
        return this.goY;
    }

    public BeautyType getType() {
        return this.goX;
    }

    public String getTypeName() {
        return this.mTypeName;
    }

    public void setTypeName(String str) {
        this.mTypeName = str;
    }

    public void a(BeautyType beautyType) {
        this.goX = beautyType;
    }

    public String bOy() {
        return this.goZ;
    }

    public void EV(String str) {
        this.goZ = h(this.mFolder, str);
    }

    public String bOz() {
        return this.gpa;
    }

    public void EW(String str) {
        this.gpa = h(this.mFolder, str);
    }

    public String bOA() {
        return this.gpb;
    }

    public static String h(File file, String str) {
        if (file != null && str != null && str.startsWith("relativePath://")) {
            return str.replace("relativePath://", file.getAbsolutePath() + File.separator);
        }
        return str;
    }

    public String EX(String str) {
        if (str.startsWith("resIdName://")) {
            return str.replace("resIdName://", "");
        }
        return str;
    }

    public void Y(File file) {
        this.mFolder = file;
    }

    public File bOB() {
        return this.mFolder;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getName());
            jSONObject.put("live_name", bOr());
            jSONObject.put("makeup_id", getId());
            String str = null;
            if (this.goX != null) {
                str = this.goX.name();
            }
            jSONObject.put("type", str);
            jSONObject.put("value", getValue());
            jSONObject.put("live_default", bOv());
            jSONObject.put("hide", bOx() ? 1 : 0);
            jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, getIcon());
            jSONObject.put("path", bOy());
            jSONObject.put("file", bOz());
            a bOs = bOs();
            if (bOs != null) {
                jSONObject.put("state_icon", bOs.toJson());
            }
            jSONObject.put(SmsLoginView.f.j, this.gpb);
            jSONObject.put("live_min", this.gpc);
            jSONObject.put("live_max", this.gpd);
            jSONObject.put("actual_min", this.gpe);
            jSONObject.put("actual_max", this.gpf);
        } catch (JSONException e) {
            e.printStackTrace();
            if (h.isDebug()) {
                h.e("DuBeautyEntity", e.getMessage());
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean dD(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        setName(jSONObject.optString("name"));
        EU(jSONObject.optString("live_name", null));
        setId(jSONObject.optString("makeup_id"));
        tl(jSONObject.optInt("live_default", 0));
        setValue(jSONObject.optInt("value", bOv()));
        setIcon(jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON));
        JSONObject optJSONObject = jSONObject.optJSONObject("state_icon");
        if (optJSONObject != null) {
            a aVar = new a();
            aVar.Y(this.mFolder);
            if (aVar.dD(optJSONObject)) {
                a(aVar);
            }
        }
        this.mTypeName = jSONObject.optString("type", this.mTypeName);
        EV(jSONObject.optString("path"));
        EW(jSONObject.optString("file"));
        if (TextUtils.isEmpty(this.mTypeName)) {
            return false;
        }
        a(BeautyType.valueOf(this.mTypeName));
        setHide(jSONObject.optInt("hide", 0) == 1);
        this.gpb = jSONObject.optString(SmsLoginView.f.j);
        this.gpc = jSONObject.optInt("live_min", 0);
        this.gpd = jSONObject.optInt("live_max", 0);
        this.gpe = jSONObject.optInt("actual_min", 0);
        this.gpf = jSONObject.optInt("actual_max", 100);
        if (!TextUtils.isEmpty(bOz())) {
            this.gpg = com.baidu.tieba.ala.alaar.sticker.a.f.bPs().Fj(bOA());
            if (this.gpg == null) {
                this.gpg = new com.baidu.tieba.ala.alaar.sticker.model.c(this);
                com.baidu.tieba.ala.alaar.sticker.a.f.bPs().a(bOA(), this.gpg);
            }
            if (this.gpg.getLocalFile() != null) {
                EV(this.gpg.getLocalFile().getAbsolutePath());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        h.d("DuBeautyEntity", str);
    }

    public void download(h.a aVar) {
        if (this.gpg == null) {
            d("download-return with model null");
            return;
        }
        if (aVar != null && !this.mOnFileLoadedCallbacks.contains(aVar)) {
            this.mOnFileLoadedCallbacks.add(aVar);
        }
        d("download-from: " + bOz() + "\nto: " + this.gpg.getLocalFile() + "\nis exists: " + this.gpg.getLocalFile().exists());
        this.gpg.b(this.mAbilityCb);
    }

    public boolean isLoaded() {
        return this.gpg == null || this.gpg.isLoaded();
    }

    public boolean isLoading() {
        return this.gpg != null && this.gpg.isLoading();
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

    public h.a bOC() {
        if (this.gph != null) {
            return this.gph.get();
        }
        return null;
    }

    /* loaded from: classes10.dex */
    public static class a implements com.baidu.tieba.ala.alaar.makeup.b.b {
        private String gpj;
        private String gpk;
        private File mFolder;

        public void Y(File file) {
            this.mFolder = file;
        }

        public String bOD() {
            return this.gpj;
        }

        public void EY(String str) {
            this.gpj = c.h(this.mFolder, str);
        }

        public void EZ(String str) {
            this.gpk = c.h(this.mFolder, str);
        }

        public JSONObject toJson() {
            if (TextUtils.isEmpty(this.gpj) && TextUtils.isEmpty(this.gpk)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.gpj)) {
                    jSONObject.put("normal", this.gpj);
                }
                if (!TextUtils.isEmpty(this.gpk)) {
                    jSONObject.put("disable", this.gpk);
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
        public boolean dD(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    String optString = jSONObject.optString("normal");
                    String optString2 = jSONObject.optString("disable");
                    EY(optString);
                    EZ(optString2);
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
