package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    private LinearLayout bOF;
    private Context context;
    private TbImageView eXD;
    private HeadImageView exw;
    private BarImageView fHt;
    private LinearGradientView fSH;
    private ImageOverlayView fUo;
    private FrsViewData fUt;
    private TextView fXU;
    private TextView fXV;
    private TextView fXW;
    private TextView fXX;
    private TextView fXY;
    private TextView fXZ;
    private TextView fYa;
    private TextView fYb;
    private TextView fYc;
    private ImageView fYd;
    private RelativeLayout fYe;
    private HeadImageView fYf;
    private TextView fYg;
    private TextView fYh;
    private au fYi;
    private Bitmap fYj;
    private ForumActiveInfo fYk;
    private TextView fuT;
    private String mForumName;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean d(FrsViewData frsViewData, TbPageContext tbPageContext) {
        this.fUt = frsViewData;
        this.mPageContext = tbPageContext;
        this.fYk = frsViewData.getForumActiveInfo();
        ap(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.fuT.setVisibility(0);
                this.fuT.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.fuT.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.fHt.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.exw.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.exw.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.fYg.setText(frsViewData.getUserData().getName_show());
                this.fYg.setVisibility(0);
            } else {
                this.fYg.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.fXU.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.fXU.setText(frsViewData.getForum().getSlogan());
            } else {
                this.fXU.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.fYh.setVisibility(0);
                this.fYh.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.fYh.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                ym(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ym("https://tieba.baidu.com/f?kw=" + frsViewData.getForum().getName() + "&fr=frsshare");
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.fXW.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.fXW.setText(getResources().getString(R.string.wait_for_you_join));
            }
            ArrayList arrayList = new ArrayList();
            if (frsViewData.userList != null) {
                for (int i = 0; i < frsViewData.userList.size() && !StringUtils.isNull(frsViewData.userList.get(i).portrait); i++) {
                    arrayList.add(frsViewData.userList.get(i).portrait);
                    if (arrayList.size() >= 5) {
                        break;
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.fUo.setData(arrayList);
                this.fUo.setVisibility(0);
                this.fYf.setVisibility(8);
                return;
            }
            this.fUo.setVisibility(8);
            this.fYf.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.fYf.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.fYf.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.bOF = (LinearLayout) findViewById(R.id.frs_private_share);
        am.k(this.bOF, R.drawable.bg_frs_private_dialog);
        this.fYe = (RelativeLayout) this.bOF.findViewById(R.id.frs_private_share_view);
        am.k(this.fYe, R.drawable.bg_frs_private_dialog);
        this.fSH = (LinearGradientView) this.bOF.findViewById(R.id.frs_private_top_gradient_bg);
        this.fSH.setCornerRadius(l.g(context, R.dimen.tbds30));
        this.fSH.setRoundMode(3);
        this.eXD = (TbImageView) this.bOF.findViewById(R.id.frs_private_top_bg_mask);
        this.eXD.setDefaultBgResource(R.color.transparent);
        this.eXD.setDefaultResource(R.drawable.pic_frs_head_default);
        this.eXD.setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.eXD.setConrers(3);
        buC();
        this.fuT = (TextView) this.bOF.findViewById(R.id.frs_private_share_name);
        am.j(this.fuT, R.color.cp_cont_a);
        this.fXU = (TextView) this.bOF.findViewById(R.id.frs_private_share_brief);
        am.j(this.fXU, R.color.cp_cont_f);
        this.fYd = (ImageView) this.bOF.findViewById(R.id.frs_private_share_qrcode);
        this.fHt = (BarImageView) this.bOF.findViewById(R.id.frs_private_share_portrait);
        this.fHt.setShowOval(true);
        this.fHt.setStrokeWith(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.fHt.setStrokeColorResId(R.color.cp_bg_line_d);
        this.exw = (HeadImageView) this.bOF.findViewById(R.id.photo);
        this.fXV = (TextView) this.bOF.findViewById(R.id.frs_user_name_identify);
        this.exw.setDefaultBgResource(R.color.cp_bg_line_e);
        this.exw.setIsRound(true);
        this.exw.setTag(null);
        am.k(this.fXV, R.drawable.username_text_bg);
        this.fXW = (TextView) this.bOF.findViewById(R.id.frs_private_share_time);
        am.j(this.fXW, R.color.cp_cont_f);
        this.fXX = (TextView) this.bOF.findViewById(R.id.frs_private_share_download);
        a(this.fXX, new com.baidu.tbadk.core.util.f.c(R.drawable.icon_share_download_n_svg));
        this.fXX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.A(FrsPrivateShareDialogView.this.bqQ());
            }
        });
        this.fXY = (TextView) this.bOF.findViewById(R.id.frs_private_share_wechat);
        a(this.fXY, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_wechat_n_svg));
        this.fXY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bqQ(), 3);
            }
        });
        this.fXZ = (TextView) this.bOF.findViewById(R.id.frs_private_share_moment);
        a(this.fXZ, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_circle_n_svg));
        this.fXZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bqQ(), 2);
            }
        });
        this.fYa = (TextView) this.bOF.findViewById(R.id.frs_private_share_qzone);
        a(this.fYa, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qqzone_n_svg));
        this.fYa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bqQ(), 4);
            }
        });
        this.fYb = (TextView) this.bOF.findViewById(R.id.frs_private_share_qq);
        a(this.fYb, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qq_n_svg));
        this.fYb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bqQ(), 8);
            }
        });
        this.fYc = (TextView) this.bOF.findViewById(R.id.frs_private_share_weibo);
        a(this.fYc, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_weibo_n_svg));
        this.fYc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bqQ(), 6);
            }
        });
        this.fUo = (ImageOverlayView) this.bOF.findViewById(R.id.frs_private_overlayview);
        int g = l.g(getContext(), R.dimen.tbds68);
        this.fUo.j(5, g, g, 0, 0, l.g(getContext(), R.dimen.tbds16));
        this.fUo.setOrientation(true);
        this.fUo.setLoadImageType(12);
        this.fUo.onChangeSkinType();
        this.fYf = (HeadImageView) this.bOF.findViewById(R.id.bar_friend_icon);
        this.fYf.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fYf.setIsRound(true);
        this.fYg = (TextView) this.bOF.findViewById(R.id.frs_user_name);
        am.j(this.fYg, R.color.cp_cont_b);
        this.fYh = (TextView) this.bOF.findViewById(R.id.frs_user_name_identify);
        am.j(this.fYh, R.color.cp_cont_a);
    }

    private void ym(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.fYd.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.f.a aVar) {
        if (aVar != null) {
            Drawable drawable = aVar.getDrawable();
            int g = l.g(getContext(), R.dimen.tbds88);
            drawable.setBounds(0, 0, g, g);
            textView.setCompoundDrawables(null, drawable, null, null);
            am.j(textView, R.color.cp_cont_f);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = getTextViewWidth();
            textView.setLayoutParams(layoutParams);
        }
    }

    private void buC() {
        ThemeElement themeElement;
        if (this.fUt != null && this.fUt.getForum() != null) {
            ThemeColorInfo themeColorInfo = this.fUt.getForum().getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                this.eXD.setVisibility(8);
                this.fSH.setDefaultGradientColor();
                return;
            }
            this.eXD.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            this.fSH.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.eXD.startLoad(themeElement.pattern_image, 10, false);
        }
    }

    private int getTextViewWidth() {
        int af;
        int g = l.g(this.context, R.dimen.tbds44);
        int g2 = l.g(this.context, R.dimen.tbds54);
        if (UtilHelper.getRealScreenOrientation(this.context) == 2) {
            af = (l.ah(this.context) - (g * 2)) - g2;
        } else {
            af = (l.af(this.context) - (g * 2)) - g2;
        }
        return af / 6;
    }

    public Bitmap bqQ() {
        if (this.fYj == null) {
            this.fYe.buildDrawingCache();
            this.fYj = this.fYe.getDrawingCache();
        }
        return this.fYj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Bitmap bitmap) {
        if (!buD()) {
            tv(1);
            if (this.fYi == null) {
                this.fYi = new au(this.mPageContext);
            }
            if (this.fYk != null) {
                this.fYi.h(aq.isEmpty(this.fYk.forum_share_url) ? "http://tieba.baidu.com" : this.fYk.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.fYi.h("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean buD() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
        }
        this.mPermissionJudgement.ake();
        this.mPermissionJudgement.e(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.ad(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Bitmap bitmap, final int i) {
        int i2 = 2;
        if (bitmap != null && !buD()) {
            if (i != 3) {
                if (i == 2) {
                    i2 = 3;
                } else if (i == 4) {
                    i2 = 4;
                } else if (i == 8) {
                    i2 = 5;
                } else {
                    i2 = i == 6 ? 6 : 1;
                }
            }
            tv(i2);
            z.a(new y<com.baidu.tbadk.coreExtra.c.e>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.y
                /* renamed from: bqP */
                public com.baidu.tbadk.coreExtra.c.e doInBackground() {
                    return FrsPrivateShareDialogView.this.d(bitmap, i);
                }
            }, new j<com.baidu.tbadk.coreExtra.c.e>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.j
                /* renamed from: o */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.e eVar) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(FrsPrivateShareDialogView.this.context, i, eVar, false));
                }
            });
        }
    }

    private void tv(int i) {
        TiebaStatic.log(new an("c13385").bT("fid", this.fUt.getForum().getId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.coreExtra.c.e d(Bitmap bitmap, int i) {
        com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
        eVar.clZ = false;
        eVar.clY = false;
        eVar.shareType = 1;
        if (i == 6) {
            eVar.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.mForumName + this.context.getString(R.string.core_bar) + "]@" + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + k.bi(this.mForumName) + "&fr=frsshare";
        } else {
            eVar.title = this.context.getString(R.string.app_name);
        }
        eVar.content = "";
        eVar.n(bitmap);
        eVar.aqn();
        return eVar;
    }
}
