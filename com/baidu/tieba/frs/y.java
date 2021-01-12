package com.baidu.tieba.frs;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
/* loaded from: classes2.dex */
public class y {
    private TbPageContext context;
    private TextView eGC;
    private TextView eGD;
    private TextView eGE;
    private TextView eGF;
    private TextView eGG;
    private TextView eGH;
    private com.baidu.tieba.pb.pb.main.at eGK;
    private Bitmap eGL;
    private String forumName;
    private int from;
    private b jeI;
    private View jeJ;
    private String jeK;
    private a jeL;
    private PermissionJudgePolicy mPermissionJudgement;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.y.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap bku = y.this.bku();
            if (view.getId() == y.this.eGC.getId()) {
                y.this.u(bku);
            } else if (view.getId() == y.this.eGD.getId()) {
                y.this.d(bku, 3);
            } else if (view.getId() == y.this.eGE.getId()) {
                y.this.d(bku, 2);
            } else if (view.getId() == y.this.eGF.getId()) {
                y.this.d(bku, 4);
            } else if (view.getId() == y.this.eGG.getId()) {
                y.this.d(bku, 8);
            } else if (view.getId() == y.this.eGH.getId()) {
                y.this.d(bku, 6);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void cDc();

        void cDd();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void yH(int i);
    }

    public y(TbPageContext tbPageContext) {
        this.context = tbPageContext;
    }

    public void a(View view, View view2, a aVar) {
        if (view != null) {
            this.eGC = (TextView) view.findViewById(R.id.frs_private_share_download);
            a(this.eGC, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_frs_private_share_download40_svg));
            this.eGC.setOnClickListener(this.onClickListener);
            this.eGD = (TextView) view.findViewById(R.id.frs_private_share_wechat);
            a(this.eGD, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
            this.eGD.setOnClickListener(this.onClickListener);
            this.eGE = (TextView) view.findViewById(R.id.frs_private_share_moment);
            a(this.eGE, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
            this.eGE.setOnClickListener(this.onClickListener);
            this.eGF = (TextView) view.findViewById(R.id.frs_private_share_qzone);
            a(this.eGF, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
            this.eGF.setOnClickListener(this.onClickListener);
            this.eGG = (TextView) view.findViewById(R.id.frs_private_share_qq);
            a(this.eGG, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
            this.eGG.setOnClickListener(this.onClickListener);
            this.eGH = (TextView) view.findViewById(R.id.frs_private_share_weibo);
            a(this.eGH, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
            this.eGH.setOnClickListener(this.onClickListener);
            this.jeJ = view2;
            this.jeL = aVar;
        }
    }

    public void setData(String str, String str2) {
        this.jeK = str;
        this.forumName = str2;
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.e.a aVar) {
        if (aVar != null) {
            Drawable drawable = aVar.getDrawable();
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.context.getPageActivity(), R.dimen.tbds88);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            com.baidu.tbadk.core.util.ao.setViewTextColor(textView, R.color.CAM_X0106);
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
    public void u(Bitmap bitmap) {
        if (!bkv()) {
            if (this.jeI != null) {
                this.jeI.yH(1);
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13724");
            aqVar.an("obj_type", 1);
            aqVar.an("obj_source", this.from);
            TiebaStatic.log(aqVar);
            if (this.eGK == null) {
                this.eGK = new com.baidu.tieba.pb.pb.main.at(this.context);
            }
            this.eGK.p(this.jeK, BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
    }

    private boolean bkv() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.context.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.context.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bkv()) {
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
            if (this.jeI != null) {
                this.jeI.yH(i2);
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13724");
            if (i == 3) {
                aqVar.an("obj_type", 2);
            } else if (i == 2) {
                aqVar.an("obj_type", 3);
            } else if (i == 8) {
                aqVar.an("obj_type", 4);
            } else if (i == 4) {
                aqVar.an("obj_type", 5);
            } else if (i == 6) {
                aqVar.an("obj_type", 6);
            }
            aqVar.an("obj_source", this.from);
            TiebaStatic.log(aqVar);
            com.baidu.tbadk.util.ac.a(new com.baidu.tbadk.util.ab<ShareItem>() { // from class: com.baidu.tieba.frs.y.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ab
                /* renamed from: bkw */
                public ShareItem doInBackground() {
                    return y.this.e(bitmap, i);
                }
            }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tieba.frs.y.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: a */
                public void onReturnDataInUI(ShareItem shareItem) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(y.this.context.getPageActivity(), i, shareItem, false));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem e(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.fsS = false;
        shareItem.fsR = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.forumName + this.context.getString(R.string.core_bar) + "]@" + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + com.baidu.adp.lib.util.k.getUrlEncode(this.forumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.x(bitmap);
        shareItem.byN();
        return shareItem;
    }

    public Bitmap bku() {
        if (this.eGL == null) {
            if (this.jeL != null) {
                this.jeL.cDd();
            }
            this.jeJ.buildDrawingCache();
            this.eGL = this.jeJ.getDrawingCache();
            if (this.jeL != null) {
                this.jeL.cDc();
            }
        }
        return this.eGL;
    }

    public void a(b bVar) {
        this.jeI = bVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
