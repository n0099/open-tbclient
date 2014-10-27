package com.baidu.tieba.flist;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.flist.ForumListModel;
import com.baidu.tieba.model.ag;
/* loaded from: classes.dex */
class f implements s {
    final /* synthetic */ ForumListActivity avP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ForumListActivity forumListActivity) {
        this.avP = forumListActivity;
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
            pVar7 = this.avP.avC;
            if (pVar7.DP() == null) {
                this.avP.showToast(str);
                this.avP.avy.DV();
                this.avP.avy.DU();
                requestParams5 = this.avP.avz;
                if (requestParams5.menu_type == 2 && !z2) {
                    this.avP.finish();
                }
                this.avP.avy.mProgressBar.setVisibility(8);
                return;
            }
        }
        if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
            requestParams = this.avP.avz;
            if (requestParams.menu_type == 2 && !z2) {
                this.avP.showToast(this.avP.getString(com.baidu.tieba.y.no_forum_data));
                this.avP.finish();
            } else {
                this.avP.showToast(str);
                this.avP.avy.DU();
                requestParams2 = this.avP.avz;
                i2 = this.avP.avu;
                requestParams2.recommend_type = i2;
                requestParams3 = this.avP.avz;
                i3 = this.avP.avv;
                requestParams3.rn = i3;
            }
            this.avP.avy.mProgressBar.setVisibility(8);
            return;
        }
        this.avP.avy.mProgressBar.setVisibility(8);
        z3 = this.avP.avt;
        if (z3) {
            this.avP.avy.aws.setText(this.avP.getString(com.baidu.tieba.y.flist_expand_list));
            ImageView imageView = this.avP.avy.awt;
            drawable = this.avP.avm;
            imageView.setImageDrawable(drawable);
            this.avP.avy.awv.setText(this.avP.getString(com.baidu.tieba.y.flist_expand_list));
            ImageView imageView2 = this.avP.avy.aww;
            drawable2 = this.avP.avm;
            imageView2.setImageDrawable(drawable2);
            this.avP.avt = false;
        }
        TextView textView = this.avP.avy.atA;
        requestParams4 = this.avP.avz;
        textView.setText(requestParams4.menu_name);
        this.avP.avy.mNavigationBar.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
        a aVar = this.avP.avy.awD;
        i4 = this.avP.menu_choose;
        aVar.ez(i4);
        int min = Math.min(forumListModel.recommend_list_left.forum_list.length, this.avP.recommend_list_left.forum_list.length);
        int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, this.avP.recommend_list_right.forum_list.length);
        System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.avP.recommend_list_left.forum_list, 0, min);
        System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.avP.recommend_list_right.forum_list, 0, min2);
        pVar = this.avP.avC;
        pVar.eA(min);
        pVar2 = this.avP.avC;
        agVar = this.avP.avr;
        pVar2.a(agVar);
        pVar3 = this.avP.avC;
        pVar3.a(this.avP.recommend_list_left.forum_list);
        this.avP.avy.awn.setSelection(1);
        if (forumListModel.recommend_list_left.has_more == 1) {
            this.avP.avy.awj.setVisibility(0);
        } else {
            this.avP.avy.awj.setVisibility(8);
        }
        this.avP.avy.awp.setText(forumListModel.forum_class[0]);
        pVar4 = this.avP.avD;
        pVar4.eA(min2);
        pVar5 = this.avP.avD;
        agVar2 = this.avP.avr;
        pVar5.a(agVar2);
        pVar6 = this.avP.avD;
        pVar6.a(this.avP.recommend_list_right.forum_list);
        this.avP.avy.awo.setSelection(1);
        if (forumListModel.recommend_list_right.has_more == 1) {
            this.avP.avy.awk.setVisibility(0);
        } else {
            this.avP.avy.awk.setVisibility(8);
        }
        this.avP.avy.awq.setText(forumListModel.forum_class[1]);
        this.avP.findViewById(com.baidu.tieba.v.item_root).setVisibility(0);
        this.avP.avy.DU();
        if (this.avP.avy.awD.getCount() > 0) {
            this.avP.avy.awE.setClickable(true);
            this.avP.avy.awE.setOnClickListener(this.avP);
        }
    }
}
