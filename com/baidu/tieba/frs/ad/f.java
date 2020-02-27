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
/* loaded from: classes9.dex */
public class f {
    private com.baidu.tbadk.core.dialog.a FR;
    private ForumData dyP;
    private TbImageView gtw;
    private TextView gtx;
    private RoundLinearLayout gty;
    private h gtz;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.gtx) {
                if (f.this.FR != null && f.this.FR.isShowing()) {
                    f.this.FR.dismiss();
                }
            } else if (view == f.this.gtw && f.this.gtz != null && !StringUtils.isNull(f.this.gtz.getUrl())) {
                ba.aGE().a(f.this.mPageContext, new String[]{f.this.gtz.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.gtz.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.FR.dismiss();
                an anVar = new an("common_click");
                anVar.cy("page_type", PageStayDurationConstants.PageName.FRS);
                anVar.cy("obj_isad", "1");
                if (f.this.gtz.getType() != 1) {
                    if (f.this.gtz.getType() != 2) {
                        if (f.this.gtz.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                anVar.X("obj_adlocate", i);
                anVar.s("obj_id", f.this.gtz.getId());
                anVar.X("obj_floor", 1);
                anVar.X("obj_locate", 3);
                if (f.this.dyP != null) {
                    anVar.cy("fid", f.this.dyP.getId());
                    anVar.cy("first_dir", f.this.dyP.getFirst_class());
                    anVar.cy("second_dir", f.this.dyP.getSecond_class());
                }
                if (f.this.gtz.getType() == 1) {
                    anVar.cy("tid", f.this.gtz.getThreadId());
                    anVar.X("thread_type", f.this.gtz.getThreadType());
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
            this.dyP = lVar.getForum();
            this.gtz = lVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + lVar.getForum().getId();
            long j = com.baidu.tbadk.core.sharedPref.b.aFB().getLong(str, 0L);
            if (j < 0 || !az.b(new Date(j), new Date(System.currentTimeMillis()))) {
                com.baidu.tbadk.core.sharedPref.b.aFB().putLong(str, System.currentTimeMillis());
                showDialog();
            }
        }
    }

    private void showDialog() {
        int i;
        initView();
        this.FR = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.FR.fG(true);
        this.FR.fH(true);
        this.FR.b(this.mPageContext).aEA();
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
        anVar.cy("page_type", PageStayDurationConstants.PageName.FRS);
        anVar.cy("obj_isad", "1");
        if (this.gtz.getType() == 1) {
            i = 11;
        } else if (this.gtz.getType() == 2) {
            i = 12;
        } else {
            i = this.gtz.getType() == 3 ? 13 : 11;
        }
        anVar.X("obj_floor", 1);
        anVar.X("obj_adlocate", i);
        anVar.s("obj_id", this.gtz.getId());
        if (this.dyP != null) {
            anVar.cy("fid", this.dyP.getId());
            anVar.cy("first_dir", this.dyP.getFirst_class());
            anVar.cy("second_dir", this.dyP.getSecond_class());
        }
        if (this.gtz.getType() == 1) {
            anVar.cy("tid", this.gtz.getThreadId());
            anVar.X("thread_type", this.gtz.getThreadType());
        }
        TiebaStatic.log(anVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.gty = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.gty.setRoundCount(8);
        this.gtw = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.gtw.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gtw.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.gtw.setLayoutParams(layoutParams);
        this.gtx = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.gtx.setOnClickListener(this.mClickListener);
        if (this.gtz != null) {
            this.gtw.startLoad(this.gtz.cKb(), 10, false);
        }
    }
}
