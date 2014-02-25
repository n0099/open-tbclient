package com.baidu.tieba.data;

import android.webkit.URLUtil;
import com.baidu.tieba.util.bs;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VersionData implements Serializable {
    private static final long serialVersionUID = 5102616316349188013L;
    private String client_id;
    private String new_file;
    private String new_version_desc;
    private int new_version_remind;
    private int force_update = 0;
    private int has_new_ver = 0;
    private String new_ver = null;
    private String url = null;

    public VersionData() {
        setClient_id(null);
        this.new_file = null;
    }

    public String getNew_version_desc() {
        return this.new_version_desc;
    }

    public void setNew_version_desc(String str) {
        this.new_version_desc = str;
    }

    public int getForce_update() {
        return this.force_update;
    }

    public void setForce_update(int i) {
        this.force_update = i;
    }

    public String getNew_version() {
        return this.new_ver;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setHas_new_ver(int i) {
        this.has_new_ver = i;
    }

    public int getHas_new_ver() {
        return this.has_new_ver;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.force_update = jSONObject.optInt("force_update", 0);
                this.new_ver = jSONObject.optString("new_version", null);
                String optString = jSONObject.optString("new_four_version", null);
                if (!bs.c(optString)) {
                    this.new_ver = optString;
                }
                this.url = jSONObject.optString("new_version_url");
                this.new_version_remind = jSONObject.optInt("new_version_remind", 0);
                this.new_version_desc = jSONObject.optString("new_version_desc", null);
                if (this.new_version_remind == 1 && this.url != null && URLUtil.isHttpUrl(this.url) && this.new_ver != null && !i.u().equalsIgnoreCase(this.new_ver)) {
                    this.has_new_ver = 1;
                    this.new_file = "tieba_" + this.new_ver + ".apk";
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }

    public void logPrint() {
        com.baidu.adp.lib.util.f.d("VersionData", "logPrint", "force_update = " + String.valueOf(this.force_update));
        com.baidu.adp.lib.util.f.d("VersionData", "logPrint", "new_ver = " + this.new_ver);
        com.baidu.adp.lib.util.f.d("VersionData", "logPrint", "has_new_ver = " + String.valueOf(this.has_new_ver));
        com.baidu.adp.lib.util.f.d("VersionData", "logPrint", "url = " + this.url);
    }

    public void setClient_id(String str) {
        this.client_id = str;
    }

    public String getClient_id() {
        return this.client_id;
    }

    public void setNew_file(String str) {
        this.new_file = str;
    }

    public String getNew_file() {
        return this.new_file;
    }
}
