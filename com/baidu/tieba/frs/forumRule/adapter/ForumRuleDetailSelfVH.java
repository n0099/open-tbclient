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
    public TextView gDC;
    public TextView jvn;
    public ImageView jvo;
    public TextView jvp;
    public TBSpecificationBtn jvq;
    public LinearLayout jvr;
    public EMTextView jvs;
    public EMTextView jvt;
    public EMTextView jvu;
    private final int jvv;
    private View mRootView;

    public ForumRuleDetailSelfVH(View view) {
        super(view);
        this.jvv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mRootView = view;
        am(view);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void am(View view) {
        this.ffU = (HeadImageView) view.findViewById(R.id.forum_rules_head_view_info_item);
        this.ffU.setRadius(R.dimen.tbds47);
        this.ffU.setConrers(15);
        this.eIO = (TextView) view.findViewById(R.id.forum_rules_user_name_info_item);
        this.jvn = (TextView) view.findViewById(R.id.forum_rules_user_identity_info_item);
        this.jvo = (ImageView) view.findViewById(R.id.forum_rules_user_forum_level_info_item);
        this.jvp = (TextView) view.findViewById(R.id.forum_rules_bjh_author_auth_info_item);
        this.gDC = (TextView) view.findViewById(R.id.forum_rules_revise);
        this.jvq = (TBSpecificationBtn) view.findViewById(R.id.forum_rules_edit_status);
        this.jvq.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_compile));
        this.jvu = (EMTextView) view.findViewById(R.id.forum_rules_check_status);
        this.jvu.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_review));
        this.jvr = (LinearLayout) view.findViewById(R.id.forum_rules_preface_layout);
        this.jvs = (EMTextView) view.findViewById(R.id.forum_rules_preface_title);
        this.jvt = (EMTextView) view.findViewById(R.id.forum_rules_preface);
    }

    public void Kx(String str) {
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.btw().oO(0).af(this.jvv).b("TL_BR", R.color.CAM_X0303, R.color.CAM_X0303).bty(), com.baidu.tbadk.core.util.f.a.b.btw().oO(0).af(this.jvv).Bw("#4D000000").bty()});
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(255);
                }
            } else if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(0);
            }
            this.jvn.setBackgroundDrawable(layerDrawable);
            ap.setViewTextColor(this.jvn, R.color.CAM_X0101);
        }
    }

    public void zu(int i) {
        if (i > 0) {
            ap.setImageResource(this.jvo, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void Ky(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            this.gDC.setVisibility(8);
        } else {
            this.gDC.setText(Kw(str));
        }
    }

    public void Kz(String str) {
        if (this.jvt != null && this.jvr != null) {
            if (StringUtils.isNull(str)) {
                this.jvr.setVisibility(8);
                return;
            }
            this.jvt.setText(str);
            this.jvr.setVisibility(0);
        }
    }

    public String Kw(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.valueOf(str + "000").longValue()));
    }

    public void zv(int i) {
        if (i == 1) {
            this.jvq.setVisibility(8);
            this.jvu.setVisibility(0);
            return;
        }
        this.jvu.setVisibility(8);
        this.jvq.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.br(this.eIO).oa(R.string.F_X01).nY(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(this.gDC).oa(R.string.F_X01).nY(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jvu).oa(R.string.F_X01).nY(R.color.CAM_X0107);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jvt).nY(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jvs).oa(R.string.F_X02).nY(R.color.CAM_X0105);
        ap.setViewTextColor(this.jvp, R.color.CAM_X0109);
        if (i == 1 || i == 4) {
            this.ffU.setIsNight(true);
        } else {
            this.ffU.setIsNight(false);
        }
        this.jvq.setTextSize(R.dimen.T_X08);
    }
}
