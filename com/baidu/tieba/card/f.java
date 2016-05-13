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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class f extends a<com.baidu.tieba.card.a.d> {
    private View aOe;
    private View aOf;
    private HeadImageView aOg;
    private TextView aOh;
    private TextView aOi;
    private TextView aOj;
    private TextView aOk;
    private TextView aOl;
    private AppDownloadView aOm;
    protected TbImageView aOn;
    protected TbImageView aOo;
    protected TbImageView aOp;
    protected TbImageView aOq;
    protected View aOr;
    private com.baidu.tieba.card.a.d aOs;
    protected boolean mIsFromCDN;
    private View mRootView;

    protected abstract String JR();

    protected abstract void Q(View view);

    protected abstract void a(boolean z, com.baidu.tieba.card.a.d dVar);

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mIsFromCDN = false;
        R(getView());
    }

    private void R(View view) {
        this.aOf = view.findViewById(t.g.top_line);
        this.mRootView = view.findViewById(t.g.root_view);
        this.aOe = view.findViewById(t.g.advert_app_left_container);
        this.aOg = (HeadImageView) view.findViewById(t.g.advert_app_head_img);
        this.aOh = (TextView) view.findViewById(t.g.advert_app_title);
        this.aOi = (TextView) view.findViewById(t.g.advert_app_content);
        this.aOk = (TextView) view.findViewById(t.g.advert_app_push_left);
        this.aOl = (TextView) view.findViewById(t.g.advert_app_push_right);
        this.aOj = (TextView) view.findViewById(t.g.advert_app_btn);
        this.aOm = (AppDownloadView) view.findViewById(t.g.advert_app_download_view);
        this.aOg.setDefaultResource(17170445);
        this.aOg.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aOg.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aOg.setRadius(view.getContext().getResources().getDimensionPixelSize(t.e.ds70));
        Q(view);
        this.mRootView.setOnClickListener(this);
        this.aOj.setOnClickListener(this);
        this.aOm.uP();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.c Kv = this.aOs.Kv();
        if (Kv != null) {
            int i = this.aOs.mPn;
            String str = this.aOs.aRF;
            boolean z = view == this.aOj;
            if (Kv.oH()) {
                b(Kv);
            } else {
                a(Kv, this.aOs.getPosition(), this.aOj, this.aOm, z);
            }
            a(Kv, z ? false : true, i, str);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.mRootView, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.k(this.aOf, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.c(this.aOh, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(this.aOk, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(this.aOi, t.d.cp_cont_b, 1);
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
        this.aOs = dVar;
        this.aOg.c(dVar.Kq(), 10, false);
        this.aOh.setText(UtilHelper.getFixedText(dVar.getUserName(), 7, true));
        String Kr = dVar.Kr();
        if (!TextUtils.isEmpty(Kr)) {
            this.aOi.setText(getFixedChineseString(com.baidu.tbadk.core.util.ay.c(Kr, 29, "...")));
        } else {
            this.aOi.setVisibility(8);
        }
        a(com.baidu.tbadk.core.l.ob().oh(), dVar);
        String Ks = dVar.Ks();
        boolean z2 = dVar.oH() && TextUtils.isEmpty(Ks);
        a(this.aOj, !z2);
        if (dVar.oG()) {
            DownloadData b = b(dVar.Kv(), this.aOs.getPosition());
            b.setStatus(AppDownloadView.b(b));
            a(this.aOj, b.getStatus(), Ks);
            this.aOm.a(com.baidu.tieba.card.a.d.aRC, b);
            if (b.getStatus() != 5 && b.getStatus() != 1 && b.getStatus() != 7) {
                z = false;
            }
            this.aOm.setVisibility(z ? 0 : 8);
            return;
        }
        if (!z2 && !TextUtils.isEmpty(Ks)) {
            this.aOj.setText(Ks);
        }
        this.aOm.setVisibility(8);
    }

    private void a(TextView textView, boolean z) {
        if (!z) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        com.baidu.tbadk.core.util.at.k(textView, t.f.btn_focus_border_bg);
        com.baidu.tbadk.core.util.at.c(textView, t.d.btn_forum_focus_color, 1);
    }

    private void a(TextView textView, int i, String str) {
        switch (i) {
            case 1:
                textView.setText(t.j.downloading2);
                return;
            case 2:
            case 4:
            case 5:
            default:
                return;
            case 3:
                textView.setText(t.j.pb_app_install);
                return;
            case 6:
                textView.setText(t.j.pb_app_download);
                if (!TextUtils.isEmpty(str)) {
                    textView.setText(str);
                    return;
                }
                return;
            case 7:
                textView.setText(t.j.pb_download_pause);
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

    DownloadData b(com.baidu.tbadk.core.data.c cVar, int i) {
        DownloadData downloadData = new DownloadData(cVar.MS);
        downloadData.setUrl(cVar.MR);
        downloadData.setName(cVar.MO);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(cVar.MN, 0));
        return downloadData;
    }

    private void a(com.baidu.tbadk.core.data.c cVar, int i, TextView textView, AppDownloadView appDownloadView, boolean z) {
        if (cVar != null) {
            int b = AppDownloadView.b(b(cVar, i));
            if ((6 == b || 7 == b) && com.baidu.adp.lib.util.i.fq() && !com.baidu.adp.lib.util.i.fr()) {
                a(cVar, i, true);
                return;
            }
            switch (b) {
                case 1:
                    if (z) {
                        textView.setText(t.j.pb_download_pause);
                        com.baidu.tieba.tbadkCore.ah.e(cVar);
                        return;
                    }
                    return;
                case 2:
                case 4:
                case 5:
                default:
                    return;
                case 3:
                    com.baidu.tieba.tbadkCore.ah.F(getTbPageContext().getPageActivity(), cVar.MS);
                    return;
                case 6:
                case 7:
                    if (6 == b) {
                        appDownloadView.setVisibility(0);
                    }
                    textView.setText(t.j.downloading2);
                    c(cVar, i);
                    return;
            }
        }
    }

    private void b(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            com.baidu.tbadk.core.util.bg.ut().a(getTbPageContext(), new String[]{cVar.MQ}, true);
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, int i, boolean z) {
        if (cVar != null) {
            if (!com.baidu.adp.lib.util.i.fe()) {
                com.baidu.adp.lib.util.k.showToast(getTbPageContext().getPageActivity(), t.j.neterror);
            } else if (cVar.oH()) {
                b(cVar);
            } else if (cVar.oG()) {
                String trim = cVar.Nb.Nl.trim();
                if (com.baidu.adp.lib.util.i.fq() && !com.baidu.adp.lib.util.i.fr()) {
                    trim = getTbPageContext().getString(t.j.frs_network_tips);
                }
                if (TextUtils.isEmpty(trim)) {
                    trim = getTbPageContext().getString(t.j.confirm);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
                aVar.cA(trim);
                aVar.a(t.j.alert_yes_button, new g(this, cVar, i));
                aVar.b(t.j.alert_no_button, new h(this));
                aVar.b(getTbPageContext()).rV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            if (!cVar.oF()) {
                com.baidu.adp.lib.util.k.showToast(getTbPageContext().getPageActivity(), t.j.pb_app_error);
            } else if (!com.baidu.tieba.tbadkCore.ah.q(getTbPageContext().getPageActivity())) {
                com.baidu.adp.lib.util.k.showToast(getTbPageContext().getPageActivity(), t.j.write_external_storage_permission_denied_fun_disable);
            } else {
                com.baidu.tieba.tbadkCore.ah.a(getTbPageContext().getPageActivity(), cVar, i);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.c cVar, boolean z, int i, String str) {
        com.baidu.tbadk.distribute.a.AL().a(cVar, str, 0L, JR(), "click", i);
        com.baidu.tieba.recapp.report.b.aLJ().a(com.baidu.tieba.recapp.report.e.a(cVar, "click", i));
    }
}
