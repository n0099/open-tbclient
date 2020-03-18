package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
/* loaded from: classes3.dex */
public class e {
    private boolean atc;
    private View contentView;
    private Context context;
    private int ewt = -1;
    private View.OnClickListener exH;
    private TextView exT;
    private HeadImageView exV;
    private TextView exW;
    private TextView exZ;
    private TextView eyb;
    private TextView mName;
    private String mOtherParams;
    private View mRootView;

    public e(Context context, View.OnClickListener onClickListener) {
        this.context = context;
        this.exH = onClickListener;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.improve_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.content_view);
        sr();
        this.exT = (TextView) this.mRootView.findViewById(a.g.tvGradeNum);
        this.exV = (HeadImageView) this.mRootView.findViewById(a.g.photo);
        this.exV.setIsRound(true);
        this.exV.setAutoChangeStyle(false);
        this.exV.setClickable(false);
        this.mName = (TextView) this.mRootView.findViewById(a.g.ala_name);
        this.exW = (TextView) this.mRootView.findViewById(a.g.ala_intro);
        this.eyb = (TextView) this.mRootView.findViewById(a.g.sub_charm_textView);
        this.exZ = (TextView) this.mRootView.findViewById(a.g.improve_rink_btn);
        this.contentView.setClickable(true);
    }

    public void a(final com.baidu.tieba.ala.charm.data.a aVar) {
        if (aVar != null) {
            this.exZ.setTag(new int[]{aVar.type, aVar.grade});
            String str = "";
            if (aVar.type == 0) {
                this.exT.setText("未上榜");
                this.eyb.setVisibility(8);
                this.exW.setText(a.i.become_vip_text);
                this.exZ.setText(a.i.goto_list_text);
                str = "no_list";
            } else if (aVar.type == 1) {
                this.exT.setText("未上榜");
                this.eyb.setVisibility(8);
                this.exW.setText(Html.fromHtml("距离第100名还差<font color='#ff1e66'>" + aVar.exb + "魅力</font>"));
                this.exZ.setText(a.i.goto_list_text);
                str = "no_list_hundred";
            } else if (aVar.type == 2) {
                this.exT.setText("01");
                this.eyb.setVisibility(8);
                this.exW.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aVar.totalPrice + ""));
                this.exZ.setVisibility(8);
                str = "my_ranking";
            } else if (aVar.type == 3) {
                if (aVar.grade < 10) {
                    this.exT.setText("0" + aVar.grade);
                } else {
                    this.exT.setText(String.valueOf(aVar.grade));
                }
                this.eyb.setText(String.format("还差%s魅力", Long.valueOf(aVar.exb)));
                this.eyb.setVisibility(0);
                this.exW.setText(a.i.transcend_text);
                this.exZ.setText(a.i.improve_rink_text);
                if (aVar.grade <= 100) {
                    str = "my_ranking";
                } else {
                    str = "no_list_hundred";
                }
            }
            k.a(this.exV, aVar.portrait, true, false);
            this.mName.setText(aVar.userName);
            this.exZ.setOnClickListener(this.exH);
            if (!this.atc && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                String pa = com.baidu.tieba.ala.charm.e.pa(this.ewt);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, pa);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, str);
                alaStaticItem.addParams("other_params", this.mOtherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            this.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(e.this.context, aVar.userId)));
                }
            });
        }
    }

    public void sr() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.context) == 2) {
                this.contentView.setBackgroundResource(a.f.improve_charm_bottom_layout_bg_land);
            } else {
                this.contentView.setBackgroundColor(this.context.getResources().getColor(a.d.ala_charm_bottom_color));
            }
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void io(boolean z) {
        this.atc = z;
    }

    public void pd(int i) {
        this.ewt = i;
    }

    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }
}
