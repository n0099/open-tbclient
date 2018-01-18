package com.baidu.tbadk.widget.a.c;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.a.a.a> {
    private int bFH;

    public b(int i) {
        this.bFH = i;
    }

    public int getBlockSize() {
        return this.bFH;
    }

    public void iG(int i) {
        this.bFH = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Qe */
    public com.baidu.tbadk.widget.a.a.a nk() {
        return new com.baidu.tbadk.widget.a.a.a(this.bFH);
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
