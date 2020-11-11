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
    private com.baidu.tbadk.core.dialog.a abn;
    private TextView ePk;
    private ForumData fqn;
    private TbImageView iNY;
    private RoundLinearLayout iNZ;
    private i iOa;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.ePk) {
                if (f.this.abn != null && f.this.abn.isShowing()) {
                    f.this.abn.dismiss();
                }
            } else if (view == f.this.iNY && f.this.iOa != null && !StringUtils.isNull(f.this.iOa.getUrl())) {
                be.brr().a(f.this.mPageContext, new String[]{f.this.iOa.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.iOa.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.abn.dismiss();
                aq aqVar = new aq("common_click");
                aqVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
                aqVar.dR("obj_isad", "1");
                if (f.this.iOa.getType() != 1) {
                    if (f.this.iOa.getType() != 2) {
                        if (f.this.iOa.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                aqVar.al("obj_adlocate", i);
                aqVar.w("obj_id", f.this.iOa.getId());
                aqVar.al("obj_floor", 1);
                aqVar.al("obj_locate", 3);
                if (f.this.fqn != null) {
                    aqVar.dR("fid", f.this.fqn.getId());
                    aqVar.dR("first_dir", f.this.fqn.getFirst_class());
                    aqVar.dR("second_dir", f.this.fqn.getSecond_class());
                }
                if (f.this.iOa.getType() == 1) {
                    aqVar.dR("tid", f.this.iOa.getThreadId());
                    aqVar.al("thread_type", f.this.iOa.getThreadType());
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
        this.fqn = mVar.getForum();
        this.iOa = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.bqh().getLong(str, 0L);
        if (j < 0 || !bd.c(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putLong(str, System.currentTimeMillis());
            Qj();
            return true;
        }
        return false;
    }

    private void Qj() {
        int i;
        initView();
        this.abn = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.abn.iV(true);
        this.abn.iW(true);
        this.abn.b(this.mPageContext).bpc();
        View decorView = this.abn.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.abn.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.abn.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        aq aqVar = new aq("common_exp");
        aqVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
        aqVar.dR("obj_isad", "1");
        if (this.iOa.getType() == 1) {
            i = 11;
        } else if (this.iOa.getType() == 2) {
            i = 12;
        } else {
            i = this.iOa.getType() == 3 ? 13 : 11;
        }
        aqVar.al("obj_floor", 1);
        aqVar.al("obj_adlocate", i);
        aqVar.w("obj_id", this.iOa.getId());
        if (this.fqn != null) {
            aqVar.dR("fid", this.fqn.getId());
            aqVar.dR("first_dir", this.fqn.getFirst_class());
            aqVar.dR("second_dir", this.fqn.getSecond_class());
        }
        if (this.iOa.getType() == 1) {
            aqVar.dR("tid", this.iOa.getThreadId());
            aqVar.al("thread_type", this.iOa.getThreadType());
        }
        TiebaStatic.log(aqVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.iNZ = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.iNZ.setRoundCount(8);
        this.iNY = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.iNY.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iNY.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.iNY.setLayoutParams(layoutParams);
        this.ePk = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.ePk.setOnClickListener(this.mClickListener);
        if (this.iOa != null) {
            this.iNY.startLoad(this.iOa.dJa(), 10, false);
        }
    }
}
