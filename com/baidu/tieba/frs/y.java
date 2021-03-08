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
    private TextView eKj;
    private TextView eKk;
    private TextView eKl;
    private TextView eKm;
    private TextView eKn;
    private TextView eKo;
    private com.baidu.tieba.pb.pb.main.at eKr;
    private Bitmap eKs;
    private String forumName;
    private int from;
    private b jmm;
    private View jmn;
    private String jmo;
    private a jmq;
    private PermissionJudgePolicy mPermissionJudgement;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.y.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap bkO = y.this.bkO();
            if (view.getId() == y.this.eKj.getId()) {
                y.this.t(bkO);
            } else if (view.getId() == y.this.eKk.getId()) {
                y.this.d(bkO, 3);
            } else if (view.getId() == y.this.eKl.getId()) {
                y.this.d(bkO, 2);
            } else if (view.getId() == y.this.eKm.getId()) {
                y.this.d(bkO, 4);
            } else if (view.getId() == y.this.eKn.getId()) {
                y.this.d(bkO, 8);
            } else if (view.getId() == y.this.eKo.getId()) {
                y.this.d(bkO, 6);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void cEB();

        void cEC();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void yS(int i);
    }

    public y(TbPageContext tbPageContext) {
        this.context = tbPageContext;
    }

    public void a(View view, View view2, a aVar) {
        if (view != null) {
            this.eKj = (TextView) view.findViewById(R.id.frs_private_share_download);
            a(this.eKj, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_frs_private_share_download40_svg));
            this.eKj.setOnClickListener(this.onClickListener);
            this.eKk = (TextView) view.findViewById(R.id.frs_private_share_wechat);
            a(this.eKk, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
            this.eKk.setOnClickListener(this.onClickListener);
            this.eKl = (TextView) view.findViewById(R.id.frs_private_share_moment);
            a(this.eKl, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
            this.eKl.setOnClickListener(this.onClickListener);
            this.eKm = (TextView) view.findViewById(R.id.frs_private_share_qzone);
            a(this.eKm, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
            this.eKm.setOnClickListener(this.onClickListener);
            this.eKn = (TextView) view.findViewById(R.id.frs_private_share_qq);
            a(this.eKn, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
            this.eKn.setOnClickListener(this.onClickListener);
            this.eKo = (TextView) view.findViewById(R.id.frs_private_share_weibo);
            a(this.eKo, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
            this.eKo.setOnClickListener(this.onClickListener);
            this.jmn = view2;
            this.jmq = aVar;
        }
    }

    public void setData(String str, String str2) {
        this.jmo = str;
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
        if (!bkP()) {
            if (this.jmm != null) {
                this.jmm.yS(1);
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13724");
            arVar.aq("obj_type", 1);
            arVar.aq("obj_source", this.from);
            TiebaStatic.log(arVar);
            if (this.eKr == null) {
                this.eKr = new com.baidu.tieba.pb.pb.main.at(this.context);
            }
            this.eKr.o(this.jmo, BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
    }

    private boolean bkP() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.context.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.context.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bkP()) {
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
            if (this.jmm != null) {
                this.jmm.yS(i2);
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13724");
            if (i == 3) {
                arVar.aq("obj_type", 2);
            } else if (i == 2) {
                arVar.aq("obj_type", 3);
            } else if (i == 8) {
                arVar.aq("obj_type", 4);
            } else if (i == 4) {
                arVar.aq("obj_type", 5);
            } else if (i == 6) {
                arVar.aq("obj_type", 6);
            }
            arVar.aq("obj_source", this.from);
            TiebaStatic.log(arVar);
            com.baidu.tbadk.util.af.a(new com.baidu.tbadk.util.ae<ShareItem>() { // from class: com.baidu.tieba.frs.y.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ae
                /* renamed from: bkQ */
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
        shareItem.fwJ = false;
        shareItem.fwI = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.forumName + this.context.getString(R.string.core_bar) + "]@" + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + com.baidu.adp.lib.util.k.getUrlEncode(this.forumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bzi();
        return shareItem;
    }

    public Bitmap bkO() {
        if (this.eKs == null) {
            if (this.jmq != null) {
                this.jmq.cEC();
            }
            this.jmn.buildDrawingCache();
            this.eKs = this.jmn.getDrawingCache();
            if (this.jmq != null) {
                this.jmq.cEB();
            }
        }
        return this.eKs;
    }

    public void a(b bVar) {
        this.jmm = bVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
