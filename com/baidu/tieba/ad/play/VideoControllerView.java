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
    private boolean baF;
    private int bnL;
    private MediaController.MediaPlayerControl bnM;
    private TextView bnN;
    private TextView bnO;
    private boolean bnP;
    private SeekBar bnQ;
    private b bnR;
    private a bnS;
    private SeekBar.OnSeekBarChangeListener bnT;
    private int bnU;
    private SeekBar.OnSeekBarChangeListener bnV;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface a {
        void Ri();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void gA(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.bnL = 50;
        this.baF = false;
        this.bnP = true;
        this.bnU = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.baF && VideoControllerView.this.bnP && VideoControllerView.this.bnM != null) {
                            int Rh = VideoControllerView.this.Rh();
                            if (VideoControllerView.this.bnR != null) {
                                VideoControllerView.this.bnR.gA(Rh);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bnL - (Rh % VideoControllerView.this.bnL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bnV = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.baF = true;
                if (VideoControllerView.this.bnT != null) {
                    VideoControllerView.this.bnT.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bnU = (int) ((VideoControllerView.this.bnM.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bnN != null) {
                        VideoControllerView.this.bnN.setText(ap.da(VideoControllerView.this.bnU));
                    }
                    if (VideoControllerView.this.bnS != null) {
                        VideoControllerView.this.bnS.Ri();
                    }
                    if (VideoControllerView.this.bnT != null) {
                        VideoControllerView.this.bnT.onProgressChanged(seekBar, VideoControllerView.this.bnU, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bnM.seekTo(VideoControllerView.this.bnU);
                VideoControllerView.this.baF = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bnT != null) {
                    VideoControllerView.this.bnT.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bnL = 50;
        this.baF = false;
        this.bnP = true;
        this.bnU = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.baF && VideoControllerView.this.bnP && VideoControllerView.this.bnM != null) {
                            int Rh = VideoControllerView.this.Rh();
                            if (VideoControllerView.this.bnR != null) {
                                VideoControllerView.this.bnR.gA(Rh);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bnL - (Rh % VideoControllerView.this.bnL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bnV = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.baF = true;
                if (VideoControllerView.this.bnT != null) {
                    VideoControllerView.this.bnT.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bnU = (int) ((VideoControllerView.this.bnM.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bnN != null) {
                        VideoControllerView.this.bnN.setText(ap.da(VideoControllerView.this.bnU));
                    }
                    if (VideoControllerView.this.bnS != null) {
                        VideoControllerView.this.bnS.Ri();
                    }
                    if (VideoControllerView.this.bnT != null) {
                        VideoControllerView.this.bnT.onProgressChanged(seekBar, VideoControllerView.this.bnU, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bnM.seekTo(VideoControllerView.this.bnU);
                VideoControllerView.this.baF = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bnT != null) {
                    VideoControllerView.this.bnT.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnL = 50;
        this.baF = false;
        this.bnP = true;
        this.bnU = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.baF && VideoControllerView.this.bnP && VideoControllerView.this.bnM != null) {
                            int Rh = VideoControllerView.this.Rh();
                            if (VideoControllerView.this.bnR != null) {
                                VideoControllerView.this.bnR.gA(Rh);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bnL - (Rh % VideoControllerView.this.bnL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bnV = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.baF = true;
                if (VideoControllerView.this.bnT != null) {
                    VideoControllerView.this.bnT.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.bnU = (int) ((VideoControllerView.this.bnM.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.bnN != null) {
                        VideoControllerView.this.bnN.setText(ap.da(VideoControllerView.this.bnU));
                    }
                    if (VideoControllerView.this.bnS != null) {
                        VideoControllerView.this.bnS.Ri();
                    }
                    if (VideoControllerView.this.bnT != null) {
                        VideoControllerView.this.bnT.onProgressChanged(seekBar, VideoControllerView.this.bnU, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bnM.seekTo(VideoControllerView.this.bnU);
                VideoControllerView.this.baF = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bnT != null) {
                    VideoControllerView.this.bnT.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bm = bm(context);
        addView(bm, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bnN = (TextView) bm.findViewById(d.g.textview_cur_time);
        this.bnO = (TextView) bm.findViewById(d.g.textview_duration);
        this.bnQ = (SeekBar) bm.findViewById(d.g.pb_video_controller_seekBar);
        this.bnQ.setOnSeekBarChangeListener(this.bnV);
    }

    protected View bm(Context context) {
        return LayoutInflater.from(context).inflate(d.h.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bnM = mediaPlayerControl;
    }

    public void T(int i, int i2) {
        this.mDuration = i2;
        this.bnP = false;
        this.mHandler.removeMessages(1);
        this.bnQ.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bnN != null) {
            this.bnN.setText(ap.da(i));
        }
        if (this.bnO != null) {
            this.bnO.setText(ap.da(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bnM != null) {
            this.bnL = ((this.bnM.getDuration() / 200) / 50) * 50;
            if (this.bnL < 50) {
                this.bnL = 50;
            } else if (this.bnL > 500) {
                this.bnL = 500;
            }
            this.bnP = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bnL - (this.bnM.getCurrentPosition() % this.bnL));
        }
    }

    public void Rg() {
        this.bnP = false;
        this.mHandler.removeMessages(1);
        this.bnQ.setProgress(0);
        if (this.bnN != null) {
            this.bnN.setText(ap.da(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Rh() {
        if (this.bnM == null || this.baF) {
            return 0;
        }
        int currentPosition = this.bnM.getCurrentPosition();
        int duration = this.bnM.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bnQ != null) {
            if (duration > 0) {
                this.bnQ.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bnM.getBufferPercentage();
        }
        if (this.bnN != null) {
            this.bnN.setText(ap.da(currentPosition));
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
            this.bnM.seekTo(i);
            if (this.bnN != null) {
                this.bnN.setText(ap.da(i));
            }
            showProgress();
        }
        if (!this.bnM.isPlaying()) {
            this.bnQ.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.bnU;
    }

    public int getCurProgress() {
        if (this.bnQ != null) {
            return this.bnQ.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.bnR = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.bnS = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bnT = onSeekBarChangeListener;
    }
}
