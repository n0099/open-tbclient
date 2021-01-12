package com.baidu.tieba.ala.guardclub;

import com.baidu.live.tbadk.TbPageContext;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.k.a {
    private com.baidu.tieba.ala.guardclub.view.e gUH;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.gUH = new com.baidu.tieba.ala.guardclub.view.e();
    }

    @Override // com.baidu.live.k.a
    public void l(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        if (bVar != null && bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                if (jSONObject != null && "guard_pk_win_tip".equals(jSONObject.optString("content_type"))) {
                    dL(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    private void dL(JSONObject jSONObject) {
        String optString;
        String optString2;
        if (this.gUH != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
            if (optJSONObject != null) {
                optString = optJSONObject.optString("tips1");
                optString2 = optJSONObject.optString("tips2");
            } else {
                optString = jSONObject.optString("tips1");
                optString2 = jSONObject.optString("tips2");
            }
            this.gUH.v(this.mTbPageContext.getPageActivity(), optString, optString2);
        }
    }
}
