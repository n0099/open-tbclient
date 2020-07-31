package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g {
    private a fBK;
    private boolean fBh;
    private bv frb;
    private String fvl;
    private i fyJ;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.frb != null && g.this.frb.aWF() != null && g.this.fyJ != null) {
                    g.this.fyJ.a(g.this.tabId, g.this.fvl, g.this.frb);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener fBi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.frb != null && g.this.frb.aWl() != null && !StringUtils.isNull(g.this.frb.aWl().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.frb.aWl().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.frb.aWl().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.fBK = new a(this.mRootView);
        this.fBh = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.fyJ = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.frb == null || cVar.frb.aWF() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.frb = cVar.frb;
        this.tabId = cVar.tabId;
        this.fvl = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.fBK.fBk.setDrawerType(0);
        this.fBK.fBk.setBorderSurroundContent(true);
        this.fBK.fBk.setDrawBorder(true);
        this.fBK.fBk.startLoad(this.frb.aWF().cover, 10, false);
        this.fBK.fBm.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, as.numberUniformFormatExtra(this.frb.aWF().audience_count)));
        this.fBK.fBo.setData(this.frb, false);
        this.fBK.fBp.setText(this.frb.getTitle());
        if (this.frb.aWl() != null) {
            String name_show = this.frb.aWl().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fBK.aJJ.setText(name_show);
        }
        String str = this.frb.aWF().label_name;
        if (this.fBh && !StringUtils.isNull(str)) {
            this.fBK.fBl.setText(str);
            this.fBK.fBl.setVisibility(0);
        } else {
            this.fBK.fBl.setVisibility(8);
        }
        if (cVar.frd) {
            this.fBK.fBq.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, as.numberUniformFormatExtra((long) (this.frb.aWF().distance / 1000.0d))));
            this.fBK.fBq.setVisibility(0);
        } else {
            this.fBK.fBq.setVisibility(8);
        }
        this.fBK.aJJ.setOnClickListener(this.fBi);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.fBK.fBn, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.fBK.fBm, R.color.cp_cont_a);
            ao.setViewTextColor(this.fBK.aJJ, R.color.cp_cont_a);
            ao.setViewTextColor(this.fBK.fBp, R.color.cp_cont_b);
            ao.setViewTextColor(this.fBK.fBq, R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView aJJ;
        public TbImageView fBk;
        public TextView fBl;
        public TextView fBm;
        public RelativeLayout fBn;
        public ClickableHeaderImageView fBo;
        public TextView fBp;
        public TextView fBq;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fBk = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fBl = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fBm = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fBn = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fBo = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aJJ = (TextView) view.findViewById(R.id.tvUserName);
            this.fBp = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fBq = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.fBk.setDefaultErrorResource(0);
            this.fBk.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fBk.setDrawerType(0);
            this.fBo.setIsRound(true);
            this.fBo.setDrawBorder(true);
            this.fBo.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.fBo.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.fBo.setIsGod(false);
            this.fBo.setIsBigV(false);
            this.fBo.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fBn.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.fBn.setLayoutParams(layoutParams);
        }
    }
}
