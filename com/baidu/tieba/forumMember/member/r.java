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
    private com.baidu.tbadk.coreExtra.view.c dLY;
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
                    ba.aOV().b((TbPageContext) com.baidu.adp.base.i.G(r.this.mContext), new String[]{tag.toString()});
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
                    am.setViewTextColor(tVar.gVE, R.color.cp_cont_d, 1);
                    am.setViewTextColor(tVar.gVD, R.color.cp_cont_b, 1);
                    am.setBackgroundResource(tVar.gVF, R.drawable.frs_member_manito_bg);
                }
                int bNh = sVar.bNh();
                String string2 = this.mContext.getResources().getString(R.string.tbtitle_quota_is_full);
                if (bNh == -1) {
                    int bNf = sVar.bNf();
                    String numberUniformFormat = aq.numberUniformFormat(bNf);
                    if (bNf > 0) {
                        string = String.format(this.mContext.getResources().getString(R.string.tbtitle_apply_assist_left_num_tip), numberUniformFormat);
                        tVar.gVF.setOnClickListener(this.mClickListener);
                        tVar.gVE.setText(string);
                        tVar.gVF.setTag(R.id.private_apply_tip, sVar.bNg());
                        tVar.gVF.setEnabled(z);
                        tVar.gVF.setClickable(z);
                        tVar.gVE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        tVar.mSkinType = this.mSkinType;
                    }
                    z = false;
                    string = string2;
                    tVar.gVF.setOnClickListener(this.mClickListener);
                    tVar.gVE.setText(string);
                    tVar.gVF.setTag(R.id.private_apply_tip, sVar.bNg());
                    tVar.gVF.setEnabled(z);
                    tVar.gVF.setClickable(z);
                    tVar.gVE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                } else {
                    if (bNh == 0) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_is_assist);
                    } else if (bNh == 1) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_assist_applying);
                    } else {
                        if (bNh == 2) {
                            string = this.mContext.getResources().getString(R.string.tbtitle_assist_apply_failed);
                        }
                        z = false;
                        string = string2;
                    }
                    tVar.gVF.setOnClickListener(this.mClickListener);
                    tVar.gVE.setText(string);
                    tVar.gVF.setTag(R.id.private_apply_tip, sVar.bNg());
                    tVar.gVF.setEnabled(z);
                    tVar.gVF.setClickable(z);
                    tVar.gVE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                }
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        Activity activity;
        com.baidu.adp.base.e<?> G = com.baidu.adp.base.i.G(this.mContext);
        if (!(G instanceof TbPageContext)) {
            activity = null;
        } else {
            activity = ((TbPageContext) G).getPageActivity();
        }
        if (this.dLY == null) {
            this.dLY = new com.baidu.tbadk.coreExtra.view.c(activity);
        }
        this.dLY.aVn();
        this.dLY.setAccountData(accountData);
        this.dLY.mm(1);
    }

    public void onDestroy() {
        if (this.dLY != null) {
            this.dLY.onDestroy();
        }
    }
}
