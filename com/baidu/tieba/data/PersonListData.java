package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PersonListData {
    private ArrayList<MetaData> mUsers = new ArrayList<>();
    private PageData mPage = new PageData();

    public void setPage(PageData page) {
        this.mPage = page;
    }

    public PageData getPage() {
        return this.mPage;
    }

    public void setUserList(ArrayList<MetaData> userList) {
        this.mUsers = userList;
    }

    public ArrayList<MetaData> getUserList() {
        return this.mUsers;
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
                JSONArray user_list = json.optJSONArray("user_list");
                if (user_list != null) {
                    for (int i = 0; i < user_list.length(); i++) {
                        MetaData tmp = new MetaData();
                        tmp.parserJson(user_list.getJSONObject(i));
                        this.mUsers.add(tmp);
                    }
                }
                this.mPage.parserJson(json.optJSONObject("page"));
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "parserJson", ex.getMessage());
            }
        }
    }
}
