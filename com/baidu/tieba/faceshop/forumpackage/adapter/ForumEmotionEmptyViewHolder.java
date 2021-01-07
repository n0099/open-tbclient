package com.baidu.tieba.faceshop.forumpackage.adapter;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionEmptyView;
/* loaded from: classes9.dex */
public class ForumEmotionEmptyViewHolder extends TypeAdapter.ViewHolder {
    private ForumEmotionEmptyView iYY;
    private com.baidu.tieba.faceshop.forumpackage.data.a iYZ;
    private TbPageContext pageContext;

    public ForumEmotionEmptyViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.iYY = (ForumEmotionEmptyView) view;
        this.pageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.faceshop.forumpackage.data.a aVar, int i, com.baidu.tieba.faceshop.forumpackage.data.b bVar, a aVar2) {
        this.iYZ = aVar;
        a(bVar, aVar2);
    }

    private void a(final com.baidu.tieba.faceshop.forumpackage.data.b bVar, final a aVar) {
        String string;
        ViewGroup filterDropDownView = this.iYY.getFilterDropDownView();
        if (bVar != null) {
            Resources resources = this.iYY.getResources();
            TextView filterView = this.iYY.getFilterView();
            filterDropDownView.setVisibility(0);
            if (bVar.cCS() == 0) {
                string = resources.getString(R.string.forum_emotion_filter_all_bar);
            } else {
                string = resources.getString(R.string.forum_emotion_filter_my_bar);
            }
            filterView.setText(string);
            if (bVar.isExpanded()) {
                filterDropDownView.setVisibility(0);
            } else {
                filterDropDownView.setVisibility(8);
            }
            filterView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.forumpackage.adapter.ForumEmotionEmptyViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    bVar.setExpanded(!bVar.isExpanded());
                    if (aVar != null) {
                        aVar.cCR();
                    }
                }
            });
            if (filterDropDownView.getChildCount() >= 2) {
                filterDropDownView.getChildAt(0).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.forumpackage.adapter.ForumEmotionEmptyViewHolder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bVar.setExpanded(false);
                        bVar.zB(0);
                        if (aVar != null) {
                            aVar.zA(bVar.cCS());
                        }
                    }
                });
                filterDropDownView.getChildAt(1).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.forumpackage.adapter.ForumEmotionEmptyViewHolder.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bVar.setExpanded(false);
                        bVar.zB(1);
                        if (aVar != null) {
                            aVar.zA(bVar.cCS());
                        }
                    }
                });
            }
        }
    }
}
