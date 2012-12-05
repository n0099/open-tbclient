package com.baidu.tieba.data;

import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class OwnerData {
    private int is_login = 0;
    private String id = null;
    private int no_un = 0;
    private String name = null;
    private String name_show = null;
    private String portrait = null;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName_show(String name_show) {
        this.name_show = name_show;
    }

    public String getName_show() {
        return this.name_show;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("MetaData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.id = json.optString("id");
                this.is_login = json.optInt("is_login", 0);
                this.no_un = json.optInt("no_un", 0);
                this.name = json.optString(PersonInfoActivity.TAG_NAME);
                this.name_show = json.optString("name_show");
                this.portrait = json.optString("portrait");
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void setIs_login(int is_login) {
        this.is_login = is_login;
    }

    public int getIs_login() {
        return this.is_login;
    }

    public void setNo_un(int no_un) {
        this.no_un = no_un;
    }

    public int getNo_un() {
        return this.no_un;
    }
}
