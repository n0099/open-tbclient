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
/* loaded from: classes10.dex */
public class e {
    private String gCX;
    private g gGB;
    private boolean gIZ;
    private a gJC;
    private cb gyA;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (e.this.gyA != null && e.this.gyA.boj() != null && e.this.gGB != null) {
                    e.this.gGB.a(e.this.tabId, e.this.gCX, e.this.gyA);
                    return;
                }
                return;
            }
            l.showLongToast(e.this.mTbPageContext.getPageActivity(), e.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener gJa = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.gyA != null && e.this.gyA.bnQ() != null && !StringUtils.isNull(e.this.gyA.bnQ().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(e.this.gyA.bnQ().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(e.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), e.this.gyA.bnQ().isBigV())));
            }
        }
    };

    public e(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.gJC = new a(this.mRootView);
        this.gIZ = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(g gVar) {
        this.gGB = gVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.e eVar) {
        if (eVar == null || eVar.gyA == null || eVar.gyA.boj() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gyA = eVar.gyA;
        this.tabId = eVar.tabId;
        this.gCX = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        this.gJC.gJc.setDrawerType(0);
        this.gJC.gJc.setBorderSurroundContent(true);
        this.gJC.gJc.setDrawBorder(true);
        this.gJC.gJc.startLoad(this.gyA.boj().cover, 10, false);
        this.gJC.gJe.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.gyA.boj().audience_count)));
        this.gJC.gJg.setData(this.gyA, false);
        this.gJC.gJh.setText(this.gyA.getTitle());
        if (this.gyA.bnQ() != null) {
            String name_show = this.gyA.bnQ().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gJC.aYx.setText(name_show);
        }
        String str = this.gyA.boj().label_name;
        if (this.gIZ && !StringUtils.isNull(str)) {
            this.gJC.gJd.setText(str);
            this.gJC.gJd.setVisibility(0);
        } else {
            this.gJC.gJd.setVisibility(8);
        }
        if (eVar.gyI) {
            this.gJC.gJi.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, au.numberUniformFormatExtra((long) (this.gyA.boj().distance / 1000.0d))));
            this.gJC.gJi.setVisibility(0);
        } else {
            this.gJC.gJi.setVisibility(8);
        }
        this.gJC.aYx.setOnClickListener(this.gJa);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gJC.gJf, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gJC.gJe, R.color.CAM_X0101);
            ap.setViewTextColor(this.gJC.aYx, R.color.CAM_X0101);
            ap.setViewTextColor(this.gJC.gJh, R.color.CAM_X0105);
            ap.setViewTextColor(this.gJC.gJi, R.color.CAM_X0109);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        public TextView aYx;
        public TbImageView gJc;
        public TextView gJd;
        public TextView gJe;
        public RelativeLayout gJf;
        public ClickableHeaderImageView gJg;
        public TextView gJh;
        public TextView gJi;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gJc = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gJd = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gJe = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gJf = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gJg = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aYx = (TextView) view.findViewById(R.id.tvUserName);
            this.gJh = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gJi = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(e.this.mOnClickListener);
            this.gJc.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gJc.setDrawerType(0);
            this.gJg.setIsRound(true);
            this.gJg.setDrawBorder(true);
            this.gJg.setBorderColor(e.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gJg.setBorderWidth(e.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gJg.setIsGod(false);
            this.gJg.setIsBigV(false);
            this.gJg.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJf.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.gJf.setLayoutParams(layoutParams);
        }
    }
}
