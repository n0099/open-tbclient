package com.baidu.tieba.frs.forumRule.adapter;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class ForumRuleDetailBottomVH extends TypeAdapter.ViewHolder {
    public View fEX;
    public BarImageView jpc;
    public ImageView jpd;
    public EMTextView jpe;
    public EMTextView jpf;
    public HeadImageView jpg;
    public EMTextView jph;
    public EMTextView jpi;
    private View mRootView;

    public ForumRuleDetailBottomVH(View view) {
        super(view);
        this.mRootView = view;
        this.jpc = (BarImageView) view.findViewById(R.id.forum_rules_bar_management_head_view);
        this.jpc.setShowOval(true);
        this.jpc.setShowOuterBorder(false);
        this.jpc.setShowInnerBorder(true);
        this.jpc.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.jpc.setStrokeColorResId(R.color.CAM_X0401);
        this.jpd = (ImageView) view.findViewById(R.id.forum_rules_bar_management_index);
        this.jpe = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_title);
        this.jpf = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_time_revise);
        this.jpg = (HeadImageView) view.findViewById(R.id.forum_rules_charger_of_bar_head_view);
        this.jpg.setBorderWidth(R.dimen.L_X01);
        this.jpg.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.jpg.setRadius(R.dimen.tbds42);
        this.jpg.setConrers(15);
        this.jph = (EMTextView) view.findViewById(R.id.forum_rules_charger_of_bar_title);
        this.jpi = (EMTextView) view.findViewById(R.id.forum_rules_time_revise);
        this.fEX = view.findViewById(R.id.cross_line);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void JJ(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            this.jpi.setVisibility(8);
            this.jpf.setVisibility(8);
            return;
        }
        this.jpi.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), JK(str)));
        this.jpf.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), JK(str)));
    }

    public String JK(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.valueOf(str + "000").longValue()));
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jpe).nX(R.string.F_X01).nV(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jpf).nX(R.string.F_X01).nV(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jph).nX(R.string.F_X01).nV(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jpi).nX(R.string.F_X01).nV(R.color.CAM_X0109);
        this.jpd.setImageDrawable(WebPManager.a(R.drawable.icon_mask_pb_barservice14, WebPManager.ResourceStateType.NORMAL));
        if (i == 4 || i == 1) {
            this.jpg.setIsNight(true);
        } else {
            this.jpg.setIsNight(false);
        }
        ao.setBackgroundColor(this.fEX, R.color.CAM_X0111);
    }
}
