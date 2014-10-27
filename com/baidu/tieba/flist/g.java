package com.baidu.tieba.flist;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class g implements e {
    final /* synthetic */ ForumListActivity avP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ForumListActivity forumListActivity) {
        this.avP = forumListActivity;
    }

    @Override // com.baidu.tieba.flist.e
    public void a(boolean z, int i, com.baidu.tieba.square.q qVar, String str, boolean z2) {
        if (!z || i != 0) {
            if (!z2) {
                this.avP.avy.DV();
                return;
            }
            return;
        }
        qVar.bMu.add(0, qVar);
        if (this.avP.avy.awD != null) {
            this.avP.avy.awD.a(qVar);
            this.avP.eW(String.valueOf(this.avP.avy.atA.getText()));
            this.avP.avy.mNavigationBar.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            this.avP.avy.awD.notifyDataSetChanged();
        }
        this.avP.avy.awE.setClickable(true);
        this.avP.avy.awE.setOnClickListener(this.avP);
    }
}
