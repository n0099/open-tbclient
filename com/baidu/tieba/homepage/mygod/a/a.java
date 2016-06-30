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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.mygod.data.a, C0059a> {
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: af */
    public C0059a a(ViewGroup viewGroup) {
        TextView textView = new TextView(this.mContext);
        textView.setText(u.j.god_acction_notice);
        textView.setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.fontsize28));
        textView.setGravity(17);
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds100)));
        return new C0059a(textView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.mygod.data.a aVar, C0059a c0059a) {
        if (c0059a.aeK != TbadkCoreApplication.m9getInst().getSkinType()) {
            av.l(c0059a.getView(), u.d.cp_bg_line_e);
            av.j(c0059a.getView(), u.d.cp_cont_d);
            c0059a.aeK = TbadkCoreApplication.m9getInst().getSkinType();
        }
        return c0059a.getView();
    }

    /* renamed from: com.baidu.tieba.homepage.mygod.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0059a extends y.a {
        public int aeK;

        public C0059a(View view) {
            super(view);
            this.aeK = 3;
        }
    }
}
