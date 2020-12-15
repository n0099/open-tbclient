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
/* loaded from: classes21.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean bbP;
    private int eud;
    private int gaD;
    private MediaController.MediaPlayerControl gaE;
    private TextView gaF;
    private TextView gaG;
    private SeekBar gaH;
    private b gaI;
    private a gaJ;
    private SeekBar.OnSeekBarChangeListener gaK;
    private SeekBar.OnSeekBarChangeListener gaL;
    private Context mContext;
    private boolean mDragging;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes21.dex */
    public interface a {
        void bMJ();
    }

    /* loaded from: classes21.dex */
    public interface b {
        void ur(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.gaD = 50;
        this.mDragging = false;
        this.bbP = true;
        this.eud = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bbP && VideoControllerView.this.gaE != null) {
                            int bMI = VideoControllerView.this.bMI();
                            if (VideoControllerView.this.gaI != null) {
                                VideoControllerView.this.gaI.ur(bMI);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gaD - (bMI % VideoControllerView.this.gaD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gaL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gaK != null) {
                    VideoControllerView.this.gaK.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eud = (int) ((VideoControllerView.this.gaE.getDuration() * i) / 10000);
                    if (VideoControllerView.this.gaF != null) {
                        VideoControllerView.this.gaF.setText(au.stringForVideoTime(VideoControllerView.this.eud));
                    }
                    if (VideoControllerView.this.gaJ != null) {
                        VideoControllerView.this.gaJ.bMJ();
                    }
                    if (VideoControllerView.this.gaK != null) {
                        VideoControllerView.this.gaK.onProgressChanged(seekBar, VideoControllerView.this.eud, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.gaE.seekTo(VideoControllerView.this.eud);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gaK != null) {
                    VideoControllerView.this.gaK.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaD = 50;
        this.mDragging = false;
        this.bbP = true;
        this.eud = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bbP && VideoControllerView.this.gaE != null) {
                            int bMI = VideoControllerView.this.bMI();
                            if (VideoControllerView.this.gaI != null) {
                                VideoControllerView.this.gaI.ur(bMI);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gaD - (bMI % VideoControllerView.this.gaD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gaL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gaK != null) {
                    VideoControllerView.this.gaK.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eud = (int) ((VideoControllerView.this.gaE.getDuration() * i) / 10000);
                    if (VideoControllerView.this.gaF != null) {
                        VideoControllerView.this.gaF.setText(au.stringForVideoTime(VideoControllerView.this.eud));
                    }
                    if (VideoControllerView.this.gaJ != null) {
                        VideoControllerView.this.gaJ.bMJ();
                    }
                    if (VideoControllerView.this.gaK != null) {
                        VideoControllerView.this.gaK.onProgressChanged(seekBar, VideoControllerView.this.eud, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.gaE.seekTo(VideoControllerView.this.eud);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gaK != null) {
                    VideoControllerView.this.gaK.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gaD = 50;
        this.mDragging = false;
        this.bbP = true;
        this.eud = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bbP && VideoControllerView.this.gaE != null) {
                            int bMI = VideoControllerView.this.bMI();
                            if (VideoControllerView.this.gaI != null) {
                                VideoControllerView.this.gaI.ur(bMI);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gaD - (bMI % VideoControllerView.this.gaD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gaL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gaK != null) {
                    VideoControllerView.this.gaK.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eud = (int) ((VideoControllerView.this.gaE.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.gaF != null) {
                        VideoControllerView.this.gaF.setText(au.stringForVideoTime(VideoControllerView.this.eud));
                    }
                    if (VideoControllerView.this.gaJ != null) {
                        VideoControllerView.this.gaJ.bMJ();
                    }
                    if (VideoControllerView.this.gaK != null) {
                        VideoControllerView.this.gaK.onProgressChanged(seekBar, VideoControllerView.this.eud, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.gaE.seekTo(VideoControllerView.this.eud);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gaK != null) {
                    VideoControllerView.this.gaK.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View fn = fn(context);
        addView(fn, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.gaF = (TextView) fn.findViewById(R.id.textview_cur_time);
        this.gaG = (TextView) fn.findViewById(R.id.textview_duration);
        this.gaH = (SeekBar) fn.findViewById(R.id.pb_video_controller_seekBar);
        this.gaH.setOnSeekBarChangeListener(this.gaL);
    }

    protected View fn(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gaE = mediaPlayerControl;
    }

    public void bB(int i, int i2) {
        this.mDuration = i2;
        this.bbP = false;
        this.mHandler.removeMessages(1);
        this.gaH.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.gaF != null) {
            this.gaF.setText(au.stringForVideoTime(i));
        }
        if (this.gaG != null) {
            this.gaG.setText(au.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.gaE != null) {
            this.gaD = ((this.gaE.getDuration() / 200) / 50) * 50;
            if (this.gaD < 50) {
                this.gaD = 50;
            } else if (this.gaD > 500) {
                this.gaD = 500;
            }
            this.bbP = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gaD - (this.gaE.getCurrentPosition() % this.gaD));
        }
    }

    public void aSx() {
        this.bbP = false;
        this.mHandler.removeMessages(1);
        this.gaH.setProgress(0);
        if (this.gaF != null) {
            this.gaF.setText(au.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bMI() {
        if (this.gaE == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.gaE.getCurrentPosition();
        int duration = this.gaE.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.gaH != null) {
            if (duration > 0) {
                this.gaH.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.gaE.getBufferPercentage();
        }
        if (this.gaF != null) {
            this.gaF.setText(au.stringForVideoTime(currentPosition));
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
            this.gaE.seekTo(i);
            if (this.gaF != null) {
                this.gaF.setText(au.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.gaE.isPlaying()) {
            this.gaH.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.eud;
    }

    public int getCurProgress() {
        if (this.gaH != null) {
            return this.gaH.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.gaI = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.gaJ = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gaK = onSeekBarChangeListener;
    }
}
