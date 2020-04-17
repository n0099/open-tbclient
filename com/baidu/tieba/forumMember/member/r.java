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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class r extends com.baidu.tieba.frs.h<s, t> {
    private com.baidu.tbadk.coreExtra.view.c dLU;
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
                    ba.aOY().b((TbPageContext) com.baidu.adp.base.i.T(r.this.mContext), new String[]{tag.toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public t b(ViewGroup viewGroup) {
        return new t(LayoutInflater.from(this.mContext).inflate(R.layout.private_member_apply, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, s sVar, t tVar) {
        String string;
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (s) tVar);
        if (sVar != null && !sVar.isEmpty() && tVar != null) {
            if (sVar.isEmpty()) {
                tVar.mRootLayout.setVisibility(8);
            } else {
                if (tVar.mSkinType != this.mSkinType) {
                    am.setBackgroundColor(tVar.mLineView, R.color.cp_bg_line_c);
                    am.setViewTextColor(tVar.gVy, R.color.cp_cont_d, 1);
                    am.setViewTextColor(tVar.gVx, R.color.cp_cont_b, 1);
                    am.setBackgroundResource(tVar.gVz, R.drawable.frs_member_manito_bg);
                }
                int bNi = sVar.bNi();
                String string2 = this.mContext.getResources().getString(R.string.tbtitle_quota_is_full);
                if (bNi == -1) {
                    int bNg = sVar.bNg();
                    String numberUniformFormat = aq.numberUniformFormat(bNg);
                    if (bNg > 0) {
                        string = String.format(this.mContext.getResources().getString(R.string.tbtitle_apply_assist_left_num_tip), numberUniformFormat);
                        tVar.gVz.setOnClickListener(this.mClickListener);
                        tVar.gVy.setText(string);
                        tVar.gVz.setTag(R.id.private_apply_tip, sVar.bNh());
                        tVar.gVz.setEnabled(z);
                        tVar.gVz.setClickable(z);
                        tVar.gVy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        tVar.mSkinType = this.mSkinType;
                    }
                    z = false;
                    string = string2;
                    tVar.gVz.setOnClickListener(this.mClickListener);
                    tVar.gVy.setText(string);
                    tVar.gVz.setTag(R.id.private_apply_tip, sVar.bNh());
                    tVar.gVz.setEnabled(z);
                    tVar.gVz.setClickable(z);
                    tVar.gVy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                } else {
                    if (bNi == 0) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_is_assist);
                    } else if (bNi == 1) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_assist_applying);
                    } else {
                        if (bNi == 2) {
                            string = this.mContext.getResources().getString(R.string.tbtitle_assist_apply_failed);
                        }
                        z = false;
                        string = string2;
                    }
                    tVar.gVz.setOnClickListener(this.mClickListener);
                    tVar.gVy.setText(string);
                    tVar.gVz.setTag(R.id.private_apply_tip, sVar.bNh());
                    tVar.gVz.setEnabled(z);
                    tVar.gVz.setClickable(z);
                    tVar.gVy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                }
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        Activity activity;
        com.baidu.adp.base.e<?> T = com.baidu.adp.base.i.T(this.mContext);
        if (!(T instanceof TbPageContext)) {
            activity = null;
        } else {
            activity = ((TbPageContext) T).getPageActivity();
        }
        if (this.dLU == null) {
            this.dLU = new com.baidu.tbadk.coreExtra.view.c(activity);
        }
        this.dLU.aVp();
        this.dLU.setAccountData(accountData);
        this.dLU.mm(1);
    }

    public void onDestroy() {
        if (this.dLU != null) {
            this.dLU.onDestroy();
        }
    }
}
