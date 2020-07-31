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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes20.dex */
public class OfficialFeedItemImage extends RelativeLayout {
    private boolean iSp;
    private TextView iUm;
    private TbImageView iUo;
    private ImageView iUp;
    private TextView iUq;
    private View iUr;
    private View iUs;
    private View iUt;
    private Context mContext;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.iSp = z;
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.iUo = (TbImageView) findViewById(R.id.message_image);
        this.iUp = (ImageView) findViewById(R.id.message_read_icon);
        this.iUq = (TextView) findViewById(R.id.message_read_count);
        this.iUm = (TextView) findViewById(R.id.message_title);
        this.iUr = findViewById(R.id.black_mask);
        this.iUo.setConrers(15);
        this.iUo.setRadius(l.getDimens(this.mContext, R.dimen.tbds21));
        this.iUs = findViewById(R.id.image_container);
        this.iUt = findViewById(R.id.msg_read_container);
        crB();
    }

    public void crC() {
        this.iUo.setRadius(l.getDimens(this.mContext, R.dimen.tbds31));
        this.iUo.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.iUs.getLayoutParams();
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds579);
        this.iUs.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iUt.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.iUt.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.iUm.getLayoutParams();
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.iUm.setLayoutParams(layoutParams3);
    }

    public void crB() {
        SvgManager.baR().a(this.iUp, R.drawable.icon_pure_broadcast_read16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.e.a.c i = com.baidu.tbadk.core.util.e.a.bbr().ma(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42);
        if (this.iSp) {
            i.aX(this.iUr);
        } else {
            i.U(l.getDimens(getContext(), R.dimen.tbds21)).T(l.getDimens(getContext(), R.dimen.tbds21)).aX(this.iUr);
        }
        ao.setViewTextColor(this.iUq, R.color.cp_cont_a);
        ao.setViewTextColor(this.iUm, R.color.cp_cont_a);
    }

    public void setData(a.C0667a c0667a, int i, com.baidu.tieba.im.forum.broadcast.data.b bVar) {
        this.iUo.startLoad(c0667a.src, 10, false);
        this.iUm.setText(c0667a.title);
        if (bVar != null) {
            i = bVar.ctK();
        }
        yw(i);
    }

    public void yw(int i) {
        if (i > 0) {
            this.iUq.setText(this.mContext.getString(R.string.person_view_num, as.cE(i)));
            this.iUq.setVisibility(0);
            this.iUp.setVisibility(0);
            return;
        }
        this.iUq.setVisibility(8);
        this.iUp.setVisibility(8);
    }
}
