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
/* loaded from: classes8.dex */
public class TopicVideoProgressView extends RelativeLayout {
    private boolean bbQ;
    private int ghB;
    private MediaController.MediaPlayerControl ghC;
    private View iQL;
    private Handler mHandler;

    public TopicVideoProgressView(Context context) {
        super(context);
        this.ghB = 50;
        this.bbQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bbQ && TopicVideoProgressView.this.ghC != null && TopicVideoProgressView.this.ghC.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.ghB - (TopicVideoProgressView.this.bLD() % TopicVideoProgressView.this.ghB));
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
        this.ghB = 50;
        this.bbQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bbQ && TopicVideoProgressView.this.ghC != null && TopicVideoProgressView.this.ghC.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.ghB - (TopicVideoProgressView.this.bLD() % TopicVideoProgressView.this.ghB));
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
        this.ghB = 50;
        this.bbQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bbQ && TopicVideoProgressView.this.ghC != null && TopicVideoProgressView.this.ghC.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.ghB - (TopicVideoProgressView.this.bLD() % TopicVideoProgressView.this.ghB));
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
        this.iQL = new View(context);
        this.iQL.setBackgroundColor(getResources().getColor(R.color.CAM_X0303));
        addView(this.iQL, 0, (int) context.getResources().getDimension(R.dimen.ds6));
        setBackgroundColor(getResources().getColor(R.color.CAM_X0204));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.ghC = mediaPlayerControl;
    }

    public void initProgress() {
        RelativeLayout.LayoutParams layoutParams;
        this.bbQ = false;
        this.mHandler.removeMessages(1);
        if (this.iQL != null && (layoutParams = (RelativeLayout.LayoutParams) this.iQL.getLayoutParams()) != null) {
            layoutParams.width = 0;
            this.iQL.setLayoutParams(layoutParams);
        }
    }

    public void showProgress() {
        if (this.ghC != null) {
            this.ghB = ((this.ghC.getDuration() / 200) / 50) * 50;
            if (this.ghB < 50) {
                this.ghB = 50;
            }
            this.bbQ = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.ghB - (this.ghC.getCurrentPosition() % this.ghB));
        }
    }

    public void aRo() {
        initProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bLD() {
        if (this.ghC == null || this.iQL == null) {
            return 0;
        }
        int currentPosition = this.ghC.getCurrentPosition();
        int duration = this.ghC.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iQL.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.iQL.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iQL, R.color.CAM_X0303);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
