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
    private int fpd;
    private MediaController.MediaPlayerControl fpe;
    private TextView fpf;
    private TextView fpg;
    private SeekBar fph;
    private SeekBar.OnSeekBarChangeListener fpl;
    private StringBuilder jdf;
    private Formatter jdg;
    private boolean mDragging;
    private Handler mHandler;
    private boolean mShowing;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.fpd = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fpe != null && TopicVideoControllerView.this.fpe.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fpd - (TopicVideoControllerView.this.bBp() % TopicVideoControllerView.this.fpd));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fpl = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fpe.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fpe.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fpf != null) {
                        TopicVideoControllerView.this.fpf.setText(TopicVideoControllerView.this.AB((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bBp();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fpd = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fpe != null && TopicVideoControllerView.this.fpe.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fpd - (TopicVideoControllerView.this.bBp() % TopicVideoControllerView.this.fpd));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fpl = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fpe.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.fpe.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fpf != null) {
                        TopicVideoControllerView.this.fpf.setText(TopicVideoControllerView.this.AB((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bBp();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fpd = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.fpe != null && TopicVideoControllerView.this.fpe.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.fpd - (TopicVideoControllerView.this.bBp() % TopicVideoControllerView.this.fpd));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fpl = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.fpe.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.fpe.seekTo((int) duration);
                    if (TopicVideoControllerView.this.fpf != null) {
                        TopicVideoControllerView.this.fpf.setText(TopicVideoControllerView.this.AB((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bBp();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fpf = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.fpg = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.fph = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.fph.setOnSeekBarChangeListener(this.fpl);
        this.jdf = new StringBuilder();
        this.jdg = new Formatter(this.jdf, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fpe = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fph.setProgress(0);
        if (this.fpf != null) {
            this.fpf.setText(AB(i));
        }
        if (this.fpg != null) {
            this.fpg.setText(AB(AA(i2)));
        }
    }

    public void showProgress() {
        if (this.fpe != null) {
            this.fpd = ((this.fpe.getDuration() / 200) / 50) * 50;
            if (this.fpd < 50) {
                this.fpd = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fpd - (this.fpe.getCurrentPosition() % this.fpd));
        }
    }

    public void aIm() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fph.setProgress(0);
        if (this.fpf != null) {
            this.fpf.setText(AB(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bBp() {
        if (this.fpe == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fpe.getCurrentPosition();
        int duration = this.fpe.getDuration();
        if (this.fph != null && duration > 0) {
            this.fph.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.fpg != null && duration > 0) {
            this.fpg.setText(AB(AA(duration)));
        }
        if (this.fpf != null) {
            this.fpf.setText(AB(currentPosition));
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
        this.jdf.setLength(0);
        return i5 > 0 ? this.jdg.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.jdg.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fpf, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.fpg, R.color.cp_cont_a, 1);
        this.fph.setProgressDrawable(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.fph.setThumb(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.fph.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.fph != null) {
            return this.fph.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
