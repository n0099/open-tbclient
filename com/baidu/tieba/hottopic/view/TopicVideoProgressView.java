package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class TopicVideoProgressView extends RelativeLayout {
    private int eZj;
    private MediaController.MediaPlayerControl eZk;
    private View hkM;
    private Handler mHandler;
    private boolean mShowing;

    public TopicVideoProgressView(Context context) {
        super(context);
        this.eZj = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.eZk != null && TopicVideoProgressView.this.eZk.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.eZj - (TopicVideoProgressView.this.bpp() % TopicVideoProgressView.this.eZj));
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
        this.eZj = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.eZk != null && TopicVideoProgressView.this.eZk.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.eZj - (TopicVideoProgressView.this.bpp() % TopicVideoProgressView.this.eZj));
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
        this.eZj = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.mShowing && TopicVideoProgressView.this.eZk != null && TopicVideoProgressView.this.eZk.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.eZj - (TopicVideoProgressView.this.bpp() % TopicVideoProgressView.this.eZj));
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
        this.hkM = new View(context);
        this.hkM.setBackgroundColor(getResources().getColor(R.color.cp_link_tip_b));
        addView(this.hkM, 0, (int) context.getResources().getDimension(R.dimen.ds6));
        setBackgroundColor(getResources().getColor(R.color.cp_bg_line_c));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eZk = mediaPlayerControl;
    }

    public void initProgress() {
        RelativeLayout.LayoutParams layoutParams;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.hkM != null && (layoutParams = (RelativeLayout.LayoutParams) this.hkM.getLayoutParams()) != null) {
            layoutParams.width = 0;
            this.hkM.setLayoutParams(layoutParams);
        }
    }

    public void showProgress() {
        if (this.eZk != null) {
            this.eZj = ((this.eZk.getDuration() / 200) / 50) * 50;
            if (this.eZj < 50) {
                this.eZj = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eZj - (this.eZk.getCurrentPosition() % this.eZj));
        }
    }

    public void axj() {
        initProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bpp() {
        if (this.eZk == null || this.hkM == null) {
            return 0;
        }
        int currentPosition = this.eZk.getCurrentPosition();
        int duration = this.eZk.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hkM.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.hkM.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this, R.color.cp_bg_line_c);
        an.setBackgroundColor(this.hkM, R.color.cp_link_tip_b);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
