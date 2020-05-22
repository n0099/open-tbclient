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
    private bk fay;
    private String feF;
    private i fic;
    private boolean fkC;
    private a flf;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.fay != null && g.this.fay.aQS() != null && g.this.fic != null) {
                    g.this.fic.a(g.this.tabId, g.this.feF, g.this.fay);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener fkD = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.fay != null && g.this.fay.aQx() != null && !StringUtils.isNull(g.this.fay.aQx().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.fay.aQx().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.fay.aQx().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.flf = new a(this.mRootView);
        this.fkC = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.fic = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.fay == null || cVar.fay.aQS() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fay = cVar.fay;
        this.tabId = cVar.tabId;
        this.feF = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.flf.fkF.setDrawerType(0);
        this.flf.fkF.setBorderSurroundContent(true);
        this.flf.fkF.setDrawBorder(true);
        this.flf.fkF.startLoad(this.fay.aQS().cover, 10, false);
        this.flf.fkH.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.fay.aQS().audience_count)));
        this.flf.fkJ.setData(this.fay, false);
        this.flf.fkK.setText(this.fay.getTitle());
        if (this.fay.aQx() != null) {
            String name_show = this.fay.aQx().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.flf.aFR.setText(name_show);
        }
        String str = this.fay.aQS().label_name;
        if (this.fkC && !StringUtils.isNull(str)) {
            this.flf.fkG.setText(str);
            this.flf.fkG.setVisibility(0);
        } else {
            this.flf.fkG.setVisibility(8);
        }
        if (cVar.faz) {
            this.flf.fkL.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.fay.aQS().distance / 1000.0d))));
            this.flf.fkL.setVisibility(0);
        } else {
            this.flf.fkL.setVisibility(8);
        }
        this.flf.aFR.setOnClickListener(this.fkD);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.flf.fkI, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.flf.fkH, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.flf.aFR, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.flf.fkK, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.flf.fkL, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView aFR;
        public TbImageView fkF;
        public TextView fkG;
        public TextView fkH;
        public RelativeLayout fkI;
        public ClickableHeaderImageView fkJ;
        public TextView fkK;
        public TextView fkL;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fkF = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fkG = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fkH = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fkI = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fkJ = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aFR = (TextView) view.findViewById(R.id.tvUserName);
            this.fkK = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fkL = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.fkF.setDefaultErrorResource(0);
            this.fkF.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fkF.setDrawerType(0);
            this.fkJ.setIsRound(true);
            this.fkJ.setDrawBorder(true);
            this.fkJ.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.fkJ.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.fkJ.setIsGod(false);
            this.fkJ.setIsBigV(false);
            this.fkJ.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkI.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.fkI.setLayoutParams(layoutParams);
        }
    }
}
