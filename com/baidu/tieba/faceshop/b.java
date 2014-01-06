package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.util.bl;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionManageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z;
        List list;
        g gVar;
        List list2;
        List<e> list3;
        List list4;
        List list5;
        List list6;
        z = this.a.p;
        if (z) {
            list = this.a.a;
            if (list.get(i) != null && (gVar = (g) view.getTag()) != null) {
                list2 = this.a.a;
                String str = ((e) list2.get(i)).a;
                if (str != null) {
                    list3 = this.a.a;
                    for (e eVar : list3) {
                        if (eVar.a.equals(str)) {
                            list4 = this.a.b;
                            if (list4.contains(str)) {
                                bl.d(gVar.a, (int) R.drawable.btn_expression_choose_n);
                                list5 = this.a.b;
                                list5.remove(str);
                                this.a.b(str);
                                eVar.c = false;
                            } else {
                                bl.d(gVar.a, (int) R.drawable.btn_expression_choose_s);
                                this.a.a(str);
                                eVar.c = true;
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
        FacePackageDetailActivity.a(emotionManageActivity, ((e) list6.get(i)).a, false, "emotion_manage");
    }
}
