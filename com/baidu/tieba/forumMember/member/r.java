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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class r extends com.baidu.tieba.frs.h<s, t> {
    private com.baidu.tbadk.coreExtra.view.c cdV;
    private View.OnClickListener mClickListener;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    r.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                    return;
                }
                Object tag = view.getTag(R.id.private_apply_tip);
                if (tag != null && !tag.toString().equals("")) {
                    ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(r.this.mContext), new String[]{tag.toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aC */
    public t onCreateViewHolder(ViewGroup viewGroup) {
        return new t(LayoutInflater.from(this.mContext).inflate(R.layout.private_member_apply, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, s sVar, t tVar) {
        String string;
        boolean z = true;
        super.onFillViewHolder(i, view, viewGroup, sVar, tVar);
        if (sVar != null && !sVar.isEmpty() && tVar != null) {
            if (sVar.isEmpty()) {
                tVar.mRootLayout.setVisibility(8);
            } else {
                if (tVar.mSkinType != this.mSkinType) {
                    al.l(tVar.bMo, R.color.cp_bg_line_b);
                    al.f(tVar.fmg, R.color.cp_cont_d, 1);
                    al.f(tVar.fmf, R.color.cp_cont_b, 1);
                    al.k(tVar.fmh, R.drawable.frs_member_manito_bg);
                }
                int biz = sVar.biz();
                String string2 = this.mContext.getResources().getString(R.string.tbtitle_quota_is_full);
                if (biz == -1) {
                    int bix = sVar.bix();
                    String aG = ap.aG(bix);
                    if (bix > 0) {
                        string = String.format(this.mContext.getResources().getString(R.string.tbtitle_apply_assist_left_num_tip), aG);
                        tVar.fmh.setOnClickListener(this.mClickListener);
                        tVar.fmg.setText(string);
                        tVar.fmh.setTag(R.id.private_apply_tip, sVar.biy());
                        tVar.fmh.setEnabled(z);
                        tVar.fmh.setClickable(z);
                        tVar.fmg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        tVar.mSkinType = this.mSkinType;
                    }
                    z = false;
                    string = string2;
                    tVar.fmh.setOnClickListener(this.mClickListener);
                    tVar.fmg.setText(string);
                    tVar.fmh.setTag(R.id.private_apply_tip, sVar.biy());
                    tVar.fmh.setEnabled(z);
                    tVar.fmh.setClickable(z);
                    tVar.fmg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                } else {
                    if (biz == 0) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_is_assist);
                    } else if (biz == 1) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_assist_applying);
                    } else {
                        if (biz == 2) {
                            string = this.mContext.getResources().getString(R.string.tbtitle_assist_apply_failed);
                        }
                        z = false;
                        string = string2;
                    }
                    tVar.fmh.setOnClickListener(this.mClickListener);
                    tVar.fmg.setText(string);
                    tVar.fmh.setTag(R.id.private_apply_tip, sVar.biy());
                    tVar.fmh.setEnabled(z);
                    tVar.fmh.setClickable(z);
                    tVar.fmg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                }
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        Activity activity;
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(this.mContext);
        if (!(ab instanceof TbPageContext)) {
            activity = null;
        } else {
            activity = ((TbPageContext) ab).getPageActivity();
        }
        if (this.cdV == null) {
            this.cdV = new com.baidu.tbadk.coreExtra.view.c(activity);
        }
        this.cdV.apm();
        this.cdV.setAccountData(accountData);
        this.cdV.jN(1);
    }

    public void onDestroy() {
        if (this.cdV != null) {
            this.cdV.onDestroy();
        }
    }
}
