package com.baidu.tieba.ala.person.a;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public List<AlaLiveInfoData> gPL;
    public c gPM;

    public List bYo() {
        int i = 0;
        if (ListUtils.isEmpty(this.gPL)) {
            return null;
        }
        int count = ListUtils.getCount(this.gPL);
        ArrayList arrayList = new ArrayList(count / 2);
        if (count != 1) {
            while (true) {
                int i2 = i;
                if (i2 >= count - 1) {
                    break;
                }
                a aVar = new a();
                aVar.gPJ = (AlaLiveInfoData) ListUtils.getItem(this.gPL, i2);
                aVar.gPK = (AlaLiveInfoData) ListUtils.getItem(this.gPL, i2 + 1);
                arrayList.add(aVar);
                i = i2 + 2;
            }
        } else {
            a aVar2 = new a();
            aVar2.gPJ = (AlaLiveInfoData) ListUtils.getItem(this.gPL, 0);
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
                this.gPL = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                        alaLiveInfoData.parserJson(optJSONObject);
                        this.gPL.add(alaLiveInfoData);
                    }
                }
            }
            this.gPM = new c();
            this.gPM.parserJson(jSONObject.optJSONObject("page"));
        }
    }
}
