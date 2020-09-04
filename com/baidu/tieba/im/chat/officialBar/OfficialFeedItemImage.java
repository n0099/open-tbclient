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
/* loaded from: classes20.dex */
public class OfficialFeedItemImage extends RelativeLayout {
    private boolean jhu;
    private TextView jjs;
    private TbImageView jju;
    private ImageView jjv;
    private TextView jjw;
    private View jjx;
    private View jjy;
    private View jjz;
    private Context mContext;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.jhu = z;
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.jju = (TbImageView) findViewById(R.id.message_image);
        this.jjv = (ImageView) findViewById(R.id.message_read_icon);
        this.jjw = (TextView) findViewById(R.id.message_read_count);
        this.jjs = (TextView) findViewById(R.id.message_title);
        this.jjx = findViewById(R.id.black_mask);
        this.jju.setConrers(15);
        this.jju.setRadius(l.getDimens(this.mContext, R.dimen.tbds21));
        this.jjy = findViewById(R.id.image_container);
        this.jjz = findViewById(R.id.msg_read_container);
        cCu();
    }

    public void cCv() {
        this.jju.setRadius(l.getDimens(this.mContext, R.dimen.tbds31));
        this.jju.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.jjy.getLayoutParams();
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds579);
        this.jjy.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jjz.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.jjz.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.jjs.getLayoutParams();
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.jjs.setLayoutParams(layoutParams3);
    }

    public void cCu() {
        SvgManager.bjq().a(this.jjv, R.drawable.icon_pure_broadcast_read16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.e.a.b i = com.baidu.tbadk.core.util.e.a.bjQ().oe(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42);
        if (this.jhu) {
            i.aZ(this.jjx);
        } else {
            i.Z(l.getDimens(getContext(), R.dimen.tbds21)).Y(l.getDimens(getContext(), R.dimen.tbds21)).aZ(this.jjx);
        }
        ap.setViewTextColor(this.jjw, R.color.cp_cont_a);
        ap.setViewTextColor(this.jjs, R.color.cp_cont_a);
    }

    public void setData(a.C0719a c0719a, int i, com.baidu.tieba.im.forum.broadcast.data.b bVar) {
        this.jju.startLoad(c0719a.src, 10, false);
        this.jjs.setText(c0719a.title);
        if (bVar != null) {
            i = bVar.cEC();
        }
        AQ(i);
    }

    public void AQ(int i) {
        if (i > 0) {
            this.jjw.setText(this.mContext.getString(R.string.person_view_num, at.cP(i)));
            this.jjw.setVisibility(0);
            this.jjv.setVisibility(0);
            return;
        }
        this.jjw.setVisibility(8);
        this.jjv.setVisibility(8);
    }
}
