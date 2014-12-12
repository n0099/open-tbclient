package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AccountActivity alO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AccountActivity accountActivity) {
        this.alO = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        l lVar2;
        TextView textView;
        TextView textView2;
        l lVar3;
        l lVar4;
        TextView textView3;
        TextView textView4;
        l lVar5;
        lVar = this.alO.alJ;
        if (!lVar.Ay()) {
            lVar4 = this.alO.alJ;
            lVar4.setEditState(true);
            textView3 = this.alO.alK;
            textView3.setText(com.baidu.tieba.z.done);
            textView4 = this.alO.alK;
            ax.g(textView4, TbadkCoreApplication.m255getInst().getSkinType());
            lVar5 = this.alO.alJ;
            lVar5.notifyDataSetChanged();
            return;
        }
        lVar2 = this.alO.alJ;
        lVar2.setEditState(false);
        textView = this.alO.alK;
        textView.setText(com.baidu.tieba.z.edit);
        textView2 = this.alO.alK;
        ax.i(textView2, TbadkCoreApplication.m255getInst().getSkinType());
        lVar3 = this.alO.alJ;
        lVar3.notifyDataSetChanged();
    }
}
