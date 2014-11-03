package com.baidu.tieba.flist;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class g implements e {
    final /* synthetic */ ForumListActivity avY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ForumListActivity forumListActivity) {
        this.avY = forumListActivity;
    }

    @Override // com.baidu.tieba.flist.e
    public void a(boolean z, int i, com.baidu.tieba.square.q qVar, String str, boolean z2) {
        if (!z || i != 0) {
            if (!z2) {
                this.avY.avH.DX();
                return;
            }
            return;
        }
        qVar.bMJ.add(0, qVar);
        if (this.avY.avH.awM != null) {
            this.avY.avH.awM.a(qVar);
            this.avY.eW(String.valueOf(this.avY.avH.atJ.getText()));
            this.avY.avH.mNavigationBar.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            this.avY.avH.awM.notifyDataSetChanged();
        }
        this.avY.avH.awN.setClickable(true);
        this.avY.avH.awN.setOnClickListener(this.avY);
    }
}
