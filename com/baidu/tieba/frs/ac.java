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
    private Bitmap ewA;
    private TextView ewr;
    private TextView ews;
    private TextView ewt;
    private TextView ewu;
    private TextView ewv;
    private TextView eww;
    private com.baidu.tieba.pb.pb.main.bd ewz;
    private View.OnClickListener fii = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ac.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap bjA = ac.this.bjA();
            if (view.getId() == ac.this.ewr.getId()) {
                ac.this.t(bjA);
            } else if (view.getId() == ac.this.ews.getId()) {
                ac.this.d(bjA, 3);
            } else if (view.getId() == ac.this.ewt.getId()) {
                ac.this.d(bjA, 2);
            } else if (view.getId() == ac.this.ewu.getId()) {
                ac.this.d(bjA, 4);
            } else if (view.getId() == ac.this.ewv.getId()) {
                ac.this.d(bjA, 8);
            } else if (view.getId() == ac.this.eww.getId()) {
                ac.this.d(bjA, 6);
            }
        }
    };
    private String forumName;
    private int from;
    private a iLA;
    private b iLx;
    private View iLy;
    private String iLz;
    private PermissionJudgePolicy mPermissionJudgement;

    /* loaded from: classes22.dex */
    public interface a {
        void cAe();

        void cAf();
    }

    /* loaded from: classes22.dex */
    public interface b {
        void yY(int i);
    }

    public ac(TbPageContext tbPageContext) {
        this.context = tbPageContext;
    }

    public void a(View view, View view2, a aVar) {
        if (view != null) {
            this.ewr = (TextView) view.findViewById(R.id.frs_private_share_download);
            a(this.ewr, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
            this.ewr.setOnClickListener(this.fii);
            this.ews = (TextView) view.findViewById(R.id.frs_private_share_wechat);
            a(this.ews, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
            this.ews.setOnClickListener(this.fii);
            this.ewt = (TextView) view.findViewById(R.id.frs_private_share_moment);
            a(this.ewt, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
            this.ewt.setOnClickListener(this.fii);
            this.ewu = (TextView) view.findViewById(R.id.frs_private_share_qzone);
            a(this.ewu, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
            this.ewu.setOnClickListener(this.fii);
            this.ewv = (TextView) view.findViewById(R.id.frs_private_share_qq);
            a(this.ewv, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
            this.ewv.setOnClickListener(this.fii);
            this.eww = (TextView) view.findViewById(R.id.frs_private_share_weibo);
            a(this.eww, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
            this.eww.setOnClickListener(this.fii);
            this.iLy = view2;
            this.iLA = aVar;
        }
    }

    public void setData(String str, String str2) {
        this.iLz = str;
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
        if (!bjB()) {
            if (this.iLx != null) {
                this.iLx.yY(1);
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13724");
            aqVar.al("obj_type", 1);
            aqVar.al("obj_source", this.from);
            TiebaStatic.log(aqVar);
            if (this.ewz == null) {
                this.ewz = new com.baidu.tieba.pb.pb.main.bd(this.context);
            }
            this.ewz.j(this.iLz, BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
    }

    private boolean bjB() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.context.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.context.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bjB()) {
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
            if (this.iLx != null) {
                this.iLx.yY(i2);
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13724");
            if (i == 3) {
                aqVar.al("obj_type", 2);
            } else if (i == 2) {
                aqVar.al("obj_type", 3);
            } else if (i == 8) {
                aqVar.al("obj_type", 4);
            } else if (i == 4) {
                aqVar.al("obj_type", 5);
            } else if (i == 6) {
                aqVar.al("obj_type", 6);
            }
            aqVar.al("obj_source", this.from);
            TiebaStatic.log(aqVar);
            com.baidu.tbadk.util.ae.a(new com.baidu.tbadk.util.ad<ShareItem>() { // from class: com.baidu.tieba.frs.ac.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: bjC */
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
        shareItem.fhj = false;
        shareItem.fhi = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.forumName + this.context.getString(R.string.core_bar) + "]" + UgcConstant.AT_RULE_TAG + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + com.baidu.adp.lib.util.k.getUrlEncode(this.forumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bxw();
        return shareItem;
    }

    public Bitmap bjA() {
        if (this.ewA == null) {
            if (this.iLA != null) {
                this.iLA.cAf();
            }
            this.iLy.buildDrawingCache();
            this.ewA = this.iLy.getDrawingCache();
            if (this.iLA != null) {
                this.iLA.cAe();
            }
        }
        return this.ewA;
    }

    public void a(b bVar) {
        this.iLx = bVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
