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
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes7.dex */
public class TopicVideoControllerView extends RelativeLayout {
    private boolean bdq;
    private SeekBar.OnSeekBarChangeListener gjB;
    private int gjt;
    private MediaController.MediaPlayerControl gju;
    private TextView gjv;
    private TextView gjw;
    private SeekBar gjx;
    private StringBuilder kAF;
    private Formatter kAG;
    private boolean mDragging;
    private Handler mHandler;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.gjt = 50;
        this.mDragging = false;
        this.bdq = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bdq && TopicVideoControllerView.this.gju != null && TopicVideoControllerView.this.gju.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.gjt - (TopicVideoControllerView.this.bLO() % TopicVideoControllerView.this.gjt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gjB = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.gju.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.gju.seekTo((int) duration);
                    if (TopicVideoControllerView.this.gjv != null) {
                        TopicVideoControllerView.this.gjv.setText(TopicVideoControllerView.this.CD((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bLO();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjt = 50;
        this.mDragging = false;
        this.bdq = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bdq && TopicVideoControllerView.this.gju != null && TopicVideoControllerView.this.gju.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.gjt - (TopicVideoControllerView.this.bLO() % TopicVideoControllerView.this.gjt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gjB = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.gju.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.gju.seekTo((int) duration);
                    if (TopicVideoControllerView.this.gjv != null) {
                        TopicVideoControllerView.this.gjv.setText(TopicVideoControllerView.this.CD((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bLO();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjt = 50;
        this.mDragging = false;
        this.bdq = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bdq && TopicVideoControllerView.this.gju != null && TopicVideoControllerView.this.gju.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.gjt - (TopicVideoControllerView.this.bLO() % TopicVideoControllerView.this.gjt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gjB = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.gju.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.gju.seekTo((int) duration);
                    if (TopicVideoControllerView.this.gjv != null) {
                        TopicVideoControllerView.this.gjv.setText(TopicVideoControllerView.this.CD((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bLO();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.gjv = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.gjw = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.gjx = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.gjx.setOnSeekBarChangeListener(this.gjB);
        this.kAF = new StringBuilder();
        this.kAG = new Formatter(this.kAF, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gju = mediaPlayerControl;
    }

    public void bx(int i, int i2) {
        this.bdq = false;
        this.mHandler.removeMessages(1);
        this.gjx.setProgress(0);
        if (this.gjv != null) {
            this.gjv.setText(CD(i));
        }
        if (this.gjw != null) {
            this.gjw.setText(CD(CC(i2)));
        }
    }

    public void showProgress() {
        if (this.gju != null) {
            this.gjt = ((this.gju.getDuration() / 200) / 50) * 50;
            if (this.gjt < 50) {
                this.gjt = 50;
            }
            this.bdq = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gjt - (this.gju.getCurrentPosition() % this.gjt));
        }
    }

    public void aRr() {
        this.bdq = false;
        this.mHandler.removeMessages(1);
        this.gjx.setProgress(0);
        if (this.gjv != null) {
            this.gjv.setText(CD(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bLO() {
        if (this.gju == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.gju.getCurrentPosition();
        int duration = this.gju.getDuration();
        if (this.gjx != null && duration > 0) {
            this.gjx.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.gjw != null && duration > 0) {
            this.gjw.setText(CD(CC(duration)));
        }
        if (this.gjv != null) {
            this.gjv.setText(CD(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int CC(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String CD(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        this.kAF.setLength(0);
        return i5 > 0 ? this.kAG.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.kAG.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.gjv, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.gjw, R.color.CAM_X0101, 1);
        this.gjx.setProgressDrawable(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.gjx.setThumb(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.gjx.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.gjx != null) {
            return this.gjx.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
