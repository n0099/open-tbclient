package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.utils.m;
/* loaded from: classes11.dex */
public class f {
    private boolean bnF;
    private View contentView;
    private Context context;
    private int gNF = -1;
    private TextView gPA;
    private TextView gPD;
    private TextView gPV;
    private View.OnClickListener gPl;
    private TextView gPx;
    private HeadImageView gPz;
    private TextView mName;
    private String mOtherParams;
    private View mRootView;

    public f(Context context, View.OnClickListener onClickListener) {
        this.context = context;
        this.gPl = onClickListener;
        this.mRootView = LayoutInflater.from(context).inflate(a.g.improve_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        bTW();
        this.gPx = (TextView) this.mRootView.findViewById(a.f.tvGradeNum);
        this.gPz = (HeadImageView) this.mRootView.findViewById(a.f.photo);
        this.gPz.setIsRound(true);
        this.gPz.setAutoChangeStyle(false);
        this.gPz.setClickable(false);
        this.mName = (TextView) this.mRootView.findViewById(a.f.ala_name);
        this.gPA = (TextView) this.mRootView.findViewById(a.f.ala_intro);
        this.gPV = (TextView) this.mRootView.findViewById(a.f.sub_charm_textView);
        this.gPD = (TextView) this.mRootView.findViewById(a.f.improve_rink_btn);
        this.contentView.setClickable(true);
    }

    public void a(final com.baidu.tieba.ala.charm.data.a aVar) {
        if (aVar != null) {
            this.gPD.setTag(new int[]{aVar.type, aVar.grade});
            String str = "";
            if (aVar.type == 0) {
                this.gPx.setText("未上榜");
                this.gPV.setVisibility(8);
                this.gPA.setText(a.h.become_vip_text);
                this.gPD.setText(a.h.goto_list_text);
                str = "no_list";
            } else if (aVar.type == 1) {
                this.gPx.setText("未上榜");
                this.gPV.setVisibility(8);
                this.gPA.setText(Html.fromHtml("距离第100名还差<font color='#ff1e66'>" + aVar.gOz + "魅力</font>"));
                this.gPD.setText(a.h.goto_list_text);
                str = "no_list_hundred";
            } else if (aVar.type == 2) {
                this.gPx.setText("01");
                this.gPV.setVisibility(8);
                this.gPA.setText(this.mRootView.getContext().getResources().getString(a.h.ala_pay_gift_name, aVar.totalPrice + ""));
                this.gPD.setVisibility(8);
                str = "my_ranking";
            } else if (aVar.type == 3) {
                if (aVar.grade < 10) {
                    this.gPx.setText("0" + aVar.grade);
                } else {
                    this.gPx.setText(String.valueOf(aVar.grade));
                }
                this.gPV.setText(String.format("还差%s魅力", Long.valueOf(aVar.gOz)));
                this.gPV.setVisibility(0);
                this.gPA.setText(a.h.transcend_text);
                this.gPD.setText(a.h.improve_rink_text);
                if (aVar.grade <= 100) {
                    str = "my_ranking";
                } else {
                    str = "no_list_hundred";
                }
            }
            m.a(this.gPz, aVar.portrait, true, false);
            this.mName.setText(aVar.userName);
            this.gPD.setOnClickListener(this.gPl);
            if (!this.bnF && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                String ui = com.baidu.tieba.ala.charm.g.ui(this.gNF);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, ui);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, str);
                alaStaticItem.addParams("other_params", this.mOtherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            this.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(f.this.context, aVar.userId)));
                }
            });
        }
    }

    public void EK() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.context) == 2) {
                this.contentView.setBackgroundResource(a.e.improve_charm_bottom_layout_bg_land);
            } else {
                this.contentView.setBackgroundColor(this.context.getResources().getColor(a.c.ala_charm_bottom_color));
            }
        }
    }

    private void bTW() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.context) == 2) {
                this.contentView.setBackgroundResource(a.e.improve_charm_bottom_layout_bg_land);
            } else {
                this.contentView.setBackgroundColor(this.context.getResources().getColor(a.c.ala_charm_bottom_color));
            }
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mV(boolean z) {
        this.bnF = z;
    }

    public void ul(int i) {
        this.gNF = i;
    }

    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }
}
