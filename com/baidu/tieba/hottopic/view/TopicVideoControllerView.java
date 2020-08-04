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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes15.dex */
public class TopicVideoControllerView extends RelativeLayout {
    private int fdL;
    private MediaController.MediaPlayerControl fdM;
    private TextView fdN;
    private TextView fdO;
    private SeekBar fdP;
    private SeekBar.OnSeekBarChangeListener fdT;
    private StringBuilder iOi;
    private Formatter iOj;
    private boolean mDragging;
    private Handler mHandler;
    private boolean mShowing;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.fdL = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fdM != null && TopicVideoControllerView.this.fdM.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fdL - (TopicVideoControllerView.this.bss() % TopicVideoControllerView.this.fdL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fdT = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fdM.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fdM.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fdN != null) {
                        TopicVideoControllerView.this.fdN.setText(TopicVideoControllerView.this.yh((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bss();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdL = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fdM != null && TopicVideoControllerView.this.fdM.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fdL - (TopicVideoControllerView.this.bss() % TopicVideoControllerView.this.fdL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fdT = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fdM.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fdM.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fdN != null) {
                        TopicVideoControllerView.this.fdN.setText(TopicVideoControllerView.this.yh((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bss();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fdL = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fdM != null && TopicVideoControllerView.this.fdM.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fdL - (TopicVideoControllerView.this.bss() % TopicVideoControllerView.this.fdL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fdT = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fdM.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.fdM.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fdN != null) {
                        TopicVideoControllerView.this.fdN.setText(TopicVideoControllerView.this.yh((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bss();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fdN = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.fdO = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.fdP = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.fdP.setOnSeekBarChangeListener(this.fdT);
        this.iOi = new StringBuilder();
        this.iOj = new Formatter(this.iOi, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fdM = mediaPlayerControl;
    }

    public void bq(int i, int i2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fdP.setProgress(0);
        if (this.fdN != null) {
            this.fdN.setText(yh(i));
        }
        if (this.fdO != null) {
            this.fdO.setText(yh(yg(i2)));
        }
    }

    public void showProgress() {
        if (this.fdM != null) {
            this.fdL = ((this.fdM.getDuration() / 200) / 50) * 50;
            if (this.fdL < 50) {
                this.fdL = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fdL - (this.fdM.getCurrentPosition() % this.fdL));
        }
    }

    public void azZ() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fdP.setProgress(0);
        if (this.fdN != null) {
            this.fdN.setText(yh(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bss() {
        if (this.fdM == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fdM.getCurrentPosition();
        int duration = this.fdM.getDuration();
        if (this.fdP != null && duration > 0) {
            this.fdP.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.fdO != null && duration > 0) {
            this.fdO.setText(yh(yg(duration)));
        }
        if (this.fdN != null) {
            this.fdN.setText(yh(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int yg(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String yh(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.iOi.setLength(0);
        return i5 > 0 ? this.iOj.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.iOj.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ao.setViewTextColor(this.fdN, R.color.cp_cont_a, 1);
        ao.setViewTextColor(this.fdO, R.color.cp_cont_a, 1);
        this.fdP.setProgressDrawable(ao.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.fdP.setThumb(ao.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.fdP.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.fdP != null) {
            return this.fdP.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
