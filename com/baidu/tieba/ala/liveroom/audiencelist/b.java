package com.baidu.tieba.ala.liveroom.audiencelist;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.utils.j;
/* loaded from: classes11.dex */
public class b {
    ViewGroup bRb;
    private long count;
    private com.baidu.tieba.ala.liveroom.operation.b hrf;
    private TextView htP;
    private ImageView htQ;
    View htR;
    private boolean isHost;
    private Context mContext;
    private View mView = null;
    private boolean gLY = true;
    private boolean htS = true;
    private boolean htT = false;
    private Handler handler = new Handler();

    public b(Context context, boolean z) {
        this.isHost = false;
        this.mContext = context;
        this.isHost = z;
        initView();
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.g.ala_liveroom_audience_count_layout, null);
        this.mView.setMinimumWidth(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds90));
        this.mView.setId(a.f.ala_liveroom_audience_count_layout);
        this.htP = (TextView) this.mView.findViewById(a.f.ala_live_room_audience_count);
        this.htQ = (ImageView) this.mView.findViewById(a.f.close_imageView);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.htQ.setVisibility(4);
        } else {
            this.htQ.setVisibility(8);
        }
        this.htP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hrf != null) {
                    b.this.hrf.v(view, 14);
                }
                if (b.this.htR != null) {
                    b.this.htR.setVisibility(8);
                }
            }
        });
        this.htT = SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.POKE_DIALOG_SHOWED, false);
    }

    public void a(ViewGroup viewGroup, int i, long j) {
        if (this.mView.getParent() != null) {
            ((ViewGroup) this.mView.getParent()).removeView(this.mView);
        }
        ff(j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds72));
        layoutParams.addRule(11);
        layoutParams.addRule(8, i);
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds8);
        viewGroup.addView(this.mView, layoutParams);
        this.bRb = viewGroup;
    }

    public void setVisible(int i) {
        if (this.gLY) {
            this.mView.setVisibility(i);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void nY(boolean z) {
        if (z) {
            this.htQ.setVisibility(4);
        } else {
            this.htQ.setVisibility(8);
        }
    }

    public void ff(long j) {
        if (j < 0) {
            j = 0;
        }
        if (this.count == 0 && j > 0 && !this.htS) {
            ccw();
        }
        this.count = j;
        this.htP.setText(j.numFormatOverWanNaForAudienceNum(j));
        this.htS = false;
    }

    private void ccw() {
        if (this.isHost && !this.htT) {
            int[] iArr = new int[2];
            this.htP.getLocationInWindow(iArr);
            this.htR = LayoutInflater.from(this.mContext).inflate(a.g.ala_poke_dialog, (ViewGroup) null);
            this.htR.setVisibility(8);
            this.htR.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = (iArr[0] - this.htR.getMeasuredWidth()) + this.htP.getWidth();
            layoutParams.topMargin = iArr[1] + this.htP.getHeight();
            if (this.bRb.getParent() != null) {
                ((ViewGroup) this.bRb.getParent()).addView(this.htR.getRootView(), layoutParams);
            }
            this.htR.setVisibility(0);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.htR.setVisibility(8);
                }
            }, 5000L);
            this.htT = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.POKE_DIALOG_SHOWED, true);
        }
    }

    public long getCount() {
        return this.count;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hrf = bVar;
    }

    public void nZ(boolean z) {
        if (this.htP != null) {
            this.htP.setEnabled(z);
        }
    }
}
