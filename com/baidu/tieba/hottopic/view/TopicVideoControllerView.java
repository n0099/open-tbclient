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
    private int fMU;
    private MediaController.MediaPlayerControl fMV;
    private TextView fMW;
    private TextView fMX;
    private SeekBar fMY;
    private SeekBar.OnSeekBarChangeListener fNc;
    private StringBuilder jNo;
    private Formatter jNp;
    private boolean mDragging;
    private Handler mHandler;
    private boolean mShowing;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.fMU = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fMV != null && TopicVideoControllerView.this.fMV.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fMU - (TopicVideoControllerView.this.bHh() % TopicVideoControllerView.this.fMU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fNc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fMV.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fMV.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fMW != null) {
                        TopicVideoControllerView.this.fMW.setText(TopicVideoControllerView.this.Cb((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bHh();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fMU = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fMV != null && TopicVideoControllerView.this.fMV.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fMU - (TopicVideoControllerView.this.bHh() % TopicVideoControllerView.this.fMU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fNc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fMV.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fMV.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fMW != null) {
                        TopicVideoControllerView.this.fMW.setText(TopicVideoControllerView.this.Cb((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bHh();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fMU = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fMV != null && TopicVideoControllerView.this.fMV.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fMU - (TopicVideoControllerView.this.bHh() % TopicVideoControllerView.this.fMU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fNc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fMV.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.fMV.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fMW != null) {
                        TopicVideoControllerView.this.fMW.setText(TopicVideoControllerView.this.Cb((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bHh();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fMW = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.fMX = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.fMY = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.fMY.setOnSeekBarChangeListener(this.fNc);
        this.jNo = new StringBuilder();
        this.jNp = new Formatter(this.jNo, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fMV = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fMY.setProgress(0);
        if (this.fMW != null) {
            this.fMW.setText(Cb(i));
        }
        if (this.fMX != null) {
            this.fMX.setText(Cb(Ca(i2)));
        }
    }

    public void showProgress() {
        if (this.fMV != null) {
            this.fMU = ((this.fMV.getDuration() / 200) / 50) * 50;
            if (this.fMU < 50) {
                this.fMU = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fMU - (this.fMV.getCurrentPosition() % this.fMU));
        }
    }

    public void aNA() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fMY.setProgress(0);
        if (this.fMW != null) {
            this.fMW.setText(Cb(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bHh() {
        if (this.fMV == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fMV.getCurrentPosition();
        int duration = this.fMV.getDuration();
        if (this.fMY != null && duration > 0) {
            this.fMY.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.fMX != null && duration > 0) {
            this.fMX.setText(Cb(Ca(duration)));
        }
        if (this.fMW != null) {
            this.fMW.setText(Cb(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int Ca(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Cb(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.jNo.setLength(0);
        return i5 > 0 ? this.jNp.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.jNp.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fMW, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.fMX, R.color.cp_cont_a, 1);
        this.fMY.setProgressDrawable(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.fMY.setThumb(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.fMY.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.fMY != null) {
            return this.fMY.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
