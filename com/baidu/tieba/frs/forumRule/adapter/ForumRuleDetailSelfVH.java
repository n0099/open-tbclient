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
    public TextView eIO;
    public HeadImageView ffU;
    public TextView gDo;
    public TextView juZ;
    public ImageView jva;
    public TextView jvb;
    public TBSpecificationBtn jvc;
    public LinearLayout jvd;
    public EMTextView jve;
    public EMTextView jvf;
    public EMTextView jvg;
    private final int jvh;
    private View mRootView;

    public ForumRuleDetailSelfVH(View view) {
        super(view);
        this.jvh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mRootView = view;
        am(view);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void am(View view) {
        this.ffU = (HeadImageView) view.findViewById(R.id.forum_rules_head_view_info_item);
        this.ffU.setRadius(R.dimen.tbds47);
        this.ffU.setConrers(15);
        this.eIO = (TextView) view.findViewById(R.id.forum_rules_user_name_info_item);
        this.juZ = (TextView) view.findViewById(R.id.forum_rules_user_identity_info_item);
        this.jva = (ImageView) view.findViewById(R.id.forum_rules_user_forum_level_info_item);
        this.jvb = (TextView) view.findViewById(R.id.forum_rules_bjh_author_auth_info_item);
        this.gDo = (TextView) view.findViewById(R.id.forum_rules_revise);
        this.jvc = (TBSpecificationBtn) view.findViewById(R.id.forum_rules_edit_status);
        this.jvc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_compile));
        this.jvg = (EMTextView) view.findViewById(R.id.forum_rules_check_status);
        this.jvg.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_review));
        this.jvd = (LinearLayout) view.findViewById(R.id.forum_rules_preface_layout);
        this.jve = (EMTextView) view.findViewById(R.id.forum_rules_preface_title);
        this.jvf = (EMTextView) view.findViewById(R.id.forum_rules_preface);
    }

    public void Kw(String str) {
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.btw().oO(0).af(this.jvh).b("TL_BR", R.color.CAM_X0303, R.color.CAM_X0303).bty(), com.baidu.tbadk.core.util.f.a.b.btw().oO(0).af(this.jvh).Bw("#4D000000").bty()});
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(255);
                }
            } else if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(0);
            }
            this.juZ.setBackgroundDrawable(layerDrawable);
            ap.setViewTextColor(this.juZ, R.color.CAM_X0101);
        }
    }

    public void zu(int i) {
        if (i > 0) {
            ap.setImageResource(this.jva, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void Kx(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            this.gDo.setVisibility(8);
        } else {
            this.gDo.setText(Kv(str));
        }
    }

    public void Ky(String str) {
        if (this.jvf != null && this.jvd != null) {
            if (StringUtils.isNull(str)) {
                this.jvd.setVisibility(8);
                return;
            }
            this.jvf.setText(str);
            this.jvd.setVisibility(0);
        }
    }

    public String Kv(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.valueOf(str + "000").longValue()));
    }

    public void zv(int i) {
        if (i == 1) {
            this.jvc.setVisibility(8);
            this.jvg.setVisibility(0);
            return;
        }
        this.jvg.setVisibility(8);
        this.jvc.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.br(this.eIO).oa(R.string.F_X01).nY(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(this.gDo).oa(R.string.F_X01).nY(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jvg).oa(R.string.F_X01).nY(R.color.CAM_X0107);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jvf).nY(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jve).oa(R.string.F_X02).nY(R.color.CAM_X0105);
        ap.setViewTextColor(this.jvb, R.color.CAM_X0109);
        if (i == 1 || i == 4) {
            this.ffU.setIsNight(true);
        } else {
            this.ffU.setIsNight(false);
        }
        this.jvc.setTextSize(R.dimen.T_X08);
    }
}
