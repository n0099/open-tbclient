package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SuggestData {
    private ArrayList<MetaData> suggest_list = new ArrayList<>();

    public void parserSuggestJson(JSONObject json, HashMap<String, String> photo_hash) {
        String portrait;
        try {
            JSONArray names = json.optJSONArray("uname");
            for (int i = 0; i < names.length(); i++) {
                MetaData data = new MetaData();
                data.setName_show(names.optString(i));
                if (photo_hash != null && (portrait = photo_hash.get(data.getName_show())) != null) {
                    data.setPortrait(portrait);
                }
                this.suggest_list.add(data);
            }
        } catch (Exception ex) {
            TiebaLog.e("AtListModel", "parserSuggestJson", "error = " + ex.getMessage());
        }
    }

    public void parserSuggestJson(String data, HashMap<String, String> photo_hash) {
        try {
            JSONObject json = new JSONObject(data);
            parserSuggestJson(json, photo_hash);
        } catch (Exception ex) {
            TiebaLog.e("AtListModel", "parserSuggestJson", "error = " + ex.getMessage());
        }
    }

    public void refreshSugguestPhto(HashMap<String, String> hash) {
        if (hash != null) {
            for (int i = 0; i < this.suggest_list.size(); i++) {
                MetaData data = this.suggest_list.get(i);
                String name = data.getName_show();
                data.setPortrait(hash.get(name));
            }
        }
    }

    public ArrayList<MetaData> getSuggestList() {
        return this.suggest_list;
    }
}
