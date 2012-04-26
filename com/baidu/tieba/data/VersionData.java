package com.baidu.tieba.data;

import android.webkit.URLUtil;
import com.baidu.tieba.util.TiebaLog;
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

    public void setNew_version_desc(String new_version_desc) {
        this.new_version_desc = new_version_desc;
    }

    public int getForce_update() {
        return this.force_update;
    }

    public void setForce_update(int force_update) {
        this.force_update = force_update;
    }

    public String getNew_version() {
        return this.new_ver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setHas_new_ver(int has_new_ver) {
        this.has_new_ver = has_new_ver;
    }

    public int getHas_new_ver() {
        return this.has_new_ver;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "parserJson", ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.force_update = json.optInt("force_update", 0);
                this.new_ver = json.optString("new_version", null);
                this.url = json.optString("new_version_url");
                this.new_version_remind = json.optInt("new_version_remind", 0);
                this.new_version_desc = json.optString("new_version_desc", null);
                if (this.new_version_remind == 1 && this.url != null && URLUtil.isHttpUrl(this.url) && this.new_ver != null && !Config.VERSION.equalsIgnoreCase(this.new_ver)) {
                    this.has_new_ver = 1;
                    this.new_file = "tieba_" + this.new_ver + ".apk";
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "parserJson", ex.getMessage());
            }
        }
    }

    public void logPrint() {
        TiebaLog.v("VersionData", "logPrint", "force_update = " + String.valueOf(this.force_update));
        TiebaLog.v("VersionData", "logPrint", "new_ver = " + this.new_ver);
        TiebaLog.v("VersionData", "logPrint", "has_new_ver = " + String.valueOf(this.has_new_ver));
        TiebaLog.v("VersionData", "logPrint", "url = " + this.url);
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_id() {
        return this.client_id;
    }

    public void setNew_file(String new_file) {
        this.new_file = new_file;
    }

    public String getNew_file() {
        return this.new_file;
    }
}
