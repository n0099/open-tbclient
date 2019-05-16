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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean cGc;
    private int cVZ;
    private MediaController.MediaPlayerControl cWa;
    private TextView cWb;
    private TextView cWc;
    private SeekBar cWd;
    private b cWe;
    private a cWf;
    private SeekBar.OnSeekBarChangeListener cWg;
    private int cWh;
    private SeekBar.OnSeekBarChangeListener cWi;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes3.dex */
    public interface a {
        void aBO();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void mn(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.cVZ = 50;
        this.cGc = false;
        this.mShowing = true;
        this.cWh = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cGc && VideoControllerView.this.mShowing && VideoControllerView.this.cWa != null) {
                            int aBN = VideoControllerView.this.aBN();
                            if (VideoControllerView.this.cWe != null) {
                                VideoControllerView.this.cWe.mn(aBN);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cVZ - (aBN % VideoControllerView.this.cVZ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cWi = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cGc = true;
                if (VideoControllerView.this.cWg != null) {
                    VideoControllerView.this.cWg.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cWh = (int) ((VideoControllerView.this.cWa.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cWb != null) {
                        VideoControllerView.this.cWb.setText(ap.im(VideoControllerView.this.cWh));
                    }
                    if (VideoControllerView.this.cWf != null) {
                        VideoControllerView.this.cWf.aBO();
                    }
                    if (VideoControllerView.this.cWg != null) {
                        VideoControllerView.this.cWg.onProgressChanged(seekBar, VideoControllerView.this.cWh, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cWa.seekTo(VideoControllerView.this.cWh);
                VideoControllerView.this.cGc = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cWg != null) {
                    VideoControllerView.this.cWg.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVZ = 50;
        this.cGc = false;
        this.mShowing = true;
        this.cWh = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cGc && VideoControllerView.this.mShowing && VideoControllerView.this.cWa != null) {
                            int aBN = VideoControllerView.this.aBN();
                            if (VideoControllerView.this.cWe != null) {
                                VideoControllerView.this.cWe.mn(aBN);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cVZ - (aBN % VideoControllerView.this.cVZ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cWi = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cGc = true;
                if (VideoControllerView.this.cWg != null) {
                    VideoControllerView.this.cWg.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cWh = (int) ((VideoControllerView.this.cWa.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cWb != null) {
                        VideoControllerView.this.cWb.setText(ap.im(VideoControllerView.this.cWh));
                    }
                    if (VideoControllerView.this.cWf != null) {
                        VideoControllerView.this.cWf.aBO();
                    }
                    if (VideoControllerView.this.cWg != null) {
                        VideoControllerView.this.cWg.onProgressChanged(seekBar, VideoControllerView.this.cWh, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cWa.seekTo(VideoControllerView.this.cWh);
                VideoControllerView.this.cGc = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cWg != null) {
                    VideoControllerView.this.cWg.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVZ = 50;
        this.cGc = false;
        this.mShowing = true;
        this.cWh = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cGc && VideoControllerView.this.mShowing && VideoControllerView.this.cWa != null) {
                            int aBN = VideoControllerView.this.aBN();
                            if (VideoControllerView.this.cWe != null) {
                                VideoControllerView.this.cWe.mn(aBN);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cVZ - (aBN % VideoControllerView.this.cVZ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cWi = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cGc = true;
                if (VideoControllerView.this.cWg != null) {
                    VideoControllerView.this.cWg.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.cWh = (int) ((VideoControllerView.this.cWa.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.cWb != null) {
                        VideoControllerView.this.cWb.setText(ap.im(VideoControllerView.this.cWh));
                    }
                    if (VideoControllerView.this.cWf != null) {
                        VideoControllerView.this.cWf.aBO();
                    }
                    if (VideoControllerView.this.cWg != null) {
                        VideoControllerView.this.cWg.onProgressChanged(seekBar, VideoControllerView.this.cWh, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.cWa.seekTo(VideoControllerView.this.cWh);
                VideoControllerView.this.cGc = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cWg != null) {
                    VideoControllerView.this.cWg.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View cX = cX(context);
        addView(cX, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.cWb = (TextView) cX.findViewById(R.id.textview_cur_time);
        this.cWc = (TextView) cX.findViewById(R.id.textview_duration);
        this.cWd = (SeekBar) cX.findViewById(R.id.pb_video_controller_seekBar);
        this.cWd.setOnSeekBarChangeListener(this.cWi);
    }

    protected View cX(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cWa = mediaPlayerControl;
    }

    public void ax(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cWd.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.cWb != null) {
            this.cWb.setText(ap.im(i));
        }
        if (this.cWc != null) {
            this.cWc.setText(ap.im(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.cWa != null) {
            this.cVZ = ((this.cWa.getDuration() / 200) / 50) * 50;
            if (this.cVZ < 50) {
                this.cVZ = 50;
            } else if (this.cVZ > 500) {
                this.cVZ = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cVZ - (this.cWa.getCurrentPosition() % this.cVZ));
        }
    }

    public void aBM() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cWd.setProgress(0);
        if (this.cWb != null) {
            this.cWb.setText(ap.im(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aBN() {
        if (this.cWa == null || this.cGc) {
            return 0;
        }
        int currentPosition = this.cWa.getCurrentPosition();
        int duration = this.cWa.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.cWd != null) {
            if (duration > 0) {
                this.cWd.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cWa.getBufferPercentage();
        }
        if (this.cWb != null) {
            this.cWb.setText(ap.im(currentPosition));
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
            this.cWa.seekTo(i);
            if (this.cWb != null) {
                this.cWb.setText(ap.im(i));
            }
            showProgress();
        }
        if (!this.cWa.isPlaying()) {
            this.cWd.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.cWh;
    }

    public int getCurProgress() {
        if (this.cWd != null) {
            return this.cWd.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.cWe = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.cWf = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.cWg = onSeekBarChangeListener;
    }
}
