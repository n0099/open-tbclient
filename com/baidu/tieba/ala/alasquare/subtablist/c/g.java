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
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g {
    private bw fFN;
    private String fJU;
    private i fNt;
    private boolean fPR;
    private a fQu;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.fFN != null && g.this.fFN.bfS() != null && g.this.fNt != null) {
                    g.this.fNt.a(g.this.tabId, g.this.fJU, g.this.fFN);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener fPS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.fFN != null && g.this.fFN.bfy() != null && !StringUtils.isNull(g.this.fFN.bfy().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.fFN.bfy().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.fFN.bfy().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.fQu = new a(this.mRootView);
        this.fPR = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.fNt = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.fFN == null || cVar.fFN.bfS() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fFN = cVar.fFN;
        this.tabId = cVar.tabId;
        this.fJU = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.fQu.fPU.setDrawerType(0);
        this.fQu.fPU.setBorderSurroundContent(true);
        this.fQu.fPU.setDrawBorder(true);
        this.fQu.fPU.startLoad(this.fFN.bfS().cover, 10, false);
        this.fQu.fPW.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.fFN.bfS().audience_count)));
        this.fQu.fPY.setData(this.fFN, false);
        this.fQu.fPZ.setText(this.fFN.getTitle());
        if (this.fFN.bfy() != null) {
            String name_show = this.fFN.bfy().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fQu.aQY.setText(name_show);
        }
        String str = this.fFN.bfS().label_name;
        if (this.fPR && !StringUtils.isNull(str)) {
            this.fQu.fPV.setText(str);
            this.fQu.fPV.setVisibility(0);
        } else {
            this.fQu.fPV.setVisibility(8);
        }
        if (cVar.fFO) {
            this.fQu.fQa.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, at.numberUniformFormatExtra((long) (this.fFN.bfS().distance / 1000.0d))));
            this.fQu.fQa.setVisibility(0);
        } else {
            this.fQu.fQa.setVisibility(8);
        }
        this.fQu.aQY.setOnClickListener(this.fPS);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.fQu.fPX, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.fQu.fPW, R.color.cp_cont_a);
            ap.setViewTextColor(this.fQu.aQY, R.color.cp_cont_a);
            ap.setViewTextColor(this.fQu.fPZ, R.color.cp_cont_b);
            ap.setViewTextColor(this.fQu.fQa, R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView aQY;
        public TbImageView fPU;
        public TextView fPV;
        public TextView fPW;
        public RelativeLayout fPX;
        public ClickableHeaderImageView fPY;
        public TextView fPZ;
        public TextView fQa;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fPU = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fPV = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fPW = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fPX = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fPY = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aQY = (TextView) view.findViewById(R.id.tvUserName);
            this.fPZ = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fQa = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.fPU.setDefaultErrorResource(0);
            this.fPU.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fPU.setDrawerType(0);
            this.fPY.setIsRound(true);
            this.fPY.setDrawBorder(true);
            this.fPY.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.fPY.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.fPY.setIsGod(false);
            this.fPY.setIsBigV(false);
            this.fPY.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fPX.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.fPX.setLayoutParams(layoutParams);
        }
    }
}
