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
/* loaded from: classes21.dex */
public class ac {
    private TbPageContext context;
    private TextView euI;
    private TextView euJ;
    private TextView euK;
    private TextView euL;
    private TextView euM;
    private TextView euN;
    private com.baidu.tieba.pb.pb.main.bd euQ;
    private Bitmap euR;
    private View.OnClickListener fhp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ac.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap biE = ac.this.biE();
            if (view.getId() == ac.this.euI.getId()) {
                ac.this.t(biE);
            } else if (view.getId() == ac.this.euJ.getId()) {
                ac.this.d(biE, 3);
            } else if (view.getId() == ac.this.euK.getId()) {
                ac.this.d(biE, 2);
            } else if (view.getId() == ac.this.euL.getId()) {
                ac.this.d(biE, 4);
            } else if (view.getId() == ac.this.euM.getId()) {
                ac.this.d(biE, 8);
            } else if (view.getId() == ac.this.euN.getId()) {
                ac.this.d(biE, 6);
            }
        }
    };
    private String forumName;
    private int from;
    private b iMk;
    private View iMl;
    private String iMm;
    private a iMn;
    private PermissionJudgePolicy mPermissionJudgement;

    /* loaded from: classes21.dex */
    public interface a {
        void czH();

        void czI();
    }

    /* loaded from: classes21.dex */
    public interface b {
        void zw(int i);
    }

    public ac(TbPageContext tbPageContext) {
        this.context = tbPageContext;
    }

    public void a(View view, View view2, a aVar) {
        if (view != null) {
            this.euI = (TextView) view.findViewById(R.id.frs_private_share_download);
            a(this.euI, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
            this.euI.setOnClickListener(this.fhp);
            this.euJ = (TextView) view.findViewById(R.id.frs_private_share_wechat);
            a(this.euJ, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
            this.euJ.setOnClickListener(this.fhp);
            this.euK = (TextView) view.findViewById(R.id.frs_private_share_moment);
            a(this.euK, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
            this.euK.setOnClickListener(this.fhp);
            this.euL = (TextView) view.findViewById(R.id.frs_private_share_qzone);
            a(this.euL, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
            this.euL.setOnClickListener(this.fhp);
            this.euM = (TextView) view.findViewById(R.id.frs_private_share_qq);
            a(this.euM, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
            this.euM.setOnClickListener(this.fhp);
            this.euN = (TextView) view.findViewById(R.id.frs_private_share_weibo);
            a(this.euN, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
            this.euN.setOnClickListener(this.fhp);
            this.iMl = view2;
            this.iMn = aVar;
        }
    }

    public void setData(String str, String str2) {
        this.iMm = str;
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
        if (!biF()) {
            if (this.iMk != null) {
                this.iMk.zw(1);
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13724");
            arVar.ak("obj_type", 1);
            arVar.ak("obj_source", this.from);
            TiebaStatic.log(arVar);
            if (this.euQ == null) {
                this.euQ = new com.baidu.tieba.pb.pb.main.bd(this.context);
            }
            this.euQ.j(this.iMm, BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
    }

    private boolean biF() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.context.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.context.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !biF()) {
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
            if (this.iMk != null) {
                this.iMk.zw(i2);
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13724");
            if (i == 3) {
                arVar.ak("obj_type", 2);
            } else if (i == 2) {
                arVar.ak("obj_type", 3);
            } else if (i == 8) {
                arVar.ak("obj_type", 4);
            } else if (i == 4) {
                arVar.ak("obj_type", 5);
            } else if (i == 6) {
                arVar.ak("obj_type", 6);
            }
            arVar.ak("obj_source", this.from);
            TiebaStatic.log(arVar);
            com.baidu.tbadk.util.ad.a(new com.baidu.tbadk.util.ac<ShareItem>() { // from class: com.baidu.tieba.frs.ac.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: biG */
                public ShareItem doInBackground() {
                    return ac.this.e(bitmap, i);
                }
            }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.frs.ac.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: a */
                public void onReturnDataInUI(ShareItem shareItem) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(ac.this.context.getPageActivity(), i, shareItem, false));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem e(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.fgr = false;
        shareItem.fgq = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.forumName + this.context.getString(R.string.core_bar) + "]" + UgcConstant.AT_RULE_TAG + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + com.baidu.adp.lib.util.k.getUrlEncode(this.forumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bwM();
        return shareItem;
    }

    public Bitmap biE() {
        if (this.euR == null) {
            if (this.iMn != null) {
                this.iMn.czI();
            }
            this.iMl.buildDrawingCache();
            this.euR = this.iMl.getDrawingCache();
            if (this.iMn != null) {
                this.iMn.czH();
            }
        }
        return this.euR;
    }

    public void a(b bVar) {
        this.iMk = bVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
