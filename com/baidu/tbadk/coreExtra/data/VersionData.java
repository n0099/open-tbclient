package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.at;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VersionData implements Serializable {
    private static final int FORCE_UPDATE = 1;
    private static final int HAS_NEW_VERSION = 1;
    private static final long serialVersionUID = 5102616316349188013L;
    private boolean isOfficialVersion;
    private String newVersionDesc;
    private int newVersionRemind;
    private String patch;
    private String patchSize;
    private String size;
    private int forceUpdate = 0;
    private int strategy = 0;
    private int hasNewVer = 0;
    private String newVer = null;
    private String url = null;
    private String clientId = null;
    private String newFile = null;
    private int newVersionCode = -1;
    private String tiebaIconUrl = null;
    private String asDownloadUrl = null;
    private String apkMD5RSA = null;
    private String asApkMD5RSA = null;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.forceUpdate = jSONObject.optInt("force_update", 0);
                this.strategy = jSONObject.optInt(UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, 0);
                this.newVer = jSONObject.optString("new_version", null);
                this.size = jSONObject.optString(TiebaInitialize.LogFields.SIZE, null);
                String optString = jSONObject.optString("new_four_version", null);
                if (!at.isEmpty(optString)) {
                    this.newVer = optString;
                }
                this.url = jSONObject.optString("new_version_url");
                this.newVersionRemind = jSONObject.optInt("new_version_remind", 0);
                this.newVersionDesc = jSONObject.optString("new_version_desc", null);
                this.patch = jSONObject.optString("patch");
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
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private boolean hasNewVersion() {
        return (this.newVersionRemind != 1 || this.url == null || !URLUtil.isNetworkUrl(this.url) || TextUtils.isEmpty(this.apkMD5RSA) || this.newVer == null || TbConfig.getVersion().equalsIgnoreCase(this.newVer)) ? false : true;
    }

    public void setNewVersionDesc(String str) {
        this.newVersionDesc = str;
    }

    public String getNewVersionDesc() {
        return this.newVersionDesc;
    }

    public void setForceUpdate(int i) {
        this.forceUpdate = i;
    }

    public boolean forceUpdate() {
        return this.forceUpdate == 1;
    }

    public void setNewVersion(String str) {
        this.newVer = str;
    }

    public String getNewVersion() {
        return this.newVer;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setHasNewVer(int i) {
        this.hasNewVer = i;
    }

    public boolean hasNewVer() {
        return this.hasNewVer == 1;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setNewFile(String str) {
        this.newFile = str;
    }

    public String getNewFile() {
        return this.newFile;
    }

    public void setStrategy(int i) {
        this.strategy = i;
    }

    public int getStrategy() {
        return this.strategy;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public String getSize() {
        return this.size;
    }

    public void setPatch(String str) {
        this.patch = str;
    }

    public String getPatch() {
        return this.patch;
    }

    public void setPatchSize(String str) {
        this.patchSize = str;
    }

    public String getPatchSize() {
        return this.patchSize;
    }

    public void setNewVersionCode(int i) {
        this.newVersionCode = i;
    }

    public int getNewVersionCode() {
        return this.newVersionCode;
    }

    public String getAsDownloadUrl() {
        return this.asDownloadUrl;
    }

    public void setTiebaIconUrl(String str) {
        this.tiebaIconUrl = str;
    }

    public String getTiebaIconUrl() {
        return this.tiebaIconUrl;
    }

    public void setApkMD5RSA(String str) {
        this.apkMD5RSA = str;
    }

    public String getApkMD5RSA() {
        return this.apkMD5RSA;
    }

    public String getAsApkMD5RSA() {
        return this.asApkMD5RSA;
    }

    public boolean isOfficialVersion() {
        return this.isOfficialVersion;
    }
}
