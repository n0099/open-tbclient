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
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes7.dex */
public class TopicVideoControllerView extends RelativeLayout {
    private boolean aYJ;
    private int gfm;
    private MediaController.MediaPlayerControl gfn;
    private TextView gfo;
    private TextView gfp;
    private SeekBar gfq;
    private SeekBar.OnSeekBarChangeListener gfu;
    private StringBuilder kqi;
    private Formatter kqj;
    private boolean mDragging;
    private Handler mHandler;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.gfm = 50;
        this.mDragging = false;
        this.aYJ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.aYJ && TopicVideoControllerView.this.gfn != null && TopicVideoControllerView.this.gfn.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.gfm - (TopicVideoControllerView.this.bLj() % TopicVideoControllerView.this.gfm));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gfu = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.gfn.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.gfn.seekTo((int) duration);
                    if (TopicVideoControllerView.this.gfo != null) {
                        TopicVideoControllerView.this.gfo.setText(TopicVideoControllerView.this.Ci((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bLj();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gfm = 50;
        this.mDragging = false;
        this.aYJ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.aYJ && TopicVideoControllerView.this.gfn != null && TopicVideoControllerView.this.gfn.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.gfm - (TopicVideoControllerView.this.bLj() % TopicVideoControllerView.this.gfm));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gfu = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.gfn.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.gfn.seekTo((int) duration);
                    if (TopicVideoControllerView.this.gfo != null) {
                        TopicVideoControllerView.this.gfo.setText(TopicVideoControllerView.this.Ci((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bLj();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gfm = 50;
        this.mDragging = false;
        this.aYJ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.aYJ && TopicVideoControllerView.this.gfn != null && TopicVideoControllerView.this.gfn.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.gfm - (TopicVideoControllerView.this.bLj() % TopicVideoControllerView.this.gfm));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gfu = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.gfn.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.gfn.seekTo((int) duration);
                    if (TopicVideoControllerView.this.gfo != null) {
                        TopicVideoControllerView.this.gfo.setText(TopicVideoControllerView.this.Ci((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bLj();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.gfo = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.gfp = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.gfq = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.gfq.setOnSeekBarChangeListener(this.gfu);
        this.kqi = new StringBuilder();
        this.kqj = new Formatter(this.kqi, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gfn = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.aYJ = false;
        this.mHandler.removeMessages(1);
        this.gfq.setProgress(0);
        if (this.gfo != null) {
            this.gfo.setText(Ci(i));
        }
        if (this.gfp != null) {
            this.gfp.setText(Ci(Ch(i2)));
        }
    }

    public void showProgress() {
        if (this.gfn != null) {
            this.gfm = ((this.gfn.getDuration() / 200) / 50) * 50;
            if (this.gfm < 50) {
                this.gfm = 50;
            }
            this.aYJ = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gfm - (this.gfn.getCurrentPosition() % this.gfm));
        }
    }

    public void aQY() {
        this.aYJ = false;
        this.mHandler.removeMessages(1);
        this.gfq.setProgress(0);
        if (this.gfo != null) {
            this.gfo.setText(Ci(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bLj() {
        if (this.gfn == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.gfn.getCurrentPosition();
        int duration = this.gfn.getDuration();
        if (this.gfq != null && duration > 0) {
            this.gfq.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.gfp != null && duration > 0) {
            this.gfp.setText(Ci(Ch(duration)));
        }
        if (this.gfo != null) {
            this.gfo.setText(Ci(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int Ch(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Ci(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        this.kqi.setLength(0);
        return i5 > 0 ? this.kqj.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.kqj.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ao.setViewTextColor(this.gfo, R.color.CAM_X0101, 1);
        ao.setViewTextColor(this.gfp, R.color.CAM_X0101, 1);
        this.gfq.setProgressDrawable(ao.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.gfq.setThumb(ao.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.gfq.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.gfq != null) {
            return this.gfq.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
