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
/* loaded from: classes25.dex */
public class OfficialFeedItemImage extends RelativeLayout {
    private boolean jYd;
    private TextView jZY;
    private TbImageView kaa;
    private ImageView kab;
    private TextView kac;
    private View kad;
    private View kae;
    private View kaf;
    private Context mContext;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.jYd = z;
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.kaa = (TbImageView) findViewById(R.id.message_image);
        this.kab = (ImageView) findViewById(R.id.message_read_icon);
        this.kac = (TextView) findViewById(R.id.message_read_count);
        this.jZY = (TextView) findViewById(R.id.message_title);
        this.kad = findViewById(R.id.black_mask);
        this.kaa.setConrers(15);
        this.kaa.setRadius(l.getDimens(this.mContext, R.dimen.tbds21));
        this.kae = findViewById(R.id.image_container);
        this.kaf = findViewById(R.id.msg_read_container);
        cOX();
    }

    public void cOY() {
        this.kaa.setRadius(l.getDimens(this.mContext, R.dimen.tbds31));
        this.kaa.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.kae.getLayoutParams();
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds579);
        this.kae.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kaf.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.kaf.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.jZY.getLayoutParams();
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.jZY.setLayoutParams(layoutParams3);
    }

    public void cOX() {
        SvgManager.bqB().a(this.kab, R.drawable.icon_pure_broadcast_read16_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.e.a.b l = com.baidu.tbadk.core.util.e.a.brc().pF(0).l(R.color.CAM_X0601, R.color.CAM_X0606);
        if (this.jYd) {
            l.bn(this.kad);
        } else {
            l.ag(l.getDimens(getContext(), R.dimen.tbds21)).af(l.getDimens(getContext(), R.dimen.tbds21)).bn(this.kad);
        }
        ap.setViewTextColor(this.kac, R.color.CAM_X0101);
        ap.setViewTextColor(this.jZY, R.color.CAM_X0101);
    }

    public void setData(a.C0766a c0766a, int i, com.baidu.tieba.im.forum.broadcast.data.b bVar) {
        this.kaa.startLoad(c0766a.src, 10, false);
        this.jZY.setText(c0766a.title);
        if (bVar != null) {
            i = bVar.cRf();
        }
        Db(i);
    }

    public void Db(int i) {
        if (i > 0) {
            this.kac.setText(this.mContext.getString(R.string.person_view_num, au.dw(i)));
            this.kac.setVisibility(0);
            this.kab.setVisibility(0);
            return;
        }
        this.kac.setVisibility(8);
        this.kab.setVisibility(8);
    }
}
