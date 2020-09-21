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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class VideoControllerView extends RelativeLayout {
    private int dOt;
    private int fso;
    private MediaController.MediaPlayerControl fsp;
    private TextView fsq;
    private TextView fsr;
    private SeekBar fss;
    private b fst;
    private a fsu;
    private SeekBar.OnSeekBarChangeListener fsv;
    private SeekBar.OnSeekBarChangeListener fsw;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes20.dex */
    public interface a {
        void bCD();
    }

    /* loaded from: classes20.dex */
    public interface b {
        void sw(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.fso = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dOt = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fsp != null) {
                            int bCC = VideoControllerView.this.bCC();
                            if (VideoControllerView.this.fst != null) {
                                VideoControllerView.this.fst.sw(bCC);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fso - (bCC % VideoControllerView.this.fso));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fsw = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fsv != null) {
                    VideoControllerView.this.fsv.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dOt = (int) ((VideoControllerView.this.fsp.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fsq != null) {
                        VideoControllerView.this.fsq.setText(at.stringForVideoTime(VideoControllerView.this.dOt));
                    }
                    if (VideoControllerView.this.fsu != null) {
                        VideoControllerView.this.fsu.bCD();
                    }
                    if (VideoControllerView.this.fsv != null) {
                        VideoControllerView.this.fsv.onProgressChanged(seekBar, VideoControllerView.this.dOt, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fsp.seekTo(VideoControllerView.this.dOt);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fsv != null) {
                    VideoControllerView.this.fsv.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fso = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dOt = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fsp != null) {
                            int bCC = VideoControllerView.this.bCC();
                            if (VideoControllerView.this.fst != null) {
                                VideoControllerView.this.fst.sw(bCC);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fso - (bCC % VideoControllerView.this.fso));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fsw = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fsv != null) {
                    VideoControllerView.this.fsv.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dOt = (int) ((VideoControllerView.this.fsp.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fsq != null) {
                        VideoControllerView.this.fsq.setText(at.stringForVideoTime(VideoControllerView.this.dOt));
                    }
                    if (VideoControllerView.this.fsu != null) {
                        VideoControllerView.this.fsu.bCD();
                    }
                    if (VideoControllerView.this.fsv != null) {
                        VideoControllerView.this.fsv.onProgressChanged(seekBar, VideoControllerView.this.dOt, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fsp.seekTo(VideoControllerView.this.dOt);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fsv != null) {
                    VideoControllerView.this.fsv.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fso = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dOt = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fsp != null) {
                            int bCC = VideoControllerView.this.bCC();
                            if (VideoControllerView.this.fst != null) {
                                VideoControllerView.this.fst.sw(bCC);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fso - (bCC % VideoControllerView.this.fso));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fsw = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fsv != null) {
                    VideoControllerView.this.fsv.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dOt = (int) ((VideoControllerView.this.fsp.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.fsq != null) {
                        VideoControllerView.this.fsq.setText(at.stringForVideoTime(VideoControllerView.this.dOt));
                    }
                    if (VideoControllerView.this.fsu != null) {
                        VideoControllerView.this.fsu.bCD();
                    }
                    if (VideoControllerView.this.fsv != null) {
                        VideoControllerView.this.fsv.onProgressChanged(seekBar, VideoControllerView.this.dOt, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fsp.seekTo(VideoControllerView.this.dOt);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fsv != null) {
                    VideoControllerView.this.fsv.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View eA = eA(context);
        addView(eA, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fsq = (TextView) eA.findViewById(R.id.textview_cur_time);
        this.fsr = (TextView) eA.findViewById(R.id.textview_duration);
        this.fss = (SeekBar) eA.findViewById(R.id.pb_video_controller_seekBar);
        this.fss.setOnSeekBarChangeListener(this.fsw);
    }

    protected View eA(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fsp = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fss.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.fsq != null) {
            this.fsq.setText(at.stringForVideoTime(i));
        }
        if (this.fsr != null) {
            this.fsr.setText(at.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.fsp != null) {
            this.fso = ((this.fsp.getDuration() / 200) / 50) * 50;
            if (this.fso < 50) {
                this.fso = 50;
            } else if (this.fso > 500) {
                this.fso = 500;
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
            this.fsq.setText(at.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bCC() {
        if (this.fsp == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fsp.getCurrentPosition();
        int duration = this.fsp.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.fss != null) {
            if (duration > 0) {
                this.fss.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.fsp.getBufferPercentage();
        }
        if (this.fsq != null) {
            this.fsq.setText(at.stringForVideoTime(currentPosition));
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
            this.fsp.seekTo(i);
            if (this.fsq != null) {
                this.fsq.setText(at.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.fsp.isPlaying()) {
            this.fss.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.dOt;
    }

    public int getCurProgress() {
        if (this.fss != null) {
            return this.fss.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.fst = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.fsu = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.fsv = onSeekBarChangeListener;
    }
}
