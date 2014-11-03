package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import java.util.List;
/* loaded from: classes.dex */
class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionManageActivity asQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EmotionManageActivity emotionManageActivity) {
        this.asQ = emotionManageActivity;
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
        z = this.asQ.asP;
        if (z) {
            list = this.asQ.asD;
            if (list.get(i) != null && (uVar = (u) view.getTag()) != null) {
                Object tag = uVar.asT.getTag();
                if (tag instanceof String) {
                    String str = (String) tag;
                    list2 = this.asQ.asD;
                    for (s sVar : list2) {
                        if (sVar.id.equals(str)) {
                            list3 = this.asQ.asE;
                            if (list3.contains(str)) {
                                com.baidu.tbadk.core.util.aw.c(uVar.asT, by.btn_expression_choose_n);
                                list4 = this.asQ.asE;
                                list4.remove(str);
                                this.asQ.eN(str);
                                sVar.asR = false;
                            } else {
                                com.baidu.tbadk.core.util.aw.c(uVar.asT, by.btn_expression_choose_s);
                                this.asQ.eM(str);
                                sVar.asR = true;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        EmotionManageActivity emotionManageActivity = this.asQ;
        list5 = this.asQ.asD;
        this.asQ.sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(emotionManageActivity, ((s) list5.get(i)).id, false, "emotion_manage")));
    }
}
