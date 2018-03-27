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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean bHi;
    private SeekBar.OnSeekBarChangeListener bTA;
    private int bTB;
    private SeekBar.OnSeekBarChangeListener bTC;
    private int bTs;
    private MediaController.MediaPlayerControl bTt;
    private TextView bTu;
    private TextView bTv;
    private boolean bTw;
    private SeekBar bTx;
    private b bTy;
    private a bTz;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface a {
        void UF();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void jo(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.bTs = 50;
        this.bHi = false;
        this.bTw = true;
        this.bTB = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bHi && VideoControllerView.this.bTw && VideoControllerView.this.bTt != null) {
                            int UE = VideoControllerView.this.UE();
                            if (VideoControllerView.this.bTy != null) {
                                VideoControllerView.this.bTy.jo(UE);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bTs - (UE % VideoControllerView.this.bTs));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTC = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bHi = true;
                if (VideoControllerView.this.bTA != null) {
                    VideoControllerView.this.bTA.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bTB = (int) ((VideoControllerView.this.bTt.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bTu != null) {
                        VideoControllerView.this.bTu.setText(am.fV(VideoControllerView.this.bTB));
                    }
                    if (VideoControllerView.this.bTz != null) {
                        VideoControllerView.this.bTz.UF();
                    }
                    if (VideoControllerView.this.bTA != null) {
                        VideoControllerView.this.bTA.onProgressChanged(seekBar, VideoControllerView.this.bTB, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bTt.seekTo(VideoControllerView.this.bTB);
                VideoControllerView.this.bHi = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bTA != null) {
                    VideoControllerView.this.bTA.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTs = 50;
        this.bHi = false;
        this.bTw = true;
        this.bTB = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bHi && VideoControllerView.this.bTw && VideoControllerView.this.bTt != null) {
                            int UE = VideoControllerView.this.UE();
                            if (VideoControllerView.this.bTy != null) {
                                VideoControllerView.this.bTy.jo(UE);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bTs - (UE % VideoControllerView.this.bTs));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTC = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bHi = true;
                if (VideoControllerView.this.bTA != null) {
                    VideoControllerView.this.bTA.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bTB = (int) ((VideoControllerView.this.bTt.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bTu != null) {
                        VideoControllerView.this.bTu.setText(am.fV(VideoControllerView.this.bTB));
                    }
                    if (VideoControllerView.this.bTz != null) {
                        VideoControllerView.this.bTz.UF();
                    }
                    if (VideoControllerView.this.bTA != null) {
                        VideoControllerView.this.bTA.onProgressChanged(seekBar, VideoControllerView.this.bTB, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bTt.seekTo(VideoControllerView.this.bTB);
                VideoControllerView.this.bHi = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bTA != null) {
                    VideoControllerView.this.bTA.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bTs = 50;
        this.bHi = false;
        this.bTw = true;
        this.bTB = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bHi && VideoControllerView.this.bTw && VideoControllerView.this.bTt != null) {
                            int UE = VideoControllerView.this.UE();
                            if (VideoControllerView.this.bTy != null) {
                                VideoControllerView.this.bTy.jo(UE);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bTs - (UE % VideoControllerView.this.bTs));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTC = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bHi = true;
                if (VideoControllerView.this.bTA != null) {
                    VideoControllerView.this.bTA.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.bTB = (int) ((VideoControllerView.this.bTt.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.bTu != null) {
                        VideoControllerView.this.bTu.setText(am.fV(VideoControllerView.this.bTB));
                    }
                    if (VideoControllerView.this.bTz != null) {
                        VideoControllerView.this.bTz.UF();
                    }
                    if (VideoControllerView.this.bTA != null) {
                        VideoControllerView.this.bTA.onProgressChanged(seekBar, VideoControllerView.this.bTB, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bTt.seekTo(VideoControllerView.this.bTB);
                VideoControllerView.this.bHi = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bTA != null) {
                    VideoControllerView.this.bTA.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bq = bq(context);
        addView(bq, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bTu = (TextView) bq.findViewById(d.g.textview_cur_time);
        this.bTv = (TextView) bq.findViewById(d.g.textview_duration);
        this.bTx = (SeekBar) bq.findViewById(d.g.pb_video_controller_seekBar);
        this.bTx.setOnSeekBarChangeListener(this.bTC);
    }

    protected View bq(Context context) {
        return LayoutInflater.from(context).inflate(d.h.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bTt = mediaPlayerControl;
    }

    public void aU(int i, int i2) {
        this.mDuration = i2;
        this.bTw = false;
        this.mHandler.removeMessages(1);
        this.bTx.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bTu != null) {
            this.bTu.setText(am.fV(i));
        }
        if (this.bTv != null) {
            this.bTv.setText(am.fV(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bTt != null) {
            this.bTs = ((this.bTt.getDuration() / 200) / 50) * 50;
            if (this.bTs < 50) {
                this.bTs = 50;
            } else if (this.bTs > 500) {
                this.bTs = 500;
            }
            this.bTw = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bTs - (this.bTt.getCurrentPosition() % this.bTs));
        }
    }

    public void UD() {
        this.bTw = false;
        this.mHandler.removeMessages(1);
        this.bTx.setProgress(0);
        if (this.bTu != null) {
            this.bTu.setText(am.fV(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int UE() {
        if (this.bTt == null || this.bHi) {
            return 0;
        }
        int currentPosition = this.bTt.getCurrentPosition();
        int duration = this.bTt.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bTx != null) {
            if (duration > 0) {
                this.bTx.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bTt.getBufferPercentage();
        }
        if (this.bTu != null) {
            this.bTu.setText(am.fV(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public int getSeekPosition() {
        return this.bTB;
    }

    public int getCurProgress() {
        if (this.bTx != null) {
            return this.bTx.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.bTy = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.bTz = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bTA = onSeekBarChangeListener;
    }
}
