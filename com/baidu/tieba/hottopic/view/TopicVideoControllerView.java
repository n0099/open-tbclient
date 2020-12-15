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
    private int gaD;
    private MediaController.MediaPlayerControl gaE;
    private TextView gaF;
    private TextView gaG;
    private SeekBar gaH;
    private SeekBar.OnSeekBarChangeListener gaL;
    private StringBuilder khB;
    private Formatter khC;
    private boolean mDragging;
    private Handler mHandler;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.gaD = 50;
        this.mDragging = false;
        this.bbP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bbP && TopicVideoControllerView.this.gaE != null && TopicVideoControllerView.this.gaE.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.gaD - (TopicVideoControllerView.this.bMI() % TopicVideoControllerView.this.gaD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gaL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.gaE.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.gaE.seekTo((int) duration);
                    if (TopicVideoControllerView.this.gaF != null) {
                        TopicVideoControllerView.this.gaF.setText(TopicVideoControllerView.this.DB((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bMI();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaD = 50;
        this.mDragging = false;
        this.bbP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bbP && TopicVideoControllerView.this.gaE != null && TopicVideoControllerView.this.gaE.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.gaD - (TopicVideoControllerView.this.bMI() % TopicVideoControllerView.this.gaD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gaL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.gaE.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.gaE.seekTo((int) duration);
                    if (TopicVideoControllerView.this.gaF != null) {
                        TopicVideoControllerView.this.gaF.setText(TopicVideoControllerView.this.DB((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bMI();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gaD = 50;
        this.mDragging = false;
        this.bbP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bbP && TopicVideoControllerView.this.gaE != null && TopicVideoControllerView.this.gaE.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.gaD - (TopicVideoControllerView.this.bMI() % TopicVideoControllerView.this.gaD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gaL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.gaE.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.gaE.seekTo((int) duration);
                    if (TopicVideoControllerView.this.gaF != null) {
                        TopicVideoControllerView.this.gaF.setText(TopicVideoControllerView.this.DB((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bMI();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.gaF = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.gaG = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.gaH = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.gaH.setOnSeekBarChangeListener(this.gaL);
        this.khB = new StringBuilder();
        this.khC = new Formatter(this.khB, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gaE = mediaPlayerControl;
    }

    public void bB(int i, int i2) {
        this.bbP = false;
        this.mHandler.removeMessages(1);
        this.gaH.setProgress(0);
        if (this.gaF != null) {
            this.gaF.setText(DB(i));
        }
        if (this.gaG != null) {
            this.gaG.setText(DB(DA(i2)));
        }
    }

    public void showProgress() {
        if (this.gaE != null) {
            this.gaD = ((this.gaE.getDuration() / 200) / 50) * 50;
            if (this.gaD < 50) {
                this.gaD = 50;
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
            this.gaF.setText(DB(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bMI() {
        if (this.gaE == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.gaE.getCurrentPosition();
        int duration = this.gaE.getDuration();
        if (this.gaH != null && duration > 0) {
            this.gaH.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.gaG != null && duration > 0) {
            this.gaG.setText(DB(DA(duration)));
        }
        if (this.gaF != null) {
            this.gaF.setText(DB(currentPosition));
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
        this.khB.setLength(0);
        return i5 > 0 ? this.khC.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.khC.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.gaF, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.gaG, R.color.CAM_X0101, 1);
        this.gaH.setProgressDrawable(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.gaH.setThumb(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.gaH.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.gaH != null) {
            return this.gaH.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
