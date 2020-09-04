package com.baidu.tieba.frs;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
/* loaded from: classes16.dex */
public class ac {
    private TbPageContext context;
    private TextView dTO;
    private TextView dTP;
    private TextView dTQ;
    private TextView dTR;
    private TextView dTS;
    private TextView dTT;
    private com.baidu.tieba.pb.pb.main.bd dTW;
    private Bitmap dTX;
    private View.OnClickListener eFG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ac.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap bbF = ac.this.bbF();
            if (view.getId() == ac.this.dTO.getId()) {
                ac.this.t(bbF);
            } else if (view.getId() == ac.this.dTP.getId()) {
                ac.this.d(bbF, 3);
            } else if (view.getId() == ac.this.dTQ.getId()) {
                ac.this.d(bbF, 2);
            } else if (view.getId() == ac.this.dTR.getId()) {
                ac.this.d(bbF, 4);
            } else if (view.getId() == ac.this.dTS.getId()) {
                ac.this.d(bbF, 8);
            } else if (view.getId() == ac.this.dTT.getId()) {
                ac.this.d(bbF, 6);
            }
        }
    };
    private String forumName;
    private int from;
    private b hXd;
    private View hXe;
    private String hXf;
    private a hXg;
    private PermissionJudgePolicy mPermissionJudgement;

    /* loaded from: classes16.dex */
    public interface a {
        void cnL();

        void cnM();
    }

    /* loaded from: classes16.dex */
    public interface b {
        void xn(int i);
    }

    public ac(TbPageContext tbPageContext) {
        this.context = tbPageContext;
    }

    public void a(View view, View view2, a aVar) {
        if (view != null) {
            this.dTO = (TextView) view.findViewById(R.id.frs_private_share_download);
            a(this.dTO, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
            this.dTO.setOnClickListener(this.eFG);
            this.dTP = (TextView) view.findViewById(R.id.frs_private_share_wechat);
            a(this.dTP, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
            this.dTP.setOnClickListener(this.eFG);
            this.dTQ = (TextView) view.findViewById(R.id.frs_private_share_moment);
            a(this.dTQ, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
            this.dTQ.setOnClickListener(this.eFG);
            this.dTR = (TextView) view.findViewById(R.id.frs_private_share_qzone);
            a(this.dTR, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
            this.dTR.setOnClickListener(this.eFG);
            this.dTS = (TextView) view.findViewById(R.id.frs_private_share_qq);
            a(this.dTS, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
            this.dTS.setOnClickListener(this.eFG);
            this.dTT = (TextView) view.findViewById(R.id.frs_private_share_weibo);
            a(this.dTT, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
            this.dTT.setOnClickListener(this.eFG);
            this.hXe = view2;
            this.hXg = aVar;
        }
    }

    public void setData(String str, String str2) {
        this.hXf = str;
        this.forumName = str2;
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            Drawable drawable = aVar.getDrawable();
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.context.getPageActivity(), R.dimen.tbds88);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            com.baidu.tbadk.core.util.ap.setViewTextColor(textView, R.color.cp_cont_f);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = getTextViewWidth();
            textView.setLayoutParams(layoutParams);
        }
    }

    private int getTextViewWidth() {
        int equipmentWidth;
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.context.getPageActivity(), R.dimen.tbds44);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.context.getPageActivity(), R.dimen.tbds54);
        if (UtilHelper.getRealScreenOrientation(this.context.getPageActivity()) == 2) {
            equipmentWidth = (com.baidu.adp.lib.util.l.getEquipmentHeight(this.context.getPageActivity()) - (dimens * 2)) - dimens2;
        } else {
            equipmentWidth = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.context.getPageActivity()) - (dimens * 2)) - dimens2;
        }
        return equipmentWidth / 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Bitmap bitmap) {
        if (!bbG()) {
            if (this.hXd != null) {
                this.hXd.xn(1);
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13724");
            aqVar.ai("obj_type", 1);
            aqVar.ai("obj_source", this.from);
            TiebaStatic.log(aqVar);
            if (this.dTW == null) {
                this.dTW = new com.baidu.tieba.pb.pb.main.bd(this.context);
            }
            this.dTW.j(this.hXf, BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
    }

    private boolean bbG() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.context.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.context.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bbG()) {
            int i2 = 1;
            if (i == 3) {
                i2 = 2;
            } else if (i == 2) {
                i2 = 3;
            } else if (i == 4) {
                i2 = 4;
            } else if (i == 8) {
                i2 = 5;
            } else if (i == 6) {
                i2 = 6;
            }
            if (this.hXd != null) {
                this.hXd.xn(i2);
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13724");
            if (i == 3) {
                aqVar.ai("obj_type", 2);
            } else if (i == 2) {
                aqVar.ai("obj_type", 3);
            } else if (i == 8) {
                aqVar.ai("obj_type", 4);
            } else if (i == 4) {
                aqVar.ai("obj_type", 5);
            } else if (i == 6) {
                aqVar.ai("obj_type", 6);
            }
            aqVar.ai("obj_source", this.from);
            TiebaStatic.log(aqVar);
            com.baidu.tbadk.util.ad.a(new com.baidu.tbadk.util.ac<ShareItem>() { // from class: com.baidu.tieba.frs.ac.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: bbH */
                public ShareItem doInBackground() {
                    return ac.this.e(bitmap, i);
                }
            }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tieba.frs.ac.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: b */
                public void onReturnDataInUI(ShareItem shareItem) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(ac.this.context.getPageActivity(), i, shareItem, false));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem e(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.eEJ = false;
        shareItem.eEI = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.forumName + this.context.getString(R.string.core_bar) + "]" + UgcConstant.AT_RULE_TAG + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + com.baidu.adp.lib.util.k.getUrlEncode(this.forumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bpA();
        return shareItem;
    }

    public Bitmap bbF() {
        if (this.dTX == null) {
            if (this.hXg != null) {
                this.hXg.cnM();
            }
            this.hXe.buildDrawingCache();
            this.dTX = this.hXe.getDrawingCache();
            if (this.hXg != null) {
                this.hXg.cnL();
            }
        }
        return this.dTX;
    }

    public void a(b bVar) {
        this.hXd = bVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
