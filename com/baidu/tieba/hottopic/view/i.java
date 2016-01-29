package com.baidu.tieba.hottopic.view;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ HotTopicPkView bNn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(HotTopicPkView hotTopicPkView) {
        this.bNn = hotTopicPkView;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < 4; i++) {
            this.bNn.postInvalidate();
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
            }
        }
        this.bNn.bNl = false;
        this.bNn.postInvalidate();
    }
}
