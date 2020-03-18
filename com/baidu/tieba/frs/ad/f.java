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
    private com.baidu.tbadk.core.dialog.a FR;
    private TextView dbU;
    private ForumData dzq;
    private TbImageView gup;
    private RoundLinearLayout guq;
    private i gur;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.dbU) {
                if (f.this.FR != null && f.this.FR.isShowing()) {
                    f.this.FR.dismiss();
                }
            } else if (view == f.this.gup && f.this.gur != null && !StringUtils.isNull(f.this.gur.getUrl())) {
                ba.aGK().a(f.this.mPageContext, new String[]{f.this.gur.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.gur.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.FR.dismiss();
                an anVar = new an("common_click");
                anVar.cx("page_type", PageStayDurationConstants.PageName.FRS);
                anVar.cx("obj_isad", "1");
                if (f.this.gur.getType() != 1) {
                    if (f.this.gur.getType() != 2) {
                        if (f.this.gur.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                anVar.X("obj_adlocate", i);
                anVar.s("obj_id", f.this.gur.getId());
                anVar.X("obj_floor", 1);
                anVar.X("obj_locate", 3);
                if (f.this.dzq != null) {
                    anVar.cx("fid", f.this.dzq.getId());
                    anVar.cx("first_dir", f.this.dzq.getFirst_class());
                    anVar.cx("second_dir", f.this.dzq.getSecond_class());
                }
                if (f.this.gur.getType() == 1) {
                    anVar.cx("tid", f.this.gur.getThreadId());
                    anVar.X("thread_type", f.this.gur.getThreadType());
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
        this.dzq = mVar.getForum();
        this.gur = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.aFH().getLong(str, 0L);
        if (j < 0 || !az.b(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.aFH().putLong(str, System.currentTimeMillis());
            showDialog();
            return true;
        }
        return false;
    }

    private void showDialog() {
        int i;
        initView();
        this.FR = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.FR.fH(true);
        this.FR.fI(true);
        this.FR.b(this.mPageContext).aEG();
        View decorView = this.FR.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.FR.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.FR.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        an anVar = new an("common_exp");
        anVar.cx("page_type", PageStayDurationConstants.PageName.FRS);
        anVar.cx("obj_isad", "1");
        if (this.gur.getType() == 1) {
            i = 11;
        } else if (this.gur.getType() == 2) {
            i = 12;
        } else {
            i = this.gur.getType() == 3 ? 13 : 11;
        }
        anVar.X("obj_floor", 1);
        anVar.X("obj_adlocate", i);
        anVar.s("obj_id", this.gur.getId());
        if (this.dzq != null) {
            anVar.cx("fid", this.dzq.getId());
            anVar.cx("first_dir", this.dzq.getFirst_class());
            anVar.cx("second_dir", this.dzq.getSecond_class());
        }
        if (this.gur.getType() == 1) {
            anVar.cx("tid", this.gur.getThreadId());
            anVar.X("thread_type", this.gur.getThreadType());
        }
        TiebaStatic.log(anVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.guq = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.guq.setRoundCount(8);
        this.gup = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.gup.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gup.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.gup.setLayoutParams(layoutParams);
        this.dbU = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.dbU.setOnClickListener(this.mClickListener);
        if (this.gur != null) {
            this.gup.startLoad(this.gur.cKy(), 10, false);
        }
    }
}
