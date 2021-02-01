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
    public BarImageView juI;
    public ImageView juJ;
    public EMTextView juK;
    public EMTextView juL;
    public HeadImageView juM;
    public EMTextView juN;
    public EMTextView juO;
    private View mRootView;

    public ForumRuleDetailBottomVH(View view) {
        super(view);
        this.mRootView = view;
        this.juI = (BarImageView) view.findViewById(R.id.forum_rules_bar_management_head_view);
        this.juI.setShowOval(true);
        this.juI.setShowOuterBorder(false);
        this.juI.setShowInnerBorder(true);
        this.juI.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.juI.setStrokeColorResId(R.color.CAM_X0401);
        this.juJ = (ImageView) view.findViewById(R.id.forum_rules_bar_management_index);
        this.juK = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_title);
        this.juL = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_time_revise);
        this.juM = (HeadImageView) view.findViewById(R.id.forum_rules_charger_of_bar_head_view);
        this.juM.setBorderWidth(R.dimen.L_X01);
        this.juM.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.juM.setRadius(R.dimen.tbds42);
        this.juM.setConrers(15);
        this.juN = (EMTextView) view.findViewById(R.id.forum_rules_charger_of_bar_title);
        this.juO = (EMTextView) view.findViewById(R.id.forum_rules_time_revise);
        this.fHj = view.findViewById(R.id.cross_line);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Ku(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            this.juO.setVisibility(8);
            this.juL.setVisibility(8);
            return;
        }
        this.juO.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), Kv(str)));
        this.juL.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), Kv(str)));
    }

    public String Kv(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.valueOf(str + "000").longValue()));
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        com.baidu.tbadk.core.elementsMaven.c.br(this.juK).oa(R.string.F_X01).nY(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(this.juL).oa(R.string.F_X01).nY(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.br(this.juN).oa(R.string.F_X01).nY(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(this.juO).oa(R.string.F_X01).nY(R.color.CAM_X0109);
        this.juJ.setImageDrawable(WebPManager.a(R.drawable.icon_mask_pb_barservice14, WebPManager.ResourceStateType.NORMAL));
        if (i == 4 || i == 1) {
            this.juM.setIsNight(true);
        } else {
            this.juM.setIsNight(false);
        }
        ap.setBackgroundColor(this.fHj, R.color.CAM_X0111);
    }
}
