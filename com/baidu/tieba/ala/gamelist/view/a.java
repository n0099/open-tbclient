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
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    private static String bitmapWHRatio;
    View.OnClickListener gJa;
    private h gUX;
    private String gWq;
    private C0633a gXq;
    private cb gyA;
    private View mRootView;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.gamelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0633a {
        public TextView aYx;
        public TbImageView gJc;
        public TextView gJd;
        public TextView gJe;
        public RelativeLayout gJf;
        public ClickableHeaderImageView gJg;
        public TextView gJh;
        public TbImageView gWt;
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
        this.gyA = cbVar;
        this.gXq.gJc.setDrawerType(0);
        this.gXq.gJc.setBorderSurroundContent(true);
        this.gXq.gJc.setDrawBorder(true);
        this.gXq.gJc.startLoad(this.gyA.boj().cover, 10, false);
        this.gXq.gJe.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, au.numberUniformFormatExtra(this.gyA.boj().audience_count)));
        this.gXq.gJg.setData(this.gyA);
        this.gXq.gJg.setIsRound(true);
        this.gXq.gJg.setBorderSurroundContent(true);
        this.gXq.gJh.setText(this.gyA.getTitle());
        if (this.gyA.bnQ() != null) {
            String name_show = this.gyA.bnQ().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gXq.aYx.setText(name_show);
        }
        if ("16:9".equals(bitmapWHRatio)) {
            String str = this.gyA.boj().label_name;
            if (au.isEmpty(str)) {
                String fixedBarText = UtilHelper.getFixedBarText(this.gyA.bnU(), 6, true);
                if (!TextUtils.isEmpty(fixedBarText)) {
                    String string = this.mTbPageContext.getPageActivity().getResources().getString(R.string.chosen_pb_original_bar, fixedBarText);
                    this.gXq.gJd.setBackgroundResource(R.drawable.transparent_bg);
                    this.gXq.gJd.setText(string);
                    this.gXq.gJd.setTextSize(0, this.mTbPageContext.getResources().getDimension(R.dimen.fontsize20));
                    this.gXq.gJd.setVisibility(0);
                }
            } else if (!str.equals(this.gWq)) {
                this.gXq.gJd.setBackgroundResource(R.drawable.game_label_bg);
                this.gXq.gJd.setText(str);
                this.gXq.gJd.setTextSize(0, this.mTbPageContext.getResources().getDimension(R.dimen.ds16));
                this.gXq.gJd.setVisibility(0);
            }
        }
        if (this.gyA.bnQ() == null || this.gyA.bnQ().getAlaUserData() == null || au.isEmpty(this.gyA.bnQ().getAlaUserData().great_anchor_icon)) {
            this.gXq.gWt.setVisibility(8);
        } else {
            this.gXq.gWt.setVisibility(0);
            this.gXq.gWt.startLoad(this.gyA.bnQ().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gXq.aYx.setOnClickListener(this.gJa);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.gyA != null && this.gyA.boj() != null) {
            if (this.gUX != null) {
                this.gUX.S(this.gyA);
            }
            d.bOE().bOF();
            TiebaStatic.log(new ar("c12116").v("obj_id", this.gyA.boj().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gXq.gJf, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gXq.gJd, R.color.CAM_X0101);
            ap.setViewTextColor(this.gXq.gJe, R.color.CAM_X0101);
            ap.setViewTextColor(this.gXq.aYx, R.color.CAM_X0109);
            ap.setViewTextColor(this.gXq.gJh, R.color.CAM_X0105);
            this.mSkinType = i;
        }
    }
}
