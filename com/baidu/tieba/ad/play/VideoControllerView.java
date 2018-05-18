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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean aRJ;
    private boolean bdA;
    private SeekBar bdB;
    private b bdC;
    private a bdD;
    private SeekBar.OnSeekBarChangeListener bdE;
    private int bdF;
    private SeekBar.OnSeekBarChangeListener bdG;
    private int bdw;
    private MediaController.MediaPlayerControl bdx;
    private TextView bdy;
    private TextView bdz;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface a {
        void Ne();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void gt(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.bdw = 50;
        this.aRJ = false;
        this.bdA = true;
        this.bdF = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.aRJ && VideoControllerView.this.bdA && VideoControllerView.this.bdx != null) {
                            int Nd = VideoControllerView.this.Nd();
                            if (VideoControllerView.this.bdC != null) {
                                VideoControllerView.this.bdC.gt(Nd);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bdw - (Nd % VideoControllerView.this.bdw));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bdG = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.aRJ = true;
                if (VideoControllerView.this.bdE != null) {
                    VideoControllerView.this.bdE.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bdF = (int) ((VideoControllerView.this.bdx.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bdy != null) {
                        VideoControllerView.this.bdy.setText(an.cV(VideoControllerView.this.bdF));
                    }
                    if (VideoControllerView.this.bdD != null) {
                        VideoControllerView.this.bdD.Ne();
                    }
                    if (VideoControllerView.this.bdE != null) {
                        VideoControllerView.this.bdE.onProgressChanged(seekBar, VideoControllerView.this.bdF, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bdx.seekTo(VideoControllerView.this.bdF);
                VideoControllerView.this.aRJ = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bdE != null) {
                    VideoControllerView.this.bdE.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdw = 50;
        this.aRJ = false;
        this.bdA = true;
        this.bdF = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.aRJ && VideoControllerView.this.bdA && VideoControllerView.this.bdx != null) {
                            int Nd = VideoControllerView.this.Nd();
                            if (VideoControllerView.this.bdC != null) {
                                VideoControllerView.this.bdC.gt(Nd);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bdw - (Nd % VideoControllerView.this.bdw));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bdG = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.aRJ = true;
                if (VideoControllerView.this.bdE != null) {
                    VideoControllerView.this.bdE.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bdF = (int) ((VideoControllerView.this.bdx.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bdy != null) {
                        VideoControllerView.this.bdy.setText(an.cV(VideoControllerView.this.bdF));
                    }
                    if (VideoControllerView.this.bdD != null) {
                        VideoControllerView.this.bdD.Ne();
                    }
                    if (VideoControllerView.this.bdE != null) {
                        VideoControllerView.this.bdE.onProgressChanged(seekBar, VideoControllerView.this.bdF, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bdx.seekTo(VideoControllerView.this.bdF);
                VideoControllerView.this.aRJ = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bdE != null) {
                    VideoControllerView.this.bdE.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdw = 50;
        this.aRJ = false;
        this.bdA = true;
        this.bdF = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.aRJ && VideoControllerView.this.bdA && VideoControllerView.this.bdx != null) {
                            int Nd = VideoControllerView.this.Nd();
                            if (VideoControllerView.this.bdC != null) {
                                VideoControllerView.this.bdC.gt(Nd);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bdw - (Nd % VideoControllerView.this.bdw));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bdG = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.aRJ = true;
                if (VideoControllerView.this.bdE != null) {
                    VideoControllerView.this.bdE.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.bdF = (int) ((VideoControllerView.this.bdx.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.bdy != null) {
                        VideoControllerView.this.bdy.setText(an.cV(VideoControllerView.this.bdF));
                    }
                    if (VideoControllerView.this.bdD != null) {
                        VideoControllerView.this.bdD.Ne();
                    }
                    if (VideoControllerView.this.bdE != null) {
                        VideoControllerView.this.bdE.onProgressChanged(seekBar, VideoControllerView.this.bdF, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bdx.seekTo(VideoControllerView.this.bdF);
                VideoControllerView.this.aRJ = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bdE != null) {
                    VideoControllerView.this.bdE.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bb = bb(context);
        addView(bb, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bdy = (TextView) bb.findViewById(d.g.textview_cur_time);
        this.bdz = (TextView) bb.findViewById(d.g.textview_duration);
        this.bdB = (SeekBar) bb.findViewById(d.g.pb_video_controller_seekBar);
        this.bdB.setOnSeekBarChangeListener(this.bdG);
    }

    protected View bb(Context context) {
        return LayoutInflater.from(context).inflate(d.i.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bdx = mediaPlayerControl;
    }

    public void Q(int i, int i2) {
        this.mDuration = i2;
        this.bdA = false;
        this.mHandler.removeMessages(1);
        this.bdB.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bdy != null) {
            this.bdy.setText(an.cV(i));
        }
        if (this.bdz != null) {
            this.bdz.setText(an.cV(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bdx != null) {
            this.bdw = ((this.bdx.getDuration() / 200) / 50) * 50;
            if (this.bdw < 50) {
                this.bdw = 50;
            } else if (this.bdw > 500) {
                this.bdw = 500;
            }
            this.bdA = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bdw - (this.bdx.getCurrentPosition() % this.bdw));
        }
    }

    public void Nc() {
        this.bdA = false;
        this.mHandler.removeMessages(1);
        this.bdB.setProgress(0);
        if (this.bdy != null) {
            this.bdy.setText(an.cV(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Nd() {
        if (this.bdx == null || this.aRJ) {
            return 0;
        }
        int currentPosition = this.bdx.getCurrentPosition();
        int duration = this.bdx.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bdB != null) {
            if (duration > 0) {
                this.bdB.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bdx.getBufferPercentage();
        }
        if (this.bdy != null) {
            this.bdy.setText(an.cV(currentPosition));
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
            this.bdx.seekTo(i);
            if (this.bdy != null) {
                this.bdy.setText(an.cV(i));
            }
            showProgress();
        }
        if (!this.bdx.isPlaying()) {
            this.bdB.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.bdF;
    }

    public int getCurProgress() {
        if (this.bdB != null) {
            return this.bdB.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.bdC = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.bdD = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bdE = onSeekBarChangeListener;
    }
}
