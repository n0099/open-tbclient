package com.baidu.tieba.hottopic.view;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ HotTopicPkView bJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HotTopicPkView hotTopicPkView) {
        this.bJG = hotTopicPkView;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < 4; i++) {
            this.bJG.postInvalidate();
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
            }
        }
        this.bJG.bJE = false;
        this.bJG.postInvalidate();
    }
}
