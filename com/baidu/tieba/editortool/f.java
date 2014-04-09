package com.baidu.tieba.editortool;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.BubbleListData;
/* loaded from: classes.dex */
final class f implements ah {
    final /* synthetic */ a a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, Context context) {
        this.a = aVar;
        this.b = context;
    }

    @Override // com.baidu.tieba.editortool.ah
    public final View a(int i, View view) {
        com.baidu.tieba.view.a aVar;
        View.OnClickListener onClickListener;
        if (view == null) {
            aVar = new com.baidu.tieba.view.a(this.b);
            view = aVar;
        } else {
            aVar = (com.baidu.tieba.view.a) view;
        }
        BubbleListData.BubbleData a = a.a(this.a, i);
        if (a != null) {
            aVar.a(a, this.a.c, com.baidu.tieba.model.f.a(this.a.b.getB_info()));
            aVar.setGravity(17);
            aVar.setTag(Integer.valueOf(i));
            onClickListener = this.a.k;
            aVar.setOnClickListener(onClickListener);
        }
        int l = TbadkApplication.j().l();
        if (this.b instanceof com.baidu.tbadk.a) {
            ((com.baidu.tbadk.a) this.b).getLayoutMode().a(l == 1);
            ((com.baidu.tbadk.a) this.b).getLayoutMode().a(view);
        } else if (this.b instanceof com.baidu.tbadk.core.e) {
            ((com.baidu.tbadk.core.e) this.b).b().a(l == 1);
            ((com.baidu.tbadk.core.e) this.b).b().a(view);
        }
        return view;
    }
}
