package com.baidu.tieba.editortool;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.data.BubbleListData;
/* loaded from: classes.dex */
class h implements aj {
    final /* synthetic */ a a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, Context context) {
        this.a = aVar;
        this.b = context;
    }

    @Override // com.baidu.tieba.editortool.aj
    public View a(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.view.b bVar;
        BubbleListData.BubbleData f;
        BubbleListData bubbleListData;
        View.OnClickListener onClickListener;
        if (view == null) {
            bVar = new com.baidu.tieba.view.b(this.b);
            view = bVar;
        } else {
            bVar = (com.baidu.tieba.view.b) view;
        }
        f = this.a.f(i);
        if (f != null) {
            bubbleListData = this.a.c;
            bVar.a(f, com.baidu.tieba.model.e.a(bubbleListData.getB_info()));
            bVar.setGravity(17);
            bVar.setTag(Integer.valueOf(i));
            onClickListener = this.a.j;
            bVar.setOnClickListener(onClickListener);
        }
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (this.b instanceof BaseActivity) {
            ((BaseActivity) this.b).getLayoutMode().a(skinType == 1);
            ((BaseActivity) this.b).getLayoutMode().a(view);
        } else if (this.b instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.b).c().a(skinType == 1);
            ((BaseFragmentActivity) this.b).c().a(view);
        }
        return view;
    }
}
