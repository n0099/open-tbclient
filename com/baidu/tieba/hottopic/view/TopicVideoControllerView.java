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
/* loaded from: classes20.dex */
public class TopicVideoControllerView extends RelativeLayout {
    private int fso;
    private MediaController.MediaPlayerControl fsp;
    private TextView fsq;
    private TextView fsr;
    private SeekBar fss;
    private SeekBar.OnSeekBarChangeListener fsw;
    private StringBuilder jlR;
    private Formatter jlS;
    private boolean mDragging;
    private Handler mHandler;
    private boolean mShowing;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.fso = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fsp != null && TopicVideoControllerView.this.fsp.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fso - (TopicVideoControllerView.this.bCC() % TopicVideoControllerView.this.fso));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fsw = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fsp.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fsp.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fsq != null) {
                        TopicVideoControllerView.this.fsq.setText(TopicVideoControllerView.this.Bc((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bCC();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fso = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fsp != null && TopicVideoControllerView.this.fsp.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fso - (TopicVideoControllerView.this.bCC() % TopicVideoControllerView.this.fso));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fsw = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fsp.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fsp.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fsq != null) {
                        TopicVideoControllerView.this.fsq.setText(TopicVideoControllerView.this.Bc((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bCC();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fso = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fsp != null && TopicVideoControllerView.this.fsp.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fso - (TopicVideoControllerView.this.bCC() % TopicVideoControllerView.this.fso));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fsw = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fsp.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.fsp.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fsq != null) {
                        TopicVideoControllerView.this.fsq.setText(TopicVideoControllerView.this.Bc((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bCC();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fsq = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.fsr = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.fss = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.fss.setOnSeekBarChangeListener(this.fsw);
        this.jlR = new StringBuilder();
        this.jlS = new Formatter(this.jlR, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fsp = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fss.setProgress(0);
        if (this.fsq != null) {
            this.fsq.setText(Bc(i));
        }
        if (this.fsr != null) {
            this.fsr.setText(Bc(Bb(i2)));
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
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fss.setProgress(0);
        if (this.fsq != null) {
            this.fsq.setText(Bc(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bCC() {
        if (this.fsp == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fsp.getCurrentPosition();
        int duration = this.fsp.getDuration();
        if (this.fss != null && duration > 0) {
            this.fss.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.fsr != null && duration > 0) {
            this.fsr.setText(Bc(Bb(duration)));
        }
        if (this.fsq != null) {
            this.fsq.setText(Bc(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int Bb(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Bc(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.jlR.setLength(0);
        return i5 > 0 ? this.jlS.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.jlS.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fsq, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.fsr, R.color.cp_cont_a, 1);
        this.fss.setProgressDrawable(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.fss.setThumb(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.fss.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.fss != null) {
            return this.fss.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
