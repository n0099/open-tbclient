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
/* loaded from: classes8.dex */
public class VideoControllerView extends RelativeLayout {
    private b eaA;
    private a eaB;
    private SeekBar.OnSeekBarChangeListener eaC;
    private int eaD;
    private SeekBar.OnSeekBarChangeListener eaE;
    private int eav;
    private MediaController.MediaPlayerControl eaw;
    private TextView eax;
    private TextView eay;
    private SeekBar eaz;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes8.dex */
    public interface a {
        void aYB();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void ok(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.eav = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eaD = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eaw != null) {
                            int aYA = VideoControllerView.this.aYA();
                            if (VideoControllerView.this.eaA != null) {
                                VideoControllerView.this.eaA.ok(aYA);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eav - (aYA % VideoControllerView.this.eav));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eaE = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eaC != null) {
                    VideoControllerView.this.eaC.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eaD = (int) ((VideoControllerView.this.eaw.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eax != null) {
                        VideoControllerView.this.eax.setText(aq.stringForVideoTime(VideoControllerView.this.eaD));
                    }
                    if (VideoControllerView.this.eaB != null) {
                        VideoControllerView.this.eaB.aYB();
                    }
                    if (VideoControllerView.this.eaC != null) {
                        VideoControllerView.this.eaC.onProgressChanged(seekBar, VideoControllerView.this.eaD, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.eaw.seekTo(VideoControllerView.this.eaD);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eaC != null) {
                    VideoControllerView.this.eaC.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eav = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eaD = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eaw != null) {
                            int aYA = VideoControllerView.this.aYA();
                            if (VideoControllerView.this.eaA != null) {
                                VideoControllerView.this.eaA.ok(aYA);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eav - (aYA % VideoControllerView.this.eav));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eaE = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eaC != null) {
                    VideoControllerView.this.eaC.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eaD = (int) ((VideoControllerView.this.eaw.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eax != null) {
                        VideoControllerView.this.eax.setText(aq.stringForVideoTime(VideoControllerView.this.eaD));
                    }
                    if (VideoControllerView.this.eaB != null) {
                        VideoControllerView.this.eaB.aYB();
                    }
                    if (VideoControllerView.this.eaC != null) {
                        VideoControllerView.this.eaC.onProgressChanged(seekBar, VideoControllerView.this.eaD, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.eaw.seekTo(VideoControllerView.this.eaD);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eaC != null) {
                    VideoControllerView.this.eaC.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eav = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eaD = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eaw != null) {
                            int aYA = VideoControllerView.this.aYA();
                            if (VideoControllerView.this.eaA != null) {
                                VideoControllerView.this.eaA.ok(aYA);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eav - (aYA % VideoControllerView.this.eav));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eaE = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eaC != null) {
                    VideoControllerView.this.eaC.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eaD = (int) ((VideoControllerView.this.eaw.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.eax != null) {
                        VideoControllerView.this.eax.setText(aq.stringForVideoTime(VideoControllerView.this.eaD));
                    }
                    if (VideoControllerView.this.eaB != null) {
                        VideoControllerView.this.eaB.aYB();
                    }
                    if (VideoControllerView.this.eaC != null) {
                        VideoControllerView.this.eaC.onProgressChanged(seekBar, VideoControllerView.this.eaD, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.eaw.seekTo(VideoControllerView.this.eaD);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eaC != null) {
                    VideoControllerView.this.eaC.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View er = er(context);
        addView(er, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.eax = (TextView) er.findViewById(R.id.textview_cur_time);
        this.eay = (TextView) er.findViewById(R.id.textview_duration);
        this.eaz = (SeekBar) er.findViewById(R.id.pb_video_controller_seekBar);
        this.eaz.setOnSeekBarChangeListener(this.eaE);
    }

    protected View er(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eaw = mediaPlayerControl;
    }

    public void ba(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eaz.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.eax != null) {
            this.eax.setText(aq.stringForVideoTime(i));
        }
        if (this.eay != null) {
            this.eay.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.eaw != null) {
            this.eav = ((this.eaw.getDuration() / 200) / 50) * 50;
            if (this.eav < 50) {
                this.eav = 50;
            } else if (this.eav > 500) {
                this.eav = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eav - (this.eaw.getCurrentPosition() % this.eav));
        }
    }

    public void akm() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eaz.setProgress(0);
        if (this.eax != null) {
            this.eax.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aYA() {
        if (this.eaw == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.eaw.getCurrentPosition();
        int duration = this.eaw.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.eaz != null) {
            if (duration > 0) {
                this.eaz.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.eaw.getBufferPercentage();
        }
        if (this.eax != null) {
            this.eax.setText(aq.stringForVideoTime(currentPosition));
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
            this.eaw.seekTo(i);
            if (this.eax != null) {
                this.eax.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.eaw.isPlaying()) {
            this.eaz.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.eaD;
    }

    public int getCurProgress() {
        if (this.eaz != null) {
            return this.eaz.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.eaA = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.eaB = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.eaC = onSeekBarChangeListener;
    }
}
