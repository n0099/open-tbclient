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
    private boolean kBS;
    private TextView kDL;
    private TbImageView kDN;
    private ImageView kDO;
    private TextView kDP;
    private View kDQ;
    private View kDR;
    private View kDS;
    private Context mContext;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.kBS = z;
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.kDN = (TbImageView) findViewById(R.id.message_image);
        this.kDO = (ImageView) findViewById(R.id.message_read_icon);
        this.kDP = (TextView) findViewById(R.id.message_read_count);
        this.kDL = (TextView) findViewById(R.id.message_title);
        this.kDQ = findViewById(R.id.black_mask);
        this.kDN.setConrers(15);
        this.kDN.setRadius(l.getDimens(this.mContext, R.dimen.tbds21));
        this.kDR = findViewById(R.id.image_container);
        this.kDS = findViewById(R.id.msg_read_container);
        cVf();
    }

    public void cVg() {
        this.kDN.setRadius(l.getDimens(this.mContext, R.dimen.tbds31));
        this.kDN.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.kDR.getLayoutParams();
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds579);
        this.kDR.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kDS.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.kDS.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.kDL.getLayoutParams();
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.kDL.setLayoutParams(layoutParams3);
    }

    public void cVf() {
        SvgManager.bsR().a(this.kDO, R.drawable.icon_pure_broadcast_read16_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.f.a.b m = com.baidu.tbadk.core.util.f.a.btv().oO(0).m(R.color.CAM_X0601, R.color.CAM_X0606);
        if (this.kBS) {
            m.bv(this.kDQ);
        } else {
            m.aj(l.getDimens(getContext(), R.dimen.tbds21)).ai(l.getDimens(getContext(), R.dimen.tbds21)).bv(this.kDQ);
        }
        ap.setViewTextColor(this.kDP, R.color.CAM_X0101);
        ap.setViewTextColor(this.kDL, R.color.CAM_X0101);
    }

    public void setData(a.C0760a c0760a, int i, com.baidu.tieba.im.forum.broadcast.data.b bVar) {
        this.kDN.startLoad(c0760a.src, 10, false);
        this.kDL.setText(c0760a.title);
        if (bVar != null) {
            i = bVar.cVX();
        }
        CN(i);
    }

    public void CN(int i) {
        if (i > 0) {
            this.kDP.setText(this.mContext.getString(R.string.person_view_num, au.eb(i)));
            this.kDP.setVisibility(0);
            this.kDO.setVisibility(0);
            return;
        }
        this.kDP.setVisibility(8);
        this.kDO.setVisibility(8);
    }
}
