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
    private boolean asR;
    private View contentView;
    private Context context;
    private int evK = -1;
    private View.OnClickListener ewX;
    private TextView exj;
    private HeadImageView exl;
    private TextView exm;
    private TextView exp;
    private TextView exr;
    private TextView mName;
    private String mOtherParams;
    private View mRootView;

    public e(Context context, View.OnClickListener onClickListener) {
        this.context = context;
        this.ewX = onClickListener;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.improve_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.content_view);
        sm();
        this.exj = (TextView) this.mRootView.findViewById(a.g.tvGradeNum);
        this.exl = (HeadImageView) this.mRootView.findViewById(a.g.photo);
        this.exl.setIsRound(true);
        this.exl.setAutoChangeStyle(false);
        this.exl.setClickable(false);
        this.mName = (TextView) this.mRootView.findViewById(a.g.ala_name);
        this.exm = (TextView) this.mRootView.findViewById(a.g.ala_intro);
        this.exr = (TextView) this.mRootView.findViewById(a.g.sub_charm_textView);
        this.exp = (TextView) this.mRootView.findViewById(a.g.improve_rink_btn);
        this.contentView.setClickable(true);
    }

    public void a(final com.baidu.tieba.ala.charm.data.a aVar) {
        if (aVar != null) {
            this.exp.setTag(new int[]{aVar.type, aVar.grade});
            String str = "";
            if (aVar.type == 0) {
                this.exj.setText("未上榜");
                this.exr.setVisibility(8);
                this.exm.setText(a.i.become_vip_text);
                this.exp.setText(a.i.goto_list_text);
                str = "no_list";
            } else if (aVar.type == 1) {
                this.exj.setText("未上榜");
                this.exr.setVisibility(8);
                this.exm.setText(Html.fromHtml("距离第100名还差<font color='#ff1e66'>" + aVar.ews + "魅力</font>"));
                this.exp.setText(a.i.goto_list_text);
                str = "no_list_hundred";
            } else if (aVar.type == 2) {
                this.exj.setText("01");
                this.exr.setVisibility(8);
                this.exm.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aVar.totalPrice + ""));
                this.exp.setVisibility(8);
                str = "my_ranking";
            } else if (aVar.type == 3) {
                if (aVar.grade < 10) {
                    this.exj.setText("0" + aVar.grade);
                } else {
                    this.exj.setText(String.valueOf(aVar.grade));
                }
                this.exr.setText(String.format("还差%s魅力", Long.valueOf(aVar.ews)));
                this.exr.setVisibility(0);
                this.exm.setText(a.i.transcend_text);
                this.exp.setText(a.i.improve_rink_text);
                if (aVar.grade <= 100) {
                    str = "my_ranking";
                } else {
                    str = "no_list_hundred";
                }
            }
            k.a(this.exl, aVar.portrait, true, false);
            this.mName.setText(aVar.userName);
            this.exp.setOnClickListener(this.ewX);
            if (!this.asR && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                String oY = com.baidu.tieba.ala.charm.e.oY(this.evK);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oY);
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

    public void sm() {
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

    public void im(boolean z) {
        this.asR = z;
    }

    public void pb(int i) {
        this.evK = i;
    }

    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }
}
