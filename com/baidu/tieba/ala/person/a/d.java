package com.baidu.tieba.ala.person.a;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public List<AlaLiveInfoData> hRd;
    public b hRe;

    public List clA() {
        int i = 0;
        if (ListUtils.isEmpty(this.hRd)) {
            return null;
        }
        int count = ListUtils.getCount(this.hRd);
        ArrayList arrayList = new ArrayList(count / 2);
        if (count != 1) {
            while (true) {
                int i2 = i;
                if (i2 >= count - 1) {
                    break;
                }
                a aVar = new a();
                aVar.hRb = (AlaLiveInfoData) ListUtils.getItem(this.hRd, i2);
                aVar.hRc = (AlaLiveInfoData) ListUtils.getItem(this.hRd, i2 + 1);
                arrayList.add(aVar);
                i = i2 + 2;
            }
        } else {
            a aVar2 = new a();
            aVar2.hRb = (AlaLiveInfoData) ListUtils.getItem(this.hRd, 0);
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
                this.hRd = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                        alaLiveInfoData.parserJson(optJSONObject);
                        this.hRd.add(alaLiveInfoData);
                    }
                }
            }
            this.hRe = new b();
            this.hRe.parserJson(jSONObject.optJSONObject("page"));
        }
    }
}
