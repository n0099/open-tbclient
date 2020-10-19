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
public class ac {
    private TbPageContext context;
    private View.OnClickListener eTU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ac.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap bfh = ac.this.bfh();
            if (view.getId() == ac.this.eia.getId()) {
                ac.this.t(bfh);
            } else if (view.getId() == ac.this.eib.getId()) {
                ac.this.d(bfh, 3);
            } else if (view.getId() == ac.this.eic.getId()) {
                ac.this.d(bfh, 2);
            } else if (view.getId() == ac.this.eid.getId()) {
                ac.this.d(bfh, 4);
            } else if (view.getId() == ac.this.eie.getId()) {
                ac.this.d(bfh, 8);
            } else if (view.getId() == ac.this.eif.getId()) {
                ac.this.d(bfh, 6);
            }
        }
    };
    private TextView eia;
    private TextView eib;
    private TextView eic;
    private TextView eid;
    private TextView eie;
    private TextView eif;
    private com.baidu.tieba.pb.pb.main.bd eii;
    private Bitmap eij;
    private String forumName;
    private int from;
    private b ite;
    private View itf;
    private String itg;
    private a ith;
    private PermissionJudgePolicy mPermissionJudgement;

    /* loaded from: classes22.dex */
    public interface a {
        void cuw();

        void cux();
    }

    /* loaded from: classes22.dex */
    public interface b {
        void ys(int i);
    }

    public ac(TbPageContext tbPageContext) {
        this.context = tbPageContext;
    }

    public void a(View view, View view2, a aVar) {
        if (view != null) {
            this.eia = (TextView) view.findViewById(R.id.frs_private_share_download);
            a(this.eia, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
            this.eia.setOnClickListener(this.eTU);
            this.eib = (TextView) view.findViewById(R.id.frs_private_share_wechat);
            a(this.eib, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
            this.eib.setOnClickListener(this.eTU);
            this.eic = (TextView) view.findViewById(R.id.frs_private_share_moment);
            a(this.eic, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
            this.eic.setOnClickListener(this.eTU);
            this.eid = (TextView) view.findViewById(R.id.frs_private_share_qzone);
            a(this.eid, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
            this.eid.setOnClickListener(this.eTU);
            this.eie = (TextView) view.findViewById(R.id.frs_private_share_qq);
            a(this.eie, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
            this.eie.setOnClickListener(this.eTU);
            this.eif = (TextView) view.findViewById(R.id.frs_private_share_weibo);
            a(this.eif, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
            this.eif.setOnClickListener(this.eTU);
            this.itf = view2;
            this.ith = aVar;
        }
    }

    public void setData(String str, String str2) {
        this.itg = str;
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
        if (!bfi()) {
            if (this.ite != null) {
                this.ite.ys(1);
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13724");
            aqVar.aj("obj_type", 1);
            aqVar.aj("obj_source", this.from);
            TiebaStatic.log(aqVar);
            if (this.eii == null) {
                this.eii = new com.baidu.tieba.pb.pb.main.bd(this.context);
            }
            this.eii.j(this.itg, BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
    }

    private boolean bfi() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.context.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.context.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bfi()) {
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
            if (this.ite != null) {
                this.ite.ys(i2);
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13724");
            if (i == 3) {
                aqVar.aj("obj_type", 2);
            } else if (i == 2) {
                aqVar.aj("obj_type", 3);
            } else if (i == 8) {
                aqVar.aj("obj_type", 4);
            } else if (i == 4) {
                aqVar.aj("obj_type", 5);
            } else if (i == 6) {
                aqVar.aj("obj_type", 6);
            }
            aqVar.aj("obj_source", this.from);
            TiebaStatic.log(aqVar);
            com.baidu.tbadk.util.ae.a(new com.baidu.tbadk.util.ad<ShareItem>() { // from class: com.baidu.tieba.frs.ac.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: bfj */
                public ShareItem doInBackground() {
                    return ac.this.e(bitmap, i);
                }
            }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.frs.ac.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
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
        shareItem.eSW = false;
        shareItem.eSV = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.forumName + this.context.getString(R.string.core_bar) + "]" + UgcConstant.AT_RULE_TAG + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + com.baidu.adp.lib.util.k.getUrlEncode(this.forumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bte();
        return shareItem;
    }

    public Bitmap bfh() {
        if (this.eij == null) {
            if (this.ith != null) {
                this.ith.cux();
            }
            this.itf.buildDrawingCache();
            this.eij = this.itf.getDrawingCache();
            if (this.ith != null) {
                this.ith.cuw();
            }
        }
        return this.eij;
    }

    public void a(b bVar) {
        this.ite = bVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
