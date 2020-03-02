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
    private ForumData dyQ;
    private RoundLinearLayout gtA;
    private h gtB;
    private TbImageView gty;
    private TextView gtz;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.gtz) {
                if (f.this.FR != null && f.this.FR.isShowing()) {
                    f.this.FR.dismiss();
                }
            } else if (view == f.this.gty && f.this.gtB != null && !StringUtils.isNull(f.this.gtB.getUrl())) {
                ba.aGG().a(f.this.mPageContext, new String[]{f.this.gtB.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.gtB.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.FR.dismiss();
                an anVar = new an("common_click");
                anVar.cy("page_type", PageStayDurationConstants.PageName.FRS);
                anVar.cy("obj_isad", "1");
                if (f.this.gtB.getType() != 1) {
                    if (f.this.gtB.getType() != 2) {
                        if (f.this.gtB.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                anVar.X("obj_adlocate", i);
                anVar.s("obj_id", f.this.gtB.getId());
                anVar.X("obj_floor", 1);
                anVar.X("obj_locate", 3);
                if (f.this.dyQ != null) {
                    anVar.cy("fid", f.this.dyQ.getId());
                    anVar.cy("first_dir", f.this.dyQ.getFirst_class());
                    anVar.cy("second_dir", f.this.dyQ.getSecond_class());
                }
                if (f.this.gtB.getType() == 1) {
                    anVar.cy("tid", f.this.gtB.getThreadId());
                    anVar.X("thread_type", f.this.gtB.getThreadType());
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
            this.dyQ = lVar.getForum();
            this.gtB = lVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + lVar.getForum().getId();
            long j = com.baidu.tbadk.core.sharedPref.b.aFD().getLong(str, 0L);
            if (j < 0 || !az.b(new Date(j), new Date(System.currentTimeMillis()))) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putLong(str, System.currentTimeMillis());
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
        this.FR.b(this.mPageContext).aEC();
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
        if (this.gtB.getType() == 1) {
            i = 11;
        } else if (this.gtB.getType() == 2) {
            i = 12;
        } else {
            i = this.gtB.getType() == 3 ? 13 : 11;
        }
        anVar.X("obj_floor", 1);
        anVar.X("obj_adlocate", i);
        anVar.s("obj_id", this.gtB.getId());
        if (this.dyQ != null) {
            anVar.cy("fid", this.dyQ.getId());
            anVar.cy("first_dir", this.dyQ.getFirst_class());
            anVar.cy("second_dir", this.dyQ.getSecond_class());
        }
        if (this.gtB.getType() == 1) {
            anVar.cy("tid", this.gtB.getThreadId());
            anVar.X("thread_type", this.gtB.getThreadType());
        }
        TiebaStatic.log(anVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.gtA = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.gtA.setRoundCount(8);
        this.gty = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.gty.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gty.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.gty.setLayoutParams(layoutParams);
        this.gtz = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.gtz.setOnClickListener(this.mClickListener);
        if (this.gtB != null) {
            this.gty.startLoad(this.gtB.cKd(), 10, false);
        }
    }
}
