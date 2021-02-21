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
    private com.baidu.tbadk.core.dialog.a acU;
    private ForumData fEm;
    private TextView fcK;
    private TbImageView jnf;
    private RoundLinearLayout jng;
    private i jnh;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.fcK) {
                if (f.this.acU != null && f.this.acU.isShowing()) {
                    f.this.acU.dismiss();
                }
            } else if (view == f.this.jnf && f.this.jnh != null && !StringUtils.isNull(f.this.jnh.getUrl())) {
                bf.bsV().a(f.this.mPageContext, new String[]{f.this.jnh.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.jnh.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.acU.dismiss();
                ar arVar = new ar("common_click");
                arVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
                arVar.dR("obj_isad", "1");
                if (f.this.jnh.getType() != 1) {
                    if (f.this.jnh.getType() != 2) {
                        if (f.this.jnh.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                arVar.ap("obj_adlocate", i);
                arVar.v("obj_id", f.this.jnh.getId());
                arVar.ap("obj_floor", 1);
                arVar.ap("obj_locate", 3);
                if (f.this.fEm != null) {
                    arVar.dR("fid", f.this.fEm.getId());
                    arVar.dR("first_dir", f.this.fEm.getFirst_class());
                    arVar.dR("second_dir", f.this.fEm.getSecond_class());
                }
                if (f.this.jnh.getType() == 1) {
                    arVar.dR("tid", f.this.jnh.getThreadId());
                    arVar.ap("thread_type", f.this.jnh.getThreadType());
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
        this.fEm = mVar.getForum();
        this.jnh = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.brQ().getLong(str, 0L);
        if (j < 0 || !be.c(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putLong(str, System.currentTimeMillis());
            QE();
            return true;
        }
        return false;
    }

    private void QE() {
        int i;
        initView();
        this.acU = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.acU.jF(true);
        this.acU.jG(true);
        this.acU.b(this.mPageContext).bqx();
        View decorView = this.acU.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.acU.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.acU.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        ar arVar = new ar("common_exp");
        arVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
        arVar.dR("obj_isad", "1");
        if (this.jnh.getType() == 1) {
            i = 11;
        } else if (this.jnh.getType() == 2) {
            i = 12;
        } else {
            i = this.jnh.getType() == 3 ? 13 : 11;
        }
        arVar.ap("obj_floor", 1);
        arVar.ap("obj_adlocate", i);
        arVar.v("obj_id", this.jnh.getId());
        if (this.fEm != null) {
            arVar.dR("fid", this.fEm.getId());
            arVar.dR("first_dir", this.fEm.getFirst_class());
            arVar.dR("second_dir", this.fEm.getSecond_class());
        }
        if (this.jnh.getType() == 1) {
            arVar.dR("tid", this.jnh.getThreadId());
            arVar.ap("thread_type", this.jnh.getThreadType());
        }
        TiebaStatic.log(arVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.jng = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.jng.setRoundCount(8);
        this.jnf = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.jnf.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jnf.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.jnf.setLayoutParams(layoutParams);
        this.fcK = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.fcK.setOnClickListener(this.mClickListener);
        if (this.jnh != null) {
            this.jnf.startLoad(this.jnh.dMC(), 10, false);
        }
    }
}
