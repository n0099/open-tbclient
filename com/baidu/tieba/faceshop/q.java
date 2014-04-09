package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.AdapterView;
import java.util.List;
/* loaded from: classes.dex */
final class q implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionManageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z;
        List list;
        w wVar;
        List<u> list2;
        List list3;
        List list4;
        List list5;
        z = this.a.p;
        if (z) {
            list = this.a.a;
            if (list.get(i) != null && (wVar = (w) view.getTag()) != null) {
                Object tag = wVar.a.getTag();
                if (tag instanceof String) {
                    String str = (String) tag;
                    list2 = this.a.a;
                    for (u uVar : list2) {
                        if (uVar.a.equals(str)) {
                            list3 = this.a.b;
                            if (list3.contains(str)) {
                                com.baidu.tbadk.core.util.ba.c(wVar.a, com.baidu.tieba.a.g.btn_expression_choose_n);
                                list4 = this.a.b;
                                list4.remove(str);
                                EmotionManageActivity.a(this.a, str);
                                uVar.c = false;
                            } else {
                                com.baidu.tbadk.core.util.ba.c(wVar.a, com.baidu.tieba.a.g.btn_expression_choose_s);
                                EmotionManageActivity.b(this.a, str);
                                uVar.c = true;
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
        this.a.sendMessage(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.i(emotionManageActivity, ((u) list5.get(i)).a, false, "emotion_manage")));
    }
}
