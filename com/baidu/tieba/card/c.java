package com.baidu.tieba.card;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends a<com.baidu.tieba.card.a.d> {
    private HeadImageView aOL;
    private TextView aOM;
    private TextView aON;
    private TextView aOO;
    private TextView aOP;
    private AppDownloadView aOQ;
    private TbImageView aOR;
    private View aOS;
    private com.baidu.tieba.card.a.d aOT;
    private int aOU;
    private final int aOV;
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
        this.aOU = resources.getDimensionPixelSize(t.e.ds70);
        int dimensionPixelSize = resources.getDimensionPixelSize(t.e.ds96);
        this.imageWidth = (int) (resources.getDimension(t.e.ds594) - resources.getDimension(t.e.ds20));
        this.imageHeight = (int) (resources.getDimension(t.e.ds260) - resources.getDimension(t.e.ds10));
        this.maxWidth = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getContext()) - dimensionPixelSize;
        this.maxHeight = resources.getDimensionPixelSize(t.e.ds321);
        this.aOV = resources.getDimensionPixelSize(t.e.ds30);
        L(getView());
    }

    private void L(View view) {
        this.mRootView = view.findViewById(t.g.root_view);
        this.aOL = (HeadImageView) view.findViewById(t.g.advert_app_head_img);
        this.aOM = (TextView) view.findViewById(t.g.advert_app_title);
        this.aON = (TextView) view.findViewById(t.g.advert_app_content);
        this.aOR = (TbImageView) view.findViewById(t.g.advert_app_img);
        this.aOP = (TextView) view.findViewById(t.g.advert_app_push);
        this.aOO = (TextView) view.findViewById(t.g.advert_app_btn);
        this.aOQ = (AppDownloadView) view.findViewById(t.g.advert_app_download_view);
        this.aOS = view.findViewById(t.g.top_line);
        this.aOL.setOnClickListener(this);
        this.aOM.setOnClickListener(this);
        this.aOP.setOnClickListener(this);
        this.aOO.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.aOL.setDefaultResource(17170445);
        this.aOL.setDefaultBgResource(t.f.icon_default_avatar_round);
        this.aOL.setRadius(this.aOU);
        this.aOR.setDrawBorder(true);
        this.aOR.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.c Kp = this.aOT.Kp();
        if (Kp != null) {
            a(Kp, true, 0);
            if (Kp.rO()) {
                b(Kp);
            } else {
                a(Kp, this.aOT.getPosition(), this.aOO, this.aOQ);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.k(this.mRootView, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.ar.k(this.aOP, t.f.icon_tuiguang);
            com.baidu.tbadk.core.util.ar.k(this.aOS, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ar.b(this.aOM, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ar.b(this.aOP, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ar.b(this.aON, t.d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int JM() {
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
        this.aOT = dVar;
        this.aOL.d(dVar.Kl(), 10, false);
        this.aOM.setText(UtilHelper.getFixedText(dVar.getUserName(), 7, true));
        if (dVar.rO()) {
            this.aOM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.aOM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_tuiguang), (Drawable) null);
        }
        String Km = dVar.Km();
        if (!TextUtils.isEmpty(Km)) {
            this.aON.setText(getFixedChineseString(com.baidu.tbadk.core.util.aw.d(Km, 29, "...")));
        } else {
            this.aON.setVisibility(8);
        }
        String Ko = dVar.Ko();
        boolean rt = com.baidu.tbadk.core.l.rn().rt();
        boolean a = a(this.aOR, dVar.Kp());
        if (rt && !TextUtils.isEmpty(Ko) && a) {
            this.aOR.setVisibility(0);
            this.aON.setPadding(0, 0, 0, 0);
            this.aOR.d(Ko, this.mIsFromCDN ? 30 : 31, false);
        } else {
            this.aOR.setVisibility(8);
        }
        String Kn = dVar.Kn();
        boolean z2 = dVar.rO() && TextUtils.isEmpty(Kn);
        b(this.aOP, z2);
        c(this.aOO, !z2);
        if (dVar.rN()) {
            DownloadData a2 = a(dVar.Kp(), this.aOT.getPosition());
            a2.setStatus(AppDownloadView.b(a2));
            a(this.aOO, a2.getStatus(), Kn);
            if (a2.getStatus() != 1 && a2.getStatus() != 7) {
                z = false;
            }
            this.aOQ.setVisibility(z ? 0 : 8);
            if (z) {
                this.aOQ.a(com.baidu.tieba.card.a.d.aRP, a2);
                return;
            }
            return;
        }
        if (!z2 && !TextUtils.isEmpty(Kn)) {
            this.aOO.setText(Kn);
        }
        this.aOQ.setVisibility(8);
    }

    private void b(TextView textView, boolean z) {
        textView.setVisibility(z ? 0 : 8);
    }

    private void c(TextView textView, boolean z) {
        if (!z) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        com.baidu.tbadk.core.util.ar.k(textView, t.f.btn_focus_border_bg);
        com.baidu.tbadk.core.util.ar.b(textView, t.d.btn_forum_focus_color, 1);
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
        if (cVar == null || cVar.UI == null || tbImageView == null) {
            a(tbImageView, this.imageHeight, this.imageWidth);
            return true;
        }
        int i = this.maxWidth;
        if (!cVar.UI.UY) {
            a(tbImageView, (this.imageHeight * i) / this.imageWidth, i);
            return true;
        }
        int i2 = cVar.UI.height;
        int i3 = cVar.UI.width;
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
        DownloadData downloadData = new DownloadData(cVar.Uy);
        downloadData.setUrl(cVar.Ux);
        downloadData.setName(cVar.Uu);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(cVar.Ut, 0));
        return downloadData;
    }

    private void a(com.baidu.tbadk.core.data.c cVar, int i, TextView textView, AppDownloadView appDownloadView) {
        if (cVar != null) {
            int b = AppDownloadView.b(a(cVar, i));
            if (6 == b) {
                if (com.baidu.adp.lib.util.i.iZ() && !com.baidu.adp.lib.util.i.ja()) {
                    a(cVar, i, true);
                    return;
                }
                appDownloadView.setVisibility(0);
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
                    com.baidu.tieba.tbadkCore.ag.N(JK().getPageActivity(), cVar.Uy);
                    return;
                case 6:
                case 7:
                    textView.setText(t.j.downloading2);
                    b(cVar, i);
                    return;
            }
        }
    }

    private void b(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            be.wt().a(JK(), new String[]{cVar.Uw}, true);
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, int i, boolean z) {
        if (cVar != null) {
            if (!com.baidu.adp.lib.util.i.iN()) {
                com.baidu.adp.lib.util.k.showToast(JK().getPageActivity(), t.j.neterror);
            } else if (cVar.rO()) {
                b(cVar);
            } else if (cVar.rN()) {
                String trim = cVar.UI.UT.trim();
                if (com.baidu.adp.lib.util.i.iZ() && !com.baidu.adp.lib.util.i.ja()) {
                    trim = JK().getString(t.j.frs_network_tips);
                }
                if (TextUtils.isEmpty(trim)) {
                    trim = JK().getString(t.j.confirm);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(JK().getPageActivity());
                aVar.cE(trim);
                aVar.a(t.j.alert_yes_button, new d(this, cVar, i));
                aVar.b(t.j.alert_no_button, new e(this));
                aVar.b(JK()).uj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            if (!cVar.rM()) {
                com.baidu.adp.lib.util.k.showToast(JK().getPageActivity(), t.j.pb_app_error);
            } else {
                com.baidu.tieba.tbadkCore.ag.a(JK().getPageActivity(), cVar, i);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.c cVar, boolean z, int i) {
        com.baidu.tbadk.distribute.a.Cl().a(cVar, "", 0L, "NEWINDEX", "click", i);
        com.baidu.tieba.recapp.report.b.aEK().a(com.baidu.tieba.recapp.report.e.a(cVar, "click", i));
    }

    private static void c(com.baidu.tbadk.core.data.c cVar, int i) {
        com.baidu.tbadk.distribute.a.Cl().a(cVar, "", 0L, "NEWINDEX", "show", i);
        com.baidu.tieba.recapp.report.b.aEK().a(com.baidu.tieba.recapp.report.e.a(cVar, "show", i));
    }

    public static void a(com.baidu.tieba.card.a.d dVar, int i) {
        c(dVar.Kp(), i);
    }
}
