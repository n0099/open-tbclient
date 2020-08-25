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
    private boolean jho;
    private TextView jjm;
    private TbImageView jjo;
    private ImageView jjp;
    private TextView jjq;
    private View jjr;
    private View jjs;
    private View jjt;
    private Context mContext;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.jho = z;
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.jjo = (TbImageView) findViewById(R.id.message_image);
        this.jjp = (ImageView) findViewById(R.id.message_read_icon);
        this.jjq = (TextView) findViewById(R.id.message_read_count);
        this.jjm = (TextView) findViewById(R.id.message_title);
        this.jjr = findViewById(R.id.black_mask);
        this.jjo.setConrers(15);
        this.jjo.setRadius(l.getDimens(this.mContext, R.dimen.tbds21));
        this.jjs = findViewById(R.id.image_container);
        this.jjt = findViewById(R.id.msg_read_container);
        cCt();
    }

    public void cCu() {
        this.jjo.setRadius(l.getDimens(this.mContext, R.dimen.tbds31));
        this.jjo.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.jjs.getLayoutParams();
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds579);
        this.jjs.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jjt.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.jjt.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.jjm.getLayoutParams();
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.jjm.setLayoutParams(layoutParams3);
    }

    public void cCt() {
        SvgManager.bjq().a(this.jjp, R.drawable.icon_pure_broadcast_read16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.e.a.b i = com.baidu.tbadk.core.util.e.a.bjQ().oe(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42);
        if (this.jho) {
            i.aZ(this.jjr);
        } else {
            i.Z(l.getDimens(getContext(), R.dimen.tbds21)).Y(l.getDimens(getContext(), R.dimen.tbds21)).aZ(this.jjr);
        }
        ap.setViewTextColor(this.jjq, R.color.cp_cont_a);
        ap.setViewTextColor(this.jjm, R.color.cp_cont_a);
    }

    public void setData(a.C0719a c0719a, int i, com.baidu.tieba.im.forum.broadcast.data.b bVar) {
        this.jjo.startLoad(c0719a.src, 10, false);
        this.jjm.setText(c0719a.title);
        if (bVar != null) {
            i = bVar.cEB();
        }
        AQ(i);
    }

    public void AQ(int i) {
        if (i > 0) {
            this.jjq.setText(this.mContext.getString(R.string.person_view_num, at.cP(i)));
            this.jjq.setVisibility(0);
            this.jjp.setVisibility(0);
            return;
        }
        this.jjq.setVisibility(8);
        this.jjp.setVisibility(8);
    }
}
