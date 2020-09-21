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
/* loaded from: classes20.dex */
public class TopicVideoProgressView extends RelativeLayout {
    private int fso;
    private MediaController.MediaPlayerControl fsp;
    private View hKw;
    private Handler mHandler;
    private boolean mShowing;

    public TopicVideoProgressView(Context context) {
        super(context);
        this.fso = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.fsp != null && TopicVideoProgressView.this.fsp.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.fso - (TopicVideoProgressView.this.bCC() % TopicVideoProgressView.this.fso));
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
        this.fso = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.fsp != null && TopicVideoProgressView.this.fsp.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.fso - (TopicVideoProgressView.this.bCC() % TopicVideoProgressView.this.fso));
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
        this.fso = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.fsp != null && TopicVideoProgressView.this.fsp.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.fso - (TopicVideoProgressView.this.bCC() % TopicVideoProgressView.this.fso));
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
        this.hKw = new View(context);
        this.hKw.setBackgroundColor(getResources().getColor(R.color.cp_link_tip_b));
        addView(this.hKw, 0, (int) context.getResources().getDimension(R.dimen.ds6));
        setBackgroundColor(getResources().getColor(R.color.cp_bg_line_c));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fsp = mediaPlayerControl;
    }

    public void initProgress() {
        RelativeLayout.LayoutParams layoutParams;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.hKw != null && (layoutParams = (RelativeLayout.LayoutParams) this.hKw.getLayoutParams()) != null) {
            layoutParams.width = 0;
            this.hKw.setLayoutParams(layoutParams);
        }
    }

    public void showProgress() {
        if (this.fsp != null) {
            this.fso = ((this.fsp.getDuration() / 200) / 50) * 50;
            if (this.fso < 50) {
                this.fso = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fso - (this.fsp.getCurrentPosition() % this.fso));
        }
    }

    public void aIX() {
        initProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bCC() {
        if (this.fsp == null || this.hKw == null) {
            return 0;
        }
        int currentPosition = this.fsp.getCurrentPosition();
        int duration = this.fsp.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hKw.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.hKw.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hKw, R.color.cp_link_tip_b);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
