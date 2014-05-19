package com.baidu.tieba.im.chat;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class da extends com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ TbImageView a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(TbImageView tbImageView, String str) {
        this.a = tbImageView;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.adp.widget.a.a aVar, String str) {
        super.a((da) aVar, str);
        this.a.a(this.b, 10, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(Object... objArr) {
        super.a(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(String str) {
        super.a(str);
    }
}
