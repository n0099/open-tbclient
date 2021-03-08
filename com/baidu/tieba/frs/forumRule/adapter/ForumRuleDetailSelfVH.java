package com.baidu.tieba.frs.forumRule.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class ForumRuleDetailSelfVH extends TypeAdapter.ViewHolder {
    public TextView eKp;
    public HeadImageView fht;
    public TextView gFl;
    public TextView jwW;
    public ImageView jwX;
    public TextView jwY;
    public TBSpecificationBtn jwZ;
    public LinearLayout jxa;
    public EMTextView jxb;
    public EMTextView jxc;
    public EMTextView jxd;
    private final int jxe;
    private View mRootView;

    public ForumRuleDetailSelfVH(View view) {
        super(view);
        this.jxe = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mRootView = view;
        am(view);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void am(View view) {
        this.fht = (HeadImageView) view.findViewById(R.id.forum_rules_head_view_info_item);
        this.fht.setRadius(R.dimen.tbds47);
        this.fht.setConrers(15);
        this.eKp = (TextView) view.findViewById(R.id.forum_rules_user_name_info_item);
        this.jwW = (TextView) view.findViewById(R.id.forum_rules_user_identity_info_item);
        this.jwX = (ImageView) view.findViewById(R.id.forum_rules_user_forum_level_info_item);
        this.jwY = (TextView) view.findViewById(R.id.forum_rules_bjh_author_auth_info_item);
        this.gFl = (TextView) view.findViewById(R.id.forum_rules_revise);
        this.jwZ = (TBSpecificationBtn) view.findViewById(R.id.forum_rules_edit_status);
        this.jwZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_compile));
        this.jxd = (EMTextView) view.findViewById(R.id.forum_rules_check_status);
        this.jxd.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_review));
        this.jxa = (LinearLayout) view.findViewById(R.id.forum_rules_preface_layout);
        this.jxb = (EMTextView) view.findViewById(R.id.forum_rules_preface_title);
        this.jxc = (EMTextView) view.findViewById(R.id.forum_rules_preface);
    }

    public void KG(String str) {
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.btz().oP(0).aj(this.jxe).b("TL_BR", R.color.CAM_X0303, R.color.CAM_X0303).btB(), com.baidu.tbadk.core.util.f.a.b.btz().oP(0).aj(this.jxe).BD("#4D000000").btB()});
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(255);
                }
            } else if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(0);
            }
            this.jwW.setBackgroundDrawable(layerDrawable);
            ap.setViewTextColor(this.jwW, R.color.CAM_X0101);
        }
    }

    public void zv(int i) {
        if (i > 0) {
            ap.setImageResource(this.jwX, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void KH(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            this.gFl.setVisibility(8);
        } else {
            this.gFl.setText(KF(str));
        }
    }

    public void KI(String str) {
        if (this.jxc != null && this.jxa != null) {
            if (StringUtils.isNull(str)) {
                this.jxa.setVisibility(8);
                return;
            }
            this.jxc.setText(str);
            this.jxa.setVisibility(0);
        }
    }

    public String KF(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.valueOf(str + "000").longValue()));
    }

    public void zw(int i) {
        if (i == 1) {
            this.jwZ.setVisibility(8);
            this.jxd.setVisibility(0);
            return;
        }
        this.jxd.setVisibility(8);
        this.jwZ.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.br(this.eKp).ob(R.string.F_X01).nZ(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(this.gFl).ob(R.string.F_X01).nZ(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jxd).ob(R.string.F_X01).nZ(R.color.CAM_X0107);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jxc).nZ(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jxb).ob(R.string.F_X02).nZ(R.color.CAM_X0105);
        ap.setViewTextColor(this.jwY, R.color.CAM_X0109);
        if (i == 1 || i == 4) {
            this.fht.setIsNight(true);
        } else {
            this.fht.setIsNight(false);
        }
        this.jwZ.setTextSize(R.dimen.T_X08);
    }
}
