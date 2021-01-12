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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class ForumRuleDetailSelfVH extends TypeAdapter.ViewHolder {
    public TextView eGI;
    public HeadImageView fdF;
    public TextView gAE;
    public EMTextView jpA;
    private final int jpB;
    public TextView jpt;
    public ImageView jpu;
    public TextView jpv;
    public TBSpecificationBtn jpw;
    public LinearLayout jpx;
    public EMTextView jpy;
    public EMTextView jpz;
    private View mRootView;

    public ForumRuleDetailSelfVH(View view) {
        super(view);
        this.jpB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mRootView = view;
        ap(view);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ap(View view) {
        this.fdF = (HeadImageView) view.findViewById(R.id.forum_rules_head_view_info_item);
        this.fdF.setRadius(R.dimen.tbds47);
        this.fdF.setConrers(15);
        this.eGI = (TextView) view.findViewById(R.id.forum_rules_user_name_info_item);
        this.jpt = (TextView) view.findViewById(R.id.forum_rules_user_identity_info_item);
        this.jpu = (ImageView) view.findViewById(R.id.forum_rules_user_forum_level_info_item);
        this.jpv = (TextView) view.findViewById(R.id.forum_rules_bjh_author_auth_info_item);
        this.gAE = (TextView) view.findViewById(R.id.forum_rules_revise);
        this.jpw = (TBSpecificationBtn) view.findViewById(R.id.forum_rules_edit_status);
        this.jpw.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_compile));
        this.jpA = (EMTextView) view.findViewById(R.id.forum_rules_check_status);
        this.jpA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_review));
        this.jpx = (LinearLayout) view.findViewById(R.id.forum_rules_preface_layout);
        this.jpy = (EMTextView) view.findViewById(R.id.forum_rules_preface_title);
        this.jpz = (EMTextView) view.findViewById(R.id.forum_rules_preface);
    }

    public void JL(String str) {
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.btc().oJ(0).ae(this.jpB).b("TL_BR", R.color.CAM_X0303, R.color.CAM_X0303).bte(), com.baidu.tbadk.core.util.f.a.b.btc().oJ(0).ae(this.jpB).Bf("#4D000000").bte()});
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(255);
                }
            } else if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(0);
            }
            this.jpt.setBackgroundDrawable(layerDrawable);
            ao.setViewTextColor(this.jpt, R.color.CAM_X0101);
        }
    }

    public void zk(int i) {
        if (i > 0) {
            ao.setImageResource(this.jpu, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void JM(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            this.gAE.setVisibility(8);
        } else {
            this.gAE.setText(JK(str));
        }
    }

    public void JN(String str) {
        if (this.jpz != null && this.jpx != null) {
            if (StringUtils.isNull(str)) {
                this.jpx.setVisibility(8);
                return;
            }
            this.jpz.setText(str);
            this.jpx.setVisibility(0);
        }
    }

    public String JK(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.valueOf(str + "000").longValue()));
    }

    public void zl(int i) {
        if (i == 1) {
            this.jpw.setVisibility(8);
            this.jpA.setVisibility(0);
            return;
        }
        this.jpA.setVisibility(8);
        this.jpw.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.bv(this.eGI).nX(R.string.F_X01).nV(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.gAE).nX(R.string.F_X01).nV(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jpA).nX(R.string.F_X01).nV(R.color.CAM_X0107);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jpz).nV(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jpy).nX(R.string.F_X02).nV(R.color.CAM_X0105);
        ao.setViewTextColor(this.jpv, R.color.CAM_X0109);
        if (i == 1 || i == 4) {
            this.fdF.setIsNight(true);
        } else {
            this.fdF.setIsNight(false);
        }
        this.jpw.setTextSize(R.dimen.T_X08);
    }
}
