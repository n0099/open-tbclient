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
    private boolean cHx;
    private TextView cXA;
    private SeekBar cXB;
    private b cXC;
    private a cXD;
    private SeekBar.OnSeekBarChangeListener cXE;
    private int cXF;
    private SeekBar.OnSeekBarChangeListener cXG;
    private int cXx;
    private MediaController.MediaPlayerControl cXy;
    private TextView cXz;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes3.dex */
    public interface a {
        void aDg();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void mu(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.cXx = 50;
        this.cHx = false;
        this.mShowing = true;
        this.cXF = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cHx && VideoControllerView.this.mShowing && VideoControllerView.this.cXy != null) {
                            int aDf = VideoControllerView.this.aDf();
                            if (VideoControllerView.this.cXC != null) {
                                VideoControllerView.this.cXC.mu(aDf);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cXx - (aDf % VideoControllerView.this.cXx));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cXG = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cHx = true;
                if (VideoControllerView.this.cXE != null) {
                    VideoControllerView.this.cXE.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cXF = (int) ((VideoControllerView.this.cXy.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cXz != null) {
                        VideoControllerView.this.cXz.setText(aq.is(VideoControllerView.this.cXF));
                    }
                    if (VideoControllerView.this.cXD != null) {
                        VideoControllerView.this.cXD.aDg();
                    }
                    if (VideoControllerView.this.cXE != null) {
                        VideoControllerView.this.cXE.onProgressChanged(seekBar, VideoControllerView.this.cXF, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cXy.seekTo(VideoControllerView.this.cXF);
                VideoControllerView.this.cHx = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cXE != null) {
                    VideoControllerView.this.cXE.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cXx = 50;
        this.cHx = false;
        this.mShowing = true;
        this.cXF = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cHx && VideoControllerView.this.mShowing && VideoControllerView.this.cXy != null) {
                            int aDf = VideoControllerView.this.aDf();
                            if (VideoControllerView.this.cXC != null) {
                                VideoControllerView.this.cXC.mu(aDf);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cXx - (aDf % VideoControllerView.this.cXx));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cXG = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cHx = true;
                if (VideoControllerView.this.cXE != null) {
                    VideoControllerView.this.cXE.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cXF = (int) ((VideoControllerView.this.cXy.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cXz != null) {
                        VideoControllerView.this.cXz.setText(aq.is(VideoControllerView.this.cXF));
                    }
                    if (VideoControllerView.this.cXD != null) {
                        VideoControllerView.this.cXD.aDg();
                    }
                    if (VideoControllerView.this.cXE != null) {
                        VideoControllerView.this.cXE.onProgressChanged(seekBar, VideoControllerView.this.cXF, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cXy.seekTo(VideoControllerView.this.cXF);
                VideoControllerView.this.cHx = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cXE != null) {
                    VideoControllerView.this.cXE.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cXx = 50;
        this.cHx = false;
        this.mShowing = true;
        this.cXF = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cHx && VideoControllerView.this.mShowing && VideoControllerView.this.cXy != null) {
                            int aDf = VideoControllerView.this.aDf();
                            if (VideoControllerView.this.cXC != null) {
                                VideoControllerView.this.cXC.mu(aDf);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cXx - (aDf % VideoControllerView.this.cXx));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cXG = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cHx = true;
                if (VideoControllerView.this.cXE != null) {
                    VideoControllerView.this.cXE.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.cXF = (int) ((VideoControllerView.this.cXy.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.cXz != null) {
                        VideoControllerView.this.cXz.setText(aq.is(VideoControllerView.this.cXF));
                    }
                    if (VideoControllerView.this.cXD != null) {
                        VideoControllerView.this.cXD.aDg();
                    }
                    if (VideoControllerView.this.cXE != null) {
                        VideoControllerView.this.cXE.onProgressChanged(seekBar, VideoControllerView.this.cXF, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cXy.seekTo(VideoControllerView.this.cXF);
                VideoControllerView.this.cHx = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cXE != null) {
                    VideoControllerView.this.cXE.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View cY = cY(context);
        addView(cY, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.cXz = (TextView) cY.findViewById(R.id.textview_cur_time);
        this.cXA = (TextView) cY.findViewById(R.id.textview_duration);
        this.cXB = (SeekBar) cY.findViewById(R.id.pb_video_controller_seekBar);
        this.cXB.setOnSeekBarChangeListener(this.cXG);
    }

    protected View cY(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cXy = mediaPlayerControl;
    }

    public void aC(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cXB.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.cXz != null) {
            this.cXz.setText(aq.is(i));
        }
        if (this.cXA != null) {
            this.cXA.setText(aq.is(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.cXy != null) {
            this.cXx = ((this.cXy.getDuration() / 200) / 50) * 50;
            if (this.cXx < 50) {
                this.cXx = 50;
            } else if (this.cXx > 500) {
                this.cXx = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cXx - (this.cXy.getCurrentPosition() % this.cXx));
        }
    }

    public void aDe() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cXB.setProgress(0);
        if (this.cXz != null) {
            this.cXz.setText(aq.is(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDf() {
        if (this.cXy == null || this.cHx) {
            return 0;
        }
        int currentPosition = this.cXy.getCurrentPosition();
        int duration = this.cXy.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.cXB != null) {
            if (duration > 0) {
                this.cXB.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cXy.getBufferPercentage();
        }
        if (this.cXz != null) {
            this.cXz.setText(aq.is(currentPosition));
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
            this.cXy.seekTo(i);
            if (this.cXz != null) {
                this.cXz.setText(aq.is(i));
            }
            showProgress();
        }
        if (!this.cXy.isPlaying()) {
            this.cXB.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.cXF;
    }

    public int getCurProgress() {
        if (this.cXB != null) {
            return this.cXB.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.cXC = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.cXD = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.cXE = onSeekBarChangeListener;
    }
}
