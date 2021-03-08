package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes7.dex */
public class OfficialFeedItemImage extends RelativeLayout {
    private boolean kEi;
    private TextView kGb;
    private TbImageView kGd;
    private ImageView kGe;
    private TextView kGf;
    private View kGg;
    private View kGh;
    private View kGi;
    private Context mContext;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.kEi = z;
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.kGd = (TbImageView) findViewById(R.id.message_image);
        this.kGe = (ImageView) findViewById(R.id.message_read_icon);
        this.kGf = (TextView) findViewById(R.id.message_read_count);
        this.kGb = (TextView) findViewById(R.id.message_title);
        this.kGg = findViewById(R.id.black_mask);
        this.kGd.setConrers(15);
        this.kGd.setRadius(l.getDimens(this.mContext, R.dimen.tbds21));
        this.kGh = findViewById(R.id.image_container);
        this.kGi = findViewById(R.id.msg_read_container);
        cVt();
    }

    public void cVu() {
        this.kGd.setRadius(l.getDimens(this.mContext, R.dimen.tbds31));
        this.kGd.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.kGh.getLayoutParams();
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds579);
        this.kGh.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kGi.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.kGi.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.kGb.getLayoutParams();
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.kGb.setLayoutParams(layoutParams3);
    }

    public void cVt() {
        SvgManager.bsU().a(this.kGe, R.drawable.icon_pure_broadcast_read16_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.f.a.b m = com.baidu.tbadk.core.util.f.a.bty().oP(0).m(R.color.CAM_X0601, R.color.CAM_X0606);
        if (this.kEi) {
            m.bv(this.kGg);
        } else {
            m.an(l.getDimens(getContext(), R.dimen.tbds21)).am(l.getDimens(getContext(), R.dimen.tbds21)).bv(this.kGg);
        }
        ap.setViewTextColor(this.kGf, R.color.CAM_X0101);
        ap.setViewTextColor(this.kGb, R.color.CAM_X0101);
    }

    public void setData(a.C0767a c0767a, int i, com.baidu.tieba.im.forum.broadcast.data.b bVar) {
        this.kGd.startLoad(c0767a.src, 10, false);
        this.kGb.setText(c0767a.title);
        if (bVar != null) {
            i = bVar.cWl();
        }
        CQ(i);
    }

    public void CQ(int i) {
        if (i > 0) {
            this.kGf.setText(this.mContext.getString(R.string.person_view_num, au.eb(i)));
            this.kGf.setVisibility(0);
            this.kGe.setVisibility(0);
            return;
        }
        this.kGf.setVisibility(8);
        this.kGe.setVisibility(8);
    }
}
