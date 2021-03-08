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
    protected String gtA;
    public int gtB;
    public a gtC;
    private BeautyType gtD;
    public boolean gtE;
    private String gtF;
    private String gtG;
    private String gtH;
    private int gtI;
    private int gtJ;
    private int gtK;
    private int gtL;
    com.baidu.tieba.ala.alaar.sticker.model.c gtM;
    private WeakReference<h.a> gtN;
    public int gtz;
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
            if (com.baidu.tieba.ala.alaar.sticker.download.b.bPW().isRunning(c.this.bPq())) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= c.this.mOnFileLoadedCallbacks.size()) {
                        break;
                    }
                    h.a aVar = (h.a) c.this.mOnFileLoadedCallbacks.get(i2);
                    if (aVar != null) {
                        aVar.L(c.this);
                    }
                    i = i2 + 1;
                }
            }
            h.a bPt = c.this.bPt();
            if (bPt != null) {
                bPt.L(c.this);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onCompleted(String str) {
            super.onCompleted(str);
            c.this.d("DownloadCallback onCompleted:" + str);
            if (c.this.gtM == null || c.this.gtM.isLoaded()) {
                onCompleted();
            }
        }

        public void onCompleted() {
            c.this.d("DownloadCallback onCompleted,mFinished:" + c.this.gtM.isLoaded());
            synchronized (c.this) {
                c.this.mAbilityCb = null;
            }
            h.a bPt = c.this.bPt();
            if (bPt != null) {
                bPt.aH(c.this);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < c.this.mOnFileLoadedCallbacks.size()) {
                    h.a aVar = (h.a) c.this.mOnFileLoadedCallbacks.get(i2);
                    if (aVar != null) {
                        aVar.aH(c.this);
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
                h.a bPt = c.this.bPt();
                if (bPt != null) {
                    bPt.a(c.this, i, 0, str);
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

    public String bPh() {
        return !TextUtils.isEmpty(this.gtA) ? this.gtA : this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void FC(String str) {
        this.gtA = str;
    }

    public String bPi() {
        return this.gtA;
    }

    protected void ts(int i) {
        this.gtB = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = g(this.mFolder, str);
        if (str.startsWith("resIdName://")) {
            int drawableId = getDrawableId(TbadkCoreApplication.getInst().getApp(), FF(str));
            if (drawableId > 0) {
                ts(drawableId);
            }
        }
    }

    public void a(a aVar) {
        this.gtC = aVar;
    }

    public a bPj() {
        return this.gtC;
    }

    public int getValue() {
        return this.value;
    }

    public int bPk() {
        return this.gtJ;
    }

    public int bPl() {
        return this.gtI;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public void tt(int i) {
        this.gtz = i;
    }

    public int bPm() {
        return this.gtz;
    }

    public float bPn() {
        return ((((this.value - this.gtI) / (this.gtJ - this.gtI)) * (this.gtL - this.gtK)) + this.gtK) / 100.0f;
    }

    public void setHide(boolean z) {
        this.gtE = z;
    }

    public boolean bPo() {
        return this.gtE;
    }

    public BeautyType getType() {
        return this.gtD;
    }

    public String getTypeName() {
        return this.mTypeName;
    }

    public void setTypeName(String str) {
        this.mTypeName = str;
    }

    public void a(BeautyType beautyType) {
        this.gtD = beautyType;
    }

    public String bPp() {
        return this.gtF;
    }

    public void FD(String str) {
        this.gtF = g(this.mFolder, str);
    }

    public String bPq() {
        return this.gtG;
    }

    public void FE(String str) {
        this.gtG = g(this.mFolder, str);
    }

    public String bPr() {
        return this.gtH;
    }

    public static String g(File file, String str) {
        if (file != null && str != null && str.startsWith("relativePath://")) {
            return str.replace("relativePath://", file.getAbsolutePath() + File.separator);
        }
        return str;
    }

    public String FF(String str) {
        if (str.startsWith("resIdName://")) {
            return str.replace("resIdName://", "");
        }
        return str;
    }

    public void V(File file) {
        this.mFolder = file;
    }

    public File bPs() {
        return this.mFolder;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getName());
            jSONObject.put("live_name", bPi());
            jSONObject.put("makeup_id", getId());
            String str = null;
            if (this.gtD != null) {
                str = this.gtD.name();
            }
            jSONObject.put("type", str);
            jSONObject.put("value", getValue());
            jSONObject.put("live_default", bPm());
            jSONObject.put("hide", bPo() ? 1 : 0);
            jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, getIcon());
            jSONObject.put("path", bPp());
            jSONObject.put("file", bPq());
            a bPj = bPj();
            if (bPj != null) {
                jSONObject.put("state_icon", bPj.toJson());
            }
            jSONObject.put(SmsLoginView.f.j, this.gtH);
            jSONObject.put("live_min", this.gtI);
            jSONObject.put("live_max", this.gtJ);
            jSONObject.put("actual_min", this.gtK);
            jSONObject.put("actual_max", this.gtL);
        } catch (JSONException e) {
            e.printStackTrace();
            if (h.isDebug()) {
                h.e("DuBeautyEntity", e.getMessage());
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean dG(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        setName(jSONObject.optString("name"));
        FC(jSONObject.optString("live_name", null));
        setId(jSONObject.optString("makeup_id"));
        tt(jSONObject.optInt("live_default", 0));
        setValue(jSONObject.optInt("value", bPm()));
        setIcon(jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON));
        JSONObject optJSONObject = jSONObject.optJSONObject("state_icon");
        if (optJSONObject != null) {
            a aVar = new a();
            aVar.V(this.mFolder);
            if (aVar.dG(optJSONObject)) {
                a(aVar);
            }
        }
        this.mTypeName = jSONObject.optString("type", this.mTypeName);
        FD(jSONObject.optString("path"));
        FE(jSONObject.optString("file"));
        if (TextUtils.isEmpty(this.mTypeName)) {
            return false;
        }
        a(BeautyType.valueOf(this.mTypeName));
        setHide(jSONObject.optInt("hide", 0) == 1);
        this.gtH = jSONObject.optString(SmsLoginView.f.j);
        this.gtI = jSONObject.optInt("live_min", 0);
        this.gtJ = jSONObject.optInt("live_max", 0);
        this.gtK = jSONObject.optInt("actual_min", 0);
        this.gtL = jSONObject.optInt("actual_max", 100);
        if (!TextUtils.isEmpty(bPq())) {
            this.gtM = com.baidu.tieba.ala.alaar.sticker.a.f.bQj().FR(bPr());
            if (this.gtM == null) {
                this.gtM = new com.baidu.tieba.ala.alaar.sticker.model.c(this);
                com.baidu.tieba.ala.alaar.sticker.a.f.bQj().a(bPr(), this.gtM);
            }
            if (this.gtM.getLocalFile() != null) {
                FD(this.gtM.getLocalFile().getAbsolutePath());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        h.d("DuBeautyEntity", str);
    }

    public void download(h.a aVar) {
        if (this.gtM == null) {
            d("download-return with model null");
            return;
        }
        if (aVar != null && !this.mOnFileLoadedCallbacks.contains(aVar)) {
            this.mOnFileLoadedCallbacks.add(aVar);
        }
        d("download-from: " + bPq() + "\nto: " + this.gtM.getLocalFile() + "\nis exists: " + this.gtM.getLocalFile().exists());
        this.gtM.b(this.mAbilityCb);
    }

    public boolean isLoaded() {
        return this.gtM == null || this.gtM.isLoaded();
    }

    public boolean isLoading() {
        return this.gtM != null && this.gtM.isLoading();
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

    public h.a bPt() {
        if (this.gtN != null) {
            return this.gtN.get();
        }
        return null;
    }

    /* loaded from: classes10.dex */
    public static class a implements com.baidu.tieba.ala.alaar.makeup.b.b {
        private String gtP;
        private String gtQ;
        private File mFolder;

        public void V(File file) {
            this.mFolder = file;
        }

        public String bPu() {
            return this.gtP;
        }

        public void FG(String str) {
            this.gtP = c.g(this.mFolder, str);
        }

        public void FH(String str) {
            this.gtQ = c.g(this.mFolder, str);
        }

        public JSONObject toJson() {
            if (TextUtils.isEmpty(this.gtP) && TextUtils.isEmpty(this.gtQ)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.gtP)) {
                    jSONObject.put("normal", this.gtP);
                }
                if (!TextUtils.isEmpty(this.gtQ)) {
                    jSONObject.put("disable", this.gtQ);
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
        public boolean dG(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    String optString = jSONObject.optString("normal");
                    String optString2 = jSONObject.optString("disable");
                    FG(optString);
                    FH(optString2);
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
