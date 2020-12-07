package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class TopicVideoProgressView extends RelativeLayout {
    private boolean bbP;
    private int gaB;
    private MediaController.MediaPlayerControl gaC;
    private View iDw;
    private Handler mHandler;

    public TopicVideoProgressView(Context context) {
        super(context);
        this.gaB = 50;
        this.bbP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bbP && TopicVideoProgressView.this.gaC != null && TopicVideoProgressView.this.gaC.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.gaB - (TopicVideoProgressView.this.bMH() % TopicVideoProgressView.this.gaB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        init(context);
    }

    public TopicVideoProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaB = 50;
        this.bbP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bbP && TopicVideoProgressView.this.gaC != null && TopicVideoProgressView.this.gaC.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.gaB - (TopicVideoProgressView.this.bMH() % TopicVideoProgressView.this.gaB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        init(context);
    }

    public TopicVideoProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gaB = 50;
        this.bbP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bbP && TopicVideoProgressView.this.gaC != null && TopicVideoProgressView.this.gaC.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.gaB - (TopicVideoProgressView.this.bMH() % TopicVideoProgressView.this.gaB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.iDw = new View(context);
        this.iDw.setBackgroundColor(getResources().getColor(R.color.CAM_X0303));
        addView(this.iDw, 0, (int) context.getResources().getDimension(R.dimen.ds6));
        setBackgroundColor(getResources().getColor(R.color.CAM_X0204));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gaC = mediaPlayerControl;
    }

    public void initProgress() {
        RelativeLayout.LayoutParams layoutParams;
        this.bbP = false;
        this.mHandler.removeMessages(1);
        if (this.iDw != null && (layoutParams = (RelativeLayout.LayoutParams) this.iDw.getLayoutParams()) != null) {
            layoutParams.width = 0;
            this.iDw.setLayoutParams(layoutParams);
        }
    }

    public void showProgress() {
        if (this.gaC != null) {
            this.gaB = ((this.gaC.getDuration() / 200) / 50) * 50;
            if (this.gaB < 50) {
                this.gaB = 50;
            }
            this.bbP = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gaB - (this.gaC.getCurrentPosition() % this.gaB));
        }
    }

    public void aSx() {
        initProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bMH() {
        if (this.gaC == null || this.iDw == null) {
            return 0;
        }
        int currentPosition = this.gaC.getCurrentPosition();
        int duration = this.gaC.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iDw.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.iDw.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iDw, R.color.CAM_X0303);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
