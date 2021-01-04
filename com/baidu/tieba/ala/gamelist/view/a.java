package com.baidu.tieba.ala.gamelist.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.d;
import com.baidu.tieba.ala.g;
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    private static String bitmapWHRatio;
    private bz gAx;
    View.OnClickListener gKW;
    private g gWT;
    private String gYm;
    private C0650a gZm;
    private View mRootView;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.gamelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0650a {
        public TextView bac;
        public TbImageView gKY;
        public TextView gKZ;
        public TextView gLa;
        public RelativeLayout gLb;
        public ClickableHeaderImageView gLc;
        public TextView gLd;
        public TbImageView gYp;
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(bz bzVar) {
        if (bzVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gAx = bzVar;
        this.gZm.gKY.setDrawerType(0);
        this.gZm.gKY.setBorderSurroundContent(true);
        this.gZm.gKY.setDrawBorder(true);
        this.gZm.gKY.startLoad(this.gAx.brJ().cover, 10, false);
        this.gZm.gLa.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, at.numberUniformFormatExtra(this.gAx.brJ().audience_count)));
        this.gZm.gLc.setData(this.gAx);
        this.gZm.gLc.setIsRound(true);
        this.gZm.gLc.setBorderSurroundContent(true);
        this.gZm.gLd.setText(this.gAx.getTitle());
        if (this.gAx.brq() != null) {
            String name_show = this.gAx.brq().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gZm.bac.setText(name_show);
        }
        if ("16:9".equals(bitmapWHRatio)) {
            String str = this.gAx.brJ().label_name;
            if (at.isEmpty(str)) {
                String fixedBarText = UtilHelper.getFixedBarText(this.gAx.bru(), 6, true);
                if (!TextUtils.isEmpty(fixedBarText)) {
                    String string = this.mTbPageContext.getPageActivity().getResources().getString(R.string.chosen_pb_original_bar, fixedBarText);
                    this.gZm.gKZ.setBackgroundResource(R.drawable.transparent_bg);
                    this.gZm.gKZ.setText(string);
                    this.gZm.gKZ.setTextSize(0, this.mTbPageContext.getResources().getDimension(R.dimen.fontsize20));
                    this.gZm.gKZ.setVisibility(0);
                }
            } else if (!str.equals(this.gYm)) {
                this.gZm.gKZ.setBackgroundResource(R.drawable.game_label_bg);
                this.gZm.gKZ.setText(str);
                this.gZm.gKZ.setTextSize(0, this.mTbPageContext.getResources().getDimension(R.dimen.ds16));
                this.gZm.gKZ.setVisibility(0);
            }
        }
        if (this.gAx.brq() == null || this.gAx.brq().getAlaUserData() == null || at.isEmpty(this.gAx.brq().getAlaUserData().great_anchor_icon)) {
            this.gZm.gYp.setVisibility(8);
        } else {
            this.gZm.gYp.setVisibility(0);
            this.gZm.gYp.startLoad(this.gAx.brq().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gZm.bac.setOnClickListener(this.gKW);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.gAx != null && this.gAx.brJ() != null) {
            if (this.gWT != null) {
                this.gWT.R(this.gAx);
            }
            d.bRR().bRS();
            TiebaStatic.log(new aq("c12116").w("obj_id", this.gAx.brJ().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gZm.gLb, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gZm.gKZ, R.color.CAM_X0101);
            ao.setViewTextColor(this.gZm.gLa, R.color.CAM_X0101);
            ao.setViewTextColor(this.gZm.bac, R.color.CAM_X0109);
            ao.setViewTextColor(this.gZm.gLd, R.color.CAM_X0105);
            this.mSkinType = i;
        }
    }
}
