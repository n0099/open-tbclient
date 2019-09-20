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
    private boolean cIv;
    private int cZk;
    private MediaController.MediaPlayerControl cZl;
    private TextView cZm;
    private TextView cZn;
    private SeekBar cZo;
    private b cZp;
    private a cZq;
    private SeekBar.OnSeekBarChangeListener cZr;
    private int cZs;
    private SeekBar.OnSeekBarChangeListener cZt;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes3.dex */
    public interface a {
        void aDM();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void mz(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.cZk = 50;
        this.cIv = false;
        this.mShowing = true;
        this.cZs = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cIv && VideoControllerView.this.mShowing && VideoControllerView.this.cZl != null) {
                            int aDL = VideoControllerView.this.aDL();
                            if (VideoControllerView.this.cZp != null) {
                                VideoControllerView.this.cZp.mz(aDL);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cZk - (aDL % VideoControllerView.this.cZk));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cZt = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cIv = true;
                if (VideoControllerView.this.cZr != null) {
                    VideoControllerView.this.cZr.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cZs = (int) ((VideoControllerView.this.cZl.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cZm != null) {
                        VideoControllerView.this.cZm.setText(aq.it(VideoControllerView.this.cZs));
                    }
                    if (VideoControllerView.this.cZq != null) {
                        VideoControllerView.this.cZq.aDM();
                    }
                    if (VideoControllerView.this.cZr != null) {
                        VideoControllerView.this.cZr.onProgressChanged(seekBar, VideoControllerView.this.cZs, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cZl.seekTo(VideoControllerView.this.cZs);
                VideoControllerView.this.cIv = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cZr != null) {
                    VideoControllerView.this.cZr.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cZk = 50;
        this.cIv = false;
        this.mShowing = true;
        this.cZs = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cIv && VideoControllerView.this.mShowing && VideoControllerView.this.cZl != null) {
                            int aDL = VideoControllerView.this.aDL();
                            if (VideoControllerView.this.cZp != null) {
                                VideoControllerView.this.cZp.mz(aDL);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cZk - (aDL % VideoControllerView.this.cZk));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cZt = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cIv = true;
                if (VideoControllerView.this.cZr != null) {
                    VideoControllerView.this.cZr.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cZs = (int) ((VideoControllerView.this.cZl.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cZm != null) {
                        VideoControllerView.this.cZm.setText(aq.it(VideoControllerView.this.cZs));
                    }
                    if (VideoControllerView.this.cZq != null) {
                        VideoControllerView.this.cZq.aDM();
                    }
                    if (VideoControllerView.this.cZr != null) {
                        VideoControllerView.this.cZr.onProgressChanged(seekBar, VideoControllerView.this.cZs, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cZl.seekTo(VideoControllerView.this.cZs);
                VideoControllerView.this.cIv = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cZr != null) {
                    VideoControllerView.this.cZr.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cZk = 50;
        this.cIv = false;
        this.mShowing = true;
        this.cZs = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cIv && VideoControllerView.this.mShowing && VideoControllerView.this.cZl != null) {
                            int aDL = VideoControllerView.this.aDL();
                            if (VideoControllerView.this.cZp != null) {
                                VideoControllerView.this.cZp.mz(aDL);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cZk - (aDL % VideoControllerView.this.cZk));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cZt = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cIv = true;
                if (VideoControllerView.this.cZr != null) {
                    VideoControllerView.this.cZr.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.cZs = (int) ((VideoControllerView.this.cZl.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.cZm != null) {
                        VideoControllerView.this.cZm.setText(aq.it(VideoControllerView.this.cZs));
                    }
                    if (VideoControllerView.this.cZq != null) {
                        VideoControllerView.this.cZq.aDM();
                    }
                    if (VideoControllerView.this.cZr != null) {
                        VideoControllerView.this.cZr.onProgressChanged(seekBar, VideoControllerView.this.cZs, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cZl.seekTo(VideoControllerView.this.cZs);
                VideoControllerView.this.cIv = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cZr != null) {
                    VideoControllerView.this.cZr.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View cY = cY(context);
        addView(cY, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.cZm = (TextView) cY.findViewById(R.id.textview_cur_time);
        this.cZn = (TextView) cY.findViewById(R.id.textview_duration);
        this.cZo = (SeekBar) cY.findViewById(R.id.pb_video_controller_seekBar);
        this.cZo.setOnSeekBarChangeListener(this.cZt);
    }

    protected View cY(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cZl = mediaPlayerControl;
    }

    public void aC(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cZo.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.cZm != null) {
            this.cZm.setText(aq.it(i));
        }
        if (this.cZn != null) {
            this.cZn.setText(aq.it(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.cZl != null) {
            this.cZk = ((this.cZl.getDuration() / 200) / 50) * 50;
            if (this.cZk < 50) {
                this.cZk = 50;
            } else if (this.cZk > 500) {
                this.cZk = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cZk - (this.cZl.getCurrentPosition() % this.cZk));
        }
    }

    public void aDK() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cZo.setProgress(0);
        if (this.cZm != null) {
            this.cZm.setText(aq.it(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDL() {
        if (this.cZl == null || this.cIv) {
            return 0;
        }
        int currentPosition = this.cZl.getCurrentPosition();
        int duration = this.cZl.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.cZo != null) {
            if (duration > 0) {
                this.cZo.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cZl.getBufferPercentage();
        }
        if (this.cZm != null) {
            this.cZm.setText(aq.it(currentPosition));
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
            this.cZl.seekTo(i);
            if (this.cZm != null) {
                this.cZm.setText(aq.it(i));
            }
            showProgress();
        }
        if (!this.cZl.isPlaying()) {
            this.cZo.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.cZs;
    }

    public int getCurProgress() {
        if (this.cZo != null) {
            return this.cZo.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.cZp = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.cZq = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.cZr = onSeekBarChangeListener;
    }
}
