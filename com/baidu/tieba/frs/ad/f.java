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
    private com.baidu.tbadk.core.dialog.a Zw;
    private TextView dPu;
    private ForumData enm;
    private TbImageView hsF;
    private RoundLinearLayout hsG;
    private i hsH;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 11;
            if (view == f.this.dPu) {
                if (f.this.Zw != null && f.this.Zw.isShowing()) {
                    f.this.Zw.dismiss();
                }
            } else if (view == f.this.hsF && f.this.hsH != null && !StringUtils.isNull(f.this.hsH.getUrl())) {
                ba.aVa().a(f.this.mPageContext, new String[]{f.this.hsH.getUrl()}, true);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.hsH.getId());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.Zw.dismiss();
                an anVar = new an("common_click");
                anVar.dh("page_type", PageStayDurationConstants.PageName.FRS);
                anVar.dh("obj_isad", "1");
                if (f.this.hsH.getType() != 1) {
                    if (f.this.hsH.getType() != 2) {
                        if (f.this.hsH.getType() == 3) {
                            i = 13;
                        }
                    } else {
                        i = 12;
                    }
                }
                anVar.ag("obj_adlocate", i);
                anVar.s("obj_id", f.this.hsH.getId());
                anVar.ag("obj_floor", 1);
                anVar.ag("obj_locate", 3);
                if (f.this.enm != null) {
                    anVar.dh("fid", f.this.enm.getId());
                    anVar.dh("first_dir", f.this.enm.getFirst_class());
                    anVar.dh("second_dir", f.this.enm.getSecond_class());
                }
                if (f.this.hsH.getType() == 1) {
                    anVar.dh("tid", f.this.hsH.getThreadId());
                    anVar.ag("thread_type", f.this.hsH.getThreadType());
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
        this.enm = mVar.getForum();
        this.hsH = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long j = com.baidu.tbadk.core.sharedPref.b.aTX().getLong(str, 0L);
        if (j < 0 || !az.b(new Date(j), new Date(System.currentTimeMillis()))) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putLong(str, System.currentTimeMillis());
            showDialog();
            return true;
        }
        return false;
    }

    private void showDialog() {
        int i;
        initView();
        this.Zw = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.Zw.gW(true);
        this.Zw.gX(true);
        this.Zw.b(this.mPageContext).aST();
        View decorView = this.Zw.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.Zw.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.Zw.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.mRootView);
        }
        an anVar = new an("common_exp");
        anVar.dh("page_type", PageStayDurationConstants.PageName.FRS);
        anVar.dh("obj_isad", "1");
        if (this.hsH.getType() == 1) {
            i = 11;
        } else if (this.hsH.getType() == 2) {
            i = 12;
        } else {
            i = this.hsH.getType() == 3 ? 13 : 11;
        }
        anVar.ag("obj_floor", 1);
        anVar.ag("obj_adlocate", i);
        anVar.s("obj_id", this.hsH.getId());
        if (this.enm != null) {
            anVar.dh("fid", this.enm.getId());
            anVar.dh("first_dir", this.enm.getFirst_class());
            anVar.dh("second_dir", this.enm.getSecond_class());
        }
        if (this.hsH.getType() == 1) {
            anVar.dh("tid", this.hsH.getThreadId());
            anVar.ag("thread_type", this.hsH.getThreadType());
        }
        TiebaStatic.log(anVar);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.hsG = (RoundLinearLayout) this.mRootView.findViewById(R.id.round_layout);
        this.hsG.setRoundCount(8);
        this.hsF = (TbImageView) this.mRootView.findViewById(R.id.frs_ad_img);
        this.hsF.setOnClickListener(this.mClickListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hsF.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.height = (int) (layoutParams.width * 1.3306452f);
        this.hsF.setLayoutParams(layoutParams);
        this.dPu = (TextView) this.mRootView.findViewById(R.id.frs_ad_close);
        this.dPu.setOnClickListener(this.mClickListener);
        if (this.hsH != null) {
            this.hsF.startLoad(this.hsH.dcL(), 10, false);
        }
    }
}
