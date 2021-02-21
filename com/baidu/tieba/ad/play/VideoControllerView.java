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
    private int ghP;
    private MediaController.MediaPlayerControl ghQ;
    private TextView ghR;
    private TextView ghS;
    private SeekBar ghT;
    private b ghU;
    private a ghV;
    private SeekBar.OnSeekBarChangeListener ghW;
    private SeekBar.OnSeekBarChangeListener ghX;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void bLL();
    }

    /* loaded from: classes.dex */
    public interface b {
        void tb(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.ghP = 50;
        this.mDragging = false;
        this.bbQ = true;
        this.eBf = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bbQ && VideoControllerView.this.ghQ != null) {
                            int bLK = VideoControllerView.this.bLK();
                            if (VideoControllerView.this.ghU != null) {
                                VideoControllerView.this.ghU.tb(bLK);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.ghP - (bLK % VideoControllerView.this.ghP));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ghX = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.ghW != null) {
                    VideoControllerView.this.ghW.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eBf = (int) ((VideoControllerView.this.ghQ.getDuration() * i) / 10000);
                    if (VideoControllerView.this.ghR != null) {
                        VideoControllerView.this.ghR.setText(au.stringForVideoTime(VideoControllerView.this.eBf));
                    }
                    if (VideoControllerView.this.ghV != null) {
                        VideoControllerView.this.ghV.bLL();
                    }
                    if (VideoControllerView.this.ghW != null) {
                        VideoControllerView.this.ghW.onProgressChanged(seekBar, VideoControllerView.this.eBf, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.ghQ.seekTo(VideoControllerView.this.eBf);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.ghW != null) {
                    VideoControllerView.this.ghW.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ghP = 50;
        this.mDragging = false;
        this.bbQ = true;
        this.eBf = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bbQ && VideoControllerView.this.ghQ != null) {
                            int bLK = VideoControllerView.this.bLK();
                            if (VideoControllerView.this.ghU != null) {
                                VideoControllerView.this.ghU.tb(bLK);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.ghP - (bLK % VideoControllerView.this.ghP));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ghX = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.ghW != null) {
                    VideoControllerView.this.ghW.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eBf = (int) ((VideoControllerView.this.ghQ.getDuration() * i) / 10000);
                    if (VideoControllerView.this.ghR != null) {
                        VideoControllerView.this.ghR.setText(au.stringForVideoTime(VideoControllerView.this.eBf));
                    }
                    if (VideoControllerView.this.ghV != null) {
                        VideoControllerView.this.ghV.bLL();
                    }
                    if (VideoControllerView.this.ghW != null) {
                        VideoControllerView.this.ghW.onProgressChanged(seekBar, VideoControllerView.this.eBf, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.ghQ.seekTo(VideoControllerView.this.eBf);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.ghW != null) {
                    VideoControllerView.this.ghW.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ghP = 50;
        this.mDragging = false;
        this.bbQ = true;
        this.eBf = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bbQ && VideoControllerView.this.ghQ != null) {
                            int bLK = VideoControllerView.this.bLK();
                            if (VideoControllerView.this.ghU != null) {
                                VideoControllerView.this.ghU.tb(bLK);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.ghP - (bLK % VideoControllerView.this.ghP));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ghX = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.ghW != null) {
                    VideoControllerView.this.ghW.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eBf = (int) ((VideoControllerView.this.ghQ.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.ghR != null) {
                        VideoControllerView.this.ghR.setText(au.stringForVideoTime(VideoControllerView.this.eBf));
                    }
                    if (VideoControllerView.this.ghV != null) {
                        VideoControllerView.this.ghV.bLL();
                    }
                    if (VideoControllerView.this.ghW != null) {
                        VideoControllerView.this.ghW.onProgressChanged(seekBar, VideoControllerView.this.eBf, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.ghQ.seekTo(VideoControllerView.this.eBf);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.ghW != null) {
                    VideoControllerView.this.ghW.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View fE = fE(context);
        addView(fE, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.ghR = (TextView) fE.findViewById(R.id.textview_cur_time);
        this.ghS = (TextView) fE.findViewById(R.id.textview_duration);
        this.ghT = (SeekBar) fE.findViewById(R.id.pb_video_controller_seekBar);
        this.ghT.setOnSeekBarChangeListener(this.ghX);
    }

    protected View fE(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.ghQ = mediaPlayerControl;
    }

    public void bx(int i, int i2) {
        this.mDuration = i2;
        this.bbQ = false;
        this.mHandler.removeMessages(1);
        this.ghT.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.ghR != null) {
            this.ghR.setText(au.stringForVideoTime(i));
        }
        if (this.ghS != null) {
            this.ghS.setText(au.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.ghQ != null) {
            this.ghP = ((this.ghQ.getDuration() / 200) / 50) * 50;
            if (this.ghP < 50) {
                this.ghP = 50;
            } else if (this.ghP > 500) {
                this.ghP = 500;
            }
            this.bbQ = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.ghP - (this.ghQ.getCurrentPosition() % this.ghP));
        }
    }

    public void aRo() {
        this.bbQ = false;
        this.mHandler.removeMessages(1);
        this.ghT.setProgress(0);
        if (this.ghR != null) {
            this.ghR.setText(au.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bLK() {
        if (this.ghQ == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.ghQ.getCurrentPosition();
        int duration = this.ghQ.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.ghT != null) {
            if (duration > 0) {
                this.ghT.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.ghQ.getBufferPercentage();
        }
        if (this.ghR != null) {
            this.ghR.setText(au.stringForVideoTime(currentPosition));
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
            this.ghQ.seekTo(i);
            if (this.ghR != null) {
                this.ghR.setText(au.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.ghQ.isPlaying()) {
            this.ghT.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.eBf;
    }

    public int getCurProgress() {
        if (this.ghT != null) {
            return this.ghT.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.ghU = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.ghV = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.ghW = onSeekBarChangeListener;
    }
}
