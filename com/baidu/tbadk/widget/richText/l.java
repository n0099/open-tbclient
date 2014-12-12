package com.baidu.tbadk.widget.richText;
/* loaded from: classes.dex */
class l extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbRichTextView aki;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbRichTextView tbRichTextView) {
        this.aki = tbRichTextView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.aki.d(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onCancelled(String str) {
        super.onCancelled(str);
    }
}
