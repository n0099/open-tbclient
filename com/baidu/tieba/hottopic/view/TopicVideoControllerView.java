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
    private MediaController.MediaPlayerControl fEA;
    private TextView fEB;
    private TextView fEC;
    private SeekBar fED;
    private SeekBar.OnSeekBarChangeListener fEH;
    private int fEz;
    private StringBuilder jAP;
    private Formatter jAQ;
    private boolean mDragging;
    private Handler mHandler;
    private boolean mShowing;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.fEz = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fEA != null && TopicVideoControllerView.this.fEA.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fEz - (TopicVideoControllerView.this.bFo() % TopicVideoControllerView.this.fEz));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fEH = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fEA.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fEA.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fEB != null) {
                        TopicVideoControllerView.this.fEB.setText(TopicVideoControllerView.this.BI((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bFo();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEz = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fEA != null && TopicVideoControllerView.this.fEA.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fEz - (TopicVideoControllerView.this.bFo() % TopicVideoControllerView.this.fEz));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fEH = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fEA.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fEA.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fEB != null) {
                        TopicVideoControllerView.this.fEB.setText(TopicVideoControllerView.this.BI((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bFo();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEz = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fEA != null && TopicVideoControllerView.this.fEA.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fEz - (TopicVideoControllerView.this.bFo() % TopicVideoControllerView.this.fEz));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fEH = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fEA.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.fEA.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fEB != null) {
                        TopicVideoControllerView.this.fEB.setText(TopicVideoControllerView.this.BI((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bFo();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fEB = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.fEC = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.fED = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.fED.setOnSeekBarChangeListener(this.fEH);
        this.jAP = new StringBuilder();
        this.jAQ = new Formatter(this.jAP, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fEA = mediaPlayerControl;
    }

    public void by(int i, int i2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fED.setProgress(0);
        if (this.fEB != null) {
            this.fEB.setText(BI(i));
        }
        if (this.fEC != null) {
            this.fEC.setText(BI(BH(i2)));
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
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fED.setProgress(0);
        if (this.fEB != null) {
            this.fEB.setText(BI(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bFo() {
        if (this.fEA == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fEA.getCurrentPosition();
        int duration = this.fEA.getDuration();
        if (this.fED != null && duration > 0) {
            this.fED.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.fEC != null && duration > 0) {
            this.fEC.setText(BI(BH(duration)));
        }
        if (this.fEB != null) {
            this.fEB.setText(BI(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int BH(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String BI(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.jAP.setLength(0);
        return i5 > 0 ? this.jAQ.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.jAQ.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fEB, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.fEC, R.color.cp_cont_a, 1);
        this.fED.setProgressDrawable(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.fED.setThumb(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.fED.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.fED != null) {
            return this.fED.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
