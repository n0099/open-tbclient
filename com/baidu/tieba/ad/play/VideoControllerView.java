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
/* loaded from: classes21.dex */
public class VideoControllerView extends RelativeLayout {
    private int eiR;
    private int fMU;
    private MediaController.MediaPlayerControl fMV;
    private TextView fMW;
    private TextView fMX;
    private SeekBar fMY;
    private b fMZ;
    private a fNa;
    private SeekBar.OnSeekBarChangeListener fNb;
    private SeekBar.OnSeekBarChangeListener fNc;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes21.dex */
    public interface a {
        void bHi();
    }

    /* loaded from: classes21.dex */
    public interface b {
        void tf(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.fMU = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eiR = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fMV != null) {
                            int bHh = VideoControllerView.this.bHh();
                            if (VideoControllerView.this.fMZ != null) {
                                VideoControllerView.this.fMZ.tf(bHh);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fMU - (bHh % VideoControllerView.this.fMU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fNc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fNb != null) {
                    VideoControllerView.this.fNb.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eiR = (int) ((VideoControllerView.this.fMV.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fMW != null) {
                        VideoControllerView.this.fMW.setText(at.stringForVideoTime(VideoControllerView.this.eiR));
                    }
                    if (VideoControllerView.this.fNa != null) {
                        VideoControllerView.this.fNa.bHi();
                    }
                    if (VideoControllerView.this.fNb != null) {
                        VideoControllerView.this.fNb.onProgressChanged(seekBar, VideoControllerView.this.eiR, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fMV.seekTo(VideoControllerView.this.eiR);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fNb != null) {
                    VideoControllerView.this.fNb.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fMU = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eiR = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fMV != null) {
                            int bHh = VideoControllerView.this.bHh();
                            if (VideoControllerView.this.fMZ != null) {
                                VideoControllerView.this.fMZ.tf(bHh);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fMU - (bHh % VideoControllerView.this.fMU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fNc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fNb != null) {
                    VideoControllerView.this.fNb.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eiR = (int) ((VideoControllerView.this.fMV.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fMW != null) {
                        VideoControllerView.this.fMW.setText(at.stringForVideoTime(VideoControllerView.this.eiR));
                    }
                    if (VideoControllerView.this.fNa != null) {
                        VideoControllerView.this.fNa.bHi();
                    }
                    if (VideoControllerView.this.fNb != null) {
                        VideoControllerView.this.fNb.onProgressChanged(seekBar, VideoControllerView.this.eiR, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fMV.seekTo(VideoControllerView.this.eiR);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fNb != null) {
                    VideoControllerView.this.fNb.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fMU = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eiR = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fMV != null) {
                            int bHh = VideoControllerView.this.bHh();
                            if (VideoControllerView.this.fMZ != null) {
                                VideoControllerView.this.fMZ.tf(bHh);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fMU - (bHh % VideoControllerView.this.fMU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fNc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fNb != null) {
                    VideoControllerView.this.fNb.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eiR = (int) ((VideoControllerView.this.fMV.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.fMW != null) {
                        VideoControllerView.this.fMW.setText(at.stringForVideoTime(VideoControllerView.this.eiR));
                    }
                    if (VideoControllerView.this.fNa != null) {
                        VideoControllerView.this.fNa.bHi();
                    }
                    if (VideoControllerView.this.fNb != null) {
                        VideoControllerView.this.fNb.onProgressChanged(seekBar, VideoControllerView.this.eiR, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fMV.seekTo(VideoControllerView.this.eiR);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fNb != null) {
                    VideoControllerView.this.fNb.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View eH = eH(context);
        addView(eH, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fMW = (TextView) eH.findViewById(R.id.textview_cur_time);
        this.fMX = (TextView) eH.findViewById(R.id.textview_duration);
        this.fMY = (SeekBar) eH.findViewById(R.id.pb_video_controller_seekBar);
        this.fMY.setOnSeekBarChangeListener(this.fNc);
    }

    protected View eH(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fMV = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fMY.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.fMW != null) {
            this.fMW.setText(at.stringForVideoTime(i));
        }
        if (this.fMX != null) {
            this.fMX.setText(at.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.fMV != null) {
            this.fMU = ((this.fMV.getDuration() / 200) / 50) * 50;
            if (this.fMU < 50) {
                this.fMU = 50;
            } else if (this.fMU > 500) {
                this.fMU = 500;
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
            this.fMW.setText(at.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bHh() {
        if (this.fMV == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fMV.getCurrentPosition();
        int duration = this.fMV.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.fMY != null) {
            if (duration > 0) {
                this.fMY.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.fMV.getBufferPercentage();
        }
        if (this.fMW != null) {
            this.fMW.setText(at.stringForVideoTime(currentPosition));
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
            this.fMV.seekTo(i);
            if (this.fMW != null) {
                this.fMW.setText(at.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.fMV.isPlaying()) {
            this.fMY.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.eiR;
    }

    public int getCurProgress() {
        if (this.fMY != null) {
            return this.fMY.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.fMZ = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.fNa = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.fNb = onSeekBarChangeListener;
    }
}
