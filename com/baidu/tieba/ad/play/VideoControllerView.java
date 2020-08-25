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
/* loaded from: classes15.dex */
public class VideoControllerView extends RelativeLayout {
    private int dMm;
    private int fpd;
    private MediaController.MediaPlayerControl fpe;
    private TextView fpf;
    private TextView fpg;
    private SeekBar fph;
    private b fpi;
    private a fpj;
    private SeekBar.OnSeekBarChangeListener fpk;
    private SeekBar.OnSeekBarChangeListener fpl;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes15.dex */
    public interface a {
        void bBq();
    }

    /* loaded from: classes15.dex */
    public interface b {
        void se(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.fpd = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dMm = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fpe != null) {
                            int bBp = VideoControllerView.this.bBp();
                            if (VideoControllerView.this.fpi != null) {
                                VideoControllerView.this.fpi.se(bBp);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fpd - (bBp % VideoControllerView.this.fpd));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fpl = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fpk != null) {
                    VideoControllerView.this.fpk.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dMm = (int) ((VideoControllerView.this.fpe.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fpf != null) {
                        VideoControllerView.this.fpf.setText(at.stringForVideoTime(VideoControllerView.this.dMm));
                    }
                    if (VideoControllerView.this.fpj != null) {
                        VideoControllerView.this.fpj.bBq();
                    }
                    if (VideoControllerView.this.fpk != null) {
                        VideoControllerView.this.fpk.onProgressChanged(seekBar, VideoControllerView.this.dMm, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fpe.seekTo(VideoControllerView.this.dMm);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fpk != null) {
                    VideoControllerView.this.fpk.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fpd = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dMm = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fpe != null) {
                            int bBp = VideoControllerView.this.bBp();
                            if (VideoControllerView.this.fpi != null) {
                                VideoControllerView.this.fpi.se(bBp);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fpd - (bBp % VideoControllerView.this.fpd));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fpl = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fpk != null) {
                    VideoControllerView.this.fpk.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dMm = (int) ((VideoControllerView.this.fpe.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fpf != null) {
                        VideoControllerView.this.fpf.setText(at.stringForVideoTime(VideoControllerView.this.dMm));
                    }
                    if (VideoControllerView.this.fpj != null) {
                        VideoControllerView.this.fpj.bBq();
                    }
                    if (VideoControllerView.this.fpk != null) {
                        VideoControllerView.this.fpk.onProgressChanged(seekBar, VideoControllerView.this.dMm, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fpe.seekTo(VideoControllerView.this.dMm);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fpk != null) {
                    VideoControllerView.this.fpk.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fpd = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dMm = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fpe != null) {
                            int bBp = VideoControllerView.this.bBp();
                            if (VideoControllerView.this.fpi != null) {
                                VideoControllerView.this.fpi.se(bBp);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fpd - (bBp % VideoControllerView.this.fpd));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fpl = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fpk != null) {
                    VideoControllerView.this.fpk.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dMm = (int) ((VideoControllerView.this.fpe.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.fpf != null) {
                        VideoControllerView.this.fpf.setText(at.stringForVideoTime(VideoControllerView.this.dMm));
                    }
                    if (VideoControllerView.this.fpj != null) {
                        VideoControllerView.this.fpj.bBq();
                    }
                    if (VideoControllerView.this.fpk != null) {
                        VideoControllerView.this.fpk.onProgressChanged(seekBar, VideoControllerView.this.dMm, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fpe.seekTo(VideoControllerView.this.dMm);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fpk != null) {
                    VideoControllerView.this.fpk.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View eu = eu(context);
        addView(eu, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fpf = (TextView) eu.findViewById(R.id.textview_cur_time);
        this.fpg = (TextView) eu.findViewById(R.id.textview_duration);
        this.fph = (SeekBar) eu.findViewById(R.id.pb_video_controller_seekBar);
        this.fph.setOnSeekBarChangeListener(this.fpl);
    }

    protected View eu(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fpe = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fph.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.fpf != null) {
            this.fpf.setText(at.stringForVideoTime(i));
        }
        if (this.fpg != null) {
            this.fpg.setText(at.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.fpe != null) {
            this.fpd = ((this.fpe.getDuration() / 200) / 50) * 50;
            if (this.fpd < 50) {
                this.fpd = 50;
            } else if (this.fpd > 500) {
                this.fpd = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fpd - (this.fpe.getCurrentPosition() % this.fpd));
        }
    }

    public void aIm() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fph.setProgress(0);
        if (this.fpf != null) {
            this.fpf.setText(at.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bBp() {
        if (this.fpe == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fpe.getCurrentPosition();
        int duration = this.fpe.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.fph != null) {
            if (duration > 0) {
                this.fph.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.fpe.getBufferPercentage();
        }
        if (this.fpf != null) {
            this.fpf.setText(at.stringForVideoTime(currentPosition));
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
            this.fpe.seekTo(i);
            if (this.fpf != null) {
                this.fpf.setText(at.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.fpe.isPlaying()) {
            this.fph.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.dMm;
    }

    public int getCurProgress() {
        if (this.fph != null) {
            return this.fph.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.fpi = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.fpj = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.fpk = onSeekBarChangeListener;
    }
}
