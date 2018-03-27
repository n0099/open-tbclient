package com.baidu.tbadk.widget.a.c;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.a.a.a> {
    private int bHJ;

    public b(int i) {
        this.bHJ = i;
    }

    public int getBlockSize() {
        return this.bHJ;
    }

    public void iD(int i) {
        this.bHJ = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: QL */
    public com.baidu.tbadk.widget.a.a.a nl() {
        return new com.baidu.tbadk.widget.a.a.a(this.bHJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public void as(com.baidu.tbadk.widget.a.a.a aVar) {
        if (aVar != null && aVar.getBitmap() != null) {
            aVar.getBitmap().recycle();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public com.baidu.tbadk.widget.a.a.a at(com.baidu.tbadk.widget.a.a.a aVar) {
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public com.baidu.tbadk.widget.a.a.a au(com.baidu.tbadk.widget.a.a.a aVar) {
        return aVar;
    }
}
