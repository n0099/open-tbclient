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
/* loaded from: classes15.dex */
public class TopicVideoProgressView extends RelativeLayout {
    private int fpd;
    private MediaController.MediaPlayerControl fpe;
    private View hDo;
    private Handler mHandler;
    private boolean mShowing;

    public TopicVideoProgressView(Context context) {
        super(context);
        this.fpd = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.fpe != null && TopicVideoProgressView.this.fpe.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.fpd - (TopicVideoProgressView.this.bBp() % TopicVideoProgressView.this.fpd));
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
        this.fpd = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.fpe != null && TopicVideoProgressView.this.fpe.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.fpd - (TopicVideoProgressView.this.bBp() % TopicVideoProgressView.this.fpd));
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
        this.fpd = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.fpe != null && TopicVideoProgressView.this.fpe.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.fpd - (TopicVideoProgressView.this.bBp() % TopicVideoProgressView.this.fpd));
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
        this.hDo = new View(context);
        this.hDo.setBackgroundColor(getResources().getColor(R.color.cp_link_tip_b));
        addView(this.hDo, 0, (int) context.getResources().getDimension(R.dimen.ds6));
        setBackgroundColor(getResources().getColor(R.color.cp_bg_line_c));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fpe = mediaPlayerControl;
    }

    public void initProgress() {
        RelativeLayout.LayoutParams layoutParams;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.hDo != null && (layoutParams = (RelativeLayout.LayoutParams) this.hDo.getLayoutParams()) != null) {
            layoutParams.width = 0;
            this.hDo.setLayoutParams(layoutParams);
        }
    }

    public void showProgress() {
        if (this.fpe != null) {
            this.fpd = ((this.fpe.getDuration() / 200) / 50) * 50;
            if (this.fpd < 50) {
                this.fpd = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fpd - (this.fpe.getCurrentPosition() % this.fpd));
        }
    }

    public void aIm() {
        initProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bBp() {
        if (this.fpe == null || this.hDo == null) {
            return 0;
        }
        int currentPosition = this.fpe.getCurrentPosition();
        int duration = this.fpe.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hDo.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.hDo.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hDo, R.color.cp_link_tip_b);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
