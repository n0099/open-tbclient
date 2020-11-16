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
import com.baidu.live.utils.l;
/* loaded from: classes4.dex */
public class f {
    private boolean bja;
    private View contentView;
    private Context context;
    private int guU = -1;
    private TextView gwL;
    private HeadImageView gwN;
    private TextView gwO;
    private TextView gwR;
    private View.OnClickListener gwz;
    private TextView gxh;
    private TextView mName;
    private String mOtherParams;
    private View mRootView;

    public f(Context context, View.OnClickListener onClickListener) {
        this.context = context;
        this.gwz = onClickListener;
        this.mRootView = LayoutInflater.from(context).inflate(a.g.improve_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        FZ();
        this.gwL = (TextView) this.mRootView.findViewById(a.f.tvGradeNum);
        this.gwN = (HeadImageView) this.mRootView.findViewById(a.f.photo);
        this.gwN.setIsRound(true);
        this.gwN.setAutoChangeStyle(false);
        this.gwN.setClickable(false);
        this.mName = (TextView) this.mRootView.findViewById(a.f.ala_name);
        this.gwO = (TextView) this.mRootView.findViewById(a.f.ala_intro);
        this.gxh = (TextView) this.mRootView.findViewById(a.f.sub_charm_textView);
        this.gwR = (TextView) this.mRootView.findViewById(a.f.improve_rink_btn);
        this.contentView.setClickable(true);
    }

    public void a(final com.baidu.tieba.ala.charm.data.a aVar) {
        if (aVar != null) {
            this.gwR.setTag(new int[]{aVar.type, aVar.grade});
            String str = "";
            if (aVar.type == 0) {
                this.gwL.setText("未上榜");
                this.gxh.setVisibility(8);
                this.gwO.setText(a.h.become_vip_text);
                this.gwR.setText(a.h.goto_list_text);
                str = "no_list";
            } else if (aVar.type == 1) {
                this.gwL.setText("未上榜");
                this.gxh.setVisibility(8);
                this.gwO.setText(Html.fromHtml("距离第100名还差<font color='#ff1e66'>" + aVar.gvP + "魅力</font>"));
                this.gwR.setText(a.h.goto_list_text);
                str = "no_list_hundred";
            } else if (aVar.type == 2) {
                this.gwL.setText("01");
                this.gxh.setVisibility(8);
                this.gwO.setText(this.mRootView.getContext().getResources().getString(a.h.ala_pay_gift_name, aVar.totalPrice + ""));
                this.gwR.setVisibility(8);
                str = "my_ranking";
            } else if (aVar.type == 3) {
                if (aVar.grade < 10) {
                    this.gwL.setText("0" + aVar.grade);
                } else {
                    this.gwL.setText(String.valueOf(aVar.grade));
                }
                this.gxh.setText(String.format("还差%s魅力", Long.valueOf(aVar.gvP)));
                this.gxh.setVisibility(0);
                this.gwO.setText(a.h.transcend_text);
                this.gwR.setText(a.h.improve_rink_text);
                if (aVar.grade <= 100) {
                    str = "my_ranking";
                } else {
                    str = "no_list_hundred";
                }
            }
            l.a(this.gwN, aVar.portrait, true, false);
            this.mName.setText(aVar.userName);
            this.gwR.setOnClickListener(this.gwz);
            if (!this.bja && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                String uQ = com.baidu.tieba.ala.charm.g.uQ(this.guU);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, uQ);
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

    public void FZ() {
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

    public void ma(boolean z) {
        this.bja = z;
    }

    public void uT(int i) {
        this.guU = i;
    }

    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }
}
