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
/* loaded from: classes8.dex */
public class OfficialFeedItemImage extends RelativeLayout {
    private boolean kCg;
    private TextView kDZ;
    private TbImageView kEb;
    private ImageView kEc;
    private TextView kEd;
    private View kEe;
    private View kEf;
    private View kEg;
    private Context mContext;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.kCg = z;
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.kEb = (TbImageView) findViewById(R.id.message_image);
        this.kEc = (ImageView) findViewById(R.id.message_read_icon);
        this.kEd = (TextView) findViewById(R.id.message_read_count);
        this.kDZ = (TextView) findViewById(R.id.message_title);
        this.kEe = findViewById(R.id.black_mask);
        this.kEb.setConrers(15);
        this.kEb.setRadius(l.getDimens(this.mContext, R.dimen.tbds21));
        this.kEf = findViewById(R.id.image_container);
        this.kEg = findViewById(R.id.msg_read_container);
        cVm();
    }

    public void cVn() {
        this.kEb.setRadius(l.getDimens(this.mContext, R.dimen.tbds31));
        this.kEb.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.kEf.getLayoutParams();
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds579);
        this.kEf.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kEg.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.kEg.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.kDZ.getLayoutParams();
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.kDZ.setLayoutParams(layoutParams3);
    }

    public void cVm() {
        SvgManager.bsR().a(this.kEc, R.drawable.icon_pure_broadcast_read16_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.f.a.b m = com.baidu.tbadk.core.util.f.a.btv().oO(0).m(R.color.CAM_X0601, R.color.CAM_X0606);
        if (this.kCg) {
            m.bv(this.kEe);
        } else {
            m.aj(l.getDimens(getContext(), R.dimen.tbds21)).ai(l.getDimens(getContext(), R.dimen.tbds21)).bv(this.kEe);
        }
        ap.setViewTextColor(this.kEd, R.color.CAM_X0101);
        ap.setViewTextColor(this.kDZ, R.color.CAM_X0101);
    }

    public void setData(a.C0761a c0761a, int i, com.baidu.tieba.im.forum.broadcast.data.b bVar) {
        this.kEb.startLoad(c0761a.src, 10, false);
        this.kDZ.setText(c0761a.title);
        if (bVar != null) {
            i = bVar.cWe();
        }
        CN(i);
    }

    public void CN(int i) {
        if (i > 0) {
            this.kEd.setText(this.mContext.getString(R.string.person_view_num, au.eb(i)));
            this.kEd.setVisibility(0);
            this.kEc.setVisibility(0);
            return;
        }
        this.kEd.setVisibility(8);
        this.kEc.setVisibility(8);
    }
}
