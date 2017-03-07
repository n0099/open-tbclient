package com.baidu.tbadk.widget.richText;
/* loaded from: classes.dex */
class j extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbRichTextView aNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TbRichTextView tbRichTextView) {
        this.aNV = tbRichTextView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.aNV.e(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onCancelled(String str) {
        super.onCancelled(str);
    }
}
