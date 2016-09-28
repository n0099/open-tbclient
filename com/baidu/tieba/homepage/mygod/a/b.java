package com.baidu.tieba.homepage.mygod.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.mygod.data.b, a> {
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public a a(ViewGroup viewGroup) {
        TextView textView = new TextView(this.mContext);
        textView.setText(r.j.god_acction_notice);
        textView.setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.fontsize28));
        textView.setGravity(17);
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds100)));
        return new a(textView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.mygod.data.b bVar, a aVar) {
        if (aVar.ahV != TbadkCoreApplication.m9getInst().getSkinType()) {
            av.l(aVar.getView(), r.d.cp_bg_line_e);
            av.j(aVar.getView(), r.d.cp_cont_d);
            aVar.ahV = TbadkCoreApplication.m9getInst().getSkinType();
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends y.a {
        public int ahV;

        public a(View view) {
            super(view);
            this.ahV = 3;
        }
    }
}
