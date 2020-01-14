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
import com.baidu.tbadk.core.data.ForumData;
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
import java.util.Date;
/* loaded from: classes7.dex */
public class f {
    private com.baidu.tbadk.core.dialog.a Fy;
    private ForumData duJ;
    private TbImageView grv;
    private TextView grw;
    private RoundLinearLayout grx;
    private h gry;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.grw) {
                if (f.this.Fy != null && f.this.Fy.isShowing()) {
                    f.this.Fy.dismiss();
                }
            } else if (view == f.this.grv && f.this.gry != null && !StringUtils.isNull(f.this.gry.getUrl())) {
                ba.aEt().a(f.this.mPageContext, new String[]{f.this.gry.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.gry.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.Fy.dismiss();
                an anVar = new an("common_click");
                anVar.cp("page_type", PageStayDurationConstants.PageName.FRS);
                anVar.cp("obj_isad", "1");
                if (f.this.gry.getType() != 1) {
                    if (f.this.gry.getType() != 2) {
                        if (f.this.gry.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                anVar.Z("obj_adlocate", i);
                anVar.s("obj_id", f.this.gry.getId());
                anVar.Z("obj_floor", 1);
                anVar.Z("obj_locate", 3);
                if (f.this.duJ != null) {
                    anVar.cp("fid", f.this.duJ.getId());
                    anVar.cp("first_dir", f.this.duJ.getFirst_class());
                    anVar.cp("second_dir", f.this.duJ.getSecond_class());
                }
                if (f.this.gry.getType() == 1) {
                    anVar.cp("tid", f.this.gry.getThreadId());
                    anVar.Z("thread_type", f.this.gry.getThreadType());
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

    public void a(l lVar) {
        if (lVar != null && lVar.getForum() != null && lVar.getBusinessPromot() != null) {
            this.duJ = lVar.getForum();
            this.gry = lVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + lVar.getForum().getId();
            long j = com.baidu.tbadk.core.sharedPref.b.aDr().getLong(str, 0L);
            if (j < 0 || !az.b(new Date(j), new Date(System.currentTimeMillis()))) {
                com.baidu.tbadk.core.sharedPref.b.aDr().putLong(str, System.currentTimeMillis());
                showDialog();
            }
        }
    }

    private void showDialog() {
        int i;
        initView();
        this.Fy = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.Fy.fz(true);
        this.Fy.fA(true);
        this.Fy.b(this.mPageContext).aCp();
        View decorView = this.Fy.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.Fy.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.Fy.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        an anVar = new an("common_exp");
        anVar.cp("page_type", PageStayDurationConstants.PageName.FRS);
        anVar.cp("obj_isad", "1");
        if (this.gry.getType() == 1) {
            i = 11;
        } else if (this.gry.getType() == 2) {
            i = 12;
        } else {
            i = this.gry.getType() == 3 ? 13 : 11;
        }
        anVar.Z("obj_floor", 1);
        anVar.Z("obj_adlocate", i);
        anVar.s("obj_id", this.gry.getId());
        if (this.duJ != null) {
            anVar.cp("fid", this.duJ.getId());
            anVar.cp("first_dir", this.duJ.getFirst_class());
            anVar.cp("second_dir", this.duJ.getSecond_class());
        }
        if (this.gry.getType() == 1) {
            anVar.cp("tid", this.gry.getThreadId());
            anVar.Z("thread_type", this.gry.getThreadType());
        }
        TiebaStatic.log(anVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.grx = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.grx.setRoundCount(8);
        this.grv = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.grv.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.grv.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.grv.setLayoutParams(layoutParams);
        this.grw = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.grw.setOnClickListener(this.mClickListener);
        if (this.gry != null) {
            this.grv.startLoad(this.gry.cIx(), 10, false);
        }
    }
}
