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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class r extends com.baidu.tieba.frs.j<s, t> {
    private static final int hCx = R.id.private_apply_tip;
    private com.baidu.tbadk.coreExtra.view.b epl;
    private View.OnClickListener mClickListener;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    Object tag = view.getTag(r.hCx);
                    if (tag != null && !tag.toString().equals("")) {
                        bd.baV().b((TbPageContext) com.baidu.adp.base.i.G(r.this.mContext), new String[]{tag.toString()});
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
    public t b(ViewGroup viewGroup) {
        return new t(LayoutInflater.from(this.mContext).inflate(R.layout.private_member_apply, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, s sVar, t tVar) {
        String string;
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (s) tVar);
        if (sVar != null && !sVar.isEmpty() && tVar != null) {
            if (sVar.isEmpty()) {
                tVar.mRootLayout.setVisibility(8);
            } else {
                if (tVar.mSkinType != this.mSkinType) {
                    ao.setBackgroundColor(tVar.mLineView, R.color.cp_bg_line_c);
                    ao.setViewTextColor(tVar.hCv, R.color.cp_cont_d, 1);
                    ao.setViewTextColor(tVar.hCu, R.color.cp_cont_b, 1);
                    ao.setBackgroundResource(tVar.hCw, R.drawable.frs_member_manito_bg);
                }
                int bZU = sVar.bZU();
                String string2 = this.mContext.getResources().getString(R.string.tbtitle_quota_is_full);
                if (bZU == -1) {
                    int bZS = sVar.bZS();
                    String numberUniformFormat = as.numberUniformFormat(bZS);
                    if (bZS > 0) {
                        string = String.format(this.mContext.getResources().getString(R.string.tbtitle_apply_assist_left_num_tip), numberUniformFormat);
                        tVar.hCw.setOnClickListener(this.mClickListener);
                        tVar.hCv.setText(string);
                        tVar.hCw.setTag(hCx, sVar.bZT());
                        tVar.hCw.setEnabled(z);
                        tVar.hCw.setClickable(z);
                        tVar.hCv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        tVar.mSkinType = this.mSkinType;
                    }
                    z = false;
                    string = string2;
                    tVar.hCw.setOnClickListener(this.mClickListener);
                    tVar.hCv.setText(string);
                    tVar.hCw.setTag(hCx, sVar.bZT());
                    tVar.hCw.setEnabled(z);
                    tVar.hCw.setClickable(z);
                    tVar.hCv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                } else {
                    if (bZU == 0) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_is_assist);
                    } else if (bZU == 1) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_assist_applying);
                    } else {
                        if (bZU == 2) {
                            string = this.mContext.getResources().getString(R.string.tbtitle_assist_apply_failed);
                        }
                        z = false;
                        string = string2;
                    }
                    tVar.hCw.setOnClickListener(this.mClickListener);
                    tVar.hCv.setText(string);
                    tVar.hCw.setTag(hCx, sVar.bZT());
                    tVar.hCw.setEnabled(z);
                    tVar.hCw.setClickable(z);
                    tVar.hCv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
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
        if (this.epl == null) {
            this.epl = new com.baidu.tbadk.coreExtra.view.b(activity);
        }
        this.epl.bhi();
        this.epl.setAccountData(accountData);
        this.epl.nC(1);
    }

    public void onDestroy() {
        if (this.epl != null) {
            this.epl.onDestroy();
        }
    }
}
