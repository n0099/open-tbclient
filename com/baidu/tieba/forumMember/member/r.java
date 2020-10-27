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
/* loaded from: classes23.dex */
public class r extends com.baidu.tieba.frs.k<s, t> {
    private static final int iyp = R.id.private_apply_tip;
    private com.baidu.tbadk.coreExtra.view.b eWi;
    private View.OnClickListener mClickListener;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    Object tag = view.getTag(r.iyp);
                    if (tag != null && !tag.toString().equals("")) {
                        be.boR().b((TbPageContext) com.baidu.adp.base.i.I(r.this.mContext), new String[]{tag.toString()});
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
    /* renamed from: bh */
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
                    ap.setViewTextColor(tVar.iyn, R.color.cp_cont_d, 1);
                    ap.setViewTextColor(tVar.iym, R.color.cp_cont_b, 1);
                    ap.setBackgroundResource(tVar.iyo, R.drawable.frs_member_manito_bg);
                }
                int cuj = sVar.cuj();
                String string2 = this.mContext.getResources().getString(R.string.tbtitle_quota_is_full);
                if (cuj == -1) {
                    int cuh = sVar.cuh();
                    String numberUniformFormat = at.numberUniformFormat(cuh);
                    if (cuh > 0) {
                        string = String.format(this.mContext.getResources().getString(R.string.tbtitle_apply_assist_left_num_tip), numberUniformFormat);
                        tVar.iyo.setOnClickListener(this.mClickListener);
                        tVar.iyn.setText(string);
                        tVar.iyo.setTag(iyp, sVar.cui());
                        tVar.iyo.setEnabled(z);
                        tVar.iyo.setClickable(z);
                        tVar.iyn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        tVar.mSkinType = this.mSkinType;
                    }
                    z = false;
                    string = string2;
                    tVar.iyo.setOnClickListener(this.mClickListener);
                    tVar.iyn.setText(string);
                    tVar.iyo.setTag(iyp, sVar.cui());
                    tVar.iyo.setEnabled(z);
                    tVar.iyo.setClickable(z);
                    tVar.iyn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                } else {
                    if (cuj == 0) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_is_assist);
                    } else if (cuj == 1) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_assist_applying);
                    } else {
                        if (cuj == 2) {
                            string = this.mContext.getResources().getString(R.string.tbtitle_assist_apply_failed);
                        }
                        z = false;
                        string = string2;
                    }
                    tVar.iyo.setOnClickListener(this.mClickListener);
                    tVar.iyn.setText(string);
                    tVar.iyo.setTag(iyp, sVar.cui());
                    tVar.iyo.setEnabled(z);
                    tVar.iyo.setClickable(z);
                    tVar.iyn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
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
        if (this.eWi == null) {
            this.eWi = new com.baidu.tbadk.coreExtra.view.b(activity);
        }
        this.eWi.bvs();
        this.eWi.setAccountData(accountData);
        this.eWi.qJ(1);
    }

    public void onDestroy() {
        if (this.eWi != null) {
            this.eWi.onDestroy();
        }
    }
}
