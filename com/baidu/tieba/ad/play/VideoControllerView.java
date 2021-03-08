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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean bdq;
    private int eCG;
    private SeekBar.OnSeekBarChangeListener gjA;
    private SeekBar.OnSeekBarChangeListener gjB;
    private int gjt;
    private MediaController.MediaPlayerControl gju;
    private TextView gjv;
    private TextView gjw;
    private SeekBar gjx;
    private b gjy;
    private a gjz;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void bLP();
    }

    /* loaded from: classes.dex */
    public interface b {
        void td(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.gjt = 50;
        this.mDragging = false;
        this.bdq = true;
        this.eCG = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bdq && VideoControllerView.this.gju != null) {
                            int bLO = VideoControllerView.this.bLO();
                            if (VideoControllerView.this.gjy != null) {
                                VideoControllerView.this.gjy.td(bLO);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gjt - (bLO % VideoControllerView.this.gjt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gjB = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gjA != null) {
                    VideoControllerView.this.gjA.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eCG = (int) ((VideoControllerView.this.gju.getDuration() * i) / 10000);
                    if (VideoControllerView.this.gjv != null) {
                        VideoControllerView.this.gjv.setText(au.stringForVideoTime(VideoControllerView.this.eCG));
                    }
                    if (VideoControllerView.this.gjz != null) {
                        VideoControllerView.this.gjz.bLP();
                    }
                    if (VideoControllerView.this.gjA != null) {
                        VideoControllerView.this.gjA.onProgressChanged(seekBar, VideoControllerView.this.eCG, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.gju.seekTo(VideoControllerView.this.eCG);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gjA != null) {
                    VideoControllerView.this.gjA.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjt = 50;
        this.mDragging = false;
        this.bdq = true;
        this.eCG = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bdq && VideoControllerView.this.gju != null) {
                            int bLO = VideoControllerView.this.bLO();
                            if (VideoControllerView.this.gjy != null) {
                                VideoControllerView.this.gjy.td(bLO);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gjt - (bLO % VideoControllerView.this.gjt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gjB = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gjA != null) {
                    VideoControllerView.this.gjA.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eCG = (int) ((VideoControllerView.this.gju.getDuration() * i) / 10000);
                    if (VideoControllerView.this.gjv != null) {
                        VideoControllerView.this.gjv.setText(au.stringForVideoTime(VideoControllerView.this.eCG));
                    }
                    if (VideoControllerView.this.gjz != null) {
                        VideoControllerView.this.gjz.bLP();
                    }
                    if (VideoControllerView.this.gjA != null) {
                        VideoControllerView.this.gjA.onProgressChanged(seekBar, VideoControllerView.this.eCG, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.gju.seekTo(VideoControllerView.this.eCG);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gjA != null) {
                    VideoControllerView.this.gjA.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjt = 50;
        this.mDragging = false;
        this.bdq = true;
        this.eCG = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bdq && VideoControllerView.this.gju != null) {
                            int bLO = VideoControllerView.this.bLO();
                            if (VideoControllerView.this.gjy != null) {
                                VideoControllerView.this.gjy.td(bLO);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gjt - (bLO % VideoControllerView.this.gjt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gjB = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gjA != null) {
                    VideoControllerView.this.gjA.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eCG = (int) ((VideoControllerView.this.gju.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.gjv != null) {
                        VideoControllerView.this.gjv.setText(au.stringForVideoTime(VideoControllerView.this.eCG));
                    }
                    if (VideoControllerView.this.gjz != null) {
                        VideoControllerView.this.gjz.bLP();
                    }
                    if (VideoControllerView.this.gjA != null) {
                        VideoControllerView.this.gjA.onProgressChanged(seekBar, VideoControllerView.this.eCG, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.gju.seekTo(VideoControllerView.this.eCG);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gjA != null) {
                    VideoControllerView.this.gjA.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View fD = fD(context);
        addView(fD, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.gjv = (TextView) fD.findViewById(R.id.textview_cur_time);
        this.gjw = (TextView) fD.findViewById(R.id.textview_duration);
        this.gjx = (SeekBar) fD.findViewById(R.id.pb_video_controller_seekBar);
        this.gjx.setOnSeekBarChangeListener(this.gjB);
    }

    protected View fD(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gju = mediaPlayerControl;
    }

    public void bx(int i, int i2) {
        this.mDuration = i2;
        this.bdq = false;
        this.mHandler.removeMessages(1);
        this.gjx.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.gjv != null) {
            this.gjv.setText(au.stringForVideoTime(i));
        }
        if (this.gjw != null) {
            this.gjw.setText(au.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.gju != null) {
            this.gjt = ((this.gju.getDuration() / 200) / 50) * 50;
            if (this.gjt < 50) {
                this.gjt = 50;
            } else if (this.gjt > 500) {
                this.gjt = 500;
            }
            this.bdq = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gjt - (this.gju.getCurrentPosition() % this.gjt));
        }
    }

    public void aRr() {
        this.bdq = false;
        this.mHandler.removeMessages(1);
        this.gjx.setProgress(0);
        if (this.gjv != null) {
            this.gjv.setText(au.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bLO() {
        if (this.gju == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.gju.getCurrentPosition();
        int duration = this.gju.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.gjx != null) {
            if (duration > 0) {
                this.gjx.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.gju.getBufferPercentage();
        }
        if (this.gjv != null) {
            this.gjv.setText(au.stringForVideoTime(currentPosition));
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
            this.gju.seekTo(i);
            if (this.gjv != null) {
                this.gjv.setText(au.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.gju.isPlaying()) {
            this.gjx.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.eCG;
    }

    public int getCurProgress() {
        if (this.gjx != null) {
            return this.gjx.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.gjy = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.gjz = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gjA = onSeekBarChangeListener;
    }
}
