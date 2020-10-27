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
    private boolean bjr;
    private View contentView;
    private Context context;
    private int gpz = -1;
    private TextView grM;
    private View.OnClickListener gre;
    private TextView grq;
    private HeadImageView grs;
    private TextView grt;
    private TextView grw;
    private TextView mName;
    private String mOtherParams;
    private View mRootView;

    public f(Context context, View.OnClickListener onClickListener) {
        this.context = context;
        this.gre = onClickListener;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.improve_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.content_view);
        Gh();
        this.grq = (TextView) this.mRootView.findViewById(a.g.tvGradeNum);
        this.grs = (HeadImageView) this.mRootView.findViewById(a.g.photo);
        this.grs.setIsRound(true);
        this.grs.setAutoChangeStyle(false);
        this.grs.setClickable(false);
        this.mName = (TextView) this.mRootView.findViewById(a.g.ala_name);
        this.grt = (TextView) this.mRootView.findViewById(a.g.ala_intro);
        this.grM = (TextView) this.mRootView.findViewById(a.g.sub_charm_textView);
        this.grw = (TextView) this.mRootView.findViewById(a.g.improve_rink_btn);
        this.contentView.setClickable(true);
    }

    public void a(final com.baidu.tieba.ala.charm.data.a aVar) {
        if (aVar != null) {
            this.grw.setTag(new int[]{aVar.type, aVar.grade});
            String str = "";
            if (aVar.type == 0) {
                this.grq.setText("未上榜");
                this.grM.setVisibility(8);
                this.grt.setText(a.i.become_vip_text);
                this.grw.setText(a.i.goto_list_text);
                str = "no_list";
            } else if (aVar.type == 1) {
                this.grq.setText("未上榜");
                this.grM.setVisibility(8);
                this.grt.setText(Html.fromHtml("距离第100名还差<font color='#ff1e66'>" + aVar.gqu + "魅力</font>"));
                this.grw.setText(a.i.goto_list_text);
                str = "no_list_hundred";
            } else if (aVar.type == 2) {
                this.grq.setText("01");
                this.grM.setVisibility(8);
                this.grt.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aVar.totalPrice + ""));
                this.grw.setVisibility(8);
                str = "my_ranking";
            } else if (aVar.type == 3) {
                if (aVar.grade < 10) {
                    this.grq.setText("0" + aVar.grade);
                } else {
                    this.grq.setText(String.valueOf(aVar.grade));
                }
                this.grM.setText(String.format("还差%s魅力", Long.valueOf(aVar.gqu)));
                this.grM.setVisibility(0);
                this.grt.setText(a.i.transcend_text);
                this.grw.setText(a.i.improve_rink_text);
                if (aVar.grade <= 100) {
                    str = "my_ranking";
                } else {
                    str = "no_list_hundred";
                }
            }
            l.a(this.grs, aVar.portrait, true, false);
            this.mName.setText(aVar.userName);
            this.grw.setOnClickListener(this.gre);
            if (!this.bjr && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                String ui = com.baidu.tieba.ala.charm.g.ui(this.gpz);
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

    public void Gh() {
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

    public void lQ(boolean z) {
        this.bjr = z;
    }

    public void ul(int i) {
        this.gpz = i;
    }

    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }
}
