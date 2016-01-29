package com.baidu.tieba.hottopic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.h, com.baidu.tieba.hottopic.b.f> {
    private HotTopicActivity bJD;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bJD = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.hottopic.b.f b(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.f(LayoutInflater.from(this.mContext).inflate(t.h.hot_topic_pk_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.h hVar, com.baidu.tieba.hottopic.b.f fVar) {
        if (hVar != null && fVar != null) {
            a(fVar, view);
            a(fVar, hVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.hottopic.b.f fVar, View view) {
        if (fVar != null) {
            this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (this.bJD != null && fVar.ahU != this.mSkinType) {
                fVar.ahU = this.mSkinType;
                ar.l(fVar.getView(), t.d.cp_bg_line_d);
                this.bJD.getLayoutMode().ac(this.mSkinType == 1);
                this.bJD.getLayoutMode().x(view);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.b.f fVar, com.baidu.tieba.hottopic.data.h hVar) {
        if (fVar != null && hVar != null) {
            fVar.bMk.setText(StringUtils.isNull(hVar.bKA) ? this.bJD.getResources().getString(t.j.pk_topic_default) : hVar.bKA.trim());
            fVar.bMl.setText(aw.d(hVar.bKB.trim(), 32, "..."));
            fVar.bMl.setText(hVar.bKB.trim());
            fVar.bMm.a(hVar, this.bJD);
            fVar.bMn.setText(hVar.bLj.trim());
            fVar.bMo.setText(hVar.bLm.trim());
        }
    }
}
