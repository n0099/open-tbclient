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
    View.OnClickListener gJo;
    private h gVl;
    private String gWE;
    private C0634a gXE;
    private cb gyO;
    private View mRootView;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.gamelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0634a {
        public TextView aYx;
        public TbImageView gJq;
        public TextView gJr;
        public TextView gJs;
        public RelativeLayout gJt;
        public ClickableHeaderImageView gJu;
        public TextView gJv;
        public TbImageView gWH;
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
        this.gyO = cbVar;
        this.gXE.gJq.setDrawerType(0);
        this.gXE.gJq.setBorderSurroundContent(true);
        this.gXE.gJq.setDrawBorder(true);
        this.gXE.gJq.startLoad(this.gyO.boj().cover, 10, false);
        this.gXE.gJs.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, au.numberUniformFormatExtra(this.gyO.boj().audience_count)));
        this.gXE.gJu.setData(this.gyO);
        this.gXE.gJu.setIsRound(true);
        this.gXE.gJu.setBorderSurroundContent(true);
        this.gXE.gJv.setText(this.gyO.getTitle());
        if (this.gyO.bnQ() != null) {
            String name_show = this.gyO.bnQ().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gXE.aYx.setText(name_show);
        }
        if ("16:9".equals(bitmapWHRatio)) {
            String str = this.gyO.boj().label_name;
            if (au.isEmpty(str)) {
                String fixedBarText = UtilHelper.getFixedBarText(this.gyO.bnU(), 6, true);
                if (!TextUtils.isEmpty(fixedBarText)) {
                    String string = this.mTbPageContext.getPageActivity().getResources().getString(R.string.chosen_pb_original_bar, fixedBarText);
                    this.gXE.gJr.setBackgroundResource(R.drawable.transparent_bg);
                    this.gXE.gJr.setText(string);
                    this.gXE.gJr.setTextSize(0, this.mTbPageContext.getResources().getDimension(R.dimen.fontsize20));
                    this.gXE.gJr.setVisibility(0);
                }
            } else if (!str.equals(this.gWE)) {
                this.gXE.gJr.setBackgroundResource(R.drawable.game_label_bg);
                this.gXE.gJr.setText(str);
                this.gXE.gJr.setTextSize(0, this.mTbPageContext.getResources().getDimension(R.dimen.ds16));
                this.gXE.gJr.setVisibility(0);
            }
        }
        if (this.gyO.bnQ() == null || this.gyO.bnQ().getAlaUserData() == null || au.isEmpty(this.gyO.bnQ().getAlaUserData().great_anchor_icon)) {
            this.gXE.gWH.setVisibility(8);
        } else {
            this.gXE.gWH.setVisibility(0);
            this.gXE.gWH.startLoad(this.gyO.bnQ().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gXE.aYx.setOnClickListener(this.gJo);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.gyO != null && this.gyO.boj() != null) {
            if (this.gVl != null) {
                this.gVl.S(this.gyO);
            }
            d.bOL().bOM();
            TiebaStatic.log(new ar("c12116").v("obj_id", this.gyO.boj().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gXE.gJt, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gXE.gJr, R.color.CAM_X0101);
            ap.setViewTextColor(this.gXE.gJs, R.color.CAM_X0101);
            ap.setViewTextColor(this.gXE.aYx, R.color.CAM_X0109);
            ap.setViewTextColor(this.gXE.gJv, R.color.CAM_X0105);
            this.mSkinType = i;
        }
    }
}
