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
    private int cNO;
    private MediaController.MediaPlayerControl cNP;
    private TextView cNQ;
    private TextView cNR;
    private SeekBar cNS;
    private b cNT;
    private a cNU;
    private SeekBar.OnSeekBarChangeListener cNV;
    private int cNW;
    private SeekBar.OnSeekBarChangeListener cNX;
    private boolean cxT;
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
        this.cNO = 50;
        this.cxT = false;
        this.mShowing = true;
        this.cNW = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cxT && VideoControllerView.this.mShowing && VideoControllerView.this.cNP != null) {
                            int awK = VideoControllerView.this.awK();
                            if (VideoControllerView.this.cNT != null) {
                                VideoControllerView.this.cNT.lz(awK);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cNO - (awK % VideoControllerView.this.cNO));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cNX = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cxT = true;
                if (VideoControllerView.this.cNV != null) {
                    VideoControllerView.this.cNV.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cNW = (int) ((VideoControllerView.this.cNP.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cNQ != null) {
                        VideoControllerView.this.cNQ.setText(ap.hz(VideoControllerView.this.cNW));
                    }
                    if (VideoControllerView.this.cNU != null) {
                        VideoControllerView.this.cNU.awL();
                    }
                    if (VideoControllerView.this.cNV != null) {
                        VideoControllerView.this.cNV.onProgressChanged(seekBar, VideoControllerView.this.cNW, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cNP.seekTo(VideoControllerView.this.cNW);
                VideoControllerView.this.cxT = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cNV != null) {
                    VideoControllerView.this.cNV.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cNO = 50;
        this.cxT = false;
        this.mShowing = true;
        this.cNW = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cxT && VideoControllerView.this.mShowing && VideoControllerView.this.cNP != null) {
                            int awK = VideoControllerView.this.awK();
                            if (VideoControllerView.this.cNT != null) {
                                VideoControllerView.this.cNT.lz(awK);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cNO - (awK % VideoControllerView.this.cNO));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cNX = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cxT = true;
                if (VideoControllerView.this.cNV != null) {
                    VideoControllerView.this.cNV.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cNW = (int) ((VideoControllerView.this.cNP.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cNQ != null) {
                        VideoControllerView.this.cNQ.setText(ap.hz(VideoControllerView.this.cNW));
                    }
                    if (VideoControllerView.this.cNU != null) {
                        VideoControllerView.this.cNU.awL();
                    }
                    if (VideoControllerView.this.cNV != null) {
                        VideoControllerView.this.cNV.onProgressChanged(seekBar, VideoControllerView.this.cNW, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cNP.seekTo(VideoControllerView.this.cNW);
                VideoControllerView.this.cxT = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cNV != null) {
                    VideoControllerView.this.cNV.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cNO = 50;
        this.cxT = false;
        this.mShowing = true;
        this.cNW = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cxT && VideoControllerView.this.mShowing && VideoControllerView.this.cNP != null) {
                            int awK = VideoControllerView.this.awK();
                            if (VideoControllerView.this.cNT != null) {
                                VideoControllerView.this.cNT.lz(awK);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cNO - (awK % VideoControllerView.this.cNO));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cNX = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cxT = true;
                if (VideoControllerView.this.cNV != null) {
                    VideoControllerView.this.cNV.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.cNW = (int) ((VideoControllerView.this.cNP.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.cNQ != null) {
                        VideoControllerView.this.cNQ.setText(ap.hz(VideoControllerView.this.cNW));
                    }
                    if (VideoControllerView.this.cNU != null) {
                        VideoControllerView.this.cNU.awL();
                    }
                    if (VideoControllerView.this.cNV != null) {
                        VideoControllerView.this.cNV.onProgressChanged(seekBar, VideoControllerView.this.cNW, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cNP.seekTo(VideoControllerView.this.cNW);
                VideoControllerView.this.cxT = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cNV != null) {
                    VideoControllerView.this.cNV.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ds = ds(context);
        addView(ds, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.cNQ = (TextView) ds.findViewById(d.g.textview_cur_time);
        this.cNR = (TextView) ds.findViewById(d.g.textview_duration);
        this.cNS = (SeekBar) ds.findViewById(d.g.pb_video_controller_seekBar);
        this.cNS.setOnSeekBarChangeListener(this.cNX);
    }

    protected View ds(Context context) {
        return LayoutInflater.from(context).inflate(d.h.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cNP = mediaPlayerControl;
    }

    public void ax(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cNS.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.cNQ != null) {
            this.cNQ.setText(ap.hz(i));
        }
        if (this.cNR != null) {
            this.cNR.setText(ap.hz(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.cNP != null) {
            this.cNO = ((this.cNP.getDuration() / 200) / 50) * 50;
            if (this.cNO < 50) {
                this.cNO = 50;
            } else if (this.cNO > 500) {
                this.cNO = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cNO - (this.cNP.getCurrentPosition() % this.cNO));
        }
    }

    public void awJ() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cNS.setProgress(0);
        if (this.cNQ != null) {
            this.cNQ.setText(ap.hz(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int awK() {
        if (this.cNP == null || this.cxT) {
            return 0;
        }
        int currentPosition = this.cNP.getCurrentPosition();
        int duration = this.cNP.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.cNS != null) {
            if (duration > 0) {
                this.cNS.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cNP.getBufferPercentage();
        }
        if (this.cNQ != null) {
            this.cNQ.setText(ap.hz(currentPosition));
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
            this.cNP.seekTo(i);
            if (this.cNQ != null) {
                this.cNQ.setText(ap.hz(i));
            }
            showProgress();
        }
        if (!this.cNP.isPlaying()) {
            this.cNS.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.cNW;
    }

    public int getCurProgress() {
        if (this.cNS != null) {
            return this.cNS.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.cNT = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.cNU = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.cNV = onSeekBarChangeListener;
    }
}
