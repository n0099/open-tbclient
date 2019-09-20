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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
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
    private com.baidu.tbadk.core.dialog.a TW;
    private TbImageView fBq;
    private TextView fBr;
    private RoundLinearLayout fBs;
    private h fBt;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.fBr) {
                if (f.this.TW != null && f.this.TW.isShowing()) {
                    f.this.TW.dismiss();
                }
            } else if (view == f.this.fBq && f.this.fBt != null && !StringUtils.isNull(f.this.fBt.getUrl())) {
                ba.ajK().a(f.this.mPageContext, new String[]{f.this.fBt.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.fBt.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.TW.dismiss();
                an anVar = new an("common_click");
                anVar.bT("page_type", "a006");
                anVar.bT("obj_isad", "1");
                String str = Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
                if (f.this.fBt.getType() != 1) {
                    if (f.this.fBt.getType() != 2) {
                        if (f.this.fBt.getType() == 3) {
                            str = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                        }
                    } else {
                        str = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                    }
                } else {
                    str = Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
                }
                anVar.bT("obj_adlocate", str);
                anVar.n(VideoPlayActivityConfig.OBJ_ID, f.this.fBt.getId());
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
            this.fBt = lVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + lVar.getForum().getId();
            long j = com.baidu.tbadk.core.sharedPref.b.ahU().getLong(str, 0L);
            if (j < 0 || !az.d(new Date(j), new Date(System.currentTimeMillis()))) {
                com.baidu.tbadk.core.sharedPref.b.ahU().putLong(str, System.currentTimeMillis());
                showDialog();
            }
        }
    }

    private void showDialog() {
        initView();
        this.TW = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.TW.dQ(true);
        this.TW.dR(true);
        this.TW.b(this.mPageContext).agO();
        View decorView = this.TW.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.TW.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.TW.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        an anVar = new an("common_exp");
        anVar.bT("page_type", "a006");
        anVar.bT("obj_isad", "1");
        String str = Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
        if (this.fBt.getType() == 1) {
            str = Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
        } else if (this.fBt.getType() == 2) {
            str = Constants.VIA_REPORT_TYPE_SET_AVATAR;
        } else if (this.fBt.getType() == 3) {
            str = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
        }
        anVar.bT("obj_adlocate", str);
        anVar.n(VideoPlayActivityConfig.OBJ_ID, this.fBt.getId());
        TiebaStatic.log(anVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.fBs = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.fBs.setRoundCount(8);
        this.fBq = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.fBq.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fBq.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.af(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.fBq.setLayoutParams(layoutParams);
        this.fBr = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.fBr.setOnClickListener(this.mClickListener);
        if (this.fBt != null) {
            this.fBq.startLoad(this.fBt.cpw(), 10, false);
        }
    }
}
