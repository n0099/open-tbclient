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
    private int dMq;
    private int fph;
    private MediaController.MediaPlayerControl fpi;
    private TextView fpj;
    private TextView fpk;
    private SeekBar fpl;
    private b fpm;
    private a fpn;
    private SeekBar.OnSeekBarChangeListener fpo;
    private SeekBar.OnSeekBarChangeListener fpp;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes15.dex */
    public interface a {
        void bBr();
    }

    /* loaded from: classes15.dex */
    public interface b {
        void se(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.fph = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dMq = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fpi != null) {
                            int bBq = VideoControllerView.this.bBq();
                            if (VideoControllerView.this.fpm != null) {
                                VideoControllerView.this.fpm.se(bBq);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fph - (bBq % VideoControllerView.this.fph));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fpp = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fpo != null) {
                    VideoControllerView.this.fpo.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dMq = (int) ((VideoControllerView.this.fpi.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fpj != null) {
                        VideoControllerView.this.fpj.setText(at.stringForVideoTime(VideoControllerView.this.dMq));
                    }
                    if (VideoControllerView.this.fpn != null) {
                        VideoControllerView.this.fpn.bBr();
                    }
                    if (VideoControllerView.this.fpo != null) {
                        VideoControllerView.this.fpo.onProgressChanged(seekBar, VideoControllerView.this.dMq, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fpi.seekTo(VideoControllerView.this.dMq);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fpo != null) {
                    VideoControllerView.this.fpo.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fph = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dMq = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fpi != null) {
                            int bBq = VideoControllerView.this.bBq();
                            if (VideoControllerView.this.fpm != null) {
                                VideoControllerView.this.fpm.se(bBq);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fph - (bBq % VideoControllerView.this.fph));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fpp = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fpo != null) {
                    VideoControllerView.this.fpo.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dMq = (int) ((VideoControllerView.this.fpi.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fpj != null) {
                        VideoControllerView.this.fpj.setText(at.stringForVideoTime(VideoControllerView.this.dMq));
                    }
                    if (VideoControllerView.this.fpn != null) {
                        VideoControllerView.this.fpn.bBr();
                    }
                    if (VideoControllerView.this.fpo != null) {
                        VideoControllerView.this.fpo.onProgressChanged(seekBar, VideoControllerView.this.dMq, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fpi.seekTo(VideoControllerView.this.dMq);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fpo != null) {
                    VideoControllerView.this.fpo.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fph = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dMq = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fpi != null) {
                            int bBq = VideoControllerView.this.bBq();
                            if (VideoControllerView.this.fpm != null) {
                                VideoControllerView.this.fpm.se(bBq);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fph - (bBq % VideoControllerView.this.fph));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fpp = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fpo != null) {
                    VideoControllerView.this.fpo.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dMq = (int) ((VideoControllerView.this.fpi.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.fpj != null) {
                        VideoControllerView.this.fpj.setText(at.stringForVideoTime(VideoControllerView.this.dMq));
                    }
                    if (VideoControllerView.this.fpn != null) {
                        VideoControllerView.this.fpn.bBr();
                    }
                    if (VideoControllerView.this.fpo != null) {
                        VideoControllerView.this.fpo.onProgressChanged(seekBar, VideoControllerView.this.dMq, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fpi.seekTo(VideoControllerView.this.dMq);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fpo != null) {
                    VideoControllerView.this.fpo.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View eu = eu(context);
        addView(eu, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fpj = (TextView) eu.findViewById(R.id.textview_cur_time);
        this.fpk = (TextView) eu.findViewById(R.id.textview_duration);
        this.fpl = (SeekBar) eu.findViewById(R.id.pb_video_controller_seekBar);
        this.fpl.setOnSeekBarChangeListener(this.fpp);
    }

    protected View eu(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fpi = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fpl.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.fpj != null) {
            this.fpj.setText(at.stringForVideoTime(i));
        }
        if (this.fpk != null) {
            this.fpk.setText(at.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.fpi != null) {
            this.fph = ((this.fpi.getDuration() / 200) / 50) * 50;
            if (this.fph < 50) {
                this.fph = 50;
            } else if (this.fph > 500) {
                this.fph = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fph - (this.fpi.getCurrentPosition() % this.fph));
        }
    }

    public void aIm() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fpl.setProgress(0);
        if (this.fpj != null) {
            this.fpj.setText(at.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bBq() {
        if (this.fpi == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fpi.getCurrentPosition();
        int duration = this.fpi.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.fpl != null) {
            if (duration > 0) {
                this.fpl.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.fpi.getBufferPercentage();
        }
        if (this.fpj != null) {
            this.fpj.setText(at.stringForVideoTime(currentPosition));
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
            this.fpi.seekTo(i);
            if (this.fpj != null) {
                this.fpj.setText(at.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.fpi.isPlaying()) {
            this.fpl.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.dMq;
    }

    public int getCurProgress() {
        if (this.fpl != null) {
            return this.fpl.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.fpm = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.fpn = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.fpo = onSeekBarChangeListener;
    }
}
