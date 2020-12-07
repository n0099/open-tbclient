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
    public int giZ;
    protected String gja;
    public int gjb;
    public a gjc;
    private BeautyType gjd;
    public boolean gje;
    private String gjf;
    private String gjg;
    private String gjh;
    private int gji;
    private int gjj;
    private int gjk;
    private int gjl;
    com.baidu.tieba.ala.alaar.sticker.model.c gjm;
    private WeakReference<h.a> gjn;
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
            if (com.baidu.tieba.ala.alaar.sticker.download.b.bQw().isRunning(c.this.bPP())) {
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
            h.a bPS = c.this.bPS();
            if (bPS != null) {
                bPS.aD(c.this);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onCompleted(String str) {
            super.onCompleted(str);
            c.this.d("DownloadCallback onCompleted:" + str);
            if (c.this.gjm == null || c.this.gjm.isLoaded()) {
                onCompleted();
            }
        }

        public void onCompleted() {
            c.this.d("DownloadCallback onCompleted,mFinished:" + c.this.gjm.isLoaded());
            synchronized (c.this) {
                c.this.mAbilityCb = null;
            }
            h.a bPS = c.this.bPS();
            if (bPS != null) {
                bPS.aE(c.this);
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
                h.a bPS = c.this.bPS();
                if (bPS != null) {
                    bPS.a(c.this, i, 0, str);
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

    public String bPG() {
        return !TextUtils.isEmpty(this.gja) ? this.gja : this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void Gh(String str) {
        this.gja = str;
    }

    public String bPH() {
        return this.gja;
    }

    protected void uE(int i) {
        this.gjb = i;
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
        this.gjc = aVar;
    }

    public a bPI() {
        return this.gjc;
    }

    public int getValue() {
        return this.value;
    }

    public int bPJ() {
        return this.gjj;
    }

    public int bPK() {
        return this.gji;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public void uF(int i) {
        this.giZ = i;
    }

    public int bPL() {
        return this.giZ;
    }

    public float bPM() {
        return ((((this.value - this.gji) / (this.gjj - this.gji)) * (this.gjl - this.gjk)) + this.gjk) / 100.0f;
    }

    public void setHide(boolean z) {
        this.gje = z;
    }

    public boolean bPN() {
        return this.gje;
    }

    public BeautyType getType() {
        return this.gjd;
    }

    public String getTypeName() {
        return this.mTypeName;
    }

    public void setTypeName(String str) {
        this.mTypeName = str;
    }

    public void a(BeautyType beautyType) {
        this.gjd = beautyType;
    }

    public String bPO() {
        return this.gjf;
    }

    public void Gi(String str) {
        this.gjf = g(this.mFolder, str);
    }

    public String bPP() {
        return this.gjg;
    }

    public void Gj(String str) {
        this.gjg = g(this.mFolder, str);
    }

    public String bPQ() {
        return this.gjh;
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

    public File bPR() {
        return this.mFolder;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getName());
            jSONObject.put("live_name", bPH());
            jSONObject.put("makeup_id", getId());
            String str = null;
            if (this.gjd != null) {
                str = this.gjd.name();
            }
            jSONObject.put("type", str);
            jSONObject.put("value", getValue());
            jSONObject.put("live_default", bPL());
            jSONObject.put("hide", bPN() ? 1 : 0);
            jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, getIcon());
            jSONObject.put("path", bPO());
            jSONObject.put("file", bPP());
            a bPI = bPI();
            if (bPI != null) {
                jSONObject.put("state_icon", bPI.toJson());
            }
            jSONObject.put(SmsLoginView.f.j, this.gjh);
            jSONObject.put("live_min", this.gji);
            jSONObject.put("live_max", this.gjj);
            jSONObject.put("actual_min", this.gjk);
            jSONObject.put("actual_max", this.gjl);
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
        setValue(jSONObject.optInt("value", bPL()));
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
        this.gjh = jSONObject.optString(SmsLoginView.f.j);
        this.gji = jSONObject.optInt("live_min", 0);
        this.gjj = jSONObject.optInt("live_max", 0);
        this.gjk = jSONObject.optInt("actual_min", 0);
        this.gjl = jSONObject.optInt("actual_max", 100);
        if (!TextUtils.isEmpty(bPP())) {
            this.gjm = com.baidu.tieba.ala.alaar.sticker.a.f.bQJ().Gw(bPQ());
            if (this.gjm == null) {
                this.gjm = new com.baidu.tieba.ala.alaar.sticker.model.c(this);
                com.baidu.tieba.ala.alaar.sticker.a.f.bQJ().a(bPQ(), this.gjm);
            }
            if (this.gjm.getLocalFile() != null) {
                Gi(this.gjm.getLocalFile().getAbsolutePath());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        h.d("DuBeautyEntity", str);
    }

    public void download(h.a aVar) {
        if (this.gjm == null) {
            d("download-return with model null");
            return;
        }
        if (aVar != null && !this.mOnFileLoadedCallbacks.contains(aVar)) {
            this.mOnFileLoadedCallbacks.add(aVar);
        }
        d("download-from: " + bPP() + "\nto: " + this.gjm.getLocalFile() + "\nis exists: " + this.gjm.getLocalFile().exists());
        this.gjm.b(this.mAbilityCb);
    }

    public boolean isLoaded() {
        return this.gjm == null || this.gjm.isLoaded();
    }

    public boolean isLoading() {
        return this.gjm != null && this.gjm.isLoading();
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

    public h.a bPS() {
        if (this.gjn != null) {
            return this.gjn.get();
        }
        return null;
    }

    /* loaded from: classes4.dex */
    public static class a implements com.baidu.tieba.ala.alaar.makeup.b.b {
        private String gjp;
        private String gjq;
        private File mFolder;

        public void W(File file) {
            this.mFolder = file;
        }

        public String bPT() {
            return this.gjp;
        }

        public void Gl(String str) {
            this.gjp = c.g(this.mFolder, str);
        }

        public void Gm(String str) {
            this.gjq = c.g(this.mFolder, str);
        }

        public JSONObject toJson() {
            if (TextUtils.isEmpty(this.gjp) && TextUtils.isEmpty(this.gjq)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.gjp)) {
                    jSONObject.put("normal", this.gjp);
                }
                if (!TextUtils.isEmpty(this.gjq)) {
                    jSONObject.put("disable", this.gjq);
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
