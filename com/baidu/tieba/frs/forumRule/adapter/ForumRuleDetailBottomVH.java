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
    public View fII;
    public BarImageView jwF;
    public ImageView jwG;
    public EMTextView jwH;
    public EMTextView jwI;
    public HeadImageView jwJ;
    public EMTextView jwK;
    public EMTextView jwL;
    private View mRootView;

    public ForumRuleDetailBottomVH(View view) {
        super(view);
        this.mRootView = view;
        this.jwF = (BarImageView) view.findViewById(R.id.forum_rules_bar_management_head_view);
        this.jwF.setShowOval(true);
        this.jwF.setShowOuterBorder(false);
        this.jwF.setShowInnerBorder(true);
        this.jwF.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.jwF.setStrokeColorResId(R.color.CAM_X0401);
        this.jwG = (ImageView) view.findViewById(R.id.forum_rules_bar_management_index);
        this.jwH = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_title);
        this.jwI = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_time_revise);
        this.jwJ = (HeadImageView) view.findViewById(R.id.forum_rules_charger_of_bar_head_view);
        this.jwJ.setBorderWidth(R.dimen.L_X01);
        this.jwJ.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.jwJ.setRadius(R.dimen.tbds42);
        this.jwJ.setConrers(15);
        this.jwK = (EMTextView) view.findViewById(R.id.forum_rules_charger_of_bar_title);
        this.jwL = (EMTextView) view.findViewById(R.id.forum_rules_time_revise);
        this.fII = view.findViewById(R.id.cross_line);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void KE(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            this.jwL.setVisibility(8);
            this.jwI.setVisibility(8);
            return;
        }
        this.jwL.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), KF(str)));
        this.jwI.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), KF(str)));
    }

    public String KF(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.valueOf(str + "000").longValue()));
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jwH).ob(R.string.F_X01).nZ(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jwI).ob(R.string.F_X01).nZ(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jwK).ob(R.string.F_X01).nZ(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jwL).ob(R.string.F_X01).nZ(R.color.CAM_X0109);
        this.jwG.setImageDrawable(WebPManager.a(R.drawable.icon_mask_pb_barservice14, WebPManager.ResourceStateType.NORMAL));
        if (i == 4 || i == 1) {
            this.jwJ.setIsNight(true);
        } else {
            this.jwJ.setIsNight(false);
        }
        ap.setBackgroundColor(this.fII, R.color.CAM_X0111);
    }
}
