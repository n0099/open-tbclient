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
/* loaded from: classes8.dex */
public class OfficialFeedItemImage extends RelativeLayout {
    private TextView kAk;
    private TbImageView kAm;
    private ImageView kAn;
    private TextView kAo;
    private View kAp;
    private View kAq;
    private View kAr;
    private boolean kyq;
    private Context mContext;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.kyq = z;
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.kAm = (TbImageView) findViewById(R.id.message_image);
        this.kAn = (ImageView) findViewById(R.id.message_read_icon);
        this.kAo = (TextView) findViewById(R.id.message_read_count);
        this.kAk = (TextView) findViewById(R.id.message_title);
        this.kAp = findViewById(R.id.black_mask);
        this.kAm.setConrers(15);
        this.kAm.setRadius(l.getDimens(this.mContext, R.dimen.tbds21));
        this.kAq = findViewById(R.id.image_container);
        this.kAr = findViewById(R.id.msg_read_container);
        cWY();
    }

    public void cWZ() {
        this.kAm.setRadius(l.getDimens(this.mContext, R.dimen.tbds31));
        this.kAm.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.kAq.getLayoutParams();
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds579);
        this.kAq.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kAr.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.kAr.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.kAk.getLayoutParams();
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.kAk.setLayoutParams(layoutParams3);
    }

    public void cWY() {
        SvgManager.bwq().a(this.kAn, R.drawable.icon_pure_broadcast_read16_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.f.a.b m = com.baidu.tbadk.core.util.f.a.bwU().qq(0).m(R.color.CAM_X0601, R.color.CAM_X0606);
        if (this.kyq) {
            m.bz(this.kAp);
        } else {
            m.ai(l.getDimens(getContext(), R.dimen.tbds21)).ah(l.getDimens(getContext(), R.dimen.tbds21)).bz(this.kAp);
        }
        ao.setViewTextColor(this.kAo, R.color.CAM_X0101);
        ao.setViewTextColor(this.kAk, R.color.CAM_X0101);
    }

    public void setData(a.C0766a c0766a, int i, com.baidu.tieba.im.forum.broadcast.data.b bVar) {
        this.kAm.startLoad(c0766a.src, 10, false);
        this.kAk.setText(c0766a.title);
        if (bVar != null) {
            i = bVar.cXQ();
        }
        Ec(i);
    }

    public void Ec(int i) {
        if (i > 0) {
            this.kAo.setText(this.mContext.getString(R.string.person_view_num, at.dV(i)));
            this.kAo.setVisibility(0);
            this.kAn.setVisibility(0);
            return;
        }
        this.kAo.setVisibility(8);
        this.kAn.setVisibility(8);
    }
}
