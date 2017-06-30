package com.baidu.tieba.enterForum.multiConcern;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b bTY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bTY = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        TextView textView;
        TextView textView2;
        List<g> list;
        TextView textView3;
        MultiConcernModel multiConcernModel;
        MultiConcernModel.a aVar;
        MultiConcernModel multiConcernModel2;
        MultiConcernModel multiConcernModel3;
        MultiConcernModel.a aVar2;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        view2 = this.bTY.bTQ;
        if (view != view2) {
            textView = this.bTY.bTS;
            if (view != textView) {
                textView2 = this.bTY.bTU;
                if (view == textView2) {
                    ArrayList<Long> arrayList = new ArrayList<>();
                    list = this.bTY.forumList;
                    for (g gVar : list) {
                        if (gVar.isSelected) {
                            arrayList.add(Long.valueOf(gVar.forumId));
                        }
                    }
                    if (z.t(arrayList)) {
                        this.bTY.abk();
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                        return;
                    } else if (!k.hA()) {
                        tbPageContext2 = this.bTY.aat;
                        k.showToast(tbPageContext2.getPageActivity(), w.l.neterror);
                        return;
                    } else {
                        textView3 = this.bTY.bTU;
                        textView3.setClickable(false);
                        multiConcernModel = this.bTY.bTW;
                        if (multiConcernModel == null) {
                            b bVar = this.bTY;
                            tbPageContext = this.bTY.aat;
                            bVar.bTW = new MultiConcernModel(tbPageContext);
                        }
                        aVar = this.bTY.bTX;
                        if (aVar == null) {
                            this.bTY.bTX = new d(this);
                            multiConcernModel3 = this.bTY.bTW;
                            aVar2 = this.bTY.bTX;
                            multiConcernModel3.a(aVar2);
                        }
                        multiConcernModel2 = this.bTY.bTW;
                        multiConcernModel2.C(arrayList);
                        return;
                    }
                }
                return;
            }
            this.bTY.abk();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
        }
    }
}
