package com.baidu.tieba.editortool;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.BubbleListData;
/* loaded from: classes.dex */
class f implements ah {
    final /* synthetic */ a a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, Context context) {
        this.a = aVar;
        this.b = context;
    }

    @Override // com.baidu.tieba.editortool.ah
    public View a(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.view.a aVar;
        BubbleListData.BubbleData e;
        View.OnClickListener onClickListener;
        if (view == null) {
            aVar = new com.baidu.tieba.view.a(this.b);
            view = aVar;
        } else {
            aVar = (com.baidu.tieba.view.a) view;
        }
        e = this.a.e(i);
        if (e != null) {
            aVar.a(e, this.a.c, com.baidu.tieba.model.f.a(this.a.b.getB_info()));
            aVar.setGravity(17);
            aVar.setTag(Integer.valueOf(i));
            onClickListener = this.a.k;
            aVar.setOnClickListener(onClickListener);
        }
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (this.b instanceof BaseActivity) {
            ((BaseActivity) this.b).getLayoutMode().a(skinType == 1);
            ((BaseActivity) this.b).getLayoutMode().a(view);
        } else if (this.b instanceof com.baidu.tbadk.core.e) {
            ((com.baidu.tbadk.core.e) this.b).a().a(skinType == 1);
            ((com.baidu.tbadk.core.e) this.b).a().a(view);
        }
        return view;
    }
}
