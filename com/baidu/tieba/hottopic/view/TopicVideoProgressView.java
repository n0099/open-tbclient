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
    private int ghP;
    private MediaController.MediaPlayerControl ghQ;
    private View iQZ;
    private Handler mHandler;

    public TopicVideoProgressView(Context context) {
        super(context);
        this.ghP = 50;
        this.bbQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bbQ && TopicVideoProgressView.this.ghQ != null && TopicVideoProgressView.this.ghQ.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.ghP - (TopicVideoProgressView.this.bLK() % TopicVideoProgressView.this.ghP));
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
        this.ghP = 50;
        this.bbQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bbQ && TopicVideoProgressView.this.ghQ != null && TopicVideoProgressView.this.ghQ.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.ghP - (TopicVideoProgressView.this.bLK() % TopicVideoProgressView.this.ghP));
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
        this.ghP = 50;
        this.bbQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (TopicVideoProgressView.this.bbQ && TopicVideoProgressView.this.ghQ != null && TopicVideoProgressView.this.ghQ.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.ghP - (TopicVideoProgressView.this.bLK() % TopicVideoProgressView.this.ghP));
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
        this.iQZ = new View(context);
        this.iQZ.setBackgroundColor(getResources().getColor(R.color.CAM_X0303));
        addView(this.iQZ, 0, (int) context.getResources().getDimension(R.dimen.ds6));
        setBackgroundColor(getResources().getColor(R.color.CAM_X0204));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.ghQ = mediaPlayerControl;
    }

    public void initProgress() {
        RelativeLayout.LayoutParams layoutParams;
        this.bbQ = false;
        this.mHandler.removeMessages(1);
        if (this.iQZ != null && (layoutParams = (RelativeLayout.LayoutParams) this.iQZ.getLayoutParams()) != null) {
            layoutParams.width = 0;
            this.iQZ.setLayoutParams(layoutParams);
        }
    }

    public void showProgress() {
        if (this.ghQ != null) {
            this.ghP = ((this.ghQ.getDuration() / 200) / 50) * 50;
            if (this.ghP < 50) {
                this.ghP = 50;
            }
            this.bbQ = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.ghP - (this.ghQ.getCurrentPosition() % this.ghP));
        }
    }

    public void aRo() {
        initProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bLK() {
        if (this.ghQ == null || this.iQZ == null) {
            return 0;
        }
        int currentPosition = this.ghQ.getCurrentPosition();
        int duration = this.ghQ.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iQZ.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.iQZ.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iQZ, R.color.CAM_X0303);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
