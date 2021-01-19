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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes7.dex */
public class OfficialFeedItemImage extends RelativeLayout {
    private boolean ktL;
    private TextView kvF;
    private TbImageView kvH;
    private ImageView kvI;
    private TextView kvJ;
    private View kvK;
    private View kvL;
    private View kvM;
    private Context mContext;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.ktL = z;
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.kvH = (TbImageView) findViewById(R.id.message_image);
        this.kvI = (ImageView) findViewById(R.id.message_read_icon);
        this.kvJ = (TextView) findViewById(R.id.message_read_count);
        this.kvF = (TextView) findViewById(R.id.message_title);
        this.kvK = findViewById(R.id.black_mask);
        this.kvH.setConrers(15);
        this.kvH.setRadius(l.getDimens(this.mContext, R.dimen.tbds21));
        this.kvL = findViewById(R.id.image_container);
        this.kvM = findViewById(R.id.msg_read_container);
        cTh();
    }

    public void cTi() {
        this.kvH.setRadius(l.getDimens(this.mContext, R.dimen.tbds31));
        this.kvH.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.kvL.getLayoutParams();
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds579);
        this.kvL.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kvM.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.kvM.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.kvF.getLayoutParams();
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.kvF.setLayoutParams(layoutParams3);
    }

    public void cTh() {
        SvgManager.bsx().a(this.kvI, R.drawable.icon_pure_broadcast_read16_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.f.a.b m = com.baidu.tbadk.core.util.f.a.btb().oJ(0).m(R.color.CAM_X0601, R.color.CAM_X0606);
        if (this.ktL) {
            m.bz(this.kvK);
        } else {
            m.ai(l.getDimens(getContext(), R.dimen.tbds21)).ah(l.getDimens(getContext(), R.dimen.tbds21)).bz(this.kvK);
        }
        ao.setViewTextColor(this.kvJ, R.color.CAM_X0101);
        ao.setViewTextColor(this.kvF, R.color.CAM_X0101);
    }

    public void setData(a.C0758a c0758a, int i, com.baidu.tieba.im.forum.broadcast.data.b bVar) {
        this.kvH.startLoad(c0758a.src, 10, false);
        this.kvF.setText(c0758a.title);
        if (bVar != null) {
            i = bVar.cTZ();
        }
        Cv(i);
    }

    public void Cv(int i) {
        if (i > 0) {
            this.kvJ.setText(this.mContext.getString(R.string.person_view_num, at.dV(i)));
            this.kvJ.setVisibility(0);
            this.kvI.setVisibility(0);
            return;
        }
        this.kvJ.setVisibility(8);
        this.kvI.setVisibility(8);
    }
}
