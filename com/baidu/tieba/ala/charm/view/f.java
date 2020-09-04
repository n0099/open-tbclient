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
import com.baidu.live.utils.k;
/* loaded from: classes7.dex */
public class f {
    private boolean bbJ;
    private View contentView;
    private Context context;
    private int fPS = -1;
    private TextView fRJ;
    private HeadImageView fRL;
    private TextView fRM;
    private TextView fRP;
    private View.OnClickListener fRx;
    private TextView fSg;
    private TextView mName;
    private String mOtherParams;
    private View mRootView;

    public f(Context context, View.OnClickListener onClickListener) {
        this.context = context;
        this.fRx = onClickListener;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.improve_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.content_view);
        EF();
        this.fRJ = (TextView) this.mRootView.findViewById(a.g.tvGradeNum);
        this.fRL = (HeadImageView) this.mRootView.findViewById(a.g.photo);
        this.fRL.setIsRound(true);
        this.fRL.setAutoChangeStyle(false);
        this.fRL.setClickable(false);
        this.mName = (TextView) this.mRootView.findViewById(a.g.ala_name);
        this.fRM = (TextView) this.mRootView.findViewById(a.g.ala_intro);
        this.fSg = (TextView) this.mRootView.findViewById(a.g.sub_charm_textView);
        this.fRP = (TextView) this.mRootView.findViewById(a.g.improve_rink_btn);
        this.contentView.setClickable(true);
    }

    public void a(final com.baidu.tieba.ala.charm.data.a aVar) {
        if (aVar != null) {
            this.fRP.setTag(new int[]{aVar.type, aVar.grade});
            String str = "";
            if (aVar.type == 0) {
                this.fRJ.setText("未上榜");
                this.fSg.setVisibility(8);
                this.fRM.setText(a.i.become_vip_text);
                this.fRP.setText(a.i.goto_list_text);
                str = "no_list";
            } else if (aVar.type == 1) {
                this.fRJ.setText("未上榜");
                this.fSg.setVisibility(8);
                this.fRM.setText(Html.fromHtml("距离第100名还差<font color='#ff1e66'>" + aVar.fQN + "魅力</font>"));
                this.fRP.setText(a.i.goto_list_text);
                str = "no_list_hundred";
            } else if (aVar.type == 2) {
                this.fRJ.setText("01");
                this.fSg.setVisibility(8);
                this.fRM.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aVar.totalPrice + ""));
                this.fRP.setVisibility(8);
                str = "my_ranking";
            } else if (aVar.type == 3) {
                if (aVar.grade < 10) {
                    this.fRJ.setText("0" + aVar.grade);
                } else {
                    this.fRJ.setText(String.valueOf(aVar.grade));
                }
                this.fSg.setText(String.format("还差%s魅力", Long.valueOf(aVar.fQN)));
                this.fSg.setVisibility(0);
                this.fRM.setText(a.i.transcend_text);
                this.fRP.setText(a.i.improve_rink_text);
                if (aVar.grade <= 100) {
                    str = "my_ranking";
                } else {
                    str = "no_list_hundred";
                }
            }
            k.a(this.fRL, aVar.portrait, true, false);
            this.mName.setText(aVar.userName);
            this.fRP.setOnClickListener(this.fRx);
            if (!this.bbJ && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                String sY = com.baidu.tieba.ala.charm.g.sY(this.fPS);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, sY);
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

    public void EF() {
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

    public void kZ(boolean z) {
        this.bbJ = z;
    }

    public void tb(int i) {
        this.fPS = i;
    }

    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }
}
