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
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {
    private static String bitmapWHRatio;
    View.OnClickListener gGq;
    private g gSn;
    private String gTG;
    private C0633a gUG;
    private bz gvQ;
    private View mRootView;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.gamelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0633a {
        public TextView aVp;
        public TbImageView gGs;
        public TextView gGt;
        public TextView gGu;
        public RelativeLayout gGv;
        public ClickableHeaderImageView gGw;
        public TextView gGx;
        public TbImageView gTJ;
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
        this.gvQ = bzVar;
        this.gUG.gGs.setDrawerType(0);
        this.gUG.gGs.setBorderSurroundContent(true);
        this.gUG.gGs.setDrawBorder(true);
        this.gUG.gGs.startLoad(this.gvQ.bnQ().cover, 10, false);
        this.gUG.gGu.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, at.numberUniformFormatExtra(this.gvQ.bnQ().audience_count)));
        this.gUG.gGw.setData(this.gvQ);
        this.gUG.gGw.setIsRound(true);
        this.gUG.gGw.setBorderSurroundContent(true);
        this.gUG.gGx.setText(this.gvQ.getTitle());
        if (this.gvQ.bnx() != null) {
            String name_show = this.gvQ.bnx().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gUG.aVp.setText(name_show);
        }
        if ("16:9".equals(bitmapWHRatio)) {
            String str = this.gvQ.bnQ().label_name;
            if (at.isEmpty(str)) {
                String fixedBarText = UtilHelper.getFixedBarText(this.gvQ.bnB(), 6, true);
                if (!TextUtils.isEmpty(fixedBarText)) {
                    String string = this.mTbPageContext.getPageActivity().getResources().getString(R.string.chosen_pb_original_bar, fixedBarText);
                    this.gUG.gGt.setBackgroundResource(R.drawable.transparent_bg);
                    this.gUG.gGt.setText(string);
                    this.gUG.gGt.setTextSize(0, this.mTbPageContext.getResources().getDimension(R.dimen.fontsize20));
                    this.gUG.gGt.setVisibility(0);
                }
            } else if (!str.equals(this.gTG)) {
                this.gUG.gGt.setBackgroundResource(R.drawable.game_label_bg);
                this.gUG.gGt.setText(str);
                this.gUG.gGt.setTextSize(0, this.mTbPageContext.getResources().getDimension(R.dimen.ds16));
                this.gUG.gGt.setVisibility(0);
            }
        }
        if (this.gvQ.bnx() == null || this.gvQ.bnx().getAlaUserData() == null || at.isEmpty(this.gvQ.bnx().getAlaUserData().great_anchor_icon)) {
            this.gUG.gTJ.setVisibility(8);
        } else {
            this.gUG.gTJ.setVisibility(0);
            this.gUG.gTJ.startLoad(this.gvQ.bnx().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gUG.aVp.setOnClickListener(this.gGq);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.gvQ != null && this.gvQ.bnQ() != null) {
            if (this.gSn != null) {
                this.gSn.R(this.gvQ);
            }
            d.bOa().bOb();
            TiebaStatic.log(new aq("c12116").w("obj_id", this.gvQ.bnQ().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gUG.gGv, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gUG.gGt, R.color.CAM_X0101);
            ao.setViewTextColor(this.gUG.gGu, R.color.CAM_X0101);
            ao.setViewTextColor(this.gUG.aVp, R.color.CAM_X0109);
            ao.setViewTextColor(this.gUG.gGx, R.color.CAM_X0105);
            this.mSkinType = i;
        }
    }
}
