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
/* loaded from: classes6.dex */
public class VideoControllerView extends RelativeLayout {
    private int dVN;
    private MediaController.MediaPlayerControl dVO;
    private TextView dVP;
    private TextView dVQ;
    private SeekBar dVR;
    private b dVS;
    private a dVT;
    private SeekBar.OnSeekBarChangeListener dVU;
    private int dVV;
    private SeekBar.OnSeekBarChangeListener dVW;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes6.dex */
    public interface a {
        void aWf();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void nR(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.dVN = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dVV = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.dVO != null) {
                            int aWe = VideoControllerView.this.aWe();
                            if (VideoControllerView.this.dVS != null) {
                                VideoControllerView.this.dVS.nR(aWe);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dVN - (aWe % VideoControllerView.this.dVN));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVW = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dVU != null) {
                    VideoControllerView.this.dVU.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dVV = (int) ((VideoControllerView.this.dVO.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dVP != null) {
                        VideoControllerView.this.dVP.setText(aq.stringForVideoTime(VideoControllerView.this.dVV));
                    }
                    if (VideoControllerView.this.dVT != null) {
                        VideoControllerView.this.dVT.aWf();
                    }
                    if (VideoControllerView.this.dVU != null) {
                        VideoControllerView.this.dVU.onProgressChanged(seekBar, VideoControllerView.this.dVV, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.dVO.seekTo(VideoControllerView.this.dVV);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dVU != null) {
                    VideoControllerView.this.dVU.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dVN = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dVV = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.dVO != null) {
                            int aWe = VideoControllerView.this.aWe();
                            if (VideoControllerView.this.dVS != null) {
                                VideoControllerView.this.dVS.nR(aWe);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dVN - (aWe % VideoControllerView.this.dVN));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVW = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dVU != null) {
                    VideoControllerView.this.dVU.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dVV = (int) ((VideoControllerView.this.dVO.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dVP != null) {
                        VideoControllerView.this.dVP.setText(aq.stringForVideoTime(VideoControllerView.this.dVV));
                    }
                    if (VideoControllerView.this.dVT != null) {
                        VideoControllerView.this.dVT.aWf();
                    }
                    if (VideoControllerView.this.dVU != null) {
                        VideoControllerView.this.dVU.onProgressChanged(seekBar, VideoControllerView.this.dVV, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.dVO.seekTo(VideoControllerView.this.dVV);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dVU != null) {
                    VideoControllerView.this.dVU.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dVN = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dVV = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.dVO != null) {
                            int aWe = VideoControllerView.this.aWe();
                            if (VideoControllerView.this.dVS != null) {
                                VideoControllerView.this.dVS.nR(aWe);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dVN - (aWe % VideoControllerView.this.dVN));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVW = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dVU != null) {
                    VideoControllerView.this.dVU.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dVV = (int) ((VideoControllerView.this.dVO.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.dVP != null) {
                        VideoControllerView.this.dVP.setText(aq.stringForVideoTime(VideoControllerView.this.dVV));
                    }
                    if (VideoControllerView.this.dVT != null) {
                        VideoControllerView.this.dVT.aWf();
                    }
                    if (VideoControllerView.this.dVU != null) {
                        VideoControllerView.this.dVU.onProgressChanged(seekBar, VideoControllerView.this.dVV, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.dVO.seekTo(VideoControllerView.this.dVV);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dVU != null) {
                    VideoControllerView.this.dVU.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ep = ep(context);
        addView(ep, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.dVP = (TextView) ep.findViewById(R.id.textview_cur_time);
        this.dVQ = (TextView) ep.findViewById(R.id.textview_duration);
        this.dVR = (SeekBar) ep.findViewById(R.id.pb_video_controller_seekBar);
        this.dVR.setOnSeekBarChangeListener(this.dVW);
    }

    protected View ep(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dVO = mediaPlayerControl;
    }

    public void aZ(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.dVR.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.dVP != null) {
            this.dVP.setText(aq.stringForVideoTime(i));
        }
        if (this.dVQ != null) {
            this.dVQ.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.dVO != null) {
            this.dVN = ((this.dVO.getDuration() / 200) / 50) * 50;
            if (this.dVN < 50) {
                this.dVN = 50;
            } else if (this.dVN > 500) {
                this.dVN = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dVN - (this.dVO.getCurrentPosition() % this.dVN));
        }
    }

    public void ahT() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.dVR.setProgress(0);
        if (this.dVP != null) {
            this.dVP.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aWe() {
        if (this.dVO == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.dVO.getCurrentPosition();
        int duration = this.dVO.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.dVR != null) {
            if (duration > 0) {
                this.dVR.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.dVO.getBufferPercentage();
        }
        if (this.dVP != null) {
            this.dVP.setText(aq.stringForVideoTime(currentPosition));
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
            this.dVO.seekTo(i);
            if (this.dVP != null) {
                this.dVP.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.dVO.isPlaying()) {
            this.dVR.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.dVV;
    }

    public int getCurProgress() {
        if (this.dVR != null) {
            return this.dVR.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.dVS = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.dVT = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.dVU = onSeekBarChangeListener;
    }
}
