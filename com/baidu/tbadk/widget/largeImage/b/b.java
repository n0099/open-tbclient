package com.baidu.tbadk.widget.largeImage.b;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.largeImage.a.a> {
    private int cJo;

    public b(int i) {
        this.cJo = i;
    }

    public int qf() {
        return this.cJo;
    }

    public void lr(int i) {
        this.cJo = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: ayy */
    public com.baidu.tbadk.widget.largeImage.a.a makeObject() {
        return new com.baidu.tbadk.widget.largeImage.a.a(this.cJo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public void destroyObject(com.baidu.tbadk.widget.largeImage.a.a aVar) {
        if (aVar != null && aVar.getBitmap() != null) {
            aVar.getBitmap().recycle();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public com.baidu.tbadk.widget.largeImage.a.a activateObject(com.baidu.tbadk.widget.largeImage.a.a aVar) {
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public com.baidu.tbadk.widget.largeImage.a.a passivateObject(com.baidu.tbadk.widget.largeImage.a.a aVar) {
        return aVar;
    }
}
