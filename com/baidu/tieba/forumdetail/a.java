package com.baidu.tieba.forumdetail;
/* loaded from: classes.dex */
class a implements d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumDetailActivity f1273a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumDetailActivity forumDetailActivity) {
        this.f1273a = forumDetailActivity;
    }

    @Override // com.baidu.tieba.forumdetail.d
    public void a(ForumDetailData forumDetailData) {
        e eVar;
        eVar = this.f1273a.f1267a;
        eVar.a(forumDetailData);
    }

    @Override // com.baidu.tieba.forumdetail.d
    public void b(ForumDetailData forumDetailData) {
        this.f1273a.showToast(forumDetailData.errorMsg);
    }
}
