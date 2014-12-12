package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.util.TbCountDownTimer;
/* loaded from: classes.dex */
public class ProgressCountDownView extends FrameLayout {
    private static final long MIN_MARK = 60000;
    private static final long SEC_MARK = 1000;
    public static final int SHOW_TYPE_MINUTE = 1;
    public static final int SHOW_TYPE_SECOND = 2;
    private String mFinalText;
    private boolean mFlickFlag;
    private ar mListerner;
    private ProgressBar mProgress;
    private View mRoot;
    private String mStrText;
    private TextView mTextView;
    private TbCountDownTimer mTimer;
    private long mTotal;
    private long mWarnTime;

    public ProgressCountDownView(Context context) {
        super(context);
        this.mTotal = 1L;
        this.mWarnTime = 0L;
        this.mFlickFlag = true;
        init(context);
    }

    public ProgressCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTotal = 1L;
        this.mWarnTime = 0L;
        this.mFlickFlag = true;
        init(context);
    }

    private void init(Context context) {
        this.mRoot = com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.x.progress_count_down_view, this);
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.w.progress_count_down_text);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.w.progress_count_down_progress);
    }

    public void setFinalText(String str) {
        this.mFinalText = String.valueOf(str) + "： ";
    }

    public void setTime(long j, long j2, long j3) {
        this.mTotal = j;
        this.mWarnTime = j3;
        this.mTimer = new aq(this, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshPregress(long j) {
        long max = (this.mProgress.getMax() * j) / this.mTotal;
        if (j <= this.mWarnTime) {
            if (this.mFlickFlag) {
                this.mProgress.setSecondaryProgress((int) max);
                this.mFlickFlag = false;
            } else {
                this.mProgress.setSecondaryProgress(0);
                this.mFlickFlag = true;
            }
            this.mProgress.setProgress(0);
            return;
        }
        this.mProgress.setProgress((int) max);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshText(long j) {
        this.mStrText = String.valueOf(this.mFinalText) + formatTime(j);
        this.mTextView.setText(this.mStrText);
    }

    private String formatTime(long j) {
        long j2;
        long j3;
        String str = "";
        if (j / 60000 < 10) {
            str = String.valueOf("") + "0";
        }
        String str2 = String.valueOf(str) + String.valueOf(j2) + "'";
        if ((j % 60000) / 1000 < 10) {
            str2 = String.valueOf(str2) + "0";
        }
        return String.valueOf(str2) + String.valueOf(j3) + "\"";
    }

    public void start() {
        if (this.mTimer != null) {
            this.mTimer.start();
        }
    }

    public void stop() {
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
    }

    public void setOnFinishlistener(ar arVar) {
        this.mListerner = arVar;
    }
}
