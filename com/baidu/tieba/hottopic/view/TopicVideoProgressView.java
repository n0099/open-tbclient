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
/* loaded from: classes7.dex */
public class TopicVideoProgressView extends RelativeLayout {
    private boolean aYJ;
    private int gfm;
    private MediaController.MediaPlayerControl gfn;
    private View iLd;
    private Handler mHandler;

    public TopicVideoProgressView(Context context) {
        super(context);
        this.gfm = 50;
        this.aYJ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.aYJ && TopicVideoProgressView.this.gfn != null && TopicVideoProgressView.this.gfn.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.gfm - (TopicVideoProgressView.this.bLj() % TopicVideoProgressView.this.gfm));
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
        this.gfm = 50;
        this.aYJ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.aYJ && TopicVideoProgressView.this.gfn != null && TopicVideoProgressView.this.gfn.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.gfm - (TopicVideoProgressView.this.bLj() % TopicVideoProgressView.this.gfm));
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
        this.gfm = 50;
        this.aYJ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.aYJ && TopicVideoProgressView.this.gfn != null && TopicVideoProgressView.this.gfn.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.gfm - (TopicVideoProgressView.this.bLj() % TopicVideoProgressView.this.gfm));
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
        this.iLd = new View(context);
        this.iLd.setBackgroundColor(getResources().getColor(R.color.CAM_X0303));
        addView(this.iLd, 0, (int) context.getResources().getDimension(R.dimen.ds6));
        setBackgroundColor(getResources().getColor(R.color.CAM_X0204));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gfn = mediaPlayerControl;
    }

    public void initProgress() {
        RelativeLayout.LayoutParams layoutParams;
        this.aYJ = false;
        this.mHandler.removeMessages(1);
        if (this.iLd != null && (layoutParams = (RelativeLayout.LayoutParams) this.iLd.getLayoutParams()) != null) {
            layoutParams.width = 0;
            this.iLd.setLayoutParams(layoutParams);
        }
    }

    public void showProgress() {
        if (this.gfn != null) {
            this.gfm = ((this.gfn.getDuration() / 200) / 50) * 50;
            if (this.gfm < 50) {
                this.gfm = 50;
            }
            this.aYJ = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gfm - (this.gfn.getCurrentPosition() % this.gfm));
        }
    }

    public void aQY() {
        initProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bLj() {
        if (this.gfn == null || this.iLd == null) {
            return 0;
        }
        int currentPosition = this.gfn.getCurrentPosition();
        int duration = this.gfn.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iLd.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.iLd.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this, R.color.CAM_X0204);
        ao.setBackgroundColor(this.iLd, R.color.CAM_X0303);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
