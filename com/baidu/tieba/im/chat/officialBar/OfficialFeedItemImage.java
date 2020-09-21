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
/* loaded from: classes25.dex */
public class OfficialFeedItemImage extends RelativeLayout {
    private boolean jqa;
    private TextView jrW;
    private TbImageView jrY;
    private ImageView jrZ;
    private TextView jsa;
    private View jsb;
    private View jsc;
    private View jsd;
    private Context mContext;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.jqa = z;
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.jrY = (TbImageView) findViewById(R.id.message_image);
        this.jrZ = (ImageView) findViewById(R.id.message_read_icon);
        this.jsa = (TextView) findViewById(R.id.message_read_count);
        this.jrW = (TextView) findViewById(R.id.message_title);
        this.jsb = findViewById(R.id.black_mask);
        this.jrY.setConrers(15);
        this.jrY.setRadius(l.getDimens(this.mContext, R.dimen.tbds21));
        this.jsc = findViewById(R.id.image_container);
        this.jsd = findViewById(R.id.msg_read_container);
        cGa();
    }

    public void cGb() {
        this.jrY.setRadius(l.getDimens(this.mContext, R.dimen.tbds31));
        this.jrY.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.jsc.getLayoutParams();
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds579);
        this.jsc.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jsd.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.jsd.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.jrW.getLayoutParams();
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.jrW.setLayoutParams(layoutParams3);
    }

    public void cGa() {
        SvgManager.bkl().a(this.jrZ, R.drawable.icon_pure_broadcast_read16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.e.a.b i = com.baidu.tbadk.core.util.e.a.bkL().oq(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42);
        if (this.jqa) {
            i.bb(this.jsb);
        } else {
            i.Z(l.getDimens(getContext(), R.dimen.tbds21)).Y(l.getDimens(getContext(), R.dimen.tbds21)).bb(this.jsb);
        }
        ap.setViewTextColor(this.jsa, R.color.cp_cont_a);
        ap.setViewTextColor(this.jrW, R.color.cp_cont_a);
    }

    public void setData(a.C0716a c0716a, int i, com.baidu.tieba.im.forum.broadcast.data.b bVar) {
        this.jrY.startLoad(c0716a.src, 10, false);
        this.jrW.setText(c0716a.title);
        if (bVar != null) {
            i = bVar.cIi();
        }
        Br(i);
    }

    public void Br(int i) {
        if (i > 0) {
            this.jsa.setText(this.mContext.getString(R.string.person_view_num, at.cQ(i)));
            this.jsa.setVisibility(0);
            this.jrZ.setVisibility(0);
            return;
        }
        this.jsa.setVisibility(8);
        this.jrZ.setVisibility(8);
    }
}
