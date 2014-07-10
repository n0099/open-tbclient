package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.editortool.AdsEmotionGroupData;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Object data;
        JSONArray optJSONArray;
        if (customResponsedMessage.getCmd() == 2001145 && (data = customResponsedMessage.getData()) != null && (data instanceof JSONObject) && (optJSONArray = ((JSONObject) data).optJSONArray("recmd_face")) != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < optJSONArray.length() && i < 2; i++) {
                try {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    AdsEmotionGroupData adsEmotionGroupData = new AdsEmotionGroupData();
                    adsEmotionGroupData.parseJson(jSONObject);
                    linkedList.add(adsEmotionGroupData);
                } catch (JSONException e) {
                }
            }
            this.a.a(linkedList);
        }
    }
}
