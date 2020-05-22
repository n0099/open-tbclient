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
public class f {
    private boolean aSw;
    private View contentView;
    private Context context;
    private int fnS = -1;
    private TextView fpI;
    private HeadImageView fpK;
    private TextView fpL;
    private TextView fpO;
    private View.OnClickListener fpw;
    private TextView fqf;
    private TextView mName;
    private String mOtherParams;
    private View mRootView;

    public f(Context context, View.OnClickListener onClickListener) {
        this.context = context;
        this.fpw = onClickListener;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.improve_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.content_view);
        ya();
        this.fpI = (TextView) this.mRootView.findViewById(a.g.tvGradeNum);
        this.fpK = (HeadImageView) this.mRootView.findViewById(a.g.photo);
        this.fpK.setIsRound(true);
        this.fpK.setAutoChangeStyle(false);
        this.fpK.setClickable(false);
        this.mName = (TextView) this.mRootView.findViewById(a.g.ala_name);
        this.fpL = (TextView) this.mRootView.findViewById(a.g.ala_intro);
        this.fqf = (TextView) this.mRootView.findViewById(a.g.sub_charm_textView);
        this.fpO = (TextView) this.mRootView.findViewById(a.g.improve_rink_btn);
        this.contentView.setClickable(true);
    }

    public void a(final com.baidu.tieba.ala.charm.data.a aVar) {
        if (aVar != null) {
            this.fpO.setTag(new int[]{aVar.type, aVar.grade});
            String str = "";
            if (aVar.type == 0) {
                this.fpI.setText("未上榜");
                this.fqf.setVisibility(8);
                this.fpL.setText(a.i.become_vip_text);
                this.fpO.setText(a.i.goto_list_text);
                str = "no_list";
            } else if (aVar.type == 1) {
                this.fpI.setText("未上榜");
                this.fqf.setVisibility(8);
                this.fpL.setText(Html.fromHtml("距离第100名还差<font color='#ff1e66'>" + aVar.foL + "魅力</font>"));
                this.fpO.setText(a.i.goto_list_text);
                str = "no_list_hundred";
            } else if (aVar.type == 2) {
                this.fpI.setText("01");
                this.fqf.setVisibility(8);
                this.fpL.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aVar.totalPrice + ""));
                this.fpO.setVisibility(8);
                str = "my_ranking";
            } else if (aVar.type == 3) {
                if (aVar.grade < 10) {
                    this.fpI.setText("0" + aVar.grade);
                } else {
                    this.fpI.setText(String.valueOf(aVar.grade));
                }
                this.fqf.setText(String.format("还差%s魅力", Long.valueOf(aVar.foL)));
                this.fqf.setVisibility(0);
                this.fpL.setText(a.i.transcend_text);
                this.fpO.setText(a.i.improve_rink_text);
                if (aVar.grade <= 100) {
                    str = "my_ranking";
                } else {
                    str = "no_list_hundred";
                }
            }
            k.a(this.fpK, aVar.portrait, true, false);
            this.mName.setText(aVar.userName);
            this.fpO.setOnClickListener(this.fpw);
            if (!this.aSw && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                String pW = com.baidu.tieba.ala.charm.g.pW(this.fnS);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, pW);
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

    public void ya() {
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

    public void jI(boolean z) {
        this.aSw = z;
    }

    public void pZ(int i) {
        this.fnS = i;
    }

    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }
}
