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
    private com.baidu.tbadk.coreExtra.view.b eap;
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
                    ba.aUZ().b((TbPageContext) com.baidu.adp.base.i.G(r.this.mContext), new String[]{tag.toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ba */
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
                    am.setViewTextColor(tVar.hkq, R.color.cp_cont_d, 1);
                    am.setViewTextColor(tVar.hkp, R.color.cp_cont_b, 1);
                    am.setBackgroundResource(tVar.hkr, R.drawable.frs_member_manito_bg);
                }
                int bTC = sVar.bTC();
                String string2 = this.mContext.getResources().getString(R.string.tbtitle_quota_is_full);
                if (bTC == -1) {
                    int bTA = sVar.bTA();
                    String numberUniformFormat = aq.numberUniformFormat(bTA);
                    if (bTA > 0) {
                        string = String.format(this.mContext.getResources().getString(R.string.tbtitle_apply_assist_left_num_tip), numberUniformFormat);
                        tVar.hkr.setOnClickListener(this.mClickListener);
                        tVar.hkq.setText(string);
                        tVar.hkr.setTag(R.id.private_apply_tip, sVar.bTB());
                        tVar.hkr.setEnabled(z);
                        tVar.hkr.setClickable(z);
                        tVar.hkq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        tVar.mSkinType = this.mSkinType;
                    }
                    z = false;
                    string = string2;
                    tVar.hkr.setOnClickListener(this.mClickListener);
                    tVar.hkq.setText(string);
                    tVar.hkr.setTag(R.id.private_apply_tip, sVar.bTB());
                    tVar.hkr.setEnabled(z);
                    tVar.hkr.setClickable(z);
                    tVar.hkq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                } else {
                    if (bTC == 0) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_is_assist);
                    } else if (bTC == 1) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_assist_applying);
                    } else {
                        if (bTC == 2) {
                            string = this.mContext.getResources().getString(R.string.tbtitle_assist_apply_failed);
                        }
                        z = false;
                        string = string2;
                    }
                    tVar.hkr.setOnClickListener(this.mClickListener);
                    tVar.hkq.setText(string);
                    tVar.hkr.setTag(R.id.private_apply_tip, sVar.bTB());
                    tVar.hkr.setEnabled(z);
                    tVar.hkr.setClickable(z);
                    tVar.hkq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
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
        if (this.eap == null) {
            this.eap = new com.baidu.tbadk.coreExtra.view.b(activity);
        }
        this.eap.bbw();
        this.eap.setAccountData(accountData);
        this.eap.mO(1);
    }

    public void onDestroy() {
        if (this.eap != null) {
            this.eap.onDestroy();
        }
    }
}
