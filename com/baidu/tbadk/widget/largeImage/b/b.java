package com.baidu.tbadk.widget.largeImage.b;
/* loaded from: classes2.dex */
public class b implements com.baidu.adp.lib.d.c<com.baidu.tbadk.widget.largeImage.a.a> {
    private int mBlockSize;

    public b(int i) {
        this.mBlockSize = i;
    }

    public int getBlockSize() {
        return this.mBlockSize;
    }

    public void setBlockSize(int i) {
        this.mBlockSize = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: bwX */
    public com.baidu.tbadk.widget.largeImage.a.a makeObject() {
        return new com.baidu.tbadk.widget.largeImage.a.a(this.mBlockSize);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public void destroyObject(com.baidu.tbadk.widget.largeImage.a.a aVar) {
        if (aVar != null && aVar.getBitmap() != null) {
            aVar.getBitmap().recycle();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: c */
    public com.baidu.tbadk.widget.largeImage.a.a activateObject(com.baidu.tbadk.widget.largeImage.a.a aVar) {
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: d */
    public com.baidu.tbadk.widget.largeImage.a.a passivateObject(com.baidu.tbadk.widget.largeImage.a.a aVar) {
        return aVar;
    }
}
