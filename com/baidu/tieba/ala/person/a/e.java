package com.baidu.tieba.ala.person.a;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public List<AlaLiveInfoData> gxH;
    public c gxI;

    public List bLf() {
        int i = 0;
        if (ListUtils.isEmpty(this.gxH)) {
            return null;
        }
        int count = ListUtils.getCount(this.gxH);
        ArrayList arrayList = new ArrayList(count / 2);
        if (count != 1) {
            while (true) {
                int i2 = i;
                if (i2 >= count - 1) {
                    break;
                }
                a aVar = new a();
                aVar.gxF = (AlaLiveInfoData) ListUtils.getItem(this.gxH, i2);
                aVar.gxG = (AlaLiveInfoData) ListUtils.getItem(this.gxH, i2 + 1);
                arrayList.add(aVar);
                i = i2 + 2;
            }
        } else {
            a aVar2 = new a();
            aVar2.gxF = (AlaLiveInfoData) ListUtils.getItem(this.gxH, 0);
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
                this.gxH = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                        alaLiveInfoData.parserJson(optJSONObject);
                        this.gxH.add(alaLiveInfoData);
                    }
                }
            }
            this.gxI = new c();
            this.gxI.parserJson(jSONObject.optJSONObject("page"));
        }
    }
}
