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
    private boolean cHE;
    private int cXE;
    private MediaController.MediaPlayerControl cXF;
    private TextView cXG;
    private TextView cXH;
    private SeekBar cXI;
    private b cXJ;
    private a cXK;
    private SeekBar.OnSeekBarChangeListener cXL;
    private int cXM;
    private SeekBar.OnSeekBarChangeListener cXN;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes3.dex */
    public interface a {
        void aDi();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void mv(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.cXE = 50;
        this.cHE = false;
        this.mShowing = true;
        this.cXM = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cHE && VideoControllerView.this.mShowing && VideoControllerView.this.cXF != null) {
                            int aDh = VideoControllerView.this.aDh();
                            if (VideoControllerView.this.cXJ != null) {
                                VideoControllerView.this.cXJ.mv(aDh);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cXE - (aDh % VideoControllerView.this.cXE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cXN = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cHE = true;
                if (VideoControllerView.this.cXL != null) {
                    VideoControllerView.this.cXL.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cXM = (int) ((VideoControllerView.this.cXF.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cXG != null) {
                        VideoControllerView.this.cXG.setText(aq.is(VideoControllerView.this.cXM));
                    }
                    if (VideoControllerView.this.cXK != null) {
                        VideoControllerView.this.cXK.aDi();
                    }
                    if (VideoControllerView.this.cXL != null) {
                        VideoControllerView.this.cXL.onProgressChanged(seekBar, VideoControllerView.this.cXM, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cXF.seekTo(VideoControllerView.this.cXM);
                VideoControllerView.this.cHE = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cXL != null) {
                    VideoControllerView.this.cXL.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cXE = 50;
        this.cHE = false;
        this.mShowing = true;
        this.cXM = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cHE && VideoControllerView.this.mShowing && VideoControllerView.this.cXF != null) {
                            int aDh = VideoControllerView.this.aDh();
                            if (VideoControllerView.this.cXJ != null) {
                                VideoControllerView.this.cXJ.mv(aDh);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cXE - (aDh % VideoControllerView.this.cXE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cXN = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cHE = true;
                if (VideoControllerView.this.cXL != null) {
                    VideoControllerView.this.cXL.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cXM = (int) ((VideoControllerView.this.cXF.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cXG != null) {
                        VideoControllerView.this.cXG.setText(aq.is(VideoControllerView.this.cXM));
                    }
                    if (VideoControllerView.this.cXK != null) {
                        VideoControllerView.this.cXK.aDi();
                    }
                    if (VideoControllerView.this.cXL != null) {
                        VideoControllerView.this.cXL.onProgressChanged(seekBar, VideoControllerView.this.cXM, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cXF.seekTo(VideoControllerView.this.cXM);
                VideoControllerView.this.cHE = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cXL != null) {
                    VideoControllerView.this.cXL.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cXE = 50;
        this.cHE = false;
        this.mShowing = true;
        this.cXM = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cHE && VideoControllerView.this.mShowing && VideoControllerView.this.cXF != null) {
                            int aDh = VideoControllerView.this.aDh();
                            if (VideoControllerView.this.cXJ != null) {
                                VideoControllerView.this.cXJ.mv(aDh);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cXE - (aDh % VideoControllerView.this.cXE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cXN = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cHE = true;
                if (VideoControllerView.this.cXL != null) {
                    VideoControllerView.this.cXL.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.cXM = (int) ((VideoControllerView.this.cXF.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.cXG != null) {
                        VideoControllerView.this.cXG.setText(aq.is(VideoControllerView.this.cXM));
                    }
                    if (VideoControllerView.this.cXK != null) {
                        VideoControllerView.this.cXK.aDi();
                    }
                    if (VideoControllerView.this.cXL != null) {
                        VideoControllerView.this.cXL.onProgressChanged(seekBar, VideoControllerView.this.cXM, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cXF.seekTo(VideoControllerView.this.cXM);
                VideoControllerView.this.cHE = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cXL != null) {
                    VideoControllerView.this.cXL.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View cY = cY(context);
        addView(cY, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.cXG = (TextView) cY.findViewById(R.id.textview_cur_time);
        this.cXH = (TextView) cY.findViewById(R.id.textview_duration);
        this.cXI = (SeekBar) cY.findViewById(R.id.pb_video_controller_seekBar);
        this.cXI.setOnSeekBarChangeListener(this.cXN);
    }

    protected View cY(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cXF = mediaPlayerControl;
    }

    public void aC(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cXI.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.cXG != null) {
            this.cXG.setText(aq.is(i));
        }
        if (this.cXH != null) {
            this.cXH.setText(aq.is(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.cXF != null) {
            this.cXE = ((this.cXF.getDuration() / 200) / 50) * 50;
            if (this.cXE < 50) {
                this.cXE = 50;
            } else if (this.cXE > 500) {
                this.cXE = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cXE - (this.cXF.getCurrentPosition() % this.cXE));
        }
    }

    public void aDg() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cXI.setProgress(0);
        if (this.cXG != null) {
            this.cXG.setText(aq.is(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDh() {
        if (this.cXF == null || this.cHE) {
            return 0;
        }
        int currentPosition = this.cXF.getCurrentPosition();
        int duration = this.cXF.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.cXI != null) {
            if (duration > 0) {
                this.cXI.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cXF.getBufferPercentage();
        }
        if (this.cXG != null) {
            this.cXG.setText(aq.is(currentPosition));
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
            this.cXF.seekTo(i);
            if (this.cXG != null) {
                this.cXG.setText(aq.is(i));
            }
            showProgress();
        }
        if (!this.cXF.isPlaying()) {
            this.cXI.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.cXM;
    }

    public int getCurProgress() {
        if (this.cXI != null) {
            return this.cXI.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.cXJ = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.cXK = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.cXL = onSeekBarChangeListener;
    }
}
