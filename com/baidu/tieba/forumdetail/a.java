package com.baidu.tieba.forumdetail;
/* loaded from: classes.dex */
class a implements d {
    final /* synthetic */ ForumDetailActivity awV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumDetailActivity forumDetailActivity) {
        this.awV = forumDetailActivity;
    }

    @Override // com.baidu.tieba.forumdetail.d
    public void a(ForumDetailData forumDetailData) {
        e eVar;
        eVar = this.awV.awS;
        eVar.d(forumDetailData);
    }

    @Override // com.baidu.tieba.forumdetail.d
    public void b(ForumDetailData forumDetailData) {
        this.awV.showToast(forumDetailData.errmsg);
    }
}
