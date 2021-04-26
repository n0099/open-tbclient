package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.unitedscheme.SchemeDescPatchListener;
import com.baidu.tbadk.TbConfig;
import d.a.c.e.p.k;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class VersionData implements Serializable {
    public static final int FORCE_UPDATE = 1;
    public static final int HAS_NEW_VERSION = 1;
    public static final long serialVersionUID = 5102616316349188013L;
    public boolean isOfficialVersion;
    public String newVersionDesc;
    public int newVersionRemind;
    public String patch;
    public String patchSize;
    public String size;
    public int forceUpdate = 0;
    public int strategy = 0;
    public int hasNewVer = 0;
    public String newVer = null;
    public String url = null;
    public String clientId = null;
    public String newFile = null;
    public int newVersionCode = -1;
    public String tiebaIconUrl = null;
    public String asDownloadUrl = null;
    public String apkMD5RSA = null;
    public String asApkMD5RSA = null;

    private boolean hasNewVersion() {
        String str;
        return (this.newVersionRemind != 1 || (str = this.url) == null || !URLUtil.isNetworkUrl(str) || TextUtils.isEmpty(this.apkMD5RSA) || this.newVer == null || TbConfig.getVersion().equalsIgnoreCase(this.newVer)) ? false : true;
    }

    public boolean forceUpdate() {
        return this.forceUpdate == 1;
    }

    public String getApkMD5RSA() {
        return this.apkMD5RSA;
    }

    public String getAsApkMD5RSA() {
        return this.asApkMD5RSA;
    }

    public String getAsDownloadUrl() {
        return this.asDownloadUrl;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getNewFile() {
        return this.newFile;
    }

    public String getNewVersion() {
        return this.newVer;
    }

    public int getNewVersionCode() {
        return this.newVersionCode;
    }

    public String getNewVersionDesc() {
        return this.newVersionDesc;
    }

    public String getPatch() {
        return this.patch;
    }

    public String getPatchSize() {
        return this.patchSize;
    }

    public String getSize() {
        return this.size;
    }

    public int getStrategy() {
        return this.strategy;
    }

    public String getTiebaIconUrl() {
        return this.tiebaIconUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean hasNewVer() {
        return this.hasNewVer == 1;
    }

    public boolean isOfficialVersion() {
        return this.isOfficialVersion;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.forceUpdate = jSONObject.optInt("force_update", 0);
            this.strategy = jSONObject.optInt("strategy", 0);
            this.newVer = jSONObject.optString("new_version", null);
            this.size = jSONObject.optString("size", null);
            String optString = jSONObject.optString("new_four_version", null);
            if (!k.isEmpty(optString)) {
                this.newVer = optString;
            }
            this.url = jSONObject.optString("new_version_url");
            this.newVersionRemind = jSONObject.optInt("new_version_remind", 0);
            this.newVersionDesc = jSONObject.optString("new_version_desc", null);
            this.patch = jSONObject.optString(SchemeDescPatchListener.PATCH);
            this.patchSize = jSONObject.optString("patch_size");
            this.newVersionCode = jSONObject.optInt("new_version_code", -1);
            this.tiebaIconUrl = jSONObject.optString("tieba_iconurl", null);
            this.asDownloadUrl = jSONObject.optString("as_downloadurl", null);
            this.apkMD5RSA = jSONObject.optString("apk_MD5_RSA", null);
            this.asApkMD5RSA = jSONObject.optString("as_apk_MD5_RSA", null);
            this.isOfficialVersion = jSONObject.optInt("android_is_official_version", 0) == 1;
            if (hasNewVersion()) {
                this.hasNewVer = 1;
                this.newFile = "tieba_" + this.newVer + ".apk";
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void setApkMD5RSA(String str) {
        this.apkMD5RSA = str;
    }

    public void setForceUpdate(int i2) {
        this.forceUpdate = i2;
    }

    public void setHasNewVer(int i2) {
        this.hasNewVer = i2;
    }

    public void setNewFile(String str) {
        this.newFile = str;
    }

    public void setNewVersion(String str) {
        this.newVer = str;
    }

    public void setNewVersionCode(int i2) {
        this.newVersionCode = i2;
    }

    public void setNewVersionDesc(String str) {
        this.newVersionDesc = str;
    }

    public void setPatch(String str) {
        this.patch = str;
    }

    public void setPatchSize(String str) {
        this.patchSize = str;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public void setStrategy(int i2) {
        this.strategy = i2;
    }

    public void setTiebaIconUrl(String str) {
        this.tiebaIconUrl = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
