package com.baidu.tbadk.widget.largeImage.b;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.largeImage.a.a> {
    private int bbz;

    public b(int i) {
        this.bbz = i;
    }

    public int getBlockSize() {
        return this.bbz;
    }

    public void fH(int i) {
        this.bbz = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: MV */
    public com.baidu.tbadk.widget.largeImage.a.a ig() {
        return new com.baidu.tbadk.widget.largeImage.a.a(this.bbz);
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
