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
    private com.baidu.tbadk.core.dialog.a ada;
    private ForumData fBZ;
    private TextView fau;
    private TbImageView jhj;
    private RoundLinearLayout jhk;
    private i jhl;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.fau) {
                if (f.this.ada != null && f.this.ada.isShowing()) {
                    f.this.ada.dismiss();
                }
            } else if (view == f.this.jhj && f.this.jhl != null && !StringUtils.isNull(f.this.jhl.getUrl())) {
                be.bsB().a(f.this.mPageContext, new String[]{f.this.jhl.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.jhl.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.ada.dismiss();
                aq aqVar = new aq("common_click");
                aqVar.dW("page_type", PageStayDurationConstants.PageName.FRS);
                aqVar.dW("obj_isad", "1");
                if (f.this.jhl.getType() != 1) {
                    if (f.this.jhl.getType() != 2) {
                        if (f.this.jhl.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                aqVar.an("obj_adlocate", i);
                aqVar.w("obj_id", f.this.jhl.getId());
                aqVar.an("obj_floor", 1);
                aqVar.an("obj_locate", 3);
                if (f.this.fBZ != null) {
                    aqVar.dW("fid", f.this.fBZ.getId());
                    aqVar.dW("first_dir", f.this.fBZ.getFirst_class());
                    aqVar.dW("second_dir", f.this.fBZ.getSecond_class());
                }
                if (f.this.jhl.getType() == 1) {
                    aqVar.dW("tid", f.this.jhl.getThreadId());
                    aqVar.an("thread_type", f.this.jhl.getThreadType());
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
        this.fBZ = mVar.getForum();
        this.jhl = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.brx().getLong(str, 0L);
        if (j < 0 || !bd.c(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.brx().putLong(str, System.currentTimeMillis());
            Pd();
            return true;
        }
        return false;
    }

    private void Pd() {
        int i;
        initView();
        this.ada = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.ada.jD(true);
        this.ada.jE(true);
        this.ada.b(this.mPageContext).bqe();
        View decorView = this.ada.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.ada.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.ada.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        aq aqVar = new aq("common_exp");
        aqVar.dW("page_type", PageStayDurationConstants.PageName.FRS);
        aqVar.dW("obj_isad", "1");
        if (this.jhl.getType() == 1) {
            i = 11;
        } else if (this.jhl.getType() == 2) {
            i = 12;
        } else {
            i = this.jhl.getType() == 3 ? 13 : 11;
        }
        aqVar.an("obj_floor", 1);
        aqVar.an("obj_adlocate", i);
        aqVar.w("obj_id", this.jhl.getId());
        if (this.fBZ != null) {
            aqVar.dW("fid", this.fBZ.getId());
            aqVar.dW("first_dir", this.fBZ.getFirst_class());
            aqVar.dW("second_dir", this.fBZ.getSecond_class());
        }
        if (this.jhl.getType() == 1) {
            aqVar.dW("tid", this.jhl.getThreadId());
            aqVar.an("thread_type", this.jhl.getThreadType());
        }
        TiebaStatic.log(aqVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.jhk = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.jhk.setRoundCount(8);
        this.jhj = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.jhj.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jhj.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.jhj.setLayoutParams(layoutParams);
        this.fau = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.fau.setOnClickListener(this.mClickListener);
        if (this.jhl != null) {
            this.jhj.startLoad(this.jhl.dKj(), 10, false);
        }
    }
}
