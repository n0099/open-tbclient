package com.baidu.tieba.hottopic.view;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ HotTopicPkView bFZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HotTopicPkView hotTopicPkView) {
        this.bFZ = hotTopicPkView;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < 4; i++) {
            this.bFZ.postInvalidate();
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
            }
        }
        this.bFZ.bFX = false;
        this.bFZ.postInvalidate();
    }
}
