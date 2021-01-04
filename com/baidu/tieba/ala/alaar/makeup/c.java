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
    public int gtA;
    protected String gtB;
    public int gtC;
    public a gtD;
    private BeautyType gtE;
    public boolean gtF;
    private String gtG;
    private String gtH;
    private String gtI;
    private int gtJ;
    private int gtK;
    private int gtL;
    private int gtM;
    com.baidu.tieba.ala.alaar.sticker.model.c gtN;
    private WeakReference<h.a> gtO;
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
            if (com.baidu.tieba.ala.alaar.sticker.download.b.bSW().isRunning(c.this.bSq())) {
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
            h.a bSt = c.this.bSt();
            if (bSt != null) {
                bSt.J(c.this);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onCompleted(String str) {
            super.onCompleted(str);
            c.this.d("DownloadCallback onCompleted:" + str);
            if (c.this.gtN == null || c.this.gtN.isLoaded()) {
                onCompleted();
            }
        }

        public void onCompleted() {
            c.this.d("DownloadCallback onCompleted,mFinished:" + c.this.gtN.isLoaded());
            synchronized (c.this) {
                c.this.mAbilityCb = null;
            }
            h.a bSt = c.this.bSt();
            if (bSt != null) {
                bSt.aF(c.this);
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
                h.a bSt = c.this.bSt();
                if (bSt != null) {
                    bSt.a(c.this, i, 0, str);
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

    public String bSh() {
        return !TextUtils.isEmpty(this.gtB) ? this.gtB : this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void Gg(String str) {
        this.gtB = str;
    }

    public String bSi() {
        return this.gtB;
    }

    protected void uQ(int i) {
        this.gtC = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = h(this.mFolder, str);
        if (str.startsWith("resIdName://")) {
            int drawableId = getDrawableId(TbadkCoreApplication.getInst().getApp(), Gj(str));
            if (drawableId > 0) {
                uQ(drawableId);
            }
        }
    }

    public void a(a aVar) {
        this.gtD = aVar;
    }

    public a bSj() {
        return this.gtD;
    }

    public int getValue() {
        return this.value;
    }

    public int bSk() {
        return this.gtK;
    }

    public int bSl() {
        return this.gtJ;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public void uR(int i) {
        this.gtA = i;
    }

    public int bSm() {
        return this.gtA;
    }

    public float bSn() {
        return ((((this.value - this.gtJ) / (this.gtK - this.gtJ)) * (this.gtM - this.gtL)) + this.gtL) / 100.0f;
    }

    public void setHide(boolean z) {
        this.gtF = z;
    }

    public boolean bSo() {
        return this.gtF;
    }

    public BeautyType getType() {
        return this.gtE;
    }

    public String getTypeName() {
        return this.mTypeName;
    }

    public void setTypeName(String str) {
        this.mTypeName = str;
    }

    public void a(BeautyType beautyType) {
        this.gtE = beautyType;
    }

    public String bSp() {
        return this.gtG;
    }

    public void Gh(String str) {
        this.gtG = h(this.mFolder, str);
    }

    public String bSq() {
        return this.gtH;
    }

    public void Gi(String str) {
        this.gtH = h(this.mFolder, str);
    }

    public String bSr() {
        return this.gtI;
    }

    public static String h(File file, String str) {
        if (file != null && str != null && str.startsWith("relativePath://")) {
            return str.replace("relativePath://", file.getAbsolutePath() + File.separator);
        }
        return str;
    }

    public String Gj(String str) {
        if (str.startsWith("resIdName://")) {
            return str.replace("resIdName://", "");
        }
        return str;
    }

    public void Z(File file) {
        this.mFolder = file;
    }

    public File bSs() {
        return this.mFolder;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getName());
            jSONObject.put("live_name", bSi());
            jSONObject.put("makeup_id", getId());
            String str = null;
            if (this.gtE != null) {
                str = this.gtE.name();
            }
            jSONObject.put("type", str);
            jSONObject.put("value", getValue());
            jSONObject.put("live_default", bSm());
            jSONObject.put("hide", bSo() ? 1 : 0);
            jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, getIcon());
            jSONObject.put("path", bSp());
            jSONObject.put("file", bSq());
            a bSj = bSj();
            if (bSj != null) {
                jSONObject.put("state_icon", bSj.toJson());
            }
            jSONObject.put(SmsLoginView.f.j, this.gtI);
            jSONObject.put("live_min", this.gtJ);
            jSONObject.put("live_max", this.gtK);
            jSONObject.put("actual_min", this.gtL);
            jSONObject.put("actual_max", this.gtM);
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
        Gg(jSONObject.optString("live_name", null));
        setId(jSONObject.optString("makeup_id"));
        uR(jSONObject.optInt("live_default", 0));
        setValue(jSONObject.optInt("value", bSm()));
        setIcon(jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON));
        JSONObject optJSONObject = jSONObject.optJSONObject("state_icon");
        if (optJSONObject != null) {
            a aVar = new a();
            aVar.Z(this.mFolder);
            if (aVar.dD(optJSONObject)) {
                a(aVar);
            }
        }
        this.mTypeName = jSONObject.optString("type", this.mTypeName);
        Gh(jSONObject.optString("path"));
        Gi(jSONObject.optString("file"));
        if (TextUtils.isEmpty(this.mTypeName)) {
            return false;
        }
        a(BeautyType.valueOf(this.mTypeName));
        setHide(jSONObject.optInt("hide", 0) == 1);
        this.gtI = jSONObject.optString(SmsLoginView.f.j);
        this.gtJ = jSONObject.optInt("live_min", 0);
        this.gtK = jSONObject.optInt("live_max", 0);
        this.gtL = jSONObject.optInt("actual_min", 0);
        this.gtM = jSONObject.optInt("actual_max", 100);
        if (!TextUtils.isEmpty(bSq())) {
            this.gtN = com.baidu.tieba.ala.alaar.sticker.a.f.bTj().Gv(bSr());
            if (this.gtN == null) {
                this.gtN = new com.baidu.tieba.ala.alaar.sticker.model.c(this);
                com.baidu.tieba.ala.alaar.sticker.a.f.bTj().a(bSr(), this.gtN);
            }
            if (this.gtN.getLocalFile() != null) {
                Gh(this.gtN.getLocalFile().getAbsolutePath());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        h.d("DuBeautyEntity", str);
    }

    public void download(h.a aVar) {
        if (this.gtN == null) {
            d("download-return with model null");
            return;
        }
        if (aVar != null && !this.mOnFileLoadedCallbacks.contains(aVar)) {
            this.mOnFileLoadedCallbacks.add(aVar);
        }
        d("download-from: " + bSq() + "\nto: " + this.gtN.getLocalFile() + "\nis exists: " + this.gtN.getLocalFile().exists());
        this.gtN.b(this.mAbilityCb);
    }

    public boolean isLoaded() {
        return this.gtN == null || this.gtN.isLoaded();
    }

    public boolean isLoading() {
        return this.gtN != null && this.gtN.isLoading();
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

    public h.a bSt() {
        if (this.gtO != null) {
            return this.gtO.get();
        }
        return null;
    }

    /* loaded from: classes11.dex */
    public static class a implements com.baidu.tieba.ala.alaar.makeup.b.b {
        private String gtQ;
        private String gtR;
        private File mFolder;

        public void Z(File file) {
            this.mFolder = file;
        }

        public String bSu() {
            return this.gtQ;
        }

        public void Gk(String str) {
            this.gtQ = c.h(this.mFolder, str);
        }

        public void Gl(String str) {
            this.gtR = c.h(this.mFolder, str);
        }

        public JSONObject toJson() {
            if (TextUtils.isEmpty(this.gtQ) && TextUtils.isEmpty(this.gtR)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.gtQ)) {
                    jSONObject.put("normal", this.gtQ);
                }
                if (!TextUtils.isEmpty(this.gtR)) {
                    jSONObject.put("disable", this.gtR);
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
                    Gk(optString);
                    Gl(optString2);
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
