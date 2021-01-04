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
/* loaded from: classes2.dex */
public class f {
    private com.baidu.tbadk.core.dialog.a adc;
    private ForumData fGG;
    private TextView ffd;
    private TbImageView jlQ;
    private RoundLinearLayout jlR;
    private i jlS;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.ffd) {
                if (f.this.adc != null && f.this.adc.isShowing()) {
                    f.this.adc.dismiss();
                }
            } else if (view == f.this.jlQ && f.this.jlS != null && !StringUtils.isNull(f.this.jlS.getUrl())) {
                be.bwu().a(f.this.mPageContext, new String[]{f.this.jlS.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.jlS.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.adc.dismiss();
                aq aqVar = new aq("common_click");
                aqVar.dX("page_type", PageStayDurationConstants.PageName.FRS);
                aqVar.dX("obj_isad", "1");
                if (f.this.jlS.getType() != 1) {
                    if (f.this.jlS.getType() != 2) {
                        if (f.this.jlS.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                aqVar.an("obj_adlocate", i);
                aqVar.w("obj_id", f.this.jlS.getId());
                aqVar.an("obj_floor", 1);
                aqVar.an("obj_locate", 3);
                if (f.this.fGG != null) {
                    aqVar.dX("fid", f.this.fGG.getId());
                    aqVar.dX("first_dir", f.this.fGG.getFirst_class());
                    aqVar.dX("second_dir", f.this.fGG.getSecond_class());
                }
                if (f.this.jlS.getType() == 1) {
                    aqVar.dX("tid", f.this.jlS.getThreadId());
                    aqVar.an("thread_type", f.this.jlS.getThreadType());
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
        this.fGG = mVar.getForum();
        this.jlS = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.bvq().getLong(str, 0L);
        if (j < 0 || !bd.c(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.bvq().putLong(str, System.currentTimeMillis());
            SY();
            return true;
        }
        return false;
    }

    private void SY() {
        int i;
        initView();
        this.adc = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.adc.jH(true);
        this.adc.jI(true);
        this.adc.b(this.mPageContext).btX();
        View decorView = this.adc.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.adc.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.adc.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        aq aqVar = new aq("common_exp");
        aqVar.dX("page_type", PageStayDurationConstants.PageName.FRS);
        aqVar.dX("obj_isad", "1");
        if (this.jlS.getType() == 1) {
            i = 11;
        } else if (this.jlS.getType() == 2) {
            i = 12;
        } else {
            i = this.jlS.getType() == 3 ? 13 : 11;
        }
        aqVar.an("obj_floor", 1);
        aqVar.an("obj_adlocate", i);
        aqVar.w("obj_id", this.jlS.getId());
        if (this.fGG != null) {
            aqVar.dX("fid", this.fGG.getId());
            aqVar.dX("first_dir", this.fGG.getFirst_class());
            aqVar.dX("second_dir", this.fGG.getSecond_class());
        }
        if (this.jlS.getType() == 1) {
            aqVar.dX("tid", this.jlS.getThreadId());
            aqVar.an("thread_type", this.jlS.getThreadType());
        }
        TiebaStatic.log(aqVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.jlR = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.jlR.setRoundCount(8);
        this.jlQ = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.jlQ.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jlQ.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.jlQ.setLayoutParams(layoutParams);
        this.ffd = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.ffd.setOnClickListener(this.mClickListener);
        if (this.jlS != null) {
            this.jlQ.startLoad(this.jlS.dOa(), 10, false);
        }
    }
}
