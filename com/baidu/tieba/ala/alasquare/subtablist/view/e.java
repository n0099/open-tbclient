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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e {
    private cb gAx;
    private String gEU;
    private g gIy;
    private boolean gKW;
    private a gLz;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (e.this.gAx != null && e.this.gAx.bol() != null && e.this.gIy != null) {
                    e.this.gIy.a(e.this.tabId, e.this.gEU, e.this.gAx);
                    return;
                }
                return;
            }
            l.showLongToast(e.this.mTbPageContext.getPageActivity(), e.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener gKX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.gAx != null && e.this.gAx.bnS() != null && !StringUtils.isNull(e.this.gAx.bnS().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(e.this.gAx.bnS().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(e.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), e.this.gAx.bnS().isBigV())));
            }
        }
    };

    public e(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.gLz = new a(this.mRootView);
        this.gKW = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(g gVar) {
        this.gIy = gVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.e eVar) {
        if (eVar == null || eVar.gAx == null || eVar.gAx.bol() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gAx = eVar.gAx;
        this.tabId = eVar.tabId;
        this.gEU = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        this.gLz.gKZ.setDrawerType(0);
        this.gLz.gKZ.setBorderSurroundContent(true);
        this.gLz.gKZ.setDrawBorder(true);
        this.gLz.gKZ.startLoad(this.gAx.bol().cover, 10, false);
        this.gLz.gLb.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.gAx.bol().audience_count)));
        this.gLz.gLd.setData(this.gAx, false);
        this.gLz.gLe.setText(this.gAx.getTitle());
        if (this.gAx.bnS() != null) {
            String name_show = this.gAx.bnS().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gLz.aZX.setText(name_show);
        }
        String str = this.gAx.bol().label_name;
        if (this.gKW && !StringUtils.isNull(str)) {
            this.gLz.gLa.setText(str);
            this.gLz.gLa.setVisibility(0);
        } else {
            this.gLz.gLa.setVisibility(8);
        }
        if (eVar.gAF) {
            this.gLz.gLf.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, au.numberUniformFormatExtra((long) (this.gAx.bol().distance / 1000.0d))));
            this.gLz.gLf.setVisibility(0);
        } else {
            this.gLz.gLf.setVisibility(8);
        }
        this.gLz.aZX.setOnClickListener(this.gKX);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gLz.gLc, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gLz.gLb, R.color.CAM_X0101);
            ap.setViewTextColor(this.gLz.aZX, R.color.CAM_X0101);
            ap.setViewTextColor(this.gLz.gLe, R.color.CAM_X0105);
            ap.setViewTextColor(this.gLz.gLf, R.color.CAM_X0109);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public TextView aZX;
        public TbImageView gKZ;
        public TextView gLa;
        public TextView gLb;
        public RelativeLayout gLc;
        public ClickableHeaderImageView gLd;
        public TextView gLe;
        public TextView gLf;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gKZ = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gLa = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gLb = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gLc = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gLd = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aZX = (TextView) view.findViewById(R.id.tvUserName);
            this.gLe = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gLf = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(e.this.mOnClickListener);
            this.gKZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gKZ.setDrawerType(0);
            this.gLd.setIsRound(true);
            this.gLd.setDrawBorder(true);
            this.gLd.setBorderColor(e.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gLd.setBorderWidth(e.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gLd.setIsGod(false);
            this.gLd.setIsBigV(false);
            this.gLd.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gLc.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.gLc.setLayoutParams(layoutParams);
        }
    }
}
