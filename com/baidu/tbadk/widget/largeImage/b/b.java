package com.baidu.tbadk.widget.largeImage.b;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.largeImage.a.a> {
    private int bax;

    public b(int i) {
        this.bax = i;
    }

    public int getBlockSize() {
        return this.bax;
    }

    public void fF(int i) {
        this.bax = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: MH */
    public com.baidu.tbadk.widget.largeImage.a.a mo9if() {
        return new com.baidu.tbadk.widget.largeImage.a.a(this.bax);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public void q(com.baidu.tbadk.widget.largeImage.a.a aVar) {
        if (aVar != null && aVar.getBitmap() != null) {
            aVar.getBitmap().recycle();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public com.baidu.tbadk.widget.largeImage.a.a r(com.baidu.tbadk.widget.largeImage.a.a aVar) {
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public com.baidu.tbadk.widget.largeImage.a.a s(com.baidu.tbadk.widget.largeImage.a.a aVar) {
        return aVar;
    }
}
