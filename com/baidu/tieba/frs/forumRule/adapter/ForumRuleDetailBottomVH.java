package com.baidu.tieba.frs.forumRule.adapter;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class ForumRuleDetailBottomVH extends TypeAdapter.ViewHolder {
    public View fHj;
    public BarImageView juW;
    public ImageView juX;
    public EMTextView juY;
    public EMTextView juZ;
    public HeadImageView jva;
    public EMTextView jvb;
    public EMTextView jvc;
    private View mRootView;

    public ForumRuleDetailBottomVH(View view) {
        super(view);
        this.mRootView = view;
        this.juW = (BarImageView) view.findViewById(R.id.forum_rules_bar_management_head_view);
        this.juW.setShowOval(true);
        this.juW.setShowOuterBorder(false);
        this.juW.setShowInnerBorder(true);
        this.juW.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.juW.setStrokeColorResId(R.color.CAM_X0401);
        this.juX = (ImageView) view.findViewById(R.id.forum_rules_bar_management_index);
        this.juY = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_title);
        this.juZ = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_time_revise);
        this.jva = (HeadImageView) view.findViewById(R.id.forum_rules_charger_of_bar_head_view);
        this.jva.setBorderWidth(R.dimen.L_X01);
        this.jva.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.jva.setRadius(R.dimen.tbds42);
        this.jva.setConrers(15);
        this.jvb = (EMTextView) view.findViewById(R.id.forum_rules_charger_of_bar_title);
        this.jvc = (EMTextView) view.findViewById(R.id.forum_rules_time_revise);
        this.fHj = view.findViewById(R.id.cross_line);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Kv(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            this.jvc.setVisibility(8);
            this.juZ.setVisibility(8);
            return;
        }
        this.jvc.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), Kw(str)));
        this.juZ.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), Kw(str)));
    }

    public String Kw(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.valueOf(str + "000").longValue()));
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        com.baidu.tbadk.core.elementsMaven.c.br(this.juY).oa(R.string.F_X01).nY(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(this.juZ).oa(R.string.F_X01).nY(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jvb).oa(R.string.F_X01).nY(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jvc).oa(R.string.F_X01).nY(R.color.CAM_X0109);
        this.juX.setImageDrawable(WebPManager.a(R.drawable.icon_mask_pb_barservice14, WebPManager.ResourceStateType.NORMAL));
        if (i == 4 || i == 1) {
            this.jva.setIsNight(true);
        } else {
            this.jva.setIsNight(false);
        }
        ap.setBackgroundColor(this.fHj, R.color.CAM_X0111);
    }
}
