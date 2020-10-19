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
    private MediaController.MediaPlayerControl fEA;
    private int fEz;
    private View hZr;
    private Handler mHandler;
    private boolean mShowing;

    public TopicVideoProgressView(Context context) {
        super(context);
        this.fEz = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.fEA != null && TopicVideoProgressView.this.fEA.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.fEz - (TopicVideoProgressView.this.bFo() % TopicVideoProgressView.this.fEz));
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
        this.fEz = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.fEA != null && TopicVideoProgressView.this.fEA.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.fEz - (TopicVideoProgressView.this.bFo() % TopicVideoProgressView.this.fEz));
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
        this.fEz = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.fEA != null && TopicVideoProgressView.this.fEA.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.fEz - (TopicVideoProgressView.this.bFo() % TopicVideoProgressView.this.fEz));
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
        this.hZr = new View(context);
        this.hZr.setBackgroundColor(getResources().getColor(R.color.cp_link_tip_b));
        addView(this.hZr, 0, (int) context.getResources().getDimension(R.dimen.ds6));
        setBackgroundColor(getResources().getColor(R.color.cp_bg_line_c));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fEA = mediaPlayerControl;
    }

    public void initProgress() {
        RelativeLayout.LayoutParams layoutParams;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.hZr != null && (layoutParams = (RelativeLayout.LayoutParams) this.hZr.getLayoutParams()) != null) {
            layoutParams.width = 0;
            this.hZr.setLayoutParams(layoutParams);
        }
    }

    public void showProgress() {
        if (this.fEA != null) {
            this.fEz = ((this.fEA.getDuration() / 200) / 50) * 50;
            if (this.fEz < 50) {
                this.fEz = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fEz - (this.fEA.getCurrentPosition() % this.fEz));
        }
    }

    public void aLG() {
        initProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bFo() {
        if (this.fEA == null || this.hZr == null) {
            return 0;
        }
        int currentPosition = this.fEA.getCurrentPosition();
        int duration = this.fEA.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZr.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.hZr.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hZr, R.color.cp_link_tip_b);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
