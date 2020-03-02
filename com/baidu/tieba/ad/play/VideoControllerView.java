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
    private int dZS;
    private MediaController.MediaPlayerControl dZT;
    private TextView dZU;
    private TextView dZV;
    private SeekBar dZW;
    private b dZX;
    private a dZY;
    private SeekBar.OnSeekBarChangeListener dZZ;
    private int eaa;
    private SeekBar.OnSeekBarChangeListener eab;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes8.dex */
    public interface a {
        void aYw();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void oi(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.dZS = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eaa = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.dZT != null) {
                            int aYv = VideoControllerView.this.aYv();
                            if (VideoControllerView.this.dZX != null) {
                                VideoControllerView.this.dZX.oi(aYv);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dZS - (aYv % VideoControllerView.this.dZS));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eab = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dZZ != null) {
                    VideoControllerView.this.dZZ.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eaa = (int) ((VideoControllerView.this.dZT.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dZU != null) {
                        VideoControllerView.this.dZU.setText(aq.stringForVideoTime(VideoControllerView.this.eaa));
                    }
                    if (VideoControllerView.this.dZY != null) {
                        VideoControllerView.this.dZY.aYw();
                    }
                    if (VideoControllerView.this.dZZ != null) {
                        VideoControllerView.this.dZZ.onProgressChanged(seekBar, VideoControllerView.this.eaa, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.dZT.seekTo(VideoControllerView.this.eaa);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dZZ != null) {
                    VideoControllerView.this.dZZ.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dZS = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eaa = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.dZT != null) {
                            int aYv = VideoControllerView.this.aYv();
                            if (VideoControllerView.this.dZX != null) {
                                VideoControllerView.this.dZX.oi(aYv);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dZS - (aYv % VideoControllerView.this.dZS));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eab = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dZZ != null) {
                    VideoControllerView.this.dZZ.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eaa = (int) ((VideoControllerView.this.dZT.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dZU != null) {
                        VideoControllerView.this.dZU.setText(aq.stringForVideoTime(VideoControllerView.this.eaa));
                    }
                    if (VideoControllerView.this.dZY != null) {
                        VideoControllerView.this.dZY.aYw();
                    }
                    if (VideoControllerView.this.dZZ != null) {
                        VideoControllerView.this.dZZ.onProgressChanged(seekBar, VideoControllerView.this.eaa, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.dZT.seekTo(VideoControllerView.this.eaa);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dZZ != null) {
                    VideoControllerView.this.dZZ.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dZS = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eaa = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.dZT != null) {
                            int aYv = VideoControllerView.this.aYv();
                            if (VideoControllerView.this.dZX != null) {
                                VideoControllerView.this.dZX.oi(aYv);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dZS - (aYv % VideoControllerView.this.dZS));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eab = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dZZ != null) {
                    VideoControllerView.this.dZZ.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eaa = (int) ((VideoControllerView.this.dZT.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.dZU != null) {
                        VideoControllerView.this.dZU.setText(aq.stringForVideoTime(VideoControllerView.this.eaa));
                    }
                    if (VideoControllerView.this.dZY != null) {
                        VideoControllerView.this.dZY.aYw();
                    }
                    if (VideoControllerView.this.dZZ != null) {
                        VideoControllerView.this.dZZ.onProgressChanged(seekBar, VideoControllerView.this.eaa, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.dZT.seekTo(VideoControllerView.this.eaa);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dZZ != null) {
                    VideoControllerView.this.dZZ.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View es = es(context);
        addView(es, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.dZU = (TextView) es.findViewById(R.id.textview_cur_time);
        this.dZV = (TextView) es.findViewById(R.id.textview_duration);
        this.dZW = (SeekBar) es.findViewById(R.id.pb_video_controller_seekBar);
        this.dZW.setOnSeekBarChangeListener(this.eab);
    }

    protected View es(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dZT = mediaPlayerControl;
    }

    public void aZ(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.dZW.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.dZU != null) {
            this.dZU.setText(aq.stringForVideoTime(i));
        }
        if (this.dZV != null) {
            this.dZV.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.dZT != null) {
            this.dZS = ((this.dZT.getDuration() / 200) / 50) * 50;
            if (this.dZS < 50) {
                this.dZS = 50;
            } else if (this.dZS > 500) {
                this.dZS = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dZS - (this.dZT.getCurrentPosition() % this.dZS));
        }
    }

    public void akj() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.dZW.setProgress(0);
        if (this.dZU != null) {
            this.dZU.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aYv() {
        if (this.dZT == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.dZT.getCurrentPosition();
        int duration = this.dZT.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.dZW != null) {
            if (duration > 0) {
                this.dZW.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.dZT.getBufferPercentage();
        }
        if (this.dZU != null) {
            this.dZU.setText(aq.stringForVideoTime(currentPosition));
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
            this.dZT.seekTo(i);
            if (this.dZU != null) {
                this.dZU.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.dZT.isPlaying()) {
            this.dZW.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.eaa;
    }

    public int getCurProgress() {
        if (this.dZW != null) {
            return this.dZW.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.dZX = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.dZY = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.dZZ = onSeekBarChangeListener;
    }
}
