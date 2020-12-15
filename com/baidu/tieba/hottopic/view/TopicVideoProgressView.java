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
    private int gaD;
    private MediaController.MediaPlayerControl gaE;
    private View iDy;
    private Handler mHandler;

    public TopicVideoProgressView(Context context) {
        super(context);
        this.gaD = 50;
        this.bbP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bbP && TopicVideoProgressView.this.gaE != null && TopicVideoProgressView.this.gaE.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.gaD - (TopicVideoProgressView.this.bMI() % TopicVideoProgressView.this.gaD));
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
        this.gaD = 50;
        this.bbP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bbP && TopicVideoProgressView.this.gaE != null && TopicVideoProgressView.this.gaE.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.gaD - (TopicVideoProgressView.this.bMI() % TopicVideoProgressView.this.gaD));
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
        this.gaD = 50;
        this.bbP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bbP && TopicVideoProgressView.this.gaE != null && TopicVideoProgressView.this.gaE.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.gaD - (TopicVideoProgressView.this.bMI() % TopicVideoProgressView.this.gaD));
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
        this.iDy = new View(context);
        this.iDy.setBackgroundColor(getResources().getColor(R.color.CAM_X0303));
        addView(this.iDy, 0, (int) context.getResources().getDimension(R.dimen.ds6));
        setBackgroundColor(getResources().getColor(R.color.CAM_X0204));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gaE = mediaPlayerControl;
    }

    public void initProgress() {
        RelativeLayout.LayoutParams layoutParams;
        this.bbP = false;
        this.mHandler.removeMessages(1);
        if (this.iDy != null && (layoutParams = (RelativeLayout.LayoutParams) this.iDy.getLayoutParams()) != null) {
            layoutParams.width = 0;
            this.iDy.setLayoutParams(layoutParams);
        }
    }

    public void showProgress() {
        if (this.gaE != null) {
            this.gaD = ((this.gaE.getDuration() / 200) / 50) * 50;
            if (this.gaD < 50) {
                this.gaD = 50;
            }
            this.bbP = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gaD - (this.gaE.getCurrentPosition() % this.gaD));
        }
    }

    public void aSx() {
        initProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bMI() {
        if (this.gaE == null || this.iDy == null) {
            return 0;
        }
        int currentPosition = this.gaE.getCurrentPosition();
        int duration = this.gaE.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iDy.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.iDy.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iDy, R.color.CAM_X0303);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
