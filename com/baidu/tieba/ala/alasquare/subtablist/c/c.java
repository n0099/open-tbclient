package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.text.TextUtils;
import android.view.View;
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
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.c> {
    private bw fFN;
    private String fJU;
    private i fNt;
    private a fPQ;
    private boolean fPR;
    View.OnClickListener fPS;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fPR = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.fFN != null && c.this.fFN.bfS() != null && c.this.fNt != null) {
                        c.this.fNt.a(c.this.tabId, c.this.fJU, c.this.fFN);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.fPS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fFN != null && c.this.fFN.bfy() != null && !StringUtils.isNull(c.this.fFN.bfy().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.fFN.bfy().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.fFN.bfy().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.fPQ = new a(getView());
        this.fPR = z;
    }

    public void c(i iVar) {
        this.fNt = iVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.fPQ.fPX, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.fPQ.fPW, R.color.cp_cont_a);
            ap.setViewTextColor(this.fPQ.aQY, R.color.cp_cont_a);
            ap.setViewTextColor(this.fPQ.fPZ, R.color.cp_cont_b);
            ap.setViewTextColor(this.fPQ.fQa, R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.fFN == null || cVar.fFN.bfS() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fFN = cVar.fFN;
        this.tabId = cVar.tabId;
        this.fJU = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.fPQ.fPU.startLoad(this.fFN.bfS().cover, 10, false);
        this.fPQ.fPW.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.fFN.bfS().audience_count)));
        this.fPQ.fPY.setData(this.fFN, false);
        this.fPQ.fPZ.setText(this.fFN.getTitle());
        if (this.fFN.bfy() != null) {
            String name_show = this.fFN.bfy().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fPQ.aQY.setText(name_show);
        }
        String str = this.fFN.bfS().label_name;
        if (this.fPR && !StringUtils.isNull(str)) {
            this.fPQ.fPV.setText(str);
            this.fPQ.fPV.setVisibility(0);
        } else {
            this.fPQ.fPV.setVisibility(8);
        }
        if (cVar.fFO) {
            this.fPQ.fQa.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, at.numberUniformFormatExtra((long) (this.fFN.bfS().distance / 1000.0d))));
            this.fPQ.fQa.setVisibility(0);
        } else {
            this.fPQ.fQa.setVisibility(8);
        }
        this.fPQ.aQY.setOnClickListener(this.fPS);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView aQY;
        public TbImageView fPU;
        public TextView fPV;
        public TextView fPW;
        public RelativeLayout fPX;
        public ClickableHeaderImageView fPY;
        public TextView fPZ;
        public TextView fQa;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fPU = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fPV = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fPW = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fPX = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fPY = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aQY = (TextView) view.findViewById(R.id.tvUserName);
            this.fPZ = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fQa = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.fPU.setDefaultErrorResource(0);
            this.fPU.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fPU.setDrawerType(0);
            this.fPY.setIsRound(true);
            this.fPY.setDrawBorder(true);
            this.fPY.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.fPY.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.fPY.setIsGod(false);
            this.fPY.setIsBigV(false);
            this.fPY.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fPX.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fPX.setLayoutParams(layoutParams);
        }
    }
}
