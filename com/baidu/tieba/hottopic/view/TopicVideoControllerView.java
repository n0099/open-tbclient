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
    private int ghP;
    private MediaController.MediaPlayerControl ghQ;
    private TextView ghR;
    private TextView ghS;
    private SeekBar ghT;
    private SeekBar.OnSeekBarChangeListener ghX;
    private StringBuilder kyD;
    private Formatter kyE;
    private boolean mDragging;
    private Handler mHandler;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.ghP = 50;
        this.mDragging = false;
        this.bbQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bbQ && TopicVideoControllerView.this.ghQ != null && TopicVideoControllerView.this.ghQ.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.ghP - (TopicVideoControllerView.this.bLK() % TopicVideoControllerView.this.ghP));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ghX = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.ghQ.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.ghQ.seekTo((int) duration);
                    if (TopicVideoControllerView.this.ghR != null) {
                        TopicVideoControllerView.this.ghR.setText(TopicVideoControllerView.this.CA((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bLK();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ghP = 50;
        this.mDragging = false;
        this.bbQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bbQ && TopicVideoControllerView.this.ghQ != null && TopicVideoControllerView.this.ghQ.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.ghP - (TopicVideoControllerView.this.bLK() % TopicVideoControllerView.this.ghP));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ghX = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.ghQ.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.ghQ.seekTo((int) duration);
                    if (TopicVideoControllerView.this.ghR != null) {
                        TopicVideoControllerView.this.ghR.setText(TopicVideoControllerView.this.CA((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bLK();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ghP = 50;
        this.mDragging = false;
        this.bbQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bbQ && TopicVideoControllerView.this.ghQ != null && TopicVideoControllerView.this.ghQ.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.ghP - (TopicVideoControllerView.this.bLK() % TopicVideoControllerView.this.ghP));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ghX = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.ghQ.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.ghQ.seekTo((int) duration);
                    if (TopicVideoControllerView.this.ghR != null) {
                        TopicVideoControllerView.this.ghR.setText(TopicVideoControllerView.this.CA((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bLK();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.ghR = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.ghS = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.ghT = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.ghT.setOnSeekBarChangeListener(this.ghX);
        this.kyD = new StringBuilder();
        this.kyE = new Formatter(this.kyD, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.ghQ = mediaPlayerControl;
    }

    public void bx(int i, int i2) {
        this.bbQ = false;
        this.mHandler.removeMessages(1);
        this.ghT.setProgress(0);
        if (this.ghR != null) {
            this.ghR.setText(CA(i));
        }
        if (this.ghS != null) {
            this.ghS.setText(CA(Cz(i2)));
        }
    }

    public void showProgress() {
        if (this.ghQ != null) {
            this.ghP = ((this.ghQ.getDuration() / 200) / 50) * 50;
            if (this.ghP < 50) {
                this.ghP = 50;
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
            this.ghR.setText(CA(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bLK() {
        if (this.ghQ == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.ghQ.getCurrentPosition();
        int duration = this.ghQ.getDuration();
        if (this.ghT != null && duration > 0) {
            this.ghT.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.ghS != null && duration > 0) {
            this.ghS.setText(CA(Cz(duration)));
        }
        if (this.ghR != null) {
            this.ghR.setText(CA(currentPosition));
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
        this.kyD.setLength(0);
        return i5 > 0 ? this.kyE.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.kyE.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.ghR, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.ghS, R.color.CAM_X0101, 1);
        this.ghT.setProgressDrawable(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.ghT.setThumb(ap.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.ghT.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.ghT != null) {
            return this.ghT.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
