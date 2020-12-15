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
/* loaded from: classes4.dex */
public class b {
    ViewGroup bNk;
    private long count;
    private com.baidu.tieba.ala.liveroom.operation.b hfw;
    private TextView hhZ;
    private ImageView hia;
    View hib;
    private boolean isHost;
    private Context mContext;
    private View mView = null;
    private boolean gBY = true;
    private boolean hic = true;
    private boolean hie = false;
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
        this.hhZ = (TextView) this.mView.findViewById(a.f.ala_live_room_audience_count);
        this.hia = (ImageView) this.mView.findViewById(a.f.close_imageView);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hia.setVisibility(4);
        } else {
            this.hia.setVisibility(8);
        }
        this.hhZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hfw != null) {
                    b.this.hfw.s(view, 14);
                }
                if (b.this.hib != null) {
                    b.this.hib.setVisibility(8);
                }
            }
        });
        this.hie = SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.POKE_DIALOG_SHOWED, false);
    }

    public void a(ViewGroup viewGroup, int i, long j) {
        if (this.mView.getParent() != null) {
            ((ViewGroup) this.mView.getParent()).removeView(this.mView);
        }
        eZ(j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds72));
        layoutParams.addRule(11);
        layoutParams.addRule(8, i);
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds8);
        viewGroup.addView(this.mView, layoutParams);
        this.bNk = viewGroup;
    }

    public void setVisible(int i) {
        if (this.gBY) {
            this.mView.setVisibility(i);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void nr(boolean z) {
        if (z) {
            this.hia.setVisibility(4);
        } else {
            this.hia.setVisibility(8);
        }
    }

    public void eZ(long j) {
        if (j < 0) {
            j = 0;
        }
        if (this.count == 0 && j > 0 && !this.hic) {
            ccv();
        }
        this.count = j;
        this.hhZ.setText(j.numFormatOverWanNaForAudienceNum(j));
        this.hic = false;
    }

    private void ccv() {
        if (this.isHost && !this.hie) {
            int[] iArr = new int[2];
            this.hhZ.getLocationInWindow(iArr);
            this.hib = LayoutInflater.from(this.mContext).inflate(a.g.ala_poke_dialog, (ViewGroup) null);
            this.hib.setVisibility(8);
            this.hib.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = (iArr[0] - this.hib.getMeasuredWidth()) + this.hhZ.getWidth();
            layoutParams.topMargin = iArr[1] + this.hhZ.getHeight();
            if (this.bNk.getParent() != null) {
                ((ViewGroup) this.bNk.getParent()).addView(this.hib.getRootView(), layoutParams);
            }
            this.hib.setVisibility(0);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.hib.setVisibility(8);
                }
            }, 5000L);
            this.hie = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.POKE_DIALOG_SHOWED, true);
        }
    }

    public long getCount() {
        return this.count;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hfw = bVar;
    }

    public void ns(boolean z) {
        if (this.hhZ != null) {
            this.hhZ.setEnabled(z);
        }
    }
}
