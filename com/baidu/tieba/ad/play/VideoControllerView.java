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
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class VideoControllerView extends RelativeLayout {
    private int bBQ;
    private MediaController.MediaPlayerControl bBR;
    private TextView bBS;
    private TextView bBT;
    private SeekBar bBU;
    private b bBV;
    private a bBW;
    private SeekBar.OnSeekBarChangeListener bBX;
    private int bBY;
    private SeekBar.OnSeekBarChangeListener bBZ;
    private boolean bmA;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes3.dex */
    public interface a {
        void Wm();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void hI(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.bBQ = 50;
        this.bmA = false;
        this.mShowing = true;
        this.bBY = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bmA && VideoControllerView.this.mShowing && VideoControllerView.this.bBR != null) {
                            int Wl = VideoControllerView.this.Wl();
                            if (VideoControllerView.this.bBV != null) {
                                VideoControllerView.this.bBV.hI(Wl);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bBQ - (Wl % VideoControllerView.this.bBQ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bBZ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bmA = true;
                if (VideoControllerView.this.bBX != null) {
                    VideoControllerView.this.bBX.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bBY = (int) ((VideoControllerView.this.bBR.getDuration() * i) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.bBS != null) {
                        VideoControllerView.this.bBS.setText(ao.dV(VideoControllerView.this.bBY));
                    }
                    if (VideoControllerView.this.bBW != null) {
                        VideoControllerView.this.bBW.Wm();
                    }
                    if (VideoControllerView.this.bBX != null) {
                        VideoControllerView.this.bBX.onProgressChanged(seekBar, VideoControllerView.this.bBY, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bBR.seekTo(VideoControllerView.this.bBY);
                VideoControllerView.this.bmA = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bBX != null) {
                    VideoControllerView.this.bBX.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bBQ = 50;
        this.bmA = false;
        this.mShowing = true;
        this.bBY = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bmA && VideoControllerView.this.mShowing && VideoControllerView.this.bBR != null) {
                            int Wl = VideoControllerView.this.Wl();
                            if (VideoControllerView.this.bBV != null) {
                                VideoControllerView.this.bBV.hI(Wl);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bBQ - (Wl % VideoControllerView.this.bBQ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bBZ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bmA = true;
                if (VideoControllerView.this.bBX != null) {
                    VideoControllerView.this.bBX.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bBY = (int) ((VideoControllerView.this.bBR.getDuration() * i) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.bBS != null) {
                        VideoControllerView.this.bBS.setText(ao.dV(VideoControllerView.this.bBY));
                    }
                    if (VideoControllerView.this.bBW != null) {
                        VideoControllerView.this.bBW.Wm();
                    }
                    if (VideoControllerView.this.bBX != null) {
                        VideoControllerView.this.bBX.onProgressChanged(seekBar, VideoControllerView.this.bBY, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bBR.seekTo(VideoControllerView.this.bBY);
                VideoControllerView.this.bmA = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bBX != null) {
                    VideoControllerView.this.bBX.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bBQ = 50;
        this.bmA = false;
        this.mShowing = true;
        this.bBY = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bmA && VideoControllerView.this.mShowing && VideoControllerView.this.bBR != null) {
                            int Wl = VideoControllerView.this.Wl();
                            if (VideoControllerView.this.bBV != null) {
                                VideoControllerView.this.bBV.hI(Wl);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bBQ - (Wl % VideoControllerView.this.bBQ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bBZ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bmA = true;
                if (VideoControllerView.this.bBX != null) {
                    VideoControllerView.this.bBX.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.bBY = (int) ((VideoControllerView.this.bBR.getDuration() * i2) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.bBS != null) {
                        VideoControllerView.this.bBS.setText(ao.dV(VideoControllerView.this.bBY));
                    }
                    if (VideoControllerView.this.bBW != null) {
                        VideoControllerView.this.bBW.Wm();
                    }
                    if (VideoControllerView.this.bBX != null) {
                        VideoControllerView.this.bBX.onProgressChanged(seekBar, VideoControllerView.this.bBY, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bBR.seekTo(VideoControllerView.this.bBY);
                VideoControllerView.this.bmA = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bBX != null) {
                    VideoControllerView.this.bBX.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ca = ca(context);
        addView(ca, -1, (int) context.getResources().getDimension(e.C0210e.ds80));
        this.bBS = (TextView) ca.findViewById(e.g.textview_cur_time);
        this.bBT = (TextView) ca.findViewById(e.g.textview_duration);
        this.bBU = (SeekBar) ca.findViewById(e.g.pb_video_controller_seekBar);
        this.bBU.setOnSeekBarChangeListener(this.bBZ);
    }

    protected View ca(Context context) {
        return LayoutInflater.from(context).inflate(e.h.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bBR = mediaPlayerControl;
    }

    public void Z(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.bBU.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bBS != null) {
            this.bBS.setText(ao.dV(i));
        }
        if (this.bBT != null) {
            this.bBT.setText(ao.dV(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bBR != null) {
            this.bBQ = ((this.bBR.getDuration() / 200) / 50) * 50;
            if (this.bBQ < 50) {
                this.bBQ = 50;
            } else if (this.bBQ > 500) {
                this.bBQ = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bBQ - (this.bBR.getCurrentPosition() % this.bBQ));
        }
    }

    public void Wk() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.bBU.setProgress(0);
        if (this.bBS != null) {
            this.bBS.setText(ao.dV(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Wl() {
        if (this.bBR == null || this.bmA) {
            return 0;
        }
        int currentPosition = this.bBR.getCurrentPosition();
        int duration = this.bBR.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bBU != null) {
            if (duration > 0) {
                this.bBU.setProgress((int) ((ErrDef.Feature.WEIGHT * currentPosition) / duration));
            }
            this.bBR.getBufferPercentage();
        }
        if (this.bBS != null) {
            this.bBS.setText(ao.dV(currentPosition));
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
            this.bBR.seekTo(i);
            if (this.bBS != null) {
                this.bBS.setText(ao.dV(i));
            }
            showProgress();
        }
        if (!this.bBR.isPlaying()) {
            this.bBU.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.bBY;
    }

    public int getCurProgress() {
        if (this.bBU != null) {
            return this.bBU.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.bBV = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.bBW = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bBX = onSeekBarChangeListener;
    }
}
