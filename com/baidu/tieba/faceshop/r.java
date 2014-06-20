package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import java.util.List;
/* loaded from: classes.dex */
class r implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionManageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z;
        List list;
        x xVar;
        List<v> list2;
        List list3;
        List list4;
        List list5;
        z = this.a.p;
        if (z) {
            list = this.a.a;
            if (list.get(i) != null && (xVar = (x) view.getTag()) != null) {
                Object tag = xVar.a.getTag();
                if (tag instanceof String) {
                    String str = (String) tag;
                    list2 = this.a.a;
                    for (v vVar : list2) {
                        if (vVar.a.equals(str)) {
                            list3 = this.a.b;
                            if (list3.contains(str)) {
                                com.baidu.tbadk.core.util.be.c(xVar.a, com.baidu.tieba.u.btn_expression_choose_n);
                                list4 = this.a.b;
                                list4.remove(str);
                                this.a.b(str);
                                vVar.c = false;
                            } else {
                                com.baidu.tbadk.core.util.be.c(xVar.a, com.baidu.tieba.u.btn_expression_choose_s);
                                this.a.a(str);
                                vVar.c = true;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        EmotionManageActivity emotionManageActivity = this.a;
        list5 = this.a.a;
        this.a.sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.j(emotionManageActivity, ((v) list5.get(i)).a, false, "emotion_manage")));
    }
}
