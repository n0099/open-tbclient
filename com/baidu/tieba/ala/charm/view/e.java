package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.utils.j;
/* loaded from: classes6.dex */
public class e {
    private boolean agL;
    private View contentView;
    private Context context;
    private int dEy = -1;
    private TextView dFK;
    private HeadImageView dFM;
    private TextView dFN;
    private TextView dFQ;
    private TextView dFS;
    private View.OnClickListener dFy;
    private TextView mName;
    private String mOtherParams;
    private View mRootView;

    public e(Context context, View.OnClickListener onClickListener) {
        this.context = context;
        this.dFy = onClickListener;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.improve_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.content_view);
        pC();
        this.dFK = (TextView) this.mRootView.findViewById(a.g.tvGradeNum);
        this.dFM = (HeadImageView) this.mRootView.findViewById(a.g.photo);
        this.dFM.setIsRound(true);
        this.dFM.setAutoChangeStyle(false);
        this.dFM.setClickable(false);
        this.mName = (TextView) this.mRootView.findViewById(a.g.ala_name);
        this.dFN = (TextView) this.mRootView.findViewById(a.g.ala_intro);
        this.dFS = (TextView) this.mRootView.findViewById(a.g.sub_charm_textView);
        this.dFQ = (TextView) this.mRootView.findViewById(a.g.improve_rink_btn);
        this.contentView.setClickable(true);
    }

    public void a(final com.baidu.tieba.ala.charm.data.a aVar) {
        if (aVar != null) {
            this.dFQ.setTag(new int[]{aVar.type, aVar.grade});
            String str = "";
            if (aVar.type == 0) {
                this.dFK.setText("未上榜");
                this.dFS.setVisibility(8);
                this.dFN.setText(a.i.become_vip_text);
                this.dFQ.setText(a.i.goto_list_text);
                str = "no_list";
            } else if (aVar.type == 1) {
                this.dFK.setText("未上榜");
                this.dFS.setVisibility(8);
                this.dFN.setText(Html.fromHtml("距离第100名还差<font color='#ff1e66'>" + aVar.dES + "魅力</font>"));
                this.dFQ.setText(a.i.goto_list_text);
                str = "no_list_hundred";
            } else if (aVar.type == 2) {
                this.dFK.setText("01");
                this.dFS.setVisibility(8);
                this.dFN.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aVar.totalPrice + ""));
                this.dFQ.setVisibility(8);
                str = "my_ranking";
            } else if (aVar.type == 3) {
                if (aVar.grade < 10) {
                    this.dFK.setText("0" + aVar.grade);
                } else {
                    this.dFK.setText(String.valueOf(aVar.grade));
                }
                this.dFS.setText(String.format("还差%s魅力", Long.valueOf(aVar.dES)));
                this.dFS.setVisibility(0);
                this.dFN.setText(a.i.transcend_text);
                this.dFQ.setText(a.i.improve_rink_text);
                if (aVar.grade <= 100) {
                    str = "my_ranking";
                } else {
                    str = "no_list_hundred";
                }
            }
            j.a(this.dFM, aVar.portrait, true, false);
            this.mName.setText(aVar.userName);
            this.dFQ.setOnClickListener(this.dFy);
            if (!this.agL) {
                String mv = com.baidu.tieba.ala.charm.d.mv(this.dEy);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, mv);
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

    public void pC() {
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

    public void gQ(boolean z) {
        this.agL = z;
    }

    public void my(int i) {
        this.dEy = i;
    }

    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }
}
