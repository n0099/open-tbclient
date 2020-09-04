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
/* loaded from: classes16.dex */
public class f {
    private com.baidu.tbadk.core.dialog.a aaD;
    private ForumData eMY;
    private TextView emu;
    private TbImageView hZE;
    private RoundLinearLayout hZF;
    private i hZG;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.emu) {
                if (f.this.aaD != null && f.this.aaD.isShowing()) {
                    f.this.aaD.dismiss();
                }
            } else if (view == f.this.hZE && f.this.hZG != null && !StringUtils.isNull(f.this.hZG.getUrl())) {
                be.bju().a(f.this.mPageContext, new String[]{f.this.hZG.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.hZG.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.aaD.dismiss();
                aq aqVar = new aq("common_click");
                aqVar.dD("page_type", PageStayDurationConstants.PageName.FRS);
                aqVar.dD("obj_isad", "1");
                if (f.this.hZG.getType() != 1) {
                    if (f.this.hZG.getType() != 2) {
                        if (f.this.hZG.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                aqVar.ai("obj_adlocate", i);
                aqVar.u("obj_id", f.this.hZG.getId());
                aqVar.ai("obj_floor", 1);
                aqVar.ai("obj_locate", 3);
                if (f.this.eMY != null) {
                    aqVar.dD("fid", f.this.eMY.getId());
                    aqVar.dD("first_dir", f.this.eMY.getFirst_class());
                    aqVar.dD("second_dir", f.this.eMY.getSecond_class());
                }
                if (f.this.hZG.getType() == 1) {
                    aqVar.dD("tid", f.this.hZG.getThreadId());
                    aqVar.ai("thread_type", f.this.hZG.getThreadType());
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
        this.eMY = mVar.getForum();
        this.hZG = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.bik().getLong(str, 0L);
        if (j < 0 || !bd.c(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.bik().putLong(str, System.currentTimeMillis());
            Nv();
            return true;
        }
        return false;
    }

    private void Nv() {
        int i;
        initView();
        this.aaD = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.aaD.ig(true);
        this.aaD.ih(true);
        this.aaD.b(this.mPageContext).bhg();
        View decorView = this.aaD.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.aaD.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.aaD.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        aq aqVar = new aq("common_exp");
        aqVar.dD("page_type", PageStayDurationConstants.PageName.FRS);
        aqVar.dD("obj_isad", "1");
        if (this.hZG.getType() == 1) {
            i = 11;
        } else if (this.hZG.getType() == 2) {
            i = 12;
        } else {
            i = this.hZG.getType() == 3 ? 13 : 11;
        }
        aqVar.ai("obj_floor", 1);
        aqVar.ai("obj_adlocate", i);
        aqVar.u("obj_id", this.hZG.getId());
        if (this.eMY != null) {
            aqVar.dD("fid", this.eMY.getId());
            aqVar.dD("first_dir", this.eMY.getFirst_class());
            aqVar.dD("second_dir", this.eMY.getSecond_class());
        }
        if (this.hZG.getType() == 1) {
            aqVar.dD("tid", this.hZG.getThreadId());
            aqVar.ai("thread_type", this.hZG.getThreadType());
        }
        TiebaStatic.log(aqVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.hZF = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.hZF.setRoundCount(8);
        this.hZE = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.hZE.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hZE.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.hZE.setLayoutParams(layoutParams);
        this.emu = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.emu.setOnClickListener(this.mClickListener);
        if (this.hZG != null) {
            this.hZE.startLoad(this.hZG.dvM(), 10, false);
        }
    }
}
