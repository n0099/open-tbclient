package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes21.dex */
public class TopicVideoControllerView extends RelativeLayout {
    private int fSK;
    private MediaController.MediaPlayerControl fSL;
    private TextView fSM;
    private TextView fSN;
    private SeekBar fSO;
    private SeekBar.OnSeekBarChangeListener fSS;
    private StringBuilder jTl;
    private Formatter jTm;
    private boolean mDragging;
    private Handler mHandler;
    private boolean mShowing;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.fSK = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fSL != null && TopicVideoControllerView.this.fSL.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fSK - (TopicVideoControllerView.this.bJG() % TopicVideoControllerView.this.fSK));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fSS = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fSL.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fSL.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fSM != null) {
                        TopicVideoControllerView.this.fSM.setText(TopicVideoControllerView.this.Co((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bJG();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fSK = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fSL != null && TopicVideoControllerView.this.fSL.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fSK - (TopicVideoControllerView.this.bJG() % TopicVideoControllerView.this.fSK));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fSS = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fSL.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fSL.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fSM != null) {
                        TopicVideoControllerView.this.fSM.setText(TopicVideoControllerView.this.Co((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bJG();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fSK = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fSL != null && TopicVideoControllerView.this.fSL.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fSK - (TopicVideoControllerView.this.bJG() % TopicVideoControllerView.this.fSK));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fSS = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fSL.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.fSL.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fSM != null) {
                        TopicVideoControllerView.this.fSM.setText(TopicVideoControllerView.this.Co((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bJG();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fSM = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.fSN = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.fSO = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.fSO.setOnSeekBarChangeListener(this.fSS);
        this.jTl = new StringBuilder();
        this.jTm = new Formatter(this.jTl, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fSL = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fSO.setProgress(0);
        if (this.fSM != null) {
            this.fSM.setText(Co(i));
        }
        if (this.fSN != null) {
            this.fSN.setText(Co(Cn(i2)));
        }
    }

    public void showProgress() {
        if (this.fSL != null) {
            this.fSK = ((this.fSL.getDuration() / 200) / 50) * 50;
            if (this.fSK < 50) {
                this.fSK = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fSK - (this.fSL.getCurrentPosition() % this.fSK));
        }
    }

    public void aQa() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fSO.setProgress(0);
        if (this.fSM != null) {
            this.fSM.setText(Co(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bJG() {
        if (this.fSL == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fSL.getCurrentPosition();
        int duration = this.fSL.getDuration();
        if (this.fSO != null && duration > 0) {
            this.fSO.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.fSN != null && duration > 0) {
            this.fSN.setText(Co(Cn(duration)));
        }
        if (this.fSM != null) {
            this.fSM.setText(Co(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int Cn(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Co(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.jTl.setLength(0);
        return i5 > 0 ? this.jTm.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.jTm.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fSM, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.fSN, R.color.cp_cont_a, 1);
        this.fSO.setProgressDrawable(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.fSO.setThumb(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.fSO.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.fSO != null) {
            return this.fSO.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
