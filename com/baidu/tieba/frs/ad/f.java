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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.m;
import java.util.Date;
/* loaded from: classes9.dex */
public class f {
    private com.baidu.tbadk.core.dialog.a aaa;
    private TextView dWm;
    private ForumData ewc;
    private TbImageView hFv;
    private RoundLinearLayout hFw;
    private i hFx;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.dWm) {
                if (f.this.aaa != null && f.this.aaa.isShowing()) {
                    f.this.aaa.dismiss();
                }
            } else if (view == f.this.hFv && f.this.hFx != null && !StringUtils.isNull(f.this.hFx.getUrl())) {
                bc.aWU().a(f.this.mPageContext, new String[]{f.this.hFx.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.hFx.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.aaa.dismiss();
                ao aoVar = new ao("common_click");
                aoVar.dk("page_type", PageStayDurationConstants.PageName.FRS);
                aoVar.dk("obj_isad", "1");
                if (f.this.hFx.getType() != 1) {
                    if (f.this.hFx.getType() != 2) {
                        if (f.this.hFx.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                aoVar.ag("obj_adlocate", i);
                aoVar.s("obj_id", f.this.hFx.getId());
                aoVar.ag("obj_floor", 1);
                aoVar.ag("obj_locate", 3);
                if (f.this.ewc != null) {
                    aoVar.dk("fid", f.this.ewc.getId());
                    aoVar.dk("first_dir", f.this.ewc.getFirst_class());
                    aoVar.dk("second_dir", f.this.ewc.getSecond_class());
                }
                if (f.this.hFx.getType() == 1) {
                    aoVar.dk("tid", f.this.hFx.getThreadId());
                    aoVar.ag("thread_type", f.this.hFx.getThreadType());
                }
                TiebaStatic.log(aoVar);
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
        this.ewc = mVar.getForum();
        this.hFx = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.aVP().getLong(str, 0L);
        if (j < 0 || !bb.b(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.aVP().putLong(str, System.currentTimeMillis());
            showDialog();
            return true;
        }
        return false;
    }

    private void showDialog() {
        int i;
        initView();
        this.aaa = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.aaa.hf(true);
        this.aaa.hg(true);
        this.aaa.b(this.mPageContext).aUN();
        View decorView = this.aaa.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.aaa.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.aaa.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        ao aoVar = new ao("common_exp");
        aoVar.dk("page_type", PageStayDurationConstants.PageName.FRS);
        aoVar.dk("obj_isad", "1");
        if (this.hFx.getType() == 1) {
            i = 11;
        } else if (this.hFx.getType() == 2) {
            i = 12;
        } else {
            i = this.hFx.getType() == 3 ? 13 : 11;
        }
        aoVar.ag("obj_floor", 1);
        aoVar.ag("obj_adlocate", i);
        aoVar.s("obj_id", this.hFx.getId());
        if (this.ewc != null) {
            aoVar.dk("fid", this.ewc.getId());
            aoVar.dk("first_dir", this.ewc.getFirst_class());
            aoVar.dk("second_dir", this.ewc.getSecond_class());
        }
        if (this.hFx.getType() == 1) {
            aoVar.dk("tid", this.hFx.getThreadId());
            aoVar.ag("thread_type", this.hFx.getThreadType());
        }
        TiebaStatic.log(aoVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.hFw = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.hFw.setRoundCount(8);
        this.hFv = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.hFv.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hFv.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.hFv.setLayoutParams(layoutParams);
        this.dWm = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.dWm.setOnClickListener(this.mClickListener);
        if (this.hFx != null) {
            this.hFv.startLoad(this.hFx.dhb(), 10, false);
        }
    }
}
