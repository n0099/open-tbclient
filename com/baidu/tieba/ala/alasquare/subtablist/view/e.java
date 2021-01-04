package com.baidu.tieba.ala.alasquare.subtablist.view;

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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class e {
    private bz gAx;
    private String gEU;
    private g gIx;
    private boolean gKV;
    private a gLy;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (e.this.gAx != null && e.this.gAx.brJ() != null && e.this.gIx != null) {
                    e.this.gIx.a(e.this.tabId, e.this.gEU, e.this.gAx);
                    return;
                }
                return;
            }
            l.showLongToast(e.this.mTbPageContext.getPageActivity(), e.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener gKW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.gAx != null && e.this.gAx.brq() != null && !StringUtils.isNull(e.this.gAx.brq().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(e.this.gAx.brq().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(e.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), e.this.gAx.brq().isBigV())));
            }
        }
    };

    public e(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.gLy = new a(this.mRootView);
        this.gKV = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(g gVar) {
        this.gIx = gVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.e eVar) {
        if (eVar == null || eVar.gAx == null || eVar.gAx.brJ() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gAx = eVar.gAx;
        this.tabId = eVar.tabId;
        this.gEU = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        this.gLy.gKY.setDrawerType(0);
        this.gLy.gKY.setBorderSurroundContent(true);
        this.gLy.gKY.setDrawBorder(true);
        this.gLy.gKY.startLoad(this.gAx.brJ().cover, 10, false);
        this.gLy.gLa.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.gAx.brJ().audience_count)));
        this.gLy.gLc.setData(this.gAx, false);
        this.gLy.gLd.setText(this.gAx.getTitle());
        if (this.gAx.brq() != null) {
            String name_show = this.gAx.brq().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gLy.bac.setText(name_show);
        }
        String str = this.gAx.brJ().label_name;
        if (this.gKV && !StringUtils.isNull(str)) {
            this.gLy.gKZ.setText(str);
            this.gLy.gKZ.setVisibility(0);
        } else {
            this.gLy.gKZ.setVisibility(8);
        }
        if (eVar.gAF) {
            this.gLy.gLe.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, at.numberUniformFormatExtra((long) (this.gAx.brJ().distance / 1000.0d))));
            this.gLy.gLe.setVisibility(0);
        } else {
            this.gLy.gLe.setVisibility(8);
        }
        this.gLy.bac.setOnClickListener(this.gKW);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gLy.gLb, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gLy.gLa, R.color.CAM_X0101);
            ao.setViewTextColor(this.gLy.bac, R.color.CAM_X0101);
            ao.setViewTextColor(this.gLy.gLd, R.color.CAM_X0105);
            ao.setViewTextColor(this.gLy.gLe, R.color.CAM_X0109);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        public TextView bac;
        public TbImageView gKY;
        public TextView gKZ;
        public TextView gLa;
        public RelativeLayout gLb;
        public ClickableHeaderImageView gLc;
        public TextView gLd;
        public TextView gLe;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gKY = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gKZ = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gLa = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gLb = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gLc = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.bac = (TextView) view.findViewById(R.id.tvUserName);
            this.gLd = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gLe = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(e.this.mOnClickListener);
            this.gKY.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gKY.setDrawerType(0);
            this.gLc.setIsRound(true);
            this.gLc.setDrawBorder(true);
            this.gLc.setBorderColor(e.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gLc.setBorderWidth(e.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gLc.setIsGod(false);
            this.gLc.setIsBigV(false);
            this.gLc.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gLb.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.gLb.setLayoutParams(layoutParams);
        }
    }
}
