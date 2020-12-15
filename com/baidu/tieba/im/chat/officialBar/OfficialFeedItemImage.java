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
    private boolean klK;
    private TextView knF;
    private TbImageView knH;
    private ImageView knI;
    private TextView knJ;
    private View knK;
    private View knL;
    private View knM;
    private Context mContext;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.klK = z;
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.knH = (TbImageView) findViewById(R.id.message_image);
        this.knI = (ImageView) findViewById(R.id.message_read_icon);
        this.knJ = (TextView) findViewById(R.id.message_read_count);
        this.knF = (TextView) findViewById(R.id.message_title);
        this.knK = findViewById(R.id.black_mask);
        this.knH.setConrers(15);
        this.knH.setRadius(l.getDimens(this.mContext, R.dimen.tbds21));
        this.knL = findViewById(R.id.image_container);
        this.knM = findViewById(R.id.msg_read_container);
        cUm();
    }

    public void cUn() {
        this.knH.setRadius(l.getDimens(this.mContext, R.dimen.tbds31));
        this.knH.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.knL.getLayoutParams();
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds579);
        this.knL.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.knM.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.knM.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.knF.getLayoutParams();
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.knF.setLayoutParams(layoutParams3);
    }

    public void cUm() {
        SvgManager.btW().a(this.knI, R.drawable.icon_pure_broadcast_read16_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.e.a.b l = com.baidu.tbadk.core.util.e.a.buz().qf(0).l(R.color.CAM_X0601, R.color.CAM_X0606);
        if (this.klK) {
            l.bq(this.knK);
        } else {
            l.ag(l.getDimens(getContext(), R.dimen.tbds21)).af(l.getDimens(getContext(), R.dimen.tbds21)).bq(this.knK);
        }
        ap.setViewTextColor(this.knJ, R.color.CAM_X0101);
        ap.setViewTextColor(this.knF, R.color.CAM_X0101);
    }

    public void setData(a.C0782a c0782a, int i, com.baidu.tieba.im.forum.broadcast.data.b bVar) {
        this.knH.startLoad(c0782a.src, 10, false);
        this.knF.setText(c0782a.title);
        if (bVar != null) {
            i = bVar.cWu();
        }
        DQ(i);
    }

    public void DQ(int i) {
        if (i > 0) {
            this.knJ.setText(this.mContext.getString(R.string.person_view_num, au.dV(i)));
            this.knJ.setVisibility(0);
            this.knI.setVisibility(0);
            return;
        }
        this.knJ.setVisibility(8);
        this.knI.setVisibility(8);
    }
}
