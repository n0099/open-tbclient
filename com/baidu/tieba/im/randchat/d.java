package com.baidu.tieba.im.randchat;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.widget.l {
    final /* synthetic */ RingLayoutView a;
    private final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(RingLayoutView ringLayoutView, e eVar) {
        this.a = ringLayoutView;
        this.b = eVar;
    }

    @Override // com.baidu.tbadk.widget.l
    public void a(String str, boolean z) {
        if (this.b != null) {
            this.b.a(str);
        }
    }

    @Override // com.baidu.tbadk.widget.l
    public void a() {
    }
}
