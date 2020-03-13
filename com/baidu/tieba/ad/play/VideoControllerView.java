package com.baidu.tieba.ad.play;

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class VideoControllerView extends RelativeLayout {
    private int eaf;
    private MediaController.MediaPlayerControl eag;
    private TextView eah;
    private TextView eai;
    private SeekBar eaj;
    private b eak;
    private a eal;
    private SeekBar.OnSeekBarChangeListener eam;
    private int ean;
    private SeekBar.OnSeekBarChangeListener eao;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes8.dex */
    public interface a {
        void aYx();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void oi(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.eaf = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.ean = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eag != null) {
                            int aYw = VideoControllerView.this.aYw();
                            if (VideoControllerView.this.eak != null) {
                                VideoControllerView.this.eak.oi(aYw);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eaf - (aYw % VideoControllerView.this.eaf));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eao = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eam != null) {
                    VideoControllerView.this.eam.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.ean = (int) ((VideoControllerView.this.eag.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eah != null) {
                        VideoControllerView.this.eah.setText(aq.stringForVideoTime(VideoControllerView.this.ean));
                    }
                    if (VideoControllerView.this.eal != null) {
                        VideoControllerView.this.eal.aYx();
                    }
                    if (VideoControllerView.this.eam != null) {
                        VideoControllerView.this.eam.onProgressChanged(seekBar, VideoControllerView.this.ean, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.eag.seekTo(VideoControllerView.this.ean);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eam != null) {
                    VideoControllerView.this.eam.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eaf = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.ean = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eag != null) {
                            int aYw = VideoControllerView.this.aYw();
                            if (VideoControllerView.this.eak != null) {
                                VideoControllerView.this.eak.oi(aYw);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eaf - (aYw % VideoControllerView.this.eaf));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eao = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eam != null) {
                    VideoControllerView.this.eam.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.ean = (int) ((VideoControllerView.this.eag.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eah != null) {
                        VideoControllerView.this.eah.setText(aq.stringForVideoTime(VideoControllerView.this.ean));
                    }
                    if (VideoControllerView.this.eal != null) {
                        VideoControllerView.this.eal.aYx();
                    }
                    if (VideoControllerView.this.eam != null) {
                        VideoControllerView.this.eam.onProgressChanged(seekBar, VideoControllerView.this.ean, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.eag.seekTo(VideoControllerView.this.ean);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eam != null) {
                    VideoControllerView.this.eam.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eaf = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.ean = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eag != null) {
                            int aYw = VideoControllerView.this.aYw();
                            if (VideoControllerView.this.eak != null) {
                                VideoControllerView.this.eak.oi(aYw);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eaf - (aYw % VideoControllerView.this.eaf));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eao = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eam != null) {
                    VideoControllerView.this.eam.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.ean = (int) ((VideoControllerView.this.eag.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.eah != null) {
                        VideoControllerView.this.eah.setText(aq.stringForVideoTime(VideoControllerView.this.ean));
                    }
                    if (VideoControllerView.this.eal != null) {
                        VideoControllerView.this.eal.aYx();
                    }
                    if (VideoControllerView.this.eam != null) {
                        VideoControllerView.this.eam.onProgressChanged(seekBar, VideoControllerView.this.ean, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.eag.seekTo(VideoControllerView.this.ean);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eam != null) {
                    VideoControllerView.this.eam.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View es = es(context);
        addView(es, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.eah = (TextView) es.findViewById(R.id.textview_cur_time);
        this.eai = (TextView) es.findViewById(R.id.textview_duration);
        this.eaj = (SeekBar) es.findViewById(R.id.pb_video_controller_seekBar);
        this.eaj.setOnSeekBarChangeListener(this.eao);
    }

    protected View es(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eag = mediaPlayerControl;
    }

    public void aZ(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eaj.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.eah != null) {
            this.eah.setText(aq.stringForVideoTime(i));
        }
        if (this.eai != null) {
            this.eai.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.eag != null) {
            this.eaf = ((this.eag.getDuration() / 200) / 50) * 50;
            if (this.eaf < 50) {
                this.eaf = 50;
            } else if (this.eaf > 500) {
                this.eaf = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eaf - (this.eag.getCurrentPosition() % this.eaf));
        }
    }

    public void akj() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eaj.setProgress(0);
        if (this.eah != null) {
            this.eah.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aYw() {
        if (this.eag == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.eag.getCurrentPosition();
        int duration = this.eag.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.eaj != null) {
            if (duration > 0) {
                this.eaj.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.eag.getBufferPercentage();
        }
        if (this.eah != null) {
            this.eah.setText(aq.stringForVideoTime(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public void setCurrentDuration(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
            }
        } else {
            this.eag.seekTo(i);
            if (this.eah != null) {
                this.eah.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.eag.isPlaying()) {
            this.eaj.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.ean;
    }

    public int getCurProgress() {
        if (this.eaj != null) {
            return this.eaj.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.eak = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.eal = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.eam = onSeekBarChangeListener;
    }
}
