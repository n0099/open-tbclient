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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class k extends com.baidu.tieba.frs.k<l, ManagerApplyViewHolder> {
    private static final int iXo = R.id.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.b fnD;
    private View.OnClickListener mClickListener;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(k.iXo);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    k.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else {
                    be.bsB().b((TbPageContext) com.baidu.adp.base.j.K(k.this.mContext), new String[]{tag.toString()});
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
                    ao.setViewTextColor(managerApplyViewHolder.iXx, R.color.CAM_X0109, 1);
                    ao.setViewTextColor(managerApplyViewHolder.iXw, R.color.CAM_X0105, 1);
                    ao.setBackgroundResource(managerApplyViewHolder.iXy, R.drawable.frs_member_manito_bg);
                }
                int czD = lVar.czD();
                if (czD > 0) {
                    managerApplyViewHolder.iXx.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), at.numberUniformFormat(czD)));
                    managerApplyViewHolder.iXy.setTag(iXo, lVar.czE());
                    managerApplyViewHolder.iXy.setOnClickListener(this.mClickListener);
                    managerApplyViewHolder.iXy.setEnabled(true);
                    managerApplyViewHolder.iXy.setClickable(true);
                } else {
                    managerApplyViewHolder.iXx.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
                    managerApplyViewHolder.iXy.setEnabled(false);
                    managerApplyViewHolder.iXy.setClickable(false);
                }
                managerApplyViewHolder.iXx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                managerApplyViewHolder.mSkinType = this.mSkinType;
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        Activity activity;
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(this.mContext);
        if (!(K instanceof TbPageContext)) {
            activity = null;
        } else {
            activity = ((TbPageContext) K).getPageActivity();
        }
        if (this.fnD == null) {
            this.fnD = new com.baidu.tbadk.coreExtra.view.b(activity);
        }
        this.fnD.bzi();
        this.fnD.setAccountData(accountData);
        this.fnD.qy(1);
    }

    public void onDestroy() {
        if (this.fnD != null) {
            this.fnD.onDestroy();
        }
    }
}
