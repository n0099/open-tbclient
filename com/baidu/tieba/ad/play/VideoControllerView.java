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
    private int eAn;
    private MediaController.MediaPlayerControl eAo;
    private TextView eAp;
    private TextView eAq;
    private SeekBar eAr;
    private b eAs;
    private a eAt;
    private SeekBar.OnSeekBarChangeListener eAu;
    private int eAv;
    private SeekBar.OnSeekBarChangeListener eAw;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes8.dex */
    public interface a {
        void bgD();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void ox(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.eAn = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eAv = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eAo != null) {
                            int bgC = VideoControllerView.this.bgC();
                            if (VideoControllerView.this.eAs != null) {
                                VideoControllerView.this.eAs.ox(bgC);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eAn - (bgC % VideoControllerView.this.eAn));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eAw = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eAu != null) {
                    VideoControllerView.this.eAu.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eAv = (int) ((VideoControllerView.this.eAo.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eAp != null) {
                        VideoControllerView.this.eAp.setText(aq.stringForVideoTime(VideoControllerView.this.eAv));
                    }
                    if (VideoControllerView.this.eAt != null) {
                        VideoControllerView.this.eAt.bgD();
                    }
                    if (VideoControllerView.this.eAu != null) {
                        VideoControllerView.this.eAu.onProgressChanged(seekBar, VideoControllerView.this.eAv, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.eAo.seekTo(VideoControllerView.this.eAv);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eAu != null) {
                    VideoControllerView.this.eAu.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eAn = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eAv = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eAo != null) {
                            int bgC = VideoControllerView.this.bgC();
                            if (VideoControllerView.this.eAs != null) {
                                VideoControllerView.this.eAs.ox(bgC);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eAn - (bgC % VideoControllerView.this.eAn));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eAw = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eAu != null) {
                    VideoControllerView.this.eAu.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eAv = (int) ((VideoControllerView.this.eAo.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eAp != null) {
                        VideoControllerView.this.eAp.setText(aq.stringForVideoTime(VideoControllerView.this.eAv));
                    }
                    if (VideoControllerView.this.eAt != null) {
                        VideoControllerView.this.eAt.bgD();
                    }
                    if (VideoControllerView.this.eAu != null) {
                        VideoControllerView.this.eAu.onProgressChanged(seekBar, VideoControllerView.this.eAv, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.eAo.seekTo(VideoControllerView.this.eAv);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eAu != null) {
                    VideoControllerView.this.eAu.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eAn = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eAv = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eAo != null) {
                            int bgC = VideoControllerView.this.bgC();
                            if (VideoControllerView.this.eAs != null) {
                                VideoControllerView.this.eAs.ox(bgC);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eAn - (bgC % VideoControllerView.this.eAn));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eAw = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eAu != null) {
                    VideoControllerView.this.eAu.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eAv = (int) ((VideoControllerView.this.eAo.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.eAp != null) {
                        VideoControllerView.this.eAp.setText(aq.stringForVideoTime(VideoControllerView.this.eAv));
                    }
                    if (VideoControllerView.this.eAt != null) {
                        VideoControllerView.this.eAt.bgD();
                    }
                    if (VideoControllerView.this.eAu != null) {
                        VideoControllerView.this.eAu.onProgressChanged(seekBar, VideoControllerView.this.eAv, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.eAo.seekTo(VideoControllerView.this.eAv);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eAu != null) {
                    VideoControllerView.this.eAu.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View dR = dR(context);
        addView(dR, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.eAp = (TextView) dR.findViewById(R.id.textview_cur_time);
        this.eAq = (TextView) dR.findViewById(R.id.textview_duration);
        this.eAr = (SeekBar) dR.findViewById(R.id.pb_video_controller_seekBar);
        this.eAr.setOnSeekBarChangeListener(this.eAw);
    }

    protected View dR(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eAo = mediaPlayerControl;
    }

    public void be(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eAr.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.eAp != null) {
            this.eAp.setText(aq.stringForVideoTime(i));
        }
        if (this.eAq != null) {
            this.eAq.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.eAo != null) {
            this.eAn = ((this.eAo.getDuration() / 200) / 50) * 50;
            if (this.eAn < 50) {
                this.eAn = 50;
            } else if (this.eAn > 500) {
                this.eAn = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eAn - (this.eAo.getCurrentPosition() % this.eAn));
        }
    }

    public void asw() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eAr.setProgress(0);
        if (this.eAp != null) {
            this.eAp.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bgC() {
        if (this.eAo == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.eAo.getCurrentPosition();
        int duration = this.eAo.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.eAr != null) {
            if (duration > 0) {
                this.eAr.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.eAo.getBufferPercentage();
        }
        if (this.eAp != null) {
            this.eAp.setText(aq.stringForVideoTime(currentPosition));
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
            this.eAo.seekTo(i);
            if (this.eAp != null) {
                this.eAp.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.eAo.isPlaying()) {
            this.eAr.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.eAv;
    }

    public int getCurProgress() {
        if (this.eAr != null) {
            return this.eAr.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.eAs = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.eAt = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.eAu = onSeekBarChangeListener;
    }
}
