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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean baz;
    private int bnf;
    private MediaController.MediaPlayerControl bng;
    private TextView bnh;
    private TextView bni;
    private boolean bnj;
    private SeekBar bnk;
    private b bnl;
    private a bnm;
    private SeekBar.OnSeekBarChangeListener bnn;
    private int bno;
    private SeekBar.OnSeekBarChangeListener bnp;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface a {
        void Rb();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void gv(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.bnf = 50;
        this.baz = false;
        this.bnj = true;
        this.bno = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.baz && VideoControllerView.this.bnj && VideoControllerView.this.bng != null) {
                            int Ra = VideoControllerView.this.Ra();
                            if (VideoControllerView.this.bnl != null) {
                                VideoControllerView.this.bnl.gv(Ra);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bnf - (Ra % VideoControllerView.this.bnf));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bnp = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.baz = true;
                if (VideoControllerView.this.bnn != null) {
                    VideoControllerView.this.bnn.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bno = (int) ((VideoControllerView.this.bng.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bnh != null) {
                        VideoControllerView.this.bnh.setText(ap.cY(VideoControllerView.this.bno));
                    }
                    if (VideoControllerView.this.bnm != null) {
                        VideoControllerView.this.bnm.Rb();
                    }
                    if (VideoControllerView.this.bnn != null) {
                        VideoControllerView.this.bnn.onProgressChanged(seekBar, VideoControllerView.this.bno, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bng.seekTo(VideoControllerView.this.bno);
                VideoControllerView.this.baz = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bnn != null) {
                    VideoControllerView.this.bnn.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bnf = 50;
        this.baz = false;
        this.bnj = true;
        this.bno = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.baz && VideoControllerView.this.bnj && VideoControllerView.this.bng != null) {
                            int Ra = VideoControllerView.this.Ra();
                            if (VideoControllerView.this.bnl != null) {
                                VideoControllerView.this.bnl.gv(Ra);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bnf - (Ra % VideoControllerView.this.bnf));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bnp = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.baz = true;
                if (VideoControllerView.this.bnn != null) {
                    VideoControllerView.this.bnn.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bno = (int) ((VideoControllerView.this.bng.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bnh != null) {
                        VideoControllerView.this.bnh.setText(ap.cY(VideoControllerView.this.bno));
                    }
                    if (VideoControllerView.this.bnm != null) {
                        VideoControllerView.this.bnm.Rb();
                    }
                    if (VideoControllerView.this.bnn != null) {
                        VideoControllerView.this.bnn.onProgressChanged(seekBar, VideoControllerView.this.bno, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bng.seekTo(VideoControllerView.this.bno);
                VideoControllerView.this.baz = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bnn != null) {
                    VideoControllerView.this.bnn.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnf = 50;
        this.baz = false;
        this.bnj = true;
        this.bno = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.baz && VideoControllerView.this.bnj && VideoControllerView.this.bng != null) {
                            int Ra = VideoControllerView.this.Ra();
                            if (VideoControllerView.this.bnl != null) {
                                VideoControllerView.this.bnl.gv(Ra);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bnf - (Ra % VideoControllerView.this.bnf));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bnp = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ad.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.baz = true;
                if (VideoControllerView.this.bnn != null) {
                    VideoControllerView.this.bnn.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.bno = (int) ((VideoControllerView.this.bng.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.bnh != null) {
                        VideoControllerView.this.bnh.setText(ap.cY(VideoControllerView.this.bno));
                    }
                    if (VideoControllerView.this.bnm != null) {
                        VideoControllerView.this.bnm.Rb();
                    }
                    if (VideoControllerView.this.bnn != null) {
                        VideoControllerView.this.bnn.onProgressChanged(seekBar, VideoControllerView.this.bno, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bng.seekTo(VideoControllerView.this.bno);
                VideoControllerView.this.baz = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bnn != null) {
                    VideoControllerView.this.bnn.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bl = bl(context);
        addView(bl, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bnh = (TextView) bl.findViewById(d.g.textview_cur_time);
        this.bni = (TextView) bl.findViewById(d.g.textview_duration);
        this.bnk = (SeekBar) bl.findViewById(d.g.pb_video_controller_seekBar);
        this.bnk.setOnSeekBarChangeListener(this.bnp);
    }

    protected View bl(Context context) {
        return LayoutInflater.from(context).inflate(d.i.ad_video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bng = mediaPlayerControl;
    }

    public void R(int i, int i2) {
        this.mDuration = i2;
        this.bnj = false;
        this.mHandler.removeMessages(1);
        this.bnk.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bnh != null) {
            this.bnh.setText(ap.cY(i));
        }
        if (this.bni != null) {
            this.bni.setText(ap.cY(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bng != null) {
            this.bnf = ((this.bng.getDuration() / 200) / 50) * 50;
            if (this.bnf < 50) {
                this.bnf = 50;
            } else if (this.bnf > 500) {
                this.bnf = 500;
            }
            this.bnj = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bnf - (this.bng.getCurrentPosition() % this.bnf));
        }
    }

    public void QZ() {
        this.bnj = false;
        this.mHandler.removeMessages(1);
        this.bnk.setProgress(0);
        if (this.bnh != null) {
            this.bnh.setText(ap.cY(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ra() {
        if (this.bng == null || this.baz) {
            return 0;
        }
        int currentPosition = this.bng.getCurrentPosition();
        int duration = this.bng.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bnk != null) {
            if (duration > 0) {
                this.bnk.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bng.getBufferPercentage();
        }
        if (this.bnh != null) {
            this.bnh.setText(ap.cY(currentPosition));
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
            this.bng.seekTo(i);
            if (this.bnh != null) {
                this.bnh.setText(ap.cY(i));
            }
            showProgress();
        }
        if (!this.bng.isPlaying()) {
            this.bnk.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public int getSeekPosition() {
        return this.bno;
    }

    public int getCurProgress() {
        if (this.bnk != null) {
            return this.bnk.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.bnl = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.bnm = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bnn = onSeekBarChangeListener;
    }
}
