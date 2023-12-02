package com.baidu.tieba;
/* loaded from: classes5.dex */
public interface ecb {

    /* loaded from: classes5.dex */
    public interface a {
        void a(float f);

        float getSpeed();

        void onFinish();

        void onProgress(float f);
    }

    void a();

    boolean b();

    int getMaxDuration();

    float getProgress();

    int getSlideNum();

    void invalidate();

    void reset();

    void setMaxDuration(int i);

    void setMinDuration(int i);

    void setOnProgressListener(a aVar);

    void setProgress(long j);

    void setShowDeleteLastTip(boolean z);

    void setVisibility(int i);

    void start();

    void stop();
}
