package com.baidu.tieba.forumMember.member;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class k extends com.baidu.tieba.frs.k<l, ManagerApplyViewHolder> {
    private static final int jeS = R.id.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.b frx;
    private View.OnClickListener mClickListener;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(k.jeS);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    k.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else {
                    bf.bsY().b((TbPageContext) com.baidu.adp.base.j.J(k.this.mContext), new String[]{tag.toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
    public ManagerApplyViewHolder e(ViewGroup viewGroup) {
        return new ManagerApplyViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.frs_member_manager_apply, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, ManagerApplyViewHolder managerApplyViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) lVar, (l) managerApplyViewHolder);
        if (lVar != null && !lVar.isEmpty() && managerApplyViewHolder != null) {
            if (lVar.isEmpty()) {
                managerApplyViewHolder.mRootLayout.setVisibility(8);
            } else {
                if (managerApplyViewHolder.mSkinType != this.mSkinType) {
                    ap.setViewTextColor(managerApplyViewHolder.jfb, R.color.CAM_X0109, 1);
                    ap.setViewTextColor(managerApplyViewHolder.jfa, R.color.CAM_X0105, 1);
                    ap.setBackgroundResource(managerApplyViewHolder.jfc, R.drawable.frs_member_manito_bg);
                }
                int cBb = lVar.cBb();
                if (cBb > 0) {
                    managerApplyViewHolder.jfb.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), au.numberUniformFormat(cBb)));
                    managerApplyViewHolder.jfc.setTag(jeS, lVar.cBc());
                    managerApplyViewHolder.jfc.setOnClickListener(this.mClickListener);
                    managerApplyViewHolder.jfc.setEnabled(true);
                    managerApplyViewHolder.jfc.setClickable(true);
                } else {
                    managerApplyViewHolder.jfb.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
                    managerApplyViewHolder.jfc.setEnabled(false);
                    managerApplyViewHolder.jfc.setClickable(false);
                }
                managerApplyViewHolder.jfb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                managerApplyViewHolder.mSkinType = this.mSkinType;
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        Activity activity;
        com.baidu.adp.base.f<?> J = com.baidu.adp.base.j.J(this.mContext);
        if (!(J instanceof TbPageContext)) {
            activity = null;
        } else {
            activity = ((TbPageContext) J).getPageActivity();
        }
        if (this.frx == null) {
            this.frx = new com.baidu.tbadk.coreExtra.view.b(activity);
        }
        this.frx.bzD();
        this.frx.setAccountData(accountData);
        this.frx.qE(1);
    }

    public void onDestroy() {
        if (this.frx != null) {
            this.frx.onDestroy();
        }
    }
}
