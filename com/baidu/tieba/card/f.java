package com.baidu.tieba.card;

import android.net.Uri;
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
    private View aRB;
    private View aRC;
    private HeadImageView aRD;
    private TextView aRE;
    private TextView aRF;
    private TextView aRG;
    private TextView aRH;
    private TextView aRI;
    private AppDownloadView aRJ;
    protected TbImageView aRK;
    protected TbImageView aRL;
    protected TbImageView aRM;
    protected TbImageView aRN;
    protected View aRO;
    private com.baidu.tieba.card.a.d aRP;
    protected boolean mIsFromCDN;
    private View mRootView;

    protected abstract String KQ();

    protected abstract void R(View view);

    protected abstract void a(boolean z, com.baidu.tieba.card.a.d dVar);

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mIsFromCDN = false;
        S(getView());
    }

    private void S(View view) {
        this.aRC = view.findViewById(u.g.top_line);
        this.mRootView = view.findViewById(u.g.root_view);
        this.aRB = view.findViewById(u.g.advert_app_left_container);
        this.aRD = (HeadImageView) view.findViewById(u.g.advert_app_head_img);
        this.aRE = (TextView) view.findViewById(u.g.advert_app_title);
        this.aRF = (TextView) view.findViewById(u.g.advert_app_content);
        this.aRH = (TextView) view.findViewById(u.g.advert_app_push_left);
        this.aRI = (TextView) view.findViewById(u.g.advert_app_push_right);
        this.aRG = (TextView) view.findViewById(u.g.advert_app_btn);
        this.aRJ = (AppDownloadView) view.findViewById(u.g.advert_app_download_view);
        this.aRD.setDefaultResource(17170445);
        this.aRD.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aRD.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aRD.setRadius(view.getContext().getResources().getDimensionPixelSize(u.e.ds70));
        R(view);
        this.mRootView.setOnClickListener(this);
        this.aRG.setOnClickListener(this);
        this.aRJ.uO();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.ff()) {
            KN().showToast(u.j.neterror);
            return;
        }
        com.baidu.tbadk.core.data.b Ls = this.aRP.Ls();
        if (Ls != null) {
            int i = this.aRP.mPn;
            String str = this.aRP.aIZ;
            boolean z = view == this.aRG;
            if (!TextUtils.isEmpty(Ls.MM) && c(Ls)) {
                b(Ls, true, i, str);
                return;
            }
            if (Ls.ox()) {
                b(Ls);
            } else {
                a(Ls, this.aRP.getPosition(), this.aRG, this.aRJ, z);
            }
            a(Ls, z ? false : true, i, str);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.mRootView, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.k(this.aRC, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.c(this.aRE, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.aRH, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.aRF, u.d.cp_cont_b, 1);
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
        this.aRP = dVar;
        this.aRD.c(dVar.Ln(), 10, false);
        this.aRE.setText(UtilHelper.getFixedText(dVar.getUserName(), 7, true));
        String Lo = dVar.Lo();
        if (!TextUtils.isEmpty(Lo)) {
            this.aRF.setText(getFixedChineseString(com.baidu.tbadk.core.util.ba.c(Lo, 29, "...")));
        } else {
            this.aRF.setVisibility(8);
        }
        a(com.baidu.tbadk.core.l.nW().oc(), dVar);
        String Lp = dVar.Lp();
        boolean z2 = dVar.ox() && TextUtils.isEmpty(Lp);
        a(this.aRG, !z2);
        if (dVar.ow()) {
            DownloadData b = b(dVar.Ls(), this.aRP.getPosition());
            b.setStatus(AppDownloadView.b(b));
            a(this.aRG, b.getStatus(), Lp);
            this.aRJ.a(com.baidu.tieba.card.a.d.aUY, b);
            if (b.getStatus() != 5 && b.getStatus() != 1 && b.getStatus() != 7) {
                z = false;
            }
            this.aRJ.setVisibility(z ? 0 : 8);
        } else {
            if (!z2 && !TextUtils.isEmpty(Lp)) {
                this.aRG.setText(Lp);
            }
            this.aRJ.setVisibility(8);
        }
        if (dVar.getPosition() == 8 || dVar.getPosition() == 18) {
            this.aRH.setText(u.j.live_in);
        } else {
            this.aRH.setText(u.j.advert_label);
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
        DownloadData downloadData = new DownloadData(bVar.MN);
        downloadData.setUrl(bVar.MK);
        downloadData.setName(bVar.MH);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(bVar.MG, 0));
        return downloadData;
    }

    private void a(com.baidu.tbadk.core.data.b bVar, int i, TextView textView, AppDownloadView appDownloadView, boolean z) {
        if (bVar != null) {
            int b = AppDownloadView.b(b(bVar, i));
            if ((6 == b || 7 == b) && com.baidu.adp.lib.util.i.fr() && !com.baidu.adp.lib.util.i.fs()) {
                a(bVar, i, true);
                return;
            }
            switch (b) {
                case 1:
                    if (z) {
                        textView.setText(u.j.pb_download_pause);
                        com.baidu.tieba.tbadkCore.al.f(bVar);
                        return;
                    }
                    return;
                case 2:
                case 4:
                case 5:
                default:
                    return;
                case 3:
                    com.baidu.tieba.tbadkCore.al.G(KN().getPageActivity(), bVar.MN);
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
            com.baidu.tbadk.core.util.bi.us().a(KN(), new String[]{bVar.MJ}, true);
        }
    }

    private boolean c(com.baidu.tbadk.core.data.b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.MM)) {
            return false;
        }
        return com.baidu.tieba.recapp.b.b(KN().getPageActivity(), Uri.parse(bVar.MM));
    }

    public void a(com.baidu.tbadk.core.data.b bVar, int i, boolean z) {
        if (bVar != null) {
            if (!com.baidu.adp.lib.util.i.ff()) {
                com.baidu.adp.lib.util.k.showToast(KN().getPageActivity(), u.j.neterror);
            } else if (bVar.ox()) {
                b(bVar);
            } else if (bVar.ow()) {
                String trim = bVar.MW.Nh.trim();
                if (com.baidu.adp.lib.util.i.fr() && !com.baidu.adp.lib.util.i.fs()) {
                    trim = KN().getString(u.j.frs_network_tips);
                }
                if (TextUtils.isEmpty(trim)) {
                    trim = KN().getString(u.j.confirm);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(KN().getPageActivity());
                aVar.cz(trim);
                aVar.a(u.j.alert_yes_button, new g(this, bVar, i));
                aVar.b(u.j.alert_no_button, new h(this));
                aVar.b(KN()).rT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.b bVar, int i) {
        if (bVar != null) {
            if (!bVar.ov()) {
                com.baidu.adp.lib.util.k.showToast(KN().getPageActivity(), u.j.pb_app_error);
            } else if (!com.baidu.tieba.tbadkCore.al.s(KN().getPageActivity())) {
                com.baidu.adp.lib.util.k.showToast(KN().getPageActivity(), u.j.write_external_storage_permission_denied_fun_disable);
            } else {
                com.baidu.tieba.tbadkCore.al.a(KN().getPageActivity(), bVar, i);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.b bVar, boolean z, int i, String str) {
        com.baidu.tbadk.distribute.a.AU().a(bVar, str, 0L, KQ(), "click", i);
        com.baidu.tieba.recapp.report.b.aUO().a(com.baidu.tieba.recapp.report.e.a(bVar, "click", i));
    }

    private void b(com.baidu.tbadk.core.data.b bVar, boolean z, int i, String str) {
        com.baidu.tieba.recapp.report.b.aUO().a(com.baidu.tieba.recapp.report.e.a(bVar, "click_deeplink", i));
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("isDeepLink", "1");
        com.baidu.tieba.recapp.report.b.aUO().b(bVar.MJ, hashMap);
    }
}
