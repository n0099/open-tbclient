package com.baidu.tieba.forumdetail;
/* loaded from: classes.dex */
class a implements d {
    final /* synthetic */ ForumDetailActivity axe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumDetailActivity forumDetailActivity) {
        this.axe = forumDetailActivity;
    }

    @Override // com.baidu.tieba.forumdetail.d
    public void a(ForumDetailData forumDetailData) {
        e eVar;
        eVar = this.axe.axb;
        eVar.d(forumDetailData);
    }

    @Override // com.baidu.tieba.forumdetail.d
    public void b(ForumDetailData forumDetailData) {
        this.axe.showToast(forumDetailData.errmsg);
    }
}
