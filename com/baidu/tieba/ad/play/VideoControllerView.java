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
/* loaded from: classes5.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean ahQ;
    private int dVE;
    private MediaController.MediaPlayerControl dVF;
    private TextView dVG;
    private TextView dVH;
    private SeekBar dVI;
    private b dVJ;
    private a dVK;
    private SeekBar.OnSeekBarChangeListener dVL;
    private int dVM;
    private SeekBar.OnSeekBarChangeListener dVN;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void aVM();
    }

    /* loaded from: classes5.dex */
    public interface b {
        void nR(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.dVE = 50;
        this.mDragging = false;
        this.ahQ = true;
        this.dVM = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.ahQ && VideoControllerView.this.dVF != null) {
                            int aVL = VideoControllerView.this.aVL();
                            if (VideoControllerView.this.dVJ != null) {
                                VideoControllerView.this.dVJ.nR(aVL);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dVE - (aVL % VideoControllerView.this.dVE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVN = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dVL != null) {
                    VideoControllerView.this.dVL.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dVM = (int) ((VideoControllerView.this.dVF.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dVG != null) {
                        VideoControllerView.this.dVG.setText(aq.stringForVideoTime(VideoControllerView.this.dVM));
                    }
                    if (VideoControllerView.this.dVK != null) {
                        VideoControllerView.this.dVK.aVM();
                    }
                    if (VideoControllerView.this.dVL != null) {
                        VideoControllerView.this.dVL.onProgressChanged(seekBar, VideoControllerView.this.dVM, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.dVF.seekTo(VideoControllerView.this.dVM);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dVL != null) {
                    VideoControllerView.this.dVL.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dVE = 50;
        this.mDragging = false;
        this.ahQ = true;
        this.dVM = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.ahQ && VideoControllerView.this.dVF != null) {
                            int aVL = VideoControllerView.this.aVL();
                            if (VideoControllerView.this.dVJ != null) {
                                VideoControllerView.this.dVJ.nR(aVL);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dVE - (aVL % VideoControllerView.this.dVE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVN = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dVL != null) {
                    VideoControllerView.this.dVL.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dVM = (int) ((VideoControllerView.this.dVF.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dVG != null) {
                        VideoControllerView.this.dVG.setText(aq.stringForVideoTime(VideoControllerView.this.dVM));
                    }
                    if (VideoControllerView.this.dVK != null) {
                        VideoControllerView.this.dVK.aVM();
                    }
                    if (VideoControllerView.this.dVL != null) {
                        VideoControllerView.this.dVL.onProgressChanged(seekBar, VideoControllerView.this.dVM, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.dVF.seekTo(VideoControllerView.this.dVM);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dVL != null) {
                    VideoControllerView.this.dVL.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dVE = 50;
        this.mDragging = false;
        this.ahQ = true;
        this.dVM = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.ahQ && VideoControllerView.this.dVF != null) {
                            int aVL = VideoControllerView.this.aVL();
                            if (VideoControllerView.this.dVJ != null) {
                                VideoControllerView.this.dVJ.nR(aVL);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dVE - (aVL % VideoControllerView.this.dVE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVN = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dVL != null) {
                    VideoControllerView.this.dVL.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dVM = (int) ((VideoControllerView.this.dVF.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.dVG != null) {
                        VideoControllerView.this.dVG.setText(aq.stringForVideoTime(VideoControllerView.this.dVM));
                    }
                    if (VideoControllerView.this.dVK != null) {
                        VideoControllerView.this.dVK.aVM();
                    }
                    if (VideoControllerView.this.dVL != null) {
                        VideoControllerView.this.dVL.onProgressChanged(seekBar, VideoControllerView.this.dVM, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.dVF.seekTo(VideoControllerView.this.dVM);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dVL != null) {
                    VideoControllerView.this.dVL.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ep = ep(context);
        addView(ep, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.dVG = (TextView) ep.findViewById(R.id.textview_cur_time);
        this.dVH = (TextView) ep.findViewById(R.id.textview_duration);
        this.dVI = (SeekBar) ep.findViewById(R.id.pb_video_controller_seekBar);
        this.dVI.setOnSeekBarChangeListener(this.dVN);
    }

    protected View ep(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dVF = mediaPlayerControl;
    }

    public void aV(int i, int i2) {
        this.mDuration = i2;
        this.ahQ = false;
        this.mHandler.removeMessages(1);
        this.dVI.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.dVG != null) {
            this.dVG.setText(aq.stringForVideoTime(i));
        }
        if (this.dVH != null) {
            this.dVH.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.dVF != null) {
            this.dVE = ((this.dVF.getDuration() / 200) / 50) * 50;
            if (this.dVE < 50) {
                this.dVE = 50;
            } else if (this.dVE > 500) {
                this.dVE = 500;
            }
            this.ahQ = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dVE - (this.dVF.getCurrentPosition() % this.dVE));
        }
    }

    public void ahA() {
        this.ahQ = false;
        this.mHandler.removeMessages(1);
        this.dVI.setProgress(0);
        if (this.dVG != null) {
            this.dVG.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aVL() {
        if (this.dVF == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.dVF.getCurrentPosition();
        int duration = this.dVF.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.dVI != null) {
            if (duration > 0) {
                this.dVI.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.dVF.getBufferPercentage();
        }
        if (this.dVG != null) {
            this.dVG.setText(aq.stringForVideoTime(currentPosition));
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
            this.dVF.seekTo(i);
            if (this.dVG != null) {
                this.dVG.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.dVF.isPlaying()) {
            this.dVI.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.dVM;
    }

    public int getCurProgress() {
        if (this.dVI != null) {
            return this.dVI.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.dVJ = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.dVK = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.dVL = onSeekBarChangeListener;
    }
}
