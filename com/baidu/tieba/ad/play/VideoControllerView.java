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
    private boolean bHf;
    private int bTp;
    private MediaController.MediaPlayerControl bTq;
    private TextView bTr;
    private TextView bTs;
    private boolean bTt;
    private SeekBar bTu;
    private b bTv;
    private a bTw;
    private SeekBar.OnSeekBarChangeListener bTx;
    private int bTy;
    private SeekBar.OnSeekBarChangeListener bTz;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface a {
        void UE();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void jo(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.bTp = 50;
        this.bHf = false;
        this.bTt = true;
        this.bTy = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bHf && VideoControllerView.this.bTt && VideoControllerView.this.bTq != null) {
                            int UD = VideoControllerView.this.UD();
                            if (VideoControllerView.this.bTv != null) {
                                VideoControllerView.this.bTv.jo(UD);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bTp - (UD % VideoControllerView.this.bTp));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTz = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bHf = true;
                if (VideoControllerView.this.bTx != null) {
                    VideoControllerView.this.bTx.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bTy = (int) ((VideoControllerView.this.bTq.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bTr != null) {
                        VideoControllerView.this.bTr.setText(am.fV(VideoControllerView.this.bTy));
                    }
                    if (VideoControllerView.this.bTw != null) {
                        VideoControllerView.this.bTw.UE();
                    }
                    if (VideoControllerView.this.bTx != null) {
                        VideoControllerView.this.bTx.onProgressChanged(seekBar, VideoControllerView.this.bTy, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bTq.seekTo(VideoControllerView.this.bTy);
                VideoControllerView.this.bHf = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bTx != null) {
                    VideoControllerView.this.bTx.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTp = 50;
        this.bHf = false;
        this.bTt = true;
        this.bTy = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bHf && VideoControllerView.this.bTt && VideoControllerView.this.bTq != null) {
                            int UD = VideoControllerView.this.UD();
                            if (VideoControllerView.this.bTv != null) {
                                VideoControllerView.this.bTv.jo(UD);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bTp - (UD % VideoControllerView.this.bTp));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTz = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bHf = true;
                if (VideoControllerView.this.bTx != null) {
                    VideoControllerView.this.bTx.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bTy = (int) ((VideoControllerView.this.bTq.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bTr != null) {
                        VideoControllerView.this.bTr.setText(am.fV(VideoControllerView.this.bTy));
                    }
                    if (VideoControllerView.this.bTw != null) {
                        VideoControllerView.this.bTw.UE();
                    }
                    if (VideoControllerView.this.bTx != null) {
                        VideoControllerView.this.bTx.onProgressChanged(seekBar, VideoControllerView.this.bTy, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bTq.seekTo(VideoControllerView.this.bTy);
                VideoControllerView.this.bHf = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bTx != null) {
                    VideoControllerView.this.bTx.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bTp = 50;
        this.bHf = false;
        this.bTt = true;
        this.bTy = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bHf && VideoControllerView.this.bTt && VideoControllerView.this.bTq != null) {
                            int UD = VideoControllerView.this.UD();
                            if (VideoControllerView.this.bTv != null) {
                                VideoControllerView.this.bTv.jo(UD);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bTp - (UD % VideoControllerView.this.bTp));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTz = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bHf = true;
                if (VideoControllerView.this.bTx != null) {
                    VideoControllerView.this.bTx.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.bTy = (int) ((VideoControllerView.this.bTq.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.bTr != null) {
                        VideoControllerView.this.bTr.setText(am.fV(VideoControllerView.this.bTy));
                    }
                    if (VideoControllerView.this.bTw != null) {
                        VideoControllerView.this.bTw.UE();
                    }
                    if (VideoControllerView.this.bTx != null) {
                        VideoControllerView.this.bTx.onProgressChanged(seekBar, VideoControllerView.this.bTy, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bTq.seekTo(VideoControllerView.this.bTy);
                VideoControllerView.this.bHf = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bTx != null) {
                    VideoControllerView.this.bTx.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bq = bq(context);
        addView(bq, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bTr = (TextView) bq.findViewById(d.g.textview_cur_time);
        this.bTs = (TextView) bq.findViewById(d.g.textview_duration);
        this.bTu = (SeekBar) bq.findViewById(d.g.pb_video_controller_seekBar);
        this.bTu.setOnSeekBarChangeListener(this.bTz);
    }

    protected View bq(Context context) {
        return LayoutInflater.from(context).inflate(d.h.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bTq = mediaPlayerControl;
    }

    public void aU(int i, int i2) {
        this.mDuration = i2;
        this.bTt = false;
        this.mHandler.removeMessages(1);
        this.bTu.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bTr != null) {
            this.bTr.setText(am.fV(i));
        }
        if (this.bTs != null) {
            this.bTs.setText(am.fV(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bTq != null) {
            this.bTp = ((this.bTq.getDuration() / 200) / 50) * 50;
            if (this.bTp < 50) {
                this.bTp = 50;
            } else if (this.bTp > 500) {
                this.bTp = 500;
            }
            this.bTt = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bTp - (this.bTq.getCurrentPosition() % this.bTp));
        }
    }

    public void UC() {
        this.bTt = false;
        this.mHandler.removeMessages(1);
        this.bTu.setProgress(0);
        if (this.bTr != null) {
            this.bTr.setText(am.fV(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int UD() {
        if (this.bTq == null || this.bHf) {
            return 0;
        }
        int currentPosition = this.bTq.getCurrentPosition();
        int duration = this.bTq.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bTu != null) {
            if (duration > 0) {
                this.bTu.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bTq.getBufferPercentage();
        }
        if (this.bTr != null) {
            this.bTr.setText(am.fV(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public int getSeekPosition() {
        return this.bTy;
    }

    public int getCurProgress() {
        if (this.bTu != null) {
            return this.bTu.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.bTv = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.bTw = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bTx = onSeekBarChangeListener;
    }
}
