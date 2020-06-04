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
    private int dsA;
    private int eOY;
    private MediaController.MediaPlayerControl eOZ;
    private TextView ePa;
    private TextView ePb;
    private SeekBar ePc;
    private b ePd;
    private a ePe;
    private SeekBar.OnSeekBarChangeListener ePf;
    private SeekBar.OnSeekBarChangeListener ePg;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes8.dex */
    public interface a {
        void bmQ();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void pg(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.eOY = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dsA = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eOZ != null) {
                            int bmP = VideoControllerView.this.bmP();
                            if (VideoControllerView.this.ePd != null) {
                                VideoControllerView.this.ePd.pg(bmP);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eOY - (bmP % VideoControllerView.this.eOY));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ePg = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.ePf != null) {
                    VideoControllerView.this.ePf.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dsA = (int) ((VideoControllerView.this.eOZ.getDuration() * i) / 10000);
                    if (VideoControllerView.this.ePa != null) {
                        VideoControllerView.this.ePa.setText(aq.stringForVideoTime(VideoControllerView.this.dsA));
                    }
                    if (VideoControllerView.this.ePe != null) {
                        VideoControllerView.this.ePe.bmQ();
                    }
                    if (VideoControllerView.this.ePf != null) {
                        VideoControllerView.this.ePf.onProgressChanged(seekBar, VideoControllerView.this.dsA, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.eOZ.seekTo(VideoControllerView.this.dsA);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.ePf != null) {
                    VideoControllerView.this.ePf.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eOY = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dsA = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eOZ != null) {
                            int bmP = VideoControllerView.this.bmP();
                            if (VideoControllerView.this.ePd != null) {
                                VideoControllerView.this.ePd.pg(bmP);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eOY - (bmP % VideoControllerView.this.eOY));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ePg = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.ePf != null) {
                    VideoControllerView.this.ePf.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dsA = (int) ((VideoControllerView.this.eOZ.getDuration() * i) / 10000);
                    if (VideoControllerView.this.ePa != null) {
                        VideoControllerView.this.ePa.setText(aq.stringForVideoTime(VideoControllerView.this.dsA));
                    }
                    if (VideoControllerView.this.ePe != null) {
                        VideoControllerView.this.ePe.bmQ();
                    }
                    if (VideoControllerView.this.ePf != null) {
                        VideoControllerView.this.ePf.onProgressChanged(seekBar, VideoControllerView.this.dsA, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.eOZ.seekTo(VideoControllerView.this.dsA);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.ePf != null) {
                    VideoControllerView.this.ePf.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eOY = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dsA = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eOZ != null) {
                            int bmP = VideoControllerView.this.bmP();
                            if (VideoControllerView.this.ePd != null) {
                                VideoControllerView.this.ePd.pg(bmP);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eOY - (bmP % VideoControllerView.this.eOY));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ePg = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.ePf != null) {
                    VideoControllerView.this.ePf.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dsA = (int) ((VideoControllerView.this.eOZ.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.ePa != null) {
                        VideoControllerView.this.ePa.setText(aq.stringForVideoTime(VideoControllerView.this.dsA));
                    }
                    if (VideoControllerView.this.ePe != null) {
                        VideoControllerView.this.ePe.bmQ();
                    }
                    if (VideoControllerView.this.ePf != null) {
                        VideoControllerView.this.ePf.onProgressChanged(seekBar, VideoControllerView.this.dsA, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.eOZ.seekTo(VideoControllerView.this.dsA);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.ePf != null) {
                    VideoControllerView.this.ePf.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ei = ei(context);
        addView(ei, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.ePa = (TextView) ei.findViewById(R.id.textview_cur_time);
        this.ePb = (TextView) ei.findViewById(R.id.textview_duration);
        this.ePc = (SeekBar) ei.findViewById(R.id.pb_video_controller_seekBar);
        this.ePc.setOnSeekBarChangeListener(this.ePg);
    }

    protected View ei(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eOZ = mediaPlayerControl;
    }

    public void bj(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.ePc.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.ePa != null) {
            this.ePa.setText(aq.stringForVideoTime(i));
        }
        if (this.ePb != null) {
            this.ePb.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.eOZ != null) {
            this.eOY = ((this.eOZ.getDuration() / 200) / 50) * 50;
            if (this.eOY < 50) {
                this.eOY = 50;
            } else if (this.eOY > 500) {
                this.eOY = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eOY - (this.eOZ.getCurrentPosition() % this.eOY));
        }
    }

    public void awd() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.ePc.setProgress(0);
        if (this.ePa != null) {
            this.ePa.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bmP() {
        if (this.eOZ == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.eOZ.getCurrentPosition();
        int duration = this.eOZ.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.ePc != null) {
            if (duration > 0) {
                this.ePc.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.eOZ.getBufferPercentage();
        }
        if (this.ePa != null) {
            this.ePa.setText(aq.stringForVideoTime(currentPosition));
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
            this.eOZ.seekTo(i);
            if (this.ePa != null) {
                this.ePa.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.eOZ.isPlaying()) {
            this.ePc.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.dsA;
    }

    public int getCurProgress() {
        if (this.ePc != null) {
            return this.ePc.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.ePd = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.ePe = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.ePf = onSeekBarChangeListener;
    }
}
