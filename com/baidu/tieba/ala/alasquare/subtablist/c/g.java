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
/* loaded from: classes2.dex */
public class g {
    private bj efE;
    private String ejF;
    private i emV;
    private boolean epx;
    private a eqa;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.efE != null && g.this.efE.aAq() != null && g.this.emV != null) {
                    g.this.emV.a(g.this.tabId, g.this.ejF, g.this.efE);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener epy = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.efE != null && g.this.efE.azX() != null && !StringUtils.isNull(g.this.efE.azX().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.efE.azX().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.efE.azX().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.eqa = new a(this.mRootView);
        this.epx = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.emV = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.efE == null || cVar.efE.aAq() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.efE = cVar.efE;
        this.tabId = cVar.tabId;
        this.ejF = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.eqa.epA.setDrawerType(0);
        this.eqa.epA.setBorderSurroundContent(true);
        this.eqa.epA.setDrawBorder(true);
        this.eqa.epA.startLoad(this.efE.aAq().cover, 10, false);
        this.eqa.epC.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.efE.aAq().audience_count)));
        this.eqa.epE.setData(this.efE, false);
        this.eqa.epF.setText(this.efE.getTitle());
        if (this.efE.azX() != null) {
            String name_show = this.efE.azX().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eqa.afG.setText(name_show);
        }
        String str = this.efE.aAq().label_name;
        if (this.epx && !StringUtils.isNull(str)) {
            this.eqa.epB.setText(str);
            this.eqa.epB.setVisibility(0);
        } else {
            this.eqa.epB.setVisibility(8);
        }
        if (cVar.efF) {
            this.eqa.epG.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.efE.aAq().distance / 1000.0d))));
            this.eqa.epG.setVisibility(0);
        } else {
            this.eqa.epG.setVisibility(8);
        }
        this.eqa.afG.setOnClickListener(this.epy);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eqa.epD, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eqa.epC, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eqa.afG, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eqa.epF, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eqa.epG, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView afG;
        public TbImageView epA;
        public TextView epB;
        public TextView epC;
        public RelativeLayout epD;
        public ClickableHeaderImageView epE;
        public TextView epF;
        public TextView epG;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.epA = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.epB = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.epC = (TextView) view.findViewById(R.id.tvLiveCount);
            this.epD = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.epE = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.afG = (TextView) view.findViewById(R.id.tvUserName);
            this.epF = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.epG = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.epA.setDefaultErrorResource(0);
            this.epA.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.epA.setDrawerType(0);
            this.epE.setIsRound(true);
            this.epE.setDrawBorder(true);
            this.epE.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.epE.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.epE.setIsGod(false);
            this.epE.setIsBigV(false);
            this.epE.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epD.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.epD.setLayoutParams(layoutParams);
        }
    }
}
