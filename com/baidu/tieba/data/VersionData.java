package com.baidu.tieba.data;

import android.webkit.URLUtil;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ba;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VersionData implements Serializable {
    private static final long serialVersionUID = 5102616316349188013L;
    private String asDownloadUrl;
    private String clientId;
    private String newFile;
    private int newVersionCode;
    private String newVersionDesc;
    private int newVersionRemind;
    private String patch;
    private String patchSize;
    private String size;
    private String tiebaIconUrl;
    private int forceUpdate = 0;
    private int strategy = 0;
    private int hasNewVer = 0;
    private String newVer = null;
    private String url = null;

    public VersionData() {
        setClientId(null);
        this.newFile = null;
        this.newVersionCode = -1;
        this.tiebaIconUrl = null;
        this.asDownloadUrl = null;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.forceUpdate = jSONObject.optInt("force_update", 0);
                this.strategy = jSONObject.optInt("strategy", 0);
                this.newVer = jSONObject.optString("new_version", null);
                this.size = jSONObject.optString("size", null);
                String optString = jSONObject.optString("new_four_version", null);
                if (!ba.c(optString)) {
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
                if (a()) {
                    this.hasNewVer = 1;
                    this.newFile = "tieba_" + this.newVer + ".apk";
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private boolean a() {
        return (this.newVersionRemind != 1 || this.url == null || !URLUtil.isHttpUrl(this.url) || this.newVer == null || TbConfig.getVersion().equalsIgnoreCase(this.newVer)) ? false : true;
    }

    public void logPrint() {
    }

    public String getNewVersionDesc() {
        return this.newVersionDesc;
    }

    public void setNewVersionDesc(String str) {
        this.newVersionDesc = str;
    }

    public boolean forceUpdate() {
        return this.forceUpdate == 1;
    }

    public void setForceUpdate(int i) {
        this.forceUpdate = i;
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

    public void setClientId(String str) {
        this.clientId = str;
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

    public int getStrategy() {
        return this.strategy;
    }

    public void setStrategy(int i) {
        this.strategy = i;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public String getPatch() {
        return this.patch;
    }

    public void setPatch(String str) {
        this.patch = str;
    }

    public String getPatchSize() {
        return this.patchSize;
    }

    public void setPatchSize(String str) {
        this.patchSize = str;
    }

    public void setNewVersionCode(int i) {
        this.newVersionCode = i;
    }

    public int getNewVersionCode() {
        return this.newVersionCode;
    }

    public void setAsDownloadUrl(String str) {
        this.asDownloadUrl = str;
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
}
