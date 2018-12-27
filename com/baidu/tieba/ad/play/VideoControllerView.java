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
    private int bBT;
    private MediaController.MediaPlayerControl bBU;
    private TextView bBV;
    private TextView bBW;
    private SeekBar bBX;
    private b bBY;
    private a bBZ;
    private SeekBar.OnSeekBarChangeListener bCa;
    private int bCb;
    private SeekBar.OnSeekBarChangeListener bCc;
    private boolean bmD;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes3.dex */
    public interface a {
        void Wo();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void hJ(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.bBT = 50;
        this.bmD = false;
        this.mShowing = true;
        this.bCb = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bmD && VideoControllerView.this.mShowing && VideoControllerView.this.bBU != null) {
                            int Wn = VideoControllerView.this.Wn();
                            if (VideoControllerView.this.bBY != null) {
                                VideoControllerView.this.bBY.hJ(Wn);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bBT - (Wn % VideoControllerView.this.bBT));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bCc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bmD = true;
                if (VideoControllerView.this.bCa != null) {
                    VideoControllerView.this.bCa.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bCb = (int) ((VideoControllerView.this.bBU.getDuration() * i) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.bBV != null) {
                        VideoControllerView.this.bBV.setText(ao.dV(VideoControllerView.this.bCb));
                    }
                    if (VideoControllerView.this.bBZ != null) {
                        VideoControllerView.this.bBZ.Wo();
                    }
                    if (VideoControllerView.this.bCa != null) {
                        VideoControllerView.this.bCa.onProgressChanged(seekBar, VideoControllerView.this.bCb, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bBU.seekTo(VideoControllerView.this.bCb);
                VideoControllerView.this.bmD = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bCa != null) {
                    VideoControllerView.this.bCa.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bBT = 50;
        this.bmD = false;
        this.mShowing = true;
        this.bCb = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bmD && VideoControllerView.this.mShowing && VideoControllerView.this.bBU != null) {
                            int Wn = VideoControllerView.this.Wn();
                            if (VideoControllerView.this.bBY != null) {
                                VideoControllerView.this.bBY.hJ(Wn);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bBT - (Wn % VideoControllerView.this.bBT));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bCc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bmD = true;
                if (VideoControllerView.this.bCa != null) {
                    VideoControllerView.this.bCa.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bCb = (int) ((VideoControllerView.this.bBU.getDuration() * i) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.bBV != null) {
                        VideoControllerView.this.bBV.setText(ao.dV(VideoControllerView.this.bCb));
                    }
                    if (VideoControllerView.this.bBZ != null) {
                        VideoControllerView.this.bBZ.Wo();
                    }
                    if (VideoControllerView.this.bCa != null) {
                        VideoControllerView.this.bCa.onProgressChanged(seekBar, VideoControllerView.this.bCb, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bBU.seekTo(VideoControllerView.this.bCb);
                VideoControllerView.this.bmD = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bCa != null) {
                    VideoControllerView.this.bCa.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bBT = 50;
        this.bmD = false;
        this.mShowing = true;
        this.bCb = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bmD && VideoControllerView.this.mShowing && VideoControllerView.this.bBU != null) {
                            int Wn = VideoControllerView.this.Wn();
                            if (VideoControllerView.this.bBY != null) {
                                VideoControllerView.this.bBY.hJ(Wn);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bBT - (Wn % VideoControllerView.this.bBT));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bCc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bmD = true;
                if (VideoControllerView.this.bCa != null) {
                    VideoControllerView.this.bCa.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.bCb = (int) ((VideoControllerView.this.bBU.getDuration() * i2) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.bBV != null) {
                        VideoControllerView.this.bBV.setText(ao.dV(VideoControllerView.this.bCb));
                    }
                    if (VideoControllerView.this.bBZ != null) {
                        VideoControllerView.this.bBZ.Wo();
                    }
                    if (VideoControllerView.this.bCa != null) {
                        VideoControllerView.this.bCa.onProgressChanged(seekBar, VideoControllerView.this.bCb, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bBU.seekTo(VideoControllerView.this.bCb);
                VideoControllerView.this.bmD = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bCa != null) {
                    VideoControllerView.this.bCa.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ca = ca(context);
        addView(ca, -1, (int) context.getResources().getDimension(e.C0210e.ds80));
        this.bBV = (TextView) ca.findViewById(e.g.textview_cur_time);
        this.bBW = (TextView) ca.findViewById(e.g.textview_duration);
        this.bBX = (SeekBar) ca.findViewById(e.g.pb_video_controller_seekBar);
        this.bBX.setOnSeekBarChangeListener(this.bCc);
    }

    protected View ca(Context context) {
        return LayoutInflater.from(context).inflate(e.h.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bBU = mediaPlayerControl;
    }

    public void Z(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.bBX.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bBV != null) {
            this.bBV.setText(ao.dV(i));
        }
        if (this.bBW != null) {
            this.bBW.setText(ao.dV(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bBU != null) {
            this.bBT = ((this.bBU.getDuration() / 200) / 50) * 50;
            if (this.bBT < 50) {
                this.bBT = 50;
            } else if (this.bBT > 500) {
                this.bBT = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bBT - (this.bBU.getCurrentPosition() % this.bBT));
        }
    }

    public void Wm() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.bBX.setProgress(0);
        if (this.bBV != null) {
            this.bBV.setText(ao.dV(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Wn() {
        if (this.bBU == null || this.bmD) {
            return 0;
        }
        int currentPosition = this.bBU.getCurrentPosition();
        int duration = this.bBU.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bBX != null) {
            if (duration > 0) {
                this.bBX.setProgress((int) ((ErrDef.Feature.WEIGHT * currentPosition) / duration));
            }
            this.bBU.getBufferPercentage();
        }
        if (this.bBV != null) {
            this.bBV.setText(ao.dV(currentPosition));
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
            this.bBU.seekTo(i);
            if (this.bBV != null) {
                this.bBV.setText(ao.dV(i));
            }
            showProgress();
        }
        if (!this.bBU.isPlaying()) {
            this.bBX.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.bCb;
    }

    public int getCurProgress() {
        if (this.bBX != null) {
            return this.bBX.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.bBY = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.bBZ = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bCa = onSeekBarChangeListener;
    }
}
