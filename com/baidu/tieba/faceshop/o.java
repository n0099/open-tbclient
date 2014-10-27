package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import java.util.List;
/* loaded from: classes.dex */
class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionManageActivity asH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EmotionManageActivity emotionManageActivity) {
        this.asH = emotionManageActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z;
        List list;
        u uVar;
        List<s> list2;
        List list3;
        List list4;
        List list5;
        z = this.asH.asG;
        if (z) {
            list = this.asH.asu;
            if (list.get(i) != null && (uVar = (u) view.getTag()) != null) {
                Object tag = uVar.asK.getTag();
                if (tag instanceof String) {
                    String str = (String) tag;
                    list2 = this.asH.asu;
                    for (s sVar : list2) {
                        if (sVar.id.equals(str)) {
                            list3 = this.asH.asv;
                            if (list3.contains(str)) {
                                com.baidu.tbadk.core.util.aw.c(uVar.asK, by.btn_expression_choose_n);
                                list4 = this.asH.asv;
                                list4.remove(str);
                                this.asH.eN(str);
                                sVar.asI = false;
                            } else {
                                com.baidu.tbadk.core.util.aw.c(uVar.asK, by.btn_expression_choose_s);
                                this.asH.eM(str);
                                sVar.asI = true;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        EmotionManageActivity emotionManageActivity = this.asH;
        list5 = this.asH.asu;
        this.asH.sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(emotionManageActivity, ((s) list5.get(i)).id, false, "emotion_manage")));
    }
}
