package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.AdapterView;
import java.util.List;
/* loaded from: classes.dex */
final class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionManageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z;
        List list;
        u uVar;
        List list2;
        List<s> list3;
        List list4;
        List list5;
        List list6;
        z = this.a.p;
        if (z) {
            list = this.a.a;
            if (list.get(i) != null && (uVar = (u) view.getTag()) != null) {
                list2 = this.a.a;
                String str = ((s) list2.get(i)).a;
                if (str != null) {
                    list3 = this.a.a;
                    for (s sVar : list3) {
                        if (sVar.a.equals(str)) {
                            list4 = this.a.b;
                            if (list4.contains(str)) {
                                com.baidu.tbadk.core.util.ba.c(uVar.a, com.baidu.tieba.a.g.btn_expression_choose_n);
                                list5 = this.a.b;
                                list5.remove(str);
                                EmotionManageActivity.a(this.a, str);
                                sVar.c = false;
                            } else {
                                com.baidu.tbadk.core.util.ba.c(uVar.a, com.baidu.tieba.a.g.btn_expression_choose_s);
                                EmotionManageActivity.b(this.a, str);
                                sVar.c = true;
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
        list6 = this.a.a;
        this.a.sendMessage(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.i(emotionManageActivity, ((s) list6.get(i)).a, false, "emotion_manage")));
    }
}
