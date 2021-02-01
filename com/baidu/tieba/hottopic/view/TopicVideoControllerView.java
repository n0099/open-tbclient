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
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes8.dex */
public class TopicVideoControllerView extends RelativeLayout {
    private boolean bbQ;
    private int ghB;
    private MediaController.MediaPlayerControl ghC;
    private TextView ghD;
    private TextView ghE;
    private SeekBar ghF;
    private SeekBar.OnSeekBarChangeListener ghJ;
    private StringBuilder kyp;
    private Formatter kyq;
    private boolean mDragging;
    private Handler mHandler;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.ghB = 50;
        this.mDragging = false;
        this.bbQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bbQ && TopicVideoControllerView.this.ghC != null && TopicVideoControllerView.this.ghC.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.ghB - (TopicVideoControllerView.this.bLD() % TopicVideoControllerView.this.ghB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ghJ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.ghC.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.ghC.seekTo((int) duration);
                    if (TopicVideoControllerView.this.ghD != null) {
                        TopicVideoControllerView.this.ghD.setText(TopicVideoControllerView.this.CA((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bLD();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ghB = 50;
        this.mDragging = false;
        this.bbQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bbQ && TopicVideoControllerView.this.ghC != null && TopicVideoControllerView.this.ghC.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.ghB - (TopicVideoControllerView.this.bLD() % TopicVideoControllerView.this.ghB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ghJ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.ghC.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.ghC.seekTo((int) duration);
                    if (TopicVideoControllerView.this.ghD != null) {
                        TopicVideoControllerView.this.ghD.setText(TopicVideoControllerView.this.CA((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bLD();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ghB = 50;
        this.mDragging = false;
        this.bbQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bbQ && TopicVideoControllerView.this.ghC != null && TopicVideoControllerView.this.ghC.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.ghB - (TopicVideoControllerView.this.bLD() % TopicVideoControllerView.this.ghB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ghJ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.ghC.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.ghC.seekTo((int) duration);
                    if (TopicVideoControllerView.this.ghD != null) {
                        TopicVideoControllerView.this.ghD.setText(TopicVideoControllerView.this.CA((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bLD();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.ghD = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.ghE = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.ghF = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.ghF.setOnSeekBarChangeListener(this.ghJ);
        this.kyp = new StringBuilder();
        this.kyq = new Formatter(this.kyp, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.ghC = mediaPlayerControl;
    }

    public void bw(int i, int i2) {
        this.bbQ = false;
        this.mHandler.removeMessages(1);
        this.ghF.setProgress(0);
        if (this.ghD != null) {
            this.ghD.setText(CA(i));
        }
        if (this.ghE != null) {
            this.ghE.setText(CA(Cz(i2)));
        }
    }

    public void showProgress() {
        if (this.ghC != null) {
            this.ghB = ((this.ghC.getDuration() / 200) / 50) * 50;
            if (this.ghB < 50) {
                this.ghB = 50;
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
            this.ghD.setText(CA(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bLD() {
        if (this.ghC == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.ghC.getCurrentPosition();
        int duration = this.ghC.getDuration();
        if (this.ghF != null && duration > 0) {
            this.ghF.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.ghE != null && duration > 0) {
            this.ghE.setText(CA(Cz(duration)));
        }
        if (this.ghD != null) {
            this.ghD.setText(CA(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int Cz(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String CA(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        this.kyp.setLength(0);
        return i5 > 0 ? this.kyq.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.kyq.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.ghD, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.ghE, R.color.CAM_X0101, 1);
        this.ghF.setProgressDrawable(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.ghF.setThumb(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.ghF.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.ghF != null) {
            return this.ghF.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
