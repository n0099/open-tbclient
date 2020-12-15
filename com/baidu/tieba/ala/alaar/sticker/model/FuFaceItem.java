package com.baidu.tieba.ala.alaar.sticker.model;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.tieba.ala.alaar.sticker.a.h;
import com.baidu.tieba.ala.alaar.sticker.a.i;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FuFaceItem extends com.baidu.live.af.b implements Serializable {
    public static final File FILE_NONE = new File("none");
    public static final String JK_ABILITY = "ability";
    public static final String JK_MAX_SDK_VERSION = "sdk_version_max";
    public static final String JK_MIN_SDK_VERSION = "sdk_version_min";
    public static final String JK_MODEL_SK = "model_sk";
    public static final String JK_MODEL_URL = "model_url";
    public static final String JK_SLAM_STATUS = "slam_status";
    public static final String JK_SO_INFO = "so_info";
    public static final String JK_SO_SK = "file_sk";
    public static final String JK_SO_URL = "file_url";
    public static final String JK_SUB_TYPE = "sub_type";
    public static final String NONE = "none";
    private static final String TAG = "Ar_Sticker_DuFaceItem";
    private static File sFolder;
    public String bgurl;
    public String file;
    public String filterId;
    public String id;
    private int mAbility;
    private b mAbilityModel;
    private a mCompositeDownloader;
    protected String mLoadingFile;
    private int mMaxtVersion;
    private int mMinVersion;
    public String mModelSk;
    public String mModelUrl;
    protected boolean mResLoaded;
    private boolean mSlamStatus;
    private b mSoFile;
    private File mStickerFile;
    private int mStickerMode;
    public String musicId;
    public String name;
    public int need_model;
    public String sk;
    public String tip;
    public boolean isCancelItem = false;
    private final List<h.a> mOnFileLoadedCallbacks = new ArrayList();
    com.baidu.tieba.ala.alaar.sticker.download.a.a mAbilityCb = new com.baidu.tieba.ala.alaar.sticker.download.a.a() { // from class: com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem.1
        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onStarted() {
            super.onStarted();
            if (com.baidu.tieba.ala.alaar.sticker.download.b.bQx().isRunning(FuFaceItem.this.file) && FuFaceItem.this.mCompositeDownloader != null) {
                FuFaceItem.this.mCompositeDownloader.onStarted();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onCompleted(String str) {
            super.onCompleted(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e(FuFaceItem.TAG, "mAbilityCb onCompleted:" + str);
            if (FuFaceItem.this.mAbilityModel == null || FuFaceItem.this.mAbilityModel.isLoaded()) {
                if ((FuFaceItem.this.mSoFile == null || FuFaceItem.this.mSoFile.isLoaded()) && FuFaceItem.this.mCompositeDownloader != null) {
                    FuFaceItem.this.mCompositeDownloader.Gz(str);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e(FuFaceItem.TAG, "mAbilityCb onFailed:" + (downloadException == null ? "," : downloadException.getErrorMessage()));
            if (FuFaceItem.this.mCompositeDownloader != null) {
                FuFaceItem.this.mCompositeDownloader.a(downloadException);
            }
        }
    };
    com.baidu.tieba.ala.alaar.sticker.download.a.a mStickerCb = new AnonymousClass2();
    protected final Sticker mSticker = new Sticker();

    public FuFaceItem() {
        this.mSticker.tag = this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FuFaceItem) {
            return super.equals(obj) || (!TextUtils.isEmpty(this.sk) && this.id.equals(((FuFaceItem) obj).sk));
        }
        return false;
    }

    public b getAbilityModel() {
        return this.mAbilityModel;
    }

    public void setArType(int i) {
        this.mSticker.setArTyp(i);
    }

    public String getThumPath() {
        return this.bgurl;
    }

    public String getId() {
        return this.id;
    }

    public File getFolder() {
        if (sFolder == null) {
            sFolder = i.getPrivateCaptureRootChildDir("duSticker");
        }
        return sFolder;
    }

    public File getStickerFile() {
        if (this.mStickerFile == null && !TextUtils.isEmpty(this.sk)) {
            setStickerFile(new File(getFolder(), this.sk));
        }
        return this.mStickerFile;
    }

    public void setStickerFile(File file) {
        this.mStickerFile = file;
        this.mSticker.setFile(this.mStickerFile);
    }

    public String getFilePath() {
        return getStickerFile().getAbsolutePath();
    }

    public void setFilePath(String str) {
        if (TextUtils.isEmpty(str)) {
            sFolder = FILE_NONE;
        } else {
            sFolder = new File(str);
        }
    }

    public boolean isResLoaded() {
        return FILE_NONE == getStickerFile() || (getStickerFile() != null && getStickerFile().exists() && ((this.mAbilityModel == null || this.mAbilityModel.isLoaded()) && (this.mSoFile == null || this.mSoFile.isLoaded())));
    }

    public File getLocalFile() {
        return this.mSticker.getFile();
    }

    public void setLocalFile(File file) {
        this.mSticker.setFile(file);
        checkResFile();
    }

    public boolean isLoading() {
        return this.mCompositeDownloader != null;
    }

    public boolean isTouchAble() {
        return this.mSlamStatus;
    }

    @Deprecated
    protected void checkResFile() {
    }

    public String getLoadingFile() {
        if (TextUtils.isEmpty(this.mLoadingFile)) {
            this.mLoadingFile = getFilePath();
            if (!this.mLoadingFile.endsWith(".zip")) {
                this.mLoadingFile += ".zip";
            }
        }
        return this.mLoadingFile;
    }

    public boolean onResLoaded(String str) {
        boolean z;
        Exception e;
        try {
            File file = new File(str);
            File file2 = new File(getFilePath() + ".tmp");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(file2);
                try {
                    file2.delete();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.d(file, file2);
            com.baidu.tieba.ala.alaar.sticker.b.a.d(TAG, "onUnzipFile: " + file2);
            z = com.baidu.minivideo.arface.a.jO(file2.getAbsolutePath());
            if (!z) {
                com.baidu.tieba.ala.alaar.sticker.b.a.d(TAG, getFilePath() + " not verify");
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(file2);
            }
            file2.renameTo(getStickerFile());
        } catch (Exception e3) {
            z = false;
            e = e3;
            com.baidu.tieba.ala.alaar.sticker.b.a.e(TAG, "onResLoaded: " + e.getMessage());
            e.printStackTrace();
            com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(getStickerFile());
            checkResFile();
            return z;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(new File(str));
            }
        } catch (Exception e4) {
            e = e4;
            com.baidu.tieba.ala.alaar.sticker.b.a.e(TAG, "onResLoaded: " + e.getMessage());
            e.printStackTrace();
            com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(getStickerFile());
            checkResFile();
            return z;
        }
        checkResFile();
        return z;
    }

    public void parse(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                parse(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.optString("id");
            this.name = jSONObject.optString("name");
            this.bgurl = jSONObject.optString("bgurl");
            this.file = jSONObject.optString("file");
            this.sk = jSONObject.optString("sk");
            this.musicId = jSONObject.optString("music_id");
            this.tip = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_TIP);
            this.filterId = jSONObject.optString("filter_id");
            String optString = jSONObject.optString("mResFile");
            this.mLoadingFile = jSONObject.optString("mLoadingFile");
            File file = null;
            if (optString != null) {
                file = new File(optString);
            }
            setLocalFile(file);
            this.mStickerMode = jSONObject.optInt("sticker_mode", 0);
            this.mSticker.setId(this.id);
            setArType(jSONObject.optInt(JK_SUB_TYPE));
            this.mAbility = jSONObject.optInt(JK_ABILITY);
            int optInt = jSONObject.optInt(JK_MAX_SDK_VERSION);
            int optInt2 = jSONObject.optInt(JK_MIN_SDK_VERSION);
            boolean z = 1 == jSONObject.optInt(JK_SLAM_STATUS);
            this.mModelUrl = jSONObject.optString(JK_MODEL_URL);
            this.mModelSk = jSONObject.optString(JK_MODEL_SK);
            this.mAbilityModel = getOrCreateDuAbilityModel(this.mModelSk, this.mModelUrl);
            if (this.mAbilityModel != null) {
                this.mSticker.setAbility(this.mAbilityModel.bQP());
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(JK_SO_INFO);
            if (optJSONObject != null) {
                this.mSoFile = getOrCreateSoModel(optJSONObject.optString(JK_SO_SK), optJSONObject.optString(JK_SO_URL));
                if (this.mSoFile != null) {
                    new ArrayList().add(this.mSoFile.bQP());
                }
            }
            setTouchAble(z);
            setMaxVersion(optInt);
            setMiniVersion(optInt2);
        }
        checkResFile();
        getFolder();
        getLoadingFile();
    }

    private b getOrCreateDuAbilityModel(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        b Go = com.baidu.tieba.ala.alaar.sticker.a.b.bQG().Go(str);
        if (Go == null) {
            com.baidu.tieba.ala.alaar.sticker.model.a aVar = new com.baidu.tieba.ala.alaar.sticker.model.a();
            aVar.mUrl = str2;
            aVar.gkR = str;
            b bVar = new b(aVar);
            com.baidu.tieba.ala.alaar.sticker.a.b.bQG().a(str, (String) bVar);
            return bVar;
        }
        return Go;
    }

    private b getOrCreateSoModel(String str, String str2) {
        d Go = com.baidu.tieba.ala.alaar.sticker.a.b.bQF().Go(str);
        if (Go == null) {
            com.baidu.tieba.ala.alaar.sticker.model.a aVar = new com.baidu.tieba.ala.alaar.sticker.model.a();
            aVar.mUrl = str2;
            aVar.gkR = str;
            d dVar = new d(aVar);
            com.baidu.tieba.ala.alaar.sticker.a.b.bQF().a(str, (String) dVar);
            return dVar;
        }
        return Go;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("name", this.name);
            jSONObject.put("bgurl", this.bgurl);
            jSONObject.put("file", this.file);
            jSONObject.put("sk", this.sk);
            jSONObject.put("music_id", this.musicId);
            jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_TIP, this.tip);
            jSONObject.put("filter_id", this.filterId);
            jSONObject.put("mResFile", this.mSticker.getPath());
            jSONObject.put("mLoadingFile", this.mLoadingFile);
            jSONObject.put("sticker_mode", this.mStickerMode);
            jSONObject.put(JK_ABILITY, this.mAbility);
            jSONObject.put(JK_MAX_SDK_VERSION, this.mMaxtVersion);
            jSONObject.put(JK_MIN_SDK_VERSION, this.mMinVersion);
            jSONObject.put(JK_SLAM_STATUS, this.mSlamStatus ? 1 : 0);
            jSONObject.put(JK_MODEL_URL, this.mModelUrl);
            jSONObject.put(JK_MODEL_SK, this.mModelSk);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public Sticker getSticker() {
        return this.mSticker;
    }

    public void setTip(String str) {
        this.tip = str;
    }

    public void download(h.a<FuFaceItem> aVar) {
        if (isResLoaded()) {
            if (aVar != null) {
                aVar.aE(this);
                return;
            }
            return;
        }
        this.mOnFileLoadedCallbacks.add(aVar);
        if (!isLoading()) {
            String loadingFile = getLoadingFile();
            if (!TextUtils.isEmpty(loadingFile)) {
                synchronized (this) {
                    if (!isResLoaded() && !isLoading()) {
                        if (this.mCompositeDownloader == null) {
                            this.mCompositeDownloader = new a();
                        }
                        File file = new File(loadingFile);
                        com.baidu.tieba.ala.alaar.sticker.b.a.e(TAG, "download:" + this.file + "\n" + file.getAbsolutePath() + "\nexists:" + file.exists());
                        File stickerFile = getStickerFile();
                        if (stickerFile != null && stickerFile.exists()) {
                            this.mStickerCb.onCompleted(stickerFile.getAbsolutePath());
                        } else {
                            if (file.exists()) {
                                try {
                                    file.delete();
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            com.baidu.tieba.ala.alaar.sticker.download.b.bQx().a(this.file, file.getParent(), file.getName(), this.mStickerCb);
                        }
                        if (this.mAbilityModel != null || this.mSoFile != null) {
                            if (this.mAbilityModel != null) {
                                com.baidu.tieba.ala.alaar.sticker.a.b.bQG().a(this.mModelSk, this.mAbilityCb);
                            }
                            if (this.mSoFile != null) {
                                com.baidu.tieba.ala.alaar.sticker.a.b.bQF().a(this.mSoFile.bQO(), this.mAbilityCb);
                            }
                        } else if (this.mCompositeDownloader != null) {
                            this.mCompositeDownloader.Gz(null);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a {
        boolean cbc;
        boolean glh;
        boolean gli;

        a() {
        }

        public void onStarted() {
            if (!this.cbc) {
                this.cbc = true;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < FuFaceItem.this.mOnFileLoadedCallbacks.size()) {
                        h.a aVar = (h.a) FuFaceItem.this.mOnFileLoadedCallbacks.get(i2);
                        if (aVar != null) {
                            aVar.aD(FuFaceItem.this);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public void Gy(String str) {
            this.glh = true;
            onCompleted();
        }

        public void Gz(String str) {
            this.gli = true;
            onCompleted();
        }

        public void onCompleted() {
            com.baidu.tieba.ala.alaar.sticker.b.a.e(FuFaceItem.TAG, "CompositeDownloader onCompleted,mFinished:" + FuFaceItem.this.isLoading() + ", sticker:" + this.glh + ", ability:" + this.gli);
            if (FuFaceItem.this.isLoading() && this.glh && this.gli) {
                synchronized (FuFaceItem.this) {
                    FuFaceItem.this.mCompositeDownloader = null;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < FuFaceItem.this.mOnFileLoadedCallbacks.size()) {
                        h.a aVar = (h.a) FuFaceItem.this.mOnFileLoadedCallbacks.get(i2);
                        if (aVar != null) {
                            aVar.aE(FuFaceItem.this);
                        }
                        i = i2 + 1;
                    } else {
                        FuFaceItem.this.mOnFileLoadedCallbacks.clear();
                        return;
                    }
                }
            }
        }

        public void a(DownloadException downloadException) {
            String str;
            int i;
            if (FuFaceItem.this.isLoading()) {
                synchronized (FuFaceItem.this) {
                    FuFaceItem.this.mCompositeDownloader = null;
                }
                for (int i2 = 0; i2 < FuFaceItem.this.mOnFileLoadedCallbacks.size(); i2++) {
                    h.a aVar = (h.a) FuFaceItem.this.mOnFileLoadedCallbacks.get(i2);
                    if (aVar != null) {
                        if (downloadException != null) {
                            i = downloadException.getErrorCode();
                            str = downloadException.getErrorMessage();
                        } else {
                            str = null;
                            i = 0;
                        }
                        aVar.a(FuFaceItem.this, i, 0, str);
                    }
                }
                FuFaceItem.this.mOnFileLoadedCallbacks.clear();
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass2 extends com.baidu.tieba.ala.alaar.sticker.download.a.a {
        AnonymousClass2() {
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onStarted() {
            super.onStarted();
            com.baidu.tieba.ala.alaar.sticker.b.a.e(FuFaceItem.TAG, "mStickerCb onStarted");
            if (com.baidu.tieba.ala.alaar.sticker.download.b.bQx().isRunning(FuFaceItem.this.file) && FuFaceItem.this.mCompositeDownloader != null) {
                FuFaceItem.this.mCompositeDownloader.onStarted();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onProgress(long j, long j2, int i) {
            super.onProgress(j, j2, i);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem$2$1] */
        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onCompleted(final String str) {
            super.onCompleted(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e(FuFaceItem.TAG, "mStickerCb onCompleted:" + str);
            new Thread() { // from class: com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem.2.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    final boolean onResLoaded = FuFaceItem.this.onResLoaded(str);
                    if (FuFaceItem.this.mCompositeDownloader != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (onResLoaded) {
                                    FuFaceItem.this.mCompositeDownloader.Gy(FuFaceItem.this.getFilePath());
                                } else {
                                    FuFaceItem.this.mCompositeDownloader.a(null);
                                }
                            }
                        });
                    }
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e(FuFaceItem.TAG, "mStickerCb onFailed:" + downloadException.getErrorMessage() + "\n" + FuFaceItem.this.file);
            if (!TextUtils.isEmpty(FuFaceItem.this.file)) {
                try {
                    new File(FuFaceItem.this.file).delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (FuFaceItem.this.mCompositeDownloader != null) {
                if (downloadException != null) {
                    downloadException.getErrorCode();
                    downloadException.getErrorMessage();
                }
                FuFaceItem.this.mCompositeDownloader.a(downloadException);
            }
        }
    }

    public boolean isSupport(int i) {
        return i >= this.mMinVersion && i <= this.mMaxtVersion;
    }

    public int getMiniVersion() {
        return this.mMinVersion;
    }

    public void setMiniVersion(int i) {
        this.mMinVersion = i;
        this.mSticker.setMiniVersion(i);
    }

    public int getMaxVersion() {
        return this.mMaxtVersion;
    }

    public void setMaxVersion(int i) {
        this.mMaxtVersion = i;
        this.mSticker.setMaxVersion(i);
    }

    public int getAbility() {
        return this.mAbility;
    }

    public void setAbility(int i) {
        this.mAbility = i;
    }

    public void setTouchAble(boolean z) {
        this.mSlamStatus = z;
        this.mSticker.setTouchAble(this.mSlamStatus);
    }
}
