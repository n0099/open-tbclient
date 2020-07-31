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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.c> {
    private a fBg;
    private boolean fBh;
    View.OnClickListener fBi;
    private bv frb;
    private String fvl;
    private i fyJ;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fBh = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.frb != null && c.this.frb.aWF() != null && c.this.fyJ != null) {
                        c.this.fyJ.a(c.this.tabId, c.this.fvl, c.this.frb);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.fBi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.frb != null && c.this.frb.aWl() != null && !StringUtils.isNull(c.this.frb.aWl().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.frb.aWl().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.frb.aWl().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.fBg = new a(getView());
        this.fBh = z;
    }

    public void c(i iVar) {
        this.fyJ = iVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.fBg.fBn, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.fBg.fBm, R.color.cp_cont_a);
            ao.setViewTextColor(this.fBg.aJJ, R.color.cp_cont_a);
            ao.setViewTextColor(this.fBg.fBp, R.color.cp_cont_b);
            ao.setViewTextColor(this.fBg.fBq, R.color.cp_cont_d);
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
        if (cVar == null || cVar.frb == null || cVar.frb.aWF() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.frb = cVar.frb;
        this.tabId = cVar.tabId;
        this.fvl = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.fBg.fBk.startLoad(this.frb.aWF().cover, 10, false);
        this.fBg.fBm.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, as.numberUniformFormatExtra(this.frb.aWF().audience_count)));
        this.fBg.fBo.setData(this.frb, false);
        this.fBg.fBp.setText(this.frb.getTitle());
        if (this.frb.aWl() != null) {
            String name_show = this.frb.aWl().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fBg.aJJ.setText(name_show);
        }
        String str = this.frb.aWF().label_name;
        if (this.fBh && !StringUtils.isNull(str)) {
            this.fBg.fBl.setText(str);
            this.fBg.fBl.setVisibility(0);
        } else {
            this.fBg.fBl.setVisibility(8);
        }
        if (cVar.frd) {
            this.fBg.fBq.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, as.numberUniformFormatExtra((long) (this.frb.aWF().distance / 1000.0d))));
            this.fBg.fBq.setVisibility(0);
        } else {
            this.fBg.fBq.setVisibility(8);
        }
        this.fBg.aJJ.setOnClickListener(this.fBi);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView aJJ;
        public TbImageView fBk;
        public TextView fBl;
        public TextView fBm;
        public RelativeLayout fBn;
        public ClickableHeaderImageView fBo;
        public TextView fBp;
        public TextView fBq;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fBk = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fBl = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fBm = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fBn = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fBo = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aJJ = (TextView) view.findViewById(R.id.tvUserName);
            this.fBp = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fBq = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.fBk.setDefaultErrorResource(0);
            this.fBk.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fBk.setDrawerType(0);
            this.fBo.setIsRound(true);
            this.fBo.setDrawBorder(true);
            this.fBo.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.fBo.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.fBo.setIsGod(false);
            this.fBo.setIsBigV(false);
            this.fBo.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fBn.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fBn.setLayoutParams(layoutParams);
        }
    }
}
