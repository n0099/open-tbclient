package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.utils.k;
/* loaded from: classes2.dex */
public class e {
    private boolean apz;
    private View contentView;
    private Context context;
    private int erz = -1;
    private View.OnClickListener esM;
    private TextView esY;
    private HeadImageView eta;
    private TextView etb;
    private TextView etf;
    private TextView eth;
    private TextView mName;
    private String mOtherParams;
    private View mRootView;

    public e(Context context, View.OnClickListener onClickListener) {
        this.context = context;
        this.esM = onClickListener;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.improve_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.content_view);
        rl();
        this.esY = (TextView) this.mRootView.findViewById(a.g.tvGradeNum);
        this.eta = (HeadImageView) this.mRootView.findViewById(a.g.photo);
        this.eta.setIsRound(true);
        this.eta.setAutoChangeStyle(false);
        this.eta.setClickable(false);
        this.mName = (TextView) this.mRootView.findViewById(a.g.ala_name);
        this.etb = (TextView) this.mRootView.findViewById(a.g.ala_intro);
        this.eth = (TextView) this.mRootView.findViewById(a.g.sub_charm_textView);
        this.etf = (TextView) this.mRootView.findViewById(a.g.improve_rink_btn);
        this.contentView.setClickable(true);
    }

    public void a(final com.baidu.tieba.ala.charm.data.a aVar) {
        if (aVar != null) {
            this.etf.setTag(new int[]{aVar.type, aVar.grade});
            String str = "";
            if (aVar.type == 0) {
                this.esY.setText("未上榜");
                this.eth.setVisibility(8);
                this.etb.setText(a.i.become_vip_text);
                this.etf.setText(a.i.goto_list_text);
                str = "no_list";
            } else if (aVar.type == 1) {
                this.esY.setText("未上榜");
                this.eth.setVisibility(8);
                this.etb.setText(Html.fromHtml("距离第100名还差<font color='#ff1e66'>" + aVar.esh + "魅力</font>"));
                this.etf.setText(a.i.goto_list_text);
                str = "no_list_hundred";
            } else if (aVar.type == 2) {
                this.esY.setText("01");
                this.eth.setVisibility(8);
                this.etb.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aVar.totalPrice + ""));
                this.etf.setVisibility(8);
                str = "my_ranking";
            } else if (aVar.type == 3) {
                if (aVar.grade < 10) {
                    this.esY.setText("0" + aVar.grade);
                } else {
                    this.esY.setText(String.valueOf(aVar.grade));
                }
                this.eth.setText(String.format("还差%s魅力", Long.valueOf(aVar.esh)));
                this.eth.setVisibility(0);
                this.etb.setText(a.i.transcend_text);
                this.etf.setText(a.i.improve_rink_text);
                if (aVar.grade <= 100) {
                    str = "my_ranking";
                } else {
                    str = "no_list_hundred";
                }
            }
            k.a(this.eta, aVar.portrait, true, false);
            this.mName.setText(aVar.userName);
            this.etf.setOnClickListener(this.esM);
            if (!this.apz && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                String oH = com.baidu.tieba.ala.charm.e.oH(this.erz);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oH);
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

    public void rl() {
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

    /* renamed from: if  reason: not valid java name */
    public void m27if(boolean z) {
        this.apz = z;
    }

    public void oK(int i) {
        this.erz = i;
    }

    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }
}
