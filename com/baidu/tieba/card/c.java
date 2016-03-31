package com.baidu.tieba.card;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends a<com.baidu.tieba.card.a.d> {
    private HeadImageView aRA;
    private TextView aRB;
    private TextView aRC;
    private TextView aRD;
    private TextView aRE;
    private TextView aRF;
    private AppDownloadView aRG;
    private TbImageView aRH;
    private View aRI;
    private com.baidu.tieba.card.a.d aRJ;
    private int aRK;
    private final int aRL;
    private final int imageHeight;
    private final int imageWidth;
    private boolean mIsFromCDN;
    private View mRootView;
    private final int maxHeight;
    private final int maxWidth;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mIsFromCDN = false;
        Resources resources = tbPageContext.getResources();
        this.aRK = resources.getDimensionPixelSize(t.e.ds70);
        int dimensionPixelSize = resources.getDimensionPixelSize(t.e.ds160);
        this.imageWidth = (int) (resources.getDimension(t.e.ds594) - resources.getDimension(t.e.ds20));
        this.imageHeight = (int) (resources.getDimension(t.e.ds260) - resources.getDimension(t.e.ds10));
        this.maxWidth = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m411getInst().getContext()) - dimensionPixelSize;
        this.maxHeight = resources.getDimensionPixelSize(t.e.ds321);
        this.aRL = resources.getDimensionPixelSize(t.e.ds30);
        P(getView());
    }

    private void P(View view) {
        this.mRootView = view.findViewById(t.g.root_view);
        this.aRA = (HeadImageView) view.findViewById(t.g.advert_app_head_img);
        this.aRB = (TextView) view.findViewById(t.g.advert_app_title);
        this.aRC = (TextView) view.findViewById(t.g.advert_app_content);
        this.aRH = (TbImageView) view.findViewById(t.g.advert_app_img);
        this.aRE = (TextView) view.findViewById(t.g.advert_app_push_left);
        this.aRF = (TextView) view.findViewById(t.g.advert_app_push_right);
        this.aRD = (TextView) view.findViewById(t.g.advert_app_btn);
        this.aRG = (AppDownloadView) view.findViewById(t.g.advert_app_download_view);
        this.aRI = view.findViewById(t.g.top_line);
        this.aRA.setOnClickListener(this);
        this.aRB.setOnClickListener(this);
        this.aRF.setOnClickListener(this);
        this.aRD.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.aRA.setDefaultResource(17170445);
        this.aRA.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aRA.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aRA.setRadius(this.aRK);
        this.aRH.setDrawBorder(true);
        this.aRH.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.c LJ = this.aRJ.LJ();
        if (LJ != null) {
            a(LJ, true, 0);
            if (LJ.rm()) {
                b(LJ);
            } else {
                a(LJ, this.aRJ.getPosition(), this.aRD, this.aRG);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.mRootView, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.k(this.aRI, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.b(this.aRB, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.b(this.aRE, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.b(this.aRC, t.d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.card_advert_app_item;
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
        this.aRJ = dVar;
        this.aRA.c(dVar.LF(), 10, false);
        this.aRB.setText(UtilHelper.getFixedText(dVar.getUserName(), 7, true));
        String LG = dVar.LG();
        if (!TextUtils.isEmpty(LG)) {
            this.aRC.setText(getFixedChineseString(com.baidu.tbadk.core.util.ay.c(LG, 29, "...")));
        } else {
            this.aRC.setVisibility(8);
        }
        String LI = dVar.LI();
        boolean qK = com.baidu.tbadk.core.l.qE().qK();
        boolean a = a(this.aRH, dVar.LJ());
        if (qK && !TextUtils.isEmpty(LI) && a) {
            this.aRH.setVisibility(0);
            this.aRC.setPadding(0, 0, 0, 0);
            this.aRH.c(LI, this.mIsFromCDN ? 30 : 31, false);
        } else {
            this.aRH.setVisibility(8);
        }
        String LH = dVar.LH();
        boolean z2 = dVar.rm() && TextUtils.isEmpty(LH);
        b(this.aRD, !z2);
        if (dVar.rl()) {
            DownloadData a2 = a(dVar.LJ(), this.aRJ.getPosition());
            a2.setStatus(AppDownloadView.b(a2));
            a(this.aRD, a2.getStatus(), LH);
            if (a2.getStatus() != 1 && a2.getStatus() != 7) {
                z = false;
            }
            this.aRG.setVisibility(z ? 0 : 8);
            if (z) {
                this.aRG.a(com.baidu.tieba.card.a.d.aVx, a2);
                return;
            }
            return;
        }
        if (!z2 && !TextUtils.isEmpty(LH)) {
            this.aRD.setText(LH);
        }
        this.aRG.setVisibility(8);
    }

    private void b(TextView textView, boolean z) {
        if (!z) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        com.baidu.tbadk.core.util.at.k(textView, t.f.btn_focus_border_bg);
        com.baidu.tbadk.core.util.at.b(textView, t.d.btn_forum_focus_color, 1);
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

    private boolean a(TbImageView tbImageView, com.baidu.tbadk.core.data.c cVar) {
        if (cVar == null || cVar.Sn == null || tbImageView == null) {
            a(tbImageView, this.imageHeight, this.imageWidth);
            return true;
        }
        int i = this.maxWidth;
        if (!cVar.Sn.SC) {
            a(tbImageView, (this.imageHeight * i) / this.imageWidth, i);
            return true;
        }
        int i2 = cVar.Sn.height;
        int i3 = cVar.Sn.width;
        if (this.maxWidth <= 0 || i2 <= 0 || i3 <= 0) {
            a(tbImageView, this.imageHeight, this.imageWidth);
            return true;
        }
        int i4 = (i2 * i) / i3;
        if (i4 > this.maxHeight) {
            return false;
        }
        a(tbImageView, i4, i);
        return true;
    }

    private void a(TbImageView tbImageView, int i, int i2) {
        if (tbImageView != null) {
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i2, i);
            } else {
                layoutParams.height = i;
                layoutParams.width = i2;
            }
            tbImageView.setLayoutParams(layoutParams);
        }
    }

    private String getFixedChineseString(String str) {
        if (!StringUtils.isNull(str)) {
            String replaceAll = str.replaceAll("，", "， ").replaceAll("。", "。 ").replaceAll("？", "？ ").replaceAll("！", "！ ").replaceAll("、", "、 ").replaceAll("‘", "’ ").replaceAll("“", "” ").replaceAll("【", "【 ").replaceAll("】", "】 ").replaceAll("；", "； ").replaceAll("：", "： ").replaceAll("（", "（ ").replaceAll("）", "） ").replaceAll("·", "· ").replaceAll(" ", "  ");
            if (replaceAll.charAt(replaceAll.length() - 1) == ' ') {
                replaceAll = replaceAll.substring(0, replaceAll.length() - 1);
            }
            return replaceAll;
        }
        return str;
    }

    DownloadData a(com.baidu.tbadk.core.data.c cVar, int i) {
        DownloadData downloadData = new DownloadData(cVar.Se);
        downloadData.setUrl(cVar.Sd);
        downloadData.setName(cVar.Sa);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(cVar.RZ, 0));
        return downloadData;
    }

    private void a(com.baidu.tbadk.core.data.c cVar, int i, TextView textView, AppDownloadView appDownloadView) {
        if (cVar != null) {
            int b = AppDownloadView.b(a(cVar, i));
            if ((6 == b || 7 == b) && com.baidu.adp.lib.util.i.jf() && !com.baidu.adp.lib.util.i.jg()) {
                a(cVar, i, true);
                return;
            }
            switch (b) {
                case 1:
                    textView.setText(t.j.pb_download_pause);
                    com.baidu.tieba.tbadkCore.ag.e(cVar);
                    return;
                case 2:
                case 4:
                case 5:
                default:
                    return;
                case 3:
                    com.baidu.tieba.tbadkCore.ag.E(Lb().getPageActivity(), cVar.Se);
                    return;
                case 6:
                case 7:
                    if (6 == b) {
                        appDownloadView.setVisibility(0);
                    }
                    textView.setText(t.j.downloading2);
                    b(cVar, i);
                    return;
            }
        }
    }

    private void b(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            com.baidu.tbadk.core.util.bg.wM().a(Lb(), new String[]{cVar.Sc}, true);
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, int i, boolean z) {
        if (cVar != null) {
            if (!com.baidu.adp.lib.util.i.iT()) {
                com.baidu.adp.lib.util.k.showToast(Lb().getPageActivity(), t.j.neterror);
            } else if (cVar.rm()) {
                b(cVar);
            } else if (cVar.rl()) {
                String trim = cVar.Sn.Sx.trim();
                if (com.baidu.adp.lib.util.i.jf() && !com.baidu.adp.lib.util.i.jg()) {
                    trim = Lb().getString(t.j.frs_network_tips);
                }
                if (TextUtils.isEmpty(trim)) {
                    trim = Lb().getString(t.j.confirm);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Lb().getPageActivity());
                aVar.cC(trim);
                aVar.a(t.j.alert_yes_button, new d(this, cVar, i));
                aVar.b(t.j.alert_no_button, new e(this));
                aVar.b(Lb()).up();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            if (!cVar.rk()) {
                com.baidu.adp.lib.util.k.showToast(Lb().getPageActivity(), t.j.pb_app_error);
            } else if (!com.baidu.tieba.tbadkCore.ag.p(Lb().getPageActivity())) {
                com.baidu.adp.lib.util.k.showToast(Lb().getPageActivity(), t.j.write_external_storage_permission_denied_fun_disable);
            } else {
                com.baidu.tieba.tbadkCore.ag.a(Lb().getPageActivity(), cVar, i);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.c cVar, boolean z, int i) {
        com.baidu.tbadk.distribute.a.CR().a(cVar, "", 0L, "NEWINDEX", "click", i);
        com.baidu.tieba.recapp.report.b.aLC().a(com.baidu.tieba.recapp.report.e.a(cVar, "click", i));
    }

    private static void c(com.baidu.tbadk.core.data.c cVar, int i) {
        com.baidu.tbadk.distribute.a.CR().a(cVar, "", 0L, "NEWINDEX", "show", i);
        com.baidu.tieba.recapp.report.b.aLC().a(com.baidu.tieba.recapp.report.e.a(cVar, "show", i));
    }

    public static void a(com.baidu.tieba.card.a.d dVar, int i) {
        c(dVar.LJ(), i);
    }

    public static void K(int i, int i2) {
        com.baidu.tieba.recapp.report.a h = com.baidu.tieba.recapp.report.e.h("store", i2, i);
        h.bz("page", "NEWINDEX");
        com.baidu.tieba.recapp.report.b.aLC().a(h);
    }
}
