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
    private bw fCB;
    private String fGI;
    private i fKf;
    private boolean fMD;
    private a fNg;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.fCB != null && g.this.fCB.beY() != null && g.this.fKf != null) {
                    g.this.fKf.a(g.this.tabId, g.this.fGI, g.this.fCB);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener fME = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.fCB != null && g.this.fCB.beE() != null && !StringUtils.isNull(g.this.fCB.beE().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.fCB.beE().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.fCB.beE().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.fNg = new a(this.mRootView);
        this.fMD = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.fKf = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.fCB == null || cVar.fCB.beY() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fCB = cVar.fCB;
        this.tabId = cVar.tabId;
        this.fGI = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.fNg.fMG.setDrawerType(0);
        this.fNg.fMG.setBorderSurroundContent(true);
        this.fNg.fMG.setDrawBorder(true);
        this.fNg.fMG.startLoad(this.fCB.beY().cover, 10, false);
        this.fNg.fMI.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.fCB.beY().audience_count)));
        this.fNg.fMK.setData(this.fCB, false);
        this.fNg.fML.setText(this.fCB.getTitle());
        if (this.fCB.beE() != null) {
            String name_show = this.fCB.beE().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fNg.aOW.setText(name_show);
        }
        String str = this.fCB.beY().label_name;
        if (this.fMD && !StringUtils.isNull(str)) {
            this.fNg.fMH.setText(str);
            this.fNg.fMH.setVisibility(0);
        } else {
            this.fNg.fMH.setVisibility(8);
        }
        if (cVar.fCC) {
            this.fNg.fMM.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, at.numberUniformFormatExtra((long) (this.fCB.beY().distance / 1000.0d))));
            this.fNg.fMM.setVisibility(0);
        } else {
            this.fNg.fMM.setVisibility(8);
        }
        this.fNg.aOW.setOnClickListener(this.fME);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.fNg.fMJ, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.fNg.fMI, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fNg.aOW, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fNg.fML, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.fNg.fMM, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView aOW;
        public TbImageView fMG;
        public TextView fMH;
        public TextView fMI;
        public RelativeLayout fMJ;
        public ClickableHeaderImageView fMK;
        public TextView fML;
        public TextView fMM;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fMG = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fMH = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fMI = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fMJ = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fMK = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aOW = (TextView) view.findViewById(R.id.tvUserName);
            this.fML = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fMM = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.fMG.setDefaultErrorResource(0);
            this.fMG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fMG.setDrawerType(0);
            this.fMK.setIsRound(true);
            this.fMK.setDrawBorder(true);
            this.fMK.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.fMK.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.fMK.setIsGod(false);
            this.fMK.setIsBigV(false);
            this.fMK.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fMJ.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.fMJ.setLayoutParams(layoutParams);
        }
    }
}
