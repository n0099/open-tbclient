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
    private com.baidu.tbadk.core.dialog.a Zd;
    private TextView dBj;
    private ForumData dYX;
    private TbImageView hdA;
    private RoundLinearLayout hdB;
    private i hdC;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.dBj) {
                if (f.this.Zd != null && f.this.Zd.isShowing()) {
                    f.this.Zd.dismiss();
                }
            } else if (view == f.this.hdA && f.this.hdC != null && !StringUtils.isNull(f.this.hdC.getUrl())) {
                ba.aOY().a(f.this.mPageContext, new String[]{f.this.hdC.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.hdC.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.Zd.dismiss();
                an anVar = new an("common_click");
                anVar.cI("page_type", PageStayDurationConstants.PageName.FRS);
                anVar.cI("obj_isad", "1");
                if (f.this.hdC.getType() != 1) {
                    if (f.this.hdC.getType() != 2) {
                        if (f.this.hdC.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                anVar.af("obj_adlocate", i);
                anVar.t("obj_id", f.this.hdC.getId());
                anVar.af("obj_floor", 1);
                anVar.af("obj_locate", 3);
                if (f.this.dYX != null) {
                    anVar.cI("fid", f.this.dYX.getId());
                    anVar.cI("first_dir", f.this.dYX.getFirst_class());
                    anVar.cI("second_dir", f.this.dYX.getSecond_class());
                }
                if (f.this.hdC.getType() == 1) {
                    anVar.cI("tid", f.this.hdC.getThreadId());
                    anVar.af("thread_type", f.this.hdC.getThreadType());
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
        this.dYX = mVar.getForum();
        this.hdC = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.aNV().getLong(str, 0L);
        if (j < 0 || !az.b(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.aNV().putLong(str, System.currentTimeMillis());
            showDialog();
            return true;
        }
        return false;
    }

    private void showDialog() {
        int i;
        initView();
        this.Zd = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.Zd.gE(true);
        this.Zd.gF(true);
        this.Zd.b(this.mPageContext).aMU();
        View decorView = this.Zd.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.Zd.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.Zd.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        an anVar = new an("common_exp");
        anVar.cI("page_type", PageStayDurationConstants.PageName.FRS);
        anVar.cI("obj_isad", "1");
        if (this.hdC.getType() == 1) {
            i = 11;
        } else if (this.hdC.getType() == 2) {
            i = 12;
        } else {
            i = this.hdC.getType() == 3 ? 13 : 11;
        }
        anVar.af("obj_floor", 1);
        anVar.af("obj_adlocate", i);
        anVar.t("obj_id", this.hdC.getId());
        if (this.dYX != null) {
            anVar.cI("fid", this.dYX.getId());
            anVar.cI("first_dir", this.dYX.getFirst_class());
            anVar.cI("second_dir", this.dYX.getSecond_class());
        }
        if (this.hdC.getType() == 1) {
            anVar.cI("tid", this.hdC.getThreadId());
            anVar.af("thread_type", this.hdC.getThreadType());
        }
        TiebaStatic.log(anVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.hdB = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.hdB.setRoundCount(8);
        this.hdA = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.hdA.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hdA.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.hdA.setLayoutParams(layoutParams);
        this.dBj = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.dBj.setOnClickListener(this.mClickListener);
        if (this.hdC != null) {
            this.hdA.startLoad(this.hdC.cVu(), 10, false);
        }
    }
}
