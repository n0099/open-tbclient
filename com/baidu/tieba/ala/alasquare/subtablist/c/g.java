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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g {
    private bw fCx;
    private String fGE;
    private i fKb;
    private boolean fMz;
    private a fNc;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.fCx != null && g.this.fCx.beY() != null && g.this.fKb != null) {
                    g.this.fKb.a(g.this.tabId, g.this.fGE, g.this.fCx);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener fMA = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.fCx != null && g.this.fCx.beE() != null && !StringUtils.isNull(g.this.fCx.beE().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.fCx.beE().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.fCx.beE().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.fNc = new a(this.mRootView);
        this.fMz = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.fKb = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.fCx == null || cVar.fCx.beY() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fCx = cVar.fCx;
        this.tabId = cVar.tabId;
        this.fGE = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.fNc.fMC.setDrawerType(0);
        this.fNc.fMC.setBorderSurroundContent(true);
        this.fNc.fMC.setDrawBorder(true);
        this.fNc.fMC.startLoad(this.fCx.beY().cover, 10, false);
        this.fNc.fME.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.fCx.beY().audience_count)));
        this.fNc.fMG.setData(this.fCx, false);
        this.fNc.fMH.setText(this.fCx.getTitle());
        if (this.fCx.beE() != null) {
            String name_show = this.fCx.beE().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fNc.aOU.setText(name_show);
        }
        String str = this.fCx.beY().label_name;
        if (this.fMz && !StringUtils.isNull(str)) {
            this.fNc.fMD.setText(str);
            this.fNc.fMD.setVisibility(0);
        } else {
            this.fNc.fMD.setVisibility(8);
        }
        if (cVar.fCy) {
            this.fNc.fMI.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, at.numberUniformFormatExtra((long) (this.fCx.beY().distance / 1000.0d))));
            this.fNc.fMI.setVisibility(0);
        } else {
            this.fNc.fMI.setVisibility(8);
        }
        this.fNc.aOU.setOnClickListener(this.fMA);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.fNc.fMF, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.fNc.fME, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fNc.aOU, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fNc.fMH, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.fNc.fMI, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView aOU;
        public TbImageView fMC;
        public TextView fMD;
        public TextView fME;
        public RelativeLayout fMF;
        public ClickableHeaderImageView fMG;
        public TextView fMH;
        public TextView fMI;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fMC = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fMD = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fME = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fMF = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fMG = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aOU = (TextView) view.findViewById(R.id.tvUserName);
            this.fMH = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fMI = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.fMC.setDefaultErrorResource(0);
            this.fMC.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fMC.setDrawerType(0);
            this.fMG.setIsRound(true);
            this.fMG.setDrawBorder(true);
            this.fMG.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.fMG.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.fMG.setIsGod(false);
            this.fMG.setIsBigV(false);
            this.fMG.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fMF.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.fMF.setLayoutParams(layoutParams);
        }
    }
}
