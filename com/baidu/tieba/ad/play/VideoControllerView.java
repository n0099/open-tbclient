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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class VideoControllerView extends RelativeLayout {
    private int dxk;
    private int eZj;
    private MediaController.MediaPlayerControl eZk;
    private TextView eZl;
    private TextView eZm;
    private SeekBar eZn;
    private b eZo;
    private a eZp;
    private SeekBar.OnSeekBarChangeListener eZq;
    private SeekBar.OnSeekBarChangeListener eZr;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes8.dex */
    public interface a {
        void bpr();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void pF(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.eZj = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dxk = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eZk != null) {
                            int bpq = VideoControllerView.this.bpq();
                            if (VideoControllerView.this.eZo != null) {
                                VideoControllerView.this.eZo.pF(bpq);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eZj - (bpq % VideoControllerView.this.eZj));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eZr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eZq != null) {
                    VideoControllerView.this.eZq.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dxk = (int) ((VideoControllerView.this.eZk.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eZl != null) {
                        VideoControllerView.this.eZl.setText(ar.stringForVideoTime(VideoControllerView.this.dxk));
                    }
                    if (VideoControllerView.this.eZp != null) {
                        VideoControllerView.this.eZp.bpr();
                    }
                    if (VideoControllerView.this.eZq != null) {
                        VideoControllerView.this.eZq.onProgressChanged(seekBar, VideoControllerView.this.dxk, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.eZk.seekTo(VideoControllerView.this.dxk);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eZq != null) {
                    VideoControllerView.this.eZq.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eZj = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dxk = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eZk != null) {
                            int bpq = VideoControllerView.this.bpq();
                            if (VideoControllerView.this.eZo != null) {
                                VideoControllerView.this.eZo.pF(bpq);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eZj - (bpq % VideoControllerView.this.eZj));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eZr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eZq != null) {
                    VideoControllerView.this.eZq.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dxk = (int) ((VideoControllerView.this.eZk.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eZl != null) {
                        VideoControllerView.this.eZl.setText(ar.stringForVideoTime(VideoControllerView.this.dxk));
                    }
                    if (VideoControllerView.this.eZp != null) {
                        VideoControllerView.this.eZp.bpr();
                    }
                    if (VideoControllerView.this.eZq != null) {
                        VideoControllerView.this.eZq.onProgressChanged(seekBar, VideoControllerView.this.dxk, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.eZk.seekTo(VideoControllerView.this.dxk);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eZq != null) {
                    VideoControllerView.this.eZq.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eZj = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dxk = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eZk != null) {
                            int bpq = VideoControllerView.this.bpq();
                            if (VideoControllerView.this.eZo != null) {
                                VideoControllerView.this.eZo.pF(bpq);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eZj - (bpq % VideoControllerView.this.eZj));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eZr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eZq != null) {
                    VideoControllerView.this.eZq.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dxk = (int) ((VideoControllerView.this.eZk.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.eZl != null) {
                        VideoControllerView.this.eZl.setText(ar.stringForVideoTime(VideoControllerView.this.dxk));
                    }
                    if (VideoControllerView.this.eZp != null) {
                        VideoControllerView.this.eZp.bpr();
                    }
                    if (VideoControllerView.this.eZq != null) {
                        VideoControllerView.this.eZq.onProgressChanged(seekBar, VideoControllerView.this.dxk, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.eZk.seekTo(VideoControllerView.this.dxk);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eZq != null) {
                    VideoControllerView.this.eZq.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ej = ej(context);
        addView(ej, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.eZl = (TextView) ej.findViewById(R.id.textview_cur_time);
        this.eZm = (TextView) ej.findViewById(R.id.textview_duration);
        this.eZn = (SeekBar) ej.findViewById(R.id.pb_video_controller_seekBar);
        this.eZn.setOnSeekBarChangeListener(this.eZr);
    }

    protected View ej(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eZk = mediaPlayerControl;
    }

    public void bn(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eZn.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.eZl != null) {
            this.eZl.setText(ar.stringForVideoTime(i));
        }
        if (this.eZm != null) {
            this.eZm.setText(ar.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.eZk != null) {
            this.eZj = ((this.eZk.getDuration() / 200) / 50) * 50;
            if (this.eZj < 50) {
                this.eZj = 50;
            } else if (this.eZj > 500) {
                this.eZj = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eZj - (this.eZk.getCurrentPosition() % this.eZj));
        }
    }

    public void axj() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eZn.setProgress(0);
        if (this.eZl != null) {
            this.eZl.setText(ar.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bpq() {
        if (this.eZk == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.eZk.getCurrentPosition();
        int duration = this.eZk.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.eZn != null) {
            if (duration > 0) {
                this.eZn.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.eZk.getBufferPercentage();
        }
        if (this.eZl != null) {
            this.eZl.setText(ar.stringForVideoTime(currentPosition));
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
            this.eZk.seekTo(i);
            if (this.eZl != null) {
                this.eZl.setText(ar.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.eZk.isPlaying()) {
            this.eZn.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.dxk;
    }

    public int getCurProgress() {
        if (this.eZn != null) {
            return this.eZn.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.eZo = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.eZp = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.eZq = onSeekBarChangeListener;
    }
}
