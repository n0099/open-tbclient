package com.baidu.tieba.forumdetail;
/* loaded from: classes.dex */
class a implements d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumDetailActivity f1278a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumDetailActivity forumDetailActivity) {
        this.f1278a = forumDetailActivity;
    }

    @Override // com.baidu.tieba.forumdetail.d
    public void a(ForumDetailData forumDetailData) {
        e eVar;
        eVar = this.f1278a.f1272a;
        eVar.a(forumDetailData);
    }

    @Override // com.baidu.tieba.forumdetail.d
    public void b(ForumDetailData forumDetailData) {
        this.f1278a.showToast(forumDetailData.errorMsg);
    }
}
