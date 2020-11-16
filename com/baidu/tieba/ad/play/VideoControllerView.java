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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class VideoControllerView extends RelativeLayout {
    private int enb;
    private int fSr;
    private MediaController.MediaPlayerControl fSs;
    private TextView fSt;
    private TextView fSu;
    private SeekBar fSv;
    private b fSw;
    private a fSx;
    private SeekBar.OnSeekBarChangeListener fSy;
    private SeekBar.OnSeekBarChangeListener fSz;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes20.dex */
    public interface a {
        void bJa();
    }

    /* loaded from: classes20.dex */
    public interface b {
        void tN(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.fSr = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.enb = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fSs != null) {
                            int bIZ = VideoControllerView.this.bIZ();
                            if (VideoControllerView.this.fSw != null) {
                                VideoControllerView.this.fSw.tN(bIZ);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fSr - (bIZ % VideoControllerView.this.fSr));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fSz = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fSy != null) {
                    VideoControllerView.this.fSy.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.enb = (int) ((VideoControllerView.this.fSs.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fSt != null) {
                        VideoControllerView.this.fSt.setText(au.stringForVideoTime(VideoControllerView.this.enb));
                    }
                    if (VideoControllerView.this.fSx != null) {
                        VideoControllerView.this.fSx.bJa();
                    }
                    if (VideoControllerView.this.fSy != null) {
                        VideoControllerView.this.fSy.onProgressChanged(seekBar, VideoControllerView.this.enb, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fSs.seekTo(VideoControllerView.this.enb);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fSy != null) {
                    VideoControllerView.this.fSy.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fSr = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.enb = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fSs != null) {
                            int bIZ = VideoControllerView.this.bIZ();
                            if (VideoControllerView.this.fSw != null) {
                                VideoControllerView.this.fSw.tN(bIZ);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fSr - (bIZ % VideoControllerView.this.fSr));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fSz = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fSy != null) {
                    VideoControllerView.this.fSy.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.enb = (int) ((VideoControllerView.this.fSs.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fSt != null) {
                        VideoControllerView.this.fSt.setText(au.stringForVideoTime(VideoControllerView.this.enb));
                    }
                    if (VideoControllerView.this.fSx != null) {
                        VideoControllerView.this.fSx.bJa();
                    }
                    if (VideoControllerView.this.fSy != null) {
                        VideoControllerView.this.fSy.onProgressChanged(seekBar, VideoControllerView.this.enb, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fSs.seekTo(VideoControllerView.this.enb);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fSy != null) {
                    VideoControllerView.this.fSy.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fSr = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.enb = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fSs != null) {
                            int bIZ = VideoControllerView.this.bIZ();
                            if (VideoControllerView.this.fSw != null) {
                                VideoControllerView.this.fSw.tN(bIZ);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fSr - (bIZ % VideoControllerView.this.fSr));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fSz = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fSy != null) {
                    VideoControllerView.this.fSy.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.enb = (int) ((VideoControllerView.this.fSs.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.fSt != null) {
                        VideoControllerView.this.fSt.setText(au.stringForVideoTime(VideoControllerView.this.enb));
                    }
                    if (VideoControllerView.this.fSx != null) {
                        VideoControllerView.this.fSx.bJa();
                    }
                    if (VideoControllerView.this.fSy != null) {
                        VideoControllerView.this.fSy.onProgressChanged(seekBar, VideoControllerView.this.enb, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fSs.seekTo(VideoControllerView.this.enb);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fSy != null) {
                    VideoControllerView.this.fSy.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View eH = eH(context);
        addView(eH, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fSt = (TextView) eH.findViewById(R.id.textview_cur_time);
        this.fSu = (TextView) eH.findViewById(R.id.textview_duration);
        this.fSv = (SeekBar) eH.findViewById(R.id.pb_video_controller_seekBar);
        this.fSv.setOnSeekBarChangeListener(this.fSz);
    }

    protected View eH(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fSs = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fSv.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.fSt != null) {
            this.fSt.setText(au.stringForVideoTime(i));
        }
        if (this.fSu != null) {
            this.fSu.setText(au.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.fSs != null) {
            this.fSr = ((this.fSs.getDuration() / 200) / 50) * 50;
            if (this.fSr < 50) {
                this.fSr = 50;
            } else if (this.fSr > 500) {
                this.fSr = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fSr - (this.fSs.getCurrentPosition() % this.fSr));
        }
    }

    public void aPs() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fSv.setProgress(0);
        if (this.fSt != null) {
            this.fSt.setText(au.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bIZ() {
        if (this.fSs == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fSs.getCurrentPosition();
        int duration = this.fSs.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.fSv != null) {
            if (duration > 0) {
                this.fSv.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.fSs.getBufferPercentage();
        }
        if (this.fSt != null) {
            this.fSt.setText(au.stringForVideoTime(currentPosition));
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
            this.fSs.seekTo(i);
            if (this.fSt != null) {
                this.fSt.setText(au.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.fSs.isPlaying()) {
            this.fSv.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.enb;
    }

    public int getCurProgress() {
        if (this.fSv != null) {
            return this.fSv.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.fSw = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.fSx = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.fSy = onSeekBarChangeListener;
    }
}
