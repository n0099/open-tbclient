package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FriendData {
    private ArrayList<MetaData> friend_list = new ArrayList<>();
    private HashMap<String, String> friend_hash = null;

    public void parserFreindJson(JSONObject json, boolean have_hash) {
        if (json != null) {
            if (have_hash) {
                try {
                    if (this.friend_hash == null) {
                        this.friend_hash = new HashMap<>();
                    }
                } catch (Exception ex) {
                    TiebaLog.e("FriendData", "parserFreindJson", "error = " + ex.getMessage());
                    return;
                }
            }
            JSONArray user_list = json.optJSONArray("user_list");
            if (user_list != null) {
                for (int i = 0; i < user_list.length(); i++) {
                    MetaData tmp = new MetaData();
                    tmp.parserJson(user_list.getJSONObject(i));
                    if (tmp.getName_show() != null) {
                        this.friend_list.add(tmp);
                        if (have_hash) {
                            this.friend_hash.put(tmp.getName_show(), tmp.getPortrait());
                        }
                    }
                }
            }
        }
    }

    public void parserFreindJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserFreindJson(json, true);
        } catch (Exception ex) {
            TiebaLog.e("FriendData", "parserFreindJson", "error = " + ex.getMessage());
        }
    }

    public void parserFreindJsonNohash(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserFreindJson(json, false);
        } catch (Exception ex) {
            TiebaLog.e("FriendData", "parserFreindJson", "error = " + ex.getMessage());
        }
    }

    public ArrayList<MetaData> getFriendList() {
        return this.friend_list;
    }

    public HashMap<String, String> getFriendHash() {
        return this.friend_hash;
    }
}
