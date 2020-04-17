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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g {
    private bj eNM;
    private String eRS;
    private i eVp;
    private boolean eXN;
    private a eYq;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.eNM != null && g.this.eNM.aKX() != null && g.this.eVp != null) {
                    g.this.eVp.a(g.this.tabId, g.this.eRS, g.this.eNM);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener eXO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.eNM != null && g.this.eNM.aKE() != null && !StringUtils.isNull(g.this.eNM.aKE().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.eNM.aKE().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.eNM.aKE().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.eYq = new a(this.mRootView);
        this.eXN = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.eVp = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.eNM == null || cVar.eNM.aKX() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eNM = cVar.eNM;
        this.tabId = cVar.tabId;
        this.eRS = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.eYq.eXQ.setDrawerType(0);
        this.eYq.eXQ.setBorderSurroundContent(true);
        this.eYq.eXQ.setDrawBorder(true);
        this.eYq.eXQ.startLoad(this.eNM.aKX().cover, 10, false);
        this.eYq.eXS.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.eNM.aKX().audience_count)));
        this.eYq.eXU.setData(this.eNM, false);
        this.eYq.eXV.setText(this.eNM.getTitle());
        if (this.eNM.aKE() != null) {
            String name_show = this.eNM.aKE().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eYq.aAs.setText(name_show);
        }
        String str = this.eNM.aKX().label_name;
        if (this.eXN && !StringUtils.isNull(str)) {
            this.eYq.eXR.setText(str);
            this.eYq.eXR.setVisibility(0);
        } else {
            this.eYq.eXR.setVisibility(8);
        }
        if (cVar.eNN) {
            this.eYq.eXW.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.eNM.aKX().distance / 1000.0d))));
            this.eYq.eXW.setVisibility(0);
        } else {
            this.eYq.eXW.setVisibility(8);
        }
        this.eYq.aAs.setOnClickListener(this.eXO);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eYq.eXT, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eYq.eXS, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eYq.aAs, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eYq.eXV, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eYq.eXW, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView aAs;
        public TbImageView eXQ;
        public TextView eXR;
        public TextView eXS;
        public RelativeLayout eXT;
        public ClickableHeaderImageView eXU;
        public TextView eXV;
        public TextView eXW;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.eXQ = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.eXR = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.eXS = (TextView) view.findViewById(R.id.tvLiveCount);
            this.eXT = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.eXU = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aAs = (TextView) view.findViewById(R.id.tvUserName);
            this.eXV = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.eXW = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.eXQ.setDefaultErrorResource(0);
            this.eXQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.eXQ.setDrawerType(0);
            this.eXU.setIsRound(true);
            this.eXU.setDrawBorder(true);
            this.eXU.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.eXU.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.eXU.setIsGod(false);
            this.eXU.setIsBigV(false);
            this.eXU.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXT.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.eXT.setLayoutParams(layoutParams);
        }
    }
}
