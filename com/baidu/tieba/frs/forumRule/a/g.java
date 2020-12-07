package com.baidu.tieba.frs.forumRule.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.data.Config;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes22.dex */
public class g extends af.a {
    public TextView eBQ;
    public HeadImageView eYM;
    public TextView guj;
    public TBSpecificationBtn jhA;
    public LinearLayout jhB;
    public EMTextView jhC;
    public EMTextView jhD;
    public EMTextView jhE;
    private final int jhF;
    public TextView jhx;
    public ImageView jhy;
    public TextView jhz;
    private View mRootView;

    public g(View view) {
        super(view);
        this.jhF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mRootView = view;
        an(view);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void an(View view) {
        this.eYM = (HeadImageView) view.findViewById(R.id.forum_rules_head_view_info_item);
        this.eYM.setRadius(R.dimen.tbds47);
        this.eYM.setConrers(15);
        this.eBQ = (TextView) view.findViewById(R.id.forum_rules_user_name_info_item);
        this.jhx = (TextView) view.findViewById(R.id.forum_rules_user_identity_info_item);
        this.jhy = (ImageView) view.findViewById(R.id.forum_rules_user_forum_level_info_item);
        this.jhz = (TextView) view.findViewById(R.id.forum_rules_bjh_author_auth_info_item);
        this.guj = (TextView) view.findViewById(R.id.forum_rules_revise);
        this.jhA = (TBSpecificationBtn) view.findViewById(R.id.forum_rules_edit_status);
        this.jhA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_compile));
        this.jhE = (EMTextView) view.findViewById(R.id.forum_rules_check_status);
        this.jhE.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_review));
        this.jhB = (LinearLayout) view.findViewById(R.id.forum_rules_preface_layout);
        this.jhC = (EMTextView) view.findViewById(R.id.forum_rules_preface_title);
        this.jhD = (EMTextView) view.findViewById(R.id.forum_rules_preface);
    }

    public void KW(String str) {
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.buA().qf(0).ac(this.jhF).b("TL_BR", R.color.CAM_X0303, R.color.CAM_X0303).buC(), com.baidu.tbadk.core.util.e.a.b.buA().qf(0).ac(this.jhF).Ct("#4D000000").buC()});
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(255);
                }
            } else if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(0);
            }
            this.jhx.setBackgroundDrawable(layerDrawable);
            ap.setViewTextColor(this.jhx, R.color.CAM_X0101);
        }
    }

    public void AE(int i) {
        if (i > 0) {
            ap.setImageResource(this.jhy, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void KX(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            this.guj.setVisibility(8);
        } else {
            this.guj.setText(KV(str));
        }
    }

    public void KY(String str) {
        if (this.jhD != null && this.jhB != null) {
            if (StringUtils.isNull(str)) {
                this.jhB.setVisibility(8);
                return;
            }
            this.jhD.setText(str);
            this.jhB.setVisibility(0);
        }
    }

    public String KV(String str) {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date(Long.valueOf(str + "000").longValue()));
    }

    public void AF(int i) {
        if (i == 1) {
            this.jhA.setVisibility(8);
            this.jhE.setVisibility(0);
            return;
        }
        this.jhE.setVisibility(8);
        this.jhA.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.bm(this.eBQ).pu(R.string.F_X01).ps(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.guj).pu(R.string.F_X01).ps(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jhE).pu(R.string.F_X01).ps(R.color.CAM_X0107);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jhD).ps(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jhC).pu(R.string.F_X02).ps(R.color.CAM_X0105);
        ap.setViewTextColor(this.jhz, R.color.CAM_X0109);
        if (i == 1 || i == 4) {
            this.eYM.setIsNight(true);
        } else {
            this.eYM.setIsNight(false);
        }
        this.jhA.setTextSize(R.dimen.T_X08);
    }
}
