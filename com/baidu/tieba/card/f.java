package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class f extends a<com.baidu.tieba.card.a.d> {
    private TextView aSA;
    private TextView aSB;
    private TextView aSC;
    private AppDownloadView aSD;
    protected TbImageView aSE;
    protected TbImageView aSF;
    protected TbImageView aSG;
    protected TbImageView aSH;
    protected View aSI;
    private com.baidu.tieba.card.a.d aSJ;
    private View aSv;
    private View aSw;
    private HeadImageView aSx;
    private TextView aSy;
    private TextView aSz;
    protected boolean mIsFromCDN;
    private View mRootView;

    protected abstract String KP();

    protected abstract void R(View view);

    protected abstract void a(boolean z, com.baidu.tieba.card.a.d dVar);

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mIsFromCDN = false;
        S(getView());
    }

    private void S(View view) {
        this.aSw = view.findViewById(u.g.top_line);
        this.mRootView = view.findViewById(u.g.root_view);
        this.aSv = view.findViewById(u.g.advert_app_left_container);
        this.aSx = (HeadImageView) view.findViewById(u.g.advert_app_head_img);
        this.aSy = (TextView) view.findViewById(u.g.advert_app_title);
        this.aSz = (TextView) view.findViewById(u.g.advert_app_content);
        this.aSB = (TextView) view.findViewById(u.g.advert_app_push_left);
        this.aSC = (TextView) view.findViewById(u.g.advert_app_push_right);
        this.aSA = (TextView) view.findViewById(u.g.advert_app_btn);
        this.aSD = (AppDownloadView) view.findViewById(u.g.advert_app_download_view);
        this.aSx.setDefaultResource(17170445);
        this.aSx.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aSx.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aSx.setRadius(view.getContext().getResources().getDimensionPixelSize(u.e.ds70));
        R(view);
        this.mRootView.setOnClickListener(this);
        this.aSA.setOnClickListener(this);
        this.aSD.uO();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (!com.baidu.adp.lib.util.i.fe()) {
            KM().showToast(u.j.neterror);
            return;
        }
        com.baidu.tbadk.core.data.b Lr = this.aSJ.Lr();
        if (Lr != null) {
            int i2 = this.aSJ.mPn;
            String str = this.aSJ.aeq;
            boolean z = view == this.aSA;
            if (!TextUtils.isEmpty(Lr.MJ) && (i = com.baidu.tieba.tbadkCore.w.i(KM(), Lr.MJ)) != 0) {
                if (i == 1) {
                    b(Lr, true, i2, str);
                    return;
                } else {
                    b(Lr, false, i2, str);
                    return;
                }
            }
            if (Lr.om()) {
                b(Lr);
            } else {
                a(Lr, this.aSJ.getPosition(), this.aSA, this.aSD, z);
            }
            a(Lr, z ? false : true, i2, str);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.mRootView, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.k(this.aSw, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.c(this.aSy, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.aSB, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.aSz, u.d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.card.a.d dVar) {
        boolean z = true;
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.aSJ = dVar;
        this.aSx.c(dVar.Lm(), 10, false);
        this.aSy.setText(UtilHelper.getFixedText(dVar.getUserName(), 7, true));
        String Ln = dVar.Ln();
        if (!TextUtils.isEmpty(Ln)) {
            this.aSz.setText(getFixedChineseString(com.baidu.tbadk.core.util.ba.c(Ln, 29, "...")));
        } else {
            this.aSz.setVisibility(8);
        }
        a(com.baidu.tbadk.core.l.nL().nR(), dVar);
        String Lo = dVar.Lo();
        boolean z2 = dVar.om() && TextUtils.isEmpty(Lo);
        a(this.aSA, !z2);
        if (dVar.ol()) {
            DownloadData b = b(dVar.Lr(), this.aSJ.getPosition());
            b.setStatus(AppDownloadView.b(b));
            a(this.aSA, b.getStatus(), Lo);
            this.aSD.a(com.baidu.tieba.card.a.d.aVW, b);
            if (b.getStatus() != 5 && b.getStatus() != 1 && b.getStatus() != 7) {
                z = false;
            }
            this.aSD.setVisibility(z ? 0 : 8);
        } else {
            if (!z2 && !TextUtils.isEmpty(Lo)) {
                this.aSA.setText(Lo);
            }
            this.aSD.setVisibility(8);
        }
        if (dVar.getPosition() == 8 || dVar.getPosition() == 18) {
            this.aSB.setText(u.j.live_in);
        } else {
            this.aSB.setText(u.j.advert_label);
        }
    }

    private void a(TextView textView, boolean z) {
        if (!z) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        com.baidu.tbadk.core.util.av.k(textView, u.f.btn_focus_border_bg);
        com.baidu.tbadk.core.util.av.c(textView, u.d.btn_forum_focus_color, 1);
    }

    private void a(TextView textView, int i, String str) {
        switch (i) {
            case 1:
                textView.setText(u.j.downloading2);
                return;
            case 2:
            case 4:
            case 5:
            default:
                return;
            case 3:
                textView.setText(u.j.pb_app_install);
                return;
            case 6:
                textView.setText(u.j.pb_app_download);
                if (!TextUtils.isEmpty(str)) {
                    textView.setText(str);
                    return;
                }
                return;
            case 7:
                textView.setText(u.j.pb_download_pause);
                return;
        }
    }

    protected String getFixedChineseString(String str) {
        if (!StringUtils.isNull(str)) {
            String replaceAll = str.replaceAll("，", "， ").replaceAll("。", "。 ").replaceAll("？", "？ ").replaceAll("！", "！ ").replaceAll("、", "、 ").replaceAll("‘", "’ ").replaceAll("“", "” ").replaceAll("【", "【 ").replaceAll("】", "】 ").replaceAll("；", "； ").replaceAll("：", "： ").replaceAll("（", "（ ").replaceAll("）", "） ").replaceAll("·", "· ").replaceAll(" ", "  ");
            if (replaceAll.charAt(replaceAll.length() - 1) == ' ') {
                replaceAll = replaceAll.substring(0, replaceAll.length() - 1);
            }
            return replaceAll;
        }
        return str;
    }

    DownloadData b(com.baidu.tbadk.core.data.b bVar, int i) {
        DownloadData downloadData = new DownloadData(bVar.MK);
        downloadData.setUrl(bVar.MI);
        downloadData.setName(bVar.MF);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(bVar.ME, 0));
        return downloadData;
    }

    private void a(com.baidu.tbadk.core.data.b bVar, int i, TextView textView, AppDownloadView appDownloadView, boolean z) {
        if (bVar != null) {
            int b = AppDownloadView.b(b(bVar, i));
            if ((6 == b || 7 == b) && com.baidu.adp.lib.util.i.fq() && !com.baidu.adp.lib.util.i.fr()) {
                a(bVar, i, true);
                return;
            }
            switch (b) {
                case 1:
                    if (z) {
                        textView.setText(u.j.pb_download_pause);
                        com.baidu.tieba.tbadkCore.al.e(bVar);
                        return;
                    }
                    return;
                case 2:
                case 4:
                case 5:
                default:
                    return;
                case 3:
                    com.baidu.tieba.tbadkCore.al.G(KM().getPageActivity(), bVar.MK);
                    return;
                case 6:
                case 7:
                    if (6 == b) {
                        appDownloadView.setVisibility(0);
                    }
                    textView.setText(u.j.downloading2);
                    c(bVar, i);
                    return;
            }
        }
    }

    private void b(com.baidu.tbadk.core.data.b bVar) {
        if (bVar != null) {
            com.baidu.tbadk.core.util.bi.us().a(KM(), new String[]{bVar.MH}, true);
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, int i, boolean z) {
        if (bVar != null) {
            if (!com.baidu.adp.lib.util.i.fe()) {
                com.baidu.adp.lib.util.k.showToast(KM().getPageActivity(), u.j.neterror);
            } else if (bVar.om()) {
                b(bVar);
            } else if (bVar.ol()) {
                String trim = bVar.MU.Nf.trim();
                if (com.baidu.adp.lib.util.i.fq() && !com.baidu.adp.lib.util.i.fr()) {
                    trim = KM().getString(u.j.frs_network_tips);
                }
                if (TextUtils.isEmpty(trim)) {
                    trim = KM().getString(u.j.confirm);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(KM().getPageActivity());
                aVar.cz(trim);
                aVar.a(u.j.alert_yes_button, new g(this, bVar, i));
                aVar.b(u.j.alert_no_button, new h(this));
                aVar.b(KM()).rS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.b bVar, int i) {
        if (bVar != null) {
            if (!bVar.ok()) {
                com.baidu.adp.lib.util.k.showToast(KM().getPageActivity(), u.j.pb_app_error);
            } else if (!com.baidu.tieba.tbadkCore.al.s(KM().getPageActivity())) {
                com.baidu.adp.lib.util.k.showToast(KM().getPageActivity(), u.j.write_external_storage_permission_denied_fun_disable);
            } else {
                com.baidu.tieba.tbadkCore.al.a(KM().getPageActivity(), bVar, i);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.b bVar, boolean z, int i, String str) {
        com.baidu.tbadk.distribute.a.AU().a(bVar, str, 0L, KP(), "click", i);
        com.baidu.tieba.recapp.report.b.aYc().a(com.baidu.tieba.recapp.report.e.a(bVar, "click", i));
    }

    private void b(com.baidu.tbadk.core.data.b bVar, boolean z, int i, String str) {
        com.baidu.tieba.recapp.report.b.aYc().a(com.baidu.tieba.recapp.report.e.a(bVar, "click_deeplink", i));
        if (z) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("isDeepLink", "1");
            com.baidu.tieba.recapp.report.b.aYc().b(bVar.MH, hashMap);
        }
    }
}
