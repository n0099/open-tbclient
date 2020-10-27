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
    private TextView eqA;
    private TextView eqB;
    private TextView eqC;
    private TextView eqD;
    private com.baidu.tieba.pb.pb.main.bd eqG;
    private Bitmap eqH;
    private TextView eqy;
    private TextView eqz;
    private View.OnClickListener fcr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ac.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap bha = ac.this.bha();
            if (view.getId() == ac.this.eqy.getId()) {
                ac.this.t(bha);
            } else if (view.getId() == ac.this.eqz.getId()) {
                ac.this.d(bha, 3);
            } else if (view.getId() == ac.this.eqA.getId()) {
                ac.this.d(bha, 2);
            } else if (view.getId() == ac.this.eqB.getId()) {
                ac.this.d(bha, 4);
            } else if (view.getId() == ac.this.eqC.getId()) {
                ac.this.d(bha, 8);
            } else if (view.getId() == ac.this.eqD.getId()) {
                ac.this.d(bha, 6);
            }
        }
    };
    private String forumName;
    private int from;
    private b iFA;
    private View iFB;
    private String iFC;
    private a iFD;
    private PermissionJudgePolicy mPermissionJudgement;

    /* loaded from: classes22.dex */
    public interface a {
        void cxD();

        void cxE();
    }

    /* loaded from: classes22.dex */
    public interface b {
        void yL(int i);
    }

    public ac(TbPageContext tbPageContext) {
        this.context = tbPageContext;
    }

    public void a(View view, View view2, a aVar) {
        if (view != null) {
            this.eqy = (TextView) view.findViewById(R.id.frs_private_share_download);
            a(this.eqy, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
            this.eqy.setOnClickListener(this.fcr);
            this.eqz = (TextView) view.findViewById(R.id.frs_private_share_wechat);
            a(this.eqz, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
            this.eqz.setOnClickListener(this.fcr);
            this.eqA = (TextView) view.findViewById(R.id.frs_private_share_moment);
            a(this.eqA, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
            this.eqA.setOnClickListener(this.fcr);
            this.eqB = (TextView) view.findViewById(R.id.frs_private_share_qzone);
            a(this.eqB, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
            this.eqB.setOnClickListener(this.fcr);
            this.eqC = (TextView) view.findViewById(R.id.frs_private_share_qq);
            a(this.eqC, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
            this.eqC.setOnClickListener(this.fcr);
            this.eqD = (TextView) view.findViewById(R.id.frs_private_share_weibo);
            a(this.eqD, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
            this.eqD.setOnClickListener(this.fcr);
            this.iFB = view2;
            this.iFD = aVar;
        }
    }

    public void setData(String str, String str2) {
        this.iFC = str;
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
        if (!bhb()) {
            if (this.iFA != null) {
                this.iFA.yL(1);
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13724");
            aqVar.aj("obj_type", 1);
            aqVar.aj("obj_source", this.from);
            TiebaStatic.log(aqVar);
            if (this.eqG == null) {
                this.eqG = new com.baidu.tieba.pb.pb.main.bd(this.context);
            }
            this.eqG.j(this.iFC, BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
    }

    private boolean bhb() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.context.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.context.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bhb()) {
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
            if (this.iFA != null) {
                this.iFA.yL(i2);
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
                /* renamed from: bhc */
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
        shareItem.fbs = false;
        shareItem.fbr = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.forumName + this.context.getString(R.string.core_bar) + "]" + UgcConstant.AT_RULE_TAG + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + com.baidu.adp.lib.util.k.getUrlEncode(this.forumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.buX();
        return shareItem;
    }

    public Bitmap bha() {
        if (this.eqH == null) {
            if (this.iFD != null) {
                this.iFD.cxE();
            }
            this.iFB.buildDrawingCache();
            this.eqH = this.iFB.getDrawingCache();
            if (this.iFD != null) {
                this.iFD.cxD();
            }
        }
        return this.eqH;
    }

    public void a(b bVar) {
        this.iFA = bVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
