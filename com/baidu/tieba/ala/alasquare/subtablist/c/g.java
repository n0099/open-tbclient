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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g {
    private bk faJ;
    private String feQ;
    private i fio;
    private boolean fkN;
    private a flq;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.faJ != null && g.this.faJ.aQS() != null && g.this.fio != null) {
                    g.this.fio.a(g.this.tabId, g.this.feQ, g.this.faJ);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener fkO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.faJ != null && g.this.faJ.aQx() != null && !StringUtils.isNull(g.this.faJ.aQx().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.faJ.aQx().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.faJ.aQx().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.flq = new a(this.mRootView);
        this.fkN = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.fio = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.faJ == null || cVar.faJ.aQS() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.faJ = cVar.faJ;
        this.tabId = cVar.tabId;
        this.feQ = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.flq.fkQ.setDrawerType(0);
        this.flq.fkQ.setBorderSurroundContent(true);
        this.flq.fkQ.setDrawBorder(true);
        this.flq.fkQ.startLoad(this.faJ.aQS().cover, 10, false);
        this.flq.fkS.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.faJ.aQS().audience_count)));
        this.flq.fkU.setData(this.faJ, false);
        this.flq.fkV.setText(this.faJ.getTitle());
        if (this.faJ.aQx() != null) {
            String name_show = this.faJ.aQx().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.flq.aFR.setText(name_show);
        }
        String str = this.faJ.aQS().label_name;
        if (this.fkN && !StringUtils.isNull(str)) {
            this.flq.fkR.setText(str);
            this.flq.fkR.setVisibility(0);
        } else {
            this.flq.fkR.setVisibility(8);
        }
        if (cVar.faK) {
            this.flq.fkW.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.faJ.aQS().distance / 1000.0d))));
            this.flq.fkW.setVisibility(0);
        } else {
            this.flq.fkW.setVisibility(8);
        }
        this.flq.aFR.setOnClickListener(this.fkO);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.flq.fkT, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.flq.fkS, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.flq.aFR, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.flq.fkV, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.flq.fkW, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView aFR;
        public TbImageView fkQ;
        public TextView fkR;
        public TextView fkS;
        public RelativeLayout fkT;
        public ClickableHeaderImageView fkU;
        public TextView fkV;
        public TextView fkW;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fkQ = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fkR = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fkS = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fkT = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fkU = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aFR = (TextView) view.findViewById(R.id.tvUserName);
            this.fkV = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fkW = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.fkQ.setDefaultErrorResource(0);
            this.fkQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fkQ.setDrawerType(0);
            this.fkU.setIsRound(true);
            this.fkU.setDrawBorder(true);
            this.fkU.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.fkU.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.fkU.setIsGod(false);
            this.fkU.setIsBigV(false);
            this.fkU.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkT.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.fkT.setLayoutParams(layoutParams);
        }
    }
}
