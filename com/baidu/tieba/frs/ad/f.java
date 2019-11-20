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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.h;
import com.baidu.tieba.tbadkCore.l;
import com.tencent.connect.common.Constants;
import java.util.Date;
/* loaded from: classes4.dex */
public class f {
    private com.baidu.tbadk.core.dialog.a CM;
    private TbImageView fzQ;
    private TextView fzR;
    private RoundLinearLayout fzS;
    private h fzT;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.fzR) {
                if (f.this.CM != null && f.this.CM.isShowing()) {
                    f.this.CM.dismiss();
                }
            } else if (view == f.this.fzQ && f.this.fzT != null && !StringUtils.isNull(f.this.fzT.getUrl())) {
                ba.amO().a(f.this.mPageContext, new String[]{f.this.fzT.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.fzT.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.CM.dismiss();
                an anVar = new an("common_click");
                anVar.bS("page_type", PageStayDurationConstants.PageName.FRS);
                anVar.bS("obj_isad", "1");
                String str = Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
                if (f.this.fzT.getType() != 1) {
                    if (f.this.fzT.getType() != 2) {
                        if (f.this.fzT.getType() == 3) {
                            str = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                        }
                    } else {
                        str = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                    }
                } else {
                    str = Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
                }
                anVar.bS("obj_adlocate", str);
                anVar.p("obj_id", f.this.fzT.getId());
                TiebaStatic.log(anVar);
            }
        }
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(l lVar) {
        if (lVar != null && lVar.getForum() != null && lVar.getBusinessPromot() != null) {
            this.fzT = lVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + lVar.getForum().getId();
            long j = com.baidu.tbadk.core.sharedPref.b.alP().getLong(str, 0L);
            if (j < 0 || !az.b(new Date(j), new Date(System.currentTimeMillis()))) {
                com.baidu.tbadk.core.sharedPref.b.alP().putLong(str, System.currentTimeMillis());
                showDialog();
            }
        }
    }

    private void showDialog() {
        initView();
        this.CM = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.CM.eg(true);
        this.CM.eh(true);
        this.CM.b(this.mPageContext).akM();
        View decorView = this.CM.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.CM.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.CM.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        an anVar = new an("common_exp");
        anVar.bS("page_type", PageStayDurationConstants.PageName.FRS);
        anVar.bS("obj_isad", "1");
        String str = Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
        if (this.fzT.getType() == 1) {
            str = Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
        } else if (this.fzT.getType() == 2) {
            str = Constants.VIA_REPORT_TYPE_SET_AVATAR;
        } else if (this.fzT.getType() == 3) {
            str = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
        }
        anVar.bS("obj_adlocate", str);
        anVar.p("obj_id", this.fzT.getId());
        TiebaStatic.log(anVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.fzS = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.fzS.setRoundCount(8);
        this.fzQ = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.fzQ.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fzQ.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.fzQ.setLayoutParams(layoutParams);
        this.fzR = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.fzR.setOnClickListener(this.mClickListener);
        if (this.fzT != null) {
            this.fzQ.startLoad(this.fzT.cnl(), 10, false);
        }
    }
}
