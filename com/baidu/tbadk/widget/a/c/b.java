package com.baidu.tbadk.widget.a.c;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.a.a.a> {
    private int aRG;

    public b(int i) {
        this.aRG = i;
    }

    public int getBlockSize() {
        return this.aRG;
    }

    public void fL(int i) {
        this.aRG = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: IR */
    public com.baidu.tbadk.widget.a.a.a fI() {
        return new com.baidu.tbadk.widget.a.a.a(this.aRG);
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
