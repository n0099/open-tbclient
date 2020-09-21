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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.m;
import java.util.Date;
/* loaded from: classes21.dex */
public class f {
    private com.baidu.tbadk.core.dialog.a aaV;
    private ForumData ePP;
    private TextView eoN;
    private TbImageView igI;
    private RoundLinearLayout igJ;
    private i igK;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.eoN) {
                if (f.this.aaV != null && f.this.aaV.isShowing()) {
                    f.this.aaV.dismiss();
                }
            } else if (view == f.this.igI && f.this.igK != null && !StringUtils.isNull(f.this.igK.getUrl())) {
                be.bkp().a(f.this.mPageContext, new String[]{f.this.igK.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.igK.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.aaV.dismiss();
                aq aqVar = new aq("common_click");
                aqVar.dF("page_type", PageStayDurationConstants.PageName.FRS);
                aqVar.dF("obj_isad", "1");
                if (f.this.igK.getType() != 1) {
                    if (f.this.igK.getType() != 2) {
                        if (f.this.igK.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                aqVar.ai("obj_adlocate", i);
                aqVar.u("obj_id", f.this.igK.getId());
                aqVar.ai("obj_floor", 1);
                aqVar.ai("obj_locate", 3);
                if (f.this.ePP != null) {
                    aqVar.dF("fid", f.this.ePP.getId());
                    aqVar.dF("first_dir", f.this.ePP.getFirst_class());
                    aqVar.dF("second_dir", f.this.ePP.getSecond_class());
                }
                if (f.this.igK.getType() == 1) {
                    aqVar.dF("tid", f.this.igK.getThreadId());
                    aqVar.ai("thread_type", f.this.igK.getThreadType());
                }
                TiebaStatic.log(aqVar);
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
        this.ePP = mVar.getForum();
        this.igK = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.bjf().getLong(str, 0L);
        if (j < 0 || !bd.c(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.bjf().putLong(str, System.currentTimeMillis());
            NY();
            return true;
        }
        return false;
    }

    private void NY() {
        int i;
        initView();
        this.aaV = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.aaV.id(true);
        this.aaV.ie(true);
        this.aaV.b(this.mPageContext).bia();
        View decorView = this.aaV.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.aaV.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.aaV.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        aq aqVar = new aq("common_exp");
        aqVar.dF("page_type", PageStayDurationConstants.PageName.FRS);
        aqVar.dF("obj_isad", "1");
        if (this.igK.getType() == 1) {
            i = 11;
        } else if (this.igK.getType() == 2) {
            i = 12;
        } else {
            i = this.igK.getType() == 3 ? 13 : 11;
        }
        aqVar.ai("obj_floor", 1);
        aqVar.ai("obj_adlocate", i);
        aqVar.u("obj_id", this.igK.getId());
        if (this.ePP != null) {
            aqVar.dF("fid", this.ePP.getId());
            aqVar.dF("first_dir", this.ePP.getFirst_class());
            aqVar.dF("second_dir", this.ePP.getSecond_class());
        }
        if (this.igK.getType() == 1) {
            aqVar.dF("tid", this.igK.getThreadId());
            aqVar.ai("thread_type", this.igK.getThreadType());
        }
        TiebaStatic.log(aqVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.igJ = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.igJ.setRoundCount(8);
        this.igI = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.igI.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.igI.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.igI.setLayoutParams(layoutParams);
        this.eoN = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.eoN.setOnClickListener(this.mClickListener);
        if (this.igK != null) {
            this.igI.startLoad(this.igK.dzF(), 10, false);
        }
    }
}
