package com.baidu.tieba.ala.person.a;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public List<AlaLiveInfoData> hVK;
    public b hVL;

    public List cpr() {
        int i = 0;
        if (ListUtils.isEmpty(this.hVK)) {
            return null;
        }
        int count = ListUtils.getCount(this.hVK);
        ArrayList arrayList = new ArrayList(count / 2);
        if (count != 1) {
            while (true) {
                int i2 = i;
                if (i2 >= count - 1) {
                    break;
                }
                a aVar = new a();
                aVar.hVI = (AlaLiveInfoData) ListUtils.getItem(this.hVK, i2);
                aVar.hVJ = (AlaLiveInfoData) ListUtils.getItem(this.hVK, i2 + 1);
                arrayList.add(aVar);
                i = i2 + 2;
            }
        } else {
            a aVar2 = new a();
            aVar2.hVI = (AlaLiveInfoData) ListUtils.getItem(this.hVK, 0);
            arrayList.add(aVar2);
        }
        return arrayList;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("record_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.hVK = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                        alaLiveInfoData.parserJson(optJSONObject);
                        this.hVK.add(alaLiveInfoData);
                    }
                }
            }
            this.hVL = new b();
            this.hVL.parserJson(jSONObject.optJSONObject("page"));
        }
    }
}
