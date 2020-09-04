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
/* loaded from: classes15.dex */
public class TopicVideoControllerView extends RelativeLayout {
    private int fph;
    private MediaController.MediaPlayerControl fpi;
    private TextView fpj;
    private TextView fpk;
    private SeekBar fpl;
    private SeekBar.OnSeekBarChangeListener fpp;
    private StringBuilder jdl;
    private Formatter jdm;
    private boolean mDragging;
    private Handler mHandler;
    private boolean mShowing;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.fph = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fpi != null && TopicVideoControllerView.this.fpi.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fph - (TopicVideoControllerView.this.bBq() % TopicVideoControllerView.this.fph));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fpp = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fpi.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fpi.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fpj != null) {
                        TopicVideoControllerView.this.fpj.setText(TopicVideoControllerView.this.AB((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bBq();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fph = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fpi != null && TopicVideoControllerView.this.fpi.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fph - (TopicVideoControllerView.this.bBq() % TopicVideoControllerView.this.fph));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fpp = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fpi.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fpi.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fpj != null) {
                        TopicVideoControllerView.this.fpj.setText(TopicVideoControllerView.this.AB((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bBq();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fph = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fpi != null && TopicVideoControllerView.this.fpi.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fph - (TopicVideoControllerView.this.bBq() % TopicVideoControllerView.this.fph));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fpp = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fpi.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.fpi.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fpj != null) {
                        TopicVideoControllerView.this.fpj.setText(TopicVideoControllerView.this.AB((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bBq();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fpj = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.fpk = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.fpl = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.fpl.setOnSeekBarChangeListener(this.fpp);
        this.jdl = new StringBuilder();
        this.jdm = new Formatter(this.jdl, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fpi = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fpl.setProgress(0);
        if (this.fpj != null) {
            this.fpj.setText(AB(i));
        }
        if (this.fpk != null) {
            this.fpk.setText(AB(AA(i2)));
        }
    }

    public void showProgress() {
        if (this.fpi != null) {
            this.fph = ((this.fpi.getDuration() / 200) / 50) * 50;
            if (this.fph < 50) {
                this.fph = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fph - (this.fpi.getCurrentPosition() % this.fph));
        }
    }

    public void aIm() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fpl.setProgress(0);
        if (this.fpj != null) {
            this.fpj.setText(AB(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bBq() {
        if (this.fpi == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fpi.getCurrentPosition();
        int duration = this.fpi.getDuration();
        if (this.fpl != null && duration > 0) {
            this.fpl.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.fpk != null && duration > 0) {
            this.fpk.setText(AB(AA(duration)));
        }
        if (this.fpj != null) {
            this.fpj.setText(AB(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int AA(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String AB(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.jdl.setLength(0);
        return i5 > 0 ? this.jdm.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.jdm.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fpj, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.fpk, R.color.cp_cont_a, 1);
        this.fpl.setProgressDrawable(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.fpl.setThumb(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.fpl.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.fpl != null) {
            return this.fpl.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
