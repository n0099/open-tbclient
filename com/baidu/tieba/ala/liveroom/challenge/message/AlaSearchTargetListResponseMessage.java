package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.challenge.b;
import com.baidu.live.challenge.d;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaSearchTargetListResponseMessage extends JsonHttpResponsedMessage {
    private b fNE;
    private List<d> fNF;

    public AlaSearchTargetListResponseMessage() {
        super(1021182);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("page");
            if (optJSONObject2 != null) {
                this.fNE = new b();
                this.fNE.parseJson(optJSONObject2);
            }
            String optString = optJSONObject.optString("query_words");
            JSONArray optJSONArray = optJSONObject.optJSONArray("user_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.fNF = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    d dVar = new d();
                    dVar.parseJson(optJSONArray.optJSONObject(i2));
                    dVar.userName = dF(optString, dVar.userName);
                    this.fNF.add(dVar);
                }
            }
        }
    }

    private static String dF(String str, String str2) {
        Matcher matcher = Pattern.compile(str, 2).matcher(str2);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "<font color='#FF5460'>" + matcher.group() + "</font>");
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public b bzR() {
        return this.fNE;
    }

    public List<d> bzS() {
        return this.fNF;
    }
}
