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
/* loaded from: classes22.dex */
public class f {
    private com.baidu.tbadk.core.dialog.a abm;
    private TextView eAZ;
    private ForumData fbW;
    private TbImageView ivF;
    private RoundLinearLayout ivG;
    private i ivH;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.eAZ) {
                if (f.this.abm != null && f.this.abm.isShowing()) {
                    f.this.abm.dismiss();
                }
            } else if (view == f.this.ivF && f.this.ivH != null && !StringUtils.isNull(f.this.ivH.getUrl())) {
                be.bmY().a(f.this.mPageContext, new String[]{f.this.ivH.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.ivH.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.abm.dismiss();
                aq aqVar = new aq("common_click");
                aqVar.dK("page_type", PageStayDurationConstants.PageName.FRS);
                aqVar.dK("obj_isad", "1");
                if (f.this.ivH.getType() != 1) {
                    if (f.this.ivH.getType() != 2) {
                        if (f.this.ivH.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                aqVar.aj("obj_adlocate", i);
                aqVar.u("obj_id", f.this.ivH.getId());
                aqVar.aj("obj_floor", 1);
                aqVar.aj("obj_locate", 3);
                if (f.this.fbW != null) {
                    aqVar.dK("fid", f.this.fbW.getId());
                    aqVar.dK("first_dir", f.this.fbW.getFirst_class());
                    aqVar.dK("second_dir", f.this.fbW.getSecond_class());
                }
                if (f.this.ivH.getType() == 1) {
                    aqVar.dK("tid", f.this.ivH.getThreadId());
                    aqVar.aj("thread_type", f.this.ivH.getThreadType());
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
        this.fbW = mVar.getForum();
        this.ivH = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.blO().getLong(str, 0L);
        if (j < 0 || !bd.c(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.blO().putLong(str, System.currentTimeMillis());
            Pd();
            return true;
        }
        return false;
    }

    private void Pd() {
        int i;
        initView();
        this.abm = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.abm.iz(true);
        this.abm.iA(true);
        this.abm.b(this.mPageContext).bkJ();
        View decorView = this.abm.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.abm.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.abm.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        aq aqVar = new aq("common_exp");
        aqVar.dK("page_type", PageStayDurationConstants.PageName.FRS);
        aqVar.dK("obj_isad", "1");
        if (this.ivH.getType() == 1) {
            i = 11;
        } else if (this.ivH.getType() == 2) {
            i = 12;
        } else {
            i = this.ivH.getType() == 3 ? 13 : 11;
        }
        aqVar.aj("obj_floor", 1);
        aqVar.aj("obj_adlocate", i);
        aqVar.u("obj_id", this.ivH.getId());
        if (this.fbW != null) {
            aqVar.dK("fid", this.fbW.getId());
            aqVar.dK("first_dir", this.fbW.getFirst_class());
            aqVar.dK("second_dir", this.fbW.getSecond_class());
        }
        if (this.ivH.getType() == 1) {
            aqVar.dK("tid", this.ivH.getThreadId());
            aqVar.aj("thread_type", this.ivH.getThreadType());
        }
        TiebaStatic.log(aqVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.ivG = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.ivG.setRoundCount(8);
        this.ivF = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.ivF.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ivF.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.ivF.setLayoutParams(layoutParams);
        this.eAZ = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.eAZ.setOnClickListener(this.mClickListener);
        if (this.ivH != null) {
            this.ivF.startLoad(this.ivH.dDq(), 10, false);
        }
    }
}
