package com.baidu.tieba.hottopic.view;

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
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes21.dex */
public class TopicVideoControllerView extends RelativeLayout {
    private boolean bbP;
    private int gaB;
    private MediaController.MediaPlayerControl gaC;
    private TextView gaD;
    private TextView gaE;
    private SeekBar gaF;
    private SeekBar.OnSeekBarChangeListener gaJ;
    private Formatter khA;
    private StringBuilder khz;
    private boolean mDragging;
    private Handler mHandler;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.gaB = 50;
        this.mDragging = false;
        this.bbP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bbP && TopicVideoControllerView.this.gaC != null && TopicVideoControllerView.this.gaC.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.gaB - (TopicVideoControllerView.this.bMH() % TopicVideoControllerView.this.gaB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gaJ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.gaC.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.gaC.seekTo((int) duration);
                    if (TopicVideoControllerView.this.gaD != null) {
                        TopicVideoControllerView.this.gaD.setText(TopicVideoControllerView.this.DB((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bMH();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaB = 50;
        this.mDragging = false;
        this.bbP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bbP && TopicVideoControllerView.this.gaC != null && TopicVideoControllerView.this.gaC.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.gaB - (TopicVideoControllerView.this.bMH() % TopicVideoControllerView.this.gaB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gaJ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.gaC.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.gaC.seekTo((int) duration);
                    if (TopicVideoControllerView.this.gaD != null) {
                        TopicVideoControllerView.this.gaD.setText(TopicVideoControllerView.this.DB((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bMH();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gaB = 50;
        this.mDragging = false;
        this.bbP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bbP && TopicVideoControllerView.this.gaC != null && TopicVideoControllerView.this.gaC.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.gaB - (TopicVideoControllerView.this.bMH() % TopicVideoControllerView.this.gaB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gaJ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.gaC.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.gaC.seekTo((int) duration);
                    if (TopicVideoControllerView.this.gaD != null) {
                        TopicVideoControllerView.this.gaD.setText(TopicVideoControllerView.this.DB((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bMH();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.gaD = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.gaE = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.gaF = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.gaF.setOnSeekBarChangeListener(this.gaJ);
        this.khz = new StringBuilder();
        this.khA = new Formatter(this.khz, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gaC = mediaPlayerControl;
    }

    public void bB(int i, int i2) {
        this.bbP = false;
        this.mHandler.removeMessages(1);
        this.gaF.setProgress(0);
        if (this.gaD != null) {
            this.gaD.setText(DB(i));
        }
        if (this.gaE != null) {
            this.gaE.setText(DB(DA(i2)));
        }
    }

    public void showProgress() {
        if (this.gaC != null) {
            this.gaB = ((this.gaC.getDuration() / 200) / 50) * 50;
            if (this.gaB < 50) {
                this.gaB = 50;
            }
            this.bbP = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gaB - (this.gaC.getCurrentPosition() % this.gaB));
        }
    }

    public void aSx() {
        this.bbP = false;
        this.mHandler.removeMessages(1);
        this.gaF.setProgress(0);
        if (this.gaD != null) {
            this.gaD.setText(DB(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bMH() {
        if (this.gaC == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.gaC.getCurrentPosition();
        int duration = this.gaC.getDuration();
        if (this.gaF != null && duration > 0) {
            this.gaF.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.gaE != null && duration > 0) {
            this.gaE.setText(DB(DA(duration)));
        }
        if (this.gaD != null) {
            this.gaD.setText(DB(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int DA(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String DB(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.khz.setLength(0);
        return i5 > 0 ? this.khA.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.khA.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.gaD, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.gaE, R.color.CAM_X0101, 1);
        this.gaF.setProgressDrawable(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.gaF.setThumb(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.gaF.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.gaF != null) {
            return this.gaF.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
