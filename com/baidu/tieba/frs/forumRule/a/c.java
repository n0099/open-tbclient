package com.baidu.tieba.frs.forumRule.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
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
/* loaded from: classes22.dex */
public class c extends af.a {
    public View fzY;
    public BarImageView jhi;
    public ImageView jhj;
    public EMTextView jhk;
    public EMTextView jhl;
    public HeadImageView jhm;
    public EMTextView jhn;
    public EMTextView jho;
    private View mRootView;

    public c(View view) {
        super(view);
        this.mRootView = view;
        this.jhi = (BarImageView) view.findViewById(R.id.forum_rules_bar_management_head_view);
        this.jhi.setShowOval(true);
        this.jhi.setShowOuterBorder(false);
        this.jhi.setShowInnerBorder(true);
        this.jhi.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.jhi.setStrokeColorResId(R.color.CAM_X0401);
        this.jhj = (ImageView) view.findViewById(R.id.forum_rules_bar_management_index);
        this.jhk = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_title);
        this.jhl = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_time_revise);
        this.jhm = (HeadImageView) view.findViewById(R.id.forum_rules_charger_of_bar_head_view);
        this.jhm.setBorderWidth(R.dimen.L_X01);
        this.jhm.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.jhm.setRadius(R.dimen.tbds42);
        this.jhm.setConrers(15);
        this.jhn = (EMTextView) view.findViewById(R.id.forum_rules_charger_of_bar_title);
        this.jho = (EMTextView) view.findViewById(R.id.forum_rules_time_revise);
        this.fzY = view.findViewById(R.id.cross_line);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void KU(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            this.jho.setVisibility(8);
            this.jhl.setVisibility(8);
            return;
        }
        this.jho.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), KV(str)));
        this.jhl.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), KV(str)));
    }

    public String KV(String str) {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date(Long.valueOf(str + "000").longValue()));
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jhk).pu(R.string.F_X01).ps(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jhl).pu(R.string.F_X01).ps(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jhn).pu(R.string.F_X01).ps(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jho).pu(R.string.F_X01).ps(R.color.CAM_X0109);
        this.jhj.setImageDrawable(WebPManager.a(R.drawable.icon_mask_pb_barservice14, WebPManager.ResourceStateType.NORMAL));
        if (i == 4 || i == 1) {
            this.jhm.setIsNight(true);
        } else {
            this.jhm.setIsNight(false);
        }
        ap.setBackgroundColor(this.fzY, R.color.CAM_X0111);
    }
}
