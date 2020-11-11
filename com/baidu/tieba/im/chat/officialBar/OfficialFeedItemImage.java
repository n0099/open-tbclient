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
    private boolean jXt;
    private TextView jZo;
    private TbImageView jZq;
    private ImageView jZr;
    private TextView jZs;
    private View jZt;
    private View jZu;
    private View jZv;
    private Context mContext;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.jXt = z;
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.jZq = (TbImageView) findViewById(R.id.message_image);
        this.jZr = (ImageView) findViewById(R.id.message_read_icon);
        this.jZs = (TextView) findViewById(R.id.message_read_count);
        this.jZo = (TextView) findViewById(R.id.message_title);
        this.jZt = findViewById(R.id.black_mask);
        this.jZq.setConrers(15);
        this.jZq.setRadius(l.getDimens(this.mContext, R.dimen.tbds21));
        this.jZu = findViewById(R.id.image_container);
        this.jZv = findViewById(R.id.msg_read_container);
        cPr();
    }

    public void cPs() {
        this.jZq.setRadius(l.getDimens(this.mContext, R.dimen.tbds31));
        this.jZq.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.jZu.getLayoutParams();
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds579);
        this.jZu.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jZv.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.jZv.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.jZo.getLayoutParams();
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.jZo.setLayoutParams(layoutParams3);
    }

    public void cPr() {
        SvgManager.brn().a(this.jZr, R.drawable.icon_pure_broadcast_read16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.e.a.b i = com.baidu.tbadk.core.util.e.a.brO().pj(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42);
        if (this.jXt) {
            i.bk(this.jZt);
        } else {
            i.af(l.getDimens(getContext(), R.dimen.tbds21)).ae(l.getDimens(getContext(), R.dimen.tbds21)).bk(this.jZt);
        }
        ap.setViewTextColor(this.jZs, R.color.cp_cont_a);
        ap.setViewTextColor(this.jZo, R.color.cp_cont_a);
    }

    public void setData(a.C0764a c0764a, int i, com.baidu.tieba.im.forum.broadcast.data.b bVar) {
        this.jZq.startLoad(c0764a.src, 10, false);
        this.jZo.setText(c0764a.title);
        if (bVar != null) {
            i = bVar.cRz();
        }
        CD(i);
    }

    public void CD(int i) {
        if (i > 0) {
            this.jZs.setText(this.mContext.getString(R.string.person_view_num, at.dw(i)));
            this.jZs.setVisibility(0);
            this.jZr.setVisibility(0);
            return;
        }
        this.jZs.setVisibility(8);
        this.jZr.setVisibility(8);
    }
}
