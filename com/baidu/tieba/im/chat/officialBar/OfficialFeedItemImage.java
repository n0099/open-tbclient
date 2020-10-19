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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes26.dex */
public class OfficialFeedItemImage extends RelativeLayout {
    private boolean jEX;
    private TextView jGT;
    private TbImageView jGV;
    private ImageView jGW;
    private TextView jGX;
    private View jGY;
    private View jGZ;
    private View jHa;
    private Context mContext;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.jEX = z;
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.jGV = (TbImageView) findViewById(R.id.message_image);
        this.jGW = (ImageView) findViewById(R.id.message_read_icon);
        this.jGX = (TextView) findViewById(R.id.message_read_count);
        this.jGT = (TextView) findViewById(R.id.message_title);
        this.jGY = findViewById(R.id.black_mask);
        this.jGV.setConrers(15);
        this.jGV.setRadius(l.getDimens(this.mContext, R.dimen.tbds21));
        this.jGZ = findViewById(R.id.image_container);
        this.jHa = findViewById(R.id.msg_read_container);
        cJJ();
    }

    public void cJK() {
        this.jGV.setRadius(l.getDimens(this.mContext, R.dimen.tbds31));
        this.jGV.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.jGZ.getLayoutParams();
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds579);
        this.jGZ.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jHa.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.jHa.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.jGT.getLayoutParams();
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.jGT.setLayoutParams(layoutParams3);
    }

    public void cJJ() {
        SvgManager.bmU().a(this.jGW, R.drawable.icon_pure_broadcast_read16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.e.a.b i = com.baidu.tbadk.core.util.e.a.bnv().oO(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42);
        if (this.jEX) {
            i.bf(this.jGY);
        } else {
            i.ab(l.getDimens(getContext(), R.dimen.tbds21)).aa(l.getDimens(getContext(), R.dimen.tbds21)).bf(this.jGY);
        }
        ap.setViewTextColor(this.jGX, R.color.cp_cont_a);
        ap.setViewTextColor(this.jGT, R.color.cp_cont_a);
    }

    public void setData(a.C0734a c0734a, int i, com.baidu.tieba.im.forum.broadcast.data.b bVar) {
        this.jGV.startLoad(c0734a.src, 10, false);
        this.jGT.setText(c0734a.title);
        if (bVar != null) {
            i = bVar.cLR();
        }
        BX(i);
    }

    public void BX(int i) {
        if (i > 0) {
            this.jGX.setText(this.mContext.getString(R.string.person_view_num, at.cY(i)));
            this.jGX.setVisibility(0);
            this.jGW.setVisibility(0);
            return;
        }
        this.jGX.setVisibility(8);
        this.jGW.setVisibility(8);
    }
}
