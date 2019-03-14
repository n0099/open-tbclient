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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class VideoControllerView extends RelativeLayout {
    private int cNL;
    private MediaController.MediaPlayerControl cNM;
    private TextView cNN;
    private TextView cNO;
    private SeekBar cNP;
    private b cNQ;
    private a cNR;
    private SeekBar.OnSeekBarChangeListener cNS;
    private int cNT;
    private SeekBar.OnSeekBarChangeListener cNU;
    private boolean cxQ;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes3.dex */
    public interface a {
        void awL();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void lz(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.cNL = 50;
        this.cxQ = false;
        this.mShowing = true;
        this.cNT = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cxQ && VideoControllerView.this.mShowing && VideoControllerView.this.cNM != null) {
                            int awK = VideoControllerView.this.awK();
                            if (VideoControllerView.this.cNQ != null) {
                                VideoControllerView.this.cNQ.lz(awK);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cNL - (awK % VideoControllerView.this.cNL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cNU = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cxQ = true;
                if (VideoControllerView.this.cNS != null) {
                    VideoControllerView.this.cNS.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cNT = (int) ((VideoControllerView.this.cNM.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cNN != null) {
                        VideoControllerView.this.cNN.setText(ap.hz(VideoControllerView.this.cNT));
                    }
                    if (VideoControllerView.this.cNR != null) {
                        VideoControllerView.this.cNR.awL();
                    }
                    if (VideoControllerView.this.cNS != null) {
                        VideoControllerView.this.cNS.onProgressChanged(seekBar, VideoControllerView.this.cNT, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cNM.seekTo(VideoControllerView.this.cNT);
                VideoControllerView.this.cxQ = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cNS != null) {
                    VideoControllerView.this.cNS.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cNL = 50;
        this.cxQ = false;
        this.mShowing = true;
        this.cNT = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cxQ && VideoControllerView.this.mShowing && VideoControllerView.this.cNM != null) {
                            int awK = VideoControllerView.this.awK();
                            if (VideoControllerView.this.cNQ != null) {
                                VideoControllerView.this.cNQ.lz(awK);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cNL - (awK % VideoControllerView.this.cNL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cNU = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cxQ = true;
                if (VideoControllerView.this.cNS != null) {
                    VideoControllerView.this.cNS.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cNT = (int) ((VideoControllerView.this.cNM.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cNN != null) {
                        VideoControllerView.this.cNN.setText(ap.hz(VideoControllerView.this.cNT));
                    }
                    if (VideoControllerView.this.cNR != null) {
                        VideoControllerView.this.cNR.awL();
                    }
                    if (VideoControllerView.this.cNS != null) {
                        VideoControllerView.this.cNS.onProgressChanged(seekBar, VideoControllerView.this.cNT, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cNM.seekTo(VideoControllerView.this.cNT);
                VideoControllerView.this.cxQ = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cNS != null) {
                    VideoControllerView.this.cNS.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cNL = 50;
        this.cxQ = false;
        this.mShowing = true;
        this.cNT = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cxQ && VideoControllerView.this.mShowing && VideoControllerView.this.cNM != null) {
                            int awK = VideoControllerView.this.awK();
                            if (VideoControllerView.this.cNQ != null) {
                                VideoControllerView.this.cNQ.lz(awK);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cNL - (awK % VideoControllerView.this.cNL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cNU = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cxQ = true;
                if (VideoControllerView.this.cNS != null) {
                    VideoControllerView.this.cNS.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.cNT = (int) ((VideoControllerView.this.cNM.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.cNN != null) {
                        VideoControllerView.this.cNN.setText(ap.hz(VideoControllerView.this.cNT));
                    }
                    if (VideoControllerView.this.cNR != null) {
                        VideoControllerView.this.cNR.awL();
                    }
                    if (VideoControllerView.this.cNS != null) {
                        VideoControllerView.this.cNS.onProgressChanged(seekBar, VideoControllerView.this.cNT, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cNM.seekTo(VideoControllerView.this.cNT);
                VideoControllerView.this.cxQ = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cNS != null) {
                    VideoControllerView.this.cNS.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View dr = dr(context);
        addView(dr, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.cNN = (TextView) dr.findViewById(d.g.textview_cur_time);
        this.cNO = (TextView) dr.findViewById(d.g.textview_duration);
        this.cNP = (SeekBar) dr.findViewById(d.g.pb_video_controller_seekBar);
        this.cNP.setOnSeekBarChangeListener(this.cNU);
    }

    protected View dr(Context context) {
        return LayoutInflater.from(context).inflate(d.h.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cNM = mediaPlayerControl;
    }

    public void ax(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cNP.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.cNN != null) {
            this.cNN.setText(ap.hz(i));
        }
        if (this.cNO != null) {
            this.cNO.setText(ap.hz(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.cNM != null) {
            this.cNL = ((this.cNM.getDuration() / 200) / 50) * 50;
            if (this.cNL < 50) {
                this.cNL = 50;
            } else if (this.cNL > 500) {
                this.cNL = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cNL - (this.cNM.getCurrentPosition() % this.cNL));
        }
    }

    public void awJ() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cNP.setProgress(0);
        if (this.cNN != null) {
            this.cNN.setText(ap.hz(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int awK() {
        if (this.cNM == null || this.cxQ) {
            return 0;
        }
        int currentPosition = this.cNM.getCurrentPosition();
        int duration = this.cNM.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.cNP != null) {
            if (duration > 0) {
                this.cNP.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cNM.getBufferPercentage();
        }
        if (this.cNN != null) {
            this.cNN.setText(ap.hz(currentPosition));
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
            this.cNM.seekTo(i);
            if (this.cNN != null) {
                this.cNN.setText(ap.hz(i));
            }
            showProgress();
        }
        if (!this.cNM.isPlaying()) {
            this.cNP.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.cNT;
    }

    public int getCurProgress() {
        if (this.cNP != null) {
            return this.cNP.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.cNQ = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.cNR = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.cNS = onSeekBarChangeListener;
    }
}
