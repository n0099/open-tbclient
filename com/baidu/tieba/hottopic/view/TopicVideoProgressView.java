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
/* loaded from: classes15.dex */
public class TopicVideoProgressView extends RelativeLayout {
    private int fdL;
    private MediaController.MediaPlayerControl fdM;
    private View hqx;
    private Handler mHandler;
    private boolean mShowing;

    public TopicVideoProgressView(Context context) {
        super(context);
        this.fdL = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.fdM != null && TopicVideoProgressView.this.fdM.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.fdL - (TopicVideoProgressView.this.bss() % TopicVideoProgressView.this.fdL));
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
        this.fdL = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.fdM != null && TopicVideoProgressView.this.fdM.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.fdL - (TopicVideoProgressView.this.bss() % TopicVideoProgressView.this.fdL));
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
        this.fdL = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.fdM != null && TopicVideoProgressView.this.fdM.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.fdL - (TopicVideoProgressView.this.bss() % TopicVideoProgressView.this.fdL));
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
        this.hqx = new View(context);
        this.hqx.setBackgroundColor(getResources().getColor(R.color.cp_link_tip_b));
        addView(this.hqx, 0, (int) context.getResources().getDimension(R.dimen.ds6));
        setBackgroundColor(getResources().getColor(R.color.cp_bg_line_c));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fdM = mediaPlayerControl;
    }

    public void initProgress() {
        RelativeLayout.LayoutParams layoutParams;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.hqx != null && (layoutParams = (RelativeLayout.LayoutParams) this.hqx.getLayoutParams()) != null) {
            layoutParams.width = 0;
            this.hqx.setLayoutParams(layoutParams);
        }
    }

    public void showProgress() {
        if (this.fdM != null) {
            this.fdL = ((this.fdM.getDuration() / 200) / 50) * 50;
            if (this.fdL < 50) {
                this.fdL = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fdL - (this.fdM.getCurrentPosition() % this.fdL));
        }
    }

    public void azZ() {
        initProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bss() {
        if (this.fdM == null || this.hqx == null) {
            return 0;
        }
        int currentPosition = this.fdM.getCurrentPosition();
        int duration = this.fdM.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqx.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.hqx.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.hqx, R.color.cp_link_tip_b);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
