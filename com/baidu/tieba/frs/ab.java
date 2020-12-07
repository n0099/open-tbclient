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
/* loaded from: classes22.dex */
public class ab {
    private TbPageContext context;
    private TextView eBK;
    private TextView eBL;
    private TextView eBM;
    private TextView eBN;
    private TextView eBO;
    private TextView eBP;
    private com.baidu.tieba.pb.pb.main.bd eBS;
    private Bitmap eBT;
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ab.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap blO = ab.this.blO();
            if (view.getId() == ab.this.eBK.getId()) {
                ab.this.t(blO);
            } else if (view.getId() == ab.this.eBL.getId()) {
                ab.this.d(blO, 3);
            } else if (view.getId() == ab.this.eBM.getId()) {
                ab.this.d(blO, 2);
            } else if (view.getId() == ab.this.eBN.getId()) {
                ab.this.d(blO, 4);
            } else if (view.getId() == ab.this.eBO.getId()) {
                ab.this.d(blO, 8);
            } else if (view.getId() == ab.this.eBP.getId()) {
                ab.this.d(blO, 6);
            }
        }
    };
    private String forumName;
    private int from;
    private b iXb;
    private View iXc;
    private String iXd;
    private a iXe;
    private PermissionJudgePolicy mPermissionJudgement;

    /* loaded from: classes22.dex */
    public interface a {
        void cDX();

        void cDY();
    }

    /* loaded from: classes22.dex */
    public interface b {
        void Ab(int i);
    }

    public ab(TbPageContext tbPageContext) {
        this.context = tbPageContext;
    }

    public void a(View view, View view2, a aVar) {
        if (view != null) {
            this.eBK = (TextView) view.findViewById(R.id.frs_private_share_download);
            a(this.eBK, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
            this.eBK.setOnClickListener(this.foP);
            this.eBL = (TextView) view.findViewById(R.id.frs_private_share_wechat);
            a(this.eBL, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
            this.eBL.setOnClickListener(this.foP);
            this.eBM = (TextView) view.findViewById(R.id.frs_private_share_moment);
            a(this.eBM, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
            this.eBM.setOnClickListener(this.foP);
            this.eBN = (TextView) view.findViewById(R.id.frs_private_share_qzone);
            a(this.eBN, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
            this.eBN.setOnClickListener(this.foP);
            this.eBO = (TextView) view.findViewById(R.id.frs_private_share_qq);
            a(this.eBO, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
            this.eBO.setOnClickListener(this.foP);
            this.eBP = (TextView) view.findViewById(R.id.frs_private_share_weibo);
            a(this.eBP, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
            this.eBP.setOnClickListener(this.foP);
            this.iXc = view2;
            this.iXe = aVar;
        }
    }

    public void setData(String str, String str2) {
        this.iXd = str;
        this.forumName = str2;
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            Drawable drawable = aVar.getDrawable();
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.context.getPageActivity(), R.dimen.tbds88);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            com.baidu.tbadk.core.util.ap.setViewTextColor(textView, R.color.CAM_X0106);
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
        if (!blP()) {
            if (this.iXb != null) {
                this.iXb.Ab(1);
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13724");
            arVar.al("obj_type", 1);
            arVar.al("obj_source", this.from);
            TiebaStatic.log(arVar);
            if (this.eBS == null) {
                this.eBS = new com.baidu.tieba.pb.pb.main.bd(this.context);
            }
            this.eBS.j(this.iXd, BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
    }

    private boolean blP() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.context.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.context.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !blP()) {
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
            if (this.iXb != null) {
                this.iXb.Ab(i2);
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13724");
            if (i == 3) {
                arVar.al("obj_type", 2);
            } else if (i == 2) {
                arVar.al("obj_type", 3);
            } else if (i == 8) {
                arVar.al("obj_type", 4);
            } else if (i == 4) {
                arVar.al("obj_type", 5);
            } else if (i == 6) {
                arVar.al("obj_type", 6);
            }
            arVar.al("obj_source", this.from);
            TiebaStatic.log(arVar);
            com.baidu.tbadk.util.ad.a(new com.baidu.tbadk.util.ac<ShareItem>() { // from class: com.baidu.tieba.frs.ab.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: blQ */
                public ShareItem doInBackground() {
                    return ab.this.e(bitmap, i);
                }
            }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.frs.ab.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: a */
                public void onReturnDataInUI(ShareItem shareItem) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(ab.this.context.getPageActivity(), i, shareItem, false));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem e(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.fnR = false;
        shareItem.fnQ = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.forumName + this.context.getString(R.string.core_bar) + "]" + UgcConstant.AT_RULE_TAG + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + com.baidu.adp.lib.util.k.getUrlEncode(this.forumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bAm();
        return shareItem;
    }

    public Bitmap blO() {
        if (this.eBT == null) {
            if (this.iXe != null) {
                this.iXe.cDY();
            }
            this.iXc.buildDrawingCache();
            this.eBT = this.iXc.getDrawingCache();
            if (this.iXe != null) {
                this.iXe.cDX();
            }
        }
        return this.eBT;
    }

    public void a(b bVar) {
        this.iXb = bVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
