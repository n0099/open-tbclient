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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean ZT;
    private boolean cRK;
    private int dhR;
    private MediaController.MediaPlayerControl dhS;
    private TextView dhT;
    private TextView dhU;
    private SeekBar dhV;
    private b dhW;
    private a dhX;
    private SeekBar.OnSeekBarChangeListener dhY;
    private int dhZ;
    private SeekBar.OnSeekBarChangeListener dia;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface a {
        void aDT();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void lD(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.dhR = 50;
        this.cRK = false;
        this.ZT = true;
        this.dhZ = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cRK && VideoControllerView.this.ZT && VideoControllerView.this.dhS != null) {
                            int aDS = VideoControllerView.this.aDS();
                            if (VideoControllerView.this.dhW != null) {
                                VideoControllerView.this.dhW.lD(aDS);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dhR - (aDS % VideoControllerView.this.dhR));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dia = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cRK = true;
                if (VideoControllerView.this.dhY != null) {
                    VideoControllerView.this.dhY.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dhZ = (int) ((VideoControllerView.this.dhS.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dhT != null) {
                        VideoControllerView.this.dhT.setText(aq.stringForVideoTime(VideoControllerView.this.dhZ));
                    }
                    if (VideoControllerView.this.dhX != null) {
                        VideoControllerView.this.dhX.aDT();
                    }
                    if (VideoControllerView.this.dhY != null) {
                        VideoControllerView.this.dhY.onProgressChanged(seekBar, VideoControllerView.this.dhZ, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.dhS.seekTo(VideoControllerView.this.dhZ);
                VideoControllerView.this.cRK = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dhY != null) {
                    VideoControllerView.this.dhY.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhR = 50;
        this.cRK = false;
        this.ZT = true;
        this.dhZ = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cRK && VideoControllerView.this.ZT && VideoControllerView.this.dhS != null) {
                            int aDS = VideoControllerView.this.aDS();
                            if (VideoControllerView.this.dhW != null) {
                                VideoControllerView.this.dhW.lD(aDS);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dhR - (aDS % VideoControllerView.this.dhR));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dia = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cRK = true;
                if (VideoControllerView.this.dhY != null) {
                    VideoControllerView.this.dhY.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dhZ = (int) ((VideoControllerView.this.dhS.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dhT != null) {
                        VideoControllerView.this.dhT.setText(aq.stringForVideoTime(VideoControllerView.this.dhZ));
                    }
                    if (VideoControllerView.this.dhX != null) {
                        VideoControllerView.this.dhX.aDT();
                    }
                    if (VideoControllerView.this.dhY != null) {
                        VideoControllerView.this.dhY.onProgressChanged(seekBar, VideoControllerView.this.dhZ, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.dhS.seekTo(VideoControllerView.this.dhZ);
                VideoControllerView.this.cRK = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dhY != null) {
                    VideoControllerView.this.dhY.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dhR = 50;
        this.cRK = false;
        this.ZT = true;
        this.dhZ = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cRK && VideoControllerView.this.ZT && VideoControllerView.this.dhS != null) {
                            int aDS = VideoControllerView.this.aDS();
                            if (VideoControllerView.this.dhW != null) {
                                VideoControllerView.this.dhW.lD(aDS);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dhR - (aDS % VideoControllerView.this.dhR));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dia = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cRK = true;
                if (VideoControllerView.this.dhY != null) {
                    VideoControllerView.this.dhY.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dhZ = (int) ((VideoControllerView.this.dhS.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.dhT != null) {
                        VideoControllerView.this.dhT.setText(aq.stringForVideoTime(VideoControllerView.this.dhZ));
                    }
                    if (VideoControllerView.this.dhX != null) {
                        VideoControllerView.this.dhX.aDT();
                    }
                    if (VideoControllerView.this.dhY != null) {
                        VideoControllerView.this.dhY.onProgressChanged(seekBar, VideoControllerView.this.dhZ, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.dhS.seekTo(VideoControllerView.this.dhZ);
                VideoControllerView.this.cRK = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dhY != null) {
                    VideoControllerView.this.dhY.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View cK = cK(context);
        addView(cK, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.dhT = (TextView) cK.findViewById(R.id.textview_cur_time);
        this.dhU = (TextView) cK.findViewById(R.id.textview_duration);
        this.dhV = (SeekBar) cK.findViewById(R.id.pb_video_controller_seekBar);
        this.dhV.setOnSeekBarChangeListener(this.dia);
    }

    protected View cK(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dhS = mediaPlayerControl;
    }

    public void aB(int i, int i2) {
        this.mDuration = i2;
        this.ZT = false;
        this.mHandler.removeMessages(1);
        this.dhV.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.dhT != null) {
            this.dhT.setText(aq.stringForVideoTime(i));
        }
        if (this.dhU != null) {
            this.dhU.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.dhS != null) {
            this.dhR = ((this.dhS.getDuration() / 200) / 50) * 50;
            if (this.dhR < 50) {
                this.dhR = 50;
            } else if (this.dhR > 500) {
                this.dhR = 500;
            }
            this.ZT = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dhR - (this.dhS.getCurrentPosition() % this.dhR));
        }
    }

    public void aDR() {
        this.ZT = false;
        this.mHandler.removeMessages(1);
        this.dhV.setProgress(0);
        if (this.dhT != null) {
            this.dhT.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDS() {
        if (this.dhS == null || this.cRK) {
            return 0;
        }
        int currentPosition = this.dhS.getCurrentPosition();
        int duration = this.dhS.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.dhV != null) {
            if (duration > 0) {
                this.dhV.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.dhS.getBufferPercentage();
        }
        if (this.dhT != null) {
            this.dhT.setText(aq.stringForVideoTime(currentPosition));
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
            this.dhS.seekTo(i);
            if (this.dhT != null) {
                this.dhT.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.dhS.isPlaying()) {
            this.dhV.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.dhZ;
    }

    public int getCurProgress() {
        if (this.dhV != null) {
            return this.dhV.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.dhW = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.dhX = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.dhY = onSeekBarChangeListener;
    }
}
