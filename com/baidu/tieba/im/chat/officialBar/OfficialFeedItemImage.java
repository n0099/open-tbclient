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
/* loaded from: classes26.dex */
public class OfficialFeedItemImage extends RelativeLayout {
    private boolean klI;
    private TextView knD;
    private TbImageView knF;
    private ImageView knG;
    private TextView knH;
    private View knI;
    private View knJ;
    private View knK;
    private Context mContext;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.klI = z;
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.knF = (TbImageView) findViewById(R.id.message_image);
        this.knG = (ImageView) findViewById(R.id.message_read_icon);
        this.knH = (TextView) findViewById(R.id.message_read_count);
        this.knD = (TextView) findViewById(R.id.message_title);
        this.knI = findViewById(R.id.black_mask);
        this.knF.setConrers(15);
        this.knF.setRadius(l.getDimens(this.mContext, R.dimen.tbds21));
        this.knJ = findViewById(R.id.image_container);
        this.knK = findViewById(R.id.msg_read_container);
        cUl();
    }

    public void cUm() {
        this.knF.setRadius(l.getDimens(this.mContext, R.dimen.tbds31));
        this.knF.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.knJ.getLayoutParams();
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds579);
        this.knJ.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.knK.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.knK.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.knD.getLayoutParams();
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.knD.setLayoutParams(layoutParams3);
    }

    public void cUl() {
        SvgManager.btW().a(this.knG, R.drawable.icon_pure_broadcast_read16_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.e.a.b l = com.baidu.tbadk.core.util.e.a.buz().qf(0).l(R.color.CAM_X0601, R.color.CAM_X0606);
        if (this.klI) {
            l.bq(this.knI);
        } else {
            l.ag(l.getDimens(getContext(), R.dimen.tbds21)).af(l.getDimens(getContext(), R.dimen.tbds21)).bq(this.knI);
        }
        ap.setViewTextColor(this.knH, R.color.CAM_X0101);
        ap.setViewTextColor(this.knD, R.color.CAM_X0101);
    }

    public void setData(a.C0782a c0782a, int i, com.baidu.tieba.im.forum.broadcast.data.b bVar) {
        this.knF.startLoad(c0782a.src, 10, false);
        this.knD.setText(c0782a.title);
        if (bVar != null) {
            i = bVar.cWt();
        }
        DQ(i);
    }

    public void DQ(int i) {
        if (i > 0) {
            this.knH.setText(this.mContext.getString(R.string.person_view_num, au.dV(i)));
            this.knH.setVisibility(0);
            this.knG.setVisibility(0);
            return;
        }
        this.knH.setVisibility(8);
        this.knG.setVisibility(8);
    }
}
