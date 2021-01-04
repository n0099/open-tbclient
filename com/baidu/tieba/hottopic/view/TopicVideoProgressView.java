package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class TopicVideoProgressView extends RelativeLayout {
    private boolean bdx;
    private int gjU;
    private MediaController.MediaPlayerControl gjV;
    private View iPK;
    private Handler mHandler;

    public TopicVideoProgressView(Context context) {
        super(context);
        this.gjU = 50;
        this.bdx = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bdx && TopicVideoProgressView.this.gjV != null && TopicVideoProgressView.this.gjV.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.gjU - (TopicVideoProgressView.this.bPa() % TopicVideoProgressView.this.gjU));
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
        this.gjU = 50;
        this.bdx = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bdx && TopicVideoProgressView.this.gjV != null && TopicVideoProgressView.this.gjV.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.gjU - (TopicVideoProgressView.this.bPa() % TopicVideoProgressView.this.gjU));
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
        this.gjU = 50;
        this.bdx = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bdx && TopicVideoProgressView.this.gjV != null && TopicVideoProgressView.this.gjV.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.gjU - (TopicVideoProgressView.this.bPa() % TopicVideoProgressView.this.gjU));
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
        this.iPK = new View(context);
        this.iPK.setBackgroundColor(getResources().getColor(R.color.CAM_X0303));
        addView(this.iPK, 0, (int) context.getResources().getDimension(R.dimen.ds6));
        setBackgroundColor(getResources().getColor(R.color.CAM_X0204));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gjV = mediaPlayerControl;
    }

    public void initProgress() {
        RelativeLayout.LayoutParams layoutParams;
        this.bdx = false;
        this.mHandler.removeMessages(1);
        if (this.iPK != null && (layoutParams = (RelativeLayout.LayoutParams) this.iPK.getLayoutParams()) != null) {
            layoutParams.width = 0;
            this.iPK.setLayoutParams(layoutParams);
        }
    }

    public void showProgress() {
        if (this.gjV != null) {
            this.gjU = ((this.gjV.getDuration() / 200) / 50) * 50;
            if (this.gjU < 50) {
                this.gjU = 50;
            }
            this.bdx = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gjU - (this.gjV.getCurrentPosition() % this.gjU));
        }
    }

    public void aUR() {
        initProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bPa() {
        if (this.gjV == null || this.iPK == null) {
            return 0;
        }
        int currentPosition = this.gjV.getCurrentPosition();
        int duration = this.gjV.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iPK.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.iPK.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this, R.color.CAM_X0204);
        ao.setBackgroundColor(this.iPK, R.color.CAM_X0303);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
