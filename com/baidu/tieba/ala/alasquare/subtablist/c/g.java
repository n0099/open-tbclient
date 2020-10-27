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
    private bw gbZ;
    private String ggp;
    private i gjP;
    private a gmQ;
    private boolean gmn;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.gbZ != null && g.this.gbZ.bku() != null && g.this.gjP != null) {
                    g.this.gjP.a(g.this.tabId, g.this.ggp, g.this.gbZ);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener gmo = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.gbZ != null && g.this.gbZ.bka() != null && !StringUtils.isNull(g.this.gbZ.bka().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.gbZ.bka().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.gbZ.bka().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.gmQ = new a(this.mRootView);
        this.gmn = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.gjP = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.gbZ == null || cVar.gbZ.bku() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gbZ = cVar.gbZ;
        this.tabId = cVar.tabId;
        this.ggp = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.gmQ.gmq.setDrawerType(0);
        this.gmQ.gmq.setBorderSurroundContent(true);
        this.gmQ.gmq.setDrawBorder(true);
        this.gmQ.gmq.startLoad(this.gbZ.bku().cover, 10, false);
        this.gmQ.gms.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.gbZ.bku().audience_count)));
        this.gmQ.gmu.setData(this.gbZ, false);
        this.gmQ.gmv.setText(this.gbZ.getTitle());
        if (this.gbZ.bka() != null) {
            String name_show = this.gbZ.bka().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gmQ.aVE.setText(name_show);
        }
        String str = this.gbZ.bku().label_name;
        if (this.gmn && !StringUtils.isNull(str)) {
            this.gmQ.gmr.setText(str);
            this.gmQ.gmr.setVisibility(0);
        } else {
            this.gmQ.gmr.setVisibility(8);
        }
        if (cVar.gca) {
            this.gmQ.gmw.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, at.numberUniformFormatExtra((long) (this.gbZ.bku().distance / 1000.0d))));
            this.gmQ.gmw.setVisibility(0);
        } else {
            this.gmQ.gmw.setVisibility(8);
        }
        this.gmQ.aVE.setOnClickListener(this.gmo);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gmQ.gmt, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gmQ.gms, R.color.cp_cont_a);
            ap.setViewTextColor(this.gmQ.aVE, R.color.cp_cont_a);
            ap.setViewTextColor(this.gmQ.gmv, R.color.cp_cont_b);
            ap.setViewTextColor(this.gmQ.gmw, R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView aVE;
        public TbImageView gmq;
        public TextView gmr;
        public TextView gms;
        public RelativeLayout gmt;
        public ClickableHeaderImageView gmu;
        public TextView gmv;
        public TextView gmw;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gmq = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gmr = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gms = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gmt = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gmu = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aVE = (TextView) view.findViewById(R.id.tvUserName);
            this.gmv = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gmw = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.gmq.setDefaultErrorResource(0);
            this.gmq.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gmq.setDrawerType(0);
            this.gmu.setIsRound(true);
            this.gmu.setDrawBorder(true);
            this.gmu.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gmu.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gmu.setIsGod(false);
            this.gmu.setIsBigV(false);
            this.gmu.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gmt.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.gmt.setLayoutParams(layoutParams);
        }
    }
}
