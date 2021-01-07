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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes8.dex */
public class TopicVideoControllerView extends RelativeLayout {
    private boolean bdx;
    private int gjU;
    private MediaController.MediaPlayerControl gjV;
    private TextView gjW;
    private TextView gjX;
    private SeekBar gjY;
    private SeekBar.OnSeekBarChangeListener gkc;
    private StringBuilder kuN;
    private Formatter kuO;
    private boolean mDragging;
    private Handler mHandler;

    public TopicVideoControllerView(Context context) {
        super(context);
        this.gjU = 50;
        this.mDragging = false;
        this.bdx = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bdx && TopicVideoControllerView.this.gjV != null && TopicVideoControllerView.this.gjV.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.gjU - (TopicVideoControllerView.this.bPb() % TopicVideoControllerView.this.gjU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gkc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.gjV.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.gjV.seekTo((int) duration);
                    if (TopicVideoControllerView.this.gjW != null) {
                        TopicVideoControllerView.this.gjW.setText(TopicVideoControllerView.this.DP((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bPb();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjU = 50;
        this.mDragging = false;
        this.bdx = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bdx && TopicVideoControllerView.this.gjV != null && TopicVideoControllerView.this.gjV.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.gjU - (TopicVideoControllerView.this.bPb() % TopicVideoControllerView.this.gjU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gkc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.gjV.getDuration() * i) / 10000;
                    TopicVideoControllerView.this.gjV.seekTo((int) duration);
                    if (TopicVideoControllerView.this.gjW != null) {
                        TopicVideoControllerView.this.gjW.setText(TopicVideoControllerView.this.DP((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bPb();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjU = 50;
        this.mDragging = false;
        this.bdx = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!TopicVideoControllerView.this.mDragging && TopicVideoControllerView.this.bdx && TopicVideoControllerView.this.gjV != null && TopicVideoControllerView.this.gjV.isPlaying()) {
                            sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.gjU - (TopicVideoControllerView.this.bPb() % TopicVideoControllerView.this.gjU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gkc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.hottopic.view.TopicVideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = true;
                TopicVideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    long duration = (TopicVideoControllerView.this.gjV.getDuration() * i2) / 10000;
                    TopicVideoControllerView.this.gjV.seekTo((int) duration);
                    if (TopicVideoControllerView.this.gjW != null) {
                        TopicVideoControllerView.this.gjW.setText(TopicVideoControllerView.this.DP((int) duration));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TopicVideoControllerView.this.mDragging = false;
                TopicVideoControllerView.this.bPb();
                TopicVideoControllerView.this.mHandler.sendEmptyMessage(1);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.gjW = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.gjX = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        this.gjY = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.gjY.setOnSeekBarChangeListener(this.gkc);
        this.kuN = new StringBuilder();
        this.kuO = new Formatter(this.kuN, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gjV = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.bdx = false;
        this.mHandler.removeMessages(1);
        this.gjY.setProgress(0);
        if (this.gjW != null) {
            this.gjW.setText(DP(i));
        }
        if (this.gjX != null) {
            this.gjX.setText(DP(DO(i2)));
        }
    }

    public void showProgress() {
        if (this.gjV != null) {
            this.gjU = ((this.gjV.getDuration() / 200) / 50) * 50;
            if (this.gjU < 50) {
                this.gjU = 50;
            }
            this.bdx = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gjU - (this.gjV.getCurrentPosition() % this.gjU));
        }
    }

    public void aUS() {
        this.bdx = false;
        this.mHandler.removeMessages(1);
        this.gjY.setProgress(0);
        if (this.gjW != null) {
            this.gjW.setText(DP(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bPb() {
        if (this.gjV == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.gjV.getCurrentPosition();
        int duration = this.gjV.getDuration();
        if (this.gjY != null && duration > 0) {
            this.gjY.setProgress((int) ((10000 * currentPosition) / duration));
        }
        if (this.gjX != null && duration > 0) {
            this.gjX.setText(DP(DO(duration)));
        }
        if (this.gjW != null) {
            this.gjW.setText(DP(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int DO(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String DP(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        this.kuN.setLength(0);
        return i5 > 0 ? this.kuO.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.kuO.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ao.setViewTextColor(this.gjW, R.color.CAM_X0101, 1);
        ao.setViewTextColor(this.gjX, R.color.CAM_X0101, 1);
        this.gjY.setProgressDrawable(ao.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.gjY.setThumb(ao.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.gjY.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.gjY != null) {
            return this.gjY.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
