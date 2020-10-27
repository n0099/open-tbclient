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
    private int fMU;
    private MediaController.MediaPlayerControl fMV;
    private View ilR;
    private Handler mHandler;
    private boolean mShowing;

    public TopicVideoProgressView(Context context) {
        super(context);
        this.fMU = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.fMV != null && TopicVideoProgressView.this.fMV.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.fMU - (TopicVideoProgressView.this.bHh() % TopicVideoProgressView.this.fMU));
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
        this.fMU = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.fMV != null && TopicVideoProgressView.this.fMV.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.fMU - (TopicVideoProgressView.this.bHh() % TopicVideoProgressView.this.fMU));
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
        this.fMU = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.fMV != null && TopicVideoProgressView.this.fMV.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.fMU - (TopicVideoProgressView.this.bHh() % TopicVideoProgressView.this.fMU));
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
        this.ilR = new View(context);
        this.ilR.setBackgroundColor(getResources().getColor(R.color.cp_link_tip_b));
        addView(this.ilR, 0, (int) context.getResources().getDimension(R.dimen.ds6));
        setBackgroundColor(getResources().getColor(R.color.cp_bg_line_c));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fMV = mediaPlayerControl;
    }

    public void initProgress() {
        RelativeLayout.LayoutParams layoutParams;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.ilR != null && (layoutParams = (RelativeLayout.LayoutParams) this.ilR.getLayoutParams()) != null) {
            layoutParams.width = 0;
            this.ilR.setLayoutParams(layoutParams);
        }
    }

    public void showProgress() {
        if (this.fMV != null) {
            this.fMU = ((this.fMV.getDuration() / 200) / 50) * 50;
            if (this.fMU < 50) {
                this.fMU = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fMU - (this.fMV.getCurrentPosition() % this.fMU));
        }
    }

    public void aNA() {
        initProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bHh() {
        if (this.fMV == null || this.ilR == null) {
            return 0;
        }
        int currentPosition = this.fMV.getCurrentPosition();
        int duration = this.fMV.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ilR.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.ilR.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.ilR, R.color.cp_link_tip_b);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
