package com.baidu.tbadk.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbImageView tbImageView) {
        this.a = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.adp.widget.a.a aVar, String str) {
        l lVar;
        l lVar2;
        this.a.e();
        lVar = this.a.d;
        if (lVar != null) {
            lVar2 = this.a.d;
            lVar2.a(aVar != null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(Object... objArr) {
        super.a(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(String str) {
        l lVar;
        l lVar2;
        super.a(str);
        this.a.e();
        lVar = this.a.d;
        if (lVar != null) {
            lVar2 = this.a.d;
            lVar2.a();
        }
    }
}
