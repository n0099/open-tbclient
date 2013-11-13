package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tieba.im.b.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1461a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.f1461a = oVar;
    }

    @Override // com.baidu.tieba.im.b.j
    public void a() {
        EnterForumGuideBottomView enterForumGuideBottomView;
        EnterForumGuideBottomView enterForumGuideBottomView2;
        this.f1461a.a(0, 1);
        enterForumGuideBottomView = this.f1461a.s;
        if (enterForumGuideBottomView != null) {
            enterForumGuideBottomView2 = this.f1461a.s;
            if (enterForumGuideBottomView2.getVisibility() == 0) {
                this.f1461a.a(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.b.j
    public void b() {
        EnterForumGuideBottomView enterForumGuideBottomView;
        EnterForumGuideBottomView enterForumGuideBottomView2;
        this.f1461a.a(8, 1);
        enterForumGuideBottomView = this.f1461a.s;
        if (enterForumGuideBottomView != null) {
            enterForumGuideBottomView2 = this.f1461a.s;
            if (enterForumGuideBottomView2.getVisibility() == 0) {
                this.f1461a.a(8);
            }
        }
    }
}
