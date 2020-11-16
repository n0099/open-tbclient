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
    private int fSr;
    private MediaController.MediaPlayerControl fSs;
    private TextView fSt;
    private TextView fSu;
    private SeekBar fSv;
    private SeekBar.OnSeekBarChangeListener fSz;
    private StringBuilder jTV;
    private Formatter jTW;
    private boolean mDragging;
    private Handler mHandler;
    private boolean mShowing;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.fSr = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fSs != null && TopicVideoControllerView.this.fSs.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fSr - (TopicVideoControllerView.this.bIZ() % TopicVideoControllerView.this.fSr));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fSz = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fSs.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fSs.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fSt != null) {
                        TopicVideoControllerView.this.fSt.setText(TopicVideoControllerView.this.CM((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bIZ();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fSr = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fSs != null && TopicVideoControllerView.this.fSs.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fSr - (TopicVideoControllerView.this.bIZ() % TopicVideoControllerView.this.fSr));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fSz = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fSs.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fSs.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fSt != null) {
                        TopicVideoControllerView.this.fSt.setText(TopicVideoControllerView.this.CM((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bIZ();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fSr = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fSs != null && TopicVideoControllerView.this.fSs.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fSr - (TopicVideoControllerView.this.bIZ() % TopicVideoControllerView.this.fSr));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fSz = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fSs.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.fSs.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fSt != null) {
                        TopicVideoControllerView.this.fSt.setText(TopicVideoControllerView.this.CM((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bIZ();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fSt = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.fSu = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.fSv = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.fSv.setOnSeekBarChangeListener(this.fSz);
        this.jTV = new StringBuilder();
        this.jTW = new Formatter(this.jTV, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fSs = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fSv.setProgress(0);
        if (this.fSt != null) {
            this.fSt.setText(CM(i));
        }
        if (this.fSu != null) {
            this.fSu.setText(CM(CL(i2)));
        }
    }

    public void showProgress() {
        if (this.fSs != null) {
            this.fSr = ((this.fSs.getDuration() / 200) / 50) * 50;
            if (this.fSr < 50) {
                this.fSr = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fSr - (this.fSs.getCurrentPosition() % this.fSr));
        }
    }

    public void aPs() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fSv.setProgress(0);
        if (this.fSt != null) {
            this.fSt.setText(CM(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bIZ() {
        if (this.fSs == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fSs.getCurrentPosition();
        int duration = this.fSs.getDuration();
        if (this.fSv != null && duration > 0) {
            this.fSv.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.fSu != null && duration > 0) {
            this.fSu.setText(CM(CL(duration)));
        }
        if (this.fSt != null) {
            this.fSt.setText(CM(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int CL(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String CM(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.jTV.setLength(0);
        return i5 > 0 ? this.jTW.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.jTW.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fSt, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.fSu, R.color.CAM_X0101, 1);
        this.fSv.setProgressDrawable(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.fSv.setThumb(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.fSv.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.fSv != null) {
            return this.fSv.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
