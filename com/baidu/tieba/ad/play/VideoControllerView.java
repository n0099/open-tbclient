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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean bbQ;
    private int eBf;
    private int ghB;
    private MediaController.MediaPlayerControl ghC;
    private TextView ghD;
    private TextView ghE;
    private SeekBar ghF;
    private b ghG;
    private a ghH;
    private SeekBar.OnSeekBarChangeListener ghI;
    private SeekBar.OnSeekBarChangeListener ghJ;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void bLE();
    }

    /* loaded from: classes.dex */
    public interface b {
        void tb(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.ghB = 50;
        this.mDragging = false;
        this.bbQ = true;
        this.eBf = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bbQ && VideoControllerView.this.ghC != null) {
                            int bLD = VideoControllerView.this.bLD();
                            if (VideoControllerView.this.ghG != null) {
                                VideoControllerView.this.ghG.tb(bLD);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.ghB - (bLD % VideoControllerView.this.ghB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ghJ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.ghI != null) {
                    VideoControllerView.this.ghI.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eBf = (int) ((VideoControllerView.this.ghC.getDuration() * i) / 10000);
                    if (VideoControllerView.this.ghD != null) {
                        VideoControllerView.this.ghD.setText(au.stringForVideoTime(VideoControllerView.this.eBf));
                    }
                    if (VideoControllerView.this.ghH != null) {
                        VideoControllerView.this.ghH.bLE();
                    }
                    if (VideoControllerView.this.ghI != null) {
                        VideoControllerView.this.ghI.onProgressChanged(seekBar, VideoControllerView.this.eBf, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.ghC.seekTo(VideoControllerView.this.eBf);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.ghI != null) {
                    VideoControllerView.this.ghI.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ghB = 50;
        this.mDragging = false;
        this.bbQ = true;
        this.eBf = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bbQ && VideoControllerView.this.ghC != null) {
                            int bLD = VideoControllerView.this.bLD();
                            if (VideoControllerView.this.ghG != null) {
                                VideoControllerView.this.ghG.tb(bLD);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.ghB - (bLD % VideoControllerView.this.ghB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ghJ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.ghI != null) {
                    VideoControllerView.this.ghI.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eBf = (int) ((VideoControllerView.this.ghC.getDuration() * i) / 10000);
                    if (VideoControllerView.this.ghD != null) {
                        VideoControllerView.this.ghD.setText(au.stringForVideoTime(VideoControllerView.this.eBf));
                    }
                    if (VideoControllerView.this.ghH != null) {
                        VideoControllerView.this.ghH.bLE();
                    }
                    if (VideoControllerView.this.ghI != null) {
                        VideoControllerView.this.ghI.onProgressChanged(seekBar, VideoControllerView.this.eBf, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.ghC.seekTo(VideoControllerView.this.eBf);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.ghI != null) {
                    VideoControllerView.this.ghI.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ghB = 50;
        this.mDragging = false;
        this.bbQ = true;
        this.eBf = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bbQ && VideoControllerView.this.ghC != null) {
                            int bLD = VideoControllerView.this.bLD();
                            if (VideoControllerView.this.ghG != null) {
                                VideoControllerView.this.ghG.tb(bLD);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.ghB - (bLD % VideoControllerView.this.ghB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ghJ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.ghI != null) {
                    VideoControllerView.this.ghI.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eBf = (int) ((VideoControllerView.this.ghC.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.ghD != null) {
                        VideoControllerView.this.ghD.setText(au.stringForVideoTime(VideoControllerView.this.eBf));
                    }
                    if (VideoControllerView.this.ghH != null) {
                        VideoControllerView.this.ghH.bLE();
                    }
                    if (VideoControllerView.this.ghI != null) {
                        VideoControllerView.this.ghI.onProgressChanged(seekBar, VideoControllerView.this.eBf, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.ghC.seekTo(VideoControllerView.this.eBf);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.ghI != null) {
                    VideoControllerView.this.ghI.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View fE = fE(context);
        addView(fE, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.ghD = (TextView) fE.findViewById(R.id.textview_cur_time);
        this.ghE = (TextView) fE.findViewById(R.id.textview_duration);
        this.ghF = (SeekBar) fE.findViewById(R.id.pb_video_controller_seekBar);
        this.ghF.setOnSeekBarChangeListener(this.ghJ);
    }

    protected View fE(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.ghC = mediaPlayerControl;
    }

    public void bw(int i, int i2) {
        this.mDuration = i2;
        this.bbQ = false;
        this.mHandler.removeMessages(1);
        this.ghF.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.ghD != null) {
            this.ghD.setText(au.stringForVideoTime(i));
        }
        if (this.ghE != null) {
            this.ghE.setText(au.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.ghC != null) {
            this.ghB = ((this.ghC.getDuration() / 200) / 50) * 50;
            if (this.ghB < 50) {
                this.ghB = 50;
            } else if (this.ghB > 500) {
                this.ghB = 500;
            }
            this.bbQ = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.ghB - (this.ghC.getCurrentPosition() % this.ghB));
        }
    }

    public void aRo() {
        this.bbQ = false;
        this.mHandler.removeMessages(1);
        this.ghF.setProgress(0);
        if (this.ghD != null) {
            this.ghD.setText(au.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bLD() {
        if (this.ghC == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.ghC.getCurrentPosition();
        int duration = this.ghC.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.ghF != null) {
            if (duration > 0) {
                this.ghF.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.ghC.getBufferPercentage();
        }
        if (this.ghD != null) {
            this.ghD.setText(au.stringForVideoTime(currentPosition));
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
            this.ghC.seekTo(i);
            if (this.ghD != null) {
                this.ghD.setText(au.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.ghC.isPlaying()) {
            this.ghF.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.eBf;
    }

    public int getCurProgress() {
        if (this.ghF != null) {
            return this.ghF.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.ghG = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.ghH = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.ghI = onSeekBarChangeListener;
    }
}
