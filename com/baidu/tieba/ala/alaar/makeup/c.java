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
    public int gbh;
    public int gbi;
    public a gbj;
    private BeautyType gbk;
    private String gbl;
    public boolean gbm;
    private String gbn;
    private String gbo;
    private String gbp;
    private int gbq;
    private int gbr;
    private int gbs;
    private int gbt;
    com.baidu.tieba.ala.alaar.sticker.model.c gbu;
    private WeakReference<h.a> gbv;
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
            if (com.baidu.tieba.ala.alaar.sticker.download.b.bNs().isRunning(c.this.bML())) {
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
            h.a bMO = c.this.bMO();
            if (bMO != null) {
                bMO.aD(c.this);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onCompleted(String str) {
            super.onCompleted(str);
            c.this.d("DownloadCallback onCompleted:" + str);
            if (c.this.gbu == null || c.this.gbu.isLoaded()) {
                onCompleted();
            }
        }

        public void onCompleted() {
            c.this.d("DownloadCallback onCompleted,mFinished:" + c.this.gbu.isLoaded());
            synchronized (c.this) {
                c.this.mAbilityCb = null;
            }
            h.a bMO = c.this.bMO();
            if (bMO != null) {
                bMO.aE(c.this);
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
                h.a bMO = c.this.bMO();
                if (bMO != null) {
                    bMO.a(c.this, i, 0, str);
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

    protected void tC(int i) {
        this.gbi = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = g(this.mFolder, str);
        if (str.startsWith("resIdName://")) {
            int aL = aL(TbadkCoreApplication.getInst().getApp(), FU(str));
            if (aL > 0) {
                tC(aL);
            }
        }
    }

    public void a(a aVar) {
        this.gbj = aVar;
    }

    public a bME() {
        return this.gbj;
    }

    public int getValue() {
        return this.value;
    }

    public int bMF() {
        return this.gbr;
    }

    public int bMG() {
        return this.gbq;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public void tD(int i) {
        this.gbh = i;
    }

    public int bMH() {
        return this.gbh;
    }

    public float bMI() {
        return ((((this.value - this.gbq) / (this.gbr - this.gbq)) * (this.gbt - this.gbs)) + this.gbs) / 100.0f;
    }

    public void setHide(boolean z) {
        this.gbm = z;
    }

    public boolean bMJ() {
        return this.gbm;
    }

    public BeautyType getType() {
        return this.gbk;
    }

    public String getTypeName() {
        return this.gbl;
    }

    public void setTypeName(String str) {
        this.gbl = str;
    }

    public void a(BeautyType beautyType) {
        this.gbk = beautyType;
    }

    public String bMK() {
        return this.gbn;
    }

    public void FS(String str) {
        this.gbn = g(this.mFolder, str);
    }

    public String bML() {
        return this.gbo;
    }

    public void FT(String str) {
        this.gbo = g(this.mFolder, str);
    }

    public String bMM() {
        return this.gbp;
    }

    public static String g(File file, String str) {
        if (file != null && str != null && str.startsWith("relativePath://")) {
            return str.replace("relativePath://", file.getAbsolutePath() + File.separator);
        }
        return str;
    }

    public String FU(String str) {
        if (str.startsWith("resIdName://")) {
            return str.replace("resIdName://", "");
        }
        return str;
    }

    public void X(File file) {
        this.mFolder = file;
    }

    public File bMN() {
        return this.mFolder;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getName());
            jSONObject.put("makeup_id", getId());
            String str = null;
            if (this.gbk != null) {
                str = this.gbk.name();
            }
            jSONObject.put("type", str);
            jSONObject.put("value", getValue());
            jSONObject.put("live_default", bMH());
            jSONObject.put("hide", bMJ() ? 1 : 0);
            jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, getIcon());
            jSONObject.put("path", bMK());
            jSONObject.put("file", bML());
            a bME = bME();
            if (bME != null) {
                jSONObject.put("state_icon", bME.toJson());
            }
            jSONObject.put(SmsLoginView.f.j, this.gbp);
            jSONObject.put("live_min", this.gbq);
            jSONObject.put("live_max", this.gbr);
            jSONObject.put("actual_min", this.gbs);
            jSONObject.put("actual_max", this.gbt);
        } catch (JSONException e) {
            e.printStackTrace();
            if (h.isDebug()) {
                h.e("DuBeautyEntity", e.getMessage());
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean dz(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        setName(jSONObject.optString("name"));
        setId(jSONObject.optString("makeup_id"));
        tD(jSONObject.optInt("live_default", 0));
        setValue(jSONObject.optInt("value", bMH()));
        setIcon(jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON));
        JSONObject optJSONObject = jSONObject.optJSONObject("state_icon");
        if (optJSONObject != null) {
            a aVar = new a();
            aVar.X(this.mFolder);
            if (aVar.dz(optJSONObject)) {
                a(aVar);
            }
        }
        this.gbl = jSONObject.optString("type", this.gbl);
        FS(jSONObject.optString("path"));
        FT(jSONObject.optString("file"));
        if (TextUtils.isEmpty(this.gbl)) {
            return false;
        }
        a(BeautyType.valueOf(this.gbl));
        setHide(jSONObject.optInt("hide", 0) == 1);
        this.gbp = jSONObject.optString(SmsLoginView.f.j);
        this.gbq = jSONObject.optInt("live_min", 0);
        this.gbr = jSONObject.optInt("live_max", 0);
        this.gbs = jSONObject.optInt("actual_min", 0);
        this.gbt = jSONObject.optInt("actual_max", 100);
        if (!TextUtils.isEmpty(bML())) {
            this.gbu = com.baidu.tieba.ala.alaar.sticker.a.f.bNF().Gg(bMM());
            if (this.gbu == null) {
                this.gbu = new com.baidu.tieba.ala.alaar.sticker.model.c(this);
                com.baidu.tieba.ala.alaar.sticker.a.f.bNF().a(bMM(), this.gbu);
            }
            if (this.gbu.getLocalFile() != null) {
                FS(this.gbu.getLocalFile().getAbsolutePath());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        h.d("DuBeautyEntity", str);
    }

    public void download(h.a aVar) {
        if (this.gbu == null) {
            d("download-return with model null");
            return;
        }
        if (aVar != null && !this.mOnFileLoadedCallbacks.contains(aVar)) {
            this.mOnFileLoadedCallbacks.add(aVar);
        }
        d("download-from: " + bML() + "\nto: " + this.gbu.getLocalFile() + "\nis exists: " + this.gbu.getLocalFile().exists());
        this.gbu.b(this.mAbilityCb);
    }

    public boolean isLoaded() {
        return this.gbu == null || this.gbu.isLoaded();
    }

    public boolean isLoading() {
        return this.gbu != null && this.gbu.isLoading();
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

    public h.a bMO() {
        if (this.gbv != null) {
            return this.gbv.get();
        }
        return null;
    }

    /* loaded from: classes4.dex */
    public static class a implements com.baidu.tieba.ala.alaar.makeup.b.b {
        private String gbx;
        private String gby;
        private File mFolder;

        public void X(File file) {
            this.mFolder = file;
        }

        public String bMP() {
            return this.gbx;
        }

        public void FV(String str) {
            this.gbx = c.g(this.mFolder, str);
        }

        public void FW(String str) {
            this.gby = c.g(this.mFolder, str);
        }

        public JSONObject toJson() {
            if (TextUtils.isEmpty(this.gbx) && TextUtils.isEmpty(this.gby)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.gbx)) {
                    jSONObject.put("normal", this.gbx);
                }
                if (!TextUtils.isEmpty(this.gby)) {
                    jSONObject.put("disable", this.gby);
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
        public boolean dz(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    String optString = jSONObject.optString("normal");
                    String optString2 = jSONObject.optString("disable");
                    FV(optString);
                    FW(optString2);
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
