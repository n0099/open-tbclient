package com.baidu.tieba.ala.liveroom.audiencelist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.j;
/* loaded from: classes4.dex */
public class b {
    private long count;
    private com.baidu.tieba.ala.liveroom.operation.b gWq;
    private TextView gYL;
    private ImageView gYM;
    private boolean isHost;
    private Context mContext;
    private View mView = null;
    private boolean gtL = true;

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
        this.gYL = (TextView) this.mView.findViewById(a.f.ala_live_room_audience_count);
        this.gYM = (ImageView) this.mView.findViewById(a.f.close_imageView);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gYM.setVisibility(4);
        } else {
            this.gYM.setVisibility(8);
        }
        this.gYL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gWq != null) {
                    b.this.gWq.p(view, 14);
                }
            }
        });
    }

    public void a(ViewGroup viewGroup, int i, long j) {
        if (this.mView.getParent() != null) {
            ((ViewGroup) this.mView.getParent()).removeView(this.mView);
        }
        ew(j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds72));
        layoutParams.addRule(11);
        layoutParams.addRule(8, i);
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds8);
        viewGroup.addView(this.mView, layoutParams);
    }

    public void setVisible(int i) {
        if (this.gtL) {
            this.mView.setVisibility(i);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void mV(boolean z) {
        if (z) {
            this.gYM.setVisibility(4);
        } else {
            this.gYM.setVisibility(8);
        }
    }

    public void ew(long j) {
        if (j < 0) {
            j = 0;
        }
        this.count = j;
        this.gYL.setText(j.numFormatOverWanNaForAudienceNum(j));
    }

    public long getCount() {
        return this.count;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gWq = bVar;
    }

    public void mW(boolean z) {
        if (this.gYL != null) {
            this.gYL.setEnabled(z);
        }
    }
}
