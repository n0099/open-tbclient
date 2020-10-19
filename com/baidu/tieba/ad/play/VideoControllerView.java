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
    private int eau;
    private MediaController.MediaPlayerControl fEA;
    private TextView fEB;
    private TextView fEC;
    private SeekBar fED;
    private b fEE;
    private a fEF;
    private SeekBar.OnSeekBarChangeListener fEG;
    private SeekBar.OnSeekBarChangeListener fEH;
    private int fEz;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes21.dex */
    public interface a {
        void bFp();
    }

    /* loaded from: classes21.dex */
    public interface b {
        void sU(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.fEz = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eau = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fEA != null) {
                            int bFo = VideoControllerView.this.bFo();
                            if (VideoControllerView.this.fEE != null) {
                                VideoControllerView.this.fEE.sU(bFo);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fEz - (bFo % VideoControllerView.this.fEz));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fEH = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fEG != null) {
                    VideoControllerView.this.fEG.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eau = (int) ((VideoControllerView.this.fEA.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fEB != null) {
                        VideoControllerView.this.fEB.setText(at.stringForVideoTime(VideoControllerView.this.eau));
                    }
                    if (VideoControllerView.this.fEF != null) {
                        VideoControllerView.this.fEF.bFp();
                    }
                    if (VideoControllerView.this.fEG != null) {
                        VideoControllerView.this.fEG.onProgressChanged(seekBar, VideoControllerView.this.eau, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fEA.seekTo(VideoControllerView.this.eau);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fEG != null) {
                    VideoControllerView.this.fEG.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEz = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eau = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fEA != null) {
                            int bFo = VideoControllerView.this.bFo();
                            if (VideoControllerView.this.fEE != null) {
                                VideoControllerView.this.fEE.sU(bFo);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fEz - (bFo % VideoControllerView.this.fEz));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fEH = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fEG != null) {
                    VideoControllerView.this.fEG.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eau = (int) ((VideoControllerView.this.fEA.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fEB != null) {
                        VideoControllerView.this.fEB.setText(at.stringForVideoTime(VideoControllerView.this.eau));
                    }
                    if (VideoControllerView.this.fEF != null) {
                        VideoControllerView.this.fEF.bFp();
                    }
                    if (VideoControllerView.this.fEG != null) {
                        VideoControllerView.this.fEG.onProgressChanged(seekBar, VideoControllerView.this.eau, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fEA.seekTo(VideoControllerView.this.eau);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fEG != null) {
                    VideoControllerView.this.fEG.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEz = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eau = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fEA != null) {
                            int bFo = VideoControllerView.this.bFo();
                            if (VideoControllerView.this.fEE != null) {
                                VideoControllerView.this.fEE.sU(bFo);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fEz - (bFo % VideoControllerView.this.fEz));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fEH = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fEG != null) {
                    VideoControllerView.this.fEG.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eau = (int) ((VideoControllerView.this.fEA.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.fEB != null) {
                        VideoControllerView.this.fEB.setText(at.stringForVideoTime(VideoControllerView.this.eau));
                    }
                    if (VideoControllerView.this.fEF != null) {
                        VideoControllerView.this.fEF.bFp();
                    }
                    if (VideoControllerView.this.fEG != null) {
                        VideoControllerView.this.fEG.onProgressChanged(seekBar, VideoControllerView.this.eau, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fEA.seekTo(VideoControllerView.this.eau);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fEG != null) {
                    VideoControllerView.this.fEG.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View eH = eH(context);
        addView(eH, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fEB = (TextView) eH.findViewById(R.id.textview_cur_time);
        this.fEC = (TextView) eH.findViewById(R.id.textview_duration);
        this.fED = (SeekBar) eH.findViewById(R.id.pb_video_controller_seekBar);
        this.fED.setOnSeekBarChangeListener(this.fEH);
    }

    protected View eH(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fEA = mediaPlayerControl;
    }

    public void by(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fED.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.fEB != null) {
            this.fEB.setText(at.stringForVideoTime(i));
        }
        if (this.fEC != null) {
            this.fEC.setText(at.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.fEA != null) {
            this.fEz = ((this.fEA.getDuration() / 200) / 50) * 50;
            if (this.fEz < 50) {
                this.fEz = 50;
            } else if (this.fEz > 500) {
                this.fEz = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fEz - (this.fEA.getCurrentPosition() % this.fEz));
        }
    }

    public void aLG() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fED.setProgress(0);
        if (this.fEB != null) {
            this.fEB.setText(at.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bFo() {
        if (this.fEA == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fEA.getCurrentPosition();
        int duration = this.fEA.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.fED != null) {
            if (duration > 0) {
                this.fED.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.fEA.getBufferPercentage();
        }
        if (this.fEB != null) {
            this.fEB.setText(at.stringForVideoTime(currentPosition));
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
            this.fEA.seekTo(i);
            if (this.fEB != null) {
                this.fEB.setText(at.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.fEA.isPlaying()) {
            this.fED.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.eau;
    }

    public int getCurProgress() {
        if (this.fED != null) {
            return this.fED.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.fEE = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.fEF = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.fEG = onSeekBarChangeListener;
    }
}
