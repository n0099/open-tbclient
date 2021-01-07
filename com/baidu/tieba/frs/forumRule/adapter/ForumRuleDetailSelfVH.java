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
    public TextView eLt;
    public HeadImageView fio;
    public TextView gFk;
    public TextView jtZ;
    public ImageView jua;
    public TextView jub;
    public TBSpecificationBtn juc;
    public LinearLayout jud;
    public EMTextView jue;
    public EMTextView juf;
    public EMTextView jug;
    private final int juh;
    private View mRootView;

    public ForumRuleDetailSelfVH(View view) {
        super(view);
        this.juh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mRootView = view;
        ap(view);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ap(View view) {
        this.fio = (HeadImageView) view.findViewById(R.id.forum_rules_head_view_info_item);
        this.fio.setRadius(R.dimen.tbds47);
        this.fio.setConrers(15);
        this.eLt = (TextView) view.findViewById(R.id.forum_rules_user_name_info_item);
        this.jtZ = (TextView) view.findViewById(R.id.forum_rules_user_identity_info_item);
        this.jua = (ImageView) view.findViewById(R.id.forum_rules_user_forum_level_info_item);
        this.jub = (TextView) view.findViewById(R.id.forum_rules_bjh_author_auth_info_item);
        this.gFk = (TextView) view.findViewById(R.id.forum_rules_revise);
        this.juc = (TBSpecificationBtn) view.findViewById(R.id.forum_rules_edit_status);
        this.juc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_compile));
        this.jug = (EMTextView) view.findViewById(R.id.forum_rules_check_status);
        this.jug.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_review));
        this.jud = (LinearLayout) view.findViewById(R.id.forum_rules_preface_layout);
        this.jue = (EMTextView) view.findViewById(R.id.forum_rules_preface_title);
        this.juf = (EMTextView) view.findViewById(R.id.forum_rules_preface);
    }

    public void KV(String str) {
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.bwW().qq(0).ae(this.juh).b("TL_BR", R.color.CAM_X0303, R.color.CAM_X0303).bwY(), com.baidu.tbadk.core.util.f.a.b.bwW().qq(0).ae(this.juh).Cq("#4D000000").bwY()});
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(255);
                }
            } else if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(0);
            }
            this.jtZ.setBackgroundDrawable(layerDrawable);
            ao.setViewTextColor(this.jtZ, R.color.CAM_X0101);
        }
    }

    public void AQ(int i) {
        if (i > 0) {
            ao.setImageResource(this.jua, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void KW(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            this.gFk.setVisibility(8);
        } else {
            this.gFk.setText(KU(str));
        }
    }

    public void KX(String str) {
        if (this.juf != null && this.jud != null) {
            if (StringUtils.isNull(str)) {
                this.jud.setVisibility(8);
                return;
            }
            this.juf.setText(str);
            this.jud.setVisibility(0);
        }
    }

    public String KU(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.valueOf(str + "000").longValue()));
    }

    public void AR(int i) {
        if (i == 1) {
            this.juc.setVisibility(8);
            this.jug.setVisibility(0);
            return;
        }
        this.jug.setVisibility(8);
        this.juc.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.bv(this.eLt).pE(R.string.F_X01).pC(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.gFk).pE(R.string.F_X01).pC(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jug).pE(R.string.F_X01).pC(R.color.CAM_X0107);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.juf).pC(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jue).pE(R.string.F_X02).pC(R.color.CAM_X0105);
        ao.setViewTextColor(this.jub, R.color.CAM_X0109);
        if (i == 1 || i == 4) {
            this.fio.setIsNight(true);
        } else {
            this.fio.setIsNight(false);
        }
        this.juc.setTextSize(R.dimen.T_X08);
    }
}
