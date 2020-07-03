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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g {
    private bu flT;
    private String fqb;
    private i ftC;
    private a fwD;
    private boolean fwa;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.flT != null && g.this.flT.aSJ() != null && g.this.ftC != null) {
                    g.this.ftC.a(g.this.tabId, g.this.fqb, g.this.flT);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener fwb = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.flT != null && g.this.flT.aSp() != null && !StringUtils.isNull(g.this.flT.aSp().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.flT.aSp().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.flT.aSp().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.fwD = new a(this.mRootView);
        this.fwa = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.ftC = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.flT == null || cVar.flT.aSJ() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.flT = cVar.flT;
        this.tabId = cVar.tabId;
        this.fqb = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.fwD.fwd.setDrawerType(0);
        this.fwD.fwd.setBorderSurroundContent(true);
        this.fwD.fwd.setDrawBorder(true);
        this.fwD.fwd.startLoad(this.flT.aSJ().cover, 10, false);
        this.fwD.fwf.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, ar.numberUniformFormatExtra(this.flT.aSJ().audience_count)));
        this.fwD.fwh.setData(this.flT, false);
        this.fwD.fwi.setText(this.flT.getTitle());
        if (this.flT.aSp() != null) {
            String name_show = this.flT.aSp().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fwD.aIn.setText(name_show);
        }
        String str = this.flT.aSJ().label_name;
        if (this.fwa && !StringUtils.isNull(str)) {
            this.fwD.fwe.setText(str);
            this.fwD.fwe.setVisibility(0);
        } else {
            this.fwD.fwe.setVisibility(8);
        }
        if (cVar.flU) {
            this.fwD.fwj.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, ar.numberUniformFormatExtra((long) (this.flT.aSJ().distance / 1000.0d))));
            this.fwD.fwj.setVisibility(0);
        } else {
            this.fwD.fwj.setVisibility(8);
        }
        this.fwD.aIn.setOnClickListener(this.fwb);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.fwD.fwg, R.drawable.addresslist_item_bg);
            an.setViewTextColor(this.fwD.fwf, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.fwD.aIn, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.fwD.fwi, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.fwD.fwj, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView aIn;
        public TbImageView fwd;
        public TextView fwe;
        public TextView fwf;
        public RelativeLayout fwg;
        public ClickableHeaderImageView fwh;
        public TextView fwi;
        public TextView fwj;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fwd = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fwe = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fwf = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fwg = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fwh = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aIn = (TextView) view.findViewById(R.id.tvUserName);
            this.fwi = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fwj = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.fwd.setDefaultErrorResource(0);
            this.fwd.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fwd.setDrawerType(0);
            this.fwh.setIsRound(true);
            this.fwh.setDrawBorder(true);
            this.fwh.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.fwh.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.fwh.setIsGod(false);
            this.fwh.setIsBigV(false);
            this.fwh.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fwg.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.fwg.setLayoutParams(layoutParams);
        }
    }
}
