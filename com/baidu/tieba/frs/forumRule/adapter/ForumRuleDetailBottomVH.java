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
    public View fJE;
    public BarImageView jtI;
    public ImageView jtJ;
    public EMTextView jtK;
    public EMTextView jtL;
    public HeadImageView jtM;
    public EMTextView jtN;
    public EMTextView jtO;
    private View mRootView;

    public ForumRuleDetailBottomVH(View view) {
        super(view);
        this.mRootView = view;
        this.jtI = (BarImageView) view.findViewById(R.id.forum_rules_bar_management_head_view);
        this.jtI.setShowOval(true);
        this.jtI.setShowOuterBorder(false);
        this.jtI.setShowInnerBorder(true);
        this.jtI.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.jtI.setStrokeColorResId(R.color.CAM_X0401);
        this.jtJ = (ImageView) view.findViewById(R.id.forum_rules_bar_management_index);
        this.jtK = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_title);
        this.jtL = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_time_revise);
        this.jtM = (HeadImageView) view.findViewById(R.id.forum_rules_charger_of_bar_head_view);
        this.jtM.setBorderWidth(R.dimen.L_X01);
        this.jtM.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.jtM.setRadius(R.dimen.tbds42);
        this.jtM.setConrers(15);
        this.jtN = (EMTextView) view.findViewById(R.id.forum_rules_charger_of_bar_title);
        this.jtO = (EMTextView) view.findViewById(R.id.forum_rules_time_revise);
        this.fJE = view.findViewById(R.id.cross_line);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void KU(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            this.jtO.setVisibility(8);
            this.jtL.setVisibility(8);
            return;
        }
        this.jtO.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), KV(str)));
        this.jtL.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), KV(str)));
    }

    public String KV(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.valueOf(str + "000").longValue()));
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jtK).pE(R.string.F_X01).pC(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jtL).pE(R.string.F_X01).pC(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jtN).pE(R.string.F_X01).pC(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jtO).pE(R.string.F_X01).pC(R.color.CAM_X0109);
        this.jtJ.setImageDrawable(WebPManager.a(R.drawable.icon_mask_pb_barservice14, WebPManager.ResourceStateType.NORMAL));
        if (i == 4 || i == 1) {
            this.jtM.setIsNight(true);
        } else {
            this.jtM.setIsNight(false);
        }
        ao.setBackgroundColor(this.fJE, R.color.CAM_X0111);
    }
}
