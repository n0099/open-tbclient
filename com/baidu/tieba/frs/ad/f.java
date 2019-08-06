package com.baidu.tieba.frs.ad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.h;
import com.baidu.tieba.tbadkCore.l;
import com.tencent.connect.common.Constants;
import java.util.Date;
/* loaded from: classes4.dex */
public class f {
    private com.baidu.tbadk.core.dialog.a TX;
    private TbImageView fzD;
    private TextView fzE;
    private RoundLinearLayout fzF;
    private h fzG;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.fzE) {
                if (f.this.TX != null && f.this.TX.isShowing()) {
                    f.this.TX.dismiss();
                }
            } else if (view == f.this.fzD && f.this.fzG != null && !StringUtils.isNull(f.this.fzG.getUrl())) {
                bb.ajE().a(f.this.mPageContext, new String[]{f.this.fzG.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.fzG.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.TX.dismiss();
                an anVar = new an("common_click");
                anVar.bT("page_type", "a006");
                anVar.bT("obj_isad", "1");
                String str = Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
                if (f.this.fzG.getType() != 1) {
                    if (f.this.fzG.getType() != 2) {
                        if (f.this.fzG.getType() == 3) {
                            str = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                        }
                    } else {
                        str = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                    }
                } else {
                    str = Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
                }
                anVar.bT("obj_adlocate", str);
                anVar.l(VideoPlayActivityConfig.OBJ_ID, f.this.fzG.getId());
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
            this.fzG = lVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + lVar.getForum().getId();
            long j = com.baidu.tbadk.core.sharedPref.b.ahQ().getLong(str, 0L);
            if (j < 0 || !ba.d(new Date(j), new Date(System.currentTimeMillis()))) {
                com.baidu.tbadk.core.sharedPref.b.ahQ().putLong(str, System.currentTimeMillis());
                showDialog();
            }
        }
    }

    private void showDialog() {
        initView();
        this.TX = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.TX.dQ(true);
        this.TX.dR(true);
        this.TX.b(this.mPageContext).agK();
        View decorView = this.TX.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.TX.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.TX.getWindow().setAttributes(attributes);
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
        if (this.fzG.getType() == 1) {
            str = Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
        } else if (this.fzG.getType() == 2) {
            str = Constants.VIA_REPORT_TYPE_SET_AVATAR;
        } else if (this.fzG.getType() == 3) {
            str = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
        }
        anVar.bT("obj_adlocate", str);
        anVar.l(VideoPlayActivityConfig.OBJ_ID, this.fzG.getId());
        TiebaStatic.log(anVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.fzF = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.fzF.setRoundCount(8);
        this.fzD = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.fzD.setOnClickListener(this.mClickListener);
        this.fzE = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.fzE.setOnClickListener(this.mClickListener);
        if (this.fzG != null) {
            this.fzD.startLoad(this.fzG.coJ(), 10, false);
        }
    }
}
