package com.baidu.tieba.forumdetail;
/* loaded from: classes.dex */
final class a implements d {
    final /* synthetic */ ForumDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumDetailActivity forumDetailActivity) {
        this.a = forumDetailActivity;
    }

    @Override // com.baidu.tieba.forumdetail.d
    public final void a(ForumDetailData forumDetailData) {
        e eVar;
        eVar = this.a.a;
        eVar.a(forumDetailData);
    }

    @Override // com.baidu.tieba.forumdetail.d
    public final void b(ForumDetailData forumDetailData) {
        this.a.showToast(forumDetailData.errorMsg);
    }
}
