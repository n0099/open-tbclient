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
    private int eoL;
    private int fSK;
    private MediaController.MediaPlayerControl fSL;
    private TextView fSM;
    private TextView fSN;
    private SeekBar fSO;
    private b fSP;
    private a fSQ;
    private SeekBar.OnSeekBarChangeListener fSR;
    private SeekBar.OnSeekBarChangeListener fSS;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes21.dex */
    public interface a {
        void bJH();
    }

    /* loaded from: classes21.dex */
    public interface b {
        void tp(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.fSK = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eoL = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fSL != null) {
                            int bJG = VideoControllerView.this.bJG();
                            if (VideoControllerView.this.fSP != null) {
                                VideoControllerView.this.fSP.tp(bJG);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fSK - (bJG % VideoControllerView.this.fSK));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fSS = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fSR != null) {
                    VideoControllerView.this.fSR.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eoL = (int) ((VideoControllerView.this.fSL.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fSM != null) {
                        VideoControllerView.this.fSM.setText(at.stringForVideoTime(VideoControllerView.this.eoL));
                    }
                    if (VideoControllerView.this.fSQ != null) {
                        VideoControllerView.this.fSQ.bJH();
                    }
                    if (VideoControllerView.this.fSR != null) {
                        VideoControllerView.this.fSR.onProgressChanged(seekBar, VideoControllerView.this.eoL, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fSL.seekTo(VideoControllerView.this.eoL);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fSR != null) {
                    VideoControllerView.this.fSR.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fSK = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eoL = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fSL != null) {
                            int bJG = VideoControllerView.this.bJG();
                            if (VideoControllerView.this.fSP != null) {
                                VideoControllerView.this.fSP.tp(bJG);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fSK - (bJG % VideoControllerView.this.fSK));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fSS = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fSR != null) {
                    VideoControllerView.this.fSR.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eoL = (int) ((VideoControllerView.this.fSL.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fSM != null) {
                        VideoControllerView.this.fSM.setText(at.stringForVideoTime(VideoControllerView.this.eoL));
                    }
                    if (VideoControllerView.this.fSQ != null) {
                        VideoControllerView.this.fSQ.bJH();
                    }
                    if (VideoControllerView.this.fSR != null) {
                        VideoControllerView.this.fSR.onProgressChanged(seekBar, VideoControllerView.this.eoL, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fSL.seekTo(VideoControllerView.this.eoL);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fSR != null) {
                    VideoControllerView.this.fSR.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fSK = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eoL = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fSL != null) {
                            int bJG = VideoControllerView.this.bJG();
                            if (VideoControllerView.this.fSP != null) {
                                VideoControllerView.this.fSP.tp(bJG);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fSK - (bJG % VideoControllerView.this.fSK));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fSS = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fSR != null) {
                    VideoControllerView.this.fSR.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eoL = (int) ((VideoControllerView.this.fSL.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.fSM != null) {
                        VideoControllerView.this.fSM.setText(at.stringForVideoTime(VideoControllerView.this.eoL));
                    }
                    if (VideoControllerView.this.fSQ != null) {
                        VideoControllerView.this.fSQ.bJH();
                    }
                    if (VideoControllerView.this.fSR != null) {
                        VideoControllerView.this.fSR.onProgressChanged(seekBar, VideoControllerView.this.eoL, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fSL.seekTo(VideoControllerView.this.eoL);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fSR != null) {
                    VideoControllerView.this.fSR.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View eH = eH(context);
        addView(eH, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fSM = (TextView) eH.findViewById(R.id.textview_cur_time);
        this.fSN = (TextView) eH.findViewById(R.id.textview_duration);
        this.fSO = (SeekBar) eH.findViewById(R.id.pb_video_controller_seekBar);
        this.fSO.setOnSeekBarChangeListener(this.fSS);
    }

    protected View eH(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fSL = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fSO.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.fSM != null) {
            this.fSM.setText(at.stringForVideoTime(i));
        }
        if (this.fSN != null) {
            this.fSN.setText(at.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.fSL != null) {
            this.fSK = ((this.fSL.getDuration() / 200) / 50) * 50;
            if (this.fSK < 50) {
                this.fSK = 50;
            } else if (this.fSK > 500) {
                this.fSK = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fSK - (this.fSL.getCurrentPosition() % this.fSK));
        }
    }

    public void aQa() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fSO.setProgress(0);
        if (this.fSM != null) {
            this.fSM.setText(at.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bJG() {
        if (this.fSL == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fSL.getCurrentPosition();
        int duration = this.fSL.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.fSO != null) {
            if (duration > 0) {
                this.fSO.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.fSL.getBufferPercentage();
        }
        if (this.fSM != null) {
            this.fSM.setText(at.stringForVideoTime(currentPosition));
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
            this.fSL.seekTo(i);
            if (this.fSM != null) {
                this.fSM.setText(at.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.fSL.isPlaying()) {
            this.fSO.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.eoL;
    }

    public int getCurProgress() {
        if (this.fSO != null) {
            return this.fSO.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.fSP = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.fSQ = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.fSR = onSeekBarChangeListener;
    }
}
