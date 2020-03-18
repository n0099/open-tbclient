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
    private bj ekm;
    private String eov;
    private i erT;
    private a euV;
    private boolean eus;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.ekm != null && g.this.ekm.aCK() != null && g.this.erT != null) {
                    g.this.erT.a(g.this.tabId, g.this.eov, g.this.ekm);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener eut = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.ekm != null && g.this.ekm.aCr() != null && !StringUtils.isNull(g.this.ekm.aCr().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.ekm.aCr().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.ekm.aCr().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.euV = new a(this.mRootView);
        this.eus = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.erT = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.ekm == null || cVar.ekm.aCK() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ekm = cVar.ekm;
        this.tabId = cVar.tabId;
        this.eov = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.euV.euv.setDrawerType(0);
        this.euV.euv.setBorderSurroundContent(true);
        this.euV.euv.setDrawBorder(true);
        this.euV.euv.startLoad(this.ekm.aCK().cover, 10, false);
        this.euV.eux.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.ekm.aCK().audience_count)));
        this.euV.euz.setData(this.ekm, false);
        this.euV.euA.setText(this.ekm.getTitle());
        if (this.ekm.aCr() != null) {
            String name_show = this.ekm.aCr().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.euV.ahY.setText(name_show);
        }
        String str = this.ekm.aCK().label_name;
        if (this.eus && !StringUtils.isNull(str)) {
            this.euV.euw.setText(str);
            this.euV.euw.setVisibility(0);
        } else {
            this.euV.euw.setVisibility(8);
        }
        if (cVar.ekn) {
            this.euV.euB.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.ekm.aCK().distance / 1000.0d))));
            this.euV.euB.setVisibility(0);
        } else {
            this.euV.euB.setVisibility(8);
        }
        this.euV.ahY.setOnClickListener(this.eut);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.euV.euy, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.euV.eux, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.euV.ahY, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.euV.euA, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.euV.euB, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView ahY;
        public TextView euA;
        public TextView euB;
        public TbImageView euv;
        public TextView euw;
        public TextView eux;
        public RelativeLayout euy;
        public ClickableHeaderImageView euz;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.euv = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.euw = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.eux = (TextView) view.findViewById(R.id.tvLiveCount);
            this.euy = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.euz = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.ahY = (TextView) view.findViewById(R.id.tvUserName);
            this.euA = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.euB = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.euv.setDefaultErrorResource(0);
            this.euv.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.euv.setDrawerType(0);
            this.euz.setIsRound(true);
            this.euz.setDrawBorder(true);
            this.euz.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.euz.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.euz.setIsGod(false);
            this.euz.setIsBigV(false);
            this.euz.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.euy.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.euy.setLayoutParams(layoutParams);
        }
    }
}
