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
    private boolean jRw;
    private TextView jTs;
    private TbImageView jTu;
    private ImageView jTv;
    private TextView jTw;
    private View jTx;
    private View jTy;
    private View jTz;
    private Context mContext;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.jRw = z;
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.jTu = (TbImageView) findViewById(R.id.message_image);
        this.jTv = (ImageView) findViewById(R.id.message_read_icon);
        this.jTw = (TextView) findViewById(R.id.message_read_count);
        this.jTs = (TextView) findViewById(R.id.message_title);
        this.jTx = findViewById(R.id.black_mask);
        this.jTu.setConrers(15);
        this.jTu.setRadius(l.getDimens(this.mContext, R.dimen.tbds21));
        this.jTy = findViewById(R.id.image_container);
        this.jTz = findViewById(R.id.msg_read_container);
        cMQ();
    }

    public void cMR() {
        this.jTu.setRadius(l.getDimens(this.mContext, R.dimen.tbds31));
        this.jTu.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.jTy.getLayoutParams();
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds579);
        this.jTy.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jTz.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.jTz.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.jTs.getLayoutParams();
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds27);
        this.jTs.setLayoutParams(layoutParams3);
    }

    public void cMQ() {
        SvgManager.boN().a(this.jTv, R.drawable.icon_pure_broadcast_read16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.e.a.b i = com.baidu.tbadk.core.util.e.a.bpo().oZ(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42);
        if (this.jRw) {
            i.bg(this.jTx);
        } else {
            i.ad(l.getDimens(getContext(), R.dimen.tbds21)).ac(l.getDimens(getContext(), R.dimen.tbds21)).bg(this.jTx);
        }
        ap.setViewTextColor(this.jTw, R.color.cp_cont_a);
        ap.setViewTextColor(this.jTs, R.color.cp_cont_a);
    }

    public void setData(a.C0750a c0750a, int i, com.baidu.tieba.im.forum.broadcast.data.b bVar) {
        this.jTu.startLoad(c0750a.src, 10, false);
        this.jTs.setText(c0750a.title);
        if (bVar != null) {
            i = bVar.cOY();
        }
        Cq(i);
    }

    public void Cq(int i) {
        if (i > 0) {
            this.jTw.setText(this.mContext.getString(R.string.person_view_num, at.da(i)));
            this.jTw.setVisibility(0);
            this.jTv.setVisibility(0);
            return;
        }
        this.jTw.setVisibility(8);
        this.jTv.setVisibility(8);
    }
}
