package com.baidu.tbadk.widget.a.c;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.a.a.a> {
    private int aOJ;

    public b(int i) {
        this.aOJ = i;
    }

    public int getBlockSize() {
        return this.aOJ;
    }

    public void fE(int i) {
        this.aOJ = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Iu */
    public com.baidu.tbadk.widget.a.a.a fI() {
        return new com.baidu.tbadk.widget.a.a.a(this.aOJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public void n(com.baidu.tbadk.widget.a.a.a aVar) {
        if (aVar != null && aVar.getBitmap() != null) {
            aVar.getBitmap().recycle();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public com.baidu.tbadk.widget.a.a.a o(com.baidu.tbadk.widget.a.a.a aVar) {
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public com.baidu.tbadk.widget.a.a.a p(com.baidu.tbadk.widget.a.a.a aVar) {
        return aVar;
    }
}
