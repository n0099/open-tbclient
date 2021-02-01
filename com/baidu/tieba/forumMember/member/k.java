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
/* loaded from: classes8.dex */
public class k extends com.baidu.tieba.frs.k<l, ManagerApplyViewHolder> {
    private static final int jcV = R.id.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.b fpW;
    private View.OnClickListener mClickListener;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(k.jcV);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    k.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else {
                    bf.bsV().b((TbPageContext) com.baidu.adp.base.j.K(k.this.mContext), new String[]{tag.toString()});
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
                    ap.setViewTextColor(managerApplyViewHolder.jde, R.color.CAM_X0109, 1);
                    ap.setViewTextColor(managerApplyViewHolder.jdd, R.color.CAM_X0105, 1);
                    ap.setBackgroundResource(managerApplyViewHolder.jdf, R.drawable.frs_member_manito_bg);
                }
                int cAO = lVar.cAO();
                if (cAO > 0) {
                    managerApplyViewHolder.jde.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), au.numberUniformFormat(cAO)));
                    managerApplyViewHolder.jdf.setTag(jcV, lVar.cAP());
                    managerApplyViewHolder.jdf.setOnClickListener(this.mClickListener);
                    managerApplyViewHolder.jdf.setEnabled(true);
                    managerApplyViewHolder.jdf.setClickable(true);
                } else {
                    managerApplyViewHolder.jde.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
                    managerApplyViewHolder.jdf.setEnabled(false);
                    managerApplyViewHolder.jdf.setClickable(false);
                }
                managerApplyViewHolder.jde.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
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
        if (this.fpW == null) {
            this.fpW = new com.baidu.tbadk.coreExtra.view.b(activity);
        }
        this.fpW.bzA();
        this.fpW.setAccountData(accountData);
        this.fpW.qD(1);
    }

    public void onDestroy() {
        if (this.fpW != null) {
            this.fpW.onDestroy();
        }
    }
}
