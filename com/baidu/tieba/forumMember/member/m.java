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
public class m extends com.baidu.tieba.frs.k<n, PrivateMgrApplyViewHolder> {
    private static final int jdg = R.id.private_apply_tip;
    private com.baidu.tbadk.coreExtra.view.b fpW;
    private View.OnClickListener mClickListener;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    Object tag = view.getTag(m.jdg);
                    if (tag != null && !tag.toString().equals("")) {
                        bf.bsV().b((TbPageContext) com.baidu.adp.base.j.K(m.this.mContext), new String[]{tag.toString()});
                        return;
                    }
                    return;
                }
                m.this.i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public PrivateMgrApplyViewHolder e(ViewGroup viewGroup) {
        return new PrivateMgrApplyViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.private_member_apply, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, PrivateMgrApplyViewHolder privateMgrApplyViewHolder) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) nVar, (n) privateMgrApplyViewHolder);
        if (nVar != null && !nVar.isEmpty() && privateMgrApplyViewHolder != null) {
            if (nVar.isEmpty()) {
                privateMgrApplyViewHolder.mRootLayout.setVisibility(8);
            } else {
                if (privateMgrApplyViewHolder.mSkinType != this.mSkinType) {
                    ap.setBackgroundColor(privateMgrApplyViewHolder.mLineView, R.color.CAM_X0204);
                    ap.setViewTextColor(privateMgrApplyViewHolder.jde, R.color.CAM_X0109, 1);
                    ap.setViewTextColor(privateMgrApplyViewHolder.jdd, R.color.CAM_X0105, 1);
                    ap.setBackgroundResource(privateMgrApplyViewHolder.jdf, R.drawable.frs_member_manito_bg);
                }
                int cAQ = nVar.cAQ();
                String string = this.mContext.getResources().getString(R.string.tbtitle_quota_is_full);
                if (cAQ == -1) {
                    int cAO = nVar.cAO();
                    String numberUniformFormat = au.numberUniformFormat(cAO);
                    if (cAO > 0) {
                        string = String.format(this.mContext.getResources().getString(R.string.tbtitle_apply_assist_left_num_tip), numberUniformFormat);
                        privateMgrApplyViewHolder.jdf.setOnClickListener(this.mClickListener);
                        privateMgrApplyViewHolder.jde.setText(string);
                        privateMgrApplyViewHolder.jdf.setTag(jdg, nVar.cAP());
                        privateMgrApplyViewHolder.jdf.setEnabled(z);
                        privateMgrApplyViewHolder.jdf.setClickable(z);
                        privateMgrApplyViewHolder.jde.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        privateMgrApplyViewHolder.mSkinType = this.mSkinType;
                    }
                    z = false;
                    privateMgrApplyViewHolder.jdf.setOnClickListener(this.mClickListener);
                    privateMgrApplyViewHolder.jde.setText(string);
                    privateMgrApplyViewHolder.jdf.setTag(jdg, nVar.cAP());
                    privateMgrApplyViewHolder.jdf.setEnabled(z);
                    privateMgrApplyViewHolder.jdf.setClickable(z);
                    privateMgrApplyViewHolder.jde.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.mSkinType = this.mSkinType;
                } else {
                    if (cAQ == 0) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_is_assist);
                    } else if (cAQ == 1) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_assist_applying);
                    } else {
                        if (cAQ == 2) {
                            string = this.mContext.getResources().getString(R.string.tbtitle_assist_apply_failed);
                        }
                        z = false;
                    }
                    privateMgrApplyViewHolder.jdf.setOnClickListener(this.mClickListener);
                    privateMgrApplyViewHolder.jde.setText(string);
                    privateMgrApplyViewHolder.jdf.setTag(jdg, nVar.cAP());
                    privateMgrApplyViewHolder.jdf.setEnabled(z);
                    privateMgrApplyViewHolder.jdf.setClickable(z);
                    privateMgrApplyViewHolder.jde.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.mSkinType = this.mSkinType;
                }
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
