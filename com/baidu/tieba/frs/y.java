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
    private TextView eII;
    private TextView eIJ;
    private TextView eIK;
    private TextView eIL;
    private TextView eIM;
    private TextView eIN;
    private com.baidu.tieba.pb.pb.main.at eIQ;
    private Bitmap eIR;
    private String forumName;
    private int from;
    private b jkp;
    private View jkq;
    private String jkr;
    private a jks;
    private PermissionJudgePolicy mPermissionJudgement;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.y.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap bkM = y.this.bkM();
            if (view.getId() == y.this.eII.getId()) {
                y.this.t(bkM);
            } else if (view.getId() == y.this.eIJ.getId()) {
                y.this.d(bkM, 3);
            } else if (view.getId() == y.this.eIK.getId()) {
                y.this.d(bkM, 2);
            } else if (view.getId() == y.this.eIL.getId()) {
                y.this.d(bkM, 4);
            } else if (view.getId() == y.this.eIM.getId()) {
                y.this.d(bkM, 8);
            } else if (view.getId() == y.this.eIN.getId()) {
                y.this.d(bkM, 6);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void cEo();

        void cEp();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void yR(int i);
    }

    public y(TbPageContext tbPageContext) {
        this.context = tbPageContext;
    }

    public void a(View view, View view2, a aVar) {
        if (view != null) {
            this.eII = (TextView) view.findViewById(R.id.frs_private_share_download);
            a(this.eII, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_frs_private_share_download40_svg));
            this.eII.setOnClickListener(this.onClickListener);
            this.eIJ = (TextView) view.findViewById(R.id.frs_private_share_wechat);
            a(this.eIJ, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
            this.eIJ.setOnClickListener(this.onClickListener);
            this.eIK = (TextView) view.findViewById(R.id.frs_private_share_moment);
            a(this.eIK, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
            this.eIK.setOnClickListener(this.onClickListener);
            this.eIL = (TextView) view.findViewById(R.id.frs_private_share_qzone);
            a(this.eIL, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
            this.eIL.setOnClickListener(this.onClickListener);
            this.eIM = (TextView) view.findViewById(R.id.frs_private_share_qq);
            a(this.eIM, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
            this.eIM.setOnClickListener(this.onClickListener);
            this.eIN = (TextView) view.findViewById(R.id.frs_private_share_weibo);
            a(this.eIN, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
            this.eIN.setOnClickListener(this.onClickListener);
            this.jkq = view2;
            this.jks = aVar;
        }
    }

    public void setData(String str, String str2) {
        this.jkr = str;
        this.forumName = str2;
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.e.a aVar) {
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
        if (!bkN()) {
            if (this.jkp != null) {
                this.jkp.yR(1);
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13724");
            arVar.ap("obj_type", 1);
            arVar.ap("obj_source", this.from);
            TiebaStatic.log(arVar);
            if (this.eIQ == null) {
                this.eIQ = new com.baidu.tieba.pb.pb.main.at(this.context);
            }
            this.eIQ.p(this.jkr, BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
    }

    private boolean bkN() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.context.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.context.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bkN()) {
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
            if (this.jkp != null) {
                this.jkp.yR(i2);
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13724");
            if (i == 3) {
                arVar.ap("obj_type", 2);
            } else if (i == 2) {
                arVar.ap("obj_type", 3);
            } else if (i == 8) {
                arVar.ap("obj_type", 4);
            } else if (i == 4) {
                arVar.ap("obj_type", 5);
            } else if (i == 6) {
                arVar.ap("obj_type", 6);
            }
            arVar.ap("obj_source", this.from);
            TiebaStatic.log(arVar);
            com.baidu.tbadk.util.af.a(new com.baidu.tbadk.util.ae<ShareItem>() { // from class: com.baidu.tieba.frs.y.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ae
                /* renamed from: bkO */
                public ShareItem doInBackground() {
                    return y.this.e(bitmap, i);
                }
            }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.frs.y.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
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
        shareItem.fvk = false;
        shareItem.fvj = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.forumName + this.context.getString(R.string.core_bar) + "]@" + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + com.baidu.adp.lib.util.k.getUrlEncode(this.forumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bzf();
        return shareItem;
    }

    public Bitmap bkM() {
        if (this.eIR == null) {
            if (this.jks != null) {
                this.jks.cEp();
            }
            this.jkq.buildDrawingCache();
            this.eIR = this.jkq.getDrawingCache();
            if (this.jks != null) {
                this.jks.cEo();
            }
        }
        return this.eIR;
    }

    public void a(b bVar) {
        this.jkp = bVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
