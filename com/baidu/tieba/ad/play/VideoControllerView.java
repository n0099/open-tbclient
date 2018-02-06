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
    private boolean bHs;
    private int bTB;
    private MediaController.MediaPlayerControl bTC;
    private TextView bTD;
    private TextView bTE;
    private boolean bTF;
    private SeekBar bTG;
    private b bTH;
    private a bTI;
    private SeekBar.OnSeekBarChangeListener bTJ;
    private int bTK;
    private SeekBar.OnSeekBarChangeListener bTL;
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
        this.bTB = 50;
        this.bHs = false;
        this.bTF = true;
        this.bTK = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bHs && VideoControllerView.this.bTF && VideoControllerView.this.bTC != null) {
                            int UE = VideoControllerView.this.UE();
                            if (VideoControllerView.this.bTH != null) {
                                VideoControllerView.this.bTH.jo(UE);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bTB - (UE % VideoControllerView.this.bTB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bHs = true;
                if (VideoControllerView.this.bTJ != null) {
                    VideoControllerView.this.bTJ.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bTK = (int) ((VideoControllerView.this.bTC.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bTD != null) {
                        VideoControllerView.this.bTD.setText(am.fV(VideoControllerView.this.bTK));
                    }
                    if (VideoControllerView.this.bTI != null) {
                        VideoControllerView.this.bTI.UF();
                    }
                    if (VideoControllerView.this.bTJ != null) {
                        VideoControllerView.this.bTJ.onProgressChanged(seekBar, VideoControllerView.this.bTK, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bTC.seekTo(VideoControllerView.this.bTK);
                VideoControllerView.this.bHs = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bTJ != null) {
                    VideoControllerView.this.bTJ.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTB = 50;
        this.bHs = false;
        this.bTF = true;
        this.bTK = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bHs && VideoControllerView.this.bTF && VideoControllerView.this.bTC != null) {
                            int UE = VideoControllerView.this.UE();
                            if (VideoControllerView.this.bTH != null) {
                                VideoControllerView.this.bTH.jo(UE);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bTB - (UE % VideoControllerView.this.bTB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bHs = true;
                if (VideoControllerView.this.bTJ != null) {
                    VideoControllerView.this.bTJ.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bTK = (int) ((VideoControllerView.this.bTC.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bTD != null) {
                        VideoControllerView.this.bTD.setText(am.fV(VideoControllerView.this.bTK));
                    }
                    if (VideoControllerView.this.bTI != null) {
                        VideoControllerView.this.bTI.UF();
                    }
                    if (VideoControllerView.this.bTJ != null) {
                        VideoControllerView.this.bTJ.onProgressChanged(seekBar, VideoControllerView.this.bTK, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bTC.seekTo(VideoControllerView.this.bTK);
                VideoControllerView.this.bHs = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bTJ != null) {
                    VideoControllerView.this.bTJ.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bTB = 50;
        this.bHs = false;
        this.bTF = true;
        this.bTK = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bHs && VideoControllerView.this.bTF && VideoControllerView.this.bTC != null) {
                            int UE = VideoControllerView.this.UE();
                            if (VideoControllerView.this.bTH != null) {
                                VideoControllerView.this.bTH.jo(UE);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bTB - (UE % VideoControllerView.this.bTB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bHs = true;
                if (VideoControllerView.this.bTJ != null) {
                    VideoControllerView.this.bTJ.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.bTK = (int) ((VideoControllerView.this.bTC.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.bTD != null) {
                        VideoControllerView.this.bTD.setText(am.fV(VideoControllerView.this.bTK));
                    }
                    if (VideoControllerView.this.bTI != null) {
                        VideoControllerView.this.bTI.UF();
                    }
                    if (VideoControllerView.this.bTJ != null) {
                        VideoControllerView.this.bTJ.onProgressChanged(seekBar, VideoControllerView.this.bTK, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bTC.seekTo(VideoControllerView.this.bTK);
                VideoControllerView.this.bHs = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bTJ != null) {
                    VideoControllerView.this.bTJ.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bq = bq(context);
        addView(bq, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bTD = (TextView) bq.findViewById(d.g.textview_cur_time);
        this.bTE = (TextView) bq.findViewById(d.g.textview_duration);
        this.bTG = (SeekBar) bq.findViewById(d.g.pb_video_controller_seekBar);
        this.bTG.setOnSeekBarChangeListener(this.bTL);
    }

    protected View bq(Context context) {
        return LayoutInflater.from(context).inflate(d.h.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bTC = mediaPlayerControl;
    }

    public void aU(int i, int i2) {
        this.mDuration = i2;
        this.bTF = false;
        this.mHandler.removeMessages(1);
        this.bTG.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bTD != null) {
            this.bTD.setText(am.fV(i));
        }
        if (this.bTE != null) {
            this.bTE.setText(am.fV(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bTC != null) {
            this.bTB = ((this.bTC.getDuration() / 200) / 50) * 50;
            if (this.bTB < 50) {
                this.bTB = 50;
            } else if (this.bTB > 500) {
                this.bTB = 500;
            }
            this.bTF = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bTB - (this.bTC.getCurrentPosition() % this.bTB));
        }
    }

    public void UD() {
        this.bTF = false;
        this.mHandler.removeMessages(1);
        this.bTG.setProgress(0);
        if (this.bTD != null) {
            this.bTD.setText(am.fV(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int UE() {
        if (this.bTC == null || this.bHs) {
            return 0;
        }
        int currentPosition = this.bTC.getCurrentPosition();
        int duration = this.bTC.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bTG != null) {
            if (duration > 0) {
                this.bTG.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bTC.getBufferPercentage();
        }
        if (this.bTD != null) {
            this.bTD.setText(am.fV(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public int getSeekPosition() {
        return this.bTK;
    }

    public int getCurProgress() {
        if (this.bTG != null) {
            return this.bTG.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.bTH = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.bTI = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bTJ = onSeekBarChangeListener;
    }
}
