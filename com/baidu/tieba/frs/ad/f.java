package com.baidu.tieba.frs.ad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.m;
import java.util.Date;
/* loaded from: classes16.dex */
public class f {
    private com.baidu.tbadk.core.dialog.a ZV;
    private ForumData eCv;
    private TextView ecH;
    private TbImageView hLt;
    private RoundLinearLayout hLu;
    private i hLv;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.ecH) {
                if (f.this.ZV != null && f.this.ZV.isShowing()) {
                    f.this.ZV.dismiss();
                }
            } else if (view == f.this.hLt && f.this.hLv != null && !StringUtils.isNull(f.this.hLv.getUrl())) {
                bd.baV().a(f.this.mPageContext, new String[]{f.this.hLv.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.hLv.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.ZV.dismiss();
                ap apVar = new ap("common_click");
                apVar.dn("page_type", PageStayDurationConstants.PageName.FRS);
                apVar.dn("obj_isad", "1");
                if (f.this.hLv.getType() != 1) {
                    if (f.this.hLv.getType() != 2) {
                        if (f.this.hLv.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                apVar.ah("obj_adlocate", i);
                apVar.t("obj_id", f.this.hLv.getId());
                apVar.ah("obj_floor", 1);
                apVar.ah("obj_locate", 3);
                if (f.this.eCv != null) {
                    apVar.dn("fid", f.this.eCv.getId());
                    apVar.dn("first_dir", f.this.eCv.getFirst_class());
                    apVar.dn("second_dir", f.this.eCv.getSecond_class());
                }
                if (f.this.hLv.getType() == 1) {
                    apVar.dn("tid", f.this.hLv.getThreadId());
                    apVar.ah("thread_type", f.this.hLv.getThreadType());
                }
                TiebaStatic.log(apVar);
            }
        }
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean d(m mVar) {
        if (mVar == null || mVar.getForum() == null || mVar.getBusinessPromot() == null) {
            return false;
        }
        this.eCv = mVar.getForum();
        this.hLv = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.aZP().getLong(str, 0L);
        if (j < 0 || !bc.b(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putLong(str, System.currentTimeMillis());
            showDialog();
            return true;
        }
        return false;
    }

    private void showDialog() {
        int i;
        initView();
        this.ZV = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.ZV.hJ(true);
        this.ZV.hK(true);
        this.ZV.b(this.mPageContext).aYL();
        View decorView = this.ZV.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.ZV.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.ZV.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        ap apVar = new ap("common_exp");
        apVar.dn("page_type", PageStayDurationConstants.PageName.FRS);
        apVar.dn("obj_isad", "1");
        if (this.hLv.getType() == 1) {
            i = 11;
        } else if (this.hLv.getType() == 2) {
            i = 12;
        } else {
            i = this.hLv.getType() == 3 ? 13 : 11;
        }
        apVar.ah("obj_floor", 1);
        apVar.ah("obj_adlocate", i);
        apVar.t("obj_id", this.hLv.getId());
        if (this.eCv != null) {
            apVar.dn("fid", this.eCv.getId());
            apVar.dn("first_dir", this.eCv.getFirst_class());
            apVar.dn("second_dir", this.eCv.getSecond_class());
        }
        if (this.hLv.getType() == 1) {
            apVar.dn("tid", this.hLv.getThreadId());
            apVar.ah("thread_type", this.hLv.getThreadType());
        }
        TiebaStatic.log(apVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.hLu = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.hLu.setRoundCount(8);
        this.hLt = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.hLt.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hLt.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.hLt.setLayoutParams(layoutParams);
        this.ecH = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.ecH.setOnClickListener(this.mClickListener);
        if (this.hLv != null) {
            this.hLt.startLoad(this.hLv.dkk(), 10, false);
        }
    }
}
