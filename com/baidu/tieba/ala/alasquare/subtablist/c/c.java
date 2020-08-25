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
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.c> {
    private bw fCx;
    private String fGE;
    private i fKb;
    View.OnClickListener fMA;
    private a fMy;
    private boolean fMz;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fMz = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.fCx != null && c.this.fCx.beY() != null && c.this.fKb != null) {
                        c.this.fKb.a(c.this.tabId, c.this.fGE, c.this.fCx);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.fMA = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fCx != null && c.this.fCx.beE() != null && !StringUtils.isNull(c.this.fCx.beE().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.fCx.beE().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.fCx.beE().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.fMy = new a(getView());
        this.fMz = z;
    }

    public void c(i iVar) {
        this.fKb = iVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.fMy.fMF, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.fMy.fME, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fMy.aOU, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fMy.fMH, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.fMy.fMI, (int) R.color.cp_cont_d);
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
        if (cVar == null || cVar.fCx == null || cVar.fCx.beY() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fCx = cVar.fCx;
        this.tabId = cVar.tabId;
        this.fGE = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.fMy.fMC.startLoad(this.fCx.beY().cover, 10, false);
        this.fMy.fME.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.fCx.beY().audience_count)));
        this.fMy.fMG.setData(this.fCx, false);
        this.fMy.fMH.setText(this.fCx.getTitle());
        if (this.fCx.beE() != null) {
            String name_show = this.fCx.beE().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fMy.aOU.setText(name_show);
        }
        String str = this.fCx.beY().label_name;
        if (this.fMz && !StringUtils.isNull(str)) {
            this.fMy.fMD.setText(str);
            this.fMy.fMD.setVisibility(0);
        } else {
            this.fMy.fMD.setVisibility(8);
        }
        if (cVar.fCy) {
            this.fMy.fMI.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, at.numberUniformFormatExtra((long) (this.fCx.beY().distance / 1000.0d))));
            this.fMy.fMI.setVisibility(0);
        } else {
            this.fMy.fMI.setVisibility(8);
        }
        this.fMy.aOU.setOnClickListener(this.fMA);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView aOU;
        public TbImageView fMC;
        public TextView fMD;
        public TextView fME;
        public RelativeLayout fMF;
        public ClickableHeaderImageView fMG;
        public TextView fMH;
        public TextView fMI;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fMC = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fMD = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fME = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fMF = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fMG = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aOU = (TextView) view.findViewById(R.id.tvUserName);
            this.fMH = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fMI = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.fMC.setDefaultErrorResource(0);
            this.fMC.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fMC.setDrawerType(0);
            this.fMG.setIsRound(true);
            this.fMG.setDrawBorder(true);
            this.fMG.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.fMG.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.fMG.setIsGod(false);
            this.fMG.setIsBigV(false);
            this.fMG.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fMF.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fMF.setLayoutParams(layoutParams);
        }
    }
}
