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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class VideoControllerView extends RelativeLayout {
    private int dDc;
    private int fdL;
    private MediaController.MediaPlayerControl fdM;
    private TextView fdN;
    private TextView fdO;
    private SeekBar fdP;
    private b fdQ;
    private a fdR;
    private SeekBar.OnSeekBarChangeListener fdS;
    private SeekBar.OnSeekBarChangeListener fdT;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes15.dex */
    public interface a {
        void bst();
    }

    /* loaded from: classes15.dex */
    public interface b {
        void pS(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.fdL = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dDc = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fdM != null) {
                            int bss = VideoControllerView.this.bss();
                            if (VideoControllerView.this.fdQ != null) {
                                VideoControllerView.this.fdQ.pS(bss);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fdL - (bss % VideoControllerView.this.fdL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fdT = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fdS != null) {
                    VideoControllerView.this.fdS.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dDc = (int) ((VideoControllerView.this.fdM.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fdN != null) {
                        VideoControllerView.this.fdN.setText(as.stringForVideoTime(VideoControllerView.this.dDc));
                    }
                    if (VideoControllerView.this.fdR != null) {
                        VideoControllerView.this.fdR.bst();
                    }
                    if (VideoControllerView.this.fdS != null) {
                        VideoControllerView.this.fdS.onProgressChanged(seekBar, VideoControllerView.this.dDc, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fdM.seekTo(VideoControllerView.this.dDc);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fdS != null) {
                    VideoControllerView.this.fdS.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdL = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dDc = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fdM != null) {
                            int bss = VideoControllerView.this.bss();
                            if (VideoControllerView.this.fdQ != null) {
                                VideoControllerView.this.fdQ.pS(bss);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fdL - (bss % VideoControllerView.this.fdL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fdT = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fdS != null) {
                    VideoControllerView.this.fdS.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dDc = (int) ((VideoControllerView.this.fdM.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fdN != null) {
                        VideoControllerView.this.fdN.setText(as.stringForVideoTime(VideoControllerView.this.dDc));
                    }
                    if (VideoControllerView.this.fdR != null) {
                        VideoControllerView.this.fdR.bst();
                    }
                    if (VideoControllerView.this.fdS != null) {
                        VideoControllerView.this.fdS.onProgressChanged(seekBar, VideoControllerView.this.dDc, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fdM.seekTo(VideoControllerView.this.dDc);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fdS != null) {
                    VideoControllerView.this.fdS.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fdL = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dDc = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fdM != null) {
                            int bss = VideoControllerView.this.bss();
                            if (VideoControllerView.this.fdQ != null) {
                                VideoControllerView.this.fdQ.pS(bss);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fdL - (bss % VideoControllerView.this.fdL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fdT = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fdS != null) {
                    VideoControllerView.this.fdS.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dDc = (int) ((VideoControllerView.this.fdM.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.fdN != null) {
                        VideoControllerView.this.fdN.setText(as.stringForVideoTime(VideoControllerView.this.dDc));
                    }
                    if (VideoControllerView.this.fdR != null) {
                        VideoControllerView.this.fdR.bst();
                    }
                    if (VideoControllerView.this.fdS != null) {
                        VideoControllerView.this.fdS.onProgressChanged(seekBar, VideoControllerView.this.dDc, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.fdM.seekTo(VideoControllerView.this.dDc);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fdS != null) {
                    VideoControllerView.this.fdS.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View em = em(context);
        addView(em, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.fdN = (TextView) em.findViewById(R.id.textview_cur_time);
        this.fdO = (TextView) em.findViewById(R.id.textview_duration);
        this.fdP = (SeekBar) em.findViewById(R.id.pb_video_controller_seekBar);
        this.fdP.setOnSeekBarChangeListener(this.fdT);
    }

    protected View em(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fdM = mediaPlayerControl;
    }

    public void bq(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fdP.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.fdN != null) {
            this.fdN.setText(as.stringForVideoTime(i));
        }
        if (this.fdO != null) {
            this.fdO.setText(as.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.fdM != null) {
            this.fdL = ((this.fdM.getDuration() / 200) / 50) * 50;
            if (this.fdL < 50) {
                this.fdL = 50;
            } else if (this.fdL > 500) {
                this.fdL = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fdL - (this.fdM.getCurrentPosition() % this.fdL));
        }
    }

    public void azZ() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fdP.setProgress(0);
        if (this.fdN != null) {
            this.fdN.setText(as.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bss() {
        if (this.fdM == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.fdM.getCurrentPosition();
        int duration = this.fdM.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.fdP != null) {
            if (duration > 0) {
                this.fdP.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.fdM.getBufferPercentage();
        }
        if (this.fdN != null) {
            this.fdN.setText(as.stringForVideoTime(currentPosition));
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
            this.fdM.seekTo(i);
            if (this.fdN != null) {
                this.fdN.setText(as.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.fdM.isPlaying()) {
            this.fdP.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.dDc;
    }

    public int getCurProgress() {
        if (this.fdP != null) {
            return this.fdP.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.fdQ = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.fdR = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.fdS = onSeekBarChangeListener;
    }
}
