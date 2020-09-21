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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class r extends com.baidu.tieba.frs.k<s, t> {
    private static final int hWS = R.id.private_apply_tip;
    private com.baidu.tbadk.coreExtra.view.b eBF;
    private View.OnClickListener mClickListener;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    Object tag = view.getTag(r.hWS);
                    if (tag != null && !tag.toString().equals("")) {
                        be.bkp().b((TbPageContext) com.baidu.adp.base.i.I(r.this.mContext), new String[]{tag.toString()});
                        return;
                    }
                    return;
                }
                r.this.i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bf */
    public t c(ViewGroup viewGroup) {
        return new t(LayoutInflater.from(this.mContext).inflate(R.layout.private_member_apply, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, s sVar, t tVar) {
        String string;
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (s) tVar);
        if (sVar != null && !sVar.isEmpty() && tVar != null) {
            if (sVar.isEmpty()) {
                tVar.mRootLayout.setVisibility(8);
            } else {
                if (tVar.mSkinType != this.mSkinType) {
                    ap.setBackgroundColor(tVar.mLineView, R.color.cp_bg_line_c);
                    ap.setViewTextColor(tVar.hWQ, R.color.cp_cont_d, 1);
                    ap.setViewTextColor(tVar.hWP, R.color.cp_cont_b, 1);
                    ap.setBackgroundResource(tVar.hWR, R.drawable.frs_member_manito_bg);
                }
                int cnE = sVar.cnE();
                String string2 = this.mContext.getResources().getString(R.string.tbtitle_quota_is_full);
                if (cnE == -1) {
                    int cnC = sVar.cnC();
                    String numberUniformFormat = at.numberUniformFormat(cnC);
                    if (cnC > 0) {
                        string = String.format(this.mContext.getResources().getString(R.string.tbtitle_apply_assist_left_num_tip), numberUniformFormat);
                        tVar.hWR.setOnClickListener(this.mClickListener);
                        tVar.hWQ.setText(string);
                        tVar.hWR.setTag(hWS, sVar.cnD());
                        tVar.hWR.setEnabled(z);
                        tVar.hWR.setClickable(z);
                        tVar.hWQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        tVar.mSkinType = this.mSkinType;
                    }
                    z = false;
                    string = string2;
                    tVar.hWR.setOnClickListener(this.mClickListener);
                    tVar.hWQ.setText(string);
                    tVar.hWR.setTag(hWS, sVar.cnD());
                    tVar.hWR.setEnabled(z);
                    tVar.hWR.setClickable(z);
                    tVar.hWQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                } else {
                    if (cnE == 0) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_is_assist);
                    } else if (cnE == 1) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_assist_applying);
                    } else {
                        if (cnE == 2) {
                            string = this.mContext.getResources().getString(R.string.tbtitle_assist_apply_failed);
                        }
                        z = false;
                        string = string2;
                    }
                    tVar.hWR.setOnClickListener(this.mClickListener);
                    tVar.hWQ.setText(string);
                    tVar.hWR.setTag(hWS, sVar.cnD());
                    tVar.hWR.setEnabled(z);
                    tVar.hWR.setClickable(z);
                    tVar.hWQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                }
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        Activity activity;
        com.baidu.adp.base.e<?> I = com.baidu.adp.base.i.I(this.mContext);
        if (!(I instanceof TbPageContext)) {
            activity = null;
        } else {
            activity = ((TbPageContext) I).getPageActivity();
        }
        if (this.eBF == null) {
            this.eBF = new com.baidu.tbadk.coreExtra.view.b(activity);
        }
        this.eBF.bqP();
        this.eBF.setAccountData(accountData);
        this.eBF.qa(1);
    }

    public void onDestroy() {
        if (this.eBF != null) {
            this.eBF.onDestroy();
        }
    }
}
