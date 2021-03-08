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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.d;
import com.baidu.tieba.ala.h;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {
    private static String bitmapWHRatio;
    private cb gAx;
    View.OnClickListener gKX;
    private h gWU;
    private String gYn;
    private C0640a gZn;
    private View mRootView;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.gamelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0640a {
        public TextView aZX;
        public TbImageView gKZ;
        public TextView gLa;
        public TextView gLb;
        public RelativeLayout gLc;
        public ClickableHeaderImageView gLd;
        public TextView gLe;
        public TbImageView gYq;
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(cb cbVar) {
        if (cbVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gAx = cbVar;
        this.gZn.gKZ.setDrawerType(0);
        this.gZn.gKZ.setBorderSurroundContent(true);
        this.gZn.gKZ.setDrawBorder(true);
        this.gZn.gKZ.startLoad(this.gAx.bol().cover, 10, false);
        this.gZn.gLb.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, au.numberUniformFormatExtra(this.gAx.bol().audience_count)));
        this.gZn.gLd.setData(this.gAx);
        this.gZn.gLd.setIsRound(true);
        this.gZn.gLd.setBorderSurroundContent(true);
        this.gZn.gLe.setText(this.gAx.getTitle());
        if (this.gAx.bnS() != null) {
            String name_show = this.gAx.bnS().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gZn.aZX.setText(name_show);
        }
        if ("16:9".equals(bitmapWHRatio)) {
            String str = this.gAx.bol().label_name;
            if (au.isEmpty(str)) {
                String fixedBarText = UtilHelper.getFixedBarText(this.gAx.bnW(), 6, true);
                if (!TextUtils.isEmpty(fixedBarText)) {
                    String string = this.mTbPageContext.getPageActivity().getResources().getString(R.string.chosen_pb_original_bar, fixedBarText);
                    this.gZn.gLa.setBackgroundResource(R.drawable.transparent_bg);
                    this.gZn.gLa.setText(string);
                    this.gZn.gLa.setTextSize(0, this.mTbPageContext.getResources().getDimension(R.dimen.fontsize20));
                    this.gZn.gLa.setVisibility(0);
                }
            } else if (!str.equals(this.gYn)) {
                this.gZn.gLa.setBackgroundResource(R.drawable.game_label_bg);
                this.gZn.gLa.setText(str);
                this.gZn.gLa.setTextSize(0, this.mTbPageContext.getResources().getDimension(R.dimen.ds16));
                this.gZn.gLa.setVisibility(0);
            }
        }
        if (this.gAx.bnS() == null || this.gAx.bnS().getAlaUserData() == null || au.isEmpty(this.gAx.bnS().getAlaUserData().great_anchor_icon)) {
            this.gZn.gYq.setVisibility(8);
        } else {
            this.gZn.gYq.setVisibility(0);
            this.gZn.gYq.startLoad(this.gAx.bnS().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gZn.aZX.setOnClickListener(this.gKX);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.gAx != null && this.gAx.bol() != null) {
            if (this.gWU != null) {
                this.gWU.S(this.gAx);
            }
            d.bOR().bOS();
            TiebaStatic.log(new ar("c12116").v("obj_id", this.gAx.bol().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gZn.gLc, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gZn.gLa, R.color.CAM_X0101);
            ap.setViewTextColor(this.gZn.gLb, R.color.CAM_X0101);
            ap.setViewTextColor(this.gZn.aZX, R.color.CAM_X0109);
            ap.setViewTextColor(this.gZn.gLe, R.color.CAM_X0105);
            this.mSkinType = i;
        }
    }
}
