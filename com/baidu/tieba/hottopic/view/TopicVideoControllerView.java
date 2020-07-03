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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes8.dex */
public class TopicVideoControllerView extends RelativeLayout {
    private int eZj;
    private MediaController.MediaPlayerControl eZk;
    private TextView eZl;
    private TextView eZm;
    private SeekBar eZn;
    private SeekBar.OnSeekBarChangeListener eZr;
    private StringBuilder iIb;
    private Formatter iIc;
    private boolean mDragging;
    private Handler mHandler;
    private boolean mShowing;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.eZj = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.eZk != null && TopicVideoControllerView.this.eZk.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.eZj - (TopicVideoControllerView.this.bpp() % TopicVideoControllerView.this.eZj));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eZr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.eZk.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.eZk.seekTo((int) duration);
                    if (TopicVideoControllerView.this.eZl != null) {
                        TopicVideoControllerView.this.eZl.setText(TopicVideoControllerView.this.xP((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bpp();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eZj = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.eZk != null && TopicVideoControllerView.this.eZk.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.eZj - (TopicVideoControllerView.this.bpp() % TopicVideoControllerView.this.eZj));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eZr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.eZk.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.eZk.seekTo((int) duration);
                    if (TopicVideoControllerView.this.eZl != null) {
                        TopicVideoControllerView.this.eZl.setText(TopicVideoControllerView.this.xP((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bpp();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eZj = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.mShowing && TopicVideoControllerView.this.eZk != null && TopicVideoControllerView.this.eZk.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.eZj - (TopicVideoControllerView.this.bpp() % TopicVideoControllerView.this.eZj));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eZr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.eZk.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.eZk.seekTo((int) duration);
                    if (TopicVideoControllerView.this.eZl != null) {
                        TopicVideoControllerView.this.eZl.setText(TopicVideoControllerView.this.xP((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bpp();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.eZl = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.eZm = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.eZn = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.eZn.setOnSeekBarChangeListener(this.eZr);
        this.iIb = new StringBuilder();
        this.iIc = new Formatter(this.iIb, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eZk = mediaPlayerControl;
    }

    public void bn(int i, int i2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eZn.setProgress(0);
        if (this.eZl != null) {
            this.eZl.setText(xP(i));
        }
        if (this.eZm != null) {
            this.eZm.setText(xP(xO(i2)));
        }
    }

    public void showProgress() {
        if (this.eZk != null) {
            this.eZj = ((this.eZk.getDuration() / 200) / 50) * 50;
            if (this.eZj < 50) {
                this.eZj = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eZj - (this.eZk.getCurrentPosition() % this.eZj));
        }
    }

    public void axj() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eZn.setProgress(0);
        if (this.eZl != null) {
            this.eZl.setText(xP(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bpp() {
        if (this.eZk == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.eZk.getCurrentPosition();
        int duration = this.eZk.getDuration();
        if (this.eZn != null && duration > 0) {
            this.eZn.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.eZm != null && duration > 0) {
            this.eZm.setText(xP(xO(duration)));
        }
        if (this.eZl != null) {
            this.eZl.setText(xP(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int xO(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String xP(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.iIb.setLength(0);
        return i5 > 0 ? this.iIc.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.iIc.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        an.setViewTextColor(this.eZl, R.color.cp_cont_a, 1);
        an.setViewTextColor(this.eZm, R.color.cp_cont_a, 1);
        this.eZn.setProgressDrawable(an.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.eZn.setThumb(an.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.eZn.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.eZn != null) {
            return this.eZn.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
