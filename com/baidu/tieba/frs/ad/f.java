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
    private com.baidu.tbadk.core.dialog.a aaB;
    private ForumData eMU;
    private TextView emq;
    private i hZA;
    private TbImageView hZy;
    private RoundLinearLayout hZz;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.emq) {
                if (f.this.aaB != null && f.this.aaB.isShowing()) {
                    f.this.aaB.dismiss();
                }
            } else if (view == f.this.hZy && f.this.hZA != null && !StringUtils.isNull(f.this.hZA.getUrl())) {
                be.bju().a(f.this.mPageContext, new String[]{f.this.hZA.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.hZA.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.aaB.dismiss();
                aq aqVar = new aq("common_click");
                aqVar.dD("page_type", PageStayDurationConstants.PageName.FRS);
                aqVar.dD("obj_isad", "1");
                if (f.this.hZA.getType() != 1) {
                    if (f.this.hZA.getType() != 2) {
                        if (f.this.hZA.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                aqVar.ai("obj_adlocate", i);
                aqVar.u("obj_id", f.this.hZA.getId());
                aqVar.ai("obj_floor", 1);
                aqVar.ai("obj_locate", 3);
                if (f.this.eMU != null) {
                    aqVar.dD("fid", f.this.eMU.getId());
                    aqVar.dD("first_dir", f.this.eMU.getFirst_class());
                    aqVar.dD("second_dir", f.this.eMU.getSecond_class());
                }
                if (f.this.hZA.getType() == 1) {
                    aqVar.dD("tid", f.this.hZA.getThreadId());
                    aqVar.ai("thread_type", f.this.hZA.getThreadType());
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
        this.eMU = mVar.getForum();
        this.hZA = mVar.getBusinessPromot();
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
        this.aaB = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.aaB.m39if(true);
        this.aaB.ig(true);
        this.aaB.b(this.mPageContext).bhg();
        View decorView = this.aaB.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.aaB.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.aaB.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        aq aqVar = new aq("common_exp");
        aqVar.dD("page_type", PageStayDurationConstants.PageName.FRS);
        aqVar.dD("obj_isad", "1");
        if (this.hZA.getType() == 1) {
            i = 11;
        } else if (this.hZA.getType() == 2) {
            i = 12;
        } else {
            i = this.hZA.getType() == 3 ? 13 : 11;
        }
        aqVar.ai("obj_floor", 1);
        aqVar.ai("obj_adlocate", i);
        aqVar.u("obj_id", this.hZA.getId());
        if (this.eMU != null) {
            aqVar.dD("fid", this.eMU.getId());
            aqVar.dD("first_dir", this.eMU.getFirst_class());
            aqVar.dD("second_dir", this.eMU.getSecond_class());
        }
        if (this.hZA.getType() == 1) {
            aqVar.dD("tid", this.hZA.getThreadId());
            aqVar.ai("thread_type", this.hZA.getThreadType());
        }
        TiebaStatic.log(aqVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.hZz = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.hZz.setRoundCount(8);
        this.hZy = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.hZy.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hZy.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.hZy.setLayoutParams(layoutParams);
        this.emq = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.emq.setOnClickListener(this.mClickListener);
        if (this.hZA != null) {
            this.hZy.startLoad(this.hZA.dvH(), 10, false);
        }
    }
}
