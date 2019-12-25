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
/* loaded from: classes6.dex */
public class f {
    private com.baidu.tbadk.core.dialog.a Ft;
    private ForumData duz;
    private TbImageView gom;
    private TextView gon;
    private RoundLinearLayout goo;
    private h gop;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.gon) {
                if (f.this.Ft != null && f.this.Ft.isShowing()) {
                    f.this.Ft.dismiss();
                }
            } else if (view == f.this.gom && f.this.gop != null && !StringUtils.isNull(f.this.gop.getUrl())) {
                ba.aEa().a(f.this.mPageContext, new String[]{f.this.gop.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.gop.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.Ft.dismiss();
                an anVar = new an("common_click");
                anVar.cp("page_type", PageStayDurationConstants.PageName.FRS);
                anVar.cp("obj_isad", "1");
                if (f.this.gop.getType() != 1) {
                    if (f.this.gop.getType() != 2) {
                        if (f.this.gop.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                anVar.Z("obj_adlocate", i);
                anVar.s("obj_id", f.this.gop.getId());
                anVar.Z("obj_floor", 1);
                anVar.Z("obj_locate", 3);
                if (f.this.duz != null) {
                    anVar.cp("fid", f.this.duz.getId());
                    anVar.cp("first_dir", f.this.duz.getFirst_class());
                    anVar.cp("second_dir", f.this.duz.getSecond_class());
                }
                if (f.this.gop.getType() == 1) {
                    anVar.cp("tid", f.this.gop.getThreadId());
                    anVar.Z("thread_type", f.this.gop.getThreadType());
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
            this.duz = lVar.getForum();
            this.gop = lVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + lVar.getForum().getId();
            long j = com.baidu.tbadk.core.sharedPref.b.aCY().getLong(str, 0L);
            if (j < 0 || !az.b(new Date(j), new Date(System.currentTimeMillis()))) {
                com.baidu.tbadk.core.sharedPref.b.aCY().putLong(str, System.currentTimeMillis());
                showDialog();
            }
        }
    }

    private void showDialog() {
        int i;
        initView();
        this.Ft = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.Ft.fu(true);
        this.Ft.fv(true);
        this.Ft.b(this.mPageContext).aBW();
        View decorView = this.Ft.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.Ft.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.Ft.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        an anVar = new an("common_exp");
        anVar.cp("page_type", PageStayDurationConstants.PageName.FRS);
        anVar.cp("obj_isad", "1");
        if (this.gop.getType() == 1) {
            i = 11;
        } else if (this.gop.getType() == 2) {
            i = 12;
        } else {
            i = this.gop.getType() == 3 ? 13 : 11;
        }
        anVar.Z("obj_floor", 1);
        anVar.Z("obj_adlocate", i);
        anVar.s("obj_id", this.gop.getId());
        if (this.duz != null) {
            anVar.cp("fid", this.duz.getId());
            anVar.cp("first_dir", this.duz.getFirst_class());
            anVar.cp("second_dir", this.duz.getSecond_class());
        }
        if (this.gop.getType() == 1) {
            anVar.cp("tid", this.gop.getThreadId());
            anVar.Z("thread_type", this.gop.getThreadType());
        }
        TiebaStatic.log(anVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.goo = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.goo.setRoundCount(8);
        this.gom = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.gom.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gom.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.gom.setLayoutParams(layoutParams);
        this.gon = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.gon.setOnClickListener(this.mClickListener);
        if (this.gop != null) {
            this.gom.startLoad(this.gop.cHr(), 10, false);
        }
    }
}
