package com.baidu.tieba.editortool;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.data.BubbleListData;
/* loaded from: classes.dex */
class h implements ao {
    final /* synthetic */ a aql;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, Context context) {
        this.aql = aVar;
        this.val$context = context;
    }

    @Override // com.baidu.tieba.editortool.ao
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.view.b bVar;
        BubbleListData.BubbleData dW;
        BubbleListData bubbleListData;
        View.OnClickListener onClickListener;
        if (view == null) {
            bVar = new com.baidu.tieba.view.b(this.val$context);
            view = bVar;
        } else {
            bVar = (com.baidu.tieba.view.b) view;
        }
        dW = this.aql.dW(i);
        if (dW != null) {
            bubbleListData = this.aql.aqg;
            bVar.a(dW, com.baidu.tieba.model.e.ag(bubbleListData.getB_info()));
            bVar.setGravity(17);
            bVar.setTag(Integer.valueOf(i));
            onClickListener = this.aql.aqk;
            bVar.setOnClickListener(onClickListener);
        }
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (this.val$context instanceof BaseActivity) {
            ((BaseActivity) this.val$context).getLayoutMode().L(skinType == 1);
            ((BaseActivity) this.val$context).getLayoutMode().h(view);
        } else if (this.val$context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.val$context).getLayoutMode().L(skinType == 1);
            ((BaseFragmentActivity) this.val$context).getLayoutMode().h(view);
        }
        return view;
    }
}
