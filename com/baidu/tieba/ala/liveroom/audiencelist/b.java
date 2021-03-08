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
/* loaded from: classes10.dex */
public class b {
    ViewGroup bSB;
    private long count;
    private com.baidu.tieba.ala.liveroom.operation.b hsO;
    View hvA;
    private TextView hvy;
    private ImageView hvz;
    private boolean isHost;
    private Context mContext;
    private View mView = null;
    private boolean gNH = true;
    private boolean hvB = true;
    private boolean hvC = false;
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
        this.hvy = (TextView) this.mView.findViewById(a.f.ala_live_room_audience_count);
        this.hvz = (ImageView) this.mView.findViewById(a.f.close_imageView);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hvz.setVisibility(4);
        } else {
            this.hvz.setVisibility(8);
        }
        this.hvy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hsO != null) {
                    b.this.hsO.v(view, 14);
                }
                if (b.this.hvA != null) {
                    b.this.hvA.setVisibility(8);
                }
            }
        });
        this.hvC = SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.POKE_DIALOG_SHOWED, false);
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
        this.bSB = viewGroup;
    }

    public void setVisible(int i) {
        if (this.gNH) {
            this.mView.setVisibility(i);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void nY(boolean z) {
        if (z) {
            this.hvz.setVisibility(4);
        } else {
            this.hvz.setVisibility(8);
        }
    }

    public void ff(long j) {
        if (j < 0) {
            j = 0;
        }
        if (this.count == 0 && j > 0 && !this.hvB) {
            ccC();
        }
        this.count = j;
        this.hvy.setText(j.numFormatOverWanNaForAudienceNum(j));
        this.hvB = false;
    }

    private void ccC() {
        if (this.isHost && !this.hvC) {
            int[] iArr = new int[2];
            this.hvy.getLocationInWindow(iArr);
            this.hvA = LayoutInflater.from(this.mContext).inflate(a.g.ala_poke_dialog, (ViewGroup) null);
            this.hvA.setVisibility(8);
            this.hvA.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = (iArr[0] - this.hvA.getMeasuredWidth()) + this.hvy.getWidth();
            layoutParams.topMargin = iArr[1] + this.hvy.getHeight();
            if (this.bSB.getParent() != null) {
                ((ViewGroup) this.bSB.getParent()).addView(this.hvA.getRootView(), layoutParams);
            }
            this.hvA.setVisibility(0);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.hvA.setVisibility(8);
                }
            }, 5000L);
            this.hvC = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.POKE_DIALOG_SHOWED, true);
        }
    }

    public long getCount() {
        return this.count;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hsO = bVar;
    }

    public void nZ(boolean z) {
        if (this.hvy != null) {
            this.hvy.setEnabled(z);
        }
    }
}
