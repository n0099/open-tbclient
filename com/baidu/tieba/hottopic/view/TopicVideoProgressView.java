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
/* loaded from: classes7.dex */
public class TopicVideoProgressView extends RelativeLayout {
    private boolean bdq;
    private int gjt;
    private MediaController.MediaPlayerControl gju;
    private View iSI;
    private Handler mHandler;

    public TopicVideoProgressView(Context context) {
        super(context);
        this.gjt = 50;
        this.bdq = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bdq && TopicVideoProgressView.this.gju != null && TopicVideoProgressView.this.gju.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.gjt - (TopicVideoProgressView.this.bLO() % TopicVideoProgressView.this.gjt));
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
        this.gjt = 50;
        this.bdq = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bdq && TopicVideoProgressView.this.gju != null && TopicVideoProgressView.this.gju.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.gjt - (TopicVideoProgressView.this.bLO() % TopicVideoProgressView.this.gjt));
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
        this.gjt = 50;
        this.bdq = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bdq && TopicVideoProgressView.this.gju != null && TopicVideoProgressView.this.gju.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.gjt - (TopicVideoProgressView.this.bLO() % TopicVideoProgressView.this.gjt));
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
        this.iSI = new View(context);
        this.iSI.setBackgroundColor(getResources().getColor(R.color.CAM_X0303));
        addView(this.iSI, 0, (int) context.getResources().getDimension(R.dimen.ds6));
        setBackgroundColor(getResources().getColor(R.color.CAM_X0204));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gju = mediaPlayerControl;
    }

    public void initProgress() {
        RelativeLayout.LayoutParams layoutParams;
        this.bdq = false;
        this.mHandler.removeMessages(1);
        if (this.iSI != null && (layoutParams = (RelativeLayout.LayoutParams) this.iSI.getLayoutParams()) != null) {
            layoutParams.width = 0;
            this.iSI.setLayoutParams(layoutParams);
        }
    }

    public void showProgress() {
        if (this.gju != null) {
            this.gjt = ((this.gju.getDuration() / 200) / 50) * 50;
            if (this.gjt < 50) {
                this.gjt = 50;
            }
            this.bdq = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gjt - (this.gju.getCurrentPosition() % this.gjt));
        }
    }

    public void aRr() {
        initProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bLO() {
        if (this.gju == null || this.iSI == null) {
            return 0;
        }
        int currentPosition = this.gju.getCurrentPosition();
        int duration = this.gju.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iSI.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.iSI.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iSI, R.color.CAM_X0303);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
