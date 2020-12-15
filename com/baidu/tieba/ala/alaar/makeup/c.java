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
/* loaded from: classes4.dex */
public class c implements com.baidu.tieba.ala.alaar.makeup.b.b {
    public int gjb;
    protected String gjc;
    public int gjd;
    public a gje;
    private BeautyType gjf;
    public boolean gjg;
    private String gjh;
    private String gji;
    private String gjj;
    private int gjk;
    private int gjl;
    private int gjm;
    private int gjn;
    com.baidu.tieba.ala.alaar.sticker.model.c gjo;
    private WeakReference<h.a> gjp;
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
            if (com.baidu.tieba.ala.alaar.sticker.download.b.bQx().isRunning(c.this.bPQ())) {
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
            h.a bPT = c.this.bPT();
            if (bPT != null) {
                bPT.aD(c.this);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onCompleted(String str) {
            super.onCompleted(str);
            c.this.d("DownloadCallback onCompleted:" + str);
            if (c.this.gjo == null || c.this.gjo.isLoaded()) {
                onCompleted();
            }
        }

        public void onCompleted() {
            c.this.d("DownloadCallback onCompleted,mFinished:" + c.this.gjo.isLoaded());
            synchronized (c.this) {
                c.this.mAbilityCb = null;
            }
            h.a bPT = c.this.bPT();
            if (bPT != null) {
                bPT.aE(c.this);
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
                h.a bPT = c.this.bPT();
                if (bPT != null) {
                    bPT.a(c.this, i, 0, str);
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

    public String bPH() {
        return !TextUtils.isEmpty(this.gjc) ? this.gjc : this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void Gh(String str) {
        this.gjc = str;
    }

    public String bPI() {
        return this.gjc;
    }

    protected void uE(int i) {
        this.gjd = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = g(this.mFolder, str);
        if (str.startsWith("resIdName://")) {
            int aL = aL(TbadkCoreApplication.getInst().getApp(), Gk(str));
            if (aL > 0) {
                uE(aL);
            }
        }
    }

    public void a(a aVar) {
        this.gje = aVar;
    }

    public a bPJ() {
        return this.gje;
    }

    public int getValue() {
        return this.value;
    }

    public int bPK() {
        return this.gjl;
    }

    public int bPL() {
        return this.gjk;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public void uF(int i) {
        this.gjb = i;
    }

    public int bPM() {
        return this.gjb;
    }

    public float bPN() {
        return ((((this.value - this.gjk) / (this.gjl - this.gjk)) * (this.gjn - this.gjm)) + this.gjm) / 100.0f;
    }

    public void setHide(boolean z) {
        this.gjg = z;
    }

    public boolean bPO() {
        return this.gjg;
    }

    public BeautyType getType() {
        return this.gjf;
    }

    public String getTypeName() {
        return this.mTypeName;
    }

    public void setTypeName(String str) {
        this.mTypeName = str;
    }

    public void a(BeautyType beautyType) {
        this.gjf = beautyType;
    }

    public String bPP() {
        return this.gjh;
    }

    public void Gi(String str) {
        this.gjh = g(this.mFolder, str);
    }

    public String bPQ() {
        return this.gji;
    }

    public void Gj(String str) {
        this.gji = g(this.mFolder, str);
    }

    public String bPR() {
        return this.gjj;
    }

    public static String g(File file, String str) {
        if (file != null && str != null && str.startsWith("relativePath://")) {
            return str.replace("relativePath://", file.getAbsolutePath() + File.separator);
        }
        return str;
    }

    public String Gk(String str) {
        if (str.startsWith("resIdName://")) {
            return str.replace("resIdName://", "");
        }
        return str;
    }

    public void W(File file) {
        this.mFolder = file;
    }

    public File bPS() {
        return this.mFolder;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getName());
            jSONObject.put("live_name", bPI());
            jSONObject.put("makeup_id", getId());
            String str = null;
            if (this.gjf != null) {
                str = this.gjf.name();
            }
            jSONObject.put("type", str);
            jSONObject.put("value", getValue());
            jSONObject.put("live_default", bPM());
            jSONObject.put("hide", bPO() ? 1 : 0);
            jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, getIcon());
            jSONObject.put("path", bPP());
            jSONObject.put("file", bPQ());
            a bPJ = bPJ();
            if (bPJ != null) {
                jSONObject.put("state_icon", bPJ.toJson());
            }
            jSONObject.put(SmsLoginView.f.j, this.gjj);
            jSONObject.put("live_min", this.gjk);
            jSONObject.put("live_max", this.gjl);
            jSONObject.put("actual_min", this.gjm);
            jSONObject.put("actual_max", this.gjn);
        } catch (JSONException e) {
            e.printStackTrace();
            if (h.isDebug()) {
                h.e("DuBeautyEntity", e.getMessage());
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean du(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        setName(jSONObject.optString("name"));
        Gh(jSONObject.optString("live_name", null));
        setId(jSONObject.optString("makeup_id"));
        uF(jSONObject.optInt("live_default", 0));
        setValue(jSONObject.optInt("value", bPM()));
        setIcon(jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON));
        JSONObject optJSONObject = jSONObject.optJSONObject("state_icon");
        if (optJSONObject != null) {
            a aVar = new a();
            aVar.W(this.mFolder);
            if (aVar.du(optJSONObject)) {
                a(aVar);
            }
        }
        this.mTypeName = jSONObject.optString("type", this.mTypeName);
        Gi(jSONObject.optString("path"));
        Gj(jSONObject.optString("file"));
        if (TextUtils.isEmpty(this.mTypeName)) {
            return false;
        }
        a(BeautyType.valueOf(this.mTypeName));
        setHide(jSONObject.optInt("hide", 0) == 1);
        this.gjj = jSONObject.optString(SmsLoginView.f.j);
        this.gjk = jSONObject.optInt("live_min", 0);
        this.gjl = jSONObject.optInt("live_max", 0);
        this.gjm = jSONObject.optInt("actual_min", 0);
        this.gjn = jSONObject.optInt("actual_max", 100);
        if (!TextUtils.isEmpty(bPQ())) {
            this.gjo = com.baidu.tieba.ala.alaar.sticker.a.f.bQK().Gw(bPR());
            if (this.gjo == null) {
                this.gjo = new com.baidu.tieba.ala.alaar.sticker.model.c(this);
                com.baidu.tieba.ala.alaar.sticker.a.f.bQK().a(bPR(), this.gjo);
            }
            if (this.gjo.getLocalFile() != null) {
                Gi(this.gjo.getLocalFile().getAbsolutePath());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        h.d("DuBeautyEntity", str);
    }

    public void download(h.a aVar) {
        if (this.gjo == null) {
            d("download-return with model null");
            return;
        }
        if (aVar != null && !this.mOnFileLoadedCallbacks.contains(aVar)) {
            this.mOnFileLoadedCallbacks.add(aVar);
        }
        d("download-from: " + bPQ() + "\nto: " + this.gjo.getLocalFile() + "\nis exists: " + this.gjo.getLocalFile().exists());
        this.gjo.b(this.mAbilityCb);
    }

    public boolean isLoaded() {
        return this.gjo == null || this.gjo.isLoaded();
    }

    public boolean isLoading() {
        return this.gjo != null && this.gjo.isLoading();
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

    public h.a bPT() {
        if (this.gjp != null) {
            return this.gjp.get();
        }
        return null;
    }

    /* loaded from: classes4.dex */
    public static class a implements com.baidu.tieba.ala.alaar.makeup.b.b {
        private String gjr;
        private String gjs;
        private File mFolder;

        public void W(File file) {
            this.mFolder = file;
        }

        public String bPU() {
            return this.gjr;
        }

        public void Gl(String str) {
            this.gjr = c.g(this.mFolder, str);
        }

        public void Gm(String str) {
            this.gjs = c.g(this.mFolder, str);
        }

        public JSONObject toJson() {
            if (TextUtils.isEmpty(this.gjr) && TextUtils.isEmpty(this.gjs)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.gjr)) {
                    jSONObject.put("normal", this.gjr);
                }
                if (!TextUtils.isEmpty(this.gjs)) {
                    jSONObject.put("disable", this.gjs);
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
        public boolean du(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    String optString = jSONObject.optString("normal");
                    String optString2 = jSONObject.optString("disable");
                    Gl(optString);
                    Gm(optString2);
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
