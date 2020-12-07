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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.m;
import java.util.Date;
/* loaded from: classes22.dex */
public class f {
    private com.baidu.tbadk.core.dialog.a acq;
    private TextView eVD;
    private ForumData fxa;
    private TbImageView iZC;
    private RoundLinearLayout iZD;
    private i iZE;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.eVD) {
                if (f.this.acq != null && f.this.acq.isShowing()) {
                    f.this.acq.dismiss();
                }
            } else if (view == f.this.iZC && f.this.iZE != null && !StringUtils.isNull(f.this.iZE.getUrl())) {
                bf.bua().a(f.this.mPageContext, new String[]{f.this.iZE.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.iZE.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.acq.dismiss();
                ar arVar = new ar("common_click");
                arVar.dY("page_type", PageStayDurationConstants.PageName.FRS);
                arVar.dY("obj_isad", "1");
                if (f.this.iZE.getType() != 1) {
                    if (f.this.iZE.getType() != 2) {
                        if (f.this.iZE.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                arVar.al("obj_adlocate", i);
                arVar.w("obj_id", f.this.iZE.getId());
                arVar.al("obj_floor", 1);
                arVar.al("obj_locate", 3);
                if (f.this.fxa != null) {
                    arVar.dY("fid", f.this.fxa.getId());
                    arVar.dY("first_dir", f.this.fxa.getFirst_class());
                    arVar.dY("second_dir", f.this.fxa.getSecond_class());
                }
                if (f.this.iZE.getType() == 1) {
                    arVar.dY("tid", f.this.iZE.getThreadId());
                    arVar.al("thread_type", f.this.iZE.getThreadType());
                }
                TiebaStatic.log(arVar);
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
        this.fxa = mVar.getForum();
        this.iZE = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.bsO().getLong(str, 0L);
        if (j < 0 || !be.c(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putLong(str, System.currentTimeMillis());
            RU();
            return true;
        }
        return false;
    }

    private void RU() {
        int i;
        initView();
        this.acq = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.acq.jl(true);
        this.acq.jm(true);
        this.acq.b(this.mPageContext).brv();
        View decorView = this.acq.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.acq.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.acq.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        ar arVar = new ar("common_exp");
        arVar.dY("page_type", PageStayDurationConstants.PageName.FRS);
        arVar.dY("obj_isad", "1");
        if (this.iZE.getType() == 1) {
            i = 11;
        } else if (this.iZE.getType() == 2) {
            i = 12;
        } else {
            i = this.iZE.getType() == 3 ? 13 : 11;
        }
        arVar.al("obj_floor", 1);
        arVar.al("obj_adlocate", i);
        arVar.w("obj_id", this.iZE.getId());
        if (this.fxa != null) {
            arVar.dY("fid", this.fxa.getId());
            arVar.dY("first_dir", this.fxa.getFirst_class());
            arVar.dY("second_dir", this.fxa.getSecond_class());
        }
        if (this.iZE.getType() == 1) {
            arVar.dY("tid", this.iZE.getThreadId());
            arVar.al("thread_type", this.iZE.getThreadType());
        }
        TiebaStatic.log(arVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.iZD = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.iZD.setRoundCount(8);
        this.iZC = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.iZC.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iZC.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.iZC.setLayoutParams(layoutParams);
        this.eVD = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.eVD.setOnClickListener(this.mClickListener);
        if (this.iZE != null) {
            this.iZC.startLoad(this.iZE.dOh(), 10, false);
        }
    }
}
