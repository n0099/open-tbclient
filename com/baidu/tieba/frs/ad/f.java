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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.m;
import java.util.Date;
/* loaded from: classes9.dex */
public class f {
    private com.baidu.tbadk.core.dialog.a Zg;
    private TextView dBn;
    private ForumData dZc;
    private TbImageView hdG;
    private RoundLinearLayout hdH;
    private i hdI;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.dBn) {
                if (f.this.Zg != null && f.this.Zg.isShowing()) {
                    f.this.Zg.dismiss();
                }
            } else if (view == f.this.hdG && f.this.hdI != null && !StringUtils.isNull(f.this.hdI.getUrl())) {
                ba.aOV().a(f.this.mPageContext, new String[]{f.this.hdI.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.hdI.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.Zg.dismiss();
                an anVar = new an("common_click");
                anVar.cI("page_type", PageStayDurationConstants.PageName.FRS);
                anVar.cI("obj_isad", "1");
                if (f.this.hdI.getType() != 1) {
                    if (f.this.hdI.getType() != 2) {
                        if (f.this.hdI.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                anVar.af("obj_adlocate", i);
                anVar.t("obj_id", f.this.hdI.getId());
                anVar.af("obj_floor", 1);
                anVar.af("obj_locate", 3);
                if (f.this.dZc != null) {
                    anVar.cI("fid", f.this.dZc.getId());
                    anVar.cI("first_dir", f.this.dZc.getFirst_class());
                    anVar.cI("second_dir", f.this.dZc.getSecond_class());
                }
                if (f.this.hdI.getType() == 1) {
                    anVar.cI("tid", f.this.hdI.getThreadId());
                    anVar.af("thread_type", f.this.hdI.getThreadType());
                }
                TiebaStatic.log(anVar);
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
        this.dZc = mVar.getForum();
        this.hdI = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.aNT().getLong(str, 0L);
        if (j < 0 || !az.b(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.aNT().putLong(str, System.currentTimeMillis());
            showDialog();
            return true;
        }
        return false;
    }

    private void showDialog() {
        int i;
        initView();
        this.Zg = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.Zg.gE(true);
        this.Zg.gF(true);
        this.Zg.b(this.mPageContext).aMS();
        View decorView = this.Zg.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.Zg.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.Zg.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        an anVar = new an("common_exp");
        anVar.cI("page_type", PageStayDurationConstants.PageName.FRS);
        anVar.cI("obj_isad", "1");
        if (this.hdI.getType() == 1) {
            i = 11;
        } else if (this.hdI.getType() == 2) {
            i = 12;
        } else {
            i = this.hdI.getType() == 3 ? 13 : 11;
        }
        anVar.af("obj_floor", 1);
        anVar.af("obj_adlocate", i);
        anVar.t("obj_id", this.hdI.getId());
        if (this.dZc != null) {
            anVar.cI("fid", this.dZc.getId());
            anVar.cI("first_dir", this.dZc.getFirst_class());
            anVar.cI("second_dir", this.dZc.getSecond_class());
        }
        if (this.hdI.getType() == 1) {
            anVar.cI("tid", this.hdI.getThreadId());
            anVar.af("thread_type", this.hdI.getThreadType());
        }
        TiebaStatic.log(anVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.hdH = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.hdH.setRoundCount(8);
        this.hdG = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.hdG.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hdG.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.hdG.setLayoutParams(layoutParams);
        this.dBn = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.dBn.setOnClickListener(this.mClickListener);
        if (this.hdI != null) {
            this.hdG.startLoad(this.hdI.cVs(), 10, false);
        }
    }
}
