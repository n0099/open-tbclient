package com.baidu.tbadk.widget.largeImage.b;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.largeImage.a.a> {
    private int bjk;

    public b(int i) {
        this.bjk = i;
    }

    public int getBlockSize() {
        return this.bjk;
    }

    public void gb(int i) {
        this.bjk = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Qn */
    public com.baidu.tbadk.widget.largeImage.a.a jB() {
        return new com.baidu.tbadk.widget.largeImage.a.a(this.bjk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public void u(com.baidu.tbadk.widget.largeImage.a.a aVar) {
        if (aVar != null && aVar.getBitmap() != null) {
            aVar.getBitmap().recycle();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public com.baidu.tbadk.widget.largeImage.a.a v(com.baidu.tbadk.widget.largeImage.a.a aVar) {
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public com.baidu.tbadk.widget.largeImage.a.a w(com.baidu.tbadk.widget.largeImage.a.a aVar) {
        return aVar;
    }
}
