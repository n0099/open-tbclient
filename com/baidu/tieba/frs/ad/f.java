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
/* loaded from: classes21.dex */
public class f {
    private com.baidu.tbadk.core.dialog.a abt;
    private TextView eOo;
    private ForumData fpv;
    private TbImageView iOL;
    private RoundLinearLayout iOM;
    private i iON;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.eOo) {
                if (f.this.abt != null && f.this.abt.isShowing()) {
                    f.this.abt.dismiss();
                }
            } else if (view == f.this.iOL && f.this.iON != null && !StringUtils.isNull(f.this.iON.getUrl())) {
                bf.bqF().a(f.this.mPageContext, new String[]{f.this.iON.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.iON.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.abt.dismiss();
                ar arVar = new ar("common_click");
                arVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
                arVar.dR("obj_isad", "1");
                if (f.this.iON.getType() != 1) {
                    if (f.this.iON.getType() != 2) {
                        if (f.this.iON.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                arVar.ak("obj_adlocate", i);
                arVar.w("obj_id", f.this.iON.getId());
                arVar.ak("obj_floor", 1);
                arVar.ak("obj_locate", 3);
                if (f.this.fpv != null) {
                    arVar.dR("fid", f.this.fpv.getId());
                    arVar.dR("first_dir", f.this.fpv.getFirst_class());
                    arVar.dR("second_dir", f.this.fpv.getSecond_class());
                }
                if (f.this.iON.getType() == 1) {
                    arVar.dR("tid", f.this.iON.getThreadId());
                    arVar.ak("thread_type", f.this.iON.getThreadType());
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
        this.fpv = mVar.getForum();
        this.iON = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.bpu().getLong(str, 0L);
        if (j < 0 || !be.c(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putLong(str, System.currentTimeMillis());
            PA();
            return true;
        }
        return false;
    }

    private void PA() {
        int i;
        initView();
        this.abt = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.abt.iW(true);
        this.abt.iX(true);
        this.abt.b(this.mPageContext).bog();
        View decorView = this.abt.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.abt.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.abt.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        ar arVar = new ar("common_exp");
        arVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
        arVar.dR("obj_isad", "1");
        if (this.iON.getType() == 1) {
            i = 11;
        } else if (this.iON.getType() == 2) {
            i = 12;
        } else {
            i = this.iON.getType() == 3 ? 13 : 11;
        }
        arVar.ak("obj_floor", 1);
        arVar.ak("obj_adlocate", i);
        arVar.w("obj_id", this.iON.getId());
        if (this.fpv != null) {
            arVar.dR("fid", this.fpv.getId());
            arVar.dR("first_dir", this.fpv.getFirst_class());
            arVar.dR("second_dir", this.fpv.getSecond_class());
        }
        if (this.iON.getType() == 1) {
            arVar.dR("tid", this.iON.getThreadId());
            arVar.ak("thread_type", this.iON.getThreadType());
        }
        TiebaStatic.log(arVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.iOM = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.iOM.setRoundCount(8);
        this.iOL = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.iOL.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iOL.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.iOL.setLayoutParams(layoutParams);
        this.eOo = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.eOo.setOnClickListener(this.mClickListener);
        if (this.iON != null) {
            this.iOL.startLoad(this.iON.dIR(), 10, false);
        }
    }
}
