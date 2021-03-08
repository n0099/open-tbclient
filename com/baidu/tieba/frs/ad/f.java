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
/* loaded from: classes2.dex */
public class f {
    private com.baidu.tbadk.core.dialog.a aeo;
    private ForumData fFL;
    private TextView fej;
    private TbImageView joO;
    private RoundLinearLayout joP;
    private i joQ;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.fej) {
                if (f.this.aeo != null && f.this.aeo.isShowing()) {
                    f.this.aeo.dismiss();
                }
            } else if (view == f.this.joO && f.this.joQ != null && !StringUtils.isNull(f.this.joQ.getUrl())) {
                bf.bsY().a(f.this.mPageContext, new String[]{f.this.joQ.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.joQ.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.aeo.dismiss();
                ar arVar = new ar("common_click");
                arVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
                arVar.dR("obj_isad", "1");
                if (f.this.joQ.getType() != 1) {
                    if (f.this.joQ.getType() != 2) {
                        if (f.this.joQ.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                arVar.aq("obj_adlocate", i);
                arVar.v("obj_id", f.this.joQ.getId());
                arVar.aq("obj_floor", 1);
                arVar.aq("obj_locate", 3);
                if (f.this.fFL != null) {
                    arVar.dR("fid", f.this.fFL.getId());
                    arVar.dR("first_dir", f.this.fFL.getFirst_class());
                    arVar.dR("second_dir", f.this.fFL.getSecond_class());
                }
                if (f.this.joQ.getType() == 1) {
                    arVar.dR("tid", f.this.joQ.getThreadId());
                    arVar.aq("thread_type", f.this.joQ.getThreadType());
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
        this.fFL = mVar.getForum();
        this.joQ = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.brR().getLong(str, 0L);
        if (j < 0 || !be.c(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.brR().putLong(str, System.currentTimeMillis());
            QH();
            return true;
        }
        return false;
    }

    private void QH() {
        int i;
        initView();
        this.aeo = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.aeo.jF(true);
        this.aeo.jG(true);
        this.aeo.b(this.mPageContext).bqz();
        View decorView = this.aeo.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.aeo.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.aeo.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        ar arVar = new ar("common_exp");
        arVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
        arVar.dR("obj_isad", "1");
        if (this.joQ.getType() == 1) {
            i = 11;
        } else if (this.joQ.getType() == 2) {
            i = 12;
        } else {
            i = this.joQ.getType() == 3 ? 13 : 11;
        }
        arVar.aq("obj_floor", 1);
        arVar.aq("obj_adlocate", i);
        arVar.v("obj_id", this.joQ.getId());
        if (this.fFL != null) {
            arVar.dR("fid", this.fFL.getId());
            arVar.dR("first_dir", this.fFL.getFirst_class());
            arVar.dR("second_dir", this.fFL.getSecond_class());
        }
        if (this.joQ.getType() == 1) {
            arVar.dR("tid", this.joQ.getThreadId());
            arVar.aq("thread_type", this.joQ.getThreadType());
        }
        TiebaStatic.log(arVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.joP = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.joP.setRoundCount(8);
        this.joO = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.joO.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.joO.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.joO.setLayoutParams(layoutParams);
        this.fej = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.fej.setOnClickListener(this.mClickListener);
        if (this.joQ != null) {
            this.joO.startLoad(this.joQ.dMK(), 10, false);
        }
    }
}
