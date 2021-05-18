package com.baidu.tieba.frs.brand.relationbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import tbclient.OriForumInfo;
/* loaded from: classes4.dex */
public class RelationBarCellView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f15352e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f15353f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15354g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15355h;

    /* renamed from: i  reason: collision with root package name */
    public int f15356i;
    public int j;
    public OriForumInfo k;

    public RelationBarCellView(Context context) {
        super(context);
        this.f15352e = 3;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_brand_relation_bar_cell_layout, (ViewGroup) this, true);
        this.f15353f = (TbImageView) findViewById(R.id.frs_brand_bar_cell_img);
        this.f15354g = (TextView) findViewById(R.id.frs_brand_bar_cell_name);
        this.f15355h = (TextView) findViewById(R.id.frs_brand_bar_cell_attention);
        this.f15353f.setDefaultResource(17170445);
        this.f15353f.setDefaultBgResource(R.color.CAM_X0205);
        this.f15353f.setBorderColor(0);
        this.f15353f.setRadius(l.g(getContext(), R.dimen.tbds20));
        this.f15353f.setConrers(5);
        this.f15356i = l.g(context, R.dimen.tbds471);
        this.j = l.g(context, R.dimen.tbds164);
        setOnClickListener(this);
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f15352e) {
            return;
        }
        this.f15352e = skinType;
        SkinManager.setBackgroundResource(this, R.drawable.cp_bg_line_d_e_selector);
        SkinManager.setViewTextColor(this.f15354g, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f15355h, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new StatisticItem("c13110").param("obj_id", this.k.ori_fid.longValue()));
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getContext()).createNormalCfg(this.k.ori_fname, "")));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(this.f15356i, this.j);
    }

    public void setData(OriForumInfo oriForumInfo) {
        if (oriForumInfo == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.k = oriForumInfo;
        this.f15353f.V(oriForumInfo.ori_avatar, 10, false);
        this.f15354g.setText(oriForumInfo.ori_fname);
        this.f15355h.setText(String.format(getContext().getString(R.string.frs_brand_relation_bar_attention), StringHelper.numFormatOverWanNa(oriForumInfo.ori_member_num.longValue())));
    }

    public RelationBarCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15352e = 3;
        a(context);
    }

    public RelationBarCellView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15352e = 3;
        a(context);
    }
}
