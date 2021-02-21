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
    public int grQ;
    protected String grR;
    public int grS;
    public a grT;
    private BeautyType grU;
    public boolean grV;
    private String grW;
    private String grX;
    private String grY;
    private int grZ;
    private int gsa;
    private int gsb;
    private int gsc;
    com.baidu.tieba.ala.alaar.sticker.model.c gsd;
    private WeakReference<h.a> gse;
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
            if (com.baidu.tieba.ala.alaar.sticker.download.b.bPQ().isRunning(c.this.bPk())) {
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
            h.a bPn = c.this.bPn();
            if (bPn != null) {
                bPn.J(c.this);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onCompleted(String str) {
            super.onCompleted(str);
            c.this.d("DownloadCallback onCompleted:" + str);
            if (c.this.gsd == null || c.this.gsd.isLoaded()) {
                onCompleted();
            }
        }

        public void onCompleted() {
            c.this.d("DownloadCallback onCompleted,mFinished:" + c.this.gsd.isLoaded());
            synchronized (c.this) {
                c.this.mAbilityCb = null;
            }
            h.a bPn = c.this.bPn();
            if (bPn != null) {
                bPn.aF(c.this);
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
                h.a bPn = c.this.bPn();
                if (bPn != null) {
                    bPn.a(c.this, i, 0, str);
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

    public String bPb() {
        return !TextUtils.isEmpty(this.grR) ? this.grR : this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void Ft(String str) {
        this.grR = str;
    }

    public String bPc() {
        return this.grR;
    }

    protected void tq(int i) {
        this.grS = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = g(this.mFolder, str);
        if (str.startsWith("resIdName://")) {
            int drawableId = getDrawableId(TbadkCoreApplication.getInst().getApp(), Fw(str));
            if (drawableId > 0) {
                tq(drawableId);
            }
        }
    }

    public void a(a aVar) {
        this.grT = aVar;
    }

    public a bPd() {
        return this.grT;
    }

    public int getValue() {
        return this.value;
    }

    public int bPe() {
        return this.gsa;
    }

    public int bPf() {
        return this.grZ;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public void tr(int i) {
        this.grQ = i;
    }

    public int bPg() {
        return this.grQ;
    }

    public float bPh() {
        return ((((this.value - this.grZ) / (this.gsa - this.grZ)) * (this.gsc - this.gsb)) + this.gsb) / 100.0f;
    }

    public void setHide(boolean z) {
        this.grV = z;
    }

    public boolean bPi() {
        return this.grV;
    }

    public BeautyType getType() {
        return this.grU;
    }

    public String getTypeName() {
        return this.mTypeName;
    }

    public void setTypeName(String str) {
        this.mTypeName = str;
    }

    public void a(BeautyType beautyType) {
        this.grU = beautyType;
    }

    public String bPj() {
        return this.grW;
    }

    public void Fu(String str) {
        this.grW = g(this.mFolder, str);
    }

    public String bPk() {
        return this.grX;
    }

    public void Fv(String str) {
        this.grX = g(this.mFolder, str);
    }

    public String bPl() {
        return this.grY;
    }

    public static String g(File file, String str) {
        if (file != null && str != null && str.startsWith("relativePath://")) {
            return str.replace("relativePath://", file.getAbsolutePath() + File.separator);
        }
        return str;
    }

    public String Fw(String str) {
        if (str.startsWith("resIdName://")) {
            return str.replace("resIdName://", "");
        }
        return str;
    }

    public void V(File file) {
        this.mFolder = file;
    }

    public File bPm() {
        return this.mFolder;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getName());
            jSONObject.put("live_name", bPc());
            jSONObject.put("makeup_id", getId());
            String str = null;
            if (this.grU != null) {
                str = this.grU.name();
            }
            jSONObject.put("type", str);
            jSONObject.put("value", getValue());
            jSONObject.put("live_default", bPg());
            jSONObject.put("hide", bPi() ? 1 : 0);
            jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, getIcon());
            jSONObject.put("path", bPj());
            jSONObject.put("file", bPk());
            a bPd = bPd();
            if (bPd != null) {
                jSONObject.put("state_icon", bPd.toJson());
            }
            jSONObject.put(SmsLoginView.f.j, this.grY);
            jSONObject.put("live_min", this.grZ);
            jSONObject.put("live_max", this.gsa);
            jSONObject.put("actual_min", this.gsb);
            jSONObject.put("actual_max", this.gsc);
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
        Ft(jSONObject.optString("live_name", null));
        setId(jSONObject.optString("makeup_id"));
        tr(jSONObject.optInt("live_default", 0));
        setValue(jSONObject.optInt("value", bPg()));
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
        Fu(jSONObject.optString("path"));
        Fv(jSONObject.optString("file"));
        if (TextUtils.isEmpty(this.mTypeName)) {
            return false;
        }
        a(BeautyType.valueOf(this.mTypeName));
        setHide(jSONObject.optInt("hide", 0) == 1);
        this.grY = jSONObject.optString(SmsLoginView.f.j);
        this.grZ = jSONObject.optInt("live_min", 0);
        this.gsa = jSONObject.optInt("live_max", 0);
        this.gsb = jSONObject.optInt("actual_min", 0);
        this.gsc = jSONObject.optInt("actual_max", 100);
        if (!TextUtils.isEmpty(bPk())) {
            this.gsd = com.baidu.tieba.ala.alaar.sticker.a.f.bQd().FI(bPl());
            if (this.gsd == null) {
                this.gsd = new com.baidu.tieba.ala.alaar.sticker.model.c(this);
                com.baidu.tieba.ala.alaar.sticker.a.f.bQd().a(bPl(), this.gsd);
            }
            if (this.gsd.getLocalFile() != null) {
                Fu(this.gsd.getLocalFile().getAbsolutePath());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        h.d("DuBeautyEntity", str);
    }

    public void download(h.a aVar) {
        if (this.gsd == null) {
            d("download-return with model null");
            return;
        }
        if (aVar != null && !this.mOnFileLoadedCallbacks.contains(aVar)) {
            this.mOnFileLoadedCallbacks.add(aVar);
        }
        d("download-from: " + bPk() + "\nto: " + this.gsd.getLocalFile() + "\nis exists: " + this.gsd.getLocalFile().exists());
        this.gsd.b(this.mAbilityCb);
    }

    public boolean isLoaded() {
        return this.gsd == null || this.gsd.isLoaded();
    }

    public boolean isLoading() {
        return this.gsd != null && this.gsd.isLoading();
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

    public h.a bPn() {
        if (this.gse != null) {
            return this.gse.get();
        }
        return null;
    }

    /* loaded from: classes11.dex */
    public static class a implements com.baidu.tieba.ala.alaar.makeup.b.b {
        private String gsg;
        private String gsh;
        private File mFolder;

        public void V(File file) {
            this.mFolder = file;
        }

        public String bPo() {
            return this.gsg;
        }

        public void Fx(String str) {
            this.gsg = c.g(this.mFolder, str);
        }

        public void Fy(String str) {
            this.gsh = c.g(this.mFolder, str);
        }

        public JSONObject toJson() {
            if (TextUtils.isEmpty(this.gsg) && TextUtils.isEmpty(this.gsh)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.gsg)) {
                    jSONObject.put("normal", this.gsg);
                }
                if (!TextUtils.isEmpty(this.gsh)) {
                    jSONObject.put("disable", this.gsh);
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
                    Fx(optString);
                    Fy(optString2);
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
