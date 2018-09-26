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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean bdX;
    private int btD;
    private MediaController.MediaPlayerControl btE;
    private TextView btF;
    private TextView btG;
    private SeekBar btH;
    private b btI;
    private a btJ;
    private SeekBar.OnSeekBarChangeListener btK;
    private int btL;
    private SeekBar.OnSeekBarChangeListener btM;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes3.dex */
    public interface a {
        void Tb();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void gZ(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.btD = 50;
        this.bdX = false;
        this.mShowing = true;
        this.btL = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bdX && VideoControllerView.this.mShowing && VideoControllerView.this.btE != null) {
                            int Ta = VideoControllerView.this.Ta();
                            if (VideoControllerView.this.btI != null) {
                                VideoControllerView.this.btI.gZ(Ta);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.btD - (Ta % VideoControllerView.this.btD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.btM = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bdX = true;
                if (VideoControllerView.this.btK != null) {
                    VideoControllerView.this.btK.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.btL = (int) ((VideoControllerView.this.btE.getDuration() * i) / 10000);
                    if (VideoControllerView.this.btF != null) {
                        VideoControllerView.this.btF.setText(ao.dj(VideoControllerView.this.btL));
                    }
                    if (VideoControllerView.this.btJ != null) {
                        VideoControllerView.this.btJ.Tb();
                    }
                    if (VideoControllerView.this.btK != null) {
                        VideoControllerView.this.btK.onProgressChanged(seekBar, VideoControllerView.this.btL, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.btE.seekTo(VideoControllerView.this.btL);
                VideoControllerView.this.bdX = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.btK != null) {
                    VideoControllerView.this.btK.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btD = 50;
        this.bdX = false;
        this.mShowing = true;
        this.btL = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bdX && VideoControllerView.this.mShowing && VideoControllerView.this.btE != null) {
                            int Ta = VideoControllerView.this.Ta();
                            if (VideoControllerView.this.btI != null) {
                                VideoControllerView.this.btI.gZ(Ta);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.btD - (Ta % VideoControllerView.this.btD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.btM = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bdX = true;
                if (VideoControllerView.this.btK != null) {
                    VideoControllerView.this.btK.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.btL = (int) ((VideoControllerView.this.btE.getDuration() * i) / 10000);
                    if (VideoControllerView.this.btF != null) {
                        VideoControllerView.this.btF.setText(ao.dj(VideoControllerView.this.btL));
                    }
                    if (VideoControllerView.this.btJ != null) {
                        VideoControllerView.this.btJ.Tb();
                    }
                    if (VideoControllerView.this.btK != null) {
                        VideoControllerView.this.btK.onProgressChanged(seekBar, VideoControllerView.this.btL, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.btE.seekTo(VideoControllerView.this.btL);
                VideoControllerView.this.bdX = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.btK != null) {
                    VideoControllerView.this.btK.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btD = 50;
        this.bdX = false;
        this.mShowing = true;
        this.btL = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bdX && VideoControllerView.this.mShowing && VideoControllerView.this.btE != null) {
                            int Ta = VideoControllerView.this.Ta();
                            if (VideoControllerView.this.btI != null) {
                                VideoControllerView.this.btI.gZ(Ta);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.btD - (Ta % VideoControllerView.this.btD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.btM = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bdX = true;
                if (VideoControllerView.this.btK != null) {
                    VideoControllerView.this.btK.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.btL = (int) ((VideoControllerView.this.btE.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.btF != null) {
                        VideoControllerView.this.btF.setText(ao.dj(VideoControllerView.this.btL));
                    }
                    if (VideoControllerView.this.btJ != null) {
                        VideoControllerView.this.btJ.Tb();
                    }
                    if (VideoControllerView.this.btK != null) {
                        VideoControllerView.this.btK.onProgressChanged(seekBar, VideoControllerView.this.btL, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.btE.seekTo(VideoControllerView.this.btL);
                VideoControllerView.this.bdX = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.btK != null) {
                    VideoControllerView.this.btK.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bS = bS(context);
        addView(bS, -1, (int) context.getResources().getDimension(e.C0141e.ds80));
        this.btF = (TextView) bS.findViewById(e.g.textview_cur_time);
        this.btG = (TextView) bS.findViewById(e.g.textview_duration);
        this.btH = (SeekBar) bS.findViewById(e.g.pb_video_controller_seekBar);
        this.btH.setOnSeekBarChangeListener(this.btM);
    }

    protected View bS(Context context) {
        return LayoutInflater.from(context).inflate(e.h.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.btE = mediaPlayerControl;
    }

    public void X(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.btH.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.btF != null) {
            this.btF.setText(ao.dj(i));
        }
        if (this.btG != null) {
            this.btG.setText(ao.dj(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.btE != null) {
            this.btD = ((this.btE.getDuration() / 200) / 50) * 50;
            if (this.btD < 50) {
                this.btD = 50;
            } else if (this.btD > 500) {
                this.btD = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.btD - (this.btE.getCurrentPosition() % this.btD));
        }
    }

    public void SZ() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.btH.setProgress(0);
        if (this.btF != null) {
            this.btF.setText(ao.dj(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ta() {
        if (this.btE == null || this.bdX) {
            return 0;
        }
        int currentPosition = this.btE.getCurrentPosition();
        int duration = this.btE.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.btH != null) {
            if (duration > 0) {
                this.btH.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.btE.getBufferPercentage();
        }
        if (this.btF != null) {
            this.btF.setText(ao.dj(currentPosition));
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
            this.btE.seekTo(i);
            if (this.btF != null) {
                this.btF.setText(ao.dj(i));
            }
            showProgress();
        }
        if (!this.btE.isPlaying()) {
            this.btH.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.btL;
    }

    public int getCurProgress() {
        if (this.btH != null) {
            return this.btH.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.btI = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.btJ = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.btK = onSeekBarChangeListener;
    }
}
