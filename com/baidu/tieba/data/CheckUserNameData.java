package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CheckUserNameData {
    private ArrayList<String> mSuggnames;
    private UserData mUser;

    public CheckUserNameData() {
        this.mUser = null;
        this.mSuggnames = null;
        this.mUser = new UserData();
        this.mSuggnames = new ArrayList<>(3);
    }

    public void setUser(UserData mUser) {
        this.mUser = mUser;
    }

    public UserData getUser() {
        return this.mUser;
    }

    public void setSuggnames(ArrayList<String> mSuggnames) {
        this.mSuggnames = mSuggnames;
    }

    public ArrayList<String> getSuggnames() {
        return this.mSuggnames;
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
        try {
            JSONObject obj = json.optJSONObject("user");
            this.mUser.parserJson(obj);
            JSONArray list = json.optJSONArray("suggnames");
            if (list != null) {
                for (int i = 0; i < list.length(); i++) {
                    this.mSuggnames.add(list.optString(i, null));
                }
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "parserJson", ex.getMessage());
        }
    }
}
