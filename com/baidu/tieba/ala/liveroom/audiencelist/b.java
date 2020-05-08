package com.baidu.tieba.ala.liveroom.audiencelist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import com.baidu.live.utils.i;
/* loaded from: classes3.dex */
public class b {
    private long count;
    private com.baidu.tieba.ala.liveroom.operation.b fwF;
    private TextView fyE;
    private ImageView fyF;
    private boolean isHost;
    private Context mContext;
    private View mView = null;
    private boolean fyG = true;

    public b(Context context, boolean z) {
        this.isHost = false;
        this.mContext = context;
        this.isHost = z;
        initView();
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.h.ala_liveroom_audience_count_layout, null);
        this.mView.setMinimumWidth(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds90));
        this.mView.setId(a.g.ala_liveroom_audience_count_layout);
        this.fyE = (TextView) this.mView.findViewById(a.g.ala_live_room_audience_count);
        this.fyF = (ImageView) this.mView.findViewById(a.g.close_imageView);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fyF.setVisibility(0);
            this.fyF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fwF != null) {
                        b.this.fwF.l(view, 8);
                    }
                }
            });
        } else {
            this.fyF.setVisibility(8);
        }
        this.fyE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fwF != null) {
                    b.this.fwF.l(view, 14);
                }
            }
        });
    }

    public void a(ViewGroup viewGroup, int i, long j) {
        if (this.mView.getParent() != null) {
            ((ViewGroup) this.mView.getParent()).removeView(this.mView);
        }
        dk(j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds72));
        layoutParams.addRule(11);
        layoutParams.addRule(8, i);
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, a.e.sdk_ds8);
        viewGroup.addView(this.mView, layoutParams);
    }

    public void setVisible(int i) {
        if (this.fyG) {
            this.mView.setVisibility(i);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void kk(boolean z) {
        if (z) {
            this.fyF.setVisibility(0);
        } else {
            this.fyF.setVisibility(8);
        }
    }

    public void dk(long j) {
        if (j < 0) {
            j = 0;
        }
        this.count = j;
        this.fyE.setText(i.numFormatOverWanNaForAudienceNum(j));
    }

    public long getCount() {
        return this.count;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.fwF = bVar;
    }

    public void kl(boolean z) {
        if (this.fyE != null) {
            this.fyE.setEnabled(z);
        }
    }
}
