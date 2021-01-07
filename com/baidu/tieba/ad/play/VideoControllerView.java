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
/* loaded from: classes.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean bdx;
    private int eDK;
    private int gjU;
    private MediaController.MediaPlayerControl gjV;
    private TextView gjW;
    private TextView gjX;
    private SeekBar gjY;
    private b gjZ;
    private a gka;
    private SeekBar.OnSeekBarChangeListener gkb;
    private SeekBar.OnSeekBarChangeListener gkc;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void bPc();
    }

    /* loaded from: classes.dex */
    public interface b {
        void uC(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.gjU = 50;
        this.mDragging = false;
        this.bdx = true;
        this.eDK = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bdx && VideoControllerView.this.gjV != null) {
                            int bPb = VideoControllerView.this.bPb();
                            if (VideoControllerView.this.gjZ != null) {
                                VideoControllerView.this.gjZ.uC(bPb);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gjU - (bPb % VideoControllerView.this.gjU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gkc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gkb != null) {
                    VideoControllerView.this.gkb.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eDK = (int) ((VideoControllerView.this.gjV.getDuration() * i) / 10000);
                    if (VideoControllerView.this.gjW != null) {
                        VideoControllerView.this.gjW.setText(at.stringForVideoTime(VideoControllerView.this.eDK));
                    }
                    if (VideoControllerView.this.gka != null) {
                        VideoControllerView.this.gka.bPc();
                    }
                    if (VideoControllerView.this.gkb != null) {
                        VideoControllerView.this.gkb.onProgressChanged(seekBar, VideoControllerView.this.eDK, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.gjV.seekTo(VideoControllerView.this.eDK);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gkb != null) {
                    VideoControllerView.this.gkb.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjU = 50;
        this.mDragging = false;
        this.bdx = true;
        this.eDK = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bdx && VideoControllerView.this.gjV != null) {
                            int bPb = VideoControllerView.this.bPb();
                            if (VideoControllerView.this.gjZ != null) {
                                VideoControllerView.this.gjZ.uC(bPb);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gjU - (bPb % VideoControllerView.this.gjU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gkc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gkb != null) {
                    VideoControllerView.this.gkb.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eDK = (int) ((VideoControllerView.this.gjV.getDuration() * i) / 10000);
                    if (VideoControllerView.this.gjW != null) {
                        VideoControllerView.this.gjW.setText(at.stringForVideoTime(VideoControllerView.this.eDK));
                    }
                    if (VideoControllerView.this.gka != null) {
                        VideoControllerView.this.gka.bPc();
                    }
                    if (VideoControllerView.this.gkb != null) {
                        VideoControllerView.this.gkb.onProgressChanged(seekBar, VideoControllerView.this.eDK, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.gjV.seekTo(VideoControllerView.this.eDK);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gkb != null) {
                    VideoControllerView.this.gkb.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjU = 50;
        this.mDragging = false;
        this.bdx = true;
        this.eDK = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bdx && VideoControllerView.this.gjV != null) {
                            int bPb = VideoControllerView.this.bPb();
                            if (VideoControllerView.this.gjZ != null) {
                                VideoControllerView.this.gjZ.uC(bPb);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gjU - (bPb % VideoControllerView.this.gjU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gkc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gkb != null) {
                    VideoControllerView.this.gkb.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eDK = (int) ((VideoControllerView.this.gjV.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.gjW != null) {
                        VideoControllerView.this.gjW.setText(at.stringForVideoTime(VideoControllerView.this.eDK));
                    }
                    if (VideoControllerView.this.gka != null) {
                        VideoControllerView.this.gka.bPc();
                    }
                    if (VideoControllerView.this.gkb != null) {
                        VideoControllerView.this.gkb.onProgressChanged(seekBar, VideoControllerView.this.eDK, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.gjV.seekTo(VideoControllerView.this.eDK);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gkb != null) {
                    VideoControllerView.this.gkb.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View fH = fH(context);
        addView(fH, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.gjW = (TextView) fH.findViewById(R.id.textview_cur_time);
        this.gjX = (TextView) fH.findViewById(R.id.textview_duration);
        this.gjY = (SeekBar) fH.findViewById(R.id.pb_video_controller_seekBar);
        this.gjY.setOnSeekBarChangeListener(this.gkc);
    }

    protected View fH(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gjV = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mDuration = i2;
        this.bdx = false;
        this.mHandler.removeMessages(1);
        this.gjY.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.gjW != null) {
            this.gjW.setText(at.stringForVideoTime(i));
        }
        if (this.gjX != null) {
            this.gjX.setText(at.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.gjV != null) {
            this.gjU = ((this.gjV.getDuration() / 200) / 50) * 50;
            if (this.gjU < 50) {
                this.gjU = 50;
            } else if (this.gjU > 500) {
                this.gjU = 500;
            }
            this.bdx = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gjU - (this.gjV.getCurrentPosition() % this.gjU));
        }
    }

    public void aUS() {
        this.bdx = false;
        this.mHandler.removeMessages(1);
        this.gjY.setProgress(0);
        if (this.gjW != null) {
            this.gjW.setText(at.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bPb() {
        if (this.gjV == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.gjV.getCurrentPosition();
        int duration = this.gjV.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.gjY != null) {
            if (duration > 0) {
                this.gjY.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.gjV.getBufferPercentage();
        }
        if (this.gjW != null) {
            this.gjW.setText(at.stringForVideoTime(currentPosition));
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
            this.gjV.seekTo(i);
            if (this.gjW != null) {
                this.gjW.setText(at.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.gjV.isPlaying()) {
            this.gjY.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.eDK;
    }

    public int getCurProgress() {
        if (this.gjY != null) {
            return this.gjY.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.gjZ = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.gka = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gkb = onSeekBarChangeListener;
    }
}
