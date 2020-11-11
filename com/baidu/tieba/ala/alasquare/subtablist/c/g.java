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
    private bw ghO;
    private String gmd;
    private i gpC;
    private a gsD;
    private boolean gsa;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.ghO != null && g.this.ghO.bmU() != null && g.this.gpC != null) {
                    g.this.gpC.a(g.this.tabId, g.this.gmd, g.this.ghO);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener gsb = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.ghO != null && g.this.ghO.bmA() != null && !StringUtils.isNull(g.this.ghO.bmA().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.ghO.bmA().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.ghO.bmA().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.gsD = new a(this.mRootView);
        this.gsa = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.gpC = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.ghO == null || cVar.ghO.bmU() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ghO = cVar.ghO;
        this.tabId = cVar.tabId;
        this.gmd = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.gsD.gsd.setDrawerType(0);
        this.gsD.gsd.setBorderSurroundContent(true);
        this.gsD.gsd.setDrawBorder(true);
        this.gsD.gsd.startLoad(this.ghO.bmU().cover, 10, false);
        this.gsD.gsf.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.ghO.bmU().audience_count)));
        this.gsD.gsh.setData(this.ghO, false);
        this.gsD.gsi.setText(this.ghO.getTitle());
        if (this.ghO.bmA() != null) {
            String name_show = this.ghO.bmA().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gsD.aWW.setText(name_show);
        }
        String str = this.ghO.bmU().label_name;
        if (this.gsa && !StringUtils.isNull(str)) {
            this.gsD.gse.setText(str);
            this.gsD.gse.setVisibility(0);
        } else {
            this.gsD.gse.setVisibility(8);
        }
        if (cVar.ghP) {
            this.gsD.gsj.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, at.numberUniformFormatExtra((long) (this.ghO.bmU().distance / 1000.0d))));
            this.gsD.gsj.setVisibility(0);
        } else {
            this.gsD.gsj.setVisibility(8);
        }
        this.gsD.aWW.setOnClickListener(this.gsb);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gsD.gsg, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gsD.gsf, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.gsD.aWW, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.gsD.gsi, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.gsD.gsj, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView aWW;
        public TbImageView gsd;
        public TextView gse;
        public TextView gsf;
        public RelativeLayout gsg;
        public ClickableHeaderImageView gsh;
        public TextView gsi;
        public TextView gsj;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gsd = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gse = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gsf = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gsg = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gsh = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aWW = (TextView) view.findViewById(R.id.tvUserName);
            this.gsi = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gsj = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.gsd.setDefaultErrorResource(0);
            this.gsd.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gsd.setDrawerType(0);
            this.gsh.setIsRound(true);
            this.gsh.setDrawBorder(true);
            this.gsh.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gsh.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gsh.setIsGod(false);
            this.gsh.setIsBigV(false);
            this.gsh.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gsg.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.gsg.setLayoutParams(layoutParams);
        }
    }
}
