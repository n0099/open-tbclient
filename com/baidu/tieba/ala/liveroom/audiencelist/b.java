package com.baidu.tieba.ala.liveroom.audiencelist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.i;
/* loaded from: classes2.dex */
public class b {
    private long count;
    private com.baidu.tieba.ala.liveroom.operation.b eNr;
    private TextView ePr;
    private ImageView ePs;
    private boolean isHost;
    private Context mContext;
    private View mView = null;
    private boolean ePt = true;

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
        this.ePr = (TextView) this.mView.findViewById(a.g.ala_live_room_audience_count);
        this.ePs = (ImageView) this.mView.findViewById(a.g.close_imageView);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ePs.setVisibility(0);
            this.ePs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.eNr != null) {
                        b.this.eNr.m(view, 8);
                    }
                }
            });
        } else {
            this.ePs.setVisibility(8);
        }
        this.ePr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eNr != null) {
                    b.this.eNr.m(view, 14);
                }
            }
        });
    }

    public void a(ViewGroup viewGroup, int i, long j) {
        if (this.mView.getParent() != null) {
            ((ViewGroup) this.mView.getParent()).removeView(this.mView);
        }
        cA(j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds72));
        layoutParams.addRule(11);
        layoutParams.addRule(8, i);
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, a.e.sdk_ds8);
        viewGroup.addView(this.mView, layoutParams);
    }

    public void setVisible(int i) {
        if (this.ePt) {
            this.mView.setVisibility(i);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void jd(boolean z) {
        if (z) {
            this.ePs.setVisibility(0);
        } else {
            this.ePs.setVisibility(8);
        }
    }

    public void cA(long j) {
        if (j < 0) {
            j = 0;
        }
        this.count = j;
        this.ePr.setText(i.numFormatOverWanNaForAudienceNum(j));
    }

    public long getCount() {
        return this.count;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.eNr = bVar;
    }

    public void je(boolean z) {
        if (this.ePr != null) {
            this.ePr.setEnabled(z);
        }
    }
}
