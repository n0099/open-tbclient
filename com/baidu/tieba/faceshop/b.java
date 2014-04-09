package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.editortool.AdsEmotionGroupData;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class b extends com.baidu.adp.framework.c.a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(2001145);
        this.a = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        Object a;
        JSONArray optJSONArray;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2.g() != 2001145 || (a = customResponsedMessage2.a()) == null || !(a instanceof JSONObject) || (optJSONArray = ((JSONObject) a).optJSONArray("recmd_face")) == null) {
            return;
        }
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
