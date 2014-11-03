package com.baidu.tieba.flist;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.flist.ForumListModel;
import com.baidu.tieba.model.ag;
/* loaded from: classes.dex */
class f implements s {
    final /* synthetic */ ForumListActivity avY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ForumListActivity forumListActivity) {
        this.avY = forumListActivity;
    }

    @Override // com.baidu.tieba.flist.s
    public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        int i2;
        ForumListModel.RequestParams requestParams3;
        int i3;
        boolean z3;
        ForumListModel.RequestParams requestParams4;
        int i4;
        p pVar;
        p pVar2;
        ag agVar;
        p pVar3;
        p pVar4;
        p pVar5;
        ag agVar2;
        p pVar6;
        Drawable drawable;
        Drawable drawable2;
        p pVar7;
        ForumListModel.RequestParams requestParams5;
        if (!z) {
            pVar7 = this.avY.avL;
            if (pVar7.DR() == null) {
                this.avY.showToast(str);
                this.avY.avH.DX();
                this.avY.avH.DW();
                requestParams5 = this.avY.avI;
                if (requestParams5.menu_type == 2 && !z2) {
                    this.avY.finish();
                }
                this.avY.avH.mProgressBar.setVisibility(8);
                return;
            }
        }
        if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
            requestParams = this.avY.avI;
            if (requestParams.menu_type == 2 && !z2) {
                this.avY.showToast(this.avY.getString(com.baidu.tieba.y.no_forum_data));
                this.avY.finish();
            } else {
                this.avY.showToast(str);
                this.avY.avH.DW();
                requestParams2 = this.avY.avI;
                i2 = this.avY.avD;
                requestParams2.recommend_type = i2;
                requestParams3 = this.avY.avI;
                i3 = this.avY.avE;
                requestParams3.rn = i3;
            }
            this.avY.avH.mProgressBar.setVisibility(8);
            return;
        }
        this.avY.avH.mProgressBar.setVisibility(8);
        z3 = this.avY.avC;
        if (z3) {
            this.avY.avH.awB.setText(this.avY.getString(com.baidu.tieba.y.flist_expand_list));
            ImageView imageView = this.avY.avH.awC;
            drawable = this.avY.avv;
            imageView.setImageDrawable(drawable);
            this.avY.avH.awE.setText(this.avY.getString(com.baidu.tieba.y.flist_expand_list));
            ImageView imageView2 = this.avY.avH.awF;
            drawable2 = this.avY.avv;
            imageView2.setImageDrawable(drawable2);
            this.avY.avC = false;
        }
        TextView textView = this.avY.avH.atJ;
        requestParams4 = this.avY.avI;
        textView.setText(requestParams4.menu_name);
        this.avY.avH.mNavigationBar.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
        a aVar = this.avY.avH.awM;
        i4 = this.avY.menu_choose;
        aVar.ez(i4);
        int min = Math.min(forumListModel.recommend_list_left.forum_list.length, this.avY.recommend_list_left.forum_list.length);
        int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, this.avY.recommend_list_right.forum_list.length);
        System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.avY.recommend_list_left.forum_list, 0, min);
        System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.avY.recommend_list_right.forum_list, 0, min2);
        pVar = this.avY.avL;
        pVar.eA(min);
        pVar2 = this.avY.avL;
        agVar = this.avY.avA;
        pVar2.a(agVar);
        pVar3 = this.avY.avL;
        pVar3.a(this.avY.recommend_list_left.forum_list);
        this.avY.avH.aww.setSelection(1);
        if (forumListModel.recommend_list_left.has_more == 1) {
            this.avY.avH.aws.setVisibility(0);
        } else {
            this.avY.avH.aws.setVisibility(8);
        }
        this.avY.avH.awy.setText(forumListModel.forum_class[0]);
        pVar4 = this.avY.avM;
        pVar4.eA(min2);
        pVar5 = this.avY.avM;
        agVar2 = this.avY.avA;
        pVar5.a(agVar2);
        pVar6 = this.avY.avM;
        pVar6.a(this.avY.recommend_list_right.forum_list);
        this.avY.avH.awx.setSelection(1);
        if (forumListModel.recommend_list_right.has_more == 1) {
            this.avY.avH.awt.setVisibility(0);
        } else {
            this.avY.avH.awt.setVisibility(8);
        }
        this.avY.avH.awz.setText(forumListModel.forum_class[1]);
        this.avY.findViewById(com.baidu.tieba.v.item_root).setVisibility(0);
        this.avY.avH.DW();
        if (this.avY.avH.awM.getCount() > 0) {
            this.avY.avH.awN.setClickable(true);
            this.avY.avH.awN.setOnClickListener(this.avY);
        }
    }
}
